package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

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
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$stopMonitor$1", f = "RFWDeviceStatusMonitor.kt", i = {0}, l = {305}, m = "invokeSuspend", n = {"$this$withLock$iv"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitor$stopMonitor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption $option;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RFWDeviceStatusMonitor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWDeviceStatusMonitor$stopMonitor$1(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption, Continuation<? super RFWDeviceStatusMonitor$stopMonitor$1> continuation) {
        super(2, continuation);
        this.this$0 = rFWDeviceStatusMonitor;
        this.$option = rFWDeviceMonitorIntervalOption;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RFWDeviceStatusMonitor$stopMonitor$1(this.this$0, this.$option, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Mutex mutex;
        RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption;
        RFWDeviceStatusMonitor rFWDeviceStatusMonitor;
        List list;
        List list2;
        List list3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                rFWDeviceStatusMonitor = (RFWDeviceStatusMonitor) this.L$2;
                rFWDeviceMonitorIntervalOption = (RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.getMutex();
            rFWDeviceMonitorIntervalOption = this.$option;
            RFWDeviceStatusMonitor rFWDeviceStatusMonitor2 = this.this$0;
            this.L$0 = mutex;
            this.L$1 = rFWDeviceMonitorIntervalOption;
            this.L$2 = rFWDeviceStatusMonitor2;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            rFWDeviceStatusMonitor = rFWDeviceStatusMonitor2;
        }
        try {
            if (rFWDeviceMonitorIntervalOption != null) {
                list2 = rFWDeviceStatusMonitor.intervalOptions;
                list2.remove(rFWDeviceMonitorIntervalOption);
                list3 = rFWDeviceStatusMonitor.intervalOptions;
                z16 = list3.isEmpty();
            } else {
                list = rFWDeviceStatusMonitor.intervalOptions;
                list.clear();
            }
            if (z16) {
                rFWDeviceStatusMonitor.stopMonitorInner();
            } else {
                rFWDeviceStatusMonitor.updateMinIntervals();
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
        return ((RFWDeviceStatusMonitor$stopMonitor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
