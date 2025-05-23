package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportQueue;", "", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportQueue$a;", "reportBundle", "Lkotlinx/coroutines/flow/Flow;", "d", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "reportData", "", "businessType", "", "c", "Lkotlinx/coroutines/channels/Channel;", "b", "Lkotlinx/coroutines/channels/Channel;", "reportChannel", "<init>", "()V", "a", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkDc5507ReportQueue {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkDc5507ReportQueue f327374a = new WinkDc5507ReportQueue();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Channel<ReportBundle> reportChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$1", f = "WinkDc5507ReportQueue.kt", i = {}, l = {35, 176}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportQueue$a;", "it", "Lkotlinx/coroutines/flow/Flow;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$1$1", f = "WinkDc5507ReportQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C90991 extends SuspendLambda implements Function2<ReportBundle, Continuation<? super Flow<? extends ReportBundle>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C90991(Continuation<? super C90991> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C90991 c90991 = new C90991(continuation);
                c90991.L$0 = obj;
                return c90991;
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull ReportBundle reportBundle, @Nullable Continuation<? super Flow<ReportBundle>> continuation) {
                return ((C90991) create(reportBundle, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return WinkDc5507ReportQueue.f327374a.d((ReportBundle) this.L$0);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(ReportBundle reportBundle, Continuation<? super Flow<? extends ReportBundle>> continuation) {
                return invoke2(reportBundle, (Continuation<? super Flow<ReportBundle>>) continuation);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$1$a */
        /* loaded from: classes21.dex */
        public static final class a implements FlowCollector<ReportBundle> {
            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(ReportBundle reportBundle, @NotNull Continuation<? super Unit> continuation) {
                ReportBundle reportBundle2 = reportBundle;
                if (QLog.isColorLevel()) {
                    QLog.d("WinkDc5507ReportQueue", 2, "[init] collect, " + reportBundle2);
                }
                WinkPublishServiceProxy2 service = reportBundle2.getService();
                if (service != null) {
                    service.dc5507Report(reportBundle2.getReportData());
                }
                return Unit.INSTANCE;
            }
        }

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0074 -> B:6:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            ChannelIterator it;
            AnonymousClass1 anonymousClass1;
            AnonymousClass1 anonymousClass12;
            ChannelIterator channelIterator;
            Object hasNext;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = channelIterator2;
                        anonymousClass1 = this;
                        QLog.d("WinkDc5507ReportQueue", 2, "[init] end");
                        anonymousClass1.L$0 = it;
                        anonymousClass1.label = 1;
                        hasNext = it.hasNext(anonymousClass1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AnonymousClass1 anonymousClass13 = anonymousClass1;
                        channelIterator = it;
                        obj = hasNext;
                        anonymousClass12 = anonymousClass13;
                        if (!((Boolean) obj).booleanValue()) {
                            Flow flatMapConcat = FlowKt.flatMapConcat(FlowKt.flowOf((ReportBundle) channelIterator.next()), new C90991(null));
                            a aVar = new a();
                            anonymousClass12.L$0 = channelIterator;
                            anonymousClass12.label = 2;
                            if (flatMapConcat.collect(aVar, anonymousClass12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = channelIterator;
                            anonymousClass1 = anonymousClass12;
                            QLog.d("WinkDc5507ReportQueue", 2, "[init] end");
                            anonymousClass1.L$0 = it;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } else {
                            QLog.w("WinkDc5507ReportQueue", 1, "[init] out for");
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    channelIterator = (ChannelIterator) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    anonymousClass12 = this;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            } else {
                ResultKt.throwOnFailure(obj);
                it = WinkDc5507ReportQueue.reportChannel.iterator();
                anonymousClass1 = this;
                anonymousClass1.L$0 = it;
                anonymousClass1.label = 1;
                hasNext = it.hasNext(anonymousClass1);
                if (hasNext == coroutine_suspended) {
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
    }

    WinkDc5507ReportQueue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalCoroutinesApi
    public final Flow<ReportBundle> d(ReportBundle reportBundle) {
        return FlowKt.callbackFlow(new WinkDc5507ReportQueue$serviceFlow$1(reportBundle, null));
    }

    public final void c(@NotNull WinkDc5507ReportData reportData, int businessType) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        try {
            boolean m2018isSuccessimpl = ChannelResult.m2018isSuccessimpl(reportChannel.mo2003trySendJP2dKIU(new ReportBundle(businessType, reportData, null, 4, null)));
            if (QLog.isColorLevel()) {
                QLog.d("WinkDc5507ReportQueue", 2, "[report] " + m2018isSuccessimpl + ", " + reportData);
            }
        } catch (Exception e16) {
            QLog.w("WinkDc5507ReportQueue", 1, "WinkDc5507ReportQueue offer error :" + e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportQueue$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "businessType", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "b", "Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "()Lcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;", "reportData", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "c", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "()Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "d", "(Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;)V", "service", "<init>", "(ILcom/tencent/mobileqq/winkpublish/report/WinkDc5507ReportData;Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;)V", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportQueue$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ReportBundle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int businessType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkDc5507ReportData reportData;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private WinkPublishServiceProxy2 service;

        public ReportBundle(int i3, @NotNull WinkDc5507ReportData reportData, @Nullable WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            this.businessType = i3;
            this.reportData = reportData;
            this.service = winkPublishServiceProxy2;
        }

        /* renamed from: a, reason: from getter */
        public final int getBusinessType() {
            return this.businessType;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final WinkDc5507ReportData getReportData() {
            return this.reportData;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final WinkPublishServiceProxy2 getService() {
            return this.service;
        }

        public final void d(@Nullable WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            this.service = winkPublishServiceProxy2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReportBundle)) {
                return false;
            }
            ReportBundle reportBundle = (ReportBundle) other;
            if (this.businessType == reportBundle.businessType && Intrinsics.areEqual(this.reportData, reportBundle.reportData) && Intrinsics.areEqual(this.service, reportBundle.service)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.businessType * 31) + this.reportData.hashCode()) * 31;
            WinkPublishServiceProxy2 winkPublishServiceProxy2 = this.service;
            if (winkPublishServiceProxy2 == null) {
                hashCode = 0;
            } else {
                hashCode = winkPublishServiceProxy2.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ReportBundle(businessType=" + this.businessType + ", reportData=" + this.reportData + ", service=" + this.service + ")";
        }

        public /* synthetic */ ReportBundle(int i3, WinkDc5507ReportData winkDc5507ReportData, WinkPublishServiceProxy2 winkPublishServiceProxy2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, winkDc5507ReportData, (i16 & 4) != 0 ? null : winkPublishServiceProxy2);
        }
    }
}
