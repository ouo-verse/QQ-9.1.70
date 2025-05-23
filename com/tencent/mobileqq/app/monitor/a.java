package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f196287a;

    /* renamed from: b, reason: collision with root package name */
    String f196288b;

    /* renamed from: c, reason: collision with root package name */
    String f196289c;

    public a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.f196287a = str;
        this.f196288b = str2;
        this.f196289c = str3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "threadName='" + this.f196287a + "', threadStatus='" + this.f196288b + "', threadStack='" + this.f196289c + "'}";
    }
}
