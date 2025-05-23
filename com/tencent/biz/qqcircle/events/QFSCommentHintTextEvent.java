package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentHintTextEvent extends SimpleBaseEvent {
    private String mCommentText;
    private String mFeedId;

    public String getCommentText() {
        return this.mCommentText;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public void setCommentText(String str) {
        this.mCommentText = str;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }
}
