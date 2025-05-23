package com.tencent.raft.measure.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class MeasureConst {
    static IPatchRedirector $redirector_ = null;
    public static final String ATTA_APP_ID = "08500061666";
    public static final String ATTA_TOKEN = "3978713261";
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CRASH_MONITOR_SP_NAME = "BuglySdkInfos";
    public static final int DEFAULT_REPORT_DELAY_TIME = 5000;
    public static final int DEFAULT_REPORT_RATE = 1;
    public static final int DO_NOT_REPORT = 0;
    public static final int MUST_REPORT = 100;
    public static final String SLI_TYPE_AVG = "average";
    public static final String SLI_TYPE_DISTRIBUTION = "distribution";
    public static final String SLI_TYPE_LAUNCH = "launch";
    public static final String SLI_TYPE_SUCCESS = "succ";

    MeasureConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
