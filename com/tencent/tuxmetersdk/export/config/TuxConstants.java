package com.tencent.tuxmetersdk.export.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String BEIJING_TIMEZONE = "GMT+08:00";
    public static final int ERROR_CODE = 10000;
    public static final String ERROR_MSG = "\u5f02\u5e38\u9519\u8bef";
    public static final long INTERVAL = 1000;
    public static final String PLATFORM = "Android";
    public static final int SELF_TRIGGER_TASK_MAX_NUM = 50;

    public TuxConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
