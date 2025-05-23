package com.tencent.halley;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public class QDDownloaderRuntimeException extends RuntimeException {
    static IPatchRedirector $redirector_;

    public QDDownloaderRuntimeException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}
