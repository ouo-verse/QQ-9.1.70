package com.tencent.hippykotlin.demo.pages.qq_intimate_space;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.FilamentSceneMessageChannelModule;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.filament_scene.IntimateSpaceFilamentView;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$deleteFonts$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFontLoader$loadFonts$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.font.IntimateSpaceFonts;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageGuildKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageManualKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageShareKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageTreeFlowerCardKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallHomepageUpgradeCardKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallTreeUpgradeAnimationKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.GuildState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.ManualState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.SharePanelState;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.module.IntimateSpaceModule;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.module.IntimateSpaceModule$init$1;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.module.QZIntimateSpaceLoveTreeModule;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallHomepage extends BaseComponentActivity {
    public MutableState<LoveWallHomepageViewModel> viewModel;

    public LoveWallHomepage() {
        MutableState<LoveWallHomepageViewModel> mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewModel = mutableStateOf$default;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void composePageDidAppear() {
        IntimateSpaceFilamentView b16;
        super.composePageDidAppear();
        aa<IntimateSpaceFilamentView> aaVar = viewModel().filamentViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            b16.onResume();
        }
        final LoveWallHomepageViewModel viewModel = viewModel();
        viewModel.getClass();
        KLog.INSTANCE.i("LoveWallHomepage", "onViewDidAppear");
        if (viewModel.viewHasDisappear.getValue().booleanValue()) {
            viewModel.viewHasDisappear.setValue(Boolean.FALSE);
            viewModel.refreshUIWhenResume();
            TimerKt.c(2000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$onViewDidAppear$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    final LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                    loveWallHomepageViewModel.fetchWaterInfo(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel$onViewDidAppear$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                            TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel.onViewDidAppear.1.1.1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    LoveWallHomepageViewModel.this.fetchWaterInfo(null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void composePageDidDisappear() {
        IntimateSpaceFilamentView b16;
        super.composePageDidDisappear();
        aa<IntimateSpaceFilamentView> aaVar = viewModel().filamentViewRef;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            KLog.INSTANCE.i("IntimateSpaceFilamentView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            AbstractBaseView.callRenderViewMethod$default(b16, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null, null, 6, null);
        }
        LoveWallHomepageViewModel viewModel = viewModel();
        viewModel.getClass();
        KLog.INSTANCE.i("LoveWallHomepage", "onViewDidDisappear");
        viewModel.viewHasDisappear.setValue(Boolean.TRUE);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void composePageWillDestroy() {
        List listOf;
        super.composePageWillDestroy();
        ((QZIntimateSpaceLoveTreeModule) b.a().acquireModule("QZIntimateSpaceLoveTreeModule")).syncToNativeMethod("onExitLoveTree", (e) null, (Function1<? super e, Unit>) null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IntimateSpaceFonts[]{IntimateSpaceFonts.MF_YUAN_HEI, IntimateSpaceFonts.DIN_PRO_BOLD, IntimateSpaceFonts.MF_ZHUO_YING, IntimateSpaceFonts.DIN_PRO_MEDIUM});
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new IntimateSpaceFontLoader$deleteFonts$1(listOf, null), 3, null);
        LoveWallHomepageViewModel viewModel = viewModel();
        Timer timer = viewModel.treeBubbleTipsTimer;
        if (timer != null) {
            timer.e();
        }
        viewModel.treeBubbleTipsTimer = null;
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap != null) {
            mutableMap.put("FilamentSceneMessageChannelModule", new FilamentSceneMessageChannelModule());
        }
        if (mutableMap != null) {
            mutableMap.put("IntimateSpaceModule", new IntimateSpaceModule());
        }
        if (mutableMap != null) {
            mutableMap.put("QZIntimateSpaceLoveTreeModule", new QZIntimateSpaceLoveTreeModule());
        }
        return mutableMap;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        List listOf;
        super.onCreate(aVar);
        ((QZIntimateSpaceLoveTreeModule) b.a().acquireModule("QZIntimateSpaceLoveTreeModule")).syncToNativeMethod("onEnterLoveTree", (e) null, (Function1<? super e, Unit>) null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IntimateSpaceFonts[]{IntimateSpaceFonts.MF_YUAN_HEI, IntimateSpaceFonts.DIN_PRO_BOLD, IntimateSpaceFonts.MF_ZHUO_YING, IntimateSpaceFonts.DIN_PRO_MEDIUM});
        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new IntimateSpaceFontLoader$loadFonts$1(listOf, null), 3, null);
        IntimateSpaceModule intimateSpaceModule = (IntimateSpaceModule) b.a().acquireModule("IntimateSpaceModule");
        intimateSpaceModule.getClass();
        intimateSpaceModule.toNative(true, IECSearchBar.METHOD_SET_CALLBACK, null, new IntimateSpaceModule$init$1(intimateSpaceModule), true);
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage$addEventListeners$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                LoveWallHomepage.this.viewModel().refreshUIWhenResume();
                return Unit.INSTANCE;
            }
        };
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("addEventListener: ", "onMiniAIODismiss", KLog.INSTANCE, "IntimateSpaceModule");
        intimateSpaceModule.eventHandlerMap.put("onMiniAIODismiss", function1);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(2063313991, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage$onCreate$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2063313991, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage.onCreate.<anonymous> (LoveWallHomepage.kt:77)");
                    }
                    final LoveWallHomepageViewModel viewModel = LoveWallHomepage.this.viewModel();
                    BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(composer2, 1130117709, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1130117709, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage.onCreate.<anonymous>.<anonymous> (LoveWallHomepage.kt:80)");
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_AaXNv2lLZwg.png", null, null, null, null, null, null, null, null, null, null, composer4, 262144, 6, 0, 2096095);
                                if (LoveWallHomepageViewModel.this.guildState.getValue() != GuildState.REQUESTING && LoveWallHomepageViewModel.this.guildState.getValue() != GuildState.PLANTING_GUILD) {
                                    composer4.startReplaceableGroup(-1866186859);
                                    LoveWallHomepageKt.LoveWallHomepageContent(LoveWallHomepageViewModel.this, composer4, 8);
                                    composer4.endReplaceableGroup();
                                } else {
                                    composer4.startReplaceableGroup(-1866186739);
                                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                                    a.k h16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.h();
                                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                                    final LoveWallHomepageViewModel loveWallHomepageViewModel = LoveWallHomepageViewModel.this;
                                    ColumnKt.a(j3, h16, horizontal, null, ComposableLambdaKt.composableLambda(composer4, 94618600, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage.onCreate.1.1.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(d dVar, Composer composer5, Integer num3) {
                                            Composer composer6 = composer5;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(94618600, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage.onCreate.<anonymous>.<anonymous>.<anonymous> (LoveWallHomepage.kt:94)");
                                                }
                                                i.Companion companion2 = i.INSTANCE;
                                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, b.a().getPageData().getStatusBarHeight()), composer6, 8, 0);
                                                LoveWallNavigationBarKt.LoveWallNavigationBar(ComposeLayoutPropUpdaterKt.k(companion2, 44), LoveWallHomepageViewModel.this.guildState.getValue() != GuildState.PLANTING_GUILD, false, false, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.LoveWallHomepage.onCreate.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Mqq.INSTANCE.getUi().popBack();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, null, null, composer6, 28040, 96);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer4, 25032, 8);
                                    composer4.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    LoveWallHomepageGuildKt.LoveWallHomepageGuild(viewModel, composer2, 8);
                    LoveWallHomepageTreeFlowerCardKt.LoveWallHomepageTreeFlowerCard(viewModel, composer2, 8);
                    LoveWallHomepageUpgradeCardKt.LoveWallHomepageUpgradeCard(viewModel, composer2, 8);
                    LoveWallTreeUpgradeAnimationKt.LoveWallTreeUpgradeAnimation(viewModel, composer2, 8);
                    LoveWallHomepageManualKt.LoveWallHomepageManual(viewModel, composer2, 8);
                    LoveWallHomepageShareKt.LoveWallHomepageShare(viewModel, composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            ManualState value = viewModel().manualState.getValue();
            ManualState manualState = ManualState.NONE;
            if (value != manualState) {
                viewModel().manualState.setValue(manualState);
                return;
            }
            SharePanelState value2 = viewModel().sharePanelState.getValue();
            SharePanelState sharePanelState = SharePanelState.NONE;
            if (value2 != sharePanelState) {
                viewModel().sharePanelState.setValue(sharePanelState);
            } else {
                Mqq.INSTANCE.getUi().popBack();
            }
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY;
    }

    public final LoveWallHomepageViewModel viewModel() {
        if (this.viewModel.getValue() == null) {
            this.viewModel.setValue(new LoveWallHomepageViewModel(getPageData().n()));
        }
        LoveWallHomepageViewModel value = this.viewModel.getValue();
        Intrinsics.checkNotNull(value);
        return value;
    }
}
