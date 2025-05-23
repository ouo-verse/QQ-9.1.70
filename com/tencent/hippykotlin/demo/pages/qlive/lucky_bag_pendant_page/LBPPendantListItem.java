package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon.LiveCouponRspModel;
import com.tencent.kuikly.core.base.BaseObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPPendantListItem extends BaseObject {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPPendantListItem.class, "detail", "getDetail()Lcom/tencent/hippykotlin/demo/pages/qlive/lucky_bag_pendant_page/LBPPlayDetail;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPPendantListItem.class, "showPendant", "getShowPendant()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPPendantListItem.class, "couponInfo", "getCouponInfo()Lcom/tencent/hippykotlin/demo/pages/qlive/lucky_bag_pendant_page/coupon/LiveCouponRspModel;", 0)};
    public double localTimeDiffServe;
    public final ReadWriteProperty detail$delegate = c.a(null);
    public final ReadWriteProperty showPendant$delegate = c.a(Boolean.FALSE);
    public int type = 1;
    public final ReadWriteProperty couponInfo$delegate = c.a(null);

    public final LiveCouponRspModel getCouponInfo() {
        return (LiveCouponRspModel) this.couponInfo$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final LBPPlayDetail getDetail() {
        return (LBPPlayDetail) this.detail$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean getShowPendant() {
        return ((Boolean) this.showPendant$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setShowPendant() {
        this.showPendant$delegate.setValue(this, $$delegatedProperties[1], Boolean.TRUE);
    }
}
