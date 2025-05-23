package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class ProductDetailIconView extends ProductDetailPendantView implements IProductDetailPageSubView {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ProductDetailIconView.class, "liveIconY", "getLiveIconY()F", 0)};
    public final ReadWriteProperty liveIconY$delegate = c.a(Float.valueOf(120.0f));

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconViewModel");
        final ProductDetailIconViewModel productDetailIconViewModel = (ProductDetailIconViewModel) viewModel;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final ProductDetailIconView productDetailIconView = ProductDetailIconView.this;
                final ProductDetailIconViewModel productDetailIconViewModel2 = productDetailIconViewModel;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        h hVar2;
                        m mVar2 = mVar;
                        ProductDetailIconView productDetailIconView2 = ProductDetailIconView.this;
                        Attr.absolutePosition$default(mVar2, ((Number) productDetailIconView2.liveIconY$delegate.getValue(productDetailIconView2, ProductDetailIconView.$$delegatedProperties[0])).floatValue(), 0.0f, 0.0f, 16.0f, 6, null);
                        productDetailIconViewModel2.getClass();
                        mVar2.size(56.0f, 64.0f);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_color_tag_light_70", false);
                        mVar2.mo113backgroundColor(hVar);
                        mVar2.borderRadius(16.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.alignItemsCenter();
                        mVar2.justifyContentFlexStart();
                        ProductDetailIconViewModel productDetailIconViewModel3 = productDetailIconViewModel2;
                        mVar2.m152visibility(((Boolean) productDetailIconViewModel3.needShowLiveIcon$delegate.getValue(productDetailIconViewModel3, ProductDetailIconViewModel.$$delegatedProperties[0])).booleanValue());
                        hVar2 = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_divider", false);
                        new e(1.0f, BorderStyle.SOLID, hVar2);
                        return Unit.INSTANCE;
                    }
                });
                final ProductDetailIconViewModel productDetailIconViewModel3 = productDetailIconViewModel;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final ProductDetailIconViewModel productDetailIconViewModel4 = ProductDetailIconViewModel.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                String str = ProductDetailIconViewModel.this.jumpUrl;
                                if (str != null) {
                                    BridgeModule.openPage$default(Utils.INSTANCE.currentBridgeModule(), str, false, null, null, 30);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.allCenter();
                                tVar2.size(24.0f, 24.0f);
                                tVar2.borderRadius(8.0f);
                                c.a.a(tVar2, 10.0f, 0.0f, 5.0f, 0.0f, 10, null);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_TOP_RIGHT, new j(new h(4294194041L), 0.0f), new j(new h(4294922871L), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        PAGViewKt.PAG(vVar2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGView pAGView) {
                                pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(PAGAttr pAGAttr) {
                                        PAGAttr pAGAttr2 = pAGAttr;
                                        pAGAttr2.autoPlay(true);
                                        pAGAttr2.repeatCount(0);
                                        pAGAttr2.size(16.0f, 16.0f);
                                        if (pAGAttr2.getPagerData().getIsIOS()) {
                                            pAGAttr2.src("ec_live_explaining.pag");
                                        } else {
                                            pAGAttr2.src("ecommerce_live_explaining");
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
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.liveIcon.ProductDetailIconView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.text("\u76f4\u64ad\u4e2d");
                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                ceVar2.color(h.INSTANCE.b());
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
        return new ProductDetailPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final boolean mainViewScrollEnable() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEvent(ScrollParams scrollParams) {
        this.liveIconY$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(Math.max((Math.min(Math.max(scrollParams.getOffsetY() / 250.0f, 0.0f), 1.0f) * 44.0f) + 120.0f, -scrollParams.getOffsetY())));
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailPendantAttr();
    }

    @Override // com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPageSubView
    public final void mainViewScrollEnd() {
    }
}
