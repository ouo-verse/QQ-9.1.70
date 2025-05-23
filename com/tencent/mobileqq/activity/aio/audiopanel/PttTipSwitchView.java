package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ViewSwitcher;

/* loaded from: classes10.dex */
public class PttTipSwitchView extends ViewSwitcher {

    /* renamed from: d, reason: collision with root package name */
    private Context f178292d;

    /* renamed from: e, reason: collision with root package name */
    private AnimationSet f178293e;

    /* renamed from: f, reason: collision with root package name */
    private AnimationSet f178294f;

    /* renamed from: h, reason: collision with root package name */
    private AnimationSet f178295h;

    /* renamed from: i, reason: collision with root package name */
    private AnimationSet f178296i;

    public PttTipSwitchView(Context context) {
        this(context, null);
    }

    private AnimationSet a(float f16, float f17) {
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, f16, 2, f17);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(false);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        animationSet.addAnimation(translateAnimation);
        return animationSet;
    }

    private void b() {
        this.f178293e = a(1.0f, 0.0f);
        this.f178294f = a(0.0f, -1.0f);
        this.f178295h = a(-1.0f, 0.0f);
        this.f178296i = a(0.0f, 1.0f);
        setInAnimation(this.f178293e);
        setOutAnimation(this.f178294f);
    }

    public void c() {
        Animation inAnimation = getInAnimation();
        AnimationSet animationSet = this.f178293e;
        if (inAnimation != animationSet) {
            setInAnimation(animationSet);
        }
        Animation outAnimation = getOutAnimation();
        AnimationSet animationSet2 = this.f178294f;
        if (outAnimation != animationSet2) {
            setOutAnimation(animationSet2);
        }
        showNext();
    }

    public PttTipSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178292d = context;
        b();
    }
}
