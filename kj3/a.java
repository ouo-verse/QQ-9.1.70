package kj3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.utils.bb;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u45.i;
import u45.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\u0007B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lkj3/a;", "", "Lkj3/a$a;", "listener", "", "a", "Lkj3/a$b;", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f412566a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lkj3/a$a;", "", "Lu45/j;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kj3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10662a {
        void a(j rsp);

        void onFail(int errCode, String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lkj3/a$b;", "", "Lu45/b;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void a(u45.b rsp);

        void onFail(int errCode, String errMsg);
    }

    a() {
    }

    public final void a(InterfaceC10662a listener) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            listener.onFail(-1, "app is null");
            return;
        }
        i iVar = new i();
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(iVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, c16, "trpc.metaverse.ugc_store_svr.UgcStoreSvr", "GetAgreeProtocolStatus", byteArray, emptyMap, new c(listener), 0, 0, 192, null);
    }

    public final void b(b listener) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            listener.onFail(-1, "app is null");
            return;
        }
        u45.a aVar = new u45.a();
        aVar.f438224a = true;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, c16, "trpc.metaverse.ugc_store_svr.UgcStoreSvr", "AgreeProtocol", byteArray, emptyMap, new d(listener), 0, 0, 192, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kj3/a$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC10662a f412567a;

        c(InterfaceC10662a interfaceC10662a) {
            this.f412567a = interfaceC10662a;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            InterfaceC10662a interfaceC10662a = this.f412567a;
            int intValue = errCode != null ? errCode.intValue() : -1;
            if (errMsg == null) {
                errMsg = "";
            }
            interfaceC10662a.onFail(intValue, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            j jVar;
            if (data == null) {
                this.f412567a.onFail(-1, "data is null");
                return;
            }
            try {
                jVar = j.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                jVar = null;
            }
            if (jVar == null) {
                this.f412567a.onFail(-1, str);
            } else {
                this.f412567a.a(jVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"kj3/a$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f412568a;

        d(b bVar) {
            this.f412568a = bVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            b bVar = this.f412568a;
            int intValue = errCode != null ? errCode.intValue() : -1;
            if (errMsg == null) {
                errMsg = "";
            }
            bVar.onFail(intValue, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            u45.b bVar;
            if (data == null) {
                this.f412568a.onFail(-1, "data is null");
                return;
            }
            try {
                bVar = u45.b.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                bVar = null;
            }
            if (bVar == null) {
                this.f412568a.onFail(-1, str);
            } else {
                this.f412568a.a(bVar);
            }
        }
    }
}
