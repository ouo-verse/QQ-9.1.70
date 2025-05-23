package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Polygon;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Polygon$getVerticesVisitor$1;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BackgroundInfo {
    public static final Companion Companion = new Companion();
    public static final Polygon shooterDeadZonePolygon;
    public final NBPMoodGroupConfig.BackgroundConfig config;
    public final float containerHeight;
    public final float containerWidth;
    public final Polygon guestAreaPolygon;
    public final float height;
    public final Polygon hostAreaPolygon;
    public final String imageSrc;
    public final w markerInfoBarSize;
    public final float scale;
    public final float width;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final Polygon getShooterDeadZone(float f16, float f17) {
            Polygon polygon = BackgroundInfo.shooterDeadZonePolygon;
            Point point = polygon.vertices.get(2);
            return polygon.transform((f16 / 2) - point.f114220x, ((f17 - 254.0f) - point.f114221y) + 50);
        }
    }

    static {
        List listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Point[]{new Point(80.0f, 756.0f), new Point(132.0f, 700.0f), new Point(216.0f, 672.0f), new Point(286.0f, 696.0f), new Point(316.0f, 724.0f), new Point(382.0f, 744.0f), new Point(414.0f, 808.0f), new Point(412.0f, 928.0f), new Point(78.0f, 924.0f)});
        shooterDeadZonePolygon = new Polygon(listOf);
    }

    public BackgroundInfo(NBPMoodGroupConfig.BackgroundConfig backgroundConfig, w wVar, float f16, float f17) {
        this.config = backgroundConfig;
        this.markerInfoBarSize = wVar;
        this.containerWidth = f16;
        this.containerHeight = f17;
        float height = f17 / backgroundConfig.getBackground().getHeight();
        this.scale = height;
        this.width = backgroundConfig.getBackground().getWidth() * height;
        this.height = f17;
        this.imageSrc = backgroundConfig.getBackground().getSrc();
        Polygon shooterDeadZone = Companion.getShooterDeadZone(f16, f17);
        this.guestAreaPolygon = buildGuestSeatAreaPolygon(shooterDeadZone);
        this.hostAreaPolygon = buildHostSeatAreaPolygon(shooterDeadZone);
    }

    public final Polygon buildHostSeatAreaPolygon(Polygon polygon) {
        List listOf;
        float width = this.config.hostAreaSize.getWidth() * this.scale;
        float height = this.config.hostAreaSize.getHeight();
        float f16 = this.scale;
        float f17 = height * f16;
        float f18 = this.config.hostAreaMarginTop * f16;
        float f19 = this.containerWidth;
        if (width > f19) {
            width = f19;
        }
        float f26 = (f19 - width) / 2.0f;
        float f27 = width + f26;
        float f28 = f17 + f18;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Point[]{new Point(f26, f18), new Point(f27, f18), new Point(f27, f28), new Point(f26, f28)});
        return cutOff(new Polygon(listOf), polygon);
    }

    public final Polygon cutOff(Polygon polygon, Polygon polygon2) {
        Polygon$getVerticesVisitor$1 polygon$getVerticesVisitor$1;
        List reversed;
        Polygon$getVerticesVisitor$1 polygon$getVerticesVisitor$12;
        Point point;
        try {
            Iterator<T> it = polygon.vertices.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    float f16 = -((Point) next).f114221y;
                    do {
                        Object next2 = it.next();
                        float f17 = -((Point) next2).f114221y;
                        if (Float.compare(f16, f17) < 0) {
                            next = next2;
                            f16 = f17;
                        }
                    } while (it.hasNext());
                }
                Point point2 = (Point) next;
                Function0<Point> verticesVisitor = polygon.getVerticesVisitor();
                if (verticesVisitor == null) {
                    return polygon;
                }
                Polygon access$createNewByFirst = BackgroundInfoKt.access$createNewByFirst(point2, verticesVisitor);
                Iterator<T> it5 = polygon2.vertices.iterator();
                if (it5.hasNext()) {
                    Object next3 = it5.next();
                    if (it5.hasNext()) {
                        float f18 = -((Point) next3).f114221y;
                        do {
                            Object next4 = it5.next();
                            float f19 = -((Point) next4).f114221y;
                            if (Float.compare(f18, f19) < 0) {
                                next3 = next4;
                                f18 = f19;
                            }
                        } while (it5.hasNext());
                    }
                    Point point3 = (Point) next3;
                    Function0<Point> verticesVisitor2 = polygon2.getVerticesVisitor();
                    if (verticesVisitor2 == null) {
                        return polygon;
                    }
                    Polygon access$createNewByFirst2 = BackgroundInfoKt.access$createNewByFirst(point3, verticesVisitor2);
                    ArrayList arrayList = (ArrayList) access$createNewByFirst.findIntersections(access$createNewByFirst2);
                    if (arrayList.size() != 2) {
                        return polygon;
                    }
                    Polygon.Intersection intersection = (Polygon.Intersection) arrayList.get(0);
                    Polygon.Intersection intersection2 = (Polygon.Intersection) arrayList.get(1);
                    ArrayList arrayList2 = new ArrayList();
                    Function0<Point> verticesVisitor3 = access$createNewByFirst.getVerticesVisitor();
                    if (verticesVisitor3 == null) {
                        return polygon;
                    }
                    while (true) {
                        polygon$getVerticesVisitor$1 = (Polygon$getVerticesVisitor$1) verticesVisitor3;
                        Point point4 = (Point) polygon$getVerticesVisitor$1.invoke();
                        if (Intrinsics.areEqual(point4, intersection.p1Line.f114218a)) {
                            break;
                        }
                        arrayList2.add(point4);
                    }
                    arrayList2.add(intersection.p1Line.f114218a);
                    arrayList2.add(intersection.interPoint);
                    arrayList2.add(intersection.p2Line.f114218a);
                    reversed = CollectionsKt___CollectionsKt.reversed(access$createNewByFirst2.vertices);
                    Function0<Point> verticesVisitor4 = new Polygon(reversed).getVerticesVisitor();
                    if (verticesVisitor4 == null) {
                        return polygon;
                    }
                    do {
                        polygon$getVerticesVisitor$12 = (Polygon$getVerticesVisitor$1) verticesVisitor4;
                    } while (!Intrinsics.areEqual((Point) polygon$getVerticesVisitor$12.invoke(), intersection.p2Line.f114219b));
                    while (true) {
                        Point point5 = (Point) polygon$getVerticesVisitor$12.invoke();
                        if (Intrinsics.areEqual(point5, intersection2.p2Line.f114219b)) {
                            break;
                        }
                        arrayList2.add(point5);
                    }
                    arrayList2.add(intersection2.p2Line.f114219b);
                    arrayList2.add(intersection2.interPoint);
                    do {
                        point = (Point) polygon$getVerticesVisitor$1.invoke();
                    } while (!Intrinsics.areEqual(point, intersection2.p1Line.f114219b));
                    arrayList2.add(point);
                    while (true) {
                        Point point6 = (Point) polygon$getVerticesVisitor$1.invoke();
                        if (Intrinsics.areEqual(point6, point2)) {
                            break;
                        }
                        arrayList2.add(point6);
                    }
                    Polygon polygon3 = new Polygon(arrayList2);
                    float area = polygon3.getArea();
                    float area2 = polygon.getArea();
                    float f26 = area / area2;
                    KLog kLog = KLog.INSTANCE;
                    kLog.d("BackgroundInfo", "retArea=" + area + ", fromArea=" + area2 + ", retRatio=" + f26);
                    if (f26 >= 0.5d) {
                        return polygon3;
                    }
                    kLog.e("BackgroundInfo", "cutOff failed, ret area=" + polygon3.getArea() + ", from area=" + polygon.getArea());
                    return polygon;
                }
                throw new NoSuchElementException();
            }
            throw new NoSuchElementException();
        } catch (Exception e16) {
            KLog.INSTANCE.e("BackgroundInfo", "cutOff failed err=" + e16);
            return polygon;
        }
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.containerHeight) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.containerWidth, (this.markerInfoBarSize.hashCode() + (this.config.hashCode() * 31)) * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BackgroundInfo(config=");
        m3.append(this.config);
        m3.append(", markerInfoBarSize=");
        m3.append(this.markerInfoBarSize);
        m3.append(", containerWidth=");
        m3.append(this.containerWidth);
        m3.append(", containerHeight=");
        m3.append(this.containerHeight);
        m3.append(')');
        return m3.toString();
    }

    public final Polygon buildGuestSeatAreaPolygon(Polygon polygon) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Float valueOf;
        Float valueOf2;
        Polygon polygon2;
        Object first;
        List<Point> list = this.config.seatArea;
        float f16 = this.scale;
        float f17 = this.containerWidth - this.width;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<Point> arrayList = new ArrayList(collectionSizeOrDefault);
        for (Point point : list) {
            arrayList.add(new Point((point.f114220x * f16) + f17, (point.f114221y * f16) + 0.0f));
        }
        float f18 = -this.config.seatPaddingLeft;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (Point point2 : arrayList) {
            arrayList2.add(new Point((point2.f114220x * 1.0f) + f18, (point2.f114221y * 1.0f) + 0.0f));
        }
        Polygon polygon3 = new Polygon(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (polygon3.vertices.isEmpty()) {
            polygon2 = new Polygon(arrayList3);
        } else {
            Iterator<T> it = polygon3.vertices.iterator();
            if (it.hasNext()) {
                float f19 = ((Point) it.next()).f114221y;
                while (it.hasNext()) {
                    f19 = Math.min(f19, ((Point) it.next()).f114221y);
                }
                valueOf = Float.valueOf(f19);
            } else {
                valueOf = null;
            }
            float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
            Iterator<T> it5 = polygon3.vertices.iterator();
            if (it5.hasNext()) {
                float f26 = ((Point) it5.next()).f114221y;
                while (it5.hasNext()) {
                    f26 = Math.max(f26, ((Point) it5.next()).f114221y);
                }
                valueOf2 = Float.valueOf(f26);
            } else {
                valueOf2 = null;
            }
            float floatValue2 = valueOf2 != null ? valueOf2.floatValue() : 0.0f;
            int size = polygon3.vertices.size();
            for (int i3 = 0; i3 < size; i3++) {
                Point point3 = polygon3.vertices.get(i3);
                if (i3 >= polygon3.vertices.size() - 1) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) polygon3.vertices);
                } else {
                    first = polygon3.vertices.get(i3 + 1);
                }
                Point point4 = (Point) first;
                float f27 = point3.f114220x;
                if (f27 >= 0.0f || point4.f114220x >= 0.0f) {
                    if (f27 >= 0.0f && point4.f114220x >= 0.0f) {
                        arrayList3.add(point3);
                    }
                    float f28 = floatValue2 - floatValue;
                    float f29 = point4.f114220x;
                    float f36 = point3.f114220x;
                    float f37 = f29 - f36;
                    float f38 = point4.f114221y;
                    float f39 = point3.f114221y;
                    float f46 = f38 - f39;
                    float f47 = 0.0f - f36;
                    float f48 = floatValue - f39;
                    float f49 = (f46 * 0.0f) + ((-f37) * f28);
                    float f56 = ((f48 * 0.0f) + ((-f28) * f47)) / f49;
                    float f57 = ((f48 * f37) - (f47 * f46)) / f49;
                    Point point5 = (f56 < 0.0f || f56 > 1.0f || f57 < 0.0f || f57 > 1.0f) ? null : new Point((f57 * 0.0f) + 0.0f, (f57 * f28) + floatValue);
                    if (point5 != null) {
                        if (f36 < 0.0f) {
                            arrayList3.add(point5);
                        } else {
                            arrayList3.add(point3);
                            arrayList3.add(point5);
                        }
                    }
                }
            }
            polygon2 = new Polygon(arrayList3);
        }
        return cutOff(polygon2.transform(this.config.seatPaddingLeft, 0.0f), polygon);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackgroundInfo)) {
            return false;
        }
        BackgroundInfo backgroundInfo = (BackgroundInfo) obj;
        return Intrinsics.areEqual(this.config, backgroundInfo.config) && Intrinsics.areEqual(this.markerInfoBarSize, backgroundInfo.markerInfoBarSize) && Float.compare(this.containerWidth, backgroundInfo.containerWidth) == 0 && Float.compare(this.containerHeight, backgroundInfo.containerHeight) == 0;
    }
}
