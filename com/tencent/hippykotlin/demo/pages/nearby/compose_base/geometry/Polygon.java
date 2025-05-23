package com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class Polygon {
    public final List<Point> vertices;

    public Polygon(List<Point> list) {
        this.vertices = list;
    }

    public final boolean contains(Point point) {
        int size = this.vertices.size() - 1;
        boolean z16 = false;
        for (int i3 = 0; i3 < this.vertices.size(); i3++) {
            if ((this.vertices.get(i3).f114221y >= point.f114221y) != (this.vertices.get(size).f114221y >= point.f114221y)) {
                if (point.f114220x <= (((point.f114221y - this.vertices.get(i3).f114221y) * (this.vertices.get(size).f114220x - this.vertices.get(i3).f114220x)) / (this.vertices.get(size).f114221y - this.vertices.get(i3).f114221y)) + this.vertices.get(i3).f114220x) {
                    z16 = !z16;
                }
            }
            size = i3;
        }
        return z16;
    }

    public final List<Intersection> findIntersections(Polygon polygon) {
        ArrayList arrayList = new ArrayList();
        int size = this.vertices.size();
        int i3 = 0;
        while (i3 < size) {
            Point point = this.vertices.get(i3);
            List<Point> list = this.vertices;
            i3++;
            Line line = new Line(point, list.get(i3 % list.size()));
            int size2 = polygon.vertices.size();
            int i16 = 0;
            while (i16 < size2) {
                Point point2 = polygon.vertices.get(i16);
                List<Point> list2 = polygon.vertices;
                i16++;
                Point point3 = list2.get(i16 % list2.size());
                Line line2 = new Line(point2, point3);
                Point lineIntersection = PolygonKt.lineIntersection(line.f114218a, line.f114219b, point2, point3);
                if (lineIntersection != null) {
                    arrayList.add(new Intersection(line, line2, lineIntersection));
                }
            }
        }
        return arrayList;
    }

    public final float getArea() {
        int collectionSizeOrDefault;
        float sumOfFloat;
        List<Triangle> splitToTriangles = splitToTriangles();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(splitToTriangles, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = splitToTriangles.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((Triangle) it.next()).area()));
        }
        sumOfFloat = CollectionsKt___CollectionsKt.sumOfFloat(arrayList);
        return sumOfFloat;
    }

    public final Function0<Point> getRandomPointGenerator() {
        int collectionSizeOrDefault;
        float sumOfFloat;
        List<Triangle> splitToTriangles = splitToTriangles();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(splitToTriangles, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = ((ArrayList) splitToTriangles).iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((Triangle) it.next()).area()));
        }
        sumOfFloat = CollectionsKt___CollectionsKt.sumOfFloat(arrayList);
        return new Polygon$getRandomPointGenerator$1(sumOfFloat, arrayList, splitToTriangles);
    }

    public final List<Point> getVertices() {
        return this.vertices;
    }

    public final Function0<Point> getVerticesVisitor() {
        Ref.IntRef intRef = new Ref.IntRef();
        int size = this.vertices.size();
        if (size == 0) {
            return null;
        }
        return new Polygon$getVerticesVisitor$1(intRef, size, this);
    }

    public final int hashCode() {
        return this.vertices.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Polygon(vertices=");
        m3.append(this.vertices);
        m3.append(')');
        return m3.toString();
    }

    public final Polygon transform(float f16, float f17) {
        int collectionSizeOrDefault;
        List<Point> list = this.vertices;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Point point : list) {
            arrayList.add(new Point((point.f114220x * 1.0f) + f16, (point.f114221y * 1.0f) + f17));
        }
        return new Polygon(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5 A[LOOP:1: B:5:0x001c->B:38:0x00e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Triangle> splitToTriangles() {
        List mutableList;
        boolean z16;
        Object last;
        Object first;
        boolean z17;
        List listOf;
        Polygon polygon = this;
        ArrayList arrayList = new ArrayList();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) polygon.vertices);
        while (true) {
            char c16 = 2;
            int i3 = 3;
            char c17 = 0;
            int i16 = 1;
            if (mutableList.size() > 3) {
                int size = mutableList.size();
                int i17 = 0;
                while (true) {
                    if (i17 >= size) {
                        z16 = false;
                        break;
                    }
                    if (i17 <= 0) {
                        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) mutableList);
                    } else {
                        last = mutableList.get(i17 - 1);
                    }
                    Point point = (Point) last;
                    Point point2 = (Point) mutableList.get(i17);
                    if (i17 >= mutableList.size() - i16) {
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
                    } else {
                        first = mutableList.get(i17 + 1);
                    }
                    Point point3 = (Point) first;
                    float f16 = point.f114220x;
                    float f17 = point3.f114220x;
                    float f18 = point2.f114221y;
                    float f19 = point3.f114221y;
                    if (((f18 - f19) * (f16 - f17)) - ((point.f114221y - f19) * (point2.f114220x - f17)) >= 0.0f) {
                        for (Point point4 : polygon.vertices) {
                            Point[] pointArr = new Point[i3];
                            pointArr[c17] = point;
                            pointArr[i16] = point2;
                            pointArr[c16] = point3;
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) pointArr);
                            if (listOf.contains(point4)) {
                                c16 = 2;
                            } else {
                                float f26 = point4.f114220x;
                                float f27 = point2.f114220x;
                                float f28 = point.f114221y;
                                float f29 = point2.f114221y;
                                float f36 = point.f114220x;
                                float f37 = point4.f114221y;
                                float f38 = ((f28 - f29) * (f26 - f27)) - ((f37 - f29) * (f36 - f27));
                                float f39 = point3.f114220x;
                                float f46 = point3.f114221y;
                                if (!(f38 >= 0.0f && ((f29 - f46) * (f26 - f39)) - ((f37 - f46) * (f27 - f39)) >= 0.0f && ((f46 - f28) * (f26 - f36)) - ((f37 - f28) * (f39 - f36)) >= 0.0f)) {
                                    c16 = 2;
                                    i3 = 3;
                                    c17 = 0;
                                    i16 = 1;
                                }
                            }
                        }
                        z17 = true;
                        if (!z17) {
                            arrayList.add(new Triangle(point, point2, point3));
                            mutableList.remove(i17);
                            z16 = true;
                            break;
                        }
                        i17++;
                        c16 = 2;
                        i3 = 3;
                        c17 = 0;
                        i16 = 1;
                        polygon = this;
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
                if (!z16) {
                    throw new IllegalArgumentException("Polygon is not simple");
                }
                polygon = this;
            } else {
                if (mutableList.size() == 3) {
                    arrayList.add(new Triangle((Point) mutableList.get(0), (Point) mutableList.get(1), (Point) mutableList.get(2)));
                }
                return arrayList;
            }
        }
    }

    /* loaded from: classes31.dex */
    public static final class Intersection {
        public final Point interPoint;
        public final Line p1Line;
        public final Line p2Line;

        public Intersection(Line line, Line line2, Point point) {
            this.p1Line = line;
            this.p2Line = line2;
            this.interPoint = point;
        }

        public final int hashCode() {
            return this.interPoint.hashCode() + ((this.p2Line.hashCode() + (this.p1Line.hashCode() * 31)) * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Intersection(p1Line=");
            m3.append(this.p1Line);
            m3.append(", p2Line=");
            m3.append(this.p2Line);
            m3.append(", interPoint=");
            m3.append(this.interPoint);
            m3.append(')');
            return m3.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Intersection)) {
                return false;
            }
            Intersection intersection = (Intersection) obj;
            return Intrinsics.areEqual(this.p1Line, intersection.p1Line) && Intrinsics.areEqual(this.p2Line, intersection.p2Line) && Intrinsics.areEqual(this.interPoint, intersection.interPoint);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Polygon) && Intrinsics.areEqual(this.vertices, ((Polygon) obj).vertices);
    }
}
