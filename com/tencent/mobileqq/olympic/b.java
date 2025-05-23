package com.tencent.mobileqq.olympic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends MobileQQServiceBase {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    OlympicToolAppInterface f255226a;

    /* renamed from: b, reason: collision with root package name */
    Random f255227b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(OlympicToolAppInterface olympicToolAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) olympicToolAppInterface);
            return;
        }
        this.f255227b = new Random();
        if (QLog.isColorLevel()) {
            QLog.i("OlympicToolService", 2, "new OlympicToolService");
        }
        this.f255226a = olympicToolAppInterface;
        MobileQQServiceBase.seq = Math.abs(this.f255227b.nextInt());
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public AppInterface getAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f255226a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    public Map<String, String[]> getCompatibleCmd2HandlerMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f.a();
    }

    @Override // com.tencent.mobileqq.service.MobileQQServiceBase
    protected Class<? extends MSFServlet> getServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c.class;
    }
}
