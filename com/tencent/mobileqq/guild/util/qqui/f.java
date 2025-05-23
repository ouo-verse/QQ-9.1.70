package com.tencent.mobileqq.guild.util.qqui;

import android.view.View;
import android.view.animation.AlphaAnimation;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f {
    public static void a(View view) {
        if (view.isEnabled()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
        }
    }

    public static void b(View view) {
        if (view.isEnabled()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
        }
    }
}
