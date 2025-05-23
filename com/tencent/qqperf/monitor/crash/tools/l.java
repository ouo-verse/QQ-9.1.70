package com.tencent.qqperf.monitor.crash.tools;

import android.os.Build;
import android.text.TextUtils;
import android.util.StringBuilderPrinter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class l {
    private static void a(StringBuilder sb5, Thread[] threadArr, int i3) {
        Thread[] threadArr2;
        int h16;
        Thread[] threadArr3 = new Thread[i3];
        int f16 = f(i3, threadArr, threadArr3);
        if (f16 <= 0 || (h16 = h(i3, threadArr, (threadArr2 = new Thread[i3]))) <= 0) {
            return;
        }
        sb5.append("\nacquireConnectionThreads:\n");
        d(f16, threadArr3, sb5);
        sb5.append("\nexecuteConnectionThreads:\n");
        d(h16, threadArr2, sb5);
    }

    private static void b(StringBuilder sb5) {
        StringBuilder sb6 = new StringBuilder();
        e(sb6);
        String sb7 = sb6.toString();
        if (TextUtils.isEmpty(sb7)) {
            return;
        }
        String k3 = k(sb7);
        sb5.append("\ndbInfo path:");
        sb5.append(k3);
    }

    public static void c(StringBuilder sb5) {
        Thread[] threadArr = new Thread[Thread.activeCount()];
        a(sb5, threadArr, Thread.enumerate(threadArr));
        b(sb5);
    }

    private static void d(int i3, Thread[] threadArr, StringBuilder sb5) {
        for (int i16 = 0; i16 < i3; i16++) {
            Thread thread = threadArr[i16];
            sb5.append(thread.getName());
            sb5.append(", id=");
            sb5.append(thread.getId());
            sb5.append("\n");
        }
    }

    private static void e(StringBuilder sb5) {
        Parameter[] parameters;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return;
            }
            Method g16 = g(Class.forName("android.database.sqlite.SQLiteDatabase").getDeclaredMethods());
            parameters = g16.getParameters();
            QLog.d("SQLiteInfoHelper", 1, "dumpAllSQLiteDatabase " + Arrays.toString(parameters));
            StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb5);
            g16.setAccessible(true);
            if (parameters.length == 2) {
                g16.invoke(null, stringBuilderPrinter, Boolean.TRUE);
            } else if (parameters.length == 3) {
                g16.invoke(null, stringBuilderPrinter, Boolean.TRUE, Boolean.FALSE);
            } else {
                QLog.e("SQLiteInfoHelper", 1, "dumpAllSQLiteDatabase illegal parameter ", g16.toString());
            }
        } catch (Throwable th5) {
            QLog.e("SQLiteInfoHelper", 1, "dumpAllSQLiteDatabase ", th5);
        }
    }

    private static int f(int i3, Thread[] threadArr, Thread[] threadArr2) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Thread thread = threadArr[i17];
            if (i(thread)) {
                threadArr2[i16] = thread;
                i16++;
            }
        }
        return i16;
    }

    private static Method g(Method[] methodArr) {
        for (Method method : methodArr) {
            if ("dumpAll".equals(method.getName())) {
                return method;
            }
        }
        return null;
    }

    private static int h(int i3, Thread[] threadArr, Thread[] threadArr2) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Thread thread = threadArr[i17];
            if (j(thread)) {
                threadArr2[i16] = thread;
                i16++;
            }
        }
        return i16;
    }

    private static boolean i(Thread thread) {
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            if ("android.database.sqlite.SQLiteConnectionPool".equals(stackTraceElement.getClassName()) && "acquireConnection".equals(stackTraceElement.getMethodName())) {
                return true;
            }
        }
        return false;
    }

    private static boolean j(Thread thread) {
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            if ("android.database.sqlite.SQLiteConnection".equals(stackTraceElement.getClassName()) && stackTraceElement.getMethodName().contains("xecute")) {
                return true;
            }
        }
        return false;
    }

    private static String k(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        String str2 = QLog.getLogPath() + (MobileQQ.processName.replace(":", "_") + ".dbInfo." + new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime()) + ".log");
        QLog.d("SQLiteInfoHelper", 1, "dumpAllSQLiteDatabase " + str2);
        FileUtils.writeFile(str.getBytes(), str2, true);
        return str2;
    }
}
