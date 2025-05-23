package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSFrameTabBarVisibleEvent extends SimpleBaseEvent {
    private final int mAnimDuration;
    private boolean mShowSeekTouchArea;
    private final boolean mShowTab;

    public QFSFrameTabBarVisibleEvent(boolean z16) {
        this(z16, 100);
    }

    public int getAnimDuration() {
        return this.mAnimDuration;
    }

    public boolean isShowSeekTouchArea() {
        return this.mShowSeekTouchArea;
    }

    public boolean needShowTab() {
        return this.mShowTab;
    }

    public void setShowSeekTouchArea(boolean z16) {
        this.mShowSeekTouchArea = z16;
    }

    public QFSFrameTabBarVisibleEvent(boolean z16, int i3) {
        this.mShowTab = z16;
        this.mAnimDuration = i3;
    }
}
