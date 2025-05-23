package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailViewAttr.class, "isClearBackgroundColor", "isClearBackgroundColor()Z", 0)};
    public final ReadWriteProperty isClearBackgroundColor$delegate = c.a(Boolean.FALSE);
    public boolean isHalf;
    public IProductDetailPageDelegate pageDelegate;
    public IProductDetailViewModel viewModel;

    public final boolean isClearBackgroundColor() {
        return ((Boolean) this.isClearBackgroundColor$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setClearBackgroundColor(boolean z16) {
        this.isClearBackgroundColor$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
