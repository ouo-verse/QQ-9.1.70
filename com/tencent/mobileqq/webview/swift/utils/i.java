package com.tencent.mobileqq.webview.swift.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.startup.BrowserAutomator;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static ArrayList<String> f314756a;

        /* renamed from: b, reason: collision with root package name */
        public static int f314757b;

        /* renamed from: c, reason: collision with root package name */
        public static boolean f314758c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f314759d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49488);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f314756a = new ArrayList<>();
            f314757b = -1;
            f314758c = false;
            f314759d = false;
        }
    }

    public static WebResourceResponse a() {
        WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
        Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
        if (responseHeaders == null) {
            responseHeaders = new HashMap<>();
        }
        responseHeaders.put("cache-control", "must-revalidate\uff0cno-store");
        webResourceResponse.setResponseHeaders(responseHeaders);
        return webResourceResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(JSONObject jSONObject, String str) {
        boolean z16;
        int length;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null || !waitAppRuntime.isLogin() || !com.tencent.mobileqq.webview.util.s.j(waitAppRuntime.getAccount())) {
            return false;
        }
        String optString = jSONObject.optString(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "");
        if (!"0".equals(optString) && !"2".equals(optString)) {
            QLog.e("SwiftWebViewUtils", 1, "not support Android! " + jSONObject.toString());
            return false;
        }
        boolean r16 = r(jSONObject, str);
        if (r16) {
            String account = waitAppRuntime.getAccount();
            int optInt = jSONObject.optInt("startIndex");
            int optInt2 = jSONObject.optInt("endIndex");
            if (optInt >= optInt2 && (length = account.length()) >= optInt && length >= optInt2) {
                int i3 = length - optInt;
                int i16 = length - optInt2;
                if (i3 < length && i16 < length && i3 <= i16) {
                    long parseLong = Long.parseLong(account.substring(i3, i16 + 1));
                    long optLong = jSONObject.optLong(Element.ELEMENT_NAME_MIN);
                    long optLong2 = jSONObject.optLong("max");
                    if (parseLong >= optLong && parseLong <= optLong2) {
                        z16 = true;
                        if (!z16) {
                            String optString2 = jSONObject.optString("uinWhiteList");
                            if (!TextUtils.isEmpty(optString2)) {
                                for (String str2 : optString2.split(";")) {
                                    if (account.equals(str2)) {
                                        r16 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        r16 = z16;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            r16 = z16;
        }
        if (!r16) {
            QLog.e("SwiftWebViewUtils", 1, "Config is not valid: " + jSONObject);
        }
        return r16;
    }

    public static int c(int i3) {
        return (i3 >> 8) & 255;
    }

    public static int d(int i3) {
        return i3 & 255;
    }

    public static void e() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Bundle bundle = new Bundle();
        bundle.putString("action", "deleteQBApk");
        QbSdk.setUserID(applicationContext, bundle);
        if (QLog.isColorLevel()) {
            QLog.i("SwiftWebViewUtils", 2, "clearQBExtraCache");
        }
    }

    public static int f(int i3, int i16) {
        return i3 + (i16 << 8);
    }

    public static AppRuntime g(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            peekAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        if (peekAppRuntime == null) {
            QLog.e("SwiftWebViewUtils", 1, "getAppModuleRuntime(" + str + ") = null!", new IllegalStateException());
            return null;
        }
        return peekAppRuntime.getAppRuntime(str);
    }

    public static Bundle h() {
        String str;
        if (a.f314758c || a.f314759d) {
            StringBuilder sb5 = new StringBuilder("_tcvassp_0_=");
            if (a.f314757b != -1 && a.f314756a.size() != 0) {
                sb5.append(a.f314757b);
                if (a.f314759d) {
                    str = "shp";
                } else {
                    str = "webp";
                }
                sb5.append(str);
                Bundle bundle = new Bundle();
                bundle.putString("argument", sb5.toString());
                ArrayList<String> arrayList = new ArrayList<>();
                try {
                    arrayList.addAll(a.f314756a);
                } catch (Throwable th5) {
                    QLog.e("SwiftWebViewUtils", 1, th5, new Object[0]);
                }
                bundle.putStringArrayList("domains", arrayList);
                if (QLog.isDevelopLevel()) {
                    QLog.i("SwiftWebViewUtils", 2, "getCDNExtensionData, arg: " + ((Object) sb5) + " ,domainList:" + TextUtils.join(", ", arrayList));
                }
                return bundle;
            }
            if (QLog.isColorLevel()) {
                QLog.w("SwiftWebViewUtils", 2, "CdnCacheConfig did not parse!!!");
                return null;
            }
            return null;
        }
        return null;
    }

    public static String i(String str) {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append("Dalvik/");
        sb5.append(System.getProperty("java.vm.version"));
        sb5.append(" (Linux; U; Android ");
        String str2 = Build.VERSION.RELEASE;
        if (str2.length() <= 0) {
            str2 = "1.0";
        }
        sb5.append(str2);
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = DeviceInfoMonitor.getModel();
            if (model.length() > 0) {
                sb5.append("; ");
                sb5.append(model);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            sb5.append(" Build/");
            sb5.append(str3);
        }
        sb5.append(str);
        sb5.append(")");
        return sb5.toString();
    }

    @NonNull
    public static String j() {
        int a16 = com.tencent.mobileqq.webview.util.g.a();
        if (a16 != -1) {
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3) {
                        if (a16 != 4) {
                            return "";
                        }
                        return " NetType/4G";
                    }
                    return " NetType/3G";
                }
                return " NetType/2G";
            }
            return " NetType/WIFI";
        }
        return " NetType/UNKNOWN";
    }

    public static String k(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(":")) > 0) {
            return str.substring(0, indexOf).toLowerCase();
        }
        return "";
    }

    public static String l(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(":")) > 0) {
            int indexOf2 = (str + "?#").indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf2 > 50) {
                indexOf2 = 50;
            }
            int i3 = indexOf + 3;
            if (i3 < str.length() && indexOf2 >= 0) {
                return str.substring(i3, indexOf2);
            }
            return "";
        }
        return "";
    }

    public static String m(String str) {
        StringBuilder sb5 = new StringBuilder("url:");
        if (str != null && str.length() > 512) {
            sb5.append(str.substring(0, 512));
        } else {
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static String n(String str, String str2, boolean z16) {
        String str3;
        String str4 = (String) BrowserAutomator.k(com.tencent.mobileqq.webview.swift.startup.b.STEP_UA_INIT);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " " + str2;
        }
        String a16 = ((com.tencent.mobileqq.webview.swift.injector.v) aa.k(com.tencent.mobileqq.webview.swift.injector.v.class)).a(z16);
        if (!TextUtils.isEmpty(a16)) {
            a.f314758c = true;
        }
        a.f314759d = z16;
        String format = String.format(str4, str, str3, a16);
        if (QLog.isDevelopLevel()) {
            QLog.i("SwiftWebViewUtils", 2, String.format("getWebViewUAForQQ [%s]", format));
        }
        return format;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean o(String str, String str2) {
        int parseInt;
        int parseInt2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 < split.length) {
                    try {
                        parseInt = Integer.parseInt(split[i3]);
                    } catch (Exception unused) {
                    }
                    if (i3 < split2.length) {
                        try {
                            parseInt2 = Integer.parseInt(split2[i3]);
                        } catch (Exception unused2) {
                        }
                        if (i3 != min - 1) {
                            if (parseInt2 > parseInt) {
                                return true;
                            }
                            if (parseInt2 < parseInt) {
                                return false;
                            }
                        } else {
                            if (parseInt2 >= parseInt) {
                                return true;
                            }
                            if (parseInt2 < parseInt) {
                                return false;
                            }
                        }
                    }
                    parseInt2 = 0;
                    if (i3 != min - 1) {
                    }
                }
                parseInt = 0;
                if (i3 < split2.length) {
                }
                parseInt2 = 0;
                if (i3 != min - 1) {
                }
            }
        }
        return false;
    }

    public static boolean p() {
        int intValue = WebAccelerateHelper.getInstance().getWebViewFeatureParams()[14].intValue();
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && intValue == -1) {
            return true;
        }
        QLog.d("SwiftWebViewUtils", 1, "isSupportPreRend: " + intValue);
        if (intValue == 1) {
            return true;
        }
        return false;
    }

    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse.isHierarchical()) {
            String queryParameter = parse.getQueryParameter("_tbs_xv");
            if (!TextUtils.isEmpty(queryParameter) && 1 == (Long.parseLong(queryParameter) & 1)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean r(JSONObject jSONObject, String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(jSONObject.optString("business", ""))) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getSubVersion() + "." + ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).f();
        if (z16 && jSONObject.has("minVersion")) {
            String optString = jSONObject.optString("minVersion");
            if (!TextUtils.isEmpty(optString) && !o(optString, str2)) {
                z16 = false;
            }
        }
        if (z16 && jSONObject.has("maxVersion")) {
            String optString2 = jSONObject.optString("maxVersion");
            if (!TextUtils.isEmpty(optString2) && !o(str2, optString2)) {
                return false;
            }
        }
        return z16;
    }

    private static boolean s(String str) {
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) com.tencent.mobileqq.webview.util.t.j().b("debug_webview_cookie_dump_on", Boolean.FALSE)).booleanValue()) {
            return true;
        }
        if (QLog.isDevelopLevel() && !TextUtils.isEmpty(str) && ((str.contains("Domain=qq.com") || str.contains("Domain=.qq.com")) && str.contains("p_skey="))) {
            return true;
        }
        return false;
    }

    public static void t(Bundle bundle) {
        String str;
        if (bundle == null) {
            QLog.e("SwiftWebViewUtils", 1, "bundle is null");
            return;
        }
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("onSetCookieInfoCallback ");
        sb5.append(bundle.toString());
        if (QLog.isColorLevel()) {
            QLog.d("SwiftWebViewUtils", 2, sb5.toString());
        }
        String string = bundle.getString("cookieValue");
        if (s(string)) {
            String string2 = bundle.getString(TtmlNode.ATTR_TTS_ORIGIN);
            String string3 = bundle.getString("url");
            QLog.e("SwiftBrowserCookieMonster", 1, "onSetCookieInfoCallback v=" + string + " origin=" + string2 + " url=" + string3);
            HashMap<String, String> hashMap = new HashMap<>();
            if (string == null) {
                string = "null";
            }
            hashMap.put("cookieValue", string);
            hashMap.put(TtmlNode.ATTR_TTS_ORIGIN, string2);
            hashMap.put("url", SwiftBrowserStatistics.u(string3));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getAccount();
            } else {
                str = "0";
            }
            hashMap.put("qqnum", str);
            ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "wvSetCookieError", true, 0L, 0L, hashMap, "");
        }
    }

    public static void u() {
        if (a.f314756a.size() != 0 && a.f314757b != -1) {
            return;
        }
        boolean f16 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).f();
        if (QLog.isColorLevel()) {
            QLog.i("SwiftWebViewUtils", 2, String.format("initCdnCacheConfig result=%b", Boolean.valueOf(f16)));
        }
    }

    public static String v(Intent intent) {
        if (intent == null) {
            return "";
        }
        String stringExtra = intent.getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra("key_params_qq");
            if (stringExtra2 == null) {
                return "";
            }
            return stringExtra2;
        }
        return stringExtra;
    }

    public static void w(String str) {
        if (!com.tencent.mobileqq.webview.util.t.j().c("default_wv_useragent", "").equals(str)) {
            com.tencent.mobileqq.webview.util.t.j().e("default_wv_useragent", str).g();
            QLog.i("SwiftWebViewUtils", 1, "updateDefaultUAIfNeed: " + str);
        }
    }
}
