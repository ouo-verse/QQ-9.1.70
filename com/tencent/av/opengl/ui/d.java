package com.tencent.av.opengl.ui;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f74145a;

    /* renamed from: b, reason: collision with root package name */
    private final a f74146b;

    /* renamed from: c, reason: collision with root package name */
    private final a f74147c;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f74148d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f74149e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: o, reason: collision with root package name */
        private static float f74150o;

        /* renamed from: p, reason: collision with root package name */
        private static float f74151p = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* renamed from: q, reason: collision with root package name */
        private static final float[] f74152q = new float[101];

        /* renamed from: r, reason: collision with root package name */
        private static final float[] f74153r = new float[101];

        /* renamed from: a, reason: collision with root package name */
        private int f74154a;

        /* renamed from: b, reason: collision with root package name */
        private int f74155b;

        /* renamed from: c, reason: collision with root package name */
        private int f74156c;

        /* renamed from: d, reason: collision with root package name */
        private int f74157d;

        /* renamed from: e, reason: collision with root package name */
        private float f74158e;

        /* renamed from: f, reason: collision with root package name */
        private float f74159f;

        /* renamed from: g, reason: collision with root package name */
        private long f74160g;

        /* renamed from: h, reason: collision with root package name */
        private int f74161h;

        /* renamed from: i, reason: collision with root package name */
        private int f74162i;

        /* renamed from: j, reason: collision with root package name */
        private int f74163j;

        /* renamed from: l, reason: collision with root package name */
        private int f74165l;

        /* renamed from: m, reason: collision with root package name */
        private float f74166m = ViewConfiguration.getScrollFriction();

        /* renamed from: n, reason: collision with root package name */
        private int f74167n = 0;

        /* renamed from: k, reason: collision with root package name */
        private boolean f74164k = true;

        static {
            float f16;
            float f17;
            float f18;
            float f19;
            float f26;
            float f27;
            float f28;
            float f29;
            float f36;
            float f37;
            float f38 = 0.0f;
            float f39 = 0.0f;
            for (int i3 = 0; i3 < 100; i3++) {
                float f46 = i3 / 100.0f;
                float f47 = 1.0f;
                while (true) {
                    f16 = 2.0f;
                    f17 = ((f47 - f38) / 2.0f) + f38;
                    f18 = 3.0f;
                    f19 = 1.0f - f17;
                    f26 = f17 * 3.0f * f19;
                    f27 = f17 * f17 * f17;
                    float f48 = (((f19 * 0.175f) + (f17 * 0.35000002f)) * f26) + f27;
                    if (Math.abs(f48 - f46) < 1.0E-5d) {
                        break;
                    } else if (f48 > f46) {
                        f47 = f17;
                    } else {
                        f38 = f17;
                    }
                }
                f74152q[i3] = (f26 * ((f19 * 0.5f) + f17)) + f27;
                float f49 = 1.0f;
                while (true) {
                    f28 = ((f49 - f39) / f16) + f39;
                    f29 = 1.0f - f28;
                    f36 = f28 * f18 * f29;
                    f37 = f28 * f28 * f28;
                    float f56 = (((f29 * 0.5f) + f28) * f36) + f37;
                    if (Math.abs(f56 - f46) < 1.0E-5d) {
                        break;
                    }
                    if (f56 > f46) {
                        f49 = f28;
                    } else {
                        f39 = f28;
                    }
                    f16 = 2.0f;
                    f18 = 3.0f;
                }
                f74153r[i3] = (f36 * ((f29 * 0.175f) + (f28 * 0.35000002f))) + f37;
            }
            float[] fArr = f74152q;
            f74153r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        a() {
        }

        private void g(int i3, int i16, int i17) {
            float abs = Math.abs((i17 - i3) / (i16 - i3));
            int i18 = (int) (abs * 100.0f);
            if (i18 < 100) {
                float f16 = i18 / 100.0f;
                int i19 = i18 + 1;
                float[] fArr = f74153r;
                float f17 = fArr[i18];
                this.f74161h = (int) (this.f74161h * (f17 + (((abs - f16) / ((i19 / 100.0f) - f16)) * (fArr[i19] - f17))));
            }
        }

        private void j(int i3, int i16, int i17) {
            float f16 = this.f74159f;
            float sqrt = (float) Math.sqrt((((((i17 * i17) / 2.0f) / Math.abs(f16)) + Math.abs(i16 - i3)) * 2.0d) / Math.abs(this.f74159f));
            this.f74160g -= (int) ((sqrt - ((-i17) / f16)) * 1000.0f);
            this.f74154a = i16;
            this.f74157d = (int) ((-this.f74159f) * sqrt);
        }

        private static float l(int i3) {
            if (i3 > 0) {
                return -2000.0f;
            }
            return 2000.0f;
        }

        private double m(int i3) {
            return Math.log((Math.abs(i3) * 0.35f) / (this.f74166m * f74150o));
        }

        private double n(int i3) {
            double m3 = m(i3);
            float f16 = f74151p;
            return this.f74166m * f74150o * Math.exp((f16 / (f16 - 1.0d)) * m3);
        }

        private int o(int i3) {
            return (int) (Math.exp(m(i3) / (f74151p - 1.0d)) * 1000.0d);
        }

        static void p(Context context) {
            f74150o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void q() {
            int i3 = this.f74157d;
            float abs = (i3 * i3) / (Math.abs(this.f74159f) * 2.0f);
            float signum = Math.signum(this.f74157d);
            int i16 = this.f74165l;
            if (abs > i16) {
                float f16 = -signum;
                int i17 = this.f74157d;
                this.f74159f = ((f16 * i17) * i17) / (i16 * 2.0f);
                abs = i16;
            }
            this.f74165l = (int) abs;
            this.f74167n = 2;
            int i18 = this.f74154a;
            int i19 = this.f74157d;
            if (i19 <= 0) {
                abs = -abs;
            }
            this.f74156c = i18 + ((int) abs);
            this.f74161h = -((int) ((i19 * 1000.0f) / this.f74159f));
        }

        private void r(int i3, int i16, int i17, int i18) {
            boolean z16;
            int i19;
            int i26;
            int i27;
            boolean z17 = true;
            if (i3 > i16 && i3 < i17) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.f74164k = true;
                return;
            }
            if (i3 > i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i19 = i17;
            } else {
                i19 = i16;
            }
            if ((i3 - i19) * i18 < 0) {
                z17 = false;
            }
            if (z17) {
                s(i3, i19, i18);
                return;
            }
            if (n(i18) > Math.abs(r4)) {
                if (z16) {
                    i26 = i16;
                } else {
                    i26 = i3;
                }
                if (z16) {
                    i27 = i3;
                } else {
                    i27 = i17;
                }
                k(i3, i18, i26, i27, this.f74165l);
                return;
            }
            u(i3, i19, i18);
        }

        private void s(int i3, int i16, int i17) {
            int i18;
            if (i17 == 0) {
                i18 = i3 - i16;
            } else {
                i18 = i17;
            }
            this.f74159f = l(i18);
            j(i3, i16, i17);
            q();
        }

        private void u(int i3, int i16, int i17) {
            this.f74164k = false;
            this.f74167n = 1;
            this.f74154a = i3;
            this.f74156c = i16;
            int i18 = i3 - i16;
            this.f74159f = l(i18);
            this.f74157d = -i18;
            this.f74165l = Math.abs(i18);
            this.f74161h = (int) (Math.sqrt((i18 * (-2.0d)) / this.f74159f) * 1000.0d);
        }

        boolean h() {
            int i3 = this.f74167n;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                if (i3 == 2) {
                    this.f74160g += this.f74161h;
                    u(this.f74156c, this.f74154a, 0);
                }
            } else {
                if (this.f74161h >= this.f74162i) {
                    return false;
                }
                this.f74154a = this.f74156c;
                int i16 = (int) this.f74158e;
                this.f74157d = i16;
                this.f74159f = l(i16);
                this.f74160g += this.f74161h;
                q();
            }
            v();
            return true;
        }

        void i() {
            this.f74155b = this.f74156c;
            this.f74164k = true;
        }

        void k(int i3, int i16, int i17, int i18, int i19) {
            double d16;
            this.f74165l = i19;
            this.f74164k = false;
            this.f74157d = i16;
            this.f74158e = i16;
            this.f74162i = 0;
            this.f74161h = 0;
            this.f74160g = AnimationUtils.currentAnimationTimeMillis();
            this.f74154a = i3;
            this.f74155b = i3;
            if (i3 <= i18 && i3 >= i17) {
                this.f74167n = 0;
                if (i16 != 0) {
                    int o16 = o(i16);
                    this.f74162i = o16;
                    this.f74161h = o16;
                    d16 = n(i16);
                } else {
                    d16 = 0.0d;
                }
                int signum = (int) (d16 * Math.signum(r0));
                this.f74163j = signum;
                int i26 = i3 + signum;
                this.f74156c = i26;
                if (i26 < i17) {
                    g(this.f74154a, i26, i17);
                    this.f74156c = i17;
                }
                int i27 = this.f74156c;
                if (i27 > i18) {
                    g(this.f74154a, i27, i18);
                    this.f74156c = i18;
                    return;
                }
                return;
            }
            r(i3, i17, i18, i16);
        }

        void t(int i3, int i16, int i17) {
            this.f74164k = false;
            this.f74154a = i3;
            this.f74156c = i3 + i16;
            this.f74160g = AnimationUtils.currentAnimationTimeMillis();
            this.f74161h = i17;
            this.f74159f = 0.0f;
            this.f74157d = 0;
        }

        boolean v() {
            float f16;
            float f17;
            double d16;
            double d17;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f74160g;
            int i3 = this.f74161h;
            if (currentAnimationTimeMillis > i3) {
                return false;
            }
            int i16 = this.f74167n;
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 != 2) {
                        d17 = 0.0d;
                    } else {
                        float f18 = ((float) currentAnimationTimeMillis) / 1000.0f;
                        int i17 = this.f74157d;
                        float f19 = this.f74159f;
                        this.f74158e = i17 + (f19 * f18);
                        d17 = (i17 * f18) + (((f19 * f18) * f18) / 2.0f);
                    }
                    this.f74155b = this.f74154a + ((int) Math.round(d17));
                    return true;
                }
                float f26 = ((float) currentAnimationTimeMillis) / i3;
                float f27 = f26 * f26;
                float signum = Math.signum(this.f74157d);
                int i18 = this.f74165l;
                d16 = i18 * signum * ((3.0f * f27) - ((2.0f * f26) * f27));
                this.f74158e = signum * i18 * 6.0f * ((-f26) + f27);
            } else {
                int i19 = this.f74162i;
                float f28 = ((float) currentAnimationTimeMillis) / i19;
                int i26 = (int) (f28 * 100.0f);
                if (i26 < 100) {
                    float f29 = i26 / 100.0f;
                    int i27 = i26 + 1;
                    float[] fArr = f74152q;
                    float f36 = fArr[i26];
                    f17 = (fArr[i27] - f36) / ((i27 / 100.0f) - f29);
                    f16 = f36 + ((f28 - f29) * f17);
                } else {
                    f16 = 1.0f;
                    f17 = 0.0f;
                }
                int i28 = this.f74163j;
                d16 = f16 * i28;
                this.f74158e = ((f17 * i28) / i19) * 1000.0f;
            }
            d17 = d16;
            this.f74155b = this.f74154a + ((int) Math.round(d17));
            return true;
        }

        void w(float f16) {
            this.f74155b = this.f74154a + Math.round(f16 * (this.f74156c - r0));
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public void a() {
        this.f74146b.i();
        this.f74147c.i();
    }

    public boolean b() {
        float interpolation;
        if (f()) {
            return false;
        }
        int i3 = this.f74145a;
        if (i3 != 0) {
            if (i3 == 1) {
                if (!this.f74146b.f74164k && !this.f74146b.v() && !this.f74146b.h()) {
                    this.f74146b.i();
                }
                if (!this.f74147c.f74164k && !this.f74147c.v() && !this.f74147c.h()) {
                    this.f74147c.i();
                }
            }
        } else {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f74146b.f74160g;
            int i16 = this.f74146b.f74161h;
            if (currentAnimationTimeMillis < i16) {
                float f16 = ((float) currentAnimationTimeMillis) / i16;
                Interpolator interpolator = this.f74148d;
                if (interpolator == null) {
                    interpolation = e.a(f16);
                } else {
                    interpolation = interpolator.getInterpolation(f16);
                }
                this.f74146b.w(interpolation);
                this.f74147c.w(interpolation);
            } else {
                a();
            }
        }
        return true;
    }

    public void c(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
        int i37;
        int i38;
        int i39;
        int i46;
        if (this.f74149e && !f()) {
            float f16 = this.f74146b.f74158e;
            float f17 = this.f74147c.f74158e;
            i37 = i17;
            float f18 = i37;
            if (Math.signum(f18) == Math.signum(f16)) {
                i38 = i18;
                float f19 = i38;
                if (Math.signum(f19) == Math.signum(f17)) {
                    i39 = (int) (f19 + f17);
                    i46 = (int) (f18 + f16);
                    this.f74145a = 1;
                    this.f74146b.k(i3, i46, i19, i26, i29);
                    this.f74147c.k(i16, i39, i27, i28, i36);
                }
                i39 = i38;
                i46 = i37;
                this.f74145a = 1;
                this.f74146b.k(i3, i46, i19, i26, i29);
                this.f74147c.k(i16, i39, i27, i28, i36);
            }
        } else {
            i37 = i17;
        }
        i38 = i18;
        i39 = i38;
        i46 = i37;
        this.f74145a = 1;
        this.f74146b.k(i3, i46, i19, i26, i29);
        this.f74147c.k(i16, i39, i27, i28, i36);
    }

    public final void d(boolean z16) {
        a aVar = this.f74146b;
        this.f74147c.f74164k = z16;
        aVar.f74164k = z16;
    }

    public final int e() {
        return this.f74146b.f74155b;
    }

    public final boolean f() {
        if (this.f74146b.f74164k && this.f74147c.f74164k) {
            return true;
        }
        return false;
    }

    public void g(int i3, int i16, int i17, int i18, int i19) {
        this.f74145a = 0;
        this.f74146b.t(i3, i17, i19);
        this.f74147c.t(i16, i18, i19);
    }

    public d(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public d(Context context, Interpolator interpolator, boolean z16) {
        this.f74148d = interpolator;
        this.f74149e = z16;
        this.f74146b = new a();
        this.f74147c = new a();
        a.p(context);
    }
}
