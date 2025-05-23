package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.distribution.model.ProductDetailDistributionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Price;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.Product;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailCommissionInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.SellerProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.coupon.ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
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
public final class ProductDetailTripleCommissionView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionViewModel");
        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel = (ProductDetailTripleCommissionViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.size(mVar2.getPagerData().m(), 81.0f);
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                ImageAttrExtKt.srcUrl(afVar2, "qecommerce_skin_shangxiang_bg_sanfen", null);
                                afVar2.size(afVar2.getPagerData().m() - 32.0f, 69.0f);
                                Attr.absolutePosition$default(afVar2, 0.0f, 16.0f, 12.0f, 0.0f, 9, null);
                                afVar2.q();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel2 = ProductDetailTripleCommissionViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                a.C5863a.a(tVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                tVar2.marginBottom(12.0f);
                                tVar2.mo141height(69.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentFlexStart();
                                tVar2.mo153width(tVar2.getPagerData().m());
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel3 = ProductDetailTripleCommissionViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(69.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel4 = ProductDetailTripleCommissionViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel5 = ProductDetailTripleCommissionViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(12.0f);
                                                ProductDetailTripleCommissionViewModel.this.getClass();
                                                ceVar2.text("\u9884\u8ba1\u4f63\u91d1\u6bd4\u4f8b");
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel5 = ProductDetailTripleCommissionViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel6 = ProductDetailTripleCommissionViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                SellerProductCardRsp sellerProductCardRsp;
                                                Product product;
                                                ProductDetailCommissionInfo productDetailCommissionInfo;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(8.0f);
                                                ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailTripleCommissionViewModel.this.info;
                                                ceVar2.text(String.valueOf((productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (productDetailCommissionInfo = product.commission) == null) ? null : productDetailCommissionInfo.commissionRate));
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_red_brand", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel4 = ProductDetailTripleCommissionViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(69.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel5 = ProductDetailTripleCommissionViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel6 = ProductDetailTripleCommissionViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
                                            
                                                if (r11.deliveryMode == 1) goto L12;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                SellerProductCardRsp sellerProductCardRsp;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(12.0f);
                                                ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailTripleCommissionViewModel.this.info;
                                                boolean z16 = (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (r11 = sellerProductCardRsp.deliveryInfo) == null) ? false : true;
                                                if (z16) {
                                                    str = "\u9884\u552e\u4ef7";
                                                } else {
                                                    str = "\u552e\u4ef7";
                                                }
                                                ceVar2.text(str);
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel6 = ProductDetailTripleCommissionViewModel.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel7 = ProductDetailTripleCommissionViewModel.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel8 = ProductDetailTripleCommissionViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        SellerProductCardRsp sellerProductCardRsp;
                                                        Product product;
                                                        Price price;
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(8.0f);
                                                        ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel9 = ProductDetailTripleCommissionViewModel.this;
                                                        productDetailTripleCommissionViewModel9.getClass();
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append('\u00a5');
                                                        ProductDetailDistributionInfo productDetailDistributionInfo = productDetailTripleCommissionViewModel9.info;
                                                        sb5.append((productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (product = sellerProductCardRsp.product) == null || (price = product.price) == null) ? null : price.priceTxt);
                                                        ceVar2.text(sb5.toString());
                                                        ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_red_brand", false, 2, null);
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
                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel5 = ProductDetailTripleCommissionViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(69.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel6 = ProductDetailTripleCommissionViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel7 = ProductDetailTripleCommissionViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(12.0f);
                                                ProductDetailTripleCommissionViewModel.this.getClass();
                                                ceVar2.text("\u5546\u54c1\u6765\u6e90");
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_secondary", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel7 = ProductDetailTripleCommissionViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailTripleCommissionViewModel productDetailTripleCommissionViewModel8 = ProductDetailTripleCommissionViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.tripleCommission.ProductDetailTripleCommissionView.body.1.3.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                SellerProductCardRsp sellerProductCardRsp;
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(8.0f);
                                                ProductDetailDistributionInfo productDetailDistributionInfo = ProductDetailTripleCommissionViewModel.this.info;
                                                if (productDetailDistributionInfo == null || (sellerProductCardRsp = productDetailDistributionInfo.detail) == null || (str = sellerProductCardRsp.source) == null) {
                                                    str = "";
                                                }
                                                ceVar2.text(str);
                                                ProductDetailShopCouponView$body$2$2$3$2$1$$ExternalSyntheticOutline0.m(ceVar2, 14.0f, null, 2, null, ceVar2, "qecommerce_skin_color_text_primary", false, 2, null);
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
