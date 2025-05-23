package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.ktx.LocalConfigurationExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletPageRouterModule;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.WalletPageRouterParam;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.WalletPageRouterResult;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailViewModel;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailRsp;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailStartupData;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbReceiver;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.lifecycle.common.Lifecycle;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.c;
import com.tencent.ntcompose.lifecycle.viewmodel.compose.a;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class HbDetailLayoutKt {
    public static final void HbDetailLayout(final HbDetailViewModel hbDetailViewModel, Composer composer, final int i3, final int i16) {
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(-1637735328);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
            } else if (i17 != 0) {
                HbDetailLayoutKt$HbDetailLayout$1 hbDetailLayoutKt$HbDetailLayout$1 = new Function1<b, HbDetailViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$1
                    @Override // kotlin.jvm.functions.Function1
                    public final HbDetailViewModel invoke(b bVar2) {
                        return new HbDetailViewModel();
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HbDetailViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(HbDetailViewModel.class), hbDetailLayoutKt$HbDetailLayout$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof c) {
                        bVar = ((c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = a.c(orCreateKotlinClass, kVar, "VM_HB_DETAIL", b16, bVar, startRestartGroup, 33160, 0);
                    startRestartGroup.endReplaceableGroup();
                    hbDetailViewModel = (HbDetailViewModel) c16;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1637735328, i3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayout (HbDetailLayout.kt:42)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                if (QUIToken.INSTANCE.isNightMode()) {
                    rememberedValue = new h(4279900698L);
                } else {
                    rememberedValue = new h(4294967295L);
                }
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            h hVar = (h) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                if (QUIToken.INSTANCE.isNightMode()) {
                    rememberedValue2 = new h(4278190080L);
                } else {
                    rememberedValue2 = new h(4294506744L);
                }
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            final h hVar2 = (h) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = Float.valueOf(com.tencent.kuikly.core.pager.h.a().getPageData().m() * 1.169f);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            final float floatValue = ((Number) rememberedValue3).floatValue();
            final float qqNavigationBarHeight = LocalConfigurationExtKt.getQqNavigationBarHeight((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())) + 50.0f;
            final float f16 = floatValue - qqNavigationBarHeight;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = GuideBannerCardAnimationViewKt$$ExternalSyntheticOutline0.m(0.0f, null, 2, null, startRestartGroup);
            }
            startRestartGroup.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue4;
            a.b(hbDetailViewModel, ((com.tencent.ntcompose.lifecycle.common.c) startRestartGroup.consume(CompositionLocalsKt.e())).getLifecycle(), startRestartGroup, (Lifecycle.f339325a << 3) | 8);
            final HbDetailViewModel hbDetailViewModel2 = hbDetailViewModel;
            BoxKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), hVar), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 622036506, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(622036506, intValue, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayout.<anonymous> (HbDetailLayout.kt:76)");
                        }
                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                        ImageKt.a("https://kuikly.qianbao.qq.com/hb/detail//qwallet_hb_top_default_bg.png", null, null, null, null, ModifiersKt.T(ModifiersKt.r(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), floatValue), 0.0f, -f16, 1, null), false), 5), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 12845062, 0, 0, 2096990);
                        final HbDetailViewModel hbDetailViewModel3 = hbDetailViewModel2;
                        HbDetailNavBarKt.HbDetailNavBar(null, "QQ\u7ea2\u5305", "\u7ea2\u5305\u8bb0\u5f55", null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                QWalletPageRouterModule qWalletPageRouterModule = (QWalletPageRouterModule) com.tencent.kuikly.core.pager.h.a().acquireModule("QWalletPageRouterModule");
                                HbDetailStartupData value = HbDetailViewModel.this.startupData.getValue();
                                String str = value != null ? value.groupId : null;
                                final HbDetailViewModel hbDetailViewModel4 = HbDetailViewModel.this;
                                final Function1<WalletPageRouterResult, Unit> function1 = new Function1<WalletPageRouterResult, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt.HbDetailLayout.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(WalletPageRouterResult walletPageRouterResult) {
                                        QWLog qWLog = QWLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("start redgiftRecord: ");
                                        HbDetailStartupData value2 = HbDetailViewModel.this.startupData.getValue();
                                        m3.append(value2 != null ? value2.groupId : null);
                                        qWLog.i("", m3.toString(), false);
                                        return Unit.INSTANCE;
                                    }
                                };
                                qWalletPageRouterModule.getClass();
                                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                if (str != null) {
                                    eVar2.v(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str);
                                }
                                final WalletPageRouterParam walletPageRouterParam = new WalletPageRouterParam(eVar2);
                                QWLog.INSTANCE.i("QWalletPageRouterModule", "openTenpayView Options: " + walletPageRouterParam, true);
                                qWalletPageRouterModule.callNativeMethod(TenpayPlugin.PLUGIN_NAME, walletPageRouterParam.toJSONObject(), new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletPageRouterModule$openTenpayView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar3) {
                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = eVar3;
                                        QWLog qWLog = QWLog.INSTANCE;
                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("openTenpayView Result: ");
                                        m3.append(WalletPageRouterParam.this.viewTag);
                                        m3.append(TokenParser.SP);
                                        m3.append(eVar4);
                                        QWLog.INSTANCE.i("QWalletPageRouterModule", m3.toString(), false);
                                        function1.invoke(new WalletPageRouterResult(eVar4 != null ? Integer.valueOf(eVar4.j("retCode")) : null, eVar4 != null ? eVar4.p("retMsg") : null, eVar4 != null ? eVar4.m("data") : null));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }, false, 0.0f, composer3, 432, 105);
                        com.tencent.ntcompose.core.i f17 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(companion2, 0.0f, 1, null), 0.0f, 1, null);
                        BorderStyle borderStyle = BorderStyle.SOLID;
                        com.tencent.ntcompose.core.i T = ModifiersKt.T(ComposeLayoutPropUpdaterKt.s(ModifiersKt.o(ModifiersKt.i(f17, new com.tencent.kuikly.core.base.e(16.0f, borderStyle, hVar2)), new com.tencent.kuikly.core.base.e(16.0f, borderStyle, hVar2)), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), 4);
                        final float f18 = qqNavigationBarHeight;
                        final HbDetailViewModel hbDetailViewModel4 = hbDetailViewModel2;
                        final float f19 = f16;
                        final MutableState<Float> mutableState2 = mutableState;
                        BoxKt.a(T, null, null, ComposableLambdaKt.composableLambda(composer3, 1094906452, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar3, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1094906452, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayout.<anonymous>.<anonymous> (HbDetailLayout.kt:115)");
                                    }
                                    com.tencent.ntcompose.core.i r16 = ComposeLayoutPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 16.0f, f18, 16.0f, 16.0f);
                                    d dVar = hbDetailViewModel4.listViewState;
                                    Boolean bool = Boolean.TRUE;
                                    Boolean bool2 = Boolean.FALSE;
                                    Float valueOf = Float.valueOf(f19);
                                    Object valueOf2 = Float.valueOf(f19);
                                    final MutableState<Float> mutableState3 = mutableState2;
                                    final float f26 = f19;
                                    composer5.startReplaceableGroup(511388516);
                                    boolean changed = composer5.changed(valueOf2) | composer5.changed(mutableState3);
                                    Object rememberedValue5 = composer5.rememberedValue();
                                    if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$2$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ScrollParams scrollParams) {
                                                ScrollParams scrollParams2 = scrollParams;
                                                if (scrollParams2.getOffsetY() < 0.0f && scrollParams2.getOffsetY() > (-f26)) {
                                                    mutableState3.setValue(Float.valueOf(scrollParams2.getOffsetY()));
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer5.updateRememberedValue(rememberedValue5);
                                    }
                                    composer5.endReplaceableGroup();
                                    final HbDetailViewModel hbDetailViewModel5 = hbDetailViewModel4;
                                    LazyColumnKt.a(r16, null, dVar, null, null, null, bool, bool2, null, null, null, 0, null, null, valueOf, null, (Function1) rememberedValue5, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 709204281, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt.HbDetailLayout.2.2.2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer6, Integer num3) {
                                            com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(709204281, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayout.<anonymous>.<anonymous>.<anonymous> (HbDetailLayout.kt:131)");
                                            }
                                            HbDetailViewModel hbDetailViewModel6 = HbDetailViewModel.this;
                                            composer7.startReplaceableGroup(-960128239);
                                            composer7.startMovableGroup(985617388, null);
                                            HbDetailHeaderItemKt.HbDetailHeaderItem(hbDetailViewModel6, composer7, 8);
                                            composer7.endMovableGroup();
                                            composer7.endReplaceableGroup();
                                            final HbDetailViewModel hbDetailViewModel7 = HbDetailViewModel.this;
                                            LazyDslKt.c(aVar2, hbDetailViewModel7.receiverList, null, ComposableLambdaKt.composableLambda(composer7, -196933485, true, new Function4<Integer, HbReceiver, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt.HbDetailLayout.2.2.2.2
                                                {
                                                    super(4);
                                                }

                                                /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
                                                /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
                                                /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
                                                @Override // kotlin.jvm.functions.Function4
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Unit invoke(Integer num4, HbReceiver hbReceiver, Composer composer8, Integer num5) {
                                                    int i19;
                                                    int i26;
                                                    int intValue4 = num4.intValue();
                                                    HbReceiver hbReceiver2 = hbReceiver;
                                                    Composer composer9 = composer8;
                                                    int intValue5 = num5.intValue();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-196933485, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HbDetailLayout.kt:137)");
                                                    }
                                                    if (HbDetailViewModel.this.receiverList.size() == 1) {
                                                        i19 = 4;
                                                    } else if (intValue4 != 0) {
                                                        i19 = intValue4 == HbDetailViewModel.this.receiverList.size() - 1 ? 3 : 2;
                                                    } else {
                                                        i26 = 1;
                                                        HbDetailRsp value = HbDetailViewModel.this.hbDetailRsp.getValue();
                                                        HbDetailReceiverItemKt.HbDetailReceiverItem(hbReceiver2, value == null ? value.sender : null, HbDetailViewModel.this.startupData.getValue(), i26, composer9, 72);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                    i26 = i19;
                                                    HbDetailRsp value2 = HbDetailViewModel.this.hbDetailRsp.getValue();
                                                    HbDetailReceiverItemKt.HbDetailReceiverItem(hbReceiver2, value2 == null ? value2.sender : null, HbDetailViewModel.this.startupData.getValue(), i26, composer9, 72);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3080, 2);
                                            if (HbDetailViewModel.this.hasMoreData.getValue().booleanValue()) {
                                                com.tencent.ntcompose.core.i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("fill_light_primary"));
                                                final HbDetailViewModel hbDetailViewModel8 = HbDetailViewModel.this;
                                                HbDetailFooterRefreshKt.HbDetailFooterRefresh(d16, 1000.0f, new Function1<Function2<? super Boolean, ? super Boolean, ? extends Unit>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt.HbDetailLayout.2.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Function2<? super Boolean, ? super Boolean, ? extends Unit> function2) {
                                                        HbDetailViewModel hbDetailViewModel9 = HbDetailViewModel.this;
                                                        hbDetailViewModel9.getClass();
                                                        QWLog qWLog = QWLog.INSTANCE;
                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("loadMore: offset=");
                                                        m3.append(hbDetailViewModel9.receiverList.size());
                                                        QWLog.INSTANCE.i("HbDetailViewModel", m3.toString(), false);
                                                        hbDetailViewModel9.requestData(hbDetailViewModel9.receiverList.size(), function2);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer7, 56, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 14155784, 0, MsgConstant.KRMFILETHUMBSIZE384, 4112186);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.view.HbDetailLayoutKt$HbDetailLayout$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HbDetailLayoutKt.HbDetailLayout(HbDetailViewModel.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
