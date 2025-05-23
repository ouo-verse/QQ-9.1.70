package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Eridanus {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f375605a;

    /* renamed from: b, reason: collision with root package name */
    public int f375606b;

    public Eridanus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        } else {
            this.f375605a = str;
            this.f375606b = i3;
        }
    }

    public static Eridanus a(int i3) {
        return new Eridanus("", i3);
    }
}
