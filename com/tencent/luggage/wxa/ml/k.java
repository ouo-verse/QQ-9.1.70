package com.tencent.luggage.wxa.ml;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public View f134755a;

    /* renamed from: b, reason: collision with root package name */
    public int f134756b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f134757c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f134758a;

        public a(Runnable runnable) {
            this.f134758a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            k.this.f134757c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable = this.f134758a;
            if (runnable != null) {
                runnable.run();
            }
            k.this.f134757c = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (k.this.f134755a != null) {
                k.this.f134755a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    public k(View view) {
        this.f134755a = view;
    }

    public boolean b() {
        ValueAnimator valueAnimator = this.f134757c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return true;
        }
        return false;
    }

    public void a(int i3, Runnable runnable) {
        if (this.f134755a == null) {
            return;
        }
        if (b() && this.f134756b == i3) {
            return;
        }
        this.f134756b = i3;
        if ((this.f134755a.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.f134755a.getBackground()).getColor() == i3) {
            if (runnable != null) {
                runnable.run();
            }
            ValueAnimator valueAnimator = this.f134757c;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                return;
            }
            return;
        }
        a aVar = new a(runnable);
        ValueAnimator valueAnimator2 = this.f134757c;
        if (valueAnimator2 != null && valueAnimator2.isStarted() && this.f134757c.isRunning() && this.f134756b == i3) {
            this.f134757c.addListener(aVar);
            return;
        }
        ValueAnimator valueAnimator3 = this.f134757c;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f134755a.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.f134755a.getBackground()).getColor() : 0), Integer.valueOf(this.f134756b));
        this.f134757c = ofObject;
        ofObject.addListener(aVar);
        this.f134757c.addUpdateListener(new b());
        this.f134757c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f134757c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
