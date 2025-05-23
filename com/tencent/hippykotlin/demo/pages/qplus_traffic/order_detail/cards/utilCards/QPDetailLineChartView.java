package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards;

import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPDetailLineChartView extends ComposeView<k, l> {
    public final Float[] value;
    public final String[] xLabels;

    public QPDetailLineChartView(Float[] fArr, String[] strArr) {
        this.value = fArr;
        this.xLabels = strArr;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailLineChartView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        Object first;
        Object last;
        super.viewDidLayout();
        Float[] fArr = this.value;
        String[] strArr = this.xLabels;
        e eVar = new e();
        b bVar = new b();
        for (Float f16 : fArr) {
            bVar.t(Float.valueOf(f16.floatValue()));
        }
        Unit unit = Unit.INSTANCE;
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "values", bVar);
        for (String str : strArr) {
            m3.t(str);
        }
        Unit unit2 = Unit.INSTANCE;
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "xlabels", m3);
        if (strArr.length > 4) {
            first = ArraysKt___ArraysKt.first(strArr);
            m16.t(first);
            m16.t(strArr[strArr.length / 3]);
            m16.t(strArr[(strArr.length * 2) / 3]);
            last = ArraysKt___ArraysKt.last(strArr);
            m16.t(last);
        } else {
            for (String str2 : strArr) {
                m16.t(str2);
            }
        }
        Unit unit3 = Unit.INSTANCE;
        eVar.v("xlabelForShow", m16);
        RenderView renderView = getRenderView();
        if (renderView != null) {
            RenderView.b(renderView, "drawChartWithConfig", eVar.toString(), null, 4, null);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "QQECKTVChartView";
    }
}
