package com.tencent.mobileqq.troop.report.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.report.api.ITroopMsgDTReportApi;
import com.tencent.mobileqq.troop.report.msgoperation.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMsgDTReportApiImpl implements ITroopMsgDTReportApi {
    static IPatchRedirector $redirector_;

    public TroopMsgDTReportApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.report.api.ITroopMsgDTReportApi
    public void reportLongTapMsg(String str, String str2, String str3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, Long.valueOf(j3));
        } else {
            c.f298289a.f(str, str2, str3, j3);
        }
    }

    @Override // com.tencent.mobileqq.troop.report.api.ITroopMsgDTReportApi
    public void reportTapMsgLinkJump(String str, String str2, String str3, String str4, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Long.valueOf(j3));
        } else {
            c.f298289a.h(str, str2, str3, str4, j3);
        }
    }
}
