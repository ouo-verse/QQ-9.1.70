package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFullScreenCompletionEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StFeed mCurrentFeed;

    public QFSFullScreenCompletionEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mCurrentFeed = feedCloudMeta$StFeed;
    }

    public FeedCloudMeta$StFeed getCurrentFeed() {
        return this.mCurrentFeed;
    }
}
