package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CardTitleKt {
    public static final void CardTitle(final String str, final String str2, final e eVar, e eVar2, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-143469952);
        final e eVar3 = (i16 & 8) != 0 ? null : eVar2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-143469952, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CardTitle (CardTitle.kt:23)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 50.0f), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CardTitleKt$CardTitle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                Iterator<String> c16;
                if (str2.length() > 0) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.openPage$default(str2, false, 6);
                }
                e eVar4 = eVar;
                e eVar5 = eVar3;
                e eVar6 = new e(eVar4.toString());
                eVar6.v("dt_eid", "em_bas_top_right_arrow");
                eVar6.v("cur_pg", eVar4);
                eVar6.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_theme_card");
                if (eVar5 != null && (c16 = eVar5.c()) != null) {
                    while (c16.hasNext()) {
                        String next = c16.next();
                        eVar6.v(next, eVar5.e(next));
                    }
                }
                ReportKt.reportCustomDTEvent("dt_clck", eVar6);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1172749470, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CardTitleKt$CardTitle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i17;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1172749470, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CardTitle.<anonymous> (CardTitle.kt:47)");
                    }
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    h color$default = QUIToken.color$default("text_primary");
                    i.Companion companion = i.INSTANCE;
                    TextKt.a(str, ComposeLayoutPropUpdaterKt.m(companion, 16.0f, 16.0f, 0.0f, 16.0f), null, color$default, Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, (i3 & 14) | 1601600, 48, 0, 134215588);
                    SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                    if (str2.length() > 0) {
                        ImageKt.a(qUIToken.image("arrow_right", QUIToken.color$default("icon_primary")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 16.0f, 16.0f), 0.0f, 20.0f, 16.0f, 14.0f, 1, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 196616, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final e eVar4 = eVar3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.CardTitleKt$CardTitle$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                CardTitleKt.CardTitle(str, str2, eVar, eVar4, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
