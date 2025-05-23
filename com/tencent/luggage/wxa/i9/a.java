package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends f {
    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        int i18;
        short a16;
        for (int i19 = 0; i19 < i16; i19++) {
            float f16 = 0.0f;
            float f17 = 0.0f;
            for (int i26 = 0; i26 < i3; i26++) {
                f17 = (float) (f17 + (Math.pow(this.f129649a[i26][i19], 2.0d) * Math.signum(this.f129649a[i26][i19])));
                f16 += Math.abs((int) this.f129649a[i26][i19]);
            }
            if (f16 == 0.0f) {
                i18 = 0;
            } else {
                i18 = (int) (f17 / f16);
            }
            short[] sArr = this.f129652d;
            if (f16 == 0.0f) {
                a16 = 0;
            } else {
                a16 = a(i18);
            }
            sArr[i19] = a16;
        }
        return a(i17, i16);
    }
}
