package com.tencent.filament.zplan.animation;

import com.tencent.filament.zplanservice.download.ZPlanAvatarInterfaceResult;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarInterfaceResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.filament.zplan.animation.FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1", f = "FilamentAnimationHelper.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ZPlanAvatarInterfaceResult>, Object> {
    int label;
    final /* synthetic */ FilamentAnimationHelper$fetchIdActionWithService$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1(FilamentAnimationHelper$fetchIdActionWithService$2 filamentAnimationHelper$fetchIdActionWithService$2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filamentAnimationHelper$fetchIdActionWithService$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1(this.this$0, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ZPlanAvatarInterfaceResult> continuation) {
        return ((FilamentAnimationHelper$fetchIdActionWithService$2$facePathDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FilamentAnimationHelper$fetchIdActionWithService$2 filamentAnimationHelper$fetchIdActionWithService$2 = this.this$0;
            ZPlanAvatarService zPlanAvatarService = filamentAnimationHelper$fetchIdActionWithService$2.$avatarService;
            long j3 = filamentAnimationHelper$fetchIdActionWithService$2.$actionId;
            int value = filamentAnimationHelper$fetchIdActionWithService$2.$gender.getValue();
            this.label = 1;
            obj = zPlanAvatarService.B(j3, value, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
