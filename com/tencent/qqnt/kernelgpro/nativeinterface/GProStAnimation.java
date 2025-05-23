package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStAnimation {
    public String animationUrl = "";
    public byte[] busiData = new byte[0];
    public int height;
    public int width;

    public String getAnimationUrl() {
        return this.animationUrl;
    }

    public byte[] getBusiData() {
        return this.busiData;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProStAnimation{width=" + this.width + ",height=" + this.height + ",animationUrl=" + this.animationUrl + ",busiData=" + this.busiData + ",}";
    }
}
