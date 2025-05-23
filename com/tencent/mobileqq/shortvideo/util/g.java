package com.tencent.mobileqq.shortvideo.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    public static void a(View view, float f16, float f17, float f18, float f19, int i3, float f26, float f27) {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f26, f27);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, f16, 0, f17, 0, f18, 0, f19);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(i3);
        animationSet.setFillEnabled(true);
        animationSet.setFillBefore(true);
        animationSet.setFillAfter(true);
        view.startAnimation(animationSet);
    }
}
