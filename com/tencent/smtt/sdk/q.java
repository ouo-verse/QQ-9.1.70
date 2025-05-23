package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.config.FeatureConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private DexLoader f369496a;

    /* renamed from: b, reason: collision with root package name */
    private String f369497b = "";

    public q(DexLoader dexLoader) {
        this.f369496a = dexLoader;
        Map<String, Boolean> coreFeatureMethodToSetMap = FeatureConfig.getCoreFeatureMethodToSetMap();
        if (coreFeatureMethodToSetMap != null && coreFeatureMethodToSetMap.size() > 0) {
            for (Map.Entry<String, Boolean> entry : coreFeatureMethodToSetMap.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    b(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }
    }

    public boolean a() throws Throwable {
        try {
            Method method = this.f369496a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            if (invoke instanceof Boolean) {
                this.f369497b = "normal_" + ((Boolean) invoke);
                return ((Boolean) invoke).booleanValue();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("end_");
            Boolean bool = (Boolean) invoke;
            sb5.append(bool);
            sb5.append("_");
            sb5.append("notBoolean");
            this.f369497b = sb5.toString();
            return bool.booleanValue();
        } catch (Throwable th5) {
            this.f369497b = "Throwable";
            throw th5;
        }
    }

    public DexLoader b() {
        return this.f369496a;
    }

    public Object c() {
        return this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    public boolean d() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void e() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    public String f() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public Object g() {
        return this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public boolean h() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public IX5WebChromeClient i() {
        Object invokeStaticMethod;
        DexLoader dexLoader = this.f369496a;
        if (dexLoader == null || (invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0])) == null) {
            return null;
        }
        return (IX5WebChromeClient) invokeStaticMethod;
    }

    public IX5WebViewClient j() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClient) invokeStaticMethod;
    }

    public IX5WebViewClientExtension k() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5WebViewClientExtension) invokeStaticMethod;
    }

    public void l() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    public void m() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    public void n() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    public void o() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    }

    public boolean p(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean q(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean r(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean s(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean t(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean u(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean v(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean w(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean x(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public String y(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public void b(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    public void c(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    public void e(Context context) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    public void g(Context context) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    public String l(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public String m(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public boolean n(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean o(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean b(Context context) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void d(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    public void e(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    public boolean f(Context context) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void g(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
    }

    public IX5DateSorter h(Context context) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (IX5DateSorter) invokeStaticMethod;
    }

    public String j(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public boolean k(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void p() {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }

    public IX5CoreServiceWorkerController q() {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getServiceWorkerController", new Class[0], new Object[0]);
        if (invokeStaticMethod instanceof IX5CoreServiceWorkerController) {
            return (IX5CoreServiceWorkerController) invokeStaticMethod;
        }
        return null;
    }

    public void c(Context context) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    public boolean d(Context context) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean i(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void b(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void c(String str, android.webkit.ValueCallback<Boolean> valueCallback) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void f(String str) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
    }

    public String h(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public void b(android.webkit.ValueCallback<Set<String>> valueCallback) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public String i(Context context) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            return (String) invokeStaticMethod;
        }
        return null;
    }

    public String b(String str, String str2, String str3) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public void b(String str, boolean z16) {
        this.f369496a.invokeStaticMethod("com.tencent.smtt.webkit.DefaultConfigManager", "setCoreFeatureCommonMethod", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z16));
    }

    public boolean a(Map<String, String[]> map) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void a(boolean z16) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z16));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IX5WebViewBase a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        try {
            if (invokeStaticMethod == null) {
                Object invokeStaticMethod2 = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().a(context, 325, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().a(context, 325, new Throwable((String) invokeStaticMethod2));
                }
                invokeStaticMethod = null;
                iX5WebViewBase = null;
            } else {
                iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                if (iX5WebViewBase != null) {
                    try {
                        if (iX5WebViewBase.getView() == null) {
                            TbsCoreLoadStat.getInstance().a(context, 325, new Throwable("x5webview.getView is null!"));
                            invokeStaticMethod = null;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (invokeStaticMethod != null) {
                        }
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
            iX5WebViewBase = null;
        }
        if (invokeStaticMethod != null) {
            return null;
        }
        return iX5WebViewBase;
    }

    public String a(String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public InputStream a(String str, boolean z16) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z16));
        if (invokeStaticMethod == null) {
            return null;
        }
        return (InputStream) invokeStaticMethod;
    }

    public Uri[] a(int i3, Intent intent) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i3), intent);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (Uri[]) invokeStaticMethod;
    }

    public void a(String str, IconListener iconListener) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    public void a(android.webkit.ValueCallback<Map> valueCallback) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public void a(String str, android.webkit.ValueCallback<Long> valueCallback) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void a(String str, long j3) {
        this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j3));
    }

    public String a(String str, String str2, String str3) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    public byte[] a(byte[] bArr) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            return null;
        }
        return (byte[]) invokeStaticMethod;
    }

    public void a(Context context, boolean z16) {
        TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
        if (z16) {
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            return;
        }
        try {
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z16));
        } catch (Exception unused) {
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f369496a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.f369496a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f369496a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            Object invokeStaticMethod2 = this.f369496a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod2 != null) {
                this.f369496a.invokeMethod(invokeStaticMethod2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        }
    }

    public int a(Context context, String str, Map<String, String> map, String str2, android.webkit.ValueCallback<String> valueCallback) {
        if (TbsDownloader.getOverSea(context)) {
            return -103;
        }
        if (str2 == null) {
            Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, android.webkit.ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            if (invokeStaticMethod == null) {
                return -104;
            }
            return ((Integer) invokeStaticMethod).intValue();
        }
        Object invokeStaticMethod2 = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
        if (invokeStaticMethod2 == null) {
            return -104;
        }
        return ((Integer) invokeStaticMethod2).intValue();
    }

    public boolean a(Context context, String str) {
        Object invokeStaticMethod = this.f369496a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }
}
