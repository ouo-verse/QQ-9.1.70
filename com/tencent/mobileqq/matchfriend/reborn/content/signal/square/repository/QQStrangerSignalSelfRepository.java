package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetUserSignalReq;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetUserSignalRsp;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\n\u001a\u00020\bR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfRepository;", "", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$GetUserSignalRsp;", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "loadCacheFirst", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "d", "signalInfo", "", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfCacheHelper;", "a", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSelfCacheHelper;", "cacheHelper", "<init>", "()V", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSelfRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheHelper;

    public QQStrangerSignalSelfRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalSelfCacheHelper>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$cacheHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalSelfCacheHelper invoke() {
                return new QQStrangerSignalSelfCacheHelper();
            }
        });
        this.cacheHelper = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSignalSelfCacheHelper c() {
        return (QQStrangerSignalSelfCacheHelper) this.cacheHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e(Continuation<? super SignalPlazaSvrPB$GetUserSignalRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[requestSelfSignalInfo] request: cmd=");
        final String str = "QQStranger.SignalPlazaSvr.SsoGetUserSignal";
        sb5.append("QQStranger.SignalPlazaSvr.SsoGetUserSignal");
        QLog.d("QQStrangerSignalSelfRepository", 2, sb5.toString());
        if (aVar != null) {
            aVar.Z0("QQStranger.SignalPlazaSvr.SsoGetUserSignal", new MessageMicro<SignalPlazaSvrPB$GetUserSignalReq>() { // from class: com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetUserSignalReq
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SignalPlazaSvrPB$GetUserSignalReq.class);
            }.toByteArray(), new b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$requestSelfSignalInfo$2$1
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    Object m476constructorimpl;
                    if (z16 && (obj instanceof byte[])) {
                        SignalPlazaSvrPB$GetUserSignalRsp signalPlazaSvrPB$GetUserSignalRsp = new SignalPlazaSvrPB$GetUserSignalRsp();
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(signalPlazaSvrPB$GetUserSignalRsp.mergeFrom((byte[]) obj));
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                            QLog.e("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] mergeFrom error ", m479exceptionOrNullimpl);
                        }
                        if (signalPlazaSvrPB$GetUserSignalRsp.ret_code.get() == 10002) {
                            cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$requestSelfSignalInfo$2$1.3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                    invoke2(th6);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.d("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] response: cmd=" + str + " isSuccess=" + z16 + " ret_code=" + signalPlazaSvrPB$GetUserSignalRsp.ret_code.get() + " ret_msg=" + signalPlazaSvrPB$GetUserSignalRsp.ret_msg.get());
                        cancellableContinuationImpl.resume(signalPlazaSvrPB$GetUserSignalRsp, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$requestSelfSignalInfo$2$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] resume exception: ", it);
                            }
                        });
                        return;
                    }
                    QLog.d("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] response: cmd=" + str + " isSuccess=" + z16 + " data=" + obj);
                    cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$requestSelfSignalInfo$2$1.5
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                            invoke2(th6);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            QLog.d("QQStrangerSignalSelfRepository", 1, "[requestSelfSignalInfo] resume exception: ", it);
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

    public final Flow<SignalPlazaSvrPB$SignalInfo> d(boolean loadCacheFirst) {
        return FlowKt.flow(new QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1(loadCacheFirst, this, null));
    }

    public final Flow<Unit> f(SignalPlazaSvrPB$SignalInfo signalInfo) {
        Intrinsics.checkNotNullParameter(signalInfo, "signalInfo");
        return FlowKt.flow(new QQStrangerSignalSelfRepository$updateSelfSignalInfo$1(this, signalInfo, null));
    }
}
