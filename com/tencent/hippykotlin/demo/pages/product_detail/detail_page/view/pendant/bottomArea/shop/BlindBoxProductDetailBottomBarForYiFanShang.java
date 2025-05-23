package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.ButtonInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.ButtonMode;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonEvent;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonView;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailBottomBarForYiFanShang extends ComposeView<ProductDetailPendantAttr, ProductDetailEvent> {
    public static final Companion Companion = new Companion();
    public static final Lazy<Float> bottomBarHeight$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final float getBottomBarHeight() {
            return BlindBoxProductDetailBottomBarForYiFanShang.bottomBarHeight$delegate.getValue().floatValue();
        }
    }

    static {
        Lazy<Float> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang$Companion$bottomBarHeight$2
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                BlindBoxProductDetailBottomBarForYiFanShang.Companion companion = BlindBoxProductDetailBottomBarForYiFanShang.Companion;
                return Float.valueOf(144.0f);
            }
        });
        bottomBarHeight$delegate = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        g pageData = c.f117352a.k(BridgeManager.f117344a.u()).getPageData();
        IProductDetailPendantViewModel viewModel = ((ProductDetailPendantAttr) getAttr()).getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShangViewModel");
        final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel = (BlindBoxProductDetailBottomBarForYiFanShangViewModel) viewModel;
        blindBoxProductDetailBottomBarForYiFanShangViewModel.width = pageData.m();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel2 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(BlindBoxProductDetailBottomBarForYiFanShangViewModel.this.height);
                        mVar2.mo153width(BlindBoxProductDetailBottomBarForYiFanShangViewModel.this.width);
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel3 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                viewContainer2.addChild(new YiFanShangDetailBottomButtonView(), new Function1<YiFanShangDetailBottomButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView) {
                        YiFanShangDetailBottomButtonView yiFanShangDetailBottomButtonView2 = yiFanShangDetailBottomButtonView;
                        final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel4 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                        yiFanShangDetailBottomButtonView2.attr(new Function1<YiFanShangDetailBottomButtonAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(YiFanShangDetailBottomButtonAttr yiFanShangDetailBottomButtonAttr) {
                                YiFanShangDetailBottomButtonAttr yiFanShangDetailBottomButtonAttr2 = yiFanShangDetailBottomButtonAttr;
                                ButtonMode buttonMode = ButtonMode.WITH_TOP_BAR;
                                ReadWriteProperty readWriteProperty = yiFanShangDetailBottomButtonAttr2.bottomButtonMode$delegate;
                                KProperty<?>[] kPropertyArr = YiFanShangDetailBottomButtonAttr.$$delegatedProperties;
                                readWriteProperty.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[0], buttonMode);
                                yiFanShangDetailBottomButtonAttr2.showLastShangTag$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[4], Boolean.FALSE);
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel5 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                ReadWriteProperty readWriteProperty2 = blindBoxProductDetailBottomBarForYiFanShangViewModel5.cover$delegate;
                                KProperty<?>[] kPropertyArr2 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.$$delegatedProperties;
                                yiFanShangDetailBottomButtonAttr2.cover$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[5], (String) readWriteProperty2.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel5, kPropertyArr2[6]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel6 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.title$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[6], (String) blindBoxProductDetailBottomBarForYiFanShangViewModel6.title$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel6, kPropertyArr2[7]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel7 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.firstButton$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[1], (ButtonInfo) blindBoxProductDetailBottomBarForYiFanShangViewModel7.firstButton$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel7, kPropertyArr2[0]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel8 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.secondButton$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[2], (ButtonInfo) blindBoxProductDetailBottomBarForYiFanShangViewModel8.secondButton$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel8, kPropertyArr2[1]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel9 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.thirdButton$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[3], (ButtonInfo) blindBoxProductDetailBottomBarForYiFanShangViewModel9.thirdButton$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel9, kPropertyArr2[2]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel10 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.firstJumpUrl$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[7], (String) blindBoxProductDetailBottomBarForYiFanShangViewModel10.firstBtnJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel10, kPropertyArr2[3]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel11 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.secondJumpUrl$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[8], (String) blindBoxProductDetailBottomBarForYiFanShangViewModel11.secondBtnJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel11, kPropertyArr2[4]));
                                BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel12 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonAttr2.thirdJumpUrl$delegate.setValue(yiFanShangDetailBottomButtonAttr2, kPropertyArr[9], (String) blindBoxProductDetailBottomBarForYiFanShangViewModel12.thirdBtnJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarForYiFanShangViewModel12, kPropertyArr2[5]));
                                return Unit.INSTANCE;
                            }
                        });
                        final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel5 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                        yiFanShangDetailBottomButtonView2.event(new Function1<YiFanShangDetailBottomButtonEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(YiFanShangDetailBottomButtonEvent yiFanShangDetailBottomButtonEvent) {
                                YiFanShangDetailBottomButtonEvent yiFanShangDetailBottomButtonEvent2 = yiFanShangDetailBottomButtonEvent;
                                final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel6 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonEvent2.onFirstBtnClick = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang.body.1.2.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        e eVar = new e();
                                        BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel7 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                        eVar.v("box_id", blindBoxProductDetailBottomBarForYiFanShangViewModel7.boxId);
                                        eVar.v("spu_id", blindBoxProductDetailBottomBarForYiFanShangViewModel7.spuId);
                                        eVar.v("group_id", blindBoxProductDetailBottomBarForYiFanShangViewModel7.groupId);
                                        eVar.t("click_area", 2);
                                        eVar.t("box_type", 2);
                                        Unit unit = Unit.INSTANCE;
                                        currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel7 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonEvent2.onSecondBtnClick = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang.body.1.2.2.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        e eVar = new e();
                                        BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel8 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                        eVar.v("box_id", blindBoxProductDetailBottomBarForYiFanShangViewModel8.boxId);
                                        eVar.v("spu_id", blindBoxProductDetailBottomBarForYiFanShangViewModel8.spuId);
                                        eVar.v("group_id", blindBoxProductDetailBottomBarForYiFanShangViewModel8.groupId);
                                        eVar.t("click_area", 3);
                                        eVar.t("box_type", 2);
                                        Unit unit = Unit.INSTANCE;
                                        currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
                                        return Unit.INSTANCE;
                                    }
                                };
                                final BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel8 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                yiFanShangDetailBottomButtonEvent2.onThirdBtnClick = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShang.body.1.2.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                        e eVar = new e();
                                        BlindBoxProductDetailBottomBarForYiFanShangViewModel blindBoxProductDetailBottomBarForYiFanShangViewModel9 = BlindBoxProductDetailBottomBarForYiFanShangViewModel.this;
                                        eVar.v("box_id", blindBoxProductDetailBottomBarForYiFanShangViewModel9.boxId);
                                        eVar.v("spu_id", blindBoxProductDetailBottomBarForYiFanShangViewModel9.spuId);
                                        eVar.v("group_id", blindBoxProductDetailBottomBarForYiFanShangViewModel9.groupId);
                                        eVar.t("click_area", 5);
                                        eVar.t("box_type", 2);
                                        Unit unit = Unit.INSTANCE;
                                        currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailPendantAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ProductDetailEvent();
    }
}
