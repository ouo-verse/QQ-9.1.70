package com.tencent.mobileqq.bgprobe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BackgroundException extends CaughtException {
    static IPatchRedirector $redirector_;

    public BackgroundException(String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) th5);
    }

    public BackgroundException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }
}
