package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopShippingView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        if (!((ProductDetailCardAttr) getAttr()).getViewModel().isShowCard()) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(m mVar) {
                            m mVar2 = mVar;
                            mVar2.mo153width(mVar2.getPagerData().m());
                            return Unit.INSTANCE;
                        }
                    });
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.size(tVar2.getPagerData().m(), 0.0f);
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
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShippingViewModel");
        final ProductDetailShippingViewModel productDetailShippingViewModel = (ProductDetailShippingViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailShippingViewModel productDetailShippingViewModel2 = ProductDetailShippingViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(ProductDetailShippingViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShippingViewModel productDetailShippingViewModel3 = ProductDetailShippingViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView$body$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailShippingViewModel productDetailShippingViewModel4 = ProductDetailShippingViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 20.0f);
                                tVar2.mo113backgroundColor(ProductDetailShippingViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                                tVar2.marginBottom(6.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShippingViewModel productDetailShippingViewModel5 = ProductDetailShippingViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ProductDetailShippingViewModel productDetailShippingViewModel6 = ProductDetailShippingViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ProductDetailShippingViewModel.this.handleTapCard();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShippingViewModel productDetailShippingViewModel6 = ProductDetailShippingViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.justifyContentFlexStart();
                                        tVar2.flexDirectionRow().alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(16.0f).marginRight(8.0f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(4288256409L);
                                                ceVar2.value("\u7269\u6d41");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailShippingViewModel productDetailShippingViewModel7 = ProductDetailShippingViewModel.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ProductDetailShippingViewModel productDetailShippingViewModel8 = ProductDetailShippingViewModel.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.m140flex(1.0f).marginRight(1.5f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).lines(1).color(4278190080L);
                                                ceVar2.textAlignLeft();
                                                ceVar2.value(ProductDetailShippingViewModel.this.shippingText());
                                                ceVar2.color(ProductDetailShippingViewModel.this.tokenColor("qecommerce_skin_color_text_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.shipping.ProductDetailShopShippingView.body.2.2.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginRight(16.0f);
                                                afVar2.size(16.0f, 16.0f);
                                                b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
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
