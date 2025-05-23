package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f195712d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.util.ac f195713e;

    /* renamed from: f, reason: collision with root package name */
    public Object f195714f;

    public i(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195714f = new Object();
            this.f195712d = qQAppInterface;
        }
    }

    public com.tencent.mobileqq.util.ac a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.util.ac) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f195713e == null) {
            synchronized (this.f195714f) {
                if (this.f195713e == null) {
                    this.f195713e = new com.tencent.mobileqq.util.ac(this.f195712d);
                }
            }
        }
        return this.f195713e;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.util.ac acVar = this.f195713e;
        if (acVar != null) {
            acVar.b();
        }
    }
}
