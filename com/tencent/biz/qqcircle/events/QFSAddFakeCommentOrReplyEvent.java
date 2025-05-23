package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAddFakeCommentOrReplyEvent extends SimpleBaseEvent {
    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_REPLY_COMMENT = 2;
    private String dtPageId;
    private final FeedCloudMeta$StComment mComment;
    private final String mFeedId;
    private final int mFrom;
    private final FeedCloudMeta$StReply mReply;
    private final int mType;
    public FeedCloudMeta$StReply targetReply;

    public QFSAddFakeCommentOrReplyEvent(String str, FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.mType = 1;
        this.mFrom = 0;
        this.mReply = null;
        this.mFeedId = str;
        this.mComment = feedCloudMeta$StComment;
    }

    public FeedCloudMeta$StComment getComment() {
        return this.mComment;
    }

    public String getDtPageId() {
        return this.dtPageId;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public FeedCloudMeta$StReply getReply() {
        return this.mReply;
    }

    public int getType() {
        return this.mType;
    }

    public void setDtPageId(String str) {
        this.dtPageId = str;
    }

    public QFSAddFakeCommentOrReplyEvent(String str, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i3) {
        this.mType = 2;
        this.mReply = feedCloudMeta$StReply;
        this.mFeedId = str;
        this.mComment = feedCloudMeta$StComment;
        this.mFrom = i3;
    }
}
