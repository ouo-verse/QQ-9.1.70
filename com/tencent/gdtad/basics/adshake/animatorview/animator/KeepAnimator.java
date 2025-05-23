package com.tencent.gdtad.basics.adshake.animatorview.animator;

import android.graphics.Canvas;
import com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class KeepAnimator extends Animator {
    public KeepAnimator(AnimatorLayer animatorLayer) {
        super(animatorLayer);
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator
    protected void onPostAnimation(Canvas canvas, AnimatorLayer animatorLayer, boolean z16) {
        resetMatrix(animatorLayer, animatorLayer.getMatrix());
    }
}
