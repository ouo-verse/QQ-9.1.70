package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailCommissionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SpuDynamic;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailDistributionCommissionView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionViewModel");
        final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel = (ProductDetailDistributionCommissionViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView$body$1.1
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
                final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel2 = ProductDetailDistributionCommissionViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u4f63\u91d1");
                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                        ceVar2.marginTop(20.0f).marginLeft(2.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                        ceVar2.color(hVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.3.1
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
                        final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel3 = ProductDetailDistributionCommissionViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel4 = ProductDetailDistributionCommissionViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        h hVar;
                                        SellerProductCardRsp sellerProductCardRsp;
                                        Product product;
                                        ProductDetailCommissionInfo productDetailCommissionInfo;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(19.0f);
                                        ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailDistributionCommissionViewModel.this.info;
                                        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (productDetailCommissionInfo = product.commission) == null || (str = productDetailCommissionInfo.commission) == null) {
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
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel3 = ProductDetailDistributionCommissionViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.justifyContentFlexStart();
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel4 = ProductDetailDistributionCommissionViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel5 = ProductDetailDistributionCommissionViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        SellerProductCardRsp sellerProductCardRsp;
                                        Product product;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(20.0f);
                                        ceVar2.marginRight(16.0f);
                                        ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailDistributionCommissionViewModel.this.info;
                                        if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (str = product.desc) == null) {
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
                        final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel5 = ProductDetailDistributionCommissionViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailDistributionCommissionViewModel productDetailDistributionCommissionViewModel6 = ProductDetailDistributionCommissionViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.commisssion.ProductDetailDistributionCommissionView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        SellerProductCardRsp sellerProductCardRsp;
                                        Product product;
                                        SpuDynamic spuDynamic;
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(20.0f);
                                        ceVar2.marginRight(16.0f);
                                        ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailDistributionCommissionViewModel.this.info;
                                        ceVar2.value(String.valueOf((productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (spuDynamic = product.dynamic) == null) ? null : spuDynamic.sales));
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
                });
                return Unit.INSTANCE;
            }
        };
    }
}
