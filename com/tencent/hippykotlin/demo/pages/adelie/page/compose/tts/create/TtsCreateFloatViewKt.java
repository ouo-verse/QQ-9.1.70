package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.AdelieAudioRecordFrequencyViewKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.ReportKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioFormat;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsDataManager;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfo;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsReport;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module.AdelieKuiklyTTSPageModule;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.HalfFloatingLayerState;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.PanGestureParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.MotionEvent;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.ntcompose.ui.platform.a;
import h25.ak;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TtsCreateFloatViewKt {
    public static final void TtsCreateFloatView(final AdelieCreateTtsViewModel adelieCreateTtsViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(683519002);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(683519002, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatView (TtsCreateFloatView.kt:51)");
        }
        ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1603709464, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$TtsCreateFloatView$1
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
                        ComposerKt.traceEventStart(1603709464, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatView.<anonymous> (TtsCreateFloatView.kt:55)");
                    }
                    i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                    Alignment alignment = Alignment.BottomEnd;
                    final Function1<Boolean, Unit> function12 = function1;
                    final int i16 = i3;
                    final AdelieCreateTtsViewModel adelieCreateTtsViewModel2 = adelieCreateTtsViewModel;
                    BoxKt.a(f16, alignment, null, ComposableLambdaKt.composableLambda(composer3, 1516883666, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$TtsCreateFloatView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1516883666, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatView.<anonymous>.<anonymous> (TtsCreateFloatView.kt:60)");
                                }
                                AdelieCreateTtsViewModel adelieCreateTtsViewModel3 = adelieCreateTtsViewModel2;
                                composer5.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer5.rememberedValue();
                                Composer.Companion companion = Composer.INSTANCE;
                                if (rememberedValue == companion.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new AdelieAudioRecordManager(adelieCreateTtsViewModel3), null, 2, null);
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                final MutableState mutableState = (MutableState) rememberedValue;
                                HalfFloatingLayerState rememberHalfFloatingLayerState = HalfFloatingLayerKt.rememberHalfFloatingLayerState(composer5);
                                float bottom = 462.0f + ((a) composer5.consume(CompositionLocalsKt.d())).f().getBottom();
                                h color$default = QUIToken.color$default("bg_middle_light");
                                final Function1<Boolean, Unit> function13 = function12;
                                composer5.startReplaceableGroup(511388516);
                                boolean changed = composer5.changed(mutableState) | composer5.changed(function13);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (changed || rememberedValue2 == companion.getEmpty()) {
                                    rememberedValue2 = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$TtsCreateFloatView$1$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Object obj) {
                                            KLog kLog = KLog.INSTANCE;
                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("closeHandlerFn ");
                                            m3.append(mutableState.getValue().buttonSize);
                                            kLog.i("AdelieTtsSettingViewModel", m3.toString());
                                            StateHolder<Boolean> stateHolder = mutableState.getValue().isPressedInside;
                                            Boolean bool = Boolean.FALSE;
                                            stateHolder._state.setValue(bool);
                                            mutableState.getValue().endRecord(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$TtsCreateFloatView$1$1$1$1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                                                    bool2.booleanValue();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            function13.invoke(bool);
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                Function1 function14 = (Function1) rememberedValue2;
                                Function2<Composer, Integer, Unit> function2 = ComposableSingletons$TtsCreateFloatViewKt.f18lambda1;
                                final AdelieCreateTtsViewModel adelieCreateTtsViewModel4 = adelieCreateTtsViewModel2;
                                final Function1<Boolean, Unit> function15 = function12;
                                final int i17 = i16;
                                HalfFloatingLayerKt.HalfFloatingLayer(bottom, 0.3f, color$default, 0.0f, function14, rememberHalfFloatingLayerState, function2, ComposableLambdaKt.composableLambda(composer5, -1555550420, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt.TtsCreateFloatView.1.1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
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
                                                ComposerKt.traceEventStart(-1555550420, intValue3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatView.<anonymous>.<anonymous>.<anonymous> (TtsCreateFloatView.kt:79)");
                                            }
                                            TtsCreateFloatViewKt.boardContent(AdelieCreateTtsViewModel.this, mutableState.getValue(), function15, composer7, ((i17 << 3) & 896) | 72);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 14156336, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3128, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24576, 15);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$TtsCreateFloatView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsCreateFloatViewKt.TtsCreateFloatView(AdelieCreateTtsViewModel.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void boardContent(final AdelieCreateTtsViewModel adelieCreateTtsViewModel, final AdelieAudioRecordManager adelieAudioRecordManager, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1467777219);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1467777219, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.boardContent (TtsCreateFloatView.kt:108)");
        }
        ColumnKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), 22.0f, 0.0f, 22.0f, 0.0f, 10, null), QUIToken.color$default("bg_middle_light")), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1157420442, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$boardContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String str;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1157420442, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.boardContent.<anonymous> (TtsCreateFloatView.kt:114)");
                    }
                    i.Companion companion = i.INSTANCE;
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 28.0f), composer3, 8, 0);
                    i k3 = ComposeLayoutPropUpdaterKt.k(companion, 28.0f);
                    Boolean value = AdelieAudioRecordManager.this.isRecording._state.getValue();
                    Boolean bool = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool)) {
                        str = "\u5f55\u97f3\u4e2d\uff0c\u8bf7\u6717\u8bfb...";
                    } else {
                        str = "\u8bf7\u6717\u8bfb";
                    }
                    h color$default = QUIToken.color$default("text_primary");
                    c.Companion companion2 = c.INSTANCE;
                    TextKt.a(str, k3, null, color$default, Float.valueOf(20.0f), null, companion2.f(), null, null, null, null, Float.valueOf(28.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 8.0f), composer3, 8, 0);
                    TextKt.a("\u8bf7\u5728\u5b89\u9759\u7684\u73af\u5883\u4e0b\uff0c\u8bfb\u51fa\u4ee5\u4e0b\u6587\u5b57", ComposeLayoutPropUpdaterKt.k(companion, 20.0f), null, QUIToken.color$default("text_secondary"), Float.valueOf(14.0f), null, companion2.e(), null, null, null, null, Float.valueOf(20.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601606, 48, 0, 134215588);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 32.0f), composer3, 8, 0);
                    i k16 = ComposeLayoutPropUpdaterKt.k(companion, 206.0f);
                    final AdelieCreateTtsViewModel adelieCreateTtsViewModel2 = adelieCreateTtsViewModel;
                    i g16 = ViewEventPropUpdaterKt.g(k16, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$boardContent$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Object obj) {
                            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                            e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_bas_ugc_tone_selection");
                            m16.v("current_timbre", AdelieTtsReport.currentTimbreId);
                            m3.v("cur_pg", m16);
                            AdelieCreateTtsViewModel adelieCreateTtsViewModel3 = AdelieCreateTtsViewModel.this;
                            m3.v("dt_eid", "em_bas_reading_panel");
                            ak value2 = adelieCreateTtsViewModel3.ttsReadTtsInfo._state.getValue();
                            m3.v("text_id", value2 != null ? value2.f404156d : null);
                            ReportKt.reportCustomDTEvent("dt_imp", m3);
                            return Unit.INSTANCE;
                        }
                    });
                    ak value2 = adelieCreateTtsViewModel.ttsReadTtsInfo._state.getValue();
                    TextKt.a(value2 != null ? value2.f404157e : null, g16, null, QUIToken.color$default("text_primary"), Float.valueOf(20.0f), null, companion2.e(), null, null, null, null, Float.valueOf(28.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134215588);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 32.0f), composer3, 8, 0);
                    if (Intrinsics.areEqual(AdelieAudioRecordManager.this.isResetButton._state.getValue(), bool)) {
                        composer3.startReplaceableGroup(2087133327);
                        TtsCreateFloatViewKt.RecordButton(AdelieAudioRecordManager.this, adelieCreateTtsViewModel, function1, composer3, (i3 & 896) | 72);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(2087133406);
                        TtsCreateFloatViewKt.RecordButton(AdelieAudioRecordManager.this, adelieCreateTtsViewModel, function1, composer3, (i3 & 896) | 72);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$boardContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsCreateFloatViewKt.boardContent(AdelieCreateTtsViewModel.this, adelieAudioRecordManager, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void indicatorBar(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1415048936);
        if (i3 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1415048936, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.indicatorBar (TtsCreateFloatView.kt:88)");
            }
            BoxKt.a(ModifiersKt.c(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 14.0f), QUIToken.color$default("bg_middle_light")), Alignment.Center, null, ComposableSingletons$TtsCreateFloatViewKt.f19lambda2, startRestartGroup, 3128, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$indicatorBar$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsCreateFloatViewKt.indicatorBar(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void RecordButton(final AdelieAudioRecordManager adelieAudioRecordManager, final AdelieCreateTtsViewModel adelieCreateTtsViewModel, final Function1<? super Boolean, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-1526923845);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1526923845, i3, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.RecordButton (TtsCreateFloatView.kt:163)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        ColumnKt.a(ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 16.0f, 0.0f, 16.0f, 0.0f, 10, null), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(startRestartGroup, -1216567068, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                String str;
                h color$default;
                h color$default2;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1216567068, intValue, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.RecordButton.<anonymous> (TtsCreateFloatView.kt:174)");
                    }
                    AdelieAudioRecordManager adelieAudioRecordManager2 = AdelieAudioRecordManager.this;
                    if (Intrinsics.areEqual(adelieAudioRecordManager2.isRecording._state.getValue(), Boolean.FALSE)) {
                        str = "";
                    } else if (Intrinsics.areEqual(adelieAudioRecordManager2.isPressedInside._state.getValue(), Boolean.TRUE)) {
                        str = "\u677e\u624b\u53d1\u9001\uff0c\u4e0a\u79fb\u53d6\u6d88";
                    } else {
                        str = "\u677e\u5f00\u53d6\u6d88";
                    }
                    Boolean value = AdelieAudioRecordManager.this.isPressedInside._state.getValue();
                    Boolean bool = Boolean.TRUE;
                    if (Intrinsics.areEqual(value, bool)) {
                        color$default = QUIToken.color$default("text_secondary");
                    } else {
                        color$default = QUIToken.color$default("feedback_error");
                    }
                    h hVar = color$default;
                    i.Companion companion = i.INSTANCE;
                    i k3 = ComposeLayoutPropUpdaterKt.k(companion, 17.0f);
                    int a16 = ai.INSTANCE.a();
                    TextKt.a(str, k3, null, hVar, Float.valueOf(12.0f), null, c.INSTANCE.e(), null, null, null, ai.f(a16), Float.valueOf(17.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer3, 1601600, 48, 0, 134214564);
                    SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion, 16.0f), composer3, 8, 0);
                    final AdelieAudioRecordManager adelieAudioRecordManager3 = AdelieAudioRecordManager.this;
                    final Function1<Boolean, Unit> function12 = function1;
                    Function1<ClickParams, Unit> function13 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ClickParams clickParams) {
                            AdelieAudioRecordManager.this.endRecord(function12);
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("record btn onClick ");
                            m3.append(AdelieAudioRecordManager.this.buttonSize);
                            kLog.i("AdelieTtsSettingViewModel", m3.toString());
                            return Unit.INSTANCE;
                        }
                    };
                    i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.j(companion, 0.0f, 1, null), uo3.c.a(8.0f));
                    if (Intrinsics.areEqual(AdelieAudioRecordManager.this.isPressedInside._state.getValue(), bool)) {
                        color$default2 = QUIToken.color$default("button_bg_primary_default");
                    } else {
                        color$default2 = QUIToken.color$default("feedback_error");
                    }
                    i k16 = ComposeLayoutPropUpdaterKt.k(ModifiersKt.c(q16, color$default2), 45.0f);
                    final AdelieAudioRecordManager adelieAudioRecordManager4 = AdelieAudioRecordManager.this;
                    final Function1<Boolean, Unit> function14 = function1;
                    final MutableState<Boolean> mutableState2 = mutableState;
                    i o16 = ViewEventPropUpdaterKt.o(k16, false, 0, null, new Function1<PanGestureParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(PanGestureParams panGestureParams) {
                            PanGestureParams panGestureParams2 = panGestureParams;
                            String state = panGestureParams2.getState();
                            int hashCode = state.hashCode();
                            if (hashCode != 100571) {
                                if (hashCode != 3357649) {
                                    if (hashCode == 109757538 && state.equals("start")) {
                                        mutableState2.setValue(Boolean.TRUE);
                                    }
                                } else if (state.equals("move")) {
                                    AdelieAudioRecordManager adelieAudioRecordManager5 = AdelieAudioRecordManager.this;
                                    float x16 = panGestureParams2.getX();
                                    float y16 = panGestureParams2.getY();
                                    boolean z16 = x16 >= 0.0f && x16 <= adelieAudioRecordManager5.buttonSize.getWidth() && y16 >= 0.0f && y16 <= adelieAudioRecordManager5.buttonSize.getHeight();
                                    AdelieAudioRecordManager.this.isPressedInside._state.setValue(Boolean.valueOf(z16));
                                }
                            } else if (state.equals("end")) {
                                AdelieAudioRecordManager.this.endRecord(function14);
                                mutableState2.setValue(Boolean.FALSE);
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pan move end ");
                                m3.append(AdelieAudioRecordManager.this.buttonSize);
                                kLog.i("AdelieTtsSettingViewModel", m3.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    }, 7, null);
                    final AdelieAudioRecordManager adelieAudioRecordManager5 = AdelieAudioRecordManager.this;
                    final Function1<Boolean, Unit> function15 = function1;
                    final MutableState<Boolean> mutableState3 = mutableState;
                    i p16 = ViewEventPropUpdaterKt.p(o16, new Function1<MotionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(MotionEvent motionEvent) {
                            MotionEvent motionEvent2 = motionEvent;
                            if (motionEvent2.getAction() == 0) {
                                final AdelieAudioRecordManager adelieAudioRecordManager6 = AdelieAudioRecordManager.this;
                                final Function1<Boolean, Unit> function16 = function15;
                                adelieAudioRecordManager6.getClass();
                                long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
                                if (currentTimeStamp - adelieAudioRecordManager6.lastClickTime < 500) {
                                    KLog.INSTANCE.i("AdelieTtsSettingViewModel", "startRecord so speed");
                                } else {
                                    adelieAudioRecordManager6.lastClickTime = currentTimeStamp;
                                    adelieAudioRecordManager6.isRecording._state.setValue(Boolean.TRUE);
                                    e eVar = new e();
                                    ak value2 = adelieAudioRecordManager6.viewModel.ttsReadTtsInfo._state.getValue();
                                    eVar.v("text_id", value2 != null ? value2.f404156d : null);
                                    eVar.t("current_state", 1);
                                    ReportKt.reportCustomDTEvent("ev_bas_reading_ai_text", eVar);
                                    if (!(adelieAudioRecordManager6.recoredTimer.length() == 0)) {
                                        TimerKt.b(adelieAudioRecordManager6.recoredTimer);
                                    }
                                    adelieAudioRecordManager6.recoredTimer = TimerKt.d(60000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.AdelieAudioRecordManager$startRecord$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u8fbe\u5230\u5f55\u5236\u65f6\u957f\u9650\u5236", QToastMode.Warning);
                                            AdelieAudioRecordManager.this.endRecord(function16);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("touch down ");
                                m3.append(AdelieAudioRecordManager.this.buttonSize);
                                kLog.i("AdelieTtsSettingViewModel", m3.toString());
                            }
                            if (!mutableState3.getValue().booleanValue() && motionEvent2.getAction() == 2) {
                                AdelieAudioRecordManager.this.endRecord(function15);
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("touch up ");
                                m16.append(AdelieAudioRecordManager.this.buttonSize);
                                kLog2.i("AdelieTtsSettingViewModel", m16.toString());
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final AdelieAudioRecordManager adelieAudioRecordManager6 = AdelieAudioRecordManager.this;
                    i k17 = ViewEventPropUpdaterKt.k(p16, new Function1<ap3.a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ap3.a aVar) {
                            AdelieAudioRecordManager.this.buttonSize = aVar.getSize();
                            return Unit.INSTANCE;
                        }
                    });
                    final AdelieAudioRecordManager adelieAudioRecordManager7 = AdelieAudioRecordManager.this;
                    ButtonKt.a(null, function13, k17, null, ComposableLambdaKt.composableLambda(composer3, -1444312295, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$1.5
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
                                    ComposerKt.traceEventStart(-1444312295, intValue2, -1, "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.RecordButton.<anonymous>.<anonymous> (TtsCreateFloatView.kt:232)");
                                }
                                composer5.startReplaceableGroup(-53668268);
                                if (Intrinsics.areEqual(AdelieAudioRecordManager.this.isRecording._state.getValue(), Boolean.TRUE)) {
                                    i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 0.0f, 1, null);
                                    final AdelieAudioRecordManager adelieAudioRecordManager8 = AdelieAudioRecordManager.this;
                                    AdelieAudioRecordFrequencyViewKt.AdelieAudioRecordFrequencyView(f16, new Function2<AdelieAudioRecordFrequencyView, aa<AdelieAudioRecordFrequencyView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt.RecordButton.1.5.1
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Unit invoke(AdelieAudioRecordFrequencyView adelieAudioRecordFrequencyView, aa<AdelieAudioRecordFrequencyView> aaVar) {
                                            AdelieAudioRecordFrequencyView adelieAudioRecordFrequencyView2 = adelieAudioRecordFrequencyView;
                                            final AdelieAudioRecordManager adelieAudioRecordManager9 = AdelieAudioRecordManager.this;
                                            adelieAudioRecordManager9.frequencyView = adelieAudioRecordFrequencyView2;
                                            QQAudioFormat qQAudioFormat = QQAudioFormat.WAV;
                                            final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt.RecordButton.1.5.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Boolean bool2) {
                                                    if (!bool2.booleanValue()) {
                                                        AdelieAudioRecordManager.this.isRecording._state.setValue(Boolean.FALSE);
                                                        Boolean value2 = AdelieAudioRecordManager.this.isResetButton._state.getValue();
                                                        AdelieAudioRecordManager.this.isResetButton._state.setValue(Boolean.valueOf(!Intrinsics.areEqual(value2, Boolean.TRUE)));
                                                    } else {
                                                        AdelieTtsInfo selectTtsInfo = AdelieTtsDataManager.INSTANCE.getSelectTtsInfo();
                                                        if (selectTtsInfo != null) {
                                                            AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule = (AdelieKuiklyTTSPageModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
                                                            e eVar = new e();
                                                            eVar.v("ttsId", selectTtsInfo.ttsId);
                                                            eVar.v("ttsName", selectTtsInfo.getTtsName());
                                                            eVar.v("ttsExample", selectTtsInfo.ttsExample);
                                                            AdelieKuiklyTTSPageModule.stopTtsVoice$default(adelieKuiklyTTSPageModule, eVar);
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            adelieAudioRecordFrequencyView2.getClass();
                                            e eVar = new e();
                                            eVar.v("sampleRate", Float.valueOf(24000.0f));
                                            eVar.t("bitsPerChannel", 16);
                                            eVar.t("channelsPerFrame", 1);
                                            eVar.v("format", qQAudioFormat);
                                            adelieAudioRecordFrequencyView2.callRenderViewMethod("startRecording", eVar.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$startRecording$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(e eVar2) {
                                                    e eVar3 = eVar2;
                                                    Function1<Boolean, Unit> function17 = function16;
                                                    if (function17 != null) {
                                                        function17.invoke(Boolean.valueOf(eVar3 != null ? eVar3.f("success") : true));
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }, composer5, 8, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer5.endReplaceableGroup();
                                } else {
                                    composer5.endReplaceableGroup();
                                    AdelieAudioRecordManager.this.frequencyView = null;
                                    h color$default3 = QUIToken.color$default("button_text_primary_default");
                                    int a17 = ai.INSTANCE.a();
                                    TextKt.a("\u6309\u4f4f\u5f00\u59cb\u5f55\u5236", null, null, color$default3, Float.valueOf(17.0f), null, c.INSTANCE.f(), null, null, null, ai.f(a17), Float.valueOf(24.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601542, 48, 0, 134214566);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 25088, 9);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create.TtsCreateFloatViewKt$RecordButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                TtsCreateFloatViewKt.RecordButton(AdelieAudioRecordManager.this, adelieCreateTtsViewModel, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
