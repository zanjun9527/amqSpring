package com.mq.source.servive;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("consumer")
public class ConsumerService {


    @Autowired
    private JmsTemplate jmsTemplate;
     
    /**
     * 接收消息
     */
    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("从队列" + destination.toString() + "收到了消息：\t"
                    + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        
        return tm;
        
    }

}
