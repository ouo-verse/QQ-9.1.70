package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleCommentCountUpdateEvent extends SimpleBaseEvent {
    private int mCount;
    private String mFeedId;

    public QCircleCommentCountUpdateEvent(String str, int i3) {
        this.mFeedId = str;
        this.mCount = i3;
    }

    public int getCount() {
        return this.mCount;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public void setCount(int i3) {
        this.mCount = i3;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public String toString() {
        return "QCircleCommentCountUpdateEvent{mFeedId='" + this.mFeedId + "', mCount=" + this.mCount + "} " + super.toString();
    }
}
