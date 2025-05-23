package com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide;

import com.tencent.ntcompose.animation.Animatable;
import com.tencent.ntcompose.animation.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.novice_guide.LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1", f = "LoveWallWateringGuildView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Animatable<Float> $opacityAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1(Animatable<Float> animatable, Continuation<? super LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1> continuation) {
        super(2, continuation);
        this.$opacityAnimation = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1(this.$opacityAnimation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallWateringGuildViewKt$LoveWallWateringGuildView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Animatable.b(this.$opacityAnimation, Boxing.boxFloat(1.0f), b.d(300, 0, null, null, 14, null), null, false, 12, null);
        return Unit.INSTANCE;
    }
}
