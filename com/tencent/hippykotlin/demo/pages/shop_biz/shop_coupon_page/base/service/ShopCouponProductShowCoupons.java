package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class ShopCouponProductShowCoupons implements ISSOModel {
    public final ShopCouponQueryORConditon cond;
    public final ArrayList<ShopCouponCouponShowInfo> couponShowInfo;

    public ShopCouponProductShowCoupons() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        ShopCouponQueryORConditon shopCouponQueryORConditon = this.cond;
        if (shopCouponQueryORConditon != null) {
            eVar.v("cond", shopCouponQueryORConditon.encode());
        }
        b bVar = new b();
        ArrayList<ShopCouponCouponShowInfo> arrayList = this.couponShowInfo;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponCouponShowInfo) it.next()).encode());
            }
        }
        eVar.v("coupon_show_info", bVar);
        return eVar;
    }

    public final int hashCode() {
        ShopCouponQueryORConditon shopCouponQueryORConditon = this.cond;
        int hashCode = (shopCouponQueryORConditon == null ? 0 : shopCouponQueryORConditon.hashCode()) * 31;
        ArrayList<ShopCouponCouponShowInfo> arrayList = this.couponShowInfo;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponProductShowCoupons(cond=");
        m3.append(this.cond);
        m3.append(", couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponProductShowCoupons(ShopCouponQueryORConditon shopCouponQueryORConditon, ArrayList<ShopCouponCouponShowInfo> arrayList) {
        this.cond = shopCouponQueryORConditon;
        this.couponShowInfo = arrayList;
    }

    public /* synthetic */ ShopCouponProductShowCoupons(ShopCouponQueryORConditon shopCouponQueryORConditon, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponProductShowCoupons)) {
            return false;
        }
        ShopCouponProductShowCoupons shopCouponProductShowCoupons = (ShopCouponProductShowCoupons) obj;
        return Intrinsics.areEqual(this.cond, shopCouponProductShowCoupons.cond) && Intrinsics.areEqual(this.couponShowInfo, shopCouponProductShowCoupons.couponShowInfo);
    }
}
