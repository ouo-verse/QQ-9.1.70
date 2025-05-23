package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailShopMainPicViewAttr extends ProductDetailCardAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailShopMainPicViewAttr.class, "currentIndex", "getCurrentIndex()I", 0)};
    public final ReadWriteProperty currentIndex$delegate = c.a(1);

    public final int getCurrentIndex() {
        return ((Number) this.currentIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }
}
