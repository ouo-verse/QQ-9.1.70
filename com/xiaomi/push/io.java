package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class io {

    /* renamed from: a, reason: collision with root package name */
    public static final String f389426a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f389427b;

    /* renamed from: c, reason: collision with root package name */
    private static int f389428c;

    static {
        String str;
        if (b.f388236a) {
            str = "ONEBOX";
        } else {
            str = "@SHIP.TO.2A2FE0D7@";
        }
        f389426a = str;
        f389427b = false;
        f389428c = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f389428c = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f389428c = 3;
        } else {
            f389428c = 1;
        }
    }

    public static int a() {
        return f389428c;
    }

    public static void b(int i3) {
        f389428c = i3;
    }

    public static boolean c() {
        if (f389428c == 2) {
            return true;
        }
        return false;
    }

    public static boolean d() {
        if (f389428c == 3) {
            return true;
        }
        return false;
    }
}
