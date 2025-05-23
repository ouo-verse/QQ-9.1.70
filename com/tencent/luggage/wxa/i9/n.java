package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n extends f {
    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < i3; i26++) {
                i19 += this.f129649a[i26][i18];
            }
            this.f129652d[i18] = (short) (i19 / i3);
        }
        return a(i17, i16);
    }

    @Override // com.tencent.luggage.wxa.i9.f, com.tencent.luggage.wxa.i9.h
    public void release() {
    }
}
