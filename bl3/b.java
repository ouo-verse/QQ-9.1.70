package bl3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import dv4.g;
import dv4.h;
import dv4.i;
import dv4.k;
import dv4.l;
import dv4.m;
import dv4.n;
import dv4.o;
import dv4.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00172\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\u001c"}, d2 = {"Lbl3/b;", "", "Ldv4/h;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/i;", "callback", "", "source", "", "e", "Ldv4/d;", "Ldv4/e;", "a", "Ldv4/k;", "Ldv4/l;", "g", "Ldv4/f;", "Ldv4/g;", "c", "Ldv4/m;", "Ldv4/n;", "i", "Ldv4/o;", "Ldv4/p;", "k", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b {

    /* renamed from: a */
    public static final b f28634a = new b();

    b() {
    }

    public final void a(dv4.d req, com.tencent.mobileqq.zootopia.api.e<dv4.e> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamEnterRoom", byteArray, emptyMap, new a(callback), source, 0, 128, null);
    }

    public final void c(dv4.f req, com.tencent.mobileqq.zootopia.api.e<g> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamGetConf", byteArray, emptyMap, new C0135b(callback), source, 0, 128, null);
    }

    public final void e(h req, com.tencent.mobileqq.zootopia.api.e<i> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamHeartbeat", byteArray, emptyMap, new c(callback), source, 0, 128, null);
    }

    public final void g(k req, com.tencent.mobileqq.zootopia.api.e<l> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamLeaveRoom", byteArray, emptyMap, new d(callback), source, 0, 128, null);
    }

    public final void i(m req, com.tencent.mobileqq.zootopia.api.e<n> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamSwitchOffStream", byteArray, emptyMap, new e(callback), source, 0, 128, null);
    }

    public final void k(o req, com.tencent.mobileqq.zootopia.api.e<p> callback, int source) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.qqlive_stream_director.QQLiveStreamDirector", "QQLiveStreamSwitchOnStream", byteArray, emptyMap, new f(callback), source, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<dv4.e> f28635a;

        a(com.tencent.mobileqq.zootopia.api.e<dv4.e> eVar) {
            this.f28635a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28635a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            dv4.e eVar;
            if (data == null) {
                this.f28635a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                eVar = dv4.e.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                eVar = null;
            }
            if (eVar == null) {
                this.f28635a.onResultFailure(-13, str);
            } else {
                this.f28635a.onResultSuccess(eVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bl3.b$b */
    /* loaded from: classes39.dex */
    public static final class C0135b implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<g> f28636a;

        C0135b(com.tencent.mobileqq.zootopia.api.e<g> eVar) {
            this.f28636a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28636a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            g gVar;
            if (data == null) {
                this.f28636a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                gVar = g.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                gVar = null;
            }
            if (gVar == null) {
                this.f28636a.onResultFailure(-13, str);
            } else {
                this.f28636a.onResultSuccess(gVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<i> f28637a;

        c(com.tencent.mobileqq.zootopia.api.e<i> eVar) {
            this.f28637a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28637a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            i iVar;
            if (data == null) {
                this.f28637a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                iVar = i.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                iVar = null;
            }
            if (iVar == null) {
                this.f28637a.onResultFailure(-13, str);
            } else {
                this.f28637a.onResultSuccess(iVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$d", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class d implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<l> f28638a;

        d(com.tencent.mobileqq.zootopia.api.e<l> eVar) {
            this.f28638a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28638a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            l lVar;
            if (data == null) {
                this.f28638a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                lVar = l.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                lVar = null;
            }
            if (lVar == null) {
                this.f28638a.onResultFailure(-13, str);
            } else {
                this.f28638a.onResultSuccess(lVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$e", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class e implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<n> f28639a;

        e(com.tencent.mobileqq.zootopia.api.e<n> eVar) {
            this.f28639a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28639a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            n nVar;
            if (data == null) {
                this.f28639a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                nVar = n.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                nVar = null;
            }
            if (nVar == null) {
                this.f28639a.onResultFailure(-13, str);
            } else {
                this.f28639a.onResultSuccess(nVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"bl3/b$f", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class f implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<p> f28640a;

        f(com.tencent.mobileqq.zootopia.api.e<p> eVar) {
            this.f28640a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f28640a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            p pVar;
            if (data == null) {
                this.f28640a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                pVar = p.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                pVar = null;
            }
            if (pVar == null) {
                this.f28640a.onResultFailure(-13, str);
            } else {
                this.f28640a.onResultSuccess(pVar);
            }
        }
    }

    public static /* synthetic */ void b(b bVar, dv4.d dVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.a(dVar, eVar, i3);
    }

    public static /* synthetic */ void d(b bVar, dv4.f fVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.c(fVar, eVar, i3);
    }

    public static /* synthetic */ void f(b bVar, h hVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.e(hVar, eVar, i3);
    }

    public static /* synthetic */ void h(b bVar, k kVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.g(kVar, eVar, i3);
    }

    public static /* synthetic */ void j(b bVar, m mVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.i(mVar, eVar, i3);
    }

    public static /* synthetic */ void l(b bVar, o oVar, com.tencent.mobileqq.zootopia.api.e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        bVar.k(oVar, eVar, i3);
    }
}
