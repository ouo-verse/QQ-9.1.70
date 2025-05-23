package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.coupon;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LiveCouponPendantAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "bigCouponViewAnimated", "getBigCouponViewAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "bigCouponViewDisappearAnimated", "getBigCouponViewDisappearAnimated()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "pendantAnimationUrl", "getPendantAnimationUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "isAnchor", "isAnchor()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "roomID", "getRoomID()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "couponInfo", "getCouponInfo()Lcom/tencent/hippykotlin/demo/pages/qlive/lucky_bag_pendant_page/coupon/LiveCouponRspModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "couponNum", "getCouponNum()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "couponBatchIdList", "getCouponBatchIdList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LiveCouponPendantAttr.class, "isHRC", "isHRC()I", 0)};
    public final ReadWriteProperty bigCouponViewAnimated$delegate;
    public final ReadWriteProperty bigCouponViewDisappearAnimated$delegate;
    public final ReadWriteProperty couponBatchIdList$delegate;
    public final ReadWriteProperty couponInfo$delegate;
    public final ReadWriteProperty couponNum$delegate;
    public final ReadWriteProperty isAnchor$delegate;
    public final ReadWriteProperty isHRC$delegate;
    public final ReadWriteProperty pendantAnimationUrl$delegate;
    public final ReadWriteProperty roomID$delegate;

    public LiveCouponPendantAttr() {
        Boolean bool = Boolean.FALSE;
        this.bigCouponViewAnimated$delegate = c.a(bool);
        this.bigCouponViewDisappearAnimated$delegate = c.a(bool);
        this.pendantAnimationUrl$delegate = c.a(null);
        this.isAnchor$delegate = c.a(bool);
        this.roomID$delegate = c.a(0L);
        this.couponInfo$delegate = c.a(null);
        this.couponNum$delegate = c.a(0);
        this.couponBatchIdList$delegate = c.b();
        this.isHRC$delegate = c.a(0);
    }

    public final boolean getBigCouponViewAnimated() {
        return ((Boolean) this.bigCouponViewAnimated$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final int getCouponNum() {
        return ((Number) this.couponNum$delegate.getValue(this, $$delegatedProperties[6])).intValue();
    }

    public final void updateCouponData(LiveCouponRspModel liveCouponRspModel) {
        if (liveCouponRspModel != null) {
            this.couponNum$delegate.setValue(this, $$delegatedProperties[6], Integer.valueOf(liveCouponRspModel.couponNum));
            ArrayList<LivingCoupon> arrayList = liveCouponRspModel.coupons;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ((com.tencent.kuikly.core.reactive.collection.c) this.couponBatchIdList$delegate.getValue(this, $$delegatedProperties[7])).add(((LivingCoupon) it.next()).couponBatchId);
                }
            }
        }
    }
}
