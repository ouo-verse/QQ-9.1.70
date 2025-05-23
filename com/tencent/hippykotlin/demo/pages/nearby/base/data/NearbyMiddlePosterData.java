package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import x25.m;

/* loaded from: classes31.dex */
public final class NearbyMiddlePosterData implements PosterDataHolder<NearbyMiddlePosterData> {
    public final m poiData;
    public final int appId = 2;
    public NearbyMiddlePosterData posterData = this;

    public NearbyMiddlePosterData(m mVar) {
        this.poiData = mVar;
    }

    public final Object getPosterData() {
        return this.posterData;
    }

    public final int hashCode() {
        return this.poiData.hashCode() + (this.appId * 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyMiddlePosterData(appId=");
        m3.append(this.appId);
        m3.append(", poiData=");
        m3.append(this.poiData);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyMiddlePosterData)) {
            return false;
        }
        NearbyMiddlePosterData nearbyMiddlePosterData = (NearbyMiddlePosterData) obj;
        return this.appId == nearbyMiddlePosterData.appId && Intrinsics.areEqual(this.poiData, nearbyMiddlePosterData.poiData);
    }
}
