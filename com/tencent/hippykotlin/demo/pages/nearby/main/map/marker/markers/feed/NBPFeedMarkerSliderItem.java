package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.feed;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import n35.v;

/* loaded from: classes31.dex */
public final class NBPFeedMarkerSliderItem {
    public final v image;
    public final String text;

    public NBPFeedMarkerSliderItem(v vVar, String str) {
        this.image = vVar;
        this.text = str;
    }

    public final int hashCode() {
        v vVar = this.image;
        int hashCode = (vVar == null ? 0 : vVar.hashCode()) * 31;
        String str = this.text;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPFeedMarkerSliderItem(image=");
        m3.append(this.image);
        m3.append(", text=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.text, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPFeedMarkerSliderItem)) {
            return false;
        }
        NBPFeedMarkerSliderItem nBPFeedMarkerSliderItem = (NBPFeedMarkerSliderItem) obj;
        return Intrinsics.areEqual(this.image, nBPFeedMarkerSliderItem.image) && Intrinsics.areEqual(this.text, nBPFeedMarkerSliderItem.text);
    }
}
