package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MsgAbstractInfo {
    public MsgAbstract msgAbs;
    public long msgId;
    public long msgSeq;
    public long msgTime;

    public MsgAbstractInfo() {
        this.msgAbs = new MsgAbstract();
    }

    public MsgAbstract getMsgAbs() {
        return this.msgAbs;
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
        return "MsgAbstractInfo{msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",msgAbs=" + this.msgAbs + ",}";
    }

    public MsgAbstractInfo(long j3, long j16, long j17, MsgAbstract msgAbstract) {
        new MsgAbstract();
        this.msgId = j3;
        this.msgSeq = j16;
        this.msgTime = j17;
        this.msgAbs = msgAbstract;
    }
}
