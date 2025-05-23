package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSeekEvent extends SimpleBaseEvent {
    public String mFeedId;
    public boolean mIsOnSeek;
    public long mStopTrackingTouchProgress;

    public QFSSeekEvent(String str, boolean z16) {
        this.mIsOnSeek = z16;
        this.mFeedId = str;
    }

    public void setStopTrackingTouchProgress(long j3) {
        this.mStopTrackingTouchProgress = j3;
    }
}
