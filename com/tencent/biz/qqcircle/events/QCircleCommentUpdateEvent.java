package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudRead$GuildDisplayInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleCommentUpdateEvent extends SimpleBaseEvent {
    public static final int EVENT_ADD_COMMENT = 3;
    public static final int EVENT_ADD_COMMENT_FAILURE = 9;
    public static final int EVENT_ADD_REPLY = 5;
    public static final int EVENT_ADD_REPLY_FAILURE = 10;
    public static final int EVENT_CANCEL_STICKY_COMMENT = 8;
    public static final int EVENT_DELETE_COMMENT = 4;
    public static final int EVENT_DELETE_REPLY = 6;
    public static final int EVENT_GET_COMMENT_LIST = 1;
    public static final int EVENT_GET_COMMENT_LIST_FAILURE = 11;
    public static final int EVENT_LOAD_MORE_COMMENT_LIST = 2;
    public static final int EVENT_STICKY_COMMENT = 7;
    public FeedCloudMeta$StComment comment;
    public List<FeedCloudMeta$StComment> commentList;
    public int commentTotalNum;
    public int contextHashCode;
    public int eventStatus;
    public String fakeCommentId;
    public String fakeReplyId;
    public String feedId;
    public boolean isFeedOwner;
    private String mFastCommentText;
    public FeedCloudRead$GuildDisplayInfo mGuildDisplayInfo;
    private boolean mIsProtocolCache;
    public boolean needShowCommentPanel;
    public FeedCloudMeta$StReply reply;
    public String tailText;

    QCircleCommentUpdateEvent() {
    }

    public static QCircleCommentUpdateEvent getCommentListFailedEvent(String str, int i3) {
        QCircleCommentUpdateEvent qCircleCommentUpdateEvent = new QCircleCommentUpdateEvent();
        qCircleCommentUpdateEvent.eventStatus = 11;
        qCircleCommentUpdateEvent.feedId = str;
        qCircleCommentUpdateEvent.contextHashCode = i3;
        return qCircleCommentUpdateEvent;
    }

    public String getFastCommentText() {
        return this.mFastCommentText;
    }

    public FeedCloudRead$GuildDisplayInfo getGuildDisplayInfo() {
        return this.mGuildDisplayInfo;
    }

    public boolean isProtocolCache() {
        return this.mIsProtocolCache;
    }

    public void setFastCommentText(String str) {
        this.mFastCommentText = str;
    }

    public void setGuildDisplayInfo(FeedCloudRead$GuildDisplayInfo feedCloudRead$GuildDisplayInfo) {
        this.mGuildDisplayInfo = feedCloudRead$GuildDisplayInfo;
    }

    public void setIsProtocolCache(boolean z16) {
        this.mIsProtocolCache = z16;
    }

    public QCircleCommentUpdateEvent(int i3, String str, List<FeedCloudMeta$StComment> list, int i16, int i17, String str2) {
        this.eventStatus = i3;
        this.feedId = str;
        this.commentList = list;
        this.commentTotalNum = i16;
        this.contextHashCode = i17;
        this.tailText = str2;
    }

    public QCircleCommentUpdateEvent(int i3, String str, FeedCloudMeta$StComment feedCloudMeta$StComment, int i16, int i17) {
        this.eventStatus = i3;
        this.feedId = str;
        this.comment = QCirclePluginUtil.deepCopycomment(feedCloudMeta$StComment);
        this.commentTotalNum = i16;
        this.contextHashCode = i17;
    }

    public QCircleCommentUpdateEvent(int i3, String str, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i16, int i17) {
        this.eventStatus = i3;
        this.feedId = str;
        this.comment = QCirclePluginUtil.deepCopycomment(feedCloudMeta$StComment);
        this.reply = QCirclePluginUtil.deepCopyReply(feedCloudMeta$StReply);
        this.commentTotalNum = i16;
        this.contextHashCode = i17;
    }

    public QCircleCommentUpdateEvent(int i3, String str, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply, int i16) {
        this.eventStatus = i3;
        this.feedId = str;
        this.comment = QCirclePluginUtil.deepCopycomment(feedCloudMeta$StComment);
        this.reply = QCirclePluginUtil.deepCopyReply(feedCloudMeta$StReply);
        this.contextHashCode = i16;
    }
}
