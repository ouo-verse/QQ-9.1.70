package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution;

import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DetailDistributionBottomView$bodyWithSepLine$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final DetailDistributionBottomView$bodyWithSepLine$1 INSTANCE = new DetailDistributionBottomView$bodyWithSepLine$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView$bodyWithSepLine$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.distribution.DetailDistributionBottomView.bodyWithSepLine.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        ((Attr) c.a.a(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null)).mo141height(1.0f);
                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_divider", false, 2, null);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public DetailDistributionBottomView$bodyWithSepLine$1() {
        super(1);
    }
}
