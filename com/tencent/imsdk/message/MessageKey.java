package com.tencent.imsdk.message;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageKey implements Serializable {
    private long clientTime;
    private String groupID;
    private boolean isMessageSender;
    private String messageID;
    private int messageType;
    private long random;
    private String receiverUserID;
    private String senderUserID;
    private long seq;
    private long serverTime;

    public long getClientTime() {
        return this.clientTime;
    }

    public String getGroupID() {
        return this.groupID;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public long getRandom() {
        return this.random;
    }

    public String getReceiverUserID() {
        return this.receiverUserID;
    }

    public String getSenderUserID() {
        return this.senderUserID;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public boolean isMessageSender() {
        return this.isMessageSender;
    }

    public void setClientTime(long j3) {
        this.clientTime = j3;
    }

    public void setGroupID(String str) {
        this.groupID = str;
    }

    public void setIsMessageSender(boolean z16) {
        this.isMessageSender = z16;
    }

    public void setMessageID(String str) {
        this.messageID = str;
    }

    public void setMessageType(int i3) {
        this.messageType = i3;
    }

    public void setRandom(long j3) {
        this.random = j3;
    }

    public void setReceiverUserID(String str) {
        this.receiverUserID = str;
    }

    public void setSenderUserID(String str) {
        this.senderUserID = str;
    }

    public void setSeq(long j3) {
        this.seq = j3;
    }

    public void setServerTime(long j3) {
        this.serverTime = j3;
    }

    public String toString() {
        return "MessageKey--->messageID:" + this.messageID + ", messageType:" + this.messageType + ", isMessageSender:" + this.isMessageSender + ", senderUserID:" + this.senderUserID + ", receiverUserID:" + this.receiverUserID + ", groupID:" + this.groupID + ", clientTime:" + this.clientTime + ", serverTime:" + this.serverTime + ", seq:" + this.seq + ", random:" + this.random;
    }
}
