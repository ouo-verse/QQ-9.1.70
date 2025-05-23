package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.os.Process;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1", f = "RFWDeviceStatusMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class RFWDeviceStatusMonitor$startMonitorInner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RFWDeviceStatusMonitor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$1", f = "RFWDeviceStatusMonitor.kt", i = {0}, l = {196}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RFWDeviceStatusMonitor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = rFWDeviceStatusMonitor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption;
            long cpuMonitorIntervalMs;
            boolean isAppForeground;
            RFWDeviceStatusMonitor.IMonitorListener iMonitorListener;
            float f16;
            float f17;
            int i3;
            int i16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i17 = this.label;
            if (i17 != 0) {
                if (i17 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            }
            do {
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    rFWDeviceMonitorIntervalOption = this.this$0.minInterval;
                    cpuMonitorIntervalMs = rFWDeviceMonitorIntervalOption.getCpuMonitorIntervalMs();
                    if (cpuMonitorIntervalMs == Long.MAX_VALUE) {
                        this.this$0.cpuUsage = 1.0f;
                    } else {
                        isAppForeground = this.this$0.isAppForeground();
                        if (isAppForeground) {
                            this.this$0.cpuUsage = CpuUtil.f258160a.g(Process.myPid());
                            iMonitorListener = this.this$0.listener;
                            f16 = this.this$0.cpuUsage;
                            f17 = this.this$0.memoryUsage;
                            i3 = this.this$0.threadCount;
                            i16 = this.this$0.fileDescriptorCount;
                            iMonitorListener.statusChanged(new RFWDeviceStatusMonitor.RFWDeviceStatus(f16, f17, i3, i16));
                        }
                        this.L$0 = coroutineScope;
                        this.label = 1;
                    }
                }
                return Unit.INSTANCE;
            } while (DelayKt.delay(cpuMonitorIntervalMs, this) != coroutine_suspended);
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$2", f = "RFWDeviceStatusMonitor.kt", i = {0}, l = {211}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RFWDeviceStatusMonitor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = rFWDeviceStatusMonitor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption;
            long memoryMonitorIntervalMs;
            boolean isAppForeground;
            float memoryUsage;
            RFWDeviceStatusMonitor.IMonitorListener iMonitorListener;
            float f16;
            float f17;
            int i3;
            int i16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i17 = this.label;
            if (i17 != 0) {
                if (i17 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            }
            do {
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    rFWDeviceMonitorIntervalOption = this.this$0.minInterval;
                    memoryMonitorIntervalMs = rFWDeviceMonitorIntervalOption.getMemoryMonitorIntervalMs();
                    if (memoryMonitorIntervalMs == Long.MAX_VALUE) {
                        this.this$0.memoryUsage = 1.0f;
                    } else {
                        isAppForeground = this.this$0.isAppForeground();
                        if (isAppForeground) {
                            RFWDeviceStatusMonitor rFWDeviceStatusMonitor = this.this$0;
                            memoryUsage = rFWDeviceStatusMonitor.getMemoryUsage();
                            rFWDeviceStatusMonitor.memoryUsage = memoryUsage;
                            iMonitorListener = this.this$0.listener;
                            f16 = this.this$0.cpuUsage;
                            f17 = this.this$0.memoryUsage;
                            i3 = this.this$0.threadCount;
                            i16 = this.this$0.fileDescriptorCount;
                            iMonitorListener.statusChanged(new RFWDeviceStatusMonitor.RFWDeviceStatus(f16, f17, i3, i16));
                        }
                        this.L$0 = coroutineScope;
                        this.label = 1;
                    }
                }
                return Unit.INSTANCE;
            } while (DelayKt.delay(memoryMonitorIntervalMs, this) != coroutine_suspended);
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$3", f = "RFWDeviceStatusMonitor.kt", i = {0}, l = {241}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWDeviceStatusMonitor$startMonitorInner$1$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RFWDeviceStatusMonitor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = rFWDeviceStatusMonitor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            CoroutineScope coroutineScope;
            RFWDeviceStatusMonitor.RFWDeviceMonitorIntervalOption rFWDeviceMonitorIntervalOption;
            long fileDescriptorMonitorIntervalMs;
            boolean isAppForeground;
            String joinToString$default;
            List split$default;
            boolean equals;
            RFWDeviceStatusMonitor.IMonitorListener iMonitorListener;
            float f16;
            float f17;
            int i3;
            int i16;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i17 = this.label;
            if (i17 != 0) {
                if (i17 == 1) {
                    coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            }
            do {
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    rFWDeviceMonitorIntervalOption = this.this$0.minInterval;
                    fileDescriptorMonitorIntervalMs = rFWDeviceMonitorIntervalOption.getFileDescriptorMonitorIntervalMs();
                    if (fileDescriptorMonitorIntervalMs == Long.MAX_VALUE) {
                        this.this$0.fileDescriptorCount = Integer.MAX_VALUE;
                        this.this$0.threadCount = Integer.MAX_VALUE;
                    } else {
                        isAppForeground = this.this$0.isAppForeground();
                        if (isAppForeground) {
                            this.this$0.fileDescriptorCount = com.tencent.qqperf.tools.e.a();
                            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(RFWDeviceStatusMonitor.INSTANCE.getDEFAULT_IGNORE_THREAD_COUNT_PHONE_MODELS(), ",", null, null, 0, null, null, 62, null);
                            split$default = StringsKt__StringsKt.split$default((CharSequence) iUnitedConfigManager.loadAsString("qqcircle_thread_monitor_phone_model_blacklist", joinToString$default), new String[]{","}, false, 0, 6, (Object) null);
                            List list = split$default;
                            boolean z16 = false;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    equals = StringsKt__StringsJVMKt.equals(DeviceInfoMonitor.getModel(), (String) it.next(), true);
                                    if (equals) {
                                        z16 = true;
                                        break;
                                    }
                                }
                            }
                            if (z16) {
                                this.this$0.threadCount = Integer.MAX_VALUE;
                            } else {
                                this.this$0.threadCount = Thread.getAllStackTraces().size();
                            }
                            iMonitorListener = this.this$0.listener;
                            f16 = this.this$0.cpuUsage;
                            f17 = this.this$0.memoryUsage;
                            i3 = this.this$0.threadCount;
                            i16 = this.this$0.fileDescriptorCount;
                            iMonitorListener.statusChanged(new RFWDeviceStatusMonitor.RFWDeviceStatus(f16, f17, i3, i16));
                        }
                        this.L$0 = coroutineScope;
                        this.label = 1;
                    }
                }
                return Unit.INSTANCE;
            } while (DelayKt.delay(fileDescriptorMonitorIntervalMs, this) != coroutine_suspended);
            return coroutine_suspended;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWDeviceStatusMonitor$startMonitorInner$1(RFWDeviceStatusMonitor rFWDeviceStatusMonitor, Continuation<? super RFWDeviceStatusMonitor$startMonitorInner$1> continuation) {
        super(2, continuation);
        this.this$0 = rFWDeviceStatusMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RFWDeviceStatusMonitor$startMonitorInner$1 rFWDeviceStatusMonitor$startMonitorInner$1 = new RFWDeviceStatusMonitor$startMonitorInner$1(this.this$0, continuation);
        rFWDeviceStatusMonitor$startMonitorInner$1.L$0 = obj;
        return rFWDeviceStatusMonitor$startMonitorInner$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RFWDeviceStatusMonitor$startMonitorInner$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
