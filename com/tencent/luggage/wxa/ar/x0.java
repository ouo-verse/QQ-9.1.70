package com.tencent.luggage.wxa.ar;

import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.xweb.util.IXWebLogClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x0 {

    /* renamed from: a, reason: collision with root package name */
    public static IXWebLogClient f121792a;

    /* renamed from: b, reason: collision with root package name */
    public static int f121793b = Process.myPid();

    public static void a(IXWebLogClient iXWebLogClient) {
        f121792a = iXWebLogClient;
    }

    public static void b(String str, String str2) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.d(b16, str2);
        } else {
            Log.d(b16, str2);
        }
    }

    public static void c(String str, String str2) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.e(b16, str2);
        } else {
            Log.e(b16, str2);
        }
    }

    public static void d(String str, String str2) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.i(b16, str2);
        } else {
            Log.i(b16, str2);
        }
    }

    public static void e(String str, String str2) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.v(b16, str2);
        } else {
            Log.v(b16, str2);
        }
    }

    public static void f(String str, String str2) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.w(b16, str2);
        } else {
            Log.w(b16, str2);
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        String b16 = b(str);
        IXWebLogClient iXWebLogClient = f121792a;
        if (iXWebLogClient != null) {
            iXWebLogClient.e(b16, str2, th5);
        } else {
            Log.e(b16, str2, th5);
        }
    }

    public static String b(String str) {
        if (str != null && str.startsWith("MicroMsg")) {
            return str;
        }
        if (str != null && str.startsWith("XWeb.Core")) {
            return str;
        }
        return "XWeb.SDK." + str;
    }

    public static void a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        d(str, str2);
        if (XWalkEnvironment.isTurnOnKVLog) {
            a(" " + str + APLogFileUtil.SEPARATOR_LOG + str2);
        }
    }

    public static void a(String str) {
        String str2 = f121793b + APLogFileUtil.SEPARATOR_LOG + new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date()) + APLogFileUtil.SEPARATOR_LOG + str;
        SharedPreferences g16 = y0.g();
        try {
            String str3 = str2 + "\n" + g16.getString("log", "");
            if (str3.length() > 10240) {
                str3 = str3.substring(0, MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE);
            }
            g16.edit().putString("log", str3).apply();
        } catch (Throwable th5) {
            a("XWebLog", "addInitializeLog error", th5);
        }
    }

    public static String a() {
        SharedPreferences g16 = y0.g();
        return g16 == null ? "" : g16.getString("log", "");
    }
}
