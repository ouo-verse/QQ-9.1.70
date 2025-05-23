package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ad {
    public static void a(View view, int i3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i3);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new a(view));
        view.setVisibility(8);
        view.startAnimation(alphaAnimation);
    }

    public static void b(View view, boolean z16, int i3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i3);
        if (z16) {
            alphaAnimation.setStartOffset(500L);
        }
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b(view));
        view.startAnimation(alphaAnimation);
        view.setVisibility(0);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f67932d;

        a(View view) {
            this.f67932d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f67932d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f67933d;

        b(View view) {
            this.f67933d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f67933d.setAnimation(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
