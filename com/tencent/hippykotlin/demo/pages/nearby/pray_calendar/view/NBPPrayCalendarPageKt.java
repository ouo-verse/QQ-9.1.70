package com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import bp3.c;
import com.tencent.avcore.jni.audiodevice.TraeAudioManager;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view_model.NBPPrayCalendarViewModel;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.lifecycle.viewmodel.b;
import com.tencent.ntcompose.lifecycle.viewmodel.e;
import com.tencent.ntcompose.lifecycle.viewmodel.g;
import com.tencent.ntcompose.lifecycle.viewmodel.i;
import com.tencent.ntcompose.lifecycle.viewmodel.k;
import com.tencent.ntcompose.material.ActivityIndicatorKt;
import com.tencent.ntcompose.material.FooterRefreshKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyVerticalGridKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.p;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import g35.a;
import java.util.ArrayList;
import java.util.List;
import k25.c;
import k25.d;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPPrayCalendarPageKt {
    public static final void BottomButton(final i iVar, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(1732119938);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if (i17 == 1 && (i18 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i17 != 0) {
                iVar = i.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1732119938, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.BottomButton (NBPPrayCalendarPage.kt:594)");
            }
            BoxKt.a(ModifiersKt.j(ModifiersKt.e(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar, 240), 45), Direction.TO_TOP_LEFT, new j(new h(16734835L, 1.0f), 0.0f), new j(new h(16737163L, 1.0f), 0.25f), new j(new h(16747913L, 1.0f), 0.75f), new j(new h(16767113L, 1.0f), 1.0f)), 30), Alignment.Center, null, ComposableSingletons$NBPPrayCalendarPageKt.f86lambda4, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$BottomButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.BottomButton(i.this, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void CalendarDay(final NBPPrayCalendarViewModel nBPPrayCalendarViewModel, i iVar, final a aVar, final c cVar, Composer composer, final int i3, final int i16) {
        h color$default;
        BorderStyle borderStyle;
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(-692695235);
        if ((i16 & 1) != 0) {
            NBPPrayCalendarPageKt$CalendarDay$1 nBPPrayCalendarPageKt$CalendarDay$1 = new Function1<b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarDay$1
                @Override // kotlin.jvm.functions.Function1
                public final NBPPrayCalendarViewModel invoke(b bVar2) {
                    return new NBPPrayCalendarViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                }
            };
            startRestartGroup.startReplaceableGroup(1485077867);
            Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
            if (consume != null) {
                k kVar = (k) consume;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                e eVar = new e();
                eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$CalendarDay$1);
                i.b b16 = eVar.b();
                if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                    bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                } else {
                    bVar = b.a.f339329b;
                }
                g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                startRestartGroup.endReplaceableGroup();
                nBPPrayCalendarViewModel = (NBPPrayCalendarViewModel) c16;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        }
        if ((i16 & 2) != 0) {
            iVar = com.tencent.ntcompose.core.i.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-692695235, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarDay (NBPPrayCalendarPage.kt:516)");
        }
        final boolean isToday = nBPPrayCalendarViewModel.isToday(cVar);
        boolean z16 = (aVar != null ? aVar.f401208e : null) != null;
        com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(iVar, 40, 54), 6);
        float f16 = (isToday || !z16) ? (float) 0.5d : 0;
        if (isToday) {
            color$default = new h(4294927243L);
        } else {
            color$default = QUIToken.color$default("fill_standard_quaternary");
        }
        if (z16) {
            borderStyle = BorderStyle.SOLID;
        } else {
            borderStyle = BorderStyle.DOTTED;
        }
        BoxKt.a(ModifiersKt.f(j3, f16, color$default, borderStyle), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1091907517, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarDay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                d dVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1091907517, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarDay.<anonymous> (NBPPrayCalendarPage.kt:533)");
                    }
                    i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                    com.tencent.ntcompose.core.i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 0.2f);
                    a aVar2 = a.this;
                    ImageKt.a((aVar2 == null || (dVar = aVar2.f401208e) == null) ? null : dVar.f411450d, null, null, null, null, D, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2097118);
                    com.tencent.ntcompose.core.i q16 = ComposeLayoutPropUpdaterKt.q(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 4);
                    Alignment.Horizontal b17 = Alignment.INSTANCE.b();
                    a.e e16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.e();
                    final c cVar2 = cVar;
                    final g35.a aVar3 = g35.a.this;
                    final boolean z17 = isToday;
                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
                    ColumnKt.a(q16, e16, b17, null, ComposableLambdaKt.composableLambda(composer3, 1688541882, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarDay$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1688541882, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarDay.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:546)");
                                }
                                i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                TextKt.a(String.valueOf(c.this.f411448f), ComposeLayoutPropUpdaterKt.k(companion2, 18), null, QUIToken.color$default("text_primary"), Float.valueOf(12), null, bp3.c.INSTANCE.f(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134216612);
                                float f17 = 32;
                                com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(companion2, f17, f17);
                                Alignment.Horizontal b18 = Alignment.INSTANCE.b();
                                final g35.a aVar4 = aVar3;
                                final boolean z18 = z17;
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = nBPPrayCalendarViewModel2;
                                final c cVar3 = c.this;
                                ColumnKt.a(v3, null, b18, null, ComposableLambdaKt.composableLambda(composer5, 519497649, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarDay.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar3, Composer composer6, Integer num3) {
                                        h color$default2;
                                        Composer composer7;
                                        h color$default3;
                                        Composer composer8 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                            composer8.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(519497649, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarDay.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:559)");
                                            }
                                            g35.a aVar5 = g35.a.this;
                                            Unit unit = null;
                                            d dVar4 = aVar5 != null ? aVar5.f401208e : null;
                                            composer8.startReplaceableGroup(1596940156);
                                            if (dVar4 == null) {
                                                composer7 = composer8;
                                            } else {
                                                boolean z19 = z18;
                                                String str = dVar4.f411455m;
                                                if (z19) {
                                                    color$default2 = new h(4294934708L);
                                                } else {
                                                    color$default2 = QUIToken.color$default("text_primary");
                                                }
                                                composer7 = composer8;
                                                TextKt.a(str, null, null, color$default2, Float.valueOf(11), null, bp3.c.INSTANCE.g(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 0, 0, 134217638);
                                                float f18 = 10;
                                                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ENPgTI94u2_.png", null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, f18, f18), 0.0f, 4, 0.0f, 0.0f, 13, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, new h(16737163L, 1.0f), null, composer7, 262150, 1073741824, 0, 1572830);
                                                unit = Unit.INSTANCE;
                                            }
                                            composer7.endReplaceableGroup();
                                            if (unit == null) {
                                                float f19 = 24;
                                                com.tencent.ntcompose.core.i v16 = ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, f19, f19);
                                                if (z18) {
                                                    color$default3 = new h(16737163L, 1.0f);
                                                } else if (nBPPrayCalendarViewModel3.isFuture(cVar3)) {
                                                    color$default3 = QUIToken.color$default("fill_standard_quaternary");
                                                } else {
                                                    color$default3 = QUIToken.color$default("fill_standard_extra");
                                                }
                                                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_a2e3Pl2r2eQ.png", null, null, null, null, v16, null, 0, null, null, null, null, null, null, null, null, null, null, null, color$default3, null, composer7, 262150, 1073741824, 0, 1572830);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 24584, 10);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 24648, 8);
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
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
        final com.tencent.ntcompose.core.i iVar2 = iVar;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarDay$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.CalendarDay(NBPPrayCalendarViewModel.this, iVar2, aVar, cVar, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void CalendarSection(NBPPrayCalendarViewModel nBPPrayCalendarViewModel, final c cVar, final Function2<? super g35.a, ? super c, Unit> function2, Composer composer, final int i3, final int i16) {
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2;
        b bVar;
        Composer startRestartGroup = composer.startRestartGroup(-696727721);
        if ((i16 & 1) != 0) {
            NBPPrayCalendarPageKt$CalendarSection$1 nBPPrayCalendarPageKt$CalendarSection$1 = new Function1<b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$1
                @Override // kotlin.jvm.functions.Function1
                public final NBPPrayCalendarViewModel invoke(b bVar2) {
                    return new NBPPrayCalendarViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                }
            };
            startRestartGroup.startReplaceableGroup(1485077867);
            Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
            if (consume != null) {
                k kVar = (k) consume;
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                e eVar = new e();
                eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$CalendarSection$1);
                i.b b16 = eVar.b();
                if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                    bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                } else {
                    bVar = b.a.f339329b;
                }
                g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                startRestartGroup.endReplaceableGroup();
                nBPPrayCalendarViewModel2 = (NBPPrayCalendarViewModel) c16;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
        } else {
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696727721, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarSection (NBPPrayCalendarPage.kt:434)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.s(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("fill_light_secondary")), 8), 0.0f, 0.0f, 0.0f, 14, 7, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -724426403, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                int i17;
                Composer composer3;
                com.tencent.ntcompose.foundation.layout.b bVar3 = bVar2;
                Composer composer4 = composer2;
                int intValue = num.intValue();
                if ((intValue & 14) == 0) {
                    i17 = (composer4.changed(bVar3) ? 4 : 2) | intValue;
                } else {
                    i17 = intValue;
                }
                if ((i17 & 91) == 18 && composer4.getSkipping()) {
                    composer4.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-724426403, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarSection.<anonymous> (NBPPrayCalendarPage.kt:445)");
                    }
                    composer4.startReplaceableGroup(-1477236963);
                    if (NBPPrayCalendarViewModel.this.isCurrentMonth(cVar)) {
                        composer3 = composer4;
                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8AsDd4sLR1-.png", null, null, null, null, bVar3.a(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 91, 30), Alignment.TopEnd), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262150, 0, 0, 2097118);
                    } else {
                        composer3 = composer4;
                    }
                    composer3.endReplaceableGroup();
                    com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = NBPPrayCalendarViewModel.this;
                    final c cVar2 = cVar;
                    final Function2<g35.a, c, Unit> function22 = function2;
                    Composer composer5 = composer3;
                    ColumnKt.a(j3, null, null, null, ComposableLambdaKt.composableLambda(composer5, -1249434028, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer6, Integer num2) {
                            int i18;
                            Composer composer7 = composer6;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1249434028, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarSection.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:455)");
                                }
                                float f16 = 16;
                                float f17 = 12;
                                com.tencent.ntcompose.core.i s16 = ComposeLayoutPropUpdaterKt.s(com.tencent.ntcompose.core.i.INSTANCE, f16, f16, 0.0f, f17, 4, null);
                                Alignment.Vertical a16 = Alignment.INSTANCE.a();
                                final c cVar3 = cVar2;
                                RowKt.a(s16, null, a16, null, null, ComposableLambdaKt.composableLambda(composer7, 1410377206, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarSection.2.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer8, Integer num3) {
                                        String padStart;
                                        String str;
                                        Composer composer9 = composer8;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                            composer9.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1410377206, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarSection.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:460)");
                                            }
                                            padStart = StringsKt__StringsKt.padStart(String.valueOf(c.this.f411447e), 2, '0');
                                            h color$default = QUIToken.color$default("text_primary");
                                            c.Companion companion = bp3.c.INSTANCE;
                                            TextKt.a(padStart, null, null, color$default, Float.valueOf(34), null, companion.h(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 0, 0, 134217638);
                                            if (k25.c.this.f411447e == 1) {
                                                str = AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6708\u00b7"), k25.c.this.f411446d, '\u5e74');
                                            } else {
                                                str = "\u6708";
                                            }
                                            TextKt.a(str, null, null, QUIToken.color$default("text_primary"), Float.valueOf(14), null, companion.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 1601536, 0, 0, 134217638);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer7, 196616, 26);
                                NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                k25.c cVar4 = cVar2;
                                int i19 = cVar4.f411446d;
                                int i26 = cVar4.f411447e;
                                nBPPrayCalendarViewModel4.getClass();
                                int i27 = 0;
                                switch (i26) {
                                    case 1:
                                    case 3:
                                    case 5:
                                    case 7:
                                    case 8:
                                    case 10:
                                    case 12:
                                        i18 = 31;
                                        break;
                                    case 2:
                                        if (!(i19 % 4 == 0 && (i19 % 100 != 0 || i19 % 400 == 0))) {
                                            i18 = 28;
                                            break;
                                        } else {
                                            i18 = 29;
                                            break;
                                        }
                                        break;
                                    case 4:
                                    case 6:
                                    case 9:
                                    case 11:
                                        i18 = 30;
                                        break;
                                    default:
                                        throw new IllegalArgumentException("Invalid month: " + i26);
                                }
                                final int i28 = i18;
                                int i29 = (i28 / 7) + 1;
                                final k25.c cVar5 = cVar2;
                                NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                Function2<g35.a, k25.c, Unit> function23 = function22;
                                while (i27 < i29) {
                                    final Function2<g35.a, k25.c, Unit> function24 = function23;
                                    final int i36 = i27;
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = nBPPrayCalendarViewModel5;
                                    RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), f17, 8, f17, 0.0f, 8, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), null, null, null, ComposableLambdaKt.composableLambda(composer7, -787596510, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$2$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer8, Integer num3) {
                                            Composer composer9 = composer8;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                                composer9.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-787596510, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarSection.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:484)");
                                                }
                                                for (int i37 = 0; i37 < 7; i37++) {
                                                    int i38 = (i36 * 7) + i37;
                                                    boolean z16 = 1 <= i38 && i38 <= i28;
                                                    k25.c cVar6 = cVar5;
                                                    final k25.c cVar7 = new k25.c(cVar6.f411446d, cVar6.f411447e, i38, 8);
                                                    String dayKey = nBPPrayCalendarViewModel6.getDayKey(cVar7);
                                                    final g35.a aVar = z16 ? nBPPrayCalendarViewModel6.attendanceMap.get(dayKey) : null;
                                                    com.tencent.ntcompose.core.i R = ModifiersKt.R(com.tencent.ntcompose.core.i.INSTANCE, z16);
                                                    com.tencent.kuikly.core.nvi.serialization.json.e dTBaseParams = DTReportConstKt.getDTBaseParams("0AND05J90ZOPH3DU");
                                                    NBPPrayCalendarViewModel nBPPrayCalendarViewModel7 = nBPPrayCalendarViewModel6;
                                                    dTBaseParams.t("is_today", Intrinsics.areEqual(dayKey, nBPPrayCalendarViewModel7.getDayKey(nBPPrayCalendarViewModel7.todayDate)) ? 1 : 0);
                                                    Unit unit = Unit.INSTANCE;
                                                    com.tencent.ntcompose.core.i elementVR$default = ModifierExtKt.elementVR$default(R, "em_nearby_luck_card_daily_lots", dTBaseParams, String.valueOf(cVar5.hashCode()));
                                                    final Function2<g35.a, k25.c, Unit> function25 = function24;
                                                    NBPPrayCalendarPageKt.CalendarDay(null, ViewEventPropUpdaterKt.d(elementVR$default, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$2$1$2$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function25.invoke(aVar, cVar7);
                                                            return Unit.INSTANCE;
                                                        }
                                                    }, 3, null), aVar, cVar7, composer9, 4672, 1);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer7, 196680, 28);
                                    i27++;
                                    nBPPrayCalendarViewModel5 = nBPPrayCalendarViewModel5;
                                    function23 = function24;
                                }
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
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = nBPPrayCalendarViewModel2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarSection$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.CalendarSection(NBPPrayCalendarViewModel.this, cVar, function2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0112  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CalendarView(NBPPrayCalendarViewModel nBPPrayCalendarViewModel, final Function2<? super g35.a, ? super k25.c, Unit> function2, Composer composer, final int i3, final int i16) {
        b bVar;
        ?? r152;
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2;
        Composer startRestartGroup = composer.startRestartGroup(-417529693);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        final int i19 = i18;
        if (i17 == 1 && (i19 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if (i17 != 0) {
                    i19 &= -15;
                }
            } else if (i17 != 0) {
                NBPPrayCalendarPageKt$CalendarView$1 nBPPrayCalendarPageKt$CalendarView$1 = new Function1<b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPPrayCalendarViewModel invoke(b bVar2) {
                        return new NBPPrayCalendarViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$CalendarView$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    r152 = 1;
                    g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    i19 &= -15;
                    nBPPrayCalendarViewModel2 = (NBPPrayCalendarViewModel) c16;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-417529693, i19, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView (NBPPrayCalendarPage.kt:385)");
                    }
                    float f16 = 16;
                    BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, r152, null), f16, 0.0f, f16, 0.0f, 10, null), 0.0f, 18, 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1989918889, r152, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                            Composer composer3 = composer2;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1989918889, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous> (NBPPrayCalendarPage.kt:393)");
                                }
                                float e16 = ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e() - 32;
                                Boolean bool = Boolean.FALSE;
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = NBPPrayCalendarViewModel.this;
                                final Function2<g35.a, k25.c, Unit> function22 = function2;
                                final int i26 = i19;
                                LazyVerticalGridKt.a(null, ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), e16, null, null, com.tencent.ntcompose.foundation.layout.k.c(0.0f, 0.0f, 0.0f, NBPPrayCalendarViewModel.this.pageData.getSafeAreaInsets().getBottom() + 78, 7, null), 0.0f, 10, null, null, null, bool, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 242888302, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                        com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(242888302, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:401)");
                                        }
                                        SnapshotStateList<String> snapshotStateList = NBPPrayCalendarViewModel.this.attendanceDateList;
                                        final Function2<g35.a, k25.c, Unit> function23 = function22;
                                        final int i27 = i26;
                                        LazyDslKt.b(aVar2, snapshotStateList, null, ComposableLambdaKt.composableLambda(composer5, 60685130, true, new Function3<String, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(String str, Composer composer6, Integer num3) {
                                                int i28;
                                                List split$default;
                                                String str2 = str;
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 14) == 0) {
                                                    i28 = (composer7.changed(str2) ? 4 : 2) | intValue3;
                                                } else {
                                                    i28 = intValue3;
                                                }
                                                if ((i28 & 91) == 18 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(60685130, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:402)");
                                                    }
                                                    split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
                                                    NBPPrayCalendarPageKt.CalendarSection(null, new k25.c(Integer.parseInt((String) split$default.get(0)), Integer.parseInt((String) split$default.get(1)), 0, 12), function23, composer7, ((i27 << 3) & 896) | 64, 1);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3080, 2);
                                        if (!NBPPrayCalendarViewModel.this.isReachEnd.getValue().booleanValue()) {
                                            final p b17 = FooterRefreshKt.b(composer5, 0);
                                            com.tencent.ntcompose.core.i R = ModifiersKt.R(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 50), b17.a());
                                            final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                            FooterRefreshKt.a(b17, null, R, 0.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                    final p pVar = b17;
                                                    nBPPrayCalendarViewModel5.fetchAttendanceList(false, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.2.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            p.this.b(false);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            }, ComposableLambdaKt.composableLambda(composer5, -1303135228, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.3
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Unit invoke(Composer composer6, Integer num3) {
                                                    Composer composer7 = composer6;
                                                    int intValue3 = num3.intValue();
                                                    if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                        composer7.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1303135228, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:420)");
                                                        }
                                                        if (p.this.a()) {
                                                            ActivityIndicatorKt.a(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20.0f), true, composer7, 56, 0);
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer5, 1573376, 26);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 12582976, 48, 1572864, 67106649);
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
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            r152 = 1;
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f162 = 16;
            BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, r152, null), f162, 0.0f, f162, 0.0f, 10, null), 0.0f, 18, 0.0f, 0.0f, 13, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1989918889, r152, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1989918889, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous> (NBPPrayCalendarPage.kt:393)");
                        }
                        float e16 = ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).e() - 32;
                        Boolean bool = Boolean.FALSE;
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = NBPPrayCalendarViewModel.this;
                        final Function2<? super g35.a, ? super k25.c, Unit> function22 = function2;
                        final int i26 = i19;
                        LazyVerticalGridKt.a(null, ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), e16, null, null, com.tencent.ntcompose.foundation.layout.k.c(0.0f, 0.0f, 0.0f, NBPPrayCalendarViewModel.this.pageData.getSafeAreaInsets().getBottom() + 78, 7, null), 0.0f, 10, null, null, null, bool, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer3, 242888302, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer4, Integer num2) {
                                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(242888302, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:401)");
                                }
                                SnapshotStateList<String> snapshotStateList = NBPPrayCalendarViewModel.this.attendanceDateList;
                                final Function2<? super g35.a, ? super k25.c, Unit> function23 = function22;
                                final int i27 = i26;
                                LazyDslKt.b(aVar2, snapshotStateList, null, ComposableLambdaKt.composableLambda(composer5, 60685130, true, new Function3<String, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(String str, Composer composer6, Integer num3) {
                                        int i28;
                                        List split$default;
                                        String str2 = str;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i28 = (composer7.changed(str2) ? 4 : 2) | intValue3;
                                        } else {
                                            i28 = intValue3;
                                        }
                                        if ((i28 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(60685130, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:402)");
                                            }
                                            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
                                            NBPPrayCalendarPageKt.CalendarSection(null, new k25.c(Integer.parseInt((String) split$default.get(0)), Integer.parseInt((String) split$default.get(1)), 0, 12), function23, composer7, ((i27 << 3) & 896) | 64, 1);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 3080, 2);
                                if (!NBPPrayCalendarViewModel.this.isReachEnd.getValue().booleanValue()) {
                                    final p b17 = FooterRefreshKt.b(composer5, 0);
                                    com.tencent.ntcompose.core.i R = ModifiersKt.R(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, 50), b17.a());
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                    FooterRefreshKt.a(b17, null, R, 0.0f, 0.0f, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                            final p pVar = b17;
                                            nBPPrayCalendarViewModel5.fetchAttendanceList(false, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.2.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    p.this.b(false);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }, ComposableLambdaKt.composableLambda(composer5, -1303135228, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.CalendarView.2.1.3
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(Composer composer6, Integer num3) {
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 11) == 2 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1303135228, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.CalendarView.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:420)");
                                                }
                                                if (p.this.a()) {
                                                    ActivityIndicatorKt.a(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20.0f), true, composer7, 56, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 1573376, 26);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 12582976, 48, 1572864, 67106649);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 3080, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$CalendarView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.CalendarView(NBPPrayCalendarViewModel.this, function2, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Header(NBPPrayCalendarViewModel nBPPrayCalendarViewModel, final Function0<Unit> function0, Composer composer, final int i3, final int i16) {
        b bVar;
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2;
        final int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1884191401);
        int i18 = i16 & 1;
        int i19 = i18 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i19 |= 48;
        } else if ((i3 & 112) == 0) {
            i19 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        int i26 = i19;
        if (i18 == 1 && (i26 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if (i18 != 0) {
                    i26 &= -15;
                }
            } else if (i18 != 0) {
                NBPPrayCalendarPageKt$Header$1 nBPPrayCalendarPageKt$Header$1 = new Function1<b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPPrayCalendarViewModel invoke(b bVar2) {
                        return new NBPPrayCalendarViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$Header$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    int i27 = i26 & (-15);
                    nBPPrayCalendarViewModel2 = (NBPPrayCalendarViewModel) c16;
                    i17 = i27;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1884191401, i17, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header (NBPPrayCalendarPage.kt:237)");
                    }
                    ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 20, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2074373838, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>(function0, i17, nBPPrayCalendarViewModel2) { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2
                        public final /* synthetic */ Function0<Unit> $clickHandlerFn;
                        public final /* synthetic */ NBPPrayCalendarViewModel $vm;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$vm = nBPPrayCalendarViewModel2;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer2, Integer num) {
                            Composer composer3 = composer2;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2074373838, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous> (NBPPrayCalendarPage.kt:245)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8XspzafkdAU.png", null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 162, 55), 0.0f, 16, 0.0f, 0.0f, 13, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262150, 0, 0, 2097118);
                                com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 3, 0.0f, 0.0f, 13, null), 128, 118);
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = this.$vm;
                                com.tencent.ntcompose.core.i q16 = ViewEventPropUpdaterKt.q(v3, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                        TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                eVar2.t("clockin_state", NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue() ? 1 : 2);
                                                Unit unit = Unit.INSTANCE;
                                                com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel5.getDTElementParams("em_nearby_luck_card_calendar", eVar2);
                                                dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTElementParams);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final Function0<Unit> function02 = this.$clickHandlerFn;
                                composer3.startReplaceableGroup(1157296644);
                                boolean changed = composer3.changed(function02);
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function02.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(q16, false, null, (Function1) rememberedValue, 3, null);
                                Alignment alignment = Alignment.Center;
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = this.$vm;
                                BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -63957932, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.3
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                        int i28;
                                        com.tencent.ntcompose.foundation.layout.b bVar3 = bVar2;
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 14) == 0) {
                                            i28 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                        } else {
                                            i28 = intValue2;
                                        }
                                        if ((i28 & 91) == 18 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-63957932, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:274)");
                                            }
                                            if (NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue()) {
                                                composer5.startReplaceableGroup(-1858462772);
                                                i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                                float f16 = 4;
                                                com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.q(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(companion2, 68, 88), 3), f16), h.INSTANCE.m());
                                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                                BoxKt.a(c17, null, null, ComposableLambdaKt.composableLambda(composer5, -519715403, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.3.1
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar4, Composer composer6, Integer num3) {
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-519715403, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:282)");
                                                            }
                                                            com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 68), 2);
                                                            d value = NBPPrayCalendarViewModel.this.todayCard.getValue();
                                                            ImageKt.a(value != null ? value.f411450d : null, null, null, null, null, j3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 3080, 6);
                                                float f17 = 2;
                                                float f18 = 0;
                                                com.tencent.ntcompose.core.i e16 = ModifiersKt.e(ModifiersKt.k(ComposeLayoutPropUpdaterKt.o(bVar3.a(ComposeLayoutPropUpdaterKt.r(companion2, f17, f16, f17, f16), Alignment.TopEnd), -98, 19), f17, f18, f17, f18), Direction.TO_LEFT, new j(new h(16734835L, 1.0f), 0.0f), new j(new h(16737163L, 1.0f), 0.5f), new j(new h(16747913L, 1.0f), 0.9f), new j(new h(16755337L, 1.0f), 1.0f));
                                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = NBPPrayCalendarViewModel.this;
                                                BoxKt.a(e16, null, null, ComposableLambdaKt.composableLambda(composer5, -1677185236, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.3.2
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar4, Composer composer6, Integer num3) {
                                                        String joinToString$default;
                                                        Composer composer7 = composer6;
                                                        int intValue3 = num3.intValue();
                                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                            composer7.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1677185236, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:305)");
                                                            }
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4eca\u65e5\u00b7");
                                                            d value = NBPPrayCalendarViewModel.this.todayCard.getValue();
                                                            m3.append(value != null ? value.f411455m : null);
                                                            String sb5 = m3.toString();
                                                            ArrayList arrayList = new ArrayList(sb5.length());
                                                            for (int i29 = 0; i29 < sb5.length(); i29++) {
                                                                arrayList.add(String.valueOf(sb5.charAt(i29)));
                                                            }
                                                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
                                                            TextKt.a(joinToString$default, null, null, h.INSTANCE.m(), Float.valueOf(10), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 0, 0, 134216614);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer5, 3080, 6);
                                                composer5.endReplaceableGroup();
                                            } else {
                                                composer5.startReplaceableGroup(-1858461018);
                                                ColumnKt.a(ModifiersKt.f(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 60, 80), (float) 2.25d), 1.5f, new h(16733322L, 1.0f), BorderStyle.DOTTED), null, Alignment.INSTANCE.b(), null, ComposableSingletons$NBPPrayCalendarPageKt.f85lambda3, composer5, 24584, 10);
                                                composer5.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer3, 3128, 4);
                                com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 8, 0.0f, 0.0f, 0.0f, 14, null), 20);
                                Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = this.$vm;
                                RowKt.a(k3, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -1886954128, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.4
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                        h hVar;
                                        Composer composer5 = composer4;
                                        int intValue2 = num2.intValue();
                                        if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1886954128, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:353)");
                                            }
                                            if (PageDataExtKt.isNightMode(NBPPrayCalendarViewModel.this.pageData)) {
                                                hVar = new h(4294967295L, 1.0f);
                                            } else {
                                                hVar = new h(16740983L, 1.0f);
                                            }
                                            h hVar2 = hVar;
                                            i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                            float f16 = 14;
                                            ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DkoSx0k5-Ll.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, f16), null, 0, null, null, null, null, null, null, null, null, null, null, null, hVar2, null, composer5, 262150, 1073741824, 0, 1572830);
                                            float f17 = 2;
                                            com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(companion2, f17, 0.0f, 0.0f, 0.0f, 14, null);
                                            c.Companion companion3 = bp3.c.INSTANCE;
                                            TextKt.a("\u7d2f\u8ba1\u83b7\u5f97\u798f\u5361", n3, null, hVar2, Float.valueOf(10), null, companion3.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134217636);
                                            TextKt.a(String.valueOf(NBPPrayCalendarViewModel.this.accumulateCount.getValue().intValue()), ComposeLayoutPropUpdaterKt.n(companion2, f17, 0.0f, 0.0f, 0.0f, 14, null), null, hVar2, Float.valueOf(f16), null, companion3.h(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134217636);
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
                    }), startRestartGroup, 24584, 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            i17 = i26;
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ColumnKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 20, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 2074373838, true, new Function3<com.tencent.ntcompose.foundation.layout.d, Composer, Integer, Unit>(function0, i17, nBPPrayCalendarViewModel2) { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2
                public final /* synthetic */ Function0<Unit> $clickHandlerFn;
                public final /* synthetic */ NBPPrayCalendarViewModel $vm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$vm = nBPPrayCalendarViewModel2;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(com.tencent.ntcompose.foundation.layout.d dVar, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2074373838, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous> (NBPPrayCalendarPage.kt:245)");
                        }
                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                        ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_8XspzafkdAU.png", null, null, null, null, ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 162, 55), 0.0f, 16, 0.0f, 0.0f, 13, null), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, 262150, 0, 0, 2097118);
                        com.tencent.ntcompose.core.i v3 = ComposeLayoutPropUpdaterKt.v(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 3, 0.0f, 0.0f, 13, null), 128, 118);
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = this.$vm;
                        com.tencent.ntcompose.core.i q16 = ViewEventPropUpdaterKt.q(v3, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = NBPPrayCalendarViewModel.this;
                                TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                        eVar2.t("clockin_state", NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue() ? 1 : 2);
                                        Unit unit = Unit.INSTANCE;
                                        com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel5.getDTElementParams("em_nearby_luck_card_calendar", eVar2);
                                        dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTElementParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final Function0<Unit> function02 = this.$clickHandlerFn;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function02);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    function02.invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(q16, false, null, (Function1) rememberedValue, 3, null);
                        Alignment alignment = Alignment.Center;
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = this.$vm;
                        BoxKt.a(d16, alignment, null, ComposableLambdaKt.composableLambda(composer3, -63957932, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.3
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                int i28;
                                com.tencent.ntcompose.foundation.layout.b bVar3 = bVar2;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i28 = (composer5.changed(bVar3) ? 4 : 2) | intValue2;
                                } else {
                                    i28 = intValue2;
                                }
                                if ((i28 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-63957932, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:274)");
                                    }
                                    if (NBPPrayCalendarViewModel.this.isTodaySignIn.getValue().booleanValue()) {
                                        composer5.startReplaceableGroup(-1858462772);
                                        i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                        float f16 = 4;
                                        com.tencent.ntcompose.core.i c17 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.q(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(companion2, 68, 88), 3), f16), h.INSTANCE.m());
                                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                        BoxKt.a(c17, null, null, ComposableLambdaKt.composableLambda(composer5, -519715403, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.3.1
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar4, Composer composer6, Integer num3) {
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-519715403, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:282)");
                                                    }
                                                    com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 68), 2);
                                                    d value = NBPPrayCalendarViewModel.this.todayCard.getValue();
                                                    ImageKt.a(value != null ? value.f411450d : null, null, null, null, null, j3, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2097118);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3080, 6);
                                        float f17 = 2;
                                        float f18 = 0;
                                        com.tencent.ntcompose.core.i e16 = ModifiersKt.e(ModifiersKt.k(ComposeLayoutPropUpdaterKt.o(bVar3.a(ComposeLayoutPropUpdaterKt.r(companion2, f17, f16, f17, f16), Alignment.TopEnd), -98, 19), f17, f18, f17, f18), Direction.TO_LEFT, new j(new h(16734835L, 1.0f), 0.0f), new j(new h(16737163L, 1.0f), 0.5f), new j(new h(16747913L, 1.0f), 0.9f), new j(new h(16755337L, 1.0f), 1.0f));
                                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = NBPPrayCalendarViewModel.this;
                                        BoxKt.a(e16, null, null, ComposableLambdaKt.composableLambda(composer5, -1677185236, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.Header.2.3.2
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar4, Composer composer6, Integer num3) {
                                                String joinToString$default;
                                                Composer composer7 = composer6;
                                                int intValue3 = num3.intValue();
                                                if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                                    composer7.skipToGroupEnd();
                                                } else {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1677185236, intValue3, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:305)");
                                                    }
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u4eca\u65e5\u00b7");
                                                    d value = NBPPrayCalendarViewModel.this.todayCard.getValue();
                                                    m3.append(value != null ? value.f411455m : null);
                                                    String sb5 = m3.toString();
                                                    ArrayList arrayList = new ArrayList(sb5.length());
                                                    for (int i29 = 0; i29 < sb5.length(); i29++) {
                                                        arrayList.add(String.valueOf(sb5.charAt(i29)));
                                                    }
                                                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "\n", null, null, 0, null, null, 62, null);
                                                    TextKt.a(joinToString$default, null, null, h.INSTANCE.m(), Float.valueOf(10), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer7, 1601536, 0, 0, 134216614);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), composer5, 3080, 6);
                                        composer5.endReplaceableGroup();
                                    } else {
                                        composer5.startReplaceableGroup(-1858461018);
                                        ColumnKt.a(ModifiersKt.f(ModifiersKt.j(ComposeLayoutPropUpdaterKt.v(com.tencent.ntcompose.core.i.INSTANCE, 60, 80), (float) 2.25d), 1.5f, new h(16733322L, 1.0f), BorderStyle.DOTTED), null, Alignment.INSTANCE.b(), null, ComposableSingletons$NBPPrayCalendarPageKt.f85lambda3, composer5, 24584, 10);
                                        composer5.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3128, 4);
                        com.tencent.ntcompose.core.i k3 = ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), 8, 0.0f, 0.0f, 0.0f, 14, null), 20);
                        Alignment.Vertical c17 = Alignment.INSTANCE.c();
                        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = this.$vm;
                        RowKt.a(k3, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -1886954128, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$2.4
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                h hVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1886954128, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.Header.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:353)");
                                    }
                                    if (PageDataExtKt.isNightMode(NBPPrayCalendarViewModel.this.pageData)) {
                                        hVar = new h(4294967295L, 1.0f);
                                    } else {
                                        hVar = new h(16740983L, 1.0f);
                                    }
                                    h hVar2 = hVar;
                                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                                    float f16 = 14;
                                    ImageKt.a("https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_DkoSx0k5-Ll.png", null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion2, f16), null, 0, null, null, null, null, null, null, null, null, null, null, null, hVar2, null, composer5, 262150, 1073741824, 0, 1572830);
                                    float f17 = 2;
                                    com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(companion2, f17, 0.0f, 0.0f, 0.0f, 14, null);
                                    c.Companion companion3 = bp3.c.INSTANCE;
                                    TextKt.a("\u7d2f\u8ba1\u83b7\u5f97\u798f\u5361", n3, null, hVar2, Float.valueOf(10), null, companion3.f(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134217636);
                                    TextKt.a(String.valueOf(NBPPrayCalendarViewModel.this.accumulateCount.getValue().intValue()), ComposeLayoutPropUpdaterKt.n(companion2, f17, 0.0f, 0.0f, 0.0f, 14, null), null, hVar2, Float.valueOf(f16), null, companion3.h(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601600, 0, 0, 134217636);
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
            }), startRestartGroup, 24584, 14);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$Header$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.Header(NBPPrayCalendarViewModel.this, function0, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TopBar(NBPPrayCalendarViewModel nBPPrayCalendarViewModel, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        b bVar;
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel2;
        Composer startRestartGroup = composer.startRestartGroup(107173778);
        int i17 = i16 & 1;
        int i18 = i17 != 0 ? i3 | 2 : i3;
        if ((i16 & 2) != 0) {
            i18 |= 48;
        } else if ((i3 & 112) == 0) {
            i18 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i16 & 4) != 0) {
            i18 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i3 & 896) == 0) {
            i18 |= startRestartGroup.changed(function02) ? 256 : 128;
        }
        final int i19 = i18;
        if (i17 == 1 && (i19 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
        } else {
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if (i17 != 0) {
                    i19 &= -15;
                }
            } else if (i17 != 0) {
                NBPPrayCalendarPageKt$TopBar$1 nBPPrayCalendarPageKt$TopBar$1 = new Function1<b, NBPPrayCalendarViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$1
                    @Override // kotlin.jvm.functions.Function1
                    public final NBPPrayCalendarViewModel invoke(b bVar2) {
                        return new NBPPrayCalendarViewModel(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData());
                    }
                };
                startRestartGroup.startReplaceableGroup(1485077867);
                Object consume = startRestartGroup.consume(CompositionLocalsKt.f());
                if (consume != null) {
                    k kVar = (k) consume;
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class);
                    e eVar = new e();
                    eVar.a(Reflection.getOrCreateKotlinClass(NBPPrayCalendarViewModel.class), nBPPrayCalendarPageKt$TopBar$1);
                    i.b b16 = eVar.b();
                    if (kVar instanceof com.tencent.ntcompose.lifecycle.viewmodel.c) {
                        bVar = ((com.tencent.ntcompose.lifecycle.viewmodel.c) kVar).a();
                    } else {
                        bVar = b.a.f339329b;
                    }
                    g c16 = com.tencent.ntcompose.lifecycle.viewmodel.compose.a.c(orCreateKotlinClass, kVar, null, b16, bVar, startRestartGroup, TraeAudioManager.CustomHandler.MSG_VOICE_CALL_PRE_PROCESS, 0);
                    startRestartGroup.endReplaceableGroup();
                    i19 &= -15;
                    nBPPrayCalendarViewModel2 = (NBPPrayCalendarViewModel) c16;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(107173778, i19, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.TopBar (NBPPrayCalendarPage.kt:163)");
                    }
                    RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i() + 44), 0.0f, 1, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i(), 0.0f, 0.0f, 13, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1451437900, true, new Function3<n, Composer, Integer, Unit>(function02, i19, nBPPrayCalendarViewModel2, function0) { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2
                        public final /* synthetic */ Function0<Unit> $clickBackBtnHandlerFn;
                        public final /* synthetic */ Function0<Unit> $clickRemindBtnHandlerFn;
                        public final /* synthetic */ NBPPrayCalendarViewModel $vm;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                            this.$vm = nBPPrayCalendarViewModel2;
                            this.$clickRemindBtnHandlerFn = function0;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
                        
                            if ((r0 != null && r0.j("isRemindEnabled") == 1) != false) goto L25;
                         */
                        @Override // kotlin.jvm.functions.Function3
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(n nVar, Composer composer2, Integer num) {
                            boolean z16;
                            Composer composer3 = composer2;
                            int intValue = num.intValue();
                            if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1451437900, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.TopBar.<anonymous> (NBPPrayCalendarPage.kt:175)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                float f16 = 28;
                                float f17 = 16;
                                com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, f16), f17, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("fill_allblack_weak")), f16);
                                final Function0<Unit> function03 = this.$clickBackBtnHandlerFn;
                                composer3.startReplaceableGroup(1157296644);
                                boolean changed = composer3.changed(function03);
                                Object rememberedValue = composer3.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            function03.invoke();
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                composer3.endReplaceableGroup();
                                BoxKt.a(ViewEventPropUpdaterKt.d(j3, false, null, (Function1) rememberedValue, 3, null), Alignment.Center, null, ComposableSingletons$NBPPrayCalendarPageKt.f83lambda1, composer3, 3128, 4);
                                NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = this.$vm;
                                nBPPrayCalendarViewModel3.getClass();
                                if (!com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().u()) {
                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = nBPPrayCalendarViewModel3.qqmcConfig;
                                    z16 = false;
                                }
                                z16 = true;
                                if (z16) {
                                    float f18 = 10;
                                    com.tencent.ntcompose.core.i j16 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 0.0f, f17, 0.0f, 11, null), QUIToken.color$default("fill_allblack_weak")), f16), f18, 0.0f, f18, 0.0f, 10, null), 24);
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = this.$vm;
                                    com.tencent.ntcompose.core.i q16 = ViewEventPropUpdaterKt.q(j16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                            TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.TopBar.2.2.1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = NBPPrayCalendarViewModel.this;
                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                    eVar3.t("op_result", NBPPrayCalendarViewModel.this.isRemindOn.getValue().booleanValue() ? 1 : 2);
                                                    Unit unit = Unit.INSTANCE;
                                                    com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel6.getDTElementParams("em_nearby_remind_everyday_switch", eVar3);
                                                    dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTElementParams);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final Function0<Unit> function04 = this.$clickRemindBtnHandlerFn;
                                    composer3.startReplaceableGroup(1157296644);
                                    boolean changed2 = composer3.changed(function04);
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                function04.invoke();
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    composer3.endReplaceableGroup();
                                    com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(q16, false, null, (Function1) rememberedValue2, 3, null);
                                    Alignment.Vertical c17 = Alignment.INSTANCE.c();
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = this.$vm;
                                    RowKt.a(d16, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -2003074191, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2.4
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                                            String str;
                                            Composer composer5 = composer4;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2003074191, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.TopBar.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:220)");
                                                }
                                                com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20), 0.0f, 0.0f, 4, 0.0f, 11, null);
                                                if (NBPPrayCalendarViewModel.this.isRemindOn.getValue().booleanValue()) {
                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ENPgTI94u2_.png";
                                                } else {
                                                    str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_w-eKnJiBL0W.png";
                                                }
                                                ImageKt.a(str, null, null, null, null, n3, null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_allwhite_primary"), null, composer5, 262144, 1073741824, 0, 1572830);
                                                TextKt.a("\u5f00\u542f\u6bcf\u65e5\u63d0\u9192", null, null, h.INSTANCE.n(), Float.valueOf(14), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 0, 0, 134217638);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 196616, 26);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), startRestartGroup, 197064, 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                }
            }
            nBPPrayCalendarViewModel2 = nBPPrayCalendarViewModel;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(ComposeLayoutPropUpdaterKt.k(com.tencent.ntcompose.core.i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i() + 44), 0.0f, 1, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).i(), 0.0f, 0.0f, 13, null), com.tencent.ntcompose.foundation.layout.base.a.f339245a.e(), Alignment.Vertical.CenterVertically, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1451437900, true, new Function3<n, Composer, Integer, Unit>(function02, i19, nBPPrayCalendarViewModel2, function0) { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2
                public final /* synthetic */ Function0<Unit> $clickBackBtnHandlerFn;
                public final /* synthetic */ Function0<Unit> $clickRemindBtnHandlerFn;
                public final /* synthetic */ NBPPrayCalendarViewModel $vm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$vm = nBPPrayCalendarViewModel2;
                    this.$clickRemindBtnHandlerFn = function0;
                }

                /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
                
                    if ((r0 != null && r0.j("isRemindEnabled") == 1) != false) goto L25;
                 */
                @Override // kotlin.jvm.functions.Function3
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    boolean z16;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451437900, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.TopBar.<anonymous> (NBPPrayCalendarPage.kt:175)");
                        }
                        i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                        float f16 = 28;
                        float f17 = 16;
                        com.tencent.ntcompose.core.i j3 = ModifiersKt.j(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(companion, f16), f17, 0.0f, 0.0f, 0.0f, 14, null), QUIToken.color$default("fill_allblack_weak")), f16);
                        final Function0<Unit> function03 = this.$clickBackBtnHandlerFn;
                        composer3.startReplaceableGroup(1157296644);
                        boolean changed = composer3.changed(function03);
                        Object rememberedValue = composer3.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    function03.invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        composer3.endReplaceableGroup();
                        BoxKt.a(ViewEventPropUpdaterKt.d(j3, false, null, (Function1) rememberedValue, 3, null), Alignment.Center, null, ComposableSingletons$NBPPrayCalendarPageKt.f83lambda1, composer3, 3128, 4);
                        NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = this.$vm;
                        nBPPrayCalendarViewModel3.getClass();
                        if (!com.tencent.kuikly.core.manager.c.f117352a.g().getPageData().u()) {
                            com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = nBPPrayCalendarViewModel3.qqmcConfig;
                            z16 = false;
                        }
                        z16 = true;
                        if (z16) {
                            float f18 = 10;
                            com.tencent.ntcompose.core.i j16 = ModifiersKt.j(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ModifiersKt.d(ComposeLayoutPropUpdaterKt.n(companion, 0.0f, 0.0f, f17, 0.0f, 11, null), QUIToken.color$default("fill_allblack_weak")), f16), f18, 0.0f, f18, 0.0f, 10, null), 24);
                            final NBPPrayCalendarViewModel nBPPrayCalendarViewModel4 = this.$vm;
                            com.tencent.ntcompose.core.i q16 = ViewEventPropUpdaterKt.q(j16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Object obj) {
                                    final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = NBPPrayCalendarViewModel.this;
                                    TimerKt.d(200, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt.TopBar.2.2.1
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            NBPPrayCalendarViewModel nBPPrayCalendarViewModel6 = NBPPrayCalendarViewModel.this;
                                            com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                            eVar3.t("op_result", NBPPrayCalendarViewModel.this.isRemindOn.getValue().booleanValue() ? 1 : 2);
                                            Unit unit = Unit.INSTANCE;
                                            com.tencent.kuikly.core.nvi.serialization.json.e dTElementParams = nBPPrayCalendarViewModel6.getDTElementParams("em_nearby_remind_everyday_switch", eVar3);
                                            dTElementParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTElementParams);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            final Function0<Unit> function04 = this.$clickRemindBtnHandlerFn;
                            composer3.startReplaceableGroup(1157296644);
                            boolean changed2 = composer3.changed(function04);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        function04.invoke();
                                        return Unit.INSTANCE;
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            composer3.endReplaceableGroup();
                            com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(q16, false, null, (Function1) rememberedValue2, 3, null);
                            Alignment.Vertical c17 = Alignment.INSTANCE.c();
                            final NBPPrayCalendarViewModel nBPPrayCalendarViewModel5 = this.$vm;
                            RowKt.a(d16, null, c17, null, null, ComposableLambdaKt.composableLambda(composer3, -2003074191, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$2.4
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(n nVar2, Composer composer4, Integer num2) {
                                    String str;
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2003074191, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.TopBar.<anonymous>.<anonymous> (NBPPrayCalendarPage.kt:220)");
                                        }
                                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 20), 0.0f, 0.0f, 4, 0.0f, 11, null);
                                        if (NBPPrayCalendarViewModel.this.isRemindOn.getValue().booleanValue()) {
                                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_ENPgTI94u2_.png";
                                        } else {
                                            str = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_w-eKnJiBL0W.png";
                                        }
                                        ImageKt.a(str, null, null, null, null, n3, null, 0, null, null, null, null, null, null, null, null, null, null, null, QUIToken.color$default("icon_allwhite_primary"), null, composer5, 262144, 1073741824, 0, 1572830);
                                        TextKt.a("\u5f00\u542f\u6bcf\u65e5\u63d0\u9192", null, null, h.INSTANCE.n(), Float.valueOf(14), null, bp3.c.INSTANCE.e(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 0, 0, 134217638);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 196616, 26);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 197064, 24);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final NBPPrayCalendarViewModel nBPPrayCalendarViewModel3 = nBPPrayCalendarViewModel2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.pray_calendar.view.NBPPrayCalendarPageKt$TopBar$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                NBPPrayCalendarPageKt.TopBar(NBPPrayCalendarViewModel.this, function0, function02, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
