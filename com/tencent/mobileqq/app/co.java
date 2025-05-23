package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class co implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195457d;

    public co(QQAppInterface qQAppInterface) throws NullPointerException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            if (qQAppInterface != null) {
                this.f195457d = qQAppInterface;
                return;
            }
            throw new NullPointerException("RecentManagerFor3rdPart, app is null");
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f195457d = null;
        }
    }
}
