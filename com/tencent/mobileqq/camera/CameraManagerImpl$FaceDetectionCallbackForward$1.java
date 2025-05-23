package com.tencent.mobileqq.camera;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
class CameraManagerImpl$FaceDetectionCallbackForward$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ n this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            n.a(null);
            n.b(null);
            throw null;
        }
    }
}
