package com.qzone.component;

import android.R;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

/* compiled from: P */
/* loaded from: classes39.dex */
class ActionSheetDialog$1 implements Runnable {
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        b.P(null).setVisibility(0);
        b.O(null).setVisibility(0);
        b.R(null, new TranslateAnimation(0.0f, 0.0f, b.P(null).getHeight(), 0.0f));
        b.N(null).setFillEnabled(true);
        b.N(null).setInterpolator(AnimationUtils.loadInterpolator(b.Q(null), R.anim.decelerate_interpolator));
        b.N(null).setDuration(400L);
        b.P(null).startAnimation(b.N(null));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillEnabled(true);
        alphaAnimation.setDuration(200L);
        b.O(null).startAnimation(alphaAnimation);
    }
}
