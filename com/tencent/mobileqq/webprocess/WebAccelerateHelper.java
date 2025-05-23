package com.tencent.mobileqq.webprocess;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.webview.injector.r;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.webview.util.n;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebAccelerateHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String[] CFG_KEYS;
    public static final String CREATE_WEB_VIEW_PLUGIN_ENGINE = "createWebViewPluginEngine";
    public static final String KEY_PRELOAD_URL = "preloadUrl";
    public static final int NEED_CHECK_COOKIE = 1;
    public static final int NEED_ENABLE_WEB_AIO = 1;
    public static final int NEED_PREGET_KEY = 1;
    public static final int SW_ENABLE_EMOJI_STICKER = 11;
    public static final int SW_ENABLE_PRELOAD_IN_PUBLIC_ACCOUNT = 9;
    public static final int SW_ENABLE_PRE_REND = 14;

    @Deprecated
    public static final int SW_ENABLE_SERVICE_WORKER = 12;
    public static final int SW_ENABLE_SERVICE_WORKER_NEW_VERSION = 13;
    public static final int SW_ENABLE_WEB_AIO = 5;
    public static final int SW_HIDE_BOTTOM_BAR_IN_LANDSCAPE = 7;
    public static final int SW_PRELOAD_PT4TOKEN_SKEY = 3;
    public static final int SW_PRELOAD_TICKETS = 0;
    public static final int SW_QQBROWSER_ICON_ANIM = 4;
    public static final int SW_THUMBNAIL_WIDTH = 2;
    public static final int SW_TOTAL_NUM = 15;
    public static final int SW_VERIFY_COOKIE = 1;
    public static final int SW_WEB_CORE_DUMP_MASK = 6;
    private static final String TAG = "WebAccelerateHelper";
    private static WebAccelerateHelper instance;
    public static boolean isWebViewEntered;
    private static final Object lock;
    public static View preloadBrowserView;
    static volatile ArrayMap<String, String> sWebViewFeatureConfigs;
    static volatile Integer[] sWebViewFeatureParams;
    private static ArrayList webProcessDPCInjector_AutoGenClazzList_QAutoInjectTransform;
    public volatile String param;
    private final Object sDPCLock;

    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_DPCApi.yml", version = 1)
    a webProcessDPCInjector;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        ArrayList arrayList = new ArrayList();
        webProcessDPCInjector_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(r.class);
        isWebViewEntered = false;
        CFG_KEYS = new String[]{KEY_PRELOAD_URL};
        lock = new Object();
        instance = null;
    }

    WebAccelerateHelper() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.sDPCLock = new Object();
        initQAutoInject();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[WebInject] inject result: ");
            if (this.webProcessDPCInjector != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 1, sb5.toString());
        }
    }

    public static WebAccelerateHelper getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new WebAccelerateHelper();
                }
            }
        }
        return instance;
    }

    public static void preInflaterBrowserView() {
        long currentTimeMillis = System.currentTimeMillis();
        if (preloadBrowserView == null) {
            try {
                WebBrowserViewContainerKt webBrowserViewContainerKt = new WebBrowserViewContainerKt(MobileQQ.sMobileQQ);
                webBrowserViewContainerKt.d(true);
                preloadBrowserView = webBrowserViewContainerKt;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "preInflaterBrowserView error:" + e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Pre_Load_init_browser_view cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public WebViewPluginEngine createWebViewPluginEngine(AppRuntime appRuntime, Activity activity, CustomWebView customWebView, com.tencent.mobileqq.webview.swift.a aVar, List<WebViewPlugin> list) {
        WebViewPluginEngine webViewPluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (WebViewPluginEngine) iPatchRedirector.redirect((short) 13, this, appRuntime, activity, customWebView, aVar, list);
        }
        if (appRuntime != null) {
            s.a(CREATE_WEB_VIEW_PLUGIN_ENGINE);
            if (activity == null && customWebView == null) {
                if (QLog.isColorLevel()) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(list != null);
                    QLog.d(TAG, 2, String.format("preload webview engine(with plugin list=%b)", objArr));
                }
                webViewPluginEngine = new WebViewPluginEngine(appRuntime, aVar, list);
            } else {
                if (QLog.isColorLevel()) {
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Boolean.valueOf(list != null);
                    QLog.d(TAG, 2, String.format("create webview engine(with plugin list=%b)", objArr2));
                }
                webViewPluginEngine = new WebViewPluginEngine(customWebView, activity, appRuntime, aVar, list);
            }
            s.b(CREATE_WEB_VIEW_PLUGIN_ENGINE);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "plugin list:" + webViewPluginEngine.h());
            }
            return webViewPluginEngine;
        }
        throw new IllegalArgumentException("runtime==null to create webview engine,check your arguments!");
    }

    public String getTBSDpcParam() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (TextUtils.isEmpty(this.param)) {
            synchronized (this.sDPCLock) {
                if (TextUtils.isEmpty(this.param) && (aVar = this.webProcessDPCInjector) != null) {
                    this.param = aVar.c();
                }
            }
        }
        return this.param;
    }

    public ArrayMap<String, String> getWebViewFeatureConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (sWebViewFeatureConfigs == null) {
            synchronized (WebAccelerateHelper.class) {
                if (sWebViewFeatureConfigs == null) {
                    String str = "";
                    a aVar = this.webProcessDPCInjector;
                    if (aVar != null) {
                        str = aVar.b();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "WebViewConfig:" + str);
                    }
                    ArrayMap<String, String> arrayMap = new ArrayMap<>(2);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            for (String str2 : CFG_KEYS) {
                                arrayMap.put(str2, jSONObject.optString(str2));
                            }
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                    sWebViewFeatureConfigs = arrayMap;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "WebView feature configs=" + sWebViewFeatureConfigs);
                    }
                }
            }
        }
        return sWebViewFeatureConfigs;
    }

    public Integer[] getWebViewFeatureParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Integer[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (sWebViewFeatureParams == null) {
            synchronized (WebAccelerateHelper.class) {
                if (sWebViewFeatureParams == null) {
                    String str = "";
                    a aVar = this.webProcessDPCInjector;
                    if (aVar != null) {
                        str = aVar.a();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "WebViewFeature:" + str);
                    }
                    Integer[] numArr = new Integer[15];
                    Arrays.fill((Object[]) numArr, (Object) (-1));
                    a aVar2 = this.webProcessDPCInjector;
                    if (aVar2 != null) {
                        aVar2.parseComplexParamsByStringToIntParser(str, numArr);
                    }
                    sWebViewFeatureParams = numArr;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "WebView feature params=" + Arrays.toString(sWebViewFeatureParams));
                    }
                }
            }
        }
        return sWebViewFeatureParams;
    }

    @QAutoInitMethod
    public void initQAutoInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.webProcessDPCInjector = (a) com.tencent.mobileqq.qroute.utils.b.a(webProcessDPCInjector_AutoGenClazzList_QAutoInjectTransform);
        if (QLog.isColorLevel()) {
            n.a(TAG, this.webProcessDPCInjector);
        }
    }

    public boolean isCheckCookie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isCheckCookie");
        }
        if (getWebViewFeatureParams()[1].intValue() == 1) {
            return true;
        }
        return false;
    }

    public boolean isPreGetKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isPreGetKey");
        }
        if (getWebViewFeatureParams()[0].intValue() != 1) {
            return false;
        }
        return true;
    }

    public void preCheckOffline(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            return;
        }
        SwiftBrowserOfflineHandler d16 = SwiftBrowserOfflineHandler.d(str);
        if (d16 != null) {
            d16.b(new SwiftBrowserOfflineHandler.b() { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebAccelerateHelper.this);
                    }
                }

                @Override // com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.b
                public void onCheckOfflineFinish(int i3) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    if (i3 != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    SwiftBrowserStatistics.V0 = z16;
                }
            }, str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void preFetchResource(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null && parse.isHierarchical()) {
                boolean z17 = false;
                if ("1".equals(parse.getQueryParameter("x5PreFetch"))) {
                    SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(str);
                    if (s16 != null && s16.B()) {
                        z16 = true;
                        if (z17 && !z16) {
                            return;
                        }
                        ThreadManagerV2.post(new Runnable(z16, str, z17) { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ String val$fUrl;
                            final /* synthetic */ boolean val$fisX5PreConnect;
                            final /* synthetic */ boolean val$fisX5PreFetch;

                            {
                                this.val$fisX5PreFetch = z16;
                                this.val$fUrl = str;
                                this.val$fisX5PreConnect = z17;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, WebAccelerateHelper.this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (this.val$fisX5PreFetch) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("User-Agent", i.n(i.i("x5prefetch_1.0"), "", false));
                                    WebAccelerator.prefetchResource(BaseApplication.getContext(), this.val$fUrl, hashMap, true);
                                    QLog.i(WebAccelerateHelper.TAG, 1, "now prefetchResource " + s.c(this.val$fUrl, new String[0]));
                                    return;
                                }
                                if (this.val$fisX5PreConnect) {
                                    WebAccelerator.preConnect(BaseApplication.getContext(), this.val$fUrl, 1, true);
                                    QLog.i(WebAccelerateHelper.TAG, 1, "now preconnect " + s.c(this.val$fUrl, new String[0]));
                                }
                            }
                        }, 5, null, true);
                    }
                    z16 = false;
                    if (z17) {
                    }
                    ThreadManagerV2.post(new Runnable(z16, str, z17) { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String val$fUrl;
                        final /* synthetic */ boolean val$fisX5PreConnect;
                        final /* synthetic */ boolean val$fisX5PreFetch;

                        {
                            this.val$fisX5PreFetch = z16;
                            this.val$fUrl = str;
                            this.val$fisX5PreConnect = z17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebAccelerateHelper.this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.val$fisX5PreFetch) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("User-Agent", i.n(i.i("x5prefetch_1.0"), "", false));
                                WebAccelerator.prefetchResource(BaseApplication.getContext(), this.val$fUrl, hashMap, true);
                                QLog.i(WebAccelerateHelper.TAG, 1, "now prefetchResource " + s.c(this.val$fUrl, new String[0]));
                                return;
                            }
                            if (this.val$fisX5PreConnect) {
                                WebAccelerator.preConnect(BaseApplication.getContext(), this.val$fUrl, 1, true);
                                QLog.i(WebAccelerateHelper.TAG, 1, "now preconnect " + s.c(this.val$fUrl, new String[0]));
                            }
                        }
                    }, 5, null, true);
                }
                if ("1".equals(parse.getQueryParameter("x5PreConnect"))) {
                    z16 = false;
                    z17 = true;
                    if (z17) {
                    }
                    ThreadManagerV2.post(new Runnable(z16, str, z17) { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ String val$fUrl;
                        final /* synthetic */ boolean val$fisX5PreConnect;
                        final /* synthetic */ boolean val$fisX5PreFetch;

                        {
                            this.val$fisX5PreFetch = z16;
                            this.val$fUrl = str;
                            this.val$fisX5PreConnect = z17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebAccelerateHelper.this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.val$fisX5PreFetch) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("User-Agent", i.n(i.i("x5prefetch_1.0"), "", false));
                                WebAccelerator.prefetchResource(BaseApplication.getContext(), this.val$fUrl, hashMap, true);
                                QLog.i(WebAccelerateHelper.TAG, 1, "now prefetchResource " + s.c(this.val$fUrl, new String[0]));
                                return;
                            }
                            if (this.val$fisX5PreConnect) {
                                WebAccelerator.preConnect(BaseApplication.getContext(), this.val$fUrl, 1, true);
                                QLog.i(WebAccelerateHelper.TAG, 1, "now preconnect " + s.c(this.val$fUrl, new String[0]));
                            }
                        }
                    }, 5, null, true);
                }
                z16 = false;
                if (z17) {
                }
                ThreadManagerV2.post(new Runnable(z16, str, z17) { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$fUrl;
                    final /* synthetic */ boolean val$fisX5PreConnect;
                    final /* synthetic */ boolean val$fisX5PreFetch;

                    {
                        this.val$fisX5PreFetch = z16;
                        this.val$fUrl = str;
                        this.val$fisX5PreConnect = z17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, WebAccelerateHelper.this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.val$fisX5PreFetch) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("User-Agent", i.n(i.i("x5prefetch_1.0"), "", false));
                            WebAccelerator.prefetchResource(BaseApplication.getContext(), this.val$fUrl, hashMap, true);
                            QLog.i(WebAccelerateHelper.TAG, 1, "now prefetchResource " + s.c(this.val$fUrl, new String[0]));
                            return;
                        }
                        if (this.val$fisX5PreConnect) {
                            WebAccelerator.preConnect(BaseApplication.getContext(), this.val$fUrl, 1, true);
                            QLog.i(WebAccelerateHelper.TAG, 1, "now preconnect " + s.c(this.val$fUrl, new String[0]));
                        }
                    }
                }, 5, null, true);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void preGetKey(Intent intent, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            preGetKey(i.v(intent), intent, appRuntime);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent, (Object) appRuntime);
        }
    }

    public Integer[] queryWebViewFeatureParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Integer[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (sWebViewFeatureParams == null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.webprocess.WebAccelerateHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebAccelerateHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        WebAccelerateHelper.this.getWebViewFeatureParams();
                    }
                }
            }, 5, null, true);
        }
        return sWebViewFeatureParams;
    }

    public void preGetKey(String str, Intent intent, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, intent, appRuntime);
            return;
        }
        SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(str);
        if (s16 != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("preGetKey: ");
            sb5.append(QLog.isColorLevel() ? s.d(str, new String[0]) : s16.f314218j);
            QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
            s16.I(str, null, appRuntime, intent);
        }
    }

    public WebViewPluginEngine createWebViewPluginEngine(AppRuntime appRuntime, Activity activity, CustomWebView customWebView, List<WebViewPlugin> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? createWebViewPluginEngine(appRuntime, activity, customWebView, new com.tencent.mobileqq.webview.swift.a(), list) : (WebViewPluginEngine) iPatchRedirector.redirect((short) 14, this, appRuntime, activity, customWebView, list);
    }
}
