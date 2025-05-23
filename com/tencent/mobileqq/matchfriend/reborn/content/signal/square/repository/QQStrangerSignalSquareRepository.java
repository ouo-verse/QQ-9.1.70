package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalRecommendReq;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalRecommendRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
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
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u0002\u0017\u001dB\u0007\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0013\u001a\u00020\u0005J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/a;", DomainData.DOMAIN_NAME, "", "partnerId", "", "refresh", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalRecommendRsp;", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "i", "p", "o", "timeMillis", ReportConstant.COSTREPORT_PREFIX, "k", "", "a", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "pageSize", "", "b", "Ljava/util/List;", "signalList", "", "c", "Ljava/lang/String;", "cookies", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareCacheHelper;", "d", "j", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareCacheHelper;", "cacheHelper", "Ljava/util/concurrent/locks/ReentrantLock;", "e", "l", "()Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "f", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy pageSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<SignalPlazaSvrPB$SignalInfo> signalList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String cookies;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy cacheHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy lock;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/QQStrangerSignalSquareRepository$b;", "T", "", "", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
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

    public QQStrangerSignalSquareRepository() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$pageSize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(b71.a.a(MobileQQ.sMobileQQ) ? 30 : 10);
            }
        });
        this.pageSize = lazy;
        this.signalList = new ArrayList();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalSquareCacheHelper>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$cacheHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalSquareCacheHelper invoke() {
                return new QQStrangerSignalSquareCacheHelper();
            }
        });
        this.cacheHelper = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ReentrantLock>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$lock$2
            @Override // kotlin.jvm.functions.Function0
            public final ReentrantLock invoke() {
                return new ReentrantLock();
            }
        });
        this.lock = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SignalPlazaSvrPB$SignalInfo> i() {
        return new ArrayList(this.signalList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerSignalSquareCacheHelper j() {
        return (QQStrangerSignalSquareCacheHelper) this.cacheHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReentrantLock l() {
        return (ReentrantLock) this.lock.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        return ((Number) this.pageSize.getValue()).intValue();
    }

    private final Flow<QQStrangerSignalInfoResult> n() {
        return FlowKt.flow(new QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object q(long j3, boolean z16, Continuation<? super b<SignalPlazaSvrPB$SignalRecommendRsp>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        boolean z17 = true;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        boolean z18 = false;
        boolean z19 = false;
        boolean z26 = false;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerSignalSquareRepository", 2, "[requestSignals] network is not available");
            cancellableContinuationImpl.resume(new b(z18, z26 ? 1 : 0, 2, z19 ? 1 : 0), null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            com.tencent.relation.common.servlet.a businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? businessHandler : null;
            if (aVar != null) {
                SignalPlazaSvrPB$SignalRecommendReq signalPlazaSvrPB$SignalRecommendReq = new SignalPlazaSvrPB$SignalRecommendReq();
                signalPlazaSvrPB$SignalRecommendReq.req_count.set(m());
                signalPlazaSvrPB$SignalRecommendReq.partner_id.set(j3);
                if (!z16) {
                    String str = this.cookies;
                    if (str != null && str.length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        signalPlazaSvrPB$SignalRecommendReq.cookies.set(this.cookies);
                    }
                }
                Unit unit = Unit.INSTANCE;
                final String str2 = "QQStranger.SignalPlazaSvr.SsoSignalRecommend";
                aVar.Z0("QQStranger.SignalPlazaSvr.SsoSignalRecommend", signalPlazaSvrPB$SignalRecommendReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$requestSignals$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i3, boolean z27, Object obj) {
                        Object m476constructorimpl;
                        if (z27 && (obj instanceof byte[])) {
                            SignalPlazaSvrPB$SignalRecommendRsp signalPlazaSvrPB$SignalRecommendRsp = new SignalPlazaSvrPB$SignalRecommendRsp();
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(signalPlazaSvrPB$SignalRecommendRsp.mergeFrom((byte[]) obj));
                            } catch (Throwable th5) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                            }
                            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                            if (m479exceptionOrNullimpl != null) {
                                QLog.e("QQStrangerSignalSquareRepository", 1, "[requestSignals] mergeFrom error ", m479exceptionOrNullimpl);
                            }
                            QLog.d("QQStrangerSignalSquareRepository", 1, "[requestSignals] response: cmd=" + str2 + " isSuccess=" + z27 + " end=" + signalPlazaSvrPB$SignalRecommendRsp.flag_end.get());
                            QQStrangerSignalSquareRepository.this.cookies = signalPlazaSvrPB$SignalRecommendRsp.cookies.get();
                            cancellableContinuationImpl.resume(new QQStrangerSignalSquareRepository.b<>(true, signalPlazaSvrPB$SignalRecommendRsp), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$requestSignals$2$2.3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                    invoke2(th6);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerSignalSquareRepository", 1, "[requestSignals] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.d("QQStrangerSignalSquareRepository", 1, "[requestSignals] response: cmd=" + str2 + " isSuccess=" + z27 + " data=" + obj);
                        DefaultConstructorMarker defaultConstructorMarker = null;
                        cancellableContinuationImpl.resume(new QQStrangerSignalSquareRepository.b<>(false, defaultConstructorMarker, 2, defaultConstructorMarker), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$requestSignals$2$2.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th6) {
                                invoke2(th6);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerSignalSquareRepository", 1, "[requestSignals] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final Flow<b<SignalPlazaSvrPB$SignalRecommendRsp>> r(long partnerId, boolean refresh) {
        return FlowKt.flow(new QQStrangerSignalSquareRepository$requestSignalsFlow$1(this, partnerId, refresh, null));
    }

    public final Flow<Long> k() {
        return FlowKt.flow(new QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1(this, null));
    }

    public final Flow<Boolean> s(long timeMillis) {
        return FlowKt.flow(new QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1(timeMillis, this, null));
    }

    public final Flow<QQStrangerSignalInfoResult> o(long partnerId) {
        final Flow<b<SignalPlazaSvrPB$SignalRecommendRsp>> r16 = r(partnerId, false);
        return new Flow<QQStrangerSignalInfoResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$loadMoreSignalInfos$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$loadMoreSignalInfos$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f244998d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerSignalSquareRepository f244999e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$loadMoreSignalInfos$$inlined$map$1$2", f = "QQStrangerSignalSquareRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$loadMoreSignalInfos$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository) {
                    this.f244998d = flowCollector;
                    this.f244999e = qQStrangerSignalSquareRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x007c A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:29:0x006b, B:31:0x0070, B:36:0x007c, B:37:0x0088), top: B:28:0x006b }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00cf A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    ReentrantLock l3;
                    boolean z16;
                    QQStrangerSignalInfoResult qQStrangerSignalInfoResult;
                    List i16;
                    List list;
                    PBUInt32Field pBUInt32Field;
                    PBRepeatMessageField<SignalPlazaSvrPB$SignalInfo> pBRepeatMessageField;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i17 = anonymousClass1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i17 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f244998d;
                                QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp> bVar2 = bVar;
                                SignalPlazaSvrPB$SignalRecommendRsp a16 = bVar2.a();
                                List<SignalPlazaSvrPB$SignalInfo> list2 = (a16 == null || (pBRepeatMessageField = a16.signal_infos) == null) ? null : pBRepeatMessageField.get();
                                SignalPlazaSvrPB$SignalRecommendRsp a17 = bVar2.a();
                                boolean z17 = (a17 == null || (pBUInt32Field = a17.flag_end) == null || pBUInt32Field.get() != 1) ? false : true;
                                l3 = this.f244999e.l();
                                l3.lock();
                                try {
                                    List<SignalPlazaSvrPB$SignalInfo> list3 = list2;
                                    if (list3 != null && !list3.isEmpty()) {
                                        z16 = false;
                                        if (!z16) {
                                            list = this.f244999e.signalList;
                                            list.addAll(list2);
                                        }
                                        Unit unit = Unit.INSTANCE;
                                        QLog.d("QQStrangerSignalSquareRepository", 1, "[loadMoreSignalInfos] moreSignalsSize=" + (list2 != null ? list2.size() : 0) + " noMore=" + z17);
                                        boolean isSuccess = bVar2.getIsSuccess();
                                        i16 = this.f244999e.i();
                                        qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(isSuccess, false, i16, z17, 2, null);
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(qQStrangerSignalInfoResult, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    z16 = true;
                                    if (!z16) {
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                    if (list2 != null) {
                                    }
                                    QLog.d("QQStrangerSignalSquareRepository", 1, "[loadMoreSignalInfos] moreSignalsSize=" + (list2 != null ? list2.size() : 0) + " noMore=" + z17);
                                    boolean isSuccess2 = bVar2.getIsSuccess();
                                    i16 = this.f244999e.i();
                                    qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(isSuccess2, false, i16, z17, 2, null);
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(qQStrangerSignalInfoResult, anonymousClass1) == coroutine_suspended) {
                                    }
                                } finally {
                                    l3.unlock();
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerSignalInfoResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Flow<QQStrangerSignalInfoResult> p(long partnerId) {
        final Flow<b<SignalPlazaSvrPB$SignalRecommendRsp>> r16 = r(partnerId, true);
        Flow<QQStrangerSignalInfoResult> flow = new Flow<QQStrangerSignalInfoResult>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$refreshSignalInfos$$inlined$map$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$refreshSignalInfos$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes33.dex */
            public static final class AnonymousClass2 implements FlowCollector<QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp>> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f245002d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQStrangerSignalSquareRepository f245003e;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$refreshSignalInfos$$inlined$map$1$2", f = "QQStrangerSignalSquareRepository.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$refreshSignalInfos$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository) {
                    this.f245002d = flowCollector;
                    this.f245003e = qQStrangerSignalSquareRepository;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp> bVar, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    QQStrangerSignalInfoResult qQStrangerSignalInfoResult;
                    QQStrangerSignalSquareCacheHelper j3;
                    ReentrantLock l3;
                    List list;
                    List list2;
                    List i16;
                    PBUInt32Field pBUInt32Field;
                    PBRepeatMessageField<SignalPlazaSvrPB$SignalInfo> pBRepeatMessageField;
                    List<SignalPlazaSvrPB$SignalInfo> list3;
                    List list4;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i17 = anonymousClass1.label;
                        if ((i17 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i17 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 != 0) {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f245002d;
                                QQStrangerSignalSquareRepository.b<SignalPlazaSvrPB$SignalRecommendRsp> bVar2 = bVar;
                                if (bVar2.getIsSuccess() && bVar2.a() != null) {
                                    j3 = this.f245003e.j();
                                    j3.g(bVar2.a());
                                    l3 = this.f245003e.l();
                                    l3.lock();
                                    try {
                                        list = this.f245003e.signalList;
                                        list.clear();
                                        SignalPlazaSvrPB$SignalRecommendRsp a16 = bVar2.a();
                                        if (a16 != null && (pBRepeatMessageField = a16.signal_infos) != null && (list3 = pBRepeatMessageField.get()) != null) {
                                            Intrinsics.checkNotNullExpressionValue(list3, "get()");
                                            list4 = this.f245003e.signalList;
                                            Boxing.boxBoolean(list4.addAll(list3));
                                        }
                                        l3.unlock();
                                        SignalPlazaSvrPB$SignalRecommendRsp a17 = bVar2.a();
                                        boolean z16 = (a17 == null || (pBUInt32Field = a17.flag_end) == null || pBUInt32Field.get() != 1) ? false : true;
                                        list2 = this.f245003e.signalList;
                                        QLog.d("QQStrangerSignalSquareRepository", 1, "[refreshSignalInfos] signalListSize=" + list2.size() + " noMore=" + z16);
                                        i16 = this.f245003e.i();
                                        qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(true, false, i16, z16, 2, null);
                                    } catch (Throwable th5) {
                                        l3.unlock();
                                        throw th5;
                                    }
                                } else {
                                    qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(false, false, null, false, 14, null);
                                }
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(qQStrangerSignalInfoResult, anonymousClass1) == coroutine_suspended) {
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super QQStrangerSignalInfoResult> flowCollector, Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                return collect == coroutine_suspended ? collect : Unit.INSTANCE;
            }
        };
        return this.signalList.isEmpty() ? FlowKt.flattenConcat(FlowKt.flowOf((Object[]) new Flow[]{n(), flow})) : flow;
    }
}
