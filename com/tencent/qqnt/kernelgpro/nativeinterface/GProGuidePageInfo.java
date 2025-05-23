package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuidePageInfo {
    public String title = "";
    public String desc = "";
    public GProImgPair images = new GProImgPair();

    public String getDesc() {
        return this.desc;
    }

    public GProImgPair getImages() {
        return this.images;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGuidePageInfo{title=" + this.title + ",desc=" + this.desc + ",images=" + this.images + ",}";
    }
}
