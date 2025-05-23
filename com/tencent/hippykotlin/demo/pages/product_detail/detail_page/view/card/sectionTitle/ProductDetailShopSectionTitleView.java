package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailEventDataCardFrame;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
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
public final class ProductDetailShopSectionTitleView extends ProductDetailCardView {
    public final String titleText;

    public ProductDetailShopSectionTitleView(String str) {
        this.titleText = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$topDivLine(ProductDetailShopSectionTitleView productDetailShopSectionTitleView) {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) productDetailShopSectionTitleView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel");
        final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel = (ProductDetailSectionTitleViewModel) viewModel;
        w.a(productDetailShopSectionTitleView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$topDivLine$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel2 = ProductDetailSectionTitleViewModel.this;
                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$topDivLine$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(8.0f);
                        tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        tVar2.mo153width(tVar2.getPagerData().m());
                        tVar2.mo113backgroundColor(ProductDetailSectionTitleViewModel.this.tokenColor("qecommerce_skin_color_bg_backplate"));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel");
        final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel = (ProductDetailSectionTitleViewModel) viewModel;
        productDetailSectionTitleViewModel.getClass();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        return Unit.INSTANCE;
                    }
                });
                if (ProductDetailSectionTitleViewModel.this.isGradientBackground()) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$body$2.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView.body.2.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.size(tVar2.getPagerData().m(), 54.0f);
                                    tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h("qecommerce_skin_color_bg_default"), 0.0f), new j(new h("qecommerce_skin_color_bg_backplate"), 1.0f));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel2 = ProductDetailSectionTitleViewModel.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$body$2.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel3 = ProductDetailSectionTitleViewModel.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView.body.2.3.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.size(tVar2.getPagerData().m(), 54.0f);
                                    tVar2.mo113backgroundColor(ProductDetailSectionTitleViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final ProductDetailShopSectionTitleView productDetailShopSectionTitleView = this;
                final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel3 = ProductDetailSectionTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView$body$2.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView.body.2.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.paddingTop(16.0f);
                                tVar2.paddingLeft(16.0f);
                                tVar2.paddingBottom(12.0f);
                                tVar2.mo153width(tVar2.getPagerData().m());
                                return Unit.INSTANCE;
                            }
                        });
                        ProductDetailShopSectionTitleView.access$topDivLine(ProductDetailShopSectionTitleView.this);
                        final ProductDetailShopSectionTitleView productDetailShopSectionTitleView2 = ProductDetailShopSectionTitleView.this;
                        final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel4 = productDetailSectionTitleViewModel3;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView.body.2.4.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailShopSectionTitleView productDetailShopSectionTitleView3 = ProductDetailShopSectionTitleView.this;
                                final ProductDetailSectionTitleViewModel productDetailSectionTitleViewModel5 = productDetailSectionTitleViewModel4;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailShopSectionTitleView.body.2.4.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(ProductDetailShopSectionTitleView.this.titleText);
                                        ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightBold();
                                        ceVar2.marginTop(8.0f);
                                        ceVar2.color(productDetailSectionTitleViewModel5.tokenColor("qecommerce_skin_color_text_primary"));
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    public final void layoutFrameDidChanged(d dVar) {
        super.layoutFrameDidChanged(dVar);
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.sectionTitle.ProductDetailSectionTitleViewModel");
        String cardFrameChangeEventName = ((ProductDetailSectionTitleViewModel) viewModel).cardFrameChangeEventName();
        if (cardFrameChangeEventName == null || dVar.getY() <= 0.0f) {
            return;
        }
        ((ProductDetailEvent) getEvent()).onFireProductDetailEvent(cardFrameChangeEventName, new ProductDetailEventDataCardFrame(new d(0.0f, dVar.getY(), 0.0f, 0.0f, 12, null)));
    }
}
