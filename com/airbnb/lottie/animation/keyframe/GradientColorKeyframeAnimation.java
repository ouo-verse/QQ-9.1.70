package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int size = gradientColor != null ? gradientColor.getSize() : 0;
        this.gradientColor = new GradientColor(new float[size], new int[size]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16) {
        return getValue((Keyframe<GradientColor>) keyframe, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    GradientColor getValue(Keyframe<GradientColor> keyframe, float f16) {
        this.gradientColor.lerp(keyframe.startValue, keyframe.endValue, f16);
        return this.gradientColor;
    }
}
