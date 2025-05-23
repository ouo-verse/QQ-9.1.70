package com.tencent.component.core.log;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import et3.a;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LogUtil {
    private static final int D = 1;
    private static final int E = 4;
    private static final int I = 2;
    private static final String LOG_TAG = "[QQLive]";
    private static final int V = 0;
    private static final int W = 3;
    private static final int WTF = 5;
    private static IAegisLogApi aegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private static boolean mIsDebug = false;
    private static List<LogCallback> sCallbacks = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface LogCallback {
        void onLog(int i3, String str, String str2);
    }

    public static int a(String str, String str2, Object... objArr) {
        aegisLogApi.a(str, buildWholeMessage(str2, objArr));
        return 0;
    }

    public static void addLogCallback(LogCallback logCallback) {
        if (!sCallbacks.contains(logCallback)) {
            sCallbacks.add(logCallback);
        }
    }

    private static String buildWholeMessage(String str, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            return LOG_TAG + String.format(str, objArr);
        }
        return "[QQLive][T_" + Thread.currentThread().getName() + "]" + str;
    }

    public static int d(String str, String str2, Object... objArr) {
        if (QLog.isColorLevel()) {
            aegisLogApi.d(str, buildWholeMessage(str2, objArr));
            return 0;
        }
        return 0;
    }

    public static int e(String str, String str2, Object... objArr) {
        aegisLogApi.e(str, 1, buildWholeMessage(str2, objArr));
        return 0;
    }

    public static String generateStackTraceString(StackTraceElement[] stackTraceElementArr, String str) {
        try {
            StringBuilder sb5 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                sb5.append(str);
                sb5.append(stackTraceElement);
                sb5.append("\n");
            }
            return sb5.toString();
        } catch (Exception unused) {
            return "generateStackTraceString err";
        }
    }

    static String generateThrowableString(Throwable th5, String str) {
        return handleThrowableFirstLine(th5, str) + generateStackTraceString(th5.getStackTrace(), "");
    }

    private static String handleThrowableFirstLine(Throwable th5, String str) {
        return str + MsgSummary.STR_COLON + th5.getMessage() + "\n";
    }

    public static int i(String str, String str2, Object... objArr) {
        aegisLogApi.i(str, 1, buildWholeMessage(str2, objArr));
        return 0;
    }

    public static boolean isDebug() {
        return mIsDebug;
    }

    public static int printException(String str, Throwable th5, String str2) {
        aegisLogApi.e(str, 1, generateThrowableString(th5, str2));
        return 0;
    }

    public static int printStackTrace(Throwable th5) {
        return printException("exception", th5, "");
    }

    public static void removeLogCallback(LogCallback logCallback) {
        sCallbacks.remove(logCallback);
    }

    public static int v(String str, String str2, Object... objArr) {
        if (QLog.isColorLevel()) {
            aegisLogApi.d(str, buildWholeMessage(str2, objArr));
            return 0;
        }
        return 0;
    }

    public static int w(String str, String str2, Object... objArr) {
        aegisLogApi.w(str, 1, buildWholeMessage(str2, objArr));
        return 0;
    }

    public static String wrapLogUin(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 4) {
            return str.substring(0, 4) + "*";
        }
        return str;
    }

    public static int a(String str, a aVar, String str2, Object... objArr) {
        aegisLogApi.a(str, buildWholeMessage(str2, objArr), aVar);
        return 0;
    }

    public static int printStackTrace(String str, Throwable th5) {
        return printException(str, th5, "");
    }

    public static void init(Context context, String str, boolean z16) {
    }
}
