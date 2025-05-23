package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* compiled from: P */
/* loaded from: classes.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    /* JADX WARN: Multi-variable type inference failed */
    public Integer getOffset(LottieFrameInfo<Integer> lottieFrameInfo) {
        T t16 = this.value;
        if (t16 != 0) {
            return (Integer) t16;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public Integer getValue(LottieFrameInfo<Integer> lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.lerp(lottieFrameInfo.getStartValue().intValue(), lottieFrameInfo.getEndValue().intValue(), lottieFrameInfo.getInterpolatedKeyframeProgress()) + getOffset(lottieFrameInfo).intValue());
    }
}
