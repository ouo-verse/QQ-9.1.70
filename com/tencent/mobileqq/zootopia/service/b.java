package com.tencent.mobileqq.zootopia.service;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zb3.ZootopiaEnterRoomData;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/b;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", "mapId", "", "roomId", "source", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzb3/f;", "callback", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/service/b$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.service.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9123b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<ZootopiaEnterRoomData> f329190a;

        C9123b(com.tencent.mobileqq.zootopia.api.e<ZootopiaEnterRoomData> eVar) {
            this.f329190a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("EnterRoomService", 1, "enterRoom: errCode=" + errCode + ", " + errMsg);
            this.f329190a.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data != null) {
                rv4.b rsp = rv4.b.c(data);
                Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                ZootopiaEnterRoomData a16 = zb3.g.a(rsp);
                if (a16 != null) {
                    this.f329190a.onResultSuccess(a16);
                    return;
                }
            }
            this.f329190a.onResultFailure(-1, "");
        }
    }

    public final void a(AppInterface app, int mapId, long roomId, int source, com.tencent.mobileqq.zootopia.api.e<ZootopiaEnterRoomData> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(callback, "callback");
        rv4.a aVar = new rv4.a();
        aVar.f432565a = mapId;
        aVar.f432566b = roomId;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.scene_manager.SceneManager", "AutoEnterSceneRoom", byteArray, emptyMap, new C9123b(callback), source, 0, 128, null);
    }
}
