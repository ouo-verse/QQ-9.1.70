package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailCommissionInfo implements ISSOModel {
    public final String commission;
    public final String commissionRate;
    public final String commissionRateTxt;
    public final int planType;

    public ProductDetailCommissionInfo() {
        this(null, null, null, 0, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("commission", this.commission);
        eVar.v("commission_rate", this.commissionRate);
        eVar.v("commission_rate_txt", this.commissionRateTxt);
        eVar.t("plan_type", this.planType);
        return eVar;
    }

    public final int hashCode() {
        return this.planType + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.commissionRateTxt, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.commissionRate, this.commission.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailCommissionInfo(commission=");
        m3.append(this.commission);
        m3.append(", commissionRate=");
        m3.append(this.commissionRate);
        m3.append(", commissionRateTxt=");
        m3.append(this.commissionRateTxt);
        m3.append(", planType=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.planType, ')');
    }

    public ProductDetailCommissionInfo(String str, String str2, String str3, int i3) {
        this.commission = str;
        this.commissionRate = str2;
        this.commissionRateTxt = str3;
        this.planType = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailCommissionInfo)) {
            return false;
        }
        ProductDetailCommissionInfo productDetailCommissionInfo = (ProductDetailCommissionInfo) obj;
        return Intrinsics.areEqual(this.commission, productDetailCommissionInfo.commission) && Intrinsics.areEqual(this.commissionRate, productDetailCommissionInfo.commissionRate) && Intrinsics.areEqual(this.commissionRateTxt, productDetailCommissionInfo.commissionRateTxt) && this.planType == productDetailCommissionInfo.planType;
    }

    public /* synthetic */ ProductDetailCommissionInfo(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", 0);
    }
}
