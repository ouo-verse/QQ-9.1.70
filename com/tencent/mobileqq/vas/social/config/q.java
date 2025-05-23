package com.tencent.mobileqq.vas.social.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/q;", "Lcom/tencent/rapier/f;", "", "service", "method", "", "reqData", "", "timeout", "", "source", "Lcom/tencent/rapier/g;", "callback", "", "a", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class q implements com.tencent.rapier.f {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/q$a;", "Le33/a;", "", "data", "", "onReceive", "Le33/c;", "b", "Lcom/tencent/rapier/g;", "a", "Lcom/tencent/rapier/g;", "getCallBack", "()Lcom/tencent/rapier/g;", "callBack", "<init>", "(Lcom/tencent/rapier/g;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements e33.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.rapier.g callBack;

        public a(com.tencent.rapier.g gVar) {
            this.callBack = gVar;
        }

        @Override // e33.a
        public void b(RspErrorData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            com.tencent.rapier.g gVar = this.callBack;
            if (gVar != null) {
                gVar.a(data.getErrCode(), data.getErrMsg());
            }
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            Map<Object, ? extends Object> emptyMap;
            com.tencent.rapier.g gVar = this.callBack;
            if (gVar != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                gVar.b(data, emptyMap);
            }
        }
    }

    @Override // com.tencent.rapier.f
    public void a(String service, String method, byte[] reqData, long timeout, int source, com.tencent.rapier.g callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(reqData, "reqData");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.d("VasSquareRapierDelegate", 1, "sendVasProxyRequest app:" + appInterface);
            if (callback != null) {
                callback.a(-1, "get app is null");
                return;
            }
            return;
        }
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(appInterface, service, method, reqData, emptyMap, new a(callback), source);
    }
}
