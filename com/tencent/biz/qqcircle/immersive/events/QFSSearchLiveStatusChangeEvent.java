package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchLiveStatusChangeEvent extends SimpleBaseEvent {
    private boolean isOnlyLiveEvent;
    public final FeedCloudMeta$StFeed stFeed;

    public QFSSearchLiveStatusChangeEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.stFeed = feedCloudMeta$StFeed;
    }

    public boolean isOnlyLiveEvent() {
        return this.isOnlyLiveEvent;
    }

    public void setOnlyLiveEvent(boolean z16) {
        this.isOnlyLiveEvent = z16;
    }
}
