package com.tencent.mobileqq.activity.aio.zplan;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.activity.aio.zplan.ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1", f = "ZPlanIntimateInfoView.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes10.dex */
final class ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bothSceneId;
    int label;
    final /* synthetic */ ZPlanIntimateInfoView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1(ZPlanIntimateInfoView zPlanIntimateInfoView, int i3, Continuation<? super ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanIntimateInfoView;
        this.$bothSceneId = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1(this.this$0, this.$bothSceneId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object Z;
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
            ZPlanIntimateInfoView zPlanIntimateInfoView = this.this$0;
            Integer boxInt = Boxing.boxInt(this.$bothSceneId);
            this.label = 1;
            Z = zPlanIntimateInfoView.Z(boxInt, this);
            if (Z == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ZPlanIntimateInfoView$zplanIntimateSceneSyncPushObserver$1$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
