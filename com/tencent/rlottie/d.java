package com.tencent.rlottie;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rlottie.AXrLottieDrawable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f365197a;

    /* renamed from: b, reason: collision with root package name */
    int f365198b;

    /* renamed from: c, reason: collision with root package name */
    int f365199c;

    /* renamed from: d, reason: collision with root package name */
    boolean f365200d;

    /* renamed from: e, reason: collision with root package name */
    boolean f365201e;

    /* renamed from: f, reason: collision with root package name */
    boolean f365202f;

    /* renamed from: g, reason: collision with root package name */
    int f365203g;

    /* renamed from: h, reason: collision with root package name */
    int f365204h;

    /* renamed from: i, reason: collision with root package name */
    int f365205i;

    /* renamed from: j, reason: collision with root package name */
    int f365206j;

    /* renamed from: k, reason: collision with root package name */
    AXrLottieDrawable.c f365207k;

    /* renamed from: l, reason: collision with root package name */
    boolean f365208l;

    /* renamed from: m, reason: collision with root package name */
    float f365209m;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f365198b = -100;
        this.f365199c = -100;
        this.f365200d = true;
        this.f365201e = false;
        this.f365202f = true;
        this.f365203g = -100;
        this.f365204h = -100;
        this.f365205i = -100;
        this.f365206j = -100;
        this.f365207k = null;
        this.f365209m = -1.0f;
        a(a.a());
    }

    public d a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (d) iPatchRedirector.redirect((short) 17, (Object) this, (Object) dVar);
        }
        if (dVar != null && dVar != this) {
            this.f365197a = dVar.f365197a;
            this.f365198b = dVar.f365198b;
            this.f365199c = dVar.f365199c;
            this.f365200d = dVar.f365200d;
            this.f365201e = dVar.f365201e;
            this.f365202f = dVar.f365202f;
            this.f365203g = dVar.f365203g;
            this.f365204h = dVar.f365204h;
            this.f365205i = dVar.f365205i;
            this.f365206j = dVar.f365206j;
            this.f365207k = dVar.f365207k;
            this.f365208l = dVar.f365208l;
            this.f365209m = dVar.f365209m;
        }
        return this;
    }

    public AXrLottieDrawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AXrLottieDrawable) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        throw new RuntimeException("Can't build an AXrLottieDrawable from AXrLottieOptions!");
    }

    public d c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (d) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
        this.f365202f = z16;
        return this;
    }

    public d d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (d) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        this.f365206j = i3;
        return this;
    }

    public d e(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (d) iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
        if (z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        return d(i3);
    }

    public d f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        this.f365200d = z16;
        return this;
    }

    public d g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str)) {
                return this;
            }
            throw new NullPointerException("lottie name (cacheName) can not be null!");
        }
        this.f365197a = str;
        return this;
    }

    public d h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (d) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.f365201e = z16;
        return this;
    }

    public d i(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i3 > 0 && i16 > 0) {
            this.f365198b = i3;
            this.f365199c = i16;
            return this;
        }
        throw new RuntimeException("lottie width and height must be > 0");
    }
}
