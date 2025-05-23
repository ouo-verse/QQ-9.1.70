package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.select_coupon;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class TitleItem implements SelectCouponItemModel {
    public final String title = "\u8be5\u8ba2\u5355\u4e0d\u53ef\u4f7f\u7528\u7684\u4f18\u60e0\u5238";

    public final int hashCode() {
        return this.title.hashCode();
    }

    public final String toString() {
        return LoadFailParams$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("TitleItem(title="), this.title, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TitleItem) && Intrinsics.areEqual(this.title, ((TitleItem) obj).title);
    }
}
