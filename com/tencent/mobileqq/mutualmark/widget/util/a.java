package com.tencent.mobileqq.mutualmark.widget.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import androidx.core.graphics.ColorUtils;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.annimation.scaleview.QUIScaleViewLayout;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private RotateAnimation f252441a;

    /* renamed from: b, reason: collision with root package name */
    private RotateAnimation f252442b;

    /* renamed from: c, reason: collision with root package name */
    private QUIShimmerImageView f252443c;

    /* renamed from: d, reason: collision with root package name */
    private QUIScaleViewLayout f252444d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(QUIShimmerImageView qUIShimmerImageView, QUIScaleViewLayout qUIScaleViewLayout, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qUIShimmerImageView, qUIScaleViewLayout, Integer.valueOf(i3));
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.f252441a = rotateAnimation;
        rotateAnimation.setRepeatCount(0);
        he0.b.m(this.f252441a, R.anim.f154983uq, 20.0f);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.f252442b = rotateAnimation2;
        rotateAnimation2.setRepeatCount(0);
        he0.b.m(this.f252442b, R.anim.f154983uq, 20.0f);
        this.f252443c = qUIShimmerImageView;
        qUIShimmerImageView.updateColors(0, ColorUtils.setAlphaComponent(i3, 153), ColorUtils.setAlphaComponent(i3, 102), 0);
        this.f252443c.updateRepeatCount(0);
        this.f252444d = qUIScaleViewLayout;
        if (qUIScaleViewLayout != null) {
            qUIScaleViewLayout.d(R.anim.f154986ut, 1);
        }
    }

    public void b(View view, View view2) {
        RotateAnimation rotateAnimation;
        RotateAnimation rotateAnimation2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) view2);
            return;
        }
        if (view != null && (rotateAnimation2 = this.f252441a) != null) {
            view.startAnimation(rotateAnimation2);
        }
        if (view2 != null && (rotateAnimation = this.f252442b) != null) {
            view2.startAnimation(rotateAnimation);
        }
    }

    public void c(Animation.AnimationListener animationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animationListener);
            return;
        }
        QUIScaleViewLayout qUIScaleViewLayout = this.f252444d;
        if (qUIScaleViewLayout == null) {
            return;
        }
        qUIScaleViewLayout.setToScale(1.1f, 1.1f);
        this.f252444d.e(animationListener);
    }

    public void d(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        QUIShimmerImageView qUIShimmerImageView = this.f252443c;
        if (qUIShimmerImageView != null && view != null) {
            qUIShimmerImageView.startShimming(null);
        }
    }
}
