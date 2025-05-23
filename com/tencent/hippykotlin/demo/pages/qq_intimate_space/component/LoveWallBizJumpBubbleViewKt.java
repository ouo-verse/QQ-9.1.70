package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.core.ComposeNodeKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.CanvasViewPropUpdater;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ab;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.material.k;
import com.tencent.ntcompose.material.m;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yo3.Offset;
import yo3.Size;
import yo3.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallBizJumpBubbleViewKt {
    public static final void LoveWallBizJumpBubbleView(final i iVar, final BubbleViewModel bubbleViewModel, Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i3, final int i16) {
        Composer startRestartGroup = composer.startRestartGroup(-1382568565);
        Function0<Unit> function03 = (i16 & 4) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1382568565, i3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView (LoveWallBizJumpBubbleView.kt:46)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        final Function0<Unit> function04 = function03;
        BoxKt.a(ViewEventPropUpdaterKt.d(iVar, false, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ClickParams clickParams) {
                BubbleStatus value = BubbleViewModel.this.bubbleStatus.getValue();
                BubbleStatus bubbleStatus = BubbleStatus.FOLD;
                if (value == bubbleStatus) {
                    BubbleViewModel bubbleViewModel2 = BubbleViewModel.this;
                    if (bubbleViewModel2.bubbleStatus.getValue() == bubbleStatus) {
                        bubbleViewModel2.bubbleStatus.setValue(BubbleStatus.START_UNFOLD);
                    }
                } else {
                    String value2 = mutableState.getValue();
                    if (value2 != null) {
                        TimerKt.a(value2);
                    }
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        }, 3, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 258108613, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2

            /* compiled from: P */
            @DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$1", f = "LoveWallBizJumpBubbleView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$1, reason: invalid class name */
            /* loaded from: classes37.dex */
            public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public final /* synthetic */ Function0<Unit> $hideFunction;
                public final /* synthetic */ MutableState<String> $hideTimerRef;
                public final /* synthetic */ BubbleViewModel $viewModel;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(BubbleViewModel bubbleViewModel, MutableState<String> mutableState, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$viewModel = bubbleViewModel;
                    this.$hideTimerRef = mutableState;
                    this.$hideFunction = function0;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$viewModel, this.$hideTimerRef, this.$hideFunction, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    ResultKt.throwOnFailure(obj);
                    if (this.$viewModel.bubbleStatus.getValue() == BubbleStatus.FOLD) {
                        String value = this.$hideTimerRef.getValue();
                        if (value != null) {
                            TimerKt.a(value);
                        }
                        MutableState<String> mutableState = this.$hideTimerRef;
                        final Function0<Unit> function0 = this.$hideFunction;
                        mutableState.setValue(TimerKt.c(3000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                Function0<Unit> function02 = function0;
                                if (function02 != null) {
                                    function02.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }));
                    } else {
                        String value2 = this.$hideTimerRef.getValue();
                        if (value2 != null) {
                            TimerKt.a(value2);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(258108613, intValue, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous> (LoveWallBizJumpBubbleView.kt:62)");
                    }
                    EffectsKt.LaunchedEffect(BubbleViewModel.this.bubbleStatus.getValue(), new AnonymousClass1(BubbleViewModel.this, mutableState, function04, null), composer3, 64);
                    final BubbleConfig bubbleConfig = BubbleViewModel.this.config;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue2 = composer3.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Animatable(c.a(new Offset(0.0f, 0.0f), new Size(bubbleConfig.bubbleUnfoldWidth, bubbleConfig.bubbleContainerHeight)));
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    final Animatable animatable = (Animatable) rememberedValue2;
                    FoldAnimation foldAnimation = bubbleConfig.foldAnimation;
                    composer3.startReplaceableGroup(969904972);
                    if (foldAnimation != null) {
                        BubbleViewModel bubbleViewModel2 = BubbleViewModel.this;
                        int ordinal = bubbleViewModel2.bubbleStatus.getValue().ordinal();
                        if (ordinal == 1) {
                            composer3.startReplaceableGroup(-1567008927);
                            EffectsKt.LaunchedEffect(animatable, new LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$1(bubbleViewModel2, animatable, bubbleConfig, foldAnimation, null), composer3, 64 | Animatable.f339143c);
                            composer3.endReplaceableGroup();
                        } else if (ordinal != 4) {
                            composer3.startReplaceableGroup(-1567006935);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1567007783);
                            EffectsKt.LaunchedEffect(animatable, new LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$2$2(bubbleViewModel2, animatable, bubbleConfig, foldAnimation, null), composer3, 64 | Animatable.f339143c);
                            composer3.endReplaceableGroup();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    composer3.endReplaceableGroup();
                    i.Companion companion2 = i.INSTANCE;
                    i f16 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(companion2, BubbleViewModel.this.config.bubbleUnfoldWidth), 0.0f, 1, null);
                    BubbleTriangleDirection bubbleTriangleDirection = bubbleConfig.triangleDirection;
                    BubbleTriangleDirection bubbleTriangleDirection2 = BubbleTriangleDirection.UP_CENTER;
                    i n3 = ComposeLayoutPropUpdaterKt.n(f16, 0.0f, bubbleTriangleDirection == bubbleTriangleDirection2 ? bubbleConfig.triangleSize.getHeight() : 0.0f, 0.0f, 0.0f, 13, null);
                    final BubbleViewModel bubbleViewModel3 = BubbleViewModel.this;
                    final Function0<Unit> function05 = function02;
                    final int i17 = i3;
                    BoxKt.a(n3, null, null, ComposableLambdaKt.composableLambda(composer3, -1612474753, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(b bVar2, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1612474753, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:130)");
                                }
                                RowKt.a(ModifiersKt.d(ModifiersKt.j(ComposeLayoutPropUpdaterKt.o(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, animatable.f().e()), animatable.f().b()), animatable.f().getLeft(), animatable.f().getTop()), bubbleConfig.borderRadius), bubbleConfig.backgroundColor), a.f339245a.e(), Alignment.INSTANCE.c(), null, null, ComposableLambdaKt.composableLambda(composer5, -2013720803, true, new Function3<n, Composer, Integer, Unit>(bubbleViewModel3, function05, i17) { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.3.1
                                    public final /* synthetic */ Function0<Unit> $buttonOnClick;
                                    public final /* synthetic */ BubbleViewModel $viewModel;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:31:0x0149  */
                                    /* JADX WARN: Removed duplicated region for block: B:33:0x014d  */
                                    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
                                    /* JADX WARN: Removed duplicated region for block: B:43:0x01a4  */
                                    @Override // kotlin.jvm.functions.Function3
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(n nVar, Composer composer6, Integer num3) {
                                        Composer composer7;
                                        BubbleStatus bubbleStatus;
                                        Composer composer8;
                                        boolean changed;
                                        Object rememberedValue3;
                                        Composer composer9 = composer6;
                                        int intValue3 = num3.intValue();
                                        if ((intValue3 & 81) == 16 && composer9.getSkipping()) {
                                            composer9.skipToGroupEnd();
                                        } else {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2013720803, intValue3, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:140)");
                                            }
                                            composer9.startReplaceableGroup(-197280641);
                                            if (BubbleConfig.this.iconUrl != null) {
                                                composer7 = composer9;
                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 10.0f, 0.0f, 0.0f, 0.0f, 14, null), 20.0f), null, h.INSTANCE.c(), null, null, BubbleConfig.this.iconUrl, null, null, null, null, null, null, null, null, null, null, composer7, 12845056, 0, 0, 2095967);
                                            } else {
                                                composer7 = composer9;
                                            }
                                            composer7.endReplaceableGroup();
                                            Composer composer10 = composer7;
                                            composer10.startReplaceableGroup(-197280345);
                                            BubbleStatus value = this.$viewModel.bubbleStatus.getValue();
                                            BubbleStatus bubbleStatus2 = BubbleStatus.FOLD;
                                            if (value != bubbleStatus2) {
                                                if (BubbleConfig.this.text.length() > 0) {
                                                    bubbleStatus = bubbleStatus2;
                                                    composer8 = composer10;
                                                    TextKt.a(BubbleConfig.this.text, ComposeLayoutPropUpdaterKt.n(i.INSTANCE, BubbleConfig.this.iconUrl == null ? 10 : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), null, com.tencent.kuikly.core.base.h.INSTANCE.b(), Float.valueOf(14.0f), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer8, 28736, 0, 0, 134217700);
                                                    composer8.endReplaceableGroup();
                                                    if (BubbleConfig.this.buttonTitle != null && this.$viewModel.bubbleStatus.getValue() != bubbleStatus) {
                                                        i.Companion companion3 = i.INSTANCE;
                                                        BubbleConfig bubbleConfig2 = BubbleConfig.this;
                                                        i n16 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion3, bubbleConfig2.buttonWidth, bubbleConfig2.buttonHeight), 0.0f, 0.0f, !(BubbleConfig.this.text.length() > 0) ? 10 : 0.0f, 0.0f, 11, null);
                                                        final Function0<Unit> function06 = this.$buttonOnClick;
                                                        Composer composer11 = composer8;
                                                        composer11.startReplaceableGroup(1157296644);
                                                        changed = composer11.changed(function06);
                                                        rememberedValue3 = composer11.rememberedValue();
                                                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$3$1$1$1
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
                                                            composer11.updateRememberedValue(rememberedValue3);
                                                        }
                                                        composer11.endReplaceableGroup();
                                                        Function1 function1 = (Function1) rememberedValue3;
                                                        final BubbleConfig bubbleConfig3 = BubbleConfig.this;
                                                        ButtonKt.a(null, function1, n16, null, ComposableLambdaKt.composableLambda(composer11, 414446879, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.3.1.2
                                                            {
                                                                super(3);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function3
                                                            public final Unit invoke(n nVar2, Composer composer12, Integer num4) {
                                                                Composer composer13 = composer12;
                                                                int intValue4 = num4.intValue();
                                                                if ((intValue4 & 81) == 16 && composer13.getSkipping()) {
                                                                    composer13.skipToGroupEnd();
                                                                } else {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(414446879, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:164)");
                                                                    }
                                                                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                                    final BubbleConfig bubbleConfig4 = BubbleConfig.this;
                                                                    BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer13, 1456140453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.3.1.2.1
                                                                        {
                                                                            super(3);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public final Unit invoke(b bVar3, Composer composer14, Integer num5) {
                                                                            int i18;
                                                                            b bVar4 = bVar3;
                                                                            Composer composer15 = composer14;
                                                                            int intValue5 = num5.intValue();
                                                                            if ((intValue5 & 14) == 0) {
                                                                                i18 = (composer15.changed(bVar4) ? 4 : 2) | intValue5;
                                                                            } else {
                                                                                i18 = intValue5;
                                                                            }
                                                                            if ((i18 & 91) == 18 && composer15.getSkipping()) {
                                                                                composer15.skipToGroupEnd();
                                                                            } else {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(1456140453, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:165)");
                                                                                }
                                                                                i.Companion companion4 = i.INSTANCE;
                                                                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_ir9Wn-rhgpR.png", null, null, null, null, null, null, null, null, null, null, composer15, 262144, 6, 0, 2096095);
                                                                                i a16 = bVar4.a(companion4, Alignment.Center);
                                                                                TextKt.a(BubbleConfig.this.buttonTitle, a16, null, new com.tencent.kuikly.core.base.h(60, 42, 26, 1.0f), Float.valueOf(BubbleConfig.this.buttonFontSize), null, new bp3.c(500), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer15, 4160, 0, 0, 134217636);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    }), composer13, 3080, 6);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), composer11, 25088, 9);
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }
                                            bubbleStatus = bubbleStatus2;
                                            composer8 = composer10;
                                            composer8.endReplaceableGroup();
                                            if (BubbleConfig.this.buttonTitle != null) {
                                                i.Companion companion32 = i.INSTANCE;
                                                BubbleConfig bubbleConfig22 = BubbleConfig.this;
                                                i n162 = ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion32, bubbleConfig22.buttonWidth, bubbleConfig22.buttonHeight), 0.0f, 0.0f, !(BubbleConfig.this.text.length() > 0) ? 10 : 0.0f, 0.0f, 11, null);
                                                final Function0<Unit> function062 = this.$buttonOnClick;
                                                Composer composer112 = composer8;
                                                composer112.startReplaceableGroup(1157296644);
                                                changed = composer112.changed(function062);
                                                rememberedValue3 = composer112.rememberedValue();
                                                if (!changed) {
                                                }
                                                rememberedValue3 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$3$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        function062.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer112.updateRememberedValue(rememberedValue3);
                                                composer112.endReplaceableGroup();
                                                Function1 function12 = (Function1) rememberedValue3;
                                                final BubbleConfig bubbleConfig32 = BubbleConfig.this;
                                                ButtonKt.a(null, function12, n162, null, ComposableLambdaKt.composableLambda(composer112, 414446879, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.3.1.2
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public final Unit invoke(n nVar2, Composer composer12, Integer num4) {
                                                        Composer composer13 = composer12;
                                                        int intValue4 = num4.intValue();
                                                        if ((intValue4 & 81) == 16 && composer13.getSkipping()) {
                                                            composer13.skipToGroupEnd();
                                                        } else {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(414446879, intValue4, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:164)");
                                                            }
                                                            i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                                                            final BubbleConfig bubbleConfig4 = BubbleConfig.this;
                                                            BoxKt.a(h16, null, null, ComposableLambdaKt.composableLambda(composer13, 1456140453, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView.2.3.1.2.1
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public final Unit invoke(b bVar3, Composer composer14, Integer num5) {
                                                                    int i18;
                                                                    b bVar4 = bVar3;
                                                                    Composer composer15 = composer14;
                                                                    int intValue5 = num5.intValue();
                                                                    if ((intValue5 & 14) == 0) {
                                                                        i18 = (composer15.changed(bVar4) ? 4 : 2) | intValue5;
                                                                    } else {
                                                                        i18 = intValue5;
                                                                    }
                                                                    if ((i18 & 91) == 18 && composer15.getSkipping()) {
                                                                        composer15.skipToGroupEnd();
                                                                    } else {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1456140453, intValue5, -1, "com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (LoveWallBizJumpBubbleView.kt:165)");
                                                                        }
                                                                        i.Companion companion4 = i.INSTANCE;
                                                                        ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.h(companion4, 0.0f, 1, null), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_zplan_config_test/couple_space_pic_resouce/4221bcd7_ir9Wn-rhgpR.png", null, null, null, null, null, null, null, null, null, null, composer15, 262144, 6, 0, 2096095);
                                                                        i a16 = bVar4.a(companion4, Alignment.Center);
                                                                        TextKt.a(BubbleConfig.this.buttonTitle, a16, null, new com.tencent.kuikly.core.base.h(60, 42, 26, 1.0f), Float.valueOf(BubbleConfig.this.buttonFontSize), null, new bp3.c(500), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer15, 4160, 0, 0, 134217636);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }), composer13, 3080, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }), composer112, 25088, 9);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), composer5, 196680, 24);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 3080, 6);
                    i n16 = ComposeLayoutPropUpdaterKt.n(ModifiersKt.G(ComposeLayoutPropUpdaterKt.v(companion2, bubbleConfig.triangleSize.getWidth(), bubbleConfig.triangleSize.getHeight()), bubbleConfig.triangleDirection == bubbleTriangleDirection2 ? 180.0f : 0.0f, null, 2, null), BubbleViewModel.this.getTriangleMarginLeft(), bubbleConfig.triangleDirection == bubbleTriangleDirection2 ? 0.0f : bubbleConfig.bubbleContainerHeight, 0.0f, 0.0f, 12, null);
                    composer3.startReplaceableGroup(-537167339);
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new k();
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    final k kVar = (k) rememberedValue3;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    final MutableState mutableState2 = (MutableState) rememberedValue4;
                    if (((Boolean) mutableState2.getValue()).booleanValue()) {
                        kVar.e();
                        ab abVar = new ab();
                        abVar.g(0.0f, 0.0f);
                        abVar.f(bubbleConfig.triangleSize.getWidth(), 0.0f);
                        abVar.f(bubbleConfig.triangleSize.getWidth() / 2.0f, bubbleConfig.triangleSize.getHeight());
                        abVar.d();
                        kVar.k(abVar, bubbleConfig.backgroundColor, m.f339435a);
                        if (!kVar.m()) {
                            kVar.w();
                            MutableState<Integer> q16 = kVar.q();
                            q16.setValue(Integer.valueOf(q16.getValue().intValue() + 1));
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new com.tencent.ntcompose.core.k("drawCallback", kVar, kVar.q().getValue(), null, null, null, CanvasViewPropUpdater.f339340a, 56, null));
                    ComposeNodeKt.a("Canvas", com.tencent.ntcompose.material.base.a.f339408a, null, ViewEventPropUpdaterKt.m(n16, new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$2$invoke$$inlined$Canvas$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(w wVar) {
                            w it = wVar;
                            Intrinsics.checkNotNullParameter(it, "it");
                            k.this.z(new Size(it.getWidth(), it.getHeight()));
                            mutableState2.setValue(Boolean.TRUE);
                            MutableState<Integer> q17 = k.this.q();
                            q17.setValue(Integer.valueOf(q17.getValue().intValue() + 1));
                            return Unit.INSTANCE;
                        }
                    }), arrayList, null, composer3, 33206, 32);
                    composer3.endReplaceableGroup();
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
        final Function0<Unit> function05 = function03;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.component.LoveWallBizJumpBubbleViewKt$LoveWallBizJumpBubbleView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                LoveWallBizJumpBubbleViewKt.LoveWallBizJumpBubbleView(i.this, bubbleViewModel, function05, function02, composer2, i3 | 1, i16);
                return Unit.INSTANCE;
            }
        });
    }
}
