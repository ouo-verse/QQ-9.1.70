package com.qzone.homepage.ui.woo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.widget.aa;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends aa implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    private static final int E = ar.d(45.0f);
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final HorizontalScrollView f47852d;

    /* renamed from: e, reason: collision with root package name */
    private final TextView f47853e;

    /* renamed from: f, reason: collision with root package name */
    private final TextView f47854f;

    /* renamed from: h, reason: collision with root package name */
    private final int f47855h;

    /* renamed from: i, reason: collision with root package name */
    private final C0397a f47856i;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f47857m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.qzone.homepage.ui.woo.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class C0397a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C0397a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a.this.f47852d.scrollTo(0, 0);
            a.this.f47854f.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            a.this.f47852d.scrollTo(0, 0);
            a.this.f47854f.setVisibility(0);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (intValue < 0) {
                return;
            }
            a.this.f47852d.scrollTo(intValue, 0);
        }
    }

    public a(View view) {
        super(view);
        this.f47856i = new C0397a();
        this.C = false;
        this.D = false;
        this.f47855h = getResources().getDimensionPixelSize(R.dimen.f159130wh);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.ena);
        this.f47852d = horizontalScrollView;
        this.f47853e = (TextView) findViewById(R.id.en9);
        this.f47854f = (TextView) findViewById(R.id.en_);
        horizontalScrollView.setOnTouchListener(this);
    }

    public void e() {
        f();
        if (!this.C) {
            this.D = true;
            return;
        }
        this.D = false;
        int width = this.f47852d.getWidth();
        int width2 = this.f47853e.getWidth();
        if (width2 - width < 1) {
            return;
        }
        Log.i("MarqueeDirector", "startAnim: ");
        if (this.C) {
            ValueAnimator ofInt = ValueAnimator.ofInt(-E, width2 + this.f47855h);
            this.f47857m = ofInt;
            ofInt.setDuration(((r3 * 1000) / r4) + 1);
            this.f47857m.addListener(this.f47856i);
            this.f47857m.addUpdateListener(this.f47856i);
            this.f47857m.setRepeatCount(-1);
            this.f47857m.start();
        }
    }

    public void f() {
        ValueAnimator valueAnimator = this.f47857m;
        if (valueAnimator == null) {
            return;
        }
        valueAnimator.cancel();
        this.f47857m = null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f47853e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        Log.i("MarqueeDirector", "onGlobalLayout: ");
        this.C = true;
        if (this.D) {
            e();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public void c(String str) {
        this.C = false;
        this.f47853e.setText(str);
        this.f47854f.setText(str);
        this.f47853e.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
}
