package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleFeedOptEvent extends SimpleBaseEvent {
    public static final int OPT_TYPE_DELETE = 2;
    public static final int OPT_TYPE_INSERT = 1;
    private FeedCloudMeta$StFeed mFeed;
    private String mFeedId;
    private int mInsertPosition;
    private int mOptType;

    public QCircleFeedOptEvent(int i3) {
        this.mOptType = i3;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getInsertPosition() {
        return this.mInsertPosition;
    }

    public int getOptType() {
        return this.mOptType;
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mFeed = feedCloudMeta$StFeed;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setInsertPosition(int i3) {
        this.mInsertPosition = i3;
    }

    public String toString() {
        return "QCircleFeedOptEvent{mOptType=" + this.mOptType + ", mFeedId='" + this.mFeedId + "', mInsertPosition=" + this.mInsertPosition + '}';
    }
}
