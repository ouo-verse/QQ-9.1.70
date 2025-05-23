package com.airbnb.lottie.model;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CubicCurveData {
    private final PointF controlPoint1;
    private final PointF controlPoint2;
    private final PointF vertex;

    public CubicCurveData() {
        this.controlPoint1 = new PointF();
        this.controlPoint2 = new PointF();
        this.vertex = new PointF();
    }

    public PointF getControlPoint1() {
        return this.controlPoint1;
    }

    public PointF getControlPoint2() {
        return this.controlPoint2;
    }

    public PointF getVertex() {
        return this.vertex;
    }

    public void setControlPoint1(float f16, float f17) {
        this.controlPoint1.set(f16, f17);
    }

    public void setControlPoint2(float f16, float f17) {
        this.controlPoint2.set(f16, f17);
    }

    public void setFrom(CubicCurveData cubicCurveData) {
        PointF pointF = cubicCurveData.vertex;
        setVertex(pointF.x, pointF.y);
        PointF pointF2 = cubicCurveData.controlPoint1;
        setControlPoint1(pointF2.x, pointF2.y);
        PointF pointF3 = cubicCurveData.controlPoint2;
        setControlPoint2(pointF3.x, pointF3.y);
    }

    public void setVertex(float f16, float f17) {
        this.vertex.set(f16, f17);
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.vertex.x), Float.valueOf(this.vertex.y), Float.valueOf(this.controlPoint1.x), Float.valueOf(this.controlPoint1.y), Float.valueOf(this.controlPoint2.x), Float.valueOf(this.controlPoint2.y));
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.controlPoint1 = pointF;
        this.controlPoint2 = pointF2;
        this.vertex = pointF3;
    }
}
