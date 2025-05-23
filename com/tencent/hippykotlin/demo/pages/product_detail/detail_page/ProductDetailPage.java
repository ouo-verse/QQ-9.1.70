package com.tencent.hippykotlin.demo.pages.product_detail.detail_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageDelegate;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public class ProductDetailPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailPage.class, "isHalfAppear", "isHalfAppear()Z", 0)};
    public e closePageData;
    public aa<ProductDetailView> detailRef;
    public IProductDetailPageModel pageModel;
    public final ReadWriteProperty isHalfAppear$delegate = c.a(Boolean.FALSE);
    public final ProductDetailPage$pageDelegate$1 pageDelegate = (ProductDetailPage$pageDelegate$1) pageDelegate();
    public final ArrayList<aa<?>> scrollEnableView = new ArrayList<>();
    public final ArrayList<IProductDetailEvent> eventViewModel = new ArrayList<>();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                if (SchemeParamExtensionKt.schemeIsHalf(ProductDetailPage.this.getPagerData().n())) {
                    ProductDetailPage productDetailPage = ProductDetailPage.this;
                    productDetailPage.isHalfAppear$delegate.setValue(productDetailPage, ProductDetailPage.$$delegatedProperties[0], Boolean.TRUE);
                    final ProductDetailPage productDetailPage2 = ProductDetailPage.this;
                    productDetailPage2.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithHalfBackgroundView$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final ProductDetailPage productDetailPage3 = ProductDetailPage.this;
                            ECTransitionViewKt.TransitionFadeInOutView(viewContainer3, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithHalfBackgroundView$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ECTransitionView eCTransitionView) {
                                    final ProductDetailPage productDetailPage4 = ProductDetailPage.this;
                                    eCTransitionView.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithHalfBackgroundView.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                            ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                            ProductDetailPage productDetailPage5 = ProductDetailPage.this;
                                            eCTransitionAttr2.setTransitionAppear(((Boolean) productDetailPage5.isHalfAppear$delegate.getValue(productDetailPage5, ProductDetailPage.$$delegatedProperties[0])).booleanValue());
                                            eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                            eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }.invoke(viewContainer2);
                    final ProductDetailPage productDetailPage3 = ProductDetailPage.this;
                    productDetailPage3.getClass();
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithHalfMainView$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final ProductDetailPage productDetailPage4 = ProductDetailPage.this;
                            ECTransitionViewKt.TransitionFromBottomView(viewContainer3, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage$bodyWithHalfMainView$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ECTransitionView eCTransitionView) {
                                    ECTransitionView eCTransitionView2 = eCTransitionView;
                                    final ProductDetailPage productDetailPage5 = ProductDetailPage.this;
                                    eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithHalfMainView.1.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                            ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                            ProductDetailPage productDetailPage6 = ProductDetailPage.this;
                                            eCTransitionAttr2.setTransitionAppear(((Boolean) productDetailPage6.isHalfAppear$delegate.getValue(productDetailPage6, ProductDetailPage.$$delegatedProperties[0])).booleanValue());
                                            eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ProductDetailPage productDetailPage6 = ProductDetailPage.this;
                                    eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithHalfMainView.1.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                            final ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                            final ProductDetailPage productDetailPage7 = ProductDetailPage.this;
                                            eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.ProductDetailPage.bodyWithHalfMainView.1.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool) {
                                                    if (!bool.booleanValue()) {
                                                        BridgeModule.closePage$default(Utils.INSTANCE.bridgeModule(ECTransitionEvent.this.getPagerId()), productDetailPage7.closePageData, null, 2);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ProductDetailPage productDetailPage7 = ProductDetailPage.this;
                                    KProperty<Object>[] kPropertyArr = ProductDetailPage.$$delegatedProperties;
                                    productDetailPage7.getClass();
                                    new ProductDetailPage$bodyWithMainView$1(productDetailPage7).invoke(eCTransitionView2);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }.invoke(viewContainer2);
                } else {
                    ProductDetailPage productDetailPage4 = ProductDetailPage.this;
                    productDetailPage4.getClass();
                    new ProductDetailPage$bodyWithMainView$1(productDetailPage4).invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        List reversed;
        super.created();
        g pageData = getPageData();
        reversed = ArraysKt___ArraysKt.reversed(ProductDetailPageModelType.values());
        int size = reversed.size();
        for (int i3 = 0; i3 < size; i3++) {
            ProductDetailPageModelType productDetailPageModelType = (ProductDetailPageModelType) reversed.get(i3);
            if (productDetailPageModelType.isThePageModelBlock.invoke(pageData.n()).booleanValue()) {
                IProductDetailPageModel invoke = productDetailPageModelType.newPageModelBlock.invoke(pageData);
                IProductDetailEvent iProductDetailEvent = invoke instanceof IProductDetailEvent ? (IProductDetailEvent) invoke : null;
                if (iProductDetailEvent != null) {
                    this.eventViewModel.add(iProductDetailEvent);
                }
                this.pageModel = invoke;
                if (invoke != null) {
                    invoke.setPageDelegate(this.pageDelegate);
                }
                IProductDetailPageModel iProductDetailPageModel = this.pageModel;
                if (iProductDetailPageModel != null) {
                    iProductDetailPageModel.reportPageExp();
                    return;
                }
                return;
            }
        }
        throw new Exception("please check ProductDetailPageModelDefine file, define param illegal");
    }

    public final IProductDetailPageDelegate pageDelegate() {
        return new ProductDetailPage$pageDelegate$1(this, this);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        IProductDetailPageModel iProductDetailPageModel = this.pageModel;
        if (iProductDetailPageModel != null) {
            iProductDetailPageModel.reportPageExit();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        IProductDetailPageModel iProductDetailPageModel = this.pageModel;
        if (iProductDetailPageModel != null) {
            iProductDetailPageModel.onDetailPageDestroy();
        }
        super.pageWillDestroy();
    }

    public void pageExpReport() {
    }
}
