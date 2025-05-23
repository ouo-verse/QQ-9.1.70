package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleVideoRateEvent extends SimpleBaseEvent {
    private String mFeedId;
    private float mSelectedRate;

    public QCircleVideoRateEvent(String str, float f16) {
        this.mFeedId = str;
        this.mSelectedRate = f16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public float getSelectedRate() {
        return this.mSelectedRate;
    }

    public String toString() {
        return "QCircleVideoRateEvent{mFeedId='" + this.mFeedId + "', mSelectedRate=" + this.mSelectedRate + '}';
    }
}
