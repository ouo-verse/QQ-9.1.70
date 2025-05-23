package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedCommentInfo {
    public FeedCloudMeta$StComment mComment;
    public String mCommentText;
    public FeedCloudMeta$StComment mFakeComment;
    public FeedCloudMeta$StReply mFakeReply;
    public FeedCloudMeta$StFeed mFeed;
    public String mHintText;
    public FeedCloudMeta$StReply mReply;
    public boolean showSuccessToast;

    public QFSFeedCommentInfo(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mComment = feedCloudMeta$StComment;
    }

    public QFSFeedCommentInfo(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mComment = feedCloudMeta$StComment;
        this.mReply = feedCloudMeta$StReply;
    }

    public QFSFeedCommentInfo(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, String str) {
        this.mFeed = feedCloudMeta$StFeed;
        this.mComment = feedCloudMeta$StComment;
        this.mReply = feedCloudMeta$StReply;
        this.mHintText = str;
    }
}
