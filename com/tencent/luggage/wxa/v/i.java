package com.tencent.luggage.wxa.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f142902a;

    /* renamed from: b, reason: collision with root package name */
    public final int f142903b;

    /* renamed from: c, reason: collision with root package name */
    public int f142904c;

    /* renamed from: d, reason: collision with root package name */
    public int f142905d;

    public i(byte[] bArr) {
        this.f142902a = bArr;
        this.f142903b = bArr.length;
    }

    public int a(int i3) {
        int i16 = this.f142904c;
        int min = Math.min(i3, 8 - this.f142905d);
        int i17 = i16 + 1;
        int i18 = ((this.f142902a[i16] & 255) >> this.f142905d) & (255 >> (8 - min));
        while (min < i3) {
            i18 |= (this.f142902a[i17] & 255) << min;
            min += 8;
            i17++;
        }
        int i19 = i18 & ((-1) >>> (32 - i3));
        b(i3);
        return i19;
    }

    public void b(int i3) {
        int i16 = i3 / 8;
        int i17 = this.f142904c + i16;
        this.f142904c = i17;
        int i18 = this.f142905d + (i3 - (i16 * 8));
        this.f142905d = i18;
        if (i18 > 7) {
            this.f142904c = i17 + 1;
            this.f142905d = i18 - 8;
        }
        a();
    }

    public boolean c() {
        boolean z16;
        if ((((this.f142902a[this.f142904c] & 255) >> this.f142905d) & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        b(1);
        return z16;
    }

    public final void a() {
        int i3;
        int i16 = this.f142904c;
        com.tencent.luggage.wxa.n0.a.b(i16 >= 0 && (i16 < (i3 = this.f142903b) || (i16 == i3 && this.f142905d == 0)));
    }

    public int b() {
        return (this.f142904c * 8) + this.f142905d;
    }
}
