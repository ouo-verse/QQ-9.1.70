package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    private final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.scaleXY = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16) {
        return getValue((Keyframe<ScaleXY>) keyframe, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public ScaleXY getValue(Keyframe<ScaleXY> keyframe, float f16) {
        ScaleXY scaleXY;
        ScaleXY scaleXY2;
        ScaleXY scaleXY3 = keyframe.startValue;
        if (scaleXY3 != null && (scaleXY = keyframe.endValue) != null) {
            ScaleXY scaleXY4 = scaleXY3;
            ScaleXY scaleXY5 = scaleXY;
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (scaleXY2 = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY4, scaleXY5, f16, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return scaleXY2;
            }
            this.scaleXY.set(MiscUtils.lerp(scaleXY4.getScaleX(), scaleXY5.getScaleX(), f16), MiscUtils.lerp(scaleXY4.getScaleY(), scaleXY5.getScaleY(), f16));
            return this.scaleXY;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
