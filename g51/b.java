package g51;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC10355b f401270a;

    /* renamed from: b, reason: collision with root package name */
    private static InterfaceC10355b f401271b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class a implements InterfaceC10355b {
        a() {
        }

        @Override // g51.b.InterfaceC10355b
        public void d(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }

        @Override // g51.b.InterfaceC10355b
        public void e(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }

        @Override // g51.b.InterfaceC10355b
        public void i(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }

        @Override // g51.b.InterfaceC10355b
        public void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2 + "  " + Log.getStackTraceString(th5));
        }

        @Override // g51.b.InterfaceC10355b
        public void w(String str, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }
    }

    /* compiled from: P */
    /* renamed from: g51.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC10355b {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        a aVar = new a();
        f401270a = aVar;
        f401271b = aVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        InterfaceC10355b interfaceC10355b = f401271b;
        if (interfaceC10355b != null) {
            interfaceC10355b.d(str, str2, objArr);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        InterfaceC10355b interfaceC10355b = f401271b;
        if (interfaceC10355b != null) {
            interfaceC10355b.e(str, str2, objArr);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        InterfaceC10355b interfaceC10355b = f401271b;
        if (interfaceC10355b != null) {
            interfaceC10355b.i(str, str2, objArr);
        }
    }

    public static void d(String str, Throwable th5, String str2, Object... objArr) {
        InterfaceC10355b interfaceC10355b = f401271b;
        if (interfaceC10355b != null) {
            interfaceC10355b.printErrStackTrace(str, th5, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        InterfaceC10355b interfaceC10355b = f401271b;
        if (interfaceC10355b != null) {
            interfaceC10355b.w(str, str2, objArr);
        }
    }
}
