package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.ListStateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieCreateTtsViewModel$fetchTtsReadTextFromServer$1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module.AdelieKuiklyTTSPageModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsErrorViewKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsListKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.TtsNavigationBarKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.extension.ListExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIPolarLightKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.AdeliePolarLightView;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.FullScreenLoadingKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.view.qui.LoadingType;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import h25.aj;
import h25.f;
import h25.s;
import h25.x;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes31.dex */
public final class AdelieTtsSettingPage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy createViewModel$delegate;
    public final Lazy enableCreateClone$delegate;
    public boolean isFirstEnter;
    public d lazyListState;
    public AdeliePolarLightView polarLightView;
    public final Lazy selectService$delegate;
    public final Lazy viewMode$delegate;

    public AdelieTtsSettingPage() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieTtsSettingViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$viewMode$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieTtsSettingViewModel invoke() {
                return new AdelieTtsSettingViewModel();
            }
        });
        this.viewMode$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AdelieCreateTtsViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$createViewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieCreateTtsViewModel invoke() {
                return new AdelieCreateTtsViewModel();
            }
        });
        this.createViewModel$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<OnKeySelectService>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$selectService$2
            @Override // kotlin.jvm.functions.Function0
            public final OnKeySelectService invoke() {
                return new OnKeySelectService();
            }
        });
        this.selectService$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$enableCreateClone$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Object m476constructorimpl;
                c cVar = c.f117352a;
                if (!PageDataExtKt.isPublic(cVar.g().getPageData())) {
                    return Boolean.TRUE;
                }
                AdelieTtsSettingPage.this.getClass();
                String qQMCConfigSync = ((AdelieKuiklyBaseModule) cVar.g().acquireModule("AdelieKuiklyBaseModule")).getQQMCConfigSync("adelie_tts_clone_create");
                KLog.INSTANCE.i("AdelieTtsSettingPage", "enableCreateClone value = " + qQMCConfigSync);
                if (qQMCConfigSync.length() == 0) {
                    return Boolean.FALSE;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(Boolean.valueOf(new e(qQMCConfigSync).g("enable", false)));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                    m476constructorimpl = Boolean.FALSE;
                }
                return (Boolean) m476constructorimpl;
            }
        });
        this.enableCreateClone$delegate = lazy4;
        this.isFirstEnter = true;
    }

    public static final void access$contentContainer(final AdelieTtsSettingPage adelieTtsSettingPage, final float f16, final Function3 function3, Composer composer, final int i3) {
        final int i16;
        adelieTtsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1689945923);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(f16) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i3 & 112) == 0) {
            i16 |= startRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i16 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1689945923, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.contentContainer (AdelieTtsSettingPage.kt:243)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.f(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j()), 0.0f, 1, null), 0.0f, 1, null), 16.0f, f16, 16.0f, 0.0f), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2067306743, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$contentContainer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(b bVar, Composer composer2, Integer num) {
                    b bVar2 = bVar;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 14) == 0) {
                        intValue |= composer3.changed(bVar2) ? 4 : 2;
                    }
                    if ((intValue & 91) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2067306743, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.contentContainer.<anonymous> (AdelieTtsSettingPage.kt:252)");
                        }
                        function3.invoke(bVar2, composer3, Integer.valueOf((intValue & 14) | (i16 & 112)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$contentContainer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.access$contentContainer(AdelieTtsSettingPage.this, f16, function3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final AdelieCreateTtsViewModel access$getCreateViewModel(AdelieTtsSettingPage adelieTtsSettingPage) {
        return (AdelieCreateTtsViewModel) adelieTtsSettingPage.createViewModel$delegate.getValue();
    }

    public static final void access$morePopDownMenu(final AdelieTtsSettingPage adelieTtsSettingPage, Composer composer, final int i3) {
        adelieTtsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(8119007);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(8119007, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.morePopDownMenu (AdelieTtsSettingPage.kt:372)");
        }
        PopDownMenuLogic popDownMenuLogic = new PopDownMenuLogic(adelieTtsSettingPage.getViewMode().getPopDownStateManager());
        popDownMenuLogic.popDownMenu(startRestartGroup, 8);
        popDownMenuLogic.renameDialog(startRestartGroup, 8);
        popDownMenuLogic.deleteDialog(startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$morePopDownMenu$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.access$morePopDownMenu(AdelieTtsSettingPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$shadowBackground(final AdelieTtsSettingPage adelieTtsSettingPage, Composer composer, final int i3) {
        h j3;
        adelieTtsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1142563662);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1142563662, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.shadowBackground (AdelieTtsSettingPage.kt:365)");
        }
        if (Intrinsics.areEqual(adelieTtsSettingPage.getViewMode().getPopDownStateManager().shadowState._state.getValue(), Boolean.TRUE)) {
            j3 = QUIToken.color$default("overlay_dark");
        } else {
            j3 = h.INSTANCE.j();
        }
        BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), j3), null, null, ComposableSingletons$AdelieTtsSettingPageKt.f17lambda2, startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$shadowBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.access$shadowBackground(AdelieTtsSettingPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
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
        hashMap.put("AdelieKuiklyTTSPageModule", new AdelieKuiklyTTSPageModule());
        Map<String, Module> createExternalModules = super.createExternalModules();
        return (createExternalModules == null || plus == null) ? hashMap : plus;
    }

    public final AdelieTtsStartParams$Params getSettingParams(g gVar) {
        e n3 = gVar.n();
        AdelieTtsStartParams$Params adelieTtsStartParams$Params = new AdelieTtsStartParams$Params(null, null, null, null, null, 0, 63, null);
        adelieTtsStartParams$Params.ttsId = n3.p("tts_id");
        adelieTtsStartParams$Params.botName = n3.p("bot_name");
        adelieTtsStartParams$Params.botPrompt = n3.p("bot_prompt");
        adelieTtsStartParams$Params.botWelcome = n3.p("bot_welcome");
        adelieTtsStartParams$Params.botDesc = n3.p("bot_desc");
        adelieTtsStartParams$Params.botGender = 0;
        String p16 = n3.p("gender");
        if (p16.length() > 0) {
            adelieTtsStartParams$Params.botGender = Integer.parseInt(p16);
        }
        return adelieTtsStartParams$Params;
    }

    public final AdelieTtsSettingViewModel getViewMode() {
        return (AdelieTtsSettingViewModel) this.viewMode$delegate.getValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        AdelieTtsSettingViewModel viewMode = getViewMode();
        viewMode.getTtsInfoStateManager().callback = viewMode.stateManagerCallback;
        viewMode.fetchTtsInfoFromServer();
        AdelieTtsReport.currentTimbreId = getSettingParams(getPageData()).ttsId;
        reportOneSelect("dt_imp");
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(528326924, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$onCreate$1
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
                        ComposerKt.traceEventStart(528326924, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.<anonymous> (AdelieTtsSettingPage.kt:118)");
                    }
                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j());
                    final AdelieTtsSettingPage adelieTtsSettingPage = AdelieTtsSettingPage.this;
                    BoxKt.a(c16, null, null, ComposableLambdaKt.composableLambda(composer2, -1879954286, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer3, Integer num2) {
                            String str;
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1879954286, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.<anonymous>.<anonymous> (AdelieTtsSettingPage.kt:122)");
                                }
                                i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                                final AdelieTtsSettingPage adelieTtsSettingPage2 = AdelieTtsSettingPage.this;
                                QUIPolarLightKt.QUIPolarLight(f16, new Function2<AdeliePolarLightView, aa<AdeliePolarLightView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(AdeliePolarLightView adeliePolarLightView, aa<AdeliePolarLightView> aaVar) {
                                        AdelieTtsSettingPage.this.polarLightView = adeliePolarLightView;
                                        return Unit.INSTANCE;
                                    }
                                }, "polar_light", composer4, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 0);
                                AdelieTtsSettingPage adelieTtsSettingPage3 = AdelieTtsSettingPage.this;
                                int i3 = AdelieTtsSettingPage.$r8$clinit;
                                boolean z16 = adelieTtsSettingPage3.getViewMode().pageState._state.getValue() == PageState.SUCCESS;
                                AnonymousClass2 anonymousClass2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                };
                                final AdelieTtsSettingPage adelieTtsSettingPage4 = AdelieTtsSettingPage.this;
                                TtsNavigationBarKt.TtsNavigationBar(z16, anonymousClass2, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        AdelieTtsSettingPage adelieTtsSettingPage5 = AdelieTtsSettingPage.this;
                                        int i16 = AdelieTtsSettingPage.$r8$clinit;
                                        StateHolder<Boolean> stateHolder = adelieTtsSettingPage5.getViewMode().showLoading;
                                        stateHolder._state.setValue(Boolean.TRUE);
                                        AdelieTtsSettingPage.this.reportOneSelect("dt_clck");
                                        final OnKeySelectService onKeySelectService = (OnKeySelectService) AdelieTtsSettingPage.this.selectService$delegate.getValue();
                                        AdelieTtsSettingPage adelieTtsSettingPage6 = AdelieTtsSettingPage.this;
                                        AdelieTtsStartParams$Params settingParams = adelieTtsSettingPage6.getSettingParams(adelieTtsSettingPage6.getPageData());
                                        final AdelieTtsSettingPage adelieTtsSettingPage7 = AdelieTtsSettingPage.this;
                                        final Function3<Integer, String, String, Unit> function3 = new Function3<Integer, String, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.3.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(Integer num3, String str2, String str3) {
                                                int intValue3 = num3.intValue();
                                                String str4 = str2;
                                                String str5 = str3;
                                                AdelieTtsSettingPage adelieTtsSettingPage8 = AdelieTtsSettingPage.this;
                                                int i17 = AdelieTtsSettingPage.$r8$clinit;
                                                StateHolder<Boolean> stateHolder2 = adelieTtsSettingPage8.getViewMode().showLoading;
                                                stateHolder2._state.setValue(Boolean.FALSE);
                                                if (intValue3 != 0) {
                                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast(str4, QToastMode.Warning);
                                                } else {
                                                    AdelieTtsPlayerManager adelieTtsPlayerManager = AdelieTtsPlayerManager.INSTANCE;
                                                    AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
                                                    AdelieTtsInfo ttsInfoById = adelieTtsDataManager.getTtsInfoById(str5);
                                                    if (ttsInfoById != null) {
                                                        AdelieTtsInfo selectTtsInfo = adelieTtsDataManager.getSelectTtsInfo();
                                                        if (selectTtsInfo != null) {
                                                            selectTtsInfo.playState$delegate.setValue(TtsPlayState.NONE);
                                                        }
                                                        adelieTtsPlayerManager.startPlay(ttsInfoById);
                                                    }
                                                    int findIndex = ListExtKt.findIndex(AdelieTtsDataManager.ttsInfoList, new AdelieTtsDataManager$getTtsIndexById$1(str5));
                                                    d dVar = AdelieTtsSettingPage.this.lazyListState;
                                                    if (dVar != null) {
                                                        d.x(dVar, findIndex, 0.0f, true, null, 8, null);
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        onKeySelectService.getClass();
                                        BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieOIDBServer$onKeySelectTts$1(new Function3<Integer, String, h25.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.OnKeySelectService$autoSelectTts$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(Integer num3, String str2, h25.c cVar) {
                                                f fVar;
                                                int intValue3 = num3.intValue();
                                                String str3 = str2;
                                                h25.c cVar2 = cVar;
                                                KLog kLog = KLog.INSTANCE;
                                                StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("onKeySelectTts errCode = ", intValue3, " errMsg = ", str3, " rsp = ");
                                                m3.append(cVar2);
                                                kLog.i("OnKeySelectService", m3.toString());
                                                if (cVar2 != null && intValue3 == 0 && (fVar = cVar2.f404189e) != null) {
                                                    Intrinsics.checkNotNull(fVar);
                                                    String str4 = fVar.f404200d;
                                                    if (str4.length() == 0) {
                                                        function3.invoke(-1, OnKeySelectService.access$getErrorMsg(onKeySelectService, str3), "");
                                                    } else {
                                                        final Function3<Integer, String, String, Unit> function32 = function3;
                                                        final OnKeySelectService onKeySelectService2 = onKeySelectService;
                                                        AdelieOIDBServer.queryTask$pollTaskState(new Ref.IntRef(), new Function3<Integer, String, aj, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.OnKeySelectService$autoSelectTts$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(Integer num4, String str5, aj ajVar) {
                                                                int intValue4 = num4.intValue();
                                                                String str6 = str5;
                                                                aj ajVar2 = ajVar;
                                                                KLog kLog2 = KLog.INSTANCE;
                                                                StringBuilder m16 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("queryTask errCode = ", intValue4, " errMsg = ", str6, " rsp = ");
                                                                m16.append(ajVar2);
                                                                kLog2.i("OnKeySelectService", m16.toString());
                                                                if (ajVar2 != null && intValue4 == 0) {
                                                                    x xVar = ajVar2.f404153h;
                                                                    if (xVar == null) {
                                                                        function32.invoke(-1, OnKeySelectService.access$getErrorMsg(onKeySelectService2, str6), "");
                                                                    } else {
                                                                        function32.invoke(0, "", xVar.G);
                                                                    }
                                                                } else {
                                                                    function32.invoke(Integer.valueOf(intValue4), OnKeySelectService.access$getErrorMsg(onKeySelectService2, str6), "");
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, str4);
                                                    }
                                                } else {
                                                    function3.invoke(-1, OnKeySelectService.access$getErrorMsg(onKeySelectService, str3), "");
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, new x(null, settingParams.botName, settingParams.botPrompt, settingParams.botWelcome, settingParams.botDesc, settingParams.botGender, settingParams.ttsId, 64263), null), 3, null);
                                        return Unit.INSTANCE;
                                    }
                                }, composer4, 48);
                                composer4.startReplaceableGroup(652714696);
                                Boolean value = AdelieTtsSettingPage.this.getViewMode().showLoading._state.getValue();
                                Boolean bool = Boolean.TRUE;
                                if (Intrinsics.areEqual(value, bool) || Intrinsics.areEqual(AdelieTtsSettingPage.access$getCreateViewModel(AdelieTtsSettingPage.this).isRecognizing._state.getValue(), bool)) {
                                    if (Intrinsics.areEqual(AdelieTtsSettingPage.access$getCreateViewModel(AdelieTtsSettingPage.this).isRecognizing._state.getValue(), bool)) {
                                        str = "\u8bc6\u522b\u4e2d";
                                    } else {
                                        str = "\u52a0\u8f7d\u4e2d";
                                    }
                                    FullScreenLoadingKt.FullScreenLoading(LoadingType.LOADING_WITH_BOTTOM, str, null, null, composer4, 6, 12);
                                }
                                composer4.endReplaceableGroup();
                                composer4.startReplaceableGroup(652715158);
                                if (Intrinsics.areEqual(AdelieTtsSettingPage.this.getViewMode().showCreatFloatView._state.getValue(), bool)) {
                                    AdelieCreateTtsViewModel access$getCreateViewModel = AdelieTtsSettingPage.access$getCreateViewModel(AdelieTtsSettingPage.this);
                                    final AdelieTtsSettingPage adelieTtsSettingPage5 = AdelieTtsSettingPage.this;
                                    TtsCreateFloatViewKt.TtsCreateFloatView(access$getCreateViewModel, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Boolean bool2) {
                                            boolean booleanValue = bool2.booleanValue();
                                            AdelieTtsSettingPage adelieTtsSettingPage6 = AdelieTtsSettingPage.this;
                                            int i16 = AdelieTtsSettingPage.$r8$clinit;
                                            adelieTtsSettingPage6.getViewMode().showCreatFloatView._state.setValue(Boolean.FALSE);
                                            if (booleanValue) {
                                                final AdelieTtsSettingViewModel viewMode2 = AdelieTtsSettingPage.this.getViewMode();
                                                final String str2 = AdelieTtsSettingPage.access$getCreateViewModel(AdelieTtsSettingPage.this).currentTaskId;
                                                viewMode2.getClass();
                                                AdelieTtsInfo selectTtsInfo = AdelieTtsDataManager.INSTANCE.getSelectTtsInfo();
                                                final String str3 = selectTtsInfo != null ? selectTtsInfo.ttsId : null;
                                                BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new AdelieOIDBServer$requestTtsList$1(new Function3<Integer, String, s, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingViewModel$fetchTtsInfoByCreate$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(Integer num3, String str4, s sVar) {
                                                        AdelieTtsInfo ttsInfoById;
                                                        int intValue3 = num3.intValue();
                                                        s sVar2 = sVar;
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("fetchTtsInfoByCreate errCode: ", intValue3, " errMsg: ", str4, ", rsp: ");
                                                        m3.append(sVar2);
                                                        kLog.i("AdelieTtsSettingViewModel", m3.toString());
                                                        if (intValue3 == 0 && sVar2 != null) {
                                                            AdelieTtsSettingViewModel.access$handleMyTtsList(AdelieTtsSettingViewModel.this, sVar2);
                                                            String str5 = str3;
                                                            if (str5 != null && (ttsInfoById = AdelieTtsDataManager.INSTANCE.getTtsInfoById(str5)) != null) {
                                                                ttsInfoById.playState$delegate.setValue(TtsPlayState.COMPLETED);
                                                            }
                                                            AdelieTtsSettingViewModel.access$handleTtsLoadingState(AdelieTtsSettingViewModel.this, PollingEntrance.CURRENT_CREATE, str2);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, null), 3, null);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, composer4, 8);
                                }
                                composer4.endReplaceableGroup();
                                final AdelieTtsSettingPage adelieTtsSettingPage6 = AdelieTtsSettingPage.this;
                                AdelieTtsSettingPage.access$contentContainer(adelieTtsSettingPage6, 88.0f, ComposableLambdaKt.composableLambda(composer4, -177273057, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.5

                                    /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$onCreate$1$1$5$WhenMappings */
                                    /* loaded from: classes31.dex */
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[PageState.values().length];
                                            try {
                                                iArr[0] = 1;
                                            } catch (NoSuchFieldError unused) {
                                            }
                                            try {
                                                iArr[1] = 2;
                                            } catch (NoSuchFieldError unused2) {
                                            }
                                            try {
                                                iArr[2] = 3;
                                            } catch (NoSuchFieldError unused3) {
                                            }
                                            $EnumSwitchMapping$0 = iArr;
                                        }
                                    }

                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer5, Integer num3) {
                                        b bVar3 = bVar2;
                                        Composer composer6 = composer5;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            intValue3 |= composer6.changed(bVar3) ? 4 : 2;
                                        }
                                        if ((intValue3 & 91) == 18 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-177273057, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.<anonymous>.<anonymous>.<anonymous> (AdelieTtsSettingPage.kt:170)");
                                            }
                                            AdelieTtsSettingPage adelieTtsSettingPage7 = AdelieTtsSettingPage.this;
                                            int i16 = AdelieTtsSettingPage.$r8$clinit;
                                            PageState value2 = adelieTtsSettingPage7.getViewMode().pageState._state.getValue();
                                            int i17 = value2 != null ? WhenMappings.$EnumSwitchMapping$0[value2.ordinal()] : -1;
                                            if (i17 == 1) {
                                                composer6.startReplaceableGroup(9673894);
                                                composer6.endReplaceableGroup();
                                            } else if (i17 == 2) {
                                                composer6.startReplaceableGroup(9674007);
                                                AdelieTtsSettingPage.this.getViewMode().showLoading._state.setValue(Boolean.FALSE);
                                                AdelieTtsSettingPage.this.SuccessContent(bVar3, composer6, (intValue3 & 14) | 64);
                                                composer6.endReplaceableGroup();
                                            } else if (i17 != 3) {
                                                composer6.startReplaceableGroup(9674632);
                                                composer6.endReplaceableGroup();
                                            } else {
                                                composer6.startReplaceableGroup(9674192);
                                                AdelieTtsSettingPage.this.getViewMode().showLoading._state.setValue(Boolean.FALSE);
                                                final AdelieTtsSettingPage adelieTtsSettingPage8 = AdelieTtsSettingPage.this;
                                                TtsErrorViewKt.TtsErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.onCreate.1.1.5.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        AdelieTtsSettingPage adelieTtsSettingPage9 = AdelieTtsSettingPage.this;
                                                        int i18 = AdelieTtsSettingPage.$r8$clinit;
                                                        StateHolder<PageState> stateHolder = adelieTtsSettingPage9.getViewMode().pageState;
                                                        stateHolder._state.setValue(PageState.LOADING);
                                                        AdelieTtsSettingPage.this.getViewMode().fetchTtsInfoFromServer();
                                                        return Unit.INSTANCE;
                                                    }
                                                }, composer6, 0);
                                                composer6.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, PlayerResources.ViewId.GET_MORE_TOGGLE_AREA);
                                AdelieTtsSettingPage.access$shadowBackground(AdelieTtsSettingPage.this, composer4, 8);
                                AdelieTtsSettingPage.access$morePopDownMenu(AdelieTtsSettingPage.this, composer4, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer2, 3080, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo>, java.util.ArrayList] */
    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        List<? extends AdelieTtsInfo> emptyList;
        super.onDestroy();
        getViewMode().getTtsInfoStateManager().callback = null;
        AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
        ListStateHolder<AdelieTtsInfo> listStateHolder = AdelieTtsDataManager.myTtsInfoList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        listStateHolder.updateValueList(emptyList);
        AdelieTtsDataManager.officialTtsInfoList.clear();
        AdelieTtsDataManager.ttsInfoList.clear();
        AdelieTtsInfo selectTtsInfo = adelieTtsDataManager.getSelectTtsInfo();
        if (selectTtsInfo != null) {
            AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule = (AdelieKuiklyTTSPageModule) c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
            e eVar = new e();
            eVar.v("ttsId", selectTtsInfo.ttsId);
            eVar.v("ttsName", selectTtsInfo.getTtsName());
            eVar.v("ttsExample", selectTtsInfo.ttsExample);
            AdelieKuiklyTTSPageModule.stopTtsVoice$default(adelieKuiklyTTSPageModule, eVar);
        }
        this.polarLightView = null;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
        AdelieTtsInfo selectTtsInfo = AdelieTtsDataManager.INSTANCE.getSelectTtsInfo();
        if (selectTtsInfo != null) {
            AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule = (AdelieKuiklyTTSPageModule) c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
            e eVar = new e();
            eVar.v("ttsId", selectTtsInfo.ttsId);
            eVar.v("ttsName", selectTtsInfo.getTtsName());
            eVar.v("ttsExample", selectTtsInfo.ttsExample);
            AdelieKuiklyTTSPageModule.stopTtsVoice$default(adelieKuiklyTTSPageModule, eVar);
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
        m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
        m3.v("cur_pg", m16);
        ReportKt.reportCustomDTEvent("dt_pgout", m3);
        AdeliePolarLightView adeliePolarLightView = this.polarLightView;
        if (adeliePolarLightView != null) {
            AbstractBaseView.callRenderViewMethod$default(adeliePolarLightView, "stopAnimation", "", null, 4, null);
        }
        getViewMode().isResume = false;
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_ugc_tone_selection");
        e eVar2 = new e();
        eVar2.v("dt_pgid", "pg_bas_ugc_tone_selection");
        eVar2.v("current_timbre", AdelieTtsReport.currentTimbreId);
        eVar.v("cur_pg", eVar2);
        ReportKt.reportCustomDTEvent("dt_pgin", eVar);
        AdeliePolarLightView adeliePolarLightView = this.polarLightView;
        if (adeliePolarLightView != null) {
            AbstractBaseView.callRenderViewMethod$default(adeliePolarLightView, QZoneJsConstants.ACTION_START_ANIMATION, "", null, 4, null);
        }
        getViewMode().isResume = true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }

    public final void reportOneSelect(String str) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
        m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", "em_bas_one_click_selection");
        m3.v("timbre_id", getSettingParams(getPageData()).ttsId);
        ReportKt.reportCustomDTEvent(str, m3);
    }

    public final void SuccessContent(final b bVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(657762657);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(657762657, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.SuccessContent (AdelieTtsSettingPage.kt:258)");
        }
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new AdelieTtsSettingPage$SuccessContent$1(this, null), startRestartGroup, 64);
        renderLazyColumn(startRestartGroup, 8);
        createVoiceButton(bVar, startRestartGroup, (i3 & 14) | 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$SuccessContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.this.SuccessContent(bVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void createVoiceButton(final b bVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-495767651);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-495767651, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.createVoiceButton (AdelieTtsSettingPage.kt:303)");
        }
        if (!((Boolean) this.enableCreateClone$delegate.getValue()).booleanValue()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$createVoiceButton$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    AdelieTtsSettingPage.this.createVoiceButton(bVar, composer2, i3 | 1);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$createVoiceButton$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
                m3.v("cur_pg", m16);
                m3.v("dt_eid", "em_bas_create_my_voice");
                ReportKt.reportCustomDTEvent("dt_clck", m3);
                if (AdelieTtsDataManager.INSTANCE.hasVoiceIsCreate()) {
                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u58f0\u97f3\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019", QToastMode.Warning);
                } else {
                    AdelieTtsSettingPage adelieTtsSettingPage = AdelieTtsSettingPage.this;
                    adelieTtsSettingPage.getClass();
                    if (AdelieTtsDataManager.myTtsInfoList._stateList.size() >= adelieTtsSettingPage.getViewMode().maxUserTtsCount) {
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u8fbe\u5230\u521b\u5efa\u4e0a\u9650", QToastMode.Warning);
                    } else {
                        AdelieCreateTtsViewModel adelieCreateTtsViewModel = (AdelieCreateTtsViewModel) adelieTtsSettingPage.createViewModel$delegate.getValue();
                        adelieCreateTtsViewModel.getClass();
                        KLog.INSTANCE.i("AdelieTtsSettingViewModel", "fetchTtsReadTextFromServer");
                        BuildersKt.e(adelieCreateTtsViewModel.requestScope, null, null, new AdelieCreateTtsViewModel$fetchTtsReadTextFromServer$1(adelieCreateTtsViewModel, null), 3, null);
                        StateHolder<Boolean> stateHolder = adelieTtsSettingPage.getViewMode().showCreatFloatView;
                        stateHolder._state.setValue(Boolean.TRUE);
                    }
                }
                return Unit.INSTANCE;
            }
        }, ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.n(bVar.a(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 45.0f), QUIToken.color$default("button_bg_primary_default")), 4.0f), Alignment.BottomCenter), 16.0f, 0.0f, 16.0f, 58.0f, 2, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$createVoiceButton$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
                m3.v("cur_pg", m16);
                m3.v("dt_eid", "em_bas_create_my_voice");
                ReportKt.reportCustomDTEvent("dt_imp", m3);
                return Unit.INSTANCE;
            }
        }), com.tencent.ntcompose.material.e.f339415a.a(h.INSTANCE.n()), ComposableSingletons$AdelieTtsSettingPageKt.f16lambda1, startRestartGroup, 29184, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$createVoiceButton$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.this.createVoiceButton(bVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void renderLazyColumn(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1802164672);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1802164672, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.renderLazyColumn (AdelieTtsSettingPage.kt:267)");
        }
        d a16 = com.tencent.ntcompose.foundation.lazy.e.a(0, 0.0f, startRestartGroup, 0, 3);
        this.lazyListState = a16;
        LazyColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 0.0f, 0.0f, 0.0f, ((Boolean) this.enableCreateClone$delegate.getValue()).booleanValue() ? 119.0f : 0.0f, 7, null), null, a16, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 284788539, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$renderLazyColumn$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(284788539, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage.renderLazyColumn.<anonymous> (AdelieTtsSettingPage.kt:274)");
                }
                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f), composer3, 8, 0);
                TtsListKt.TtsList(aVar2, AdelieTtsSettingPage.this.getViewMode(), composer3, 72);
                AdelieTtsSettingPage adelieTtsSettingPage = AdelieTtsSettingPage.this;
                if (!adelieTtsSettingPage.isFirstEnter) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    adelieTtsSettingPage.isFirstEnter = false;
                    final float a17 = ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).a();
                    AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
                    AdelieTtsSettingPage adelieTtsSettingPage2 = AdelieTtsSettingPage.this;
                    final int findIndex = ListExtKt.findIndex(AdelieTtsDataManager.ttsInfoList, new AdelieTtsDataManager$getTtsIndexById$1(adelieTtsSettingPage2.getSettingParams(adelieTtsSettingPage2.getPageData()).ttsId));
                    final AdelieTtsSettingPage adelieTtsSettingPage3 = AdelieTtsSettingPage.this;
                    TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$renderLazyColumn$1.1

                        @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$renderLazyColumn$1$1$1", f = "AdelieTtsSettingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$renderLazyColumn$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes31.dex */
                        public final class C13911 extends SuspendLambda implements Function2<com.tencent.kuikly.core.coroutines.b, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ int $position;
                            public final /* synthetic */ float $rootHeight;
                            public final /* synthetic */ AdelieTtsSettingPage this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C13911(int i3, float f16, AdelieTtsSettingPage adelieTtsSettingPage, Continuation<? super C13911> continuation) {
                                super(2, continuation);
                                this.$position = i3;
                                this.$rootHeight = f16;
                                this.this$0 = adelieTtsSettingPage;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C13911(this.$position, this.$rootHeight, this.this$0, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(com.tencent.kuikly.core.coroutines.b bVar, Continuation<? super Unit> continuation) {
                                return ((C13911) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                d dVar;
                                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                ResultKt.throwOnFailure(obj);
                                int i3 = this.$position;
                                if (i3 != -1 && (((i3 + 6) * 48) - this.$rootHeight) + 88.0f > 0.0f && (dVar = this.this$0.lazyListState) != null) {
                                    Boxing.boxBoolean(d.x(dVar, i3, 0.0f, true, null, 8, null));
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            BuildersKt.e(com.tencent.kuikly.core.coroutines.e.f117232d, null, null, new C13911(findIndex, a17, adelieTtsSettingPage3, null), 3, null);
                            return Unit.INSTANCE;
                        }
                    });
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$renderLazyColumn$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AdelieTtsSettingPage.this.renderLazyColumn(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
