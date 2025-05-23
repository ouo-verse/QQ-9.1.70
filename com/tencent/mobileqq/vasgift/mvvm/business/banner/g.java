package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes20.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f311798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f311799d;

        a(View view) {
            this.f311799d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f311799d.setScaleX(floatValue);
            this.f311799d.setScaleY(floatValue);
        }
    }

    public g(View view, float f16, float f17) {
        b(view, f16, f17, 200L);
    }

    private void b(View view, float f16, float f17, long j3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        this.f311798a = ofFloat;
        ofFloat.setDuration(j3);
        this.f311798a.setInterpolator(new DecelerateInterpolator());
        this.f311798a.addUpdateListener(new a(view));
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f311798a.addListener(animatorListener);
    }

    public void c() {
        this.f311798a.start();
    }

    public void d() {
        this.f311798a.cancel();
        this.f311798a.reverse();
    }

    public g(View view, float f16, float f17, long j3) {
        b(view, f16, f17, j3);
    }
}
