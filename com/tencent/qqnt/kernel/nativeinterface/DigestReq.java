package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DigestReq {
    public long groupCode;
    public int msgRandom;
    public int msgSeq;

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMsgRandom() {
        return this.msgRandom;
    }

    public int getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "DigestReq{groupCode=" + this.groupCode + ",msgSeq=" + this.msgSeq + ",msgRandom=" + this.msgRandom + ",}";
    }
}
