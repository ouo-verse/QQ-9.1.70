package com.tencent.hippykotlin.demo.pages.goods_center.event;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterEventDataBackEvent {
    public final Boolean isAfterSearch;
    public final String lastQueryText;

    public GoodsCenterEventDataBackEvent() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        Boolean bool = this.isAfterSearch;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.lastQueryText;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterEventDataBackEvent(isAfterSearch=");
        m3.append(this.isAfterSearch);
        m3.append(", lastQueryText=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.lastQueryText, ')');
    }

    public GoodsCenterEventDataBackEvent(Boolean bool, String str) {
        this.isAfterSearch = bool;
        this.lastQueryText = str;
    }

    public /* synthetic */ GoodsCenterEventDataBackEvent(Boolean bool, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterEventDataBackEvent)) {
            return false;
        }
        GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = (GoodsCenterEventDataBackEvent) obj;
        return Intrinsics.areEqual(this.isAfterSearch, goodsCenterEventDataBackEvent.isAfterSearch) && Intrinsics.areEqual(this.lastQueryText, goodsCenterEventDataBackEvent.lastQueryText);
    }
}
