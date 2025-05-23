package com.tencent.mobileqq.microapp.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppCrashUtils {
    static IPatchRedirector $redirector_;

    public MiniAppCrashUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportCrash(String str) {
        try {
            ClassLoader classLoader = BaseApplicationImpl.sApplication.getClassLoader();
            if (classLoader == null) {
                return;
            }
            classLoader.loadClass("com.tencent.mobileqq.microapp.sdk.MiniAppController").getMethod("handleNoCatchCrash", String.class).invoke(null, str);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
