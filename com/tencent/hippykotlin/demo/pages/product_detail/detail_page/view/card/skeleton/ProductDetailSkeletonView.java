package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class ProductDetailSkeletonView extends ComposeView<ProductDetailSkeletonAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ProductDetailSkeletonAttr access$getAttr(ProductDetailSkeletonView productDetailSkeletonView) {
        return (ProductDetailSkeletonAttr) productDetailSkeletonView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        SchemeParamExtensionKt.schemeIsHalf(getPagerData().n());
        getPagerData().getNavigationBarHeight();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailSkeletonView productDetailSkeletonView = ProductDetailSkeletonView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final ProductDetailSkeletonView productDetailSkeletonView2 = ProductDetailSkeletonView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                IProductDetailPageDelegate iProductDetailPageDelegate = ProductDetailSkeletonView.access$getAttr(ProductDetailSkeletonView.this).pageDelegate;
                                if (iProductDetailPageDelegate != null) {
                                    iProductDetailPageDelegate.closePage(null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailSkeletonView productDetailSkeletonView2 = ProductDetailSkeletonView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final ProductDetailSkeletonView productDetailSkeletonView3 = ProductDetailSkeletonView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                h hVar;
                                t tVar2 = tVar;
                                g pageData = c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
                                float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(pageData.n());
                                if (Math.abs(schemeMarginTop - 0) <= 0.1f) {
                                    schemeMarginTop = pageData.m() * 0.48f;
                                }
                                float navigationBarHeight = (pageData.getNavigationBarHeight() - 44.0f) + schemeMarginTop;
                                if (SchemeParamExtensionKt.schemeIsHalf(ProductDetailSkeletonView.this.getPagerData().n())) {
                                    tVar2.marginTop(navigationBarHeight);
                                } else {
                                    tVar2.marginTop(tVar2.getPagerData().getNavigationBarHeight() + 0.48f);
                                }
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentFlexStart();
                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                                tVar2.mo113backgroundColor(hVar);
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        h hVar;
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().m());
                                        hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                        tVar2.mo113backgroundColor(hVar);
                                        tVar2.borderRadius(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.paddingLeft(16.0f);
                                        tVar2.paddingRight(16.0f);
                                        tVar2.marginTop(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                t tVar2 = tVar;
                                                tVar2.size(60.0f, 20.0f);
                                                tVar2.borderRadius(4.0f);
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                                tVar2.mo113backgroundColor(hVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                h hVar;
                                                t tVar2 = tVar;
                                                tVar2.size(50.0f, 20.0f);
                                                tVar2.borderRadius(4.0f);
                                                hVar = IPagerIdKtxKt.getSkinColor(tVar2).tokenColor("qecommerce_skin_color_bg_backplate", false);
                                                tVar2.mo113backgroundColor(hVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(100.0f, 20.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_backplate", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.5
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.5.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(160.0f, 20.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_backplate", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.6
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.6.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(80.0f, 20.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_backplate", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.7
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.skeleton.ProductDetailSkeletonView.body.1.2.7.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(tVar2.getPagerData().m() - 32.0f, 300.0f);
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginTop(16.0f);
                                        tVar2.borderRadius(4.0f);
                                        GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_backplate", false, 2, null);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailSkeletonAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
