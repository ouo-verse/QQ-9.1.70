package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ThrowablesUtils {
    static IPatchRedirector $redirector_;

    public ThrowablesUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getStackTraceAsString(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
