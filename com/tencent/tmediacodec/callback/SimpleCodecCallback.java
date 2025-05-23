package com.tencent.tmediacodec.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SimpleCodecCallback implements CodecCallback {
    static IPatchRedirector $redirector_;

    public SimpleCodecCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onCreate(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onRealRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onReuseCodecAPIException(String str, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) th5);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onStarted(Boolean bool, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bool, (Object) str);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onTransToKeepPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.tmediacodec.callback.CodecCallback
    public void onTransToRunningPool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
