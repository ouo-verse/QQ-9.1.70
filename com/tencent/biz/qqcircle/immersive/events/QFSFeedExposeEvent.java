package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedExposeEvent extends SimpleBaseEvent {
    private final FeedCloudMeta$StFeed feed;
    private String feedId;

    public QFSFeedExposeEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        this.feed = feedCloudMeta$StFeed;
        this.feedId = str;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.feed;
    }

    public String getFeedId() {
        return this.feedId;
    }
}
