package com.tencent.qqmini.sdk.core.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EditAreaAnimatorUtil {
    public static final int EDIT_DURATION = 100;

    public static void editAreaAnimator(View view, float f16, float f17, float f18, float f19) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f16, f17);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f18, f19);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f18, f19);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(100L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.qqmini.sdk.core.utils.EditAreaAnimatorUtil.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        animatorSet.start();
    }
}
