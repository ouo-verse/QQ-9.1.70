package com.tencent.mobileqq.msf.core.quicksend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QuickSendStrategy {
    static IPatchRedirector $redirector_ = null;
    public static final int STRATEGY_COMMON = 0;
    public static final int STRATEGY_MSG = 1;

    public QuickSendStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a getStragegyArgs(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return new a(5000L, 60000L, 12, true);
        }
        return new a(5000L, 0L, 0, true);
    }
}
