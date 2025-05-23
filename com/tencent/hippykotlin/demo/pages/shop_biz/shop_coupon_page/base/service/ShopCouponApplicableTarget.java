package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponApplicableTarget implements ISSOModel {
    public final int couponType;
    public final ArrayList<ShopCouponTarget> target;

    public ShopCouponApplicableTarget() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("coupon_type", this.couponType);
        b bVar = new b();
        ArrayList<ShopCouponTarget> arrayList = this.target;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((ShopCouponTarget) it.next()).encode());
            }
        }
        eVar.v("target", bVar);
        return eVar;
    }

    public final int hashCode() {
        int i3 = this.couponType * 31;
        ArrayList<ShopCouponTarget> arrayList = this.target;
        return i3 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponApplicableTarget(couponType=");
        m3.append(this.couponType);
        m3.append(", target=");
        m3.append(this.target);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponApplicableTarget(int i3, ArrayList<ShopCouponTarget> arrayList) {
        this.couponType = i3;
        this.target = arrayList;
    }

    public /* synthetic */ ShopCouponApplicableTarget(int i3, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponApplicableTarget)) {
            return false;
        }
        ShopCouponApplicableTarget shopCouponApplicableTarget = (ShopCouponApplicableTarget) obj;
        return this.couponType == shopCouponApplicableTarget.couponType && Intrinsics.areEqual(this.target, shopCouponApplicableTarget.target);
    }
}
