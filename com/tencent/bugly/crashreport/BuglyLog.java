package com.tencent.bugly.crashreport;

import android.util.Log;
import com.tencent.bugly.proguard.ay;
import com.tencent.bugly.proguard.p;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.d(str, str2);
        }
        ay.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.e(str, str2);
        }
        ay.a("E", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.i(str, str2);
        }
        ay.a("I", str, str2);
    }

    public static void setCache(int i3) {
        ay.a(i3);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.v(str, str2);
        }
        ay.a("V", str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.w(str, str2);
        }
        ay.a("W", str, str2);
    }

    public static void e(String str, String str2, Throwable th5) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        if (p.f98529c) {
            Log.e(str, str2, th5);
        }
        ay.a("E", str, th5);
    }
}
