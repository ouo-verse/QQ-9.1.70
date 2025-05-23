package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendGroupInfo {
    public GProRecommendFeed feed = new GProRecommendFeed();
    public ArrayList<GProRecommendChannel> channelList = new ArrayList<>();

    public ArrayList<GProRecommendChannel> getChannelList() {
        return this.channelList;
    }

    public GProRecommendFeed getFeed() {
        return this.feed;
    }

    public String toString() {
        return "GProRecommendGroupInfo{feed=" + this.feed + ",channelList=" + this.channelList + ",}";
    }
}
