package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
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
public final class ProductDetailShopRecommendView$priceView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailShopRecommendViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailShopRecommendView$priceView$1(ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel) {
        super(1);
        this.$viewModel = productDetailShopRecommendViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel = this.$viewModel;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView$priceView$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.justifyContentFlexStart();
                        tVar2.flexDirectionRow();
                        tVar2.marginBottom(8.0f);
                        tVar2.marginLeft(8.0f);
                        tVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                ceVar2.fontFamily("Qvideo Digit");
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                ceVar2.color(hVar);
                                ceVar2.text("\u00a5");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel2 = ProductDetailShopRecommendViewModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel3 = ProductDetailShopRecommendViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null);
                                ceVar2.fontFamily("Qvideo Digit");
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                ceVar2.color(hVar);
                                ceVar2.text(ProductDetailShopRecommendViewModel.this.info.price_str);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel3 = ProductDetailShopRecommendViewModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ProductDetailShopRecommendViewModel productDetailShopRecommendViewModel4 = ProductDetailShopRecommendViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.recommend.ProductDetailShopRecommendView.priceView.1.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h hVar;
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(8.0f);
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_secondary", false);
                                ceVar2.color(hVar);
                                ceVar2.text("\u9500\u91cf " + ProductDetailShopRecommendViewModel.this.info.sales_str);
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
