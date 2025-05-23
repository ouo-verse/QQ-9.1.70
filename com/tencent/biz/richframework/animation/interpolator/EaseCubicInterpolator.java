package com.tencent.biz.richframework.animation.interpolator;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EaseCubicInterpolator implements Interpolator {
    private final PointF mControlPoint1;
    private final PointF mControlPoint2;
    private int mLastI;

    public EaseCubicInterpolator(float f16, float f17, float f18, float f19) {
        PointF pointF = new PointF();
        this.mControlPoint1 = pointF;
        PointF pointF2 = new PointF();
        this.mControlPoint2 = pointF2;
        this.mLastI = 0;
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
        int i3 = this.mLastI;
        float f17 = f16;
        while (true) {
            if (i3 >= 4096) {
                break;
            }
            f17 = (i3 * 1.0f) / 4096.0f;
            if (cubicCurves(f17, 0.0d, this.mControlPoint1.x, this.mControlPoint2.x, 1.0d) >= f16) {
                this.mLastI = i3;
                break;
            }
            i3++;
        }
        double cubicCurves = cubicCurves(f17, 0.0d, this.mControlPoint1.y, this.mControlPoint2.y, 1.0d);
        if (cubicCurves > 0.999d) {
            this.mLastI = 0;
            cubicCurves = 1.0d;
        }
        return (float) cubicCurves;
    }
}
