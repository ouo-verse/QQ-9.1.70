package com.tencent.raft.codegenmeta.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RLog {
    static IPatchRedirector $redirector_ = null;
    public static final String DEBUG = "DEBUG";
    public static final String ERROR = "ERROR";
    public static final String WARN = " WARN";

    public RLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, Object... objArr) {
        System.out.println(format("DEBUG", str, getLogMsg(objArr).toString()));
    }

    public static void e(String str, Object... objArr) {
        System.out.println(format(ERROR, str, getLogMsg(objArr).toString()));
    }

    private static String format(String str, String str2, String str3) {
        return "[" + str + "] [" + str2 + "] " + str3;
    }

    private static StringBuilder getLogMsg(Object... objArr) {
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        return sb5;
    }

    public static void w(String str, Object... objArr) {
        System.out.println(format(WARN, str, getLogMsg(objArr).toString()));
    }
}
