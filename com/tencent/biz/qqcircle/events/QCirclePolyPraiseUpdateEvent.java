package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;
import qqcircle.QQCircleFeedBase$StPolyLike;

/* loaded from: classes4.dex */
public class QCirclePolyPraiseUpdateEvent extends SimpleBaseEvent {
    public QQCircleFeedBase$StPolyLike mNewStPolyLike;
    public int mPraisedNum;
    public int mPraisedStatus;
    private FeedCloudMeta$StFeed mStFeed;
    public String mTargetFeedId;
    public QQCircleFeedBase$StPolyLike moldStPolyLike;

    public QCirclePolyPraiseUpdateEvent(String str, QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike, QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike2, int i3, int i16) {
        this.moldStPolyLike = qQCircleFeedBase$StPolyLike;
        this.mPraisedStatus = i3;
        this.mNewStPolyLike = qQCircleFeedBase$StPolyLike2;
        this.mTargetFeedId = str;
        this.mPraisedNum = i16;
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    public boolean isPraised() {
        if (this.mPraisedStatus == 1) {
            return true;
        }
        return false;
    }

    public void setStFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mStFeed = feedCloudMeta$StFeed;
    }

    public String toString() {
        return "QCirclePolyPraiseUpdateEvent{mTargetFeedId='" + this.mTargetFeedId + "', mPraisedStatus=" + this.mPraisedStatus + "', mPraisedNum=" + this.mPraisedNum + "'} " + super.toString();
    }
}
