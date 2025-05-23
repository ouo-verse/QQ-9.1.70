package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: P */
/* loaded from: classes.dex */
abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieInterpolatedValue(T t16, T t17) {
        this(t16, t17, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return interpolateValue(this.startValue, this.endValue, this.interpolator.getInterpolation(lottieFrameInfo.getOverallProgress()));
    }

    abstract T interpolateValue(T t16, T t17, float f16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public LottieInterpolatedValue(T t16, T t17, Interpolator interpolator) {
        this.startValue = t16;
        this.endValue = t17;
        this.interpolator = interpolator;
    }
}
