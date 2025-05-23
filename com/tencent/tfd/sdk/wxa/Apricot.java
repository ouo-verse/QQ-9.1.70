package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Apricot {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f375396a;

    /* renamed from: b, reason: collision with root package name */
    public int f375397b;

    /* renamed from: c, reason: collision with root package name */
    public long f375398c;

    /* renamed from: d, reason: collision with root package name */
    public String f375399d;

    /* renamed from: e, reason: collision with root package name */
    public int f375400e;

    /* renamed from: f, reason: collision with root package name */
    public int f375401f;

    public Apricot(int i3, int i16, long j3, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f375396a = i3;
        this.f375397b = i16;
        this.f375398c = j3;
        this.f375399d = str;
        this.f375400e = i17;
        this.f375401f = i18;
    }

    public static Apricot a(int i3) {
        return new Apricot(i3, 100, -1L, "", -1, -2);
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f375396a + "_" + this.f375397b + "_" + this.f375398c + "_" + this.f375400e + "_" + this.f375399d + "_" + this.f375401f;
    }

    public static Apricot a(int i3, int i16) {
        return new Apricot(i3, 200, -1L, "", -1, i16);
    }
}
