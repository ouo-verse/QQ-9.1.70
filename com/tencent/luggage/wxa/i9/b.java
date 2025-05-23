package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends f {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        short b16;
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 1;
            int i26 = 0;
            while (i26 < i3) {
                if (i26 == 0) {
                    b16 = this.f129649a[i26][i18];
                } else {
                    b16 = b(i19, this.f129649a[i26][i18]);
                }
                i26++;
                i19 = b16;
            }
            this.f129652d[i18] = a(i19);
        }
        return a(i17, i16);
    }

    public final int b(int i3, int i16) {
        return (int) ((i3 + i16) / Math.sqrt(2.0d));
    }
}
