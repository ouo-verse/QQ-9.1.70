package com.tencent.luggage.wxa.a9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static e f120975a = new d();

    public static void a(e eVar) {
        if (eVar != null) {
            f120975a = eVar;
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        f120975a.i(str, str2, objArr);
    }

    public static void a(String str, String str2, Object... objArr) {
        f120975a.e(str, str2, objArr);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        f120975a.printStackTrace(str, th5, str2, objArr);
    }
}
