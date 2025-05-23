package com.qzone.reborn.part.publish.fakefeed;

import com.qzone.reborn.intimate.request.QZoneIntimateGetFeedDetailRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import qzone.QZIntimateSpaceReader$GetFeedDetailRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J%\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\fJa\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2(\u0010\u0012\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/part/publish/fakefeed/QZoneGetFakeFeedFeature;", "", "", "g", "i", "", h.F, "", "feedId", WadlProxyConsts.CREATE_TIME, "Lqzone/QZIntimateSpaceReader$GetFeedDetailRsp;", "f", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "T", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "predicate", "Lkotlin/Function1;", "block", "j", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "I", "checkFeedCount", "<init>", "()V", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneGetFakeFeedFeature {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int checkFeedCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\n2\u000e\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\f0\fH\n\u00a2\u0006\u0002\b\r"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "isSuccess", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZoneIntimateGetFeedDetailRequest f58627a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<QZIntimateSpaceReader$GetFeedDetailRsp> f58628b;

        /* JADX WARN: Multi-variable type inference failed */
        b(QZoneIntimateGetFeedDetailRequest qZoneIntimateGetFeedDetailRequest, CancellableContinuation<? super QZIntimateSpaceReader$GetFeedDetailRsp> cancellableContinuation) {
            this.f58627a = qZoneIntimateGetFeedDetailRequest;
            this.f58628b = cancellableContinuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            QLog.i("upload2-QZoneGetFakeFeedFeature", 1, "[doCheckFeedDetail][onReceive] isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str + ", traceId: " + this.f58627a.getTraceId());
            if (this.f58628b.isActive()) {
                if (z16 && j3 == 0) {
                    this.f58628b.resumeWith(Result.m476constructorimpl(obj instanceof QZIntimateSpaceReader$GetFeedDetailRsp ? (QZIntimateSpaceReader$GetFeedDetailRsp) obj : null));
                } else {
                    this.f58628b.resumeWith(Result.m476constructorimpl(null));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(String str, long j3, Continuation<? super QZIntimateSpaceReader$GetFeedDetailRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QZoneIntimateGetFeedDetailRequest qZoneIntimateGetFeedDetailRequest = new QZoneIntimateGetFeedDetailRequest(str);
        VSNetworkHelper.getInstance().sendRequest(qZoneIntimateGetFeedDetailRequest, new b(qZoneIntimateGetFeedDetailRequest, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long g() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_GET_REAL_FEED_DELAY, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_GET_REAL_FEED_MAX_RETRY_COUNT, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long i() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_INTIMATE_SPACE, QzoneConfig.SECONDARY_KEY_INTIMATE_GET_REAL_FEED_RETRY_DELAY, 3000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0093 -> B:11:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object j(Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        QZoneGetFakeFeedFeature$retryWithResult$1 qZoneGetFakeFeedFeature$retryWithResult$1;
        Object coroutine_suspended;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function32;
        Function1<? super Continuation<? super T>, ? extends Object> function12;
        Object invoke;
        Object invoke2;
        boolean z16;
        if (continuation instanceof QZoneGetFakeFeedFeature$retryWithResult$1) {
            qZoneGetFakeFeedFeature$retryWithResult$1 = (QZoneGetFakeFeedFeature$retryWithResult$1) continuation;
            int i26 = qZoneGetFakeFeedFeature$retryWithResult$1.label;
            if ((i26 & Integer.MIN_VALUE) != 0) {
                qZoneGetFakeFeedFeature$retryWithResult$1.label = i26 - Integer.MIN_VALUE;
                Object obj = qZoneGetFakeFeedFeature$retryWithResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qZoneGetFakeFeedFeature$retryWithResult$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    i16 = 10;
                    i17 = 0;
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$0 = function3;
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$1 = function1;
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$2 = null;
                    qZoneGetFakeFeedFeature$retryWithResult$1.I$0 = i17;
                    qZoneGetFakeFeedFeature$retryWithResult$1.I$1 = i16;
                    qZoneGetFakeFeedFeature$retryWithResult$1.label = 1;
                    invoke2 = function1.invoke(qZoneGetFakeFeedFeature$retryWithResult$1);
                    if (invoke2 != coroutine_suspended) {
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            int i27 = qZoneGetFakeFeedFeature$retryWithResult$1.I$1;
                            i18 = qZoneGetFakeFeedFeature$retryWithResult$1.I$0;
                            Object obj2 = qZoneGetFakeFeedFeature$retryWithResult$1.L$2;
                            Function1<? super Continuation<? super T>, ? extends Object> function13 = (Function1) qZoneGetFakeFeedFeature$retryWithResult$1.L$1;
                            Function3<? super Integer, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function33 = (Function3) qZoneGetFakeFeedFeature$retryWithResult$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            QZoneGetFakeFeedFeature$retryWithResult$1 qZoneGetFakeFeedFeature$retryWithResult$12 = qZoneGetFakeFeedFeature$retryWithResult$1;
                            int i28 = i27;
                            function3 = function33;
                            Object obj3 = obj2;
                            function12 = function13;
                            Object obj4 = coroutine_suspended;
                            QZoneGetFakeFeedFeature$retryWithResult$1 qZoneGetFakeFeedFeature$retryWithResult$13 = qZoneGetFakeFeedFeature$retryWithResult$12;
                            if (((Boolean) obj).booleanValue()) {
                                z16 = false;
                            } else {
                                QLog.d("upload2-QZoneGetFakeFeedFeature-retryWithResult", 1, "attempt=" + i18 + ", result=" + obj3);
                                i18++;
                                z16 = true;
                            }
                            if (z16 || i18 >= i28) {
                                return obj3;
                            }
                            i16 = i28;
                            qZoneGetFakeFeedFeature$retryWithResult$1 = qZoneGetFakeFeedFeature$retryWithResult$13;
                            coroutine_suspended = obj4;
                            Function1<? super Continuation<? super T>, ? extends Object> function14 = function12;
                            i17 = i18;
                            function1 = function14;
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$0 = function3;
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$1 = function1;
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$2 = null;
                            qZoneGetFakeFeedFeature$retryWithResult$1.I$0 = i17;
                            qZoneGetFakeFeedFeature$retryWithResult$1.I$1 = i16;
                            qZoneGetFakeFeedFeature$retryWithResult$1.label = 1;
                            invoke2 = function1.invoke(qZoneGetFakeFeedFeature$retryWithResult$1);
                            if (invoke2 != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function32 = function3;
                            i19 = i16;
                            obj = invoke2;
                            int i29 = i17;
                            function12 = function1;
                            i18 = i29;
                            Integer boxInt = Boxing.boxInt(i18);
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$0 = function32;
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$1 = function12;
                            qZoneGetFakeFeedFeature$retryWithResult$1.L$2 = obj;
                            qZoneGetFakeFeedFeature$retryWithResult$1.I$0 = i18;
                            qZoneGetFakeFeedFeature$retryWithResult$1.I$1 = i19;
                            qZoneGetFakeFeedFeature$retryWithResult$1.label = 2;
                            invoke = function32.invoke(boxInt, obj, qZoneGetFakeFeedFeature$retryWithResult$1);
                            if (invoke != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            QZoneGetFakeFeedFeature$retryWithResult$1 qZoneGetFakeFeedFeature$retryWithResult$14 = qZoneGetFakeFeedFeature$retryWithResult$1;
                            i28 = i19;
                            function3 = function32;
                            obj4 = coroutine_suspended;
                            qZoneGetFakeFeedFeature$retryWithResult$13 = qZoneGetFakeFeedFeature$retryWithResult$14;
                            obj3 = obj;
                            obj = invoke;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            if (z16) {
                            }
                            return obj3;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i19 = qZoneGetFakeFeedFeature$retryWithResult$1.I$1;
                    i18 = qZoneGetFakeFeedFeature$retryWithResult$1.I$0;
                    function12 = (Function1) qZoneGetFakeFeedFeature$retryWithResult$1.L$1;
                    function32 = (Function3) qZoneGetFakeFeedFeature$retryWithResult$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    Integer boxInt2 = Boxing.boxInt(i18);
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$0 = function32;
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$1 = function12;
                    qZoneGetFakeFeedFeature$retryWithResult$1.L$2 = obj;
                    qZoneGetFakeFeedFeature$retryWithResult$1.I$0 = i18;
                    qZoneGetFakeFeedFeature$retryWithResult$1.I$1 = i19;
                    qZoneGetFakeFeedFeature$retryWithResult$1.label = 2;
                    invoke = function32.invoke(boxInt2, obj, qZoneGetFakeFeedFeature$retryWithResult$1);
                    if (invoke != coroutine_suspended) {
                    }
                }
            }
        }
        qZoneGetFakeFeedFeature$retryWithResult$1 = new QZoneGetFakeFeedFeature$retryWithResult$1(this, continuation);
        Object obj5 = qZoneGetFakeFeedFeature$retryWithResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qZoneGetFakeFeedFeature$retryWithResult$1.label;
        if (i3 != 0) {
        }
    }

    public final Object k(String str, long j3, Continuation<? super QZIntimateSpaceReader$GetFeedDetailRsp> continuation) {
        QLog.i("upload2-QZoneGetFakeFeedFeature", 1, "[tryCheckFeedComplete]");
        this.checkFeedCount = 0;
        return j(new QZoneGetFakeFeedFeature$tryCheckFeedComplete$2(this, null), new QZoneGetFakeFeedFeature$tryCheckFeedComplete$3(this, str, j3, null), continuation);
    }
}
