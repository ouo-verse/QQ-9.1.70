package com.tencent.raft.measure.log;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.measure.RAFTMeasure;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RLog {
    static IPatchRedirector $redirector_;

    RLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, Object... objArr) {
        RAFTMeasure.getAppConfig().getLogDelegate().debug(str, getLogMsg(objArr).toString());
    }

    public static void e(String str, Object... objArr) {
        RAFTMeasure.getAppConfig().getLogDelegate().error(str, getLogMsg(objArr).toString());
    }

    private static StringBuilder getLogMsg(@NonNull Object... objArr) {
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        return sb5;
    }

    public static void i(String str, Object... objArr) {
        RAFTMeasure.getAppConfig().getLogDelegate().info(str, getLogMsg(objArr).toString());
    }

    public static void w(String str, Object... objArr) {
        RAFTMeasure.getAppConfig().getLogDelegate().warn(str, getLogMsg(objArr).toString());
    }

    public static void d(String str, String str2, Throwable th5) {
        RAFTMeasure.getAppConfig().getLogDelegate().debug(str, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        RAFTMeasure.getAppConfig().getLogDelegate().error(str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        RAFTMeasure.getAppConfig().getLogDelegate().info(str, str2, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        RAFTMeasure.getAppConfig().getLogDelegate().warn(str, str2, th5);
    }
}
