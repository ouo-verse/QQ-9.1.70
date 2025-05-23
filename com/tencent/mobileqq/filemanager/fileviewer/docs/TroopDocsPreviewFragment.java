package com.tencent.mobileqq.filemanager.fileviewer.docs;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.DownloadReceiver4Offline;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqnt.circularprogress.api.ICircularProgressApi;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class TroopDocsPreviewFragment extends WebViewFragment {
    private static int J = 2130706432;
    private TroopDocsPreviewPresenter C;
    int D = 0;
    int E = 0;
    int F = 0;
    String G = "";
    private com.tencent.qqnt.circularprogress.b H = null;
    private View I = null;

    private void Bh(Context context) {
        int i3;
        Integer num;
        if (uh()) {
            return;
        }
        Ch(true);
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) DownloadReceiver4Offline.class), 201326592);
            Map<String, Object> vh5 = vh();
            if (vh5 != null && (num = (Integer) vh5.get("startHour")) != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            calendar.set(11, i3);
            calendar.set(12, 0);
            calendar.set(13, 0);
            if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
                calendar.add(5, 1);
            }
            QLog.d("TroopDocsPreviewFragment", 1, "setDailyDownloadTask time=", Integer.valueOf(i3));
            alarmManager.setRepeating(0, calendar.getTimeInMillis(), 86400000L, broadcast);
        } catch (Exception e16) {
            QLog.e("TroopDocsPreviewFragment", 1, "setDailyDownloadTask exception=", e16);
        }
    }

    public static void Ch(boolean z16) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("tencent_doc_file_daily_download_task_key", z16);
    }

    public static boolean uh() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("tencent_doc_file_daily_download_task_key", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> vh() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Map<String, Object> map = null;
        if (peekAppRuntime == null) {
            return null;
        }
        try {
            map = cooperation.vip.b.b(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("tencent_docs_preview_offline_info", null));
        } catch (Exception e16) {
            QLog.e("TroopDocsPreviewFragment", 1, "getOfflineInfo, exception=" + e16);
        }
        QLog.i("TroopDocsPreviewFragment", 1, "getOfflineInfo" + map);
        return map;
    }

    private WebViewClient wh() {
        return new a();
    }

    private void xh(final AppActivity appActivity) {
        if (getSwiftTitleUI().E != null) {
            yh(appActivity);
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TroopDocsPreviewFragment.this.getSwiftTitleUI().E != null) {
                        TroopDocsPreviewFragment.this.yh(appActivity);
                    } else {
                        QLog.e("TroopDocsPreviewFragment", 1, "initFlashTransferUi failed.");
                    }
                }
            }, 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh(AppActivity appActivity) {
        ViewParent parent = getSwiftTitleUI().E.getParent();
        if (parent instanceof RelativeLayout) {
            com.tencent.qqnt.circularprogress.b circularProgress = ((ICircularProgressApi) QRoute.api(ICircularProgressApi.class)).getCircularProgress(appActivity, 24);
            this.H = circularProgress;
            circularProgress.a("download_with_progress");
            View view = this.H.getView();
            this.I = view;
            view.setOnClickListener(this);
            this.I.setVisibility(0);
            zh((RelativeLayout) parent, getSwiftTitleUI().E, this.I, BaseAIOUtils.f(40.0f, appActivity.getResources()), BaseAIOUtils.f(40.0f, appActivity.getResources()), BaseAIOUtils.f(0.0f, appActivity.getResources()));
        }
        getSwiftTitleUI().H(true);
    }

    private void zh(RelativeLayout relativeLayout, View view, View view2, int i3, int i16, int i17) {
        if (view != null && view2 != null) {
            view2.setId(sh());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i16);
            layoutParams.addRule(17, view.getId());
            layoutParams.setMarginStart(i17);
            layoutParams.addRule(15);
            relativeLayout.addView(view2, layoutParams);
        }
    }

    public void Ah() {
        HashMap hashMap = new HashMap();
        hashMap.put("ver8", this.G);
        hashMap.put("ver9", Integer.valueOf(this.D));
        hashMap.put("ver10", Integer.valueOf(this.E));
        hashMap.put("ver11", Integer.valueOf(this.F));
        int i3 = this.E;
        if (i3 == 0) {
            hashMap.put("ver12", 0);
        } else {
            hashMap.put("ver12", Double.valueOf(Double.parseDouble(String.format("%.5f", Double.valueOf(this.F / i3)))));
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopDocsPreviewFragment", 2, "reportUseOfflinePackage, reportParams:" + hashMap);
        }
        ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).report("docs_online", "preview", "offline", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(Bundle bundle) {
        AppActivity appActivity = (AppActivity) getHostActivity();
        this.C = new TroopDocsPreviewPresenter(appActivity);
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(MobileQQ.sMobileQQ);
        if (!this.C.C(this.intent)) {
            appActivity.finish();
            return true;
        }
        Bh(appActivity);
        boolean doOnCreate = super.doOnCreate(bundle);
        if (this.C.x() == 58) {
            xh(appActivity);
            this.C.L(appActivity, true);
        }
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public String getUrlFromIntent() {
        return this.C.y();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != getSwiftTitleUI().C && view != getSwiftTitleUI().E && view != this.I) {
            super.onClick(view);
        } else if (view == this.I && this.C.x() == 58) {
            TroopDocsPreviewPresenter troopDocsPreviewPresenter = this.C;
            troopDocsPreviewPresenter.P(Long.toString(troopDocsPreviewPresenter.A()), this.H, this.I);
        } else {
            this.C.N();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Ah();
        TroopDocsPreviewPresenter troopDocsPreviewPresenter = this.C;
        if (troopDocsPreviewPresenter != null && troopDocsPreviewPresenter.x() == 58) {
            this.C.L((AppActivity) getHostActivity(), false);
        }
        super.onDestroy();
        TroopDocsPreviewPresenter troopDocsPreviewPresenter2 = this.C;
        if (troopDocsPreviewPresenter2 != null) {
            troopDocsPreviewPresenter2.t();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void setTitle(String str) {
        super.setTitle(this.C.w());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView touchWebView) {
        touchWebView.setWebViewClient(wh());
        this.C.E(touchWebView);
        super.setWebView(touchWebView);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tdoc_web_online_preview_remove_pskey_switch", false);
        th(getUrlFromIntent());
        if (isSwitchOn) {
            QLog.i("TroopDocsPreviewFragment", 1, "remove pskey switch is on");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            CookieManager.getInstance().setCookie(ITeamWorkHandler.DOCS_DOMAIN, "p_skey=; EXPIRES=" + format + ";", true);
            CookieManager.getInstance().flush();
        }
    }

    public int sh() {
        int i3 = J;
        J = i3 + 1;
        return i3;
    }

    void th(String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter(ISchemeApi.KEY_IOS_SRC_TYPE);
            if (queryParameter != null && !queryParameter.isEmpty()) {
                this.G = queryParameter;
            }
        } catch (Exception e16) {
            QLog.e("TroopDocsPreviewFragment", 1, "getCurrentPreviewUrlDocsType, exception=" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        private boolean f208254b = true;

        a() {
        }

        public WebResourceResponse a(WebView webView, String str, WebResourceRequest webResourceRequest) {
            String str2;
            Map map;
            ArrayList arrayList;
            Map vh5 = TroopDocsPreviewFragment.this.vh();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("innerShouldInterceptRequest, before url:");
                str2 = str;
                sb5.append(str2);
                QLog.i("TroopDocsPreviewFragment", 2, sb5.toString());
            } else {
                str2 = str;
            }
            if (vh5 == null || !((Boolean) vh5.get("enable")).booleanValue()) {
                return null;
            }
            TroopDocsPreviewFragment.this.D++;
            try {
                map = (Map) vh5.get("url_2_bid");
            } catch (Exception e16) {
                QLog.e("TroopDocsPreviewFragment", 1, "innerShouldInterceptRequest, exception=" + e16);
                map = null;
            }
            if (map == null) {
                return null;
            }
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                if (Pattern.compile(str3).matcher(str2).matches()) {
                    QLog.d("TroopDocsPreviewFragment", 1, "innerShouldInterceptRequest, matcher _bid:" + str4);
                    TroopDocsPreviewFragment troopDocsPreviewFragment = TroopDocsPreviewFragment.this;
                    troopDocsPreviewFragment.E = troopDocsPreviewFragment.E + 1;
                    try {
                        URL url = new URL(str2);
                        URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
                        String query = uri.getQuery();
                        if (query != null) {
                            arrayList = new ArrayList(Arrays.asList(query.split(ContainerUtils.FIELD_DELIMITER)));
                        } else {
                            arrayList = new ArrayList();
                        }
                        arrayList.add("_bid=" + str4);
                        str2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), no0.a.a(ContainerUtils.FIELD_DELIMITER, arrayList), uri.getFragment()).toString();
                    } catch (Exception e17) {
                        QLog.e("TroopDocsPreviewFragment", 1, "innerShouldInterceptRequest addBidParameterToUrl, exception=" + e17);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopDocsPreviewFragment", 2, "innerShouldInterceptRequest, after url:" + str2);
            }
            WebResourceResponse webResourceResp = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getWebResourceResp(str2, webResourceRequest);
            if (webResourceResp != null) {
                TroopDocsPreviewFragment.this.F++;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopDocsPreviewFragment", 2, "innerShouldInterceptRequest, resp:" + webResourceResp + " url=" + str2 + " totalCount=" + TroopDocsPreviewFragment.this.D + " matchCount=" + TroopDocsPreviewFragment.this.E + " hitCount=" + TroopDocsPreviewFragment.this.F);
            }
            return webResourceResp;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            QLog.d("TroopDocsPreviewFragment", 2, "onPageFinished  url:" + str + "currentProgress :" + TroopDocsPreviewFragment.this.C.z());
            if (TroopDocsPreviewFragment.this.C.z() == 100) {
                TroopDocsPreviewFragment.this.getUIStyleHandler().U.a((byte) 2);
            }
            super.onPageFinished(webView, str);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            QLog.d("TroopDocsPreviewFragment", 2, "onPageStarted  url:" + str);
            TroopDocsPreviewFragment.this.getUIStyleHandler().C.O(TroopDocsPreviewFragment.this.C.w());
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse a16 = a(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
            return a16 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a16;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            this.f208254b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f208254b = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse a16 = a(webView, str, null);
            return a16 == null ? super.shouldInterceptRequest(webView, str) : a16;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
        
            if (r3.s(r9, 16, null) == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
        
            return false;
         */
        @Override // com.tencent.smtt.sdk.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopDocsPreviewFragment", 1, "URLDecoder.decode, url:" + str);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopDocsPreviewFragment", 2, "parseUrl error,exception:" + e16.toString());
                }
            }
            if (TroopDocsPreviewFragment.this.C.B(webView, str)) {
                return true;
            }
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            String k3 = i.k(str);
            if (!"http".equals(k3) && !"https".equals(k3) && !"data".equals(k3) && !"file".equals(k3)) {
                if (pluginEngine != null && pluginEngine.S(str, this.f208254b)) {
                    QLog.d("TroopDocsPreviewFragment", 2, "shouldOverrideUrlRequest  url:" + str);
                    return true;
                }
                if (TroopDocsPreviewFragment.this.getWebViewKernelCallBack().afterWebViewEngineHandleOverrideUrl(webView, str)) {
                    QLog.d("TroopDocsPreviewFragment", 2, "afterWebViewEngineHandleOverrideUrl  url:" + str);
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            WebResourceResponse a16 = a(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
            return a16 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : a16;
        }
    }
}
