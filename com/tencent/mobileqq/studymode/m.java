package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.l;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class m {
    static IPatchRedirector $redirector_;

    public static void a(l lVar, l.a aVar) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "addCallback:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
            return;
        }
        lVar.d(aVar);
    }

    public static int b(l lVar) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "getTargetType:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
            return 0;
        }
        return lVar.m();
    }

    public static boolean c(l lVar) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "isSwitching:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
            return false;
        }
        return lVar.o();
    }

    public static void d(l lVar) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "releaseDialog:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
        }
    }

    public static void e(l lVar, l.a aVar) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "removeCallback:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
            return;
        }
        lVar.v(aVar);
    }

    public static void f(l lVar, int i3) {
        if (lVar == null) {
            QLog.i("ModeSwitchManagerWrapper", 1, "setOldType:: manager is null, stack:" + QLog.getStackTraceString(new Throwable()));
            return;
        }
        lVar.x(i3);
    }
}
