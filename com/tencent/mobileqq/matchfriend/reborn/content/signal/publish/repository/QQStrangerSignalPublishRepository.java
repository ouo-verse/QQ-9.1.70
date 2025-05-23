package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetSignalConfigReq;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetSignalConfigRsp;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalPublishReq;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalPublishRsp;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0002\u0016\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0002J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00030\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fR\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$GetSignalConfigRsp;", "k", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "e", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "signalConfig", "", "partnerAdjID", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalPublishRsp;", "g", "i", "(Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", h.F, "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishCacheHelper;", "a", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishCacheHelper;", "cacheHelper", "<init>", "()V", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheHelper;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository$b;", "T", "", "", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final T data;

        public b(boolean z16, T t16) {
            this.isSuccess = z16;
            this.data = t16;
        }

        public final T a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSuccess() {
            return this.isSuccess;
        }

        public /* synthetic */ b(boolean z16, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i3 & 2) != 0 ? null : obj);
        }
    }

    public QQStrangerSignalPublishRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalPublishCacheHelper>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$cacheHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalPublishCacheHelper invoke() {
                return new QQStrangerSignalPublishCacheHelper();
            }
        });
        this.cacheHelper = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSignalPublishCacheHelper d() {
        return (QQStrangerSignalPublishCacheHelper) this.cacheHelper.getValue();
    }

    private final Flow<QQStrangerSignalConfigResult> e() {
        return FlowKt.flow(new QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1(this, null));
    }

    private final Flow<b<SignalPlazaSvrPB$SignalPublishRsp>> g(SignalPB$SignalConfig signalConfig, long partnerAdjID) {
        return FlowKt.flow(new QQStrangerSignalPublishRepository$publishSignalFlow$1(this, signalConfig, partnerAdjID, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(SignalPB$SignalConfig signalPB$SignalConfig, long j3, Continuation<? super b<SignalPlazaSvrPB$SignalPublishRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
        if (aVar != null) {
            SignalPlazaSvrPB$SignalPublishReq signalPlazaSvrPB$SignalPublishReq = new SignalPlazaSvrPB$SignalPublishReq();
            signalPlazaSvrPB$SignalPublishReq.partner_id.set(signalPB$SignalConfig.partner_id.get());
            signalPlazaSvrPB$SignalPublishReq.partner_adj_id.set(j3);
            Unit unit = Unit.INSTANCE;
            final String str = "QQStranger.SignalPlazaSvr.SsoSignalPublish";
            aVar.Z0("QQStranger.SignalPlazaSvr.SsoSignalPublish", signalPlazaSvrPB$SignalPublishReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestPublishSignal$2$2
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    if (z16 && (obj instanceof byte[])) {
                        SignalPlazaSvrPB$SignalPublishRsp signalPlazaSvrPB$SignalPublishRsp = new SignalPlazaSvrPB$SignalPublishRsp();
                        signalPlazaSvrPB$SignalPublishRsp.mergeFrom((byte[]) obj);
                        QLog.d("QQStrangerSignalPublishRepository", 1, "[requestPublishSignal] response: cmd=" + str + " isSuccess=" + z16 + " retCodee=" + signalPlazaSvrPB$SignalPublishRsp.ret_code.get() + ", retMsg=" + signalPlazaSvrPB$SignalPublishRsp.ret_msg.get());
                        cancellableContinuationImpl.resume(new QQStrangerSignalPublishRepository.b<>(true, signalPlazaSvrPB$SignalPublishRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestPublishSignal$2$2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerSignalPublishRepository", 1, "[requestPublishSignal] resume exception: ", it);
                            }
                        });
                        return;
                    }
                    QLog.d("QQStrangerSignalPublishRepository", 1, "[requestPublishSignal] response: cmd=" + str + " isSuccess=" + z16 + " data=" + obj);
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    cancellableContinuationImpl.resume(new QQStrangerSignalPublishRepository.b<>(false, defaultConstructorMarker, 2, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestPublishSignal$2$2.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            QLog.d("QQStrangerSignalPublishRepository", 1, "[requestPublishSignal] resume exception: ", it);
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object j(Continuation<? super b<SignalPlazaSvrPB$GetSignalConfigRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
        if (aVar != null) {
            final String str = "QQStranger.SignalPlazaSvr.SsoGetSignalConfig";
            aVar.Z0("QQStranger.SignalPlazaSvr.SsoGetSignalConfig", new MessageMicro<SignalPlazaSvrPB$GetSignalConfigReq>() { // from class: com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetSignalConfigReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SignalPlazaSvrPB$GetSignalConfigReq.class);
            }.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestSignalConfigs$2$1
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    Object m476constructorimpl;
                    if (z16 && (obj instanceof byte[])) {
                        SignalPlazaSvrPB$GetSignalConfigRsp signalPlazaSvrPB$GetSignalConfigRsp = new SignalPlazaSvrPB$GetSignalConfigRsp();
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(signalPlazaSvrPB$GetSignalConfigRsp.mergeFrom((byte[]) obj));
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                            QLog.e("QQStrangerSignalPublishRepository", 1, "[requestSignalConfigs] mergeFrom error ", m479exceptionOrNullimpl);
                        }
                        QLog.d("QQStrangerSignalPublishRepository", 1, "[requestSignalConfigs] response: cmd=" + str + " isSuccess=" + z16 + " config size=" + signalPlazaSvrPB$GetSignalConfigRsp.signal_configs.size() + ", expire=" + signalPlazaSvrPB$GetSignalConfigRsp.signal_expire.get());
                        cancellableContinuationImpl.resume(new QQStrangerSignalPublishRepository.b<>(true, signalPlazaSvrPB$GetSignalConfigRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestSignalConfigs$2$1.3
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerSignalPublishRepository", 1, "[requestSignalConfigs] resume exception: ", it);
                            }
                        });
                        return;
                    }
                    QLog.d("QQStrangerSignalPublishRepository", 1, "[requestSignalConfigs] response: cmd=" + str + " isSuccess=" + z16 + " data=" + obj);
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    cancellableContinuationImpl.resume(new QQStrangerSignalPublishRepository.b<>(false, defaultConstructorMarker, 2, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestSignalConfigs$2$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                            invoke2(th6);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            QLog.d("QQStrangerSignalPublishRepository", 1, "[requestSignalConfigs] resume exception: ", it);
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Flow<b<SignalPlazaSvrPB$GetSignalConfigRsp>> k() {
        return FlowKt.flow(new QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1(this, null));
    }

    public final Flow<QQStrangerSignalPublishResult> f(SignalPB$SignalConfig signalConfig, long partnerAdjID) {
        Intrinsics.checkNotNullParameter(signalConfig, "signalConfig");
        final Flow<b<SignalPlazaSvrPB$SignalPublishRsp>> g16 = g(signalConfig, partnerAdjID);
        return new Flow<QQStrangerSignalPublishResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$publishSignal$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerSignalPublishResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$publishSignal$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$SignalPublishRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244922d;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$publishSignal$$inlined$map$1$2", f = "QQStrangerSignalPublishRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$publishSignal$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f244922d = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$SignalPublishRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerSignalPublishResult qQStrangerSignalPublishResult;
                    PBStringField pBStringField;
                    PBUInt32Field pBUInt32Field;
                    PBStringField pBStringField2;
                    PBUInt32Field pBUInt32Field2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244922d;
                                QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$SignalPublishRsp> bVar2 = bVar;
                                if (bVar2.getIsSuccess() && bVar2.a() != null) {
                                    SignalPlazaSvrPB$SignalPublishRsp a16 = bVar2.a();
                                    String str = null;
                                    Integer boxInt = (a16 == null || (pBUInt32Field2 = a16.ret_code) == null) ? null : Boxing.boxInt(pBUInt32Field2.get());
                                    SignalPlazaSvrPB$SignalPublishRsp a17 = bVar2.a();
                                    QLog.d("QQStrangerSignalPublishRepository", 1, "[publishSignal] retCode=" + boxInt + ", retMsg=" + ((a17 == null || (pBStringField2 = a17.ret_msg) == null) ? null : pBStringField2.get()));
                                    SignalPlazaSvrPB$SignalPublishRsp a18 = bVar2.a();
                                    SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = a18 != null ? a18.signal_info : null;
                                    SignalPlazaSvrPB$SignalPublishRsp a19 = bVar2.a();
                                    int i17 = (a19 == null || (pBUInt32Field = a19.ret_code) == null) ? -1 : pBUInt32Field.get();
                                    SignalPlazaSvrPB$SignalPublishRsp a26 = bVar2.a();
                                    if (a26 != null && (pBStringField = a26.ret_msg) != null) {
                                        str = pBStringField.get();
                                    }
                                    if (str == null) {
                                        str = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str, "rspData.data?.ret_msg?.get() ?: \"\"");
                                    }
                                    qQStrangerSignalPublishResult = new QQStrangerSignalPublishResult(true, signalPlazaSvrPB$SignalInfo, i17, str);
                                } else {
                                    qQStrangerSignalPublishResult = new QQStrangerSignalPublishResult(false, null, 0, null, 14, null);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerSignalPublishResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
    }

    public final Flow<QQStrangerSignalConfigResult> h() {
        final Flow<b<SignalPlazaSvrPB$GetSignalConfigRsp>> k3 = k();
        return FlowKt.flattenConcat(FlowKt.flowOf((Object[]) new Flow[]{e(), new Flow<QQStrangerSignalConfigResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$refreshSignalConfigs$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerSignalConfigResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$refreshSignalConfigs$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$GetSignalConfigRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244925d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerSignalPublishRepository f244926e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$refreshSignalConfigs$$inlined$map$1$2", f = "QQStrangerSignalPublishRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$refreshSignalConfigs$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository) {
                    this.f244925d = flowCollector;
                    this.f244926e = qQStrangerSignalPublishRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$GetSignalConfigRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerSignalConfigResult qQStrangerSignalConfigResult;
                    QQStrangerSignalPublishCacheHelper d16;
                    PBUInt64Field pBUInt64Field;
                    PBRepeatMessageField<SignalPB$SignalConfig> pBRepeatMessageField;
                    PBRepeatMessageField<SignalPB$SignalConfig> pBRepeatMessageField2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244925d;
                                QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$GetSignalConfigRsp> bVar2 = bVar;
                                if (bVar2.getIsSuccess() && bVar2.a() != null) {
                                    d16 = this.f244926e.d();
                                    d16.e(bVar2.a());
                                    SignalPlazaSvrPB$GetSignalConfigRsp a16 = bVar2.a();
                                    QLog.d("QQStrangerSignalPublishRepository", 1, "[refreshSignalConfigs] signalConfigSize=" + ((a16 == null || (pBRepeatMessageField2 = a16.signal_configs) == null) ? 0 : pBRepeatMessageField2.size()));
                                    SignalPlazaSvrPB$GetSignalConfigRsp a17 = bVar2.a();
                                    List<SignalPB$SignalConfig> list = (a17 == null || (pBRepeatMessageField = a17.signal_configs) == null) ? null : pBRepeatMessageField.get();
                                    if (list == null) {
                                        list = CollectionsKt__CollectionsKt.emptyList();
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(list, "rspData.data?.signal_configs?.get() ?: emptyList()");
                                    }
                                    SignalPlazaSvrPB$GetSignalConfigRsp a18 = bVar2.a();
                                    qQStrangerSignalConfigResult = new QQStrangerSignalConfigResult(true, list, (a18 == null || (pBUInt64Field = a18.signal_expire) == null) ? 0L : pBUInt64Field.get());
                                } else {
                                    qQStrangerSignalConfigResult = new QQStrangerSignalConfigResult(false, null, 0L, 6, null);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerSignalConfigResult, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        }}));
    }
}
