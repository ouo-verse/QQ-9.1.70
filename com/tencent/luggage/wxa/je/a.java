package com.tencent.luggage.wxa.je;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: k, reason: collision with root package name */
    public static volatile a f130954k = null;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f130955l = false;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f130956m = true;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f130957n = true;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f130958o = true;

    /* renamed from: p, reason: collision with root package name */
    public static volatile boolean f130959p = true;

    /* renamed from: a, reason: collision with root package name */
    public int f130960a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f130961b;

    /* renamed from: c, reason: collision with root package name */
    public long f130962c = 33000;

    /* renamed from: d, reason: collision with root package name */
    public boolean f130963d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f130964e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f130965f;

    /* renamed from: g, reason: collision with root package name */
    public String f130966g;

    /* renamed from: h, reason: collision with root package name */
    public int f130967h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f130968i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f130969j;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.je.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6334a {

        /* renamed from: a, reason: collision with root package name */
        public int f130970a = 0;

        /* renamed from: b, reason: collision with root package name */
        public boolean f130971b = false;

        /* renamed from: c, reason: collision with root package name */
        public final long f130972c = 33000;

        /* renamed from: d, reason: collision with root package name */
        public boolean f130973d = a.f130955l;

        /* renamed from: e, reason: collision with root package name */
        public boolean f130974e = a.f130956m;

        /* renamed from: f, reason: collision with root package name */
        public boolean f130975f = a.f130957n;

        /* renamed from: g, reason: collision with root package name */
        public String f130976g = "medium";

        /* renamed from: h, reason: collision with root package name */
        public int f130977h = 10;

        /* renamed from: i, reason: collision with root package name */
        public boolean f130978i = a.b();

        /* renamed from: j, reason: collision with root package name */
        public boolean f130979j = true;

        public C6334a c(boolean z16) {
            this.f130979j = z16;
            return this;
        }

        public C6334a a(int i3) {
            this.f130970a = i3;
            return this;
        }

        public C6334a b(boolean z16) {
            this.f130978i = z16;
            return this;
        }

        public C6334a a(boolean z16) {
            this.f130971b = z16;
            return this;
        }

        public C6334a a(String str) {
            this.f130976g = str;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public a(C6334a c6334a) {
        this.f130960a = c6334a.f130970a;
        this.f130961b = c6334a.f130971b;
        this.f130963d = c6334a.f130973d;
        this.f130964e = c6334a.f130974e;
        this.f130965f = c6334a.f130975f;
        this.f130966g = c6334a.f130976g;
        this.f130967h = c6334a.f130977h;
        this.f130968i = c6334a.f130978i;
        this.f130969j = c6334a.f130979j;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f130954k == null) {
                f130954k = new C6334a().a();
            }
            aVar = f130954k;
        }
        return aVar;
    }

    public static boolean b() {
        w.d("MicroMsg.Ble.BleConfig", "isDefaultRefreshCache, defaultRefreshCache: " + f130959p);
        return f130959p;
    }

    public String toString() {
        return "BleConfig{interval=" + this.f130960a + ", allowDuplicatesKey=" + this.f130961b + ", actionTimeOutTime=" + this.f130962c + ", debug=" + this.f130963d + ", mainThread=" + this.f130964e + ", serial=" + this.f130965f + ", mode='" + this.f130966g + "', actionDelayTime=" + this.f130967h + ", scanWorkaround=" + this.f130969j + '}';
    }

    public static synchronized void a(a aVar) {
        synchronized (a.class) {
            f130954k = aVar;
        }
    }

    public static void a(boolean z16) {
        w.d("MicroMsg.Ble.BleConfig", "setDefaultRefreshCache, defaultRefreshCache: " + z16);
        f130959p = z16;
    }
}
