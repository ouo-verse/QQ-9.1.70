package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes4.dex */
public class QFSPushParabolaAnimEvent extends SimpleBaseEvent {
    private int mHasPushCount;
    private final int[] mPushIconLocation = new int[2];
    private int mPushType;
    private final String mTargetFeedId;

    public QFSPushParabolaAnimEvent(String str) {
        this.mTargetFeedId = str;
    }

    public int getHasPushCount() {
        return this.mHasPushCount;
    }

    public int[] getPushIconLocation() {
        return this.mPushIconLocation;
    }

    public int getPushType() {
        return this.mPushType;
    }

    public String getTargetFeedId() {
        return this.mTargetFeedId;
    }

    public void setHasPushCount(int i3) {
        this.mHasPushCount = i3;
    }

    public void setPushIconLocation(int i3, int i16) {
        int[] iArr = this.mPushIconLocation;
        iArr[0] = i3;
        iArr[1] = i16;
    }

    public void setPushType(int i3) {
        this.mPushType = i3;
    }
}
