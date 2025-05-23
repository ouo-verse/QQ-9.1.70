package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BdhLogUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String Tag = "BDH_LOG";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface LogTag {
        public static final String Tag_Conn = "C";
        public static final String Tag_Engine = "E";
        public static final String Tag_Net = "N";
        public static final String Tag_Probe = "P";
        public static final String Tag_Req = "R";
        public static final String Tag_Trans = "T";
    }

    public BdhLogUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void LogEvent(String str, String str2) {
        QLog.d(Tag, 1, str + ". " + str2);
    }

    public static void LogException(String str, String str2, Throwable th5) {
        QLog.e(Tag, 1, str + ". " + str2, th5);
    }
}
