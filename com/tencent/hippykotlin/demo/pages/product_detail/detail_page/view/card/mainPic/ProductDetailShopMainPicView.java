package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic;

import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailCardViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.SliderPageAttr;
import com.tencent.kuikly.core.views.compose.SliderPageView;
import com.tencent.kuikly.core.views.compose.d;
import com.tencent.kuikly.core.views.compose.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopMainPicView extends ProductDetailCardView implements IProductDetailPageSubView {
    /* JADX WARN: Multi-variable type inference failed */
    public static final ProductDetailShopMainPicViewAttr access$viewAttr(ProductDetailShopMainPicView productDetailShopMainPicView) {
        A attr = productDetailShopMainPicView.getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicViewAttr");
        return (ProductDetailShopMainPicViewAttr) attr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailCardViewModel viewModel = ((ProductDetailCardAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailMainPicViewModel");
        final ProductDetailMainPicViewModel productDetailMainPicViewModel = (ProductDetailMainPicViewModel) viewModel;
        final List<String> picsUrl = productDetailMainPicViewModel.picsUrl();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailMainPicViewModel productDetailMainPicViewModel2 = productDetailMainPicViewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(mVar2.getPagerData().m(), mVar2.getPagerData().m());
                        mVar2.keepAlive(true);
                        mVar2.mo113backgroundColor(ProductDetailMainPicViewModel.this.tokenColor("qecommerce_skin_color_bg_backplate"));
                        mVar2.borderRadius(6.0f, 6.0f, 0.0f, 0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final List<String> list = picsUrl;
                final ProductDetailShopMainPicView productDetailShopMainPicView = this;
                final ProductDetailMainPicViewModel productDetailMainPicViewModel3 = productDetailMainPicViewModel;
                e.a(viewContainer2, new Function1<SliderPageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SliderPageView sliderPageView) {
                        SliderPageView sliderPageView2 = sliderPageView;
                        final List<String> list2 = list;
                        final ProductDetailShopMainPicView productDetailShopMainPicView2 = productDetailShopMainPicView;
                        final ProductDetailMainPicViewModel productDetailMainPicViewModel4 = productDetailMainPicViewModel3;
                        sliderPageView2.attr(new Function1<SliderPageAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(SliderPageAttr sliderPageAttr) {
                                SliderPageAttr sliderPageAttr2 = sliderPageAttr;
                                sliderPageAttr2.q(0);
                                sliderPageAttr2.r(true);
                                sliderPageAttr2.t(sliderPageAttr2.getPagerData().m());
                                sliderPageAttr2.u(sliderPageAttr2.getPagerData().m());
                                List<String> list3 = list2;
                                if (list3 != null) {
                                    final ProductDetailShopMainPicView productDetailShopMainPicView3 = productDetailShopMainPicView2;
                                    final ProductDetailMainPicViewModel productDetailMainPicViewModel5 = productDetailMainPicViewModel4;
                                    sliderPageAttr2.o(list3, new Function2<PageListView<?, ?>, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1$2$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(PageListView<?, ?> pageListView, String str) {
                                            final String str2 = str;
                                            final ProductDetailShopMainPicView productDetailShopMainPicView4 = ProductDetailShopMainPicView.this;
                                            final ProductDetailMainPicViewModel productDetailMainPicViewModel6 = productDetailMainPicViewModel5;
                                            w.a(pageListView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1$2$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    final String str3 = str2;
                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ImageView imageView) {
                                                            final String str4 = str3;
                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(af afVar) {
                                                                    af afVar2 = afVar;
                                                                    afVar2.size(afVar2.getPagerData().m(), afVar2.getPagerData().m());
                                                                    b.a.b(afVar2, str4, false, 2, null);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final ProductDetailShopMainPicView productDetailShopMainPicView5 = productDetailShopMainPicView4;
                                                    final ProductDetailMainPicViewModel productDetailMainPicViewModel7 = productDetailMainPicViewModel6;
                                                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Object invoke() {
                                                            return Boolean.valueOf(ProductDetailShopMainPicView.access$viewAttr(ProductDetailShopMainPicView.this).getCurrentIndex() == 1 && !Intrinsics.areEqual(productDetailMainPicViewModel7.coverPendent(), ""));
                                                        }
                                                    };
                                                    final ProductDetailMainPicViewModel productDetailMainPicViewModel8 = productDetailMainPicViewModel6;
                                                    ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ConditionView conditionView) {
                                                            final ProductDetailMainPicViewModel productDetailMainPicViewModel9 = ProductDetailMainPicViewModel.this;
                                                            ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    final ProductDetailMainPicViewModel productDetailMainPicViewModel10 = ProductDetailMainPicViewModel.this;
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.3.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                                            afVar2.size(afVar2.getPagerData().m(), afVar2.getPagerData().m());
                                                                            ImageAttrExtKt.srcUrl(afVar2, ProductDetailMainPicViewModel.this.coverPendent(), null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.alignItemsCenter();
                                                            tVar2.justifyContentCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final ProductDetailMainPicViewModel productDetailMainPicViewModel9 = productDetailMainPicViewModel6;
                                                    final ProductDetailShopMainPicView productDetailShopMainPicView6 = productDetailShopMainPicView4;
                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final ProductDetailMainPicViewModel productDetailMainPicViewModel10 = ProductDetailMainPicViewModel.this;
                                                            final ProductDetailShopMainPicView productDetailShopMainPicView7 = productDetailShopMainPicView6;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.1.1.1.1.5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    ProductDetailMainPicViewModel.this.showPhotoBrowser(ProductDetailShopMainPicView.access$viewAttr(productDetailShopMainPicView7).getCurrentIndex() - 1);
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
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopMainPicView productDetailShopMainPicView3 = productDetailShopMainPicView;
                        sliderPageView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                final ProductDetailShopMainPicView productDetailShopMainPicView4 = ProductDetailShopMainPicView.this;
                                dVar.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        ProductDetailShopMainPicViewAttr access$viewAttr = ProductDetailShopMainPicView.access$viewAttr(ProductDetailShopMainPicView.this);
                                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                        access$viewAttr.currentIndex$delegate.setValue(access$viewAttr, ProductDetailShopMainPicViewAttr.$$delegatedProperties[0], Integer.valueOf(((com.tencent.kuikly.core.nvi.serialization.json.e) obj).j("index") + 1));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                if (picsUrl.size() > 1) {
                    final ProductDetailShopMainPicView productDetailShopMainPicView2 = this;
                    final List<String> list2 = picsUrl;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView$body$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.positionAbsolute().m149right(16.0f).m138bottom(16.0f);
                                    tVar2.size(48.0f, 18.0f);
                                    tVar2.borderRadius(9.0f);
                                    tVar2.backgroundColor(2147483648L);
                                    tVar2.flexDirectionRow();
                                    tVar2.allCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            final ProductDetailShopMainPicView productDetailShopMainPicView3 = ProductDetailShopMainPicView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.3.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final ProductDetailShopMainPicView productDetailShopMainPicView4 = ProductDetailShopMainPicView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.3.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeightNormal().color(4294967295L);
                                            ceVar2.value(String.valueOf(ProductDetailShopMainPicView.access$viewAttr(ProductDetailShopMainPicView.this).getCurrentIndex()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final List<String> list3 = list2;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.3.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final List<String> list4 = list3;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.mainPic.ProductDetailShopMainPicView.body.1.3.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null).fontWeightNormal().color(1728053247L);
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append('/');
                                            sb5.append(list4.size());
                                            ceVar2.value(sb5.toString());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ProductDetailCardAttr createAttr() {
        return new ProductDetailShopMainPicViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        return false;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailCardView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailShopMainPicViewAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
    }
}
