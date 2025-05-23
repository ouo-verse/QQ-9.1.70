package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f16, Float f17) {
        super(f16, f17);
    }

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue, com.airbnb.lottie.value.LottieValueCallback
    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedFloatValue(Float f16, Float f17, Interpolator interpolator) {
        super(f16, f17, interpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    public Float interpolateValue(Float f16, Float f17, float f18) {
        return Float.valueOf(MiscUtils.lerp(f16.floatValue(), f17.floatValue(), f18));
    }
}
