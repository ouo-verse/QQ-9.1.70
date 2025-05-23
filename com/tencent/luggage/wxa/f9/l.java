package com.tencent.luggage.wxa.f9;

import com.tencent.mm.audio.mix.jni.SilkResampleJni;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l implements j {

    /* renamed from: a, reason: collision with root package name */
    public int f125582a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f125583b = 2;

    /* renamed from: c, reason: collision with root package name */
    public int f125584c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f125585d = 2;

    /* renamed from: e, reason: collision with root package name */
    public String f125586e;

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean a(String str, int i3, int i16, int i17, int i18) {
        this.f125582a = i3;
        this.f125583b = i16;
        this.f125584c = i17;
        this.f125585d = i18;
        this.f125586e = str;
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.SilkResampleAlgorithm", "initResample, fileName:%s, sSample:%d, dSample:%d", str, Integer.valueOf(i3), Integer.valueOf(i17));
        if (SilkResampleJni.initResample(str, i3, i17) != -1) {
            return true;
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.SilkResampleAlgorithm", "initResample result is -1, fileName:%s", str);
        return false;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public boolean release() {
        if (SilkResampleJni.clearResample(this.f125586e) == -1) {
            com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.SilkResampleAlgorithm", "clearResample result is -1");
            return false;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.SilkResampleAlgorithm", "release");
        return true;
    }

    @Override // com.tencent.luggage.wxa.f9.j
    public byte[] a(byte[] bArr) {
        short[] a16 = a.a(bArr, bArr.length);
        int length = a16.length;
        int i3 = this.f125584c;
        int i16 = this.f125582a;
        int i17 = (length * i3) / i16;
        if (i3 % i16 != 0) {
            i17++;
        }
        short[] sArr = new short[i17];
        if (SilkResampleJni.resamplePcm(this.f125586e, i16, i3, a16, a16.length, sArr) != -1) {
            return a.a(sArr);
        }
        com.tencent.luggage.wxa.m9.b.a("MicroMsg.Mix.SilkResampleAlgorithm", "resamplePcm result is -1, fileName:%s", this.f125586e);
        return null;
    }
}
