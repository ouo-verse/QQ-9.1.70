package com.tencent.mobileqq.qqlive.data.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class BizModules {
    static IPatchRedirector $redirector_ = null;
    public static final int BIZ_ANCHOR_ROOM = 2;
    public static final int BIZ_AUDIENCE_ROOM = 1;
    public static final int BIZ_GIFT = 6;
    public static final int BIZ_LOGIN = 4;
    public static final int BIZ_PUSH = 5;
    public static final int BIZ_SSO = 3;
    public static final int BIZ_UNKNOWN = 0;

    public BizModules() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
