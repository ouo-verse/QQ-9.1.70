package com.tencent.luggage.wxa.n0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f135084a;

    /* renamed from: b, reason: collision with root package name */
    public int f135085b;

    /* renamed from: c, reason: collision with root package name */
    public int f135086c;

    /* renamed from: d, reason: collision with root package name */
    public int f135087d;

    public k(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public int a(int i3) {
        int i16;
        if (i3 == 0) {
            return 0;
        }
        this.f135086c += i3;
        int i17 = 0;
        while (true) {
            i16 = this.f135086c;
            if (i16 <= 8) {
                break;
            }
            int i18 = i16 - 8;
            this.f135086c = i18;
            byte[] bArr = this.f135084a;
            int i19 = this.f135085b;
            this.f135085b = i19 + 1;
            i17 |= (bArr[i19] & 255) << i18;
        }
        byte[] bArr2 = this.f135084a;
        int i26 = this.f135085b;
        int i27 = ((-1) >>> (32 - i3)) & (i17 | ((bArr2[i26] & 255) >> (8 - i16)));
        if (i16 == 8) {
            this.f135086c = 0;
            this.f135085b = i26 + 1;
        }
        a();
        return i27;
    }

    public int b() {
        return (this.f135085b * 8) + this.f135086c;
    }

    public void c(int i3) {
        int i16 = i3 / 8;
        int i17 = this.f135085b + i16;
        this.f135085b = i17;
        int i18 = this.f135086c + (i3 - (i16 * 8));
        this.f135086c = i18;
        if (i18 > 7) {
            this.f135085b = i17 + 1;
            this.f135086c = i18 - 8;
        }
        a();
    }

    public void d() {
        int i3 = this.f135086c + 1;
        this.f135086c = i3;
        if (i3 == 8) {
            this.f135086c = 0;
            this.f135085b++;
        }
        a();
    }

    public k(byte[] bArr, int i3) {
        this.f135084a = bArr;
        this.f135087d = i3;
    }

    public void b(int i3) {
        int i16 = i3 / 8;
        this.f135085b = i16;
        this.f135086c = i3 - (i16 * 8);
        a();
    }

    public boolean c() {
        boolean z16 = (this.f135084a[this.f135085b] & (128 >> this.f135086c)) != 0;
        d();
        return z16;
    }

    public final void a() {
        int i3;
        int i16 = this.f135085b;
        a.b(i16 >= 0 && (i16 < (i3 = this.f135087d) || (i16 == i3 && this.f135086c == 0)));
    }
}
