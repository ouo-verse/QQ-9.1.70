package c.t.m.g;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes.dex */
public class o3 {
    public static void a(String str, int i3, String str2) {
    }

    public static void b(String str, String str2) {
        a(str, 4, str2);
    }

    public static void a(String str, String str2) {
        a(str, 6, str2);
    }

    public static void a(String str, String str2, Throwable th5) {
        a(str, 6, str2 + " exception: " + Log.getStackTraceString(th5));
    }

    public static void a(String str) {
        a("#", 4, str);
    }
}
