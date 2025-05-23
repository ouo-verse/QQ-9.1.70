package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.common_share.NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Polygon;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Polygon$getRandomPointGenerator$1;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Rectangle;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.MatrixSpiralVisitor;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.random.Random;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MarkerLayout {
    public final UsedMap fatUsedMap;
    public final Polygon guestAreaPolygon;
    public final int guestCount;
    public final Function0<Point> guestPosGen;
    public final List<PointInfo> guestPositions;
    public final Polygon hostAreaPolygon;
    public final Function0<Point> hostPosGen;
    public PointInfo hostPosition;
    public final w markerInfoBarSize;
    public final UsedMap thinUsedMap;

    public MarkerLayout(Polygon polygon, Polygon polygon2, int i3, w wVar) {
        Float valueOf;
        Float valueOf2;
        Float valueOf3;
        this.guestAreaPolygon = polygon;
        this.hostAreaPolygon = polygon2;
        this.guestCount = i3;
        this.markerInfoBarSize = wVar;
        Iterator<T> it = polygon.getVertices().iterator();
        Float f16 = null;
        if (it.hasNext()) {
            float x16 = ((Point) it.next()).getX();
            while (it.hasNext()) {
                x16 = Math.min(x16, ((Point) it.next()).getX());
            }
            valueOf = Float.valueOf(x16);
        } else {
            valueOf = null;
        }
        float floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
        Iterator<T> it5 = this.guestAreaPolygon.getVertices().iterator();
        if (it5.hasNext()) {
            float x17 = ((Point) it5.next()).getX();
            while (it5.hasNext()) {
                x17 = Math.max(x17, ((Point) it5.next()).getX());
            }
            valueOf2 = Float.valueOf(x17);
        } else {
            valueOf2 = null;
        }
        float floatValue2 = valueOf2 != null ? valueOf2.floatValue() : 0.0f;
        Iterator<T> it6 = this.guestAreaPolygon.getVertices().iterator();
        if (it6.hasNext()) {
            float y16 = ((Point) it6.next()).getY();
            while (it6.hasNext()) {
                y16 = Math.min(y16, ((Point) it6.next()).getY());
            }
            valueOf3 = Float.valueOf(y16);
        } else {
            valueOf3 = null;
        }
        float floatValue3 = valueOf3 != null ? valueOf3.floatValue() : 0.0f;
        Iterator<T> it7 = this.guestAreaPolygon.getVertices().iterator();
        if (it7.hasNext()) {
            float y17 = ((Point) it7.next()).getY();
            while (it7.hasNext()) {
                y17 = Math.max(y17, ((Point) it7.next()).getY());
            }
            f16 = Float.valueOf(y17);
        }
        Rectangle rectangle = new Rectangle(floatValue, floatValue2, floatValue3, f16 != null ? f16.floatValue() : 0.0f);
        this.fatUsedMap = new UsedMap(32, 32, rectangle, (this.guestCount + 1) / 4, this.markerInfoBarSize.getWidth(), this.markerInfoBarSize.getHeight());
        this.thinUsedMap = new UsedMap(64, 64, rectangle, this.guestCount + 1, this.markerInfoBarSize.getWidth(), this.markerInfoBarSize.getHeight());
        this.guestPosGen = (Polygon$getRandomPointGenerator$1) this.guestAreaPolygon.getRandomPointGenerator();
        this.hostPosGen = (Polygon$getRandomPointGenerator$1) this.hostAreaPolygon.getRandomPointGenerator();
        this.hostPosition = new PointInfo(randomPoint(true), -1);
        this.guestPositions = new ArrayList();
        refresh();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.PointInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout.PointInfo>, java.util.ArrayList] */
    public final void refresh() {
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(2, "NBP_MOOD_GROUP_MARKER_LAYOUT");
        this.fatUsedMap.reset();
        this.thinUsedMap.reset();
        this.guestPositions.clear();
        this.hostPosition = genNextPos(true);
        int i3 = this.guestCount;
        for (int i16 = 0; i16 < i3; i16++) {
            this.guestPositions.add(genNextPos(false));
        }
        aPICallTechReporter.reportSuccess();
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u70b9\u4f4d\u751f\u6210\u8017\u65f6: ");
        m3.append(aPICallTechReporter.timeUsage);
        m3.append(" ms");
        kLog.i("MarkerLayout", m3.toString());
    }

    public final Point randomPoint(boolean z16) {
        if (z16) {
            return (Point) this.hostPosGen.invoke();
        }
        return (Point) this.guestPosGen.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b A[EDGE_INSN: B:42:0x014b->B:33:0x014b BREAK  A[LOOP:2: B:22:0x004e->B:40:0x004e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PointInfo genNextPos(boolean z16) {
        PointInfo pointInfo;
        boolean z17;
        MatrixSpiralVisitor.Point point;
        boolean z18;
        int i3 = 1;
        while (i3 < 10) {
            i3++;
            Point randomPoint = randomPoint(z16);
            if (!this.fatUsedMap.isUsed(randomPoint)) {
                this.fatUsedMap.markUsed(randomPoint);
                this.thinUsedMap.markUsed(randomPoint);
                return new PointInfo(randomPoint, i3);
            }
        }
        while (i3 < 110) {
            i3++;
            Point randomPoint2 = randomPoint(z16);
            if (!this.thinUsedMap.isUsed(randomPoint2)) {
                this.fatUsedMap.markUsed(randomPoint2);
                this.thinUsedMap.markUsed(randomPoint2);
                return new PointInfo(randomPoint2, i3);
            }
        }
        UsedMap usedMap = this.thinUsedMap;
        Polygon polygon = this.guestAreaPolygon;
        int i16 = 0;
        while (true) {
            MatrixSpiralVisitor matrixSpiralVisitor = usedMap.mapVisitor;
            pointInfo = null;
            if (!matrixSpiralVisitor.initialized) {
                boolean[][] zArr = matrixSpiralVisitor.visited;
                int i17 = matrixSpiralVisitor.f114230y;
                boolean[] zArr2 = zArr[i17];
                int i18 = matrixSpiralVisitor.f114229x;
                zArr2[i18] = true;
                matrixSpiralVisitor.initialized = true;
                point = new MatrixSpiralVisitor.Point(i18, i17);
                if (point != null) {
                    break;
                }
                i16++;
                if (!usedMap.isUsedByIndex(point.f114231x, point.f114232y)) {
                    float f16 = usedMap.usedMapCellWidth * point.f114231x;
                    Rectangle rectangle = usedMap.mappedRegin;
                    float f17 = f16 + rectangle.left;
                    float f18 = (usedMap.usedMapCellHeight * point.f114232y) + rectangle.top;
                    Point point2 = new Point(f17, f18);
                    if (polygon.contains(point2)) {
                        usedMap.markUsed(point2);
                        Random.Companion companion = Random.INSTANCE;
                        pointInfo = new PointInfo(new Point(f17 + (companion.nextFloat() * usedMap.usedMapCellWidth), f18 + (companion.nextFloat() * usedMap.usedMapCellHeight)), i16);
                        break;
                    }
                }
            }
            while (true) {
                int i19 = matrixSpiralVisitor.stepsInCurrentDirection;
                int i26 = matrixSpiralVisitor.step;
                if (i19 == i26) {
                    matrixSpiralVisitor.directionIndex = (matrixSpiralVisitor.directionIndex + 1) % 4;
                    matrixSpiralVisitor.stepsInCurrentDirection = 0;
                    int i27 = matrixSpiralVisitor.stepsInCurrentLeg + 1;
                    matrixSpiralVisitor.stepsInCurrentLeg = i27;
                    if (i27 == 2) {
                        matrixSpiralVisitor.stepsInCurrentLeg = 0;
                        matrixSpiralVisitor.step = i26 + 1;
                    }
                }
                matrixSpiralVisitor.f114229x = matrixSpiralVisitor.directions[matrixSpiralVisitor.directionIndex].getFirst().intValue() + matrixSpiralVisitor.f114229x;
                int intValue = matrixSpiralVisitor.directions[matrixSpiralVisitor.directionIndex].getSecond().intValue() + matrixSpiralVisitor.f114230y;
                matrixSpiralVisitor.f114230y = intValue;
                matrixSpiralVisitor.stepsInCurrentDirection++;
                int i28 = matrixSpiralVisitor.width;
                int i29 = matrixSpiralVisitor.f114229x;
                if (i29 >= 0 && i29 < i28) {
                    if (intValue >= 0 && intValue < matrixSpiralVisitor.height) {
                        boolean[] zArr3 = matrixSpiralVisitor.visited[intValue];
                        if (!zArr3[i29]) {
                            zArr3[i29] = true;
                            point = new MatrixSpiralVisitor.Point(i29, intValue);
                            break;
                        }
                    }
                }
                boolean[][] zArr4 = matrixSpiralVisitor.visited;
                int length = zArr4.length;
                int i36 = 0;
                while (true) {
                    if (i36 >= length) {
                        z17 = true;
                        break;
                    }
                    boolean[] zArr5 = zArr4[i36];
                    int length2 = zArr5.length;
                    int i37 = 0;
                    while (true) {
                        if (i37 >= length2) {
                            z18 = true;
                            break;
                        }
                        if (!zArr5[i37]) {
                            z18 = false;
                            break;
                        }
                        i37++;
                    }
                    if (!z18) {
                        z17 = false;
                        break;
                    }
                    i36++;
                }
                if (z17) {
                    point = null;
                    break;
                }
            }
            if (point != null) {
            }
        }
        if (pointInfo != null) {
            int i38 = i3 + pointInfo.retryTimes;
            this.fatUsedMap.markUsed(pointInfo.point);
            NearbyCommonShareHelper$getArkMsgAndShare$1$2$$ExternalSyntheticOutline0.m("thinUsedMap \u515c\u5e95\u68c0\u7d22\u6210\u529f: ", i38, KLog.INSTANCE, "MarkerLayout");
            return new PointInfo(pointInfo.point, i38);
        }
        KLog.INSTANCE.e("MarkerLayout", "\u515c\u5e95\u68c0\u7d22\u5931\u8d25: " + i3);
        return new PointInfo(randomPoint(z16), -1);
    }
}
