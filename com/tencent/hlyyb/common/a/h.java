package com.tencent.hlyyb.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class h implements Thread.UncaughtExceptionHandler {
    static IPatchRedirector $redirector_;

    public h(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) thread, (Object) th5);
        } else {
            th5.printStackTrace();
        }
    }
}
