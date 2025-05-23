package com.tencent.biz.subscribe.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes5.dex */
public class PraisedUpdateEvents extends SimpleBaseEvent {
    public int mPraisedNum;
    public int mPraisedStatus;
    public String mTargetFeedId;

    public PraisedUpdateEvents(String str, int i3, int i16) {
        this.mPraisedStatus = i3;
        this.mTargetFeedId = str;
        this.mPraisedNum = i16;
    }
}
