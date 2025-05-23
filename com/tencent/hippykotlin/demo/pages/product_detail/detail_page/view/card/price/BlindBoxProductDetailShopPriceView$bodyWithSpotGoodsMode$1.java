package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSpuDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.m;
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
public final class BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ BlindBoxProductDetailShopPriceViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1(BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel) {
        super(1);
        this.$viewModel = blindBoxProductDetailShopPriceViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel = this.$viewModel;
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(m mVar) {
                m mVar2 = mVar;
                mVar2.size(mVar2.getPagerData().m(), 50.0f);
                mVar2.flexDirectionRow().justifyContentSpaceBetween();
                mVar2.mo113backgroundColor(BlindBoxProductDetailShopPriceViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                mVar2.paddingLeft(16.0f);
                return Unit.INSTANCE;
            }
        });
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel2 = this.$viewModel;
        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.flexDirectionRow();
                        tVar2.justifyContentFlexStart();
                        tVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel3 = BlindBoxProductDetailShopPriceViewModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.2.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u00a5");
                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                ceVar2.fontWeightBold();
                                ceVar2.fontFamily("Qvideo Digit");
                                ceVar2.marginTop(20.0f).marginLeft(2.0f);
                                ceVar2.color(BlindBoxProductDetailShopPriceViewModel.this.tokenColor("qecommerce_skin_color_text_red_brand"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel5 = BlindBoxProductDetailShopPriceViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.2.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(19.0f);
                                ceVar2.value(BlindBoxProductDetailShopPriceViewModel.this.priceTxt());
                                ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 26.0f, null, 2, null);
                                ceVar2.color(BlindBoxProductDetailShopPriceViewModel.this.tokenColor("qecommerce_skin_color_text_red_brand"));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel3 = this.$viewModel;
        cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView$bodyWithSpotGoodsMode$1.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextView textView) {
                final BlindBoxProductDetailShopPriceViewModel blindBoxProductDetailShopPriceViewModel4 = BlindBoxProductDetailShopPriceViewModel.this;
                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxProductDetailShopPriceView.bodyWithSpotGoodsMode.1.3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ce ceVar) {
                        String str;
                        ProductDetailProductCardRsp productDetailProductCardRsp;
                        ProductDetailProduct productDetailProduct;
                        ProductDetailSpuDynamic productDetailSpuDynamic;
                        ce ceVar2 = ceVar;
                        ceVar2.marginTop(20.0f);
                        ceVar2.marginRight(16.0f);
                        ProductDetailInfo productDetailInfo = BlindBoxProductDetailShopPriceViewModel.this.info;
                        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailSpuDynamic = productDetailProduct.dynamic) == null || (str = productDetailSpuDynamic.sales) == null) {
                            str = "";
                        }
                        ceVar2.value(str);
                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                        ceVar2.color(4288256409L);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
