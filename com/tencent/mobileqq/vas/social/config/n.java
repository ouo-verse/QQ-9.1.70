package com.tencent.mobileqq.vas.social.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.api.INetworkDelegate;
import com.tencent.state.api.INetworkDelegateCallBack;
import com.tencent.state.api.SquareErrorData;
import e33.RspErrorData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016JD\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/n;", "Lcom/tencent/state/api/INetworkDelegate;", "", "service", "method", "", "reqData", "", "extData", "Lcom/tencent/state/api/INetworkDelegateCallBack;", "callBack", "", "sendVasProxyRequest", "", "source", "<init>", "()V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n implements INetworkDelegate {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/n$a;", "Le33/a;", "", "data", "", "onReceive", "Le33/c;", "b", "Lcom/tencent/state/api/INetworkDelegateCallBack;", "a", "Lcom/tencent/state/api/INetworkDelegateCallBack;", "getCallBack", "()Lcom/tencent/state/api/INetworkDelegateCallBack;", "callBack", "<init>", "(Lcom/tencent/state/api/INetworkDelegateCallBack;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements e33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final INetworkDelegateCallBack callBack;

        public a(INetworkDelegateCallBack callBack) {
            Intrinsics.checkNotNullParameter(callBack, "callBack");
            this.callBack = callBack;
        }

        @Override // e33.a
        public void b(RspErrorData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.callBack.onError(new SquareErrorData(data.getErrCode(), data.getErrMsg(), data.getPrompt()));
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            this.callBack.onReceive(data);
        }
    }

    @Override // com.tencent.state.api.INetworkDelegate
    public void sendVasProxyRequest(String service, String method, byte[] reqData, Map<String, String> extData, INetworkDelegateCallBack callBack) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        sendVasProxyRequest(service, method, reqData, extData, 0, callBack);
    }

    @Override // com.tencent.state.api.INetworkDelegate
    public void sendVasProxyRequest(String service, String method, byte[] reqData, Map<String, String> extData, int source, INetworkDelegateCallBack callBack) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.d("VasSquareNetworkDelegate", 1, "sendVasProxyRequest app:" + appInterface);
            callBack.onError(new SquareErrorData(-1, "get app is null", null));
            return;
        }
        ((IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class)).sendVasProxyRequest(appInterface, service, method, reqData, extData, new a(callBack), source);
    }
}
