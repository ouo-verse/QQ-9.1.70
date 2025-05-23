package com.tencent.mobileqq.widget.annimation.scaleview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.mobileqq.R;
import he0.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f316659a;

    /* renamed from: b, reason: collision with root package name */
    private ScaleAnimation f316660b;

    /* renamed from: c, reason: collision with root package name */
    private int f316661c = R.anim.f154986ut;

    /* renamed from: d, reason: collision with root package name */
    private int f316662d = 3;

    public void a() {
        View view = this.f316659a;
        if (view != null && this.f316660b != null) {
            view.clearAnimation();
            this.f316660b.cancel();
        }
    }

    public a b(int i3, int i16) {
        this.f316661c = i3;
        if (i16 > 0) {
            this.f316662d = i16;
        }
        ScaleAnimation scaleAnimation = this.f316660b;
        if (scaleAnimation != null) {
            b.m(scaleAnimation, i3, this.f316662d);
        }
        return this;
    }

    public a c(int i3) {
        ScaleAnimation scaleAnimation = this.f316660b;
        if (scaleAnimation != null) {
            scaleAnimation.setRepeatCount(i3);
        }
        return this;
    }

    public a d(float f16, float f17, float f18, float f19) {
        if (this.f316659a == null) {
            return this;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(f16, f17, f18, f19, this.f316659a.getWidth() / 2, this.f316659a.getHeight() / 2);
        this.f316660b = scaleAnimation;
        b.m(scaleAnimation, this.f316661c, this.f316662d);
        this.f316660b.setFillAfter(true);
        this.f316660b.setFillBefore(true);
        this.f316660b.setRepeatMode(2);
        return this;
    }

    public a e(View view) {
        this.f316659a = view;
        return this;
    }

    public boolean f(Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation;
        if (this.f316659a != null && (scaleAnimation = this.f316660b) != null) {
            scaleAnimation.setRepeatCount(1);
            if (animationListener != null) {
                this.f316660b.setAnimationListener(animationListener);
            }
            this.f316659a.startAnimation(this.f316660b);
            return true;
        }
        return false;
    }
}
