package com.tencent.imsdk.message;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageListGetOption implements Serializable {
    private int count;
    private boolean getCloudMessage;
    private long getTimeBegin;
    private long getTimePeriod;
    private MessageKey messageKey;
    private boolean toOlderMessage;

    public int getCount() {
        return this.count;
    }

    public long getGetTimeBegin() {
        return this.getTimeBegin;
    }

    public long getGetTimePeriod() {
        return this.getTimePeriod;
    }

    public MessageKey getMessageKey() {
        return this.messageKey;
    }

    public boolean isGetCloudMessage() {
        return this.getCloudMessage;
    }

    public boolean isToOlderMessage() {
        return this.toOlderMessage;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setGetCloudMessage(boolean z16) {
        this.getCloudMessage = z16;
    }

    public void setGetTimeBegin(long j3) {
        this.getTimeBegin = j3;
    }

    public void setGetTimePeriod(long j3) {
        this.getTimePeriod = j3;
    }

    public void setMessageKey(MessageKey messageKey) {
        this.messageKey = messageKey;
    }

    public void setToOlderMessage(boolean z16) {
        this.toOlderMessage = z16;
    }
}
