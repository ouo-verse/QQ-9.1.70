package com.tencent.qqprotect.qsec.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.qsec.api.IO3NotifySecApi;
import com.tencent.qqprotect.report.O3Report;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class O3NotifySecApiImpl implements IO3NotifySecApi {
    static IPatchRedirector $redirector_;

    public O3NotifySecApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3NotifySecApi
    public void sendMessage(String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) list);
        } else {
            O3Report.f(str, list);
        }
    }
}
