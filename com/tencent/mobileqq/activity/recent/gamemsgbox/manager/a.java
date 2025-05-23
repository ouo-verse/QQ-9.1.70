package com.tencent.mobileqq.activity.recent.gamemsgbox.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f185537d;

    /* renamed from: e, reason: collision with root package name */
    protected EntityManager f185538e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            this.f185537d = (AppInterface) appRuntime;
            return true;
        }
        QLog.e("GameMsgBaseManager", 1, "appRuntime not instanceof AppInterface");
        return false;
    }

    public void b(AppRuntime appRuntime, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) entityManager);
        } else {
            if (!a(appRuntime)) {
                return;
            }
            this.f185538e = entityManager;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f185537d = null;
            this.f185538e = null;
        }
    }
}
