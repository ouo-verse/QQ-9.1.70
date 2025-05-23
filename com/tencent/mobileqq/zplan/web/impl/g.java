package com.tencent.mobileqq.zplan.web.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.hippy.api.data.ZPlanParadiseHippyCacheEntity;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.mobileqq.zplan.web.impl.g;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qv4.ak;
import qv4.al;
import qv4.an;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/g;", "Lcl3/a;", "Lqv4/al;", "hippyPreRequest", "", "V0", "Lqv4/an;", "hippyResource", "U0", "Lqv4/ak;", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "preloadHippyRes", "<init>", "()V", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements cl3.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016JT\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/web/impl/g$b", "Lcom/tencent/hippy/qq/api/IUpdateListener;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "bundleName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateJSCosts", "", "onUpdateSuccess", "retCode", "errMsg", "onUpdateFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IUpdateListener {
        b() {
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int requestId, int retCode, String errMsg, String bundleName, HashMap<String, String> updateJSCosts) {
            QLog.e("ZPlanHippyImpl", 1, "commonUpdateJsBundle onUpdateFailed requestId:" + requestId + " bundleName:" + bundleName + " retCode:" + retCode + " errMsg:" + errMsg);
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int requestId, String bundleName, HashMap<String, String> updateJSCosts) {
            QLog.i("ZPlanHippyImpl", 1, "commonUpdateJsBundle onUpdateSuccess requestId:" + requestId + " bundleName:" + bundleName);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/web/impl/g$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ al f336072a;

        c(al alVar) {
            this.f336072a = alVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(al hippyPreRequest, String jsonString) {
            String str;
            Intrinsics.checkNotNullParameter(hippyPreRequest, "$hippyPreRequest");
            Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
            ZPlanParadiseHippyCacheEntity zPlanParadiseHippyCacheEntity = new ZPlanParadiseHippyCacheEntity();
            SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
            if (firstSimpleAccount != null) {
                str = firstSimpleAccount.getUin();
                Intrinsics.checkNotNullExpressionValue(str, "simpleAccount.uin");
            } else {
                str = "";
            }
            zPlanParadiseHippyCacheEntity.cacheKey = str + "_" + hippyPreRequest.f429945d;
            zPlanParadiseHippyCacheEntity.cacheData = jsonString;
            ZplanDataBaseHelper.h().i(zPlanParadiseHippyCacheEntity);
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            QLog.i("ZPlanHippyImpl", 1, "hippyPreRequest onError error" + errCode + " errMsg" + errMsg);
        }

        @Override // td3.a
        public void onReceive(byte[] data) {
            QLog.i("ZPlanHippyImpl", 1, "hippyPreRequest onReceive data:" + data);
            if (data != null) {
                final al alVar = this.f336072a;
                final String str = new String(data, Charsets.UTF_8);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.c.c(al.this, str);
                    }
                }, 32, null, true);
            }
        }
    }

    private final void U0(an hippyResource) {
        QLog.i("ZPlanHippyImpl", 1, "bundleResUpdate HippyResource:" + hippyResource);
        ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(hippyResource.f429948a, "ZPlanParadise", new b());
    }

    private final void V0(al hippyPreRequest) {
        Map emptyMap;
        QLog.i("ZPlanHippyImpl", 1, "hippyResPreRequest server:" + hippyPreRequest.f429942a + " method:" + hippyPreRequest.f429943b);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        String str = hippyPreRequest.f429942a;
        Intrinsics.checkNotNullExpressionValue(str, "hippyPreRequest.server");
        String str2 = hippyPreRequest.f429943b;
        Intrinsics.checkNotNullExpressionValue(str2, "hippyPreRequest.method");
        byte[] bArr = hippyPreRequest.f429944c.f429946a;
        Intrinsics.checkNotNullExpressionValue(bArr, "hippyPreRequest.requestBody.body");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.a((IZootopiaProxyServlet) api, appInterface, str, str2, bArr, emptyMap, new c(hippyPreRequest), 0, 0, 192, null);
    }

    @Override // cl3.a
    public void preloadHippyRes(ak hippyInfo) {
        Intrinsics.checkNotNullParameter(hippyInfo, "hippyInfo");
        QLog.i("ZPlanHippyImpl", 1, "preloadHippyRes");
        al[] alVarArr = hippyInfo.f429940b;
        if (alVarArr != null) {
            for (al it : alVarArr) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                V0(it);
            }
        }
        an[] anVarArr = hippyInfo.f429939a;
        if (anVarArr != null) {
            for (an it5 : anVarArr) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                U0(it5);
            }
        }
    }
}
