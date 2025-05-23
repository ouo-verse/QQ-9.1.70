package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitle;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitleKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPRowInfoView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailDetailInfoCardView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardViewModel");
        final QPOrderDetailDetailInfoCardViewModel qPOrderDetailDetailInfoCardViewModel = (QPOrderDetailDetailInfoCardViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1.1
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
                QPDetailSectionTitleKt.QPDetailSectionTitle(viewContainer2, "\u8be6\u7ec6\u4fe1\u606f", new Function1<QPDetailSectionTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailSectionTitle qPDetailSectionTitle) {
                        return Unit.INSTANCE;
                    }
                });
                Pair<String, String>[] infoList = QPOrderDetailDetailInfoCardViewModel.this.infoList();
                final QPOrderDetailDetailInfoCardViewModel qPOrderDetailDetailInfoCardViewModel2 = QPOrderDetailDetailInfoCardViewModel.this;
                int i3 = 0;
                final int i16 = 0;
                while (i3 < 7) {
                    final Pair<String, String> pair = infoList[i3];
                    viewContainer2.addChild(new QPRowInfoView(pair.getFirst(), new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            int i17 = i16;
                            QPOrderDetailDetailInfoCardViewModel qPOrderDetailDetailInfoCardViewModel3 = qPOrderDetailDetailInfoCardViewModel2;
                            final Pair<String, String> pair2 = pair;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.flexDirectionRow();
                                    tVar2.justifyContentFlexStart();
                                    tVar2.alignItemsCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final Pair<String, String> pair3 = pair2;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text(pair3.getSecond());
                                            ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            qPOrderDetailDetailInfoCardViewModel3.infoList();
                            if (i17 == 6) {
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        TextView textView2 = textView;
                                        textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(8.0f);
                                                ceVar2.text("\u590d\u5236");
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_link", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Pair<String, String> pair3 = pair2;
                                        textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$1$1$3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextEvent textEvent) {
                                                final Pair<String, String> pair4 = pair3;
                                                textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView.body.1.3.1.1.3.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Utils utils = Utils.INSTANCE;
                                                        utils.currentBridgeModule().copyToPasteboard(pair4.getSecond());
                                                        utils.currentBridgeModule().toast("\u5df2\u590d\u5236\u8ba2\u5355\u7f16\u53f7");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    }), new Function1<QPRowInfoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(QPRowInfoView qPRowInfoView) {
                            qPRowInfoView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.detailInfo.QPOrderDetailDetailInfoCardView$body$1$3$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                    qPOrderDetailCardAttr.marginBottom(16.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    i3++;
                    i16++;
                }
                return Unit.INSTANCE;
            }
        };
    }
}
