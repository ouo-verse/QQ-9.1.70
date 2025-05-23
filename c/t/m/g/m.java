package c.t.m.g;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f29851a = "";

    public static String a() {
        if (e()) {
            return f29851a;
        }
        return l1.g();
    }

    public static String b() {
        if (e()) {
            return "";
        }
        return l1.h();
    }

    public static String c() {
        if (e() || Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        return l1.j();
    }

    public static String d() {
        if (e()) {
            return f29851a;
        }
        return l1.k();
    }

    public static boolean e() {
        return false;
    }
}
