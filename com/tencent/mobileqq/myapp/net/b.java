package com.tencent.mobileqq.myapp.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f252473a;

    /* renamed from: b, reason: collision with root package name */
    public int f252474b;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f252473a = "";
            this.f252474b = -1;
        }
    }
}
