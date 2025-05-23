package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1", f = "LoveWallLevelProgressView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ MutableState<Boolean> $playShineAnimation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1(MutableState<Boolean> mutableState, Continuation<? super LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$playShineAnimation = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1(this.$playShineAnimation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoveWallLevelProgressViewKt$LoveWallLProgressBar$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        this.$playShineAnimation.setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
