package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUserPublishedFeedSummary {
    public String publishedCountStr = "";
    public ArrayList<byte[]> feedList = new ArrayList<>();

    public ArrayList<byte[]> getFeedList() {
        return this.feedList;
    }

    public String getPublishedCountStr() {
        return this.publishedCountStr;
    }

    public String toString() {
        return "GProUserPublishedFeedSummary{publishedCountStr=" + this.publishedCountStr + ",feedList=" + this.feedList + ",}";
    }
}
