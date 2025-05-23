package com.tencent.mobileqq.qqperftool;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperftool.common.e;
import com.tencent.mobileqq.qqperftool.crash.d;
import com.tencent.mobileqq.qqperftool.crash.i;
import com.tencent.mobileqq.qqperftool.crash.m;
import com.tencent.mobileqq.qqperftool.crashdefend.b;
import com.tencent.mobileqq.qqperftool.crashdefend.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile i f274248a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f274249b;

    public static boolean a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (f274249b == null) {
            e.b("QQPerfTool", "addConfigCrashDefender crashDefendManager is null!");
            return false;
        }
        return f274249b.c(str, str2, str3);
    }

    public static boolean b(d dVar) {
        if (f274248a == null) {
            e.b("QQPerfTool", "addCrashCommonRecorder crashDefendManager is null!");
            return false;
        }
        return f274248a.a(dVar);
    }

    public static boolean c(String str) {
        if (f274249b == null) {
            e.f("QQPerfTool", "containCrashDefender crashDefendManager is null!");
            return false;
        }
        return f274249b.d(str);
    }

    public static boolean d() {
        if (f274249b == null) {
            e.b("QQPerfTool", "endStartStepCrashDefend crashDefendManager is null!");
            return false;
        }
        return f274249b.e();
    }

    public static List<com.tencent.mobileqq.qqperftool.crash.b> e() {
        if (f274249b == null) {
            e.f("QQPerfTool", "getStartStepCrashList crashDefendManager is null!");
            return null;
        }
        return f274249b.f();
    }

    public static void f(boolean z16, boolean z17) {
        if (f274248a == null) {
            f274248a = new i();
            f274248a.c(z16, z17);
            f274249b = new b();
            f274249b.g();
            f274248a.g(f274249b);
            f274248a.a(new m());
        }
    }

    public static boolean g(f.a aVar) {
        if (f274249b == null) {
            e.b("QQPerfTool", "initStartStepCrashDefend crashDefendManager is null!");
            return false;
        }
        return f274249b.h(aVar);
    }

    public static boolean h() {
        if (f274248a == null) {
            return false;
        }
        return f274248a.b();
    }

    public static boolean i(@NonNull Thread thread, @NonNull Throwable th5) {
        if (f274248a == null) {
            return false;
        }
        f274248a.d(thread, th5);
        return true;
    }

    public static void j(boolean z16) {
        if (f274248a == null) {
            e.b("QQPerfTool", "registerToSystem lightCrashCatcher is null!");
        } else {
            f274248a.e(z16);
        }
    }

    public static void k(d dVar) {
        if (f274248a == null) {
            e.b("QQPerfTool", "removeCrashCommonRecorder crashDefendManager is null!");
        } else {
            f274248a.f(dVar);
        }
    }

    public static boolean l(@NonNull String str) {
        if (f274249b == null) {
            e.b("QQPerfTool", "removeCrashDefenderByName crashDefendManager is null!");
            return false;
        }
        return f274249b.i(str);
    }

    public static void m(com.tencent.mobileqq.qqperftool.common.d dVar) {
        e.e(dVar);
    }

    public static void n() {
        if (f274248a != null) {
            f274248a.h();
        }
    }
}
