package com.tencent.mobileqq.leba.business.urlreport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f240324a;

    public e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f240324a = str;
        }
    }

    @Override // com.tencent.mobileqq.leba.business.urlreport.b
    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && str.contains("plg_vkey=1")) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.leba.business.urlreport.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return String.format("&mqqvkey=%s", this.f240324a);
    }
}
