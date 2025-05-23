package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ZootopiaNetRemoteManagerImpl;", "Lcom/tencent/mobileqq/zootopia/ipc/aa;", "", "server", "method", "requestJson", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "callback", "", "sendJsonRequest", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaNetRemoteManagerImpl implements aa {
    public static final int ERROR_CODE_CLIENT = -1;
    public static final String TAG = "ZootopiaNetRemoteManagerImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/ipc/ZootopiaNetRemoteManagerImpl$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah f328338a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f328339b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328340c;

        b(ah ahVar, String str, String str2) {
            this.f328338a = ahVar;
            this.f328339b = str;
            this.f328340c = str2;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e(ZootopiaNetRemoteManagerImpl.TAG, 1, "sendJsonRequest failed. server: " + this.f328339b + ", method: " + this.f328340c + ", rsp: {errCode: " + errCode + ", errMsg: " + errMsg + "}");
            ah ahVar = this.f328338a;
            if (ahVar != null) {
                int intValue = errCode != null ? errCode.intValue() : -1;
                if (errMsg == null) {
                    errMsg = "";
                }
                ahVar.onFailed(intValue, errMsg);
            }
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data != null) {
                String str = new String(data, Charsets.UTF_8);
                ah ahVar = this.f328338a;
                if (ahVar != null) {
                    ahVar.onSuccess(str);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.aa
    public void sendJsonRequest(String server, String method, String requestJson, ah callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(server, "server");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.i(TAG, 1, "sendJsonRequest error : appInterface must not be empty");
            if (callback != null) {
                callback.onFailed(-1, "appInterface must not be empty");
                return;
            }
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] bytes = requestJson.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.a((IZootopiaProxyServlet) api, appInterface, server, method, bytes, emptyMap, new b(callback, server, method), 0, 0, 192, null);
    }
}
