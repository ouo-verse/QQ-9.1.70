package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;

/* loaded from: classes31.dex */
public final class Point {

    /* renamed from: x, reason: collision with root package name */
    public final float f114220x;

    /* renamed from: y, reason: collision with root package name */
    public final float f114221y;

    public Point(float f16, float f17) {
        this.f114220x = f16;
        this.f114221y = f17;
    }

    public final float getX() {
        return this.f114220x;
    }

    public final float getY() {
        return this.f114221y;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f114221y) + (Float.floatToIntBits(this.f114220x) * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Point(x=");
        m3.append(this.f114220x);
        m3.append(", y=");
        m3.append(this.f114221y);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return Float.compare(this.f114220x, point.f114220x) == 0 && Float.compare(this.f114221y, point.f114221y) == 0;
    }
}
