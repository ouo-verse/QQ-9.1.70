package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDLogisticsCardViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDLogisticsCardViewAttr.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDLogisticsCardViewAttr.class, "content", "getContent()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDLogisticsCardViewAttr.class, "iconUrl", "getIconUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDLogisticsCardViewAttr.class, WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDLogisticsCardViewAttr.class, "showBtn", "getShowBtn()Z", 0)};
    public AfterSalesDetailRspModel rspModel;
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty content$delegate = c.a("");
    public final ReadWriteProperty iconUrl$delegate = c.a("");
    public final ReadWriteProperty jumpUrl$delegate = c.a("");
    public final ReadWriteProperty showBtn$delegate = c.a(Boolean.FALSE);

    public final String getJumpUrl() {
        return (String) this.jumpUrl$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final AfterSalesDetailRspModel getRspModel() {
        AfterSalesDetailRspModel afterSalesDetailRspModel = this.rspModel;
        if (afterSalesDetailRspModel != null) {
            return afterSalesDetailRspModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rspModel");
        return null;
    }

    public final void setIconUrl(String str) {
        this.iconUrl$delegate.setValue(this, $$delegatedProperties[2], str);
    }
}
