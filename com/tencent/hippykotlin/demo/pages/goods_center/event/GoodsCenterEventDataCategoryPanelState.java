package com.tencent.hippykotlin.demo.pages.goods_center.event;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;

/* loaded from: classes31.dex */
public final class GoodsCenterEventDataCategoryPanelState {
    public final boolean isHide = false;

    public final int hashCode() {
        boolean z16 = this.isHide;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public final String toString() {
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("GoodsCenterEventDataCategoryPanelState(isHide="), this.isHide, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GoodsCenterEventDataCategoryPanelState) && this.isHide == ((GoodsCenterEventDataCategoryPanelState) obj).isHide;
    }
}
