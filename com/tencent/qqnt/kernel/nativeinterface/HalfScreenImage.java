package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HalfScreenImage {
    public int height;
    public int imageType;
    public int width;
    public String picUrl = "";
    public String md5 = "";

    public int getHeight() {
        return this.height;
    }

    public int getImageType() {
        return this.imageType;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "HalfScreenImage{imageType=" + this.imageType + ",picUrl=" + this.picUrl + ",width=" + this.width + ",height=" + this.height + ",md5=" + this.md5 + ",}";
    }
}
