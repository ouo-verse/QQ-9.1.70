package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.layout.FlexNode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCategoryAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECCategoryAttr.class, "indicatorPosition", "getIndicatorPosition()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECCategoryAttr.class, "currentIndex", "getCurrentIndex()I", 0)};
    public final ReadWriteProperty currentIndex$delegate;
    public boolean indicatorAnimation;
    public final ReadWriteProperty indicatorPosition$delegate;
    public final IndicatorStyle indicatorStyle;
    public final ItemStyle itemStyle;
    public List<String> itemTitles;
    public boolean switchAutoMoveIndicator;

    public ECCategoryAttr() {
        List<String> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.itemTitles = emptyList;
        this.itemStyle = new ItemStyle();
        this.indicatorStyle = new IndicatorStyle();
        this.indicatorPosition$delegate = c.a(Float.valueOf(0.0f));
        this.currentIndex$delegate = c.a(0);
    }

    public final float getIndicatorPosition() {
        return ((Number) this.indicatorPosition$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void indicatorPosition(float f16) {
        float itemWidth = itemWidth();
        this.indicatorStyle.getClass();
        this.indicatorPosition$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(((itemWidth - 20.0f) / 2) + f16));
    }

    public final float itemWidth() {
        FlexNode flexNode = getFlexNode();
        return (flexNode != null ? flexNode.U() : 0.0f) / this.itemTitles.size();
    }
}
