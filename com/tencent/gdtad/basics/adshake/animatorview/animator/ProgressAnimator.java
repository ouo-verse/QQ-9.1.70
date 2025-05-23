package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* loaded from: classes6.dex */
public class ProgressAnimator extends Animator {
    private float mFromProgress;
    private float mToProgress;

    public ProgressAnimator(AnimatorLayer animatorLayer, float f16, float f17) {
        super(animatorLayer);
        this.mFromProgress = f16;
        this.mToProgress = f17;
    }

    private float getProgressDiff() {
        return this.mToProgress - this.mFromProgress;
    }

    private void postProgress(Canvas canvas, AnimatorLayer animatorLayer, float f16) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
        animatorLayer.postProgress(f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float computeProgress() {
        float progressDiff;
        float f16;
        float progress = getProgress();
        TimeInterpolator timeInterpolator = this.mInterpolator;
        if (timeInterpolator != null) {
            progress = timeInterpolator.getInterpolation(progress);
        }
        if (getRepeatMode() == 2 && getRepeatIndex() % 2 != 0) {
            progressDiff = getProgressDiff() * (1.0f - progress);
            f16 = this.mFromProgress;
        } else {
            progressDiff = getProgressDiff() * progress;
            f16 = this.mFromProgress;
        }
        return progressDiff + f16;
    }

    public float getToProgress() {
        return this.mToProgress;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        if (z16 && !shouldRepeat()) {
            postProgress(canvas, animatorLayer, this.mToProgress);
        } else {
            postProgress(canvas, animatorLayer, computeProgress());
        }
    }

    public void setFromProgress(float f16) {
        this.mFromProgress = f16;
    }

    public void setToProgress(float f16) {
        this.mToProgress = f16;
    }
}
