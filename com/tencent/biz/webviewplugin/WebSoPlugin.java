package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.webso.WebSoScreenshot;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class WebSoPlugin extends WebViewPlugin {
    public static final int E = 2131383580;
    public static final int F = 2131383581;
    private static int G = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f97516d;

    /* renamed from: h, reason: collision with root package name */
    private c f97519h;

    /* renamed from: e, reason: collision with root package name */
    public String f97517e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f97518f = "";

    /* renamed from: i, reason: collision with root package name */
    boolean[] f97520i = new boolean[1];

    /* renamed from: m, reason: collision with root package name */
    private b f97521m = new b();
    private Handler C = new a(Looper.getMainLooper());
    private boolean D = false;

    /* loaded from: classes5.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 203 && (message.obj instanceof Bundle)) {
                com.tencent.mobileqq.webview.webso.e.h("handle MSG_WNS_HTTP_GET_DATA");
                try {
                    WebSoPlugin.this.w((Bundle) message.obj);
                } catch (OutOfMemoryError unused) {
                    com.tencent.mobileqq.webview.webso.e.h("oom on receive");
                }
            }
        }

        @Override // android.os.Handler
        public String toString() {
            return "WnsProxyHandler" + super.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private WebSoService.WebSoState.WebSo3 f97525a;

        /* renamed from: b, reason: collision with root package name */
        private String f97526b;

        b() {
        }

        private void a(WebSoPlugin webSoPlugin, String str, WebSoService.WebSoState.WebSo3 webSo3) {
            if (webSo3 != null && !TextUtils.isEmpty(str)) {
                com.tencent.mobileqq.webview.webso.e.h("callJs");
                try {
                    webSoPlugin.callJs(str, this.f97525a.b());
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.f97526b = null;
            }
        }

        public void b() {
            com.tencent.mobileqq.webview.webso.e.h("clearJsCallback");
            this.f97526b = null;
            this.f97525a = null;
        }

        public WebSoService.WebSoState.WebSo3 c() {
            return this.f97525a;
        }

        public void d(WebSoPlugin webSoPlugin, String str) {
            com.tencent.mobileqq.webview.webso.e.h("registerGetData");
            this.f97526b = str;
            a(webSoPlugin, str, this.f97525a);
        }

        public void e(WebSoPlugin webSoPlugin, WebSoService.WebSoState.WebSo3 webSo3) {
            com.tencent.mobileqq.webview.webso.e.h("setUpWebso3");
            this.f97525a = webSo3;
            a(webSoPlugin, this.f97526b, webSo3);
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        private CustomWebView f97527a;

        /* renamed from: b, reason: collision with root package name */
        public volatile String f97528b;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f97529c = false;

        public c(CustomWebView customWebView) {
            this.f97527a = customWebView;
        }

        private void a() {
            CustomWebView customWebView;
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj doCallback body: " + this.f97528b);
            }
            if (!TextUtils.isEmpty(this.f97528b) && (customWebView = this.f97527a) != null) {
                customWebView.callJs("window._websoPageData=" + this.f97528b + "; if(window.silentCallback) {window.silentCallback(" + this.f97528b + " );}");
                this.f97528b = null;
            }
        }

        public void b(String str) {
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj onDataLoaded: " + str);
            }
            this.f97528b = str;
            if (!TextUtils.isEmpty(str)) {
                a();
            }
        }

        @JavascriptInterface
        public void catchHtml(String str) {
            String H = com.tencent.mobileqq.webview.webso.e.H(str);
            com.tencent.mobileqq.webview.webso.e.h("catchHtml");
            WebSoService.WebSoState.WebSo3 c16 = WebSoPlugin.this.f97521m.c();
            if (c16 != null) {
                WebSoService.H(H, c16.f314978e, c16.f314979f, Uri.parse(c16.f314981i));
            } else {
                com.tencent.mobileqq.webview.webso.e.h("return webSo3 == null");
            }
        }

        @JavascriptInterface
        public void didDOMContentLoaded() {
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didDOMContentLoaded.");
            }
            this.f97529c = true;
            a();
        }

        @JavascriptInterface
        public void didEventFiredWithParams(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "WebSoJavaScriptObj didEventFiredWithParams, envent: " + str + " param: " + str2);
            }
        }
    }

    public static boolean A(WebView webView) {
        u(webView);
        return true;
    }

    private void s(int i3) {
        CustomWebView customWebView;
        long j3;
        if (TextUtils.isEmpty(this.f97517e) || TextUtils.isEmpty(this.f97518f)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        if (customWebView == null) {
            return;
        }
        try {
            if (i3 != 200) {
                if (i3 == 304) {
                    jSONObject.put("code", 304);
                    if (QLog.isColorLevel()) {
                        QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + jSONObject.toString());
                    }
                    customWebView.callJs(this.f97517e, jSONObject.toString());
                }
            } else {
                JSONObject jSONObject2 = new JSONObject(this.f97518f);
                long currentTimeMillis = System.currentTimeMillis() - jSONObject2.optLong(SonicSession.WEB_RESPONSE_LOCAL_REFRESH_TIME, 0L);
                if (currentTimeMillis > 30000) {
                    if (QLog.isColorLevel()) {
                        QLog.w("WebSoPlugin", 1, "receive js call too late, " + (currentTimeMillis / 1000.0d) + ReportConstant.COSTREPORT_PREFIX);
                    }
                    this.f97518f = "";
                    this.f97517e = "";
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("WebSoPlugin", 1, "receive js call in time: " + (currentTimeMillis / 1000.0d) + ReportConstant.COSTREPORT_PREFIX);
                    j3 = 0;
                } else {
                    j3 = 0;
                }
                if (currentTimeMillis > j3) {
                    jSONObject.put(SonicSession.WEB_RESPONSE_LOCAL_REFRESH_TIME, currentTimeMillis);
                }
                jSONObject2.remove(SonicSession.WEB_RESPONSE_LOCAL_REFRESH_TIME);
                jSONObject.put("result", jSONObject2.toString());
                jSONObject.put("code", 200);
                if (QLog.isColorLevel()) {
                    QLog.i("WebSoPlugin", 1, "now call localRefresh data: , " + jSONObject.toString());
                }
                customWebView.callJs(this.f97517e, jSONObject.toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("WebSoPlugin", 1, e16, "dispatchDiffData to website error!");
        }
        this.f97518f = "";
    }

    public static int u(WebView webView) {
        if (G < 0 && webView != null) {
            G = WebView.getTbsCoreVersion(BaseApplication.getContext());
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "tbsCoreVersion= " + G);
            }
        }
        return G;
    }

    private boolean v(String str, long j3, Map<String, Object> map) {
        WebViewPlugin.b bVar;
        Activity a16;
        CustomWebView e16;
        this.D = false;
        this.f97520i[0] = false;
        this.f97521m.b();
        if (j3 != 32 || TextUtils.isEmpty(str) || (bVar = this.mRuntime) == null || (a16 = bVar.a()) == null || a16.isFinishing() || a16.getIntent() == null || (e16 = this.mRuntime.e()) == null) {
            return false;
        }
        String url = e16.getUrl();
        if (!TextUtils.isEmpty(url) && !"about:blank".equals(url)) {
            QLog.e("WebSoPlugin", 1, "now onHandleEventBeforeLoaded current url is not null! so return! " + com.tencent.biz.common.util.k.e(url, new String[0]));
            return false;
        }
        r(str);
        if (!com.tencent.mobileqq.webview.webso.e.E(str) || com.tencent.mobileqq.webview.webso.e.G(str)) {
            return false;
        }
        WebSoService.j().m(str, this.C, this.f97520i);
        x(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Bundle bundle) {
        CustomWebView customWebView;
        boolean z16;
        String b16;
        String b17;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            customWebView = bVar.e();
        } else {
            customWebView = null;
        }
        if (customWebView == null) {
            return;
        }
        String url = customWebView.getUrl();
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("url");
        bundle.getInt("req_state", 0);
        int i3 = bundle.getInt("result_code", 0);
        boolean z17 = bundle.getBoolean("is_local_data");
        String string2 = bundle.getString(QzoneCoverConst.WebViewConst.KEY_WNS_PROXY_HTTP_DATA);
        boolean isEmpty = TextUtils.isEmpty(string2);
        if (!TextUtils.isEmpty(url) && !"about:blank".equals(url)) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean z18 = bundle.getBoolean("key_wns_cache_hit", false);
        WebSoService.WebSoState.WebSo3 webSo3 = (WebSoService.WebSoState.WebSo3) bundle.getParcelable("key_webso_3");
        if (i3 == 10503) {
            QLog.e("WebSoPlugin", 1, "QZoneWebViewPlugin onReceive 503, now it reload url! " + com.tencent.biz.common.util.k.e(string, new String[0]));
            customWebView.loadUrlOriginal(string);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QZoneWebViewPlugin onReceive  htmlBody(");
        sb5.append(!isEmpty);
        sb5.append(") currentUrl(");
        sb5.append(url);
        sb5.append(") cache hit(");
        sb5.append(z18);
        sb5.append(") hasLoadCache(");
        sb5.append(this.D);
        sb5.append(") load Url: ");
        sb5.append(com.tencent.biz.common.util.k.e(string, new String[0]));
        sb5.append(",silent_mode:");
        sb5.append(bundle.getBoolean("is_silent_mode", false));
        sb5.append(",isLocalData:");
        sb5.append(z17);
        QLog.d("WebSoPlugin", 1, sb5.toString());
        if (webSo3 != null && webSo3.f314977d) {
            this.f97521m.e(this, webSo3);
            return;
        }
        this.f97521m.b();
        if (!isEmpty) {
            if (z17) {
                if (this.f97519h == null) {
                    c cVar = new c(customWebView);
                    this.f97519h = cVar;
                    customWebView.addJavascriptInterface(cVar, "_webso");
                    if (QLog.isColorLevel()) {
                        QLog.d("WebSoPlugin", 1, "js method : " + Arrays.toString(this.f97519h.getClass().getDeclaredMethods()));
                    }
                }
            } else if (bundle.getBoolean("is_silent_mode", false)) {
                QLog.d("WebSoPlugin", 1, "\u9759\u9ed8\u52a0\u8f7dhtml");
                c cVar2 = this.f97519h;
                if (cVar2 != null) {
                    cVar2.b(string2);
                    return;
                }
                return;
            }
        }
        boolean z19 = this.D;
        if (!z19 && !isEmpty && z16) {
            this.D = true;
            this.f97520i[0] = true;
            if (z17) {
                b17 = com.tencent.mobileqq.webview.webso.e.a(string, string2);
            } else {
                b17 = com.tencent.mobileqq.webview.webso.e.b(string, string2);
            }
            z(customWebView, string, b17);
            return;
        }
        if (z18) {
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 2, "webso return 304, so hit local cache!");
            }
            c cVar3 = this.f97519h;
            if (cVar3 != null) {
                cVar3.b("{\"code\":0,\"data\":null}");
            }
            this.f97518f = "304";
            s(304);
            return;
        }
        if (z19) {
            if (QLog.isColorLevel()) {
                QLog.i("WebSoPlugin", 1, "webso success load local data, now load new data ! " + this.D);
            }
            this.f97516d = true;
        }
        if (isEmpty && z16) {
            customWebView.loadUrl(string);
            x(true);
            return;
        }
        if (!isEmpty && z16) {
            if (z17) {
                b16 = com.tencent.mobileqq.webview.webso.e.a(string, string2);
            } else {
                b16 = com.tencent.mobileqq.webview.webso.e.b(string, string2);
            }
            z(customWebView, string, b16);
            return;
        }
        if (!isEmpty && !z16) {
            if (bundle.getBoolean("need_force_refresh", false)) {
                if (!z17) {
                    string2 = com.tencent.mobileqq.webview.webso.e.b(string, string2);
                }
                z(customWebView, string, string2);
                return;
            } else {
                if (bundle.getBoolean("need_local_refresh", false)) {
                    this.f97518f = bundle.getString("key_html_changed_data");
                    s(200);
                    return;
                }
                return;
            }
        }
        this.f97516d = false;
    }

    private void x(boolean z16) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        Activity a16 = bVar.a();
        if (a16 instanceof QBaseActivity) {
            WebViewFragment t16 = t((QBaseActivity) a16);
            if (t16 != null && t16.getUIStyleHandler() != null) {
                if (t16.getUIStyleHandler().U != null) {
                    t16.getUIStyleHandler().f314499a0 = !z16;
                    t16.getUIStyleHandler().U.l(z16);
                    return;
                } else {
                    t16.getUIStyleHandler().f314499a0 = !z16;
                    return;
                }
            }
            y(z16);
            return;
        }
        y(z16);
    }

    private void y(boolean z16) {
        View findViewById;
        int i3;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.e() != null && this.mRuntime.e().getRootView() != null && this.mRuntime.e().getRootView().findViewById(R.id.l2a) != null && (findViewById = this.mRuntime.e().getRootView().findViewById(R.id.l2a).findViewById(R.id.g1p)) != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            findViewById.setVisibility(i3);
        }
    }

    public static void z(CustomWebView customWebView, String str, String str2) {
        com.tencent.mobileqq.webview.webso.e.h("setdata");
        if (TextUtils.isEmpty(str)) {
            QLog.w("WebSoPlugin", 1, "setWebViewData webview url is Empty!");
        }
        if (A(customWebView)) {
            customWebView.setTag(E, str2);
            customWebView.setTag(F, Long.valueOf(System.currentTimeMillis()));
            customWebView.loadUrl(str);
            return;
        }
        customWebView.loadDataWithBaseURL(str, str2, "text/html", "utf-8", str);
    }

    void B(CustomWebView customWebView) {
        if (customWebView != null) {
            customWebView.setLayerType(1, null);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "WebSo";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        CustomWebView e16;
        WebBackForwardList copyBackForwardList;
        CustomWebView e17;
        String str2;
        String str3;
        if (j3 == 32) {
            com.tencent.mobileqq.webview.webso.e.h("KEY_EVENT_BEFORE_LOAD");
            return v(str, j3, map);
        }
        if (j3 == 8589934594L) {
            com.tencent.mobileqq.webview.webso.e.h("EVENT_LOAD_FINISH");
            if (TextUtils.isEmpty(str) || "about:bank".equals(str) || !com.tencent.mobileqq.webview.webso.e.E(str) || (e17 = this.mRuntime.e()) == null) {
                return false;
            }
            WebBackForwardList copyBackForwardList2 = e17.copyBackForwardList();
            if (copyBackForwardList2 != null && copyBackForwardList2.getSize() != 0) {
                if (QLog.isColorLevel()) {
                    for (int size = copyBackForwardList2.getSize() - 1; size >= 0; size--) {
                        WebHistoryItem itemAtIndex = copyBackForwardList2.getItemAtIndex(size);
                        if (itemAtIndex != null) {
                            QLog.i("WebSoPlugin", 2, " EVENT_LOAD_FINISH --- history: " + size + " " + itemAtIndex.getUrl());
                        }
                    }
                }
                if (copyBackForwardList2.getSize() >= 2) {
                    int size2 = copyBackForwardList2.getSize() - 1;
                    WebHistoryItem itemAtIndex2 = copyBackForwardList2.getItemAtIndex(size2);
                    WebHistoryItem itemAtIndex3 = copyBackForwardList2.getItemAtIndex(size2 - 1);
                    if (itemAtIndex2 != null && itemAtIndex3 != null) {
                        str2 = itemAtIndex2.getUrl();
                        str3 = itemAtIndex3.getUrl();
                    } else {
                        str2 = "";
                        str3 = "";
                    }
                    if (!TextUtils.isEmpty(str3) && str3.equals(str2)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("WebSoPlugin", 2, "current url equals with precious url, need clear history!");
                        }
                        this.f97516d = true;
                    }
                }
                if (this.f97516d) {
                    if (QLog.isColorLevel()) {
                        QLog.i("WebSoPlugin", 2, "now clear webview history!");
                    }
                    e17.clearHistory();
                    this.f97516d = false;
                }
            } else {
                if (this.f97516d) {
                    if (QLog.isColorLevel()) {
                        QLog.i("WebSoPlugin", 2, "now clear webview history!");
                    }
                    e17.clearHistory();
                    this.f97516d = false;
                }
                return false;
            }
        } else if (j3 == 8589934601L) {
            com.tencent.mobileqq.webview.webso.e.h("EVENT_GO_BACK");
            if (!TextUtils.isEmpty(str) && !"about:bank".equals(str) && com.tencent.mobileqq.webview.webso.e.E(str) && (e16 = this.mRuntime.e()) != null && (copyBackForwardList = e16.copyBackForwardList()) != null && copyBackForwardList.getSize() == 2) {
                if (copyBackForwardList.getItemAtIndex(copyBackForwardList.getSize() - 2).getUrl().equals(copyBackForwardList.getItemAtIndex(copyBackForwardList.getSize() - 1).getUrl())) {
                    if (QLog.isColorLevel()) {
                        QLog.i("WebSoPlugin", 2, "current url equals with precious url, need close activity!");
                    }
                    if (this.mRuntime.a() != null) {
                        this.mRuntime.a().finish();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (str2 == null || !"WebSo".equals(str2)) {
            return false;
        }
        JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebSoPlugin", 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e("WebSoPlugin", 1, "callback id is null, so return");
            return true;
        }
        if ("getWebsoDiffData".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d("WebSoPlugin", 2, "WebSo get webso js api, data: " + Arrays.toString(strArr));
            }
            if (this.mRuntime.e() != null && strArr.length > 0) {
                try {
                    String string = new JSONObject(strArr[0]).getString("callback");
                    if (!TextUtils.isEmpty(string)) {
                        this.f97517e = string;
                        if (!TextUtils.isEmpty(this.f97518f)) {
                            if (this.f97518f.equals("304")) {
                                s(304);
                            } else {
                                s(200);
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        } else if ("getData".equals(str3)) {
            com.tencent.mobileqq.webview.webso.e.h("js call getData");
            this.f97521m.d(this, optString);
        } else {
            try {
                if ("updateWebsoCache".equals(str3)) {
                    com.tencent.mobileqq.webview.webso.e.h("js call updateWebsoCache");
                    if (this.f97521m.c() != null) {
                        WebViewPlugin.b bVar = this.mRuntime;
                        if (bVar != null) {
                            bVar.e().loadUrl("javascript:window._webso.catchHtml(document.getElementsByTagName('html')[0].outerHTML);");
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("result", 1);
                        super.callJs(optString, jSONObject.toString());
                    } else {
                        com.tencent.mobileqq.webview.webso.e.h("return : webso == null");
                    }
                } else if ("updateScreenshot".equals(str3)) {
                    com.tencent.mobileqq.webview.webso.e.h("js call updateScreenshot");
                    WebViewPlugin.b bVar2 = this.mRuntime;
                    if (bVar2 != null) {
                        CustomWebView e17 = bVar2.e();
                        String url = e17.getUrl();
                        if (com.tencent.mobileqq.webview.webso.e.E(url)) {
                            WebSoScreenshot.a(e17, url);
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 1);
                    super.callJs(optString, jSONObject2.toString());
                } else if ("hideScreenshot".equals(str3)) {
                    com.tencent.mobileqq.webview.webso.e.h("js call hideScreenshot");
                    WebViewPlugin.b bVar3 = this.mRuntime;
                    if (bVar3 != null) {
                        WebSoScreenshot.c(bVar3.e());
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result", 1);
                    super.callJs(optString, jSONObject3.toString());
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    void r(final String str) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.WebSoPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                WebViewPlugin.b bVar;
                if (com.tencent.mobileqq.webview.webso.e.F(str) && (bVar = WebSoPlugin.this.mRuntime) != null && bVar.a() != null) {
                    WebSoPlugin.this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.WebSoPlugin.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WebViewPlugin.b bVar2 = WebSoPlugin.this.mRuntime;
                            if (bVar2 != null && bVar2.e() != null) {
                                try {
                                    WebSoPlugin webSoPlugin = WebSoPlugin.this;
                                    webSoPlugin.B(webSoPlugin.mRuntime.e());
                                } catch (Throwable th5) {
                                    QLog.e("WebSoPlugin", 1, "asynJudgmentDynamicCover, useSoftwareMode err, ExceptionMsg = " + th5.getMessage());
                                }
                            }
                        }
                    });
                }
            }
        }, 5, null, false);
    }

    public WebViewFragment t(QBaseActivity qBaseActivity) {
        List<Fragment> fragments;
        FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
        if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof WebViewFragment) {
                    return (WebViewFragment) fragment;
                }
            }
            return null;
        }
        return null;
    }
}
