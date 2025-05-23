package com.tencent.mobileqq.subaccount;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f291104a;

    /* renamed from: b, reason: collision with root package name */
    public Object f291105b;

    public d(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, obj);
        } else {
            this.f291104a = str;
            this.f291105b = obj;
        }
    }
}
