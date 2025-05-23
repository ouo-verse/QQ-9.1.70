package ah0;

import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float f26073a;

    /* renamed from: b, reason: collision with root package name */
    private final float f26074b;

    /* renamed from: c, reason: collision with root package name */
    private final float f26075c;

    /* renamed from: d, reason: collision with root package name */
    private final float f26076d;

    public b(float f16, float f17, float f18, float f19) {
        this.f26073a = f16;
        this.f26074b = f17;
        this.f26075c = f18;
        this.f26076d = f19;
    }

    float a(float f16, float f17) {
        return (float) ((1.0d - (f17 * 3.0d)) + (f16 * 3.0d));
    }

    float b(float f16, float f17) {
        return (float) ((f17 * 3.0d) - (f16 * 6.0d));
    }

    float c(float f16) {
        return (float) (f16 * 3.0d);
    }

    float d(float f16, float f17, float f18) {
        return ((((a(f17, f18) * f16) + b(f17, f18)) * f16) + c(f17)) * f16;
    }

    float e(float f16, float f17, float f18) {
        double d16 = f16;
        return (float) ((a(f17, f18) * 3.0d * d16 * d16) + (b(f17, f18) * 2.0d * d16) + c(f17));
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return (this.f26073a == this.f26074b && this.f26075c == this.f26076d) ? f16 : d(f(f16), this.f26074b, this.f26076d);
    }

    float f(float f16) {
        float f17 = f16;
        for (int i3 = 0; i3 < 4; i3++) {
            float e16 = e(f17, this.f26073a, this.f26075c);
            if (e16 == 0.0d) {
                return f17;
            }
            f17 -= (d(f17, this.f26073a, this.f26075c) - f16) / e16;
        }
        return f17;
    }
}
