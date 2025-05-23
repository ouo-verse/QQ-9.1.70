package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitle;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPDetailSectionTitleKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.utilCards.QPRowInfoView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPayDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailPaymentDetailsCardView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardViewModel");
        final QPOrderDetailPaymentDetailsCardViewModel qPOrderDetailPaymentDetailsCardViewModel = (QPOrderDetailPaymentDetailsCardViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                QPlusPayDetail qPlusPayDetail;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1.1
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
                QPDetailSectionTitleKt.QPDetailSectionTitle(viewContainer2, "\u652f\u4ed8\u8be6\u60c5", new Function1<QPDetailSectionTitle, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(QPDetailSectionTitle qPDetailSectionTitle) {
                        return Unit.INSTANCE;
                    }
                });
                QPOrderDetailPaymentDetailsCardViewModel qPOrderDetailPaymentDetailsCardViewModel2 = QPOrderDetailPaymentDetailsCardViewModel.this;
                qPOrderDetailPaymentDetailsCardViewModel2.getClass();
                QPlusPromotionDetail qPlusPromotionDetail = qPOrderDetailPaymentDetailsCardViewModel2.info.promotionDetail;
                final Pair pair = new Pair("\u5df2\u652f\u4ed8QQ\u91d1\u5e01", Integer.valueOf((qPlusPromotionDetail == null || (qPlusPayDetail = qPlusPromotionDetail.payDetail) == null) ? 0 : qPlusPayDetail.payedAmount));
                viewContainer2.addChild(new QPRowInfoView((String) pair.getFirst(), new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final Pair<String, Integer> pair2 = pair;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1$1$2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1$1$2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(12.0f, 12.0f);
                                        b.a.b(afVar2, "qecommerce_icon_qqjinbi", false, 2, null);
                                        afVar2.marginRight(2.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1$1$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final Pair<String, Integer> pair3 = pair2;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$1$1$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(String.valueOf(pair3.getSecond().intValue()));
                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }), new Function1<QPRowInfoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPRowInfoView qPRowInfoView) {
                        qPRowInfoView.attr(new Function1<QPOrderDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.paymentDetail.QPOrderDetailPaymentDetailsCardView$body$1$3$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QPOrderDetailCardAttr qPOrderDetailCardAttr) {
                                qPOrderDetailCardAttr.marginBottom(16.0f);
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
