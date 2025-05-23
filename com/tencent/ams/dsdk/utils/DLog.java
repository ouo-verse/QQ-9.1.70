package com.tencent.ams.dsdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DLog {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_TAG = "DynamicSDK";
    private static final String PREFIX = "TENCENT_AMS_DYNAMIC";
    private static boolean debugEnabled;
    private static final LogSupport defaultLogSupport;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LogSupport {
        void d(String str, String str2);

        void d(String str, String str2, Throwable th5);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th5);

        void i(String str, String str2);

        void i(String str, String str2, Throwable th5);

        void v(String str, String str2);

        void v(String str, String str2, Throwable th5);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th5);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18979);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            debugEnabled = false;
            defaultLogSupport = new LogSupport() { // from class: com.tencent.ams.dsdk.utils.DLog.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void d(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                    } else if (DLog.debugEnabled) {
                        Log.d(str, str2);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void e(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                        iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
                    } else if (DLog.debugEnabled) {
                        Log.e(str, str2);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void i(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                    } else if (DLog.debugEnabled) {
                        Log.i(str, str2);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void v(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
                    } else if (DLog.debugEnabled) {
                        Log.v(str, str2);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void w(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                        iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
                    } else if (DLog.debugEnabled) {
                        Log.w(str, str2);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void d(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, str, str2, th5);
                    } else if (DLog.debugEnabled) {
                        Log.d(str, str2, th5);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void e(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                        iPatchRedirector.redirect((short) 11, this, str, str2, th5);
                    } else if (DLog.debugEnabled) {
                        Log.e(str, str2, th5);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void i(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, this, str, str2, th5);
                    } else if (DLog.debugEnabled) {
                        Log.i(str, str2, th5);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void v(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, this, str, str2, th5);
                    } else if (DLog.debugEnabled) {
                        Log.v(str, str2, th5);
                    }
                }

                @Override // com.tencent.ams.dsdk.utils.DLog.LogSupport
                public void w(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                        iPatchRedirector.redirect((short) 9, this, str, str2, th5);
                    } else if (DLog.debugEnabled) {
                        Log.w(str, str2, th5);
                    }
                }
            };
        }
    }

    public DLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str) {
        d(DEFAULT_TAG, str);
    }

    public static void e(String str) {
        e(DEFAULT_TAG, str);
    }

    private static LogSupport getLogSupport() {
        LogSupport logSupport = DKConfiguration.getLogSupport();
        if (logSupport == null) {
            return defaultLogSupport;
        }
        return logSupport;
    }

    private static String getTag(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TENCENT_AMS_DYNAMIC_");
        if (TextUtils.isEmpty(str)) {
            str = DEFAULT_TAG;
        }
        sb5.append(str);
        return sb5.toString();
    }

    public static void i(String str) {
        i(DEFAULT_TAG, str);
    }

    public static void setDebugEnabled(boolean z16) {
        debugEnabled = z16;
        getLogSupport().d(getTag(DEFAULT_TAG), "debugEnabled: " + z16);
    }

    public static void v(String str) {
        v(DEFAULT_TAG, str);
    }

    public static void w(String str) {
        w(DEFAULT_TAG, str);
    }

    public static void d(String str, String str2) {
        getLogSupport().d(getTag(str), str2);
    }

    public static void e(String str, Throwable th5) {
        e(DEFAULT_TAG, str, th5);
    }

    public static void i(String str, String str2) {
        getLogSupport().i(getTag(str), str2);
    }

    public static void v(String str, String str2) {
        getLogSupport().v(getTag(str), str2);
    }

    public static void w(String str, String str2) {
        getLogSupport().w(getTag(str), str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        getLogSupport().d(getTag(str), str2, th5);
    }

    public static void e(String str, String str2) {
        getLogSupport().e(getTag(str), str2);
    }

    public static void i(String str, String str2, Throwable th5) {
        getLogSupport().i(getTag(str), str2, th5);
    }

    public static void v(String str, String str2, Throwable th5) {
        getLogSupport().v(getTag(str), str2, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        getLogSupport().w(getTag(str), str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        getLogSupport().e(getTag(str), str2, th5);
    }
}
