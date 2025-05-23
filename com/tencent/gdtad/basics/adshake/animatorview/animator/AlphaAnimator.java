package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AlphaAnimator extends Animator {
    private float mFromAlpha;
    private float mToAlpha;

    public AlphaAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
        super(animatorLayer);
        this.mFromAlpha = f16;
        this.mToAlpha = f17;
    }

    private float computeAlpha() {
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progress = 1.0f - progress;
        }
        float f16 = this.mFromAlpha;
        float f17 = f16 + ((this.mToAlpha - f16) * progress);
        if (f17 < 0.0f) {
            return 0.0f;
        }
        if (f17 > 1.0f) {
            return 1.0f;
        }
        return f17;
    }

    private void postAlpha(Canvas canvas, AnimatorLayer animatorLayer, int i3) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.getPaint().setAlpha(i3);
        animatorLayer.postAlpha(i3);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        if (z16 && !shouldRepeat()) {
            postAlpha(canvas, animatorLayer, (int) (this.mToAlpha * 255.0f));
        } else {
            postAlpha(canvas, animatorLayer, (int) (computeAlpha() * 255.0f));
        }
    }
}
