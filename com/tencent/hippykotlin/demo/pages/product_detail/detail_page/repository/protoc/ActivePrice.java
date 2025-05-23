package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ActivePrice implements ISSOModel {
    public final String discountPriceDesc;
    public final String discountPriceTxt;
    public final long live;
    public final long liveSpecial;
    public final long max;
    public final long min;
    public final long original;

    public ActivePrice() {
        this(0L, 0L, 0L, null, null, 0L, 0L, 127, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.u(Element.ELEMENT_NAME_MIN, this.min);
        eVar.u("max", this.max);
        eVar.u("original", this.original);
        eVar.v("discount_price_txt", this.discountPriceTxt);
        eVar.v("discount_price_desc", this.discountPriceDesc);
        eVar.u("live", this.live);
        eVar.u("live_special", this.liveSpecial);
        return eVar;
    }

    public final int hashCode() {
        return d.a(this.liveSpecial) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.live, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPriceDesc, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.discountPriceTxt, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.original, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.max, d.a(this.min) * 31, 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActivePrice(min=");
        m3.append(this.min);
        m3.append(", max=");
        m3.append(this.max);
        m3.append(", original=");
        m3.append(this.original);
        m3.append(", discountPriceTxt=");
        m3.append(this.discountPriceTxt);
        m3.append(", discountPriceDesc=");
        m3.append(this.discountPriceDesc);
        m3.append(", live=");
        m3.append(this.live);
        m3.append(", liveSpecial=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.liveSpecial, ')');
    }

    public ActivePrice(long j3, long j16, long j17, String str, String str2, long j18, long j19) {
        this.min = j3;
        this.max = j16;
        this.original = j17;
        this.discountPriceTxt = str;
        this.discountPriceDesc = str2;
        this.live = j18;
        this.liveSpecial = j19;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivePrice)) {
            return false;
        }
        ActivePrice activePrice = (ActivePrice) obj;
        return this.min == activePrice.min && this.max == activePrice.max && this.original == activePrice.original && Intrinsics.areEqual(this.discountPriceTxt, activePrice.discountPriceTxt) && Intrinsics.areEqual(this.discountPriceDesc, activePrice.discountPriceDesc) && this.live == activePrice.live && this.liveSpecial == activePrice.liveSpecial;
    }

    public /* synthetic */ ActivePrice(long j3, long j16, long j17, String str, String str2, long j18, long j19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L, "", "", 0L, 0L);
    }
}
