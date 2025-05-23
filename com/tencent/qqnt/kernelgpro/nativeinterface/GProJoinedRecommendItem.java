package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProJoinedRecommendItem {
    public ArrayList<GProRecommendContentItem> liveCards = new ArrayList<>();
    public GProStFeed stfeed = new GProStFeed();
    public int type;

    public ArrayList<GProRecommendContentItem> getLiveCards() {
        return this.liveCards;
    }

    public GProStFeed getStfeed() {
        return this.stfeed;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProJoinedRecommendItem{type=" + this.type + ",liveCards=" + this.liveCards + ",stfeed=" + this.stfeed + ",}";
    }
}
