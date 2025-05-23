package com.tencent.luggage.wxa.l0;

import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f132789a;

    /* renamed from: b, reason: collision with root package name */
    public final int f132790b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f132791c;

    /* renamed from: d, reason: collision with root package name */
    public final a[] f132792d;

    /* renamed from: e, reason: collision with root package name */
    public int f132793e;

    /* renamed from: f, reason: collision with root package name */
    public int f132794f;

    /* renamed from: g, reason: collision with root package name */
    public int f132795g;

    /* renamed from: h, reason: collision with root package name */
    public a[] f132796h;

    public k(boolean z16, int i3) {
        this(z16, i3, 0);
    }

    public synchronized void a(int i3) {
        boolean z16 = i3 < this.f132793e;
        this.f132793e = i3;
        if (z16) {
            b();
        }
    }

    @Override // com.tencent.luggage.wxa.l0.b
    public synchronized void b() {
        int i3 = 0;
        int max = Math.max(0, v.a(this.f132793e, this.f132790b) - this.f132794f);
        int i16 = this.f132795g;
        if (max >= i16) {
            return;
        }
        if (this.f132791c != null) {
            int i17 = i16 - 1;
            while (i3 <= i17) {
                a[] aVarArr = this.f132796h;
                a aVar = aVarArr[i3];
                byte[] bArr = aVar.f132760a;
                byte[] bArr2 = this.f132791c;
                if (bArr == bArr2) {
                    i3++;
                } else {
                    a aVar2 = aVarArr[i17];
                    if (aVar2.f132760a != bArr2) {
                        i17--;
                    } else {
                        aVarArr[i3] = aVar2;
                        aVarArr[i17] = aVar;
                        i17--;
                        i3++;
                    }
                }
            }
            max = Math.max(max, i3);
            if (max >= this.f132795g) {
                return;
            }
        }
        Arrays.fill(this.f132796h, max, this.f132795g, (Object) null);
        this.f132795g = max;
    }

    @Override // com.tencent.luggage.wxa.l0.b
    public int c() {
        return this.f132790b;
    }

    public synchronized int d() {
        return this.f132794f * this.f132790b;
    }

    public synchronized void e() {
        if (this.f132789a) {
            a(0);
        }
    }

    public k(boolean z16, int i3, int i16) {
        com.tencent.luggage.wxa.n0.a.a(i3 > 0);
        com.tencent.luggage.wxa.n0.a.a(i16 >= 0);
        this.f132789a = z16;
        this.f132790b = i3;
        this.f132795g = i16;
        this.f132796h = new a[i16 + 100];
        if (i16 > 0) {
            this.f132791c = new byte[i16 * i3];
            for (int i17 = 0; i17 < i16; i17++) {
                this.f132796h[i17] = new a(this.f132791c, i17 * i3);
            }
        } else {
            this.f132791c = null;
        }
        this.f132792d = new a[1];
    }

    @Override // com.tencent.luggage.wxa.l0.b
    public synchronized a a() {
        a aVar;
        this.f132794f++;
        int i3 = this.f132795g;
        if (i3 > 0) {
            a[] aVarArr = this.f132796h;
            int i16 = i3 - 1;
            this.f132795g = i16;
            aVar = aVarArr[i16];
            aVarArr[i16] = null;
        } else {
            aVar = new a(new byte[this.f132790b], 0);
        }
        return aVar;
    }

    @Override // com.tencent.luggage.wxa.l0.b
    public synchronized void a(a aVar) {
        a[] aVarArr = this.f132792d;
        aVarArr[0] = aVar;
        a(aVarArr);
    }

    @Override // com.tencent.luggage.wxa.l0.b
    public synchronized void a(a[] aVarArr) {
        boolean z16;
        int i3 = this.f132795g;
        int length = aVarArr.length + i3;
        a[] aVarArr2 = this.f132796h;
        if (length >= aVarArr2.length) {
            this.f132796h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i3 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            byte[] bArr = aVar.f132760a;
            if (bArr != this.f132791c && bArr.length != this.f132790b) {
                z16 = false;
                com.tencent.luggage.wxa.n0.a.a(z16);
                a[] aVarArr3 = this.f132796h;
                int i16 = this.f132795g;
                this.f132795g = i16 + 1;
                aVarArr3[i16] = aVar;
            }
            z16 = true;
            com.tencent.luggage.wxa.n0.a.a(z16);
            a[] aVarArr32 = this.f132796h;
            int i162 = this.f132795g;
            this.f132795g = i162 + 1;
            aVarArr32[i162] = aVar;
        }
        this.f132794f -= aVarArr.length;
        notifyAll();
    }
}
