package com.qzone.component;

import android.R;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

/* compiled from: P */
/* loaded from: classes39.dex */
class ActionSheetDialog$3 implements Runnable {
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        b.R(null, new TranslateAnimation(0.0f, 0.0f, 0.0f, b.P(null).getHeight()));
        b.N(null).setInterpolator(AnimationUtils.loadInterpolator(b.Q(null), R.anim.decelerate_interpolator));
        b.N(null).setDuration(200L);
        b.N(null).setFillAfter(true);
        b.P(null).startAnimation(b.N(null));
        b.N(null).setAnimationListener(new a());
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            try {
                ActionSheetDialog$3.this.getClass();
                b.U(null);
                ActionSheetDialog$3.this.getClass();
                b.S(null, true);
            } catch (Exception unused) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
