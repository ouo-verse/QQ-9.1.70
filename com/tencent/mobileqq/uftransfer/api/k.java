package com.tencent.mobileqq.uftransfer.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f304921a;

    /* renamed from: b, reason: collision with root package name */
    private final d f304922b;

    /* renamed from: c, reason: collision with root package name */
    private final a f304923c;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f304924a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f304925b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f304926c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f304927d;

        /* renamed from: e, reason: collision with root package name */
        private b f304928e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f304924a = false;
            this.f304925b = false;
            this.f304926c = false;
            this.f304927d = false;
            this.f304928e = new b();
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "DownloadConfig{useExtf=" + this.f304924a + ", useHttps=" + this.f304925b + ", useIPv6=" + this.f304926c + ", useMediaPlatform=" + this.f304927d + ", extfCfg=" + this.f304928e.toString() + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f304929a;

        /* renamed from: b, reason: collision with root package name */
        public int f304930b;

        /* renamed from: c, reason: collision with root package name */
        public int f304931c;

        /* renamed from: d, reason: collision with root package name */
        public int f304932d;

        /* renamed from: e, reason: collision with root package name */
        public int f304933e;

        /* renamed from: f, reason: collision with root package name */
        public int f304934f;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f304929a = 524288L;
            this.f304930b = 3;
            this.f304931c = 30;
            this.f304932d = 1000;
            this.f304933e = 2000;
            this.f304934f = 10;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "ExtfDownloadCfg{sliceSize=" + this.f304929a + ", maxParrallelSlice=" + this.f304930b + ", maxWaitingSlice=" + this.f304931c + ", notifyIntervals=" + this.f304932d + ", speedDuration=" + this.f304933e + ", sliceNum=" + this.f304934f + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f304935a;

        /* renamed from: b, reason: collision with root package name */
        private int f304936b;

        /* renamed from: c, reason: collision with root package name */
        private int f304937c;

        /* renamed from: d, reason: collision with root package name */
        private int f304938d;

        /* renamed from: e, reason: collision with root package name */
        private int f304939e;

        /* renamed from: f, reason: collision with root package name */
        private int f304940f;

        /* renamed from: g, reason: collision with root package name */
        private long f304941g;

        /* renamed from: h, reason: collision with root package name */
        private long f304942h;

        /* renamed from: i, reason: collision with root package name */
        private long f304943i;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f304935a = 10485760L;
            this.f304936b = 3;
            this.f304937c = 524288;
            this.f304938d = 200;
            this.f304939e = 27;
            this.f304940f = 10;
            this.f304941g = 7000L;
            this.f304942h = 21000L;
            this.f304943i = 120000L;
        }

        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
            }
            return this.f304941g;
        }

        public long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
            }
            return this.f304942h;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f304936b;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.f304939e;
        }

        public int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.f304940f;
        }

        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.f304938d;
        }

        public long g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.f304935a;
        }

        public int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.f304937c;
        }

        public long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
            }
            return this.f304943i;
        }

        public void j(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, j3);
            } else {
                this.f304941g = j3;
            }
        }

        public void k(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, j3);
            } else {
                this.f304942h = j3;
            }
        }

        public void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.f304936b = i3;
            }
        }

        public void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.f304939e = i3;
            }
        }

        public void n(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, i3);
            } else {
                this.f304940f = i3;
            }
        }

        public void o(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.f304938d = i3;
            }
        }

        public void p(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.f304935a = j3;
            }
        }

        public void q(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.f304937c = i3;
            }
        }

        public void r(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, j3);
            } else {
                this.f304943i = j3;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (String) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return "ExtfUploadCfg{muliFileSizeLimit=" + this.f304935a + ", maxChannelNum=" + this.f304936b + ", pieceSize=" + this.f304937c + ", maxEachHostTotalUseCount=" + this.f304938d + ", maxEachHostErrorCount=" + this.f304939e + ", maxEachHostParallelUseCount=" + this.f304940f + ", connectTimeout=" + this.f304941g + ", dataTimeout=" + this.f304942h + ", totoalDataTimeout=" + this.f304943i + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f304944a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f304945b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f304946c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f304947d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f304948e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f304949f;

        /* renamed from: g, reason: collision with root package name */
        private c f304950g;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f304944a = false;
            this.f304945b = false;
            this.f304946c = false;
            this.f304947d = false;
            this.f304948e = false;
            this.f304949f = false;
            this.f304950g = new c();
        }

        public c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (c) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.f304950g;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.f304945b;
        }

        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            return this.f304948e;
        }

        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.f304944a;
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.f304946c;
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.f304947d;
        }

        public boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.f304949f;
        }

        public void h(c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) cVar);
            } else {
                this.f304950g = cVar;
            }
        }

        public void i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.f304945b = z16;
            }
        }

        public void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else {
                this.f304948e = z16;
            }
        }

        public void k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.f304944a = z16;
            }
        }

        public void l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.f304946c = z16;
            }
        }

        public void m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                this.f304947d = z16;
            }
        }

        public void n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, z16);
            } else {
                this.f304949f = z16;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "UploadConfig{useExtf=" + this.f304944a + ", extfSafeGuard=" + this.f304945b + ", useHttps=" + this.f304946c + ", useIPv6=" + this.f304947d + ", ftnSpeedTest=" + this.f304948e + ", useMediaPlatform=" + this.f304949f + ", extfCfg=" + this.f304950g.toString() + '}';
        }
    }

    public k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.f304922b = new d();
        this.f304923c = new a();
        this.f304921a = z16;
    }

    public d a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f304922b;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f304921a) {
            return "UFTTransferConfig{" + this.f304922b.toString() + "}";
        }
        return "UFTTransferConfig{" + this.f304923c.toString() + "}";
    }
}
