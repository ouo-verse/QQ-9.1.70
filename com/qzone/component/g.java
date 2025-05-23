package com.qzone.component;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import com.qzone.component.c;
import com.qzone.widget.util.ZipLoadBitmapGenerator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private Rect f46704b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f46705c;

    /* renamed from: d, reason: collision with root package name */
    private long f46706d;

    /* renamed from: e, reason: collision with root package name */
    private long f46707e;

    /* renamed from: p, reason: collision with root package name */
    private double f46718p;

    /* renamed from: r, reason: collision with root package name */
    public final String f46720r;

    /* renamed from: s, reason: collision with root package name */
    public final com.qzone.widget.util.c f46721s;

    /* renamed from: t, reason: collision with root package name */
    private a f46722t;

    /* renamed from: f, reason: collision with root package name */
    private double f46708f = 1.0d;

    /* renamed from: g, reason: collision with root package name */
    private double f46709g = 1.0d;

    /* renamed from: h, reason: collision with root package name */
    private double f46710h = 1.0d;

    /* renamed from: i, reason: collision with root package name */
    private double f46711i = 1.0d;

    /* renamed from: j, reason: collision with root package name */
    private long f46712j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f46713k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f46714l = 0;

    /* renamed from: m, reason: collision with root package name */
    private double f46715m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    private long f46716n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f46717o = 0;

    /* renamed from: q, reason: collision with root package name */
    private double f46719q = -0.8d;

    /* renamed from: a, reason: collision with root package name */
    private c f46703a = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(g gVar);
    }

    private void a(long j3) {
        double d16 = (j3 - this.f46706d) / 1000.0d;
        c cVar = this.f46703a;
        double g16 = g(cVar.f46633b.f46638a, cVar.f46634c.f46636a, d16);
        c cVar2 = this.f46703a;
        double g17 = g(cVar2.f46633b.f46639b, cVar2.f46634c.f46637b, d16);
        c cVar3 = this.f46703a;
        c.b bVar = cVar3.f46633b;
        double d17 = bVar.f46638a;
        c.a aVar = cVar3.f46634c;
        double d18 = d17 + (aVar.f46636a * d16);
        bVar.f46638a = d18;
        double d19 = bVar.f46639b + (aVar.f46637b * d16);
        double d26 = d16 * 0.0d;
        bVar.f46638a = d18 + (d26 * d18);
        bVar.f46639b = d19 + (d26 * d19);
        cVar3.f46632a.offset((float) g16, (float) g17);
    }

    private void b() {
        this.f46708f = Math.max(1.0d - (Math.abs(this.f46703a.f46633b.f46638a) * 3.0E-4d), 0.8d);
    }

    private void c() {
        this.f46709g = Math.max(1.0d - (Math.abs(this.f46703a.f46633b.f46639b) * 3.0E-4d), 0.8d);
    }

    private int d(Rect rect, RectF rectF) {
        int i3 = ((float) rect.left) > rectF.left ? 1 : 0;
        if (rect.right < rectF.right) {
            i3 ^= 2;
        }
        if (rect.top > rectF.top) {
            i3 ^= 4;
        }
        return ((float) rect.bottom) < rectF.bottom ? i3 ^ 8 : i3;
    }

    private double g(double d16, double d17, double d18) {
        return (((d16 * 2.0d) + (d17 * d18)) / 2.0d) * d18;
    }

    private double h(long j3) {
        if (Math.abs(this.f46710h - this.f46708f) < 0.01d) {
            return this.f46708f;
        }
        long j16 = j3 - this.f46706d;
        double d16 = this.f46710h;
        double d17 = this.f46708f;
        if (d16 < d17) {
            double d18 = d16 + ((j16 * 2) / 1000.0d);
            this.f46710h = d18;
            this.f46710h = Math.min(d17, d18);
        } else {
            double d19 = d16 - ((j16 * 2) / 1000.0d);
            this.f46710h = d19;
            this.f46710h = Math.max(d17, d19);
        }
        return this.f46710h;
    }

    private double i(long j3) {
        if (Math.abs(this.f46711i - this.f46709g) < 0.01d) {
            return this.f46709g;
        }
        long j16 = j3 - this.f46706d;
        double d16 = this.f46711i;
        double d17 = this.f46709g;
        if (d16 < d17) {
            double d18 = d16 + ((j16 * 2) / 1000.0d);
            this.f46711i = d18;
            this.f46711i = Math.min(d17, d18);
        } else {
            double d19 = d16 - ((j16 * 2) / 1000.0d);
            this.f46711i = d19;
            this.f46711i = Math.max(d17, d19);
        }
        return this.f46711i;
    }

    private void n() {
        RectF rectF = this.f46703a.f46632a;
        float f16 = rectF.left;
        int i3 = this.f46704b.left;
        if (f16 < i3) {
            rectF.offset(i3 - f16, 0.0f);
        }
        RectF rectF2 = this.f46703a.f46632a;
        float f17 = rectF2.right;
        int i16 = this.f46704b.right;
        if (f17 > i16) {
            rectF2.offset(i16 - f17, 0.0f);
        }
        RectF rectF3 = this.f46703a.f46632a;
        float f18 = rectF3.top;
        int i17 = this.f46704b.top;
        if (f18 < i17) {
            rectF3.offset(0.0f, i17 - f18);
        }
        RectF rectF4 = this.f46703a.f46632a;
        float f19 = rectF4.bottom;
        int i18 = this.f46704b.bottom;
        if (f19 > i18) {
            rectF4.offset(0.0f, i18 - f19);
        }
    }

    private void q(int i3, long j3) {
        this.f46707e = j3;
        this.f46708f = 1.0d;
        this.f46709g = 1.0d;
        if ((i3 & 1) > 0) {
            b();
        }
        if ((i3 & 2) > 0) {
            b();
        }
        if ((i3 & 4) > 0) {
            c();
        }
        if ((i3 & 8) > 0) {
            c();
        }
    }

    public long j() {
        return this.f46717o;
    }

    public void p(a aVar) {
        this.f46722t = aVar;
    }

    private void l(long j3) {
        double centerX = this.f46703a.f46632a.centerX();
        double centerY = this.f46703a.f46632a.centerY();
        double h16 = this.f46721s.h() * this.f46718p;
        double f16 = this.f46721s.f() * this.f46718p;
        long j16 = this.f46717o;
        if (j16 > 0) {
            long j17 = j3 - j16;
            if (j17 > 500) {
                RectF rectF = this.f46703a.f46632a;
                double d16 = h16 / 2.0d;
                rectF.left = (float) (centerX - d16);
                rectF.right = (float) (centerX + d16);
                double d17 = f16 / 2.0d;
                rectF.top = (float) (centerY - d17);
                rectF.bottom = (float) (centerY + d17);
                n();
                this.f46703a.f46635d = 0;
                return;
            }
            if (j17 < 100) {
                double d18 = j17;
                RectF rectF2 = this.f46703a.f46632a;
                double d19 = (h16 * (((d18 * 1.0d) / 100.0d) + 1.0d)) / 2.0d;
                rectF2.left = (float) (centerX - d19);
                rectF2.right = (float) (centerX + d19);
                double d26 = (f16 * (((d18 * 0.4d) / 100.0d) + 1.0d)) / 2.0d;
                rectF2.top = (float) (centerY - d26);
                rectF2.bottom = (float) (centerY + d26);
                n();
                return;
            }
            if (j17 < 200) {
                double d27 = j17 - 100;
                RectF rectF3 = this.f46703a.f46632a;
                double d28 = (h16 * ((((-0.4d) * d27) / 100.0d) + 2.0d)) / 2.0d;
                rectF3.left = (float) (centerX - d28);
                rectF3.right = (float) (centerX + d28);
                double d29 = (f16 * (((d27 * (-0.6d)) / 100.0d) + 1.4d)) / 2.0d;
                rectF3.top = (float) (centerY - d29);
                rectF3.bottom = (float) (centerY + d29);
                return;
            }
            if (j17 < 300) {
                double d36 = j17 - 200;
                RectF rectF4 = this.f46703a.f46632a;
                double d37 = (h16 * ((((-0.6d) * d36) / 100.0d) + 1.6d)) / 2.0d;
                rectF4.left = (float) (centerX - d37);
                rectF4.right = (float) (centerX + d37);
                double d38 = (f16 * (((d36 * 0.5d) / 100.0d) + 0.8d)) / 2.0d;
                rectF4.top = (float) (centerY - d38);
                rectF4.bottom = (float) (centerY + d38);
                return;
            }
            if (j17 < 400) {
                double d39 = j17 - 300;
                RectF rectF5 = this.f46703a.f46632a;
                double d46 = (h16 * (((0.2d * d39) / 100.0d) + 1.0d)) / 2.0d;
                rectF5.left = (float) (centerX - d46);
                rectF5.right = (float) (centerX + d46);
                double d47 = (f16 * (((d39 * (-0.3d)) / 100.0d) + 1.3d)) / 2.0d;
                rectF5.top = (float) (centerY - d47);
                rectF5.bottom = (float) (centerY + d47);
                return;
            }
            RectF rectF6 = this.f46703a.f46632a;
            double d48 = (h16 * ((((j17 - 400) * (-0.2d)) / 100.0d) + 1.2d)) / 2.0d;
            rectF6.left = (float) (centerX - d48);
            rectF6.right = (float) (centerX + d48);
            double d49 = (f16 * 1.0d) / 2.0d;
            rectF6.top = (float) (centerY - d49);
            rectF6.bottom = (float) (centerY + d49);
        }
    }

    private void m(long j3) {
        double centerX = this.f46703a.f46632a.centerX();
        double centerY = this.f46703a.f46632a.centerY();
        double h16 = this.f46721s.h() * this.f46718p;
        double f16 = this.f46721s.f() * this.f46718p;
        double h17 = h(j3);
        this.f46710h = h17;
        RectF rectF = this.f46703a.f46632a;
        rectF.left = (float) (centerX - ((h16 * h17) / 2.0d));
        rectF.right = (float) (centerX + ((h16 * h17) / 2.0d));
        double i3 = i(j3);
        this.f46711i = i3;
        RectF rectF2 = this.f46703a.f46632a;
        rectF2.top = (float) (centerY - ((f16 * i3) / 2.0d));
        rectF2.bottom = (float) (centerY + ((f16 * i3) / 2.0d));
    }

    private void o() {
        this.f46708f = 1.0d;
        this.f46709g = 1.0d;
    }

    public g(Point point, c.b bVar, c.a aVar, long j3, int i3, boolean z16, int i16, String str, ZipLoadBitmapGenerator zipLoadBitmapGenerator) {
        this.f46718p = 1.0d;
        this.f46720r = str;
        this.f46721s = new com.qzone.widget.util.c(zipLoadBitmapGenerator.getBitmapIdList(), zipLoadBitmapGenerator, 25);
        this.f46718p = i3 / r4.h();
        this.f46706d = j3;
        double d16 = i3;
        double f16 = r4.f() * this.f46718p;
        if (i16 == 85) {
            RectF rectF = this.f46703a.f46632a;
            int i17 = point.x;
            int i18 = point.y;
            rectF.set((float) (i17 - d16), (float) (i18 - f16), i17, i18);
        } else if (i16 == 81) {
            RectF rectF2 = this.f46703a.f46632a;
            int i19 = point.x;
            double d17 = d16 / 2.0d;
            int i26 = point.y;
            rectF2.set((float) (i19 - d17), (float) (i26 - f16), (float) (i19 + d17), i26);
        } else {
            RectF rectF3 = this.f46703a.f46632a;
            int i27 = point.x;
            double d18 = d16 / 2.0d;
            int i28 = point.y;
            rectF3.set((float) (i27 - d18), i28, (float) (i27 + d18), (float) (i28 + f16));
        }
        this.f46703a.f46633b.a(bVar);
        this.f46703a.f46634c.a(aVar);
        if (z16) {
            this.f46703a.f46635d = 5;
        }
    }

    private int e(int i3) {
        int i16 = ((i3 & 1) <= 0 || Math.abs(this.f46703a.f46633b.f46638a) <= 100.0d) ? 0 : 1;
        if ((i3 & 2) > 0 && Math.abs(this.f46703a.f46633b.f46638a) > 100.0d) {
            i16 |= 2;
        }
        if ((i3 & 4) > 0 && Math.abs(this.f46703a.f46633b.f46639b) > 100.0d) {
            i16 |= 4;
        }
        return ((i3 & 8) <= 0 || Math.abs(this.f46703a.f46633b.f46639b) <= 100.0d) ? i16 : i16 | 8;
    }

    public void f(Canvas canvas, long j3, int i3, int i16, float f16) {
        int i17;
        int i18 = 0;
        if (this.f46704b == null) {
            this.f46704b = new Rect(0, 0, i3, i16);
        }
        if (this.f46705c == null) {
            this.f46705c = new Rect();
        }
        if (this.f46703a.f46635d == 5) {
            l(j3);
        }
        if (this.f46703a.f46635d != 5) {
            if (j3 - this.f46707e > 170) {
                o();
            }
            m(j3);
        }
        if (this.f46703a.f46635d != 3) {
            a(j3);
            int d16 = d(this.f46704b, this.f46703a.f46632a);
            if (d16 != 0) {
                if ((d16 & 8) > 0) {
                    if (this.f46712j == 0) {
                        this.f46712j = j3;
                    }
                    int i19 = this.f46713k + 1;
                    this.f46713k = i19;
                    c cVar = this.f46703a;
                    cVar.f46633b.f46638a *= 0.95d;
                    if (cVar.f46635d != 4 && i19 >= 3) {
                        cVar.f46635d = 4;
                        this.f46716n = j3;
                    }
                }
                int i26 = this.f46714l + 1;
                this.f46714l = i26;
                if (i26 == 3) {
                    c cVar2 = this.f46703a;
                    this.f46715m = cVar2.f46632a.left;
                    cVar2.f46634c.f46637b = 2000.0d;
                    this.f46719q = -0.5d;
                }
                k(d16, this.f46704b, this.f46703a.f46632a);
                int e16 = e(d16);
                if (e16 != 0 && (i17 = this.f46703a.f46635d) != 4 && i17 != 5) {
                    q(e16, j3);
                }
            }
        }
        if (this.f46703a.f46635d != 3) {
            int save = canvas.save();
            double d17 = this.f46715m;
            canvas.rotate(d17 > 0.0d ? (float) (((this.f46703a.f46632a.left - d17) * 360.0d) / (this.f46721s.f() * 3.141592653589793d)) : 0.0f, this.f46703a.f46632a.centerX(), this.f46703a.f46632a.centerY());
            c cVar3 = this.f46703a;
            if (cVar3.f46635d == 4) {
                long j16 = (j3 - this.f46716n) - 2000;
                if (j16 > 0) {
                    if (j16 > 700) {
                        cVar3.f46635d = 3;
                    } else {
                        i18 = (int) (255 - ((j16 * 255) / 700));
                    }
                    this.f46721s.o((int) (i18 * f16));
                    this.f46703a.f46632a.round(this.f46705c);
                    this.f46721s.e(canvas, this.f46705c);
                    canvas.restoreToCount(save);
                }
            }
            i18 = 255;
            this.f46721s.o((int) (i18 * f16));
            this.f46703a.f46632a.round(this.f46705c);
            this.f46721s.e(canvas, this.f46705c);
            canvas.restoreToCount(save);
        } else {
            a aVar = this.f46722t;
            if (aVar != null) {
                aVar.a(this);
            }
        }
        this.f46706d = j3;
        if (this.f46717o == 0) {
            this.f46717o = j3;
        }
    }

    private void k(int i3, Rect rect, RectF rectF) {
        double d16;
        double d17 = 0.0d;
        if ((i3 & 1) > 0) {
            d16 = (rectF.left - rect.left) * (-1.8d);
            this.f46703a.f46633b.f46638a *= -0.8d;
        } else {
            d16 = 0.0d;
        }
        if ((i3 & 2) > 0) {
            d16 = (rectF.right - rect.right) * (-1.8d);
            this.f46703a.f46633b.f46638a *= -0.8d;
        }
        if ((i3 & 4) > 0) {
            d17 = (rectF.top - rect.top) * (-1.8d);
            this.f46703a.f46633b.f46639b *= -0.8d;
        }
        if ((i3 & 8) > 0) {
            double d18 = rectF.bottom - rect.bottom;
            double d19 = this.f46719q;
            d17 = d18 * ((-1.0d) + d19);
            this.f46703a.f46633b.f46639b *= d19;
        }
        this.f46703a.f46632a.offset((float) d16, (float) d17);
    }
}
