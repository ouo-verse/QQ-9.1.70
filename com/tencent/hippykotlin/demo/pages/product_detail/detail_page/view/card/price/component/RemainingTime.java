package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.component;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RemainingTime {
    public long remainingDay;
    public long remainingHour;
    public long remainingMin;
    public long remainingSec;

    public RemainingTime() {
        this(0L, 0L, 0L, 0L, 15, null);
    }

    public final int hashCode() {
        return d.a(this.remainingSec) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.remainingMin, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.remainingHour, d.a(this.remainingDay) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("RemainingTime(remainingDay=");
        m3.append(this.remainingDay);
        m3.append(", remainingHour=");
        m3.append(this.remainingHour);
        m3.append(", remainingMin=");
        m3.append(this.remainingMin);
        m3.append(", remainingSec=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.remainingSec, ')');
    }

    public RemainingTime(long j3, long j16, long j17, long j18) {
        this.remainingDay = j3;
        this.remainingHour = j16;
        this.remainingMin = j17;
        this.remainingSec = j18;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemainingTime)) {
            return false;
        }
        RemainingTime remainingTime = (RemainingTime) obj;
        return this.remainingDay == remainingTime.remainingDay && this.remainingHour == remainingTime.remainingHour && this.remainingMin == remainingTime.remainingMin && this.remainingSec == remainingTime.remainingSec;
    }

    public /* synthetic */ RemainingTime(long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L, 0L);
    }
}
