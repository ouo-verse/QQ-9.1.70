package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProStDelFeedReq {
    public GProStCommonExt extInfo = new GProStCommonExt();
    public GProStFeed feed = new GProStFeed();
    public int from;
    public int scene;
    public int src;

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProStFeed getFeed() {
        return this.feed;
    }

    public int getFrom() {
        return this.from;
    }

    public int getScene() {
        return this.scene;
    }

    public int getSrc() {
        return this.src;
    }

    public String toString() {
        return "GProStDelFeedReq{extInfo=" + this.extInfo + ",feed=" + this.feed + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",src=" + this.src + ",scene=" + this.scene + ",}";
    }
}
