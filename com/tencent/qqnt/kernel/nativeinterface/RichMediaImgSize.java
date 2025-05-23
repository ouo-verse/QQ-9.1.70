package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RichMediaImgSize {
    public int height;
    public int width;

    public RichMediaImgSize() {
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "RichMediaImgSize{width=" + this.width + ",height=" + this.height + ",}";
    }

    public RichMediaImgSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }
}
