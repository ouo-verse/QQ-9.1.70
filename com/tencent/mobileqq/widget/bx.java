package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bx {

    /* renamed from: c, reason: collision with root package name */
    protected WebViewProgressBar f316789c;

    /* renamed from: g, reason: collision with root package name */
    private float f316793g;

    /* renamed from: h, reason: collision with root package name */
    private float f316794h;

    /* renamed from: i, reason: collision with root package name */
    private float f316795i;

    /* renamed from: j, reason: collision with root package name */
    private float f316796j;

    /* renamed from: k, reason: collision with root package name */
    private float f316797k;

    /* renamed from: m, reason: collision with root package name */
    private long f316799m;

    /* renamed from: a, reason: collision with root package name */
    private byte f316787a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f316788b = 0;

    /* renamed from: d, reason: collision with root package name */
    private Handler f316790d = new b(this);

    /* renamed from: e, reason: collision with root package name */
    private boolean f316791e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f316792f = 255;

    /* renamed from: l, reason: collision with root package name */
    private byte f316798l = 6;

    /* renamed from: n, reason: collision with root package name */
    public boolean f316800n = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: h, reason: collision with root package name */
        private static a f316801h;

        /* renamed from: i, reason: collision with root package name */
        private static a f316802i;

        /* renamed from: a, reason: collision with root package name */
        private int[] f316803a;

        /* renamed from: b, reason: collision with root package name */
        private int f316804b;

        /* renamed from: c, reason: collision with root package name */
        private int f316805c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f316806d;

        /* renamed from: e, reason: collision with root package name */
        private int f316807e;

        /* renamed from: f, reason: collision with root package name */
        private long f316808f;

        /* renamed from: g, reason: collision with root package name */
        private int f316809g;

        public a(int i3) {
            this.f316803a = null;
            this.f316806d = 9000;
            this.f316807e = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
            this.f316804b = i3;
            if (i3 == 0) {
                this.f316806d = 9000;
                this.f316807e = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
            } else {
                this.f316806d = 6000;
                this.f316807e = 1200;
            }
            this.f316808f = 0L;
            this.f316809g = 0;
            this.f316803a = new int[3];
            for (int i16 = 0; i16 < 3; i16++) {
                this.f316803a[i16] = 0;
            }
        }

        private void a() {
            for (int i3 = 0; i3 < 3; i3++) {
                this.f316803a[i3] = 0;
            }
            this.f316809g = 0;
        }

        public static a c(int i3) {
            if (i3 == 0) {
                if (f316801h == null) {
                    f316801h = new a(0);
                }
                return f316801h;
            }
            if (f316802i == null) {
                f316802i = new a(1);
            }
            return f316802i;
        }

        private int d() {
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < 3; i17++) {
                int i18 = this.f316803a[i17];
                if (i18 > 0) {
                    i3++;
                    i16 += i18;
                }
            }
            if (i3 <= 0) {
                return 0;
            }
            return i16 / i3;
        }

        public int b() {
            if (2 == this.f316805c) {
                return this.f316806d;
            }
            return this.f316807e;
        }

        public void e() {
            int i3;
            int i16;
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.f316808f);
            int d16 = d();
            if (this.f316805c == 2) {
                i3 = this.f316806d;
            } else {
                i3 = this.f316807e;
            }
            if (d16 == 0) {
                i16 = i3 * 3;
            } else {
                i16 = d16 * 3;
            }
            if (currentTimeMillis > 100) {
                if (currentTimeMillis > i16) {
                    currentTimeMillis = i16;
                }
                int[] iArr = this.f316803a;
                int i17 = this.f316809g;
                iArr[i17] = (int) (currentTimeMillis * 1.2f);
                int i18 = i17 + 1;
                this.f316809g = i18;
                this.f316809g = i18 % 3;
            }
        }

        public int f() {
            int i3;
            this.f316808f = System.currentTimeMillis();
            int netWorkType = NetworkUtil.getNetWorkType();
            boolean z16 = true;
            QLog.d("mickie", 1, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_NEW_NET_TYPE + netWorkType);
            if (this.f316805c == netWorkType) {
                z16 = false;
            }
            this.f316805c = netWorkType;
            if (z16) {
                if (netWorkType == 2) {
                    i3 = this.f316806d;
                } else {
                    i3 = this.f316807e;
                }
                int i16 = i3;
                a();
                return i16;
            }
            int d16 = d();
            if (d16 <= 0) {
                return 0;
            }
            return d16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<bx> f316810a;

        public b(bx bxVar) {
            super(Looper.getMainLooper());
            this.f316810a = new WeakReference<>(bxVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            bx bxVar = this.f316810a.get();
            if (bxVar != null && message.what == 200) {
                bxVar.i();
            }
        }
    }

    private long n(long j3) {
        if (j3 > 30) {
            return 30L;
        }
        return j3;
    }

    public void a(byte b16) {
        if (!this.f316800n) {
            return;
        }
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 == 2) {
                    byte b17 = this.f316787a;
                    if (b17 == 0 || b17 == 1) {
                        f();
                    }
                    this.f316787a = (byte) 2;
                    return;
                }
                return;
            }
            h();
            return;
        }
        if (this.f316787a == 0) {
            return;
        }
        this.f316787a = (byte) 0;
        g();
    }

    public int b() {
        return this.f316792f;
    }

    public byte c() {
        return this.f316787a;
    }

    public float d() {
        return this.f316797k;
    }

    public byte e() {
        return this.f316798l;
    }

    public void f() {
        a.c(1).e();
        this.f316799m = System.currentTimeMillis();
        this.f316798l = (byte) 5;
        this.f316795i = 0.13333334f;
        float f16 = this.f316794h;
        if (f16 <= 60.0f) {
            this.f316795i = (((60.0f - f16) * 0.5f) + 40.0f) / 300.0f;
            this.f316793g = 0.81666666f;
        } else {
            this.f316793g = (0.13333334f * 245.0f) / (100.0f - f16);
        }
        i();
    }

    public void g() {
        int f16 = a.c(0).f();
        if (f16 <= 0) {
            f16 = a.c(0).b();
        }
        this.f316795i = 20.0f / f16;
        this.f316794h = 0.0f;
        this.f316798l = (byte) 0;
        this.f316797k = this.f316796j;
        this.f316792f = 255;
        this.f316799m = System.currentTimeMillis();
        WebViewProgressBar webViewProgressBar = this.f316789c;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(0);
        }
        i();
    }

    public void h() {
        a.c(0).e();
        int f16 = a.c(1).f();
        if (f16 <= 0) {
            f16 = a.c(1).b();
        }
        this.f316795i = 60.0f / f16;
        this.f316799m = System.currentTimeMillis();
        this.f316798l = (byte) 2;
        this.f316787a = (byte) 1;
        i();
    }

    public void i() {
        if (this.f316798l != 6) {
            long currentTimeMillis = System.currentTimeMillis();
            float f16 = this.f316794h;
            if (f16 >= 100.0f) {
                j();
            } else {
                byte b16 = this.f316798l;
                if (b16 != 0) {
                    if (b16 != 1) {
                        if (b16 != 2) {
                            if (b16 != 3) {
                                if (b16 != 4) {
                                    if (b16 == 5) {
                                        float n3 = (float) n(currentTimeMillis - this.f316799m);
                                        float f17 = this.f316794h + (this.f316795i * n3);
                                        this.f316794h = f17;
                                        this.f316799m = currentTimeMillis;
                                        int i3 = this.f316788b;
                                        float f18 = (i3 * f17) / 100.0f;
                                        this.f316797k = f18;
                                        if (this.f316791e) {
                                            if (f18 >= i3) {
                                                this.f316797k = i3;
                                            }
                                        } else {
                                            int i16 = this.f316792f - ((int) (n3 * this.f316793g));
                                            this.f316792f = i16;
                                            if (i16 <= 0) {
                                                j();
                                                this.f316792f = 0;
                                            }
                                        }
                                    }
                                } else {
                                    this.f316797k = (this.f316788b * f16) / 100.0f;
                                }
                            } else {
                                float n16 = this.f316794h + (((float) n(currentTimeMillis - this.f316799m)) * this.f316795i);
                                this.f316794h = n16;
                                this.f316799m = currentTimeMillis;
                                if (n16 >= 98.0f) {
                                    this.f316799m = currentTimeMillis;
                                    this.f316798l = (byte) 4;
                                    this.f316795i = 0.0f;
                                }
                                this.f316797k = (this.f316788b * n16) / 100.0f;
                            }
                        } else {
                            long n17 = n(currentTimeMillis - this.f316799m);
                            float f19 = this.f316794h;
                            float f26 = (float) n17;
                            float f27 = this.f316795i;
                            float f28 = f19 + (f26 * f27);
                            this.f316794h = f28;
                            this.f316799m = currentTimeMillis;
                            if (f28 >= 80.0f) {
                                this.f316799m = currentTimeMillis;
                                this.f316798l = (byte) 3;
                                this.f316795i = f27 / 20.0f;
                            }
                            this.f316797k = (this.f316788b * f28) / 100.0f;
                        }
                    } else {
                        float n18 = this.f316794h + (((float) n(currentTimeMillis - this.f316799m)) * this.f316795i);
                        this.f316794h = n18;
                        this.f316799m = currentTimeMillis;
                        if (n18 >= 98.0f) {
                            this.f316799m = currentTimeMillis;
                            this.f316798l = (byte) 4;
                            this.f316794h = 98.0f;
                            this.f316795i = 0.0f;
                        }
                        this.f316797k = (this.f316788b * this.f316794h) / 100.0f;
                    }
                } else {
                    long n19 = n(currentTimeMillis - this.f316799m);
                    float f29 = this.f316794h;
                    float f36 = (float) n19;
                    float f37 = this.f316795i;
                    float f38 = f29 + (f36 * f37);
                    this.f316794h = f38;
                    this.f316799m = currentTimeMillis;
                    if (f38 >= 20.0f) {
                        this.f316799m = currentTimeMillis;
                        this.f316798l = (byte) 1;
                        this.f316795i = f37 / 5.0f;
                    }
                    this.f316797k = (this.f316788b * f38) / 100.0f;
                }
            }
            this.f316790d.removeMessages(200);
            this.f316790d.sendEmptyMessageDelayed(200, 20L);
        }
        WebViewProgressBar webViewProgressBar = this.f316789c;
        if (webViewProgressBar != null) {
            webViewProgressBar.invalidate();
        }
    }

    public void j() {
        this.f316798l = (byte) 6;
        this.f316794h = 0.0f;
        this.f316796j = (int) ((0.0f * this.f316788b) / 100.0f);
        this.f316792f = 255;
        this.f316799m = System.currentTimeMillis();
    }

    public void k(WebViewProgressBar webViewProgressBar) {
        this.f316789c = webViewProgressBar;
    }

    public void l(boolean z16) {
        if (z16 != this.f316800n && !z16) {
            if (this.f316787a != 2) {
                a((byte) 2);
            }
            this.f316789c.setVisibility(8);
            this.f316800n = false;
        }
    }

    public void m(int i3) {
        this.f316788b = i3;
    }
}
