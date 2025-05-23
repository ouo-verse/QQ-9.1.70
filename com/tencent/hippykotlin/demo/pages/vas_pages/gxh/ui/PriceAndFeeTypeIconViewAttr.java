package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import c01.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.DressItem;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.User;
import com.tencent.kuikly.core.base.k;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class PriceAndFeeTypeIconViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceAndFeeTypeIconViewAttr.class, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "getItem$qecommerce_biz_release()Lcom/tencent/hippykotlin/demo/pages/vas_pages/gxh/common/models/DressItem;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceAndFeeTypeIconViewAttr.class, QCircleAlphaUserReporter.KEY_USER, "getUser$qecommerce_biz_release()Lcom/tencent/hippykotlin/demo/pages/vas_pages/gxh/common/models/User;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceAndFeeTypeIconViewAttr.class, "viewScale", "getViewScale$qecommerce_biz_release()F", 0)};
    public final ReadWriteProperty item$delegate = c.a(new DressItem());
    public final ReadWriteProperty user$delegate = c.a(new User());
    public final ReadWriteProperty viewScale$delegate = c.a(Float.valueOf(-1.0f));

    public final DressItem getItem$qecommerce_biz_release() {
        return (DressItem) this.item$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final float getViewScale$qecommerce_biz_release() {
        return ((Number) this.viewScale$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }
}
