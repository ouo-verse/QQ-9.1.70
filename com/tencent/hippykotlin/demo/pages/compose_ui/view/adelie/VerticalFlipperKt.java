package com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.ButtonKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class VerticalFlipperKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VerticalFlipper(i iVar, final int i3, int i16, int i17, Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i18, final int i19) {
        int i26;
        int i27;
        int i28;
        int i29;
        Function1<? super Integer, Unit> function13;
        int i36;
        Function1<? super Integer, Unit> function14;
        i iVar2;
        Function1<? super Integer, Unit> function15;
        final int i37;
        final Function1<? super Integer, Unit> function16;
        Composer startRestartGroup = composer.startRestartGroup(-167328315);
        int i38 = i19 & 1;
        int i39 = i38 != 0 ? i18 | 2 : i18;
        if ((i19 & 2) != 0) {
            i39 |= 48;
        } else if ((i18 & 112) == 0) {
            i39 |= startRestartGroup.changed(i3) ? 32 : 16;
        }
        int i46 = i19 & 4;
        if (i46 != 0) {
            i39 |= MsgConstant.KRMFILETHUMBSIZE384;
        } else if ((i18 & 896) == 0) {
            i26 = i16;
            i39 |= startRestartGroup.changed(i26) ? 256 : 128;
            i27 = i19 & 8;
            if (i27 == 0) {
                i39 |= 3072;
            } else if ((i18 & 7168) == 0) {
                i28 = i17;
                i39 |= startRestartGroup.changed(i28) ? 2048 : 1024;
                i29 = i19 & 16;
                if (i29 != 0) {
                    i39 |= 24576;
                } else if ((57344 & i18) == 0) {
                    function13 = function1;
                    i39 |= startRestartGroup.changed(function13) ? 16384 : 8192;
                    i36 = i19 & 32;
                    if (i36 == 0) {
                        i39 |= 196608;
                    } else if ((458752 & i18) == 0) {
                        function14 = function12;
                        i39 |= startRestartGroup.changed(function14) ? 131072 : 65536;
                        if ((i19 & 64) != 0) {
                            i39 |= 1572864;
                        } else if ((3670016 & i18) == 0) {
                            i39 |= startRestartGroup.changed(function3) ? 1048576 : 524288;
                        }
                        if (i38 != 1 && (i39 & 2995931) == 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            iVar2 = iVar;
                            i37 = i28;
                            function16 = function13;
                            function15 = function14;
                        } else {
                            iVar2 = i38 != 0 ? null : iVar;
                            if (i46 != 0) {
                                i26 = 4000;
                            }
                            int i47 = i27 != 0 ? 500 : i28;
                            Function1<? super Integer, Unit> function17 = i29 != 0 ? null : function13;
                            function15 = i36 != 0 ? null : function14;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-167328315, i39, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipper (VerticalFlipper.kt:25)");
                            }
                            if (i3 <= 0) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    return;
                                }
                                final i iVar3 = iVar2;
                                final int i48 = i26;
                                final int i49 = i47;
                                final Function1<? super Integer, Unit> function18 = function17;
                                final Function1<? super Integer, Unit> function19 = function15;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Composer composer2, Integer num) {
                                        num.intValue();
                                        VerticalFlipperKt.VerticalFlipper(i.this, i3, i48, i49, function18, function19, function3, composer2, i18 | 1, i19);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return;
                            }
                            startRestartGroup.startReplaceableGroup(-492369756);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            Composer.Companion companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new FlipperStateHolder(i3, i26), null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue;
                            int i56 = i26;
                            final State<Float> b16 = AnimateAsStateKt.b(((FlipperStateHolder) mutableState.getValue()).isAnimating() ? 0.0f : ((Number) ((FlipperStateHolder) mutableState.getValue()).contentViewHeight$delegate.getValue()).floatValue(), b.d(i47, 0, null, null, 14, null), null, startRestartGroup, 0, 4);
                            float f16 = ((FlipperStateHolder) mutableState.getValue()).isAnimating() ? -((Number) ((FlipperStateHolder) mutableState.getValue()).contentViewHeight$delegate.getValue()).floatValue() : 0.0f;
                            m d16 = b.d(i47, 0, null, null, 14, null);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            boolean changed = startRestartGroup.changed(mutableState);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$outAnimation$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Float f17) {
                                        f17.floatValue();
                                        mutableState.getValue().isAnimating$delegate.setValue(Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final State<Float> b17 = AnimateAsStateKt.b(f16, d16, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                            i r16 = ModifiersKt.r(iVar2 == null ? ComposeLayoutPropUpdaterKt.j(i.INSTANCE, 0.0f, 1, null) : iVar2, true);
                            startRestartGroup.startReplaceableGroup(1157296644);
                            boolean changed2 = startRestartGroup.changed(mutableState);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1<w, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$realModifier$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(w wVar) {
                                        mutableState.getValue().contentViewHeight$delegate.setValue(Float.valueOf(wVar.getHeight()));
                                        return Unit.INSTANCE;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            final Function1<? super Integer, Unit> function110 = function15;
                            final int i57 = i39;
                            final Function1<? super Integer, Unit> function111 = function17;
                            BoxKt.a(ViewEventPropUpdaterKt.m(r16, (Function1) rememberedValue3), Alignment.CenterStart, null, ComposableLambdaKt.composableLambda(startRestartGroup, 343387339, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                                    Composer composer3 = composer2;
                                    int intValue = num.intValue();
                                    if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(343387339, intValue, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipper.<anonymous> (VerticalFlipper.kt:65)");
                                        }
                                        composer3.startReplaceableGroup(1912449203);
                                        if (mutableState.getValue().isAnimating()) {
                                            i.Companion companion2 = i.INSTANCE;
                                            i p16 = ComposeLayoutPropUpdaterKt.p(companion2, 0.0f, b17.getValue().floatValue(), 1, null);
                                            final Function3<Integer, Composer, Integer, Unit> function32 = function3;
                                            final int i58 = i57;
                                            final MutableState<FlipperStateHolder> mutableState2 = mutableState;
                                            BoxKt.a(p16, null, null, ComposableLambdaKt.composableLambda(composer3, 1460864620, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                                    Composer composer5 = composer4;
                                                    int intValue2 = num2.intValue();
                                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1460864620, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipper.<anonymous>.<anonymous> (VerticalFlipper.kt:67)");
                                                        }
                                                        function32.invoke(Integer.valueOf(mutableState2.getValue().prePlayIndex), composer5, Integer.valueOf((i58 >> 15) & 112));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer3, 3080, 6);
                                            i p17 = ComposeLayoutPropUpdaterKt.p(companion2, 0.0f, b16.getValue().floatValue(), 1, null);
                                            final Function3<Integer, Composer, Integer, Unit> function33 = function3;
                                            final int i59 = i57;
                                            final MutableState<FlipperStateHolder> mutableState3 = mutableState;
                                            BoxKt.a(p17, null, null, ComposableLambdaKt.composableLambda(composer3, -1811808861, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar2, Composer composer4, Integer num2) {
                                                    Composer composer5 = composer4;
                                                    int intValue2 = num2.intValue();
                                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                    } else {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1811808861, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipper.<anonymous>.<anonymous> (VerticalFlipper.kt:70)");
                                                        }
                                                        function33.invoke(Integer.valueOf(mutableState3.getValue().currentPlayIndex), composer5, Integer.valueOf((i59 >> 15) & 112));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer3, 3080, 6);
                                        }
                                        composer3.endReplaceableGroup();
                                        if (!mutableState.getValue().isAnimating()) {
                                            final Function1<Integer, Unit> function112 = function110;
                                            final MutableState<FlipperStateHolder> mutableState4 = mutableState;
                                            composer3.startReplaceableGroup(511388516);
                                            boolean changed3 = composer3.changed(function112) | composer3.changed(mutableState4);
                                            Object rememberedValue4 = composer3.rememberedValue();
                                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue4 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$2$3$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<Integer, Unit> function113 = function112;
                                                        if (function113 != null) {
                                                            function113.invoke(Integer.valueOf(mutableState4.getValue().currentPlayIndex));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue4);
                                            }
                                            composer3.endReplaceableGroup();
                                            Function1 function113 = (Function1) rememberedValue4;
                                            final Function3<Integer, Composer, Integer, Unit> function34 = function3;
                                            final int i65 = i57;
                                            final MutableState<FlipperStateHolder> mutableState5 = mutableState;
                                            ButtonKt.a(null, function113, null, null, ComposableLambdaKt.composableLambda(composer3, 504554760, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$2.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
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
                                                            ComposerKt.traceEventStart(504554760, intValue2, -1, "com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipper.<anonymous>.<anonymous> (VerticalFlipper.kt:77)");
                                                        }
                                                        function34.invoke(Integer.valueOf(mutableState5.getValue().currentPlayIndex), composer5, Integer.valueOf((i65 >> 15) & 112));
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }), composer3, 24576, 13);
                                            if (mutableState.getValue().currentShowIndex != mutableState.getValue().currentPlayIndex) {
                                                mutableState.getValue().currentShowIndex = mutableState.getValue().currentPlayIndex;
                                                Function1<Integer, Unit> function114 = function111;
                                                if (function114 != null) {
                                                    function114.invoke(Integer.valueOf(mutableState.getValue().currentPlayIndex));
                                                }
                                            }
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), startRestartGroup, 3128, 4);
                            FlipperStateHolder flipperStateHolder = (FlipperStateHolder) mutableState.getValue();
                            Integer valueOf = Integer.valueOf(i3);
                            startRestartGroup.startReplaceableGroup(511388516);
                            boolean changed3 = startRestartGroup.changed(valueOf) | startRestartGroup.changed(mutableState);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changed3 || rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                        if (i3 > 1) {
                                            final FlipperStateHolder value = mutableState.getValue();
                                            Timer timer = value.timer;
                                            if (timer != null) {
                                                timer.e();
                                            }
                                            value.timer = null;
                                            Timer timer2 = new Timer();
                                            int i58 = value.intervalTimeMs;
                                            timer2.f(i58, i58, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.FlipperStateHolder$startTimer$1$1
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Unit invoke() {
                                                    FlipperStateHolder flipperStateHolder2 = FlipperStateHolder.this;
                                                    int i59 = flipperStateHolder2.currentPlayIndex;
                                                    flipperStateHolder2.prePlayIndex = i59;
                                                    int i65 = i59 + 1;
                                                    if (i65 >= flipperStateHolder2.size) {
                                                        i65 = 0;
                                                    }
                                                    flipperStateHolder2.currentPlayIndex = i65;
                                                    flipperStateHolder2.isAnimating$delegate.setValue(Boolean.TRUE);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            value.timer = timer2;
                                        }
                                        final MutableState<FlipperStateHolder> mutableState2 = mutableState;
                                        return new DisposableEffectResult() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$3$1$invoke$$inlined$onDispose$1
                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public final void dispose() {
                                                FlipperStateHolder flipperStateHolder2 = (FlipperStateHolder) MutableState.this.getValue();
                                                Timer timer3 = flipperStateHolder2.timer;
                                                if (timer3 != null) {
                                                    timer3.e();
                                                }
                                                flipperStateHolder2.timer = null;
                                            }
                                        };
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(flipperStateHolder, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue4, startRestartGroup, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i26 = i56;
                            i37 = i47;
                            function16 = function17;
                        }
                        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                        if (endRestartGroup2 == null) {
                            return;
                        }
                        final i iVar4 = iVar2;
                        final int i58 = i26;
                        final Function1<? super Integer, Unit> function112 = function15;
                        endRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.view.adelie.VerticalFlipperKt$VerticalFlipper$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                VerticalFlipperKt.VerticalFlipper(i.this, i3, i58, i37, function16, function112, function3, composer2, i18 | 1, i19);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                    function14 = function12;
                    if ((i19 & 64) != 0) {
                    }
                    if (i38 != 1) {
                    }
                    if (i38 != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i27 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i36 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (i3 <= 0) {
                    }
                }
                function13 = function1;
                i36 = i19 & 32;
                if (i36 == 0) {
                }
                function14 = function12;
                if ((i19 & 64) != 0) {
                }
                if (i38 != 1) {
                }
                if (i38 != 0) {
                }
                if (i46 != 0) {
                }
                if (i27 != 0) {
                }
                if (i29 != 0) {
                }
                if (i36 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (i3 <= 0) {
                }
            }
            i28 = i17;
            i29 = i19 & 16;
            if (i29 != 0) {
            }
            function13 = function1;
            i36 = i19 & 32;
            if (i36 == 0) {
            }
            function14 = function12;
            if ((i19 & 64) != 0) {
            }
            if (i38 != 1) {
            }
            if (i38 != 0) {
            }
            if (i46 != 0) {
            }
            if (i27 != 0) {
            }
            if (i29 != 0) {
            }
            if (i36 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (i3 <= 0) {
            }
        }
        i26 = i16;
        i27 = i19 & 8;
        if (i27 == 0) {
        }
        i28 = i17;
        i29 = i19 & 16;
        if (i29 != 0) {
        }
        function13 = function1;
        i36 = i19 & 32;
        if (i36 == 0) {
        }
        function14 = function12;
        if ((i19 & 64) != 0) {
        }
        if (i38 != 1) {
        }
        if (i38 != 0) {
        }
        if (i46 != 0) {
        }
        if (i27 != 0) {
        }
        if (i29 != 0) {
        }
        if (i36 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (i3 <= 0) {
        }
    }
}
