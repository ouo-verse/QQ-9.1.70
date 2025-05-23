package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLockRateStatusChangeEvent extends SimpleBaseEvent {
    private final boolean mIsLockRate;
    private final float mPlayRate;
    private boolean mIsFollowPage = false;
    private String mFeedId = "";

    public QFSLockRateStatusChangeEvent(boolean z16, float f16) {
        this.mIsLockRate = z16;
        this.mPlayRate = f16;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public boolean getIsFollowPage() {
        return this.mIsFollowPage;
    }

    public boolean getIsLockRate() {
        return this.mIsLockRate;
    }

    public float getPlayRate() {
        return this.mPlayRate;
    }

    public void setFeedId(String str) {
        this.mFeedId = str;
    }

    public void setIsFollowPage(boolean z16) {
        this.mIsFollowPage = z16;
    }
}
