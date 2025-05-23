package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.cache.QzoneProtocolCacheManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.IQZAegisListener;
import com.tencent.hippykotlin.demo.pages.qzone.data.QZoneDataExtKt;
import com.tencent.hippykotlin.demo.pages.qzone.net.QZoneBaseRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kuikly.NS_QWEB_PROTOCAL.d;
import oicq.wlogin_sdk.tools.util;
import zz0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b'\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JQ\u0010\u0012\u001a\u00020\u0007\"\b\b\u0000\u0010\n*\u00020\t\"\b\b\u0001\u0010\u000b*\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014J\b\u0010\u0017\u001a\u00020\u0002H&R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/service/QzoneBaseService;", "", "", "generateTraceId", "cacheKey", "", "byteArr", "", "saveRspCache", "Lc45/e;", "BusiReq", "BusiRsp", "Lcom/tencent/hippykotlin/demo/pages/qzone/net/QZoneBaseRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "dataCallback", "sendQzoneRequest$qecommerce_biz_release", "(Lcom/tencent/hippykotlin/demo/pages/qzone/net/QZoneBaseRequest;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;Ljava/lang/String;)V", "sendQzoneRequest", "loadRspCache", "Lkotlin/Function0;", "task", "runOnUIThread", "getLogTag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "aegisListener", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "getAegisListener", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;", "setAegisListener", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/IQZAegisListener;)V", "<init>", "()V", "Companion", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QzoneBaseService {
    public static final long ERROR_CODE_CLIENT_PARAMS_ERROR = -1024;
    public static final long ERROR_CODE_NO_ANY_DATA = -250411;
    public static final String ERROR_MSG_NO_ANY_DATA = "fatal error, no any data!";
    public static final String LOG_PREFIX = "qz_request_";
    private IQZAegisListener aegisListener;
    public static final int $stable = 8;

    private final String generateTraceId() {
        return QQKuiklyPlatformApi.Companion.getUin() + util.base64_pad_url + a.f453719a.a() + util.base64_pad_url + Random.INSTANCE.nextInt(10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveRspCache(String cacheKey, byte[] byteArr) {
        try {
            a aVar = a.f453719a;
            long a16 = aVar.a();
            KLog kLog = KLog.INSTANCE;
            kLog.d(LOG_PREFIX + getLogTag(), "start saveRspCache, cacheKey: " + cacheKey + ", byteArr size: " + byteArr.length);
            ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).e(cacheKey, byteArr);
            long a17 = aVar.a() - a16;
            kLog.d(LOG_PREFIX + getLogTag(), "saveRspCache success, cacheKey: " + cacheKey + ", byteArr size: " + byteArr.length + ", costTime: " + a17 + "ms");
        } catch (Throwable th5) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(LOG_PREFIX);
            m3.append(getLogTag());
            String sb5 = m3.toString();
            StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("saveRspCache failed, cacheKey: ", cacheKey, ", error: ");
            m16.append(th5.getMessage());
            kLog2.e(sb5, m16.toString());
        }
    }

    public final IQZAegisListener getAegisListener() {
        return this.aegisListener;
    }

    public abstract String getLogTag();

    public final byte[] loadRspCache(String cacheKey) {
        try {
            a aVar = a.f453719a;
            long a16 = aVar.a();
            KLog kLog = KLog.INSTANCE;
            kLog.d(LOG_PREFIX + getLogTag(), "start loadRspCache, cacheKey: " + cacheKey);
            byte[] a17 = ((e) c.f117352a.g().acquireModule("KRDiskCacheModule")).a(cacheKey);
            long a18 = aVar.a() - a16;
            if (a17 != null) {
                kLog.d(LOG_PREFIX + getLogTag(), "loadRspCache success, cacheKey: " + cacheKey + ", byteArr size: " + a17.length + ", costTime: " + a18 + "ms");
            } else {
                kLog.d(LOG_PREFIX + getLogTag(), "loadRspCache not found, cacheKey: " + cacheKey + ", costTime: " + a18 + "ms");
            }
            return a17;
        } catch (Throwable th5) {
            KLog kLog2 = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(LOG_PREFIX);
            m3.append(getLogTag());
            String sb5 = m3.toString();
            StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("loadRspCache failed, cacheKey: ", cacheKey, ", error: ");
            m16.append(th5.getMessage());
            kLog2.e(sb5, m16.toString());
            return null;
        }
    }

    public final void runOnUIThread(final Function0<Unit> task) {
        if (c.f117352a.n(BridgeManager.f117344a.u())) {
            com.tencent.kuikly.core.kmp.a.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$runOnUIThread$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    task.invoke();
                }
            });
        } else {
            com.tencent.kuikly.core.kmp.a.b(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$runOnUIThread$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    task.invoke();
                }
            });
        }
    }

    public final <BusiReq extends c45.e, BusiRsp extends c45.e> void sendQzoneRequest$qecommerce_biz_release(final QZoneBaseRequest<BusiReq, BusiRsp> request, final DataCallback<BusiRsp> dataCallback, final String cacheKey) {
        String generateTraceId = generateTraceId();
        request.setTraceId(generateTraceId);
        IQZAegisListener iQZAegisListener = this.aegisListener;
        if (iQZAegisListener != null) {
            iQZAegisListener.onBeforeRequest(request);
        }
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(request, generateTraceId, new Function1<PbResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$sendQzoneRequest$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lc45/e;", "BusiReq", "BusiRsp", "", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            /* renamed from: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$sendQzoneRequest$1$5, reason: invalid class name */
            /* loaded from: classes37.dex */
            public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ DataCallback<BusiRsp> $dataCallback;
                public final /* synthetic */ QZoneBaseRequest<BusiReq, BusiRsp> $request;
                public final /* synthetic */ QzoneBaseService this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass5(QzoneBaseService qzoneBaseService, QZoneBaseRequest<BusiReq, BusiRsp> qZoneBaseRequest, DataCallback<BusiRsp> dataCallback) {
                    super(0);
                    this.this$0 = qzoneBaseService;
                    this.$request = qZoneBaseRequest;
                    this.$dataCallback = dataCallback;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                    m3.append(this.this$0.getLogTag());
                    String sb5 = m3.toString();
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest fail, no any data, code: -250411, msg: fatal error, no any data!, cmd: ");
                    m16.append(this.$request.getCmd());
                    m16.append(", traceId: ");
                    m16.append(this.$request.getTraceId());
                    m16.append(", req seq: ");
                    m16.append(this.$request.getRequest().f413147d);
                    kLog.d(sb5, m16.toString());
                    this.$dataCallback.onFailure(QzoneBaseService.ERROR_CODE_NO_ANY_DATA, QzoneBaseService.ERROR_MSG_NO_ANY_DATA);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PbResponse<d> pbResponse) {
                invoke2(pbResponse);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v17, types: [c45.e, T] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final PbResponse<d> pbResponse) {
                boolean z16;
                c45.a aVar;
                final d dVar = pbResponse.rsp;
                IQZAegisListener aegisListener = QzoneBaseService.this.getAegisListener();
                if (aegisListener != null) {
                    aegisListener.onBeforeResponse(pbResponse);
                }
                if (!(dVar != null && dVar.f413155e == null)) {
                    if (dVar != null) {
                        final QzoneBaseService qzoneBaseService = QzoneBaseService.this;
                        final QZoneBaseRequest<BusiReq, BusiRsp> qZoneBaseRequest = request;
                        final DataCallback<BusiRsp> dataCallback2 = dataCallback;
                        qzoneBaseService.runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$sendQzoneRequest$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                Long l3;
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                                m3.append(QzoneBaseService.this.getLogTag());
                                String sb5 = m3.toString();
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest fail, qWebRsp info, code: ");
                                d dVar2 = dVar;
                                m16.append(dVar2 != null ? dVar2.f413155e : null);
                                m16.append(", msg: ");
                                m16.append(QZoneDataExtKt.getErrorMsg(dVar));
                                m16.append(", cmd: ");
                                m16.append(qZoneBaseRequest.getCmd());
                                m16.append(", traceId: ");
                                m16.append(qZoneBaseRequest.getTraceId());
                                m16.append(", seq: ");
                                d dVar3 = dVar;
                                m16.append(dVar3 != null ? dVar3.f413154d : null);
                                kLog.d(sb5, m16.toString());
                                DataCallback<BusiRsp> dataCallback3 = dataCallback2;
                                d dVar4 = dVar;
                                dataCallback3.onFailure((dVar4 == null || (l3 = dVar4.f413155e) == null) ? 0L : l3.longValue(), QZoneDataExtKt.getErrorMsg(dVar));
                            }
                        });
                        return;
                    }
                    final QzoneBaseService qzoneBaseService2 = QzoneBaseService.this;
                    final QZoneBaseRequest<BusiReq, BusiRsp> qZoneBaseRequest2 = request;
                    final DataCallback<BusiRsp> dataCallback3 = dataCallback;
                    qzoneBaseService2.runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$sendQzoneRequest$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                            m3.append(QzoneBaseService.this.getLogTag());
                            String sb5 = m3.toString();
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest fail, rsp info, code: ");
                            m16.append(pbResponse.code);
                            m16.append(", msg: ");
                            m16.append(pbResponse.f114187msg);
                            m16.append(", cmd: ");
                            m16.append(qZoneBaseRequest2.getCmd());
                            m16.append(", traceId: ");
                            m16.append(qZoneBaseRequest2.getTraceId());
                            m16.append(", req seq: ");
                            m16.append(qZoneBaseRequest2.getRequest().f413147d);
                            kLog.d(sb5, m16.toString());
                            dataCallback3.onFailure(r1.code, pbResponse.f114187msg);
                        }
                    });
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                byte[] bArr = (dVar == null || (aVar = dVar.f413157h) == null) ? null : aVar.f30291a;
                if (bArr != null) {
                    objectRef.element = request.decodeBusiRsp(bArr);
                }
                final QzoneBaseService qzoneBaseService3 = QzoneBaseService.this;
                final QZoneBaseRequest<BusiReq, BusiRsp> qZoneBaseRequest3 = request;
                final DataCallback<BusiRsp> dataCallback4 = dataCallback;
                qzoneBaseService3.runOnUIThread(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService$sendQzoneRequest$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Long l3;
                        Long l16;
                        long j3 = 0;
                        if (objectRef.element != 0) {
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                            m3.append(qzoneBaseService3.getLogTag());
                            String sb5 = m3.toString();
                            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest success, cmd: ");
                            m16.append(qZoneBaseRequest3.getCmd());
                            m16.append(", traceId: ");
                            m16.append(qZoneBaseRequest3.getTraceId());
                            m16.append(", seq: ");
                            d dVar2 = dVar;
                            m16.append(dVar2 != null ? dVar2.f413154d : null);
                            m16.append(", busiRsp: ");
                            BasePbRequest basePbRequest = qZoneBaseRequest3;
                            T t16 = objectRef.element;
                            Intrinsics.checkNotNull(t16);
                            basePbRequest.getClass();
                            m16.append(((c45.e) t16).toString());
                            kLog.d(sb5, m16.toString());
                            DataCallback<BusiRsp> dataCallback5 = dataCallback4;
                            T t17 = objectRef.element;
                            Intrinsics.checkNotNull(t17);
                            d dVar3 = dVar;
                            if (dVar3 != null && (l16 = dVar3.f413155e) != null) {
                                j3 = l16.longValue();
                            }
                            long j16 = j3;
                            String errorMsg = QZoneDataExtKt.getErrorMsg(dVar);
                            QZoneBaseRequest<BusiReq, BusiRsp> qZoneBaseRequest4 = qZoneBaseRequest3;
                            T t18 = objectRef.element;
                            Intrinsics.checkNotNull(t18);
                            dataCallback5.onSuccess(t17, j16, errorMsg, qZoneBaseRequest4.checkFinish((c45.e) t18));
                            return;
                        }
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(QzoneBaseService.LOG_PREFIX);
                        m17.append(qzoneBaseService3.getLogTag());
                        String sb6 = m17.toString();
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("doRequest finish but busiRsp is null, cmd: ");
                        m18.append(qZoneBaseRequest3.getCmd());
                        m18.append(", traceId: ");
                        m18.append(qZoneBaseRequest3.getTraceId());
                        m18.append(", seq: ");
                        d dVar4 = dVar;
                        m18.append(dVar4 != null ? dVar4.f413154d : null);
                        kLog2.d(sb6, m18.toString());
                        DataCallback<BusiRsp> dataCallback6 = dataCallback4;
                        d dVar5 = dVar;
                        if (dVar5 != null && (l3 = dVar5.f413155e) != null) {
                            j3 = l3.longValue();
                        }
                        dataCallback6.onFailure(j3, "rsp is null");
                    }
                });
                String str = cacheKey;
                if (str != null) {
                    if (str.length() > 0) {
                        z16 = true;
                        if (z16 || bArr == null) {
                        }
                        if (!(bArr.length == 0)) {
                            QzoneBaseService.this.saveRspCache(cacheKey, bArr);
                            QzoneProtocolCacheManager.INSTANCE.saveRspCache(cacheKey, bArr);
                            return;
                        }
                        return;
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        }, 4);
    }

    public final void setAegisListener(IQZAegisListener iQZAegisListener) {
        this.aegisListener = iQZAegisListener;
    }

    public static /* synthetic */ void sendQzoneRequest$qecommerce_biz_release$default(QzoneBaseService qzoneBaseService, QZoneBaseRequest qZoneBaseRequest, DataCallback dataCallback, String str, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                str = null;
            }
            qzoneBaseService.sendQzoneRequest$qecommerce_biz_release(qZoneBaseRequest, dataCallback, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendQzoneRequest");
    }
}
