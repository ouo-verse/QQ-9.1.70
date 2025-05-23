package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailActiveInfo;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailButtonItem;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.protoc.ProductDetailProductCardRsp;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.repository.shop.model.ProductDetailInfo;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class ProductDetailShopBottomView$bigBtn$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ Function1<ProductDetailButtonItem, Unit> $block;
    public final /* synthetic */ ProductDetailButtonItem $btnItem;
    public final /* synthetic */ ProductDetailShopBottomViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProductDetailShopBottomView$bigBtn$1(ProductDetailShopBottomViewModel productDetailShopBottomViewModel, Function1<? super ProductDetailButtonItem, Unit> function1, ProductDetailButtonItem productDetailButtonItem) {
        super(1);
        this.$viewModel = productDetailShopBottomViewModel;
        this.$block = function1;
        this.$btnItem = productDetailButtonItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        final ProductDetailShopBottomViewModel productDetailShopBottomViewModel = this.$viewModel;
        final Function1<ProductDetailButtonItem, Unit> function1 = this.$block;
        final ProductDetailButtonItem productDetailButtonItem = this.$btnItem;
        w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView$bigBtn$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(v vVar) {
                v vVar2 = vVar;
                final ProductDetailShopBottomViewModel productDetailShopBottomViewModel2 = ProductDetailShopBottomViewModel.this;
                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.bigBtn.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(t tVar) {
                        t tVar2 = tVar;
                        tVar2.mo141height(40.0f);
                        tVar2.marginLeft(8.0f);
                        tVar2.mo153width(tVar2.getPagerData().m() - 112.0f);
                        tVar2.borderRadius(4.0f);
                        tVar2.allCenter();
                        if (ProductDetailShopBottomViewModel.this.isBigBtnEnabled()) {
                            tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_color_btn_gradient01_normal"), 0.0f), new j(new h("qecommerce_color_btn_gradient02_normal"), 1.0f));
                        } else {
                            tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h("qecommerce_skin_color_btn_gradient01_disable"), 0.0f), new j(new h("qecommerce_skin_color_btn_gradient02_disable"), 1.0f));
                        }
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopBottomViewModel productDetailShopBottomViewModel3 = ProductDetailShopBottomViewModel.this;
                final Function1<ProductDetailButtonItem, Unit> function12 = function1;
                final ProductDetailButtonItem productDetailButtonItem2 = productDetailButtonItem;
                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.bigBtn.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(u uVar) {
                        final ProductDetailShopBottomViewModel productDetailShopBottomViewModel4 = ProductDetailShopBottomViewModel.this;
                        final Function1<ProductDetailButtonItem, Unit> function13 = function12;
                        final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem2;
                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.bigBtn.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                if (ProductDetailShopBottomViewModel.this.isBigBtnEnabled()) {
                                    function13.invoke(productDetailButtonItem3);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailShopBottomViewModel productDetailShopBottomViewModel4 = ProductDetailShopBottomViewModel.this;
                final ProductDetailButtonItem productDetailButtonItem3 = productDetailButtonItem;
                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.bigBtn.1.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final ProductDetailShopBottomViewModel productDetailShopBottomViewModel5 = ProductDetailShopBottomViewModel.this;
                        final ProductDetailButtonItem productDetailButtonItem4 = productDetailButtonItem3;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.ProductDetailShopBottomView.bigBtn.1.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                String str;
                                ProductDetailProductCardRsp productDetailProductCardRsp;
                                ProductDetailActiveInfo productDetailActiveInfo;
                                ce ceVar2 = ceVar;
                                ProductDetailShopBottomViewModel productDetailShopBottomViewModel6 = ProductDetailShopBottomViewModel.this;
                                ProductDetailButtonItem productDetailButtonItem5 = productDetailButtonItem4;
                                if (productDetailShopBottomViewModel6.productStatus$enumunboxing$() != 2) {
                                    str = productDetailButtonItem5.txt;
                                } else {
                                    ProductDetailInfo info = productDetailShopBottomViewModel6.getInfo();
                                    int i3 = (info == null || (productDetailProductCardRsp = info.detail) == null || (productDetailActiveInfo = productDetailProductCardRsp.activeInfo) == null) ? 0 : productDetailActiveInfo.activeDetailStatus;
                                    if (i3 == 1) {
                                        str = "\u6d3b\u52a8\u672a\u5f00\u59cb";
                                    } else if (i3 == 3 || i3 == 3) {
                                        str = "\u6d3b\u52a8\u5df2\u7ed3\u675f";
                                    } else if (i3 == 5) {
                                        str = "\u5df2\u552e\u7f44";
                                    } else {
                                        str = "";
                                    }
                                    if (!(str.length() > 0)) {
                                        str = productDetailButtonItem5.txt;
                                    }
                                }
                                ceVar2.text(str);
                                ceVar2.fontWeightBold();
                                ceVar2.color(h.INSTANCE.m());
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
}
