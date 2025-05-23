package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

@Deprecated
/* loaded from: classes11.dex */
public class ThreadPriority {
    static IPatchRedirector $redirector_ = null;
    public static final int HIGH = 8;
    public static final int LOW = 2;
    public static final int MAX = 10;
    public static final int MIN = 1;
    public static final int NORMAL = 5;

    public ThreadPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
