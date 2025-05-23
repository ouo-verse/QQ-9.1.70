package com.tencent.mobileqq.hitrate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public String f236847f;

    public b(String str, String str2, String str3) {
        super("plugin", str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
        } else {
            this.f236847f = str3;
        }
    }

    @Override // com.tencent.mobileqq.hitrate.d
    @Deprecated
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.a();
        }
    }

    @Override // com.tencent.mobileqq.hitrate.d
    @Deprecated
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.d();
        }
    }
}
