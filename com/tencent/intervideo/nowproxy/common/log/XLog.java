package com.tencent.intervideo.nowproxy.common.log;

import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class XLog {
    static IPatchRedirector $redirector_ = null;
    public static final int D = 1;
    public static final int E = 4;
    public static final int I = 2;
    public static final int V = 0;
    public static final int W = 3;
    public static final int WTF = 5;

    public XLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final int d(String str, String str2) {
        SdkBaseAbilityImpl.getsInstance().printLog(0, str, str2);
        return 0;
    }

    public static final int e(String str, String str2) {
        SdkBaseAbilityImpl.getsInstance().printLog(4, str, str2);
        return 0;
    }

    public static final int i(String str, String str2) {
        SdkBaseAbilityImpl.getsInstance().printLog(2, str, str2);
        return 0;
    }
}
