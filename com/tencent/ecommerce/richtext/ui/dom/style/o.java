package com.tencent.ecommerce.richtext.ui.dom.style;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
public class o {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f105419e = {1, 2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a, reason: collision with root package name */
    private final float[] f105420a = c();

    /* renamed from: b, reason: collision with root package name */
    private float[] f105421b = null;

    /* renamed from: c, reason: collision with root package name */
    private int f105422c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f105423d;

    private float[] c() {
        return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }

    public float a(int i3) {
        float f16;
        char c16;
        float[] fArr = this.f105421b;
        if (fArr != null) {
            f16 = fArr[i3];
        } else if (i3 != 6 && i3 != 7) {
            f16 = 0.0f;
        } else {
            f16 = Float.NaN;
        }
        int i16 = this.f105422c;
        if (i16 == 0) {
            return f16;
        }
        int[] iArr = f105419e;
        if ((iArr[i3] & i16) != 0) {
            return this.f105420a[i3];
        }
        if (this.f105423d) {
            if (i3 != 1 && i3 != 3) {
                c16 = 5;
            } else {
                c16 = 4;
            }
            if ((iArr[c16] & i16) != 0) {
                return this.f105420a[c16];
            }
            if ((i16 & iArr[8]) != 0) {
                return this.f105420a[8];
            }
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b(int i3, int i16) {
        if ((this.f105422c & f105419e[i3]) != 0) {
            return this.f105420a[i3];
        }
        return a(i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Arrays.fill(this.f105420a, Float.NaN);
        this.f105421b = null;
        this.f105423d = false;
        this.f105422c = 0;
    }

    public boolean e(int i3, float f16) {
        boolean z16 = false;
        if (l.a(this.f105420a[i3], f16)) {
            return false;
        }
        this.f105420a[i3] = f16;
        if (f.a(f16)) {
            this.f105422c = (~f105419e[i3]) & this.f105422c;
        } else {
            this.f105422c = f105419e[i3] | this.f105422c;
        }
        int i16 = this.f105422c;
        int[] iArr = f105419e;
        if ((iArr[8] & i16) != 0 || (iArr[4] & i16) != 0 || (i16 & iArr[5]) != 0) {
            z16 = true;
        }
        this.f105423d = z16;
        return true;
    }
}
