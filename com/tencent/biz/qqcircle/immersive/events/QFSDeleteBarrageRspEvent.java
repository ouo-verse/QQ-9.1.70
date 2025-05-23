package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDeleteBarrageRspEvent extends SimpleBaseEvent {
    private boolean isSuccess;
    private FeedCloudMeta$StBarrage mBarrage;
    private String mErrorMsg;
    private FeedCloudMeta$StFeed mFeed;

    public QFSDeleteBarrageRspEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, boolean z16, String str) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mBarrage = feedCloudMeta$StBarrage;
        this.isSuccess = z16;
        this.mErrorMsg = str;
    }

    public FeedCloudMeta$StBarrage getBarrage() {
        return this.mBarrage;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.mFeed;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }
}
