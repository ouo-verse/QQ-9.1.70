package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NavigateInfo {
    public long msgSeq;
    public NavigateType type;

    public NavigateInfo() {
        this.type = NavigateType.values()[0];
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public NavigateType getType() {
        return this.type;
    }

    public String toString() {
        return "NavigateInfo{msgSeq=" + this.msgSeq + ",type=" + this.type + ",}";
    }

    public NavigateInfo(long j3, NavigateType navigateType) {
        NavigateType navigateType2 = NavigateType.values()[0];
        this.msgSeq = j3;
        this.type = navigateType;
    }
}
