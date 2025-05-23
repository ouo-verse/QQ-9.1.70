package com.tencent.sqshow.zootopia.samestyle;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006J*\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/g;", "", "Lcom/tencent/common/app/AppInterface;", "app", "Lnv4/d;", "req", "Lkotlin/Function1;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "", "callback", "a", "Lcom/tencent/sqshow/zootopia/samestyle/e;", "Lcom/tencent/sqshow/zootopia/samestyle/f;", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f372915a = new g();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/g$a", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<ZPlanTemplateCat>, Unit> f372916a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super List<ZPlanTemplateCat>, Unit> function1) {
            this.f372916a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            List<ZPlanTemplateCat> emptyList;
            QLog.e("ZPlanSameStyle", 1, "request template tabs error, errCode = " + errCode + ", errMsg = " + errMsg);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.f372916a.invoke(emptyList);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            nv4.e eVar;
            List<ZPlanTemplateCat> emptyList;
            List<ZPlanTemplateCat> emptyList2;
            if (data == null) {
                QLog.i("ZPlanSameStyle", 1, "request template tabs success, but data is null");
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                this.f372916a.invoke(emptyList2);
                return;
            }
            QLog.i("ZPlanSameStyle", 1, "start parse get template tab response data");
            try {
                eVar = nv4.e.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanSameStyle", 1, e16, new Object[0]);
                eVar = null;
            }
            if (eVar == null) {
                QLog.e("ZPlanSameStyle", 1, "parse get template tab response fail");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.f372916a.invoke(emptyList);
                return;
            }
            ArrayList arrayList = new ArrayList();
            nv4.n[] nVarArr = eVar.f421392a;
            int length = nVarArr != null ? nVarArr.length : 0;
            QLog.i("ZPlanSameStyle", 1, "tab list size = " + length);
            for (int i3 = 0; i3 < length; i3++) {
                nv4.n[] nVarArr2 = eVar.f421392a;
                nv4.n nVar = nVarArr2 != null ? nVarArr2[i3] : null;
                if (nVar != null) {
                    String str = nVar.f421437a;
                    Intrinsics.checkNotNullExpressionValue(str, "item.tabName");
                    long j3 = nVar.f421438b;
                    mv4.j jVar = nVar.f421439c;
                    if (jVar == null) {
                        jVar = new mv4.j();
                    }
                    ZPlanTemplateCat zPlanTemplateCat = new ZPlanTemplateCat(str, j3, jVar);
                    QLog.i("ZPlanSameStyle", 1, i3 + "th template cat is: [" + zPlanTemplateCat + "]");
                    arrayList.add(zPlanTemplateCat);
                }
            }
            this.f372916a.invoke(arrayList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/g$b", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<TemplateRsp, Unit> f372917a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super TemplateRsp, Unit> function1) {
            this.f372917a = function1;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.e("ZPlanSameStyle", 1, "request templates error, errCode = " + errCode + ", errMsg = " + errMsg);
            this.f372917a.invoke(new TemplateRsp(errCode != null ? errCode.intValue() : -1, errMsg, 0L, 0, 0, 0, null, 124, null));
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            nv4.g gVar;
            if (data == null) {
                QLog.e("ZPlanSameStyle", 1, "request templates success, but data is null");
                this.f372917a.invoke(new TemplateRsp(-1, "data is null", 0L, 0, 0, 0, null, 124, null));
                return;
            }
            try {
                gVar = nv4.g.c(data);
            } catch (Exception e16) {
                QLog.e("ZPlanSameStyle", 1, e16, new Object[0]);
                gVar = null;
            }
            if (gVar == null) {
                QLog.e("ZPlanSameStyle", 1, "parse get templates response fail");
                this.f372917a.invoke(new TemplateRsp(-1, "parse resp fail", 0L, 0, 0, 0, null, 124, null));
                return;
            }
            TemplateRsp templateRsp = new TemplateRsp(0, null, gVar.f421399a, gVar.f421400b, gVar.f421401c, gVar.f421402d, ZPlanTemplate.INSTANCE.a(gVar), 3, null);
            QLog.i("ZPlanSameStyle", 1, "request success, tabId = " + templateRsp.getTabId() + ", pageIndex = " + templateRsp.getPageIndex() + ", totalPage = " + templateRsp.getTotalPage());
            this.f372917a.invoke(templateRsp);
        }
    }

    g() {
    }

    public final void a(AppInterface app, nv4.d req, Function1<? super List<ZPlanTemplateCat>, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZPlanSameStyle", 1, "start request template tabs, filterMultiPlayer:" + req.f421391a);
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, app, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "GetTemplateTab", byteArray, emptyMap, new a(callback), 0, 0, 192, null);
    }

    public final void b(AppInterface app, TemplateReq req, Function1<? super TemplateRsp, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZPlanSameStyle", 1, "start request templates with req = [" + req + "]");
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        IZootopiaProxyServlet iZootopiaProxyServlet = (IZootopiaProxyServlet) api;
        nv4.f fVar = new nv4.f();
        fVar.f421393a = req.getTabId();
        fVar.f421394b = req.getPageIndex();
        fVar.f421395c = req.getPerPageNum();
        fVar.f421396d = req.getPlayerNum();
        fVar.f421397e = req.getContentType();
        fVar.f421398f = req.getSortType();
        Unit unit = Unit.INSTANCE;
        byte[] byteArray = MessageNano.toByteArray(fVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(GetTemplates\u2026q.sortType\n            })");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b(iZootopiaProxyServlet, app, "trpc.metaverse.same_style_template.SameStyleTemplateSvr", "GetTemplates", byteArray, emptyMap, new b(callback), 0, 0, 192, null);
    }
}
