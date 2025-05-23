package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.CategoryItemConfig;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailCategoryAttr extends ProductDetailPendantAttr {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCategoryAttr.class, "indicator", "getIndicator()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCategoryAttr.class, "opacity", "getOpacity()F", 0)};
    public final ArrayList<CategoryItemConfig> itemsConfig;
    public final ReadWriteProperty indicator$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty opacity$delegate = c.a(Float.valueOf(1.0f));

    public ProductDetailCategoryAttr() {
        ArrayList<CategoryItemConfig> arrayList = new ArrayList<>();
        CategoryItemConfig categoryItemConfig = new CategoryItemConfig();
        categoryItemConfig.text("\u5546\u54c1");
        Unit unit = Unit.INSTANCE;
        arrayList.add(0, categoryItemConfig);
        CategoryItemConfig categoryItemConfig2 = new CategoryItemConfig();
        categoryItemConfig2.text("\u8bc4\u4ef7");
        arrayList.add(1, categoryItemConfig2);
        CategoryItemConfig categoryItemConfig3 = new CategoryItemConfig();
        categoryItemConfig3.text("\u8be6\u60c5");
        arrayList.add(2, categoryItemConfig3);
        CategoryItemConfig categoryItemConfig4 = new CategoryItemConfig();
        categoryItemConfig4.text("\u63a8\u8350");
        arrayList.add(3, categoryItemConfig4);
        this.itemsConfig = arrayList;
    }

    public final float getIndicator() {
        return ((Number) this.indicator$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setIndicator(float f16) {
        this.indicator$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(f16));
    }
}
