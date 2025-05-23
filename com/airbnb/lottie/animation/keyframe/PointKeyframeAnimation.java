package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PointF point;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16) {
        return getValue((Keyframe<PointF>) keyframe, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    protected /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f16, float f17, float f18) {
        return getValue((Keyframe<PointF>) keyframe, f16, f17, f18);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public PointF getValue(Keyframe<PointF> keyframe, float f16) {
        return getValue(keyframe, f16, f16, f16);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    protected PointF getValue(Keyframe<PointF> keyframe, float f16, float f17, float f18) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = keyframe.startValue;
        if (pointF3 != null && (pointF = keyframe.endValue) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (pointF2 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF4, pointF5, f16, getLinearCurrentKeyframeProgress(), getProgress())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.point;
            float f19 = pointF4.x;
            float f26 = f19 + (f17 * (pointF5.x - f19));
            float f27 = pointF4.y;
            pointF6.set(f26, f27 + (f18 * (pointF5.y - f27)));
            return this.point;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
