package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.IReport;
import com.tencent.mobileqq.videoplatform.imp.ReportImp;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ReportUtil {
    static IPatchRedirector $redirector_;
    private static IReport sReportImp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sReportImp = new ReportImp();
        }
    }

    public ReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void report(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        sReportImp.report(str, str2, z16, j3, j16, hashMap, str3);
    }

    public static void setReportImp(IReport iReport) {
        sReportImp = iReport;
    }
}
