package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.crashdefend.report.StartStepCrashReportHelper;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SafeModeHelper {

    /* renamed from: a, reason: collision with root package name */
    private static a f363205a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicInteger f363206b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        Map<String, Integer> a();

        List<com.tencent.qqperf.monitor.crash.safemode.a> b(Context context);
    }

    public static boolean a() {
        String g16 = AppSetting.g();
        if (g16 == null) {
            wy3.c.c("SafeModeHelper", "checkIsCheckInPublishPackage channel is null!");
            return false;
        }
        boolean equalsIgnoreCase = g16.equalsIgnoreCase(QZoneJsConstants.PKGNAME_QZONE_CHECKIN);
        wy3.c.a("SafeModeHelper", "checkIsCheckInPublishPackage result is " + equalsIgnoreCase + " | channel is " + g16);
        return equalsIgnoreCase;
    }

    public static void b(final Context context) {
        if (context != null && MobileQQ.sProcessId == 1) {
            try {
                new BaseThread(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.safemode.SafeModeHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CrashDefendManager.i().c()) {
                            if (!d.c().e()) {
                                c.a(context);
                                return;
                            }
                            return;
                        }
                        SafeModeCrashMMKVSaveUtils.a(context);
                    }
                }).start();
            } catch (Throwable th5) {
                QLog.e("SafeModeHelper", 1, "clearSafeModeCrashNumOnStartUpEnd Thread start has Exception!", th5);
            }
        }
    }

    private static void c(@NonNull Context context, int i3) {
        a aVar = f363205a;
        if (aVar == null) {
            return;
        }
        List<com.tencent.qqperf.monitor.crash.safemode.a> b16 = aVar.b(context);
        Map<String, Integer> a16 = f363205a.a();
        if (b16 != null && a16 != null) {
            StartStepCrashReportHelper.d(i3);
            for (com.tencent.qqperf.monitor.crash.safemode.a aVar2 : b16) {
                try {
                    if (!a16.containsKey(aVar2.b())) {
                        QLog.w("SafeModeHelper", 1, "ISafeModeStartUpRunner find trigger failed! :" + aVar2.getClass().toString());
                    } else if (i3 >= a16.get(aVar2.b()).intValue()) {
                        aVar2.a(context);
                    }
                } catch (Throwable th5) {
                    QLog.e("SafeModeHelper", 1, com.tencent.qqperf.monitor.crash.safemode.a.class.getSimpleName() + " run has Throwable!", th5);
                }
            }
        }
    }

    private static synchronized int d(Context context) {
        int b16;
        synchronized (SafeModeHelper.class) {
            AtomicInteger atomicInteger = f363206b;
            if (atomicInteger != null) {
                return atomicInteger.get();
            }
            if (context == null && (context = BaseApplication.getContext()) == null) {
                throw new IllegalArgumentException("context is null!");
            }
            if (CrashDefendManager.i().e()) {
                b16 = c.b(context);
            } else {
                b16 = SafeModeCrashMMKVSaveUtils.b(context);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(b16);
            f363206b = atomicInteger2;
            return atomicInteger2.get();
        }
    }

    public static void e(@NonNull a aVar) {
        f363205a = aVar;
    }

    public static boolean f(Context context) {
        if (context == null || d(context) <= 0) {
            return false;
        }
        return true;
    }

    public static void g(Context context) {
        String obj;
        if (context != null && MobileQQ.sProcessId == 1) {
            int d16 = d(context);
            if (QLog.isColorLevel()) {
                QLog.d("SafeModeHelper", 2, "safeModeCheckAtStartup startUpFailedCount = " + d16);
            }
            if (d16 > 0) {
                c(context, d16);
            }
            if (!CrashDefendManager.i().e()) {
                SafeModeCrashMMKVSaveUtils.d(context);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("safeModeCheckAtStartup jump for context = ");
            if (context == null) {
                obj = "null";
            } else {
                obj = context.toString();
            }
            sb5.append(obj);
            QLog.d("SafeModeHelper", 2, sb5.toString());
        }
    }
}
