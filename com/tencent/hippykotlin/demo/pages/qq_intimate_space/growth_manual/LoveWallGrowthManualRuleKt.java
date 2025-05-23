package com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.n;
import com.tencent.ntcompose.material.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallGrowthManualRuleKt {
    public static final void LoveWallGrowthManualRule(final Function0<Unit> function0, Composer composer, final int i3) {
        final int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1783574049);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(function0) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783574049, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule (LoveWallGrowthManualRule.kt:48)");
            }
            ModalKt.a(null, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1886888739, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ComposerKt.traceEventStart(-1886888739, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule.<anonymous> (LoveWallGrowthManualRule.kt:49)");
                        }
                        i c16 = ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.5f));
                        final Function0<Unit> function02 = function0;
                        final int i17 = i16;
                        BoxKt.a(c16, null, null, ComposableLambdaKt.composableLambda(composer3, -1271838569, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer4, Integer num2) {
                                int i18;
                                b bVar2 = bVar;
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 14) == 0) {
                                    i18 = (composer5.changed(bVar2) ? 4 : 2) | intValue2;
                                } else {
                                    i18 = intValue2;
                                }
                                if ((i18 & 91) == 18 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1271838569, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule.<anonymous>.<anonymous> (LoveWallGrowthManualRule.kt:52)");
                                    }
                                    i.Companion companion = i.INSTANCE;
                                    i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                    final Function0<Unit> function03 = function02;
                                    composer5.startReplaceableGroup(1157296644);
                                    boolean changed = composer5.changed(function03);
                                    Object rememberedValue = composer5.rememberedValue();
                                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1$1$1$1
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
                                        composer5.updateRememberedValue(rememberedValue);
                                    }
                                    composer5.endReplaceableGroup();
                                    BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), null, null, null, composer5, 8, 14);
                                    i d16 = ViewEventPropUpdaterKt.d(bVar2.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 0.0f, 122, 0.0f, 0.0f, 13, null), Alignment.BottomCenter), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule.1.1.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                            return Unit.INSTANCE;
                                        }
                                    }, 3, null);
                                    final Function0<Unit> function04 = function02;
                                    final int i19 = i17;
                                    BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer5, 728863418, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(b bVar3, Composer composer6, Integer num3) {
                                            int i26;
                                            b bVar4 = bVar3;
                                            Composer composer7 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 14) == 0) {
                                                i26 = (composer7.changed(bVar4) ? 4 : 2) | intValue3;
                                            } else {
                                                i26 = intValue3;
                                            }
                                            if ((i26 & 91) == 18 && composer7.getSkipping()) {
                                                composer7.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(728863418, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualRule.kt:61)");
                                                }
                                                composer7.startReplaceableGroup(-492369756);
                                                Object rememberedValue2 = composer7.rememberedValue();
                                                Composer.Companion companion2 = Composer.INSTANCE;
                                                if (rememberedValue2 == companion2.getEmpty()) {
                                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                    composer7.updateRememberedValue(rememberedValue2);
                                                }
                                                composer7.endReplaceableGroup();
                                                final MutableState mutableState = (MutableState) rememberedValue2;
                                                i.Companion companion3 = i.INSTANCE;
                                                i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null), 0.0f, 40, 0.0f, 0.0f, 13, null);
                                                Alignment alignment = Alignment.BottomCenter;
                                                BoxKt.a(bVar4.a(n3, alignment), null, null, ComposableLambdaKt.composableLambda(composer7, 975170804, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule.1.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar5, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(975170804, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualRule.kt:66)");
                                                            }
                                                            i.Companion companion4 = i.INSTANCE;
                                                            i h17 = ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null);
                                                            int c17 = com.tencent.ntcompose.material.h.INSTANCE.c();
                                                            Boolean bool = Boolean.TRUE;
                                                            final MutableState<Boolean> mutableState2 = mutableState;
                                                            composer9.startReplaceableGroup(1157296644);
                                                            boolean changed2 = composer9.changed(mutableState2);
                                                            Object rememberedValue3 = composer9.rememberedValue();
                                                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue3 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1$1$3$1$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                                        mutableState2.setValue(Boolean.TRUE);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue3);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            ImageKt.a(null, null, null, null, null, h17, null, c17, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_aa89x1atuzH.png", null, bool, null, null, null, (Function1) rememberedValue3, null, null, null, null, composer9, 12845056, 390, 0, 2026335);
                                                            if (mutableState.getValue().booleanValue()) {
                                                                BoxKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), 20, 51, 32, com.tencent.ntcompose.activity.b.a().getPageData().getSafeAreaInsets().getBottom() + 40.0f), null, null, ComposableSingletons$LoveWallGrowthManualRuleKt.f98lambda1, composer9, 3080, 6);
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3080, 6);
                                                if (((Boolean) mutableState.getValue()).booleanValue()) {
                                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 180), 80.0f), 7, 0.0f, 2, null), null, com.tencent.ntcompose.material.h.INSTANCE.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_NHW74B1IXGA.png", null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 6, 0, 2095967);
                                                    BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 32.0f), 0.0f, 20, 16, 0.0f, 9, null), null, null, ComposableLambdaKt.composableLambda(composer7, -421591495, true, new Function3<b, Composer, Integer, Unit>(function04, i19) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule.1.1.3.2
                                                        public final /* synthetic */ Function0<Unit> $onExit;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar5, Composer composer8, Integer num4) {
                                                            int i27;
                                                            b bVar6 = bVar5;
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 14) == 0) {
                                                                i27 = (composer9.changed(bVar6) ? 4 : 2) | intValue4;
                                                            } else {
                                                                i27 = intValue4;
                                                            }
                                                            if ((i27 & 91) == 18 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-421591495, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRule.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualRule.kt:123)");
                                                                }
                                                                i a16 = bVar6.a(ComposeLayoutPropUpdaterKt.u(i.INSTANCE, 32.0f), Alignment.TopEnd);
                                                                final Function0<Unit> function05 = this.$onExit;
                                                                composer9.startReplaceableGroup(1157296644);
                                                                boolean changed2 = composer9.changed(function05);
                                                                Object rememberedValue3 = composer9.rememberedValue();
                                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1$1$3$2$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            function05.invoke();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    composer9.updateRememberedValue(rememberedValue3);
                                                                }
                                                                composer9.endReplaceableGroup();
                                                                ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue3, 3, null), null, 0, null, null, QUIToken.INSTANCE.image("close_circle", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2096095);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 3080, 6);
                                                    i p16 = ComposeLayoutPropUpdaterKt.p(bVar4.a(ComposeLayoutPropUpdaterKt.v(companion3, 66, 23), alignment), 0.0f, -com.tencent.ntcompose.activity.b.a().getPageData().getSafeAreaInsets().getBottom(), 1, null);
                                                    final Function0<Unit> function05 = function04;
                                                    composer7.startReplaceableGroup(1157296644);
                                                    boolean changed2 = composer7.changed(function05);
                                                    Object rememberedValue3 = composer7.rememberedValue();
                                                    if (changed2 || rememberedValue3 == companion2.getEmpty()) {
                                                        rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$1$1$3$3$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                function05.invoke();
                                                                MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), "https://wj.qq.com/s2/17363000/be3b/");
                                                                return Unit.INSTANCE;
                                                            }
                                                        };
                                                        composer7.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    RowKt.a(ViewEventPropUpdaterKt.d(p16, false, null, (Function1) rememberedValue3, 3, null), a.f339245a.b(), Alignment.Vertical.CenterVertically, null, null, ComposableSingletons$LoveWallGrowthManualRuleKt.f99lambda2, composer7, 197064, 24);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 3080, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 3080, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }), startRestartGroup, 24624, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallGrowthManualRule$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallGrowthManualRuleKt.LoveWallGrowthManualRule(function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallRuleTitle(final String str, final String str2, final i iVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(166021877);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(166021877, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallRuleTitle (LoveWallGrowthManualRule.kt:170)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null), 27), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1012439035, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallRuleTitle$1
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
                        ComposerKt.traceEventStart(1012439035, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallRuleTitle.<anonymous> (LoveWallGrowthManualRule.kt:173)");
                    }
                    ImageKt.a(null, null, null, null, null, bVar2.a(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 149), 20), -12, 0.0f, 2, null), Alignment.BottomStart), null, 0, null, null, str2, null, null, null, null, null, null, null, null, null, null, composer3, 262144, (i3 >> 3) & 14, 0, 2096095);
                    TextKt.a(str, iVar, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(null, Float.valueOf(18), null, o.c(o.INSTANCE.a()), new n("MFYuanHei"), null, null, null, ai.f(ai.INSTANCE.c()), Float.valueOf(27), null, null, null, null, 15589, null), null, null, null, null, null, false, composer3, (i3 & 14) | 64, 0, k.f28903n, 133169148);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallRuleTitle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallGrowthManualRuleKt.LoveWallRuleTitle(str, str2, iVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallRuleContent(final String str, Composer composer, final int i3) {
        int i16;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(92728508);
        if ((i3 & 14) == 0) {
            i16 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i16 = i3;
        }
        if ((i16 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(92728508, i16, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallRuleContent (LoveWallGrowthManualRule.kt:194)");
            }
            composer2 = startRestartGroup;
            TextKt.a(str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(null, Float.valueOf(14), null, o.c(o.INSTANCE.b()), null, null, null, null, null, Float.valueOf(20), null, null, null, null, 15861, null), null, null, null, null, null, false, composer2, i16 & 14, 0, k.f28903n, 133169150);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualRuleKt$LoveWallRuleContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer3, Integer num) {
                num.intValue();
                LoveWallGrowthManualRuleKt.LoveWallRuleContent(str, composer3, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
