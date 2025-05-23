package com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.QPOrderDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.Cir_main_page_extensionKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusContentDetail;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusPromotionDetail;
import com.tencent.kuikly.core.base.ViewContainer;
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
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QPOrderDetailCommodityInfoView extends IQPOrderDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.IQPOrderDetailCardView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IQPOrderDetailCardViewModel viewModel = ((QPOrderDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoViewModel");
        final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel = (QPOrderDetailCommodityInfoViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), 92.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentFlexStart();
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel2 = QPOrderDetailCommodityInfoViewModel.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel3 = QPOrderDetailCommodityInfoViewModel.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                QPlusContentDetail qPlusContentDetail;
                                af afVar2 = afVar;
                                afVar2.size(64.0f, 64.0f);
                                afVar2.marginLeft(16.0f);
                                QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailCommodityInfoViewModel.this.info.promotionDetail;
                                if (qPlusPromotionDetail == null || (qPlusContentDetail = qPlusPromotionDetail.contentDetail) == null || (str = qPlusContentDetail.icon) == null) {
                                    str = "";
                                }
                                ImageAttrExtKt.srcUrl(afVar2, str, null);
                                afVar2.borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel3 = QPOrderDetailCommodityInfoViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                tVar2.marginLeft(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel4 = QPOrderDetailCommodityInfoViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel5 = QPOrderDetailCommodityInfoViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        h hVar;
                                        QPlusContentDetail qPlusContentDetail;
                                        String str2;
                                        ce ceVar2 = ceVar;
                                        QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailCommodityInfoViewModel.this.info.promotionDetail;
                                        if (qPlusPromotionDetail == null || (qPlusContentDetail = qPlusPromotionDetail.contentDetail) == null || (str2 = qPlusContentDetail.title) == null || (str = Cir_main_page_extensionKt.filterCirEmoji(str2)) == null) {
                                            str = "";
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        ceVar2.color(hVar);
                                        ceVar2.marginBottom(4.0f);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.lines(1);
                                        ceVar2.m144maxWidth((((ceVar2.getPagerData().m() - 32.0f) - 64.0f) - 16.0f) - 16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel5 = QPOrderDetailCommodityInfoViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel6 = QPOrderDetailCommodityInfoViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        h hVar;
                                        QPlusContentDetail qPlusContentDetail;
                                        ce ceVar2 = ceVar;
                                        QPlusPromotionDetail qPlusPromotionDetail = QPOrderDetailCommodityInfoViewModel.this.info.promotionDetail;
                                        if (qPlusPromotionDetail == null || (qPlusContentDetail = qPlusPromotionDetail.contentDetail) == null || (str = qPlusContentDetail.date) == null) {
                                            str = "";
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                        ceVar2.color(hVar);
                                        ceVar2.marginBottom(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel6 = QPOrderDetailCommodityInfoViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel7 = QPOrderDetailCommodityInfoViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.order_detail.cards.commodityInfo.QPOrderDetailCommodityInfoView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        String str2;
                                        h hVar;
                                        QPlusContentDetail qPlusContentDetail;
                                        QPlusContentDetail qPlusContentDetail2;
                                        ce ceVar2 = ceVar;
                                        QPOrderDetailCommodityInfoViewModel qPOrderDetailCommodityInfoViewModel8 = QPOrderDetailCommodityInfoViewModel.this;
                                        StringBuilder sb5 = new StringBuilder();
                                        QPlusPromotionDetail qPlusPromotionDetail = qPOrderDetailCommodityInfoViewModel8.info.promotionDetail;
                                        if (qPlusPromotionDetail == null || (qPlusContentDetail2 = qPlusPromotionDetail.contentDetail) == null || (str = qPlusContentDetail2.creatorNick) == null) {
                                            str = "";
                                        }
                                        sb5.append(str);
                                        QPlusPromotionDetail qPlusPromotionDetail2 = qPOrderDetailCommodityInfoViewModel8.info.promotionDetail;
                                        if ((qPlusPromotionDetail2 == null || (qPlusContentDetail = qPlusPromotionDetail2.contentDetail) == null || qPlusContentDetail.contentType != 2) ? false : true) {
                                            str2 = "\u7684\u76f4\u64ad";
                                        } else {
                                            str2 = "\u7684\u89c6\u9891";
                                        }
                                        sb5.append(str2);
                                        ceVar2.text(sb5.toString());
                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        ceVar2.color(hVar);
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
