package com.tencent.mobileqq.profile.view.helper;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f260544a;

    /* renamed from: b, reason: collision with root package name */
    private final int f260545b;

    /* renamed from: c, reason: collision with root package name */
    private View f260546c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f260547d;

    /* renamed from: e, reason: collision with root package name */
    private int f260548e;

    /* renamed from: f, reason: collision with root package name */
    private int f260549f;

    /* renamed from: g, reason: collision with root package name */
    private TranslateAnimation f260550g;

    /* renamed from: h, reason: collision with root package name */
    private Animation.AnimationListener f260551h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.profile.view.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class AnimationAnimationListenerC8249a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        AnimationAnimationListenerC8249a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            int random;
            int sqrt;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            if (a.this.f260547d) {
                a.this.f260547d = false;
                return;
            }
            do {
                random = (int) (a.this.f260545b * ((Math.random() * 2.0d) - 1.0d));
                sqrt = (int) Math.sqrt((a.this.f260545b * a.this.f260545b) - (random * random));
                if (Math.random() <= 0.5d) {
                    sqrt = -sqrt;
                }
            } while (((a.this.f260548e + random) * (a.this.f260548e + random)) + ((a.this.f260549f + sqrt) * (a.this.f260549f + sqrt)) > a.this.f260544a * a.this.f260544a);
            a.this.f260550g = new TranslateAnimation(a.this.f260548e, a.this.f260548e + random, a.this.f260549f, a.this.f260549f + sqrt);
            a.this.f260548e += random;
            a.this.f260549f += sqrt;
            a.this.f260550g.setAnimationListener(a.this.f260551h);
            a.this.f260550g.setDuration(a.this.f260545b * ((int) ((Math.random() * 30.0d) + 50.0d)));
            a.this.f260546c.startAnimation(a.this.f260550g);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public a(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        this.f260547d = false;
        this.f260548e = 0;
        this.f260549f = 0;
        this.f260551h = new AnimationAnimationListenerC8249a();
        if (view != null) {
            this.f260546c = view;
            int c16 = x.c(view.getContext(), 15.0f);
            this.f260544a = c16;
            this.f260545b = (int) (c16 / 1.5d);
            return;
        }
        throw new IllegalArgumentException("Wrapped View shouldn't be null!");
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f260546c.getAnimation() == this.f260550g) {
            return true;
        }
        return false;
    }

    public void n() {
        int random;
        int sqrt;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f260547d = false;
        this.f260548e = 0;
        this.f260549f = 0;
        do {
            random = (int) (this.f260545b * ((Math.random() * 2.0d) - 1.0d));
            int i17 = this.f260545b;
            sqrt = (int) Math.sqrt((i17 * i17) - (random * random));
            if (Math.random() <= 0.5d) {
                sqrt = -sqrt;
            }
            int i18 = this.f260548e;
            int i19 = (random + i18) * (i18 + random);
            int i26 = this.f260549f;
            i3 = i19 + ((sqrt + i26) * (i26 + sqrt));
            i16 = this.f260544a;
        } while (i3 > i16 * i16);
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f260548e, r3 + random, this.f260549f, r5 + sqrt);
        this.f260550g = translateAnimation;
        this.f260548e = random + this.f260548e;
        this.f260549f = sqrt + this.f260549f;
        translateAnimation.setDuration(this.f260545b * ((int) ((Math.random() * 30.0d) + 50.0d)));
        this.f260550g.setAnimationListener(this.f260551h);
        this.f260546c.startAnimation(this.f260550g);
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f260547d = true;
        if (m()) {
            this.f260546c.clearAnimation();
        }
    }
}
