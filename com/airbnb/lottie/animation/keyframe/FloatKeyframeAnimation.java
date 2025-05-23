package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    float getFloatValue(Keyframe<Float> keyframe, float f16) {
        Float f17;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (f17 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f16, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return f17.floatValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f16);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16) {
        return getValue((Keyframe<Float>) keyframe, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    Float getValue(Keyframe<Float> keyframe, float f16) {
        return Float.valueOf(getFloatValue(keyframe, f16));
    }

    public float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
