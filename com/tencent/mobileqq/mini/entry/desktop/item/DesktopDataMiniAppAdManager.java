package com.tencent.mobileqq.mini.entry.desktop.item;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DesktopDataMiniAppAdManager implements Manager {
    private static final String DEFAULT_MODEL_KEY = "default";
    private static final String ELDER_MODEL_KEY = "elderly";
    private static final String GDT_AD_POSITION_ID = "9005466481770166";
    private static final int MINI_APP_GDT_COUNT = 1;
    public static final int REQUEST_DEFAULT_INTERVAL_TIME = 180;
    public static final String TAG = "DesktopDataMiniAppAdManager";
    private static final String TEENAGER_MODEL_KEY = "teenager";
    private AdExposureChecker.ExposureCallback mExposureCallback;
    private AdExposureChecker mExposureChecker;
    private GdtAd mGdtAdInfo;
    private Set<String> mOriginalExposureTraceIdSet = new HashSet();
    private Set<String> mExposureTraceIdSet = new HashSet();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface MiniAppAdCallback {
        void onGetMiniAppAdFailure(int i3, String str);

        void onGetMiniAppAdSuccess(GdtAd gdtAd, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class SingletonHolder {
        private static final DesktopDataMiniAppAdManager INSTANCE = new DesktopDataMiniAppAdManager();

        SingletonHolder() {
        }
    }

    DesktopDataMiniAppAdManager() {
    }

    private VasNewAdParams createRequestAdParams() {
        VasNewAdParams.Builder builder = new VasNewAdParams.Builder();
        builder.getAdvPos().add(GDT_AD_POSITION_ID);
        builder.setBusiType(51);
        builder.setAdCount(1);
        builder.setClientMod(getClientMode());
        builder.setDeepLinkVersion(0);
        return builder.build();
    }

    private String getClientMode() {
        if (SimpleUIUtil.isNowElderMode()) {
            return "elderly";
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return "teenager";
        }
        return "default";
    }

    public static DesktopDataMiniAppAdManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private int getRequestIntervalTime(access.AdGetRsp adGetRsp) {
        if (adGetRsp.ext.get().isEmpty() || TextUtils.isEmpty(adGetRsp.ext.get(0).value.get())) {
            return 180;
        }
        QLog.d(TAG, 1, "getRequestIntervalTime server response");
        return Integer.parseInt(adGetRsp.ext.get(0).value.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGdtMiniAppAd$1(final MiniAppAdCallback miniAppAdCallback, final int i3, final access.AdGetRsp adGetRsp, final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.desktop.item.a
            @Override // java.lang.Runnable
            public final void run() {
                DesktopDataMiniAppAdManager.this.lambda$loadGdtMiniAppAd$0(i3, adGetRsp, miniAppAdCallback, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportAdByHttp$3(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.connect();
            QLog.i(TAG, 1, "reportMiniAd/BlockAd rspCode" + httpURLConnection.getResponseCode());
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "reportMiniAd/BlockAd error, url = " + str, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportGdtMiniAppAdExposure$2(GdtAd gdtAd, WeakReference weakReference) {
        gdtAdExposureReport(gdtAd);
        QLog.d(TAG, 1, "gdtMiniAppAdExposure onExposure");
    }

    private void reportAdByHttp(final String str) {
        QLog.i(TAG, 1, "reportMiniAd reportUrl = " + str);
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.desktop.item.c
            @Override // java.lang.Runnable
            public final void run() {
                DesktopDataMiniAppAdManager.lambda$reportAdByHttp$3(str);
            }
        });
    }

    private void resetGdtAdParams() {
        this.mOriginalExposureTraceIdSet.clear();
        this.mExposureTraceIdSet.clear();
    }

    public GdtAd getGdtAdInfo() {
        return this.mGdtAdInfo;
    }

    public void setGdtAdInfo(GdtAd gdtAd) {
        this.mGdtAdInfo = gdtAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadGdtMiniAppAd$0(int i3, access.AdGetRsp adGetRsp, MiniAppAdCallback miniAppAdCallback, String str) {
        if (i3 == 0 && adGetRsp != null && adGetRsp.get() != null && adGetRsp.action_report_infos.get() != null && adGetRsp.qq_ad_get_rsp.get() != null && adGetRsp.qq_ad_get_rsp.pos_ads_info.get() != null) {
            if (!adGetRsp.qq_ad_get_rsp.pos_ads_info.isEmpty() && adGetRsp.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0).display_info != null) {
                GdtAd gdtAd = new GdtAd(adGetRsp.qq_ad_get_rsp.get().pos_ads_info.get(0).ads_info.get(0));
                this.mGdtAdInfo = gdtAd;
                String str2 = gdtAd.info.display_info.mini_program_id.get();
                String str3 = this.mGdtAdInfo.info.display_info.mini_program_name.get();
                String str4 = this.mGdtAdInfo.info.display_info.basic_info.img.get();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    resetGdtAdParams();
                    miniAppAdCallback.onGetMiniAppAdSuccess(this.mGdtAdInfo, getRequestIntervalTime(adGetRsp));
                    QLog.d(TAG, 1, "get miniapp ad resp success! miniAppName:" + str3 + " miniAppId:" + str2);
                    return;
                }
                miniAppAdCallback.onGetMiniAppAdFailure(i3, "get miniapp ad data is empty");
                QLog.d(TAG, 1, "get miniapp ad data is empty");
                return;
            }
            miniAppAdCallback.onGetMiniAppAdFailure(i3, str);
            QLog.d(TAG, 1, "get miniapp ad resp data empty");
            return;
        }
        miniAppAdCallback.onGetMiniAppAdFailure(i3, str);
        QLog.d(TAG, 1, "get miniapp ad resp data error:" + i3 + " msg:" + str);
    }

    public void gdtAdExposureReport(GdtAd gdtAd) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && !TextUtils.isEmpty(reportInfo.exposure_url.get())) {
            String str = gdtAd.info.report_info.trace_info.traceid.get();
            if (this.mExposureTraceIdSet.contains(str)) {
                return;
            }
            reportAdByHttp(gdtAd.info.report_info.exposure_url.get());
            this.mExposureTraceIdSet.add(str);
            QLog.d(TAG, 1, "gdtMiniAppAdExposure onExposure gdtAdTraceId:" + str);
            return;
        }
        QLog.d(TAG, 1, "gdtAdExposureReport gdtAdInfo is null");
    }

    public void reportGdtMiniAppAdExposure(final GdtAd gdtAd, View view) {
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        if (view == null) {
            QLog.d(TAG, 1, "gdtMiniAppAdExposure adView null");
            return;
        }
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null) {
            String str = reportInfo.trace_info.traceid.get();
            if (this.mOriginalExposureTraceIdSet.contains(str)) {
                return;
            }
            this.mExposureChecker = new AdExposureChecker(gdtAd, new WeakReference(view));
            this.mExposureCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.mini.entry.desktop.item.b
                @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
                public final void onExposure(WeakReference weakReference) {
                    DesktopDataMiniAppAdManager.this.lambda$reportGdtMiniAppAdExposure$2(gdtAd, weakReference);
                }
            };
            this.mExposureChecker.setCallback(new WeakReference<>(this.mExposureCallback));
            this.mExposureChecker.startCheck();
            if (TextUtils.isEmpty(gdtAd.info.report_info.original_exposure_url.get())) {
                return;
            }
            GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, view.getContext());
            this.mOriginalExposureTraceIdSet.add(str);
            new GdtThirdProcessorProxy().c2sReportAsync(0, 0, gdtAd.info);
            QLog.i(TAG, 1, "gdtMiniAppAdExposure start original Exposure gdtAdTraceId:" + str);
            return;
        }
        QLog.d(TAG, 1, "gdtMiniAppAdExposure gdtAdInfo null");
    }

    public void miniAppGdtAdClick(WeakReference<Activity> weakReference, GdtAd gdtAd) {
        if (gdtAd == null) {
            QLog.d(TAG, 1, "miniAppGdtAdClick gdtAdInfo null");
            return;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        params.activity = weakReference;
        params.f108486ad = gdtAd;
        Bundle bundle = new Bundle();
        params.extra = bundle;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniapp");
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        new GdtThirdProcessorProxy().c2sReportAsync(1, 0, gdtAd.info);
    }

    public void loadGdtMiniAppAd(final MiniAppAdCallback miniAppAdCallback) {
        if (miniAppAdCallback == null) {
            return;
        }
        QLog.d(TAG, 1, "request miniapp ad");
        ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).requestAd(createRequestAdParams(), new VasAdCallback() { // from class: com.tencent.mobileqq.mini.entry.desktop.item.d
            @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
            public final void onRsp(int i3, access.AdGetRsp adGetRsp, String str) {
                DesktopDataMiniAppAdManager.this.lambda$loadGdtMiniAppAd$1(miniAppAdCallback, i3, adGetRsp, str);
            }
        });
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
