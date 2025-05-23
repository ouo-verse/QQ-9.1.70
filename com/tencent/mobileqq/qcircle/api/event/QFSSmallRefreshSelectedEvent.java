package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSSmallRefreshSelectedEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed mCurrentFeed;

    public FeedCloudMeta$StFeed getCurrentFeed() {
        return this.mCurrentFeed;
    }

    public void setCurrentFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mCurrentFeed = feedCloudMeta$StFeed;
    }
}
