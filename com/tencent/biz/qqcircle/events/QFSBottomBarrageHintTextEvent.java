package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBottomBarrageHintTextEvent extends SimpleBaseEvent {
    private String mBarrageText;
    private FeedCloudMeta$StFeed mFeed;
    private String mFeedId;

    public QFSBottomBarrageHintTextEvent(String str, String str2) {
        this.mFeedId = str;
        this.mBarrageText = str2;
    }

    public String getBarrageText() {
        return this.mBarrageText;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public void setBarrageText(String str) {
        this.mBarrageText = str;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public QFSBottomBarrageHintTextEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mBarrageText = str;
    }
}
