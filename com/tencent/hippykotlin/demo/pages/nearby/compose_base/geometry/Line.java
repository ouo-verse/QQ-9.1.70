package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Line {

    /* renamed from: a, reason: collision with root package name */
    public final Point f114218a;

    /* renamed from: b, reason: collision with root package name */
    public final Point f114219b;

    public Line(Point point, Point point2) {
        this.f114218a = point;
        this.f114219b = point2;
    }

    public final int hashCode() {
        return this.f114219b.hashCode() + (this.f114218a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Line(a=");
        m3.append(this.f114218a);
        m3.append(", b=");
        m3.append(this.f114219b);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Line)) {
            return false;
        }
        Line line = (Line) obj;
        return Intrinsics.areEqual(this.f114218a, line.f114218a) && Intrinsics.areEqual(this.f114219b, line.f114219b);
    }
}
