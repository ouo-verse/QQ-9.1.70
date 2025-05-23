package com.airbnb.lottie.value;

import androidx.annotation.RestrictTo;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public LottieFrameInfo<T> set(float f16, float f17, T t16, T t17, float f18, float f19, float f26) {
        this.startFrame = f16;
        this.endFrame = f17;
        this.startValue = t16;
        this.endValue = t17;
        this.linearKeyframeProgress = f18;
        this.interpolatedKeyframeProgress = f19;
        this.overallProgress = f26;
        return this;
    }
}
