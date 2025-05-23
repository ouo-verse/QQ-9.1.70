package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailRingChartViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitle;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitleKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusProgress;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPromotionDataView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataViewModel");
        final QPOrderDetailPromotionDataViewModel qPOrderDetailPromotionDataViewModel = (QPOrderDetailPromotionDataViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView$body$1.1
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
                QPDetailSectionTitleKt.QPDetailSectionTitle(viewContainer2, "\u63a8\u5e7f\u8fdb\u5ea6", new Function1<QPDetailSectionTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailSectionTitle qPDetailSectionTitle) {
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailPromotionDataViewModel qPOrderDetailPromotionDataViewModel2 = QPOrderDetailPromotionDataViewModel.this;
                final QPOrderDetailPromotionDataView qPOrderDetailPromotionDataView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 144.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentCenter();
                                tVar2.marginBottom(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailPromotionDataViewModel qPOrderDetailPromotionDataViewModel3 = QPOrderDetailPromotionDataViewModel.this;
                        final QPOrderDetailPromotionDataView qPOrderDetailPromotionDataView2 = qPOrderDetailPromotionDataView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                QPlusProgress qPlusProgress;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m() / 2.0f, 144.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailPromotionDataViewModel.this.info.promotionDetail;
                                int i3 = (qPlusPromotionDetail == null || (qPlusProgress = qPlusPromotionDetail.progress) == null) ? 0 : qPlusProgress.percent;
                                final QPOrderDetailPromotionDataView qPOrderDetailPromotionDataView3 = qPOrderDetailPromotionDataView2;
                                vVar4.addChild(new QPDetailRingChartView(i3), new Function1<QPDetailRingChartView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPDetailRingChartView qPDetailRingChartView) {
                                        QPDetailRingChartView qPDetailRingChartView2 = qPDetailRingChartView;
                                        final QPOrderDetailPromotionDataView qPOrderDetailPromotionDataView4 = QPOrderDetailPromotionDataView.this;
                                        qPDetailRingChartView2.ref(qPDetailRingChartView2, new Function1<aa<QPDetailRingChartView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<QPDetailRingChartView> aaVar) {
                                                QPOrderDetailPromotionDataView.this.getClass();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        qPDetailRingChartView2.attr(new Function1<QPDetailRingChartViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.2.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPDetailRingChartViewAttr qPDetailRingChartViewAttr) {
                                                qPDetailRingChartViewAttr.size(144.0f, 144.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailPromotionDataViewModel qPOrderDetailPromotionDataViewModel4 = QPOrderDetailPromotionDataViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                String valueOf;
                                QPlusProgress qPlusProgress;
                                QPlusProgress qPlusProgress2;
                                QPlusProgress qPlusProgress3;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m() / 2.0f, 144.0f);
                                        tVar2.flexDirectionColumn();
                                        tVar2.justifyContentSpaceBetween();
                                        return Unit.INSTANCE;
                                    }
                                });
                                QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailPromotionDataViewModel.this.info.promotionDetail;
                                int i3 = 0;
                                int i16 = (qPlusPromotionDetail == null || (qPlusProgress3 = qPlusPromotionDetail.progress) == null) ? 0 : qPlusProgress3.expectCovers;
                                String str = "--";
                                if (i16 < 0) {
                                    valueOf = "--";
                                } else {
                                    valueOf = String.valueOf(i16);
                                }
                                QPDetailSimpleDataViewKt.QPDetailSimpleDataView(vVar4, valueOf, "\u671f\u671b\u8986\u76d6\u4eba\u6570", new Function1<QPDetailSimpleDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPDetailSimpleDataView qPDetailSimpleDataView) {
                                        qPDetailSimpleDataView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                                qPOrderDetailCardAttr.marginTop(11.5f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                QPlusPromotionDetail qPlusPromotionDetail2 = QPOrderDetailPromotionDataViewModel.this.info.promotionDetail;
                                int i17 = (qPlusPromotionDetail2 == null || (qPlusProgress2 = qPlusPromotionDetail2.progress) == null) ? 0 : qPlusProgress2.actualCovers;
                                if (qPlusPromotionDetail2 != null && (qPlusProgress = qPlusPromotionDetail2.progress) != null) {
                                    i3 = qPlusProgress.expectCovers;
                                }
                                int i18 = i17 - i3;
                                if (i18 >= 0) {
                                    str = String.valueOf(i18);
                                }
                                QPDetailSimpleDataViewKt.QPDetailSimpleDataView(vVar4, str, "\u8d85\u989d\u8986\u76d6\u4eba\u6570", new Function1<QPDetailSimpleDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QPDetailSimpleDataView qPDetailSimpleDataView) {
                                        qPDetailSimpleDataView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.promotionData.QPOrderDetailPromotionDataView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                                qPOrderDetailCardAttr.marginBottom(11.5f);
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
                });
                return Unit.INSTANCE;
            }
        };
    }
}
