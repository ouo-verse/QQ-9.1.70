package com.tencent.mobileqq.qqconnectface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f262378a;

    /* renamed from: b, reason: collision with root package name */
    public String f262379b;

    /* renamed from: c, reason: collision with root package name */
    public String f262380c;

    /* renamed from: d, reason: collision with root package name */
    public String f262381d;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "{ret=" + this.f262378a + ", errMsg='" + this.f262379b + "', idKey='" + this.f262380c + "', allResults='" + this.f262381d + "'}";
    }
}
