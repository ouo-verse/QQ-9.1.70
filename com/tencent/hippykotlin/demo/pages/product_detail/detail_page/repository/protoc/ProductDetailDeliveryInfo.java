package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class ProductDetailDeliveryInfo implements ISSOModel {
    public final long deliveryDay;
    public final int deliveryMode;
    public final int deliveryOpportunity;
    public final int deliveryTimeType;
    public final boolean hasEndTime;
    public final long presaleEndTime;

    public ProductDetailDeliveryInfo() {
        this(0, 0, 0, 0L, 0L, false, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("delivery_mode", this.deliveryMode);
        eVar.t("delivery_opportunity", this.deliveryOpportunity);
        eVar.t("delivery_time_type", this.deliveryTimeType);
        eVar.u("delivery_day", this.deliveryDay);
        eVar.u("presale_end_time", this.presaleEndTime);
        eVar.w("has_end_time", this.hasEndTime);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.presaleEndTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.deliveryDay, QQAudioParams$$ExternalSyntheticOutline0.m(this.deliveryTimeType, QQAudioParams$$ExternalSyntheticOutline0.m(this.deliveryOpportunity, this.deliveryMode * 31, 31), 31), 31), 31);
        boolean z16 = this.hasEndTime;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailDeliveryInfo(deliveryMode=");
        m3.append(this.deliveryMode);
        m3.append(", deliveryOpportunity=");
        m3.append(this.deliveryOpportunity);
        m3.append(", deliveryTimeType=");
        m3.append(this.deliveryTimeType);
        m3.append(", deliveryDay=");
        m3.append(this.deliveryDay);
        m3.append(", presaleEndTime=");
        m3.append(this.presaleEndTime);
        m3.append(", hasEndTime=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.hasEndTime, ')');
    }

    public ProductDetailDeliveryInfo(int i3, int i16, int i17, long j3, long j16, boolean z16) {
        this.deliveryMode = i3;
        this.deliveryOpportunity = i16;
        this.deliveryTimeType = i17;
        this.deliveryDay = j3;
        this.presaleEndTime = j16;
        this.hasEndTime = z16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailDeliveryInfo)) {
            return false;
        }
        ProductDetailDeliveryInfo productDetailDeliveryInfo = (ProductDetailDeliveryInfo) obj;
        return this.deliveryMode == productDetailDeliveryInfo.deliveryMode && this.deliveryOpportunity == productDetailDeliveryInfo.deliveryOpportunity && this.deliveryTimeType == productDetailDeliveryInfo.deliveryTimeType && this.deliveryDay == productDetailDeliveryInfo.deliveryDay && this.presaleEndTime == productDetailDeliveryInfo.presaleEndTime && this.hasEndTime == productDetailDeliveryInfo.hasEndTime;
    }

    public /* synthetic */ ProductDetailDeliveryInfo(int i3, int i16, int i17, long j3, long j16, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, 0, 0L, 0L, false);
    }
}
