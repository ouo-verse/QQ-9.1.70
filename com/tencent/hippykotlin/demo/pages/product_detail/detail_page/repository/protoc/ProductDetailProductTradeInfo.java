package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class ProductDetailProductTradeInfo implements ISSOModel {
    public final int deliveryMode;
    public final int hasEndTime;
    public final long presaleEndTime;

    public ProductDetailProductTradeInfo() {
        this(0, 0L, 0, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("delivery_mode", this.deliveryMode);
        eVar.u("presale_end_time", this.presaleEndTime);
        eVar.t("has_end_time", this.hasEndTime);
        return eVar;
    }

    public final int hashCode() {
        return this.hasEndTime + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.presaleEndTime, this.deliveryMode * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ProductDetailProductTradeInfo(deliveryMode=");
        m3.append(this.deliveryMode);
        m3.append(", presaleEndTime=");
        m3.append(this.presaleEndTime);
        m3.append(", hasEndTime=");
        return AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(m3, this.hasEndTime, ')');
    }

    public ProductDetailProductTradeInfo(int i3, long j3, int i16) {
        this.deliveryMode = i3;
        this.presaleEndTime = j3;
        this.hasEndTime = i16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductDetailProductTradeInfo)) {
            return false;
        }
        ProductDetailProductTradeInfo productDetailProductTradeInfo = (ProductDetailProductTradeInfo) obj;
        return this.deliveryMode == productDetailProductTradeInfo.deliveryMode && this.presaleEndTime == productDetailProductTradeInfo.presaleEndTime && this.hasEndTime == productDetailProductTradeInfo.hasEndTime;
    }

    public /* synthetic */ ProductDetailProductTradeInfo(int i3, long j3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0L, 0);
    }
}
