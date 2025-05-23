package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTopFeedAbstract {
    public String title = "";
    public GProThumbnail thumbnail = new GProThumbnail();

    public GProThumbnail getThumbnail() {
        return this.thumbnail;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProTopFeedAbstract{title=" + this.title + ",thumbnail=" + this.thumbnail + ",}";
    }
}
