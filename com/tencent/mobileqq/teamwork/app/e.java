package com.tencent.mobileqq.teamwork.app;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.meta.WebResourceReq;
import com.tencent.localedit.fakenative.meta.WebResourceResp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.INativeEngineFileBrowserWrapper;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.nativepreview.base.primitive.NativeEngineJNI;
import com.tencent.nativepreview.service.drive.DriveUploadCallback;
import com.tencent.nativepreview.service.drive.DriveUploadRequest;
import com.tencent.nativepreview.wrapper.model.DocInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    private static WebViewClient e(String str) {
        return new a(str);
    }

    public static String f() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("sp_tencent_doc_file_browser_native_engine_ver_key", "");
    }

    public static String g() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("sp_tencent_doc_file_browser_native_engine_related_file", "");
    }

    public static WebResourceResp h(String str, WebResourceReq webResourceReq) {
        String b16 = com.tencent.mobileqq.teamwork.app.a.b(str);
        Log.d("FileBrowserUtils", "getWebResourceResp resourceUrl = " + b16);
        String d16 = com.tencent.mobileqq.teamwork.app.a.d(b16);
        Log.d("FileBrowserUtils", "getWebResourceResp offlineFilePath = " + d16);
        if (d16 == null) {
            return null;
        }
        return w11.a.f444159a.b(d16, 2592000L, com.tencent.mobileqq.teamwork.app.a.c(d16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"LongLogTag"})
    public static boolean i(final WebView webView, String str, String str2) {
        JSONObject p16;
        final JSONObject p17;
        if (str == null) {
            return false;
        }
        try {
        } catch (Exception e16) {
            Log.e("FileBrowserUtils", "url parse fail!,url: " + str + " e: " + e16);
        }
        if (str.startsWith("jsbridge://docx/getLocalServer")) {
            String optString = new JSONObject(Uri.parse(str).getQueryParameter("p")).optString("callback");
            Log.d("FileBrowserUtils", "getLocalServer - callback:" + optString);
            HashMap hashMap = new HashMap();
            StringBuilder sb5 = new StringBuilder();
            LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
            sb5.append(localEditSDK.localServer.getLocalhost());
            sb5.append(":");
            sb5.append(localEditSDK.localServer.getPort());
            hashMap.put("data", sb5.toString());
            l(webView, optString, hashMap);
            return true;
        }
        if (str.startsWith("jsbridge://docx/getLocalFileDocId") && (p17 = p(new URL(str).getQuery())) != null) {
            final String optString2 = p17.optString("filePath", "");
            QLog.d("FileBrowserUtils", 1, "getLocalFileDocId filePath:" + optString2);
            kr2.b.b(new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.app.b
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    e.n(optString2, p17, webView, obj);
                }
            });
            return true;
        }
        if (str.startsWith("jsbridge://docx/notifyOpenLocalFileResult") && (p16 = p(new URL(str).getQuery())) != null) {
            int optInt = p16.optInt("errorCode", 0);
            String optString3 = p16.optString("errorMsg", "");
            Log.d("FileBrowserUtils", "notifyOpenLocalFileResult errorCode:" + optInt + " errorMsg:" + optString3);
            r.b().c(str2, optInt, optString3);
            return true;
        }
        if (str.startsWith("jsbridge://docx/notifyLocalFilePasswordError")) {
            URL url = new URL(str);
            JSONObject p18 = p(url.getQuery());
            if (p18 != null) {
                r.b().f(url.getHost(), url.getPath().substring(1), p18.toString());
                return true;
            }
        }
        return false;
    }

    public static void j(WebSettings webSettings) {
        if (webSettings == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(webSettings.getUserAgentString());
        sb5.append(" V1_AND_SQ_7.1.0_0_TENCENT_DOCS_D Channel/0 TencentDocs/");
        String str = AppSetting.f99551k;
        sb5.append(str);
        sb5.append(".tencentdocs  Pixel/1080.0 mobile language/zh-CN MobileQQApp/");
        sb5.append(str);
        webSettings.setUserAgentString(sb5.toString());
        webSettings.setMixedContentMode(0);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(-1);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
    }

    private static void k(WebView webView) {
        webView.setWebChromeClient(new ReportX5CoreWebChromeClient());
        webView.setScrollBarStyle(0);
        webView.requestFocus();
        WebView.setWebContentsDebuggingEnabled(true);
        webView.setFocusable(true);
        webView.setFocusableInTouchMode(false);
        j(webView.getSettings());
        webView.setLayerType(2, null);
    }

    private static void l(final WebView webView, String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            final String str2 = "javascript: " + "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);".replace("((0))", str).replace("((1))", jSONObject.toString());
            QLog.d("FileBrowserUtils", 1, "invokeCallback loadUrl :" + str2);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.app.d
                @Override // java.lang.Runnable
                public final void run() {
                    WebView.this.loadUrl(str2);
                }
            });
        } catch (Exception e16) {
            QLog.e("FileBrowserUtils", 1, "invokeCallback failed, e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(WebView webView, String str, int i3, String str2, DocInfo docInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(i3));
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("msg", str2);
        if (docInfo != null) {
            hashMap.put("docId", docInfo.getDocId());
            hashMap.put("docsType", Integer.valueOf(docInfo.getDocType()));
            hashMap.put("docUrl", docInfo.getUrl());
            hashMap.put("folderId", docInfo.getFolderId());
            hashMap.put("padType", docInfo.getPadType());
            hashMap.put("localPadId", docInfo.getLocalPadId());
            hashMap.put("domainId", docInfo.getDomainId());
            hashMap.put("title", docInfo.getTitle());
        }
        QLog.d("FileBrowserUtils", 1, "getLocalFileDocId data:" + hashMap);
        l(webView, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(String str, JSONObject jSONObject, final WebView webView, Object obj) {
        String str2;
        if (!(obj instanceof INativeEngineFileBrowserWrapper.a)) {
            return;
        }
        INativeEngineFileBrowserWrapper.a aVar = (INativeEngineFileBrowserWrapper.a) obj;
        DriveUploadRequest driveUploadRequest = new DriveUploadRequest();
        driveUploadRequest.setFilePath(str);
        driveUploadRequest.setUid(aVar.f291658a);
        driveUploadRequest.setDomain(aVar.f291659b);
        if (!TextUtils.isEmpty(aVar.f291660c)) {
            str2 = aVar.f291660c;
        } else {
            str2 = "";
        }
        driveUploadRequest.setCookie(str2);
        driveUploadRequest.setDriveFolder("/\u6765\u81eaQQ\u6587\u4ef6");
        driveUploadRequest.setConvertType(10);
        final String optString = jSONObject.optString("callback");
        NativeEngineJNI.INSTANCE.uploadToDrive(driveUploadRequest, new DriveUploadCallback() { // from class: com.tencent.mobileqq.teamwork.app.c
            @Override // com.tencent.nativepreview.service.drive.DriveUploadCallback
            public final void onCallback(int i3, String str3, DocInfo docInfo) {
                e.m(WebView.this, optString, i3, str3, docInfo);
            }
        });
    }

    private static JSONObject p(String str) {
        String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (split.length == 2) {
            try {
                return new JSONObject(URLDecoder.decode(split[1], "UTF-8"));
            } catch (Exception e16) {
                QLog.e("FileBrowserUtils", 1, "parseQueryString ,e = " + e16);
                return null;
            }
        }
        return null;
    }

    public static void q(WebView webView, String str) {
        if (webView == null) {
            return;
        }
        webView.setWebViewClient(e(str));
        k(webView);
    }

    public static void r(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("sp_tencent_doc_file_browser_native_engine_ver_key", str);
    }

    public static void s(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString("sp_tencent_doc_file_browser_native_engine_related_file", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        t11.a f291924b;

        /* renamed from: c, reason: collision with root package name */
        final String f291925c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f291926d;

        a(String str) {
            this.f291926d = str;
            this.f291925c = str;
        }

        private void a(String str) {
            if (this.f291924b == null) {
                t11.a createController = LocalEditSDK.INSTANCE.createController(str);
                this.f291924b = createController;
                createController.n();
            }
        }

        private WebResourceResponse b(WebView webView, String str, WebResourceRequest webResourceRequest) {
            WebResourceReq webResourceReq;
            if (w11.a.f444159a.p(str)) {
                a(str);
            }
            if (webResourceRequest == null) {
                webResourceReq = new WebResourceReq(null, null, null, null, null, null);
            } else {
                webResourceReq = new WebResourceReq(webResourceRequest.getUrl(), Boolean.valueOf(webResourceRequest.isForMainFrame()), Boolean.valueOf(webResourceRequest.isRedirect()), Boolean.valueOf(webResourceRequest.hasGesture()), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders());
            }
            WebResourceResp d16 = this.f291924b.interceptManager.d(str, webResourceReq);
            if (d16 != null) {
                return new WebResourceResponse(d16.getMimeType(), d16.getEncoding(), d16.getStatusCode(), d16.getReasonPhrase(), d16.getResponseHeaders(), d16.getInputStream());
            }
            return null;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            RemoteWebRenderIPCClient.y().R(this.f291926d, RemoteWebViewEvent.ON_PAGE_FINISH);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
            RemoteWebRenderIPCClient.y().R(this.f291926d, RemoteWebViewEvent.ON_PAGE_STARTED);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            Log.d("FileBrowserUtils", "shouldInterceptRequest1 s = " + str);
            WebResourceResponse b16 = b(webView, str, null);
            return b16 == null ? super.shouldInterceptRequest(webView, str) : b16;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewPluginEngine pluginEngine;
            try {
                if (e.i(webView, str, this.f291925c)) {
                    QLog.d("FileBrowserUtils", 1, "tDoc_step shouldOverrideUrlLoading url = " + str);
                    return true;
                }
                if ((webView instanceof CustomWebView) && (pluginEngine = ((CustomWebView) webView).getPluginEngine()) != null && pluginEngine.S(str, true)) {
                    QLog.d("FileBrowserUtils", 1, "tDoc_step CustomWebView shouldOverrideUrlLoading url = " + str);
                    return true;
                }
                return false;
            } catch (Exception e16) {
                QLog.e("FileBrowserUtils", 1, "shouldOverrideUrlLoading e = " + e16);
                return false;
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            Log.d("FileBrowserUtils", "shouldInterceptRequest2 s = " + webResourceRequest.getUrl());
            WebResourceResponse b16 = b(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
            return b16 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : b16;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            Log.d("FileBrowserUtils", "shouldInterceptRequest3 s = " + webResourceRequest.getUrl());
            WebResourceResponse b16 = b(webView, webResourceRequest.getUrl().toString(), webResourceRequest);
            return b16 == null ? super.shouldInterceptRequest(webView, webResourceRequest, bundle) : b16;
        }
    }
}
