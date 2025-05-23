package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Triangle {

    /* renamed from: p1, reason: collision with root package name */
    public final Point f114222p1;

    /* renamed from: p2, reason: collision with root package name */
    public final Point f114223p2;

    /* renamed from: p3, reason: collision with root package name */
    public final Point f114224p3;

    public Triangle(Point point, Point point2, Point point3) {
        this.f114222p1 = point;
        this.f114223p2 = point2;
        this.f114224p3 = point3;
    }

    public final float area() {
        Point point = this.f114222p1;
        float f16 = point.f114220x;
        Point point2 = this.f114224p3;
        float f17 = point2.f114220x;
        Point point3 = this.f114223p2;
        float f18 = point3.f114221y;
        float f19 = point2.f114221y;
        return ((f18 - f19) * (f16 - f17)) - ((point.f114221y - f19) * (point3.f114220x - f17));
    }

    public final int hashCode() {
        return this.f114224p3.hashCode() + ((this.f114223p2.hashCode() + (this.f114222p1.hashCode() * 31)) * 31);
    }

    public final Point randomPoint() {
        Random.Companion companion = Random.INSTANCE;
        float nextFloat = companion.nextFloat();
        float nextFloat2 = companion.nextFloat();
        float sqrt = (float) Math.sqrt(nextFloat);
        float f16 = 1;
        float f17 = f16 - sqrt;
        Point point = this.f114222p1;
        float f18 = point.f114220x * f17;
        float f19 = (f16 - nextFloat2) * sqrt;
        Point point2 = this.f114223p2;
        float f26 = (point2.f114220x * f19) + f18;
        float f27 = sqrt * nextFloat2;
        Point point3 = this.f114224p3;
        return new Point((point3.f114220x * f27) + f26, (f27 * point3.f114221y) + (f19 * point2.f114221y) + (f17 * point.f114221y));
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Triangle(p1=");
        m3.append(this.f114222p1);
        m3.append(", p2=");
        m3.append(this.f114223p2);
        m3.append(", p3=");
        m3.append(this.f114224p3);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triangle)) {
            return false;
        }
        Triangle triangle = (Triangle) obj;
        return Intrinsics.areEqual(this.f114222p1, triangle.f114222p1) && Intrinsics.areEqual(this.f114223p2, triangle.f114223p2) && Intrinsics.areEqual(this.f114224p3, triangle.f114224p3);
    }
}
