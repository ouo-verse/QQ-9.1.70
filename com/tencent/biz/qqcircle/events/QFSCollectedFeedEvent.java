package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCollectedFeedEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed feed;
    private String feedId;
    private boolean hasCollectBox;
    private boolean isCollected;
    private boolean showGoWatchBanner = true;

    public QFSCollectedFeedEvent(String str, boolean z16) {
        this.feedId = str;
        this.isCollected = z16;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public boolean isCollected() {
        return this.isCollected;
    }

    public boolean isHasCollectBox() {
        return this.hasCollectBox;
    }

    public boolean isShowGoWatchBanner() {
        return this.showGoWatchBanner;
    }

    public void setCollected(boolean z16) {
        this.isCollected = z16;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.feed = feedCloudMeta$StFeed;
    }

    public void setFeedId(String str) {
        this.feedId = str;
    }

    public void setHasCollectBox(boolean z16) {
        this.hasCollectBox = z16;
    }

    public void setShowGoWatchBanner(boolean z16) {
        this.showGoWatchBanner = z16;
    }
}
