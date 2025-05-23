package com.tencent.mobileqq.relation.api.impl;

import android.os.Bundle;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.api.ISafetyReportTempService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SafetyReportTempServiceImpl implements ISafetyReportTempService {
    static IPatchRedirector $redirector_;

    public SafetyReportTempServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.ISafetyReportTempService
    public String encrypt(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        return NewReportPlugin.j(str, str2);
    }

    @Override // com.tencent.mobileqq.relation.api.ISafetyReportTempService
    public String getKeyForMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return NewReportPlugin.p(i3);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.ISafetyReportTempService
    public void safetyNewReport(QBaseActivity qBaseActivity, String str, String str2, String str3, String str4, String str5, int i3, String str6, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qBaseActivity, str, str2, str3, str4, str5, Integer.valueOf(i3), str6, bundle);
        } else {
            NewReportPlugin.S(qBaseActivity, str, str2, str3, str4, str5, i3, str6, bundle);
        }
    }

    @Override // com.tencent.mobileqq.relation.api.ISafetyReportTempService
    public void safetyReport(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qBaseActivity, str, str2, str3, Integer.valueOf(i3), str4);
        } else {
            NewReportPlugin.T(qBaseActivity, str, str2, str3, i3, str4);
        }
    }
}
