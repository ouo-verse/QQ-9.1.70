package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFeedReportData {
    public GProFeed feed;

    public GProFeedReportData() {
        this.feed = new GProFeed();
    }

    public GProFeed getFeed() {
        return this.feed;
    }

    public void setFeed(GProFeed gProFeed) {
        this.feed = gProFeed;
    }

    public String toString() {
        return "GProFeedReportData{feed=" + this.feed + ",}";
    }

    public GProFeedReportData(GProFeed gProFeed) {
        new GProFeed();
        this.feed = gProFeed;
    }
}
