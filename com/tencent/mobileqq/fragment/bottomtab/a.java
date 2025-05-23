package com.tencent.mobileqq.fragment.bottomtab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final long f211359a;

    /* renamed from: b, reason: collision with root package name */
    private final View f211360b;

    /* renamed from: c, reason: collision with root package name */
    private final String f211361c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.fragment.bottomtab.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class C7631a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f211362d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f211363e;

        C7631a(LinearLayout.LayoutParams layoutParams, int i3) {
            this.f211362d = layoutParams;
            this.f211363e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, layoutParams, Integer.valueOf(i3));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f211362d.width = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f211363e);
            a.this.f211360b.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f211365d;

        b(LinearLayout.LayoutParams layoutParams) {
            this.f211365d = layoutParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) layoutParams);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            this.f211365d.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f211360b.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f211367d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f211368e;

        c(LinearLayout.LayoutParams layoutParams, float f16) {
            this.f211367d = layoutParams;
            this.f211368e = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, layoutParams, Float.valueOf(f16));
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f211367d.width = (int) (floatValue * this.f211368e);
            a.this.f211360b.requestLayout();
        }
    }

    public a(View view, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) str);
            return;
        }
        this.f211359a = 120L;
        this.f211360b = view;
        this.f211361c = str;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f211360b.getLayoutParams();
        float f16 = layoutParams.width;
        if (f16 == 0.0f) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(120L);
        ofFloat.addUpdateListener(new c(layoutParams, f16));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f211360b, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f211360b, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f211360b, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(120L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f211360b.getLayoutParams();
        float f16 = layoutParams.width;
        if (f16 == 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new C7631a(layoutParams, i3));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f211360b, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f211360b, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f211360b, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(120L);
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            animatorSet.start();
            return;
        }
        float f17 = i3;
        if (f16 == f17) {
            return;
        }
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(f16, f17);
        ofFloat5.addUpdateListener(new b(layoutParams));
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(120L);
        animatorSet2.play(ofFloat5);
        animatorSet2.start();
    }
}
