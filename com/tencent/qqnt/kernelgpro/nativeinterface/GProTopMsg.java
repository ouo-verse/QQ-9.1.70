package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTopMsg implements Serializable {
    public long operatorTinyid;
    public long seq;
    long serialVersionUID = 1;
    public long time;
    public int topMsgType;

    public GProTopMsg() {
    }

    public long getOperatorTinyid() {
        return this.operatorTinyid;
    }

    public long getSeq() {
        return this.seq;
    }

    public long getTime() {
        return this.time;
    }

    public int getTopMsgType() {
        return this.topMsgType;
    }

    public String toString() {
        return "GProTopMsg{seq=" + this.seq + ",time=" + this.time + ",operatorTinyid=" + this.operatorTinyid + ",topMsgType=" + this.topMsgType + ",}";
    }

    public GProTopMsg(long j3, long j16, long j17, int i3) {
        this.seq = j3;
        this.time = j16;
        this.operatorTinyid = j17;
        this.topMsgType = i3;
    }
}
