package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RoamDatemsg {
    public long clientSeq;
    public long msgSeq;
    public long msgTime;

    public RoamDatemsg() {
    }

    public long getClientSeq() {
        return this.clientSeq;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String toString() {
        return "RoamDatemsg{msgSeq=" + this.msgSeq + ",clientSeq=" + this.clientSeq + ",msgTime=" + this.msgTime + ",}";
    }

    public RoamDatemsg(long j3, long j16, long j17) {
        this.msgSeq = j3;
        this.clientSeq = j16;
        this.msgTime = j17;
    }
}
