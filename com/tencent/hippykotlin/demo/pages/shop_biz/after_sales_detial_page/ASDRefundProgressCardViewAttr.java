package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class ASDRefundProgressCardViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDRefundProgressCardViewAttr.class, "actualAmount", "getActualAmount()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDRefundProgressCardViewAttr.class, "refundRecords", "getRefundRecords()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty actualAmount$delegate = c.a("");
    public final ReadWriteProperty refundRecords$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<RefundProgressRecord> getRefundRecords() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.refundRecords$delegate.getValue(this, $$delegatedProperties[1]);
    }
}
