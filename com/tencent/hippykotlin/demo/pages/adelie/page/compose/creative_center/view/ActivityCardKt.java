package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

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
import com.tencent.luggage.wxa.gf.d0;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import h25.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ActivityCardKt {
    public static final void report(String str, String str2, e eVar) {
        e eVar2 = new e(eVar.toString());
        eVar2.v("dt_eid", "em_bas_inspiration_gas_station");
        eVar2.v("activity_id", str2);
        eVar2.v("cur_pg", eVar);
        ReportKt.reportCustomDTEvent(str, eVar2);
    }

    public static final void ActivityCard(final d dVar, final e eVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-372844649);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-372844649, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCard (ActivityCard.kt:29)");
        }
        SurfaceKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.g(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt$ActivityCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                ActivityCardKt.report("dt_imp", d.this.f404190d, eVar);
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt$ActivityCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(d.this.F, false, 6);
                ActivityCardKt.report("dt_clck", d.this.f404190d, eVar);
                return Unit.INSTANCE;
            }
        }, 3, null), c.a(8.0f), null, QUIToken.color$default("bg_bottom_light"), ComposableLambdaKt.composableLambda(startRestartGroup, -1483961383, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt$ActivityCard$3
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
                        ComposerKt.traceEventStart(-1483961383, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCard.<anonymous> (ActivityCard.kt:41)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(companion, 52.0f), 0.0f, 1, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                    a.e e16 = a.f339245a.e();
                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                    final d dVar2 = d.this;
                    RowKt.a(s16, e16, vertical, null, null, ComposableLambdaKt.composableLambda(composer3, 1719065979, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt$ActivityCard$3.1
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
                                    ComposerKt.traceEventStart(1719065979, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCard.<anonymous>.<anonymous> (ActivityCard.kt:46)");
                                }
                                String str = d.this.f404192f;
                                h color$default = QUIToken.color$default("text_primary");
                                c.Companion companion2 = bp3.c.INSTANCE;
                                TextKt.a(str, null, null, color$default, Float.valueOf(17.0f), null, companion2.f(), null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 48, 0, 134215590);
                                TextKt.a(d.this.f404191e, null, null, QUIToken.color$default("text_secondary_light"), Float.valueOf(12.0f), null, companion2.e(), null, null, null, null, Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601536, 48, 0, 134215590);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 197064, 24);
                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), ((((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e() - 30) * 110) / d0.CTRL_INDEX), null, com.tencent.ntcompose.material.h.INSTANCE.a(), null, null, d.this.f404193h, null, null, null, null, null, null, null, null, null, null, composer3, 12845056, 0, 0, 2095967);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.ActivityCardKt$ActivityCard$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ActivityCardKt.ActivityCard(d.this, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
