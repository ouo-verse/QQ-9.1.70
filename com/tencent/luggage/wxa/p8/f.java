package com.tencent.luggage.wxa.p8;

import com.tencent.luggage.wxa.h.b;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static e f137421a = new d();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f137422a;

        public a(e eVar) {
            this.f137422a = eVar;
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void d(String str, String str2, Object... objArr) {
            this.f137422a.d(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void e(String str, String str2, Object... objArr) {
            this.f137422a.e(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void i(String str, String str2, Object... objArr) {
            this.f137422a.i(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            this.f137422a.printStackTrace(str, th5, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void w(String str, String str2, Object... objArr) {
            this.f137422a.w(str, str2, objArr);
        }
    }

    public static void a(e eVar) {
        if (eVar != null) {
            f137421a = eVar;
            b(eVar);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        f137421a.e(str, str2, objArr);
    }

    public static void c(String str, String str2, Object... objArr) {
        f137421a.i(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        f137421a.w(str, str2, objArr);
    }

    public static void b(e eVar) {
        com.tencent.luggage.wxa.h.b.a(new a(eVar));
    }

    public static void a(String str, String str2, Object... objArr) {
        f137421a.d(str, str2, objArr);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        f137421a.printStackTrace(str, th5, str2, objArr);
    }
}
