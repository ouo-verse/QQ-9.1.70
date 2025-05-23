package com.tencent.imsdk.message;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class MessageListener {
    public void onReceiveMessageModified(List<Message> list) {
    }

    public void onReceiveMessageReceipt(List<MessageReceipt> list) {
    }

    public void onReceiveMessageRevoked(List<MessageKey> list) {
    }

    public void onReceiveNewMessage(List<Message> list) {
    }
}
