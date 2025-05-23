package com.tencent.mobileqq.colornote.swipe;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    public static void a(View view, int i3, float f16, float f17, float f18, float f19) {
        view.setPivotX(view.getWidth());
        view.setPivotY(view.getHeight() / 2);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f16, f17);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f18, f19);
        animatorSet.setDuration(i3);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public static void b(View view, int i3, float f16, float f17, float f18, float f19, float f26, float f27) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, f16, f17);
        animatorSet.setDuration(i3);
        animatorSet.playTogether(ofFloat, ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f18, f19), ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f26, f27));
        animatorSet.start();
    }
}
