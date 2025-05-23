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

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/service/a;", "Lyb4/d;", "Lav4/f;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lav4/g;", "callback", "", "e", "", "method", "c", "", "data", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends yb4.d {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/service/ZootopiaBaseService$requestNetWork$1", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ yb4.d f329166a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f329167b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e f329168c;

        public b(yb4.d dVar, String str, com.tencent.mobileqq.zootopia.api.e eVar) {
            this.f329166a = dVar;
            this.f329167b = str;
            this.f329168c = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZootopiaBaseService", 1, "requestNetWork\uff0cerrCode:" + errCode + ", errMsg:" + errMsg);
            this.f329168c.onResultFailure(errCode != null ? errCode.intValue() : -1001, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            av4.g gVar;
            try {
                Object a16 = this.f329166a.a(this.f329167b, data);
                if (!(a16 instanceof av4.g)) {
                    QLog.e("ZootopiaBaseService", 4, "convertByteArray\uff0cerr, data is not T, data:" + a16);
                    gVar = null;
                } else if (a16 != null) {
                    gVar = (av4.g) a16;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.msg_center_svr.nano.ReportMsgRsp");
                }
                if (gVar != null) {
                    this.f329168c.onResultSuccess(gVar);
                } else {
                    this.f329168c.onResultFailure(-1001, "rsp is null");
                }
            } catch (Exception e16) {
                QLog.e("ZootopiaBaseService", 1, "requestNetWork throw e:" + e16.getMessage(), e16);
                this.f329168c.onResultFailure(-1001, "Exception:" + e16.getMessage());
            }
        }
    }

    @Override // yb4.d
    public Object a(String method, byte[] data) {
        Intrinsics.checkNotNullParameter(method, "method");
        av4.g c16 = av4.g.c(data);
        Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(data)");
        return c16;
    }

    @Override // yb4.d
    public String c(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return "trpc.metaverse.msg_center_svr.MsgCenterSvr";
    }

    public final void e(av4.f req, com.tencent.mobileqq.zootopia.api.e<av4.g> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZootopiaBaseService", 1, "requestNetWork, method:ReportMsg");
        if (req instanceof MessageNano) {
            byte[] byteArray = MessageNano.toByteArray(req);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(data)");
            int source = getSource();
            AppInterface b16 = b(callback);
            if (b16 == null) {
                return;
            }
            QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
            String c16 = c("ReportMsg");
            emptyMap = MapsKt__MapsKt.emptyMap();
            IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, b16, c16, "ReportMsg", byteArray, emptyMap, new b(this, "ReportMsg", callback), source, 0, 128, null);
            return;
        }
        QLog.e("ZootopiaBaseService", 1, "requestNetWork data is not MessageNano type,data=" + req);
    }
}
