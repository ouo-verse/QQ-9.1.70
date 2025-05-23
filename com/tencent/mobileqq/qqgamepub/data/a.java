package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f264496a;

    /* renamed from: b, reason: collision with root package name */
    public String f264497b;

    /* renamed from: c, reason: collision with root package name */
    public int f264498c;

    /* renamed from: d, reason: collision with root package name */
    public String f264499d;

    /* renamed from: e, reason: collision with root package name */
    public String f264500e;

    public a() {
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
        return "AdTianshuReport{appId='" + this.f264496a + "', pageId='" + this.f264497b + "', action=" + this.f264498c + ", itemId='" + this.f264499d + "', traceInfo='" + this.f264500e + "'}";
    }
}
