package com.tencent.mobileqq.ark.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f199651a = false;

    public static synchronized void a() {
        synchronized (a.class) {
            f199651a = true;
            String b16 = h91.b.b();
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.CrashProtect", 2, "profiling clearAllCrashProtectedMark");
            }
            File[] listFiles = new File(b16).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name != null && name.contains(".crash_file")) {
                        if (QLog.isColorLevel()) {
                            QLog.e("ArkApp.CrashProtect", 2, "profiling clearCrashProtectedMark app=", name);
                        }
                        file.delete();
                    }
                }
            }
        }
    }

    public static synchronized boolean b(String str) {
        synchronized (a.class) {
            if (f199651a || TextUtils.isEmpty(str)) {
                return false;
            }
            String c16 = c(str);
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.CrashProtect", 2, "profiling clearCrashProtectedMark appname=", str, ",filePath=", c16);
            }
            return new File(c16).delete();
        }
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return h91.b.b() + File.separator + str + ".crash_file";
    }

    public static synchronized boolean d(String str) {
        synchronized (a.class) {
            boolean z16 = false;
            if (f199651a || TextUtils.isEmpty(str)) {
                return false;
            }
            String c16 = c(str);
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.CrashProtect", 2, "profiling isAppCrash appname=", str, ",filePath=", c16);
            }
            if (new File(c16).exists()) {
                QLog.e("ArkApp.CrashProtect", 1, "profiling find preload crashed app=", str, ",filePath=", c16);
                z16 = true;
            }
            return z16;
        }
    }

    public static synchronized boolean e(String str) {
        synchronized (a.class) {
            boolean z16 = false;
            if (f199651a || TextUtils.isEmpty(str)) {
                return false;
            }
            String c16 = c(str);
            if (QLog.isColorLevel()) {
                QLog.e("ArkApp.CrashProtect", 2, "profiling setCrashProtectedMark appname=", str, ",filePath=", c16);
            }
            try {
                z16 = new File(c16).createNewFile();
            } catch (IOException e16) {
                QLog.d("ArkApp.CrashProtect", 1, "createFile exception", e16);
            }
            return z16;
        }
    }
}
