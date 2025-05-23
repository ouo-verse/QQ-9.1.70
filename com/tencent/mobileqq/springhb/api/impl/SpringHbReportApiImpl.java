package com.tencent.mobileqq.springhb.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.ReportInfo;
import com.tencent.mobileqq.springhb.SpringReporter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.debug.DebugMonitorHelper;
import com.tencent.mobileqq.springhb.n;
import com.tencent.mobileqq.springhb.t;
import com.tencent.mobileqq.springhb.util.b;
import java.io.Serializable;
import java.util.Map;
import kl2.a;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SpringHbReportApiImpl implements ISpringHbReportApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "Springhb_report.SpringHbReportApiImpl";
    t mGameCenterReportManager;

    public SpringHbReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean isGameCenterActivity() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isGameCenterActivity(peekAppRuntime);
    }

    private boolean isSpringHbActivity() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isSpringHbActivity(peekAppRuntime);
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void checkResCover(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else if (i3 == 1) {
            n.e();
        } else {
            n.g();
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void configReport(int i3, int i16, int i17, int i18, int i19, boolean z16, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), strArr);
        } else {
            n.i(3, i3, i16, i17, i18, i19, z16, strArr);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void gameHBConfigReport(int i3, int i16, int i17, int i18, int i19, boolean z16, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), strArr);
        } else {
            n.i(1, i3, i16, i17, i18, i19, z16, strArr);
        }
    }

    public DebugMonitorHelper getDebugMonitorHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (DebugMonitorHelper) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        t tVar = this.mGameCenterReportManager;
        if (tVar != null) {
            return tVar.n();
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else if (MobileQQ.sProcessId == 1) {
            this.mGameCenterReportManager = new t(appRuntime, 1);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        t tVar = this.mGameCenterReportManager;
        if (tVar != null) {
            tVar.z();
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void report(Serializable serializable, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) serializable, i3);
        } else if (serializable instanceof ReportInfo) {
            this.mGameCenterReportManager.E((ReportInfo) serializable, i3);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportExCatch(int i3, Throwable th5, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), th5, strArr);
        } else {
            n.F(i3, th5, strArr);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportForGameCenter(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
        } else if (isSpringHbActivity()) {
            b.f289632a.d(TAG, true, "reportForGameCenter isSpringHbActivity return");
        } else {
            SpringReporter.i(map, 1);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportForSpringHb(Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) map);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportGameHBConfigCoverage(int i3, int i16, int i17, int i18, int i19, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), str);
        } else {
            n.G(i3, i16, i17, i18, i19, z16, str);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportPerformance(int i3, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3), str);
        } else {
            n.H(i3, j3, str);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportResPreload(a aVar, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, aVar, str, str2, Integer.valueOf(i3));
        } else {
            n.L(aVar, str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportResRealTimeDownload(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, Integer.valueOf(i3));
        } else {
            n.M(str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportResourceConfigCover(int i3, int i16, int i17, int i18, int i19, boolean z16, String str, String str2, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), str, str2, Integer.valueOf(i26));
        } else {
            n.E(i3, i16, i17, i18, i19, z16, str, str2, i26);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void reportSpringHBConfigCoverage(int i3, int i16, int i17, int i18, int i19, boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z16), str);
        } else {
            n.N(i3, i16, i17, i18, i19, z16, str);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void tryReportResState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            n.W(z16);
        }
    }

    @Override // com.tencent.mobileqq.springhb.api.ISpringHbReportApi
    public void webReport(JSONObject jSONObject, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject, i3);
        } else {
            SpringReporter.k(jSONObject, i3);
        }
    }
}
