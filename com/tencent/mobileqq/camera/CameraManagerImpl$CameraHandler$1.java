package com.tencent.mobileqq.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
class CameraManagerImpl$CameraHandler$1 implements Runnable {
    static IPatchRedirector $redirector_;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            throw null;
        } catch (RuntimeException e16) {
            QLog.e(l.a(null), 2, "take picture failed.");
            throw e16;
        }
    }
}
