package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f {
    public static boolean a(String str) {
        com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        boolean P = eVar.P();
        if (QLog.isColorLevel()) {
            QLog.i("ExpandSharePreUtils", 2, "check850SaveEmptyAIONode startLabSaveEmptyAIONode \uff1a " + P);
        }
        return P && (eVar.f(str) == 0);
    }

    public static String b(String str) {
        return "";
    }

    public static int c(String str) {
        return 0;
    }

    public static String d(String str) {
        return "";
    }

    public static long e(String str) {
        return 0L;
    }

    public static boolean f(String str) {
        return false;
    }

    public static void g(String str, long j3) {
    }

    public static void h(String str, String str2) {
    }

    public static void j(String str, long j3) {
    }

    public static void i(String str, int i3, String str2) {
    }
}
