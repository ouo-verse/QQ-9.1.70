package com.tencent.mobileqq.vasgift.view.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f312105a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f312106d;

        a(View view) {
            this.f312106d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f312106d.setScaleX(floatValue);
            this.f312106d.setScaleY(floatValue);
        }
    }

    public e(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.2f, 1.0f);
        this.f312105a = ofFloat;
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new a(view));
    }

    public void a() {
        this.f312105a.start();
    }

    public void b() {
        this.f312105a.cancel();
    }
}
