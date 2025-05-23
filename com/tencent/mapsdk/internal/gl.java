package com.tencent.mapsdk.internal;

import android.opengl.Matrix;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gl {

    /* renamed from: a, reason: collision with root package name */
    public float f148502a;

    /* renamed from: b, reason: collision with root package name */
    public float f148503b;

    /* renamed from: c, reason: collision with root package name */
    public float f148504c;

    /* renamed from: d, reason: collision with root package name */
    public float f148505d = 1.0f;

    public gl() {
    }

    private gl a(float[] fArr) {
        float[] fArr2 = new float[4];
        Matrix.multiplyMV(fArr2, 0, fArr, 0, new float[]{this.f148502a, this.f148503b, this.f148504c, this.f148505d}, 0);
        float f16 = fArr2[0];
        float f17 = fArr2[3];
        return new gl(f16 / f17, fArr2[1] / f17, fArr2[2] / f17);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof gl)) {
            return false;
        }
        gl glVar = (gl) obj;
        if (this.f148502a != glVar.f148502a || this.f148503b != glVar.f148503b || this.f148504c != glVar.f148504c) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.f148502a + "," + this.f148503b + "," + this.f148504c;
    }

    public gl(float f16, float f17, float f18) {
        this.f148502a = f16;
        this.f148503b = f17;
        this.f148504c = f18;
    }
}
