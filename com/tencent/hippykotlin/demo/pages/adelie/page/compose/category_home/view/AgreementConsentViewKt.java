package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.animation.l;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.AlertCustomDialogKt;
import com.tencent.ntcompose.material.AlertDialogTransitionType;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.aj;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AgreementConsentViewKt {
    public static final void access$report(String str, String str2, e eVar) {
        e eVar2 = new e(eVar.toString());
        eVar2.v("dt_eid", str2);
        eVar2.v("cur_pg", eVar);
        eVar2.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
        ReportKt.reportCustomDTEvent(str, eVar2);
    }

    public static final void agreementConsentView(final Function0<Unit> function0, final e eVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(341319251);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(341319251, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.agreementConsentView (AgreementConsentView.kt:141)");
        }
        ColumnKt.a(ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 0.0f, FloatExtKt.getTo812(165.0f), 0.0f, 0.0f, 13, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$agreementConsentView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                AgreementConsentViewKt.access$report("dt_imp", "em_bas_convention_popup", e.this);
                return Unit.INSTANCE;
            }
        }), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1451381878, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$agreementConsentView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ComposerKt.traceEventStart(-1451381878, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.agreementConsentView.<anonymous> (AgreementConsentView.kt:155)");
                    }
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    i r16 = ModifiersKt.r(ModifiersKt.e(ModifiersKt.q(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 296.0f), 395.0f), c.a(8.0f)), Direction.TO_BOTTOM_RIGHT, new j(new h(qUIToken.isNightMode() ? 4468931L : 9877247L, 1.0f), 0.0f), new j(new h(qUIToken.isNightMode() ? 6444271L : 15528703L, 1.0f), 0.27f), new j(new h(qUIToken.isNightMode() ? 16052991L : 16777215L, 1.0f), 1.0f)), true);
                    Alignment alignment = Alignment.Center;
                    final e eVar2 = e.this;
                    final Function0<Unit> function02 = function0;
                    BoxKt.a(r16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 1327378064, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$agreementConsentView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1327378064, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.agreementConsentView.<anonymous>.<anonymous> (AgreementConsentView.kt:174)");
                                }
                                i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                final e eVar3 = e.this;
                                final Function0<Unit> function03 = function02;
                                final float f16 = 296.0f;
                                ColumnKt.a(h16, null, null, null, ComposableLambdaKt.composableLambda(composer5, -574982649, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt.agreementConsentView.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar2, Composer composer6, Integer num3) {
                                        int i16;
                                        String str;
                                        d dVar3 = dVar2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i16 = (composer7.changed(dVar3) ? 4 : 2) | intValue3;
                                        } else {
                                            i16 = intValue3;
                                        }
                                        if ((i16 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-574982649, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.agreementConsentView.<anonymous>.<anonymous>.<anonymous> (AgreementConsentView.kt:178)");
                                            }
                                            if (QUIToken.INSTANCE.isNightMode()) {
                                                str = "https://bot-resource-1251316161.file.myqcloud.com/media/WBZBFGyU.png";
                                            } else {
                                                str = "https://static-res.qq.com/static-res/agent/dialog.png";
                                            }
                                            i.Companion companion = i.INSTANCE;
                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f16), 184.0f), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, str, null, null, null, null, null, new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt.agreementConsentView.2.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                    return Unit.INSTANCE;
                                                }
                                            }, null, null, null, null, composer7, 12845056, 1572864, 0, 2030431);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 5.0f), composer7, 8, 0);
                                            AgreementConsentViewKt.innerText("\u2022 \u5171\u5b88\u793e\u533a\u516c\u7ea6\uff0c\u5411\u8fdd\u89c4\u5185\u5bb9\u8bf4\u201c\u4e0d\u201d", composer7, 6, 0);
                                            AgreementConsentViewKt.innerText("\u2022 \u53cb\u597d\u4e92\u52a8\uff0c\u7528\u7231\u8fde\u63a5\u6570\u5b57\u751f\u547d", composer7, 6, 0);
                                            AgreementConsentViewKt.innerText("\u2022 \u5584\u7528AI\u6280\u672f\uff0c\u53d1\u6325\u6b63\u9762\u79ef\u6781\u4f5c\u7528", composer7, 6, 0);
                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 8.0f), composer7, 8, 0);
                                            i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 260.0f), 40.0f);
                                            Alignment.Companion companion2 = Alignment.INSTANCE;
                                            i b16 = dVar3.b(k3, companion2.b());
                                            a.C0144a c0144a = new a.C0144a(0, 1, null);
                                            h color$default = QUIToken.color$default("text_primary");
                                            aj.Companion companion3 = aj.INSTANCE;
                                            int e16 = c0144a.e(new bp3.j(color$default, Float.valueOf(14.0f), null, null, null, null, aj.d(companion3.b()), null, null, null, null, null, null, null, null, 32700, null));
                                            try {
                                                c0144a.a("\u70b9\u51fb\u89c6\u4e3a\u540c\u610f");
                                                Unit unit = Unit.INSTANCE;
                                                c0144a.c(e16);
                                                e16 = c0144a.e(new bp3.j(QUIToken.color$default("text_link"), Float.valueOf(14.0f), null, null, null, null, aj.d(companion3.b()), null, null, null, null, null, null, null, null, 32700, null));
                                                try {
                                                    c0144a.a("\u300aQQ\u667a\u80fd\u4f53\u7cfb\u670d\u52a1\u534f\u8bae\u300b\n");
                                                    c0144a.c(e16);
                                                    e16 = c0144a.e(new bp3.j(QUIToken.color$default("text_link"), Float.valueOf(14.0f), null, null, null, null, aj.d(companion3.b()), null, null, null, null, null, null, null, null, 32700, null));
                                                    try {
                                                        c0144a.a("\u300aQQ\u667a\u80fd\u4f53\u7cfb\u793e\u533a\u516c\u7ea6\u300b");
                                                        c0144a.c(e16);
                                                        a f17 = c0144a.f();
                                                        final e eVar4 = eVar3;
                                                        RichTextKt.a(f17, b16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new Function2<Integer, ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt.agreementConsentView.2.1.1.3
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(Integer num4, ClickParams clickParams) {
                                                                int intValue4 = num4.intValue();
                                                                if (intValue4 == 1) {
                                                                    QQKuiklyPlatformApi.Companion companion4 = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.openPage$default("https://rule.tencent.com/rule/202404080001", false, 6);
                                                                    AgreementConsentViewKt.access$report("dt_clck", "em_bas_agent_service_agreement", e.this);
                                                                    KLog.INSTANCE.i("", "spanIndex 0");
                                                                } else if (intValue4 == 2) {
                                                                    QQKuiklyPlatformApi.Companion companion5 = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.openPage$default("https://act.qzone.qq.com/v2/vip/tx/p/52081_70e8a14a?enteranceId=moren&_wv=3&_wwv=513", false, 6);
                                                                    AgreementConsentViewKt.access$report("dt_clck", "em_bas_agent_community_convention", e.this);
                                                                    KLog.INSTANCE.i("", "spanIndex 1");
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, composer7, 64, 0, 0, 67108860);
                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 24.0f), composer7, 8, 0);
                                                        i b17 = dVar3.b(ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 236.0f), 45.0f), 4.0f), QUIToken.color$default("button_bg_primary_default")), companion2.b());
                                                        final Function0<Unit> function04 = function03;
                                                        final e eVar5 = eVar3;
                                                        ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt.agreementConsentView.2.1.1.4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function04.invoke();
                                                                AgreementConsentViewKt.access$report("dt_clck", "em_bas_know", eVar5);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, b17, null, ComposableSingletons$AgreementConsentViewKt.f4lambda1, composer7, 25088, 9);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    } finally {
                                                    }
                                                } finally {
                                                }
                                            } finally {
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$agreementConsentView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AgreementConsentViewKt.agreementConsentView(function0, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void showAgreementConsentView(final Function0<Unit> function0, final Function0<Unit> function02, final e eVar, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(580291786);
        if ((i16 & 1) != 0) {
            function0 = null;
        }
        if ((i16 & 2) != 0) {
            function02 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(580291786, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.showAgreementConsentView (AgreementConsentView.kt:62)");
        }
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (k.a(cVar)) {
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed(function0);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showAgreementConsentView$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function03 = function0;
                        if (function03 != null) {
                            function03.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Function0 function03 = (Function0) rememberedValue;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed(function02);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showAgreementConsentView$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function04 = function02;
                        if (function04 != null) {
                            function04.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            showDialogWithAgreementConsentView(function03, (Function0) rememberedValue2, eVar, startRestartGroup, 512, 0);
        } else if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
            String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&use_host_display_metrics=1", "&page_name=adelie_agreement_consent_page&modal_mode=1&is_animated=0");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.openPage$default(m3, false, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function0<Unit> function04 = function0;
        final Function0<Unit> function05 = function02;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showAgreementConsentView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AgreementConsentViewKt.showAgreementConsentView(function04, function05, eVar, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void showDialogWithAgreementConsentView(Function0<Unit> function0, Function0<Unit> function02, final e eVar, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1220081284);
        final Function0<Unit> function03 = (i16 & 1) != 0 ? null : function0;
        final Function0<Unit> function04 = (i16 & 2) != 0 ? null : function02;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1220081284, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.showDialogWithAgreementConsentView (AgreementConsentView.kt:96)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        boolean booleanValue = ((Boolean) mutableState.getValue()).booleanValue();
        h a16 = h.INSTANCE.a(0.5f);
        AlertDialogTransitionType alertDialogTransitionType = AlertDialogTransitionType.DIRECTION_FROM_CENTER;
        l b16 = com.tencent.ntcompose.animation.b.b(0.85f, 0.0f, 0, 0.0f, null, 0, false, 126, null);
        m d16 = com.tencent.ntcompose.animation.b.d(200, 0, com.tencent.ntcompose.animation.i.c(), null, 10, null);
        Alignment alignment = Alignment.TopCenter;
        AgreementConsentViewKt$showDialogWithAgreementConsentView$1 agreementConsentViewKt$showDialogWithAgreementConsentView$1 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function04);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Lazy lazy;
                    lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$2$1$adelieKuiklyModule$2
                        @Override // kotlin.jvm.functions.Function0
                        public final AdelieKuiklyBaseModule invoke() {
                            return (AdelieKuiklyBaseModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
                        }
                    });
                    AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) lazy.getValue();
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ADELIE_HOME_PAGE_HAS_SHOW_USER_AGREEMENT_");
                    m3.append(PageDataExtKt.getUin(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData()));
                    String sb5 = m3.toString();
                    adelieKuiklyBaseModule.getClass();
                    adelieKuiklyBaseModule.setStringToCache$enumunboxing$(sb5, String.valueOf(true), 1, 2);
                    Function0<Unit> function05 = function04;
                    if (function05 != null) {
                        function05.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Function0 function05 = (Function0) rememberedValue2;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed2 = startRestartGroup.changed(function03);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    Function0<Unit> function06 = function03;
                    if (function06 != null) {
                        function06.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        final Function0<Unit> function06 = function04;
        final Function0<Unit> function07 = function03;
        AlertCustomDialogKt.a(booleanValue, true, a16, agreementConsentViewKt$showDialogWithAgreementConsentView$1, alertDialogTransitionType, function05, (Function0) rememberedValue3, alignment, b16, d16, ComposableLambdaKt.composableLambda(startRestartGroup, -493436305, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-493436305, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.showDialogWithAgreementConsentView.<anonymous> (AgreementConsentView.kt:130)");
                    }
                    final MutableState<Boolean> mutableState2 = mutableState;
                    composer3.startReplaceableGroup(1157296644);
                    boolean changed3 = composer3.changed(mutableState2);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                mutableState2.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    AgreementConsentViewKt.agreementConsentView((Function0) rememberedValue4, eVar, composer3, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 113274416, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$showDialogWithAgreementConsentView$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                AgreementConsentViewKt.showDialogWithAgreementConsentView(function07, function06, eVar, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void innerText(String str, Composer composer, final int i3, final int i16) {
        final String str2;
        int i17;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1170808055);
        int i18 = i16 & 1;
        if (i18 != 0) {
            i17 = i3 | 6;
            str2 = str;
        } else if ((i3 & 14) == 0) {
            str2 = str;
            i17 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
        } else {
            str2 = str;
            i17 = i3;
        }
        if ((i17 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            String str3 = i18 != 0 ? "" : str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1170808055, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.innerText (AgreementConsentView.kt:270)");
            }
            composer2 = startRestartGroup;
            String str4 = str3;
            TextKt.a(str4, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 280.0f), 20.0f), 30.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_primary"), Float.valueOf(14.0f), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.c()), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer2, (i17 & 14) | 1601600, 48, 0, 134214564);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$innerText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                AgreementConsentViewKt.innerText(str2, composer3, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
