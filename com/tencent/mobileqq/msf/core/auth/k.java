package com.tencent.mobileqq.msf.core.auth;

import android.util.Log;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247487a = "WTReporter";

    /* renamed from: b, reason: collision with root package name */
    private static final String f247488b = "invalidWTUin";

    /* renamed from: c, reason: collision with root package name */
    private static final String f247489c = "stackTrace";

    /* renamed from: d, reason: collision with root package name */
    private static final String f247490d = "type";

    /* renamed from: e, reason: collision with root package name */
    public static final String f247491e = "read";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247492f = "write";

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(String str, String str2) {
        try {
            QLog.d(f247487a, 1, "checkAndReporterUinError uin = " + str);
            Long.parseLong(str);
        } catch (Exception e16) {
            try {
                QLog.d(f247487a, 1, e16, new Object[0]);
                String stackTraceString = Log.getStackTraceString(e16);
                HashMap hashMap = new HashMap();
                hashMap.put(f247489c, stackTraceString);
                hashMap.put("type", str2);
                if (BaseApplication.getContext() != null && MsfService.getCore().statReporter != null) {
                    MsfService.getCore().statReporter.a(f247488b, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                }
            } catch (Throwable th5) {
                QLog.e(f247487a, 1, th5, new Object[0]);
            }
        }
    }
}
