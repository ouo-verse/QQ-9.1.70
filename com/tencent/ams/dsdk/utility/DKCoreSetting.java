package com.tencent.ams.dsdk.utility;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKCoreSetting {
    static IPatchRedirector $redirector_ = null;
    public static final String SDK_VERSION = "250407";

    public DKCoreSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getSdkVersion() {
        return SDK_VERSION;
    }
}
