package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f264502a;

    /* renamed from: b, reason: collision with root package name */
    public Object f264503b;

    public c(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, obj);
        } else {
            this.f264502a = str;
            this.f264503b = obj;
        }
    }
}
