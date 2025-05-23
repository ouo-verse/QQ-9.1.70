package com.tencent.mobileqq.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
class CameraManagerImpl$AFMoveCallbackForward$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ k this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            k.a(null);
            k.b(null);
            throw null;
        }
    }
}
