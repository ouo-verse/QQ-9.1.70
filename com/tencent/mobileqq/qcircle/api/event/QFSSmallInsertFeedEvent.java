package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSSmallInsertFeedEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed mCurrentFeed;

    public QFSSmallInsertFeedEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mCurrentFeed = feedCloudMeta$StFeed;
    }

    public FeedCloudMeta$StFeed getCurrentFeed() {
        return this.mCurrentFeed;
    }
}
