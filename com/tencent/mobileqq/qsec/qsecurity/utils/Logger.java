package com.tencent.mobileqq.qsec.qsecurity.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import common.config.service.QzoneConfig;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes17.dex */
public class Logger {
    static IPatchRedirector $redirector_;
    private static boolean sCacheable;
    private static Context sContext;
    private static boolean sDebug;

    public Logger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String buildMsgWithLocation(String str) {
        String str2;
        String str3;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str4 = "";
        String str5 = "";
        int i3 = 3;
        while (true) {
            if (i3 >= stackTrace.length) {
                str2 = "";
                str3 = str2;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            String className = stackTraceElement.getClassName();
            if (!TextUtils.equals(className, Logger.class.getName())) {
                str4 = stackTraceElement.getMethodName();
                str2 = stackTraceElement.getFileName();
                str3 = String.valueOf(stackTraceElement.getLineNumber());
                str5 = className;
                break;
            }
            i3++;
            str5 = className;
        }
        return String.format(Locale.US, "[Thread:%d %s, %s.%s(%s:%s)] %s", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), str5, str4, str2, str3, str);
    }

    private static void cacheLogInfo(Context context, String str) {
        if (context == null) {
            el(Logger.class.getSimpleName(), "method:cacheLogInfo#return#context=" + context);
        }
    }

    public static void d(String str) {
        if (sDebug) {
            handleLogInfo("", 3, str, false, false);
        }
    }

    public static void dc(String str) {
        if (sDebug) {
            handleLogInfo("", 3, str, false, true);
        }
    }

    public static void dcOneTime(Context context, String str) {
        if (sDebug) {
            handleLogInfo("", 3, str, false, false);
            cacheLogInfo(context, str.trim());
        }
    }

    public static void dl(String str) {
        if (sDebug) {
            handleLogInfo("", 3, str, true, false);
        }
    }

    public static void dlc(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 3, str2, true, true);
        }
    }

    public static void dlcOneTime(Context context, String str, String str2) {
        if (sDebug) {
            cacheLogInfo(context, handleLogInfo(str, 3, str2, true, false));
        }
    }

    public static void e(String str) {
        if (sDebug) {
            handleLogInfo("", 6, str, false, false);
        }
    }

    public static void el(String str) {
        if (sDebug) {
            handleLogInfo("", 6, str, true, false);
        }
    }

    private static String handleLogInfo(String str, int i3, String str2, boolean z16, boolean z17) {
        String trim;
        String substring;
        if (TextUtils.isEmpty(str)) {
            str = initTag();
        }
        if (z16) {
            trim = buildMsgWithLocation(str2).trim();
        } else {
            trim = str2.trim();
        }
        int i16 = 0;
        while (i16 < trim.length()) {
            int length = trim.length();
            int i17 = i16 + QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES;
            if (length <= i17) {
                substring = trim.substring(i16);
            } else {
                substring = trim.substring(i16, i17);
            }
            printLogInfo(str, i3, substring.trim());
            i16 = i17;
        }
        if (sCacheable && z17) {
            cacheLogInfo(sContext, trim);
        }
        return trim;
    }

    public static void i(String str) {
        if (sDebug) {
            handleLogInfo("", 4, str, false, false);
        }
    }

    public static void initDebug(boolean z16) {
        sDebug = z16;
    }

    private static String initTag() {
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str = "";
        for (int i3 = 3; i3 < stackTrace.length; i3++) {
            str = stackTrace[i3].getClassName();
            if (!TextUtils.equals(str, Logger.class.getName())) {
                String fileName = stackTrace[i3].getFileName();
                if (fileName.contains(".")) {
                    return fileName.substring(0, fileName.lastIndexOf(46));
                }
                return fileName;
            }
        }
        return str;
    }

    public static void isCacheable(Context context, boolean z16) {
        if (context != null) {
            sContext = context.getApplicationContext();
        }
        sCacheable = z16;
    }

    public static boolean isDebug() {
        return sDebug;
    }

    private static void printLogInfo(String str, int i3, String str2) {
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        Log.d(str, str2);
                        return;
                    } else {
                        Log.e(str, str2);
                        return;
                    }
                }
                Log.w(str, str2);
                return;
            }
            Log.i(str, str2);
            return;
        }
        Log.v(str, str2);
    }

    public static void v(String str) {
        if (sDebug) {
            handleLogInfo("", 2, str, false, false);
        }
    }

    public static void w(String str) {
        if (sDebug) {
            handleLogInfo("", 5, str, false, false);
        }
    }

    public static void wl(String str) {
        if (sDebug) {
            handleLogInfo("", 5, str, true, false);
        }
    }

    public static void d(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 3, str2, false, false);
        }
    }

    public static void dc(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 3, str2, false, true);
        }
    }

    public static void dl(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 3, str2, true, false);
        }
    }

    public static void dlc(String str) {
        if (sDebug) {
            handleLogInfo("", 3, str, true, true);
        }
    }

    public static void e(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 6, str2, false, false);
        }
    }

    public static void el(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 6, str2, true, false);
        }
    }

    public static void i(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 4, str2, false, false);
        }
    }

    public static void v(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 2, str2, false, false);
        }
    }

    public static void w(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 5, str2, false, false);
        }
    }

    public static void wl(String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 5, str2, true, false);
        }
    }

    public static void dcOneTime(Context context, String str, String str2) {
        if (sDebug) {
            handleLogInfo(str, 3, str2, false, false);
            cacheLogInfo(context, str2.trim());
        }
    }

    public static void dlcOneTime(Context context, String str) {
        if (sDebug) {
            cacheLogInfo(context, handleLogInfo("", 3, str, false, false));
        }
    }
}
