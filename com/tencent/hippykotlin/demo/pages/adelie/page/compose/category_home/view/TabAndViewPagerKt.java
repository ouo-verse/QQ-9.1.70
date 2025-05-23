package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.lazy.d;
import com.tencent.ntcompose.foundation.lazy.e;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.PagerListKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TabRowKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import uo3.c;

/* loaded from: classes31.dex */
public final class TabAndViewPagerKt {
    public static final <T, V> void TabAndViewPager(final i iVar, boolean z16, final LinkedHashMap<T, List<V>> linkedHashMap, final h hVar, final float f16, final float f17, final i iVar2, int i3, int i16, boolean z17, final Function5<? super Integer, ? super T, ? super Boolean, ? super Composer, ? super Integer, Unit> function5, final Function1<? super T, Unit> function1, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, final Function7<? super Integer, ? super V, ? super Integer, ? super T, ? super Integer, ? super Composer, ? super Integer, Unit> function7, Composer composer, final int i17, final int i18, final int i19) {
        final List list;
        Composer startRestartGroup = composer.startRestartGroup(-776805768);
        boolean z18 = (i19 & 2) != 0 ? true : z16;
        int i26 = (i19 & 128) != 0 ? 5 : i3;
        int i27 = (i19 & 256) != 0 ? 1 : i16;
        boolean z19 = (i19 & 512) != 0 ? true : z17;
        Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32 = (i19 & 4096) != 0 ? null : function3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-776805768, i17, i18, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager (TabAndViewPager.kt:27)");
        }
        list = CollectionsKt___CollectionsKt.toList(linkedHashMap.keySet());
        if (list.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final boolean z26 = z18;
            final int i28 = i26;
            final int i29 = i27;
            final boolean z27 = z19;
            final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function33 = function32;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    TabAndViewPagerKt.TabAndViewPager(i.this, z26, linkedHashMap, hVar, f16, f17, iVar2, i28, i29, z27, function5, function1, function33, function7, composer2, i17 | 1, i18, i19);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = linkedHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            List<V> list2 = linkedHashMap.get(next);
            if (!(list2 == null || list2.isEmpty())) {
                Iterator<V> it5 = list2.iterator();
                while (it5.hasNext()) {
                    arrayList.add(new Pair(next, it5.next()));
                }
            }
        }
        if (arrayList.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
            if (endRestartGroup2 == null) {
                return;
            }
            final boolean z28 = z18;
            final int i36 = i26;
            final int i37 = i27;
            final boolean z29 = z19;
            final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function34 = function32;
            endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    TabAndViewPagerKt.TabAndViewPager(i.this, z28, linkedHashMap, hVar, f16, f17, iVar2, i36, i37, z29, function5, function1, function34, function7, composer2, i17 | 1, i18, i19);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        final d a16 = e.a(0, 0.0f, startRestartGroup, 0, 3);
        final d a17 = e.a(0, 0.0f, startRestartGroup, 0, 3);
        final boolean z36 = z18;
        final int i38 = i26;
        final int i39 = i27;
        final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function35 = function32;
        final boolean z37 = z19;
        SurfaceKt.a(iVar, c.a(8.0f), null, hVar, ComposableLambdaKt.composableLambda(startRestartGroup, 292419130, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(292419130, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous> (TabAndViewPager.kt:66)");
                    }
                    i z38 = ComposeLayoutPropUpdaterKt.z(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null));
                    a.e b16 = a.f339245a.b();
                    final boolean z39 = z36;
                    final d dVar = a17;
                    final float f18 = f16;
                    final int i46 = i38;
                    final int i47 = i17;
                    final i iVar3 = iVar2;
                    final d dVar2 = a16;
                    final float f19 = f17;
                    final int i48 = i39;
                    final Function3<Integer, Composer, Integer, Unit> function36 = function35;
                    final int i49 = i18;
                    final List<T> list3 = list;
                    final List<Pair<T, V>> list4 = arrayList;
                    final boolean z46 = z37;
                    final Function1<T, Unit> function12 = function1;
                    final Function5<Integer, T, Boolean, Composer, Integer, Unit> function52 = function5;
                    final Function7<Integer, V, Integer, T, Integer, Composer, Integer, Unit> function72 = function7;
                    final LinkedHashMap<T, List<V>> linkedHashMap2 = linkedHashMap;
                    ColumnKt.a(z38, b16, null, null, ComposableLambdaKt.composableLambda(composer3, 1969112817, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar3, Composer composer4, Integer num2) {
                            MutableState mutableState;
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1969112817, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous> (TabAndViewPager.kt:70)");
                                }
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer5.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState2 = (MutableState) rememberedValue;
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                MutableState mutableState3 = (MutableState) rememberedValue2;
                                if (z39) {
                                    composer5.startReplaceableGroup(-2118017440);
                                    int intValue3 = ((Number) mutableState2.getValue()).intValue();
                                    d dVar4 = dVar;
                                    i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f18);
                                    final Function3<Integer, Composer, Integer, Unit> function37 = function36;
                                    final int i56 = i49;
                                    ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer5, -20351960, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue4 = num3.intValue();
                                            if ((intValue4 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-20351960, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:78)");
                                                }
                                                Function3<Integer, Composer, Integer, Unit> function38 = function37;
                                                if (function38 != null) {
                                                    function38.invoke(mutableState2.getValue(), composer7, Integer.valueOf((i56 >> 3) & 112));
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    int i57 = i46;
                                    final List<Object> list5 = list3;
                                    final float f26 = f18;
                                    final List<Pair<Object, Object>> list6 = list4;
                                    final d dVar5 = dVar2;
                                    final boolean z47 = z46;
                                    final Function1<Object, Unit> function13 = function12;
                                    mutableState = mutableState3;
                                    final Function5<Integer, Object, Boolean, Composer, Integer, Unit> function53 = function52;
                                    final int i58 = i49;
                                    TabRowKt.a(intValue3, dVar4, k3, composableLambda, i57, ComposableLambdaKt.composableLambda(composer5, 1292136618, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue4 = num3.intValue();
                                            if ((intValue4 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1292136618, intValue4, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:80)");
                                                }
                                                List<Object> list7 = list5;
                                                float f27 = f26;
                                                MutableState<Integer> mutableState4 = mutableState2;
                                                List<Pair<Object, Object>> list8 = list6;
                                                d dVar6 = dVar5;
                                                boolean z48 = z47;
                                                Function1<Object, Unit> function14 = function13;
                                                final Function5<Integer, Object, Boolean, Composer, Integer, Unit> function54 = function53;
                                                int i59 = i58;
                                                int i65 = 0;
                                                for (final Object obj : list7) {
                                                    int i66 = i65 + 1;
                                                    if (i65 < 0) {
                                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                    }
                                                    i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), f27);
                                                    a.e b17 = a.f339245a.b();
                                                    final MutableState<Integer> mutableState5 = mutableState4;
                                                    final int i67 = i65;
                                                    final List<Pair<Object, Object>> list9 = list8;
                                                    final d dVar7 = dVar6;
                                                    final boolean z49 = z48;
                                                    final Function1<Object, Unit> function15 = function14;
                                                    Function1<ClickParams, Unit> function16 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3$1$2$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            TabAndViewPagerKt.access$changePageWhenClickTab(mutableState5, i67, list9, obj, dVar7, z49);
                                                            function15.invoke(obj);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final int i68 = i59;
                                                    Function1<Object, Unit> function17 = function14;
                                                    final int i69 = i65;
                                                    final MutableState<Integer> mutableState6 = mutableState4;
                                                    TabRowKt.b(k16, function16, b17, null, ComposableLambdaKt.composableLambda(composer7, 1450927335, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3$1$2$1$2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar8, Composer composer8, Integer num4) {
                                                            Composer composer9 = composer8;
                                                            int intValue5 = num4.intValue();
                                                            if ((intValue5 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1450927335, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:88)");
                                                                }
                                                                function54.invoke(Integer.valueOf(i69), obj, Boolean.valueOf(i69 == mutableState6.getValue().intValue()), composer9, Integer.valueOf((i68 << 9) & 7168));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 25096, 8);
                                                    i59 = i68;
                                                    function54 = function54;
                                                    function14 = function17;
                                                    z48 = z48;
                                                    dVar6 = dVar7;
                                                    list8 = list8;
                                                    mutableState4 = mutableState4;
                                                    i65 = i66;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, ((i47 >> 9) & 57344) | 200192, 0);
                                    composer5.endReplaceableGroup();
                                } else {
                                    mutableState = mutableState3;
                                    composer5.startReplaceableGroup(-2118016420);
                                    int intValue4 = ((Number) mutableState2.getValue()).intValue();
                                    i k16 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), f18);
                                    final List<Object> list7 = list3;
                                    final float f27 = f18;
                                    final List<Pair<Object, Object>> list8 = list4;
                                    final d dVar6 = dVar2;
                                    final boolean z48 = z46;
                                    final Function1<Object, Unit> function14 = function12;
                                    final Function5<Integer, Object, Boolean, Composer, Integer, Unit> function54 = function52;
                                    final int i59 = i49;
                                    TabRowKt.c(intValue4, k16, null, ComposableLambdaKt.composableLambda(composer5, -1541169686, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue5 = num3.intValue();
                                            if ((intValue5 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1541169686, intValue5, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:97)");
                                                }
                                                List<Object> list9 = list7;
                                                float f28 = f27;
                                                MutableState<Integer> mutableState4 = mutableState2;
                                                List<Pair<Object, Object>> list10 = list8;
                                                d dVar7 = dVar6;
                                                boolean z49 = z48;
                                                Function1<Object, Unit> function15 = function14;
                                                final Function5<Integer, Object, Boolean, Composer, Integer, Unit> function55 = function54;
                                                int i65 = i59;
                                                int i66 = 0;
                                                for (final Object obj : list9) {
                                                    int i67 = i66 + 1;
                                                    if (i66 < 0) {
                                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                    }
                                                    i k17 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.B(i.INSTANCE), f28);
                                                    a.e b17 = a.f339245a.b();
                                                    final MutableState<Integer> mutableState5 = mutableState4;
                                                    final int i68 = i66;
                                                    final List<Pair<Object, Object>> list11 = list10;
                                                    final d dVar8 = dVar7;
                                                    final boolean z55 = z49;
                                                    final Function1<Object, Unit> function16 = function15;
                                                    Function1<ClickParams, Unit> function17 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3$1$3$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            TabAndViewPagerKt.access$changePageWhenClickTab(mutableState5, i68, list11, obj, dVar8, z55);
                                                            function16.invoke(obj);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    final int i69 = i65;
                                                    Function1<Object, Unit> function18 = function15;
                                                    final int i75 = i66;
                                                    final MutableState<Integer> mutableState6 = mutableState4;
                                                    TabRowKt.b(k17, function17, b17, null, ComposableLambdaKt.composableLambda(composer7, -1323219545, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$3$1$3$1$2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar9, Composer composer8, Integer num4) {
                                                            Composer composer9 = composer8;
                                                            int intValue6 = num4.intValue();
                                                            if ((intValue6 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1323219545, intValue6, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:105)");
                                                                }
                                                                function55.invoke(Integer.valueOf(i75), obj, Boolean.valueOf(i75 == mutableState6.getValue().intValue()), composer9, Integer.valueOf((i69 << 9) & 7168));
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 25096, 8);
                                                    i65 = i69;
                                                    function55 = function55;
                                                    function15 = function18;
                                                    z49 = z49;
                                                    dVar7 = dVar8;
                                                    list10 = list10;
                                                    mutableState4 = mutableState4;
                                                    i66 = i67;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3136, 4);
                                    composer5.endReplaceableGroup();
                                }
                                int intValue5 = ((Number) mutableState2.getValue()).intValue();
                                i iVar4 = iVar3;
                                d dVar7 = dVar2;
                                Float valueOf = Float.valueOf(f19);
                                int i65 = i48;
                                Boolean bool = Boolean.FALSE;
                                final List<Pair<Object, Object>> list9 = list4;
                                final List<Object> list10 = list3;
                                final MutableState mutableState4 = mutableState;
                                Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Integer num3) {
                                        int intValue6 = num3.intValue();
                                        KLog.INSTANCE.e("TabAndViewPager", "onPageIndexDidChanged pageIndex:" + intValue6);
                                        mutableState4.setValue(Integer.valueOf(intValue6));
                                        mutableState2.setValue(Integer.valueOf(list10.indexOf(list9.get(intValue6).getFirst())));
                                        return Unit.INSTANCE;
                                    }
                                };
                                final List<Pair<Object, Object>> list11 = list4;
                                final Function7<Integer, Object, Integer, Object, Integer, Composer, Integer, Unit> function73 = function72;
                                final LinkedHashMap<Object, List<Object>> linkedHashMap3 = linkedHashMap2;
                                final int i66 = i49;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(composer5, -1389485922, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer6, Integer num3) {
                                        com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                        Composer composer7 = composer6;
                                        int intValue6 = num3.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1389485922, intValue6, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:124)");
                                        }
                                        List<Pair<Object, Object>> list12 = list11;
                                        final Function7<Integer, Object, Integer, Object, Integer, Composer, Integer, Unit> function74 = function73;
                                        final MutableState<Integer> mutableState5 = mutableState2;
                                        final LinkedHashMap<Object, List<Object>> linkedHashMap4 = linkedHashMap3;
                                        final int i67 = i66;
                                        LazyDslKt.c(aVar2, list12, null, ComposableLambdaKt.composableLambda(composer7, 2098677255, true, new Function4<Integer, Pair<Object, Object>, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt.TabAndViewPager.3.1.5.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            @Override // kotlin.jvm.functions.Function4
                                            public final Unit invoke(Integer num4, Pair<Object, Object> pair, Composer composer8, Integer num5) {
                                                int i68;
                                                int intValue7 = num4.intValue();
                                                Pair<Object, Object> pair2 = pair;
                                                Composer composer9 = composer8;
                                                int intValue8 = num5.intValue();
                                                if ((intValue8 & 14) == 0) {
                                                    i68 = (composer9.changed(intValue7) ? 4 : 2) | intValue8;
                                                } else {
                                                    i68 = intValue8;
                                                }
                                                if ((intValue8 & 112) == 0) {
                                                    i68 |= composer9.changed(pair2) ? 32 : 16;
                                                }
                                                if ((i68 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && composer9.getSkipping()) {
                                                    composer9.skipToGroupEnd();
                                                } else {
                                                    int i69 = -1;
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2098677255, i68, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPager.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabAndViewPager.kt:125)");
                                                    }
                                                    Function7<Integer, Object, Integer, Object, Integer, Composer, Integer, Unit> function75 = function74;
                                                    Integer valueOf2 = Integer.valueOf(intValue7);
                                                    Object second = pair2.getSecond();
                                                    Integer value = mutableState5.getValue();
                                                    Object first = pair2.getFirst();
                                                    LinkedHashMap<Object, List<Object>> linkedHashMap5 = linkedHashMap4;
                                                    Object second2 = pair2.getSecond();
                                                    Iterator<Map.Entry<Object, List<Object>>> it6 = linkedHashMap5.entrySet().iterator();
                                                    while (true) {
                                                        if (!it6.hasNext()) {
                                                            break;
                                                        }
                                                        int indexOf = it6.next().getValue().indexOf(second2);
                                                        if (indexOf != -1) {
                                                            i69 = indexOf;
                                                            break;
                                                        }
                                                    }
                                                    function75.invoke(valueOf2, second, value, first, Integer.valueOf(i69), composer9, Integer.valueOf((i68 & 14) | ((i67 << 6) & 458752)));
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer7, 3144, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                int i67 = i47;
                                PagerListKt.a(iVar4, null, dVar7, valueOf, intValue5, null, null, null, null, null, null, i65, null, null, bool, 0.0f, function15, null, null, null, null, null, null, composableLambda2, composer5, ((i67 >> 6) & 7168) | 8, ((i67 >> 21) & 112) | 24576, 3072, 8304610);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 12);
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
        ScopeUpdateScope endRestartGroup3 = startRestartGroup.endRestartGroup();
        if (endRestartGroup3 == null) {
            return;
        }
        final boolean z38 = z18;
        final int i46 = i26;
        final int i47 = i27;
        final boolean z39 = z19;
        final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function36 = function32;
        endRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.TabAndViewPagerKt$TabAndViewPager$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TabAndViewPagerKt.TabAndViewPager(i.this, z38, linkedHashMap, hVar, f16, f17, iVar2, i46, i47, z39, function5, function1, function36, function7, composer2, i17 | 1, i18, i19);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void access$changePageWhenClickTab(MutableState mutableState, int i3, List list, Object obj, d dVar, boolean z16) {
        int i16;
        mutableState.setValue(Integer.valueOf(i3));
        Iterator it = list.iterator();
        int i17 = 0;
        do {
            i16 = i17;
            if (!it.hasNext()) {
                return;
            } else {
                i17 = i16 + 1;
            }
        } while (!Intrinsics.areEqual(((Pair) it.next()).getFirst(), obj));
        d.x(dVar, i16, 0.0f, z16, null, 10, null);
    }
}
