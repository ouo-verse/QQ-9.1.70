package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StReply;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSReplyItemInfo extends QFSCommentOrReplyActionBean {
    public int moreNum;
    public FeedCloudMeta$StReply reply;
    public int type;

    public QFSReplyItemInfo(int i3) {
        this.type = i3;
    }

    public QFSReplyItemInfo(int i3, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        this.type = i3;
        this.reply = feedCloudMeta$StReply;
    }

    public QFSReplyItemInfo(int i3, FeedCloudMeta$StReply feedCloudMeta$StReply, int i16) {
        this.type = i3;
        this.reply = feedCloudMeta$StReply;
        this.moreNum = i16;
    }
}
