package com.tencent.luggage.wxa.f9;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k implements j {

    /* renamed from: a, reason: collision with root package name */
    public int f125579a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f125580b = 0;

    /* renamed from: c, reason: collision with root package name */
    public short[] f125581c;

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean a(String str, int i3, int i16, int i17, int i18) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.LinearResampleAlgorithm", "linear resample algorithm  sSample:%d, dSample:%d", Integer.valueOf(i3), Integer.valueOf(i17));
        this.f125579a = i3;
        this.f125580b = i17;
        return true;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean release() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public byte[] a(byte[] bArr) {
        int length = a.a(bArr, bArr.length).length - 1;
        int length2 = (int) (r9.length * (this.f125580b / this.f125579a));
        short[] sArr = this.f125581c;
        if (sArr == null || sArr.length != length2) {
            this.f125581c = new short[length2];
        }
        Arrays.fill(this.f125581c, 0, length2, (short) 0);
        for (int i3 = 0; i3 < length2; i3++) {
            float f16 = (i3 * this.f125579a) / this.f125580b;
            int i16 = (int) f16;
            float f17 = f16 - i16;
            this.f125581c[i3] = (short) (((1.0f - f17) * r9[i16]) + (f17 * r9[i16 == length ? length : i16 + 1]));
        }
        return a.a(this.f125581c);
    }
}
