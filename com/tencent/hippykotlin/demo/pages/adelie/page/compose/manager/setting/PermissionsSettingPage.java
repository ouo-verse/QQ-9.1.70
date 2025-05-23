package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes31.dex */
public final class PermissionsSettingPage extends BaseComposePager {
    public final Lazy viewModel$delegate;

    public PermissionsSettingPage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PermissionsSettingViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final PermissionsSettingViewModel invoke() {
                return new PermissionsSettingViewModel();
            }
        });
        this.viewModel$delegate = lazy;
    }

    public static final void access$contentContainer(final PermissionsSettingPage permissionsSettingPage, final float f16, final Function3 function3, Composer composer, final int i3) {
        final int i16;
        permissionsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(1469261121);
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
                ComposerKt.traceEventStart(1469261121, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.contentContainer (PermissionsSettingPage.kt:108)");
            }
            BoxKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.f(ModifiersKt.c(i.INSTANCE, h.INSTANCE.j()), 0.0f, 1, null), 0.0f, 1, null), 16.0f, f16, 16.0f, 0.0f), Alignment.Center, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1942131067, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$contentContainer$1
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
                            ComposerKt.traceEventStart(1942131067, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.contentContainer.<anonymous> (PermissionsSettingPage.kt:117)");
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$contentContainer$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingPage.access$contentContainer(PermissionsSettingPage.this, f16, function3, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        AdeliePermissionSettingReport.uin = getPageData().n().n("robot_uin");
        AdeliePermissionSettingReport.type = getPageData().n().j("type");
        StateHolder<Integer> stateHolder = ((PermissionsSettingViewModel) this.viewModel$delegate.getValue()).settingType;
        stateHolder._state.setValue(Integer.valueOf(getPageData().n().j("type")));
        com.tencent.ntcompose.activity.b.c(this, null, ComposableLambdaKt.composableLambdaInstance(-622407792, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$onCreate$1
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
                        ComposerKt.traceEventStart(-622407792, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.onCreate.<anonymous> (PermissionsSettingPage.kt:57)");
                    }
                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j());
                    final PermissionsSettingPage permissionsSettingPage = PermissionsSettingPage.this;
                    BoxKt.a(c16, null, null, ComposableLambdaKt.composableLambda(composer2, 1473220374, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1473220374, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.onCreate.<anonymous>.<anonymous> (PermissionsSettingPage.kt:61)");
                                }
                                PermissionsSettingPage.access$setBkgView(PermissionsSettingPage.this, composer4, 8);
                                PermissionsSettingPage.access$navigationBar(PermissionsSettingPage.this, composer4, 8);
                                final PermissionsSettingPage permissionsSettingPage2 = PermissionsSettingPage.this;
                                PermissionsSettingPage.access$contentContainer(permissionsSettingPage2, 104.0f, ComposableLambdaKt.composableLambda(composer4, 1508356003, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.onCreate.1.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer5, Integer num3) {
                                        Composer composer6 = composer5;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1508356003, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.onCreate.<anonymous>.<anonymous>.<anonymous> (PermissionsSettingPage.kt:64)");
                                            }
                                            PermissionsSettingListKt.PermissionsSettingList((PermissionsSettingViewModel) PermissionsSettingPage.this.viewModel$delegate.getValue(), composer6, 8);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer4, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
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

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onPause() {
        super.onPause();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_agent_permission_setting");
        eVar.t("check_status", AdeliePermissionSettingReport.type);
        eVar.u("agent_uin", AdeliePermissionSettingReport.uin);
        ReportKt.reportCustomDTEvent("dt_pgout", eVar);
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
        e eVar = new e();
        eVar.v("dt_pgid", "pg_bas_agent_permission_setting");
        eVar.t("check_status", AdeliePermissionSettingReport.type);
        eVar.u("agent_uin", AdeliePermissionSettingReport.uin);
        ReportKt.reportCustomDTEvent("dt_pgin", eVar);
    }

    public static final void access$navigationBar(final PermissionsSettingPage permissionsSettingPage, Composer composer, final int i3) {
        permissionsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-1814205247);
        if ((i3 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1814205247, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.navigationBar (PermissionsSettingPage.kt:82)");
            }
            i.Companion companion = i.INSTANCE;
            float f16 = 88.0f / 2;
            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), f16), startRestartGroup, 8, 0);
            BoxKt.a(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(ModifiersKt.c(companion, h.INSTANCE.j()), 0.0f, 1, null), 0.0f, f16, 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$navigationBar$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    return Unit.INSTANCE;
                }
            }), null, null, ComposableSingletons$PermissionsSettingPageKt.f9lambda1, startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$navigationBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingPage.access$navigationBar(PermissionsSettingPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$setBkgView(final PermissionsSettingPage permissionsSettingPage, Composer composer, final int i3) {
        String str;
        permissionsSettingPage.getClass();
        Composer startRestartGroup = composer.startRestartGroup(-2080266301);
        if ((i3 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2080266301, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage.setBkgView (PermissionsSettingPage.kt:72)");
            }
            if (QUIToken.INSTANCE.isNightMode()) {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg_night.png";
            } else {
                str = "https://static-res.qq.com/static-res/adelie/home/home_page_bg.png";
            }
            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, str, null, null, null, null, null, null, null, null, null, null, startRestartGroup, 12845056, 0, 0, 2095967);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingPage$setBkgView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingPage.access$setBkgView(PermissionsSettingPage.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
