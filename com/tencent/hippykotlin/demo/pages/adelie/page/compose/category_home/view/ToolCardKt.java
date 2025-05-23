package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.ToolDelegateData;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ToolCardKt {
    public static final void ToolCard(final a aVar, final ToolDelegateData toolDelegateData, final e eVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(906270438);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(906270438, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCard (ToolCard.kt:22)");
        }
        SurfaceKt.a(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 32.0f), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardKt$ToolCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar2 = e.this;
                e eVar3 = new e();
                ToolDelegateData toolDelegateData2 = toolDelegateData;
                eVar3.t(IPublicAccountConfigAttr.CARD_STYLE, 3);
                eVar3.v("subject_name", toolDelegateData2.card.f401133e);
                Unit unit = Unit.INSTANCE;
                e eVar4 = new e(eVar2.toString());
                eVar4.v("dt_eid", "em_bas_theme_card");
                eVar4.v("cur_pg", eVar2);
                Iterator<String> c16 = eVar3.c();
                if (c16 != null) {
                    while (c16.hasNext()) {
                        String next = c16.next();
                        eVar4.v(next, eVar3.e(next));
                    }
                }
                eVar4.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
                ReportKt.reportCustomDTEvent("dt_imp", eVar4);
                return Unit.INSTANCE;
            }
        }), c.a(8.0f), null, QUIToken.color$default("fill_light_primary"), ComposableLambdaKt.composableLambda(startRestartGroup, 312735784, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardKt$ToolCard$2
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
                        ComposerKt.traceEventStart(312735784, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCard.<anonymous> (ToolCard.kt:39)");
                    }
                    g25.a aVar2 = ToolDelegateData.this.card;
                    CardTitleKt.CardTitle(aVar2.f401133e, aVar2.f401135h, eVar, null, composer3, 512, 8);
                    LazyDslKt.c(aVar, ToolDelegateData.this.card.f401136i, null, ComposableSingletons$ToolCardKt.f5lambda1, composer3, 3144, 2);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(i.INSTANCE, 8.0f), composer3, 8, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 28680, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.ToolCardKt$ToolCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ToolCardKt.ToolCard(a.this, toolDelegateData, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
