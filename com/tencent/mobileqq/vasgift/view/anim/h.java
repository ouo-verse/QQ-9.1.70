package com.tencent.mobileqq.vasgift.view.anim;

import android.animation.ValueAnimator;
import com.tencent.mobileqq.vasgift.view.QQGiftCircleProgress;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f312109a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f312110d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGiftCircleProgress f312111e;

        a(float f16, QQGiftCircleProgress qQGiftCircleProgress) {
            this.f312110d = f16;
            this.f312111e = qQGiftCircleProgress;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction() + this.f312110d;
            if (animatedFraction <= 1.0f) {
                this.f312111e.setProgress(animatedFraction * 100.0f);
            } else {
                h.this.a();
            }
        }
    }

    public h(QQGiftCircleProgress qQGiftCircleProgress, long j3, float f16) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        this.f312109a = ofFloat;
        ofFloat.setDuration(j3 * 1000);
        ofFloat.addUpdateListener(new a((f16 * 1.0f) / 100.0f, qQGiftCircleProgress));
    }

    public void a() {
        ValueAnimator valueAnimator = this.f312109a;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f312109a.cancel();
        }
    }

    public void b() {
        ValueAnimator valueAnimator = this.f312109a;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }
}
