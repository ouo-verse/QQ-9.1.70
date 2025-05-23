package com.tencent.mobileqq.vasgift.view.anim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.vasgift.view.QQGiftCircleProgress;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final QQGiftCircleProgress f312089a;

    /* renamed from: b, reason: collision with root package name */
    private final ValueAnimator f312090b;

    /* renamed from: c, reason: collision with root package name */
    private g f312091c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f312092d = true;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f312093d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGiftCircleProgress f312094e;

        a(int i3, QQGiftCircleProgress qQGiftCircleProgress) {
            this.f312093d = i3;
            this.f312094e = qQGiftCircleProgress;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f312094e.setProgress((1.0f - (((Float) valueAnimator.getAnimatedValue()).floatValue() / this.f312093d)) * 100.0f);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.vasgift.view.anim.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    class C8942b implements Animator.AnimatorListener {
        C8942b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f312092d || b.this.f312091c == null) {
                return;
            }
            b.this.f312091c.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public b(QQGiftCircleProgress qQGiftCircleProgress, int i3) {
        this.f312089a = qQGiftCircleProgress;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i3);
        this.f312090b = ofFloat;
        ofFloat.setDuration(i3);
        ofFloat.addUpdateListener(new a(i3, qQGiftCircleProgress));
        ofFloat.addListener(new C8942b());
    }

    public void c() {
        this.f312092d = true;
        this.f312090b.end();
        this.f312089a.setProgress(100.0f);
    }

    public void d(g gVar) {
        this.f312091c = gVar;
    }

    public void e() {
        this.f312092d = false;
        this.f312090b.start();
    }
}
