package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ActiveSku implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final BuyLimit activeLimit;
    public final ActivePrice activePrice;
    public final ActiveStock activeStock;
    public final BuyLimit liveLimit;
    public final ActivePrice livePrice;
    public final ActiveStock liveStock;

    public ActiveSku() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ActivePrice activePrice = this.livePrice;
        if (activePrice != null) {
            eVar.v("live_price", activePrice.encode());
        }
        ActiveStock activeStock = this.liveStock;
        if (activeStock != null) {
            eVar.v("live_stock", activeStock.encode());
        }
        BuyLimit buyLimit = this.liveLimit;
        if (buyLimit != null) {
            eVar.v("live_limit", buyLimit.encode());
        }
        ActivePrice activePrice2 = this.activePrice;
        if (activePrice2 != null) {
            eVar.v("active_price", activePrice2.encode());
        }
        BuyLimit buyLimit2 = this.activeLimit;
        if (buyLimit2 != null) {
            eVar.v("active_limit", buyLimit2.encode());
        }
        ActiveStock activeStock2 = this.activeStock;
        if (activeStock2 != null) {
            eVar.v("active_stock", activeStock2.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        ActivePrice activePrice = this.livePrice;
        int hashCode = (activePrice == null ? 0 : activePrice.hashCode()) * 31;
        ActiveStock activeStock = this.liveStock;
        int hashCode2 = (hashCode + (activeStock == null ? 0 : activeStock.hashCode())) * 31;
        BuyLimit buyLimit = this.liveLimit;
        int hashCode3 = (hashCode2 + (buyLimit == null ? 0 : buyLimit.hashCode())) * 31;
        ActivePrice activePrice2 = this.activePrice;
        int hashCode4 = (hashCode3 + (activePrice2 == null ? 0 : activePrice2.hashCode())) * 31;
        BuyLimit buyLimit2 = this.activeLimit;
        int hashCode5 = (hashCode4 + (buyLimit2 == null ? 0 : buyLimit2.hashCode())) * 31;
        ActiveStock activeStock2 = this.activeStock;
        return hashCode5 + (activeStock2 != null ? activeStock2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ActiveSku(livePrice=");
        m3.append(this.livePrice);
        m3.append(", liveStock=");
        m3.append(this.liveStock);
        m3.append(", liveLimit=");
        m3.append(this.liveLimit);
        m3.append(", activePrice=");
        m3.append(this.activePrice);
        m3.append(", activeLimit=");
        m3.append(this.activeLimit);
        m3.append(", activeStock=");
        m3.append(this.activeStock);
        m3.append(')');
        return m3.toString();
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final ActiveSku decode(e eVar) {
            e m3 = eVar.m("live_price");
            ActivePrice activePrice = m3 != null ? new ActivePrice(m3.o(Element.ELEMENT_NAME_MIN, 0L), m3.o("max", 0L), m3.o("original", 0L), m3.q("discount_price_txt", ""), m3.q("discount_price_desc", ""), m3.o("live", 0L), m3.o("live_special", 0L)) : null;
            e m16 = eVar.m("live_stock");
            ActiveStock activeStock = m16 != null ? new ActiveStock(m16.o("total", 0L), m16.o("remain", 0L), m16.o("active", 0L), m16.q("remain_txt", "")) : null;
            e m17 = eVar.m("live_limit");
            BuyLimit buyLimit = m17 != null ? new BuyLimit(m17.k("user_daily_limit", 0)) : null;
            e m18 = eVar.m("active_price");
            ActivePrice activePrice2 = m18 != null ? new ActivePrice(m18.o(Element.ELEMENT_NAME_MIN, 0L), m18.o("max", 0L), m18.o("original", 0L), m18.q("discount_price_txt", ""), m18.q("discount_price_desc", ""), m18.o("live", 0L), m18.o("live_special", 0L)) : null;
            e m19 = eVar.m("active_limit");
            BuyLimit buyLimit2 = m19 != null ? new BuyLimit(m19.k("user_daily_limit", 0)) : null;
            e m26 = eVar.m("active_stock");
            return new ActiveSku(activePrice, activeStock, buyLimit, activePrice2, buyLimit2, m26 != null ? new ActiveStock(m26.o("total", 0L), m26.o("remain", 0L), m26.o("active", 0L), m26.q("remain_txt", "")) : null);
        }
    }

    public ActiveSku(ActivePrice activePrice, ActiveStock activeStock, BuyLimit buyLimit, ActivePrice activePrice2, BuyLimit buyLimit2, ActiveStock activeStock2) {
        this.livePrice = activePrice;
        this.liveStock = activeStock;
        this.liveLimit = buyLimit;
        this.activePrice = activePrice2;
        this.activeLimit = buyLimit2;
        this.activeStock = activeStock2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveSku)) {
            return false;
        }
        ActiveSku activeSku = (ActiveSku) obj;
        return Intrinsics.areEqual(this.livePrice, activeSku.livePrice) && Intrinsics.areEqual(this.liveStock, activeSku.liveStock) && Intrinsics.areEqual(this.liveLimit, activeSku.liveLimit) && Intrinsics.areEqual(this.activePrice, activeSku.activePrice) && Intrinsics.areEqual(this.activeLimit, activeSku.activeLimit) && Intrinsics.areEqual(this.activeStock, activeSku.activeStock);
    }

    public /* synthetic */ ActiveSku(ActivePrice activePrice, ActiveStock activeStock, BuyLimit buyLimit, ActivePrice activePrice2, BuyLimit buyLimit2, ActiveStock activeStock2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null, null, null, null);
    }
}
