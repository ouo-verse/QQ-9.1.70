package com.tencent.mobileqq.matchfriend.reborn.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyReq;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/QQStrangerCommonProxyRequest;", "", "", "appId", "", "service", "method", "", "bizBuffer", "Lcom/tencent/trpcprotocol/qqstranger/common_proxy/common_proxy/CommonProxyPB$ProxyRsp;", "a", "(ILjava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerCommonProxyRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerCommonProxyRequest f245454a = new QQStrangerCommonProxyRequest();

    QQStrangerCommonProxyRequest() {
    }

    public final Object a(int i3, String str, final String str2, byte[] bArr, Continuation<? super CommonProxyPB$ProxyRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerCommonProxyRequest", 1, "[proxyRequest] network is not available");
            cancellableContinuationImpl.resume(null, null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
            QLog.d("QQStrangerCommonProxyRequest", 1, "[proxyRequest] request: service=" + str + " method=" + str2);
            if (aVar != null) {
                CommonProxyPB$ProxyReq commonProxyPB$ProxyReq = new CommonProxyPB$ProxyReq();
                commonProxyPB$ProxyReq.service.set(str);
                commonProxyPB$ProxyReq.method.set(str2);
                commonProxyPB$ProxyReq.appid.set(i3);
                commonProxyPB$ProxyReq.biz_buf.set(ByteStringMicro.copyFrom(bArr));
                Unit unit = Unit.INSTANCE;
                aVar.Z0("trpc.qqstranger.common_proxy.CommonProxy.SsoHandle", commonProxyPB$ProxyReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest$proxyRequest$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i16, boolean z16, Object obj) {
                        if (z16 && (obj instanceof byte[])) {
                            CommonProxyPB$ProxyRsp commonProxyPB$ProxyRsp = new CommonProxyPB$ProxyRsp();
                            try {
                                commonProxyPB$ProxyRsp.mergeFrom((byte[]) obj);
                            } catch (Exception e16) {
                                QLog.e("QQStrangerCommonProxyRequest", 1, "[proxyRequest] mergeFrom error ", e16);
                            }
                            QLog.d("QQStrangerCommonProxyRequest", 1, "[proxyRequest] response: method=" + str2 + " ret_code=" + commonProxyPB$ProxyRsp.ret_code.get() + " ret_msg=" + commonProxyPB$ProxyRsp.ret_msg.get());
                            cancellableContinuationImpl.resume(commonProxyPB$ProxyRsp, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest$proxyRequest$2$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerCommonProxyRequest", 1, "[proxyRequest] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.e("QQStrangerCommonProxyRequest", 1, "[proxyRequest] response: method=" + str2 + " isSuccess=" + z16 + " data=" + obj);
                        cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerCommonProxyRequest$proxyRequest$2$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerCommonProxyRequest", 1, "[proxyRequest] resume exception: ", it);
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
}
