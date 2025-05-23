package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBlockBaseInfo implements Serializable {
    public GProRecommendV2Channel channel;
    public GProRecommendsV2Feed feed;
    long serialVersionUID;
    public GProRecommendShareInfo shareInfo;
    public int type;

    public GProBlockBaseInfo() {
        this.serialVersionUID = 1L;
        this.feed = new GProRecommendsV2Feed();
        this.shareInfo = new GProRecommendShareInfo();
        this.channel = new GProRecommendV2Channel();
    }

    public GProRecommendV2Channel getChannel() {
        return this.channel;
    }

    public GProRecommendsV2Feed getFeed() {
        return this.feed;
    }

    public GProRecommendShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProBlockBaseInfo{type=" + this.type + ",feed=" + this.feed + ",shareInfo=" + this.shareInfo + ",channel=" + this.channel + ",}";
    }

    public GProBlockBaseInfo(int i3, GProRecommendsV2Feed gProRecommendsV2Feed, GProRecommendShareInfo gProRecommendShareInfo, GProRecommendV2Channel gProRecommendV2Channel) {
        this.serialVersionUID = 1L;
        this.feed = new GProRecommendsV2Feed();
        this.shareInfo = new GProRecommendShareInfo();
        new GProRecommendV2Channel();
        this.type = i3;
        this.feed = gProRecommendsV2Feed;
        this.shareInfo = gProRecommendShareInfo;
        this.channel = gProRecommendV2Channel;
    }
}
