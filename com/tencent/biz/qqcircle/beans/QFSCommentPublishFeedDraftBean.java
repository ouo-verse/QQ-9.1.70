package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;

/* loaded from: classes4.dex */
public class QFSCommentPublishFeedDraftBean {
    private String mDraftId;
    private FeedCloudMeta$StComment mFakeComment;
    private FeedCloudMeta$StReply mFakeReply;
    private QFSFeedCommentInfo mFeedCommentInfo;
    private int mHostPartHashcode;
    private int mPostType;

    public QFSCommentPublishFeedDraftBean(QFSFeedCommentInfo qFSFeedCommentInfo, String str, int i3) {
        this.mFeedCommentInfo = qFSFeedCommentInfo;
        this.mDraftId = str;
        this.mPostType = i3;
    }

    public String getDraftId() {
        return this.mDraftId;
    }

    public FeedCloudMeta$StComment getFakeComment() {
        return this.mFakeComment;
    }

    public FeedCloudMeta$StReply getFakeReply() {
        return this.mFakeReply;
    }

    public QFSFeedCommentInfo getFeedCommentInfo() {
        return this.mFeedCommentInfo;
    }

    public int getHostPartHashcode() {
        return this.mHostPartHashcode;
    }

    public int getPostType() {
        return this.mPostType;
    }

    public void setFakeComment(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.mFakeComment = feedCloudMeta$StComment;
    }

    public void setFakeReply(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        this.mFakeReply = feedCloudMeta$StReply;
    }

    public void setHostPartHashcode(int i3) {
        this.mHostPartHashcode = i3;
    }

    public void setPostType(int i3) {
        this.mPostType = i3;
    }
}
