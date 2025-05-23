package com.tencent.mobileqq.pad;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f257079a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f257080b;

    /* renamed from: c, reason: collision with root package name */
    private LaunchMode f257081c;

    /* renamed from: d, reason: collision with root package name */
    private int f257082d;

    /* renamed from: e, reason: collision with root package name */
    private int f257083e;

    /* renamed from: f, reason: collision with root package name */
    private int f257084f;

    /* renamed from: g, reason: collision with root package name */
    private int f257085g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f257086h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f257087i;

    /* renamed from: j, reason: collision with root package name */
    private String f257088j;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f257079a = false;
        this.f257080b = true;
        this.f257081c = LaunchMode.standard;
    }

    public LaunchParam a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (LaunchParam) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new LaunchParam(this.f257079a, this.f257080b, this.f257081c, this.f257082d, this.f257083e, this.f257084f, this.f257085g, this.f257086h, this.f257087i, this.f257088j);
    }

    @Deprecated
    public b b(@AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.f257082d = i3;
        this.f257083e = i16;
        this.f257084f = 0;
        this.f257085g = 0;
        return this;
    }

    public b c(@AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i16, @AnimRes @AnimatorRes int i17, @AnimRes @AnimatorRes int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
        this.f257082d = i3;
        this.f257083e = i16;
        this.f257084f = i17;
        this.f257085g = i18;
        return this;
    }

    public b d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        this.f257088j = str;
        return this;
    }

    public b e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
        this.f257079a = z16;
        return this;
    }

    public b f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
        this.f257087i = z16;
        return this;
    }

    public b g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        this.f257080b = z16;
        return this;
    }

    public b h(LaunchMode launchMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) launchMode);
        }
        this.f257081c = launchMode;
        return this;
    }

    public b i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, z16);
        }
        this.f257086h = z16;
        return this;
    }
}
