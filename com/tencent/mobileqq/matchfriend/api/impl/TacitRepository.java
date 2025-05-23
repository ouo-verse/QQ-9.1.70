package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.impl.TacitRepository;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$CommonSendInterMsgReq;
import com.tencent.trpcprotocol.kuolie.interactivemsg.interactive_msg_service.InteractiveMsgServicePB$CommonSendInterMsgRsp;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyReq;
import com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.CommonProxyPB$ProxyRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\f0\tH\u0002J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/TacitRepository;", "", "", "service", "method", "", "appId", "", "bizBuffer", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/matchfriend/api/impl/TacitRepository$b;", "Lcom/tencent/trpcprotocol/qqstranger/common_proxy/common_proxy/CommonProxyPB$ProxyRsp;", "", "callback", "b", "accountId", "d", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TacitRepository {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0004\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/TacitRepository$b;", "T", "", "", "a", "Z", "b", "()Z", "isSuccess", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ZLjava/lang/Object;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private final void b(String service, final String method, int appId, byte[] bizBuffer, final Function1<? super b<CommonProxyPB$ProxyRsp>, Unit> callback) {
        boolean z16 = false;
        boolean z17 = false;
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("TacitRepository", 1, "[proxyRequest] network is not available");
            callback.invoke(new b(false, z17 ? 1 : 0, 2, z16 ? 1 : 0));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        com.tencent.relation.common.servlet.a businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? businessHandler : null;
        QLog.d("TacitRepository", 1, "[proxyRequest] request: service=" + service + " method=" + method);
        if (aVar != null) {
            CommonProxyPB$ProxyReq commonProxyPB$ProxyReq = new CommonProxyPB$ProxyReq();
            commonProxyPB$ProxyReq.service.set(service);
            commonProxyPB$ProxyReq.method.set(method);
            commonProxyPB$ProxyReq.appid.set(appId);
            commonProxyPB$ProxyReq.biz_buf.set(ByteStringMicro.copyFrom(bizBuffer));
            Unit unit = Unit.INSTANCE;
            aVar.Z0("trpc.qqstranger.common_proxy.CommonProxy.SsoHandle", commonProxyPB$ProxyReq.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.api.impl.i
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z18, Object obj) {
                    TacitRepository.c(Function1.this, method, i3, z18, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 callback, String method, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(method, "$method");
        if (z16 && (obj instanceof byte[])) {
            try {
                callback.invoke(new b(true, new CommonProxyPB$ProxyRsp().mergeFrom((byte[]) obj)));
                return;
            } catch (Exception e16) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                callback.invoke(new b(false, defaultConstructorMarker, 2, defaultConstructorMarker));
                QLog.e("TacitRepository", 1, "[proxyRequest] mergeFrom error ", e16);
                return;
            }
        }
        QLog.e("TacitRepository", 1, "[proxyRequest] response: method=" + method + " isSuccess=" + z16 + " data=" + obj);
        QLog.d("TacitRepository", 1, "[proxyRequest] resume exception: ");
    }

    public final void d(String accountId, int appId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        QLog.d("TacitRepository", 1, "[sendGrayMsg] request: accountId=" + accountId + " appId=" + appId);
        InteractiveMsgServicePB$CommonSendInterMsgReq interactiveMsgServicePB$CommonSendInterMsgReq = new InteractiveMsgServicePB$CommonSendInterMsgReq();
        interactiveMsgServicePB$CommonSendInterMsgReq.peer_tiny_id.set(Long.parseLong(accountId));
        interactiveMsgServicePB$CommonSendInterMsgReq.scene_id.set(3);
        Unit unit = Unit.INSTANCE;
        byte[] byteArray = interactiveMsgServicePB$CommonSendInterMsgReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "CommonSendInterMsgReq().\u2026          }.toByteArray()");
        b("QQStranger.InteractiveMsgSvr", "SsoCommonSendInterMsg", appId, byteArray, new Function1<b<CommonProxyPB$ProxyRsp>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.api.impl.TacitRepository$sendGrayMsg$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TacitRepository.b<CommonProxyPB$ProxyRsp> bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TacitRepository.b<CommonProxyPB$ProxyRsp> rspData) {
                Intrinsics.checkNotNullParameter(rspData, "rspData");
                if (rspData.getIsSuccess()) {
                    CommonProxyPB$ProxyRsp a16 = rspData.a();
                    if ((a16 != null ? a16.biz_buf : null) != null) {
                        InteractiveMsgServicePB$CommonSendInterMsgRsp interactiveMsgServicePB$CommonSendInterMsgRsp = new InteractiveMsgServicePB$CommonSendInterMsgRsp();
                        try {
                            interactiveMsgServicePB$CommonSendInterMsgRsp.mergeFrom(rspData.a().biz_buf.get().toByteArray());
                        } catch (Exception e16) {
                            QLog.e("TacitRepository", 1, "[CommonSendInterMsg] mergeFrom error ", e16);
                        }
                        QLog.d("TacitRepository", 1, "[CommonSendInterMsg] response: rsp_head=" + interactiveMsgServicePB$CommonSendInterMsgRsp.rsp_head.get());
                    }
                }
            }
        });
    }
}
