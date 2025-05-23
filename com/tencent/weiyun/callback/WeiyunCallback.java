package com.tencent.weiyun.callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class WeiyunCallback {
    static IPatchRedirector $redirector_;
    protected static final int INVALID_NATIVE_PTR = 0;
    protected static final int SUCCESS_CODE = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WeiyunCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onNativeCallback(long j3, int i3, int i16, String str, boolean z16);
}
