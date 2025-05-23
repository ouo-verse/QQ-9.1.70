package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.util.AdelieCategoryAIOJumpUtil;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.an;
import com.tencent.ntcompose.material.base.ModifiersKt;
import g25.k;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HotAndFriendItemKt {
    public static final void access$report(String str, e eVar, String str2, long j3, int i3) {
        e eVar2 = new e();
        eVar2.v("tab_name", str2);
        eVar2.u("agent_uin", j3);
        eVar2.t("serial_number", i3);
        Unit unit = Unit.INSTANCE;
        e eVar3 = new e(eVar.toString());
        eVar3.v("dt_eid", "em_bas_bot_entry");
        eVar3.v("cur_pg", eVar);
        Iterator<String> c16 = eVar2.c();
        if (c16 != null) {
            while (c16.hasNext()) {
                String next = c16.next();
                eVar3.v(next, eVar2.e(next));
            }
        }
        eVar3.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card");
        ReportKt.reportCustomDTEvent(str, eVar3);
    }

    public static final void HotAndFriendItem(final int i3, final k kVar, final int i16, final e eVar, final String str, Composer composer, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(1306439158);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1306439158, i17, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItem (HotAndFriendItem.kt:46)");
        }
        RowKt.a(ViewEventPropUpdaterKt.d(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 90.0f), 16.0f, 0.0f, 0.0f, 0.0f, 14, null), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt$HotAndFriendItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar2 = e.this;
                String str2 = str;
                k kVar2 = kVar;
                HotAndFriendItemKt.access$report("dt_imp", eVar2, str2, kVar2.f401171d, kVar2.L);
                return Unit.INSTANCE;
            }
        }), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt$HotAndFriendItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                AdelieCategoryAIOJumpUtil.INSTANCE.jumpToAIO$qecommerce_biz_release(k.this, null, null, false);
                e eVar2 = eVar;
                String str2 = str;
                k kVar2 = k.this;
                HotAndFriendItemKt.access$report("dt_clck", eVar2, str2, kVar2.f401171d, kVar2.L);
                return Unit.INSTANCE;
            }
        }, 3, null), null, Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -303592556, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt$HotAndFriendItem$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(n nVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-303592556, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItem.<anonymous> (HotAndFriendItem.kt:65)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, ModifiersKt.g(ModifiersKt.j(ComposeLayoutPropUpdaterKt.u(companion, 56.0f), 28.0f), new com.tencent.kuikly.core.base.e(0.5f, BorderStyle.SOLID, QUIToken.color$default("overlay_standard_secondary"))), null, 0, null, null, k.this.f401175f, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2096095);
                    i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 70.0f), 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    Alignment.Vertical f16 = Alignment.INSTANCE.f();
                    final int i18 = i3;
                    final k kVar2 = k.this;
                    final int i19 = i16;
                    final int i26 = i17;
                    RowKt.a(n3, null, f16, null, null, ComposableLambdaKt.composableLambda(composer3, -1269218126, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt$HotAndFriendItem$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                            h color$default;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1269218126, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItem.<anonymous>.<anonymous> (HotAndFriendItem.kt:84)");
                                }
                                i.Companion companion2 = i.INSTANCE;
                                i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(companion2), 22.0f);
                                String valueOf = String.valueOf(i18);
                                int i27 = i18;
                                if (i27 == 1) {
                                    color$default = QUIToken.color$default("feedback_error");
                                } else if (i27 == 2) {
                                    color$default = new h(255, 139, 73, 1.0f);
                                } else if (i27 != 3) {
                                    color$default = QUIToken.color$default("text_secondary");
                                } else {
                                    color$default = new h(255, 179, 0, 1.0f);
                                }
                                TextKt.a(valueOf, k3, null, color$default, Float.valueOf(16.0f), null, null, new com.tencent.ntcompose.material.n("DIN-NextLT-Pro-QQ"), null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, (com.tencent.ntcompose.material.n.f339436b << 21) | 28736, 48, 0, 134215524);
                                i f17 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.n(companion2, 6.0f, 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null), 0.0f, 1, null);
                                final k kVar3 = kVar2;
                                final int i28 = i19;
                                final int i29 = i26;
                                ColumnKt.a(f17, null, null, null, ComposableLambdaKt.composableLambda(composer5, -112858085, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt.HotAndFriendItem.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(d dVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-112858085, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItem.<anonymous>.<anonymous>.<anonymous> (HotAndFriendItem.kt:101)");
                                            }
                                            String str2 = k.this.f401173e;
                                            h color$default2 = QUIToken.color$default("text_primary");
                                            c.Companion companion3 = c.INSTANCE;
                                            c f18 = companion3.f();
                                            an.Companion companion4 = an.INSTANCE;
                                            int b16 = companion4.b();
                                            i.Companion companion5 = i.INSTANCE;
                                            TextKt.a(str2, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), 6.0f, 0.0f, 0.0f, 0.0f, 14, null), null, color$default2, Float.valueOf(16.0f), null, f18, null, null, null, null, Float.valueOf(22.0f), null, null, null, null, an.d(b16), null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 102236208, 0, 133887908);
                                            TextKt.a(k.this.f401177h, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), 6.0f, 6.0f, 0.0f, 0.0f, 12, null), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion3.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, an.d(companion4.b()), null, 1, null, null, null, null, null, null, null, false, composer7, 1601600, 102236208, 0, 133887908);
                                            HotViewKt.LightHotView(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(companion5, 20.0f), 6.0f, 2.0f, 0.0f, 0.0f, 12, null), k.this, i28, true, composer7, (i29 & 896) | 3144, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
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
                    }), composer3, 196616, 26);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendItemKt$HotAndFriendItem$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HotAndFriendItemKt.HotAndFriendItem(i3, kVar, i16, eVar, str, composer2, i17 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
