package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponCouponInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final int canUseCouponNum;
    public final ArrayList<ShopCouponCouponOrderInfo> couponOrderInfo;
    public final long discountPrice;
    public final boolean isBestDiscount;
    public final boolean isPriceBelowZero;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ShopCouponCouponInfo decode(e eVar) {
            ArrayList arrayList;
            b l3 = eVar.l("coupon_order_info");
            if (l3 != null) {
                ArrayList arrayList2 = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    Object d16 = l3.d(i3);
                    if (d16 != null) {
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d16;
                        e m3 = eVar2.m("coupon_show_info");
                        arrayList2.add(new ShopCouponCouponOrderInfo(m3 != null ? ShopCouponCouponShowInfo.Companion.decode(m3) : null, eVar2.q("coupon_id", ""), eVar2.g("is_in_best_options", false), eVar2.g("is_user_select", false), eVar2.g("can_use", false)));
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new ShopCouponCouponInfo(arrayList, eVar.g("is_best_discount", false), eVar.o("discount_price", 0L), eVar.k("can_use_coupon_num", 0), eVar.g("is_price_below_zero", false));
        }
    }

    public ShopCouponCouponInfo() {
        this(null, false, 0L, 0, false, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        ArrayList<ShopCouponCouponOrderInfo> arrayList = this.couponOrderInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponCouponOrderInfo) it.next()).encode());
            }
        }
        eVar.v("coupon_order_info", bVar);
        eVar.w("is_best_discount", this.isBestDiscount);
        eVar.u("discount_price", this.discountPrice);
        eVar.t("can_use_coupon_num", this.canUseCouponNum);
        eVar.w("is_price_below_zero", this.isPriceBelowZero);
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        ArrayList<ShopCouponCouponOrderInfo> arrayList = this.couponOrderInfo;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        boolean z16 = this.isBestDiscount;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int m3 = QQAudioParams$$ExternalSyntheticOutline0.m(this.canUseCouponNum, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.discountPrice, (hashCode + i3) * 31, 31), 31);
        boolean z17 = this.isPriceBelowZero;
        return m3 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponInfo(couponOrderInfo=");
        m3.append(this.couponOrderInfo);
        m3.append(", isBestDiscount=");
        m3.append(this.isBestDiscount);
        m3.append(", discountPrice=");
        m3.append(this.discountPrice);
        m3.append(", canUseCouponNum=");
        m3.append(this.canUseCouponNum);
        m3.append(", isPriceBelowZero=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.isPriceBelowZero, ')');
    }

    public ShopCouponCouponInfo(ArrayList<ShopCouponCouponOrderInfo> arrayList, boolean z16, long j3, int i3, boolean z17) {
        this.couponOrderInfo = arrayList;
        this.isBestDiscount = z16;
        this.discountPrice = j3;
        this.canUseCouponNum = i3;
        this.isPriceBelowZero = z17;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponInfo)) {
            return false;
        }
        ShopCouponCouponInfo shopCouponCouponInfo = (ShopCouponCouponInfo) obj;
        return Intrinsics.areEqual(this.couponOrderInfo, shopCouponCouponInfo.couponOrderInfo) && this.isBestDiscount == shopCouponCouponInfo.isBestDiscount && this.discountPrice == shopCouponCouponInfo.discountPrice && this.canUseCouponNum == shopCouponCouponInfo.canUseCouponNum && this.isPriceBelowZero == shopCouponCouponInfo.isPriceBelowZero;
    }

    public /* synthetic */ ShopCouponCouponInfo(ArrayList arrayList, boolean z16, long j3, int i3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, false, 0L, 0, false);
    }
}
