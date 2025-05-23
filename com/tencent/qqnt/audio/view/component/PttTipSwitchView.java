package com.tencent.qqnt.audio.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewSwitcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes23.dex */
public class PttTipSwitchView extends ViewSwitcher {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AnimationSet f352639d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationSet f352640e;

    /* renamed from: f, reason: collision with root package name */
    private AnimationSet f352641f;

    /* renamed from: h, reason: collision with root package name */
    private AnimationSet f352642h;

    public PttTipSwitchView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private AnimationSet a(float f16, float f17) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, f16, 2, f17);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(false);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private void b() {
        this.f352639d = a(1.0f, 0.0f);
        this.f352640e = a(0.0f, -1.0f);
        this.f352641f = a(-1.0f, 0.0f);
        this.f352642h = a(0.0f, 1.0f);
        setInAnimation(this.f352639d);
        setOutAnimation(this.f352640e);
    }

    public PttTipSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            b();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
