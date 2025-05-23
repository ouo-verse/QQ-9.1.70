package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import defpackage.k;
import h25.al;
import h25.am;
import h25.g;
import h25.v;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BotListCellKt {
    public static final void report(String str, int i3, al alVar, e eVar) {
        v vVar;
        v vVar2;
        e eVar2 = new e(eVar.toString());
        eVar2.v("dt_eid", "em_bas_agent_card");
        eVar2.t("serial_number", i3 + 1);
        eVar2.v("agent_id", alVar.f404163i);
        eVar2.u("agent_uin", alVar.f404159d);
        eVar2.v("agent_name", alVar.f404160e);
        am amVar = alVar.f404164m;
        Long l3 = null;
        eVar2.v("friends_number", (amVar == null || (vVar2 = amVar.f404165d) == null) ? null : Long.valueOf(vVar2.f404245d));
        am amVar2 = alVar.f404164m;
        if (amVar2 != null && (vVar = amVar2.f404165d) != null) {
            l3 = Long.valueOf(vVar.f404246e);
        }
        eVar2.v("message_number", l3);
        eVar2.v("cur_pg", eVar);
        ReportKt.reportCustomDTEvent(str, eVar2);
    }

    public static final void BotListCell(final int i3, final al alVar, final e eVar, final Set<String> set, final Function1<? super Boolean, Unit> function1, AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(633414070);
        final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo2 = (i17 & 32) != 0 ? null : adelieRedDotModule$Companion$RedDotInfo;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(633414070, i16, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell (BotListCell.kt:44)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.b(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 83.0f), new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f16) {
                float floatValue = f16.floatValue();
                if (!set.contains(alVar.f404163i) && floatValue >= 0.5f) {
                    BotListCellKt.report("dt_imp", i3, alVar, eVar);
                    set.add(alVar.f404163i);
                } else if (floatValue <= 0.0f) {
                    set.remove(alVar.f404163i);
                }
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(AdelieCreativeCenterDataManager.managerSchemeConfig, "&page_name=adelie_manager_page&uid=");
                m3.append(al.this.f404163i);
                m3.append("&robot_uin=");
                m3.append(al.this.f404159d);
                String sb5 = m3.toString();
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default(sb5, false, 6);
                function1.invoke(Boolean.FALSE);
                BotListCellKt.report("dt_clck", i3, al.this, eVar);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1331047208, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                int i18;
                n nVar2 = nVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i18 = (composer3.changed(nVar2) ? 4 : 2) | intValue;
                } else {
                    i18 = intValue;
                }
                if ((i18 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1331047208, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell.<anonymous> (BotListCell.kt:72)");
                    }
                    float f16 = k.a(c.f117352a) ? 50.0f : 56.0f;
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, f16), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), f16 / 2), new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, QUIToken.color$default("overlay_standard_secondary"))), null, 0, null, null, al.this.f404161f, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2096095);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.f(companion, 0.0f, 1, null), 12.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    a aVar = a.f339245a;
                    a.e b16 = aVar.b();
                    final al alVar2 = al.this;
                    ColumnKt.a(n3, b16, null, null, ComposableLambdaKt.composableLambda(composer3, -1337345969, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Object firstOrNull;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1337345969, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell.<anonymous>.<anonymous> (BotListCell.kt:85)");
                                }
                                String str = al.this.f404160e;
                                h color$default = QUIToken.color$default("text_primary");
                                bp3.c f17 = bp3.c.INSTANCE.f();
                                int b17 = an.INSTANCE.b();
                                i.Companion companion2 = i.INSTANCE;
                                TextKt.a(str, ComposeLayoutPropUpdaterKt.x(ComposeLayoutPropUpdaterKt.z(companion2), 0.0f, 140.0f), null, color$default, Float.valueOf(16.0f), null, f17, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, an.d(b17), null, 1, null, null, null, null, null, null, null, false, composer5, 1601600, 102236208, 0, 133887908);
                                final al alVar3 = al.this;
                                RowKt.a(null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, -1964436751, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt.BotListCell.3.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar3, Composer composer6, Integer num3) {
                                        v vVar;
                                        v vVar2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1964436751, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell.<anonymous>.<anonymous>.<anonymous> (BotListCell.kt:96)");
                                            }
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u597d\u53cb ");
                                            am amVar = al.this.f404164m;
                                            Long l3 = null;
                                            m3.append((amVar == null || (vVar2 = amVar.f404165d) == null) ? null : Long.valueOf(vVar2.f404245d));
                                            String sb5 = m3.toString();
                                            h color$default2 = QUIToken.color$default("text_secondary");
                                            c.Companion companion3 = bp3.c.INSTANCE;
                                            TextKt.a(sb5, null, null, color$default2, Float.valueOf(14.0f), null, companion3.e(), null, null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 48, 0, 134215590);
                                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6d88\u606f ");
                                            am amVar2 = al.this.f404164m;
                                            if (amVar2 != null && (vVar = amVar2.f404165d) != null) {
                                                l3 = Long.valueOf(vVar.f404246e);
                                            }
                                            m16.append(l3);
                                            TextKt.a(m16.toString(), ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 10.0f, 0.0f, 0.0f, 0.0f, 14, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion3.e(), null, null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601600, 48, 0, 134215588);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196608, 31);
                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) al.this.C);
                                final h25.e eVar2 = (h25.e) firstOrNull;
                                if (eVar2 != null) {
                                    ButtonKt.a(null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            QQKuiklyPlatformApi.Companion companion3 = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.openPage$default(h25.e.this.f404198f, false, 6);
                                            return Unit.INSTANCE;
                                        }
                                    }, ModifiersKt.c(ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(companion2, 17.0f), 6.0f, 0.0f, 6.0f, 0.0f, 10, null), 4.0f), new h(436247039L)), null, ComposableLambdaKt.composableLambda(composer5, -1031451014, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar3, Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1031451014, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BotListCell.kt:121)");
                                                }
                                                StringBuilder m3 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('#');
                                                m3.append(h25.e.this.f404197e);
                                                TextKt.a(m3.toString(), null, null, new h(4278229503L), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), null, null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 48, 0, 134215590);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 25088, 9);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 12);
                    SpacerKt.a(nVar2.a(companion, 1.0f), composer3, 8, 0);
                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                    Alignment.Vertical c16 = Alignment.INSTANCE.c();
                    a.d c17 = aVar.c();
                    final al alVar3 = al.this;
                    final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo3 = adelieRedDotModule$Companion$RedDotInfo2;
                    RowKt.a(j3, c17, c16, null, null, ComposableLambdaKt.composableLambda(composer3, 1753898106, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
                        
                            if ((r2.length() > 0) == true) goto L42;
                         */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar3, Composer composer4, Integer num2) {
                            int i19;
                            String str;
                            Composer composer5;
                            n nVar4 = nVar3;
                            Composer composer6 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 14) == 0) {
                                i19 = (composer6.changed(nVar4) ? 4 : 2) | intValue2;
                            } else {
                                i19 = intValue2;
                            }
                            if ((i19 & 91) == 18 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1753898106, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCell.<anonymous>.<anonymous> (BotListCell.kt:139)");
                                }
                                g gVar = al.this.G;
                                if (gVar == null || (str = gVar.f404205f) == null) {
                                    str = "";
                                }
                                String str2 = str;
                                boolean z16 = true;
                                if (str2.length() > 0) {
                                    composer6.startReplaceableGroup(1294708626);
                                    composer5 = composer6;
                                    TextKt.a(str2, ComposeLayoutPropUpdaterKt.n(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, QUIToken.color$default("icon_secondary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 1601600, 48, 0, 134215460);
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer6.startReplaceableGroup(1294709063);
                                    h25.an anVar = al.this.E;
                                    if (anVar != null && (r2 = anVar.f404169e) != null) {
                                    }
                                    z16 = false;
                                    if (z16) {
                                        composer6.startReplaceableGroup(1294709143);
                                        h25.an anVar2 = al.this.E;
                                        Intrinsics.checkNotNull(anVar2);
                                        TextKt.a(anVar2.f404169e, ComposeLayoutPropUpdaterKt.n(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, QUIToken.color$default("feedback_error"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer6, (com.tencent.ntcompose.material.n.f339436b << 21) | 1601600, 48, 0, 134215460);
                                        composer6.endReplaceableGroup();
                                        composer5 = composer6;
                                    } else if (adelieRedDotModule$Companion$RedDotInfo3 != null) {
                                        composer6.startReplaceableGroup(1294709659);
                                        TextKt.a(adelieRedDotModule$Companion$RedDotInfo3.redDotText, ComposeLayoutPropUpdaterKt.n(nVar4.b(i.INSTANCE, Alignment.INSTANCE.c()), 0.0f, 0.0f, 8.0f, 0.0f, 11, null), null, QUIToken.color$default("icon_secondary"), Float.valueOf(12.0f), null, bp3.c.INSTANCE.e(), new com.tencent.ntcompose.material.n("PingFang SC"), null, null, null, Float.valueOf(27.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer6, (com.tencent.ntcompose.material.n.f339436b << 21) | 1601600, 48, 0, 134215460);
                                        composer5 = composer6;
                                        RedDotKt.RedDot(composer5, 0);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5 = composer6;
                                        composer5.startReplaceableGroup(1294710171);
                                        composer5.endReplaceableGroup();
                                    }
                                    composer5.endReplaceableGroup();
                                }
                                ImageKt.a(QUIToken.INSTANCE.image("arrow_right", QUIToken.color$default("icon_secondary")), null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 16.0f, 16.0f), 0.0f, 0.0f, 16.0f, 0.0f, 11, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 262144, 0, 0, 2097118);
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
        }), startRestartGroup, 197000, 26);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final AdelieRedDotModule$Companion$RedDotInfo adelieRedDotModule$Companion$RedDotInfo3 = adelieRedDotModule$Companion$RedDotInfo2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BotListCellKt.BotListCell(i3, alVar, eVar, set, function1, adelieRedDotModule$Companion$RedDotInfo3, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
