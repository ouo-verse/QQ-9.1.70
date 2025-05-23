package com.tencent.mobileqq.widget.bounce;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.widget.f;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected float f316771a;

    /* renamed from: b, reason: collision with root package name */
    private Animator f316772b;

    /* renamed from: c, reason: collision with root package name */
    private int f316773c = 200;

    /* renamed from: d, reason: collision with root package name */
    private BounceViewPager f316774d;

    public a(BounceViewPager bounceViewPager) {
        this.f316774d = bounceViewPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        boolean z16;
        BounceViewPager bounceViewPager = this.f316774d;
        if (bounceViewPager.f316765f == 0 && this.f316771a < 0.0f) {
            return true;
        }
        if (bounceViewPager.getAdapter().getCount() - 1 == this.f316774d.getCurrentItem()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.f316771a > 0.0f) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        Animator animator = this.f316772b;
        if (animator != null && animator.isRunning()) {
            this.f316772b.addListener(new b());
            this.f316772b.cancel();
        } else {
            d();
        }
    }

    public void c(float f16) {
        this.f316771a = f16;
        this.f316774d.c();
    }

    protected void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f316774d, "Pull", this.f316771a, 0.0f);
        this.f316772b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        this.f316772b.setDuration(this.f316773c * Math.abs(-this.f316771a));
        this.f316772b.addListener(new C8990a());
        this.f316772b.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.bounce.a$a, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public class C8990a extends f {
        C8990a() {
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

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.d();
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
