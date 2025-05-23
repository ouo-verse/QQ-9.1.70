package com.tencent.mobileqq.zootopia.service;

import com.google.protobuf.nano.MessageNano;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.netprobe.EchoTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import hw4.l;
import hw4.m;
import hw4.n;
import hw4.o;
import hw4.p;
import hw4.q;
import hw4.r;
import hw4.s;
import hw4.t;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001#B\u0011\u0012\b\b\u0002\u0010+\u001a\u00020\u0010\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u001c\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\tJ$\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\tJ.\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00160\tJ.\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00180\tJ2\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001c\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001d0\tJ2\u0010!\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020 0\tJ*\u0010#\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\"0\tJ*\u0010%\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020$0\tJ$\u0010'\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\tR\u0017\u0010+\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b#\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/j;", "", "", "str", "", "l", "Lcom/tencent/common/app/AppInterface;", "app", "uin", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/i;", "callback", "", "e", "Lhw4/p;", "f", "", "status", "Lhw4/t;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "page", WidgetCacheConstellationData.NUM, "Lhw4/l;", "g", "Lhw4/r;", "j", "", "list", "src", "Lhw4/c;", "b", "reqSrc", "Lhw4/g;", "d", "Lhw4/a;", "a", "Lhw4/e;", "c", "type", "i", "I", "getSource", "()I", "source", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: from kotlin metadata */
    private final int source;

    public j(int i3) {
        this.source = i3;
    }

    private final long l(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable th5) {
            QLog.e("ZootopiaSmallHomeAuthService", 1, "safelyParseLong, error, ", th5);
            return 0L;
        }
    }

    public final void a(AppInterface app, List<Long> list, com.tencent.mobileqq.zootopia.api.e<hw4.a> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        hw4.b bVar = new hw4.b();
        longArray = CollectionsKt___CollectionsKt.toLongArray(list);
        bVar.f406516a = longArray;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "BatchAddBlacklist", byteArray, emptyMap, new b(callback), this.source);
    }

    public final void b(AppInterface app, List<Long> list, int src, com.tencent.mobileqq.zootopia.api.e<hw4.c> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        hw4.b bVar = new hw4.b();
        longArray = CollectionsKt___CollectionsKt.toLongArray(list);
        bVar.f406516a = longArray;
        bVar.f406517b = src;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "BatchAddVisitor", byteArray, emptyMap, new c(callback), this.source);
    }

    public final void c(AppInterface app, List<Long> list, com.tencent.mobileqq.zootopia.api.e<hw4.e> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        hw4.d dVar = new hw4.d();
        longArray = CollectionsKt___CollectionsKt.toLongArray(list);
        dVar.f406519a = longArray;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(dVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "BatchDelBlacklist", byteArray, emptyMap, new d(callback), this.source);
    }

    public final void d(AppInterface app, List<Long> list, int reqSrc, com.tencent.mobileqq.zootopia.api.e<hw4.g> callback) {
        long[] longArray;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        hw4.f fVar = new hw4.f();
        longArray = CollectionsKt___CollectionsKt.toLongArray(list);
        fVar.f406520a = longArray;
        fVar.f406521b = reqSrc;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "BatchDelVisitor", byteArray, emptyMap, new e(callback), this.source);
    }

    public final void e(AppInterface app, String uin, com.tencent.mobileqq.zootopia.api.e<hw4.i> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long l3 = l(uin);
        if (l3 == 0) {
            callback.onResultFailure(-1000, "uin parsed is 0");
            return;
        }
        hw4.h hVar = new hw4.h();
        hVar.f406522a = l3;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(hVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "Chk", byteArray, emptyMap, new f(callback), this.source);
    }

    public final void f(AppInterface app, com.tencent.mobileqq.zootopia.api.e<p> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        o oVar = new o();
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(oVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "GetStatus", byteArray, emptyMap, new g(callback), this.source);
    }

    public final void g(AppInterface app, int page, int r122, com.tencent.mobileqq.zootopia.api.e<l> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        hw4.k kVar = new hw4.k();
        kVar.f406528a = page;
        kVar.f406529b = r122;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(kVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "GetBlacklist", byteArray, emptyMap, new h(callback), this.source);
    }

    public final void i(AppInterface app, int type, com.tencent.mobileqq.zootopia.api.e<Integer> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        m mVar = new m();
        mVar.f406532a = type;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(mVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "GetFriendCount", byteArray, emptyMap, new i(callback), this.source);
    }

    public final void j(AppInterface app, int page, int r122, com.tencent.mobileqq.zootopia.api.e<r> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        q qVar = new q();
        qVar.f406535a = page;
        qVar.f406536b = r122;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(qVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "GetVisitorList", byteArray, emptyMap, new C9125j(callback), this.source);
    }

    public final void m(AppInterface app, int i3, com.tencent.mobileqq.zootopia.api.e<t> callback) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        s sVar = new s();
        sVar.f406539a = i3;
        IZplanVasProxyServlet iZplanVasProxyServlet = (IZplanVasProxyServlet) QRoute.api(IZplanVasProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(sVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZplanVasProxyServlet.sendVasProxyRequest(app, "trpc.qmeta.visit_auth_svr.VisitAuthSvr", "SetStatus", byteArray, emptyMap, new k(callback), this.source);
    }

    public /* synthetic */ j(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 3 : i3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<hw4.a> f329249a;

        b(com.tencent.mobileqq.zootopia.api.e<hw4.a> eVar) {
            this.f329249a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329249a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329249a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<hw4.a> eVar = this.f329249a;
                hw4.a c16 = hw4.a.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "batchAddBlackList error");
                this.f329249a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$c", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<hw4.c> f329250a;

        c(com.tencent.mobileqq.zootopia.api.e<hw4.c> eVar) {
            this.f329250a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329250a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329250a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<hw4.c> eVar = this.f329250a;
                hw4.c c16 = hw4.c.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "batchAddVisitor error");
                this.f329250a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$d", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<hw4.e> f329251a;

        d(com.tencent.mobileqq.zootopia.api.e<hw4.e> eVar) {
            this.f329251a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329251a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329251a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<hw4.e> eVar = this.f329251a;
                hw4.e c16 = hw4.e.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "batchDeleteBlackList error");
                this.f329251a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$e", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<hw4.g> f329252a;

        e(com.tencent.mobileqq.zootopia.api.e<hw4.g> eVar) {
            this.f329252a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329252a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329252a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<hw4.g> eVar = this.f329252a;
                hw4.g c16 = hw4.g.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "batchDeleteVisitor error");
                this.f329252a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$f", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<hw4.i> f329253a;

        f(com.tencent.mobileqq.zootopia.api.e<hw4.i> eVar) {
            this.f329253a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329253a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329253a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<hw4.i> eVar = this.f329253a;
                hw4.i c16 = hw4.i.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "checkAuth error");
                this.f329253a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$g", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<p> f329254a;

        g(com.tencent.mobileqq.zootopia.api.e<p> eVar) {
            this.f329254a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329254a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329254a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<p> eVar = this.f329254a;
                p c16 = p.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "getAuthStatus error");
                this.f329254a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$h", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<l> f329255a;

        h(com.tencent.mobileqq.zootopia.api.e<l> eVar) {
            this.f329255a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329255a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329255a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<l> eVar = this.f329255a;
                l c16 = l.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "batchBlackList error");
                this.f329255a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$i", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Integer> f329256a;

        i(com.tencent.mobileqq.zootopia.api.e<Integer> eVar) {
            this.f329256a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329256a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329256a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                this.f329256a.onResultSuccess(Integer.valueOf(n.c(data).f406533a));
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "getFriendCount error");
                this.f329256a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$j", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.j$j */
    /* loaded from: classes35.dex */
    public static final class C9125j implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<r> f329257a;

        C9125j(com.tencent.mobileqq.zootopia.api.e<r> eVar) {
            this.f329257a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329257a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329257a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<r> eVar = this.f329257a;
                r c16 = r.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "getVisitorList error");
                this.f329257a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/j$k", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements e33.b {

        /* renamed from: a */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<t> f329258a;

        k(com.tencent.mobileqq.zootopia.api.e<t> eVar) {
            this.f329258a = eVar;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            this.f329258a.onResultFailure(errCode != null ? errCode.intValue() : -999, errMsg);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f329258a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, "data is null");
                return;
            }
            try {
                com.tencent.mobileqq.zootopia.api.e<t> eVar = this.f329258a;
                t c16 = t.c(data);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
                eVar.onResultSuccess(c16);
            } catch (Throwable th5) {
                QLog.e("ZootopiaSmallHomeAuthService", 2, "getAuthStatus error");
                this.f329258a.onResultFailure(EchoTask.ECHO_SERVER_EXCEPTION, th5.getMessage());
            }
        }
    }

    public static /* synthetic */ void h(j jVar, AppInterface appInterface, int i3, int i16, com.tencent.mobileqq.zootopia.api.e eVar, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        jVar.g(appInterface, i3, i16, eVar);
    }

    public static /* synthetic */ void k(j jVar, AppInterface appInterface, int i3, int i16, com.tencent.mobileqq.zootopia.api.e eVar, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        jVar.j(appInterface, i3, i16, eVar);
    }
}
