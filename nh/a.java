package nh;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f420128a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f420129b;

    /* renamed from: c, reason: collision with root package name */
    private int f420130c;

    public a(float f16, float f17, float f18, float f19) {
        PointF pointF = new PointF();
        this.f420128a = pointF;
        PointF pointF2 = new PointF();
        this.f420129b = pointF2;
        this.f420130c = 0;
        pointF.x = f16;
        pointF.y = f17;
        pointF2.x = f18;
        pointF2.y = f19;
    }

    public static double a(double d16, double d17, double d18, double d19, double d26) {
        double d27 = 1.0d - d16;
        double d28 = d16 * d16;
        double d29 = d27 * d27;
        return (d29 * d27 * d17) + (d29 * 3.0d * d16 * d18) + (d27 * 3.0d * d28 * d19) + (d28 * d16 * d26);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        int i3 = this.f420130c;
        float f17 = f16;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            f17 = (i3 * 1.0f) / 4096.0f;
            if (a(f17, 0.0d, this.f420128a.x, this.f420129b.x, 1.0d) >= f16) {
                this.f420130c = i3;
                break;
            }
            i3++;
        }
        double a16 = a(f17, 0.0d, this.f420128a.y, this.f420129b.y, 1.0d);
        if (a16 > 0.999d) {
            this.f420130c = 0;
            a16 = 1.0d;
        }
        return (float) a16;
    }
}
