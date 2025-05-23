package com.tencent.luggage.wxa.s1;

import com.tencent.luggage.wxa.e2.a;
import com.tencent.luggage.wxa.p8.f;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final a.C6146a f140001a = new a.C6146a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.p8.e {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.p8.e
        public void d(String str, String str2, Object... objArr) {
            w.a(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.p8.e
        public void e(String str, String str2, Object... objArr) {
            w.b(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.p8.e
        public void i(String str, String str2, Object... objArr) {
            w.d(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.p8.e
        public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            w.a(str, th5, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.p8.e
        public void w(String str, String str2, Object... objArr) {
            w.h(str, str2, objArr);
        }
    }

    public void a() {
        long a16 = w0.a();
        com.tencent.luggage.wxa.p8.b.a();
        w.d("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush [%d]ms", Long.valueOf(w0.e(a16)));
    }

    public void b() {
        com.tencent.luggage.wxa.e2.a.a(f140001a, new a());
    }

    public void c() {
        a();
        f.a(new b());
    }
}
