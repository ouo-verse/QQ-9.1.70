package com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterFooterPlaceHolderView extends GoodsCenterCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderViewAttr");
        final GoodsCenterFooterPlaceHolderViewAttr goodsCenterFooterPlaceHolderViewAttr = (GoodsCenterFooterPlaceHolderViewAttr) attr;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final GoodsCenterFooterPlaceHolderViewAttr goodsCenterFooterPlaceHolderViewAttr2 = GoodsCenterFooterPlaceHolderViewAttr.this;
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.keepAlive(true);
                        mVar2.mo153width(mVar2.getPagerData().m());
                        GoodsCenterFooterPlaceHolderViewAttr goodsCenterFooterPlaceHolderViewAttr3 = GoodsCenterFooterPlaceHolderViewAttr.this;
                        mVar2.mo141height(((Number) goodsCenterFooterPlaceHolderViewAttr3.viewHeight$delegate.getValue(goodsCenterFooterPlaceHolderViewAttr3, GoodsCenterFooterPlaceHolderViewAttr.$$delegatedProperties[0])).floatValue());
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterCardAttr createAttr() {
        return new GoodsCenterFooterPlaceHolderViewAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewContentSizeChanged(float f16) {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderViewAttr");
        GoodsCenterFooterPlaceHolderViewAttr goodsCenterFooterPlaceHolderViewAttr = (GoodsCenterFooterPlaceHolderViewAttr) attr;
        IGoodsCenterCardViewModel viewModel = ((GoodsCenterCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderViewModel");
        GoodsCenterFooterPlaceHolderViewModel goodsCenterFooterPlaceHolderViewModel = (GoodsCenterFooterPlaceHolderViewModel) viewModel;
        float f17 = goodsCenterFooterPlaceHolderViewModel.ceilingOffsetY + goodsCenterFooterPlaceHolderViewModel.mainViewHeight;
        if (f16 >= f17) {
            if (f16 == f17) {
                return;
            }
            goodsCenterFooterPlaceHolderViewAttr.viewHeight$delegate.setValue(goodsCenterFooterPlaceHolderViewAttr, GoodsCenterFooterPlaceHolderViewAttr.$$delegatedProperties[0], Float.valueOf(0.0f));
        } else {
            A attr2 = getAttr();
            Intrinsics.checkNotNull(attr2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.card.placeholder.GoodsCenterFooterPlaceHolderViewAttr");
            GoodsCenterFooterPlaceHolderViewAttr goodsCenterFooterPlaceHolderViewAttr2 = (GoodsCenterFooterPlaceHolderViewAttr) attr2;
            goodsCenterFooterPlaceHolderViewAttr2.viewHeight$delegate.setValue(goodsCenterFooterPlaceHolderViewAttr2, GoodsCenterFooterPlaceHolderViewAttr.$$delegatedProperties[0], Float.valueOf(f17 - f16));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterFooterPlaceHolderViewAttr();
    }
}
