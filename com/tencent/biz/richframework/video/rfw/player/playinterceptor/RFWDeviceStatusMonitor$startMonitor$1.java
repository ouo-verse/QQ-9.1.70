package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor;
import java.util.List;
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
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitor$1", f = "RFWDeviceStatusMonitor.kt", i = {0}, l = {305}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitor$startMonitor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption $option;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RFWDeviceStatusMonitor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWDeviceStatusMonitor$startMonitor$1(RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption, RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super RFWDeviceStatusMonitor$startMonitor$1> continuation) {
        super(2, continuation);
        this.$option = rFWDeviceMonitorIntervalOption;
        this.this$0 = rFWDeviceStatusMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RFWDeviceStatusMonitor$startMonitor$1(this.$option, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Mutex mutex;
        RFWDeviceStatusMonitor rFWDeviceStatusMonitor;
        RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption;
        List list;
        Job job;
        Job startMonitorInner;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = false;
        if (i3 != 0) {
            if (i3 == 1) {
                rFWDeviceMonitorIntervalOption = (RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption) this.L$2;
                rFWDeviceStatusMonitor = (RFWDeviceStatusMonitor) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            RFWLog.d("RFWDeviceStatusMonitor", 1, "starting monitor: " + this.$option);
            mutex = this.this$0.getMutex();
            rFWDeviceStatusMonitor = this.this$0;
            RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption2 = this.$option;
            this.L$0 = mutex;
            this.L$1 = rFWDeviceStatusMonitor;
            this.L$2 = rFWDeviceMonitorIntervalOption2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            rFWDeviceMonitorIntervalOption = rFWDeviceMonitorIntervalOption2;
        }
        try {
            list = rFWDeviceStatusMonitor.intervalOptions;
            list.add(rFWDeviceMonitorIntervalOption);
            rFWDeviceStatusMonitor.updateMinIntervals();
            job = rFWDeviceStatusMonitor.monitorJob;
            if (job != null && job.isActive()) {
                z16 = true;
            }
            if (!z16) {
                startMonitorInner = rFWDeviceStatusMonitor.startMonitorInner();
                rFWDeviceStatusMonitor.monitorJob = startMonitorInner;
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            mutex.unlock(null);
            throw th5;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RFWDeviceStatusMonitor$startMonitor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
