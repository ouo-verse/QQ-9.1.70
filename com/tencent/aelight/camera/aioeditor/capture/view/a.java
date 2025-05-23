package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.widget.f;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static final Interpolator f67334d = new LinearInterpolator();

    /* renamed from: a, reason: collision with root package name */
    private final View f67335a;

    /* renamed from: b, reason: collision with root package name */
    private ValueAnimator f67336b = null;

    /* renamed from: c, reason: collision with root package name */
    private final b f67337c;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final View f67340d;

        /* renamed from: e, reason: collision with root package name */
        float f67341e = 1.0f;

        b(View view) {
            this.f67340d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f67341e = floatValue;
            this.f67340d.invalidate();
            if (QLog.isColorLevel()) {
                QLog.d("PressScaleAnimDelegate ", 2, "do scale animtion, scale=" + floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(View view) {
        this.f67335a = view;
        this.f67337c = new b(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ValueAnimator valueAnimator = this.f67336b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f67336b.removeUpdateListener(this.f67337c);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.75f, 0.5f, 0.75f, 1.0f);
        this.f67336b = ofFloat;
        ofFloat.setDuration(200L);
        this.f67336b.setInterpolator(f67334d);
        this.f67336b.addUpdateListener(this.f67337c);
        this.f67336b.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Canvas canvas) {
        int paddingLeft = this.f67335a.getPaddingLeft();
        int right = (this.f67335a.getRight() - this.f67335a.getLeft()) - this.f67335a.getPaddingRight();
        int i3 = (paddingLeft + right) / 2;
        int paddingTop = (this.f67335a.getPaddingTop() + ((this.f67335a.getBottom() - this.f67335a.getTop()) - this.f67335a.getPaddingBottom())) / 2;
        float f16 = this.f67337c.f67341e;
        canvas.scale(f16, f16, i3, paddingTop);
        if (QLog.isColorLevel()) {
            QLog.d("PressScaleAnimDelegate ", 2, "draw, left=" + paddingLeft + ",right=" + right + ",centerX=" + i3 + ",centerY=" + paddingTop + ",scale=" + this.f67337c.f67341e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f67337c.f67341e != 1.0f;
    }

    public static void d(View view, long j3, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.75f, 0.5f, 0.75f, 1.0f);
        C0582a c0582a = new C0582a(view, onClickListener);
        ofFloat.setDuration(j3);
        ofFloat.setInterpolator(f67334d);
        ofFloat.addUpdateListener(c0582a);
        ofFloat.addListener(c0582a);
        ofFloat.start();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    private static final class C0582a extends f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final View f67338d;

        /* renamed from: e, reason: collision with root package name */
        final View.OnClickListener f67339e;

        C0582a(View view, View.OnClickListener onClickListener) {
            this.f67338d = view;
            this.f67339e = onClickListener;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View.OnClickListener onClickListener = this.f67339e;
            if (onClickListener != null) {
                onClickListener.onClick(this.f67338d);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f67338d.setScaleX(floatValue);
            this.f67338d.setScaleY(floatValue);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
