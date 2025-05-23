package com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort;

import com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortView;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class GoodsCenterSortPendantView extends GoodsCenterPendantView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterPendantAttr access$getAttr(GoodsCenterSortPendantView goodsCenterSortPendantView) {
        return (GoodsCenterPendantAttr) goodsCenterSortPendantView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GoodsCenterEvent access$getEvent(GoodsCenterSortPendantView goodsCenterSortPendantView) {
        return (GoodsCenterEvent) goodsCenterSortPendantView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantViewModel");
        final GoodsCenterSortPendantViewModel goodsCenterSortPendantViewModel = (GoodsCenterSortPendantViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final GoodsCenterSortPendantView goodsCenterSortPendantView = GoodsCenterSortPendantView.this;
                final IGoodsCenterPendantViewModel viewModel2 = GoodsCenterSortPendantView.access$getAttr(goodsCenterSortPendantView).getViewModel();
                GoodsCenterPendantAttr access$getAttr = GoodsCenterSortPendantView.access$getAttr(goodsCenterSortPendantView);
                Intrinsics.checkNotNull(access$getAttr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantViewAttr");
                final float floatValue = ((Number) ((GoodsCenterSortPendantViewAttr) access$getAttr).positionTop$delegate.getValue()).floatValue();
                final GoodsCenterSortPendantViewModel goodsCenterSortPendantViewModel2 = goodsCenterSortPendantViewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        Attr.absolutePosition$default(mVar2, floatValue, 0.0f, 0.0f, 0.0f, 12, null);
                        GoodsCenterSortPendantViewModel goodsCenterSortPendantViewModel3 = goodsCenterSortPendantViewModel2;
                        mVar2.m152visibility(((Boolean) goodsCenterSortPendantViewModel3.isSearching$delegate.getValue(goodsCenterSortPendantViewModel3, GoodsCenterSortPendantViewModel.$$delegatedProperties[0])).booleanValue());
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.addChild(new GoodsCenterSortView(), new Function1<GoodsCenterSortView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GoodsCenterSortView goodsCenterSortView) {
                        GoodsCenterSortView goodsCenterSortView2 = goodsCenterSortView;
                        final IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel = IGoodsCenterPendantViewModel.this;
                        goodsCenterSortView2.attr(new Function1<GoodsCenterCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterCardAttr goodsCenterCardAttr) {
                                GoodsCenterCardAttr goodsCenterCardAttr2 = goodsCenterCardAttr;
                                IGoodsCenterPendantViewModel iGoodsCenterPendantViewModel2 = IGoodsCenterPendantViewModel.this;
                                if (iGoodsCenterPendantViewModel2 instanceof GoodsCenterSortViewModel) {
                                    goodsCenterCardAttr2.viewModel = (IGoodsCenterCardViewModel) iGoodsCenterPendantViewModel2;
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final GoodsCenterSortPendantView goodsCenterSortPendantView2 = goodsCenterSortPendantView;
                        goodsCenterSortView2.event(new Function1<GoodsCenterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GoodsCenterEvent goodsCenterEvent) {
                                final GoodsCenterSortPendantView goodsCenterSortPendantView3 = GoodsCenterSortPendantView.this;
                                goodsCenterEvent.goodsCenterEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantView.body.1.2.2.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(String str, Object obj) {
                                        GoodsCenterSortPendantView.access$getEvent(GoodsCenterSortPendantView.this).onFireEvent(str, obj);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final GoodsCenterPendantAttr createAttr() {
        return new GoodsCenterSortPendantViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        IGoodsCenterPendantViewModel viewModel = ((GoodsCenterPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantViewModel");
        GoodsCenterSortPendantViewModel goodsCenterSortPendantViewModel = (GoodsCenterSortPendantViewModel) viewModel;
        if (((Boolean) goodsCenterSortPendantViewModel.isSearching$delegate.getValue(goodsCenterSortPendantViewModel, GoodsCenterSortPendantViewModel.$$delegatedProperties[0])).booleanValue()) {
            return;
        }
        ((GoodsCenterPendantAttr) getAttr()).m152visibility(scrollParams.getOffsetY() >= goodsCenterSortPendantViewModel.cardYOffset);
        ((GoodsCenterEvent) getEvent()).onFireEvent("change_ceiling_state", Boolean.valueOf(scrollParams.getOffsetY() >= goodsCenterSortPendantViewModel.cardYOffset));
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterSortPendantViewAttr();
    }
}
