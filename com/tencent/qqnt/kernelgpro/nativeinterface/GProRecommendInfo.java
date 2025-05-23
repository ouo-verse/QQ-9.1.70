package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecommendInfo {
    public int type;
    public GProRecommendFeed feed = new GProRecommendFeed();
    public GProRecommendChannel channel = new GProRecommendChannel();
    public GProRecommendShareInfo shareInfo = new GProRecommendShareInfo();

    public GProRecommendChannel getChannel() {
        return this.channel;
    }

    public GProRecommendFeed getFeed() {
        return this.feed;
    }

    public GProRecommendShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendInfo{feed=" + this.feed + ",channel=" + this.channel + ",shareInfo=" + this.shareInfo + ",type=" + this.type + ",}";
    }
}
