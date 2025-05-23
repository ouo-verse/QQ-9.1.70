package com.tencent.avcore.jni.dav;

import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class NtrtcEngineCallbackImplWrapper implements NtrtcEngineCallback {
    static IPatchRedirector $redirector_;
    private NtrtcEngineCallback mBusiCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NtrtcEngineCallbackImplWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mBusiCallback = null;
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcEngineCallback
    public void onHasGotSharpConfigPayload(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable(i3) { // from class: com.tencent.avcore.jni.dav.NtrtcEngineCallbackImplWrapper.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$version;

                {
                    this.val$version = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcEngineCallbackImplWrapper.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcEngineCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcEngineCallbackImplWrapper.this.mBusiCallback.onHasGotSharpConfigPayload(this.val$version);
                    }
                }
            });
        }
    }

    @Override // com.tencent.avcore.jni.dav.NtrtcEngineCallback
    public void onUseXgNetworkForQualityOptimization() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            NtrtcEngine.getInstance().postRunable(new Runnable() { // from class: com.tencent.avcore.jni.dav.NtrtcEngineCallbackImplWrapper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NtrtcEngineCallbackImplWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (NtrtcEngineCallbackImplWrapper.this.mBusiCallback == null) {
                            return;
                        }
                        NtrtcEngineCallbackImplWrapper.this.mBusiCallback.onUseXgNetworkForQualityOptimization();
                    }
                }
            });
        }
    }

    public void setBusiCallback(NtrtcEngineCallback ntrtcEngineCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) ntrtcEngineCallback);
        } else {
            this.mBusiCallback = ntrtcEngineCallback;
        }
    }
}
