package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomePageBannerConfig;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.module.t;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes31.dex */
public final class AdelieCategoryHomePage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean showedUserAlertView;
    public String showingAgreementEventCallbackRef;
    public String showingNativeGuideCallbackRef;
    public final Function1<e, Unit> showingUserAlertCallback;
    public AdelieCategoryHomeTrace startTrace;
    public final Lazy viewModel$delegate;

    public AdelieCategoryHomePage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieHomeCategoryViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieHomeCategoryViewModel invoke() {
                return new AdelieHomeCategoryViewModel();
            }
        });
        this.viewModel$delegate = lazy;
        this.showingUserAlertCallback = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$showingUserAlertCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("showedUserAlertView, data=", eVar, KLog.INSTANCE, "AdelieCategoryHomePage");
                AdelieCategoryHomePage.this.showedUserAlertView = true;
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0016, code lost:
    
        r1 = kotlin.collections.MapsKt__MapsKt.plus(r1, r0);
     */
    @Override // com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager, com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> plus;
        HashMap hashMap = new HashMap();
        hashMap.put("AdelieKuiklyHomePageModule", new AdelieKuiklyHomePageModule());
        Map<String, Module> createExternalModules = super.createExternalModules();
        return (createExternalModules == null || plus == null) ? hashMap : plus;
    }

    public final e getDTPageParam() {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_home_page_new");
        m3.v("superior_source", c.f117352a.g().getPageData().n().q("superior_source", "1"));
        return m3;
    }

    public final AdelieHomeCategoryViewModel getViewModel() {
        return (AdelieHomeCategoryViewModel) this.viewModel$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        final AdelieHomeCategoryViewModel viewModel = getViewModel();
        viewModel.getClass();
        KLog kLog = KLog.INSTANCE;
        kLog.i("AdelieHomeCategoryViewModel", "requestCategory start");
        viewModel.requestLocalCachePageData(viewModel.defaultCategory);
        kLog.i("AdelieHomeCategoryViewModel", "get banner data");
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) viewModel.adelieKuiklyModule$delegate.getValue();
        final String qQMCConfigSync = adelieKuiklyBaseModule.getQQMCConfigSync("robot_home_page_banner_config");
        if (qQMCConfigSync.length() == 0) {
            kLog.i("AdelieHomeCategoryViewModel", "getQQMCConfigSync banner data is null");
            adelieKuiklyBaseModule.getQQMCConfig("robot_home_page_banner_config", "", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$fetchBannerData$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("banner info : ", eVar2, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
                    if (eVar2 != null) {
                        try {
                            if (!(eVar2.q("data", "").length() == 0)) {
                                AdelieHomeCategoryViewModel.this.bannerInfo._state.setValue(AdelieHomePageBannerConfig.Companion.fromJsonString(qQMCConfigSync));
                            }
                        } catch (Throwable th5) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getQQMCConfig error, ", th5, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            viewModel.bannerInfo._state.setValue(AdelieHomePageBannerConfig.Companion.fromJsonString(qQMCConfigSync));
        }
        kLog.i("AdelieHomeCategoryViewModel", "fetchSuperResolutionUinBlackList");
        AdelieKuiklyBaseModule adelieKuiklyBaseModule2 = (AdelieKuiklyBaseModule) viewModel.adelieKuiklyModule$delegate.getValue();
        String qQMCConfigSync2 = adelieKuiklyBaseModule2.getQQMCConfigSync("robot_home_page_super_resolution_uin_blacklist");
        if (qQMCConfigSync2.length() == 0) {
            kLog.i("AdelieHomeCategoryViewModel", "fetchSuperResolutionUinBlackList sync data is null");
            adelieKuiklyBaseModule2.getQQMCConfig("robot_home_page_super_resolution_uin_blacklist", "", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel$fetchSuperResolutionUinBlackList$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    KLog kLog2 = KLog.INSTANCE;
                    AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("fetchSuperResolutionUinBlackList config : ", eVar2, kLog2, "AdelieHomeCategoryViewModel");
                    if (eVar2 != null) {
                        try {
                            String q16 = eVar2.q("data", "");
                            AdelieHomeCategoryViewModel adelieHomeCategoryViewModel = AdelieHomeCategoryViewModel.this;
                            adelieHomeCategoryViewModel.superResolutionUinBlacklist = adelieHomeCategoryViewModel.parseSuperResolutionUinBlackList(q16);
                            kLog2.i("AdelieHomeCategoryViewModel", "fetchSuperResolutionUinBlackList blacklist=" + AdelieHomeCategoryViewModel.this.superResolutionUinBlacklist);
                        } catch (Throwable th5) {
                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("getQQMCConfig error, ", th5, KLog.INSTANCE, "AdelieHomeCategoryViewModel");
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            viewModel.superResolutionUinBlacklist = viewModel.parseSuperResolutionUinBlackList(qQMCConfigSync2);
            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchSuperResolutionUinBlackList blacklist="), viewModel.superResolutionUinBlacklist, kLog, "AdelieHomeCategoryViewModel");
        }
        c cVar = c.f117352a;
        this.showingNativeGuideCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_show_native_guide", false, this.showingUserAlertCallback, 2, null);
        this.showingAgreementEventCallbackRef = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "adelie_showing_user_agreement", false, this.showingUserAlertCallback, 2, null);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-188530209, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$onCreate$1
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
                        ComposerKt.traceEventStart(-188530209, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage.onCreate.<anonymous> (AdelieCategoryHomePage.kt:56)");
                    }
                    i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j());
                    final AdelieCategoryHomePage adelieCategoryHomePage = AdelieCategoryHomePage.this;
                    SurfaceKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer2, -807961507, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$onCreate$1.1
                        {
                            super(2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 11) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-807961507, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage.onCreate.<anonymous>.<anonymous> (AdelieCategoryHomePage.kt:62)");
                                }
                                AdelieCategoryHomePage adelieCategoryHomePage2 = AdelieCategoryHomePage.this;
                                int i3 = AdelieCategoryHomePage.$r8$clinit;
                                AdelieHomeCategoryViewModel viewModel2 = adelieCategoryHomePage2.getViewModel();
                                AdelieCategoryHomePage adelieCategoryHomePage3 = AdelieCategoryHomePage.this;
                                AdelieCategoryTabAndPageKt.AdelieCategoryTabAndPage(viewModel2, adelieCategoryHomePage3.startTrace, adelieCategoryHomePage3.getDTPageParam(), composer4, 584);
                                if (((Boolean) AdelieCategoryHomePage.this.getViewModel().shouldShowAgreement$delegate.getValue()).booleanValue()) {
                                    final AdelieCategoryHomePage adelieCategoryHomePage4 = AdelieCategoryHomePage.this;
                                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage.onCreate.1.1.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            AdelieCategoryHomePage.this.showedUserAlertView = true;
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    final AdelieCategoryHomePage adelieCategoryHomePage5 = AdelieCategoryHomePage.this;
                                    AgreementConsentViewKt.showAgreementConsentView(function0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage.onCreate.1.1.2
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            AdelieCategoryHomePage adelieCategoryHomePage6 = AdelieCategoryHomePage.this;
                                            int i16 = AdelieCategoryHomePage.$r8$clinit;
                                            adelieCategoryHomePage6.getClass();
                                            t tVar = (t) c.f117352a.g().acquireModule("KRTurboDisplayModule");
                                            if (tVar.a()) {
                                                KLog.INSTANCE.i("AdelieHomeCategoryViewModel", "update turbo display");
                                                tVar.b();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, AdelieCategoryHomePage.this.getDTPageParam(), composer4, 512, 0);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onCreatePager(String str, e eVar) {
        e m3 = eVar.m("param");
        if (m3 != null) {
            long n3 = m3.n("start_time");
            if (n3 > 0) {
                this.startTrace = new AdelieCategoryHomeTrace(n3);
            }
        }
        AdelieCategoryHomeTrace adelieCategoryHomeTrace = this.startTrace;
        if (adelieCategoryHomeTrace != null) {
            adelieCategoryHomeTrace.createPagerStartTime = zz0.a.f453719a.a();
        }
        super.onCreatePager(str, eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        getViewModel().getClass();
        String str = this.showingNativeGuideCallbackRef;
        if (str != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str);
        }
        String str2 = this.showingAgreementEventCallbackRef;
        if (str2 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).removeCallback(str2);
        }
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onFirstFramePaint() {
        super.onFirstFramePaint();
        AdelieCategoryHomeTrace adelieCategoryHomeTrace = this.startTrace;
        if (adelieCategoryHomeTrace != null) {
            adelieCategoryHomeTrace.firstFrameTime = zz0.a.f453719a.a();
            if (adelieCategoryHomeTrace.isReadyToReport()) {
                adelieCategoryHomeTrace.report();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        Lazy lazy;
        super.pageDidAppear();
        AdelieCategoryHomeTrace adelieCategoryHomeTrace = this.startTrace;
        if (adelieCategoryHomeTrace != null) {
            adelieCategoryHomeTrace.pageShowTime = zz0.a.f453719a.a();
            if (adelieCategoryHomeTrace.isReadyToReport()) {
                adelieCategoryHomeTrace.report();
            }
        }
        ReportKt.reportCustomDTEvent("dt_pgin", getDTPageParam());
        if (!this.showedUserAlertView) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$showUserAgreementIfNeeded$adelieKuiklyModule$2
                @Override // kotlin.jvm.functions.Function0
                public final AdelieKuiklyBaseModule invoke() {
                    return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                }
            });
            AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) lazy.getValue();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_ANIMATION_");
            c cVar = c.f117352a;
            m3.append(PageDataExtKt.getUin(cVar.g().getPageData()));
            boolean booleanFromCache = adelieKuiklyBaseModule.getBooleanFromCache(m3.toString());
            AdelieKuiklyBaseModule adelieKuiklyBaseModule2 = (AdelieKuiklyBaseModule) lazy.getValue();
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_GUIDE_HAS_SHOWN_NATIVE_GUIDE_");
            m16.append(PageDataExtKt.getUin(cVar.g().getPageData()));
            boolean booleanFromCache2 = adelieKuiklyBaseModule2.getBooleanFromCache(m16.toString());
            AdelieKuiklyBaseModule adelieKuiklyBaseModule3 = (AdelieKuiklyBaseModule) lazy.getValue();
            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_HOME_PAGE_HAS_SHOW_USER_AGREEMENT_");
            m17.append(PageDataExtKt.getUin(cVar.g().getPageData()));
            boolean booleanFromCache3 = adelieKuiklyBaseModule3.getBooleanFromCache(m17.toString());
            boolean z16 = !booleanFromCache3 && (booleanFromCache || booleanFromCache2);
            if (z16 && ((Boolean) getViewModel().shouldShowAgreement$delegate.getValue()).booleanValue()) {
                getViewModel().shouldShowAgreement$delegate.setValue(Boolean.FALSE);
            }
            KLog.INSTANCE.i("AdelieCategoryHomePage", "hasShownAnimation : " + booleanFromCache + ", hasNativeGuide : " + booleanFromCache2 + ", hasAgreementConsent : " + booleanFromCache3);
            getViewModel().shouldShowAgreement$delegate.setValue(Boolean.valueOf(z16));
            return;
        }
        AdelieCategoryHomePage$$ExternalSyntheticOutline2.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("showedUserAlertView : "), this.showedUserAlertView, KLog.INSTANCE, "AdelieCategoryHomePage");
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        ReportKt.reportCustomDTEvent("dt_pgout", getDTPageParam());
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
