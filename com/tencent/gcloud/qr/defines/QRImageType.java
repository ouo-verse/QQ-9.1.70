package com.tencent.gcloud.qr.defines;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QRImageType {
    static IPatchRedirector $redirector_ = null;
    public static final int Logo = 2;
    public static final int None = 0;
    public static final int Normal = 1;

    public QRImageType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
