package com.tencent.qqperf.monitor.crash.safemode;

import android.content.Context;
import com.tencent.qqperf.crashdefend.report.StartStepCrashReportHelper;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {
    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (context == null) {
                wy3.c.g("SafeModeCrashSaveUtils", "clearStartUpCrashHistory context is null");
                return;
            }
            File b16 = wy3.d.c().b(context, "CD/SU_history/");
            if (b16 == null) {
                wy3.c.g("SafeModeCrashSaveUtils", "clearStartUpCrashHistory dir is null");
                return;
            }
            File[] listFiles = b16.listFiles();
            int length = listFiles.length;
            for (File file : listFiles) {
                if (file != null && file.exists()) {
                    file.delete();
                }
            }
            if (length > 0) {
                StartStepCrashReportHelper.e(length);
            }
            wy3.c.e("SafeModeCrashSaveUtils", "clearStartUpCrashHistory end");
        }
    }

    public static synchronized int b(Context context) {
        synchronized (c.class) {
            if (context == null) {
                wy3.c.g("SafeModeCrashSaveUtils", "getHistoryStartUpCrashCount context is null");
                return -1;
            }
            File b16 = wy3.d.c().b(context, "CD/SU_history/");
            if (b16 != null && b16.listFiles() != null) {
                return b16.listFiles().length;
            }
            wy3.c.g("SafeModeCrashSaveUtils", "getHistoryStartUpCrashCount dir is empty");
            return -1;
        }
    }

    public static synchronized boolean c(Context context, com.tencent.mobileqq.qqperftool.crash.b bVar) {
        synchronized (c.class) {
            if (context != null && bVar != null) {
                File b16 = wy3.d.c().b(context, "CD/SU_history/");
                if (b16 != null && b16.exists()) {
                    File file = new File(b16.getAbsolutePath(), bVar.d() + "_" + bVar.b());
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            return file.createNewFile();
                        } catch (IOException e16) {
                            wy3.c.d("SafeModeCrashSaveUtils", "saveStartUpCrash create file failed! path:" + file.getAbsolutePath(), e16);
                            return false;
                        }
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                wy3.c.g("SafeModeCrashSaveUtils", "saveStartUpCrash dir is invalied");
                return false;
            }
            wy3.c.g("SafeModeCrashSaveUtils", "saveStartUpCrash invalied");
            return false;
        }
    }
}
