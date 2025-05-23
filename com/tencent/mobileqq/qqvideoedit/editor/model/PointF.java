package com.tencent.mobileqq.qqvideoedit.editor.model;

import android.graphics.Point;
import java.io.Serializable;

/* loaded from: classes17.dex */
public class PointF implements Serializable {

    /* renamed from: x, reason: collision with root package name */
    public float f275793x;

    /* renamed from: y, reason: collision with root package name */
    public float f275794y;

    public PointF() {
    }

    public final boolean equals(float f16, float f17) {
        return this.f275793x == f16 && this.f275794y == f17;
    }

    public int hashCode() {
        int i3;
        float f16 = this.f275793x;
        int i16 = 0;
        if (f16 != 0.0f) {
            i3 = Float.floatToIntBits(f16);
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        float f17 = this.f275794y;
        if (f17 != 0.0f) {
            i16 = Float.floatToIntBits(f17);
        }
        return i17 + i16;
    }

    public final float length() {
        return length(this.f275793x, this.f275794y);
    }

    public final void negate() {
        this.f275793x = -this.f275793x;
        this.f275794y = -this.f275794y;
    }

    public final void offset(float f16, float f17) {
        this.f275793x += f16;
        this.f275794y += f17;
    }

    public final void set(float f16, float f17) {
        this.f275793x = f16;
        this.f275794y = f17;
    }

    public String toString() {
        return "PointF(" + this.f275793x + ", " + this.f275794y + ")";
    }

    public PointF(float f16, float f17) {
        this.f275793x = f16;
        this.f275794y = f17;
    }

    public static float length(float f16, float f17) {
        return (float) Math.hypot(f16, f17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        android.graphics.PointF pointF = (android.graphics.PointF) obj;
        return Float.compare(pointF.x, this.f275793x) == 0 && Float.compare(pointF.y, this.f275794y) == 0;
    }

    public final void set(android.graphics.PointF pointF) {
        this.f275793x = pointF.x;
        this.f275794y = pointF.y;
    }

    public PointF(Point point) {
        this.f275793x = point.x;
        this.f275794y = point.y;
    }
}
