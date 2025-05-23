package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class ProductDetailShopHostBottomView extends ProductDetailPendantView {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        Object first;
        final float f16 = getPagerData().getIsIphoneX() ? 14.5f : 0.0f;
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomViewModel");
        final ProductDetailShopHostBottomViewModel productDetailShopHostBottomViewModel = (ProductDetailShopHostBottomViewModel) viewModel;
        productDetailShopHostBottomViewModel.getClass();
        first = ArraysKt___ArraysKt.first(new ProductDetailButtonItem[]{new ProductDetailButtonItem("\u6dfb\u52a0", 29)});
        final ProductDetailButtonItem productDetailButtonItem = (ProductDetailButtonItem) first;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailShopHostBottomViewModel productDetailShopHostBottomViewModel2 = ProductDetailShopHostBottomViewModel.this;
                final float f17 = f16;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                        ProductDetailShopHostBottomViewModel.this.getClass();
                        mVar2.mo141height(f17 + 80.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                ((Attr) c.a.a(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null)).mo141height(1.0f);
                                GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_divider", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopHostBottomViewModel productDetailShopHostBottomViewModel3 = ProductDetailShopHostBottomViewModel.this;
                final ProductDetailButtonItem productDetailButtonItem2 = productDetailButtonItem;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.allCenter();
                                tVar2.borderRadius(4.0f);
                                ((Attr) c.a.a(tVar2, 10.0f, 16.0f, 0.0f, 16.0f, 4, null)).mo141height(40.0f);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailShopHostBottomViewModel productDetailShopHostBottomViewModel4 = ProductDetailShopHostBottomViewModel.this;
                        final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>(productDetailButtonItem3) { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ProductDetailShopHostBottomViewModel productDetailShopHostBottomViewModel5 = ProductDetailShopHostBottomViewModel.this;
                                        productDetailShopHostBottomViewModel5.getClass();
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        e eVar = new e();
                                        eVar.v("addSpuid", productDetailShopHostBottomViewModel5.spuId);
                                        BridgeModule.closePage$default(currentBridgeModule, eVar, null, 2);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem2;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final ProductDetailButtonItem productDetailButtonItem5 = ProductDetailButtonItem.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopHostBottomView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        h hVar;
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(ProductDetailButtonItem.this.txt);
                                        ce.fontSize$default(ceVar2.fontWeightBold(), 16.0f, null, 2, null);
                                        hVar = IPagerIdKtxKt.getSkinColor(ceVar2).tokenColor("qecommerce_color_bg_default", false);
                                        ceVar2.color(hVar);
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
