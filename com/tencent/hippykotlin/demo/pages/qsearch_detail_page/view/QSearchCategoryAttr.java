package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ce;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCategoryAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCategoryAttr.class, "itemTitles", "getItemTitles()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchCategoryAttr.class, "currentIndex", "getCurrentIndex()I", 0)};
    public float autoScrollExtDistance;
    public Function3<? super m, ? super Integer, ? super Integer, Unit> tabViewStyle;
    public Function3<? super ce, ? super Integer, ? super Integer, Unit> textViewStyle;
    public final ReadWriteProperty itemTitles$delegate = c.b();
    public final ReadWriteProperty currentIndex$delegate = c.a(0);
    public boolean useScrollableIndicator = true;
    public final IndicatorStyle indicatorStyle = new IndicatorStyle();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static final class IndicatorStyle {
        public h color;
        public float height = 3.0f;
        public float margin;
    }

    public final int getCurrentIndex() {
        return ((Number) this.currentIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getItemTitles() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.itemTitles$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
