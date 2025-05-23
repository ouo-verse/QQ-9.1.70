package com.tencent.mobileqq.vasgift.view.anim;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f312102a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f312103d;

        a(View view) {
            this.f312103d = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f312103d.setScaleX(floatValue);
            this.f312103d.setScaleY(floatValue);
        }
    }

    public d(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        this.f312102a = ofFloat;
        ofFloat.setDuration(100L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new a(view));
    }

    public void a() {
        this.f312102a.cancel();
        this.f312102a.reverse();
        this.f312102a.start();
    }
}
