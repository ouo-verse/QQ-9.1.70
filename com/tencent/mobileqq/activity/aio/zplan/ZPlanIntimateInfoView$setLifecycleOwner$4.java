package com.tencent.mobileqq.activity.aio.zplan;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\b\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$setLifecycleOwner$4", f = "ZPlanIntimateInfoView.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class ZPlanIntimateInfoView$setLifecycleOwner$4 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ WeakReference<com.tencent.mobileqq.zplan.aio.couple.i> $coupleAvatarViewControllerRef;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$setLifecycleOwner$4(WeakReference<com.tencent.mobileqq.zplan.aio.couple.i> weakReference, Continuation<? super ZPlanIntimateInfoView$setLifecycleOwner$4> continuation) {
        super(1, continuation);
        this.$coupleAvatarViewControllerRef = weakReference;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$setLifecycleOwner$4(this.$coupleAvatarViewControllerRef, continuation);
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
            com.tencent.mobileqq.zplan.aio.couple.i iVar = this.$coupleAvatarViewControllerRef.get();
            if (iVar != null) {
                this.label = 1;
                obj = iVar.e(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return null;
            }
        }
        return (Integer) obj;
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final Object invoke(@Nullable Continuation<? super Integer> continuation) {
        return ((ZPlanIntimateInfoView$setLifecycleOwner$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
