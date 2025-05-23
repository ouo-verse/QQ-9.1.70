package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class SpuDynamic implements ISSOModel {
    public final BuyLimit buyLimit;
    public final String sales;
    public final long salesNum;
    public final String stock;
    public final long stockNum;

    public SpuDynamic() {
        this(null, null, null, 0L, 0L, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("stock", this.stock);
        BuyLimit buyLimit = this.buyLimit;
        if (buyLimit != null) {
            eVar.v("buy_limit", buyLimit.encode());
        }
        eVar.v("sales", this.sales);
        eVar.u("stock_num", this.stockNum);
        eVar.u("sales_num", this.salesNum);
        return eVar;
    }

    public final int hashCode() {
        int hashCode = this.stock.hashCode() * 31;
        BuyLimit buyLimit = this.buyLimit;
        return d.a(this.salesNum) + AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.stockNum, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sales, (hashCode + (buyLimit == null ? 0 : buyLimit.userDailyLimit)) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("SpuDynamic(stock=");
        m3.append(this.stock);
        m3.append(", buyLimit=");
        m3.append(this.buyLimit);
        m3.append(", sales=");
        m3.append(this.sales);
        m3.append(", stockNum=");
        m3.append(this.stockNum);
        m3.append(", salesNum=");
        return GoodsCenterCommissionPercentRange$$ExternalSyntheticOutline0.m(m3, this.salesNum, ')');
    }

    public SpuDynamic(String str, BuyLimit buyLimit, String str2, long j3, long j16) {
        this.stock = str;
        this.buyLimit = buyLimit;
        this.sales = str2;
        this.stockNum = j3;
        this.salesNum = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpuDynamic)) {
            return false;
        }
        SpuDynamic spuDynamic = (SpuDynamic) obj;
        return Intrinsics.areEqual(this.stock, spuDynamic.stock) && Intrinsics.areEqual(this.buyLimit, spuDynamic.buyLimit) && Intrinsics.areEqual(this.sales, spuDynamic.sales) && this.stockNum == spuDynamic.stockNum && this.salesNum == spuDynamic.salesNum;
    }

    public /* synthetic */ SpuDynamic(String str, BuyLimit buyLimit, String str2, long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "", 0L, 0L);
    }
}
