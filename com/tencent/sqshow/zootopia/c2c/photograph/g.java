package com.tencent.sqshow.zootopia.c2c.photograph;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/g;", "Lcom/tencent/mobileqq/mvvm/a;", "", "page", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "callback", "", "j", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    public g(ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    public final void j(int page, com.tencent.mobileqq.zootopia.api.e<List<ZPlanTemplate>> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        nv4.f fVar = new nv4.f();
        fVar.f421394b = page;
        fVar.f421395c = 10;
        fVar.f421396d = 2;
        fVar.f421397e = 2;
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(request)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "GetTemplates", byteArray, emptyMap, new b(callback), ZootopiaSource.INSTANCE.j(this.source), 0, 128, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/c2c/photograph/g$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<ZPlanTemplate>> f370164a;

        b(com.tencent.mobileqq.zootopia.api.e<List<ZPlanTemplate>> eVar) {
            this.f370164a = eVar;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            this.f370164a.onResultFailure(errCode != null ? errCode.intValue() : -1, errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f370164a.onResultFailure(-1, "data is null");
                return;
            }
            nv4.g rsp = nv4.g.c(data);
            com.tencent.mobileqq.zootopia.api.e<List<ZPlanTemplate>> eVar = this.f370164a;
            ZPlanTemplate.Companion companion = ZPlanTemplate.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            eVar.onResultSuccess(companion.a(rsp));
        }
    }
}
