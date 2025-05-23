package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProIndexFeedItem {
    public int indexType;
    public GProContentRecommendFeed recommendFeed = new GProContentRecommendFeed();
    public GProRecentViewedData recentViewData = new GProRecentViewedData();

    public int getIndexType() {
        return this.indexType;
    }

    public GProRecentViewedData getRecentViewData() {
        return this.recentViewData;
    }

    public GProContentRecommendFeed getRecommendFeed() {
        return this.recommendFeed;
    }

    public String toString() {
        return "GProIndexFeedItem{indexType=" + this.indexType + ",recommendFeed=" + this.recommendFeed + ",recentViewData=" + this.recentViewData + ",}";
    }
}
