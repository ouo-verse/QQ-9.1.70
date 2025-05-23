package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.IReportControllerApi;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReportControllerApiImpl implements IReportControllerApi {
    static IPatchRedirector $redirector_;

    public ReportControllerApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private AppRuntime getRunTime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            ReportController.o(getRunTime(), str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEventRuntime(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            ReportController.p(getRunTime(), str, str2, i3);
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportDeviceInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            ReportController.s(getRunTime(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
        } else {
            iPatchRedirector.redirect((short) 13, this, str, str2, str3, str4, Integer.valueOf(i3), str5, str6, str7, str8, str9, str10, str11, str12, str13);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportDeviceInfoRuntime(String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            ReportController.t(getRunTime(), str, str2, str3, str4, i3, str5);
        } else {
            iPatchRedirector.redirect((short) 9, this, str, str2, str3, str4, Integer.valueOf(i3), str5);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportDeviceInfoWithPerformance(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            ReportController.v(getRunTime(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12);
        } else {
            iPatchRedirector.redirect((short) 11, this, str, str2, str3, str4, Integer.valueOf(i3), str5, str6, str7, str8, str9, str10, str11, str12);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportDeviceInfoWithPerformanceRuntime(String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4, Integer.valueOf(i3), str5);
        } else {
            ReportController.w(getRunTime(), str, str2, str3, str4, i3, str5);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportPushNotification(boolean z16, String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            ReportController.x(getRunTime(), z16, str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
        } else {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str, str2, str3, str4, Integer.valueOf(i3), str5, str6, str7, str8, str9, str10, str11, str12, str13);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportWith898(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            ReportController.y(getRunTime(), str);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            ReportController.n(getRunTime(), str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str6, str7, str8, str9);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            ReportController.r(getRunTime(), str, str2, str3, str4, str5, i3, i16, str6, str7, str8, str9);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), str6, str7, str8, str9);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportDeviceInfoRuntime(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            ReportController.u(getRunTime(), str, str2, str3, str4, i3, str5, str6, str7, str8, str9, str10, str11, str12, str13);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, str2, str3, str4, Integer.valueOf(i3), str5, str6, str7, str8, str9, str10, str11, str12, str13);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEvent(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            ReportController.m(getRunTime(), str, str2, i3);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.IReportControllerApi
    public void reportClickEventRuntime(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            ReportController.q(getRunTime(), str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
        } else {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str6, str7, str8, str9);
        }
    }
}
