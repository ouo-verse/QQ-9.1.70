package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    int getIntValue(Keyframe<Integer> keyframe, float f16) {
        Integer num;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), keyframe.startValue, keyframe.endValue, f16, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return num.intValue();
            }
            return MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f16);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16) {
        return getValue((Keyframe<Integer>) keyframe, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    Integer getValue(Keyframe<Integer> keyframe, float f16) {
        return Integer.valueOf(getIntValue(keyframe, f16));
    }

    public int getIntValue() {
        return getIntValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
