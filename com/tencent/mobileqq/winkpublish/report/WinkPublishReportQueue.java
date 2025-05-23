package com.tencent.mobileqq.winkpublish.report;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.config.WinkPublishConfigConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue;", "", "()V", "TAG", "", "reportChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue$ReportBundle;", "needSampling", "", "samplingRate", "", "report", "", "reportData", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "businessType", "sampled", "Lkotlin/Function0;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "serviceFlow", "Lkotlinx/coroutines/flow/Flow;", "reportBundle", "ReportBundle", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkPublishReportQueue {

    @NotNull
    public static final String TAG = "WinkPublishReportQueue";

    @NotNull
    public static final WinkPublishReportQueue INSTANCE = new WinkPublishReportQueue();

    @NotNull
    private static final Channel<ReportBundle> reportChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$1", f = "WinkPublishReportQueue.kt", i = {}, l = {38, 182}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue$ReportBundle;", "it", "Lkotlinx/coroutines/flow/Flow;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
        @DebugMetadata(c = "com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$1$1", f = "WinkPublishReportQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C91001 extends SuspendLambda implements Function2<ReportBundle, Continuation<? super Flow<? extends ReportBundle>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            C91001(Continuation<? super C91001> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C91001 c91001 = new C91001(continuation);
                c91001.L$0 = obj;
                return c91001;
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull ReportBundle reportBundle, @Nullable Continuation<? super Flow<ReportBundle>> continuation) {
                return ((C91001) create(reportBundle, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return WinkPublishReportQueue.INSTANCE.serviceFlow((ReportBundle) this.L$0);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(ReportBundle reportBundle, Continuation<? super Flow<? extends ReportBundle>> continuation) {
                return invoke2(reportBundle, (Continuation<? super Flow<ReportBundle>>) continuation);
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue$1$a */
        /* loaded from: classes21.dex */
        public static final class a implements FlowCollector<ReportBundle> {
            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(ReportBundle reportBundle, @NotNull Continuation<? super Unit> continuation) {
                ReportBundle reportBundle2 = reportBundle;
                if (QLog.isColorLevel()) {
                    QLog.d(WinkPublishReportQueue.TAG, 2, "[init] collect, " + reportBundle2);
                }
                WinkPublishServiceProxy2 service = reportBundle2.getService();
                if (service != null) {
                    service.qualityReport(reportBundle2.getReportData());
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
        /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
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
                        QLog.d(WinkPublishReportQueue.TAG, 4, "[init] end");
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
                            Flow flatMapConcat = FlowKt.flatMapConcat(FlowKt.flowOf((ReportBundle) channelIterator.next()), new C91001(null));
                            a aVar = new a();
                            anonymousClass12.L$0 = channelIterator;
                            anonymousClass12.label = 2;
                            if (flatMapConcat.collect(aVar, anonymousClass12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            it = channelIterator;
                            anonymousClass1 = anonymousClass12;
                            QLog.d(WinkPublishReportQueue.TAG, 4, "[init] end");
                            anonymousClass1.L$0 = it;
                            anonymousClass1.label = 1;
                            hasNext = it.hasNext(anonymousClass1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } else {
                            QLog.w(WinkPublishReportQueue.TAG, 1, "[init] out for");
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
                it = WinkPublishReportQueue.reportChannel.iterator();
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

    WinkPublishReportQueue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalCoroutinesApi
    public final Flow<ReportBundle> serviceFlow(ReportBundle reportBundle) {
        return FlowKt.callbackFlow(new WinkPublishReportQueue$serviceFlow$1(reportBundle, null));
    }

    public final boolean needSampling(int samplingRate) {
        String uinString;
        int parseLong;
        if (samplingRate <= 0) {
            QLog.w(TAG, 1, "[needSampling] invalid sampleRatio=" + samplingRate);
            return false;
        }
        try {
            uinString = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            Intrinsics.checkNotNullExpressionValue(uinString, "uinString");
            parseLong = (int) (Long.parseLong(uinString) % samplingRate);
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[needSampling] ", e16);
        }
        if (parseLong == samplingRate - 1) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[needSampling] no sampled, uin=" + uinString + ", mod=" + parseLong + ", samplingRate=" + samplingRate);
        }
        return false;
    }

    public final void report(@NotNull WinkPublishQualityReportData reportData, int businessType) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (reportData.getReportTimeMillis() <= 0) {
            reportData.setReportTimeMillis(System.currentTimeMillis());
        }
        try {
            Object mo2003trySendJP2dKIU = reportChannel.mo2003trySendJP2dKIU(new ReportBundle(businessType, reportData, null, 4, null));
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[report] " + ChannelResult.m2019toStringimpl(mo2003trySendJP2dKIU) + ", " + reportData);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 1, "WinkPublishReportQueue offer error :" + e16);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/report/WinkPublishReportQueue$ReportBundle;", "", "businessType", "", "reportData", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "service", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "(ILcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;)V", "getBusinessType", "()I", "getReportData", "()Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "getService", "()Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "setService", "(Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final /* data */ class ReportBundle {
        private final int businessType;

        @NotNull
        private final WinkPublishQualityReportData reportData;

        @Nullable
        private WinkPublishServiceProxy2 service;

        public ReportBundle(int i3, @NotNull WinkPublishQualityReportData reportData, @Nullable WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            this.businessType = i3;
            this.reportData = reportData;
            this.service = winkPublishServiceProxy2;
        }

        public static /* synthetic */ ReportBundle copy$default(ReportBundle reportBundle, int i3, WinkPublishQualityReportData winkPublishQualityReportData, WinkPublishServiceProxy2 winkPublishServiceProxy2, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = reportBundle.businessType;
            }
            if ((i16 & 2) != 0) {
                winkPublishQualityReportData = reportBundle.reportData;
            }
            if ((i16 & 4) != 0) {
                winkPublishServiceProxy2 = reportBundle.service;
            }
            return reportBundle.copy(i3, winkPublishQualityReportData, winkPublishServiceProxy2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBusinessType() {
            return this.businessType;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final WinkPublishQualityReportData getReportData() {
            return this.reportData;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final WinkPublishServiceProxy2 getService() {
            return this.service;
        }

        @NotNull
        public final ReportBundle copy(int businessType, @NotNull WinkPublishQualityReportData reportData, @Nullable WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(reportData, "reportData");
            return new ReportBundle(businessType, reportData, service);
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

        public final int getBusinessType() {
            return this.businessType;
        }

        @NotNull
        public final WinkPublishQualityReportData getReportData() {
            return this.reportData;
        }

        @Nullable
        public final WinkPublishServiceProxy2 getService() {
            return this.service;
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

        public final void setService(@Nullable WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            this.service = winkPublishServiceProxy2;
        }

        @NotNull
        public String toString() {
            return "ReportBundle(businessType=" + this.businessType + ", reportData=" + this.reportData + ", service=" + this.service + ")";
        }

        public /* synthetic */ ReportBundle(int i3, WinkPublishQualityReportData winkPublishQualityReportData, WinkPublishServiceProxy2 winkPublishServiceProxy2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, winkPublishQualityReportData, (i16 & 4) != 0 ? null : winkPublishServiceProxy2);
        }
    }

    public final void report(@NotNull WinkPublishQualityReportData reportData, @NotNull String businessName) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        report(reportData, WinkPublishConfigConstant.INSTANCE.name2Type(businessName));
    }

    public final void report(@NotNull WinkPublishQualityReportData reportData, int businessType, int samplingRate) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        if (needSampling(samplingRate)) {
            report(reportData, businessType);
        }
    }

    public final void report(@NotNull WinkPublishQualityReportData reportData, int businessType, @NotNull Function0<Boolean> sampled) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        Intrinsics.checkNotNullParameter(sampled, "sampled");
        if (sampled.invoke().booleanValue()) {
            report(reportData, businessType);
        }
    }
}
