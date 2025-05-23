package com.tencent.luggage.wxa.lo;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static b f133747a;

    /* renamed from: b, reason: collision with root package name */
    public static b f133748b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {
        @Override // com.tencent.luggage.wxa.lo.n.b
        public void d(String str, String str2, Object... objArr) {
            Log.d(str, str2);
        }

        @Override // com.tencent.luggage.wxa.lo.n.b
        public void e(String str, String str2, Object... objArr) {
            Log.e(str, str2);
        }

        @Override // com.tencent.luggage.wxa.lo.n.b
        public void i(String str, String str2, Object... objArr) {
            Log.i(str, str2);
        }

        @Override // com.tencent.luggage.wxa.lo.n.b
        public void v(String str, String str2, Object... objArr) {
            Log.v(str, str2);
        }

        @Override // com.tencent.luggage.wxa.lo.n.b
        public void w(String str, String str2, Object... objArr) {
            Log.w(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        a aVar = new a();
        f133747a = aVar;
        f133748b = aVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        b bVar = f133748b;
        if (bVar != null) {
            bVar.d(str, str2, objArr);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        b bVar = f133748b;
        if (bVar != null) {
            bVar.e(str, str2, objArr);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        b bVar = f133748b;
        if (bVar != null) {
            bVar.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        b bVar = f133748b;
        if (bVar != null) {
            bVar.v(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        b bVar = f133748b;
        if (bVar != null) {
            bVar.w(str, str2, objArr);
        }
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        if (f133748b != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            f133748b.e(str, str2 + "  " + Log.getStackTraceString(th5), new Object[0]);
        }
    }
}
