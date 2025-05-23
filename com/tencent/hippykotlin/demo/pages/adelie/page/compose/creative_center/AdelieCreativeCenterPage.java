package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt;
import com.tencent.hippykotlin.demo.pages.base.view.QQRichTextView;
import com.tencent.hippykotlin.demo.pages.base.view.QQTextView;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIScanningLightKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.f;
import com.tencent.kuikly.core.pager.h;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import h25.af;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import zz0.a;

/* loaded from: classes31.dex */
public final class AdelieCreativeCenterPage extends BaseComposePager {
    public String createEventCallbackRef;
    public String deleteEventCallbackRef;
    public String editEventCallbackRef;
    public final Function1<e, Unit> refreshCallback;
    public final Function1<e, Unit> refreshRedDotCallback;
    public String revokeRedDotEventCallbackRef;
    public final MutableState showRecycleBubbleTips$delegate;
    public AdelieCreativeTrace startTrace;
    public final Lazy viewModel$delegate;

    public AdelieCreativeCenterPage() {
        Lazy lazy;
        MutableState mutableStateOf$default;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieCreativeCenterViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieCreativeCenterViewModel invoke() {
                return new AdelieCreativeCenterViewModel();
            }
        });
        this.viewModel$delegate = lazy;
        this.refreshCallback = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$refreshCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("refreshCallback, data=", eVar, KLog.INSTANCE, "AdelieCreativeCenterPage");
                AdelieCreativeCenterPage.this.getViewModel().fetchServerData(false, null);
                return Unit.INSTANCE;
            }
        };
        this.refreshRedDotCallback = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$refreshRedDotCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("refreshRedDotCallback, data=", eVar, KLog.INSTANCE, "AdelieCreativeCenterPage");
                AdelieCreativeCenterPage.this.getViewModel().fetchRedDotData();
                return Unit.INSTANCE;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.showRecycleBubbleTips$delegate = mutableStateOf$default;
    }

    public final e getDTPageParam() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_creative_center");
    }

    public final AdelieCreativeCenterViewModel getViewModel() {
        return (AdelieCreativeCenterViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onCreatePager(String str, e eVar) {
        e m3 = eVar.m("param");
        if (m3 != null) {
            long n3 = m3.n("start_time");
            if (n3 > 0) {
                this.startTrace = new AdelieCreativeTrace(n3);
            }
        }
        AdelieCreativeTrace adelieCreativeTrace = this.startTrace;
        if (adelieCreativeTrace != null) {
            adelieCreativeTrace.createPagerStartTime = a.f453719a.a();
        }
        super.onCreatePager(str, eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        getViewModel().getClass();
        String str = this.createEventCallbackRef;
        if (str != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str);
        }
        String str2 = this.editEventCallbackRef;
        if (str2 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str2);
        }
        String str3 = this.deleteEventCallbackRef;
        if (str3 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str3);
        }
        String str4 = this.revokeRedDotEventCallbackRef;
        if (str4 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str4);
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onFirstFramePaint() {
        super.onFirstFramePaint();
        AdelieCreativeTrace adelieCreativeTrace = this.startTrace;
        if (adelieCreativeTrace != null) {
            adelieCreativeTrace.hasLocalCache = getViewModel().hasLocalCache;
        }
        AdelieCreativeTrace adelieCreativeTrace2 = this.startTrace;
        if (adelieCreativeTrace2 != null) {
            adelieCreativeTrace2.firstFrameTime = a.f453719a.a();
            if (adelieCreativeTrace2.isReadyToReport()) {
                adelieCreativeTrace2.report();
            }
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        super.pageDidAppear();
        ReportKt.reportCustomDTEvent("dt_pgin", getDTPageParam());
        AdelieCreativeTrace adelieCreativeTrace = this.startTrace;
        if (adelieCreativeTrace != null) {
            adelieCreativeTrace.pageShowTime = a.f453719a.a();
            if (adelieCreativeTrace.isReadyToReport()) {
                adelieCreativeTrace.report();
            }
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        setShowRecycleBubbleTips(false);
        ReportKt.reportCustomDTEvent("dt_pgout", getDTPageParam());
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    public final void setShowRecycleBubbleTips(boolean z16) {
        this.showRecycleBubbleTips$delegate.setValue(Boolean.valueOf(z16));
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(com.tencent.ntcompose.activity.a aVar) {
        af afVar;
        super.onCreate(aVar);
        if (getPageData().getIsAndroid()) {
            registerViewCreator("TextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$registerViewCreator$1
                @Override // com.tencent.kuikly.core.pager.f
                public final DeclarativeBaseView<?, ?> createView() {
                    return new QQTextView();
                }
            });
            registerViewCreator("RichTextView", new f() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$registerViewCreator$2
                @Override // com.tencent.kuikly.core.pager.f
                public final DeclarativeBaseView<?, ?> createView() {
                    return new QQRichTextView();
                }
            });
        }
        final AdelieCreativeCenterViewModel viewModel = getViewModel();
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = viewModel.adelieKuiklyBaseModule;
        String qQMCConfigSync = adelieKuiklyBaseModule.getQQMCConfigSync("adelie_create_center_banner");
        if (qQMCConfigSync.length() == 0) {
            adelieKuiklyBaseModule.getQQMCConfig("adelie_create_center_banner", "", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel$fetchBannerData$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    if (eVar2 != null) {
                        try {
                            String q16 = eVar2.q("data", "");
                            if (!(q16.length() == 0)) {
                                AdelieCreativeCenterViewModel.this.bannerInfo._state.setValue(CreateCenterBanner.Companion.fromJsonString(q16));
                            }
                        } catch (Throwable th5) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getQQMCConfig error, ", th5, KLog.INSTANCE, "AdelieCreativeCenterViewModel");
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            viewModel.bannerInfo._state.setValue(CreateCenterBanner.Companion.fromJsonString(qQMCConfigSync));
        }
        AdelieCreativeCenterDataManager adelieCreativeCenterDataManager = AdelieCreativeCenterDataManager.INSTANCE;
        KLog kLog = KLog.INSTANCE;
        kLog.i("AdelieCreativeCenterDataManager", "fetchCreativeCenterCacheDataSync start");
        c cVar = c.f117352a;
        if (defpackage.k.a(cVar)) {
            AdelieKuiklyBaseModule adelieKuiklyBaseModule2 = adelieCreativeCenterDataManager.getAdelieKuiklyBaseModule();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("adelie_creative_center");
            m3.append(cVar.g().getPageData().n().q("uin", ""));
            String sb5 = m3.toString();
            adelieKuiklyBaseModule2.getClass();
            byte[] a16 = ((com.tencent.kuikly.core.module.e) h.a().acquireModule("KRDiskCacheModule")).a(sb5);
            if (a16 != null) {
                afVar = (af) i.b(new af(null, null, null, null, false, null, false, null, null, 511, null), a16);
                kLog.i("AdelieCreativeCenterDataManager", "fetchCreativeCenterCacheDataSync end");
            }
            afVar = null;
        } else {
            if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                AdelieKuiklyBaseModule adelieKuiklyBaseModule3 = adelieCreativeCenterDataManager.getAdelieKuiklyBaseModule();
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("adelie_creative_center");
                m16.append(cVar.g().getPageData().n().q("uin", ""));
                String stringFromCache$default = AdelieKuiklyBaseModule.getStringFromCache$default(adelieKuiklyBaseModule3, m16.toString(), null, 14);
                if (!(stringFromCache$default.length() == 0)) {
                    byte[] a17 = d45.a.a(stringFromCache$default);
                    afVar = a17 != null ? (af) i.b(new af(null, null, null, null, false, null, false, null, null, 511, null), a17) : null;
                    kLog.i("AdelieCreativeCenterDataManager", "fetchCreativeCenterCacheDataSync end");
                }
            }
            afVar = null;
        }
        if (viewModel.hasFetchServerData) {
            kLog.i("AdelieCreativeCenterViewModel", "fetchCreativeCenterCacheData server data fetched");
        } else if (afVar == null) {
            kLog.i("AdelieCreativeCenterViewModel", "cache data is null");
            viewModel.pageState._state.setValue(PageState.LOADING);
        } else {
            kLog.i("AdelieCreativeCenterViewModel", "fetchCreativeCenterCacheDataSync success");
            viewModel.parsePspData(afVar, false);
            viewModel.hasLocalCache = true;
            viewModel.pageState._state.setValue(PageState.SUCCESS);
        }
        viewModel.fetchServerData(false, null);
        BuildersKt.e(viewModel.requestScope, null, null, new AdelieCreativeCenterViewModel$fetchManagerSchemeData$1(null), 3, null);
        viewModel.fetchRedDotData();
        kLog.i("AdelieCreativeCenterPage", "setContent viewModel data state: " + getViewModel().pageState._state.getValue());
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(994819706, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$onCreate$1
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
                        ComposerKt.traceEventStart(994819706, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage.onCreate.<anonymous> (AdelieCreativeCenterPage.kt:78)");
                    }
                    AdelieCreativeCenterPage.access$SetMainContent(AdelieCreativeCenterPage.this, composer2, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
        this.createEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_create_robot", false, this.refreshCallback, 2, null);
        this.editEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_edit_robot", false, this.refreshCallback, 2, null);
        this.deleteEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_delete_robot", false, this.refreshCallback, 2, null);
        this.revokeRedDotEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_revoke_red_dot", false, this.refreshRedDotCallback, 2, null);
    }

    public static final void access$SetMainContent(final AdelieCreativeCenterPage adelieCreativeCenterPage, Composer composer, final int i3) {
        adelieCreativeCenterPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(1022453040);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1022453040, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage.SetMainContent (AdelieCreativeCenterPage.kt:90)");
        }
        final d a16 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, startRestartGroup, 0, 3);
        LazyColumnKt.a(ViewEventPropUpdaterKt.j(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                AdelieCreativeCenterPage.this.setShowRecycleBubbleTips(false);
                return Unit.INSTANCE;
            }
        }, 3, null), new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                AdelieCreativeCenterPage.this.setShowRecycleBubbleTips(false);
                return Unit.INSTANCE;
            }
        }), null, a16, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1930141035, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$3

            /* loaded from: classes31.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PageState.values().length];
                    try {
                        iArr[1] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[2] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[3] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1930141035, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage.SetMainContent.<anonymous> (AdelieCreativeCenterPage.kt:105)");
                }
                PageState value = AdelieCreativeCenterPage.this.getViewModel().pageState._state.getValue();
                int i16 = value != null ? WhenMappings.$EnumSwitchMapping$0[value.ordinal()] : -1;
                if (i16 == 1) {
                    composer3.startReplaceableGroup(864439951);
                    KLog.INSTANCE.i("AdelieCreativeCenterPage", "fetch data loading");
                    QUIScanningLightKt.QUIScanningLight(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 818.0f), 0.0f, AdelieCreativeCenterPage.this.getPageData().getIsAndroid() ? (-AdelieCreativeCenterPage.this.getPageData().getStatusBarHeight()) - 44.0f : 0.0f, 0.0f, 0.0f, 13, null), "creative_center", composer3, 56, 0);
                    composer3.endReplaceableGroup();
                } else if (i16 == 2) {
                    composer3.startReplaceableGroup(864440461);
                    KLog.INSTANCE.i("AdelieCreativeCenterPage", "fetch data success");
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 5.0f), composer3, 8, 0);
                    DataCardKt.DataCard(AdelieCreativeCenterPage.this.getViewModel(), true, AdelieCreativeCenterPage.this.getDTPageParam(), composer3, PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 0);
                    h25.d value2 = AdelieCreativeCenterPage.this.getViewModel().activityInfo._state.getValue();
                    composer3.startReplaceableGroup(864440732);
                    if (value2 != null) {
                        AdelieCreativeCenterPage adelieCreativeCenterPage2 = AdelieCreativeCenterPage.this;
                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                        ActivityCardKt.ActivityCard(value2, adelieCreativeCenterPage2.getDTPageParam(), composer3, 72);
                        Unit unit = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                    AdelieCreativeCenterViewModel viewModel = AdelieCreativeCenterPage.this.getViewModel();
                    e dTPageParam = AdelieCreativeCenterPage.this.getDTPageParam();
                    d dVar = a16;
                    boolean booleanValue = ((Boolean) AdelieCreativeCenterPage.this.showRecycleBubbleTips$delegate.getValue()).booleanValue();
                    final AdelieCreativeCenterPage adelieCreativeCenterPage3 = AdelieCreativeCenterPage.this;
                    BotListKt.BotList(aVar2, viewModel, dTPageParam, true, dVar, booleanValue, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$3.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            AdelieCreativeCenterPage.this.setShowRecycleBubbleTips(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }, composer3, 3656);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                    AdelieCreativeTrace adelieCreativeTrace = AdelieCreativeCenterPage.this.startTrace;
                    if (adelieCreativeTrace != null) {
                        adelieCreativeTrace.dataShowTime = a.f453719a.a();
                        if (adelieCreativeTrace.isReadyToReport()) {
                            adelieCreativeTrace.report();
                        }
                    }
                    composer3.endReplaceableGroup();
                } else if (i16 != 3) {
                    composer3.startReplaceableGroup(864441853);
                    composer3.endReplaceableGroup();
                    KLog.INSTANCE.i("AdelieCreativeCenterPage", "init");
                } else {
                    composer3.startReplaceableGroup(864441295);
                    KLog.INSTANCE.i("AdelieCreativeCenterPage", "fetch data error");
                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 5.0f), composer3, 8, 0);
                    DataCardKt.DataCard(AdelieCreativeCenterPage.this.getViewModel(), false, null, composer3, 56, 4);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer3, 8, 0);
                    AdelieCreativeCenterViewModel viewModel2 = AdelieCreativeCenterPage.this.getViewModel();
                    e dTPageParam2 = AdelieCreativeCenterPage.this.getDTPageParam();
                    d dVar2 = a16;
                    boolean booleanValue2 = ((Boolean) AdelieCreativeCenterPage.this.showRecycleBubbleTips$delegate.getValue()).booleanValue();
                    final AdelieCreativeCenterPage adelieCreativeCenterPage4 = AdelieCreativeCenterPage.this;
                    BotListKt.BotList(aVar2, viewModel2, dTPageParam2, true, dVar2, booleanValue2, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$3.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            AdelieCreativeCenterPage.this.setShowRecycleBubbleTips(bool.booleanValue());
                            return Unit.INSTANCE;
                        }
                    }, composer3, 3656);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 16.0f), composer3, 8, 0);
                    AdelieCreativeTrace adelieCreativeTrace2 = AdelieCreativeCenterPage.this.startTrace;
                    if (adelieCreativeTrace2 != null) {
                        adelieCreativeTrace2.errorCode = -1L;
                        adelieCreativeTrace2.errorTime = a.f453719a.a();
                        adelieCreativeTrace2.report();
                    }
                    composer3.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194170);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterPage$SetMainContent$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieCreativeCenterPage.access$SetMainContent(AdelieCreativeCenterPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
