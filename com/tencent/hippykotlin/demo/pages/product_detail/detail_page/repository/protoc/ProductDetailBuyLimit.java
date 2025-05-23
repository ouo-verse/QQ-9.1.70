package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class ProductDetailBuyLimit implements ISSOModel {
    public final int userDailyLimit;

    public ProductDetailBuyLimit() {
        this(0, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("user_daily_limit", this.userDailyLimit);
        return eVar;
    }

    public final int hashCode() {
        return this.userDailyLimit;
    }

    public final String toString() {
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailBuyLimit(userDailyLimit="), this.userDailyLimit, ')');
    }

    public ProductDetailBuyLimit(int i3) {
        this.userDailyLimit = i3;
    }

    public /* synthetic */ ProductDetailBuyLimit(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductDetailBuyLimit) && this.userDailyLimit == ((ProductDetailBuyLimit) obj).userDailyLimit;
    }
}
