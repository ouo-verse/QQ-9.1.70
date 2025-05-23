package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailNavBarView extends ProductDetailPendantView implements IProductDetailPageSubView {
    public final IProductDetailViewModel detailViewModel;

    public ProductDetailNavBarView(IProductDetailViewModel iProductDetailViewModel) {
        this.detailViewModel = iProductDetailViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel");
        final ProductDetailNavBarViewModel productDetailNavBarViewModel = (ProductDetailNavBarViewModel) viewModel;
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewAttr");
        final ProductDetailNavBarViewAttr productDetailNavBarViewAttr = (ProductDetailNavBarViewAttr) attr;
        if (productDetailNavBarViewModel.isHalf()) {
            productDetailNavBarViewAttr.opacity$delegate.setValue(productDetailNavBarViewAttr, ProductDetailNavBarViewAttr.$$delegatedProperties[0], Float.valueOf(0.0f));
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailNavBarViewModel productDetailNavBarViewModel2 = ProductDetailNavBarViewModel.this;
                final ProductDetailNavBarViewAttr productDetailNavBarViewAttr2 = productDetailNavBarViewAttr;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                        mVar2.mo141height(mVar2.getPagerData().getNavigationBarHeight());
                        mVar2.mo113backgroundColor(ProductDetailNavBarViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        ProductDetailNavBarViewAttr productDetailNavBarViewAttr3 = productDetailNavBarViewAttr2;
                        mVar2.m147opacity(((Number) productDetailNavBarViewAttr3.opacity$delegate.getValue(productDetailNavBarViewAttr3, ProductDetailNavBarViewAttr.$$delegatedProperties[0])).floatValue());
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailNavBarViewModel productDetailNavBarViewModel3 = ProductDetailNavBarViewModel.this;
                final ProductDetailNavBarView productDetailNavBarView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginTop(tVar2.getPager().getPageData().getStatusBarHeight());
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailNavBarViewModel productDetailNavBarViewModel4 = ProductDetailNavBarViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(55.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailNavBarViewModel productDetailNavBarViewModel5 = ProductDetailNavBarViewModel.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final ProductDetailNavBarViewModel productDetailNavBarViewModel6 = ProductDetailNavBarViewModel.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ProductDetailNavBarViewModel.this.backBtnPressed();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailNavBarViewModel productDetailNavBarViewModel6 = ProductDetailNavBarViewModel.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final ProductDetailNavBarViewModel productDetailNavBarViewModel7 = ProductDetailNavBarViewModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(25.0f, 25.0f);
                                                afVar2.marginLeft(-8.0f);
                                                b.a.b(afVar2, ProductDetailNavBarViewModel.this.backIconToken(), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailNavBarViewModel productDetailNavBarViewModel5 = ProductDetailNavBarViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(tVar2.getPagerData().m() - 110.0f);
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailNavBarViewModel productDetailNavBarViewModel6 = ProductDetailNavBarViewModel.this;
                                RichTextViewKt.b(vVar4, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextView richTextView) {
                                        final ProductDetailNavBarViewModel productDetailNavBarViewModel7 = ProductDetailNavBarViewModel.this;
                                        richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                ce.fontSize$default(richTextAttr2, 17.0f, null, 2, null).fontWeightMedium();
                                                richTextAttr2.color(ProductDetailNavBarViewModel.this.tokenColor("qecommerce_skin_color_text_primary"));
                                                richTextAttr2.text(ProductDetailNavBarViewModel.this.getTitle());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailNavBarView productDetailNavBarView2 = productDetailNavBarView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final ProductDetailNavBarView productDetailNavBarView3 = ProductDetailNavBarView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:4:0x001b, code lost:
                                    
                                        if (r0.canShare() == true) goto L8;
                                     */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(43.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentFlexEnd();
                                        IProductDetailViewModel iProductDetailViewModel = ProductDetailNavBarView.this.detailViewModel;
                                        boolean z16 = iProductDetailViewModel != null;
                                        tVar2.m152visibility(z16);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, "qecommerce_skin_icon_nav_share", false, 2, null);
                                                afVar2.marginRight(9.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailNavBarView productDetailNavBarView4 = ProductDetailNavBarView.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final ProductDetailNavBarView productDetailNavBarView5 = ProductDetailNavBarView.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarView.body.1.2.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                IProductDetailViewModel iProductDetailViewModel = ProductDetailNavBarView.this.detailViewModel;
                                                if (iProductDetailViewModel != null) {
                                                    iProductDetailViewModel.doShare();
                                                }
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

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ProductDetailPendantAttr createAttr() {
        return new ProductDetailNavBarViewAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel");
        return ((ProductDetailNavBarViewModel) viewModel).isHalf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewAttr");
        ProductDetailNavBarViewAttr productDetailNavBarViewAttr = (ProductDetailNavBarViewAttr) attr;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.navbar.ProductDetailNavBarViewModel");
        IProductDetailViewModel detailViewModel = ((ProductDetailNavBarViewModel) viewModel).getDetailViewModel();
        if (detailViewModel != null) {
            productDetailNavBarViewAttr.opacity$delegate.setValue(productDetailNavBarViewAttr, ProductDetailNavBarViewAttr.$$delegatedProperties[0], Float.valueOf(scrollParams.getOffsetY() / (detailViewModel.halfMarginTopHeight() - 44.0f)));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailNavBarViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }
}
