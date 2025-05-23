package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RoleDelegateData;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.LazyVerticalGridKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import g25.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import uo3.b;
import uo3.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class RoleCardKt {
    public static final e access$getRoleCardReportParams(RoleDelegateData roleDelegateData) {
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m(IPublicAccountConfigAttr.CARD_STYLE, 2);
        m3.v("subject_name", roleDelegateData.card.f401133e);
        return m3;
    }

    public static final void RoleCard(final RoleDelegateData roleDelegateData, final e eVar, final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-77976463);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-77976463, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCard (RoleCard.kt:34)");
        }
        final float e16 = (((((a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 32.0f) - 11.0f) - 32.0f) / 2;
        final int ceil = (int) Math.ceil(roleDelegateData.card.f401136i.size() / 2.0d);
        ColumnKt.a(ViewEventPropUpdaterKt.r(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - 32.0f), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$RoleCard$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar2 = e.this;
                e access$getRoleCardReportParams = RoleCardKt.access$getRoleCardReportParams(roleDelegateData);
                e eVar3 = new e(eVar2.toString());
                eVar3.v("dt_eid", "em_bas_theme_card");
                eVar3.v("cur_pg", eVar2);
                Iterator<String> c16 = access$getRoleCardReportParams.c();
                if (c16 != null) {
                    while (c16.hasNext()) {
                        String next = c16.next();
                        eVar3.v(next, access$getRoleCardReportParams.e(next));
                    }
                }
                eVar3.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
                ReportKt.reportCustomDTEvent("dt_imp", eVar3);
                return Unit.INSTANCE;
            }
        }), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1403713830, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$RoleCard$2
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
                        ComposerKt.traceEventStart(-1403713830, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCard.<anonymous> (RoleCard.kt:50)");
                    }
                    i z16 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null));
                    h color$default = QUIToken.color$default("fill_light_primary");
                    b a16 = c.a(8.0f);
                    final RoleDelegateData roleDelegateData2 = RoleDelegateData.this;
                    final e eVar2 = eVar;
                    final float f16 = e16;
                    final int i16 = ceil;
                    final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = adelieHomeCategoryViewModel;
                    SurfaceKt.a(z16, a16, null, color$default, ComposableLambdaKt.composableLambda(composer3, 1559891868, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$RoleCard$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(1559891868, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCard.<anonymous>.<anonymous> (RoleCard.kt:55)");
                                }
                                RoleDelegateData roleDelegateData3 = RoleDelegateData.this;
                                g25.a aVar = roleDelegateData3.card;
                                CardTitleKt.CardTitle(aVar.f401133e, aVar.f401135h, eVar2, RoleCardKt.access$getRoleCardReportParams(roleDelegateData3), composer5, g.f247730p1, 0);
                                i.Companion companion = i.INSTANCE;
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 6.0f), composer5, 8, 0);
                                r.a aVar2 = new r.a(2);
                                float e17 = ((a) composer5.consume(CompositionLocalsKt.d())).e() - 32.0f;
                                i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, ((a) composer5.consume(CompositionLocalsKt.d())).e() - 32.0f), ((r5 - 1) * 12.0f) + ((f16 + 74.0f) * i16)), 16.0f, 0.0f, 16.0f, 0.0f, 10, null);
                                Boolean bool = Boolean.FALSE;
                                final RoleDelegateData roleDelegateData4 = RoleDelegateData.this;
                                final float f17 = f16;
                                final e eVar3 = eVar2;
                                final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel3 = adelieHomeCategoryViewModel2;
                                LazyVerticalGridKt.a(aVar2, s16, e17, null, null, null, 11.0f, 12.0f, bool, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer5, 49117217, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt.RoleCard.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar3, Composer composer6, Integer num3) {
                                        com.tencent.ntcompose.foundation.lazy.layout.a aVar4 = aVar3;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(49117217, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCard.<anonymous>.<anonymous>.<anonymous> (RoleCard.kt:69)");
                                        }
                                        final RoleDelegateData roleDelegateData5 = RoleDelegateData.this;
                                        List<k> list = roleDelegateData5.card.f401136i;
                                        final float f18 = f17;
                                        final e eVar4 = eVar3;
                                        final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel4 = adelieHomeCategoryViewModel3;
                                        LazyDslKt.c(aVar4, list, null, ComposableLambdaKt.composableLambda(composer7, -1000149306, true, new Function4<Integer, k, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt.RoleCard.2.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public final Unit invoke(Integer num4, k kVar, Composer composer8, Integer num5) {
                                                num4.intValue();
                                                k kVar2 = kVar;
                                                Composer composer9 = composer8;
                                                int intValue4 = num5.intValue();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1000149306, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RoleCard.kt:70)");
                                                }
                                                RoleCardItemKt.RoleCardItem(kVar2, f18, eVar4, "em_bas_bot_entry", null, null, "em_bas_theme_card", RoleCardKt.access$getRoleCardReportParams(roleDelegateData5), adelieHomeCategoryViewModel4, composer9, 152792584, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 3144, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 114819136, 0, 1572864, 67108408);
                                SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer5, 8, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 28680, 4);
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$RoleCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                RoleCardKt.RoleCard(RoleDelegateData.this, eVar, adelieHomeCategoryViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
