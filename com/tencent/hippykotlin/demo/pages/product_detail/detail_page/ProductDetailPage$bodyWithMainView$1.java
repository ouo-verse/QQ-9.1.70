package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import com.tencent.hippykotlin.demo.pages.base.ECErrorView;
import com.tencent.hippykotlin.demo.pages.base.ECErrorViewKt;
import com.tencent.hippykotlin.demo.pages.base.ErrorViewAttr;
import com.tencent.hippykotlin.demo.pages.base.ErrorViewEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.define.ProductDetailPageState;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailViewAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailViewEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.p;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ScrollParams;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailPage$bodyWithMainView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ ProductDetailPage $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductDetailPage$bodyWithMainView$1(ProductDetailPage productDetailPage) {
        super(1);
        this.$ctx = productDetailPage;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final ProductDetailPage productDetailPage = this.$ctx;
        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                return Boolean.valueOf((iProductDetailPageModel != null ? iProductDetailPageModel.detailState() : null) == ProductDetailPageState.COMPLETED);
            }
        };
        final ProductDetailPage productDetailPage2 = this.$ctx;
        ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                Function1<ViewContainer<?, ?>, Unit> function1;
                Function1<ViewContainer<?, ?>, Unit> function12;
                ConditionView conditionView2 = conditionView;
                final ProductDetailPage productDetailPage3 = ProductDetailPage.this;
                KProperty<Object>[] kPropertyArr = ProductDetailPage.$$delegatedProperties;
                productDetailPage3.getClass();
                if (productDetailPage3.pageModel == null) {
                    function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithDetailList$1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function1 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithDetailList$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final ProductDetailPage productDetailPage4 = ProductDetailPage.this;
                            viewContainer3.addChild(new ProductDetailView(), new Function1<ProductDetailView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithDetailList$2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ProductDetailView productDetailView) {
                                    ProductDetailView productDetailView2 = productDetailView;
                                    final ProductDetailPage productDetailPage5 = ProductDetailPage.this;
                                    productDetailView2.ref(productDetailView2, new Function1<aa<ProductDetailView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(aa<ProductDetailView> aaVar) {
                                            ProductDetailPage.this.detailRef = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ProductDetailPage productDetailPage6 = ProductDetailPage.this;
                                    productDetailView2.attr(new Function1<ProductDetailViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ProductDetailViewAttr productDetailViewAttr) {
                                            float navigationBarHeight;
                                            IProductDetailViewModel detailViewModel;
                                            ProductDetailViewAttr productDetailViewAttr2 = productDetailViewAttr;
                                            IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                                            if (iProductDetailPageModel != null) {
                                                navigationBarHeight = iProductDetailPageModel.detailViewTopOffset();
                                            } else {
                                                navigationBarHeight = productDetailViewAttr2.getPagerData().getNavigationBarHeight();
                                            }
                                            productDetailViewAttr2.marginTop(navigationBarHeight);
                                            productDetailViewAttr2.mo153width(ProductDetailPage.this.getPageData().m());
                                            IProductDetailPageModel iProductDetailPageModel2 = ProductDetailPage.this.pageModel;
                                            productDetailViewAttr2.mo141height((iProductDetailPageModel2 == null || (detailViewModel = iProductDetailPageModel2.detailViewModel()) == null) ? 0.0f : detailViewModel.getHeight());
                                            boolean schemeIsHalf = SchemeParamExtensionKt.schemeIsHalf(ProductDetailPage.this.getPageData().n());
                                            productDetailViewAttr2.isHalf = schemeIsHalf;
                                            productDetailViewAttr2.setClearBackgroundColor(schemeIsHalf);
                                            IProductDetailPageModel iProductDetailPageModel3 = ProductDetailPage.this.pageModel;
                                            Intrinsics.checkNotNull(iProductDetailPageModel3);
                                            productDetailViewAttr2.viewModel = iProductDetailPageModel3.detailViewModel();
                                            productDetailViewAttr2.pageDelegate = ProductDetailPage.this.pageDelegate;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ProductDetailPage productDetailPage7 = ProductDetailPage.this;
                                    productDetailView2.event(new Function1<ProductDetailViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ProductDetailViewEvent productDetailViewEvent) {
                                            ProductDetailViewEvent productDetailViewEvent2 = productDetailViewEvent;
                                            final ProductDetailPage productDetailPage8 = ProductDetailPage.this;
                                            final Function1<ScrollParams, Unit> function13 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ScrollParams scrollParams) {
                                                    ScrollParams scrollParams2 = scrollParams;
                                                    Iterator<aa<?>> it = ProductDetailPage.this.scrollEnableView.iterator();
                                                    while (it.hasNext()) {
                                                        Object b16 = it.next().b();
                                                        IProductDetailPageSubView iProductDetailPageSubView = b16 instanceof IProductDetailPageSubView ? (IProductDetailPageSubView) b16 : null;
                                                        if (iProductDetailPageSubView != null) {
                                                            iProductDetailPageSubView.mainViewScrollEvent(scrollParams2);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            productDetailViewEvent2.getClass();
                                            productDetailViewEvent2.register("scroll", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailViewEvent$scroll$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    Function1<ScrollParams, Unit> function14 = function13;
                                                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ScrollParams");
                                                    function14.invoke((ScrollParams) obj);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailPage productDetailPage9 = ProductDetailPage.this;
                                            productDetailViewEvent2.register("scrollEnd", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    Iterator<aa<?>> it = ProductDetailPage.this.scrollEnableView.iterator();
                                                    while (it.hasNext()) {
                                                        Object b16 = it.next().b();
                                                        IProductDetailPageSubView iProductDetailPageSubView = b16 instanceof IProductDetailPageSubView ? (IProductDetailPageSubView) b16 : null;
                                                        if (iProductDetailPageSubView != null) {
                                                            iProductDetailPageSubView.mainViewScrollEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailPage productDetailPage10 = ProductDetailPage.this;
                                            productDetailViewEvent2.productDetailEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.3.3
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Unit invoke(String str, Object obj) {
                                                    String str2 = str;
                                                    Iterator<IProductDetailEvent> it = ProductDetailPage.this.eventViewModel.iterator();
                                                    while (it.hasNext()) {
                                                        IProductDetailEvent next = it.next();
                                                        if (next.canHandleEventName().contains(str2)) {
                                                            next.onEvent(str2, obj);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final ProductDetailPage productDetailPage11 = ProductDetailPage.this;
                                            VisibilityEventKt.b(productDetailViewEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithDetailList.2.1.3.4
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    ProductDetailPage.this.pageExpReport();
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
                function1.invoke(conditionView2);
                final ProductDetailPage productDetailPage4 = ProductDetailPage.this;
                productDetailPage4.getClass();
                if (productDetailPage4.pageModel == null) {
                    function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$1
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            ViewContainer<?, ?> viewContainer4 = viewContainer3;
                            IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                            Intrinsics.checkNotNull(iProductDetailPageModel);
                            IProductDetailPendantViewModel[] detailPendantsViewModel = iProductDetailPageModel.detailPendantsViewModel();
                            final ProductDetailPage productDetailPage5 = ProductDetailPage.this;
                            for (final IProductDetailPendantViewModel iProductDetailPendantViewModel : detailPendantsViewModel) {
                                IProductDetailEvent iProductDetailEvent = iProductDetailPendantViewModel instanceof IProductDetailEvent ? (IProductDetailEvent) iProductDetailPendantViewModel : null;
                                productDetailPage5.getClass();
                                if (iProductDetailEvent != null) {
                                    productDetailPage5.eventViewModel.add(iProductDetailEvent);
                                }
                                viewContainer4.addChild(iProductDetailPendantViewModel.getPendantView(), new Function1<ComposeView<ProductDetailPendantAttr, ProductDetailEvent>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ComposeView<ProductDetailPendantAttr, ProductDetailEvent> composeView) {
                                        ComposeView<ProductDetailPendantAttr, ProductDetailEvent> composeView2 = composeView;
                                        final IProductDetailPendantViewModel iProductDetailPendantViewModel2 = IProductDetailPendantViewModel.this;
                                        composeView2.attr(new Function1<ProductDetailPendantAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$2$1$1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ProductDetailPendantAttr productDetailPendantAttr) {
                                                productDetailPendantAttr.viewModel = IProductDetailPendantViewModel.this;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailPage productDetailPage6 = productDetailPage5;
                                        composeView2.ref(composeView2, new Function1<aa<ComposeView<ProductDetailPendantAttr, ProductDetailEvent>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$2$1$1.2
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
                                            
                                                if (r0.mainViewScrollEnable() == true) goto L11;
                                             */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(aa<ComposeView<ProductDetailPendantAttr, ProductDetailEvent>> aaVar) {
                                                aa<ComposeView<ProductDetailPendantAttr, ProductDetailEvent>> aaVar2 = aaVar;
                                                p b16 = aaVar2.b();
                                                IProductDetailPageSubView iProductDetailPageSubView = b16 instanceof IProductDetailPageSubView ? (IProductDetailPageSubView) b16 : null;
                                                boolean z16 = iProductDetailPageSubView != null;
                                                if (z16) {
                                                    ProductDetailPage.this.scrollEnableView.add(aaVar2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailPage productDetailPage7 = productDetailPage5;
                                        composeView2.event(new Function1<ProductDetailEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithAllPendantView$2$1$1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ProductDetailEvent productDetailEvent) {
                                                final ProductDetailPage productDetailPage8 = ProductDetailPage.this;
                                                productDetailEvent.productDetailEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithAllPendantView.2.1.1.3.1
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Unit invoke(String str, Object obj) {
                                                        String str2 = str;
                                                        Iterator<IProductDetailEvent> it = ProductDetailPage.this.eventViewModel.iterator();
                                                        while (it.hasNext()) {
                                                            IProductDetailEvent next = it.next();
                                                            if (next.canHandleEventName().contains(str2)) {
                                                                next.onEvent(str2, obj);
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
                            }
                            return Unit.INSTANCE;
                        }
                    };
                }
                function12.invoke(conditionView2);
                return Unit.INSTANCE;
            }
        });
        final ProductDetailPage productDetailPage3 = this.$ctx;
        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                return Boolean.valueOf((iProductDetailPageModel != null ? iProductDetailPageModel.detailState() : null) == ProductDetailPageState.LOADING);
            }
        };
        final ProductDetailPage productDetailPage4 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final ProductDetailPage productDetailPage5 = ProductDetailPage.this;
                KProperty<Object>[] kPropertyArr = ProductDetailPage.$$delegatedProperties;
                productDetailPage5.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithSkeletonView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final ProductDetailPage productDetailPage6 = ProductDetailPage.this;
                        viewContainer3.addChild(new ProductDetailSkeletonView(), new Function1<ProductDetailSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithSkeletonView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ProductDetailSkeletonView productDetailSkeletonView) {
                                final ProductDetailPage productDetailPage7 = ProductDetailPage.this;
                                productDetailSkeletonView.attr(new Function1<ProductDetailSkeletonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithSkeletonView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ProductDetailSkeletonAttr productDetailSkeletonAttr) {
                                        productDetailSkeletonAttr.pageDelegate = ProductDetailPage.this.pageDelegate;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }.invoke(conditionView);
                return Unit.INSTANCE;
            }
        });
        final ProductDetailPage productDetailPage5 = this.$ctx;
        Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                return Boolean.valueOf((iProductDetailPageModel != null ? iProductDetailPageModel.detailState() : null) == ProductDetailPageState.FAILURE);
            }
        };
        final ProductDetailPage productDetailPage6 = this.$ctx;
        ConditionViewKt.b(viewContainer2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithMainView$1.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                final ProductDetailPage productDetailPage7 = ProductDetailPage.this;
                KProperty<Object>[] kPropertyArr = ProductDetailPage.$$delegatedProperties;
                productDetailPage7.getClass();
                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithErrorView$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                        final ProductDetailPage productDetailPage8 = ProductDetailPage.this;
                        ECErrorViewKt.ErrorView(viewContainer3, new Function1<ECErrorView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithErrorView$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECErrorView eCErrorView) {
                                ECErrorView eCErrorView2 = eCErrorView;
                                eCErrorView2.attr(new Function1<ErrorViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithErrorView.1.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ErrorViewAttr errorViewAttr) {
                                        errorViewAttr.positionTop = Float.valueOf(0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailPage productDetailPage9 = ProductDetailPage.this;
                                eCErrorView2.event(new Function1<ErrorViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithErrorView.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ErrorViewEvent errorViewEvent) {
                                        ErrorViewEvent errorViewEvent2 = errorViewEvent;
                                        final ProductDetailPage productDetailPage10 = ProductDetailPage.this;
                                        errorViewEvent2.registerEvent("clickRetryButton", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithErrorView.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                IProductDetailPageModel iProductDetailPageModel = ProductDetailPage.this.pageModel;
                                                if (iProductDetailPageModel != null) {
                                                    iProductDetailPageModel.refreshData();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ProductDetailPage productDetailPage11 = ProductDetailPage.this;
                                        errorViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithErrorView.1.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ProductDetailPage.this.pageDelegate.closePage(null);
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
                }.invoke(conditionView);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
