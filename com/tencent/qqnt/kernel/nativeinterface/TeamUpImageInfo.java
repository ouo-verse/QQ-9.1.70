package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpImageInfo {
    public int height;
    public int width;
    public String picUrl = "";
    public String md5 = "";

    public int getHeight() {
        return this.height;
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
        return "TeamUpImageInfo{picUrl=" + this.picUrl + ",width=" + this.width + ",height=" + this.height + ",md5=" + this.md5 + ",}";
    }
}
