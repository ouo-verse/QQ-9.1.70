package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSVideoPauseEvent extends SimpleBaseEvent {
    public String mFeedId;
    public boolean mIsClick;
    public boolean mIsPause;
    public long mProgress;

    public QFSVideoPauseEvent(String str, boolean z16, long j3) {
        this.mFeedId = str;
        this.mIsPause = z16;
        this.mProgress = j3;
    }

    public QFSVideoPauseEvent setClick(boolean z16) {
        this.mIsClick = z16;
        return this;
    }

    public QFSVideoPauseEvent(String str, boolean z16, long j3, int i3) {
        this.mFeedId = str;
        this.mIsPause = z16;
        this.mProgress = j3;
        this.mHashCode = i3;
    }
}
