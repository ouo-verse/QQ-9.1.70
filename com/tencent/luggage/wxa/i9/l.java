package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l extends f {

    /* renamed from: i, reason: collision with root package name */
    public float f129672i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f129673j = true;

    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        this.f129673j = true;
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < i3; i26++) {
                i19 += this.f129649a[i26][i18];
            }
            this.f129652d[i18] = a(a(i19, this.f129673j));
        }
        return a(i17, i16);
    }

    public final int a(int i3, boolean z16) {
        float f16 = this.f129672i;
        float f17 = i3;
        int i16 = (int) (f16 * f17);
        int i17 = this.f129654f;
        if (i16 > i17) {
            float f18 = i17 / f17;
            this.f129672i = f18;
            if (f18 < 1.0f) {
                this.f129672i = f18 - ((1.0f - f18) / 16.0f);
            }
            return a(i16, false);
        }
        int i18 = this.f129655g;
        if (i16 < i18) {
            float f19 = i18 / f17;
            this.f129672i = f19;
            if (f19 < 1.0f) {
                this.f129672i = f19 - ((1.0f - f19) / 16.0f);
            }
            return a(i16, false);
        }
        if (z16 && i3 < i17 && i3 > i18) {
            if (f16 < 1.0f) {
                this.f129672i = f16 + ((1.0f - f16) / 16.0f);
            }
            this.f129673j = false;
        }
        return i16;
    }
}
