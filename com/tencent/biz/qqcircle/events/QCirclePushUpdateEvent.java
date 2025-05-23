package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes4.dex */
public class QCirclePushUpdateEvent extends SimpleBaseEvent {
    public int mAllPushTimes;
    public FeedCloudMeta$StUser mCurrentUser;
    private FeedCloudMeta$StFeed mStFeed;
    public String mTargetFeedId;

    public QCirclePushUpdateEvent(FeedCloudMeta$StUser feedCloudMeta$StUser, String str, int i3) {
        this.mTargetFeedId = str;
        this.mCurrentUser = feedCloudMeta$StUser;
        this.mAllPushTimes = i3;
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mStFeed = feedCloudMeta$StFeed;
    }
}
