package com.tencent.ntcompose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aK\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u001aE\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u0001\u001a\u00020\n2\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u000b\u0010\f\u001aQ\u0010\u000e\u001a\f\u0012\b\u0012\u00060\nj\u0002`\r0\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0012\b\u0002\u0010\u0003\u001a\f\u0012\b\u0012\u00060\nj\u0002`\r0\u00022\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u000e\u0010\f\u001aE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\"\u001e\u0010\u0015\u001a\f\u0012\b\u0012\u00060\nj\u0002`\r0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\"\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013\"\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0013\"\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00128\u0002X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"T", "targetValue", "Lcom/tencent/ntcompose/animation/a;", "animationSpec", "Lkotlin/Function1;", "", "finishedListener", "Landroidx/compose/runtime/State;", "d", "(Ljava/lang/Object;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "", "c", "(FLcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lcom/tencent/ntcompose/ui/unit/Dp;", "b", "Lcom/tencent/kuikly/core/base/h;", "a", "(Lcom/tencent/kuikly/core/base/h;Lcom/tencent/ntcompose/animation/a;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lcom/tencent/ntcompose/animation/l;", "Lcom/tencent/ntcompose/animation/l;", "floatDefaultSpring", "dpDefaultSpring", "colorDefaultSpring", "", "intSizeDefaultSpring", "e", "intOffsetDefaultSpring", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AnimateAsStateKt {

    /* renamed from: a, reason: collision with root package name */
    private static final l<Float> f339146a = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);

    /* renamed from: b, reason: collision with root package name */
    private static final l<Float> f339147b = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);

    /* renamed from: c, reason: collision with root package name */
    private static final l<com.tencent.kuikly.core.base.h> f339148c = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);

    /* renamed from: d, reason: collision with root package name */
    private static final l<Object> f339149d = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);

    /* renamed from: e, reason: collision with root package name */
    private static final l<Object> f339150e = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);

    public static final State<com.tencent.kuikly.core.base.h> a(com.tencent.kuikly.core.base.h targetValue, a<com.tencent.kuikly.core.base.h> aVar, Function1<? super com.tencent.kuikly.core.base.h, Unit> function1, Composer composer, int i3, int i16) {
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        composer.startReplaceableGroup(-172969719);
        if ((i16 & 2) != 0) {
            aVar = f339148c;
        }
        a<com.tencent.kuikly.core.base.h> aVar2 = aVar;
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        Function1<? super com.tencent.kuikly.core.base.h, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-172969719, i3, -1, "com.tencent.ntcompose.animation.animateColorAsState (AnimateAsState.kt:96)");
        }
        State<com.tencent.kuikly.core.base.h> d16 = d(targetValue, aVar2, function12, composer, (i3 & 112) | 8 | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return d16;
    }

    public static final State<Float> b(float f16, a<Float> aVar, Function1<? super Float, Unit> function1, Composer composer, int i3, int i16) {
        composer.startReplaceableGroup(863285983);
        if ((i16 & 2) != 0) {
            aVar = f339147b;
        }
        a<Float> aVar2 = aVar;
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        Function1<? super Float, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(863285983, i3, -1, "com.tencent.ntcompose.animation.animateDpAsState (AnimateAsState.kt:84)");
        }
        State<Float> d16 = d(Float.valueOf(f16), aVar2, function12, composer, (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return d16;
    }

    public static final State<Float> c(float f16, a<Float> aVar, Function1<? super Float, Unit> function1, Composer composer, int i3, int i16) {
        composer.startReplaceableGroup(283560041);
        if ((i16 & 2) != 0) {
            aVar = f339146a;
        }
        a<Float> aVar2 = aVar;
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        Function1<? super Float, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(283560041, i3, -1, "com.tencent.ntcompose.animation.animateFloatAsState (AnimateAsState.kt:72)");
        }
        State<Float> d16 = d(Float.valueOf(f16), aVar2, function12, composer, (i3 & 14) | (i3 & 112) | (i3 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return d16;
    }

    public static final <T> State<T> d(final T t16, a<T> aVar, Function1<? super T, Unit> function1, Composer composer, int i3, int i16) {
        final a<T> aVar2;
        composer.startReplaceableGroup(-919850970);
        if ((i16 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = b.b(0.0f, 0.0f, 0, 0.0f, null, 0, false, 127, null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            aVar2 = (a) rememberedValue;
        } else {
            aVar2 = aVar;
        }
        final Function1<? super T, Unit> function12 = (i16 & 4) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-919850970, i3, -1, "com.tencent.ntcompose.animation.animateValueAsState (AnimateAsState.kt:41)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Animatable(t16);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final Animatable animatable = (Animatable) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue3;
        EffectsKt.DisposableEffect(t16, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.tencent.ntcompose.animation.AnimateAsStateKt$animateValueAsState$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements DisposableEffectResult {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ MutableState f339151a;

                public a(MutableState mutableState) {
                    this.f339151a = mutableState;
                }

                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    this.f339151a.setValue(Integer.valueOf(((Number) this.f339151a.getValue()).intValue() + 1));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                if (!Intrinsics.areEqual(animatable.e(), t16)) {
                    MutableState<Integer> mutableState2 = mutableState;
                    mutableState2.setValue(Integer.valueOf(mutableState2.getValue().intValue() + 1));
                    final int intValue = mutableState2.getValue().intValue();
                    final MutableState<Integer> mutableState3 = mutableState;
                    final Animatable<T> animatable2 = animatable;
                    final T t17 = t16;
                    final com.tencent.ntcompose.animation.a<T> aVar3 = aVar2;
                    final Function1<T, Unit> function13 = function12;
                    TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.ntcompose.animation.AnimateAsStateKt$animateValueAsState$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (intValue != mutableState3.getValue().intValue() || Intrinsics.areEqual(animatable2.e(), t17)) {
                                return;
                            }
                            animatable2.a(t17, aVar3, function13, false);
                        }
                    }, 1, null);
                }
                return new a(mutableState);
            }
        }, composer, (i3 & 8) | (i3 & 14));
        State<T> c16 = animatable.c();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return c16;
    }
}
