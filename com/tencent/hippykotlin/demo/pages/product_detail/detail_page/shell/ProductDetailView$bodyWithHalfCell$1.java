package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailView$bodyWithHalfCell$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailView $ctx;
    public final /* synthetic */ IProductDetailViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailView$bodyWithHalfCell$1(IProductDetailViewModel iProductDetailViewModel, ProductDetailView productDetailView) {
        super(1);
        this.$viewModel = iProductDetailViewModel;
        this.$ctx = productDetailView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final IProductDetailViewModel iProductDetailViewModel = this.$viewModel;
        final ProductDetailView productDetailView = this.$ctx;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithHalfCell$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final IProductDetailViewModel iProductDetailViewModel2 = IProductDetailViewModel.this;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithHalfCell.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo153width(tVar2.getPagerData().m());
                        tVar2.mo141height(IProductDetailViewModel.this.halfMarginTopHeight() - 44.0f);
                        tVar2.mo113backgroundColor(h.INSTANCE.k());
                        return Unit.INSTANCE;
                    }
                });
                final IProductDetailViewModel iProductDetailViewModel3 = IProductDetailViewModel.this;
                final ProductDetailView productDetailView2 = productDetailView;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithHalfCell.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final IProductDetailViewModel iProductDetailViewModel4 = IProductDetailViewModel.this;
                        final ProductDetailView productDetailView3 = productDetailView2;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithHalfCell.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                IProductDetailPageDelegate iProductDetailPageDelegate;
                                IProductDetailViewModel iProductDetailViewModel5 = IProductDetailViewModel.this;
                                if (iProductDetailViewModel5 instanceof ProductDetailShopViewModel) {
                                    if (!((ProductDetailShopViewModel) iProductDetailViewModel5).popRetainWindow() && (iProductDetailPageDelegate = ProductDetailView.access$getAttr(productDetailView3).pageDelegate) != null) {
                                        iProductDetailPageDelegate.closePage(null);
                                    }
                                } else {
                                    IProductDetailPageDelegate iProductDetailPageDelegate2 = ProductDetailView.access$getAttr(productDetailView3).pageDelegate;
                                    if (iProductDetailPageDelegate2 != null) {
                                        iProductDetailPageDelegate2.closePage(null);
                                    }
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
}
