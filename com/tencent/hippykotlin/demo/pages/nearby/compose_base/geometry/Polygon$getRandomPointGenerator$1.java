package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

/* loaded from: classes31.dex */
public final class Polygon$getRandomPointGenerator$1 extends Lambda implements Function0<Point> {
    public final /* synthetic */ List<Float> $triangleAreas;
    public final /* synthetic */ float $triangleAreasSum;
    public final /* synthetic */ List<Triangle> $triangles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Polygon$getRandomPointGenerator$1(float f16, List<Float> list, List<Triangle> list2) {
        super(0);
        this.$triangleAreasSum = f16;
        this.$triangleAreas = list;
        this.$triangles = list2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Point invoke() {
        Point point;
        Object last;
        double d16 = 0.0d;
        double nextDouble = Random.INSTANCE.nextDouble(0.0d, this.$triangleAreasSum);
        int size = this.$triangleAreas.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                point = null;
                break;
            }
            d16 += this.$triangleAreas.get(i3).doubleValue();
            if (nextDouble < d16) {
                point = this.$triangles.get(i3).randomPoint();
                break;
            }
            i3++;
        }
        if (point != null) {
            return point;
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.$triangles);
        return ((Triangle) last).randomPoint();
    }
}
