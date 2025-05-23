package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMsgSeq implements Serializable {
    public long seq;
    long serialVersionUID = 1;
    public long time;

    public GProMsgSeq() {
    }

    public long getSeq() {
        return this.seq;
    }

    public long getTime() {
        return this.time;
    }

    public void setSeq(long j3) {
        this.seq = j3;
    }

    public void setTime(long j3) {
        this.time = j3;
    }

    public String toString() {
        return "GProMsgSeq{seq=" + this.seq + ",time=" + this.time + ",}";
    }

    public GProMsgSeq(long j3, long j16) {
        this.seq = j3;
        this.time = j16;
    }
}
