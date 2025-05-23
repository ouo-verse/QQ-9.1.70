package com.tencent.mobileqq.videoplatform.imp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.videoplatform.api.IReport;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ReportImp implements IReport {
    static IPatchRedirector $redirector_;

    public ReportImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.videoplatform.api.IReport
    public void report(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap, str3);
        }
    }
}
