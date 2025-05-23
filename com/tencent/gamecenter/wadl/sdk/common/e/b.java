package com.tencent.gamecenter.wadl.sdk.common.e;

import android.util.Log;
import com.tencent.raft.standard.log.IRLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f107231a = false;

    public static void a(String str, String str2) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.d(str, str2);
            } else {
                Log.d(str, str2);
            }
        }
    }

    public static void b(String str, String str2) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.e(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public static void c(String str, String str2) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.i(str, str2);
            } else {
                Log.i(str, str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.v(str, str2);
            } else {
                Log.v(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.w(str, str2);
            } else {
                Log.w(str, str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.d(str, str2, th5);
            } else {
                Log.d(str, str2, th5);
            }
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.e(str, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }
    }

    public static void c(String str, String str2, Throwable th5) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.w(str, str2, th5);
            } else {
                Log.w(str, str2, th5);
            }
        }
    }

    public static void a(String str, Throwable th5) {
        if (f107231a) {
            IRLog iRLog = com.tencent.gamecenter.wadl.sdk.common.a.f106991n;
            if (iRLog != null) {
                iRLog.w(str, "", th5);
            } else {
                Log.w(str, "", th5);
            }
        }
    }

    public static void a(boolean z16) {
        f107231a = z16;
    }
}
