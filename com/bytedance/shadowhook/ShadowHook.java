package com.bytedance.shadowhook;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShadowHook {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f31936a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f31937b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static long f31938c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f31939d = Mode.SHARED.getValue();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Mode {
        SHARED(0),
        UNIQUE(1);

        private final int value;

        Mode(int i3) {
            this.value = i3;
        }

        int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f31943a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f31944b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f31945c;

        public b() {
            ShadowHook.a();
            this.f31943a = ShadowHook.f31939d;
            this.f31944b = false;
            this.f31945c = false;
        }

        public a a() {
            a aVar = new a();
            aVar.f(null);
            aVar.g(this.f31943a);
            aVar.e(this.f31944b);
            aVar.h(this.f31945c);
            return aVar;
        }

        public b b(boolean z16) {
            this.f31944b = z16;
            return this;
        }

        public b c(Mode mode) {
            this.f31943a = mode.getValue();
            return this;
        }

        public b d(boolean z16) {
            this.f31945c = z16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface c {
    }

    static /* synthetic */ c a() {
        return null;
    }

    public static synchronized int c(a aVar) {
        synchronized (ShadowHook.class) {
            if (f31936a) {
                return f31937b;
            }
            f31936a = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar == null) {
                aVar = new b().a();
            }
            if (!d(aVar)) {
                f31937b = 100;
                f31938c = System.currentTimeMillis() - currentTimeMillis;
                return f31937b;
            }
            try {
                f31937b = nativeInit(aVar.c(), aVar.a());
            } catch (Throwable unused) {
                f31937b = 101;
            }
            if (aVar.d()) {
                try {
                    nativeSetRecordable(aVar.d());
                } catch (Throwable unused2) {
                    f31937b = 101;
                }
            }
            f31938c = System.currentTimeMillis() - currentTimeMillis;
            return f31937b;
        }
    }

    private static boolean d(a aVar) {
        if (aVar != null) {
            try {
                aVar.b();
            } catch (Throwable unused) {
                return false;
            }
        }
        System.loadLibrary("shadowhook");
        return true;
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int i3);

    private static native String nativeGetVersion();

    private static native int nativeInit(int i3, boolean z16);

    private static native void nativeSetDebuggable(boolean z16);

    private static native void nativeSetRecordable(boolean z16);

    private static native String nativeToErrmsg(int i3);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f31940a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f31941b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f31942c;

        public boolean a() {
            return this.f31941b;
        }

        public c b() {
            return null;
        }

        public int c() {
            return this.f31940a;
        }

        public boolean d() {
            return this.f31942c;
        }

        public void e(boolean z16) {
            this.f31941b = z16;
        }

        public void g(int i3) {
            this.f31940a = i3;
        }

        public void h(boolean z16) {
            this.f31942c = z16;
        }

        public void f(c cVar) {
        }
    }
}
