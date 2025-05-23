package com.tencent.mobileqq.activity.aio.zplan;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$2$updateIntimateInfo$1", f = "ZPlanIntimateInfoView.kt", i = {}, l = {244, 245}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class ZPlanIntimateInfoView$2$updateIntimateInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$2$updateIntimateInfo$1(ZPlanIntimateInfoView zPlanIntimateInfoView, Continuation<? super ZPlanIntimateInfoView$2$updateIntimateInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanIntimateInfoView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$2$updateIntimateInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            ZPlanIntimateInfoView zPlanIntimateInfoView = this.this$0;
            this.label = 1;
            obj = zPlanIntimateInfoView.E(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (((Boolean) obj).booleanValue()) {
            ZPlanIntimateInfoView zPlanIntimateInfoView2 = this.this$0;
            this.label = 2;
            if (ZPlanIntimateInfoView.a0(zPlanIntimateInfoView2, null, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ZPlanIntimateInfoView$2$updateIntimateInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
