package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSPushTenTimesEvent extends SimpleBaseEvent {
    public FeedCloudMeta$StFeed mFeed;

    public QFSPushTenTimesEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }
}
