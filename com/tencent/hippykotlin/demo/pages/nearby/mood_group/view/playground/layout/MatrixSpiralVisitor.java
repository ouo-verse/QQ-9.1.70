package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MatrixSpiralVisitor {
    public int directionIndex;
    public final Pair<Integer, Integer>[] directions;
    public final int height;
    public boolean initialized;
    public int step = 1;
    public int stepsInCurrentDirection;
    public int stepsInCurrentLeg;
    public boolean[][] visited;
    public final int width;

    /* renamed from: x, reason: collision with root package name */
    public int f114229x;

    /* renamed from: y, reason: collision with root package name */
    public int f114230y;

    public MatrixSpiralVisitor(int i3, int i16) {
        this.width = i3;
        this.height = i16;
        this.f114229x = i3 / 2;
        this.f114230y = i16 / 2;
        boolean[][] zArr = new boolean[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            zArr[i17] = new boolean[this.width];
        }
        this.visited = zArr;
        this.directions = new Pair[]{new Pair<>(0, -1), new Pair<>(-1, 0), new Pair<>(0, 1), new Pair<>(1, 0)};
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Point {

        /* renamed from: x, reason: collision with root package name */
        public final int f114231x;

        /* renamed from: y, reason: collision with root package name */
        public final int f114232y;

        public Point(int i3, int i16) {
            this.f114231x = i3;
            this.f114232y = i16;
        }

        public final int hashCode() {
            return this.f114232y + (this.f114231x * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Point(x=");
            m3.append(this.f114231x);
            m3.append(", y=");
            return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.f114232y, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }
            Point point = (Point) obj;
            return this.f114231x == point.f114231x && this.f114232y == point.f114232y;
        }
    }
}
