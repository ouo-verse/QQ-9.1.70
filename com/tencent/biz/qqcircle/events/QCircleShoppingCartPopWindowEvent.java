package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QCircleShoppingCartPopWindowEvent extends SimpleBaseEvent {
    FeedCloudMeta$StFeed mFeed;
    String mJumpUrl;

    public QCircleShoppingCartPopWindowEvent(String str, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mJumpUrl = str;
        this.mFeed = feedCloudMeta$StFeed;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public String getJumpUrl() {
        return this.mJumpUrl;
    }
}
