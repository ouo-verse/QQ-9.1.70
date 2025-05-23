package com.tencent.luggage.wxa.n;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final int f135013a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135014b;

    /* renamed from: c, reason: collision with root package name */
    public final int f135015c;

    /* renamed from: d, reason: collision with root package name */
    public final int f135016d;

    /* renamed from: e, reason: collision with root package name */
    public final int f135017e;

    /* renamed from: f, reason: collision with root package name */
    public final short[] f135018f;

    /* renamed from: g, reason: collision with root package name */
    public int f135019g;

    /* renamed from: h, reason: collision with root package name */
    public short[] f135020h;

    /* renamed from: i, reason: collision with root package name */
    public int f135021i;

    /* renamed from: j, reason: collision with root package name */
    public short[] f135022j;

    /* renamed from: k, reason: collision with root package name */
    public int f135023k;

    /* renamed from: l, reason: collision with root package name */
    public short[] f135024l;

    /* renamed from: q, reason: collision with root package name */
    public int f135029q;

    /* renamed from: r, reason: collision with root package name */
    public int f135030r;

    /* renamed from: s, reason: collision with root package name */
    public int f135031s;

    /* renamed from: t, reason: collision with root package name */
    public int f135032t;

    /* renamed from: v, reason: collision with root package name */
    public int f135034v;

    /* renamed from: w, reason: collision with root package name */
    public int f135035w;

    /* renamed from: x, reason: collision with root package name */
    public int f135036x;

    /* renamed from: m, reason: collision with root package name */
    public int f135025m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f135026n = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f135033u = 0;

    /* renamed from: o, reason: collision with root package name */
    public float f135027o = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f135028p = 1.0f;

    public k(int i3, int i16) {
        this.f135013a = i3;
        this.f135014b = i16;
        this.f135015c = i3 / 400;
        int i17 = i3 / 65;
        this.f135016d = i17;
        int i18 = i17 * 2;
        this.f135017e = i18;
        this.f135018f = new short[i18];
        this.f135019g = i18;
        int i19 = i16 * i18;
        this.f135020h = new short[i19];
        this.f135021i = i18;
        this.f135022j = new short[i19];
        this.f135023k = i18;
        this.f135024l = new short[i19];
    }

    public void a(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f135014b, this.f135030r);
        shortBuffer.put(this.f135022j, 0, this.f135014b * min);
        int i3 = this.f135030r - min;
        this.f135030r = i3;
        short[] sArr = this.f135022j;
        int i16 = this.f135014b;
        System.arraycopy(sArr, min * i16, sArr, 0, i3 * i16);
    }

    public void b(float f16) {
        this.f135028p = f16;
    }

    public void c(float f16) {
        this.f135027o = f16;
    }

    public final void d(int i3) {
        int i16 = this.f135030r - i3;
        int i17 = this.f135031s + i16;
        int i18 = this.f135023k;
        if (i17 > i18) {
            int i19 = i18 + (i18 / 2) + i16;
            this.f135023k = i19;
            this.f135024l = Arrays.copyOf(this.f135024l, i19 * this.f135014b);
        }
        short[] sArr = this.f135022j;
        int i26 = this.f135014b;
        System.arraycopy(sArr, i3 * i26, this.f135024l, this.f135031s * i26, i26 * i16);
        this.f135030r = i3;
        this.f135031s += i16;
    }

    public final void e(int i3) {
        if (i3 == 0) {
            return;
        }
        short[] sArr = this.f135024l;
        int i16 = this.f135014b;
        System.arraycopy(sArr, i3 * i16, sArr, 0, (this.f135031s - i3) * i16);
        this.f135031s -= i3;
    }

    public final void f(int i3) {
        int i16 = this.f135029q - i3;
        short[] sArr = this.f135020h;
        int i17 = this.f135014b;
        System.arraycopy(sArr, i3 * i17, sArr, 0, i17 * i16);
        this.f135029q = i16;
    }

    public void b(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i3 = this.f135014b;
        int i16 = remaining / i3;
        b(i16);
        shortBuffer.get(this.f135020h, this.f135029q * this.f135014b, ((i3 * i16) * 2) / 2);
        this.f135029q += i16;
        b();
    }

    public void c() {
        int i3;
        int i16 = this.f135029q;
        float f16 = this.f135027o;
        float f17 = this.f135028p;
        int i17 = this.f135030r + ((int) ((((i16 / (f16 / f17)) + this.f135031s) / f17) + 0.5f));
        b((this.f135017e * 2) + i16);
        int i18 = 0;
        while (true) {
            i3 = this.f135017e * 2;
            int i19 = this.f135014b;
            if (i18 >= i3 * i19) {
                break;
            }
            this.f135020h[(i19 * i16) + i18] = 0;
            i18++;
        }
        this.f135029q += i3;
        b();
        if (this.f135030r > i17) {
            this.f135030r = i17;
        }
        this.f135029q = 0;
        this.f135032t = 0;
        this.f135031s = 0;
    }

    public int a() {
        return this.f135030r;
    }

    public final void a(short[] sArr, int i3, int i16) {
        c(i16);
        int i17 = this.f135014b;
        System.arraycopy(sArr, i3 * i17, this.f135022j, this.f135030r * i17, i17 * i16);
        this.f135030r += i16;
    }

    public final void b(int i3) {
        int i16 = this.f135029q + i3;
        int i17 = this.f135019g;
        if (i16 > i17) {
            int i18 = i17 + (i17 / 2) + i3;
            this.f135019g = i18;
            this.f135020h = Arrays.copyOf(this.f135020h, i18 * this.f135014b);
        }
    }

    public final int a(int i3) {
        int min = Math.min(this.f135017e, this.f135032t);
        a(this.f135020h, i3, min);
        this.f135032t -= min;
        return min;
    }

    public final void b(short[] sArr, int i3, int i16) {
        int i17 = this.f135017e / i16;
        int i18 = this.f135014b;
        int i19 = i16 * i18;
        int i26 = i3 * i18;
        for (int i27 = 0; i27 < i17; i27++) {
            int i28 = 0;
            for (int i29 = 0; i29 < i19; i29++) {
                i28 += sArr[(i27 * i19) + i26 + i29];
            }
            this.f135018f[i27] = (short) (i28 / i19);
        }
    }

    public final int a(short[] sArr, int i3, int i16, int i17) {
        int i18 = i3 * this.f135014b;
        int i19 = 255;
        int i26 = 1;
        int i27 = 0;
        int i28 = 0;
        while (i16 <= i17) {
            int i29 = 0;
            for (int i36 = 0; i36 < i16; i36++) {
                i29 += Math.abs(sArr[i18 + i36] - sArr[(i18 + i16) + i36]);
            }
            if (i29 * i27 < i26 * i16) {
                i27 = i16;
                i26 = i29;
            }
            if (i29 * i19 > i28 * i16) {
                i19 = i16;
                i28 = i29;
            }
            i16++;
        }
        this.f135035w = i26 / i27;
        this.f135036x = i28 / i19;
        return i27;
    }

    public final short b(short[] sArr, int i3, int i16, int i17) {
        short s16 = sArr[i3];
        short s17 = sArr[i3 + this.f135014b];
        int i18 = this.f135026n * i16;
        int i19 = this.f135025m;
        int i26 = i19 * i17;
        int i27 = (i19 + 1) * i17;
        int i28 = i27 - i18;
        int i29 = i27 - i26;
        return (short) (((s16 * i28) + ((i29 - i28) * s17)) / i29);
    }

    public final void c(int i3) {
        int i16 = this.f135030r + i3;
        int i17 = this.f135021i;
        if (i16 > i17) {
            int i18 = i17 + (i17 / 2) + i3;
            this.f135021i = i18;
            this.f135022j = Arrays.copyOf(this.f135022j, i18 * this.f135014b);
        }
    }

    public final boolean a(int i3, int i16, boolean z16) {
        if (i3 == 0 || this.f135033u == 0) {
            return false;
        }
        return z16 ? i16 <= i3 * 3 && i3 * 2 > this.f135034v * 3 : i3 > this.f135034v;
    }

    public final int b(short[] sArr, int i3, float f16, int i16) {
        int i17;
        if (f16 >= 2.0f) {
            i17 = (int) (i16 / (f16 - 1.0f));
        } else {
            this.f135032t = (int) ((i16 * (2.0f - f16)) / (f16 - 1.0f));
            i17 = i16;
        }
        c(i17);
        a(i17, this.f135014b, this.f135022j, this.f135030r, sArr, i3, sArr, i3 + i16);
        this.f135030r += i17;
        return i17;
    }

    public final int a(short[] sArr, int i3, boolean z16) {
        int i16;
        int i17 = this.f135013a;
        int i18 = i17 > 4000 ? i17 / 4000 : 1;
        if (this.f135014b == 1 && i18 == 1) {
            i16 = a(sArr, i3, this.f135015c, this.f135016d);
        } else {
            b(sArr, i3, i18);
            int a16 = a(this.f135018f, 0, this.f135015c / i18, this.f135016d / i18);
            if (i18 != 1) {
                int i19 = a16 * i18;
                int i26 = i18 * 4;
                int i27 = i19 - i26;
                int i28 = i19 + i26;
                int i29 = this.f135015c;
                if (i27 < i29) {
                    i27 = i29;
                }
                int i36 = this.f135016d;
                if (i28 > i36) {
                    i28 = i36;
                }
                if (this.f135014b == 1) {
                    i16 = a(sArr, i3, i27, i28);
                } else {
                    b(sArr, i3, 1);
                    i16 = a(this.f135018f, 0, i27, i28);
                }
            } else {
                i16 = a16;
            }
        }
        int i37 = a(this.f135035w, this.f135036x, z16) ? this.f135033u : i16;
        this.f135034v = this.f135035w;
        this.f135033u = i16;
        return i37;
    }

    public final void b() {
        int i3 = this.f135030r;
        float f16 = this.f135027o / this.f135028p;
        double d16 = f16;
        if (d16 <= 1.00001d && d16 >= 0.99999d) {
            a(this.f135020h, 0, this.f135029q);
            this.f135029q = 0;
        } else {
            a(f16);
        }
        float f17 = this.f135028p;
        if (f17 != 1.0f) {
            a(f17, i3);
        }
    }

    public final void a(float f16, int i3) {
        int i16;
        int i17;
        if (this.f135030r == i3) {
            return;
        }
        int i18 = this.f135013a;
        int i19 = (int) (i18 / f16);
        while (true) {
            if (i19 <= 16384 && i18 <= 16384) {
                break;
            }
            i19 /= 2;
            i18 /= 2;
        }
        d(i3);
        int i26 = 0;
        while (true) {
            int i27 = this.f135031s - 1;
            if (i26 < i27) {
                while (true) {
                    i16 = this.f135025m + 1;
                    int i28 = i16 * i19;
                    i17 = this.f135026n;
                    if (i28 <= i17 * i18) {
                        break;
                    }
                    c(1);
                    int i29 = 0;
                    while (true) {
                        int i36 = this.f135014b;
                        if (i29 < i36) {
                            this.f135022j[(this.f135030r * i36) + i29] = b(this.f135024l, (i36 * i26) + i29, i18, i19);
                            i29++;
                        }
                    }
                    this.f135026n++;
                    this.f135030r++;
                }
                this.f135025m = i16;
                if (i16 == i18) {
                    this.f135025m = 0;
                    com.tencent.luggage.wxa.n0.a.b(i17 == i19);
                    this.f135026n = 0;
                }
                i26++;
            } else {
                e(i27);
                return;
            }
        }
    }

    public final int a(short[] sArr, int i3, float f16, int i16) {
        int i17;
        if (f16 < 0.5f) {
            i17 = (int) ((i16 * f16) / (1.0f - f16));
        } else {
            this.f135032t = (int) ((i16 * ((2.0f * f16) - 1.0f)) / (1.0f - f16));
            i17 = i16;
        }
        int i18 = i16 + i17;
        c(i18);
        int i19 = this.f135014b;
        System.arraycopy(sArr, i3 * i19, this.f135022j, this.f135030r * i19, i19 * i16);
        a(i17, this.f135014b, this.f135022j, this.f135030r + i16, sArr, i3 + i16, sArr, i3);
        this.f135030r += i18;
        return i17;
    }

    public final void a(float f16) {
        int a16;
        int i3 = this.f135029q;
        if (i3 < this.f135017e) {
            return;
        }
        int i16 = 0;
        do {
            if (this.f135032t > 0) {
                a16 = a(i16);
            } else {
                int a17 = a(this.f135020h, i16, true);
                if (f16 > 1.0d) {
                    a16 = a17 + b(this.f135020h, i16, f16, a17);
                } else {
                    a16 = a(this.f135020h, i16, f16, a17);
                }
            }
            i16 += a16;
        } while (this.f135017e + i16 <= i3);
        f(i16);
    }

    public static void a(int i3, int i16, short[] sArr, int i17, short[] sArr2, int i18, short[] sArr3, int i19) {
        for (int i26 = 0; i26 < i16; i26++) {
            int i27 = (i17 * i16) + i26;
            int i28 = (i19 * i16) + i26;
            int i29 = (i18 * i16) + i26;
            for (int i36 = 0; i36 < i3; i36++) {
                sArr[i27] = (short) (((sArr2[i29] * (i3 - i36)) + (sArr3[i28] * i36)) / i3);
                i27 += i16;
                i29 += i16;
                i28 += i16;
            }
        }
    }
}
