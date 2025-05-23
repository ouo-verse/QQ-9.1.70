package com.tencent.sveffects;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SLog {
    static IPatchRedirector $redirector_;

    public SLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        SdkContext.getInstance().getLogger().d(str, str2);
    }

    public static void e(String str, String str2) {
        SdkContext.getInstance().getLogger().e(str, str2);
    }

    public static void i(String str, String str2) {
        SdkContext.getInstance().getLogger().i(str, str2);
    }

    public static final boolean isEnable() {
        return SdkContext.getInstance().getLogger().isEnable();
    }

    public static void w(String str, String str2) {
        SdkContext.getInstance().getLogger().w(str, str2);
    }

    public static void e(String str, Throwable th5) {
        SdkContext.getInstance().getLogger().e(str, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        SdkContext.getInstance().getLogger().e(str, str2, th5);
    }
}
