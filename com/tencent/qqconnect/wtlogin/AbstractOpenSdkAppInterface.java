package com.tencent.qqconnect.wtlogin;

import com.tencent.common.app.business.BaseOpenSDKAppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import hp3.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbstractOpenSdkAppInterface extends BaseOpenSDKAppInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<b> f344963d;

    /* renamed from: e, reason: collision with root package name */
    private hp3.b f344964e;

    public AbstractOpenSdkAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mobileQQ, (Object) str);
        } else {
            this.f344963d = new ArrayList();
            this.f344964e = new hp3.b();
        }
    }

    public void f(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        } else if (bVar != null) {
            this.f344963d.add(bVar);
        }
    }

    public abstract Object fetchQQLiteStatus(f fVar);

    public hp3.b g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (hp3.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f344964e;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return null;
    }

    public void h(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, obj);
            return;
        }
        Iterator<b> it = this.f344963d.iterator();
        while (it.hasNext()) {
            it.next().a(i3, obj);
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.f344963d.clear();
        }
    }
}
