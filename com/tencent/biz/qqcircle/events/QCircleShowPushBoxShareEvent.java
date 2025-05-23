package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QCircleShowPushBoxShareEvent extends SimpleBaseEvent {
    FeedCloudMeta$StFeed mFeed;

    public QCircleShowPushBoxShareEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }
}
