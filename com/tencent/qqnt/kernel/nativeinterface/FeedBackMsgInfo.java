package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FeedBackMsgInfo {
    public long clientSeq;
    public long msgId;
    public long msgRandom;
    public long msgSeq;

    public FeedBackMsgInfo() {
    }

    public long getClientSeq() {
        return this.clientSeq;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgRandom() {
        return this.msgRandom;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "FeedBackMsgInfo{msgId=" + this.msgId + ",msgRandom=" + this.msgRandom + ",msgSeq=" + this.msgSeq + ",clientSeq=" + this.clientSeq + ",}";
    }

    public FeedBackMsgInfo(long j3, long j16, long j17, long j18) {
        this.msgId = j3;
        this.msgRandom = j16;
        this.msgSeq = j17;
        this.clientSeq = j18;
    }
}
