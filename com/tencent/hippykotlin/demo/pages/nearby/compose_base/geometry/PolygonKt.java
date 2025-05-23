package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

/* loaded from: classes31.dex */
public final class PolygonKt {
    public static final Point lineIntersection(Point point, Point point2, Point point3, Point point4) {
        float f16 = point2.f114220x;
        float f17 = point.f114220x;
        float f18 = f16 - f17;
        float f19 = point2.f114221y;
        float f26 = point.f114221y;
        float f27 = f19 - f26;
        float f28 = point4.f114220x;
        float f29 = point3.f114220x;
        float f36 = f28 - f29;
        float f37 = point4.f114221y;
        float f38 = point3.f114221y;
        float f39 = f37 - f38;
        float f46 = f17 - f29;
        float f47 = f26 - f38;
        float f48 = (f18 * f39) + ((-f36) * f27);
        float f49 = ((f47 * f18) + ((-f27) * f46)) / f48;
        float f56 = ((f47 * f36) - (f46 * f39)) / f48;
        if (f49 < 0.0f || f49 > 1.0f || f56 < 0.0f || f56 > 1.0f) {
            return null;
        }
        return new Point((f18 * f56) + f17, (f56 * f27) + f26);
    }
}
