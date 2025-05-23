package com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bp3.j;
import bp3.k;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveSproutCardViewKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageData;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.LazyVerticalGridKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.RichTextKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import e25.i;
import java.util.Iterator;
import kotlin.NotImplementedError;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.aspectj.lang.JoinPoint;
import uo3.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallGrowthManualViewKt {
    public static final void GrowthTaskItem(final i iVar, final Function1<? super ClickParams, Unit> function1, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1274389489);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1274389489, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.GrowthTaskItem (LoveWallGrowthManualView.kt:274)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), 40), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -613129225, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$GrowthTaskItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                int i16;
                i.Companion companion;
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
                        ComposerKt.traceEventStart(-613129225, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.GrowthTaskItem.<anonymous> (LoveWallGrowthManualView.kt:280)");
                    }
                    String str = e25.i.this.f395481h;
                    i.Companion companion2 = com.tencent.ntcompose.core.i.INSTANCE;
                    ImageKt.a(null, null, null, null, null, bVar2.a(ModifiersKt.h(ModifiersKt.q(ComposeLayoutPropUpdaterKt.u(companion2, 40), c.b()), 1.33f, h.INSTANCE.m(), null, 4, null), Alignment.CenterStart), null, 0, null, null, str, null, null, null, null, null, null, null, null, null, null, composer3, 262144, 0, 0, 2096095);
                    com.tencent.ntcompose.core.i a16 = bVar2.a(ComposeLayoutPropUpdaterKt.v(companion2, 64.0f, 32.0f), Alignment.CenterEnd);
                    int i17 = e25.i.this.G;
                    if (i17 != 0) {
                        if (i17 == 1) {
                            companion = companion2;
                            composer3.startReplaceableGroup(-1101280353);
                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(a16, false, null, function1, 3, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_A_ZcGy4BSwY.png", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                            composer3.endReplaceableGroup();
                        } else if (i17 == 2) {
                            companion = companion2;
                            composer3.startReplaceableGroup(-1101280028);
                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(a16, false, null, function1, 3, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_FkAMyDIb46l.png", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                            composer3.endReplaceableGroup();
                        } else if (i17 != 3) {
                            composer3.startReplaceableGroup(-1101279688);
                            composer3.endReplaceableGroup();
                            companion = companion2;
                        } else {
                            composer3.startReplaceableGroup(-1101280675);
                            companion = companion2;
                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(a16, false, null, function1, 3, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_8e2BG0ennn0.png", null, null, null, null, null, null, null, null, null, null, composer3, 262144, 6, 0, 2096095);
                            composer3.endReplaceableGroup();
                        }
                        com.tencent.ntcompose.core.i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 36), 49, 0.0f, 63, 0.0f, 10, null);
                        a.e e16 = a.f339245a.e();
                        Alignment.Horizontal horizontal = Alignment.Horizontal.Start;
                        final e25.i iVar2 = e25.i.this;
                        ColumnKt.a(n3, e16, horizontal, null, ComposableLambdaKt.composableLambda(composer3, 607997934, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$GrowthTaskItem$1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                                Composer composer5 = composer4;
                                int intValue2 = num2.intValue();
                                if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(607997934, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.GrowthTaskItem.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:318)");
                                    }
                                    TextKt.a(e25.i.this.f395479e, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("text_primary"), Float.valueOf(16), null, null, null, null, null, null, ai.f(ai.INSTANCE.c()), null, null, null, null, null, 16124, null), null, null, null, null, null, false, composer5, 0, 0, k.f28903n, 133169150);
                                    com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null);
                                    a.d g16 = a.f339245a.g();
                                    Alignment.Vertical vertical = Alignment.Vertical.CenterVertically;
                                    final e25.i iVar3 = e25.i.this;
                                    RowKt.a(j3, g16, vertical, null, null, ComposableLambdaKt.composableLambda(composer5, 1531548048, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.GrowthTaskItem.1.1.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                            Composer composer7;
                                            String replace$default;
                                            String replace$default2;
                                            Composer composer8 = composer6;
                                            int intValue3 = num3.intValue();
                                            if ((intValue3 & 81) == 16 && composer8.getSkipping()) {
                                                composer8.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1531548048, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.GrowthTaskItem.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:332)");
                                                }
                                                composer8.startReplaceableGroup(-1201340641);
                                                if (e25.i.this.G == 3) {
                                                    i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                                    float f16 = 12;
                                                    composer7 = composer8;
                                                    ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion3, f16), null, 0, null, null, QUIToken.INSTANCE.image(JoinPoint.SYNCHRONIZATION_LOCK, QUIToken.color$default("brand_standard")), null, null, null, null, null, null, null, null, null, null, composer7, 262144, 0, 0, 2096095);
                                                    TextKt.a(e25.i.this.H, ComposeLayoutPropUpdaterKt.n(companion3, 2, 0.0f, 0.0f, 0.0f, 14, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new k(QUIToken.color$default("brand_standard"), Float.valueOf(f16), null, null, null, null, null, null, ai.f(ai.INSTANCE.c()), null, null, null, null, null, 16124, null), null, null, null, null, null, false, composer7, 64, 0, k.f28903n, 133169148);
                                                } else {
                                                    composer7 = composer8;
                                                }
                                                composer7.endReplaceableGroup();
                                                com.tencent.ntcompose.core.i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), e25.i.this.G == 3 ? 4 : 0.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                replace$default = StringsKt__StringsJVMKt.replace$default(e25.i.this.D, "[", "", false, 4, (Object) null);
                                                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "]", "", false, 4, (Object) null);
                                                RichTextKt.b(LoveSproutCardViewKt.highlightedText(replace$default2, new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null), LoveSproutCardViewKt.extractBracketedContent(e25.i.this.D), new j(new h(255, 128, 0, 1.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null)), n16, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, new k(QUIToken.color$default("text_secondary"), Float.valueOf(12), null, null, null, null, null, null, ai.f(ai.INSTANCE.c()), Float.valueOf(14), null, null, null, null, 15612, null), null, null, null, null, null, null, composer7, 64, 100663296, k.f28903n << 3, 266076156);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer5, 197064, 24);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), composer3, 25032, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composer3.startReplaceableGroup(-1101279704);
                        composer3.endReplaceableGroup();
                        throw new NotImplementedError(null, 1, null);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$GrowthTaskItem$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallGrowthManualViewKt.GrowthTaskItem(e25.i.this, function1, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public static final void LoveWallGrowthManual(final com.tencent.ntcompose.core.i iVar, final LoveWallHomepageData loveWallHomepageData, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1055115017);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1055115017, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual (LoveWallGrowthManualView.kt:67)");
        }
        ModalKt.a(iVar, false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1371679495, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1
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
                        ComposerKt.traceEventStart(1371679495, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous> (LoveWallGrowthManualView.kt:76)");
                    }
                    com.tencent.ntcompose.core.i elementVR = ModifierExtKt.elementVR(ModifiersKt.c(ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), h.INSTANCE.a(0.5f)), "em_qz_planting_handbook_pop", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                    final Function0<Unit> function03 = function0;
                    final int i16 = i3;
                    final Function0<Unit> function04 = function02;
                    final LoveWallHomepageData loveWallHomepageData2 = loveWallHomepageData;
                    BoxKt.a(elementVR, null, null, ComposableLambdaKt.composableLambda(composer3, -1719582271, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(-1719582271, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:80)");
                                }
                                i.Companion companion = com.tencent.ntcompose.core.i.INSTANCE;
                                com.tencent.ntcompose.core.i h16 = ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null);
                                final Function0<Unit> function05 = function03;
                                composer5.startReplaceableGroup(1157296644);
                                boolean changed = composer5.changed(function05);
                                Object rememberedValue = composer5.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$1$1
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
                                    composer5.updateRememberedValue(rememberedValue);
                                }
                                composer5.endReplaceableGroup();
                                BoxKt.a(ViewEventPropUpdaterKt.d(h16, false, null, (Function1) rememberedValue, 3, null), null, null, null, composer5, 8, 14);
                                com.tencent.ntcompose.core.i d16 = ViewEventPropUpdaterKt.d(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 0.0f, 156, 0.0f, 0.0f, 13, null), false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                }, 3, null);
                                final Function0<Unit> function06 = function04;
                                final int i17 = i16;
                                final LoveWallHomepageData loveWallHomepageData3 = loveWallHomepageData2;
                                final Function0<Unit> function07 = function03;
                                BoxKt.a(d16, null, null, ComposableLambdaKt.composableLambda(composer5, -1546226076, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3

                                    /* compiled from: P */
                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$5", f = "LoveWallGrowthManualView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$5, reason: invalid class name */
                                    /* loaded from: classes37.dex */
                                    public final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        public final /* synthetic */ MutableState<Boolean> $hide;
                                        public final /* synthetic */ Animatable<Float> $opacityAnimation;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass5(Animatable<Float> animatable, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass5> continuation) {
                                            super(2, continuation);
                                            this.$opacityAnimation = animatable;
                                            this.$hide = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass5(this.$opacityAnimation, this.$hide, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float> animatable = this.$opacityAnimation;
                                            Float boxFloat = Boxing.boxFloat(1.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(300, 0, null, null, 14, null);
                                            final MutableState<Boolean> mutableState = this.$hide;
                                            Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f16) {
                                                    f16.floatValue();
                                                    mutableState.setValue(Boolean.TRUE);
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* compiled from: P */
                                    @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$6", f = "LoveWallGrowthManualView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$6, reason: invalid class name */
                                    /* loaded from: classes37.dex */
                                    public final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        public final /* synthetic */ Animatable<Float> $opacityAnimation;
                                        public final /* synthetic */ MutableState<LoveWallGrowthManualViewModel> $viewModel;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        public AnonymousClass6(Animatable<Float> animatable, MutableState<LoveWallGrowthManualViewModel> mutableState, Continuation<? super AnonymousClass6> continuation) {
                                            super(2, continuation);
                                            this.$opacityAnimation = animatable;
                                            this.$viewModel = mutableState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass6(this.$opacityAnimation, this.$viewModel, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            ResultKt.throwOnFailure(obj);
                                            Animatable<Float> animatable = this.$opacityAnimation;
                                            Float boxFloat = Boxing.boxFloat(0.0f);
                                            m d16 = com.tencent.ntcompose.animation.b.d(300, 2000, null, null, 12, null);
                                            final MutableState<LoveWallGrowthManualViewModel> mutableState = this.$viewModel;
                                            Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.6.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Float f16) {
                                                    f16.floatValue();
                                                    mutableState.getValue().showTip.setValue(Boolean.FALSE);
                                                    return Unit.INSTANCE;
                                                }
                                            }, false, 8, null);
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar2, Composer composer6, Integer num3) {
                                        int i18;
                                        final MutableState mutableState;
                                        b bVar3 = bVar2;
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 14) == 0) {
                                            i18 = (composer7.changed(bVar3) ? 4 : 2) | intValue3;
                                        } else {
                                            i18 = intValue3;
                                        }
                                        if ((i18 & 91) == 18 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1546226076, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:87)");
                                            }
                                            composer7.startReplaceableGroup(-492369756);
                                            Object rememberedValue2 = composer7.rememberedValue();
                                            Composer.Companion companion2 = Composer.INSTANCE;
                                            if (rememberedValue2 == companion2.getEmpty()) {
                                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                composer7.updateRememberedValue(rememberedValue2);
                                            }
                                            composer7.endReplaceableGroup();
                                            final MutableState mutableState2 = (MutableState) rememberedValue2;
                                            LoveWallHomepageData loveWallHomepageData4 = loveWallHomepageData3;
                                            Function0<Unit> function08 = function07;
                                            composer7.startReplaceableGroup(-492369756);
                                            Object rememberedValue3 = composer7.rememberedValue();
                                            if (rememberedValue3 == companion2.getEmpty()) {
                                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new LoveWallGrowthManualViewModel(loveWallHomepageData4, function08), null, 2, null);
                                                composer7.updateRememberedValue(rememberedValue3);
                                            }
                                            composer7.endReplaceableGroup();
                                            final MutableState mutableState3 = (MutableState) rememberedValue3;
                                            i.Companion companion3 = com.tencent.ntcompose.core.i.INSTANCE;
                                            com.tencent.ntcompose.core.i h17 = ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null);
                                            h.Companion companion4 = com.tencent.ntcompose.material.h.INSTANCE;
                                            int c16 = companion4.c();
                                            Boolean bool = Boolean.TRUE;
                                            composer7.startReplaceableGroup(1157296644);
                                            boolean changed2 = composer7.changed(mutableState2);
                                            Object rememberedValue4 = composer7.rememberedValue();
                                            if (changed2 || rememberedValue4 == companion2.getEmpty()) {
                                                rememberedValue4 = new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$1$1
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
                                                composer7.updateRememberedValue(rememberedValue4);
                                            }
                                            composer7.endReplaceableGroup();
                                            ImageKt.a(null, null, null, null, null, h17, null, c16, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_aa89x1atuzH.png", null, bool, null, null, null, (Function1) rememberedValue4, null, null, null, null, composer7, 12845056, 390, 0, 2026335);
                                            if (!((Boolean) mutableState2.getValue()).booleanValue()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            } else {
                                                float f16 = 20;
                                                ColumnKt.a(ComposeLayoutPropUpdaterKt.m(ComposeLayoutPropUpdaterKt.h(companion3, 0.0f, 1, null), f16, 41, f16, com.tencent.ntcompose.activity.b.a().getPageData().getSafeAreaInsets().getBottom() + 40.0f), null, Alignment.INSTANCE.b(), null, ComposableLambdaKt.composableLambda(composer7, 347435597, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(d dVar, Composer composer8, Integer num4) {
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(347435597, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:107)");
                                                            }
                                                            i.Companion companion5 = com.tencent.ntcompose.core.i.INSTANCE;
                                                            Direction direction = Direction.TO_RIGHT;
                                                            LoveWallGrowthManualRuleKt.LoveWallRuleTitle("\u517b\u6210\u8bf4\u660e", "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_BXVkCiP1i8n.png", ModifiersKt.e(companion5, direction, new com.tencent.kuikly.core.base.j(new com.tencent.kuikly.core.base.h(4278366577L), 0.0f), new com.tencent.kuikly.core.base.j(new com.tencent.kuikly.core.base.h(4280621584L), 0.0f)), composer9, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
                                                            float f17 = 8;
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion5, f17), composer9, 8, 0);
                                                            com.tencent.ntcompose.core.i j3 = ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null);
                                                            a aVar = a.f339245a;
                                                            RowKt.a(j3, aVar.g(), null, null, null, ComposableSingletons$LoveWallGrowthManualViewKt.f100lambda1, composer9, 196680, 28);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion5, f17), composer9, 8, 0);
                                                            ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.v(companion5, 334.0f, 157.0f), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_vZsZSGH2Gcm.png", null, null, null, null, null, null, null, null, null, null, composer9, 262144, 6, 0, 2096095);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion5, 9), composer9, 8, 0);
                                                            RowKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.j(companion5, 0.0f, 1, null), 4, 0.0f, 0.0f, 0.0f, 14, null), aVar.g(), null, null, null, ComposableSingletons$LoveWallGrowthManualViewKt.f101lambda2, composer9, 196680, 28);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion5, 20), composer9, 8, 0);
                                                            LoveWallGrowthManualRuleKt.LoveWallRuleTitle("\u7ed3\u679c\u79d8\u7c4d", "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_BXVkCiP1i8n.png", ModifiersKt.e(companion5, direction, new com.tencent.kuikly.core.base.j(new com.tencent.kuikly.core.base.h(4278366577L), 0.0f), new com.tencent.kuikly.core.base.j(new com.tencent.kuikly.core.base.h(4280621584L), 0.0f)), composer9, PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT);
                                                            SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion5, f17), composer9, 8, 0);
                                                            com.tencent.ntcompose.core.i h18 = ComposeLayoutPropUpdaterKt.h(companion5, 0.0f, 1, null);
                                                            final MutableState<LoveWallGrowthManualViewModel> mutableState4 = mutableState3;
                                                            BoxKt.a(h18, null, null, ComposableLambdaKt.composableLambda(composer9, -1872204153, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar4, Composer composer10, Integer num5) {
                                                                    Composer composer11 = composer10;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 81) == 16 && composer11.getSkipping()) {
                                                                        composer11.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1872204153, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:159)");
                                                                        }
                                                                        Boolean bool2 = Boolean.FALSE;
                                                                        final MutableState<LoveWallGrowthManualViewModel> mutableState5 = mutableState4;
                                                                        LazyVerticalGridKt.a(new r.a(1), ComposeLayoutPropUpdaterKt.h(com.tencent.ntcompose.core.i.INSTANCE, 0.0f, 1, null), ((com.tencent.ntcompose.ui.platform.a) composer11.consume(CompositionLocalsKt.d())).e() - 40.0f, null, null, null, 0.0f, 16, null, null, null, bool2, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(composer11, -1825208926, true, new Function3<com.tencent.ntcompose.foundation.lazy.layout.a, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.2.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(3);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function3
                                                                            public final Unit invoke(com.tencent.ntcompose.foundation.lazy.layout.a aVar2, Composer composer12, Integer num6) {
                                                                                Composer composer13 = composer12;
                                                                                int intValue6 = num6.intValue();
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1825208926, intValue6, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:166)");
                                                                                }
                                                                                Iterator<e25.i> it = mutableState5.getValue().flowerTaskList.iterator();
                                                                                while (it.hasNext()) {
                                                                                    final e25.i next = it.next();
                                                                                    final MutableState<LoveWallGrowthManualViewModel> mutableState6 = mutableState5;
                                                                                    LoveWallGrowthManualViewKt.GrowthTaskItem(next, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.2.1.1.1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                                            String str;
                                                                                            LoveWallGrowthManualViewModel value = mutableState6.getValue();
                                                                                            e25.i iVar2 = next;
                                                                                            value.getClass();
                                                                                            if (iVar2.G == 3) {
                                                                                                value.tip.setValue("\u53bb\u6d47\u6c34\u8ba9\u690d\u7269\u957f\u9ad8\u54e6~");
                                                                                                value.showTip.setValue(Boolean.TRUE);
                                                                                            } else {
                                                                                                e25.b bVar5 = iVar2.F;
                                                                                                if (bVar5 != null && (str = bVar5.f395470f) != null) {
                                                                                                    KLog.INSTANCE.i("LoveWall", "jumpUrl: " + str);
                                                                                                    if (str.length() > 0) {
                                                                                                        MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str);
                                                                                                        value.onExit.invoke();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    }, composer13, 8);
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }), composer11, 12582976, 48, 1572864, 67106680);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer9, 3080, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 24584, 10);
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion3, 180), 80.0f), 7, -40.0f), null, companion4.c(), null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_NHW74B1IXGA.png", null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 6, 0, 2095967);
                                                com.tencent.ntcompose.core.i p16 = ComposeLayoutPropUpdaterKt.p(bVar3.a(ComposeLayoutPropUpdaterKt.v(companion3, 100, 23), Alignment.BottomCenter), 0.0f, -com.tencent.ntcompose.activity.b.a().getPageData().getSafeAreaInsets().getBottom(), 1, null);
                                                final Function0<Unit> function09 = function06;
                                                composer7.startReplaceableGroup(1157296644);
                                                boolean changed3 = composer7.changed(function09);
                                                Object rememberedValue5 = composer7.rememberedValue();
                                                if (changed3 || rememberedValue5 == companion2.getEmpty()) {
                                                    rememberedValue5 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$3$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function09.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                    composer7.updateRememberedValue(rememberedValue5);
                                                }
                                                composer7.endReplaceableGroup();
                                                RowKt.a(ViewEventPropUpdaterKt.d(p16, false, null, (Function1) rememberedValue5, 3, null), a.f339245a.g(), Alignment.Vertical.CenterVertically, null, null, ComposableSingletons$LoveWallGrowthManualViewKt.f102lambda3, composer7, 197064, 24);
                                                BoxKt.a(ComposeLayoutPropUpdaterKt.p(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.j(companion3, 0.0f, 1, null), 32.0f), 0.0f, 0.0f, 16, 0.0f, 11, null), 0.0f, -20.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(composer7, -404374626, true, new Function3<b, Composer, Integer, Unit>(function07, i17) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.4
                                                    public final /* synthetic */ Function0<Unit> $onExit;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(b bVar4, Composer composer8, Integer num4) {
                                                        int i19;
                                                        b bVar5 = bVar4;
                                                        Composer composer9 = composer8;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 14) == 0) {
                                                            i19 = (composer9.changed(bVar5) ? 4 : 2) | intValue4;
                                                        } else {
                                                            i19 = intValue4;
                                                        }
                                                        if ((i19 & 91) == 18 && composer9.getSkipping()) {
                                                            composer9.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-404374626, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:214)");
                                                            }
                                                            com.tencent.ntcompose.core.i a16 = bVar5.a(ComposeLayoutPropUpdaterKt.u(com.tencent.ntcompose.core.i.INSTANCE, 32.0f), Alignment.TopEnd);
                                                            final Function0<Unit> function010 = this.$onExit;
                                                            composer9.startReplaceableGroup(1157296644);
                                                            boolean changed4 = composer9.changed(function010);
                                                            Object rememberedValue6 = composer9.rememberedValue();
                                                            if (changed4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue6 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$1$1$3$4$1$1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                        function010.invoke();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                composer9.updateRememberedValue(rememberedValue6);
                                                            }
                                                            composer9.endReplaceableGroup();
                                                            ImageKt.a(null, null, null, null, null, ViewEventPropUpdaterKt.d(a16, false, null, (Function1) rememberedValue6, 3, null), null, 0, null, null, QUIToken.INSTANCE.image("close_circle", QUIToken.color$default("icon_allwhite_primary")), null, null, null, null, null, null, null, null, null, null, composer9, 262144, 0, 0, 2096095);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer7, 3080, 6);
                                                if (((LoveWallGrowthManualViewModel) mutableState3.getValue()).showTip.getValue().booleanValue()) {
                                                    composer7.startReplaceableGroup(-492369756);
                                                    Object rememberedValue6 = composer7.rememberedValue();
                                                    if (rememberedValue6 == companion2.getEmpty()) {
                                                        rememberedValue6 = new Animatable(Float.valueOf(0.0f));
                                                        composer7.updateRememberedValue(rememberedValue6);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    Animatable animatable = (Animatable) rememberedValue6;
                                                    composer7.startReplaceableGroup(-492369756);
                                                    Object rememberedValue7 = composer7.rememberedValue();
                                                    if (rememberedValue7 == companion2.getEmpty()) {
                                                        rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                                        composer7.updateRememberedValue(rememberedValue7);
                                                    }
                                                    composer7.endReplaceableGroup();
                                                    MutableState mutableState4 = (MutableState) rememberedValue7;
                                                    if (!((Boolean) mutableState4.getValue()).booleanValue()) {
                                                        composer7.startReplaceableGroup(588732926);
                                                        EffectsKt.LaunchedEffect(animatable, new AnonymousClass5(animatable, mutableState4, null), composer7, Animatable.f339143c | 64);
                                                        composer7.endReplaceableGroup();
                                                        mutableState = mutableState3;
                                                    } else {
                                                        composer7.startReplaceableGroup(588733396);
                                                        mutableState = mutableState3;
                                                        EffectsKt.LaunchedEffect(animatable, new AnonymousClass6(animatable, mutableState, null), composer7, Animatable.f339143c | 64);
                                                        composer7.endReplaceableGroup();
                                                    }
                                                    com.tencent.ntcompose.core.i D = ModifiersKt.D(ComposeLayoutPropUpdaterKt.v(companion3, 164, 32), ((Number) animatable.f()).floatValue());
                                                    Alignment alignment = Alignment.Center;
                                                    BoxKt.a(ModifiersKt.d(ModifiersKt.j(bVar3.a(D, alignment), 8), QUIToken.color$default("fill_allblack_strong")), alignment, null, ComposableLambdaKt.composableLambda(composer7, -487082356, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt.LoveWallGrowthManual.1.1.3.7
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public final Unit invoke(b bVar4, Composer composer8, Integer num4) {
                                                            Composer composer9 = composer8;
                                                            int intValue4 = num4.intValue();
                                                            if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                                composer9.skipToGroupEnd();
                                                            } else {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-487082356, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManual.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallGrowthManualView.kt:260)");
                                                                }
                                                                TextKt.a(mutableState.getValue().tip.getValue(), null, null, com.tencent.kuikly.core.base.h.INSTANCE.m(), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer9, 28672, 0, 0, 134217702);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }), composer7, 3128, 4);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
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
        }), startRestartGroup, 24632, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.growth_manual.LoveWallGrowthManualViewKt$LoveWallGrowthManual$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallGrowthManualViewKt.LoveWallGrowthManual(com.tencent.ntcompose.core.i.this, loveWallHomepageData, function0, function02, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
