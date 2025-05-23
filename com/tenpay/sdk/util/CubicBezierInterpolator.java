package com.tenpay.sdk.util;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CubicBezierInterpolator implements Interpolator {
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;

    public CubicBezierInterpolator(float f16, float f17, float f18, float f19) {
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        pointF.x = f16;
        pointF.y = f17;
        pointF2.x = f18;
        pointF2.y = f19;
    }

    public static double cubicCurves(double d16, double d17, double d18, double d19, double d26) {
        double d27 = 1.0d - d16;
        double d28 = d16 * d16;
        double d29 = d27 * d27;
        return (d29 * d27 * d17) + (d29 * 3.0d * d16 * d18) + (d27 * 3.0d * d28 * d19) + (d28 * d16 * d26);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        return (float) cubicCurves(f16, 0.0d, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
    }
}
