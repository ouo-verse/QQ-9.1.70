package com.tencent.mobileqq.wink.editor.model;

import android.graphics.Point;
import java.io.Serializable;

/* loaded from: classes21.dex */
public class PointF implements Serializable {

    /* renamed from: x, reason: collision with root package name */
    public float f320587x;

    /* renamed from: y, reason: collision with root package name */
    public float f320588y;

    public PointF() {
    }

    public final boolean equals(float f16, float f17) {
        return this.f320587x == f16 && this.f320588y == f17;
    }

    public int hashCode() {
        int i3;
        float f16 = this.f320587x;
        int i16 = 0;
        if (f16 != 0.0f) {
            i3 = Float.floatToIntBits(f16);
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        float f17 = this.f320588y;
        if (f17 != 0.0f) {
            i16 = Float.floatToIntBits(f17);
        }
        return i17 + i16;
    }

    public final float length() {
        return length(this.f320587x, this.f320588y);
    }

    public final void negate() {
        this.f320587x = -this.f320587x;
        this.f320588y = -this.f320588y;
    }

    public final void offset(float f16, float f17) {
        this.f320587x += f16;
        this.f320588y += f17;
    }

    public final void set(float f16, float f17) {
        this.f320587x = f16;
        this.f320588y = f17;
    }

    public String toString() {
        return "PointF(" + this.f320587x + ", " + this.f320588y + ")";
    }

    public PointF(float f16, float f17) {
        this.f320587x = f16;
        this.f320588y = f17;
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
        return Float.compare(pointF.x, this.f320587x) == 0 && Float.compare(pointF.y, this.f320588y) == 0;
    }

    public final void set(android.graphics.PointF pointF) {
        this.f320587x = pointF.x;
        this.f320588y = pointF.y;
    }

    public PointF(Point point) {
        this.f320587x = point.x;
        this.f320588y = point.y;
    }
}
