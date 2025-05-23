package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import k25.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NearbyCalendarPosterData implements PosterDataHolder<NearbyCalendarPosterData> {
    public d luckyCard;
    public NearbyCalendarPosterData posterData;
    public long timeStamp;

    public NearbyCalendarPosterData() {
        this(null, 0L, 3, null);
    }

    public final Object getPosterData() {
        return this.posterData;
    }

    public final int hashCode() {
        return com.tencent.aegiskmm.d.a(this.timeStamp) + (this.luckyCard.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyCalendarPosterData(luckyCard=");
        m3.append(this.luckyCard);
        m3.append(", timeStamp=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.timeStamp, ')');
    }

    public NearbyCalendarPosterData(d dVar, long j3) {
        this.luckyCard = dVar;
        this.timeStamp = j3;
        this.posterData = this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyCalendarPosterData)) {
            return false;
        }
        NearbyCalendarPosterData nearbyCalendarPosterData = (NearbyCalendarPosterData) obj;
        return Intrinsics.areEqual(this.luckyCard, nearbyCalendarPosterData.luckyCard) && this.timeStamp == nearbyCalendarPosterData.timeStamp;
    }

    public /* synthetic */ NearbyCalendarPosterData(d dVar, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new d(null, null, null, 0, null, null, null, 127, null), 0L);
    }
}
