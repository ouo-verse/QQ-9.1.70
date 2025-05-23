package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.viewModel.IMyCouponListViewModel;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.layout.FlexNode;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponListViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponListViewAttr.class, "isNotEmptyCoupon", "isNotEmptyCoupon$qecommerce_biz_release()Z", 0)};
    public IMyCouponListViewModel couponViewModel;
    public final ReadWriteProperty isNotEmptyCoupon$delegate = c.a(Boolean.FALSE);

    public final float height() {
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            return flexNode.K();
        }
        return 0.0f;
    }

    public final float width() {
        FlexNode flexNode = getFlexNode();
        if (flexNode != null) {
            return flexNode.U();
        }
        return 0.0f;
    }
}
