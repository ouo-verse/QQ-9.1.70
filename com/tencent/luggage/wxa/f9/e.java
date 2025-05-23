package com.tencent.luggage.wxa.f9;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e implements i {

    /* renamed from: p, reason: collision with root package name */
    public static long f125539p;

    /* renamed from: q, reason: collision with root package name */
    public static Object f125540q = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final int f125541a;

    /* renamed from: b, reason: collision with root package name */
    public j f125542b;

    /* renamed from: c, reason: collision with root package name */
    public int f125543c;

    /* renamed from: d, reason: collision with root package name */
    public int f125544d;

    /* renamed from: e, reason: collision with root package name */
    public int f125545e;

    /* renamed from: f, reason: collision with root package name */
    public int f125546f;

    /* renamed from: g, reason: collision with root package name */
    public int f125547g;

    /* renamed from: h, reason: collision with root package name */
    public int f125548h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f125549i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f125550j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f125551k;

    /* renamed from: l, reason: collision with root package name */
    public String f125552l;

    /* renamed from: m, reason: collision with root package name */
    public String f125553m;

    /* renamed from: n, reason: collision with root package name */
    public byte[][] f125554n;

    /* renamed from: o, reason: collision with root package name */
    public j f125555o;

    public e() {
        this(1);
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public void a(int i3, int i16, int i17) {
        synchronized (this) {
            int i18 = this.f125543c;
            this.f125543c = i3;
            this.f125544d = i16;
            this.f125545e = i17;
            if (this.f125546f != i3) {
                j jVar = this.f125542b;
                if (jVar == null) {
                    j e16 = e();
                    this.f125542b = e16;
                    e16.a(this.f125553m, this.f125543c, this.f125545e, this.f125546f, this.f125548h);
                } else if (i18 != i3) {
                    jVar.release();
                    j e17 = e();
                    this.f125542b = e17;
                    e17.a(this.f125553m, this.f125543c, this.f125545e, this.f125546f, this.f125548h);
                }
                if (this.f125544d == 2 && this.f125547g == 2) {
                    j jVar2 = this.f125555o;
                    if (jVar2 == null) {
                        j e18 = e();
                        this.f125555o = e18;
                        e18.a(this.f125553m + "RResample", this.f125543c, this.f125545e, this.f125546f, this.f125548h);
                    } else if (i18 != this.f125543c) {
                        jVar2.release();
                        j e19 = e();
                        this.f125555o = e19;
                        e19.a(this.f125553m + "RResample", this.f125543c, this.f125545e, this.f125546f, this.f125548h);
                    }
                }
                this.f125551k = true;
            } else {
                this.f125551k = false;
                j jVar3 = this.f125542b;
                if (jVar3 != null) {
                    jVar3.release();
                    this.f125542b = null;
                }
            }
            if (this.f125548h != this.f125545e) {
                this.f125550j = true;
            }
            if (this.f125547g != this.f125544d) {
                this.f125549i = true;
            }
        }
    }

    public byte[] b(byte[] bArr) {
        j jVar = this.f125542b;
        if (jVar == null) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertProcess", "resampleAlgorithm is null");
            return bArr;
        }
        if (jVar instanceof l) {
            if (this.f125547g == 2) {
                int length = bArr.length / 2;
                byte[][] bArr2 = this.f125554n;
                if (bArr2 == null || length != bArr2.length) {
                    this.f125554n = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 2, length);
                }
                d.a(this.f125548h, bArr, this.f125554n);
                byte[] a16 = this.f125542b.a(this.f125554n[0]);
                byte[] a17 = this.f125555o.a(this.f125554n[1]);
                if (a16 != null && a17 != null) {
                    return d.a(this.f125548h, a16, a17);
                }
                return bArr;
            }
            return jVar.a(bArr);
        }
        return jVar.a(bArr);
    }

    public boolean c() {
        return this.f125549i;
    }

    public boolean d() {
        return this.f125550j;
    }

    public abstract j e();

    public boolean f() {
        return this.f125551k;
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public void release() {
        synchronized (this) {
            j jVar = this.f125542b;
            if (jVar != null) {
                jVar.release();
                this.f125542b = null;
            }
            j jVar2 = this.f125555o;
            if (jVar2 != null) {
                jVar2.release();
                this.f125555o = null;
            }
        }
    }

    public e(int i3) {
        this.f125543c = 0;
        this.f125544d = 0;
        this.f125545e = 0;
        this.f125546f = 44100;
        this.f125547g = 2;
        this.f125548h = 2;
        this.f125549i = false;
        this.f125550j = false;
        this.f125551k = false;
        this.f125554n = new byte[2];
        this.f125541a = i3;
    }

    @Override // com.tencent.luggage.wxa.f9.i
    public byte[] a(byte[] bArr) {
        byte[] bArr2;
        byte[] a16;
        if (bArr == null) {
            return bArr;
        }
        if (!d() || (bArr2 = d.a(this.f125545e, this.f125548h, bArr)) == null) {
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArr = bArr2;
        }
        synchronized (this) {
            if (this.f125544d == 1 && this.f125547g == 2 && f()) {
                j jVar = this.f125542b;
                if (jVar == null) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertProcess", "resampleAlgorithm is null");
                    return bArr;
                }
                byte[] a17 = jVar.a(bArr);
                if (a17 != null) {
                    bArr = a17;
                }
                byte[] a18 = d.a(this.f125544d, this.f125547g, this.f125548h, bArr);
                if (a18 != null) {
                    bArr = a18;
                }
                return bArr;
            }
            if (this.f125544d == 2 && this.f125547g == 2 && f()) {
                byte[] b16 = b(bArr);
                if (b16 != null) {
                    bArr = b16;
                }
                return bArr;
            }
            if (c() && (a16 = d.a(this.f125544d, this.f125547g, this.f125548h, bArr)) != null) {
                bArr = a16;
            }
            if (f()) {
                if (this.f125542b == null) {
                    com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.AudioConvertProcess", "resampleAlgorithm is null");
                    return bArr;
                }
                synchronized (f125540q) {
                    f125539p++;
                }
                System.nanoTime();
                byte[] a19 = this.f125542b.a(bArr);
                if (a19 != null) {
                    bArr = a19;
                }
                synchronized (f125540q) {
                }
            }
            return bArr;
        }
    }
}
