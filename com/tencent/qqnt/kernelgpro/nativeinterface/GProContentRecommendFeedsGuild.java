package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendFeedsGuild implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProContentRecommendFeed> feeds = new ArrayList<>();

    public ArrayList<GProContentRecommendFeed> getFeeds() {
        return this.feeds;
    }

    public String toString() {
        return "GProContentRecommendFeedsGuild{feeds=" + this.feeds + ",}";
    }
}
