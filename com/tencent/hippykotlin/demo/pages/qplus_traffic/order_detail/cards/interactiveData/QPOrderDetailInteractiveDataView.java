package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitle;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitleKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailInteractiveDataView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataViewModel");
        final QPOrderDetailInteractiveDataViewModel qPOrderDetailInteractiveDataViewModel = (QPOrderDetailInteractiveDataViewModel) viewModel;
        if (!qPOrderDetailInteractiveDataViewModel.shouldShow()) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirectionColumn();
                        mVar2.justifyContentFlexStart();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                QPDetailSectionTitleKt.QPDetailSectionTitle(viewContainer2, "\u4e92\u52a8\u6570\u636e", new Function1<QPDetailSectionTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailSectionTitle qPDetailSectionTitle) {
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailInteractiveDataViewModel qPOrderDetailInteractiveDataViewModel2 = QPOrderDetailInteractiveDataViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView.body.2.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.paddingLeft(16.0f);
                                tVar2.flexDirectionRow();
                                tVar2.marginBottom(16.0f);
                                tVar2.justifyContentSpaceEvenly();
                                return Unit.INSTANCE;
                            }
                        });
                        Pair<String, Integer>[] infoList = QPOrderDetailInteractiveDataViewModel.this.infoList();
                        if (infoList != null) {
                            for (Pair<String, Integer> pair : infoList) {
                                QPDetailSimpleDataViewKt.QPDetailSimpleDataView(vVar2, String.valueOf(pair.getSecond().intValue()), pair.getFirst(), new Function1<QPDetailSimpleDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2$3$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPDetailSimpleDataView qPDetailSimpleDataView) {
                                        qPDetailSimpleDataView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.interactiveData.QPOrderDetailInteractiveDataView$body$2$3$2$1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                                QPOrderDetailCardAttr qPOrderDetailCardAttr2 = qPOrderDetailCardAttr;
                                                qPOrderDetailCardAttr2.mo153width((qPOrderDetailCardAttr2.getPagerData().m() - 32) / 4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
