package com.tencent.mobileqq.activity;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f182459a;

    /* renamed from: b, reason: collision with root package name */
    private int f182460b;

    /* renamed from: c, reason: collision with root package name */
    private int f182461c;

    /* renamed from: d, reason: collision with root package name */
    private int f182462d;

    /* renamed from: e, reason: collision with root package name */
    private int f182463e;

    /* renamed from: f, reason: collision with root package name */
    private int f182464f;

    /* renamed from: g, reason: collision with root package name */
    private int f182465g;

    /* renamed from: h, reason: collision with root package name */
    private int f182466h;

    /* renamed from: i, reason: collision with root package name */
    private int f182467i;

    /* renamed from: j, reason: collision with root package name */
    private int f182468j;

    /* renamed from: k, reason: collision with root package name */
    private int f182469k;

    /* renamed from: l, reason: collision with root package name */
    private long f182470l;

    /* renamed from: m, reason: collision with root package name */
    private int f182471m;

    /* renamed from: n, reason: collision with root package name */
    private float f182472n;

    /* renamed from: o, reason: collision with root package name */
    private float f182473o;

    /* renamed from: p, reason: collision with root package name */
    private float f182474p;

    /* renamed from: q, reason: collision with root package name */
    private float f182475q;

    /* renamed from: r, reason: collision with root package name */
    private float f182476r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f182477s;

    /* renamed from: t, reason: collision with root package name */
    private Interpolator f182478t;

    /* renamed from: u, reason: collision with root package name */
    private float f182479u;

    /* renamed from: v, reason: collision with root package name */
    private float f182480v;

    /* renamed from: w, reason: collision with root package name */
    private float f182481w;

    /* renamed from: x, reason: collision with root package name */
    public final float f182482x;

    public h(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private float k(float f16) {
        float exp;
        float f17 = f16 * this.f182475q;
        if (f17 < 1.0f) {
            exp = f17 - (1.0f - ((float) Math.exp(-f17)));
        } else {
            exp = 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
        }
        return exp * this.f182476r;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.f182468j = this.f182462d;
        this.f182469k = this.f182463e;
        this.f182477s = true;
    }

    public int b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return (int) ((i3 * i3) / (this.f182482x * 2.0f));
    }

    public boolean c() {
        float interpolation;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f182477s) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.f182470l);
        if (currentAnimationTimeMillis < this.f182471m) {
            int i3 = this.f182459a;
            if (i3 != 0) {
                if (i3 == 1) {
                    float f16 = currentAnimationTimeMillis / 1000.0f;
                    float f17 = (this.f182481w * f16) - (((this.f182482x * f16) * f16) / 2.0f);
                    int round = this.f182460b + Math.round(this.f182479u * f17);
                    this.f182468j = round;
                    int min = Math.min(round, this.f182465g);
                    this.f182468j = min;
                    this.f182468j = Math.max(min, this.f182464f);
                    int round2 = this.f182461c + Math.round(f17 * this.f182480v);
                    this.f182469k = round2;
                    int min2 = Math.min(round2, this.f182467i);
                    this.f182469k = min2;
                    int max = Math.max(min2, this.f182466h);
                    this.f182469k = max;
                    if (this.f182468j == this.f182462d && max == this.f182463e) {
                        this.f182477s = true;
                    }
                }
            } else {
                float f18 = currentAnimationTimeMillis * this.f182472n;
                Interpolator interpolator = this.f182478t;
                if (interpolator == null) {
                    interpolation = k(f18);
                } else {
                    interpolation = interpolator.getInterpolation(f18);
                }
                this.f182468j = this.f182460b + Math.round(this.f182473o * interpolation);
                int round3 = this.f182461c + Math.round(interpolation * this.f182474p);
                this.f182469k = round3;
                if (this.f182468j == this.f182462d && round3 == this.f182463e) {
                    this.f182477s = true;
                }
            }
        } else {
            this.f182468j = this.f182462d;
            this.f182469k = this.f182463e;
            this.f182477s = true;
        }
        return true;
    }

    public int d(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3))).intValue();
        }
        int sqrt = (int) Math.sqrt(i3 * 2 * this.f182482x);
        if (z16) {
            return -sqrt;
        }
        return sqrt;
    }

    public void e(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28));
            return;
        }
        this.f182459a = 1;
        this.f182477s = false;
        float hypot = (float) Math.hypot(i17, i18);
        this.f182481w = hypot;
        this.f182471m = (int) ((1000.0f * hypot) / this.f182482x);
        this.f182470l = AnimationUtils.currentAnimationTimeMillis();
        this.f182460b = i3;
        this.f182461c = i16;
        float f17 = 1.0f;
        if (hypot == 0.0f) {
            f16 = 1.0f;
        } else {
            f16 = i17 / hypot;
        }
        this.f182479u = f16;
        if (hypot != 0.0f) {
            f17 = i18 / hypot;
        }
        this.f182480v = f17;
        int i29 = (int) ((hypot * hypot) / (this.f182482x * 2.0f));
        this.f182464f = i19;
        this.f182465g = i26;
        this.f182466h = i27;
        this.f182467i = i28;
        float f18 = i29;
        int round = i3 + Math.round(f16 * f18);
        this.f182462d = round;
        int min = Math.min(round, this.f182465g);
        this.f182462d = min;
        this.f182462d = Math.max(min, this.f182464f);
        int round2 = i16 + Math.round(f18 * this.f182480v);
        this.f182463e = round2;
        int min2 = Math.min(round2, this.f182467i);
        this.f182463e = min2;
        this.f182463e = Math.max(min2, this.f182466h);
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f182468j;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f182469k;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f182477s;
    }

    public void i(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            j(i3, i16, i17, i18, 250);
        }
    }

    public void j(int i3, int i16, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.f182459a = 0;
        this.f182477s = false;
        this.f182471m = i19;
        this.f182470l = AnimationUtils.currentAnimationTimeMillis();
        this.f182460b = i3;
        this.f182461c = i16;
        this.f182462d = i3 + i17;
        this.f182463e = i16 + i18;
        this.f182473o = i17;
        this.f182474p = i18;
        this.f182472n = 1.0f / this.f182471m;
        this.f182475q = 8.0f;
        this.f182476r = 1.0f;
        this.f182476r = 1.0f / k(1.0f);
    }

    public h(Context context, Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) interpolator);
            return;
        }
        this.f182479u = 0.0f;
        this.f182480v = 1.0f;
        this.f182477s = true;
        this.f182478t = interpolator;
        this.f182482x = context.getResources().getDisplayMetrics().density * 800.0f * 386.0878f * ViewConfiguration.getScrollFriction();
    }
}
