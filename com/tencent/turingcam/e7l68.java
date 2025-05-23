package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class e7l68 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f382200a;

    /* renamed from: b, reason: collision with root package name */
    public int f382201b;

    /* renamed from: c, reason: collision with root package name */
    public long f382202c;

    /* renamed from: d, reason: collision with root package name */
    public String f382203d;

    /* renamed from: e, reason: collision with root package name */
    public int f382204e;

    /* renamed from: f, reason: collision with root package name */
    public int f382205f;

    public e7l68(int i3, int i16, long j3, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str, Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f382200a = i3;
        this.f382201b = i16;
        this.f382202c = j3;
        this.f382203d = str;
        this.f382204e = i17;
        this.f382205f = i18;
    }

    public static e7l68 a(int i3) {
        return new e7l68(i3, 100, -1L, "", -1, -2);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f382200a + "_" + this.f382201b + "_" + this.f382202c + "_" + this.f382204e + "_" + this.f382203d + "_" + this.f382205f;
    }

    public static e7l68 a(int i3, int i16) {
        return new e7l68(i3, 200, -1L, "", -1, i16);
    }
}
