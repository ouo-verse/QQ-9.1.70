package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgIdInfo {
    public long msgId;
    public long msgSeq;
    public long msgTime;

    public MsgIdInfo() {
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String toString() {
        return "MsgIdInfo{msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",}";
    }

    public MsgIdInfo(long j3, long j16, long j17) {
        this.msgId = j3;
        this.msgSeq = j16;
        this.msgTime = j17;
    }
}
