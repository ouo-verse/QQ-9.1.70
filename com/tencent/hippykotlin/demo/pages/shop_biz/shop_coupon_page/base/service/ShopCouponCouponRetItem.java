package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
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
public final class ShopCouponCouponRetItem implements ISSOModel {
    public final String couponBatchId;
    public final ArrayList<String> couponIds;
    public final ShopCouponCouponShowInfo couponShowInfo;
    public final int retCode;
    public final String retMsg;

    public ShopCouponCouponRetItem() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.t("ret_code", this.retCode);
        eVar.v("ret_msg", this.retMsg);
        eVar.v("coupon_batch_id", this.couponBatchId);
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        if (shopCouponCouponShowInfo != null) {
            eVar.v("coupon_show_info", shopCouponCouponShowInfo.encode());
        }
        b bVar = new b();
        ArrayList<String> arrayList = this.couponIds;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t((String) it.next());
            }
        }
        eVar.v("coupon_ids", bVar);
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.couponBatchId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.retMsg, this.retCode * 31, 31), 31);
        ShopCouponCouponShowInfo shopCouponCouponShowInfo = this.couponShowInfo;
        int hashCode = (m3 + (shopCouponCouponShowInfo == null ? 0 : shopCouponCouponShowInfo.hashCode())) * 31;
        ArrayList<String> arrayList = this.couponIds;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponCouponRetItem(retCode=");
        m3.append(this.retCode);
        m3.append(", retMsg=");
        m3.append(this.retMsg);
        m3.append(", couponBatchId=");
        m3.append(this.couponBatchId);
        m3.append(", couponShowInfo=");
        m3.append(this.couponShowInfo);
        m3.append(", couponIds=");
        m3.append(this.couponIds);
        m3.append(')');
        return m3.toString();
    }

    public ShopCouponCouponRetItem(int i3, String str, String str2, ShopCouponCouponShowInfo shopCouponCouponShowInfo, ArrayList<String> arrayList) {
        this.retCode = i3;
        this.retMsg = str;
        this.couponBatchId = str2;
        this.couponShowInfo = shopCouponCouponShowInfo;
        this.couponIds = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponCouponRetItem)) {
            return false;
        }
        ShopCouponCouponRetItem shopCouponCouponRetItem = (ShopCouponCouponRetItem) obj;
        return this.retCode == shopCouponCouponRetItem.retCode && Intrinsics.areEqual(this.retMsg, shopCouponCouponRetItem.retMsg) && Intrinsics.areEqual(this.couponBatchId, shopCouponCouponRetItem.couponBatchId) && Intrinsics.areEqual(this.couponShowInfo, shopCouponCouponRetItem.couponShowInfo) && Intrinsics.areEqual(this.couponIds, shopCouponCouponRetItem.couponIds);
    }

    public /* synthetic */ ShopCouponCouponRetItem(int i3, String str, String str2, ShopCouponCouponShowInfo shopCouponCouponShowInfo, ArrayList arrayList, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", null, null);
    }
}
