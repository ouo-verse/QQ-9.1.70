package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.bk;
import com.tencent.mobileqq.config.business.bl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.TraceUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public final class WebViewPluginEngine implements com.tencent.mobileqq.webviewplugin.i {
    static IPatchRedirector $redirector_;
    protected static final HashMap<String, String> G;
    protected static final HashSet<String> H;
    public static WebViewPluginEngine I;
    public WebViewProvider C;
    private AuthorizeConfig D;
    private WebViewJSInterfaceImpl E;

    @NotNull
    private com.tencent.mobileqq.webview.nativeapi.b F;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, WebViewPlugin> f314115d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<Long, CopyOnWriteArrayList<WebViewPlugin>> f314116e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, CopyOnWriteArrayList<WebViewPlugin>> f314117f;

    /* renamed from: h, reason: collision with root package name */
    private volatile CustomWebView f314118h;

    /* renamed from: i, reason: collision with root package name */
    public Activity f314119i;

    /* renamed from: m, reason: collision with root package name */
    public AppRuntime f314120m;

    /* loaded from: classes20.dex */
    public static class WebViewJSInterfaceImpl {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<WebViewPluginEngine> f314124a;

        public WebViewJSInterfaceImpl(WebViewPluginEngine webViewPluginEngine) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewPluginEngine);
            } else {
                this.f314124a = new WeakReference<>(webViewPluginEngine);
            }
        }

        @JavascriptInterface
        public void invoke(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            WebViewPluginEngine webViewPluginEngine = this.f314124a.get();
            if (webViewPluginEngine != null) {
                webViewPluginEngine.v(str, false);
            } else {
                QLog.e("WebLog_WebViewPluginEngine", 1, "mEngine is already recycled");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        G = hashMap;
        HashSet<String> hashSet = new HashSet<>();
        H = hashSet;
        hashMap.put("auth.init", "Troop.init");
        hashMap.put("device.getNetworkInfo", "qbizApi.getNetworkInfo");
        hashMap.put("data.setShareInfo", "QQApi.setShareInfo");
        hashMap.put("event.dispatchEvent", "event.dispatchEvent");
        hashMap.put("media.showPicture", "troopNotice.showPicture");
        hashMap.put("ui.popBack", "publicAccount.close");
        hashMap.put("ui.shareMessage", "QQApi.shareMsg");
        hashSet.add("gflive.addBarrageList");
        I = null;
    }

    public WebViewPluginEngine(AppRuntime appRuntime, a aVar, List<WebViewPlugin> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, list);
            return;
        }
        this.f314115d = new ConcurrentHashMap<>();
        this.f314116e = new HashMap<>();
        this.f314117f = new HashMap<>();
        this.f314120m = appRuntime;
        this.F = (com.tencent.mobileqq.webview.nativeapi.b) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.nativeapi.b.class);
        C(true, aVar, list);
    }

    private void A(WebViewPlugin webViewPlugin, boolean z16) {
        if (webViewPlugin == null) {
            return;
        }
        boolean E = E(webViewPlugin);
        if (E) {
            B(webViewPlugin, z16);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebLog_WebViewPluginEngine", 1, String.format("initInsertPlugin plugin[%s] %b", webViewPlugin.getNameSpace(), Boolean.valueOf(E)));
        }
    }

    private void B(WebViewPlugin webViewPlugin, boolean z16) {
        if (webViewPlugin == null) {
            return;
        }
        if (z16) {
            webViewPlugin.onAppRuntimeReady(this.f314120m);
            webViewPlugin.onCreate();
            return;
        }
        webViewPlugin.onAppRuntimeReady(this.f314120m);
        webViewPlugin.initRuntime(this.f314119i, this.f314120m);
        webViewPlugin.mRuntime.i(this.C);
        webViewPlugin.onCreate();
        if (this.f314118h != null) {
            webViewPlugin.onWebViewCreated(this.f314118h);
        }
    }

    private void C(boolean z16, a aVar, List<WebViewPlugin> list) {
        if (aVar != null) {
            Iterator<WebViewPlugin> it = aVar.getCommonJsPlugin().iterator();
            while (it.hasNext()) {
                A(it.next(), z16);
            }
        }
        if (list != null) {
            Iterator<WebViewPlugin> it5 = list.iterator();
            while (it5.hasNext()) {
                A(it5.next(), z16);
            }
        } else if (!z16) {
            L();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean E(WebViewPlugin webViewPlugin) {
        if (webViewPlugin == 0) {
            return false;
        }
        if (webViewPlugin instanceof l) {
            String[] multiNameSpace = ((l) webViewPlugin).getMultiNameSpace();
            if (multiNameSpace == null || multiNameSpace.length <= 0) {
                return false;
            }
            boolean z16 = false;
            for (String str : multiNameSpace) {
                if (!TextUtils.isEmpty(str)) {
                    z16 |= F(str, webViewPlugin);
                }
            }
            return z16;
        }
        if (TextUtils.isEmpty(webViewPlugin.getNameSpace())) {
            return false;
        }
        return false | F(webViewPlugin.getNameSpace(), webViewPlugin);
    }

    private boolean F(String str, WebViewPlugin webViewPlugin) {
        if (TextUtils.isEmpty(str) || webViewPlugin == null) {
            return false;
        }
        if (this.f314115d.containsKey(str)) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "insertPlugin:namespace " + str + " already exists!");
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebLog_WebViewPluginEngine", 2, "insertPlugin:add pair [" + str + "] -> " + webViewPlugin.getClass().getSimpleName());
        }
        this.f314115d.put(str, webViewPlugin);
        long webViewEventByNameSpace = webViewPlugin.getWebViewEventByNameSpace(str);
        if (webViewEventByNameSpace > 0) {
            int i3 = 1;
            long j3 = 1;
            while (webViewEventByNameSpace >= j3) {
                if ((webViewEventByNameSpace & j3) != 0) {
                    CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList = this.f314116e.get(Long.valueOf(j3));
                    if (copyOnWriteArrayList == null) {
                        copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                        this.f314116e.put(Long.valueOf(j3), copyOnWriteArrayList);
                    }
                    copyOnWriteArrayList.add(webViewPlugin);
                }
                j3 = 1 << i3;
                i3++;
            }
        }
        long webViewSchemaByNameSpace = webViewPlugin.getWebViewSchemaByNameSpace(str);
        int i16 = 1;
        long j16 = 1;
        while (webViewSchemaByNameSpace > 0 && webViewSchemaByNameSpace >= j16) {
            if ((webViewSchemaByNameSpace & j16) != 0) {
                String a16 = ah.a(j16);
                if (!TextUtils.isEmpty(a16)) {
                    CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList2 = this.f314117f.get(a16);
                    if (copyOnWriteArrayList2 == null) {
                        copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                        this.f314117f.put(a16, copyOnWriteArrayList2);
                    }
                    int webViewSchemaListIndex = webViewPlugin.getWebViewSchemaListIndex();
                    if (webViewSchemaListIndex >= 0 && webViewSchemaListIndex < copyOnWriteArrayList2.size()) {
                        copyOnWriteArrayList2.add(webViewSchemaListIndex, webViewPlugin);
                    } else {
                        copyOnWriteArrayList2.add(webViewPlugin);
                    }
                }
            }
            j16 = 1 << i16;
            i16++;
        }
        return true;
    }

    private boolean G(String str, boolean z16) {
        CustomWebView customWebView;
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (TextUtils.isEmpty(k3) || "javascript".equals(k3) || (customWebView = this.f314118h) == null) {
            return false;
        }
        if ("jsbridge".equals(k3)) {
            return u(this, customWebView, str, z16);
        }
        if ("openapi".equals(k3)) {
            return y(this, customWebView, str, z16);
        }
        if ("nativeapi".equals(k3)) {
            return x(this, customWebView, str, z16);
        }
        return z(this, customWebView, str, k3, z16);
    }

    private void K() {
        Iterator<c> it = ag.f314193c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next instanceof e) {
                try {
                    D(((e) next).a(this.f314119i.getIntent()));
                } catch (Throwable th5) {
                    QLog.d("WebLog_WebViewPluginEngine", 1, "preCreatePlugin failed", th5);
                }
            }
        }
    }

    private static void M(WebViewPluginEngine webViewPluginEngine, String str, String str2, JsBridgeListener jsBridgeListener, String str3, String str4) {
        String str5;
        com.tencent.mobileqq.webview.swift.component.c h16;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            T("no plugin have right handle  " + str4 + ",currentUrl=" + str3);
        }
        jsBridgeListener.f();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h16 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
            h16.g(str, str2, "permission denied!");
        }
        if (!TextUtils.isEmpty(str3)) {
            if (str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str5 = str3.substring(0, str3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            } else {
                str5 = str3;
            }
            int E = (int) webViewPluginEngine.i().E();
            int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
            String str6 = ((com.tencent.mobileqq.webview.swift.injector.d) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.d.class)).a() + " " + ((com.tencent.mobileqq.webview.swift.injector.d) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.d.class)).getModel();
            VasBaseWebviewUtil.reportVasStatus("JsApiRights", str, str2, 3, 0, tbsVersion, E, str5, str6);
            if (!str5.startsWith("http")) {
                QLog.d("WebLog_WebViewPluginEngine", 1, "no plugin have right handle  " + str4 + ", x5 version = " + tbsVersion + ", phone is " + str6);
            }
        }
        QLog.e("WebLog_WebViewPluginEngine", 1, "currentUrl :" + str3 + ", cmdName: " + str4 + ", permission denied!");
        SwiftBrowserStatistics.b0(1, str4, str3);
    }

    private static boolean N(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String str, String[] strArr, String str2, String str3, boolean z16, long j3, JsBridgeListener jsBridgeListener, String str4, String str5) {
        com.tencent.mobileqq.webview.swift.component.c h16;
        WebViewPlugin m3 = webViewPluginEngine.m(str2);
        if (m3 == null) {
            m3 = webViewPluginEngine.f(str2);
        }
        if (m3 != null) {
            if (d(str5, m3)) {
                return true;
            }
            w(m3, jsBridgeListener, str, str2, str3, strArr);
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h16 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
                h16.g(str2, str3, "success!");
            }
            SwiftBrowserStatistics.b0(0, str5, str4);
            return true;
        }
        O(webViewPluginEngine, customWebView, strArr, str2, str3, z16, j3, str4, str5);
        return false;
    }

    private static void O(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String[] strArr, String str, String str2, boolean z16, long j3, String str3, String str4) {
        String str5;
        com.tencent.mobileqq.webview.swift.component.c h16;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            T("no plugin handle " + str4);
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h16 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
            h16.g(str, str2, "not supported!");
        }
        if (z16) {
            if (j3 != -1 && !((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                customWebView.callJs("alert(' MobileQQ don't Handle JSBridge Method " + str4 + "')");
            }
        } else {
            if (strArr.length > 0 && strArr[0].startsWith("{")) {
                try {
                    str5 = new JSONObject(strArr[0]).optString("callback");
                } catch (JSONException unused) {
                }
                if (TextUtils.isEmpty(str5) && j3 != -1) {
                    str5 = Long.toString(j3);
                }
                if (!TextUtils.isEmpty(str5) && !((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                    customWebView.callJs("alert(' MobileQQ don't Handle JSBridge Method " + str4 + "')");
                }
            }
            str5 = null;
            if (TextUtils.isEmpty(str5)) {
                str5 = Long.toString(j3);
            }
            if (!TextUtils.isEmpty(str5)) {
                customWebView.callJs("alert(' MobileQQ don't Handle JSBridge Method " + str4 + "')");
            }
        }
        SwiftBrowserStatistics.b0(2, str4, str3);
    }

    private void P(CustomWebView customWebView) {
        if (customWebView == null) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "registerJSInterface webView is null");
            return;
        }
        if (this.E == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("WebLog_WebViewPluginEngine", 2, "registerJSInterface");
            }
            WebViewJSInterfaceImpl webViewJSInterfaceImpl = new WebViewJSInterfaceImpl(this);
            this.E = webViewJSInterfaceImpl;
            customWebView.addJavascriptInterface(webViewJSInterfaceImpl, "_mqqWebViewJSInterface");
        }
    }

    private static void T(String str) {
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            ThreadManager.getUIHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.webview.swift.WebViewPluginEngine.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f314121d;

                {
                    this.f314121d = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        Toast.makeText(BaseApplication.getContext(), this.f314121d, 1).show();
                    }
                }
            });
        }
        QLog.e("WebLog_WebViewPluginEngine", 1, str);
    }

    public static boolean c(String str, String str2, String str3, boolean z16) {
        bk bkVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || !peekAppRuntime.isLogin() || (bkVar = (bk) com.tencent.mobileqq.config.am.s().x(811)) == null) {
            return false;
        }
        if (str2 != null) {
            str3 = str2 + QzoneWebViewOfflinePlugin.STR_DEVIDER + str3;
        }
        Pair<Boolean, String> b16 = bkVar.b(str3, z16);
        boolean booleanValue = ((Boolean) b16.first).booleanValue();
        boolean z17 = !TextUtils.isEmpty((CharSequence) b16.second);
        if (str3.length() > 60) {
            str3 = str3.substring(0, 60);
        }
        if (z17 || QLog.isDevelopLevel()) {
            QLog.d("WVBlacklistConfProcessor", 1, "riskCheck hit=", Boolean.valueOf(z17), ",forbid=", Boolean.valueOf(booleanValue), ",request=", com.tencent.mobileqq.webview.util.s.d(str3, new String[0]));
        }
        if (z17 && booleanValue) {
            return true;
        }
        if (z17 || bkVar.d()) {
            SwiftBrowserStatistics.T(str3, str);
        }
        return false;
    }

    private static boolean d(String str, WebViewPlugin webViewPlugin) {
        bl blVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin() && (blVar = (bl) com.tencent.mobileqq.config.am.s().x(com.tencent.luggage.wxa.uf.e.CTRL_INDEX)) != null && blVar.a(str, webViewPlugin.getLastCallTime(str))) {
            return true;
        }
        return false;
    }

    private static boolean e(String str, String str2) {
        bk bkVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin() && (bkVar = (bk) com.tencent.mobileqq.config.am.s().x(811)) != null && bkVar.a(str, str2)) {
            return true;
        }
        return false;
    }

    private WebViewPlugin f(String str) {
        WebViewPlugin b16 = ag.b(str);
        A(b16, false);
        return b16;
    }

    private void g(AppRuntime appRuntime, Activity activity) {
        for (WebViewPlugin webViewPlugin : this.f314115d.values()) {
            if (webViewPlugin != null) {
                if (webViewPlugin.mRuntime == null) {
                    webViewPlugin.initRuntime(activity, appRuntime);
                }
                webViewPlugin.onActivityReady();
            }
        }
    }

    private String j(long j3) {
        String binaryString = Long.toBinaryString(j3);
        if (TextUtils.isEmpty(binaryString)) {
            return "";
        }
        return "1L << " + (binaryString.length() - binaryString.replaceAll("0", "").length());
    }

    @NonNull
    public static String o(Activity activity) {
        if (activity == null) {
            return "";
        }
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra("url");
        if (stringExtra == null) {
            String stringExtra2 = intent.getStringExtra("key_params_qq");
            if (stringExtra2 == null) {
                return "";
            }
            return stringExtra2;
        }
        return stringExtra;
    }

    private static boolean u(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String str, boolean z16) {
        long parseLong;
        String[] strArr;
        boolean z17;
        String str2;
        long parseInt;
        String[] strArr2;
        String[] split = (str + "/#").split("/");
        if (split.length < 5) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "illegal jsbridge:" + str);
            return true;
        }
        String str3 = split[2];
        if (split.length == 5) {
            String[] split2 = split[3].split("#");
            if (split2.length > 1) {
                try {
                    parseInt = Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    StringBuilder sb5 = new StringBuilder("illegal jsbridge[");
                    sb5.append(str);
                    sb5.append("] error:");
                    sb5.append(e16.toString());
                    QLog.e("WebLog_WebViewPluginEngine", 1, sb5);
                    return true;
                }
            } else {
                parseInt = -1;
            }
            String[] split3 = split2[0].split("\\?");
            String str4 = split3[0];
            if (split3.length > 1) {
                strArr2 = split3[1].split(ContainerUtils.FIELD_DELIMITER);
                if (strArr2.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = strArr2.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        int indexOf = strArr2[i3].indexOf(61);
                        if (indexOf != -1) {
                            if (!"mqq_tt".equals(strArr2[i3].substring(0, indexOf))) {
                                if (H.contains(str3 + "." + str4)) {
                                    arrayList.add(strArr2[i3].substring(indexOf + 1));
                                } else {
                                    arrayList.add(URLDecoder.decode(strArr2[i3].substring(indexOf + 1)));
                                }
                            }
                        } else {
                            arrayList.add("");
                        }
                    }
                    strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
            } else {
                strArr2 = new String[0];
            }
            str2 = str4;
            parseLong = parseInt;
            strArr = strArr2;
            z17 = false;
        } else {
            String str5 = split[3];
            try {
                parseLong = Long.parseLong(split[4]);
                int length2 = split.length - 6;
                String[] strArr3 = new String[length2];
                System.arraycopy(split, 5, strArr3, 0, length2);
                for (int i16 = 0; i16 < length2; i16++) {
                    strArr3[i16] = URLDecoder.decode(strArr3[i16]);
                }
                strArr = strArr3;
                z17 = true;
                str2 = str5;
            } catch (Exception e17) {
                StringBuilder sb6 = new StringBuilder("illegal jsbridge[");
                sb6.append(str);
                sb6.append("] error:");
                sb6.append(e17.toString());
                QLog.e("WebLog_WebViewPluginEngine", 1, sb6);
                return true;
            }
        }
        JsBridgeListener jsBridgeListener = new JsBridgeListener(customWebView, parseLong, str);
        String url = customWebView.getUrl();
        String str6 = str3 + "." + str2;
        if (e(url, str6)) {
            return true;
        }
        if (!z16) {
            if (c(url, "jsbridge", str3 + "/" + str2, false)) {
                return true;
            }
        }
        if (webViewPluginEngine.i().F(url, str6)) {
            N(webViewPluginEngine, customWebView, str, strArr, str3, str2, z17, parseLong, jsBridgeListener, url, str6);
            return true;
        }
        M(webViewPluginEngine, str3, str2, jsBridgeListener, url, str6);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ef, code lost:
    
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f1, code lost:
    
        com.tencent.widget.TraceUtils.traceEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0137, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0134, code lost:
    
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean w(WebViewPlugin webViewPlugin, JsBridgeListener jsBridgeListener, String str, String str2, String str3, String[] strArr) {
        if (webViewPlugin == null) {
            return false;
        }
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            TraceUtils.traceBegin(str2 + "." + str3);
        }
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (webViewPlugin.handleJsRequest(jsBridgeListener, str, str2, str3, strArr)) {
                    webViewPlugin.setCallTime(str2 + "." + str3);
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (QLog.isDevelopLevel()) {
                        StringBuilder sb5 = new StringBuilder("plugin[");
                        sb5.append(webViewPlugin.getClass().getSimpleName());
                        sb5.append("] handle JsApi[");
                        sb5.append(str2);
                        sb5.append(".");
                        sb5.append(str3);
                        sb5.append("] cost ");
                        sb5.append(currentTimeMillis2);
                        sb5.append(" ms.");
                        QLog.d("WebLog_WebViewPluginEngine", 2, sb5);
                    }
                }
                if (QLog.isDevelopLevel()) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    StringBuilder sb6 = new StringBuilder("plugin[");
                    sb6.append(webViewPlugin.getClass().getSimpleName());
                    sb6.append("] ignore JsApi[");
                    sb6.append(str2);
                    sb6.append(".");
                    sb6.append(str3);
                    sb6.append("] cost ");
                    sb6.append(currentTimeMillis3);
                    sb6.append(" ms.");
                    QLog.d("WebLog_WebViewPluginEngine", 2, sb6);
                }
            } catch (Exception e16) {
                StringBuilder sb7 = new StringBuilder("plugin[");
                sb7.append(webViewPlugin.getClass().getSimpleName());
                sb7.append("] handle JsApi[");
                sb7.append(str2);
                sb7.append(".");
                sb7.append(str3);
                sb7.append("] error:");
                sb7.append(e16.toString());
                QLog.e("WebLog_WebViewPluginEngine", 2, sb7);
            }
        } finally {
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                TraceUtils.traceEnd();
            }
        }
    }

    private static boolean x(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String str, boolean z16) {
        return webViewPluginEngine.k().b(customWebView, str, webViewPluginEngine.f314119i, z16);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean y(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String str, boolean z16) {
        long parseInt;
        String[] strArr;
        String[] strArr2;
        int i3;
        String str2;
        String str3;
        com.tencent.mobileqq.webview.swift.component.c h16;
        com.tencent.mobileqq.webview.swift.component.c h17;
        com.tencent.mobileqq.webview.swift.component.c h18;
        int i16;
        int i17;
        JSONObject jSONObject;
        String[] split = (str + "/#").split("/");
        if (split.length < 5) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "illegal jsbridge:" + str);
            return true;
        }
        String str4 = split[2];
        if (split.length == 5) {
            String[] split2 = split[3].split("#");
            if (split2.length > 1) {
                try {
                    parseInt = Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    StringBuilder sb5 = new StringBuilder("illegal jsbridge[");
                    sb5.append(str);
                    sb5.append("] error:");
                    sb5.append(e16.toString());
                    QLog.e("WebLog_WebViewPluginEngine", 1, sb5);
                    return true;
                }
            } else {
                parseInt = -1;
            }
            String[] split3 = split2[0].split("\\?");
            if (split3.length > 1) {
                int indexOf = split3[1].indexOf(61);
                if (indexOf != -1) {
                    String decode = URLDecoder.decode(split3[1].substring(indexOf + 1));
                    if ("{}".equals(decode)) {
                        strArr = new String[0];
                    } else {
                        strArr = new String[]{decode};
                    }
                } else {
                    strArr = new String[0];
                }
            } else {
                strArr = new String[0];
            }
            String str5 = split3[0];
            String str6 = str4 + "." + str5;
            if (!z16) {
                if (c(customWebView.getUrl(), "openapi", str4 + "/" + str5, false)) {
                    return true;
                }
            }
            JsBridgeListener jsBridgeListener = new JsBridgeListener((WebView) customWebView, parseInt, true);
            if (strArr.length == 1 && !"auth.init".equals(str6)) {
                try {
                    jSONObject = new JSONObject(strArr[0]);
                    i16 = Integer.parseInt((String) jSONObject.remove("appid"));
                    try {
                        str2 = (String) jSONObject.remove("openGroupId");
                    } catch (NumberFormatException e17) {
                        e = e17;
                        i17 = 1;
                        str2 = null;
                        str3 = null;
                        QLog.e("WebLog_WebViewPluginEngine", i17, "NumberFormatException:" + e.toString());
                        i3 = i16;
                        strArr2 = strArr;
                        String str7 = str5;
                        if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                        }
                    } catch (JSONException e18) {
                        e = e18;
                        str2 = null;
                        str3 = null;
                        QLog.e("WebLog_WebViewPluginEngine", 1, "JSONException:" + e.toString());
                        i3 = i16;
                        strArr2 = strArr;
                        String str72 = str5;
                        if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                        }
                    }
                    try {
                        str3 = (String) jSONObject.remove("token");
                    } catch (NumberFormatException e19) {
                        e = e19;
                        i17 = 1;
                        str3 = null;
                        QLog.e("WebLog_WebViewPluginEngine", i17, "NumberFormatException:" + e.toString());
                        i3 = i16;
                        strArr2 = strArr;
                        String str722 = str5;
                        if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                        }
                    } catch (JSONException e26) {
                        e = e26;
                        str3 = null;
                        QLog.e("WebLog_WebViewPluginEngine", 1, "JSONException:" + e.toString());
                        i3 = i16;
                        strArr2 = strArr;
                        String str7222 = str5;
                        if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                        }
                    }
                } catch (NumberFormatException e27) {
                    e = e27;
                    i17 = 1;
                    i16 = 0;
                } catch (JSONException e28) {
                    e = e28;
                    i16 = 0;
                }
                try {
                    try {
                        jSONObject.remove("apiList");
                        String jSONObject2 = jSONObject.toString();
                        if ("{}".equals(jSONObject2)) {
                            strArr2 = new String[0];
                        } else {
                            i17 = 1;
                            try {
                                String[] strArr3 = new String[1];
                                strArr3[0] = jSONObject2;
                                strArr2 = strArr3;
                            } catch (NumberFormatException e29) {
                                e = e29;
                                QLog.e("WebLog_WebViewPluginEngine", i17, "NumberFormatException:" + e.toString());
                                i3 = i16;
                                strArr2 = strArr;
                                String str72222 = str5;
                                if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                                }
                            }
                        }
                        i3 = i16;
                    } catch (NumberFormatException e36) {
                        e = e36;
                        i17 = 1;
                    }
                } catch (JSONException e37) {
                    e = e37;
                    QLog.e("WebLog_WebViewPluginEngine", 1, "JSONException:" + e.toString());
                    i3 = i16;
                    strArr2 = strArr;
                    String str722222 = str5;
                    if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                    }
                }
            } else {
                strArr2 = strArr;
                i3 = 0;
                str2 = null;
                str3 = null;
            }
            String str7222222 = str5;
            if (!customWebView.checkToken(customWebView, i3, str2, str3, str6, jsBridgeListener)) {
                if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h18 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
                    h18.g(str4, str7222222, "permission denied!");
                }
                SwiftBrowserStatistics.c0(1, str6, customWebView.getUrl());
                return true;
            }
            HashMap<String, String> hashMap = G;
            if (hashMap.containsKey(str6)) {
                String[] split4 = hashMap.get(str6).split("\\.");
                if (split4.length == 2) {
                    str4 = split4[0];
                    str7222222 = split4[1];
                }
            }
            WebViewPlugin m3 = webViewPluginEngine.m(str4);
            if (m3 == null) {
                m3 = webViewPluginEngine.f(str4);
            }
            if (m3 != null && w(m3, jsBridgeListener, str, str4, str7222222, strArr2)) {
                if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h17 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
                    h17.g(str4, str7222222, "success!");
                }
                SwiftBrowserStatistics.c0(0, str6, customWebView.getUrl());
                return true;
            }
            customWebView.callJs4OpenApi(jsBridgeListener, 3, JsBridgeListener.a(3, null, "no such method"));
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && (h16 = com.tencent.mobileqq.webview.swift.component.c.h(webViewPluginEngine)) != null) {
                h16.g(str4, str7222222, "no such method!");
            }
            SwiftBrowserStatistics.c0(2, str6, customWebView.getUrl());
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("WebLog_WebViewPluginEngine.troop.openapi", 2, "paths.length != 5");
            return false;
        }
        return false;
    }

    private static boolean z(WebViewPluginEngine webViewPluginEngine, CustomWebView customWebView, String str, String str2, boolean z16) {
        StringBuilder sb5;
        String url = customWebView.getUrl();
        if (!z16 && c(url, null, str, true)) {
            return true;
        }
        if (webViewPluginEngine.f314117f.containsKey(str2) && webViewPluginEngine.i().H(url, str2)) {
            CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList = webViewPluginEngine.f314117f.get(str2);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder(copyOnWriteArrayList.size() * 64);
                } else {
                    sb5 = new StringBuilder();
                }
                Iterator<WebViewPlugin> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WebViewPlugin next = it.next();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (next != null) {
                        if (next.handleSchemaRequest(str, str2)) {
                            if (QLog.isDevelopLevel()) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                sb5.append("plugin[");
                                sb5.append(next.getClass().getSimpleName());
                                sb5.append("] handle scheme[");
                                sb5.append(str2);
                                sb5.append("] success cost ");
                                sb5.append(currentTimeMillis2);
                                sb5.append(" ms.");
                                QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                            }
                            SwiftBrowserStatistics.e0(str, url, 0);
                            return true;
                        }
                        if (QLog.isDevelopLevel()) {
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis3 > 50) {
                                sb5.append("plugin[");
                                sb5.append(next.getClass().getSimpleName());
                                sb5.append("] handle scheme[");
                                sb5.append(str2);
                                sb5.append("] cost ");
                                sb5.append(currentTimeMillis3);
                                sb5.append(" ms.");
                            }
                        }
                    }
                }
                if (QLog.isDevelopLevel() && sb5.length() > 0) {
                    sb5.append("overrideUrlRequest error:no plugin can handle this scheme[");
                    sb5.append(str2);
                    sb5.append("].");
                    QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                }
                SwiftBrowserStatistics.e0(str, url, 1);
            }
            return false;
        }
        StringBuilder sb6 = new StringBuilder("overrideUrlRequest error:no plugin can handle this scheme[");
        sb6.append(str2);
        sb6.append("].");
        QLog.e("WebLog_WebViewPluginEngine", 1, sb6);
        SwiftBrowserStatistics.e0(str, url, 2);
        return false;
    }

    public void D(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (this.f314115d.containsKey(str)) {
                    QLog.e("WebLog_WebViewPluginEngine", 1, "insertPlugin:namespace " + str + " already exists!");
                } else {
                    f(str);
                }
            }
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        for (WebViewPlugin webViewPlugin : this.f314115d.values()) {
            if (webViewPlugin != null && !hashMap.containsKey(webViewPlugin)) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    webViewPlugin.onDestroy();
                    hashMap.put(webViewPlugin, Boolean.TRUE);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebLog_WebViewPluginEngine", 2, QLog.getStackTraceString(e16));
                    }
                }
                if (QLog.isColorLevel()) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis2 > 50) {
                        StringBuilder sb5 = new StringBuilder("plugin[");
                        sb5.append(webViewPlugin.getClass().getSimpleName());
                        sb5.append("] onDestroy cost ");
                        sb5.append(currentTimeMillis2);
                        sb5.append(" ms.");
                        QLog.d("WebLog_WebViewPluginEngine", 2, sb5);
                    }
                }
            }
        }
        this.f314115d.clear();
        this.f314116e.clear();
        this.f314117f.clear();
        this.F.a();
        this.f314118h = null;
    }

    public void I(AppRuntime appRuntime, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) appRuntime, (Object) activity);
        } else {
            J(appRuntime, activity, null);
        }
    }

    public void J(AppRuntime appRuntime, Activity activity, List<WebViewPlugin> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appRuntime, activity, list);
            return;
        }
        if (this.f314119i == null) {
            this.f314119i = activity;
        }
        if (this.f314120m == null) {
            this.f314120m = appRuntime;
        }
        if (list != null && list.size() > 0) {
            Iterator<WebViewPlugin> it = list.iterator();
            while (it.hasNext()) {
                A(it.next(), false);
            }
        }
        g(appRuntime, activity);
        if (activity != null && activity.getIntent() != null) {
            K();
        } else {
            QLog.i("WebLog_WebViewPluginEngine", 1, "onRuntimeReady params activity is empty");
        }
    }

    public void L() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Activity activity = this.f314119i;
        if (activity != null) {
            Intent intent = activity.getIntent();
            String o16 = o(this.f314119i);
            if (TextUtils.isEmpty(o16)) {
                return;
            }
            int indexOf = o16.indexOf(":");
            if (indexOf > 0) {
                str = o16.substring(0, indexOf);
            } else {
                str = "";
            }
            Iterator<c> it = ag.f314193c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next instanceof f) {
                    try {
                        D(((f) next).providePreCreatePlugins(intent, o16, str));
                    } catch (Throwable th5) {
                        QLog.d("WebLog_WebViewPluginEngine", 1, "preCreatePlugin failed", th5);
                    }
                }
            }
        }
    }

    public void Q(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) customWebView);
            return;
        }
        if (customWebView != null && this.f314118h != customWebView) {
            this.f314118h = customWebView;
            Iterator<WebViewPlugin> it = this.f314115d.values().iterator();
            while (it.hasNext()) {
                it.next().onWebViewCreated(customWebView);
            }
            P(customWebView);
        }
    }

    public boolean R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        return S(str, true);
    }

    public boolean S(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            com.tencent.mobileqq.webview.util.s.a("web_shouldOverrideUrlRequest=" + str);
        }
        boolean G2 = G(str, z16);
        if (G2 && !((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            com.tencent.mobileqq.webview.util.s.b("web_shouldOverrideUrlRequest=" + str);
        }
        return G2;
    }

    public void a(WebViewProvider webViewProvider) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) webViewProvider);
            return;
        }
        if (webViewProvider == null) {
            return;
        }
        this.C = webViewProvider;
        for (WebViewPlugin webViewPlugin : this.f314115d.values()) {
            if (webViewPlugin != null) {
                webViewPlugin.bindWebViewProvider(webViewProvider);
            }
        }
    }

    public void b(y yVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) yVar);
            return;
        }
        if (yVar == null) {
            return;
        }
        for (WebViewPlugin webViewPlugin : this.f314115d.values()) {
            if (webViewPlugin != null) {
                webViewPlugin.setWebUiInterface(yVar);
            }
        }
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f314115d.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewPluginEngine", 2, "-->plugin list is empty.");
                return "no plugins";
            }
            return "no plugins";
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("plugin list:\n");
        Iterator<WebViewPlugin> it = this.f314115d.values().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().getClass().getSimpleName());
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public AuthorizeConfig i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (AuthorizeConfig) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.D == null) {
            this.D = AuthorizeConfig.y();
        }
        return this.D;
    }

    @NotNull
    public com.tencent.mobileqq.webview.nativeapi.b k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.mobileqq.webview.nativeapi.b) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.F;
    }

    public WebViewPlugin l(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (WebViewPlugin) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        WebViewPlugin webViewPlugin = null;
        for (Map.Entry<Class<? extends WebViewPlugin>, Integer> entry : ag.f314194d.entrySet()) {
            if (entry.getValue().intValue() == i3) {
                for (WebViewPlugin webViewPlugin2 : this.f314115d.values()) {
                    if (webViewPlugin2.getClass() == entry.getKey()) {
                        webViewPlugin = webViewPlugin2;
                    }
                }
            }
        }
        if (webViewPlugin == null && z16) {
            WebViewPlugin a16 = ag.a(i3);
            A(a16, false);
            return a16;
        }
        return webViewPlugin;
    }

    public WebViewPlugin m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (WebViewPlugin) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        return n(str, false);
    }

    public WebViewPlugin n(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (WebViewPlugin) iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        }
        if (this.f314115d.containsKey(str)) {
            return this.f314115d.get(str);
        }
        if (z16) {
            return ag.b(str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webviewplugin.i
    public void onRuntimeUpdate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) appRuntime);
            return;
        }
        this.f314120m = appRuntime;
        QLog.d("WebLog_WebViewPluginEngine", 1, "onRuntimeUpdate new:" + appRuntime + ", old: " + this.f314120m);
        for (WebViewPlugin webViewPlugin : this.f314115d.values()) {
            if (webViewPlugin != null) {
                webViewPlugin.onRuntimeUpdate(this.f314120m);
            }
        }
    }

    public boolean p(Map<String, Object> map) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) map)).booleanValue();
        }
        CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList = this.f314116e.get(32L);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(copyOnWriteArrayList.size() * 64);
            } else {
                sb5 = new StringBuilder();
            }
            HashMap hashMap = new HashMap();
            Iterator<WebViewPlugin> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WebViewPlugin next = it.next();
                if (next != null && !hashMap.containsKey(next)) {
                    Object obj = map.get("url");
                    if (obj instanceof String) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (next.handleEvent((String) obj, 32L, map)) {
                            if (QLog.isColorLevel()) {
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                sb5.append("plugin [");
                                sb5.append(next.getClass().getSimpleName());
                                sb5.append("] handleBeforeLoad success, cost ");
                                sb5.append(currentTimeMillis2);
                                sb5.append(" ms.");
                                QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                                return true;
                            }
                            return true;
                        }
                        hashMap.put(next, Boolean.TRUE);
                        if (QLog.isColorLevel()) {
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis3 > 50) {
                                sb5.append("plugin [");
                                sb5.append(next.getClass().getSimpleName());
                                sb5.append("] handleBeforeLoad, cost ");
                                sb5.append(currentTimeMillis3);
                                sb5.append(" ms.\r\n");
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (QLog.isColorLevel() && sb5.length() > 0) {
                sb5.append("handleBeforeLoad error:no plugin can handled!");
                QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
            }
        }
        return false;
    }

    public boolean q(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, str, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errorCode", Integer.valueOf(i3));
        return s(str, j3, hashMap);
    }

    public Object r(String str, long j3) {
        String str2;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return iPatchRedirector.redirect((short) 12, this, str, Long.valueOf(j3));
        }
        CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList = this.f314116e.get(Long.valueOf(j3));
        if (copyOnWriteArrayList != null) {
            str2 = j(j3);
        } else if (j3 > 8589934592L) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.f314115d.values());
            str2 = String.valueOf(j3 - 8589934592L);
        } else {
            if (QLog.isDevelopLevel()) {
                StringBuilder sb6 = new StringBuilder("handleEvent error:no plugin can handle this event(");
                sb6.append(j3);
                sb6.append(").");
                QLog.e("WebLog_WebViewPluginEngine", 1, sb6);
            }
            str2 = "";
        }
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(copyOnWriteArrayList.size() * 64);
            } else {
                sb5 = new StringBuilder();
            }
            for (WebViewPlugin webViewPlugin : copyOnWriteArrayList) {
                if (webViewPlugin != null && !hashMap.containsKey(webViewPlugin)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Object handleEvent = webViewPlugin.handleEvent(str, j3);
                    if (handleEvent != null) {
                        if (QLog.isColorLevel()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            sb5.append("plugin[");
                            sb5.append(webViewPlugin.getClass().getSimpleName());
                            sb5.append("] handled event[");
                            sb5.append(j3);
                            sb5.append("] success cost ");
                            sb5.append(currentTimeMillis2);
                            sb5.append(" ms.");
                            QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                        }
                        return handleEvent;
                    }
                    hashMap.put(webViewPlugin, Boolean.TRUE);
                    if (QLog.isColorLevel()) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis3 > 50) {
                            sb5.append("plugin[");
                            sb5.append(webViewPlugin.getClass().getSimpleName());
                            sb5.append("] handled event[");
                            sb5.append(j3);
                            sb5.append("] cost ");
                            sb5.append(currentTimeMillis3);
                            sb5.append(" ms\r\n.");
                        }
                    }
                }
            }
            if (QLog.isColorLevel() && sb5.length() > 0) {
                sb5.append("handleEvent error:no plugin can handleEvent (");
                sb5.append(str2);
                sb5.append(")");
                QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                return null;
            }
            return null;
        }
        return null;
    }

    public boolean s(String str, long j3, Map<String, Object> map) {
        CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), map)).booleanValue();
        }
        if (this.f314116e.containsKey(Long.valueOf(j3))) {
            copyOnWriteArrayList = this.f314116e.get(Long.valueOf(j3));
        } else if (j3 > 8589934592L) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>(this.f314115d.values());
        } else {
            if (QLog.isDevelopLevel()) {
                StringBuilder sb6 = new StringBuilder("handleEvent error:no plugin can handle this event(");
                sb6.append(j3);
                sb6.append(").");
                QLog.e("WebLog_WebViewPluginEngine", 1, sb6);
            }
            copyOnWriteArrayList = null;
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(copyOnWriteArrayList.size() * 64);
        } else {
            sb5 = new StringBuilder();
        }
        for (WebViewPlugin webViewPlugin : copyOnWriteArrayList) {
            if (webViewPlugin != null && !hashMap.containsKey(webViewPlugin)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (webViewPlugin.handleEvent(str, j3, map)) {
                    if (QLog.isColorLevel()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 50) {
                            sb5.append("plugin[");
                            sb5.append(webViewPlugin.getClass().getSimpleName());
                            sb5.append("] handled event[");
                            sb5.append(j3);
                            sb5.append("] success cost ");
                            sb5.append(currentTimeMillis2);
                            sb5.append(" ms.");
                            QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                hashMap.put(webViewPlugin, Boolean.TRUE);
                if (QLog.isColorLevel()) {
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                    if (currentTimeMillis3 > 50) {
                        sb5.append("plugin[");
                        sb5.append(webViewPlugin.getClass().getSimpleName());
                        sb5.append("] handled event[");
                        sb5.append(j3);
                        sb5.append("] cost ");
                        sb5.append(currentTimeMillis3);
                        sb5.append(" ms\r\n.");
                    }
                }
            }
        }
        if (QLog.isColorLevel() && sb5.length() > 0) {
            sb5.append("handleEvent error: no plugin can handleEvent(");
            sb5.append(j3);
            sb5.append(")");
            QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
            return false;
        }
        return false;
    }

    public boolean t(String str, Map<String, Object> map) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) map)).booleanValue();
        }
        CopyOnWriteArrayList<WebViewPlugin> copyOnWriteArrayList = this.f314116e.get(2048L);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            if (QLog.isColorLevel()) {
                sb5 = new StringBuilder(copyOnWriteArrayList.size() * 64);
            } else {
                sb5 = new StringBuilder();
            }
            HashMap hashMap = new HashMap();
            Iterator<WebViewPlugin> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WebViewPlugin next = it.next();
                if (next != null && !hashMap.containsKey(next)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (next.handleEvent(str, 2048L, map)) {
                        if (QLog.isColorLevel()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            sb5.append("plugin [");
                            sb5.append(next.getClass().getSimpleName());
                            sb5.append("] handleInterceptLoadUrl success, cost ");
                            sb5.append(currentTimeMillis2);
                            sb5.append(" ms.");
                            QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
                            return true;
                        }
                        return true;
                    }
                    hashMap.put(next, Boolean.TRUE);
                    if (QLog.isColorLevel()) {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis3 > 50) {
                            sb5.append("plugin [");
                            sb5.append(next.getClass().getSimpleName());
                            sb5.append("] handleInterceptLoadUrl, cost ");
                            sb5.append(currentTimeMillis3);
                            sb5.append(" ms.\r\n");
                        }
                    }
                }
            }
            if (QLog.isColorLevel() && sb5.length() > 0) {
                sb5.append("handleInterceptLoadUrl error:no plugin can handled!");
                QLog.i("WebLog_WebViewPluginEngine", 2, sb5.toString());
            }
        }
        return false;
    }

    public void v(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, Boolean.valueOf(z16));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is null");
            return;
        }
        if (str.startsWith("https://jsbridge/")) {
            str = str.replace("https://jsbridge/", "jsbridge://");
        } else if (str.startsWith("http://jsbridge/")) {
            str = str.replace("http://jsbridge/", "jsbridge://");
        }
        if (QLog.isColorLevel()) {
            if (str.startsWith("jsbridge://") && str.length() > 512) {
                QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str.substring(0, 512));
            } else {
                QLog.i("WebLog_WebViewPluginEngine", 2, "handleJsInterfaceRequest:" + str);
            }
        }
        if (!str.startsWith("jsbridge:")) {
            QLog.e("WebLog_WebViewPluginEngine", 1, "handleJsInterfaceRequest requestUrl is not startsWith jsbridge");
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(str, z16) { // from class: com.tencent.mobileqq.webview.swift.WebViewPluginEngine.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f314122d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f314123e;

                {
                    this.f314122d = str;
                    this.f314123e = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WebViewPluginEngine.this, str, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        WebViewPluginEngine.this.S(this.f314122d, this.f314123e);
                    }
                }
            });
        }
    }

    public WebViewPluginEngine(CustomWebView customWebView, Activity activity, AppRuntime appRuntime, a aVar, List<WebViewPlugin> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, customWebView, activity, appRuntime, aVar, list);
            return;
        }
        this.f314115d = new ConcurrentHashMap<>();
        this.f314116e = new HashMap<>();
        this.f314117f = new HashMap<>();
        this.f314118h = customWebView;
        this.f314119i = activity;
        this.f314120m = appRuntime;
        this.F = (com.tencent.mobileqq.webview.nativeapi.b) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.nativeapi.b.class);
        C(false, aVar, list);
        I(appRuntime, activity);
    }
}
