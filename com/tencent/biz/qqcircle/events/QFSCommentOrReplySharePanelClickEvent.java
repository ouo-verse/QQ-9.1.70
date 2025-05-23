package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;

/* loaded from: classes4.dex */
public class QFSCommentOrReplySharePanelClickEvent extends SimpleBaseEvent {
    public static final int TYPE_CANCEL_STICKY_COMMENT = 2;
    public static final int TYPE_DELETE_COMMENT = 3;
    public static final int TYPE_DELETE_REPLY = 4;
    public static final int TYPE_STICKY_COMMENT = 1;
    public int clickType;
    public FeedCloudMeta$StComment comment;
    public int contextHashCode;
    public String feedId;
    public FeedCloudMeta$StReply reply;

    public QFSCommentOrReplySharePanelClickEvent(int i3, String str, int i16, FeedCloudMeta$StComment feedCloudMeta$StComment, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        this.clickType = i3;
        this.feedId = str;
        this.contextHashCode = i16;
        this.comment = feedCloudMeta$StComment;
        this.reply = feedCloudMeta$StReply;
    }
}
