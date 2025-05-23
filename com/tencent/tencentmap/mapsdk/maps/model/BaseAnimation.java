package com.tencent.tencentmap.mapsdk.maps.model;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseAnimation implements Animation {
    private AnimationListener mAnimationListener;
    private long mDuration;
    private Interpolator mInterpolator;

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public AnimationListener getAnimationListener() {
        return this.mAnimationListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public long getDuration() {
        return this.mDuration;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setDuration(long j3) {
        this.mDuration = j3;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }
}
