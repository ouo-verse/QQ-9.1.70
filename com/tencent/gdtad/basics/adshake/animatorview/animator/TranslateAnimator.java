package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class TranslateAnimator extends Animator {
    private float mFromXDelta;
    private float mFromYDelta;
    private float mToXDelta;
    private float mToYDelta;

    public TranslateAnimator(AnimatorLayer animatorLayer, float f16, float f17, float f18, float f19) {
        super(animatorLayer);
        this.mFromXDelta = f16;
        this.mToXDelta = f17;
        this.mFromYDelta = f18;
        this.mToYDelta = f19;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        QLog.e("Animator", 1, "translte on post animaton " + System.currentTimeMillis());
        if (z16 && !shouldRepeat()) {
            postTranslate(canvas, animatorLayer, this.mToXDelta, this.mToYDelta);
            return;
        }
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progress = 1.0f - progress;
        }
        float f16 = this.mFromXDelta;
        float f17 = f16 + ((this.mToXDelta - f16) * progress);
        float f18 = this.mFromYDelta;
        postTranslate(canvas, animatorLayer, f17, f18 + ((this.mToYDelta - f18) * progress));
    }

    protected void postTranslate(Canvas canvas, AnimatorLayer animatorLayer, float f16, float f17) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.postTranslate(f16, f17);
    }
}
