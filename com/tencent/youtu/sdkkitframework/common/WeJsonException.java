package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WeJsonException extends IOException {
    static IPatchRedirector $redirector_;

    public WeJsonException() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public WeJsonException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }

    public WeJsonException(String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) th5);
    }

    public WeJsonException(Throwable th5) {
        super(th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) th5);
    }
}
