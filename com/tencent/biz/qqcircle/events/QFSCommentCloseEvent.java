package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentCloseEvent extends SimpleBaseEvent {
    private String mFeedId;

    public QFSCommentCloseEvent(String str) {
        this.mFeedId = str;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public QFSCommentCloseEvent() {
    }
}
