package com.airbnb.lottie.animation.keyframe;

import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {
    private final A valueCallbackValue;

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback) {
        this(lottieValueCallback, null);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    float getEndProgress() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public A getValue() {
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        A a16 = this.valueCallbackValue;
        return lottieValueCallback.getValueInternal(0.0f, 0.0f, a16, a16, getProgress(), getProgress(), getProgress());
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void notifyListeners() {
        if (this.valueCallback != null) {
            super.notifyListeners();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public void setProgress(float f16) {
        this.progress = f16;
    }

    public ValueCallbackKeyframeAnimation(LottieValueCallback<A> lottieValueCallback, @Nullable A a16) {
        super(Collections.emptyList());
        setValueCallback(lottieValueCallback);
        this.valueCallbackValue = a16;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    A getValue(Keyframe<K> keyframe, float f16) {
        return getValue();
    }
}
