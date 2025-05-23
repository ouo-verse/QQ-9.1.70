package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Animatable;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements Animatable {
    private ImageView C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f198793d;

    /* renamed from: e, reason: collision with root package name */
    private int f198794e;

    /* renamed from: f, reason: collision with root package name */
    private int f198795f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f198796h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f198797i;

    /* renamed from: m, reason: collision with root package name */
    private Animator.AnimatorListener f198798m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C7408a implements ValueAnimator.AnimatorUpdateListener {
        C7408a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.b(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public a(int[] iArr, ImageView imageView, int i3) {
        this(0, iArr, imageView, i3);
    }

    private void a() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f198793d.length - 1);
        this.f198796h = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        this.f198796h.setDuration(400L);
        this.f198797i = new C7408a();
        this.f198798m = new b();
    }

    private void e(Animator.AnimatorListener animatorListener) {
        this.f198796h.addUpdateListener(this.f198797i);
        if (animatorListener != null) {
            this.f198796h.addListener(animatorListener);
        }
        this.f198796h.start();
    }

    public void b(int i3) {
        int length;
        this.f198794e = i3;
        if (this.D) {
            length = i3 % this.f198793d.length;
        } else {
            int[] iArr = this.f198793d;
            length = (iArr.length - (i3 % iArr.length)) - 1;
        }
        this.C.setImageResource(this.f198793d[length]);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.f198796h.isStarted()) {
            return;
        }
        e(animatorListener);
    }

    public void f(boolean z16, Animator.AnimatorListener animatorListener) {
        stop();
        this.D = z16;
        if (z16) {
            this.f198795f = this.f198793d.length - 1;
        } else {
            this.f198795f = 0;
        }
        d(animatorListener);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f198796h.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        e(null);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        ValueAnimator valueAnimator = this.f198796h;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.f198796h.end();
        }
        ValueAnimator valueAnimator2 = this.f198796h;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f198796h.removeAllListeners();
        }
        this.f198794e = this.f198795f;
    }

    public a(int i3, int[] iArr, ImageView imageView, int i16) {
        this.f198793d = iArr;
        this.C = imageView;
        if (iArr.length > 0) {
            imageView.setImageResource(iArr[i16]);
            this.f198794e = i16;
            this.f198795f = i16;
            a();
            return;
        }
        throw new RuntimeException(" FrameAnimDrawable RES_IDS can not empty !!!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
