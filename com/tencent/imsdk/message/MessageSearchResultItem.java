package com.tencent.imsdk.message;

import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageSearchResultItem implements Serializable {
    private String conversationID;
    private int messageCount;
    private List<Message> messageList;
    private int messageType;

    public String getConversationID() {
        return this.conversationID;
    }

    public int getMessageCount() {
        return this.messageCount;
    }

    public List<Message> getMessageList() {
        return this.messageList;
    }

    public int getMessageType() {
        return this.messageType;
    }
}
