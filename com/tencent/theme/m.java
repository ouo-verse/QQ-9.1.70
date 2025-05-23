package com.tencent.theme;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static ISkinEngineLog f376084a;

    public static void a(String str, int i3, String str2) {
        b(str, i3, str2, null);
    }

    public static void b(String str, int i3, String str2, Throwable th5) {
        ISkinEngineLog iSkinEngineLog = f376084a;
        if (iSkinEngineLog != null) {
            iSkinEngineLog.trace(3, str, i3, str2, th5);
        } else if (SkinEngine.DEBUG || SkinEngine.SWITCH_DEBUG) {
            Log.d(str, str2, th5);
        }
    }

    public static void c(String str, String str2) {
        b(str, 2, str2, null);
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        ISkinEngineLog iSkinEngineLog = f376084a;
        if (iSkinEngineLog != null) {
            iSkinEngineLog.trace(6, str, i3, str2, th5);
        } else if (SkinEngine.DEBUG || SkinEngine.SWITCH_DEBUG) {
            Log.e(str, str2, th5);
        }
    }

    public static void e(String str, int i3, String str2, Throwable th5) {
        ISkinEngineLog iSkinEngineLog = f376084a;
        if (iSkinEngineLog != null) {
            iSkinEngineLog.trace(4, str, i3, str2, th5);
        } else if (SkinEngine.DEBUG || SkinEngine.SWITCH_DEBUG) {
            Log.i(str, str2, th5);
        }
    }

    public static void f(String str, String str2) {
        e(str, 1, str2, null);
    }
}
