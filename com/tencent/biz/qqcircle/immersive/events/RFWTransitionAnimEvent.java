package com.tencent.biz.qqcircle.immersive.events;

import android.graphics.drawable.Drawable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RFWTransitionAnimEvent extends SimpleBaseEvent {
    private Drawable mAnimCoverDrawable;
    private final String mClickViewHashCode;
    private boolean mIsAnimStart;

    public RFWTransitionAnimEvent(String str, boolean z16) {
        this.mClickViewHashCode = str;
        this.mIsAnimStart = z16;
    }

    public Drawable getAnimCoverDrawable() {
        return this.mAnimCoverDrawable;
    }

    public String getClickViewHashCode() {
        return this.mClickViewHashCode;
    }

    public boolean isAnimStart() {
        return this.mIsAnimStart;
    }

    public void setAnimCoverDrawable(Drawable drawable) {
        this.mAnimCoverDrawable = drawable;
    }

    public String toString() {
        return "RFWTransitionAnimEvent{mClickViewHashCode='" + this.mClickViewHashCode + "', mIsAnimStart=" + this.mIsAnimStart + ", mAnimCoverDrawable=" + this.mAnimCoverDrawable + '}';
    }
}
