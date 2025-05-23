package com.tencent.mobileqq.log;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VipWebViewReportLog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f241736a;

    /* renamed from: b, reason: collision with root package name */
    static Set<String> f241737b;

    /* renamed from: c, reason: collision with root package name */
    static boolean f241738c;

    /* renamed from: d, reason: collision with root package name */
    static boolean f241739d;

    /* renamed from: e, reason: collision with root package name */
    private static Context f241740e;

    /* renamed from: f, reason: collision with root package name */
    private static AppRuntime f241741f;

    /* renamed from: g, reason: collision with root package name */
    private static int f241742g;

    /* renamed from: h, reason: collision with root package name */
    private static int f241743h;

    /* renamed from: i, reason: collision with root package name */
    private static int f241744i;

    /* renamed from: j, reason: collision with root package name */
    public static int f241745j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f241746k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f241747l;

    /* renamed from: m, reason: collision with root package name */
    public static String f241748m;

    /* renamed from: n, reason: collision with root package name */
    public static String f241749n;

    /* renamed from: o, reason: collision with root package name */
    public static String f241750o;

    /* renamed from: p, reason: collision with root package name */
    public static String f241751p;

    /* renamed from: q, reason: collision with root package name */
    static AtomicInteger f241752q;

    /* renamed from: r, reason: collision with root package name */
    private static HighFreqLogUtil f241753r;

    /* renamed from: s, reason: collision with root package name */
    static Thread f241754s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class LoadConfigRbl implements Runnable {
        static IPatchRedirector $redirector_;

        LoadConfigRbl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d("WebCoreDump", 1, "-->start load config at " + currentTimeMillis);
            try {
                FileUtils.deleteDirectory(VipWebViewReportLog.f241746k);
                if (QLog.isColorLevel()) {
                    QLog.d("WebCoreDump", 2, "delete old configs");
                }
            } catch (Exception e16) {
                QLog.e("WebCoreDump", 1, "delete old configs error:", e16.toString());
            }
            if (VipWebViewReportLog.f241741f != null) {
                str = VipWebViewReportLog.f241741f.getApplication().getFilesDir() + File.separator + VipWebViewReportLog.f241747l + VipWebViewReportLog.f241741f.getAccount() + "config.json";
            } else {
                str = "";
            }
            File file = new File(str);
            if (!file.exists()) {
                VipWebViewReportLog.f241744i = VipWebViewReportLog.f241743h;
                VipWebViewReportLog.l();
                QLog.d("WebCoreDump", 1, "-->config file not exist: " + file.getPath());
                VipWebViewReportLog.f241752q.set(0);
            } else {
                QLog.d("WebCoreDump", 1, "-->config file exist");
                VipWebViewReportLog.f241745j = 0;
                VipWebViewReportLog.f241744i = VipWebViewReportLog.f241743h;
                try {
                    try {
                        String readFileContent = FileUtils.readFileContent(file);
                        if (!TextUtils.isEmpty(readFileContent)) {
                            JSONObject jSONObject = new JSONObject(readFileContent);
                            VipWebViewReportLog.f241738c = jSONObject.optBoolean("js_report", true);
                            VipWebViewReportLog.f241739d = jSONObject.optBoolean("url_check", true);
                            if (jSONObject.has("url_list")) {
                                JSONArray jSONArray = jSONObject.getJSONArray("url_list");
                                int length = jSONArray.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    VipWebViewReportLog.f241737b.add(jSONArray.getString(i3));
                                }
                                QLog.d("WebCoreDump", 1, "-->url white list:" + VipWebViewReportLog.f241737b);
                            } else {
                                QLog.d("WebCoreDump", 1, "-->No url white list in config!" + jSONObject.toString());
                            }
                            if (VipWebViewReportLog.f241739d && !jSONObject.has("url_list")) {
                                VipWebViewReportLog.f241752q.set(0);
                            }
                            VipWebViewReportLog.f241752q.set(2);
                        }
                    } catch (Exception e17) {
                        VipWebViewReportLog.f241752q.set(0);
                        QLog.d("WebCoreDump", 1, "-->read config file err:" + e17.toString());
                    }
                    VipWebViewReportLog.l();
                } catch (Throwable th5) {
                    VipWebViewReportLog.l();
                    throw th5;
                }
            }
            QLog.d("WebCoreDump", 1, "parse config cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48393);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f241736a = VipWebViewReportLog.class.getSimpleName();
        f241737b = new HashSet();
        f241738c = false;
        f241739d = false;
        f241740e = null;
        f241741f = null;
        f241742g = 1;
        f241743h = 2;
        f241745j = 0;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AppConstants.SDCARD_PATH);
        sb5.append("WebViewCheck");
        String str = File.separator;
        sb5.append(str);
        f241746k = sb5.toString();
        f241747l = "WebViewCheck" + str;
        f241748m = null;
        f241749n = "null";
        f241750o = "null";
        f241751p = "null";
        f241752q = new AtomicInteger(0);
        f241753r = new HighFreqLogUtil(2);
        f241754s = null;
    }

    public VipWebViewReportLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void d(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return;
        }
        f241749n = "null";
        f241750o = "null";
        f241751p = "null";
        NetworkInfo recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
        if (recentNetworkInfo != null && recentNetworkInfo.isAvailable()) {
            int type = NetworkMonitor.getType(recentNetworkInfo);
            if (type != 9) {
                switch (type) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        f241749n = telephonyManager.getNetworkOperatorName();
                        e(telephonyManager);
                        return;
                    case 1:
                    case 6:
                        f241750o = Global.TRACKING_WIFI;
                        return;
                    default:
                        f241750o = "unknown";
                        f241751p = "unknown";
                        return;
                }
            }
            f241750o = "cable";
        }
    }

    public static void f(Context context, AppRuntime appRuntime) {
        if (f241752q.compareAndSet(0, 1)) {
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 2, "VipWebViewReportLog init by context=" + context + ", AppInterface=" + appRuntime);
            }
            f241740e = context.getApplicationContext();
            f241741f = appRuntime;
            f241744i = f241742g;
            j();
        }
    }

    public static boolean g() {
        if (f241752q.get() != 0) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        QLog.d("WebCoreDump", 1, "-->uin in white list:" + f241739d);
        return f241739d;
    }

    public static boolean i(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : f241737b) {
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    QLog.d("WebCoreDump", 1, "-->url:" + s.d(str, new String[0]) + " is in white list");
                    return true;
                }
            }
        }
        QLog.d("WebCoreDump", 1, "-->url:" + s.d(str, new String[0]) + " is not in white list");
        return false;
    }

    public static void j() {
        Thread thread = f241754s;
        if (thread == null || !thread.isAlive()) {
            f241754s = ThreadManagerV2.newFreeThread(new LoadConfigRbl(), "WebviewLoadConfig", 8);
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 1, "ready to load config at:" + System.currentTimeMillis());
            }
            f241754s.start();
        }
    }

    public static void k(JSONObject jSONObject, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder(4096);
        if ("null".equals(f241750o)) {
            try {
                d((TelephonyManager) f241740e.getSystemService("phone"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        sb5.append("==> SUMMARY INFO <==\nNET_TYPE:");
        sb5.append(f241750o);
        sb5.append("\n");
        sb5.append("ERROR_CODE:");
        sb5.append(i3);
        sb5.append("\n");
        if (jSONObject == null) {
            str = "\n";
        } else {
            long optLong = jSONObject.optLong("dns_start");
            long optLong2 = jSONObject.optLong("dns_end") - optLong;
            long optLong3 = jSONObject.optLong("connect_start");
            long optLong4 = jSONObject.optLong("connect_end") - optLong3;
            long optLong5 = jSONObject.optLong("ssl_handshake_start");
            long optLong6 = jSONObject.optLong("ssl_handshake_end") - optLong5;
            long optLong7 = jSONObject.optLong("send_start");
            long optLong8 = jSONObject.optLong("send_end") - optLong7;
            long optLong9 = jSONObject.optLong("recv_start");
            long optLong10 = jSONObject.optLong("recv_end");
            long j3 = optLong10 - optLong9;
            if (0 == optLong) {
                if (0 != optLong3) {
                    optLong = optLong3;
                } else if (0 != optLong5) {
                    optLong = optLong5;
                } else if (0 != optLong7) {
                    optLong = optLong7;
                } else if (0 != optLong9) {
                    optLong = optLong9;
                } else {
                    optLong = optLong10;
                }
            }
            long j16 = optLong10 - optLong;
            sb5.append("DNS cost=");
            sb5.append(optLong2);
            str = "\n";
            sb5.append(str);
            sb5.append("Create connect cost=");
            sb5.append(optLong4);
            sb5.append(str);
            sb5.append("SSL handshake cost=");
            sb5.append(optLong6);
            sb5.append(str);
            sb5.append("Send cost=");
            sb5.append(optLong8);
            sb5.append(str);
            sb5.append("Receive cost=");
            sb5.append(j3);
            sb5.append(str);
            sb5.append("Total Duration=");
            sb5.append(j16);
            sb5.append(str);
            sb5.append("Original Data:\n");
            sb5.append(jSONObject);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebCoreDump", 2, sb5.toString());
        }
        if (webResourceRequest != null) {
            sb5.setLength(0);
            sb5.append("HAS_GESTURE:" + webResourceRequest.hasGesture() + str);
            sb5.append("IS_FOR_MAINFRAME:" + webResourceRequest.isForMainFrame() + str);
            sb5.append(webResourceRequest.getMethod());
            sb5.append(" ");
            sb5.append(webResourceRequest.getUrl());
            sb5.append(str);
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            if (requestHeaders != null && requestHeaders.size() > 0) {
                for (String str2 : requestHeaders.keySet()) {
                    if (str2.equalsIgnoreCase("cookie")) {
                        sb5.append(str2 + ":" + s.c(requestHeaders.get(str2), new String[0]) + str);
                    } else {
                        sb5.append(str2 + ":" + requestHeaders.get(str2) + str);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 2, "-->HTTP REQUEST\n" + sb5.toString());
            }
        }
        if (webResourceResponse != null) {
            sb5.setLength(0);
            sb5.append("STATUS_CODE:" + webResourceResponse.getStatusCode() + str);
            sb5.append("CONTENT_ENCODING:" + webResourceResponse.getEncoding() + str);
            sb5.append("MIME_TYPE:" + webResourceResponse.getMimeType() + str);
            sb5.append("REASON_PHRASE:" + webResourceResponse.getReasonPhrase() + str);
            Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
            if (responseHeaders != null && responseHeaders.size() > 0) {
                for (String str3 : responseHeaders.keySet()) {
                    sb5.append(str3 + ":" + responseHeaders.get(str3) + str);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebCoreDump", 1, "<--HTTP RESPONSE\n" + sb5.toString());
            }
        }
    }

    public static void m(ConsoleMessage consoleMessage) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            if (f241741f == null) {
                return;
            }
            if ((!QLog.isDevelopLevel() && ((f241744i == f241743h && !f241738c) || consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR)) || b.f241759a.a(consoleMessage)) {
                return;
            }
            String str6 = (((("protocol_ver=1") + "&client_plat_id=109") + "&client_ver=" + ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).getSubVersion()) + "&os_ver=" + Build.VERSION.SDK) + "&uin=" + f241741f.getAccount();
            if (consoleMessage.sourceId() != null) {
                str = str6 + "&err_file=" + URLEncoder.encode(consoleMessage.sourceId());
            } else {
                str = str6 + "&err_file=null";
            }
            String str7 = str + "&err_line=" + String.valueOf(consoleMessage.lineNumber());
            if (consoleMessage.message() != null) {
                str2 = str7 + "&err_message=" + URLEncoder.encode(consoleMessage.message());
            } else {
                str2 = str7 + "&err_message=null";
            }
            String str8 = str2 + "&err_timestamp=" + System.currentTimeMillis();
            if (f241748m != null) {
                str3 = str8 + "&err_page_url=" + URLEncoder.encode(f241748m);
            } else {
                str3 = str8 + "&err_page_url=null";
            }
            if (consoleMessage.messageLevel() != null) {
                str4 = str3 + "&err_level=" + consoleMessage.messageLevel().toString();
            } else {
                str4 = str3 + "&err_level=null";
            }
            String str9 = str4 + "&phone_model=" + DeviceInfoMonitor.getModel();
            if (QLog.isColorLevel()) {
                str5 = str9 + "&user_status=COLORUSER";
            } else {
                str5 = str9 + "&user_status=COMMONUSER";
            }
            try {
                d((TelephonyManager) f241740e.getSystemService("phone"));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            f241753r.d(f241736a, 1, ((str5 + "&networkOperator=" + f241749n) + "&mNetworkType=" + f241750o) + "&mobileType=" + f241751p);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
    }

    public static void l() {
    }

    private static void e(TelephonyManager telephonyManager) {
    }
}
