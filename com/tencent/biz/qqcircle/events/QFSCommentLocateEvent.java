package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentLocateEvent extends SimpleBaseEvent {
    private final String mCommentId;
    private final String mFeedId;
    private final String mReplyId;
    public boolean smoothScroll;

    public QFSCommentLocateEvent(String str, String str2, String str3) {
        this.mFeedId = str;
        this.mCommentId = str2;
        this.mReplyId = str3;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public String getReplyId() {
        return this.mReplyId;
    }

    public String toString() {
        return "QFSCommentLocateEvent{mFeedId='" + this.mFeedId + "', mCommentId='" + this.mCommentId + "', mReplyId='" + this.mReplyId + "'}";
    }
}
