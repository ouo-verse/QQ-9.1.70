package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFakeCommentSendEvent extends SimpleBaseEvent {
    private FeedCloudMeta$StComment mFakeComment;
    private FeedCloudMeta$StFeed mTargetFeed;

    public QFSFakeCommentSendEvent(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.mTargetFeed = feedCloudMeta$StFeed;
        this.mFakeComment = feedCloudMeta$StComment;
    }

    public FeedCloudMeta$StComment getFakeComment() {
        return this.mFakeComment;
    }

    public FeedCloudMeta$StFeed getTargetFeed() {
        return this.mTargetFeed;
    }
}
