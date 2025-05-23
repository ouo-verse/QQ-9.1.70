package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailPrice;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailSpuDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.f;
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
public final class ProductDetailShopPriceView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceViewModel");
        final ProductDetailShopPriceViewModel productDetailShopPriceViewModel = (ProductDetailShopPriceViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), 50.0f);
                        mVar2.flexDirectionRow().justifyContentSpaceBetween();
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.paddingLeft(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopPriceViewModel productDetailShopPriceViewModel2 = ProductDetailShopPriceViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u00a5");
                                        ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                        ceVar2.fontWeightBold();
                                        ceVar2.fontFamily("Qvideo Digit");
                                        ceVar2.marginTop(20.0f).marginLeft(2.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                        ceVar2.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopPriceViewModel productDetailShopPriceViewModel3 = ProductDetailShopPriceViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailShopPriceViewModel productDetailShopPriceViewModel4 = ProductDetailShopPriceViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        h hVar;
                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                        ProductDetailProduct productDetailProduct;
                                        ProductDetailPrice productDetailPrice;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(19.0f);
                                        ProductDetailInfo productDetailInfo = ProductDetailShopPriceViewModel.this.info;
                                        if (productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null || (str = productDetailPrice.priceTxt) == null) {
                                            str = "";
                                        }
                                        ceVar2.value(str);
                                        ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 26.0f, null, 2, null);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                        ceVar2.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (ProductDetailShopPriceViewModel.this.couponPrice().length() > 0) {
                            final ProductDetailShopPriceViewModel productDetailShopPriceViewModel4 = ProductDetailShopPriceViewModel.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.justifyContentFlexStart();
                                            tVar2.alignItemsFlexEnd();
                                            tVar2.marginTop(11.0f);
                                            tVar2.marginLeft(10.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    b.a.b(afVar2, "qecommerce_skin_quanhoujia_bg_sanjiao", false, 2, null);
                                                    afVar2.size(4.0f, 4.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ProductDetailShopPriceViewModel productDetailShopPriceViewModel5 = ProductDetailShopPriceViewModel.this;
                                    w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar5) {
                                            v vVar6 = vVar5;
                                            vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    h hVar;
                                                    t tVar2 = tVar;
                                                    tVar2.mo141height(20.0f);
                                                    hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_tag_light", false);
                                                    tVar2.mo113backgroundColor(hVar);
                                                    tVar2.m137borderRadius(new f(2.0f, 2.0f, 0.0f, 2.0f));
                                                    tVar2.flexDirectionRow();
                                                    tVar2.allCenter();
                                                    tVar2.paddingLeft(8.0f).paddingRight(8.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailShopPriceViewModel productDetailShopPriceViewModel6 = ProductDetailShopPriceViewModel.this;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final ProductDetailShopPriceViewModel productDetailShopPriceViewModel7 = ProductDetailShopPriceViewModel.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ProductDetailProductCardRsp productDetailProductCardRsp;
                                                            ProductDetailProduct productDetailProduct;
                                                            ProductDetailPrice productDetailPrice;
                                                            ce ceVar2 = ceVar;
                                                            ProductDetailInfo productDetailInfo = ProductDetailShopPriceViewModel.this.info;
                                                            ceVar2.text(String.valueOf((productDetailInfo == null || (productDetailProductCardRsp = productDetailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null) ? null : productDetailPrice.discountPriceDesc));
                                                            ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 12.0f, null, 2, null);
                                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                                            ceVar2.color(hVar);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailShopPriceViewModel productDetailShopPriceViewModel7 = ProductDetailShopPriceViewModel.this;
                                            cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final ProductDetailShopPriceViewModel productDetailShopPriceViewModel8 = ProductDetailShopPriceViewModel.this;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.4.3.3.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            h hVar;
                                                            ce ceVar2 = ceVar;
                                                            if (ceVar2.getPagerData().getIsIOS()) {
                                                                ceVar2.marginTop(5.0f);
                                                            }
                                                            ceVar2.text(ProductDetailShopPriceViewModel.this.couponPrice());
                                                            ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 16.0f, null, 2, null);
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
                            });
                        } else {
                            final ProductDetailShopPriceViewModel productDetailShopPriceViewModel5 = ProductDetailShopPriceViewModel.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.5
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final ProductDetailShopPriceViewModel productDetailShopPriceViewModel6 = ProductDetailShopPriceViewModel.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.2.5.1
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
                                        @Override // kotlin.jvm.functions.Function1
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Unit invoke(ce ceVar) {
                                            boolean z16;
                                            h hVar;
                                            ProductDetailProductCardRsp productDetailProductCardRsp;
                                            ProductDetailProduct productDetailProduct;
                                            ProductDetailPrice productDetailPrice;
                                            ProductDetailProductCardRsp productDetailProductCardRsp2;
                                            ProductDetailProduct productDetailProduct2;
                                            ProductDetailPrice productDetailPrice2;
                                            String str;
                                            ce ceVar2 = ceVar;
                                            ceVar2.marginTop(21.0f).marginLeft(8.0f);
                                            ceVar2.textDecorationLineThrough();
                                            ProductDetailShopPriceViewModel productDetailShopPriceViewModel7 = ProductDetailShopPriceViewModel.this;
                                            ProductDetailInfo productDetailInfo = productDetailShopPriceViewModel7.info;
                                            if (productDetailInfo != null && (productDetailProductCardRsp2 = productDetailInfo.detail) != null && (productDetailProduct2 = productDetailProductCardRsp2.product) != null && (productDetailPrice2 = productDetailProduct2.price) != null && (str = productDetailPrice2.originPriceTxt) != null) {
                                                if (str.length() == 0) {
                                                    z16 = true;
                                                    String str2 = "";
                                                    if (!z16) {
                                                        StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u00a5');
                                                        ProductDetailInfo productDetailInfo2 = productDetailShopPriceViewModel7.info;
                                                        m3.append((productDetailInfo2 == null || (productDetailProductCardRsp = productDetailInfo2.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (productDetailPrice = productDetailProduct.price) == null) ? null : productDetailPrice.originPriceTxt);
                                                        String sb5 = m3.toString();
                                                        if (sb5 != null) {
                                                            str2 = sb5;
                                                        }
                                                    }
                                                    ceVar2.value(str2);
                                                    ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 18.0f, null, 2, null);
                                                    hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_btn_primary_red_disable", false);
                                                    ceVar2.color(hVar);
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                            z16 = false;
                                            String str22 = "";
                                            if (!z16) {
                                            }
                                            ceVar2.value(str22);
                                            ce.fontSize$default(ceVar2.fontFamily("Qvideo Digit").lines(1), 18.0f, null, 2, null);
                                            hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_btn_primary_red_disable", false);
                                            ceVar2.color(hVar);
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
                final ProductDetailShopPriceViewModel productDetailShopPriceViewModel3 = ProductDetailShopPriceViewModel.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ProductDetailShopPriceViewModel productDetailShopPriceViewModel4 = ProductDetailShopPriceViewModel.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.ProductDetailShopPriceView.body.1.3.1
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
                                ProductDetailInfo productDetailInfo = ProductDetailShopPriceViewModel.this.info;
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
        };
    }
}
