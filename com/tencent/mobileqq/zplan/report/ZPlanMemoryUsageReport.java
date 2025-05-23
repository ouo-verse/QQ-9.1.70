package com.tencent.mobileqq.zplan.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J(\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/report/ZPlanMemoryUsageReport;", "Lkotlinx/coroutines/CoroutineScope;", "", "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/zplan/report/b;", "beginEvent", "endEvent", "", "sceneClassName", "", "isFirstLaunch", "e", "g", h.F, "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/Channel;", "Lcom/tencent/mobileqq/zplan/report/a;", "Lkotlinx/coroutines/channels/Channel;", "launchEngineBeginEvents", "launchEngineEndEvents", "Z", "reportSwitchForDebugOnly", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMemoryUsageReport implements CoroutineScope {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String sceneClassName;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f335045e;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Channel<LaunchEngineBeginEvent> launchEngineBeginEvents;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Channel<MemoryUsageEvent> launchEngineEndEvents;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean reportSwitchForDebugOnly;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$1", f = "ZPlanMemoryUsageReport.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$1, reason: invalid class name */
    /* loaded from: classes34.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    ZPlanMemoryUsageReport zPlanMemoryUsageReport = ZPlanMemoryUsageReport.this;
                    this.label = 1;
                    if (zPlanMemoryUsageReport.i(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th5) {
                QLog.e("ZPlanMemoryUsageReport", 1, "sceneClassName=" + ZPlanMemoryUsageReport.this.getSceneClassName() + " beginEvents=" + ZPlanMemoryUsageReport.this.launchEngineBeginEvents + " endEvents=" + ZPlanMemoryUsageReport.this.launchEngineEndEvents, th5);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public ZPlanMemoryUsageReport(String sceneClassName) {
        Intrinsics.checkNotNullParameter(sceneClassName, "sceneClassName");
        this.sceneClassName = sceneClassName;
        this.f335045e = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.launchEngineBeginEvents = ChannelKt.Channel$default(0, null, null, 7, null);
        this.launchEngineEndEvents = ChannelKt.Channel$default(0, null, null, 7, null);
        this.reportSwitchForDebugOnly = true;
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    private final void e(MemoryUsageEvent beginEvent, MemoryUsageEvent endEvent, String sceneClassName, boolean isFirstLaunch) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sceneClassName", sceneClassName), TuplesKt.to("incrementMemory", String.valueOf(endEvent.getUsageMB() - beginEvent.getUsageMB())), TuplesKt.to("onStartMemory", String.valueOf(beginEvent.getUsageMB())), TuplesKt.to("isFirstLaunch", String.valueOf(isFirstLaunch)), TuplesKt.to("memoryDuration", String.valueOf((endEvent.getMeasureTimestampMs() - beginEvent.getMeasureTimestampMs()) / 1000.0d)));
        QLog.d("ZPlanMemoryUsageReport", 4, "MemoryUsageReport: params=" + mapOf);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new ZPlanMemoryUsageReport$beaconReport$1(this, mapOf, beginEvent, endEvent, sceneClassName, isFirstLaunch, null), 3, null);
    }

    /* renamed from: f, reason: from getter */
    public final String getSceneClassName() {
        return this.sceneClassName;
    }

    public final void g() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new ZPlanMemoryUsageReport$onLaunchEngineBegin$1(this, new LaunchEngineBeginEvent(new MemoryUsageEvent(0.0d, 0L, 3, null)), null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f335045e.getCoroutineContext();
    }

    public final void h() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new ZPlanMemoryUsageReport$onLaunchEngineEnd$1(this, new MemoryUsageEvent(0.0d, 0L, 3, null), null), 3, null);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0083 -> B:11:0x0088). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r17 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$reportEngineMemoryUsageLooper$1
            if (r1 == 0) goto L17
            r1 = r0
            com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$reportEngineMemoryUsageLooper$1 r1 = (com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$reportEngineMemoryUsageLooper$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L1e
        L17:
            com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$reportEngineMemoryUsageLooper$1 r1 = new com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport$reportEngineMemoryUsageLooper$1
            r2 = r17
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L54
            if (r4 == r6) goto L46
            if (r4 != r5) goto L3d
            int r4 = r1.I$0
            java.lang.Object r8 = r1.L$1
            com.tencent.mobileqq.zplan.report.a r8 = (com.tencent.mobileqq.zplan.report.LaunchEngineBeginEvent) r8
            java.lang.Object r9 = r1.L$0
            com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport r9 = (com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport) r9
            kotlin.ResultKt.throwOnFailure(r0)
            goto L88
        L3d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L46:
            int r4 = r1.I$0
            java.lang.Object r8 = r1.L$1
            com.tencent.mobileqq.zplan.report.b r8 = (com.tencent.mobileqq.zplan.report.MemoryUsageEvent) r8
            java.lang.Object r9 = r1.L$0
            com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport r9 = (com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport) r9
            kotlin.ResultKt.throwOnFailure(r0)
            goto L6e
        L54:
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r2
            r4 = r6
            r0 = r7
            r8 = r0
        L5b:
            if (r0 != 0) goto L70
            kotlinx.coroutines.channels.Channel<com.tencent.mobileqq.zplan.report.a> r0 = r9.launchEngineBeginEvents
            r1.L$0 = r9
            r1.L$1 = r8
            r1.I$0 = r4
            r1.label = r6
            java.lang.Object r0 = r0.receive(r1)
            if (r0 != r3) goto L6e
            return r3
        L6e:
            com.tencent.mobileqq.zplan.report.a r0 = (com.tencent.mobileqq.zplan.report.LaunchEngineBeginEvent) r0
        L70:
            if (r8 != 0) goto L8f
            kotlinx.coroutines.channels.Channel<com.tencent.mobileqq.zplan.report.b> r8 = r9.launchEngineEndEvents
            r1.L$0 = r9
            r1.L$1 = r0
            r1.I$0 = r4
            r1.label = r5
            java.lang.Object r8 = r8.receive(r1)
            if (r8 != r3) goto L83
            return r3
        L83:
            r16 = r8
            r8 = r0
            r0 = r16
        L88:
            com.tencent.mobileqq.zplan.report.b r0 = (com.tencent.mobileqq.zplan.report.MemoryUsageEvent) r0
            r16 = r8
            r8 = r0
            r0 = r16
        L8f:
            long r10 = r8.getMeasureTimestampMs()
            com.tencent.mobileqq.zplan.report.b r12 = r0.getMemoryUsage()
            long r12 = r12.getMeasureTimestampMs()
            long r10 = r10 - r12
            r12 = 0
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r13 = 0
            if (r12 > 0) goto La6
            r8 = r7
        La4:
            r4 = r13
            goto L5b
        La6:
            r14 = 20000(0x4e20, double:9.8813E-320)
            int r10 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r10 <= 0) goto Lae
            r0 = r7
            goto L5b
        Lae:
            com.tencent.mobileqq.zplan.report.b r0 = r0.getMemoryUsage()
            java.lang.String r10 = r9.sceneClassName
            if (r4 == 0) goto Lb8
            r4 = r6
            goto Lb9
        Lb8:
            r4 = r13
        Lb9:
            r9.e(r0, r8, r10, r4)
            r0 = r7
            r8 = r0
            goto La4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.zplan.report.ZPlanMemoryUsageReport.i(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
