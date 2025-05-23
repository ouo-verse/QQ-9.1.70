package jc0;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float f409766a;

    /* renamed from: b, reason: collision with root package name */
    private final float f409767b;

    /* renamed from: c, reason: collision with root package name */
    private final float f409768c;

    /* renamed from: d, reason: collision with root package name */
    private final float f409769d;

    public a(float f16, float f17, float f18, float f19) {
        this.f409766a = f16;
        this.f409767b = f17;
        this.f409768c = f18;
        this.f409769d = f19;
    }

    private float a(float f16, float f17, float f18) {
        if (f16 != 0.0f && f16 != 1.0f) {
            float e16 = e(0.0f, f17, f16);
            float e17 = e(f17, f18, f16);
            return e(e(e16, e17, f16), e(e17, e(f18, 1.0f, f16), f16), f16);
        }
        return f16;
    }

    private float b(float f16) {
        float f17 = 0.0f;
        if (f16 <= 0.0f) {
            return 0.0f;
        }
        if (f16 >= 1.0f) {
            return 1.0f;
        }
        float f18 = f16;
        float f19 = 1.0f;
        float f26 = 0.0f;
        for (int i3 = 0; i3 < 8; i3++) {
            f26 = c(f18);
            double c16 = (c(f18 + 1.0E-6f) - f26) / 1.0E-6f;
            float f27 = f26 - f16;
            if (Math.abs(f27) < 1.0E-6f) {
                return f18;
            }
            if (Math.abs(c16) < 9.999999974752427E-7d) {
                break;
            }
            if (f26 < f16) {
                f17 = f18;
            } else {
                f19 = f18;
            }
            f18 = (float) (f18 - (f27 / c16));
        }
        for (int i16 = 0; Math.abs(f26 - f16) > 1.0E-6f && i16 < 8; i16++) {
            if (f26 < f16) {
                float f28 = f18;
                f18 = (f18 + f19) / 2.0f;
                f17 = f28;
            } else {
                f19 = f18;
                f18 = (f18 + f17) / 2.0f;
            }
            f26 = c(f18);
        }
        return f18;
    }

    private float c(float f16) {
        return a(f16, this.f409766a, this.f409768c);
    }

    private float d(float f16) {
        return a(f16, this.f409767b, this.f409769d);
    }

    private float e(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return d(b(f16));
    }
}
