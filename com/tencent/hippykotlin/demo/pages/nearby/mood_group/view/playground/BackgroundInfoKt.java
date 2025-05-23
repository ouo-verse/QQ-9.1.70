package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Polygon;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BackgroundInfoKt {
    public static final Polygon access$createNewByFirst(Point point, Function0 function0) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(point);
        do {
        } while (!Intrinsics.areEqual((Point) function0.invoke(), point));
        while (true) {
            Point point2 = (Point) function0.invoke();
            if (arrayList.contains(point2)) {
                return new Polygon(arrayList);
            }
            arrayList.add(point2);
        }
    }
}
