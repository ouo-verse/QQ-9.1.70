package com.tencent.biz.qqcircle.immersive.feed.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTabTitleVisibilityEvent extends SimpleBaseEvent {
    private boolean mAnimation;
    private int mDuration;
    private int mVisibility;

    public QFSTabTitleVisibilityEvent(int i3, boolean z16, int i16) {
        this.mVisibility = i3;
        this.mAnimation = z16;
        this.mDuration = i16;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public boolean needAnimation() {
        return this.mAnimation;
    }

    public String toString() {
        return "QFSTabTitleVisibilityEvent{mVisibility=" + this.mVisibility + ", mAnimation=" + this.mAnimation + ", mDuration=" + this.mDuration + '}';
    }
}
