package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.obtain_coupon;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ObtainCouponItemModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ObtainCouponItemModel.class, "status", "getStatus()Lcom/tencent/hippykotlin/demo/pages/shop_biz/shop_coupon_page/obtain_coupon/ObtainStatus;", 0)};
    public final CommonCouponItemModel commonItemModel;
    public final ReadWriteProperty status$delegate = c.a(ObtainStatus.INIT);

    public ObtainCouponItemModel(CommonCouponItemModel commonCouponItemModel) {
        this.commonItemModel = commonCouponItemModel;
    }

    public final ObtainStatus getStatus() {
        return (ObtainStatus) this.status$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int hashCode() {
        return this.commonItemModel.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ObtainCouponItemModel(commonItemModel=");
        m3.append(this.commonItemModel);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ObtainCouponItemModel) && Intrinsics.areEqual(this.commonItemModel, ((ObtainCouponItemModel) obj).commonItemModel);
    }
}
