package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes27.dex */
public class Peanut {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382984a;

    /* renamed from: b, reason: collision with root package name */
    public int f382985b;

    /* renamed from: c, reason: collision with root package name */
    public long f382986c;

    /* renamed from: d, reason: collision with root package name */
    public String f382987d;

    /* renamed from: e, reason: collision with root package name */
    public int f382988e;

    /* renamed from: f, reason: collision with root package name */
    public int f382989f;

    public Peanut(int i3, int i16, long j3, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f382984a = i3;
        this.f382985b = i16;
        this.f382986c = j3;
        this.f382987d = str;
        this.f382988e = i17;
        this.f382989f = i18;
    }

    public static Peanut a(int i3) {
        return new Peanut(i3, 100, -1L, "", -1, -2);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f382984a + "_" + this.f382985b + "_" + this.f382986c + "_" + this.f382988e + "_" + this.f382987d + "_" + this.f382989f;
    }

    public static Peanut a(int i3, int i16) {
        return new Peanut(i3, 200, -1L, "", -1, i16);
    }
}
