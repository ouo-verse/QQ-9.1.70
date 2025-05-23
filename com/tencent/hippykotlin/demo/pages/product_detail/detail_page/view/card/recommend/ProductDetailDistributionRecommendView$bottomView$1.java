package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailCommissionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionRecommendView$bottomView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailDistributionRecommendViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailDistributionRecommendView$bottomView$1(ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel) {
        super(1);
        this.$viewModel = productDetailDistributionRecommendViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel = this.$viewModel;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView$bottomView$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.justifyContentFlexStart();
                        tVar2.alignItemsCenter();
                        tVar2.marginLeft(8.0f);
                        tVar2.marginTop(8.0f);
                        tVar2.marginBottom(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u4f63\u91d1");
                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 11.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_red_brand", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u00a5");
                                ce.fontSize$default(ceVar2, 11.0f, null, 2, null);
                                ceVar2.marginTop(3.5f);
                                ceVar2.marginLeft(4.0f);
                                ceVar2.marginRight(2.0f);
                                ceVar2.fontFamily("Qvideo Digit");
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                ceVar2.color(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel2 = ProductDetailDistributionRecommendViewModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ProductDetailDistributionRecommendViewModel productDetailDistributionRecommendViewModel3 = ProductDetailDistributionRecommendViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailDistributionRecommendView.bottomView.1.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                String str;
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(1.5f);
                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                ProductDetailCommissionInfo productDetailCommissionInfo = ProductDetailDistributionRecommendViewModel.this.info.commission;
                                if (productDetailCommissionInfo == null || (str = productDetailCommissionInfo.commission) == null) {
                                    str = "";
                                }
                                ceVar2.text(str);
                                ceVar2.fontFamily("Qvideo Digit");
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
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
}
