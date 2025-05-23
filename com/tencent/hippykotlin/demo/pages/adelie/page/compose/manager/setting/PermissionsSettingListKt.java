package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.GuardFastClickKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyColumnKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* loaded from: classes31.dex */
public final class PermissionsSettingListKt {
    public static final void ItemGroup(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(1830910376);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function2) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1830910376, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.ItemGroup (PermissionsSettingList.kt:64)");
            }
            ColumnKt.a(ModifiersKt.q(ModifiersKt.c(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null)), QUIToken.color$default("fill_light_primary")), c.a(8.0f)), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1935064657, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$ItemGroup$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1935064657, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.ItemGroup.<anonymous> (PermissionsSettingList.kt:68)");
                        }
                        function2.invoke(composer3, Integer.valueOf(i16 & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$ItemGroup$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingListKt.ItemGroup(function2, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void settingReport(int i3, String str) {
        String str2;
        if (i3 == 1) {
            str2 = "em_bas_publicly_visible";
        } else {
            str2 = "em_bas_share_visibility";
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_permission_setting");
        e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_agent_permission_setting");
        m16.t("check_status", AdeliePermissionSettingReport.type);
        m16.u("agent_uin", AdeliePermissionSettingReport.uin);
        m3.v("cur_pg", m16);
        m3.v("dt_eid", str2);
        ReportKt.reportCustomDTEvent(str, m3);
    }

    public static final void PermissionsSettingList(final PermissionsSettingViewModel permissionsSettingViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(834291374);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(834291374, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingList (PermissionsSettingList.kt:45)");
        }
        LazyColumnKt.a(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), null, null, null, null, null, null, Boolean.FALSE, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1244093481, true, new Function3<a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$PermissionsSettingList$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(a aVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1244093481, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingList.<anonymous> (PermissionsSettingList.kt:49)");
                }
                final PermissionsSettingViewModel permissionsSettingViewModel2 = PermissionsSettingViewModel.this;
                PermissionsSettingListKt.ItemGroup(ComposableLambdaKt.composableLambda(composer3, 1599956296, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$PermissionsSettingList$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Composer composer4, Integer num2) {
                        Composer composer5 = composer4;
                        int intValue2 = num2.intValue();
                        if ((intValue2 & 11) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1599956296, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingList.<anonymous>.<anonymous> (PermissionsSettingList.kt:50)");
                            }
                            PermissionsSettingListKt.SettingListItem("\u516c\u5f00\u53ef\u89c1", 1, PermissionsSettingViewModel.this, composer5, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.5f), QUIToken.color$default("border_standard")), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), composer5, 8, 0);
                            PermissionsSettingListKt.SettingListItem("\u4ec5\u5206\u4eab\u53ef\u89c1", 2, PermissionsSettingViewModel.this, composer5, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 12582920, 0, MsgConstant.KRMFILETHUMBSIZE384, 4194174);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$PermissionsSettingList$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingListKt.PermissionsSettingList(PermissionsSettingViewModel.this, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void SettingListItem(final String str, final int i3, final PermissionsSettingViewModel permissionsSettingViewModel, Composer composer, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1378746399);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1378746399, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.SettingListItem (PermissionsSettingList.kt:90)");
        }
        i d16 = ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 72.0f), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                final int i17 = i3;
                final PermissionsSettingViewModel permissionsSettingViewModel2 = permissionsSettingViewModel;
                GuardFastClickKt.guardFastClick(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        int i18 = i17;
                        PermissionsSettingViewModel permissionsSettingViewModel3 = permissionsSettingViewModel2;
                        Integer value = permissionsSettingViewModel3.settingType._state.getValue();
                        if (value == null || i18 != value.intValue()) {
                            StateHolder<Integer> stateHolder = permissionsSettingViewModel3.settingType;
                            stateHolder._state.setValue(Integer.valueOf(i18));
                            k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                            e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("type", i18);
                            Unit unit = Unit.INSTANCE;
                            k.d(kVar, "adelie_manager_permission_type", m3, false, 4, null);
                        }
                        PermissionsSettingListKt.settingReport(i17, "dt_clck");
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }, 3, null);
        Integer valueOf = Integer.valueOf(i3);
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(valueOf);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj) {
                    PermissionsSettingListKt.settingReport(i3, "dt_imp");
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.a(ViewEventPropUpdaterKt.r(d16, (Function1) rememberedValue), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1777958681, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1777958681, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.SettingListItem.<anonymous> (PermissionsSettingList.kt:107)");
                    }
                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), h.INSTANCE.j());
                    Alignment.Vertical c17 = Alignment.INSTANCE.c();
                    a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                    final String str2 = str;
                    final int i17 = i16;
                    final PermissionsSettingViewModel permissionsSettingViewModel2 = permissionsSettingViewModel;
                    final int i18 = i3;
                    RowKt.a(c16, e16, c17, null, null, ComposableLambdaKt.composableLambda(composer3, 301058697, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(301058697, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.SettingListItem.<anonymous>.<anonymous> (PermissionsSettingList.kt:113)");
                                }
                                QUIToken qUIToken = QUIToken.INSTANCE;
                                h color$default = QUIToken.color$default("text_primary");
                                int e17 = ai.INSTANCE.e();
                                TextKt.a(str2, null, null, color$default, Float.valueOf(17.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(e17), Float.valueOf(20.0f), null, null, null, null, an.d(an.INSTANCE.b()), null, 1, null, null, null, null, null, null, null, false, composer5, (i17 & 14) | 1601536, 102236208, 0, 133886886);
                                Integer value = permissionsSettingViewModel2.settingType._state.getValue();
                                int i19 = i18;
                                if (value != null && value.intValue() == i19) {
                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 20.0f), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, qUIToken.image("qui_check", QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2095967);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.setting.PermissionsSettingListKt$SettingListItem$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                PermissionsSettingListKt.SettingListItem(str, i3, permissionsSettingViewModel, composer2, i16 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
