package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FreqLimitInfo {
    public int isLimited;
    public int leftCount;
    public long limitTimestamp;

    public FreqLimitInfo() {
    }

    public int getIsLimited() {
        return this.isLimited;
    }

    public int getLeftCount() {
        return this.leftCount;
    }

    public long getLimitTimestamp() {
        return this.limitTimestamp;
    }

    public String toString() {
        return "FreqLimitInfo{isLimited=" + this.isLimited + ",leftCount=" + this.leftCount + ",limitTimestamp=" + this.limitTimestamp + ",}";
    }

    public FreqLimitInfo(int i3, int i16, long j3) {
        this.isLimited = i3;
        this.leftCount = i16;
        this.limitTimestamp = j3;
    }
}
