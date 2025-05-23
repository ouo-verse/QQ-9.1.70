package com.tencent.pts.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class PTSReportUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int REPORT_TYPE_ERROR = 1;
    public static final int REPORT_TYPE_INFO = 0;
    private static final String TAG = "PTSReportUtil";
    private static IPTSReport sPtsReport;

    /* loaded from: classes22.dex */
    public static class DefaultPTSReport implements IPTSReport {
        static IPatchRedirector $redirector_;

        public DefaultPTSReport() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.pts.utils.PTSReportUtil.IPTSReport
        public void reportEvent(String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3));
            }
        }
    }

    /* loaded from: classes22.dex */
    public interface IPTSReport {
        void reportEvent(String str, String str2, int i3);
    }

    PTSReportUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerPtsReport(IPTSReport iPTSReport) {
        if (iPTSReport != null) {
            sPtsReport = iPTSReport;
        }
    }

    public static void reportEvent(String str, String str2, int i3) {
        IPTSReport iPTSReport = sPtsReport;
        if (iPTSReport != null) {
            iPTSReport.reportEvent(str, str2, i3);
        }
    }
}
