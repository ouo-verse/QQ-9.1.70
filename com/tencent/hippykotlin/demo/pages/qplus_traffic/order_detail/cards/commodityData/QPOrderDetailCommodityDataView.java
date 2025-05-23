package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitle;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitleKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSimpleDataViewKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCommodityData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
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
public final class QPOrderDetailCommodityDataView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataViewModel");
        final QPOrderDetailCommodityDataViewModel qPOrderDetailCommodityDataViewModel = (QPOrderDetailCommodityDataViewModel) viewModel;
        QPlusPromotionDetail qPlusPromotionDetail = qPOrderDetailCommodityDataViewModel.info.promotionDetail;
        if (!((qPlusPromotionDetail != null ? qPlusPromotionDetail.commodityData : null) != null)) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2.1
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
                QPDetailSectionTitleKt.QPDetailSectionTitle(viewContainer2, "\u5546\u54c1\u6570\u636e", new Function1<QPDetailSectionTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailSectionTitle qPDetailSectionTitle) {
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailCommodityDataViewModel qPOrderDetailCommodityDataViewModel2 = QPOrderDetailCommodityDataViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        QPlusCommodityData qPlusCommodityData;
                        QPlusCommodityData qPlusCommodityData2;
                        QPlusCommodityData qPlusCommodityData3;
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView.body.2.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.paddingLeft(16.0f);
                                tVar2.flexDirectionRow();
                                tVar2.marginBottom(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        QPOrderDetailCommodityDataViewModel qPOrderDetailCommodityDataViewModel3 = QPOrderDetailCommodityDataViewModel.this;
                        qPOrderDetailCommodityDataViewModel3.getClass();
                        Pair[] pairArr = new Pair[3];
                        QPlusPromotionDetail qPlusPromotionDetail2 = qPOrderDetailCommodityDataViewModel3.info.promotionDetail;
                        pairArr[0] = new Pair("\u70b9\u51fb", Integer.valueOf((qPlusPromotionDetail2 == null || (qPlusCommodityData3 = qPlusPromotionDetail2.commodityData) == null) ? 0 : qPlusCommodityData3.clickNum));
                        QPlusPromotionDetail qPlusPromotionDetail3 = qPOrderDetailCommodityDataViewModel3.info.promotionDetail;
                        pairArr[1] = new Pair("\u6210\u4ea4\u6b21\u6570", Integer.valueOf((qPlusPromotionDetail3 == null || (qPlusCommodityData2 = qPlusPromotionDetail3.commodityData) == null) ? 0 : qPlusCommodityData2.salesAmount));
                        QPlusPromotionDetail qPlusPromotionDetail4 = qPOrderDetailCommodityDataViewModel3.info.promotionDetail;
                        pairArr[2] = new Pair("\u6210\u4ea4\u91d1\u989d", Integer.valueOf((qPlusPromotionDetail4 == null || (qPlusCommodityData = qPlusPromotionDetail4.commodityData) == null) ? 0 : qPlusCommodityData.salesNum));
                        for (int i3 = 0; i3 < 3; i3++) {
                            Pair pair = pairArr[i3];
                            QPDetailSimpleDataViewKt.QPDetailSimpleDataView(vVar2, String.valueOf(((Number) pair.getSecond()).intValue()), (String) pair.getFirst(), new Function1<QPDetailSimpleDataView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2$3$2$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QPDetailSimpleDataView qPDetailSimpleDataView) {
                                    qPDetailSimpleDataView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityData.QPOrderDetailCommodityDataView$body$2$3$2$1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                            QPOrderDetailCardAttr qPOrderDetailCardAttr2 = qPOrderDetailCardAttr;
                                            qPOrderDetailCardAttr2.mo153width((qPOrderDetailCardAttr2.getPagerData().m() - 32) / 3.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
