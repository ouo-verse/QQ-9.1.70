package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonConfig;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallButtonKt;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.utils.IntimateSpaceReportUtilKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ModalKt;
import com.tencent.ntcompose.material.SpacerKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallWateringGuildViewKt {
    public static final void LoveWallWateringGuildView(final LoveWallHomepageViewModel loveWallHomepageViewModel, final Function0<Unit> function0, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1931814794);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1931814794, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView (LoveWallWateringGuildView.kt:34)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Animatable(Float.valueOf(0.0f));
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Animatable animatable = (Animatable) rememberedValue;
        EffectsKt.LaunchedEffect(animatable, new LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1(animatable, null), startRestartGroup, Animatable.f339143c | 64);
        ModalKt.a(ModifiersKt.D(ModifiersKt.d(i.INSTANCE, h.INSTANCE.a(0.4f)), ((Number) animatable.f()).floatValue()), false, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1471369780, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2
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
                        ComposerKt.traceEventStart(-1471369780, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView.<anonymous> (LoveWallWateringGuildView.kt:42)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    Alignment.Horizontal b16 = Alignment.INSTANCE.b();
                    final LoveWallHomepageViewModel loveWallHomepageViewModel2 = LoveWallHomepageViewModel.this;
                    final Function0<Unit> function02 = function0;
                    ColumnKt.a(h16, null, b16, null, ComposableLambdaKt.composableLambda(composer3, 641018371, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    ComposerKt.traceEventStart(641018371, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView.<anonymous>.<anonymous> (LoveWallWateringGuildView.kt:46)");
                                }
                                i pageVR = ModifierExtKt.pageVR(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), "pg_qz_love_tree_guide", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams());
                                final LoveWallHomepageViewModel loveWallHomepageViewModel3 = LoveWallHomepageViewModel.this;
                                final Function0<Unit> function03 = function02;
                                BoxKt.a(pageVR, null, null, ComposableLambdaKt.composableLambda(composer5, 233366281, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt.LoveWallWateringGuildView.2.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public final Unit invoke(b bVar, Composer composer6, Integer num3) {
                                        Composer composer7 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(233366281, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView.<anonymous>.<anonymous>.<anonymous> (LoveWallWateringGuildView.kt:49)");
                                            }
                                            final LoveWallHomepageViewModel loveWallHomepageViewModel4 = LoveWallHomepageViewModel.this;
                                            final Function0<Unit> function04 = function03;
                                            final Function0<Unit> function05 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$onClickBtn$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    final LoveWallHomepageViewModel loveWallHomepageViewModel5 = LoveWallHomepageViewModel.this;
                                                    loveWallHomepageViewModel5.requestWatering(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$onClickBtn$1.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            LoveWallHomepageViewModel.this.collectWaterWeight.setValue(0L);
                                                            LoveWallHomepageViewModel.this.updateWaterTaskState();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    function04.invoke();
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            i.Companion companion = i.INSTANCE;
                                            BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, 131, 7, null), Alignment.BottomCenter, null, ComposableLambdaKt.composableLambda(composer7, 2061353359, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt.LoveWallWateringGuildView.2.1.1.1

                                                /* compiled from: P */
                                                @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$1$1", f = "LoveWallWateringGuildView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$1$1, reason: invalid class name and collision with other inner class name */
                                                /* loaded from: classes37.dex */
                                                public final class C46091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    public final /* synthetic */ MutableState<Boolean> $enlarge;
                                                    public final /* synthetic */ Animatable<Float> $scaleAnimation;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public C46091(Animatable<Float> animatable, MutableState<Boolean> mutableState, Continuation<? super C46091> continuation) {
                                                        super(2, continuation);
                                                        this.$scaleAnimation = animatable;
                                                        this.$enlarge = mutableState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C46091(this.$scaleAnimation, this.$enlarge, continuation);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return ((C46091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        ResultKt.throwOnFailure(obj);
                                                        Animatable<Float> animatable = this.$scaleAnimation;
                                                        Float boxFloat = Boxing.boxFloat(this.$enlarge.getValue().booleanValue() ? 1.05f : 0.95f);
                                                        m d16 = com.tencent.ntcompose.animation.b.d(1000, 0, null, null, 14, null);
                                                        final MutableState<Boolean> mutableState = this.$enlarge;
                                                        Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt.LoveWallWateringGuildView.2.1.1.1.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Float f16) {
                                                                f16.floatValue();
                                                                mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
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
                                                public final Unit invoke(b bVar2, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2061353359, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallWateringGuildView.kt:62)");
                                                        }
                                                        composer9.startReplaceableGroup(-492369756);
                                                        Object rememberedValue2 = composer9.rememberedValue();
                                                        Composer.Companion companion2 = Composer.INSTANCE;
                                                        if (rememberedValue2 == companion2.getEmpty()) {
                                                            rememberedValue2 = new Animatable(Float.valueOf(1.0f));
                                                            composer9.updateRememberedValue(rememberedValue2);
                                                        }
                                                        composer9.endReplaceableGroup();
                                                        final Animatable animatable2 = (Animatable) rememberedValue2;
                                                        composer9.startReplaceableGroup(-492369756);
                                                        Object rememberedValue3 = composer9.rememberedValue();
                                                        if (rememberedValue3 == companion2.getEmpty()) {
                                                            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                                                            composer9.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer9.endReplaceableGroup();
                                                        MutableState mutableState = (MutableState) rememberedValue3;
                                                        EffectsKt.LaunchedEffect(mutableState.getValue(), animatable2, new C46091(animatable2, mutableState, null), composer9, (Animatable.f339143c << 3) | 512);
                                                        i u16 = ModifiersKt.u(ModifierExtKt.elementVR(ComposeLayoutPropUpdaterKt.v(i.INSTANCE, 210, 56), "em_qz_watering_button", IntimateSpaceReportUtilKt.getIntimateDTReportBaseParams()), new Function1<zo3.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt.LoveWallWateringGuildView.2.1.1.1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(zo3.d dVar2) {
                                                                zo3.d dVar3 = dVar2;
                                                                dVar3.n(animatable2.f());
                                                                dVar3.o(animatable2.f());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        LoveWallButtonConfig loveWallButtonConfig = new LoveWallButtonConfig("\u53ef\u6d47\u6c3410g");
                                                        final Function0<Unit> function06 = function05;
                                                        composer9.startReplaceableGroup(1157296644);
                                                        boolean changed = composer9.changed(function06);
                                                        Object rememberedValue4 = composer9.rememberedValue();
                                                        if (changed || rememberedValue4 == companion2.getEmpty()) {
                                                            rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$1$3$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    function06.invoke();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer9.updateRememberedValue(rememberedValue4);
                                                        }
                                                        composer9.endReplaceableGroup();
                                                        LoveWallButtonKt.LoveWallButton(u16, loveWallButtonConfig, (Function1) rememberedValue4, composer9, 8);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 3128, 4);
                                            ColumnKt.a(ComposeLayoutPropUpdaterKt.h(companion, 0.0f, 1, null), a.f339245a.a(), Alignment.Horizontal.End, null, ComposableLambdaKt.composableLambda(composer7, -1630250624, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt.LoveWallWateringGuildView.2.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(d dVar2, Composer composer8, Integer num4) {
                                                    Composer composer9 = composer8;
                                                    int intValue4 = num4.intValue();
                                                    if ((intValue4 & 81) == 16 && composer9.getSkipping()) {
                                                        composer9.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1630250624, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallWateringGuildView.kt:94)");
                                                        }
                                                        i.Companion companion2 = i.INSTANCE;
                                                        i n3 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion2, (float) 137.2d, 130), 0.0f, 0.0f, 45, 0.0f, 11, null);
                                                        final Function0<Unit> function06 = function05;
                                                        composer9.startReplaceableGroup(1157296644);
                                                        boolean changed = composer9.changed(function06);
                                                        Object rememberedValue2 = composer9.rememberedValue();
                                                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue2 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$2$1$1$2$1$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    function06.invoke();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            composer9.updateRememberedValue(rememberedValue2);
                                                        }
                                                        composer9.endReplaceableGroup();
                                                        APNGKt.a(ViewEventPropUpdaterKt.d(n3, false, null, (Function1) rememberedValue2, 3, null), null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_mSbOXa9EB79.png", 0, null, null, null, null, composer9, 3464, 242);
                                                        SpacerKt.a(ComposeLayoutPropUpdaterKt.k(companion2, 68), composer9, 8, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer7, 25032, 8);
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
                    }), composer3, 24584, 10);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallWateringGuildViewKt.LoveWallWateringGuildView(LoveWallHomepageViewModel.this, function0, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
