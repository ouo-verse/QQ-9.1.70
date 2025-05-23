package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes20.dex */
class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private float[] f337462a;

    /* renamed from: b, reason: collision with root package name */
    private float[] f337463b;

    public d(float f16, float f17, float f18, float f19) {
        a(f16, f17, f18, f19);
    }

    private void a(float f16, float f17, float f18, float f19) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f16, f17, f18, f19, 1.0f, 1.0f);
        a(path);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f337462a.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i16 = (i3 + length) / 2;
            if (f16 < this.f337462a[i16]) {
                length = i16;
            } else {
                i3 = i16;
            }
        }
        float[] fArr = this.f337462a;
        float f17 = fArr[length];
        float f18 = fArr[i3];
        float f19 = f17 - f18;
        if (f19 == 0.0f) {
            return this.f337463b[i3];
        }
        float f26 = (f16 - f18) / f19;
        float[] fArr2 = this.f337463b;
        float f27 = fArr2[i3];
        return f27 + (f26 * (fArr2[length] - f27));
    }

    private void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i3 = ((int) (length / 0.002f)) + 1;
        this.f337462a = new float[i3];
        this.f337463b = new float[i3];
        float[] fArr = new float[2];
        for (int i16 = 0; i16 < i3; i16++) {
            pathMeasure.getPosTan((i16 * length) / (i3 - 1), fArr, null);
            this.f337462a[i16] = fArr[0];
            this.f337463b[i16] = fArr[1];
        }
    }
}
