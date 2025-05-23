package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooter;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterAttr;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterEvent;
import com.tencent.hippykotlin.demo.pages.base.ECRefreshFooterKt;
import com.tencent.hippykotlin.demo.pages.base.ISkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cl;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailView extends ComposeView<ProductDetailViewAttr, ProductDetailViewEvent> {
    public aa<cm> detailViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final Function1 access$bodyWithHalfCell(ProductDetailView productDetailView, ProductDetailView productDetailView2) {
        productDetailView.getClass();
        IProductDetailViewModel iProductDetailViewModel = ((ProductDetailViewAttr) productDetailView2.getAttr()).viewModel;
        Intrinsics.checkNotNull(iProductDetailViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel");
        return new ProductDetailView$bodyWithHalfCell$1(iProductDetailViewModel, productDetailView2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailViewAttr access$getAttr(ProductDetailView productDetailView) {
        return (ProductDetailViewAttr) productDetailView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailViewEvent access$getEvent(ProductDetailView productDetailView) {
        return (ProductDetailViewEvent) productDetailView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleDragEnd(ProductDetailView productDetailView) {
        cm b16;
        aa<cm> aaVar = productDetailView.detailViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null || b16.getCurOffsetY() >= (-productDetailView.getPagerData().l()) / 7) {
            return;
        }
        AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m(Utils.INSTANCE.notifyModule(""), "DetailHalfViewExit", false, 4, null);
        IProductDetailPageDelegate iProductDetailPageDelegate = ((ProductDetailViewAttr) productDetailView.getAttr()).pageDelegate;
        if (iProductDetailPageDelegate != null) {
            iProductDetailPageDelegate.closePage(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$snapToEdge(ProductDetailView productDetailView) {
        cm b16;
        IProductDetailViewModel iProductDetailViewModel = ((ProductDetailViewAttr) productDetailView.getAttr()).viewModel;
        Intrinsics.checkNotNull(iProductDetailViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel");
        aa<cm> aaVar = productDetailView.detailViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        float curOffsetY = b16.getCurOffsetY();
        float halfMarginTopHeight = iProductDetailViewModel.halfMarginTopHeight();
        c cVar = c.f117352a;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        float navigationBarHeight = halfMarginTopHeight - (cVar.k(bridgeManager.u()).getPageData().getNavigationBarHeight() - cVar.k(bridgeManager.u()).getPageData().getStatusBarHeight());
        float f16 = navigationBarHeight / 2;
        if (curOffsetY < f16) {
            productDetailView.setContentOffsetY(0.0f, true);
        } else {
            if (curOffsetY < f16 || curOffsetY >= navigationBarHeight) {
                return;
            }
            productDetailView.setContentOffsetY(navigationBarHeight, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final IProductDetailViewModel iProductDetailViewModel = ((ProductDetailViewAttr) getAttr()).viewModel;
        Intrinsics.checkNotNull(iProductDetailViewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel");
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final ProductDetailView productDetailView = ProductDetailView.this;
                final IProductDetailViewModel iProductDetailViewModel2 = iProductDetailViewModel;
                cn.a(viewContainer, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(cm cmVar) {
                        cm cmVar2 = cmVar;
                        final ProductDetailView productDetailView2 = ProductDetailView.this;
                        cmVar2.ref(cmVar2, new Function1<aa<cm>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<cm> aaVar) {
                                ProductDetailView.this.detailViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailView productDetailView3 = ProductDetailView.this;
                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ck ckVar) {
                                ck ckVar2 = ckVar;
                                ckVar2.m140flex(1.0f);
                                ckVar2.alignSelfCenter();
                                ckVar2.h(2);
                                FlexNode flexNode = ProductDetailView.access$getAttr(ProductDetailView.this).getFlexNode();
                                ckVar2.w(flexNode != null ? flexNode.U() : 0.0f);
                                FlexNode flexNode2 = ProductDetailView.access$getAttr(ProductDetailView.this).getFlexNode();
                                ckVar2.mo141height(flexNode2 != null ? flexNode2.K() : 0.0f);
                                ckVar2.t(-21.0f);
                                ckVar2.showScrollerIndicator(false);
                                if (ProductDetailView.access$getAttr(ProductDetailView.this).isClearBackgroundColor()) {
                                    ckVar2.mo113backgroundColor(h.INSTANCE.k());
                                } else {
                                    ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(ckVar2);
                                    e n3 = ProductDetailView.this.getPagerData().n();
                                    ckVar2.mo113backgroundColor(skinColor.tokenColor("qecommerce_skin_color_bg_backplate", Intrinsics.areEqual(n3.q("page_name", ""), "blind_box_detail_page") || Intrinsics.areEqual(n3.q("page_name", ""), "float_product_detail")));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailView productDetailView4 = ProductDetailView.this;
                        cmVar2.event(new Function1<cl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cl clVar) {
                                cl clVar2 = clVar;
                                final ProductDetailView productDetailView5 = ProductDetailView.this;
                                clVar2.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ScrollParams scrollParams2 = scrollParams;
                                        ProductDetailViewAttr access$getAttr = ProductDetailView.access$getAttr(ProductDetailView.this);
                                        SchemeParamExtensionKt.schemeMarginTop(access$getAttr.getPagerData().n());
                                        c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getNavigationBarHeight();
                                        if (access$getAttr.isHalf) {
                                            float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(access$getAttr.getPagerData().n());
                                            if (schemeMarginTop <= 0.1f) {
                                                schemeMarginTop = access$getAttr.getPagerData().m() * 0.48f;
                                            }
                                            if (scrollParams2.getOffsetY() <= schemeMarginTop && !access$getAttr.isClearBackgroundColor()) {
                                                access$getAttr.setClearBackgroundColor(true);
                                            } else if (scrollParams2.getOffsetY() > schemeMarginTop && access$getAttr.isClearBackgroundColor()) {
                                                access$getAttr.setClearBackgroundColor(false);
                                            }
                                        }
                                        ProductDetailView.access$getEvent(ProductDetailView.this).onFireEvent("scroll", scrollParams2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailView productDetailView6 = ProductDetailView.this;
                                clVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ProductDetailView.access$getEvent(ProductDetailView.this).onFireEvent("scrollEnd", null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailView productDetailView7 = ProductDetailView.this;
                                clVar2.dragEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.body.1.1.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        if (ProductDetailView.access$getAttr(ProductDetailView.this).isHalf) {
                                            ProductDetailView.access$snapToEdge(ProductDetailView.this);
                                            ProductDetailView.access$handleDragEnd(ProductDetailView.this);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (ProductDetailView.access$getAttr(ProductDetailView.this).isHalf) {
                            ProductDetailView productDetailView5 = ProductDetailView.this;
                            ((ProductDetailView$bodyWithHalfCell$1) ProductDetailView.access$bodyWithHalfCell(productDetailView5, productDetailView5)).invoke(cmVar2);
                        }
                        final ProductDetailView productDetailView6 = ProductDetailView.this;
                        productDetailView6.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithDetailCards$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                final ProductDetailView productDetailView7 = ProductDetailView.this;
                                Function0<com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel>>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithDetailCards$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> invoke() {
                                        com.tencent.kuikly.core.reactive.collection.c<IProductDetailCardViewModel> detailCardsViewModel;
                                        IProductDetailViewModel iProductDetailViewModel3 = ProductDetailView.access$getAttr(ProductDetailView.this).viewModel;
                                        return (iProductDetailViewModel3 == null || (detailCardsViewModel = iProductDetailViewModel3.detailCardsViewModel()) == null) ? new com.tencent.kuikly.core.reactive.collection.c<>(null, null, null, 7, null) : detailCardsViewModel;
                                    }
                                };
                                final ProductDetailView productDetailView8 = ProductDetailView.this;
                                LoopDirectivesViewKt.a(viewContainer2, function0, new Function2<LoopDirectivesView<IProductDetailCardViewModel>, IProductDetailCardViewModel, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithDetailCards$1.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<IProductDetailCardViewModel> loopDirectivesView, IProductDetailCardViewModel iProductDetailCardViewModel) {
                                        final IProductDetailCardViewModel iProductDetailCardViewModel2 = iProductDetailCardViewModel;
                                        ComposeView<ProductDetailCardAttr, ProductDetailEvent> cardView = iProductDetailCardViewModel2.getCardView();
                                        final ProductDetailView productDetailView9 = ProductDetailView.this;
                                        loopDirectivesView.addChild(cardView, new Function1<ComposeView<ProductDetailCardAttr, ProductDetailEvent>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithDetailCards.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ComposeView<ProductDetailCardAttr, ProductDetailEvent> composeView) {
                                                ComposeView<ProductDetailCardAttr, ProductDetailEvent> composeView2 = composeView;
                                                final IProductDetailCardViewModel iProductDetailCardViewModel3 = IProductDetailCardViewModel.this;
                                                composeView2.attr(new Function1<ProductDetailCardAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithDetailCards.1.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ProductDetailCardAttr productDetailCardAttr) {
                                                        productDetailCardAttr.viewModel = IProductDetailCardViewModel.this;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ProductDetailView productDetailView10 = productDetailView9;
                                                composeView2.event(new Function1<ProductDetailEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithDetailCards.1.2.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ProductDetailEvent productDetailEvent) {
                                                        final ProductDetailView productDetailView11 = ProductDetailView.this;
                                                        productDetailEvent.productDetailEvent(new Function2<String, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithDetailCards.1.2.1.2.1
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(String str, Object obj) {
                                                                ProductDetailView.access$getEvent(ProductDetailView.this).onFireProductDetailEvent(str, obj);
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
                        }.invoke(cmVar2);
                        ProductDetailView productDetailView7 = ProductDetailView.this;
                        final IProductDetailViewModel iProductDetailViewModel3 = iProductDetailViewModel2;
                        productDetailView7.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithRefreshFooter$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                final IProductDetailViewModel iProductDetailViewModel4 = IProductDetailViewModel.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithRefreshFooter$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(IProductDetailViewModel.this.needShowFooter());
                                    }
                                };
                                final IProductDetailViewModel iProductDetailViewModel5 = IProductDetailViewModel.this;
                                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView$bodyWithRefreshFooter$1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final IProductDetailViewModel iProductDetailViewModel6 = IProductDetailViewModel.this;
                                        ECRefreshFooterKt.ECRefreshFooter(conditionView, new Function1<ECRefreshFooter, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithRefreshFooter.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECRefreshFooter eCRefreshFooter) {
                                                ECRefreshFooter eCRefreshFooter2 = eCRefreshFooter;
                                                final IProductDetailViewModel iProductDetailViewModel7 = IProductDetailViewModel.this;
                                                eCRefreshFooter2.attr(new Function1<ECRefreshFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithRefreshFooter.1.2.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECRefreshFooterAttr eCRefreshFooterAttr) {
                                                        ECRefreshFooterAttr eCRefreshFooterAttr2 = eCRefreshFooterAttr;
                                                        eCRefreshFooterAttr2.setPreloadDistance(30.0f);
                                                        eCRefreshFooterAttr2.mo153width(eCRefreshFooterAttr2.getPagerData().m());
                                                        eCRefreshFooterAttr2.mo141height(30.0f);
                                                        eCRefreshFooterAttr2.setFooterRefreshState(IProductDetailViewModel.this.refreshState());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final IProductDetailViewModel iProductDetailViewModel8 = IProductDetailViewModel.this;
                                                eCRefreshFooter2.event(new Function1<ECRefreshFooterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithRefreshFooter.1.2.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ECRefreshFooterEvent eCRefreshFooterEvent) {
                                                        ECRefreshFooterEvent eCRefreshFooterEvent2 = eCRefreshFooterEvent;
                                                        final IProductDetailViewModel iProductDetailViewModel9 = IProductDetailViewModel.this;
                                                        eCRefreshFooterEvent2.onRefreshingHandlerFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithRefreshFooter.1.2.1.2.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                IProductDetailViewModel.this.loadMore();
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        final IProductDetailViewModel iProductDetailViewModel10 = IProductDetailViewModel.this;
                                                        eCRefreshFooterEvent2.refreshStateDidChangeHandlerFn = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView.bodyWithRefreshFooter.1.2.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                IProductDetailViewModel.this.setRefreshState(footerRefreshState);
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
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
                        }.invoke(cmVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ProductDetailViewEvent();
    }

    public final void setContentOffsetY(float f16, boolean z16) {
        cm b16;
        aa<cm> aaVar = this.detailViewRef;
        if (aaVar == null || (b16 = aaVar.b()) == null) {
            return;
        }
        ScrollerView.setContentOffset$default(b16, 0.0f, f16, z16, null, 8, null);
    }
}
