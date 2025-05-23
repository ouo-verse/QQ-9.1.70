package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginMsfListener;

/* loaded from: classes15.dex */
public class WtProvider {
    static IPatchRedirector $redirector_ = null;
    static final String tag = "MSF.C.WtloginMsfProvider";

    public WtProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cancel(int i3) {
        m.a(i3);
    }

    public static int sendData(WUserSigInfo wUserSigInfo, String str, String str2, byte[] bArr, int i3, boolean z16, WtloginMsfListener wtloginMsfListener) {
        return m.a(wUserSigInfo, str, str2, bArr, i3, z16, wtloginMsfListener);
    }
}
