package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends f {
    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i16; i18++) {
            float f16 = 1.0f;
            for (int i19 = 0; i19 < i3; i19++) {
                if (i19 == 0) {
                    f16 = this.f129649a[i19][i18];
                } else {
                    f16 = a(f16, this.f129649a[i19][i18]);
                }
            }
            this.f129652d[i18] = a((int) f16);
        }
        return a(i17, i16);
    }

    public final float a(float f16, float f17) {
        float f18;
        float f19;
        int i3;
        if (f16 < 0.0f && f17 < 0.0f) {
            f18 = f16 + f17;
            f19 = f16 * f17;
            i3 = this.f129655g;
        } else {
            if (f16 <= 0.0f || f17 <= 0.0f) {
                return f16 + f17;
            }
            f18 = f16 + f17;
            f19 = f16 * f17;
            i3 = this.f129654f;
        }
        return f18 - (f19 / i3);
    }
}
