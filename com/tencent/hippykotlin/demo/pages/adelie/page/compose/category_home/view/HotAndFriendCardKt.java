package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.HotDelegateData;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import g25.a;
import g25.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class HotAndFriendCardKt {
    public static final void HotAndFriendCard(final HotDelegateData hotDelegateData, final e eVar, Composer composer, final int i3) {
        final MutableState mutableStateOf$default;
        List chunked;
        Composer startRestartGroup = composer.startRestartGroup(1967575113);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1967575113, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCard (HotAndFriendCard.kt:34)");
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : hotDelegateData.cards) {
            chunked = CollectionsKt___CollectionsKt.chunked(aVar.f401136i, 3);
            Pair pair = new Pair(aVar, chunked);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        float f16 = 2 * 16.0f;
        final float e16 = (((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - f16) - 44.0f;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        BoxKt.a(ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.w(ViewEventPropUpdaterKt.r(i.INSTANCE, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar2 = e.this;
                e eVar3 = new e(eVar2.toString());
                eVar3.v("dt_eid", "em_bas_top_recommendation_card");
                eVar3.v("cur_pg", eVar2);
                eVar3.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
                ReportKt.reportCustomDTEvent("dt_imp", eVar3);
                return Unit.INSTANCE;
            }
        }), ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() - f16)), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -669322289, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                b bVar2 = bVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i16 = (composer3.changed(bVar2) ? 4 : 2) | intValue;
                } else {
                    i16 = intValue;
                }
                if ((i16 & 91) == 18 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-669322289, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCard.<anonymous> (HotAndFriendCard.kt:47)");
                    }
                    i.Companion companion = i.INSTANCE;
                    i j3 = ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null);
                    LinkedHashMap<a, List<List<k>>> linkedHashMap2 = linkedHashMap;
                    QUIToken qUIToken = QUIToken.INSTANCE;
                    h color$default = QUIToken.color$default("fill_light_primary");
                    float f17 = e16;
                    i E = ModifiersKt.E(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, f17), 270.0f), false);
                    int size = linkedHashMap.size();
                    final MutableState<Integer> mutableState = mutableStateOf$default;
                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer3, -952309140, true, new Function5<Integer, a, Boolean, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(5);
                        }

                        @Override // kotlin.jvm.functions.Function5
                        public final Unit invoke(Integer num2, a aVar2, Boolean bool, Composer composer4, Integer num3) {
                            String str;
                            c e17;
                            int intValue2 = num2.intValue();
                            a aVar3 = aVar2;
                            boolean booleanValue = bool.booleanValue();
                            Composer composer5 = composer4;
                            int intValue3 = num3.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-952309140, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCard.<anonymous>.<anonymous> (HotAndFriendCard.kt:58)");
                            }
                            if (booleanValue) {
                                mutableState.setValue(Integer.valueOf(intValue2));
                            }
                            String str2 = aVar3.f401133e;
                            if (booleanValue) {
                                str = "brand_standard";
                            } else {
                                str = "text_primary";
                            }
                            h color$default2 = QUIToken.color$default(str);
                            if (booleanValue) {
                                e17 = c.INSTANCE.f();
                            } else {
                                e17 = c.INSTANCE.e();
                            }
                            TextKt.a(str2, ComposeLayoutPropUpdaterKt.s(i.INSTANCE, intValue2 == 0 ? 16.0f : 12.0f, 0.0f, 0.0f, 0.0f, 14, null), null, color$default2, Float.valueOf(17.0f), null, e17, null, null, null, null, Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 28736, 48, 0, 134215588);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final e eVar2 = eVar;
                    Function1<a, Unit> function1 = new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(a aVar2) {
                            e eVar3 = e.this;
                            e eVar4 = new e();
                            eVar4.v("tab_name", aVar2.f401133e);
                            Unit unit = Unit.INSTANCE;
                            e eVar5 = new e(eVar3.toString());
                            eVar5.v("dt_eid", "em_bas_top_tab");
                            eVar5.v("cur_pg", eVar3);
                            Iterator<String> c16 = eVar4.c();
                            if (c16 != null) {
                                while (c16.hasNext()) {
                                    String next = c16.next();
                                    eVar5.v(next, eVar4.e(next));
                                }
                            }
                            eVar5.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
                            ReportKt.reportCustomDTEvent("dt_clck", eVar5);
                            return Unit.INSTANCE;
                        }
                    };
                    final e eVar3 = eVar;
                    TabAndViewPagerKt.TabAndViewPager(j3, false, linkedHashMap2, color$default, 50.0f, f17, E, size, 2, false, composableLambda, function1, null, ComposableLambdaKt.composableLambda(composer3, -1604787449, true, new Function7<Integer, List<? extends k>, Integer, a, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2.3
                        {
                            super(7);
                        }

                        @Override // kotlin.jvm.functions.Function7
                        public final Unit invoke(Integer num2, List<? extends k> list, Integer num3, a aVar2, Integer num4, Composer composer4, Integer num5) {
                            num2.intValue();
                            List<? extends k> list2 = list;
                            num3.intValue();
                            a aVar3 = aVar2;
                            int intValue2 = num4.intValue();
                            Composer composer5 = composer4;
                            int intValue3 = num5.intValue();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1604787449, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCard.<anonymous>.<anonymous> (HotAndFriendCard.kt:82)");
                            }
                            HotAndFriendPageKt.HotAndFriendPage(list2, aVar3, intValue2, e.this, composer5, 4168);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 102789688, 3462, 512);
                    final String str = hotDelegateData.cards.get(mutableStateOf$default.getValue().intValue()).f401135h;
                    if (str.length() > 0) {
                        i o16 = ComposeLayoutPropUpdaterKt.o(bVar2.a(ComposeLayoutPropUpdaterKt.u(companion, 16.0f), Alignment.TopEnd), -16.0f, 20.0f);
                        final e eVar4 = eVar;
                        i r16 = ViewEventPropUpdaterKt.r(o16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                e eVar5 = e.this;
                                e eVar6 = new e(eVar5.toString());
                                eVar6.v("dt_eid", "em_bas_top_right_arrow");
                                eVar6.v("cur_pg", eVar5);
                                eVar6.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card");
                                ReportKt.reportCustomDTEvent("dt_imp", eVar6);
                                return Unit.INSTANCE;
                            }
                        });
                        final e eVar5 = eVar;
                        ImageKt.a(qUIToken.image("arrow_right", QUIToken.color$default("icon_primary")), null, null, null, null, ViewEventPropUpdaterKt.d(r16, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                QQKuiklyPlatformApi.Companion.openPage$default(str, false, 6);
                                e eVar6 = eVar5;
                                e eVar7 = new e(eVar6.toString());
                                eVar7.v("dt_eid", "em_bas_top_right_arrow");
                                eVar7.v("cur_pg", eVar6);
                                eVar7.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, "em_bas_top_recommendation_card");
                                ReportKt.reportCustomDTEvent("dt_clck", eVar7);
                                return Unit.INSTANCE;
                            }
                        }, 3, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotAndFriendCardKt$HotAndFriendCard$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                HotAndFriendCardKt.HotAndFriendCard(HotDelegateData.this, eVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
