package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$stopMonitorInner$1", f = "RFWDeviceStatusMonitor.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitor$stopMonitorInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RFWDeviceStatusMonitor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWDeviceStatusMonitor$stopMonitorInner$1(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super RFWDeviceStatusMonitor$stopMonitorInner$1> continuation) {
        super(2, continuation);
        this.this$0 = rFWDeviceStatusMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RFWDeviceStatusMonitor$stopMonitorInner$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Job job;
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
            job = this.this$0.monitorJob;
            if (job != null) {
                this.label = 1;
                if (JobKt.cancelAndJoin(job, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        this.this$0.monitorJob = null;
        RFWLog.d("RFWDeviceStatusMonitor", 1, "monitor stopped");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RFWDeviceStatusMonitor$stopMonitorInner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
