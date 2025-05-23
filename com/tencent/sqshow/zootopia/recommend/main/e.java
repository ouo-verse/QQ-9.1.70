package com.tencent.sqshow.zootopia.recommend.main;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qv4.ae;
import qv4.af;
import qv4.w;
import qv4.x;
import qv4.y;
import qv4.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007J&\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u000e2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/e;", "", "Lqv4/w;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/x;", "callback", "", "source", "", "a", "Lqv4/y;", "Lqv4/z;", "c", "Lqv4/ae;", "Lqv4/af;", "e", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a */
    public static final e f372619a = new e();

    e() {
    }

    public final void a(w req, com.tencent.mobileqq.zootopia.api.e<x> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetPortalV2BottomTabs", byteArray, emptyMap, new a(callback), source, 0, 128, null);
    }

    public final void c(y req, com.tencent.mobileqq.zootopia.api.e<z> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetPortalV2CharacterPageInfo", byteArray, emptyMap, new b(callback), source, 0, 128, null);
    }

    public final void e(ae req, com.tencent.mobileqq.zootopia.api.e<af> callback, int source) {
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
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.scene_info_svr.SceneInfoSvr", "GetSceneIndexModuleInfo", byteArray, emptyMap, new c(callback), source, 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/e$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<x> f372620a;

        a(com.tencent.mobileqq.zootopia.api.e<x> eVar) {
            this.f372620a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f372620a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            x xVar;
            if (data == null) {
                this.f372620a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                xVar = x.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                xVar = null;
            }
            if (xVar == null) {
                this.f372620a.onResultFailure(-13, str);
            } else {
                this.f372620a.onResultSuccess(xVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/e$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<z> f372621a;

        b(com.tencent.mobileqq.zootopia.api.e<z> eVar) {
            this.f372621a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f372621a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            z zVar;
            if (data == null) {
                this.f372621a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                zVar = z.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                zVar = null;
            }
            if (zVar == null) {
                this.f372621a.onResultFailure(-13, str);
            } else {
                this.f372621a.onResultSuccess(zVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/e$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<af> f372622a;

        c(com.tencent.mobileqq.zootopia.api.e<af> eVar) {
            this.f372622a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f372622a.onResultFailure(errCode != null ? errCode.intValue() : -11, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            String str;
            af afVar;
            if (data == null) {
                this.f372622a.onResultFailure(-10, "rsp is null");
                return;
            }
            try {
                afVar = af.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                afVar = null;
            }
            if (afVar == null) {
                this.f372622a.onResultFailure(-13, str);
            } else {
                this.f372622a.onResultSuccess(afVar);
            }
        }
    }

    public static /* synthetic */ void b(e eVar, w wVar, com.tencent.mobileqq.zootopia.api.e eVar2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        eVar.a(wVar, eVar2, i3);
    }

    public static /* synthetic */ void d(e eVar, y yVar, com.tencent.mobileqq.zootopia.api.e eVar2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        eVar.c(yVar, eVar2, i3);
    }

    public static /* synthetic */ void f(e eVar, ae aeVar, com.tencent.mobileqq.zootopia.api.e eVar2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        eVar.e(aeVar, eVar2, i3);
    }
}
