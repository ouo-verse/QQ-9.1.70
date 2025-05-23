package com.tencent.mobileqq.zplan.report;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$onLaunchEngineBegin$1", f = "ZPlanMemoryUsageReport.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanMemoryUsageReport$onLaunchEngineBegin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LaunchEngineBeginEvent $e;
    int label;
    final /* synthetic */ ZPlanMemoryUsageReport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMemoryUsageReport$onLaunchEngineBegin$1(ZPlanMemoryUsageReport zPlanMemoryUsageReport, LaunchEngineBeginEvent launchEngineBeginEvent, Continuation<? super ZPlanMemoryUsageReport$onLaunchEngineBegin$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanMemoryUsageReport;
        this.$e = launchEngineBeginEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanMemoryUsageReport$onLaunchEngineBegin$1(this.this$0, this.$e, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Channel channel = this.this$0.launchEngineBeginEvents;
            LaunchEngineBeginEvent launchEngineBeginEvent = this.$e;
            this.label = 1;
            if (channel.send(launchEngineBeginEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanMemoryUsageReport$onLaunchEngineBegin$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
