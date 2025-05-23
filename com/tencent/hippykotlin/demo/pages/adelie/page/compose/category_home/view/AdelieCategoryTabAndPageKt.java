package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomeTrace;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.AdelieHomeCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.Category;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel.RecommondPageData;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIScanningLightKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import defpackage.k;
import g25.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdelieCategoryTabAndPageKt {
    public static final void access$report(String str, String str2, String str3, e eVar) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("tab_name", str2, "tabid", str3);
        Unit unit = Unit.INSTANCE;
        e eVar2 = new e(eVar.toString());
        eVar2.v("dt_eid", "em_bas_tab");
        eVar2.v("cur_pg", eVar);
        Iterator<String> c16 = m3.c();
        if (c16 != null) {
            while (c16.hasNext()) {
                String next = c16.next();
                eVar2.v(next, m3.e(next));
            }
        }
        eVar2.v(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, null);
        ReportKt.reportCustomDTEvent(str, eVar2);
    }

    public static final void AdelieCategoryTabAndPage(final AdelieHomeCategoryViewModel adelieHomeCategoryViewModel, final AdelieCategoryHomeTrace adelieCategoryHomeTrace, final e eVar, Composer composer, final int i3) {
        final Lazy lazy;
        List<h> emptyList;
        Composer composer2;
        List listOf;
        Composer startRestartGroup = composer.startRestartGroup(-1264504780);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1264504780, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPage (AdelieCategoryTabAndPage.kt:36)");
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyHomePageModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$adelieKuiklyHomePageModule$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieKuiklyHomePageModule invoke() {
                return (AdelieKuiklyHomePageModule) c.f117352a.g().acquireModule("AdelieKuiklyHomePageModule");
            }
        });
        adelieHomeCategoryViewModel.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Category value = adelieHomeCategoryViewModel._category._state.getValue();
        if (value == null || (emptyList = value.data) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        for (h hVar : emptyList) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(adelieHomeCategoryViewModel.getPageDataWrapper(hVar).recommondPageData);
            linkedHashMap.put(hVar, listOf);
        }
        float e16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).e();
        float d16 = ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d() - 56.0f;
        final int size = linkedHashMap.keySet().size();
        Category value2 = adelieHomeCategoryViewModel._category._state.getValue();
        Intrinsics.checkNotNull(value2);
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(value2.type);
        if (ordinal == 0) {
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(106227840);
            c cVar = c.f117352a;
            if (k.a(cVar)) {
                composer2.startReplaceableGroup(106227879);
                QUIScanningLightKt.QUIScanningLight(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null), 0.0f, 16.0f, 0.0f, 0.0f, 13, null), "category_home", composer2, 56, 0);
                composer2.endReplaceableGroup();
            } else if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                composer2.startReplaceableGroup(106228106);
                QUIScanningLightKt.QUIScanningLight(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), e16 / 0.529661f), "category_home", composer2, 56, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(106228359);
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
        } else if (ordinal != 1) {
            if (ordinal != 2) {
                startRestartGroup.startReplaceableGroup(106231244);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(106230982);
                if (adelieCategoryHomeTrace != null) {
                    adelieCategoryHomeTrace.errorCode = -1L;
                    adelieCategoryHomeTrace.errorTime = zz0.a.f453719a.a();
                    adelieCategoryHomeTrace.report();
                }
                CategoryHomeErrorViewKt.CategoryHomeErrorView(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        KLog.INSTANCE.i("AdelieCategoryTabAndPage", "error view reload");
                        AdelieHomeCategoryViewModel adelieHomeCategoryViewModel2 = AdelieHomeCategoryViewModel.this;
                        adelieHomeCategoryViewModel2.getPageDataWrapper(adelieHomeCategoryViewModel2.defaultCategory).refreshPageData();
                        return Unit.INSTANCE;
                    }
                }, startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            composer2 = startRestartGroup;
        } else {
            startRestartGroup.startReplaceableGroup(106228403);
            if (adelieCategoryHomeTrace != null) {
                adelieCategoryHomeTrace.hasLocalCache = adelieHomeCategoryViewModel.getPageDataWrapper(adelieHomeCategoryViewModel.defaultCategory).hasLocalCache;
            }
            if (adelieCategoryHomeTrace != null) {
                adelieCategoryHomeTrace.dataShowTime = zz0.a.f453719a.a();
                if (adelieCategoryHomeTrace.isReadyToReport()) {
                    adelieCategoryHomeTrace.report();
                }
            }
            i.Companion companion = i.INSTANCE;
            composer2 = startRestartGroup;
            TabAndViewPagerKt.TabAndViewPager(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), ((a) startRestartGroup.consume(CompositionLocalsKt.d())).d()), true, linkedHashMap, com.tencent.kuikly.core.base.h.INSTANCE.j(), 56.0f, e16, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, e16), d16), linkedHashMap.size(), 1, false, ComposableLambdaKt.composableLambda(startRestartGroup, 1874193622, true, new Function5<Integer, h, Boolean, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(5);
                }

                @Override // kotlin.jvm.functions.Function5
                public final Unit invoke(Integer num, h hVar2, Boolean bool, Composer composer3, Integer num2) {
                    bp3.c e17;
                    String str;
                    int intValue = num.intValue();
                    final h hVar3 = hVar2;
                    boolean booleanValue = bool.booleanValue();
                    Composer composer4 = composer3;
                    int intValue2 = num2.intValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1874193622, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPage.<anonymous> (AdelieCategoryTabAndPage.kt:77)");
                    }
                    String str2 = hVar3.f401164e;
                    if (booleanValue) {
                        e17 = bp3.c.INSTANCE.f();
                    } else {
                        e17 = bp3.c.INSTANCE.e();
                    }
                    bp3.c cVar2 = e17;
                    if (booleanValue) {
                        str = "brand_standard";
                    } else {
                        str = "text_primary";
                    }
                    com.tencent.kuikly.core.base.h color$default = QUIToken.color$default(str);
                    i s16 = ComposeLayoutPropUpdaterKt.s(i.INSTANCE, intValue == 0 ? 16.0f : 8.0f, 0.0f, intValue == size + (-1) ? 16.0f : 8.0f, 0.0f, 10, null);
                    final e eVar2 = eVar;
                    TextKt.a(str2, ViewEventPropUpdaterKt.g(s16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            h hVar4 = h.this;
                            AdelieCategoryTabAndPageKt.access$report("dt_imp", hVar4.f401164e, hVar4.f401163d, eVar2);
                            return Unit.INSTANCE;
                        }
                    }), null, color$default, Float.valueOf(17.0f), null, cVar2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer4, 28736, 0, 0, 134217636);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
            }), new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(h hVar2) {
                    h hVar3 = hVar2;
                    lazy.getValue().toNative(false, "clearSuperResolutionImageCache", null, null, false);
                    AdelieCategoryTabAndPageKt.access$report("dt_clck", hVar3.f401164e, hVar3.f401163d, e.this);
                    return Unit.INSTANCE;
                }
            }, ComposableLambdaKt.composableLambda(startRestartGroup, -918152236, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(Integer num, Composer composer3, Integer num2) {
                    int i16;
                    final int intValue = num.intValue();
                    Composer composer4 = composer3;
                    int intValue2 = num2.intValue();
                    if ((intValue2 & 14) == 0) {
                        i16 = (composer4.changed(intValue) ? 4 : 2) | intValue2;
                    } else {
                        i16 = intValue2;
                    }
                    if ((i16 & 91) == 18 && composer4.getSkipping()) {
                        composer4.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-918152236, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPage.<anonymous> (AdelieCategoryTabAndPage.kt:93)");
                        }
                        i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                        final int i17 = size;
                        ColumnKt.a(h16, null, null, null, ComposableLambdaKt.composableLambda(composer4, -1411835139, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer5, Integer num3) {
                                Composer composer6 = composer5;
                                int intValue3 = num3.intValue();
                                if ((intValue3 & 81) == 16 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1411835139, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPage.<anonymous>.<anonymous> (AdelieCategoryTabAndPage.kt:96)");
                                    }
                                    i.Companion companion2 = i.INSTANCE;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 43.0f), composer6, 8, 0);
                                    i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(companion2, 2.0f), 0.0f, 1, null), QUIToken.color$default("brand_standard"));
                                    int i18 = intValue;
                                    SpacerKt.a(ComposeLayoutPropUpdaterKt.n(c16, i18 == 0 ? 16.0f : 8.0f, 0.0f, i18 == i17 - 1 ? 16.0f : 8.0f, 0.0f, 10, null), composer6, 8, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer4, 24584, 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, -35288896, true, new Function7<Integer, StateHolder<RecommondPageData>, Integer, h, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(7);
                }

                @Override // kotlin.jvm.functions.Function7
                public final Unit invoke(Integer num, StateHolder<RecommondPageData> stateHolder, Integer num2, h hVar2, Integer num3, Composer composer3, Integer num4) {
                    num.intValue();
                    StateHolder<RecommondPageData> stateHolder2 = stateHolder;
                    num2.intValue();
                    h hVar3 = hVar2;
                    num3.intValue();
                    Composer composer4 = composer3;
                    int intValue = num4.intValue();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-35288896, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPage.<anonymous> (AdelieCategoryTabAndPage.kt:107)");
                    }
                    AdelieCategoryPageViewKt.AdelieCategoryPageView(stateHolder2, AdelieHomeCategoryViewModel.this, hVar3, eVar, composer4, ((intValue >> 3) & 14) | 4672);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    return Unit.INSTANCE;
                }
            }), composer2, 102789688, 3462, 512);
            composer2.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AdelieCategoryTabAndPageKt$AdelieCategoryTabAndPage$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                AdelieCategoryTabAndPageKt.AdelieCategoryTabAndPage(AdelieHomeCategoryViewModel.this, adelieCategoryHomeTrace, eVar, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
