package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponQueryORConditon implements ISSOModel {
    public final String mediaId;
    public final String shopId;
    public final String spuId;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShopCouponQueryORConditon() {
        this(r0, r0, 7);
        String str = null;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("shop_id", this.shopId);
        eVar.v("spu_id", this.spuId);
        eVar.v("media_id", this.mediaId);
        return eVar;
    }

    public final int hashCode() {
        return this.mediaId.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.spuId, this.shopId.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ShopCouponQueryORConditon(shopId=");
        m3.append(this.shopId);
        m3.append(", spuId=");
        m3.append(this.spuId);
        m3.append(", mediaId=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.mediaId, ')');
    }

    public ShopCouponQueryORConditon(String str, String str2, String str3) {
        this.shopId = str;
        this.spuId = str2;
        this.mediaId = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponQueryORConditon)) {
            return false;
        }
        ShopCouponQueryORConditon shopCouponQueryORConditon = (ShopCouponQueryORConditon) obj;
        return Intrinsics.areEqual(this.shopId, shopCouponQueryORConditon.shopId) && Intrinsics.areEqual(this.spuId, shopCouponQueryORConditon.spuId) && Intrinsics.areEqual(this.mediaId, shopCouponQueryORConditon.mediaId);
    }

    public /* synthetic */ ShopCouponQueryORConditon(String str, String str2, int i3) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? null : "");
    }
}
