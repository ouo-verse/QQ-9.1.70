package com.tencent.hippykotlin.demo.pages.goods_center.card.filter;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterCond;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterRangeCond;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterEventFilter {
    public final List<GoodsCenterFilterCond> filterCondList;
    public final List<GoodsCenterRangeCond> rangeFilterCondList;

    public GoodsCenterEventFilter(List<GoodsCenterFilterCond> list, List<GoodsCenterRangeCond> list2) {
        this.filterCondList = list;
        this.rangeFilterCondList = list2;
    }

    public final int hashCode() {
        List<GoodsCenterFilterCond> list = this.filterCondList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<GoodsCenterRangeCond> list2 = this.rangeFilterCondList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterEventFilter(filterCondList=");
        m3.append(this.filterCondList);
        m3.append(", rangeFilterCondList=");
        m3.append(this.rangeFilterCondList);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterEventFilter)) {
            return false;
        }
        GoodsCenterEventFilter goodsCenterEventFilter = (GoodsCenterEventFilter) obj;
        return Intrinsics.areEqual(this.filterCondList, goodsCenterEventFilter.filterCondList) && Intrinsics.areEqual(this.rangeFilterCondList, goodsCenterEventFilter.rangeFilterCondList);
    }
}
