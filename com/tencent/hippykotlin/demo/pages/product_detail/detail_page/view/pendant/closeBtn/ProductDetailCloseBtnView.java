package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.ProductDetailShopViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailCloseBtnView extends ProductDetailPendantView implements IProductDetailPageSubView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCloseBtnView.class, "closeBtnY", "getCloseBtnY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailCloseBtnView.class, "closeBtnAlpha", "getCloseBtnAlpha()F", 0)};
    public final ReadWriteProperty closeBtnAlpha$delegate;
    public float closeBtnDefaultY;
    public final ReadWriteProperty closeBtnY$delegate;
    public float closeIconTopMargin = 16.0f;

    public ProductDetailCloseBtnView() {
        float navigationBarHeight = c.f117352a.k(BridgeManager.f117344a.u()).getPageData().getNavigationBarHeight() + 200.0f + this.closeIconTopMargin;
        this.closeBtnDefaultY = navigationBarHeight;
        this.closeBtnY$delegate = c01.c.a(Float.valueOf(navigationBarHeight));
        this.closeBtnAlpha$delegate = c01.c.a(Float.valueOf(1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnViewModel");
        final ProductDetailCloseBtnViewModel productDetailCloseBtnViewModel = (ProductDetailCloseBtnViewModel) viewModel;
        g pageData = c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(pageData.n());
        if (Math.abs(schemeMarginTop - 0) <= 0.1f) {
            schemeMarginTop = pageData.m() * 0.48f;
        }
        float navigationBarHeight = (pageData.getNavigationBarHeight() - 44.0f) + schemeMarginTop + this.closeIconTopMargin;
        ReadWriteProperty readWriteProperty = this.closeBtnY$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], Float.valueOf(navigationBarHeight));
        this.closeBtnDefaultY = ((Number) this.closeBtnY$delegate.getValue(this, kPropertyArr[0])).floatValue();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailCloseBtnView productDetailCloseBtnView = ProductDetailCloseBtnView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.size(32.0f, 32.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_color_tag_dark_30", false);
                        mVar2.mo113backgroundColor(hVar);
                        ProductDetailCloseBtnView productDetailCloseBtnView2 = ProductDetailCloseBtnView.this;
                        ReadWriteProperty readWriteProperty2 = productDetailCloseBtnView2.closeBtnY$delegate;
                        KProperty<?>[] kPropertyArr2 = ProductDetailCloseBtnView.$$delegatedProperties;
                        Attr.absolutePosition$default(mVar2, ((Number) readWriteProperty2.getValue(productDetailCloseBtnView2, kPropertyArr2[0])).floatValue(), 0.0f, 0.0f, 16.0f, 6, null);
                        mVar2.borderRadius(16.0f);
                        ProductDetailCloseBtnView productDetailCloseBtnView3 = ProductDetailCloseBtnView.this;
                        mVar2.m147opacity(((Number) productDetailCloseBtnView3.closeBtnAlpha$delegate.getValue(productDetailCloseBtnView3, kPropertyArr2[1])).floatValue());
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailCloseBtnViewModel productDetailCloseBtnViewModel2 = productDetailCloseBtnViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final ProductDetailCloseBtnViewModel productDetailCloseBtnViewModel3 = ProductDetailCloseBtnViewModel.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                IProductDetailPageDelegate iProductDetailPageDelegate;
                                ProductDetailCloseBtnViewModel productDetailCloseBtnViewModel4 = ProductDetailCloseBtnViewModel.this;
                                IProductDetailViewModel iProductDetailViewModel = productDetailCloseBtnViewModel4.detailViewModel;
                                if (iProductDetailViewModel != null) {
                                    if ((iProductDetailViewModel instanceof ProductDetailShopViewModel) && !((ProductDetailShopViewModel) iProductDetailViewModel).popRetainWindow() && (iProductDetailPageDelegate = productDetailCloseBtnViewModel4.pageDelegate) != null) {
                                        iProductDetailPageDelegate.closePage(null);
                                    }
                                } else {
                                    IProductDetailPageDelegate iProductDetailPageDelegate2 = productDetailCloseBtnViewModel4.pageDelegate;
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
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.closeBtn.ProductDetailCloseBtnView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(20.0f, 20.0f);
                                b.a.b(afVar2, "qecommerce_icon_nav_close", false, 2, null);
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

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        float schemeMarginTop = SchemeParamExtensionKt.schemeMarginTop(getPagerData().n());
        if (schemeMarginTop <= 0.1f) {
            schemeMarginTop = getPagerData().m() * 0.48f;
        }
        float offsetY = this.closeBtnDefaultY - scrollParams.getOffsetY();
        ReadWriteProperty readWriteProperty = this.closeBtnY$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], Float.valueOf(offsetY));
        this.closeBtnAlpha$delegate.setValue(this, kPropertyArr[1], Float.valueOf(1 - Math.min(1.0f, Math.max(scrollParams.getOffsetY() / (schemeMarginTop - 44.0f), 0.0f))));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }
}
