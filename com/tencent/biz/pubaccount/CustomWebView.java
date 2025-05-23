package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.webview.html.l;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.p;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class CustomWebView extends SuperWebView {
    static final String CALLBACK_NAME_HOLDER = "((0))";
    static final String CALLBACK_PARAM_HOLDER = "((1))";
    static final String CALL_JS_DEFAULT_TPL = "(window.mqq && mqq.version > 20140616001 && mqq.execGlobalCallback || function(cb) {window[cb] && window[cb].apply(window, [].slice.call(arguments, 1));}).apply(window, [((0)), ((1))]);";
    public static final String TAG = "CustomWebView";
    public static final String TAG_WEBVIEW_CHECK = "WEBVIEWCHECK";
    public static final String TAG_WEBVIEW_LOAD = "webviewLoad";
    protected static SparseArray<String> mMsg4CallbackMap = null;
    static String sCallJsTpl = null;
    private static byte sInterceptOn = -1;
    public static String sLastContextLog;
    protected boolean attachedToWindow;
    String cookieUrl;
    t43.b cookiesCallback;
    protected boolean isDestroyed;
    protected boolean isFirstIntercept;
    protected boolean isFirstLoad;
    public boolean isPaused;
    protected c mOpenApiInfo;
    protected WebViewPluginEngine mPluginEngine;
    public boolean mWebIsInitMiniAIO;

    /* renamed from: mt, reason: collision with root package name */
    d f78785mt;
    boolean needSetCookies;
    protected l sessionClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements t43.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f78787a;

        a(b bVar) {
            this.f78787a = bVar;
        }

        @Override // t43.b
        public void a(String str, Bundle bundle, long j3) {
            b bVar = this.f78787a;
            int i3 = bVar.f78789a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            CustomWebView.this.loadDataWithBaseURL(str, bVar.f78791c, bVar.f78792d, bVar.f78793e, bVar.f78794f);
                            return;
                        }
                        return;
                    }
                    CustomWebView.this.loadData(str, bVar.f78792d, bVar.f78793e);
                    return;
                }
                CustomWebView.this.loadUrlOriginal(str);
                return;
            }
            CustomWebView.this.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f78789a = 1;

        /* renamed from: b, reason: collision with root package name */
        String f78790b;

        /* renamed from: c, reason: collision with root package name */
        String f78791c;

        /* renamed from: d, reason: collision with root package name */
        String f78792d;

        /* renamed from: e, reason: collision with root package name */
        String f78793e;

        /* renamed from: f, reason: collision with root package name */
        String f78794f;

        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f78796a;

        /* renamed from: b, reason: collision with root package name */
        public String f78797b;

        /* renamed from: c, reason: collision with root package name */
        public String f78798c;

        /* renamed from: d, reason: collision with root package name */
        public long f78799d;

        /* renamed from: e, reason: collision with root package name */
        public int f78800e;

        /* renamed from: f, reason: collision with root package name */
        public HashMap<String, Long> f78801f;

        public void a() {
            HashMap<String, Long> hashMap = this.f78801f;
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface d {
        void onSChanged(int i3, int i16, int i17, int i18);
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>(8);
        mMsg4CallbackMap = sparseArray;
        sparseArray.put(0, "recode_successed");
        mMsg4CallbackMap.put(1, "recode_failed_permission_denied");
        mMsg4CallbackMap.put(2, "recode_failed_token_verify_time_out");
        mMsg4CallbackMap.put(3, "recode_failed_no_such_method");
        mMsg4CallbackMap.put(4, "recode_failed_params_error");
        mMsg4CallbackMap.put(5, "recode_failed_frequency_limit");
    }

    public CustomWebView(Context context) {
        super(context);
        this.isPaused = true;
        this.isDestroyed = false;
        this.attachedToWindow = false;
        this.isFirstLoad = true;
        this.isFirstIntercept = true;
        this.needSetCookies = true;
        this.cookiesCallback = null;
        this.cookieUrl = "";
    }

    public static void addContextLog(String str) {
        if (str != null && !str.equals(sLastContextLog)) {
            long currentTimeMillis = System.currentTimeMillis();
            sLastContextLog = str;
            if (str.length() > 512) {
                str = str.substring(0, 512);
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 2) {
                str = str + " at " + stackTrace[2].toString();
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG_WEBVIEW_LOAD, 4, "cost:" + (System.currentTimeMillis() - currentTimeMillis) + " " + str);
            }
            ((com.tencent.mobileqq.webview.swift.injector.k) aa.k(com.tencent.mobileqq.webview.swift.injector.k.class)).c(TAG_WEBVIEW_LOAD, str);
        }
    }

    private Intent getIntent() {
        Activity activity;
        Intent intent = this.mIntent;
        if (intent != null) {
            return intent;
        }
        WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
        if (webViewPluginEngine != null && (activity = webViewPluginEngine.f314119i) != null) {
            return activity.getIntent();
        }
        return null;
    }

    private boolean handleIntercept(String str, boolean z16) {
        if (isInterceptOn() && this.isFirstIntercept) {
            this.isFirstIntercept = false;
            HashMap hashMap = new HashMap();
            hashMap.put(WebViewPlugin.KEY_ORIGINAL_LOAD, Boolean.valueOf(z16));
            WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
            if (webViewPluginEngine != null && webViewPluginEngine.t(str, hashMap)) {
                QLog.w(TAG, 1, "loadUrl is intercepted. isOriginal: " + z16 + ", url: " + s.d(str, new String[0]));
                return true;
            }
        }
        return false;
    }

    private static boolean isInterceptOn() {
        if (sInterceptOn < 0) {
            sInterceptOn = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("105926", false) ? (byte) 1 : (byte) 0;
            QLog.i(TAG, 1, "isInterceptOn: " + ((int) sInterceptOn));
        }
        if (sInterceptOn != 1) {
            return false;
        }
        return true;
    }

    private boolean isNeedSetCookies() {
        Intent intent;
        if (this.needSetCookies && (intent = getIntent()) != null && intent.getBooleanExtra("ignoreLoginWeb", false)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ignore login state, set key cookie abort.");
            }
            this.needSetCookies = false;
        }
        return this.needSetCookies;
    }

    private boolean setCookiesIfNeeded(b bVar) {
        if (!this.needSetCookies) {
            return false;
        }
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(bVar.f78790b);
        if (!"http".equals(k3) && !"https".equals(k3)) {
            return false;
        }
        this.cookiesCallback = new a(bVar);
        SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(bVar.f78790b);
        if (s16 == null) {
            return false;
        }
        this.needSetCookies = false;
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("avoidLoginWeb", false)) {
            s16.e();
            return false;
        }
        String str = bVar.f78790b;
        this.cookieUrl = str;
        s16.I(str, this.cookiesCallback, null, intent);
        return true;
    }

    public void callJs(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, QLog.getStackTraceString(new Throwable("func is empty")));
                return;
            }
            return;
        }
        if (sCallJsTpl == null) {
            String x16 = AuthorizeConfig.y().x("jscallback", null);
            if (x16 != null && x16.contains(CALLBACK_NAME_HOLDER) && x16.contains(CALLBACK_PARAM_HOLDER)) {
                sCallJsTpl = x16;
            } else {
                sCallJsTpl = CALL_JS_DEFAULT_TPL;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        if (strArr != null && strArr.length > 0 && !"".equals(strArr[0])) {
            sb5.append(strArr[0]);
            int length = strArr.length;
            for (int i3 = 1; i3 < length; i3++) {
                sb5.append(',');
                sb5.append(strArr[i3]);
            }
        } else {
            sb5.append("void(0)");
        }
        callJs(sCallJsTpl.replace(CALLBACK_NAME_HOLDER, s.l(str)).replace(CALLBACK_PARAM_HOLDER, sb5));
    }

    public void callJs4OpenApi(JsBridgeListener jsBridgeListener, int i3, String... strArr) {
        if (jsBridgeListener != null && jsBridgeListener.f314007b != -1) {
            String str = mMsg4CallbackMap.get(i3);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", i3);
                if (str == null) {
                    str = "";
                }
                jSONObject.put("msg", str);
                StringBuilder sb5 = new StringBuilder();
                if (strArr != null && strArr.length > 0 && !"".equals(strArr[0])) {
                    sb5.append(strArr[0]);
                    int length = strArr.length;
                    for (int i16 = 1; i16 < length; i16++) {
                        sb5.append(',');
                        sb5.append(strArr[i16]);
                    }
                } else {
                    sb5.append("{}");
                }
                jSONObject.put("data", sb5.toString());
                String jSONObject2 = jSONObject.toString();
                if (QLog.isColorLevel()) {
                    QLog.d("CustomWebView.troop.openapi", 2, "callJs4OpenApi,listener.sn" + jsBridgeListener.f314007b + " | result:" + jSONObject2);
                }
                callJs(CALL_JS_DEFAULT_TPL.replace(CALLBACK_NAME_HOLDER, s.l(jsBridgeListener.f314007b + "")).replace(CALLBACK_PARAM_HOLDER, jSONObject2));
                return;
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("CustomWebView.troop.openapi", 2, "callJs4OpenApi, JSONException");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "callJs4OpenApi, listener == null || listener.sn == -1");
        }
    }

    public boolean checkToken(CustomWebView customWebView, int i3, String str, String str2, String str3, JsBridgeListener jsBridgeListener) {
        boolean z16;
        boolean z17;
        String str4;
        if (customWebView == null) {
            return false;
        }
        if ("auth.init".equals(str3)) {
            return true;
        }
        if (this.mOpenApiInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e("CustomWebView.troop.openapi", 2, "mOpenApiInfo == null");
            }
            return false;
        }
        if (i3 != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            long serverTime = NetConnInfoCenter.getServerTime();
            if (QLog.isColorLevel()) {
                QLog.e("CustomWebView.troop.openapi", 2, "serverTime - mOpenApiInfo.expireTime:" + (serverTime - this.mOpenApiInfo.f78799d));
            }
            if (serverTime > this.mOpenApiInfo.f78799d) {
                customWebView.callJs4OpenApi(jsBridgeListener, 2, JsBridgeListener.a(2, null, "token_verify_time_out"));
                if (QLog.isColorLevel()) {
                    QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_TOKEN_VERIFY_TIME_OUT");
                }
                return false;
            }
            String str5 = i3 + "_" + str + "_" + str2;
            String str6 = "mqq." + str3;
            c cVar = this.mOpenApiInfo;
            if (cVar != null && !TextUtils.isEmpty(cVar.f78798c) && str5.equals(this.mOpenApiInfo.f78798c)) {
                z16 = false;
            } else {
                z16 = true;
            }
            HashMap<String, Long> hashMap = this.mOpenApiInfo.f78801f;
            if (hashMap != null) {
                Iterator<String> it = hashMap.keySet().iterator();
                str4 = null;
                while (true) {
                    if (it.hasNext()) {
                        str4 = it.next();
                        if (Pattern.compile(str4).matcher(str6).find()) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
            } else {
                z17 = false;
                str4 = null;
            }
            if (!z16 && z17) {
                long longValue = this.mOpenApiInfo.f78801f.get(str4).longValue() + this.mOpenApiInfo.f78800e;
                if (QLog.isColorLevel()) {
                    QLog.e("CustomWebView.troop.openapi", 2, "expectedTime - System.currentTimeMillis():" + (longValue - System.currentTimeMillis()));
                }
                if (longValue > System.currentTimeMillis()) {
                    customWebView.callJs4OpenApi(jsBridgeListener, 5, JsBridgeListener.a(5, null, "frequency_limit"));
                    if (QLog.isColorLevel()) {
                        QLog.e("CustomWebView.troop.openapi", 2, "frequency_limit");
                    }
                    return false;
                }
                this.mOpenApiInfo.f78801f.put(str4, Long.valueOf(System.currentTimeMillis()));
                return true;
            }
            customWebView.callJs4OpenApi(jsBridgeListener, 1, JsBridgeListener.a(1, null, "permission_denied"));
            if (QLog.isColorLevel()) {
                QLog.e("CustomWebView.troop.openapi", 2, "permission_denied");
            }
            return false;
        }
        customWebView.callJs4OpenApi(jsBridgeListener, 4, JsBridgeListener.a(4, null, "params_error"));
        if (QLog.isColorLevel()) {
            QLog.e("CustomWebView.troop.openapi", 2, "RECODE_FAILED_PARAMS_ERROR");
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView, com.tencent.smtt.sdk.WebView
    public void destroy() {
        this.isDestroyed = true;
        QLog.d(TAG, 1, "on destroy");
        if (this.cookiesCallback != null && !TextUtils.isEmpty(this.cookieUrl)) {
            SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(this.cookieUrl);
            if (s16 != null) {
                s16.F(this.cookiesCallback);
            }
            this.cookiesCallback = null;
            this.cookieUrl = "";
        }
        if (!this.attachedToWindow) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.CustomWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(CustomWebView.TAG, 2, "webview real destroy now");
                    }
                    CustomWebView.this.destroyWebView();
                }
            }, 1000L);
        }
        c cVar = this.mOpenApiInfo;
        if (cVar != null) {
            cVar.a();
            this.mOpenApiInfo = null;
        }
    }

    public void destroyWebView() {
        try {
            ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        } catch (NoSuchMethodException e19) {
            e19.printStackTrace();
        } catch (Exception e26) {
            e26.printStackTrace();
        }
        try {
            super.destroy();
        } catch (Exception e27) {
            e27.printStackTrace();
        }
    }

    public String getCookieUrl() {
        return this.cookieUrl;
    }

    public l getHtmlSessionClient() {
        return this.sessionClient;
    }

    public c getOpenApiTokenInfo() {
        return this.mOpenApiInfo;
    }

    public WebViewPluginEngine getPluginEngine() {
        return this.mPluginEngine;
    }

    public boolean goBack(Map<String, Object> map) {
        WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
        if (webViewPluginEngine != null && webViewPluginEngine.s(getUrl(), 8589934601L, map)) {
            return false;
        }
        super.stopLoading();
        super.goBack();
        return true;
    }

    public boolean goForward(Map<String, Object> map) {
        WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
        if (webViewPluginEngine != null && webViewPluginEngine.s(getUrl(), 8589934602L, map)) {
            return false;
        }
        super.stopLoading();
        super.goForward();
        return true;
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadData(String str, String str2, String str3) {
        if (this.isDestroyed) {
            return;
        }
        if (isNeedSetCookies()) {
            b bVar = new b();
            bVar.f78789a = 3;
            bVar.f78790b = str;
            bVar.f78792d = str2;
            bVar.f78793e = str3;
            if (setCookiesIfNeeded(bVar)) {
                return;
            }
        }
        if (this.isFirstLoad) {
            this.isFirstLoad = false;
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
            if (webViewPluginEngine != null && webViewPluginEngine.p(hashMap)) {
                return;
            } else {
                str = (String) hashMap.get("url");
            }
        }
        addContextLog(str);
        super.loadData(str, str2, str3);
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (this.isDestroyed) {
            return;
        }
        if (isNeedSetCookies()) {
            b bVar = new b();
            bVar.f78789a = 4;
            bVar.f78790b = str;
            bVar.f78791c = str2;
            bVar.f78792d = str3;
            bVar.f78793e = str4;
            bVar.f78794f = str5;
            if (setCookiesIfNeeded(bVar)) {
                return;
            }
        }
        if (this.isFirstLoad) {
            this.isFirstLoad = false;
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
            if (webViewPluginEngine != null && webViewPluginEngine.p(hashMap)) {
                return;
            } else {
                str = (String) hashMap.get("url");
            }
        }
        String str7 = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        sb5.append(s.d(str7, new String[0]));
        sb5.append("]");
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 128) {
                str6 = str2.substring(0, 128);
            } else {
                str6 = str2;
            }
            sb5.append(str6);
        }
        addContextLog(sb5.toString());
        super.loadDataWithBaseURL(str7, str2, str3, str4, str5);
    }

    public void loadDataWithBaseURLAndHeader(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) {
        if (getX5WebViewExtension() != null && QbSdk.getTbsVersion(BaseApplication.getContext()) >= 43304) {
            getX5WebViewExtension().loadDataWithBaseURLWithHeaders(str, str2, str3, str4, str5, hashMap);
            QLog.d(TAG, 1, "loadDataWithBaseURLAndHeader");
            super.readyForLoadJs();
            return;
        }
        loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadDataWithHeaders(String str, String str2, String str3, HashMap<String, String> hashMap) {
        if (getX5WebViewExtension() != null && QbSdk.getTbsVersion(BaseApplication.getContext()) >= 43304) {
            QLog.d(TAG, 1, "loadDataWithHeaders");
            getX5WebViewExtension().loaddataWithHeaders(str, str2, str3, hashMap);
        } else {
            loadData(str, str2, str3);
        }
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView, com.tencent.qimei.webview.QmX5Webview, com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView, com.tencent.smtt.sdk.WebView
    public void loadUrl(String str) {
        l lVar;
        WebViewPluginEngine webViewPluginEngine;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView needLoadUrl000: " + str + ", loadUrl url:" + s.d(str, new String[0]));
        }
        if (this.isDestroyed) {
            return;
        }
        boolean z16 = true;
        if (isNeedSetCookies()) {
            b bVar = new b();
            bVar.f78789a = 1;
            bVar.f78790b = str;
            if (setCookiesIfNeeded(bVar)) {
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView needLoadUrl111: " + str + ", loadUrl url:" + s.d(str, new String[0]));
        }
        if (handleIntercept(str, false)) {
            return;
        }
        if (this.isFirstLoad) {
            this.isFirstLoad = false;
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            WebViewPluginEngine webViewPluginEngine2 = this.mPluginEngine;
            if (webViewPluginEngine2 != null && webViewPluginEngine2.p(hashMap)) {
                return;
            } else {
                str = (String) hashMap.get("url");
            }
        }
        if (TextUtils.isEmpty(str) || ((webViewPluginEngine = this.mPluginEngine) != null && webViewPluginEngine.R(str))) {
            z16 = false;
        }
        if (z16 && (lVar = this.sessionClient) != null) {
            lVar.b(str);
            return;
        }
        if (z16 && ((str.startsWith("http") || str.startsWith("data:")) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
            addContextLog(s.d(str, new String[0]));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView needLoadUrl222: " + z16 + ", loadUrl url:" + s.d(str, new String[0]));
            VipWebViewReportLog.f241748m = str;
        }
        p.b(this, p.f314878b);
        if (z16) {
            super.loadUrl(str);
        }
    }

    public void loadUrlOriginal(String str) {
        QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView loadUrlOriginal000 url:" + str);
        if (this.isDestroyed) {
            return;
        }
        if ("about:blank".equals(str)) {
            super.loadUrl(str);
            return;
        }
        if (isNeedSetCookies()) {
            b bVar = new b();
            bVar.f78789a = 2;
            bVar.f78790b = str;
            if (setCookiesIfNeeded(bVar)) {
                return;
            }
        }
        QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView loadUrlOriginal111 url:" + str);
        if (handleIntercept(str, true)) {
            return;
        }
        if (this.isFirstLoad) {
            this.isFirstLoad = false;
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            WebViewPluginEngine webViewPluginEngine = this.mPluginEngine;
            if (webViewPluginEngine != null && webViewPluginEngine.p(hashMap)) {
                return;
            } else {
                str = (String) hashMap.get("url");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG_WEBVIEW_CHECK, 2, "tendocpreload CustomWebView loadUrlOriginal222 url:" + s.d(str, new String[0]));
        }
        if ((str.startsWith("http") || str.startsWith("data:")) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
            addContextLog(s.d(str, new String[0]));
        }
        super.loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        if (this.isDestroyed) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.CustomWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(CustomWebView.TAG, 2, "webview real destroy now");
                    }
                    CustomWebView.this.destroyWebView();
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void onPause() {
        this.isPaused = true;
        super.onPause();
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void onResume() {
        this.isPaused = false;
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        d dVar = this.f78785mt;
        if (dVar != null) {
            dVar.onSChanged(i3, i16, i17, i18);
        }
    }

    public void recordHttpStream(boolean z16) {
        try {
            IX5WebSettingsExtension settingsExtension = getSettingsExtension();
            if (settingsExtension != null) {
                settingsExtension.setRecordRequestEnabled(z16);
            }
        } catch (Throwable unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "webkit not support request record!");
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.SuperWebView
    public void resetForReuse() {
        super.resetForReuse();
        clearHistory();
        if (this.cookiesCallback != null && !TextUtils.isEmpty(this.cookieUrl)) {
            SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(this.cookieUrl);
            if (s16 != null) {
                s16.F(this.cookiesCallback);
            }
            this.cookiesCallback = null;
            this.cookieUrl = "";
        }
        this.attachedToWindow = false;
        this.isPaused = true;
        this.isDestroyed = false;
        this.isFirstLoad = true;
        this.needSetCookies = true;
        c cVar = this.mOpenApiInfo;
        if (cVar != null) {
            cVar.a();
            this.mOpenApiInfo = null;
        }
        setIntent(null);
        setWebChromeClient(null);
        setWebViewClient(null);
        setDownloadListener(null);
        setOnLongClickListener(null);
        if (getX5WebViewExtension() != null) {
            getX5WebViewExtension().setWebViewClientExtension(null);
        }
        getView().setOnTouchListener(null);
        setMask(false);
        this.mPluginEngine = null;
    }

    public void saveToken(int i3, String str, String str2, int i16, int i17, ArrayList<String> arrayList) {
        if (this.mOpenApiInfo == null) {
            this.mOpenApiInfo = new c();
        }
        c cVar = this.mOpenApiInfo;
        cVar.f78796a = i3;
        cVar.f78797b = str2;
        cVar.f78798c = i3 + "_" + str + "_" + str2;
        c cVar2 = this.mOpenApiInfo;
        cVar2.f78800e = i16;
        cVar2.f78799d = NetConnInfoCenter.getServerTime() + ((long) i17);
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mOpenApiInfo.f78801f = new HashMap<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.mOpenApiInfo.f78801f.put(it.next(), 0L);
            }
        }
    }

    public void setHtmlSessionClient(l lVar) {
        this.sessionClient = lVar;
    }

    public void setMask(boolean z16) {
        Activity activity;
        View view;
        Context context = getContext();
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
            view = activity.findViewById(R.id.f_1);
        } else {
            activity = null;
            view = null;
        }
        if (activity == null) {
            return;
        }
        if (z16) {
            if (view == null) {
                View view2 = new View(getContext());
                view2.setBackgroundColor(1711276032);
                view2.setId(R.id.f_1);
                activity.addContentView(view2, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            view.setVisibility(0);
            return;
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setOnCustomScrollChangeListener(d dVar) {
        this.f78785mt = dVar;
    }

    public void setPluginEngine(WebViewPluginEngine webViewPluginEngine) {
        if (webViewPluginEngine != this.mPluginEngine) {
            this.mPluginEngine = webViewPluginEngine;
            if (webViewPluginEngine != null) {
                webViewPluginEngine.Q(this);
            }
        }
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPaused = true;
        this.isDestroyed = false;
        this.attachedToWindow = false;
        this.isFirstLoad = true;
        this.isFirstIntercept = true;
        this.needSetCookies = true;
        this.cookiesCallback = null;
        this.cookieUrl = "";
    }

    public void callJs(final String str) {
        if (this.isDestroyed) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                super.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.biz.pubaccount.CustomWebView.4
            @Override // java.lang.Runnable
            public void run() {
                CustomWebView customWebView = CustomWebView.this;
                if (customWebView.isDestroyed) {
                    return;
                }
                try {
                    CustomWebView.super.loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + str);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        });
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isPaused = true;
        this.isDestroyed = false;
        this.attachedToWindow = false;
        this.isFirstLoad = true;
        this.isFirstIntercept = true;
        this.needSetCookies = true;
        this.cookiesCallback = null;
        this.cookieUrl = "";
    }
}
