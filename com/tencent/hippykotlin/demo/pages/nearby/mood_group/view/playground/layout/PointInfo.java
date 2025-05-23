package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.layout;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.nearby.compose_base.geometry.Point;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class PointInfo {
    public final Point point;
    public final int retryTimes;

    public PointInfo(Point point, int i3) {
        this.point = point;
        this.retryTimes = i3;
    }

    public final int hashCode() {
        return this.retryTimes + (this.point.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("PointInfo(point=");
        m3.append(this.point);
        m3.append(", retryTimes=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.retryTimes, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointInfo)) {
            return false;
        }
        PointInfo pointInfo = (PointInfo) obj;
        return Intrinsics.areEqual(this.point, pointInfo.point) && this.retryTimes == pointInfo.retryTimes;
    }
}
