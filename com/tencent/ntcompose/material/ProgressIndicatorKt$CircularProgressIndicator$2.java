package com.tencent.ntcompose.material;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.ntcompose.material.ProgressIndicatorKt$CircularProgressIndicator$2", f = "ProgressIndicator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class ProgressIndicatorKt$CircularProgressIndicator$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.kuikly.core.base.h $backgroundColor;
    final /* synthetic */ MutableState<com.tencent.kuikly.core.base.w> $canvasSize;
    final /* synthetic */ com.tencent.kuikly.core.base.h $color;
    final /* synthetic */ i $drawState;
    final /* synthetic */ float $newProgress;
    final /* synthetic */ float $strokeWidth;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorKt$CircularProgressIndicator$2(MutableState<com.tencent.kuikly.core.base.w> mutableState, float f16, i iVar, com.tencent.kuikly.core.base.h hVar, com.tencent.kuikly.core.base.h hVar2, float f17, Continuation<? super ProgressIndicatorKt$CircularProgressIndicator$2> continuation) {
        super(2, continuation);
        this.$canvasSize = mutableState;
        this.$strokeWidth = f16;
        this.$drawState = iVar;
        this.$backgroundColor = hVar;
        this.$color = hVar2;
        this.$newProgress = f17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProgressIndicatorKt$CircularProgressIndicator$2(this.$canvasSize, this.$strokeWidth, this.$drawState, this.$backgroundColor, this.$color, this.$newProgress, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$canvasSize.getValue().getWidth() > 0.0f && this.$canvasSize.getValue().getHeight() > 0.0f) {
                float min = Math.min(this.$canvasSize.getValue().getWidth(), this.$canvasSize.getValue().getHeight());
                float f16 = 2;
                float f17 = min / f16;
                float f18 = this.$strokeWidth;
                float f19 = (min - f18) / f16;
                i iVar = this.$drawState;
                com.tencent.kuikly.core.base.h hVar = this.$backgroundColor;
                com.tencent.kuikly.core.base.h hVar2 = this.$color;
                float f26 = this.$newProgress;
                iVar.n();
                iVar.b();
                iVar.t(hVar);
                iVar.l(f18);
                iVar.j();
                iVar.a(f17, f17, f19, 0.0f, 6.2831855f, false);
                iVar.s();
                iVar.b();
                iVar.t(hVar2);
                iVar.l(f18);
                iVar.i();
                float f27 = ((3.1415927f * f26) / 180.0f) - 1.5707964f;
                if (f26 >= 360.0f) {
                    f27 -= 0.01f;
                }
                iVar.a(f17, f17, f19, -1.5707964f, f27, false);
                iVar.s();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProgressIndicatorKt$CircularProgressIndicator$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
