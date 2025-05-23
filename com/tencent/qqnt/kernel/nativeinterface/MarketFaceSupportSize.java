package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MarketFaceSupportSize {
    public int height;
    public int width;

    public MarketFaceSupportSize() {
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "MarketFaceSupportSize{width=" + this.width + ",height=" + this.height + ",}";
    }

    public MarketFaceSupportSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }
}
