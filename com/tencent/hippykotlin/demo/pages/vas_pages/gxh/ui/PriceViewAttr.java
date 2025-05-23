package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class PriceViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceViewAttr.class, "price", "getPrice$qecommerce_biz_release()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceViewAttr.class, "isInvalid", "isInvalid$qecommerce_biz_release()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceViewAttr.class, "isDiscount", "isDiscount$qecommerce_biz_release()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PriceViewAttr.class, "viewScale", "getViewScale$qecommerce_biz_release()F", 0)};
    public final ReadWriteProperty isDiscount$delegate;
    public final ReadWriteProperty isInvalid$delegate;
    public final ReadWriteProperty price$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty viewScale$delegate;

    public PriceViewAttr() {
        Boolean bool = Boolean.FALSE;
        this.isInvalid$delegate = c.a(bool);
        this.isDiscount$delegate = c.a(bool);
        this.viewScale$delegate = c.a(Float.valueOf(-1.0f));
    }

    public final float getPrice$qecommerce_biz_release() {
        return ((Number) this.price$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final float getViewScale$qecommerce_biz_release() {
        return ((Number) this.viewScale$delegate.getValue(this, $$delegatedProperties[3])).floatValue();
    }

    public final boolean isDiscount$qecommerce_biz_release() {
        return ((Boolean) this.isDiscount$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setPrice$qecommerce_biz_release(float f16) {
        this.price$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }

    public final void setViewScale$qecommerce_biz_release(float f16) {
        this.viewScale$delegate.setValue(this, $$delegatedProperties[3], Float.valueOf(f16));
    }
}
