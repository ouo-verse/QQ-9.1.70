package com.tencent.mobileqq.zootopia.service.api.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tu4.f;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002J2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/api/impl/b;", "", "Lkotlin/Function1;", "Ltu4/c;", "", "callback", "a", "", "md5", "", "redPacketId", "", "avatarId", "", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/b$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.api.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9122b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<tu4.c, Unit> f329183a;

        /* JADX WARN: Multi-variable type inference failed */
        C9122b(Function1<? super tu4.c, Unit> function1) {
            this.f329183a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("RedPacketService", 1, "loadRedPacketList failed " + errCode + " " + errMsg);
            this.f329183a.invoke(null);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            tu4.c cVar = null;
            if (data == null) {
                QLog.e("RedPacketService", 1, "loadRedPacketList failed data is null");
                this.f329183a.invoke(null);
            } else {
                try {
                    cVar = tu4.c.c(data);
                } catch (Exception e16) {
                    QLog.e("RedPacketService", 1, "loadRedPacketList failed parse error", e16);
                }
                this.f329183a.invoke(cVar);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/api/impl/b$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329184a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f329184a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("RedPacketService", 1, "updateCoverInfo failed " + errCode + " " + errMsg);
            this.f329184a.invoke(Boolean.FALSE);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                QLog.e("RedPacketService", 1, "updateCoverInfo failed data is null");
                this.f329184a.invoke(Boolean.FALSE);
            } else {
                this.f329184a.invoke(Boolean.TRUE);
            }
        }
    }

    public final void a(Function1<? super tu4.c, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("RedPacketService", 1, "loadRedPacketList");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            QLog.e("RedPacketService", 1, "loadRedPacketList but appRunTime is null");
            return;
        }
        tu4.b bVar = new tu4.b();
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(bVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.hongbao_cover_svr.HongbaoCover", "GetCoverTemplates", byteArray, emptyMap, new C9122b(callback), 0, 0, 192, null);
    }

    public final void b(String md5, int redPacketId, long avatarId, Function1<? super Boolean, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("RedPacketService", 1, "updateCoverInfo");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            QLog.e("RedPacketService", 1, "updateCoverInfo but appRunTime is null");
            return;
        }
        f fVar = new f();
        fVar.f437511a = md5;
        fVar.f437512b = redPacketId;
        fVar.f437513c = avatarId;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.hongbao_cover_svr.HongbaoCover", "UpdateCoverInfo", byteArray, emptyMap, new c(callback), 0, 0, 192, null);
    }
}
