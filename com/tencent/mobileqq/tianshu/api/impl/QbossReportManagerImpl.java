package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QbossReportManagerImpl implements IQbossReportManager {
    static IPatchRedirector $redirector_;

    public QbossReportManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportClick(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().o(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportClose(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().p(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportExpose(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().q(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportIntercept(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().r(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportSlide(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().s(str, str2, i3);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void reportUrlClick(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().t(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void sendErrorReport(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().u(i3, i16, i17, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IQbossReportManager
    public void sendReport(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
        } else {
            com.tencent.mobileqq.tianshu.impl.qboss.c.m().v(str, str2, i3);
        }
    }
}
