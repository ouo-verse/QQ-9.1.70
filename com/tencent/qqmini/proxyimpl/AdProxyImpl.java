package com.tencent.qqmini.proxyimpl;

import NS_COMM.COMM;
import NS_MINI_AD.MiniAppAd$StGetAdReq;
import NS_MINI_AD.MiniAppAd$StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.gdtad.api.motivebrowsing.RewardedBrowsingCallbackReceiver;
import com.tencent.gdtad.basics.adbox.GdtAdBoxListener;
import com.tencent.gdtad.basics.adbox.IGdtAdBox;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.helper.MiniAdExposureHelper;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdReportHelper;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.utils.VipWithoutAdHelper;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.plugins.BannerAdPlugin;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

@ProxyService(proxy = AdProxy.class)
/* loaded from: classes34.dex */
public class AdProxyImpl extends AdProxy {

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<String, f> f347097e;

    /* renamed from: a, reason: collision with root package name */
    private e f347098a;

    /* renamed from: b, reason: collision with root package name */
    private RewardedBrowsingCallbackReceiver f347099b;

    /* renamed from: c, reason: collision with root package name */
    private SDKRewardedVideoAdView f347100c = null;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f347101d = null;

    /* loaded from: classes34.dex */
    public static class AdResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private SDKRewardedVideoAdView f347114d;

        public AdResultReceiver(Handler handler, SDKRewardedVideoAdView sDKRewardedVideoAdView) {
            super(handler);
            this.f347114d = sDKRewardedVideoAdView;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            SDKRewardedVideoAdView sDKRewardedVideoAdView = this.f347114d;
            if (sDKRewardedVideoAdView != null) {
                sDKRewardedVideoAdView.f(i3, bundle);
            } else {
                QLog.d("AdResultReceiver", 1, "adView is null");
            }
        }
    }

    /* loaded from: classes34.dex */
    private class SDKBannerAdView extends AdProxy.AbsBannerAdView {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f347115a;

        /* renamed from: b, reason: collision with root package name */
        AdProxy.IBannerAdListener f347116b;

        /* renamed from: c, reason: collision with root package name */
        GdtBannerView f347117c;

        /* renamed from: d, reason: collision with root package name */
        GdtAdListener f347118d;

        /* renamed from: e, reason: collision with root package name */
        IGdtBannerAd f347119e;

        /* renamed from: f, reason: collision with root package name */
        protected qq_ad_get.QQAdGetRsp.AdInfo f347120f;

        /* renamed from: g, reason: collision with root package name */
        String f347121g;

        /* renamed from: h, reason: collision with root package name */
        String f347122h;

        /* renamed from: i, reason: collision with root package name */
        String f347123i;

        /* renamed from: j, reason: collision with root package name */
        int f347124j;

        /* renamed from: k, reason: collision with root package name */
        int f347125k;

        /* renamed from: l, reason: collision with root package name */
        String f347126l;

        /* renamed from: m, reason: collision with root package name */
        String f347127m;

        /* renamed from: n, reason: collision with root package name */
        String f347128n;

        /* renamed from: o, reason: collision with root package name */
        String f347129o;

        /* renamed from: p, reason: collision with root package name */
        String f347130p;

        /* renamed from: q, reason: collision with root package name */
        int f347131q;

        /* renamed from: r, reason: collision with root package name */
        int f347132r;

        /* renamed from: s, reason: collision with root package name */
        String f347133s;

        /* renamed from: t, reason: collision with root package name */
        long f347134t;

        /* renamed from: u, reason: collision with root package name */
        IMiniAppContext f347135u;

        /* renamed from: v, reason: collision with root package name */
        IGetAdPosInfo f347136v;

        /* renamed from: w, reason: collision with root package name */
        boolean f347137w;

        /* renamed from: x, reason: collision with root package name */
        private AdExposureChecker f347138x;

        /* renamed from: y, reason: collision with root package name */
        public AdExposureChecker.ExposureCallback f347139y;

        /* renamed from: z, reason: collision with root package name */
        private volatile boolean f347140z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes34.dex */
        public class a implements GdtAdListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f347145a;

            a(Activity activity) {
                this.f347145a = activity;
            }

            @Override // com.tencent.gdtad.api.GdtAdListener
            public void onAdClicked(GdtAd gdtAd) {
                QLog.i("AdProxyImpl", 1, "bannerad onAdClicked");
                if (gdtAd != null && gdtAd.getAd() != null) {
                    if (!wm0.a.f445800a.a(SDKBannerAdView.this.f347137w)) {
                        AdExposureChecker.onClick(this.f347145a, gdtAd.getAd(), new WeakReference(SDKBannerAdView.this.f347139y));
                    }
                    GdtBannerView gdtBannerView = SDKBannerAdView.this.f347117c;
                    if (gdtBannerView != null) {
                        com.tencent.gdtad.util.f.f109553a.a(gdtBannerView.getView(), 1, gdtAd.getAd(), SDKBannerAdView.this.f347121g);
                    }
                } else {
                    QLog.i("AdProxyImpl", 1, "ad null");
                }
                AdProxy.IBannerAdListener iBannerAdListener = SDKBannerAdView.this.f347116b;
                if (iBannerAdListener != null) {
                    iBannerAdListener.onADClicked();
                }
            }

            @Override // com.tencent.gdtad.api.GdtAdListener
            public void onAdClosed(GdtAd gdtAd) {
                QLog.i("AdProxyImpl", 1, "bannerad onAdClosed");
                AdProxy.IBannerAdListener iBannerAdListener = SDKBannerAdView.this.f347116b;
                if (iBannerAdListener != null) {
                    iBannerAdListener.onADClosed();
                }
            }

            @Override // com.tencent.gdtad.api.GdtAdListener
            public void onAdImpression(GdtAd gdtAd) {
                QLog.i("AdProxyImpl", 1, "bannerad onAdImpression");
            }

            @Override // com.tencent.gdtad.api.GdtAdListener
            public void onAdLoaded(GdtAd gdtAd) {
                QLog.i("AdProxyImpl", 1, "bannerad onAdLoaded");
            }

            @Override // com.tencent.gdtad.api.GdtAdListener
            public void onAdFailedToLoad(GdtAd gdtAd, GdtAdError gdtAdError) {
                String str;
                int errorCode = gdtAdError != null ? gdtAdError.getErrorCode() : -1;
                if (gdtAdError != null) {
                    str = gdtAdError.getErrorMessage();
                } else {
                    str = "";
                }
                QLog.i("AdProxyImpl", 1, "bannerad onAdFailedToLoad code=" + errorCode + ", msg=" + str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes34.dex */
        public class b implements e {
            b() {
            }

            @Override // com.tencent.qqmini.proxyimpl.AdProxyImpl.e
            public void a() {
                SDKBannerAdView sDKBannerAdView = SDKBannerAdView.this;
                if (sDKBannerAdView.f347115a != null && sDKBannerAdView.f347117c != null && sDKBannerAdView.f347116b != null) {
                    QLog.d("AdProxyImpl", 1, "setBannerAdRefreshListener onRefreshResume()");
                    SDKBannerAdView.this.f347140z = true;
                    SDKBannerAdView.this.f347116b.onAdRefreshResume();
                    return;
                }
                QLog.e("AdProxyImpl", 1, "setBannerAdRefreshListener onRefreshResume() fail");
            }

            @Override // com.tencent.qqmini.proxyimpl.AdProxyImpl.e
            public void b() {
                SDKBannerAdView sDKBannerAdView = SDKBannerAdView.this;
                if (sDKBannerAdView.f347115a != null && sDKBannerAdView.f347117c != null && sDKBannerAdView.f347116b != null) {
                    QLog.d("AdProxyImpl", 1, "setBannerAdRefreshListener onRefreshPause()");
                    SDKBannerAdView.this.f347140z = false;
                    SDKBannerAdView.this.f347116b.onAdRefreshPause();
                    return;
                }
                QLog.e("AdProxyImpl", 1, "setBannerAdRefreshListener onRefreshPause() fail");
            }
        }

        /* loaded from: classes34.dex */
        class c implements AdProxy.ICmdListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f347148a;

            c(Activity activity) {
                this.f347148a = activity;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    try {
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String string2 = jSONObject.getString("response");
                        if (i3 == 0 && !TextUtils.isEmpty(string2)) {
                            JSONArray l3 = AdProxyImpl.this.l(string2);
                            String obj = l3 != null ? l3.get(0).toString() : null;
                            qq_ad_get.QQAdGetRsp.AdInfo s16 = TextUtils.isEmpty(obj) ? null : AdProxyImpl.this.s(obj);
                            if (s16 != null) {
                                GdtPreLoader.c().h(new com.tencent.gdtad.aditem.GdtAd(s16));
                                SDKBannerAdView.this.f347133s = s16.report_info.exposure_url.get();
                                SDKBannerAdView.this.f347134t = s16.report_info.trace_info.aid.get();
                            } else {
                                QLog.e("AdProxyImpl", 1, "adInfo is null");
                            }
                            try {
                                COMM.StCommonExt stCommonExt = (COMM.StCommonExt) jSONObject.get("extInfo");
                                SDKBannerAdView sDKBannerAdView = SDKBannerAdView.this;
                                sDKBannerAdView.f347137w = AdProxyImpl.this.o(stCommonExt.mapInfo.get());
                            } catch (Exception e16) {
                                QLog.e("AdProxyImpl", 1, "banner ad getRenderType error:", e16);
                            }
                            SDKBannerAdView sDKBannerAdView2 = SDKBannerAdView.this;
                            sDKBannerAdView2.f347117c = sDKBannerAdView2.g(this.f347148a, s16, sDKBannerAdView2.f347122h, sDKBannerAdView2.f347131q, sDKBannerAdView2.f347132r, sDKBannerAdView2.f347137w, sDKBannerAdView2.f347135u);
                            SDKBannerAdView sDKBannerAdView3 = SDKBannerAdView.this;
                            sDKBannerAdView3.f347120f = s16;
                            if (sDKBannerAdView3.f347117c != null) {
                                if (sDKBannerAdView3.f347116b != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put(BannerAdPlugin.AD_AUTO_REFRESH_INTERVAL, SDKBannerAdView.this.k(s16));
                                    } catch (JSONException unused) {
                                        QLog.e("AdProxyImpl", 1, "adInfo is null");
                                    }
                                    SDKBannerAdView.this.f347116b.onADReceive(jSONObject2);
                                    SDKBannerAdView.this.m();
                                }
                                SDKBannerAdView sDKBannerAdView4 = SDKBannerAdView.this;
                                AdProxyImpl.this.v(obj, sDKBannerAdView4.f347124j);
                                return;
                            }
                            AdProxy.IBannerAdListener iBannerAdListener = sDKBannerAdView3.f347116b;
                            if (iBannerAdListener != null) {
                                iBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                                return;
                            }
                            return;
                        }
                        if (SDKBannerAdView.this.f347116b != null) {
                            int retCodeByServerResult = PluginConst.AdConst.getRetCodeByServerResult(i3);
                            if (retCodeByServerResult != -1) {
                                i3 = retCodeByServerResult;
                            }
                            SDKBannerAdView.this.f347116b.onNoAD(i3, string);
                            return;
                        }
                        return;
                    } catch (JSONException e17) {
                        QLog.e("AdProxyImpl", 1, "loadAD, err", e17);
                        AdProxy.IBannerAdListener iBannerAdListener2 = SDKBannerAdView.this.f347116b;
                        if (iBannerAdListener2 != null) {
                            iBannerAdListener2.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                            return;
                        }
                        return;
                    }
                }
                AdProxy.IBannerAdListener iBannerAdListener3 = SDKBannerAdView.this.f347116b;
                if (iBannerAdListener3 != null) {
                    iBannerAdListener3.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes34.dex */
        public class d implements AdExposureChecker.ExposureCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f347150a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.gdtad.aditem.GdtAd f347151b;

            d(View view, com.tencent.gdtad.aditem.GdtAd gdtAd) {
                this.f347150a = view;
                this.f347151b = gdtAd;
            }

            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public void onExposure(WeakReference<View> weakReference) {
                SDKBannerAdView sDKBannerAdView;
                qq_ad_get.QQAdGetRsp.AdInfo adInfo;
                qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
                PBStringField pBStringField;
                QLog.i("AdProxyImpl", 1, "bannerad onExposure");
                if (!wm0.a.f445800a.a(SDKBannerAdView.this.f347137w) && (adInfo = (sDKBannerAdView = SDKBannerAdView.this).f347120f) != null && (reportInfo = adInfo.report_info) != null && (pBStringField = reportInfo.exposure_url) != null) {
                    sDKBannerAdView.l(pBStringField.get());
                }
                com.tencent.gdtad.util.f.f109553a.a(this.f347150a, 0, this.f347151b, SDKBannerAdView.this.f347121g);
            }
        }

        public SDKBannerAdView(Activity activity, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8, int i17, int i18, AdProxy.IBannerAdListener iBannerAdListener, IMiniAppContext iMiniAppContext, IGetAdPosInfo iGetAdPosInfo) {
            super();
            this.f347137w = false;
            this.f347139y = null;
            this.f347140z = true;
            this.f347115a = new WeakReference<>(activity);
            this.f347116b = iBannerAdListener;
            this.f347121g = str;
            this.f347122h = str2;
            this.f347123i = str3;
            this.f347124j = i3;
            this.f347125k = i16;
            this.f347126l = str4;
            this.f347127m = str5;
            this.f347128n = str6;
            this.f347129o = str7;
            this.f347130p = str8;
            this.f347131q = i17;
            this.f347132r = i18;
            this.f347135u = iMiniAppContext;
            this.f347136v = iGetAdPosInfo;
            j(activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GdtBannerView g(Activity activity, qq_ad_get.QQAdGetRsp.AdInfo adInfo, String str, int i3, int i16, boolean z16, IMiniAppContext iMiniAppContext) {
            QLog.i("AdProxyImpl", 1, "createBannerAdView width = " + i3 + ", height = " + i16);
            if (adInfo == null || activity == null) {
                return null;
            }
            try {
                QLog.i("AdProxyImpl", 1, BannerAdPlugin.API_AD_CREATE_BANNER_AD);
                GdtBannerParams gdtBannerParams = new GdtBannerParams();
                gdtBannerParams.clickParams = AdProxyImpl.this.n(activity, adInfo, iMiniAppContext, str);
                gdtBannerParams.width = i3;
                gdtBannerParams.height = i16;
                gdtBannerParams.isRenderTypeKuikly = z16;
                int i17 = 0;
                if (!(this.f347125k == 90)) {
                    i17 = 1;
                }
                gdtBannerParams.orientation = i17;
                IGdtBannerAd buildBannerAd = ((IGdtBannerAdAPI) QRoute.api(IGdtBannerAdAPI.class)).buildBannerAd(gdtBannerParams);
                this.f347119e = buildBannerAd;
                GdtBannerView render = buildBannerAd.render(activity, i3, i16);
                this.f347119e.setListener(new WeakReference<>(this.f347118d));
                if (render == null) {
                    QLog.e("AdProxyImpl", 1, "build Ad error");
                }
                return render;
            } catch (Exception e16) {
                QLog.e("AdProxyImpl", 1, "createBannerAd, error", e16);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h(MiniAdPosInfo miniAdPosInfo) {
            if (miniAdPosInfo == null) {
                return "";
            }
            int i3 = miniAdPosInfo.left;
            int i16 = miniAdPosInfo.top;
            int i17 = miniAdPosInfo.width;
            int i18 = miniAdPosInfo.height;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("px", String.valueOf(i3));
                jSONObject.put("py", String.valueOf(i16));
                jSONObject.put("da", String.valueOf(i17));
                jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(i18));
                jSONObject.put(HippyTKDListViewAdapter.X, "0");
                return "s=" + URLEncoder.encode(jSONObject.toString(), "utf-8");
            } catch (UnsupportedEncodingException e16) {
                QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", e16);
                QLog.i("AdProxyImpl", 1, "getBannerExtraReportParams = " + miniAdPosInfo);
                return "";
            } catch (JSONException e17) {
                QLog.e("AdProxyImpl", 1, "getBannerExtraReportParams error", e17);
                QLog.i("AdProxyImpl", 1, "getBannerExtraReportParams = " + miniAdPosInfo);
                return "";
            }
        }

        private void j(Activity activity) {
            if (this.f347118d == null) {
                this.f347118d = new a(activity);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int k(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            Throwable th5;
            int i3;
            if (adInfo == null) {
                return 0;
            }
            try {
                i3 = new JSONObject(adInfo.ext_json.get()).optInt(BannerAdPlugin.AD_AUTO_REFRESH_INTERVAL, 0);
            } catch (Throwable th6) {
                th5 = th6;
                i3 = 0;
            }
            try {
                QLog.d("AdProxyImpl", 1, "BannerAdPlugin parseAdAutoRefreshInterval: ", Integer.valueOf(i3));
            } catch (Throwable th7) {
                th5 = th7;
                QLog.e("AdProxyImpl", 1, "getExtFromExtJson", th5);
                return i3;
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(final String str) {
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.6
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    IGetAdPosInfo iGetAdPosInfo = SDKBannerAdView.this.f347136v;
                    if (iGetAdPosInfo != null) {
                        String h16 = SDKBannerAdView.this.h(iGetAdPosInfo.getPosInfo());
                        if (!TextUtils.isEmpty(h16)) {
                            str2 = str2 + ContainerUtils.FIELD_DELIMITER + h16;
                        }
                    }
                    AdProxyImpl.u(str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m() {
            AdProxyImpl.this.f347098a = new b();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void destroy(Context context) {
            AdExposureChecker adExposureChecker = this.f347138x;
            if (adExposureChecker != null) {
                adExposureChecker.onActivityDestroy();
                this.f347138x = null;
            }
            this.f347139y = null;
            GdtBannerView gdtBannerView = this.f347117c;
            if (gdtBannerView != null && context != null) {
                gdtBannerView.destroy(context);
                this.f347117c = null;
            }
            this.f347115a = null;
            this.f347116b = null;
            this.f347120f = null;
            this.f347119e = null;
            AdProxyImpl.this.f347098a = null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public long getAdID() {
            return this.f347134t;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public String getReportUrl() {
            return this.f347133s;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public View getView() {
            GdtBannerView gdtBannerView = this.f347117c;
            if (gdtBannerView != null) {
                return gdtBannerView.getView();
            }
            return null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void onAdHide() {
            AdProxy.IBannerAdListener iBannerAdListener = this.f347116b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdRefreshPause();
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void onAdShow() {
            AdProxy.IBannerAdListener iBannerAdListener = this.f347116b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdRefreshResume();
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void onExposure() {
            i(this.f347120f, getView());
            IGdtBannerAd iGdtBannerAd = this.f347119e;
            if (iGdtBannerAd != null) {
                iGdtBannerAd.onDisplay();
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void pause(Context context) {
            GdtBannerView gdtBannerView = this.f347117c;
            if (gdtBannerView != null) {
                gdtBannerView.pause(context);
            }
            AdExposureChecker adExposureChecker = this.f347138x;
            if (adExposureChecker != null) {
                adExposureChecker.onActivityPause();
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void resume(Context context) {
            if (this.f347140z) {
                GdtBannerView gdtBannerView = this.f347117c;
                if (gdtBannerView != null) {
                    gdtBannerView.resume(context);
                }
                AdExposureChecker adExposureChecker = this.f347138x;
                if (adExposureChecker != null) {
                    adExposureChecker.onActivityResume();
                }
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void setSize(int i3, int i16) {
            GdtBannerView gdtBannerView = this.f347117c;
            if (gdtBannerView != null) {
                gdtBannerView.setSize(i3, i16);
            }
        }

        private void i(qq_ad_get.QQAdGetRsp.AdInfo adInfo, View view) {
            if (adInfo != null && view != null) {
                com.tencent.gdtad.aditem.GdtAd gdtAd = new com.tencent.gdtad.aditem.GdtAd(adInfo);
                this.f347138x = new AdExposureChecker(gdtAd, new WeakReference(view));
                if (this.f347139y == null) {
                    this.f347139y = new d(view, gdtAd);
                }
                this.f347138x.setCallback(new WeakReference<>(this.f347139y));
                this.f347138x.startCheck();
                QLog.i("AdProxyImpl", 1, "startonExposure");
                return;
            }
            QLog.i("AdProxyImpl", 1, "initAdExposureChecker null");
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBannerAdView
        public void loadAD() {
            WeakReference<Activity> weakReference = this.f347115a;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity != null) {
                final LifecycleOwner p16 = AdProxyImpl.this.p(activity);
                if (p16 != null) {
                    p16.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.3
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public void onDestroy() {
                            AdProxyImpl.this.f347098a = null;
                            p16.getLifecycle().removeObserver(this);
                        }
                    });
                }
                AdProxyImpl.this.requestAdInfo(activity, this.f347123i, this.f347122h, this.f347121g, 53, this.f347124j, this.f347125k, this.f347126l, this.f347127m, this.f347128n, this.f347129o, this.f347130p, 1, new c(activity));
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadAD, act is null, ");
            sb5.append(this.f347116b != null);
            QLog.e("AdProxyImpl", 1, sb5.toString());
            AdProxy.IBannerAdListener iBannerAdListener = this.f347116b;
            if (iBannerAdListener != null) {
                iBannerAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
            }
        }
    }

    /* loaded from: classes34.dex */
    class a implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f347173a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdProxy.ILoadingAdListener f347174b;

        a(Bundle bundle, AdProxy.ILoadingAdListener iLoadingAdListener) {
            this.f347173a = bundle;
            this.f347174b = iLoadingAdListener;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo;
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
            if (z16 && jSONObject != null) {
                try {
                    MiniAppAd$StGetAdRsp miniAppAd$StGetAdRsp = (MiniAppAd$StGetAdRsp) jSONObject.get("response");
                    int i3 = jSONObject.getInt("retCode");
                    String string = jSONObject.getString("errMsg");
                    String str = miniAppAd$StGetAdRsp.strAdsJson.get();
                    QLog.d("MiniLoadingAdManager", 1, "selectAd receive retCode= " + i3 + " errMsg=" + string);
                    if (QLog.isColorLevel()) {
                        QLog.d("AdProxyImpl", 2, "adJson=" + str);
                    }
                    String appendToJson = AdUtils.appendToJson(str, AdUtils.KEY_AD_STYLE_TYPE, miniAppAd$StGetAdRsp.extInfo.attachInfo.get());
                    if (TextUtils.isEmpty(appendToJson)) {
                        MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_EMPTY, this.f347173a, null, null);
                    }
                    if (i3 != 0 || TextUtils.isEmpty(appendToJson)) {
                        return;
                    }
                    List<com.tencent.gdtad.aditem.GdtAd> convertJson2GdtAds = AdUtils.convertJson2GdtAds(appendToJson);
                    String str2 = "";
                    ArrayList<Long> arrayList = new ArrayList<>();
                    for (int i16 = 0; i16 < convertJson2GdtAds.size(); i16++) {
                        com.tencent.gdtad.aditem.GdtAd gdtAd = convertJson2GdtAds.get(i16);
                        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && (traceInfo = reportInfo.trace_info) != null) {
                            arrayList.add(Long.valueOf(traceInfo.aid.get()));
                            if (i16 == 0) {
                                str2 = gdtAd.getTraceId();
                            }
                        }
                    }
                    MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_SUCCESS, this.f347173a, null, str2);
                    this.f347174b.onSelectAdProcessDone(appendToJson, arrayList, AdProxyImpl.this.q(miniAppAd$StGetAdRsp.extInfo.mapInfo.get()));
                    return;
                } catch (JSONException e16) {
                    QLog.e("MiniLoadingAdManager", 1, "selectAd getRewardedVideoADInfo error", e16);
                    return;
                }
            }
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_FAIL, this.f347173a, null, null);
            this.f347174b.onSelectAdProcessDone(null, new ArrayList<>(), null);
        }
    }

    /* loaded from: classes34.dex */
    class b implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f347176a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f347177b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdProxy.ILoadingAdListener f347178c;

        b(String str, String str2, AdProxy.ILoadingAdListener iLoadingAdListener) {
            this.f347176a = str;
            this.f347177b = str2;
            this.f347178c = iLoadingAdListener;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            QLog.d("MiniLoadingAdManager", 1, "requestPreloadLoadingAd receive isSuc= " + z16);
            if (z16) {
                try {
                    MiniAppAd$StGetAdRsp miniAppAd$StGetAdRsp = (MiniAppAd$StGetAdRsp) jSONObject.get("response");
                    int i3 = jSONObject.getInt("retCode");
                    String string = jSONObject.getString("errMsg");
                    String str = miniAppAd$StGetAdRsp.strAdsJson.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniLoadingAdManager", 2, "requestPreloadLoadingAd receive retCode= " + i3 + " errMsg=" + string + " adJson=" + str);
                    }
                    if (i3 == 0 && !TextUtils.isEmpty(str)) {
                        MiniLoadingAdManager.downloadAndSaveLoadingAd(str, this.f347176a, this.f347177b);
                        AdProxy.ILoadingAdListener iLoadingAdListener = this.f347178c;
                        if (iLoadingAdListener != null) {
                            iLoadingAdListener.onPreloadAdReceive(i3);
                            return;
                        }
                        return;
                    }
                } catch (JSONException e16) {
                    QLog.e("AdProxyImpl", 1, "preloadLoadingAd failed:", e16);
                }
            }
            int optInt = jSONObject != null ? jSONObject.optInt("retCode", -1) : -1;
            AdProxy.ILoadingAdListener iLoadingAdListener2 = this.f347178c;
            if (iLoadingAdListener2 != null) {
                iLoadingAdListener2.onPreloadAdReceive(optInt);
            }
        }
    }

    /* loaded from: classes34.dex */
    class c implements MiniLoadingAdLayout.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdProxy.ILoadingAdListener f347180a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f347181b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f347182c;

        c(AdProxy.ILoadingAdListener iLoadingAdListener, MiniAppInfo miniAppInfo, String str) {
            this.f347180a = iLoadingAdListener;
            this.f347181b = miniAppInfo;
            this.f347182c = str;
        }

        @Override // com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.OnDismissListener
        public void onDismiss(boolean z16) {
            AdProxy.ILoadingAdListener iLoadingAdListener = this.f347180a;
            if (iLoadingAdListener != null) {
                iLoadingAdListener.onAdDismiss(z16);
            }
            if (z16) {
                MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_SKIP_CLICK, this.f347181b, this.f347182c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public interface e {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static final class f {

        /* renamed from: b, reason: collision with root package name */
        private static int f347191b;

        /* renamed from: a, reason: collision with root package name */
        private SDKRewardedVideoAdView f347192a;

        f(SDKRewardedVideoAdView sDKRewardedVideoAdView) {
            this.f347192a = sDKRewardedVideoAdView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AD_PROXY_ACTION_MOTIVE_BROWSING_END#index#");
            int i3 = f347191b;
            f347191b = i3 + 1;
            sb5.append(i3);
            return sb5.toString();
        }
    }

    /* loaded from: classes34.dex */
    private class g extends AdProxy.AbsBlockAdView {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f347193a;

        /* renamed from: b, reason: collision with root package name */
        AdProxy.IBlockAdListener f347194b;

        /* renamed from: c, reason: collision with root package name */
        BlockAdView f347195c;

        /* renamed from: d, reason: collision with root package name */
        BlockAdInfo f347196d;

        /* renamed from: e, reason: collision with root package name */
        String f347197e;

        /* renamed from: f, reason: collision with root package name */
        String f347198f;

        /* renamed from: g, reason: collision with root package name */
        int f347199g;

        /* renamed from: h, reason: collision with root package name */
        int f347200h;

        /* renamed from: i, reason: collision with root package name */
        String f347201i;

        /* renamed from: j, reason: collision with root package name */
        String f347202j;

        /* renamed from: k, reason: collision with root package name */
        String f347203k;

        /* renamed from: l, reason: collision with root package name */
        String f347204l;

        /* renamed from: m, reason: collision with root package name */
        String f347205m;

        /* renamed from: n, reason: collision with root package name */
        ArrayList<String> f347206n;

        /* loaded from: classes34.dex */
        class a implements AdProxy.ICmdListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f347208a;

            a(Activity activity) {
                this.f347208a = activity;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    try {
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String string2 = jSONObject.getString("response");
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("getBlockADInfo receive retCode= ");
                        sb5.append(i3);
                        sb5.append(" adJson=");
                        sb5.append((string2 == null || string2.length() <= 1024) ? string2 : string2.substring(0, 1024));
                        QLog.i("AdProxyImpl", 1, sb5.toString());
                        if (i3 == 0 && !TextUtils.isEmpty(string2)) {
                            try {
                                if (new JSONObject(string2).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) != 0) {
                                    AdProxy.IBlockAdListener iBlockAdListener = g.this.f347194b;
                                    if (iBlockAdListener != null) {
                                        iBlockAdListener.onNoAD(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                                        return;
                                    }
                                    return;
                                }
                                List<com.tencent.gdtad.aditem.GdtAd> convertJson2GdtAds = AdUtils.convertJson2GdtAds(string2);
                                g.this.f347196d.setAdMiniAppInfo(convertJson2GdtAds);
                                g.this.f347206n = BlockAdManager.getInstance().getReportUrlList(convertJson2GdtAds);
                                g.this.f347195c = BlockAdManager.getInstance().genarateBlockAdView(this.f347208a, g.this.f347196d);
                                int realAdNum = g.this.f347195c.getRealAdNum();
                                int realWidth = g.this.f347196d.getRealWidth();
                                int realHeight = g.this.f347196d.getRealHeight();
                                if (realAdNum < 1) {
                                    AdProxy.IBlockAdListener iBlockAdListener2 = g.this.f347194b;
                                    if (iBlockAdListener2 != null) {
                                        iBlockAdListener2.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
                                        return;
                                    }
                                    return;
                                }
                                if (convertJson2GdtAds != null) {
                                    AdProxy.IBlockAdListener iBlockAdListener3 = g.this.f347194b;
                                    if (iBlockAdListener3 != null) {
                                        iBlockAdListener3.onADReceive(realAdNum, realWidth, realHeight);
                                    }
                                    g gVar = g.this;
                                    AdProxyImpl.this.v(string2, gVar.f347199g);
                                    return;
                                }
                                AdProxy.IBlockAdListener iBlockAdListener4 = g.this.f347194b;
                                if (iBlockAdListener4 != null) {
                                    iBlockAdListener4.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                QLog.e("AdProxyImpl", 1, "check adsJson exception:", th5);
                                AdProxy.IBlockAdListener iBlockAdListener5 = g.this.f347194b;
                                if (iBlockAdListener5 != null) {
                                    iBlockAdListener5.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                                    return;
                                }
                                return;
                            }
                        }
                        if (g.this.f347194b != null) {
                            int retCodeByServerResult = PluginConst.AdConst.getRetCodeByServerResult(i3);
                            if (retCodeByServerResult != -1) {
                                i3 = retCodeByServerResult;
                            }
                            g.this.f347194b.onNoAD(i3, string);
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        QLog.e("AdProxyImpl", 1, "loadAD, err", e16);
                        AdProxy.IBlockAdListener iBlockAdListener6 = g.this.f347194b;
                        if (iBlockAdListener6 != null) {
                            iBlockAdListener6.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                            return;
                        }
                        return;
                    }
                }
                AdProxy.IBlockAdListener iBlockAdListener7 = g.this.f347194b;
                if (iBlockAdListener7 != null) {
                    iBlockAdListener7.onNoAD(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                }
            }
        }

        public g(Activity activity, String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, int i26, int i27, String str4, String str5, String str6, String str7, String str8, AdProxy.IBlockAdListener iBlockAdListener) {
            super();
            this.f347193a = new WeakReference<>(activity);
            this.f347194b = iBlockAdListener;
            this.f347197e = str;
            this.f347198f = str3;
            this.f347199g = i26;
            this.f347200h = i27;
            this.f347201i = str4;
            this.f347202j = str5;
            this.f347203k = str6;
            this.f347204l = str7;
            this.f347205m = str8;
            BlockAdInfo blockAdInfo = new BlockAdInfo(str2, i3, i16, i17, i18, i19);
            this.f347196d = blockAdInfo;
            blockAdInfo.setCurrentMiniAppId(str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public ArrayList<String> getReportUrl() {
            return this.f347206n;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public View getView() {
            return this.f347195c;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public View updateAdInfo(int i3, int i16) {
            AdProxy.IBlockAdListener iBlockAdListener;
            BlockAdInfo blockAdInfo = this.f347196d;
            if (blockAdInfo == null || this.f347195c == null) {
                return null;
            }
            blockAdInfo.setLeft(i3);
            this.f347196d.setTop(i16);
            this.f347195c.setData(this.f347196d);
            if (this.f347195c.getRealAdNum() == 0 && (iBlockAdListener = this.f347194b) != null) {
                iBlockAdListener.onNoAD(1009, PluginConst.AdConst.ERROR_MSG_INVALID_POSITION);
                return null;
            }
            return this.f347195c;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public void destroy(Context context) {
            this.f347193a = null;
            this.f347194b = null;
            BlockAdView blockAdView = this.f347195c;
            if (blockAdView != null) {
                blockAdView.destroy();
            }
            this.f347195c = null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public void clearBlockAdAnimation(AdProxy.AbsBlockAdView absBlockAdView) {
            if (absBlockAdView == null || !(absBlockAdView.getView() instanceof BlockAdView)) {
                return;
            }
            ((BlockAdView) absBlockAdView.getView()).clearBlockAdAnimation();
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public void loadAD() {
            WeakReference<Activity> weakReference = this.f347193a;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadAD, act is null, ");
                sb5.append(this.f347194b != null);
                QLog.e("AdProxyImpl", 1, sb5.toString());
                AdProxy.IBlockAdListener iBlockAdListener = this.f347194b;
                if (iBlockAdListener != null) {
                    iBlockAdListener.onNoAD(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return;
                }
                return;
            }
            BlockAdManager.getInstance().initActivitySize(activity);
            AdProxyImpl.this.requestAdInfo(activity, this.f347198f, this.f347196d.getAdUnitId(), this.f347197e, 53, this.f347199g, this.f347200h, this.f347201i, this.f347202j, this.f347203k, this.f347204l, this.f347205m, this.f347196d.getSize(), new a(activity));
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBlockAdView
        public void showBlockAdAnimation(AdProxy.AbsBlockAdView absBlockAdView) {
            if (absBlockAdView == null || !(absBlockAdView.getView() instanceof BlockAdView)) {
                return;
            }
            BlockAdView blockAdView = (BlockAdView) absBlockAdView.getView();
            blockAdView.startBlockAnimation();
            BlockAdInfo blockAdInfo = this.f347196d;
            if (blockAdInfo == null || blockAdInfo.getGdtAdInfoList().isEmpty()) {
                return;
            }
            Iterator<com.tencent.gdtad.aditem.GdtAd> it = this.f347196d.getGdtAdInfoList().iterator();
            while (it.hasNext()) {
                com.tencent.gdtad.util.f.f109553a.a(blockAdView, 0, it.next(), this.f347197e);
            }
        }
    }

    /* loaded from: classes34.dex */
    private class h extends AdProxy.AbsBoxAdView {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f347210a;

        /* renamed from: b, reason: collision with root package name */
        AdProxy.IBoxADLisener f347211b;

        /* renamed from: c, reason: collision with root package name */
        IGdtAdBox f347212c;

        /* renamed from: d, reason: collision with root package name */
        String f347213d;

        /* renamed from: e, reason: collision with root package name */
        String f347214e;

        /* renamed from: f, reason: collision with root package name */
        String f347215f;

        /* renamed from: g, reason: collision with root package name */
        int f347216g;

        /* renamed from: h, reason: collision with root package name */
        int f347217h;

        /* renamed from: i, reason: collision with root package name */
        String f347218i;

        /* renamed from: j, reason: collision with root package name */
        String f347219j;

        /* renamed from: k, reason: collision with root package name */
        String f347220k;

        /* renamed from: l, reason: collision with root package name */
        String f347221l;

        /* renamed from: m, reason: collision with root package name */
        String f347222m;

        /* renamed from: n, reason: collision with root package name */
        boolean f347223n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes34.dex */
        public class a implements AdProxy.ICmdListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean f347225a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f347226b;

            /* renamed from: com.tencent.qqmini.proxyimpl.AdProxyImpl$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes34.dex */
            class C9400a implements GdtAdBoxListener {
                C9400a() {
                }

                @Override // com.tencent.gdtad.basics.adbox.GdtAdBoxListener
                public void onDismiss() {
                    AdProxy.IBoxADLisener iBoxADLisener = h.this.f347211b;
                    if (iBoxADLisener != null) {
                        iBoxADLisener.onDismiss();
                    }
                }

                @Override // com.tencent.gdtad.basics.adbox.GdtAdBoxListener
                public void onRefresh() {
                    h.this.c();
                }
            }

            a(boolean z16, Activity activity) {
                this.f347225a = z16;
                this.f347226b = activity;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    try {
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String string2 = jSONObject.getString("response");
                        if (i3 == 0 && !TextUtils.isEmpty(string2)) {
                            if (new JSONObject(string2).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) != 0) {
                                AdProxy.IBoxADLisener iBoxADLisener = h.this.f347211b;
                                if (iBoxADLisener != null) {
                                    iBoxADLisener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                                    return;
                                }
                                return;
                            }
                            if (this.f347225a) {
                                QLog.d("AdProxyImpl", 1, "load ad");
                                h.this.f347212c = ((IGdtAPI) QRoute.api(IGdtAPI.class)).buildAdBox(this.f347226b, string2, "biz_src_miniapp", new C9400a());
                            } else {
                                QLog.d("AdProxyImpl", 1, "refresh ad");
                                IGdtAdBox iGdtAdBox = h.this.f347212c;
                                if (iGdtAdBox != null) {
                                    iGdtAdBox.refresh(((IGdtAPI) QRoute.api(IGdtAPI.class)).getAdBoxRefreshData(string2, "biz_src_miniapp"));
                                }
                            }
                            h hVar = h.this;
                            if (hVar.f347212c != null) {
                                AdProxy.IBoxADLisener iBoxADLisener2 = hVar.f347211b;
                                if (iBoxADLisener2 != null) {
                                    iBoxADLisener2.onLoad();
                                }
                                h hVar2 = h.this;
                                AdProxyImpl.this.v(string2, hVar2.f347216g);
                                return;
                            }
                            AdProxy.IBoxADLisener iBoxADLisener3 = hVar.f347211b;
                            if (iBoxADLisener3 != null) {
                                iBoxADLisener3.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                                return;
                            }
                            return;
                        }
                        int retCodeByServerResult = PluginConst.AdConst.getRetCodeByServerResult(i3);
                        if (retCodeByServerResult != -1) {
                            i3 = retCodeByServerResult;
                        }
                        IGdtAdBox iGdtAdBox2 = h.this.f347212c;
                        if (iGdtAdBox2 != null && !this.f347225a) {
                            iGdtAdBox2.refresh(((IGdtAPI) QRoute.api(IGdtAPI.class)).getAdBoxRefreshData(null, "biz_src_miniapp"));
                        }
                        AdProxy.IBoxADLisener iBoxADLisener4 = h.this.f347211b;
                        if (iBoxADLisener4 != null) {
                            iBoxADLisener4.onError(i3, string);
                            return;
                        }
                        return;
                    } catch (JSONException e16) {
                        QLog.e("AdProxyImpl", 1, "requestAd, err", e16);
                        IGdtAdBox iGdtAdBox3 = h.this.f347212c;
                        if (iGdtAdBox3 != null && !this.f347225a) {
                            iGdtAdBox3.refresh(((IGdtAPI) QRoute.api(IGdtAPI.class)).getAdBoxRefreshData(null, "biz_src_miniapp"));
                        }
                        AdProxy.IBoxADLisener iBoxADLisener5 = h.this.f347211b;
                        if (iBoxADLisener5 != null) {
                            iBoxADLisener5.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                            return;
                        }
                        return;
                    }
                }
                IGdtAdBox iGdtAdBox4 = h.this.f347212c;
                if (iGdtAdBox4 != null && !this.f347225a) {
                    iGdtAdBox4.refresh(((IGdtAPI) QRoute.api(IGdtAPI.class)).getAdBoxRefreshData(null, "biz_src_miniapp"));
                }
                AdProxy.IBoxADLisener iBoxADLisener6 = h.this.f347211b;
                if (iBoxADLisener6 != null) {
                    iBoxADLisener6.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                }
            }
        }

        public h(Activity activity, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8, AdProxy.IBoxADLisener iBoxADLisener) {
            super();
            this.f347223n = false;
            this.f347210a = new WeakReference<>(activity);
            this.f347211b = iBoxADLisener;
            this.f347213d = str;
            this.f347214e = str2;
            this.f347215f = str3;
            this.f347216g = i3;
            this.f347217h = i16;
            this.f347218i = str4;
            this.f347219j = str5;
            this.f347220k = str6;
            this.f347221l = str7;
            this.f347222m = str8;
        }

        private void a() {
            this.f347223n = this.f347210a.get().getResources().getConfiguration().orientation == 2;
        }

        private void b(int i3) {
            BaseRuntime currentRuntime;
            WeakReference<Activity> weakReference = this.f347210a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if (i3 == 2) {
                a();
            }
            if (this.f347223n && (currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime()) != null) {
                currentRuntime.onRewardedVideoAdStatusChanged(i3);
                QLog.d("AdProxyImpl", 1, "notifyBoxAdState:", Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView
        public void show() {
            IGdtAdBox iGdtAdBox = this.f347212c;
            if (iGdtAdBox != null) {
                iGdtAdBox.show();
            }
            b(2);
        }

        public void c() {
            d(false);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView
        public void destroy() {
            b(3);
            IGdtAdBox iGdtAdBox = this.f347212c;
            if (iGdtAdBox != null) {
                iGdtAdBox.destroy();
            }
            this.f347212c = null;
            this.f347210a = null;
            this.f347211b = null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView
        public void loadAD() {
            d(true);
        }

        private void d(boolean z16) {
            WeakReference<Activity> weakReference = this.f347210a;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("requestAd, act is null, ");
                sb5.append(this.f347211b != null);
                QLog.e("AdProxyImpl", 1, sb5.toString());
                AdProxy.IBoxADLisener iBoxADLisener = this.f347211b;
                if (iBoxADLisener != null) {
                    iBoxADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return;
                }
                return;
            }
            AdProxyImpl.this.requestAdInfo(activity, this.f347215f, this.f347214e, this.f347213d, 53, this.f347216g, this.f347217h, this.f347218i, this.f347219j, this.f347220k, this.f347221l, this.f347222m, 1, new a(z16, activity));
        }
    }

    /* loaded from: classes34.dex */
    private class i extends AdProxy.AbsInterstitialAdView {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Activity> f347229a;

        /* renamed from: b, reason: collision with root package name */
        AdProxy.InterstitialADLisener f347230b;

        /* renamed from: c, reason: collision with root package name */
        IGdtInterstitialAd f347231c;

        /* renamed from: d, reason: collision with root package name */
        String f347232d;

        /* renamed from: e, reason: collision with root package name */
        String f347233e;

        /* renamed from: f, reason: collision with root package name */
        String f347234f;

        /* renamed from: g, reason: collision with root package name */
        int f347235g;

        /* renamed from: h, reason: collision with root package name */
        int f347236h;

        /* renamed from: i, reason: collision with root package name */
        String f347237i;

        /* renamed from: j, reason: collision with root package name */
        String f347238j;

        /* renamed from: k, reason: collision with root package name */
        String f347239k;

        /* renamed from: l, reason: collision with root package name */
        String f347240l;

        /* renamed from: m, reason: collision with root package name */
        String f347241m;

        /* renamed from: n, reason: collision with root package name */
        WeakReference<IMiniAppContext> f347242n;

        /* renamed from: o, reason: collision with root package name */
        volatile long f347243o;

        /* loaded from: classes34.dex */
        class a implements AdProxy.ICmdListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f347245a;

            a(Activity activity) {
                this.f347245a = activity;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    try {
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String string2 = jSONObject.getString("response");
                        if (i3 == 0 && !TextUtils.isEmpty(string2)) {
                            int i16 = 0;
                            JSONObject jSONObject2 = new JSONObject(string2).optJSONArray("pos_ads_info").getJSONObject(0);
                            if (jSONObject2.optInt("ret", -1) != 0) {
                                AdProxy.InterstitialADLisener interstitialADLisener = i.this.f347230b;
                                if (interstitialADLisener != null) {
                                    interstitialADLisener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                                    return;
                                }
                                return;
                            }
                            JSONObject jSONObject3 = jSONObject2.getJSONArray("ads_info").getJSONObject(0);
                            GdtInterstitialParams gdtInterstitialParams = new GdtInterstitialParams();
                            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject3));
                            boolean z17 = i.this.f347236h == 90;
                            try {
                                gdtInterstitialParams.isRenderTypeKuikly = AdProxyImpl.this.o(((COMM.StCommonExt) jSONObject.get("extInfo")).mapInfo.get());
                            } catch (Exception e16) {
                                QLog.e("AdProxyImpl", 1, "interstitial ad getRenderType error:", e16);
                            }
                            if (!z17) {
                                i16 = 1;
                            }
                            gdtInterstitialParams.orientation = i16;
                            GdtHandler.Options b16 = i.this.b(adInfo);
                            gdtInterstitialParams.clickOptions = b16;
                            com.tencent.gdtad.aditem.GdtAd gdtAd = b16.f108486ad;
                            if (gdtAd != null) {
                                gdtInterstitialParams.adInfoJson = gdtAd.toString();
                            }
                            gdtInterstitialParams.windowTranslucentStatus = true;
                            i.this.f347231c = ((IGdtInterstitialAPI) QRoute.api(IGdtInterstitialAPI.class)).build(this.f347245a, gdtInterstitialParams);
                            AdProxy.InterstitialADLisener interstitialADLisener2 = i.this.f347230b;
                            if (interstitialADLisener2 != null) {
                                interstitialADLisener2.onLoad();
                            }
                            i iVar = i.this;
                            AdProxyImpl.this.v(string2, iVar.f347235g);
                            return;
                        }
                        int retCodeByServerResult = PluginConst.AdConst.getRetCodeByServerResult(i3);
                        if (retCodeByServerResult != -1) {
                            i3 = retCodeByServerResult;
                        }
                        AdProxy.InterstitialADLisener interstitialADLisener3 = i.this.f347230b;
                        if (interstitialADLisener3 != null) {
                            interstitialADLisener3.onError(i3, string);
                            return;
                        }
                        return;
                    } catch (JSONException e17) {
                        QLog.e("AdProxyImpl", 1, "loadAD, err", e17);
                        AdProxy.InterstitialADLisener interstitialADLisener4 = i.this.f347230b;
                        if (interstitialADLisener4 != null) {
                            interstitialADLisener4.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                            return;
                        }
                        return;
                    }
                }
                AdProxy.InterstitialADLisener interstitialADLisener5 = i.this.f347230b;
                if (interstitialADLisener5 != null) {
                    interstitialADLisener5.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                }
            }
        }

        public i(Activity activity, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8, AdProxy.InterstitialADLisener interstitialADLisener, IMiniAppContext iMiniAppContext) {
            super();
            this.f347229a = new WeakReference<>(activity);
            this.f347230b = interstitialADLisener;
            this.f347232d = str;
            this.f347233e = str2;
            this.f347234f = str3;
            this.f347235g = i3;
            this.f347236h = i16;
            this.f347237i = str4;
            this.f347238j = str5;
            this.f347239k = str6;
            this.f347240l = str7;
            this.f347241m = str8;
            this.f347242n = new WeakReference<>(iMiniAppContext);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GdtHandler.Options b(qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
            GdtHandler.Options options = new GdtHandler.Options();
            options.f108486ad = new com.tencent.gdtad.aditem.GdtAd(adInfo);
            options.reportForClick = true;
            options.appAutoDownload = true;
            Bundle bundle = new Bundle();
            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniapp");
            options.extra = bundle;
            return options;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView
        public void onClose(Activity activity, int i3, Intent intent) {
            try {
                IGdtInterstitialAd iGdtInterstitialAd = this.f347231c;
                if (iGdtInterstitialAd == null || activity == null) {
                    return;
                }
                iGdtInterstitialAd.onClose(activity, i3, intent);
            } catch (Exception e16) {
                QLog.e("AdProxyImpl", 1, "onClose", e16);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView
        public boolean show(Activity activity) {
            AdProxy.InterstitialADLisener interstitialADLisener;
            if (this.f347231c == null || activity == null) {
                return false;
            }
            WeakReference<IMiniAppContext> weakReference = this.f347242n;
            this.f347231c.setAntiSpamParamsForDisplayOnReportServer(ae.b(weakReference != null ? weakReference.get() : null, this.f347243o, this.f347233e));
            boolean show = this.f347231c.show(activity);
            if (show && (interstitialADLisener = this.f347230b) != null) {
                interstitialADLisener.onShow();
            }
            return show;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView
        public void destroy() {
            this.f347231c = null;
            this.f347229a = null;
            this.f347230b = null;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView
        public void loadAD() {
            WeakReference<Activity> weakReference = this.f347229a;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadAD, act is null, ");
                sb5.append(this.f347230b != null);
                QLog.e("AdProxyImpl", 1, sb5.toString());
                AdProxy.InterstitialADLisener interstitialADLisener = this.f347230b;
                if (interstitialADLisener != null) {
                    interstitialADLisener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return;
                }
                return;
            }
            this.f347243o = System.currentTimeMillis();
            AdProxyImpl.this.requestAdInfo(activity, this.f347234f, this.f347233e, this.f347232d, 53, this.f347235g, this.f347236h, this.f347237i, this.f347238j, this.f347239k, this.f347240l, this.f347241m, 1, new a(activity));
        }
    }

    public AdProxyImpl() {
        if (QLog.isColorLevel()) {
            QLog.d("AdProxyImpl", 2, "AdProxyImpl constructor");
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONArray l(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", -1);
            if (optInt != 0 && optInt == 102006) {
                QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
                return null;
            }
            return ((JSONObject) jSONObject.getJSONArray("pos_ads_info").get(0)).getJSONArray("ads_info");
        } catch (Exception e16) {
            QLog.e("AdProxyImpl", 1, "mockAdJson failed e:", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(List<COMM.Entry> list) {
        if (list.isEmpty()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            COMM.Entry entry = list.get(i3);
            if (TextUtils.equals(entry.key.get(), "kuikly") && TextUtils.equals(entry.value.get(), "1")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleOwner p(Activity activity) {
        if (activity instanceof LifecycleOwner) {
            return (LifecycleOwner) activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> q(List<COMM.Entry> list) {
        if (list.isEmpty()) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < list.size(); i3++) {
            COMM.Entry entry = list.get(i3);
            hashMap.put(entry.key.get(), entry.value.get());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qq_ad_get.QQAdGetRsp.AdInfo s(String str) {
        try {
            return (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str)));
        } catch (Exception e16) {
            QLog.i("AdProxyImpl", 2, "parseJson2AdInfo error" + str, e16);
            return null;
        }
    }

    private void t() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("AD_PROXY_ACTION_MOTIVE_BROWSING_END");
        if (QLog.isColorLevel()) {
            QLog.d("AdProxyImpl", 2, "onCreate registerReceiver mRewardedBrowsingCallbackReceiver");
        }
        this.f347099b = new RewardedBrowsingCallbackReceiver(null, this);
        BaseApplicationImpl.getApplication().registerReceiver(this.f347099b, intentFilter);
    }

    public static void u(final String str) {
        QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd reportUrl = " + str);
        if (TextUtils.isEmpty(str) || !URLUtil.isNetworkUrl(str)) {
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.connect();
                    QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd rspCode" + httpURLConnection.getResponseCode());
                } catch (Throwable th5) {
                    QLog.i("AdProxyImpl", 1, "reportBannerAd/BlockAd error, url = " + str, th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i3) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("gdt_cookie")) {
                String string = jSONObject.getString("gdt_cookie");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String str2 = "";
                MiniAppProxy miniAppProxy = (MiniAppProxy) AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
                if (miniAppProxy != null && miniAppProxy.getAccount() == null && AppLoaderFactory.g().getMiniAppEnv().getLoginInfo() != null) {
                    str2 = AppLoaderFactory.g().getMiniAppEnv().getLoginInfo().getAccount();
                } else if (miniAppProxy != null) {
                    str2 = miniAppProxy.getAccount();
                }
                StorageUtil.getPreference().edit().putString("gdt_cookie_" + str2 + "_" + i3, string).apply();
                QLog.i("AdProxyImpl", 1, "parseAndSaveCookie save key success, adType = " + i3 + ", value = " + string);
            }
        } catch (Exception e16) {
            QLog.i("AdProxyImpl", 1, "parseAndSaveCookie error" + str, e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public boolean adClick(Context context, String str, String str2) {
        boolean z16;
        JSONObject optJSONObject;
        if (context != null && (context instanceof Activity) && !TextUtils.isEmpty(str)) {
            Activity activity = (Activity) context;
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str3 = "";
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                if (jSONObject.has("data")) {
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null && (optJSONObject2.has("ads_info") || optJSONObject2.has("antiSpamParamsForClick") || optJSONObject2.has("antiSpamParams"))) {
                        str3 = optJSONObject2.optString("ads_info");
                        if (optJSONObject2.has("antiSpamParamsForClick")) {
                            jSONObject2 = optJSONObject2.optJSONObject("antiSpamParamsForClick");
                        }
                        if (optJSONObject2.has("antiSpamParams")) {
                            jSONObject3 = optJSONObject2.optJSONObject("antiSpamParams");
                        }
                        if (optJSONObject2.has("appAutoDownload")) {
                            z16 = optJSONObject2.getBoolean("appAutoDownload");
                            QLog.i("AdProxyImpl", 1, "adClick, appAutoDownload=" + z16);
                            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str3)));
                            GdtHandler.Params params = new GdtHandler.Params();
                            params.processId = 11;
                            params.activity = new WeakReference<>(activity);
                            params.f108486ad = new com.tencent.gdtad.aditem.GdtAd(adInfo);
                            params.reportForClick = true;
                            params.appAutoDownload = z16;
                            Bundle bundle = new Bundle();
                            bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniappD");
                            params.extra = bundle;
                            params.antiSpamParamsForClick = jSONObject2;
                            params.antiSpamParams = jSONObject3.toString();
                            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                            return true;
                        }
                    } else if (optJSONObject2 != null && optJSONObject2.has("data") && (optJSONObject = optJSONObject2.optJSONObject("data")) != null) {
                        if (optJSONObject.has("ads_info")) {
                            str3 = optJSONObject.optString("ads_info");
                        }
                        if (optJSONObject.has("antiSpamParamsForClick")) {
                            jSONObject2 = optJSONObject.optJSONObject("antiSpamParamsForClick");
                        }
                        if (optJSONObject2.has("antiSpamParams")) {
                            jSONObject3 = optJSONObject2.optJSONObject("antiSpamParams");
                        }
                        if (optJSONObject.has("appAutoDownload")) {
                            z16 = optJSONObject2.getBoolean("appAutoDownload");
                            QLog.i("AdProxyImpl", 1, "adClick, appAutoDownload=" + z16);
                            qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str3)));
                            GdtHandler.Params params2 = new GdtHandler.Params();
                            params2.processId = 11;
                            params2.activity = new WeakReference<>(activity);
                            params2.f108486ad = new com.tencent.gdtad.aditem.GdtAd(adInfo2);
                            params2.reportForClick = true;
                            params2.appAutoDownload = z16;
                            Bundle bundle2 = new Bundle();
                            bundle2.putString(LaunchParam.KEY_REF_ID, "biz_src_miniappD");
                            params2.extra = bundle2;
                            params2.antiSpamParamsForClick = jSONObject2;
                            params2.antiSpamParams = jSONObject3.toString();
                            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params2);
                            return true;
                        }
                    }
                }
                z16 = false;
                QLog.i("AdProxyImpl", 1, "adClick, appAutoDownload=" + z16);
                qq_ad_get.QQAdGetRsp.AdInfo adInfo22 = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(str3)));
                GdtHandler.Params params22 = new GdtHandler.Params();
                params22.processId = 11;
                params22.activity = new WeakReference<>(activity);
                params22.f108486ad = new com.tencent.gdtad.aditem.GdtAd(adInfo22);
                params22.reportForClick = true;
                params22.appAutoDownload = z16;
                Bundle bundle22 = new Bundle();
                bundle22.putString(LaunchParam.KEY_REF_ID, "biz_src_miniappD");
                params22.extra = bundle22;
                params22.antiSpamParamsForClick = jSONObject2;
                params22.antiSpamParams = jSONObject3.toString();
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params22);
                return true;
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public boolean adExposure(Context context, String str, String str2) {
        return super.adExposure(context, str, str2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void destroy(Activity activity) {
        if (this.f347099b != null) {
            try {
                BaseApplicationImpl.getApplication().unregisterReceiver(this.f347099b);
            } catch (Throwable th5) {
                QLog.e("AdProxyImpl", 1, "unregisterReceiver exception.", th5);
            }
            this.f347099b = null;
        }
        BlockAdManager.getInstance().hideAllBlockAdView();
        this.f347100c = null;
        this.f347098a = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void getVipWithoutAdMemberState() {
        VipWithoutAdHelper.requestVipWithoutAdMemberState();
        VipWithoutAdHelper.showToast();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void onActivityResult(int i3, int i16, Intent intent) {
        Bundle bundle;
        if (QLog.isColorLevel()) {
            QLog.d("AdProxyImpl", 2, "[onActivityResult] requestCode=" + i3 + " resultCode=" + i16);
        }
        if (i3 == 4760 && this.f347100c != null) {
            if (intent != null && intent.getExtras() != null) {
                bundle = intent.getExtras();
            } else {
                bundle = new Bundle();
                QLog.e("AdProxyImpl", 1, "[onActivityResult] resultData is empty!");
            }
            this.f347100c.f(i16, bundle);
            this.f347100c = null;
        }
        if (this.f347101d != null) {
            ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onActivityResult(this.f347101d, i3, i16, intent);
            QLog.d("AdProxyImpl", 1, "loading ad onActivityResult");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void onActivityStart() {
        super.onActivityStart();
        ae.j();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void onActivityStop() {
        super.onActivityStop();
        ae.k();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void onFirstFrame() {
        super.onFirstFrame();
        ae.e();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void selectLoadingAd(Bundle bundle, String str, AdProxy.ILoadingAdListener iLoadingAdListener) {
        MiniAppAd$StGetAdReq m3 = m(bundle);
        if (iLoadingAdListener == null || m3 == null) {
            return;
        }
        MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_REQ_START, bundle, null, null);
        MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(m3, new a(bundle, iLoadingAdListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public class SDKRewardedVideoAdView extends AdProxy.AbsRewardVideoAdView {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<Context> f347153a;

        /* renamed from: b, reason: collision with root package name */
        AdProxy.IRewardVideoAdListener f347154b;

        /* renamed from: c, reason: collision with root package name */
        GdtMotiveVideoPageData f347155c;

        /* renamed from: d, reason: collision with root package name */
        String f347156d;

        /* renamed from: e, reason: collision with root package name */
        String f347157e;

        /* renamed from: f, reason: collision with root package name */
        String f347158f;

        /* renamed from: g, reason: collision with root package name */
        String f347159g;

        /* renamed from: h, reason: collision with root package name */
        int f347160h;

        /* renamed from: i, reason: collision with root package name */
        int f347161i;

        /* renamed from: j, reason: collision with root package name */
        String f347162j;

        /* renamed from: k, reason: collision with root package name */
        String f347163k;

        /* renamed from: l, reason: collision with root package name */
        String f347164l;

        /* renamed from: m, reason: collision with root package name */
        String f347165m;

        /* renamed from: n, reason: collision with root package name */
        String f347166n;

        /* renamed from: o, reason: collision with root package name */
        boolean f347167o;

        /* renamed from: p, reason: collision with root package name */
        IMiniAppContext f347168p;

        /* loaded from: classes34.dex */
        class a implements AdProxy.ICmdListener {
            a() {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ICmdListener
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                QLog.i("AdProxyImpl", 1, "onCmdListener: " + jSONObject);
                if (z16 && jSONObject != null) {
                    try {
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String string2 = jSONObject.getString("response");
                        if (i3 == 0 && !TextUtils.isEmpty(string2)) {
                            if (new JSONObject(string2).optInt("ret", -1) != 102006) {
                                JSONArray l3 = AdProxyImpl.this.l(string2);
                                String obj = (l3 == null || l3.isNull(0)) ? null : l3.get(0).toString();
                                SDKRewardedVideoAdView sDKRewardedVideoAdView = SDKRewardedVideoAdView.this;
                                sDKRewardedVideoAdView.f347155c = sDKRewardedVideoAdView.d(obj);
                                qq_ad_get.QQAdGetRsp.AdInfo s16 = TextUtils.isEmpty(obj) ? null : AdProxyImpl.this.s(obj);
                                if (SDKRewardedVideoAdView.this.f347155c != null && s16 != null) {
                                    com.tencent.gdtad.aditem.GdtAd gdtAd = new com.tencent.gdtad.aditem.GdtAd(s16);
                                    if (SDKRewardedVideoAdView.this.f347154b != null) {
                                        SDKRewardedVideoAdView.this.f347154b.onADLoad(AdUtils.getExpParam(gdtAd));
                                    }
                                    SDKRewardedVideoAdView sDKRewardedVideoAdView2 = SDKRewardedVideoAdView.this;
                                    AdProxyImpl.this.v(obj, sDKRewardedVideoAdView2.f347160h);
                                    ae.n(SDKRewardedVideoAdView.this.f347155c.adId + "", gdtAd.getUrlForClick());
                                    ae.o(SDKRewardedVideoAdView.this.f347155c.adId + "");
                                    SDKRewardedVideoAdView sDKRewardedVideoAdView3 = SDKRewardedVideoAdView.this;
                                    sDKRewardedVideoAdView3.f347155c.appId = sDKRewardedVideoAdView3.f347157e;
                                    return;
                                }
                                QLog.e("AdProxyImpl", 1, "first adInfo is null");
                                return;
                            }
                            QLog.e("AdProxyImpl", 1, "mockAdJson failed ret == 102006");
                            AdProxy.IRewardVideoAdListener iRewardVideoAdListener = SDKRewardedVideoAdView.this.f347154b;
                            if (iRewardVideoAdListener != null) {
                                iRewardVideoAdListener.onError(1004, PluginConst.AdConst.ERROR_MSG_NO_AD);
                                return;
                            }
                            return;
                        }
                        int retCodeByServerResult = PluginConst.AdConst.getRetCodeByServerResult(i3);
                        if (retCodeByServerResult != -1) {
                            i3 = retCodeByServerResult;
                        }
                        AdProxy.IRewardVideoAdListener iRewardVideoAdListener2 = SDKRewardedVideoAdView.this.f347154b;
                        if (iRewardVideoAdListener2 != null) {
                            iRewardVideoAdListener2.onError(i3, string);
                            return;
                        }
                        return;
                    } catch (JSONException unused) {
                        AdProxy.IRewardVideoAdListener iRewardVideoAdListener3 = SDKRewardedVideoAdView.this.f347154b;
                        if (iRewardVideoAdListener3 != null) {
                            iRewardVideoAdListener3.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                            return;
                        }
                        return;
                    }
                }
                AdProxy.IRewardVideoAdListener iRewardVideoAdListener4 = SDKRewardedVideoAdView.this.f347154b;
                if (iRewardVideoAdListener4 != null) {
                    iRewardVideoAdListener4.onError(1000, PluginConst.AdConst.ERROR_MSG_SERVICE_FAIL);
                }
            }
        }

        public SDKRewardedVideoAdView(Context context, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, String str8, AdProxy.IRewardVideoAdListener iRewardVideoAdListener, IMiniAppContext iMiniAppContext) {
            super();
            this.f347167o = false;
            this.f347153a = new WeakReference<>(context);
            this.f347154b = iRewardVideoAdListener;
            this.f347157e = str;
            this.f347158f = str2;
            this.f347159g = str3;
            this.f347160h = i3;
            this.f347161i = i16;
            this.f347162j = str4;
            this.f347163k = str5;
            this.f347164l = str6;
            this.f347165m = str7;
            this.f347166n = str8;
            this.f347168p = iMiniAppContext;
        }

        private void c() {
            this.f347167o = this.f347153a.get().getResources().getConfiguration().orientation == 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GdtMotiveVideoPageData d(String str) {
            int rewardVideoShowTimeFromExp;
            GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
            qq_ad_get.QQAdGetRsp.AdInfo s16 = !TextUtils.isEmpty(str) ? AdProxyImpl.this.s(str) : null;
            if (s16 == null) {
                return null;
            }
            com.tencent.gdtad.aditem.GdtAd gdtAd = new com.tencent.gdtad.aditem.GdtAd(s16);
            if (gdtAd.isValid()) {
                GdtPreLoader.c().h(gdtAd);
                gdtMotiveVideoPageData = bf.a(gdtAd, str, this.f347161i == 90 ? 0 : 1);
                if (gdtMotiveVideoPageData != null && (rewardVideoShowTimeFromExp = AdUtils.getRewardVideoShowTimeFromExp(gdtAd)) > 0) {
                    gdtMotiveVideoPageData.setVideoCountDown(rewardVideoShowTimeFromExp);
                }
            }
            return gdtMotiveVideoPageData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i3) {
            WeakReference<Context> weakReference;
            BaseRuntime currentRuntime;
            if (this.f347155c == null || (weakReference = this.f347153a) == null || weakReference.get() == null) {
                return;
            }
            if (i3 == 2) {
                c();
            }
            if ((this.f347167o && this.f347155c.isForcePortrait) && (currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime()) != null) {
                currentRuntime.onRewardedVideoAdStatusChanged(i3);
                QLog.d("AdProxyImpl", 1, "notifyOriginRewardedVideoAdState:", Integer.valueOf(i3));
            }
        }

        public void f(int i3, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("AdProxyImpl", 2, "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "]");
            }
            long j3 = bundle.getLong(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME);
            long j16 = bundle.getLong("elapsed_time");
            boolean z16 = bundle.getBoolean("profitable_flag", false);
            int i16 = (int) ((j3 > j16 ? j16 : j3) / 1000);
            if (i16 > 15) {
                i16 = 15;
            }
            BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
            MiniAppInfo miniAppInfo = currentRuntime != null ? currentRuntime.getMiniAppInfo() : null;
            if (miniAppInfo != null) {
                miniAppInfo.gameAdsTotalTime += i16;
                QLog.d("AdProxyImpl", 1, "RewardedAd now gameAdsTotalTime = " + miniAppInfo.gameAdsTotalTime + ", reportTime = " + i16);
            } else {
                QLog.d("AdProxyImpl", 1, "RewardedAd miniAppInfo is null");
            }
            AdProxy.IRewardVideoAdListener iRewardVideoAdListener = this.f347154b;
            if (iRewardVideoAdListener != null) {
                if (z16 && i3 == -1) {
                    iRewardVideoAdListener.onReward();
                }
                this.f347154b.onADClose(this.f347156d);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AdProxyImpl", 1, "RewardedAd ActivityResultListener receive durationTime= " + j3 + " elaspedTime=" + j16 + " profitable=" + z16 + ", resultCode = " + i3);
            }
            if (AdProxyImpl.this.f347098a != null) {
                AdProxyImpl.this.f347098a.a();
                QLog.d("AdProxyImpl", 1, "mBannerAdRefreshListener.onRefreshResume()");
            }
            e(3);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView
        public void showAD(Context context, String str) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            AdResultReceiver adResultReceiver = null;
            Activity activity = (context == null || !(context instanceof Activity)) ? null : (Activity) context;
            if (activity != null && (gdtMotiveVideoPageData = this.f347155c) != null) {
                this.f347156d = str;
                gdtMotiveVideoPageData.refId = "biz_src_miniapp";
                gdtMotiveVideoPageData.supportOpenMotiveAd = true;
                gdtMotiveVideoPageData.containerType = 1;
                if (GdtUtil.parseDataType(gdtMotiveVideoPageData) != 1) {
                    adResultReceiver = new AdResultReceiver(new Handler(Looper.getMainLooper()), this);
                } else {
                    f fVar = new f(this);
                    String c16 = fVar.c();
                    QLog.i("AdProxyImpl", 1, "mvBrowing dataKey = " + c16 + ", data =" + fVar.f347192a);
                    if (AdProxyImpl.f347097e == null) {
                        AdProxyImpl.f347097e = new HashMap();
                    }
                    this.f347155c.motiveBrowsingKey = c16;
                    AdProxyImpl.f347097e.put(c16, fVar);
                }
                this.f347155c.antiSpamParams = ae.h(this.f347168p, this.f347155c.adId + "", this.f347158f);
                IMiniAppContext iMiniAppContext = this.f347168p;
                if (iMiniAppContext != null) {
                    this.f347155c.isMiniGame = iMiniAppContext.isMiniGame();
                }
                ((IGdtAPI) QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.build(activity, this.f347155c, adResultReceiver));
                AdProxy.IRewardVideoAdListener iRewardVideoAdListener = this.f347154b;
                if (iRewardVideoAdListener != null) {
                    iRewardVideoAdListener.onADShow();
                }
                if (AdProxyImpl.this.f347098a != null) {
                    AdProxyImpl.this.f347098a.b();
                    QLog.d("AdProxyImpl", 1, "mBannerAdRefreshListener.onRefreshPause()");
                }
                e(2);
                return;
            }
            QLog.d("AdProxyImpl", 1, "data is not GdtMotiveVideoPageData");
            AdProxy.IRewardVideoAdListener iRewardVideoAdListener2 = this.f347154b;
            if (iRewardVideoAdListener2 != null) {
                iRewardVideoAdListener2.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView
        public void loadAD(Context context) {
            final LifecycleOwner p16;
            if (context == null) {
                AdProxy.IRewardVideoAdListener iRewardVideoAdListener = this.f347154b;
                if (iRewardVideoAdListener != null) {
                    iRewardVideoAdListener.onError(1003, PluginConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return;
                }
                return;
            }
            if ((this.f347153a.get() instanceof Activity) && (p16 = AdProxyImpl.this.p((Activity) this.f347153a.get())) != null) {
                p16.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKRewardedVideoAdView.1
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    public void onDestroy() {
                        SDKRewardedVideoAdView sDKRewardedVideoAdView = SDKRewardedVideoAdView.this;
                        sDKRewardedVideoAdView.f347154b = null;
                        sDKRewardedVideoAdView.e(3);
                        p16.getLifecycle().removeObserver(this);
                    }
                });
            }
            QLog.i("AdProxyImpl", 1, "reward load");
            AdProxyImpl.this.requestAdInfo(context, this.f347159g, this.f347158f, this.f347157e, 53, this.f347160h, this.f347161i, this.f347162j, this.f347163k, this.f347164l, this.f347165m, this.f347166n, 1, new a());
        }
    }

    private MiniAppAd$StGetAdReq m(Bundle bundle) {
        long parseLong;
        int i3 = bundle.getInt(AdProxy.KEY_AD_TYPE);
        int i16 = bundle.getInt(AdProxy.KEY_MODE);
        int i17 = bundle.getInt(AdProxy.KEY_SHARE_RATE);
        int i18 = bundle.getInt(AdProxy.KEY_ADCOUNT);
        String string = bundle.getString(AdProxy.KEY_POSID);
        String string2 = bundle.getString(AdProxy.KEY_APPID);
        String string3 = bundle.getString(AdProxy.KEY_ACCOUNT);
        String spAdGdtCookie = AdUtils.getSpAdGdtCookie(i3);
        String string4 = bundle.getString(AdProxy.KEY_ENTRY_PATH);
        String string5 = bundle.getString(AdProxy.KEY_REPORT_DATA);
        String string6 = bundle.getString(AdProxy.KEY_REFER);
        String string7 = bundle.getString(AdProxy.KEY_VIA);
        try {
            if (TextUtils.isEmpty(string3)) {
                parseLong = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
            } else {
                parseLong = Long.parseLong(string3);
            }
            if (i16 == 0) {
                return AdUtils.createAdRequest(BaseApplication.getContext(), parseLong, string, string2, i17, i3, 0, spAdGdtCookie, string4, string5, string6, string7, 2, 2, MiniLoadingAdManager.getCurCachedAdsList(string3, string2));
            }
            if (i16 == 1) {
                return AdUtils.createAdRequest(BaseApplication.getContext(), parseLong, string, string2, i17, i3, 0, spAdGdtCookie, string4, string5, string6, string7, i18, 1, null);
            }
            return null;
        } catch (Exception e16) {
            QLog.e("AdProxyImpl", 1, "uin format error!", e16);
            return null;
        }
    }

    public void r(Intent intent) {
        String stringExtra;
        f fVar;
        if (intent == null || f347097e == null || (fVar = f347097e.get((stringExtra = intent.getStringExtra("KEY_MOTIVE_BROWSING")))) == null) {
            return;
        }
        SDKRewardedVideoAdView sDKRewardedVideoAdView = fVar.f347192a;
        QLog.i("AdProxyImpl", 1, "mvBrowing dataKey = " + stringExtra + ", data =" + sDKRewardedVideoAdView);
        f347097e.remove(stringExtra);
        if (sDKRewardedVideoAdView != null) {
            sDKRewardedVideoAdView.f(-1, intent.getExtras());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void preloadLoadingAd(Bundle bundle, AdProxy.ILoadingAdListener iLoadingAdListener) {
        if (bundle == null) {
            return;
        }
        MiniAppAd$StGetAdReq m3 = m(bundle);
        String string = bundle.getString(AdProxy.KEY_APPID);
        MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(m3, new b(bundle.getString(AdProxy.KEY_ACCOUNT), string, iLoadingAdListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GdtHandler.Params n(Activity activity, qq_ad_get.QQAdGetRsp.AdInfo adInfo, IMiniAppContext iMiniAppContext, String str) {
        if (activity == null || adInfo == null) {
            return null;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = 11;
        params.activity = new WeakReference<>(activity);
        params.f108486ad = new com.tencent.gdtad.aditem.GdtAd(adInfo);
        params.reportForClick = true;
        params.appAutoDownload = true;
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_miniapp");
        params.extra = bundle;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = adInfo.report_info;
        if (reportInfo != null) {
            params.antiSpamParamsForClick = ae.f(iMiniAppContext, reportInfo.click_url.get(), str);
        }
        return params;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void requestAdInfo(final Context context, final String str, final String str2, final String str3, final int i3, final int i16, final int i17, final String str4, final String str5, final String str6, final String str7, final String str8, final int i18, final AdProxy.ICmdListener iCmdListener) {
        if (context == null) {
            QLog.i("AdProxyImpl", 1, "context is null");
            if (iCmdListener != null) {
                iCmdListener.onCmdListener(true, null);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.1

            /* renamed from: com.tencent.qqmini.proxyimpl.AdProxyImpl$1$a */
            /* loaded from: classes34.dex */
            class a implements MiniAppCmdInterface {
                a() {
                }

                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (z16 && jSONObject != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            MiniAppAd$StGetAdRsp miniAppAd$StGetAdRsp = (MiniAppAd$StGetAdRsp) jSONObject.get("response");
                            int i3 = jSONObject.getInt("retCode");
                            String string = jSONObject.getString("errMsg");
                            String str = miniAppAd$StGetAdRsp.strAdsJson.get();
                            QLog.d("AdProxyImpl", 1, "getADInfo receive retCode= " + i3 + " errMsg=" + string);
                            if (QLog.isColorLevel()) {
                                QLog.d("AdProxyImpl", 2, "adJson=" + str);
                            }
                            jSONObject2.put("retCode", i3);
                            jSONObject2.put("errMsg", string);
                            jSONObject2.put("response", str);
                            jSONObject2.put("adClass", miniAppAd$StGetAdRsp.strAdTemplateJson.get());
                            jSONObject2.put("extInfo", miniAppAd$StGetAdRsp.extInfo.get());
                            AdProxy.ICmdListener iCmdListener = iCmdListener;
                            if (iCmdListener != null) {
                                iCmdListener.onCmdListener(z16, jSONObject2);
                            }
                            if (i3 != 0 || TextUtils.isEmpty(str)) {
                                return;
                            }
                            try {
                                PBRepeatMessageField<INTERFACE$StApiAppInfo> pBRepeatMessageField = miniAppAd$StGetAdRsp.vecAppInfo;
                                if (pBRepeatMessageField == null || pBRepeatMessageField.size() <= 0 || miniAppAd$StGetAdRsp.iPreLoadLevel.get() != 2) {
                                    return;
                                }
                                for (int i16 = 0; i16 < miniAppAd$StGetAdRsp.vecAppInfo.size(); i16++) {
                                    MiniAppInfo.from(miniAppAd$StGetAdRsp.vecAppInfo.get(i16));
                                }
                                return;
                            } catch (Throwable th5) {
                                QLog.e("AdProxyImpl", 1, "preloadGpkgByConfig failed:", th5);
                                return;
                            }
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            AdProxy.ICmdListener iCmdListener2 = iCmdListener;
                            if (iCmdListener2 != null) {
                                iCmdListener2.onCmdListener(false, null);
                                return;
                            }
                            return;
                        }
                    }
                    AdProxy.ICmdListener iCmdListener3 = iCmdListener;
                    if (iCmdListener3 != null) {
                        iCmdListener3.onCmdListener(false, jSONObject);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                long longValue;
                try {
                    if (!TextUtils.isEmpty(str)) {
                        longValue = Long.parseLong(str);
                    } else {
                        longValue = Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()).longValue();
                    }
                    MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(AdUtils.createAdRequest(context, longValue, str2, str3, i3, i16, i17, str4, str5, str6, str7, str8, i18), new a());
                } catch (Exception e16) {
                    QLog.e("AdProxyImpl", 1, "uin format error!", e16);
                    AdProxy.ICmdListener iCmdListener2 = iCmdListener;
                    if (iCmdListener2 != null) {
                        iCmdListener2.onCmdListener(false, null);
                    }
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public AdProxy.AbsBannerAdView createBannerAdView(Activity activity, String str, String str2, int i3, int i16, AdProxy.IBannerAdListener iBannerAdListener, Bundle bundle, IMiniAppContext iMiniAppContext, IGetAdPosInfo iGetAdPosInfo) {
        if (activity == null || bundle == null) {
            return null;
        }
        return new SDKBannerAdView(activity, str, str2, bundle.getString(AdProxy.KEY_ACCOUNT), bundle.getInt(AdProxy.KEY_AD_TYPE), bundle.getInt(AdProxy.KEY_ORIENTATION), bundle.getString(AdProxy.KEY_GDT_COOKIE), bundle.getString(AdProxy.KEY_ENTRY_PATH), bundle.getString(AdProxy.KEY_REPORT_DATA), bundle.getString(AdProxy.KEY_REFER), bundle.getString(AdProxy.KEY_VIA), i3, i16, iBannerAdListener, iMiniAppContext, iGetAdPosInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public AdProxy.AbsBlockAdView createBlockAdView(Activity activity, String str, String str2, int i3, int i16, int i17, int i18, int i19, AdProxy.IBlockAdListener iBlockAdListener, Bundle bundle) {
        if (activity == null || bundle == null) {
            return null;
        }
        return new g(activity, str, str2, i3, i16, i17, i18, i19, bundle.getString(AdProxy.KEY_ACCOUNT), bundle.getInt(AdProxy.KEY_AD_TYPE), bundle.getInt(AdProxy.KEY_ORIENTATION), bundle.getString(AdProxy.KEY_GDT_COOKIE), bundle.getString(AdProxy.KEY_ENTRY_PATH), bundle.getString(AdProxy.KEY_REPORT_DATA), bundle.getString(AdProxy.KEY_REFER), bundle.getString(AdProxy.KEY_VIA), iBlockAdListener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public AdProxy.AbsBoxAdView createBoxAdView(Activity activity, String str, String str2, AdProxy.IBoxADLisener iBoxADLisener, Bundle bundle) {
        if (activity == null || bundle == null) {
            return null;
        }
        return new h(activity, str, str2, bundle.getString(AdProxy.KEY_ACCOUNT), bundle.getInt(AdProxy.KEY_AD_TYPE), bundle.getInt(AdProxy.KEY_ORIENTATION), bundle.getString(AdProxy.KEY_GDT_COOKIE), bundle.getString(AdProxy.KEY_ENTRY_PATH), bundle.getString(AdProxy.KEY_REPORT_DATA), bundle.getString(AdProxy.KEY_REFER), bundle.getString(AdProxy.KEY_VIA), iBoxADLisener);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public AdProxy.AbsInterstitialAdView createInterstitialAdView(Activity activity, String str, String str2, AdProxy.InterstitialADLisener interstitialADLisener, Bundle bundle, IMiniAppContext iMiniAppContext) {
        if (activity == null || bundle == null) {
            return null;
        }
        return new i(activity, str, str2, bundle.getString(AdProxy.KEY_ACCOUNT), bundle.getInt(AdProxy.KEY_AD_TYPE), bundle.getInt(AdProxy.KEY_ORIENTATION), bundle.getString(AdProxy.KEY_GDT_COOKIE), bundle.getString(AdProxy.KEY_ENTRY_PATH), bundle.getString(AdProxy.KEY_REPORT_DATA), bundle.getString(AdProxy.KEY_REFER), bundle.getString(AdProxy.KEY_VIA), interstitialADLisener, iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public AdProxy.AbsRewardVideoAdView createRewardVideoAdView(Context context, String str, String str2, AdProxy.IRewardVideoAdListener iRewardVideoAdListener, Bundle bundle, IMiniAppContext iMiniAppContext) {
        if (context == null || bundle == null) {
            return null;
        }
        return new SDKRewardedVideoAdView(context, str, str2, bundle.getString(AdProxy.KEY_ACCOUNT), bundle.getInt(AdProxy.KEY_AD_TYPE), bundle.getInt(AdProxy.KEY_ORIENTATION), bundle.getString(AdProxy.KEY_GDT_COOKIE), bundle.getString(AdProxy.KEY_ENTRY_PATH), bundle.getString(AdProxy.KEY_REPORT_DATA), bundle.getString(AdProxy.KEY_REFER), bundle.getString(AdProxy.KEY_VIA), iRewardVideoAdListener, iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void downloadRealTimeAdPic(String str, String str2, final String str3, AdProxy.ILoadingAdListener iLoadingAdListener) {
        List<com.tencent.gdtad.aditem.GdtAd> convertJson2GdtAds;
        com.tencent.gdtad.aditem.GdtAd gdtAd;
        String str4;
        long j3;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
        if (iLoadingAdListener == null || (convertJson2GdtAds = AdUtils.convertJson2GdtAds(str)) == null || convertJson2GdtAds.isEmpty() || (gdtAd = convertJson2GdtAds.get(0)) == null) {
            return;
        }
        String traceId = gdtAd.getTraceId();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAd.info;
        if (adInfo == null || (reportInfo = adInfo.report_info) == null || (traceInfo = reportInfo.trace_info) == null) {
            str4 = traceId;
            j3 = -1;
        } else {
            j3 = traceInfo.aid.get();
            str4 = gdtAd.info.report_info.trace_info.traceid.get();
        }
        final MiniLoadingAdManager.CachedAdInfo cachedAdInfo = new MiniLoadingAdManager.CachedAdInfo(gdtAd, str2, str3);
        final d dVar = new d(iLoadingAdListener, str3, str4, str, j3, cachedAdInfo);
        if (new File(cachedAdInfo.filePath).exists()) {
            QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd \u4e4b\u524d\u7684\u5b9e\u65f6\u5e7f\u544a\u4e0b\u8f7d\u8fc7 \u56e0\u5b9e\u65f6\u5e7f\u544a\u4e0d\u843d\u5730 \u5bfc\u81f4\u7684\u672c\u5730\u6709\u56fe\u7247\u4f46\u662f\u6ca1\u4fe1\u606f\u7684\u60c5\u51b5 \u76f4\u63a5\u56de\u8c03");
            iLoadingAdListener.onDownloadAdEnd(str, j3, cachedAdInfo.filePath);
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_CACHED, null, str3, str4);
        } else {
            final String str5 = str4;
            ThreadPools.getNetworkIOThreadPool().execute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.AdProxyImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download newCachedAdInfo.url= " + cachedAdInfo.url + " start");
                    MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_START, null, str3, str5);
                    MiniappDownloadUtil miniappDownloadUtil = MiniappDownloadUtil.getInstance();
                    MiniLoadingAdManager.CachedAdInfo cachedAdInfo2 = cachedAdInfo;
                    miniappDownloadUtil.download(cachedAdInfo2.url, cachedAdInfo2.filePath, false, dVar, Downloader.DownloadMode.OkHttpMode, null);
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy
    public void updateLoadingAdLayoutAndShow(Context context, MiniAppInfo miniAppInfo, boolean z16, String str, String str2, String str3, String str4, String str5, String str6, long j3, AdProxy.ILoadingAdListener iLoadingAdListener) {
        if (MiniAdExposureHelper.checkAdExpoFreqAvailable() && context != null) {
            MiniLoadingAdLayout miniLoadingAdLayout = new MiniLoadingAdLayout(context);
            miniLoadingAdLayout.initUI(AdUtils.parseToInt(AdUtils.getValueFromJson(str, AdUtils.KEY_AD_STYLE_TYPE), 0));
            boolean z17 = miniLoadingAdLayout.setupUIForSDK(miniAppInfo, z16, str, str2, str3, str4, str5, str6, j3, iLoadingAdListener);
            String traceId = miniLoadingAdLayout.getTraceId();
            MiniLoadingAdReportHelper miniLoadingAdReportHelper = MiniLoadingAdReportHelper.INSTANCE;
            miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_START, miniAppInfo, traceId);
            if (z17) {
                miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_SUCCESS, miniAppInfo, traceId);
                miniLoadingAdLayout.show(new c(iLoadingAdListener, miniAppInfo, traceId));
                if (iLoadingAdListener != null) {
                    iLoadingAdListener.onAdShow(miniLoadingAdLayout);
                }
                QLog.d("MiniLoadingAdManager", 1, "getLoadingAdLayout filePath " + str5 + "video is  " + str6);
                MiniAdExposureHelper.updateRecentExpoTimeStampList();
                if (context instanceof Activity) {
                    this.f347101d = new WeakReference<>((Activity) context);
                    QLog.d("AdProxyImpl", 1, "getLoadingAdLayout activity ref");
                    return;
                }
                return;
            }
            QLog.d("MiniLoadingAdManager", 1, "getLoadingAdLayout setup fail");
            miniLoadingAdReportHelper.reportEvent(MiniLoadingAdReportHelper.EVENT_RENDER_FAIL, miniAppInfo, traceId);
        }
    }

    /* loaded from: classes34.dex */
    class d implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdProxy.ILoadingAdListener f347184a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f347185b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f347186c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f347187d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f347188e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ MiniLoadingAdManager.CachedAdInfo f347189f;

        d(AdProxy.ILoadingAdListener iLoadingAdListener, String str, String str2, String str3, long j3, MiniLoadingAdManager.CachedAdInfo cachedAdInfo) {
            this.f347184a = iLoadingAdListener;
            this.f347185b = str;
            this.f347186c = str2;
            this.f347187d = str3;
            this.f347188e = j3;
            this.f347189f = cachedAdInfo;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + str + " canceled");
            this.f347184a.onDownloadAdEnd(null, -1L, null);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + str + " failed");
            this.f347184a.onDownloadAdEnd(null, -1L, null);
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_FAIL, null, this.f347185b, this.f347186c);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            QLog.d("MiniLoadingAdManager", 1, "processSelectAdWithUncachedAd download url= " + str + " succeed");
            this.f347184a.onDownloadAdEnd(this.f347187d, this.f347188e, this.f347189f.filePath);
            MiniLoadingAdReportHelper.INSTANCE.reportEvent(MiniLoadingAdReportHelper.EVENT_LOAD_SUCCESS, null, this.f347185b, this.f347186c);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }
}
