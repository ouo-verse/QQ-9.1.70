package com.tencent.luggage.wxa.zp;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static f f146812a;

    /* renamed from: b, reason: collision with root package name */
    public static g f146813b;

    /* renamed from: c, reason: collision with root package name */
    public static b f146814c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c implements b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void e(String str, String str2, Object... objArr) {
            Log.e(str, String.format(str2, objArr));
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void i(String str, String str2, Object... objArr) {
            Log.i(str, String.format(str2, objArr));
        }

        @Override // com.tencent.luggage.wxa.zp.d.b
        public void w(String str, String str2, Object... objArr) {
            Log.w(str, String.format(str2, objArr));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zp.d$d, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6996d implements f {
        public C6996d() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, int i16, long j3, String str2) {
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, com.tencent.luggage.wxa.zp.f fVar, long j3, long j16, String str2, boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, String str2, boolean z16) {
        }

        @Override // com.tencent.luggage.wxa.zp.d.f
        public void a(String str, int i3, Throwable th5) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        void a(String str, int i3, int i16, long j3, String str2);

        void a(String str, int i3, com.tencent.luggage.wxa.zp.f fVar, long j3, long j16, String str2, boolean z16);

        void a(String str, int i3, String str2, boolean z16);

        void a(String str, int i3, Throwable th5);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface g {
        void a(Thread thread, String str, long j3);

        void b(Thread thread, String str, long j3);

        void c(Thread thread, String str, long j3);
    }

    static {
        f146812a = new C6996d();
        f146813b = new e();
        f146814c = new c();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class e implements g {
        public e() {
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void a(Thread thread, String str, long j3) {
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void b(Thread thread, String str, long j3) {
        }

        @Override // com.tencent.luggage.wxa.zp.d.g
        public void c(Thread thread, String str, long j3) {
        }
    }
}
