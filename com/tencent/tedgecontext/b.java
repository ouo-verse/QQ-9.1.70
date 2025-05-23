package com.tencent.tedgecontext;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import ve4.m;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    static IPatchRedirector $redirector_;
    private a mContext;
    protected c mLog;

    public b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.mContext = aVar;
            this.mLog = new c(aVar);
        }
    }

    public void asyncRun(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
        } else {
            getRouter().f375305c.l(runnable);
        }
    }

    public void asyncRunInRequestThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        } else {
            getRouter().f375305c.asyncRunInRequestThread(runnable);
        }
    }

    public a getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mContext;
    }

    public com.tencent.tedger.routecenter.a getRouter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.tedger.routecenter.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return getContext().m();
    }

    public void syncRunInRequestThread(m.a aVar, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, aVar, Long.valueOf(j3));
        } else {
            getRouter().f375305c.syncRunInRequestThread(aVar, j3);
        }
    }
}
