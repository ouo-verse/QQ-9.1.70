package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProNavigateInfo {
    public long msgSeq;
    public GProNavigateType type;

    public GProNavigateInfo() {
        this.type = GProNavigateType.values()[0];
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public GProNavigateType getType() {
        return this.type;
    }

    public String toString() {
        return "GProNavigateInfo{msgSeq=" + this.msgSeq + ",type=" + this.type + ",}";
    }

    public GProNavigateInfo(long j3, GProNavigateType gProNavigateType) {
        GProNavigateType gProNavigateType2 = GProNavigateType.values()[0];
        this.msgSeq = j3;
        this.type = gProNavigateType;
    }
}
