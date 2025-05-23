package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFakeDeleteBarrageEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StBarrage mBarrage;
    private FeedCloudMeta$StFeed mFeed;

    public QFSFakeDeleteBarrageEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mBarrage = feedCloudMeta$StBarrage;
    }

    public FeedCloudMeta$StBarrage getBarrage() {
        return this.mBarrage;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }
}
