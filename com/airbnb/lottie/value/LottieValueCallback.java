package com.airbnb.lottie.value;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieValueCallback<T> {

    @Nullable
    private BaseKeyframeAnimation<?, ?> animation;
    private final LottieFrameInfo<T> frameInfo;

    @Nullable
    protected T value;

    public LottieValueCallback() {
        this.frameInfo = new LottieFrameInfo<>();
        this.value = null;
    }

    @Nullable
    public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
        return this.value;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T getValueInternal(float f16, float f17, T t16, T t17, float f18, float f19, float f26) {
        return getValue(this.frameInfo.set(f16, f17, t16, t17, f18, f19, f26));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setAnimation(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animation = baseKeyframeAnimation;
    }

    public final void setValue(@Nullable T t16) {
        this.value = t16;
        BaseKeyframeAnimation<?, ?> baseKeyframeAnimation = this.animation;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.notifyListeners();
        }
    }

    public LottieValueCallback(@Nullable T t16) {
        this.frameInfo = new LottieFrameInfo<>();
        this.value = t16;
    }
}
