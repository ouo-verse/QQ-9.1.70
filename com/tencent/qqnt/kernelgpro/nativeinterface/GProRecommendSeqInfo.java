package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendSeqInfo implements Serializable {
    public byte[] maxBytesReadMsgMeta;
    public long maxCntSeq;
    public long maxMsgSeq;
    long serialVersionUID;

    public GProRecommendSeqInfo() {
        this.serialVersionUID = 1L;
        this.maxBytesReadMsgMeta = new byte[0];
    }

    public byte[] getMaxBytesReadMsgMeta() {
        return this.maxBytesReadMsgMeta;
    }

    public long getMaxCntSeq() {
        return this.maxCntSeq;
    }

    public long getMaxMsgSeq() {
        return this.maxMsgSeq;
    }

    public String toString() {
        return "GProRecommendSeqInfo{maxMsgSeq=" + this.maxMsgSeq + ",maxCntSeq=" + this.maxCntSeq + ",maxBytesReadMsgMeta=" + this.maxBytesReadMsgMeta + ",}";
    }

    public GProRecommendSeqInfo(long j3, long j16, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.maxMsgSeq = j3;
        this.maxCntSeq = j16;
        this.maxBytesReadMsgMeta = bArr;
    }
}
