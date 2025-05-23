package com.tencent.wcdb.repair;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DBDumpUtil {
    static IPatchRedirector $redirector_;

    public DBDumpUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static native boolean nativeDumpDB(String str, String str2, String str3);

    private static native boolean nativeIsSqlComplete(String str);
}
