package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.ICrashReportApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CrashReportApiImpl implements ICrashReportApi {
    static IPatchRedirector $redirector_;

    public CrashReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ICrashReportApi
    public void postException(int i3, String str, String str2, String str3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            CrashReport.postException(i3, str, str2, str3, map);
        } else {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, map);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.ICrashReportApi
    public void postException(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            CrashReport.postException(thread, i3, str, str2, str3, map);
        } else {
            iPatchRedirector.redirect((short) 3, this, thread, Integer.valueOf(i3), str, str2, str3, map);
        }
    }
}
