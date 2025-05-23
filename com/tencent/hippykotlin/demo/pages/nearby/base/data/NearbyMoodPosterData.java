package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.Intrinsics;
import w25.g;

/* loaded from: classes31.dex */
public final class NearbyMoodPosterData implements PosterDataHolder<NearbyMoodPosterData> {
    public final String config;
    public int mid;
    public NearbyMoodPosterData posterData = this;
    public final g user;

    public NearbyMoodPosterData(g gVar, String str, int i3) {
        this.user = gVar;
        this.config = str;
        this.mid = i3;
    }

    public final Object getPosterData() {
        return this.posterData;
    }

    public final int hashCode() {
        return this.mid + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.config, this.user.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NearbyMoodPosterData(user=");
        m3.append(this.user);
        m3.append(", config=");
        m3.append(this.config);
        m3.append(", mid=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.mid, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyMoodPosterData)) {
            return false;
        }
        NearbyMoodPosterData nearbyMoodPosterData = (NearbyMoodPosterData) obj;
        return Intrinsics.areEqual(this.user, nearbyMoodPosterData.user) && Intrinsics.areEqual(this.config, nearbyMoodPosterData.config) && this.mid == nearbyMoodPosterData.mid;
    }
}
