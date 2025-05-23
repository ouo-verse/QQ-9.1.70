package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.b;
import com.tencent.ntcompose.animation.m;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1", f = "LoveWallWaterDropsFloatView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<Integer> $currentDelay;
    public final /* synthetic */ MutableState<Boolean> $moveUp;
    public final /* synthetic */ float $startY;
    public final /* synthetic */ float $toY;
    public final /* synthetic */ Animatable<Float> $yAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1(Animatable<Float> animatable, MutableState<Boolean> mutableState, float f16, float f17, MutableState<Integer> mutableState2, Continuation<? super LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1> continuation) {
        super(2, continuation);
        this.$yAnimation = animatable;
        this.$moveUp = mutableState;
        this.$toY = f16;
        this.$startY = f17;
        this.$currentDelay = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1(this.$yAnimation, this.$moveUp, this.$toY, this.$startY, this.$currentDelay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Animatable<Float> animatable = this.$yAnimation;
        if (this.$moveUp.getValue().booleanValue()) {
            f16 = this.$toY;
        } else {
            f16 = this.$startY;
        }
        Float boxFloat = Boxing.boxFloat(f16);
        m d16 = b.d(1000, this.$currentDelay.getValue().intValue(), null, null, 12, null);
        final MutableState<Boolean> mutableState = this.$moveUp;
        final MutableState<Integer> mutableState2 = this.$currentDelay;
        Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallWaterDropsFloatViewKt$RandomMovingWaterDropWithBubbleView$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Float f17) {
                f17.floatValue();
                mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
                mutableState2.setValue(0);
                return Unit.INSTANCE;
            }
        }, false, 8, null);
        return Unit.INSTANCE;
    }
}
