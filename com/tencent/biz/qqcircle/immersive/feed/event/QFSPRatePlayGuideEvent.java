package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSPRatePlayGuideEvent extends SimpleBaseEvent {
    private int mContextHashCode;
    private FeedCloudMeta$StFeed mFeed;
    private final boolean mIsFullScreen;

    public QFSPRatePlayGuideEvent(boolean z16, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mIsFullScreen = z16;
        this.mFeed = feedCloudMeta$StFeed;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public boolean isFuLLScreen() {
        return this.mIsFullScreen;
    }

    public QFSPRatePlayGuideEvent setContextHashCode(int i3) {
        this.mContextHashCode = i3;
        return this;
    }
}
