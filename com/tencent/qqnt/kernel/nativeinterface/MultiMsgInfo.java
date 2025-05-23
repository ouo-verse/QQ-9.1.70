package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MultiMsgInfo {
    public long msgId;
    public String senderShowName;

    public MultiMsgInfo() {
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getSenderShowName() {
        return this.senderShowName;
    }

    public String toString() {
        return "MultiMsgInfo{msgId=" + this.msgId + ",senderShowName=" + this.senderShowName + ",}";
    }

    public MultiMsgInfo(long j3, String str) {
        this.msgId = j3;
        this.senderShowName = str;
    }
}
