package com.tencent.mobileqq.devicetoken.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NativeDeviceTokenReq {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f203485b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f203486a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f203485b = false;
        }
    }

    public NativeDeviceTokenReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203486a = false;
        }
    }

    private native int initNative(String str);
}
