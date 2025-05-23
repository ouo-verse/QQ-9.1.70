package com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.SSORequestModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes33.dex */
public final class EntrancePage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(EntrancePage.class, "showAgreePanel", "getShowAgreePanel()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(EntrancePage.class, "isRequesting", "isRequesting()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(EntrancePage.class, VideoTemplateParser.ITEM_LIST, "getItemList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty isRequesting$delegate;
    public final ReadWriteProperty itemList$delegate;
    public final ReadWriteProperty showAgreePanel$delegate;

    /* loaded from: classes33.dex */
    public static final class Companion {
        public final void doReport(String str) {
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("bus_id", 2);
            Unit unit = Unit.INSTANCE;
            currentBridgeModule.reportDT(str, m3);
        }
    }

    public EntrancePage() {
        Boolean bool = Boolean.TRUE;
        this.showAgreePanel$delegate = c.a(bool);
        this.isRequesting$delegate = c.a(bool);
        this.itemList$delegate = c.b();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        ArrayList arrayList = new ArrayList();
        e n3 = getPager().getPageData().n();
        if (Intrinsics.areEqual(n3.p("show_order"), "1")) {
            arrayList.add(new EntranceItem("qecommerce_skin_icon_general_order_primary", "\u6211\u7684\u8ba2\u5355", "mqqapi://ecommerce/open?target=2&channel=2&src_type=internal&version=1", 24));
        }
        if (Intrinsics.areEqual(n3.p("show_coupon"), "1")) {
            arrayList.add(new EntranceItem("qecommerce_skin_icon_general_coupon_primary", "\u6211\u7684\u4f18\u60e0\u5238", "mqqapi://ecommerce/open?target=52&page_name=my_coupon_list&channel=2&src_type=internal&version=1", 24));
        }
        if (Intrinsics.areEqual(n3.p("show_polar_mystery"), "1")) {
            arrayList.add(new EntranceItem("qecommerce_skin_icon_general_jiguangmanghe_primary", "\u6781\u5149\u76f2\u76d2", "mqqapi://ecommerce/open?src_type=internal&version=1&target=52&channel=2&page_name=blind_box_home&channel=2&source=4&hr_background_image_base64=bGluZWFyLWdyYWRpZW50KDEsNDI4MTc2NTg4NyAwLDQyODMwMjk5OTcgMC4zMyw0Mjg1NzAzNjc5IDAuNjYsNDI4NDkzNDkxMSAxKQ==", 24));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            getItemList().add((EntranceItem) it.next());
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.justifyContentFlexEnd();
                        return Unit.INSTANCE;
                    }
                });
                final EntrancePage entrancePage = EntrancePage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        EntrancePage entrancePage2 = EntrancePage.this;
                        return Boolean.valueOf(((Boolean) entrancePage2.isRequesting$delegate.getValue(entrancePage2, EntrancePage.$$delegatedProperties[1])).booleanValue());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ECLoadingViewKt.ECLoading(conditionView, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                        eCLoadingAttr.delayShow = true;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final EntrancePage entrancePage2 = EntrancePage.this;
                ECTransitionViewKt.TransitionFadeInOutView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final EntrancePage entrancePage3 = EntrancePage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                EntrancePage entrancePage4 = EntrancePage.this;
                                eCTransitionAttr2.setTransitionAppear(((Boolean) entrancePage4.showAgreePanel$delegate.getValue(entrancePage4, EntrancePage.$$delegatedProperties[0])).booleanValue());
                                eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                final ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(ECTransitionEvent.this), null, null, 3);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final EntrancePage entrancePage4 = EntrancePage.this;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        tVar2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final EntrancePage entrancePage5 = EntrancePage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final EntrancePage entrancePage6 = EntrancePage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.4.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                EntrancePage entrancePage7 = EntrancePage.this;
                                                entrancePage7.showAgreePanel$delegate.setValue(entrancePage7, EntrancePage.$$delegatedProperties[0], Boolean.FALSE);
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
                final EntrancePage entrancePage3 = EntrancePage.this;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$body$2.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final EntrancePage entrancePage4 = EntrancePage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                EntrancePage entrancePage5 = EntrancePage.this;
                                eCTransitionAttr.setTransitionAppear(((Boolean) entrancePage5.showAgreePanel$delegate.getValue(entrancePage5, EntrancePage.$$delegatedProperties[0])).booleanValue());
                                return Unit.INSTANCE;
                            }
                        });
                        final EntrancePage entrancePage5 = EntrancePage.this;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m137borderRadius(new f(16.0f, 16.0f, 0.0f, 0.0f));
                                        tVar2.flexDirection(FlexDirection.COLUMN);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final EntrancePage entrancePage6 = EntrancePage.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final EntrancePage entrancePage7 = EntrancePage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                EntrancePage entrancePage8 = EntrancePage.this;
                                                entrancePage8.showAgreePanel$delegate.setValue(entrancePage8, EntrancePage.$$delegatedProperties[0], Boolean.FALSE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final EntrancePage entrancePage7 = EntrancePage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.paddingTop(10.0f);
                                                tVar2.paddingBottom(40.0f);
                                                tVar2.mo113backgroundColor(IPagerIdKtxKt.getSkinColor(tVar2).getForegroundColor());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final EntrancePage entrancePage8 = EntrancePage.this;
                                        LoopDirectivesViewKt.a(vVar4, new Function0<com.tencent.kuikly.core.reactive.collection.c<EntranceItem>>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3.2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final com.tencent.kuikly.core.reactive.collection.c<EntranceItem> invoke() {
                                                EntrancePage entrancePage9 = EntrancePage.this;
                                                EntrancePage.Companion companion = EntrancePage.Companion;
                                                return entrancePage9.getItemList();
                                            }
                                        }, new Function2<LoopDirectivesView<EntranceItem>, EntranceItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3.3
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Unit invoke(LoopDirectivesView<EntranceItem> loopDirectivesView, EntranceItem entranceItem) {
                                                final EntranceItem entranceItem2 = entranceItem;
                                                loopDirectivesView.addChild(new EntranceItemView(), new Function1<EntranceItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(EntranceItemView entranceItemView) {
                                                        final EntranceItem entranceItem3 = EntranceItem.this;
                                                        entranceItemView.attr(new Function1<EntranceItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage.body.2.5.2.3.3.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(EntranceItemViewAttr entranceItemViewAttr) {
                                                                entranceItemViewAttr.itemData = EntranceItem.this;
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        Companion.doReport("ds_shopping_entry_clk");
        new SSORequestModel() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$created$reqModel$1
            @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
            public final String cmd() {
                return "trpc.ecom.window_info_svr.WindowInfoSvr/GetMyShopping";
            }

            @Override // com.tencent.hippykotlin.demo.pages.base.SSORequestModel
            public final e reqParam() {
                e eVar = new e();
                eVar.t("scene", 0);
                eVar.t("req_source", 2);
                return eVar;
            }
        }.requestData(new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntrancePage$created$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar, Integer num, String str) {
                Object d16;
                boolean contains$default;
                boolean contains$default2;
                boolean contains$default3;
                boolean contains$default4;
                e eVar2 = eVar;
                int intValue = num.intValue();
                EntrancePage entrancePage = EntrancePage.this;
                entrancePage.isRequesting$delegate.setValue(entrancePage, EntrancePage.$$delegatedProperties[1], Boolean.FALSE);
                Utils.INSTANCE.currentBridgeModule().log("EntrancePage" + intValue + str + eVar2);
                if (intValue == 0) {
                    ArrayList arrayList = new ArrayList();
                    b l3 = eVar2.l("my_shopping_infos");
                    if (l3 != null) {
                        EntrancePage entrancePage2 = EntrancePage.this;
                        int c16 = l3.c();
                        for (int i3 = 0; i3 < c16; i3++) {
                            if (BooleanCompanionObject.INSTANCE instanceof e) {
                                d16 = Boolean.valueOf(l3.e(i3));
                            } else if (IntCompanionObject.INSTANCE instanceof e) {
                                d16 = Integer.valueOf(l3.i(i3));
                            } else if (LongCompanionObject.INSTANCE instanceof e) {
                                d16 = Long.valueOf(l3.m(i3));
                            } else if (StringCompanionObject.INSTANCE instanceof e) {
                                d16 = l3.o(i3);
                            } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                                d16 = Double.valueOf(l3.g(i3));
                            } else {
                                d16 = l3.d(i3);
                            }
                            if (d16 != null) {
                                e eVar3 = (e) d16;
                                String p16 = eVar3.p("name");
                                String p17 = eVar3.p("icon");
                                String p18 = eVar3.p("url");
                                String p19 = eVar3.p("default_icon");
                                String p26 = eVar3.p("dark_icon");
                                EntranceItem entranceItem = new EntranceItem(p17, p16, p18, p19, p26);
                                if (((String) entranceItem.iconSrc$delegate.getValue(entranceItem, EntranceItem.$$delegatedProperties[0])).length() == 0) {
                                    if (!PageDataExtKt.isNightMode(entrancePage2.getPageData())) {
                                        p26 = p19;
                                    }
                                    entranceItem.setIconSrc(p26);
                                }
                                arrayList.add(entranceItem);
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) p16, (CharSequence) "\u6211\u7684\u8ba2\u5355", false, 2, (Object) null);
                                if (contains$default) {
                                    EntrancePage.Companion.doReport("ds_order_entry_exp");
                                }
                                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) p16, (CharSequence) "\u6211\u7684\u4f18\u60e0\u5238", false, 2, (Object) null);
                                if (contains$default2) {
                                    EntrancePage.Companion.doReport("ds_coupon_entry_exp");
                                }
                                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) p16, (CharSequence) "\u79ef\u5206\u5546\u57ce", false, 2, (Object) null);
                                if (contains$default3) {
                                    EntrancePage.Companion.doReport("ds_jifen_entry_exp");
                                }
                                contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) p16, (CharSequence) "\u6781\u5149\u76f2\u76d2", false, 2, (Object) null);
                                if (contains$default4) {
                                    EntrancePage.Companion.doReport("blindbox_entry_exp");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        EntrancePage.this.getItemList().clear();
                        EntrancePage.this.getItemList().addAll(arrayList);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final com.tencent.kuikly.core.reactive.collection.c<EntranceItem> getItemList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.itemList$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void themeDidChanged(e eVar) {
        String str;
        super.themeDidChanged(eVar);
        boolean g16 = eVar.g(MiniGamePAHippyBaseFragment.KEY_THEME, false);
        Iterator<EntranceItem> it = getItemList().iterator();
        while (it.hasNext()) {
            EntranceItem next = it.next();
            if (!(next.icon.length() > 0)) {
                if (g16) {
                    str = next.darkIcon;
                } else {
                    str = next.defaultIcon;
                }
                next.setIconSrc(str);
            }
        }
    }
}
