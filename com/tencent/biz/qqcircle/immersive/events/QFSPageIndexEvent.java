package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSPageIndexEvent extends SimpleBaseEvent {
    public boolean hasMoreData;
    public int pageIndex = -1;
    public FeedCloudMeta$StFeed stFeed;

    public QFSPageIndexEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.stFeed = feedCloudMeta$StFeed;
    }
}
