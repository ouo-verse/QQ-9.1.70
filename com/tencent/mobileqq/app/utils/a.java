package com.tencent.mobileqq.app.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import mqq.app.MSFServlet;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends MobileQQServiceBase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    BrowserAppInterface f196634a;

    public a(BrowserAppInterface browserAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) browserAppInterface);
        } else {
            this.f196634a = browserAppInterface;
        }
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196634a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public Map<String, String[]> getCompatibleCmd2HandlerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return com.tencent.mobileqq.app.f.a();
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return am.class;
    }
}
