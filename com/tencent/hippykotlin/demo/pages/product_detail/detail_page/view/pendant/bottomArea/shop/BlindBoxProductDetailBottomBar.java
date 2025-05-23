package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBar;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarAttr;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarEvent;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.IProductDetailPendantViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailEvent;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.shell.ProductDetailPendantAttr;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailBottomBar extends ComposeView<ProductDetailPendantAttr, ProductDetailEvent> {
    public static final Companion Companion = new Companion();
    public static final Lazy<Float> bottomBarHeight$delegate;

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final float getBottomBarHeight() {
            return BlindBoxProductDetailBottomBar.bottomBarHeight$delegate.getValue().floatValue();
        }
    }

    static {
        Lazy<Float> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Float>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar$Companion$bottomBarHeight$2
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                BlindBoxProductDetailBottomBar.Companion companion = BlindBoxProductDetailBottomBar.Companion;
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
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarViewModel");
        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel = (BlindBoxProductDetailBottomBarViewModel) viewModel;
        blindBoxProductDetailBottomBarViewModel.width = pageData.m();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel2 = BlindBoxProductDetailBottomBarViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(BlindBoxProductDetailBottomBarViewModel.this.height);
                        mVar2.mo153width(BlindBoxProductDetailBottomBarViewModel.this.width);
                        Attr.absolutePosition$default(mVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                        return Unit.INSTANCE;
                    }
                });
                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel3 = BlindBoxProductDetailBottomBarViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel4 = BlindBoxProductDetailBottomBarViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(BlindBoxProductDetailBottomBarViewModel.this.height);
                                tVar2.mo153width(BlindBoxProductDetailBottomBarViewModel.this.width);
                                tVar2.borderRadius(16.0f, 16.0f, 0.0f, 0.0f);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(4292474623L), 0.0f), new j(new h(3858759679L), 1.0f));
                                return Unit.INSTANCE;
                            }
                        });
                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel5 = BlindBoxProductDetailBottomBarViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel6 = BlindBoxProductDetailBottomBarViewModel.this;
                                return Boolean.valueOf(((Boolean) blindBoxProductDetailBottomBarViewModel6.showBlindBoxInfo$delegate.getValue(blindBoxProductDetailBottomBarViewModel6, BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties[14])).booleanValue());
                            }
                        };
                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel6 = BlindBoxProductDetailBottomBarViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel7 = BlindBoxProductDetailBottomBarViewModel.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel8 = BlindBoxProductDetailBottomBarViewModel.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(32.0f);
                                                tVar2.mo153width(BlindBoxProductDetailBottomBarViewModel.this.width);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.marginTop(12.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel9 = BlindBoxProductDetailBottomBarViewModel.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel10 = BlindBoxProductDetailBottomBarViewModel.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.marginLeft(16.0f);
                                                        afVar2.mo153width(45.0f);
                                                        afVar2.mo141height(32.0f);
                                                        afVar2.o();
                                                        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel11 = BlindBoxProductDetailBottomBarViewModel.this;
                                                        b.a.b(afVar2, (String) blindBoxProductDetailBottomBarViewModel11.blindBoxCoverUrl$delegate.getValue(blindBoxProductDetailBottomBarViewModel11, BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties[15]), false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel10 = BlindBoxProductDetailBottomBarViewModel.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel11 = BlindBoxProductDetailBottomBarViewModel.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.3.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel12 = BlindBoxProductDetailBottomBarViewModel.this;
                                                        ceVar2.text((String) blindBoxProductDetailBottomBarViewModel12.blindBoxTitle$delegate.getValue(blindBoxProductDetailBottomBarViewModel12, BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties[16]));
                                                        ceVar2.m140flex(1.0f);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        ceVar2.marginLeft(16.0f);
                                                        ceVar2.marginRight(30.0f);
                                                        ceVar2.color(new h(4281884306L));
                                                        ceVar2.lines(1);
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
                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel7 = BlindBoxProductDetailBottomBarViewModel.this;
                        vVar2.addChild(new BlindBoxOperationBottomBar(), new Function1<BlindBoxOperationBottomBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BlindBoxOperationBottomBar blindBoxOperationBottomBar) {
                                BlindBoxOperationBottomBar blindBoxOperationBottomBar2 = blindBoxOperationBottomBar;
                                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel8 = BlindBoxProductDetailBottomBarViewModel.this;
                                blindBoxOperationBottomBar2.attr(new Function1<BlindBoxOperationBottomBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BlindBoxOperationBottomBarAttr blindBoxOperationBottomBarAttr) {
                                        BlindBoxOperationBottomBarAttr blindBoxOperationBottomBarAttr2 = blindBoxOperationBottomBarAttr;
                                        blindBoxOperationBottomBarAttr2.marginTop(FloatExtKt.getTo375(12.0f));
                                        BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton = blindBoxOperationBottomBarAttr2.assistButton;
                                        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel9 = BlindBoxProductDetailBottomBarViewModel.this;
                                        ReadWriteProperty readWriteProperty = blindBoxProductDetailBottomBarViewModel9.assistButtonEnable$delegate;
                                        KProperty<?>[] kPropertyArr = BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties;
                                        blindBoxOperationBottomBarButton.enable = ((Boolean) readWriteProperty.getValue(blindBoxProductDetailBottomBarViewModel9, kPropertyArr[0])).booleanValue();
                                        BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton2 = blindBoxOperationBottomBarAttr2.assistButton;
                                        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel10 = BlindBoxProductDetailBottomBarViewModel.this;
                                        blindBoxOperationBottomBarButton2.text = (String) blindBoxProductDetailBottomBarViewModel10.assistButtonText$delegate.getValue(blindBoxProductDetailBottomBarViewModel10, kPropertyArr[1]);
                                        BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton3 = blindBoxOperationBottomBarAttr2.firstLotteryButton;
                                        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel11 = BlindBoxProductDetailBottomBarViewModel.this;
                                        int intValue = ((Number) blindBoxProductDetailBottomBarViewModel11.firstLotteryButtonType$delegate.getValue(blindBoxProductDetailBottomBarViewModel11, kPropertyArr[3])).intValue();
                                        for (int i3 : BoxType$EnumUnboxingSharedUtility.values(4)) {
                                            if (BoxType$EnumUnboxingSharedUtility.ordinal(i3) == intValue) {
                                                blindBoxOperationBottomBarButton3.type = i3;
                                                BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton4 = blindBoxOperationBottomBarAttr2.firstLotteryButton;
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel12 = BlindBoxProductDetailBottomBarViewModel.this;
                                                blindBoxOperationBottomBarButton4.enable = ((Boolean) blindBoxProductDetailBottomBarViewModel12.firstLotteryButtonEnable$delegate.getValue(blindBoxProductDetailBottomBarViewModel12, kPropertyArr[4])).booleanValue();
                                                BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton5 = blindBoxOperationBottomBarAttr2.firstLotteryButton;
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel13 = BlindBoxProductDetailBottomBarViewModel.this;
                                                blindBoxOperationBottomBarButton5.text = (String) blindBoxProductDetailBottomBarViewModel13.firstLotteryButtonText$delegate.getValue(blindBoxProductDetailBottomBarViewModel13, kPropertyArr[5]);
                                                BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton6 = blindBoxOperationBottomBarAttr2.firstLotteryButton;
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel14 = BlindBoxProductDetailBottomBarViewModel.this;
                                                blindBoxOperationBottomBarButton6.price = (String) blindBoxProductDetailBottomBarViewModel14.firstLotteryButtonPrice$delegate.getValue(blindBoxProductDetailBottomBarViewModel14, kPropertyArr[6]);
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel15 = BlindBoxProductDetailBottomBarViewModel.this;
                                                if (((Boolean) blindBoxProductDetailBottomBarViewModel15.containsTwoLotteryButton$delegate.getValue(blindBoxProductDetailBottomBarViewModel15, kPropertyArr[13])).booleanValue()) {
                                                    BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton7 = new BlindBoxOperationBottomBarButton(0, 31);
                                                    blindBoxOperationBottomBarAttr2.secondLotteryButton = blindBoxOperationBottomBarButton7;
                                                    Intrinsics.checkNotNull(blindBoxOperationBottomBarButton7);
                                                    BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel16 = BlindBoxProductDetailBottomBarViewModel.this;
                                                    int intValue2 = ((Number) blindBoxProductDetailBottomBarViewModel16.secondLotteryButtonType$delegate.getValue(blindBoxProductDetailBottomBarViewModel16, kPropertyArr[8])).intValue();
                                                    for (int i16 : BoxType$EnumUnboxingSharedUtility.values(4)) {
                                                        if (BoxType$EnumUnboxingSharedUtility.ordinal(i16) == intValue2) {
                                                            blindBoxOperationBottomBarButton7.type = i16;
                                                            BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton8 = blindBoxOperationBottomBarAttr2.secondLotteryButton;
                                                            Intrinsics.checkNotNull(blindBoxOperationBottomBarButton8);
                                                            BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel17 = BlindBoxProductDetailBottomBarViewModel.this;
                                                            blindBoxOperationBottomBarButton8.enable = ((Boolean) blindBoxProductDetailBottomBarViewModel17.secondLotteryButtonEnable$delegate.getValue(blindBoxProductDetailBottomBarViewModel17, kPropertyArr[9])).booleanValue();
                                                            BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton9 = blindBoxOperationBottomBarAttr2.secondLotteryButton;
                                                            Intrinsics.checkNotNull(blindBoxOperationBottomBarButton9);
                                                            BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel18 = BlindBoxProductDetailBottomBarViewModel.this;
                                                            blindBoxOperationBottomBarButton9.text = (String) blindBoxProductDetailBottomBarViewModel18.secondLotteryButtonText$delegate.getValue(blindBoxProductDetailBottomBarViewModel18, kPropertyArr[10]);
                                                            BlindBoxOperationBottomBarButton blindBoxOperationBottomBarButton10 = blindBoxOperationBottomBarAttr2.secondLotteryButton;
                                                            Intrinsics.checkNotNull(blindBoxOperationBottomBarButton10);
                                                            BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel19 = BlindBoxProductDetailBottomBarViewModel.this;
                                                            blindBoxOperationBottomBarButton10.price = (String) blindBoxProductDetailBottomBarViewModel19.secondLotteryButtonPrice$delegate.getValue(blindBoxProductDetailBottomBarViewModel19, kPropertyArr[11]);
                                                        }
                                                    }
                                                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        throw new NoSuchElementException("Array contains no element matching the predicate.");
                                    }
                                });
                                final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel9 = BlindBoxProductDetailBottomBarViewModel.this;
                                blindBoxOperationBottomBar2.event(new Function1<BlindBoxOperationBottomBarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BlindBoxOperationBottomBarEvent blindBoxOperationBottomBarEvent) {
                                        final BlindBoxOperationBottomBarEvent blindBoxOperationBottomBarEvent2 = blindBoxOperationBottomBarEvent;
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel10 = BlindBoxProductDetailBottomBarViewModel.this;
                                        blindBoxOperationBottomBarEvent2.register("onAssistButtonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Utils utils = Utils.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxAssistEntranceView did click with schema:");
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel11 = BlindBoxProductDetailBottomBarViewModel.this;
                                                ReadWriteProperty readWriteProperty = blindBoxProductDetailBottomBarViewModel11.assistButtonJumpUrl$delegate;
                                                KProperty<?>[] kPropertyArr = BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties;
                                                m3.append((String) readWriteProperty.getValue(blindBoxProductDetailBottomBarViewModel11, kPropertyArr[2]));
                                                utils.logToNative(m3.toString());
                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(blindBoxOperationBottomBarEvent2);
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel12 = BlindBoxProductDetailBottomBarViewModel.this;
                                                BridgeModule.openPage$default(bridgeModule, (String) blindBoxProductDetailBottomBarViewModel12.assistButtonJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarViewModel12, kPropertyArr[2]), false, null, null, 30);
                                                BridgeModule currentBridgeModule = utils.currentBridgeModule();
                                                e eVar = new e();
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel13 = BlindBoxProductDetailBottomBarViewModel.this;
                                                eVar.v("box_id", blindBoxProductDetailBottomBarViewModel13.boxId);
                                                eVar.v("spu_id", blindBoxProductDetailBottomBarViewModel13.spuId);
                                                eVar.t("click_area", 1);
                                                Unit unit = Unit.INSTANCE;
                                                currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel11 = BlindBoxProductDetailBottomBarViewModel.this;
                                        blindBoxOperationBottomBarEvent2.register("onFirstLotteryButtonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Utils utils = Utils.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxProductDetailBottomBar onLotteryClick with schema:");
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel12 = BlindBoxProductDetailBottomBarViewModel.this;
                                                ReadWriteProperty readWriteProperty = blindBoxProductDetailBottomBarViewModel12.firstLotteryButtonJumpUrl$delegate;
                                                KProperty<?>[] kPropertyArr = BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties;
                                                m3.append((String) readWriteProperty.getValue(blindBoxProductDetailBottomBarViewModel12, kPropertyArr[7]));
                                                utils.logToNative(m3.toString());
                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(blindBoxOperationBottomBarEvent2);
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel13 = BlindBoxProductDetailBottomBarViewModel.this;
                                                BridgeModule.openPage$default(bridgeModule, (String) blindBoxProductDetailBottomBarViewModel13.firstLotteryButtonJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarViewModel13, kPropertyArr[7]), false, null, null, 30);
                                                BridgeModule currentBridgeModule = utils.currentBridgeModule();
                                                e eVar = new e();
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel14 = BlindBoxProductDetailBottomBarViewModel.this;
                                                eVar.v("box_id", blindBoxProductDetailBottomBarViewModel14.boxId);
                                                eVar.v("spu_id", blindBoxProductDetailBottomBarViewModel14.spuId);
                                                eVar.t("click_area", ((Number) blindBoxProductDetailBottomBarViewModel14.firstLotteryButtonType$delegate.getValue(blindBoxProductDetailBottomBarViewModel14, kPropertyArr[3])).intValue());
                                                Unit unit = Unit.INSTANCE;
                                                currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel12 = BlindBoxProductDetailBottomBarViewModel.this;
                                        blindBoxOperationBottomBarEvent2.register("onSecondLotteryButtonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBar.body.1.2.4.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                Utils utils = Utils.INSTANCE;
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("BlindBoxProductDetailBottomBar onLotteryClick with schema:");
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel13 = BlindBoxProductDetailBottomBarViewModel.this;
                                                ReadWriteProperty readWriteProperty = blindBoxProductDetailBottomBarViewModel13.secondLotteryButtonJumpUrl$delegate;
                                                KProperty<?>[] kPropertyArr = BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties;
                                                m3.append((String) readWriteProperty.getValue(blindBoxProductDetailBottomBarViewModel13, kPropertyArr[12]));
                                                utils.logToNative(m3.toString());
                                                BridgeModule bridgeModule = IPagerIdKtxKt.getBridgeModule(blindBoxOperationBottomBarEvent2);
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel14 = BlindBoxProductDetailBottomBarViewModel.this;
                                                BridgeModule.openPage$default(bridgeModule, (String) blindBoxProductDetailBottomBarViewModel14.secondLotteryButtonJumpUrl$delegate.getValue(blindBoxProductDetailBottomBarViewModel14, kPropertyArr[12]), false, null, null, 30);
                                                BridgeModule currentBridgeModule = utils.currentBridgeModule();
                                                e eVar = new e();
                                                BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel15 = BlindBoxProductDetailBottomBarViewModel.this;
                                                eVar.v("box_id", blindBoxProductDetailBottomBarViewModel15.boxId);
                                                eVar.v("spu_id", blindBoxProductDetailBottomBarViewModel15.spuId);
                                                eVar.t("click_area", ((Number) blindBoxProductDetailBottomBarViewModel15.secondLotteryButtonType$delegate.getValue(blindBoxProductDetailBottomBarViewModel15, kPropertyArr[8])).intValue());
                                                Unit unit = Unit.INSTANCE;
                                                currentBridgeModule.reportDT("blindbox_goodspage_click", eVar);
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ProductDetailPendantAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ProductDetailEvent();
    }
}
