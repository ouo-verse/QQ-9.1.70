package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadSetting {
    static IPatchRedirector $redirector_;
    public static int CLR;
    public static int PROCESS_QQ;
    public static boolean isDebugVersion;
    public static boolean isGrayVersion;
    public static boolean isPublicVersion;
    public static boolean logcatBgTaskMonitor;
    public static String revision;
    public static int sProcessId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41104);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        isPublicVersion = true;
        isGrayVersion = false;
        isDebugVersion = true;
        revision = "0";
        PROCESS_QQ = 1;
        sProcessId = -1;
        logcatBgTaskMonitor = false;
        CLR = 2;
    }

    public ThreadSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
