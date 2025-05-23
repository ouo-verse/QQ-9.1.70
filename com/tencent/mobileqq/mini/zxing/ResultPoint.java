package com.tencent.mobileqq.mini.zxing;

import com.tencent.mobileqq.mini.zxing.common.detector.MathUtils;

/* loaded from: classes33.dex */
public class ResultPoint {

    /* renamed from: x, reason: collision with root package name */
    private final float f246769x;

    /* renamed from: y, reason: collision with root package name */
    private final float f246770y;

    public ResultPoint(float f16, float f17) {
        this.f246769x = f16;
        this.f246770y = f17;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f16 = resultPoint2.f246769x;
        float f17 = resultPoint2.f246770y;
        return ((resultPoint3.f246769x - f16) * (resultPoint.f246770y - f17)) - ((resultPoint3.f246770y - f17) * (resultPoint.f246769x - f16));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f246769x, resultPoint.f246770y, resultPoint2.f246769x, resultPoint2.f246770y);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        return this.f246769x == resultPoint.f246769x && this.f246770y == resultPoint.f246770y;
    }

    public final float getX() {
        return this.f246769x;
    }

    public final float getY() {
        return this.f246770y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f246769x) * 31) + Float.floatToIntBits(this.f246770y);
    }

    public final String toString() {
        return "(" + this.f246769x + ',' + this.f246770y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }
}
