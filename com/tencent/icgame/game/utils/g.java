package com.tencent.icgame.game.utils;

import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g {
    public static void a(String str, String str2) {
        f.f116101a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static void b(String str, int i3, String str2) {
        f.f116101a.a(str2);
        QLog.e(str, i3, str2);
    }

    public static void c(String str, int i3, String str2, Throwable th5) {
        f.f116101a.a(str2);
        QLog.e(str, i3, str2, th5);
    }

    public static void d(String str, String str2) {
        f.f116101a.a(str2);
        QLog.e(str, 1, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        f.f116101a.a(str2);
        QLog.e(str, 1, str2, th5);
    }

    public static String f(long j3) {
        return "";
    }

    public static void g(String str, int i3, String str2) {
        f.f116101a.a(str2);
        QLog.i(str, i3, str2);
    }

    public static void h(String str, String str2) {
        f.f116101a.a(str2);
        QLog.i(str, 1, str2);
    }

    public static String i(long j3) {
        return LogUtil.getSafePrintUin(String.valueOf(j3));
    }

    public static void j(String str, String str2) {
        f.f116101a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, str2);
        }
    }

    public static void k(String str, String str2, Throwable th5) {
        f.f116101a.a(str2);
        if (QLog.isColorLevel()) {
            QLog.w(str, 2, str2, th5);
        }
    }
}
