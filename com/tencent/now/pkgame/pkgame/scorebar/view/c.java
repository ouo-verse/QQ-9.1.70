package com.tencent.now.pkgame.pkgame.scorebar.view;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private AnimationSet f339091a;

    /* renamed from: b, reason: collision with root package name */
    private AnimationSet f339092b;

    public void a() {
        AnimationSet animationSet = this.f339091a;
        if (animationSet != null) {
            animationSet.cancel();
        }
        AnimationSet animationSet2 = this.f339092b;
        if (animationSet2 != null) {
            animationSet2.cancel();
        }
    }

    public void b(View view, Animation.AnimationListener animationListener) {
        view.setVisibility(4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(100L);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.1f, 1, 0.2f);
        translateAnimation.setDuration(400L);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.3f);
        translateAnimation2.setStartOffset(500L);
        translateAnimation2.setDuration(400L);
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.1f);
        translateAnimation3.setStartOffset(900L);
        translateAnimation3.setDuration(400L);
        AnimationSet animationSet = new AnimationSet(true);
        this.f339092b = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.f339092b.addAnimation(translateAnimation);
        this.f339092b.addAnimation(translateAnimation2);
        this.f339092b.addAnimation(translateAnimation3);
        this.f339092b.setStartOffset(200L);
        this.f339092b.setFillAfter(true);
        this.f339092b.setAnimationListener(animationListener);
        view.startAnimation(this.f339092b);
    }

    public void c(View view, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 0.3f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        AnimationSet animationSet = new AnimationSet(true);
        this.f339091a = animationSet;
        animationSet.addAnimation(translateAnimation);
        this.f339091a.addAnimation(alphaAnimation);
        this.f339091a.setDuration(400L);
        this.f339091a.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f339091a.setAnimationListener(animationListener);
        view.startAnimation(this.f339091a);
    }
}
