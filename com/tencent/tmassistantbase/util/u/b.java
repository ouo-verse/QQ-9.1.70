package com.tencent.tmassistantbase.util.u;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static boolean f380541a = true;

    public static void a(String str, String str2) {
        a(str, str2, false);
    }

    public static void a(String str, String str2, boolean z16) {
        if (f380541a) {
            if (z16) {
                a.a().c(str).b(str2).d().c();
            } else {
                a.a().c(str).b(str2).c();
            }
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        if (f380541a) {
            a.a().c(str).b(str2).a(th5);
        }
    }
}
