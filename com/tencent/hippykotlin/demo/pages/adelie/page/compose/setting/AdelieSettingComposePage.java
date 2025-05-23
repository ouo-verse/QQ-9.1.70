package com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.page.BaseComposePager;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineCommonViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIListSingleLineSwitchViewKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUITokenThemeMode;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* loaded from: classes31.dex */
public final class AdelieSettingComposePage extends BaseComposePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final Lazy viewModel$delegate;

    public AdelieSettingComposePage() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieSettingComposeViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage$viewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieSettingComposeViewModel invoke() {
                return new AdelieSettingComposeViewModel();
            }
        });
        this.viewModel$delegate = lazy;
    }

    public static final AdelieSettingComposeViewModel access$getViewModel(AdelieSettingComposePage adelieSettingComposePage) {
        return (AdelieSettingComposeViewModel) adelieSettingComposePage.viewModel$delegate.getValue();
    }

    public final e getDTPageParam() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_settings");
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        AdelieSettingComposeViewModel adelieSettingComposeViewModel = (AdelieSettingComposeViewModel) this.viewModel$delegate.getValue();
        BuildersKt.e(adelieSettingComposeViewModel.requestScope, null, null, new AdelieSettingComposeViewModel$querySetting$1(adelieSettingComposeViewModel, null, null), 3, null);
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(763403183, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage$onCreate$1
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
                        ComposerKt.traceEventStart(763403183, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.<anonymous> (AdelieSettingComposePage.kt:50)");
                    }
                    i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), QUIToken.color$default("bg_bottom_standard"));
                    final AdelieSettingComposePage adelieSettingComposePage = AdelieSettingComposePage.this;
                    ColumnKt.a(d16, null, null, null, ComposableLambdaKt.composableLambda(composer2, -814435290, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage$onCreate$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer3, Integer num2) {
                            Composer composer4 = composer3;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-814435290, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.<anonymous>.<anonymous> (AdelieSettingComposePage.kt:56)");
                                }
                                QUINavBarKt.QUINavBar(new h(0, 0, 0, 0.0f), null, null, "\u521b\u4f5c\u8005\u8bbe\u7f6e", null, null, null, null, false, 0.0f, composer4, 3080, 1014);
                                i.Companion companion = i.INSTANCE;
                                i n3 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(companion, c.a(8.0f)), 16.0f, 16.0f, 16.0f, 0.0f, 8, null);
                                final AdelieSettingComposePage adelieSettingComposePage2 = AdelieSettingComposePage.this;
                                i r16 = ViewEventPropUpdaterKt.r(n3, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        AdelieSettingComposePage adelieSettingComposePage3 = AdelieSettingComposePage.this;
                                        int i3 = AdelieSettingComposePage.$r8$clinit;
                                        e dTPageParam = adelieSettingComposePage3.getDTPageParam();
                                        AdelieSettingComposePage adelieSettingComposePage4 = AdelieSettingComposePage.this;
                                        dTPageParam.v("dt_eid", "em_bas_visitors_view_data_card");
                                        dTPageParam.t("after_click_state", AdelieSettingComposePage.access$getViewModel(adelieSettingComposePage4).accessible.getValue().booleanValue() ? 1 : 2);
                                        dTPageParam.v("cur_pg", adelieSettingComposePage4.getDTPageParam());
                                        ReportKt.reportCustomDTEvent("dt_imp", dTPageParam);
                                        return Unit.INSTANCE;
                                    }
                                });
                                boolean booleanValue = AdelieSettingComposePage.access$getViewModel(AdelieSettingComposePage.this).accessible.getValue().booleanValue();
                                final AdelieSettingComposePage adelieSettingComposePage3 = AdelieSettingComposePage.this;
                                QUIListSingleLineSwitchViewKt.QUIListSingleLineSwitchView(r16, null, null, "\u5141\u8bb8\u901a\u8fc7\u667a\u80fd\u4f53\u67e5\u770b\u6211", null, booleanValue, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        boolean booleanValue2 = bool.booleanValue();
                                        AdelieSettingComposeViewModel access$getViewModel = AdelieSettingComposePage.access$getViewModel(AdelieSettingComposePage.this);
                                        BuildersKt.e(access$getViewModel.requestScope, null, null, new AdelieSettingComposeViewModel$editSetting$1(booleanValue2, access$getViewModel, null), 3, null);
                                        e dTPageParam = AdelieSettingComposePage.this.getDTPageParam();
                                        AdelieSettingComposePage adelieSettingComposePage4 = AdelieSettingComposePage.this;
                                        dTPageParam.v("dt_eid", "em_bas_visitors_view_data_card");
                                        dTPageParam.t("after_click_state", booleanValue2 ? 1 : 2);
                                        dTPageParam.v("cur_pg", adelieSettingComposePage4.getDTPageParam());
                                        ReportKt.reportCustomDTEvent("dt_clck", dTPageParam);
                                        return Unit.INSTANCE;
                                    }
                                }, composer4, 3080, 22);
                                TextKt.a("\u6253\u5f00\u540e\uff0c\u8bbf\u5ba2\u53ef\u70b9\u51fb\u667a\u80fd\u4f53\u7684\u521b\u5efa\u4eba\u6635\u79f0\u67e5\u770b\u4f60\u7684\u8d44\u6599\u5361\uff0c\u53ef\u4ee5\u5e2e\u4f60\u66f4\u597d\u5730\u6269\u5217\u3002", ComposeLayoutPropUpdaterKt.m(companion, 32.0f, 6.0f, 32.0f, 12.0f), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, null, null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer4, 28742, 48, 0, 134215652);
                                i n16 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.q(companion, c.a(8.0f)), 16.0f, 16.0f, 16.0f, 0.0f, 8, null);
                                final AdelieSettingComposePage adelieSettingComposePage4 = AdelieSettingComposePage.this;
                                i r17 = ViewEventPropUpdaterKt.r(n16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.1.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        AdelieSettingComposePage adelieSettingComposePage5 = AdelieSettingComposePage.this;
                                        int i3 = AdelieSettingComposePage.$r8$clinit;
                                        e dTPageParam = adelieSettingComposePage5.getDTPageParam();
                                        AdelieSettingComposePage adelieSettingComposePage6 = AdelieSettingComposePage.this;
                                        dTPageParam.v("dt_eid", "em_bas_user_agreement");
                                        dTPageParam.v("cur_pg", adelieSettingComposePage6.getDTPageParam());
                                        ReportKt.reportCustomDTEvent("dt_imp", dTPageParam);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AdelieSettingComposePage adelieSettingComposePage5 = AdelieSettingComposePage.this;
                                QUIListSingleLineCommonViewKt.QUIListSingleLineCommonView(ViewEventPropUpdaterKt.d(r17, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.1.1.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        final AdelieSettingComposePage adelieSettingComposePage6 = AdelieSettingComposePage.this;
                                        GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.setting.AdelieSettingComposePage.onCreate.1.1.4.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.openPage$default("https://rule.tencent.com/rule/202404080001", false, 6);
                                                AdelieSettingComposePage adelieSettingComposePage7 = AdelieSettingComposePage.this;
                                                int i3 = AdelieSettingComposePage.$r8$clinit;
                                                e dTPageParam = adelieSettingComposePage7.getDTPageParam();
                                                AdelieSettingComposePage adelieSettingComposePage8 = AdelieSettingComposePage.this;
                                                dTPageParam.v("dt_eid", "em_bas_user_agreement");
                                                dTPageParam.v("cur_pg", adelieSettingComposePage8.getDTPageParam());
                                                ReportKt.reportCustomDTEvent("dt_clck", dTPageParam);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null), null, null, "\u7528\u6237\u534f\u8bae", 0.0f, null, null, null, null, null, null, 0.0f, composer4, 3080, 0, 4086);
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

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidAppear() {
        super.pageDidAppear();
        ReportKt.reportCustomDTEvent("dt_pgin", getDTPageParam());
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void pageDidDisappear() {
        super.pageDidDisappear();
        ReportKt.reportCustomDTEvent("dt_pgout", getDTPageParam());
    }

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity
    public final QUITokenThemeMode quiTokenThemeMode() {
        return QUITokenThemeMode.ONLY_DAY_AND_NIGHT;
    }
}
