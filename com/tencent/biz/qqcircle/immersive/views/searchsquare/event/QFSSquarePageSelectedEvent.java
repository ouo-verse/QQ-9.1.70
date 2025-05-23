package com.tencent.biz.qqcircle.immersive.views.searchsquare.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSSquarePageSelectedEvent extends SimpleBaseEvent {
    public final FeedCloudMeta$StFeed feed;

    public QFSSquarePageSelectedEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.feed = feedCloudMeta$StFeed;
    }
}
