package com.tencent.luggage.wxa.i9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends f {

    /* renamed from: n, reason: collision with root package name */
    public float f129670n;

    /* renamed from: i, reason: collision with root package name */
    public float f129665i = 128.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f129666j = 128.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f129667k = 128.0f;

    /* renamed from: l, reason: collision with root package name */
    public int f129668l = 44100;

    /* renamed from: m, reason: collision with root package name */
    public int f129669m = (int) ((((44100 * 0.02f) * 2.0f) * 16.0f) / 8.0f);

    /* renamed from: o, reason: collision with root package name */
    public float f129671o = 1.0f;

    public k() {
        this.f129670n = 44100 / r1;
    }

    @Override // com.tencent.luggage.wxa.i9.f
    public byte[] a(int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < i3; i26++) {
                i19 += this.f129649a[i26][i18];
                if (i19 > this.f129654f) {
                    this.f129665i *= 32768.0f / i19;
                } else if (i19 < this.f129655g) {
                    this.f129665i *= 32768.0f / i19;
                }
            }
            float f16 = this.f129665i;
            float f17 = this.f129666j;
            if (f16 >= f17) {
                float f18 = this.f129670n;
                float f19 = this.f129671o;
                this.f129665i = (((f17 + 1.0f) * f18) + (f16 * f19)) / (f18 + f19);
            } else {
                this.f129665i = (f17 + f16) / 2.0f;
            }
            float f26 = this.f129665i;
            this.f129666j = f26;
            if ((((int) (f26 * 128.0f)) >> 7) != 128) {
                i19 = ((int) (i19 * ((this.f129667k * f26) / 128.0f))) / 128;
            }
            this.f129652d[i18] = a(i19);
        }
        return a(i17, i16);
    }
}
