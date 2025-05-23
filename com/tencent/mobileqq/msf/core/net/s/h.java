package com.tencent.mobileqq.msf.core.net.s;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public final String f249102f;

    public h(String str, String str2) {
        super(2, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.f249102f = str;
        }
    }
}
