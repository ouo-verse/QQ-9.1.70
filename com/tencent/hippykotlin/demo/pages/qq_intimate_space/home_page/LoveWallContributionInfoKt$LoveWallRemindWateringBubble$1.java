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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1", f = "LoveWallContributionInfo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<Boolean> $hideBubble;
    public final /* synthetic */ Animatable<Float> $opacityAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1(Animatable<Float> animatable, MutableState<Boolean> mutableState, Continuation<? super LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1> continuation) {
        super(2, continuation);
        this.$opacityAnimation = animatable;
        this.$hideBubble = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1(this.$opacityAnimation, this.$hideBubble, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Animatable<Float> animatable = this.$opacityAnimation;
        Float boxFloat = Boxing.boxFloat(1.0f);
        m d16 = b.d(300, 0, null, null, 14, null);
        final MutableState<Boolean> mutableState = this.$hideBubble;
        Animatable.b(animatable, boxFloat, d16, new Function1<Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallContributionInfoKt$LoveWallRemindWateringBubble$1.1
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
