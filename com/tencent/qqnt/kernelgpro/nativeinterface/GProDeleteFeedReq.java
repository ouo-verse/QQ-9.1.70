package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;

/* loaded from: classes24.dex */
public final class GProDeleteFeedReq {
    public GProFDLStCommonExt extInfo;
    public GProFDLStDeleteFeed feed;
    public int from;
    public int scene;

    public GProDeleteFeedReq() {
        this.extInfo = new GProFDLStCommonExt();
        this.feed = new GProFDLStDeleteFeed();
    }

    public GProFDLStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProFDLStDeleteFeed getFeed() {
        return this.feed;
    }

    public int getFrom() {
        return this.from;
    }

    public int getScene() {
        return this.scene;
    }

    public String toString() {
        return "GProDeleteFeedReq{extInfo=" + this.extInfo + ",feed=" + this.feed + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",scene=" + this.scene + ",}";
    }

    public GProDeleteFeedReq(GProFDLStCommonExt gProFDLStCommonExt, GProFDLStDeleteFeed gProFDLStDeleteFeed, int i3, int i16) {
        this.extInfo = new GProFDLStCommonExt();
        new GProFDLStDeleteFeed();
        this.extInfo = gProFDLStCommonExt;
        this.feed = gProFDLStDeleteFeed;
        this.from = i3;
        this.scene = i16;
    }
}
