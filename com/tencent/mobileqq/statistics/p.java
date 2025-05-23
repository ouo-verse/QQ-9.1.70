package com.tencent.mobileqq.statistics;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class p extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private z91.a f290064a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements z91.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
            }
        }

        @Override // z91.a
        public void a(String str, int i3, String str2, Entity entity, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16));
            } else {
                ((BaseProxy) p.this).proxyManager.addMsgQueue(str, i3, str2, entity, i16, null);
            }
        }
    }

    public p(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        } else {
            this.f290064a = new a();
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            ReportController reportController = ((QQAppInterface) appRuntime).getReportController();
            if (reportController instanceof ReportControllerImpl) {
                ((ReportControllerImpl) reportController).G(this.app, this.f290064a);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime instanceof QQAppInterface) {
            ReportController reportController = ((QQAppInterface) appRuntime).getReportController();
            if (reportController instanceof ReportControllerImpl) {
                ((ReportControllerImpl) reportController).M(this.app, this.f290064a);
            }
        }
    }
}
