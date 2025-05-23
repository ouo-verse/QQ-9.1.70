package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ShareMsgInfo {
    public long msgSeq;
    public long msgTime;

    public ShareMsgInfo() {
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String toString() {
        return "ShareMsgInfo{msgTime=" + this.msgTime + ",msgSeq=" + this.msgSeq + ",}";
    }

    public ShareMsgInfo(long j3, long j16) {
        this.msgTime = j3;
        this.msgSeq = j16;
    }
}
