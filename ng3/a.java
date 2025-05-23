package ng3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.sso.api.IZ1ProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sb3.Z1RspErrorData;
import sb3.b;
import zu4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lng3/a;", "", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f420127a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"ng3/a$a", "Lsb3/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ng3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10845a implements b {
        C10845a() {
        }

        @Override // sb3.b
        public void a(Integer errCode, String errMsg) {
            QLog.e("CloudGameReportRequest", 1, "GetBaseModInfoRequest error " + errCode + ", " + errMsg);
        }

        @Override // sb3.a
        public void b(Z1RspErrorData z1RspErrorData) {
            b.a.a(this, z1RspErrorData);
        }

        @Override // sb3.a
        public void onReceive(byte[] data) {
            QLog.i("CloudGameReportRequest", 1, "GetBaseModInfoRequest success");
        }
    }

    a() {
    }

    public final void a() {
        Map emptyMap;
        QLog.i("CloudGameReportRequest", 1, "CloudGameReportRequest :: start request ");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        c cVar = new c();
        QRouteApi api = QRoute.api(IZ1ProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZ1ProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(cVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(request)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZ1ProxyServlet.a.a((IZ1ProxyServlet) api, appInterface, "trpc.zmeta.mod_info_svr.ModInfoSvr", "CloudGameReport", byteArray, emptyMap, new C10845a(), 0, 64, null);
    }
}
