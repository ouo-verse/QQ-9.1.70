package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.layout.FlexNode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CategoryAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CategoryAttr.class, "indicatorPositio", "getIndicatorPositio()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(CategoryAttr.class, "fontChangeEnable", "getFontChangeEnable()Z", 0)};
    public int currentIndex;
    public final ReadWriteProperty fontChangeEnable$delegate;
    public h indicatorColor;
    public final ReadWriteProperty indicatorPositio$delegate;
    public List<? extends CategoryItemConfig> items;
    public final float indicatorWidth = 20.0f;
    public final float indicatorHeight = 3.0f;

    public CategoryAttr() {
        List<? extends CategoryItemConfig> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.items = emptyList;
        this.indicatorColor = h.INSTANCE.b();
        this.indicatorPositio$delegate = c.a(Float.valueOf(0.0f));
        this.fontChangeEnable$delegate = c.a(Boolean.TRUE);
    }

    public final void index(int i3) {
        CategoryItemConfig categoryItemConfig;
        CategoryItemConfig categoryItemConfig2;
        int i16 = this.currentIndex;
        if (i16 < this.items.size()) {
            categoryItemConfig = this.items.get(i16);
        } else {
            categoryItemConfig = new CategoryItemConfig();
        }
        if (i3 < this.items.size()) {
            categoryItemConfig2 = this.items.get(i3);
        } else {
            categoryItemConfig2 = new CategoryItemConfig();
        }
        ReadWriteProperty readWriteProperty = categoryItemConfig.isChoose$delegate;
        KProperty<?>[] kPropertyArr = CategoryItemConfig.$$delegatedProperties;
        readWriteProperty.setValue(categoryItemConfig, kPropertyArr[1], Boolean.FALSE);
        categoryItemConfig2.isChoose$delegate.setValue(categoryItemConfig2, kPropertyArr[1], Boolean.TRUE);
        this.currentIndex = i3;
    }

    public final void indicatorPosition(float f16, boolean z16) {
        float f17 = 2;
        float itemWidth = ((itemWidth() - this.indicatorWidth) / f17) + f16;
        ReadWriteProperty readWriteProperty = this.indicatorPositio$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], Float.valueOf(itemWidth));
        if (z16) {
            index((int) (((this.indicatorWidth / f17) + ((Number) this.indicatorPositio$delegate.getValue(this, kPropertyArr[0])).floatValue()) / itemWidth()));
        }
    }

    public final float itemWidth() {
        FlexNode flexNode = getFlexNode();
        return (flexNode != null ? flexNode.U() : 0.0f) / this.items.size();
    }
}
