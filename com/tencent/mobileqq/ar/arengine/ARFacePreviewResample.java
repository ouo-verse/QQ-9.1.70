package com.tencent.mobileqq.ar.arengine;

import android.util.Log;

/* loaded from: classes11.dex */
public class ARFacePreviewResample {

    /* renamed from: a, reason: collision with root package name */
    private int f197798a;

    /* renamed from: b, reason: collision with root package name */
    private int f197799b;

    /* renamed from: c, reason: collision with root package name */
    private int f197800c;

    /* renamed from: d, reason: collision with root package name */
    private int f197801d;

    /* renamed from: e, reason: collision with root package name */
    private int f197802e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f197803f;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f197804g;

    private void a(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        nativeScaleYUVImage2(this.f197804g, this.f197801d, this.f197802e, bArr, this.f197798a, this.f197799b);
        Log.d("ARFacePreviewResample", String.format("doResample time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    private native int nativeScaleYUVImage2(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18);

    public byte[] b() {
        if (this.f197803f) {
            return this.f197804g;
        }
        return null;
    }

    public int c() {
        return this.f197802e;
    }

    public int d() {
        return this.f197801d;
    }

    public void e(int i3, int i16, int i17) {
        this.f197798a = i3;
        this.f197799b = i16;
        this.f197800c = i17;
        if (i16 > 480) {
            int i18 = ((i16 / 2) / 4) * 4;
            this.f197802e = i18;
            this.f197801d = ((((i3 * i18) / i16) + 3) / 4) * 4;
            this.f197803f = true;
        } else {
            this.f197802e = i16;
            this.f197801d = i3;
            this.f197803f = false;
        }
        if (this.f197803f) {
            this.f197804g = new byte[((this.f197801d * this.f197802e) * 3) >> 1];
        }
    }

    public boolean f(byte[] bArr) {
        if (this.f197803f) {
            a(bArr);
            return true;
        }
        return false;
    }
}
