package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class MyCouponFootLoadingCellAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(MyCouponFootLoadingCellAttr.class, "isLoadFinishing", "isLoadFinishing$qecommerce_biz_release()Z", 0)};
    public final ReadWriteProperty isLoadFinishing$delegate = c.a(Boolean.FALSE);

    public final boolean isLoadFinishing$qecommerce_biz_release() {
        return ((Boolean) this.isLoadFinishing$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }
}
