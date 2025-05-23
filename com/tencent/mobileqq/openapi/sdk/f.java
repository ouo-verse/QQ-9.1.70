package com.tencent.mobileqq.openapi.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f256972a;

    /* renamed from: b, reason: collision with root package name */
    public int f256973b;

    /* renamed from: c, reason: collision with root package name */
    public String f256974c;

    public f(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.f256972a = i3;
        this.f256973b = i16;
        this.f256974c = str;
    }

    public f(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        this.f256972a = 100;
        this.f256973b = i3;
        this.f256974c = str;
    }
}
