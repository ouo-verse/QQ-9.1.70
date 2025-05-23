package com.tencent.mobileqq.microapp.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class AppBrandContant {
    static IPatchRedirector $redirector_ = null;
    public static final String A_ACTION_DATA_MICRO = "micro_app";
    public static final String CONFIG = "CONFIG";
    public static final String RECEIVER = "receiver";
    public static final String STEP_MINIAPP_CONFIG_FINISHED = "ConfigLoaded";
    public static final String STEP_MINIAPP_END = "MiniAppEnd";
    public static final String STEP_MINIAPP_PROCESS_FINISHED = "ProcessLoaded";
    public static final String STEP_MINIAPP_START = "MiniAppStart";
    public static final String STEP_PAGE_VISIT = "PageVisit";
    public static final int VERSION_TYPE_DEBUG = 1;
    public static final int VERSION_TYPE_RELEASE = 0;

    public AppBrandContant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
