package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.CategoryAttr;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.CategoryEvent;
import com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.view.MyCouponCategoryView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ScrollParams;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailCategoryView extends ProductDetailPendantView implements IProductDetailPageSubView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCategoryView.class, "categoryViewOpacity", "getCategoryViewOpacity()F", 0)};
    public final ReadWriteProperty categoryViewOpacity$delegate = c.a(Float.valueOf(0.0f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$moveToPageIndex(ProductDetailCategoryView productDetailCategoryView, int i3) {
        IProductDetailPageDelegate iProductDetailPageDelegate;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) productDetailCategoryView.getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel");
        ProductDetailCategoryViewModel productDetailCategoryViewModel = (ProductDetailCategoryViewModel) viewModel;
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(productDetailCategoryView.getPagerData().n());
        if (schemeMarginTop <= 0.1f) {
            schemeMarginTop = 0.48f * productDetailCategoryView.getPagerData().m();
        }
        float navigationBarHeight = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getNavigationBarHeight();
        productDetailCategoryViewModel.getClass();
        float f16 = schemeMarginTop - (navigationBarHeight - 44.0f);
        if (!productDetailCategoryViewModel.isHalf) {
            f16 = 0.0f;
        }
        if (i3 == 0) {
            IProductDetailPageDelegate iProductDetailPageDelegate2 = productDetailCategoryViewModel.pageDelegate;
            if (iProductDetailPageDelegate2 != null) {
                iProductDetailPageDelegate2.setContentOffset(f16 + 0.0f, true);
                return;
            }
            return;
        }
        if (i3 == 1) {
            IProductDetailPageDelegate iProductDetailPageDelegate3 = productDetailCategoryViewModel.pageDelegate;
            if (iProductDetailPageDelegate3 != null) {
                iProductDetailPageDelegate3.setContentOffset(productDetailCategoryViewModel.commentCardY, true);
                return;
            }
            return;
        }
        if (i3 == 2) {
            IProductDetailPageDelegate iProductDetailPageDelegate4 = productDetailCategoryViewModel.pageDelegate;
            if (iProductDetailPageDelegate4 != null) {
                iProductDetailPageDelegate4.setContentOffset(productDetailCategoryViewModel.picturesCardY, true);
                return;
            }
            return;
        }
        if (i3 == 3 && (iProductDetailPageDelegate = productDetailCategoryViewModel.pageDelegate) != null) {
            float f17 = productDetailCategoryViewModel.recommendCardY;
            iProductDetailPageDelegate.setContentOffset(f17 > 0.0f ? f17 : 0.0f, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryAttr");
        final ProductDetailCategoryAttr productDetailCategoryAttr = (ProductDetailCategoryAttr) attr;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel");
        final ProductDetailCategoryViewModel productDetailCategoryViewModel = (ProductDetailCategoryViewModel) viewModel;
        if (productDetailCategoryViewModel.isHalf) {
            productDetailCategoryAttr.opacity$delegate.setValue(productDetailCategoryAttr, ProductDetailCategoryAttr.$$delegatedProperties[1], Float.valueOf(0.0f));
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailCategoryViewModel productDetailCategoryViewModel2 = ProductDetailCategoryViewModel.this;
                final ProductDetailCategoryView productDetailCategoryView = this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        Attr.absolutePosition$default(mVar2, mVar2.getPagerData().getNavigationBarHeight(), 0.0f, 0.0f, 0.0f, 14, null);
                        float m3 = mVar2.getPagerData().m();
                        ProductDetailCategoryViewModel.this.getClass();
                        mVar2.size(m3, 44.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        ProductDetailCategoryView productDetailCategoryView2 = productDetailCategoryView;
                        mVar2.m147opacity(((Number) productDetailCategoryView2.categoryViewOpacity$delegate.getValue(productDetailCategoryView2, ProductDetailCategoryView.$$delegatedProperties[0])).floatValue());
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailCategoryView productDetailCategoryView2 = this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ProductDetailCategoryView productDetailCategoryView3 = ProductDetailCategoryView.this;
                        return Boolean.valueOf(!(((Number) productDetailCategoryView3.categoryViewOpacity$delegate.getValue(productDetailCategoryView3, ProductDetailCategoryView.$$delegatedProperties[0])).floatValue() == 0.0f));
                    }
                };
                final ProductDetailCategoryViewModel productDetailCategoryViewModel3 = ProductDetailCategoryViewModel.this;
                final ProductDetailCategoryAttr productDetailCategoryAttr2 = productDetailCategoryAttr;
                final ProductDetailCategoryView productDetailCategoryView3 = this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ProductDetailCategoryViewModel productDetailCategoryViewModel4 = ProductDetailCategoryViewModel.this;
                        final ProductDetailCategoryAttr productDetailCategoryAttr3 = productDetailCategoryAttr2;
                        final ProductDetailCategoryView productDetailCategoryView4 = productDetailCategoryView3;
                        conditionView.addChild(new MyCouponCategoryView(), new Function1<MyCouponCategoryView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(MyCouponCategoryView myCouponCategoryView) {
                                MyCouponCategoryView myCouponCategoryView2 = myCouponCategoryView;
                                final ProductDetailCategoryViewModel productDetailCategoryViewModel5 = ProductDetailCategoryViewModel.this;
                                final ProductDetailCategoryAttr productDetailCategoryAttr4 = productDetailCategoryAttr3;
                                myCouponCategoryView2.attr(new Function1<CategoryAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CategoryAttr categoryAttr) {
                                        h hVar;
                                        CategoryAttr categoryAttr2 = categoryAttr;
                                        categoryAttr2.mo153width(categoryAttr2.getPagerData().m());
                                        ProductDetailCategoryViewModel.this.getClass();
                                        categoryAttr2.mo141height(44.0f);
                                        categoryAttr2.items = productDetailCategoryAttr4.itemsConfig;
                                        hVar = IPagerIdKtxKt.getSkinColor(categoryAttr2).tokenColor("qecommerce_skin_color_icon_primary", false);
                                        categoryAttr2.indicatorColor = hVar;
                                        categoryAttr2.indicatorPosition(productDetailCategoryAttr4.getIndicator(), false);
                                        categoryAttr2.fontChangeEnable$delegate.setValue(categoryAttr2, CategoryAttr.$$delegatedProperties[1], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ProductDetailCategoryView productDetailCategoryView5 = productDetailCategoryView4;
                                myCouponCategoryView2.event(new Function1<CategoryEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(CategoryEvent categoryEvent) {
                                        final ProductDetailCategoryView productDetailCategoryView6 = ProductDetailCategoryView.this;
                                        categoryEvent.registerEvent("clickTabSwitch", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                ProductDetailCategoryView productDetailCategoryView7 = ProductDetailCategoryView.this;
                                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                                ProductDetailCategoryView.access$moveToPageIndex(productDetailCategoryView7, ((Integer) obj).intValue());
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
        return new ProductDetailCategoryAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        A attr = getAttr();
        Intrinsics.checkNotNull(attr, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryAttr");
        ProductDetailCategoryAttr productDetailCategoryAttr = (ProductDetailCategoryAttr) attr;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel");
        ProductDetailCategoryViewModel productDetailCategoryViewModel = (ProductDetailCategoryViewModel) viewModel;
        float offsetY = scrollParams.getOffsetY();
        productDetailCategoryViewModel.getClass();
        float f16 = offsetY + 44.0f;
        float f17 = productDetailCategoryViewModel.recommendCardY;
        if (f16 > f17 && f17 > 0.0f) {
            float m3 = getPagerData().m() * 0.75f;
            if (!(productDetailCategoryAttr.getIndicator() == m3)) {
                productDetailCategoryAttr.setIndicator(m3);
            }
        } else {
            float f18 = productDetailCategoryViewModel.picturesCardY;
            if (f16 > f18 && f18 > 0.0f) {
                float m16 = getPagerData().m() * 0.5f;
                if (!(productDetailCategoryAttr.getIndicator() == m16)) {
                    productDetailCategoryAttr.setIndicator(m16);
                }
            } else {
                float f19 = productDetailCategoryViewModel.commentCardY;
                if (f16 > f19 && f19 > 0.0f) {
                    float m17 = getPagerData().m() * 0.25f;
                    if (!(productDetailCategoryAttr.getIndicator() == m17)) {
                        productDetailCategoryAttr.setIndicator(m17);
                    }
                } else if (productDetailCategoryAttr.getIndicator() > 0.0f) {
                    productDetailCategoryAttr.setIndicator(0.0f);
                }
            }
        }
        IProductDetailPendantViewModel viewModel2 = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel");
        ProductDetailCategoryViewModel productDetailCategoryViewModel2 = (ProductDetailCategoryViewModel) viewModel2;
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(getPagerData().n());
        if (schemeMarginTop <= 0.1f) {
            schemeMarginTop = getPagerData().m() * 0.48f;
        }
        float navigationBarHeight = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getNavigationBarHeight();
        productDetailCategoryViewModel2.getClass();
        this.categoryViewOpacity$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(Math.min(Math.max((scrollParams.getOffsetY() - (schemeMarginTop - (navigationBarHeight - 44.0f))) / 250.0f, 0.0f), 1.0f)));
        IProductDetailPendantViewModel viewModel3 = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.category.ProductDetailCategoryViewModel");
        ProductDetailCategoryViewModel productDetailCategoryViewModel3 = (ProductDetailCategoryViewModel) viewModel3;
        float offsetY2 = scrollParams.getOffsetY();
        productDetailCategoryViewModel3.getClass();
        float f26 = offsetY2 + 44.0f;
        if (productDetailCategoryViewModel3.recommendCardY > 0.0f && getPagerData().g() + f26 > productDetailCategoryViewModel3.recommendCardY) {
            productDetailCategoryViewModel3.updatePageExpDepth(4);
            return;
        }
        if (productDetailCategoryViewModel3.picturesCardY > 0.0f && getPagerData().g() + f26 > productDetailCategoryViewModel3.picturesCardY) {
            productDetailCategoryViewModel3.updatePageExpDepth(3);
        } else if (productDetailCategoryViewModel3.commentCardY > 0.0f && getPagerData().g() + f26 > productDetailCategoryViewModel3.commentCardY) {
            productDetailCategoryViewModel3.updatePageExpDepth(2);
        } else {
            productDetailCategoryViewModel3.updatePageExpDepth(1);
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailCategoryAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }
}
