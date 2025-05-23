package com.tencent.mobileqq.qqgift.runtime;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends MobileQQServiceBase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f264971a;

    public b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f264971a = appInterface;
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public void dispatchToHandler(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        BusinessHandler businessHandler = getAppInterface().getBusinessHandler("");
        if (businessHandler != null) {
            try {
                businessHandler.onReceive(toServiceMsg, fromServiceMsg, obj);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("QQLiveToolService", 2, businessHandler.getClass().getSimpleName() + " onReceive error", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f264971a;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public boolean isPBPushCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return true;
    }
}
