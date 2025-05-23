package com.tencent.gdtad.aditem;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.statistics.AdRelationTargetMatch;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtMotiveAPI;
import com.tencent.gdtad.config.IGdtConfigAPI;
import com.tencent.gdtad.config.data.k;
import com.tencent.gdtad.kuikly.IGdtKuiklyAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.IPrePullListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class GdtPreLoader {

    /* renamed from: a, reason: collision with root package name */
    private static volatile GdtPreLoader f108489a;

    private void b(@Nullable GdtAd gdtAd) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null && gdtAd != null && gdtAd.isValid()) {
            AdRelationTargetMatch.handle(new WeakReference(context), gdtAd);
        } else {
            GdtLog.e("GdtPreLoader", "dealAdReltargetMatch error params error");
        }
    }

    public static GdtPreLoader c() {
        if (f108489a == null) {
            synchronized (GdtPreLoader.class) {
                if (f108489a == null) {
                    f108489a = new GdtPreLoader();
                }
            }
        }
        return f108489a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d() {
        ((IGdtMotiveAPI) QRoute.api(IGdtMotiveAPI.class)).preDownload();
    }

    private void e(@Nullable GdtAd gdtAd) {
        if (gdtAd != null && gdtAd.isMotiveAd()) {
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.aditem.a
                @Override // java.lang.Runnable
                public final void run() {
                    GdtPreLoader.d();
                }
            }, "GdtPreLoader", "");
        }
    }

    private void f(GdtAd gdtAd) {
        String str;
        long j3;
        String str2;
        k kVar = null;
        if (gdtAd != null) {
            str = gdtAd.getPosId();
        } else {
            str = null;
        }
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        } else {
            str2 = null;
        }
        if (gdtAd != null && gdtAd.isWXCustomerService()) {
            try {
                kVar = ((IGdtConfigAPI) QRoute.api(IGdtConfigAPI.class)).getConfigForWXCustomerService();
            } catch (Throwable th5) {
                QLog.e("GdtPreLoader", 1, "[preDownloadWXCustomerServiceKuikly]", th5);
            }
            if (kVar == null) {
                QLog.e("GdtPreLoader", 1, "[preDownloadWXCustomerServiceKuikly] not enabled, posId:" + str + " aid:" + j3 + " traceId:" + str2);
                return;
            }
            QLog.i("GdtPreLoader", 1, "[preDownloadWXCustomerServiceKuikly] posId:" + str + " aid:" + j3 + " traceId:" + str2);
            try {
                ((IGdtKuiklyAPI) QRoute.api(IGdtKuiklyAPI.class)).preDownload(BaseApplication.getContext(), str, "gdt_wx_customer_service_card_module");
                return;
            } catch (Throwable th6) {
                QLog.e("GdtPreLoader", 1, "[preDownloadInterstitialKuikly]", th6);
                return;
            }
        }
        QLog.i("GdtPreLoader", 1, "[preDownloadWXCustomerServiceKuikly] do nothing, posId:" + str + " aid:" + j3 + " traceId:" + str2);
    }

    public void g(GdtAd gdtAd) {
        String str;
        long j3;
        String str2 = null;
        if (gdtAd != null) {
            str = gdtAd.getPosId();
        } else {
            str = null;
        }
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        }
        QLog.i("GdtPreLoader", 1, "[preLoadAfterAdExposure] posId:" + str + " aid:" + j3 + " traceId:" + str2);
        f(gdtAd);
    }

    @Deprecated
    public void h(@Nullable final GdtAd gdtAd) {
        String str;
        long j3;
        String str2;
        if (gdtAd != null) {
            str = gdtAd.getPosId();
        } else {
            str = null;
        }
        if (gdtAd != null) {
            j3 = gdtAd.getAId();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        if (gdtAd != null) {
            str2 = gdtAd.getTraceId();
        } else {
            str2 = null;
        }
        QLog.i("GdtPreLoader", 1, "[preLoadAfterAdLoaded] posId:" + str + " aid:" + j3 + " traceId:" + str2);
        GdtManager.q().r(BaseApplication.getContext(), null);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.gdtad.aditem.GdtPreLoader.1

            /* renamed from: com.tencent.gdtad.aditem.GdtPreLoader$1$a */
            /* loaded from: classes6.dex */
            class a implements IPrePullListener {
                a() {
                }

                @Override // com.tencent.mobileqq.mini.api.IPrePullListener
                public void onPrePullCallback(boolean z16, JSONObject jSONObject) {
                    GdtLog.i("GdtPreLoader", String.format("MiniAppPrePullManager.getInstance().prePullAppinfoByLink end:%b", Boolean.valueOf(z16)));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                GdtAd gdtAd2 = gdtAd;
                if (gdtAd2 != null && gdtAd2.isValid()) {
                    GdtLog.i("GdtPreLoader", "preLoadAfterAdLoaded");
                    if (gdtAd.isQQMINIProgram()) {
                        GdtLog.i("GdtPreLoader", String.format("canPreloadForQQMINIProgram %b", Boolean.valueOf(gdtAd.canPreloadForQQMINIProgram())));
                        if (gdtAd.canPreloadForQQMINIProgram() && !TextUtils.isEmpty(gdtAd.getUrlForLandingPage())) {
                            GdtLog.i("GdtPreLoader", "MiniAppPrePullManager.getInstance().prePullAppinfoByLink start");
                            ((IMiniAppService) QRoute.api(IMiniAppService.class)).prePullAppinfoByLink(gdtAd.getUrlForLandingPage(), false, new a());
                            return;
                        }
                        return;
                    }
                    return;
                }
                GdtLog.e("GdtPreLoader", "preLoadAfterAdLoaded error");
            }
        });
        b(gdtAd);
        AdAnalysisHelperForUtil.reportForPreload(BaseApplication.getContext(), gdtAd);
        e(gdtAd);
        f(gdtAd);
    }
}
