package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ThumbResult {
    public int cropHeight;
    public int cropWidth;
    public int cropXOffset;
    public int cropYOffset;
    public int scaleHeight;
    public int scaleWidth;

    public ThumbResult() {
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public int getCropXOffset() {
        return this.cropXOffset;
    }

    public int getCropYOffset() {
        return this.cropYOffset;
    }

    public int getScaleHeight() {
        return this.scaleHeight;
    }

    public int getScaleWidth() {
        return this.scaleWidth;
    }

    public String toString() {
        return "ThumbResult{cropXOffset=" + this.cropXOffset + ",cropYOffset=" + this.cropYOffset + ",cropWidth=" + this.cropWidth + ",cropHeight=" + this.cropHeight + ",scaleWidth=" + this.scaleWidth + ",scaleHeight=" + this.scaleHeight + ",}";
    }

    public ThumbResult(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.cropXOffset = i3;
        this.cropYOffset = i16;
        this.cropWidth = i17;
        this.cropHeight = i18;
        this.scaleWidth = i19;
        this.scaleHeight = i26;
    }
}
