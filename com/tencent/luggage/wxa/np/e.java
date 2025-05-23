package com.tencent.luggage.wxa.np;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static c f135893a = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void a(String str, Throwable th5, String str2) {
            th5.printStackTrace();
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void d(String str, String str2, Object... objArr) {
            try {
                Log.d(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void e(String str, String str2, Object... objArr) {
            try {
                Log.e(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void i(String str, String str2, Object... objArr) {
            try {
                Log.i(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void v(String str, String str2, Object... objArr) {
            try {
                Log.v(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.luggage.wxa.np.c
        public void w(String str, String str2, Object... objArr) {
            try {
                Log.w(str, String.format(str2, objArr));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void a(c cVar) {
        if (cVar != null) {
            f135893a = cVar;
            return;
        }
        throw new RuntimeException("logInstance can not be null");
    }

    public static void b(String str, String str2, Object... objArr) {
        f135893a.e(str, str2, objArr);
    }

    public static void c(String str, String str2, Object... objArr) {
        f135893a.i(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        f135893a.v(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        f135893a.w(str, str2, objArr);
    }

    public static void a(String str, String str2, Object... objArr) {
        f135893a.d(str, str2, objArr);
    }

    public static void a(String str, Throwable th5, String str2) {
        f135893a.a(str, th5, str2);
    }
}
