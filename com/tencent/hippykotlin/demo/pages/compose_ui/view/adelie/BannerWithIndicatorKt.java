package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.foundation.lazy.layout.LazyDslKt;
import com.tencent.ntcompose.material.SliderPageKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.ac;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import uo3.c;
import zo3.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BannerWithIndicatorKt {
    public static final <T> void BannerWithIndicator(final List<? extends T> list, final float f16, final i iVar, int i3, boolean z16, boolean z17, float f17, g gVar, Alignment alignment, Function1<? super Integer, Unit> function1, final Function4<? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i16, final int i17, final int i18) {
        g gVar2;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(1600006775);
        int i26 = (i18 & 8) != 0 ? 3000 : i3;
        boolean z18 = (i18 & 16) != 0 ? true : z16;
        boolean z19 = (i18 & 32) != 0 ? true : z17;
        float f18 = (i18 & 64) != 0 ? 8.0f : f17;
        if ((i18 & 128) != 0) {
            i19 = i16 & (-29360129);
            gVar2 = c.a(8.0f);
        } else {
            gVar2 = gVar;
            i19 = i16;
        }
        Alignment alignment2 = (i18 & 256) != 0 ? Alignment.BottomEnd : alignment;
        Function1<? super Integer, Unit> function12 = (i18 & 512) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1600006775, i19, i17, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicator (BannerWithIndicator.kt:36)");
        }
        if (list.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final int i27 = i26;
            final boolean z26 = z18;
            final boolean z27 = z19;
            final float f19 = f18;
            final g gVar3 = gVar2;
            final Alignment alignment3 = alignment2;
            final Function1<? super Integer, Unit> function13 = function12;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    BannerWithIndicatorKt.BannerWithIndicator(list, f16, iVar, i27, z26, z27, f19, gVar3, alignment3, function13, function4, composer2, i16 | 1, i17, i18);
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final Alignment alignment4 = alignment2;
        final int i28 = i19;
        final int i29 = i26;
        final boolean z28 = z18;
        final Function1<? super Integer, Unit> function14 = function12;
        final boolean z29 = z19;
        final float f26 = f18;
        SurfaceKt.a(iVar, gVar2, null, h.INSTANCE.j(), ComposableLambdaKt.composableLambda(startRestartGroup, -1883658183, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$2
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
                        ComposerKt.traceEventStart(-1883658183, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicator.<anonymous> (BannerWithIndicator.kt:69)");
                    }
                    final i iVar2 = i.this;
                    Alignment alignment5 = alignment4;
                    final List<T> list2 = list;
                    final float f27 = f16;
                    final int i36 = i29;
                    final boolean z36 = z28;
                    final Function1<Integer, Unit> function15 = function14;
                    final MutableState<Integer> mutableState2 = mutableState;
                    final int i37 = i28;
                    final Function4<Integer, T, Composer, Integer, Unit> function42 = function4;
                    final int i38 = i17;
                    final boolean z37 = z29;
                    final float f28 = f26;
                    BoxKt.a(iVar2, alignment5, null, ComposableLambdaKt.composableLambda(composer3, 228365119, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$2.1
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
                                    ComposerKt.traceEventStart(228365119, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicator.<anonymous>.<anonymous> (BannerWithIndicator.kt:73)");
                                }
                                i iVar3 = i.this;
                                List<Object> list3 = list2;
                                float f29 = f27;
                                int i39 = i36;
                                boolean z38 = z36;
                                final Function1<Integer, Unit> function16 = function15;
                                final MutableState<Integer> mutableState3 = mutableState2;
                                composer5.startReplaceableGroup(511388516);
                                boolean changed = composer5.changed(function16) | composer5.changed(mutableState3);
                                Object rememberedValue2 = composer5.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$2$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            Function1<Integer, Unit> function17 = function16;
                                            if (function17 != null) {
                                                function17.invoke(Integer.valueOf(mutableState3.getValue().intValue()));
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue2);
                                }
                                composer5.endReplaceableGroup();
                                Function0 function0 = (Function0) rememberedValue2;
                                final MutableState<Integer> mutableState4 = mutableState2;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed2 = composer5.changed(mutableState4);
                                Object rememberedValue3 = composer5.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function1<Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$2$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(Integer num3) {
                                            mutableState4.setValue(Integer.valueOf(num3.intValue()));
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composer5.updateRememberedValue(rememberedValue3);
                                }
                                composer5.endReplaceableGroup();
                                Function4<Integer, Object, Composer, Integer, Unit> function43 = function42;
                                int i46 = i37;
                                BannerWithIndicatorKt.BannerSlider(iVar3, list3, f29, i39, z38, function0, (Function1) rememberedValue3, function43, composer5, (i46 & 57344) | ((i46 << 3) & 896) | 72 | (i46 & 7168) | ((i38 << 21) & 29360128), 0);
                                if (z37 && list2.size() > 1) {
                                    BannerWithIndicatorKt.Indicator(mutableState2.getValue().intValue(), list2.size(), f28, composer5, (i37 >> 12) & 896);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, ((i28 >> 21) & 112) | 3080, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i19 >> 18) & 112) | 28680, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 == null) {
            return;
        }
        final int i36 = i26;
        final boolean z36 = z18;
        final boolean z37 = z19;
        final float f27 = f18;
        final g gVar4 = gVar2;
        final Alignment alignment5 = alignment2;
        final Function1<? super Integer, Unit> function15 = function12;
        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerWithIndicator$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BannerWithIndicatorKt.BannerWithIndicator(list, f16, iVar, i36, z36, z37, f27, gVar4, alignment5, function15, function4, composer2, i16 | 1, i17, i18);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void Indicator(final int i3, final int i16, final float f16, Composer composer, final int i17) {
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(2015481194);
        if ((i17 & 14) == 0) {
            i18 = (startRestartGroup.changed(i3) ? 4 : 2) | i17;
        } else {
            i18 = i17;
        }
        if ((i17 & 112) == 0) {
            i18 |= startRestartGroup.changed(i16) ? 32 : 16;
        }
        if ((i17 & 896) == 0) {
            i18 |= startRestartGroup.changed(f16) ? 256 : 128;
        }
        if ((i18 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015481194, i17, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.Indicator (BannerWithIndicator.kt:131)");
            }
            RowKt.a(ComposeLayoutPropUpdaterKt.q(i.INSTANCE, 8), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1069846392, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$Indicator$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(n nVar, Composer composer2, Integer num) {
                    h color$default;
                    Composer composer3 = composer2;
                    int intValue = num.intValue();
                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                    } else {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1069846392, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.Indicator.<anonymous> (BannerWithIndicator.kt:140)");
                        }
                        int i19 = i16;
                        int i26 = i3;
                        float f17 = f16;
                        for (int i27 = 0; i27 < i19; i27++) {
                            if (i27 == i26) {
                                color$default = QUIToken.color$default("text_allwhite_primary");
                            } else {
                                color$default = QUIToken.color$default("fill_allblack_weak");
                            }
                            i.Companion companion = i.INSTANCE;
                            SpacerKt.a(ComposeLayoutPropUpdaterKt.w(companion, 8.0f), composer3, 8, 0);
                            BoxKt.a(ModifiersKt.c(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion, f17), c.b()), color$default), null, null, null, composer3, 8, 14);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 196680, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$Indicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BannerWithIndicatorKt.Indicator(i3, i16, f16, composer2, i17 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final <T> void BannerSlider(final i iVar, final List<? extends T> list, final float f16, final int i3, boolean z16, final Function0<Unit> function0, final Function1<? super Integer, Unit> function1, final Function4<? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i16, final int i17) {
        Composer startRestartGroup = composer.startRestartGroup(1981055753);
        final boolean z17 = (i17 & 16) != 0 ? true : z16;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1981055753, i16, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerSlider (BannerWithIndicator.kt:100)");
        }
        ac A = SliderPageKt.A(startRestartGroup, 0);
        int size = list.size();
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed(function0);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerSlider$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ClickParams clickParams) {
                    Function0<Unit> function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        int i18 = i16 << 6;
        SliderPageKt.a(null, ViewEventPropUpdaterKt.d(iVar, false, null, (Function1) rememberedValue, 3, null), A, f16, size, i3, 0, z17, function1, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 861636433, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerSlider$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar, Composer composer2, Integer num) {
                com.tencent.ntcompose.foundation.lazy.layout.a aVar2 = aVar;
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(861636433, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerSlider.<anonymous> (BannerWithIndicator.kt:122)");
                }
                List<T> list2 = list;
                final Function4<Integer, T, Composer, Integer, Unit> function42 = function4;
                final int i19 = i16;
                LazyDslKt.c(aVar2, list2, null, ComposableLambdaKt.composableLambda(composer3, -877314894, true, new Function4<Integer, Object, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerSlider$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(Integer num2, Object obj, Composer composer4, Integer num3) {
                        int i26;
                        int intValue2 = num2.intValue();
                        Composer composer5 = composer4;
                        int intValue3 = num3.intValue();
                        if ((intValue3 & 14) == 0) {
                            i26 = (composer5.changed(intValue2) ? 4 : 2) | intValue3;
                        } else {
                            i26 = intValue3;
                        }
                        if ((intValue3 & 112) == 0) {
                            i26 |= composer5.changed(obj) ? 32 : 16;
                        }
                        if ((i26 & TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY) == 146 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-877314894, i26, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerSlider.<anonymous>.<anonymous> (BannerWithIndicator.kt:123)");
                            }
                            function42.invoke(Integer.valueOf(intValue2), obj, composer5, Integer.valueOf((i26 & 112) | (i26 & 14) | ((i19 >> 15) & 896)));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), composer3, 3144, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, ((i16 << 3) & 7168) | 64 | (458752 & i18) | ((i16 << 9) & 29360128) | (i18 & 234881024), 24576, 15937);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.BannerWithIndicatorKt$BannerSlider$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                BannerWithIndicatorKt.BannerSlider(i.this, list, f16, i3, z17, function0, function1, function4, composer2, i16 | 1, i17);
                return Unit.INSTANCE;
            }
        });
    }
}
