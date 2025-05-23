package com.tencent.mobileqq.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
class CameraManagerImpl$PreviewCallbackForward$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ p this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            p.a(null);
            p.b(null);
            throw null;
        }
    }
}
