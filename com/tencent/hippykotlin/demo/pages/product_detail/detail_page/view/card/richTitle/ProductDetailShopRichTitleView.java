package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailLabelInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProduct;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.ProductDetailShopRepository;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.component.ProductDetailLabelView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopRichTitleView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailRichTitleViewModel");
        final ProductDetailRichTitleViewModel productDetailRichTitleViewModel = (ProductDetailRichTitleViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailRichTitleViewModel productDetailRichTitleViewModel2 = ProductDetailRichTitleViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(ProductDetailRichTitleViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailRichTitleViewModel productDetailRichTitleViewModel3 = ProductDetailRichTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m() - 32.0f);
                                tVar2.margin(8.0f, 16.0f, 12.0f, 16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailRichTitleViewModel productDetailRichTitleViewModel4 = ProductDetailRichTitleViewModel.this;
                        vVar2.addChild(new ProductDetailLabelView(), new Function1<ProductDetailLabelView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ProductDetailLabelView productDetailLabelView) {
                                final ProductDetailRichTitleViewModel productDetailRichTitleViewModel5 = ProductDetailRichTitleViewModel.this;
                                productDetailLabelView.attr(new Function1<ProductDetailLabelAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ProductDetailLabelAttr productDetailLabelAttr) {
                                        ArrayList<ProductDetailLabelInfo> arrayList;
                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                        ProductDetailProduct productDetailProduct;
                                        ProductDetailLabelAttr productDetailLabelAttr2 = productDetailLabelAttr;
                                        ProductDetailShopRichTitleViewModel productDetailShopRichTitleViewModel = (ProductDetailShopRichTitleViewModel) ProductDetailRichTitleViewModel.this;
                                        productDetailShopRichTitleViewModel.getClass();
                                        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
                                        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(productDetailShopRichTitleViewModel.spuId);
                                        if (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (arrayList = productDetailProduct.labels) == null) {
                                            arrayList = new ArrayList<>();
                                        }
                                        productDetailLabelAttr2.labels = arrayList;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailRichTitleViewModel productDetailRichTitleViewModel5 = ProductDetailRichTitleViewModel.this;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                final ProductDetailRichTitleViewModel productDetailRichTitleViewModel6 = ProductDetailRichTitleViewModel.this;
                                final aa aaVar = null;
                                richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.richTitle.ProductDetailShopRichTitleView.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        String str;
                                        ProductDetailLabelView b16;
                                        ProductDetailProductCardRsp productDetailProductCardRsp;
                                        ProductDetailProduct productDetailProduct;
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        richTextAttr2.mo153width(richTextAttr2.getPagerData().m() - 32.0f);
                                        ce.fontSize$default(richTextAttr2, 15.0f, null, 2, null).fontWeight500().lines(2);
                                        ProductDetailShopRichTitleViewModel productDetailShopRichTitleViewModel = (ProductDetailShopRichTitleViewModel) ProductDetailRichTitleViewModel.this;
                                        productDetailShopRichTitleViewModel.getClass();
                                        ProductDetailShopRepository productDetailShopRepository = ProductDetailShopRepository.INSTANCE;
                                        ProductDetailInfo detailInfo = ProductDetailShopRepository.cache.getDetailInfo(productDetailShopRichTitleViewModel.spuId);
                                        if (detailInfo == null || (productDetailProductCardRsp = detailInfo.detail) == null || (productDetailProduct = productDetailProductCardRsp.product) == null || (str = productDetailProduct.title) == null) {
                                            str = "";
                                        }
                                        richTextAttr2.value(str);
                                        ce.fontSize$default(richTextAttr2, 16.0f, null, 2, null);
                                        richTextAttr2.color(ProductDetailRichTitleViewModel.this.tokenColor("qecommerce_skin_color_text_primary"));
                                        aa<ProductDetailLabelView> aaVar2 = aaVar;
                                        richTextAttr2.firstLineHeadIndent((aaVar2 == null || (b16 = aaVar2.b()) == null) ? 0.0f : b16.getHeadLabelIndent());
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
