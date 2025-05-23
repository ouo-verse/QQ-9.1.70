package com.tencent.mtgpa.haptic.android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f336880a;

    /* renamed from: b, reason: collision with root package name */
    int f336881b;

    /* renamed from: c, reason: collision with root package name */
    int f336882c;

    /* renamed from: d, reason: collision with root package name */
    int f336883d;

    /* renamed from: e, reason: collision with root package name */
    int f336884e;

    /* renamed from: f, reason: collision with root package name */
    public long f336885f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f336886g;

    /* renamed from: h, reason: collision with root package name */
    int f336887h;

    /* renamed from: i, reason: collision with root package name */
    public int f336888i;

    public a(String str, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f336886g = true;
        this.f336880a = str;
        this.f336881b = i3;
        this.f336882c = i16;
        this.f336883d = i17;
        this.f336884e = i18;
        this.f336888i = 0;
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f336883d;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f336884e;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f336882c;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f336881b;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f336880a;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f336887h;
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f336887h = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "PatternPlayerLooperInfo{mPattern='" + this.f336880a + "', mLoop=" + this.f336881b + ", mInterval=" + this.f336882c + ", mAmplitude=" + this.f336883d + ", mFreq=" + this.f336884e + ", mWhen=" + this.f336885f + ", mValid=" + this.f336886g + ", mPatternLastTime=" + this.f336887h + ", mHasVibNum=" + this.f336888i + '}';
    }
}
