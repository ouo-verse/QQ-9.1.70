package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SkuDynamic implements ISSOModel {
    public final BuyLimit buyLimit;
    public final String stock;
    public final long stockNums;

    public SkuDynamic() {
        this(null, 0L, null, 7, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("stock", this.stock);
        eVar.u("stock_nums", this.stockNums);
        BuyLimit buyLimit = this.buyLimit;
        if (buyLimit != null) {
            eVar.v("buy_limit", buyLimit.encode());
        }
        return eVar;
    }

    public final int hashCode() {
        int m3 = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.stockNums, this.stock.hashCode() * 31, 31);
        BuyLimit buyLimit = this.buyLimit;
        return m3 + (buyLimit == null ? 0 : buyLimit.userDailyLimit);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SkuDynamic(stock=");
        m3.append(this.stock);
        m3.append(", stockNums=");
        m3.append(this.stockNums);
        m3.append(", buyLimit=");
        m3.append(this.buyLimit);
        m3.append(')');
        return m3.toString();
    }

    public SkuDynamic(String str, long j3, BuyLimit buyLimit) {
        this.stock = str;
        this.stockNums = j3;
        this.buyLimit = buyLimit;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDynamic)) {
            return false;
        }
        SkuDynamic skuDynamic = (SkuDynamic) obj;
        return Intrinsics.areEqual(this.stock, skuDynamic.stock) && this.stockNums == skuDynamic.stockNums && Intrinsics.areEqual(this.buyLimit, skuDynamic.buyLimit);
    }

    public /* synthetic */ SkuDynamic(String str, long j3, BuyLimit buyLimit, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, null);
    }
}
