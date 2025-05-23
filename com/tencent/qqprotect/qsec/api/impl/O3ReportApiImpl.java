package com.tencent.qqprotect.qsec.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.qsec.api.IO3ReportApi;
import com.tencent.qqprotect.report.O3Report;
import cooperation.qzone.report.QZonePushReporter;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class O3ReportApiImpl implements IO3ReportApi {
    static IPatchRedirector $redirector_ = null;
    private static final String COMBINE_STR = "/";
    boolean isInited;

    public O3ReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isInited = false;
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void report(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
        } else {
            O3Report.j(str, str2, str3);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAIOExposure(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        O3Report.a("message", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, str + "/" + str2);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAction(String str, String str2, String str3, ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, arrayList);
        } else {
            O3Report.a(str, str2, str3);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAddFriendClick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            O3Report.a.a();
            O3Report.a(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, "click", Integer.toString(i3));
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAddFriendExposure(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            O3Report.a.a();
            O3Report.a(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, Integer.toString(i3));
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAddGroupClick(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            O3Report.a.a();
            O3Report.a("add_group", "click", Integer.toString(i3));
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportAddGroupExposure(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            O3Report.a.a();
            O3Report.a("add_group", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, Integer.toString(i3));
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportLoginClick(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        O3Report.a.a();
        O3Report.b(str, "login", "click", Integer.toString(i3) + "/" + i16);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportLoginExposure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        O3Report.a.a();
        O3Report.a("login", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, Integer.toString(i3) + "/" + i16);
    }

    @Override // com.tencent.qqprotect.qsec.api.IO3ReportApi
    public void reportSendMessageAction(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            O3Report.a("message", "click", str);
        }
    }
}
