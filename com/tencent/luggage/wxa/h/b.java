package com.tencent.luggage.wxa.h;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static c f126828a = new C6250b();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6250b implements c {
        public C6250b() {
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void d(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    Log.e(str, "", e16);
                    return;
                }
            }
            Log.d(str, str2);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void e(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    Log.e(str, "", e16);
                    return;
                }
            }
            Log.e(str, str2);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void i(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    Log.e(str, "", e16);
                    return;
                }
            }
            Log.i(str, str2);
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void printStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            if (th5 != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length > 0) {
                            str2 = String.format(str2, objArr);
                        }
                    } catch (Exception e16) {
                        Log.e(str, "", e16);
                        return;
                    }
                }
                Log.e(str, str2, th5);
            }
        }

        @Override // com.tencent.luggage.wxa.h.b.c
        public void w(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        str2 = String.format(str2, objArr);
                    }
                } catch (Exception e16) {
                    Log.e(str, "", e16);
                    return;
                }
            }
            Log.w(str, str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printStackTrace(String str, Throwable th5, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(c cVar) {
        if (cVar != null) {
            f126828a = cVar;
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        f126828a.e(str, str2, objArr);
    }

    public static void c(String str, String str2, Object... objArr) {
        f126828a.i(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        f126828a.w(str, str2, objArr);
    }

    public static void a(String str, String str2, Object... objArr) {
        f126828a.d(str, str2, objArr);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        f126828a.printStackTrace(str, th5, str2, objArr);
    }
}
