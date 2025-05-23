package com.tencent.mobileqq.Doraemon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f154090a;

    /* renamed from: b, reason: collision with root package name */
    public final int f154091b;

    /* renamed from: c, reason: collision with root package name */
    public final int f154092c;

    /* renamed from: d, reason: collision with root package name */
    public final Class<? extends e> f154093d;

    public b(String str, int i3, int i16, Class<? extends e> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), cls);
            return;
        }
        this.f154090a = str;
        this.f154091b = i3;
        this.f154092c = i16;
        this.f154093d = cls;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "APIConfig{apiName='" + this.f154090a + "', apiIndex=" + this.f154091b + ", authorizeType=" + this.f154092c + ", moduleClass=" + this.f154093d + '}';
    }
}
