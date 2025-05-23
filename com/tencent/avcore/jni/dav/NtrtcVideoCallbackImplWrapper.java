package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
class NtrtcVideoCallbackImplWrapper implements NtrtcVideoCallback {
    static IPatchRedirector $redirector_;
    private NtrtcVideoCallback mBusiCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NtrtcVideoCallbackImplWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBusiCallback = null;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcVideoCallback
    public void onRecvFirstFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcVideoCallbackImplWrapper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcVideoCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcVideoCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcVideoCallbackImplWrapper.this.mBusiCallback.onRecvFirstFrame();
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcVideoCallback
    public void onRequestUpdateCamera(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcVideoCallbackImplWrapper.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$fps;

                {
                    this.val$fps = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcVideoCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcVideoCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcVideoCallbackImplWrapper.this.mBusiCallback.onRequestUpdateCamera(this.val$fps);
                    }
                }
            });
        }
    }

    public void setBusiCallback(NtrtcVideoCallback ntrtcVideoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcVideoCallback);
        } else {
            this.mBusiCallback = ntrtcVideoCallback;
        }
    }
}
