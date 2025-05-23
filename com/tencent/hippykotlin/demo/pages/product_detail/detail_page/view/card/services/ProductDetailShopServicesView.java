package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services;

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
public final class ProductDetailShopServicesView extends ProductDetailCardView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailServicesViewModel");
        final ProductDetailServicesViewModel productDetailServicesViewModel = (ProductDetailServicesViewModel) viewModel;
        if (!productDetailServicesViewModel.shouldShow()) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView$body$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView$body$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.mo153width(tVar2.getPagerData().m());
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
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailServicesViewModel productDetailServicesViewModel2 = ProductDetailServicesViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView$body$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), 26.0f);
                        mVar2.mo113backgroundColor(ProductDetailServicesViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                        mVar2.paddingBottom(6.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailServicesViewModel productDetailServicesViewModel3 = ProductDetailServicesViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView$body$2.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailServicesViewModel productDetailServicesViewModel4 = ProductDetailServicesViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m(), 20.0f);
                                tVar2.flexDirectionRow().alignItemsCenter();
                                tVar2.mo113backgroundColor(ProductDetailServicesViewModel.this.tokenColor("qecommerce_skin_color_bg_default"));
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailServicesViewModel productDetailServicesViewModel5 = ProductDetailServicesViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailServicesViewModel productDetailServicesViewModel6 = ProductDetailServicesViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.marginRight(8.0f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(ProductDetailServicesViewModel.this.tokenColor("qecommerce_skin_color_text_secondary"));
                                        ceVar2.value("\u4fdd\u969c");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailServicesViewModel productDetailServicesViewModel6 = ProductDetailServicesViewModel.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailServicesViewModel productDetailServicesViewModel7 = ProductDetailServicesViewModel.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.m140flex(1.0f).marginRight(1.5f);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).lines(1).color(ProductDetailServicesViewModel.this.tokenColor("qecommerce_skin_color_text_primary"));
                                        ceVar2.textAlignLeft();
                                        ceVar2.value(ProductDetailServicesViewModel.this.servicesText());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (ProductDetailServicesViewModel.this.shouldShowArrowIcon()) {
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.4
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.4.1
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
                        }
                        final ProductDetailServicesViewModel productDetailServicesViewModel7 = ProductDetailServicesViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final ProductDetailServicesViewModel productDetailServicesViewModel8 = ProductDetailServicesViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.services.ProductDetailShopServicesView.body.2.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ProductDetailServicesViewModel.this.onTapEvent();
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
