package com.tencent.mobileqq.zplan.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t74.r;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$beaconReport$1", f = "ZPlanMemoryUsageReport.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class ZPlanMemoryUsageReport$beaconReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MemoryUsageEvent $beginEvent;
    final /* synthetic */ MemoryUsageEvent $endEvent;
    final /* synthetic */ boolean $isFirstLaunch;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $sceneClassName;
    int label;
    final /* synthetic */ ZPlanMemoryUsageReport this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanMemoryUsageReport$beaconReport$1(ZPlanMemoryUsageReport zPlanMemoryUsageReport, Map<String, String> map, MemoryUsageEvent memoryUsageEvent, MemoryUsageEvent memoryUsageEvent2, String str, boolean z16, Continuation<? super ZPlanMemoryUsageReport$beaconReport$1> continuation) {
        super(2, continuation);
        this.this$0 = zPlanMemoryUsageReport;
        this.$params = map;
        this.$beginEvent = memoryUsageEvent;
        this.$endEvent = memoryUsageEvent2;
        this.$sceneClassName = str;
        this.$isFirstLaunch = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ZPlanMemoryUsageReport$beaconReport$1(this.this$0, this.$params, this.$beginEvent, this.$endEvent, this.$sceneClassName, this.$isFirstLaunch, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                z16 = this.this$0.reportSwitchForDebugOnly;
                if (z16) {
                    r.e(null, "zplanlite#nativeapp#launch#memory", this.$params, 1, null);
                }
            } catch (Throwable th5) {
                QLog.e("ZPlanMemoryUsageReport", 1, "report exception: beginEvent=" + this.$beginEvent + " endEvent=" + this.$endEvent + " sceneClassName=" + this.$sceneClassName + " isFirstLaunch=" + this.$isFirstLaunch + " params=" + this.$params, th5);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ZPlanMemoryUsageReport$beaconReport$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
