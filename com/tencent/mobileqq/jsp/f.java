package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.WiFiDash;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static PowerManager.WakeLock f238866f;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f238867h;

    /* renamed from: d, reason: collision with root package name */
    private int[] f238868d;

    /* renamed from: e, reason: collision with root package name */
    private String f238869e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f238867h = false;
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238869e = "";
        }
    }

    private int v() {
        return com.tencent.mobileqq.utils.ah.n();
    }

    public static void w(boolean z16, Context context, boolean z17) {
        if (z16) {
            if (f238866f == null) {
                f238866f = ((PowerManager) context.getSystemService("power")).newWakeLock(10, "device:VasWakeLock");
            }
            f238866f.acquire();
            f238867h = true;
            return;
        }
        PowerManager.WakeLock wakeLock = f238866f;
        if (wakeLock != null && wakeLock.isHeld()) {
            f238866f.release();
        }
        if (!z17) {
            f238867h = false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "device";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0033 -> B:17:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getTotalMem() {
        ?? r26;
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && (r26 = iPatchRedirector.hasPatch((short) 13)) != 0) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
            r26 = r26;
        }
        try {
            try {
                r26 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
            } catch (FileNotFoundException e17) {
                e = e17;
                r26 = 0;
            } catch (IOException e18) {
                e = e18;
                r26 = 0;
            } catch (Throwable th6) {
                th5 = th6;
                if (bufferedReader != null) {
                }
                throw th5;
            }
            try {
                String readLine = r26.readLine();
                if (readLine != null) {
                    str = readLine;
                }
                r26.close();
                r26 = r26;
            } catch (FileNotFoundException e19) {
                e = e19;
                e.printStackTrace();
                if (r26 != 0) {
                    r26.close();
                    r26 = r26;
                }
                if (str != null) {
                }
            } catch (IOException e26) {
                e = e26;
                e.printStackTrace();
                if (r26 != 0) {
                    r26.close();
                    r26 = r26;
                }
                if (str != null) {
                }
            }
            if (str != null) {
                return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
            }
            return 0L;
        } catch (Throwable th7) {
            th5 = th7;
            bufferedReader = r26;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("DeviceApiPlugin", 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str != null && "device".equals(str2) && str3 != null) {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DeviceApiPlugin", 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            try {
                if (jsonFromJSBridge.has("callback")) {
                    str4 = jsonFromJSBridge.getString("callback");
                } else {
                    int indexOf = str.indexOf("#");
                    if (indexOf != -1 && (i3 = indexOf + 1) <= str.length() - 1) {
                        str4 = str.substring(i3);
                    }
                    return false;
                }
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.i("DeviceApiPlugin", 2, "Failed to parse callbackid,json=" + jsonFromJSBridge);
                }
                str4 = null;
            }
            if (str4 == null) {
                return false;
            }
            if ("setScreenStatus".equals(str3)) {
                try {
                    w((jsonFromJSBridge.has("status") ? jsonFromJSBridge.getInt("status") : 0) == 1, this.mRuntime.a().getApplicationContext(), false);
                    callJs(str4, f238867h ? "{'result':1,'message':'light'}" : "{'result':0,'message':'dim'}");
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DeviceApiPlugin", 2, "Failed to setScreenStatus:" + e16.getMessage());
                    }
                    callJs(str4, "{'result':-1,'message':" + e16.getMessage() + "}");
                }
            } else if ("getWebpDecoderVersion".equals(str3)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", -1);
                    if (this.f238868d != null) {
                        jSONObject.put("result", 0);
                        jSONObject.put("type", this.f238869e);
                        jSONObject.put("version", String.format("%d.%d.%d", Integer.valueOf(this.f238868d[0]), Integer.valueOf(this.f238868d[1]), Integer.valueOf(this.f238868d[2])));
                    }
                    callJs(str4, jSONObject.toString());
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            } else if ("canInstallThirdPartyApp".equals(str3)) {
                Activity a16 = this.mRuntime.a();
                if (a16 != null) {
                    str5 = "{'result':" + Settings.Secure.getInt(a16.getContentResolver(), "install_non_market_apps", 0) + "}";
                } else {
                    str5 = "{'result':-1,'message':'Context is null!'}";
                }
                callJs(str4, str5);
            } else {
                if ("getCPUInfo".equals(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("maxFreq", t());
                        jSONObject2.put("minFreq", u());
                        jSONObject2.put("curFreq", r());
                        jSONObject2.put("CPUName", q());
                        String jSONObject3 = jSONObject2.toString();
                        QLog.i("DeviceApiPlugin", 2, "getCPUInfo : " + jSONObject3);
                        callJs(str4, jSONObject3);
                    } catch (JSONException e18) {
                        e18.printStackTrace();
                    }
                    return true;
                }
                if ("getMemInfo".equals(str3)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("idleMem", s());
                        jSONObject4.put("totalMem", getTotalMem());
                        String jSONObject5 = jSONObject4.toString();
                        QLog.i("DeviceApiPlugin", 2, "getMemInfo : " + jSONObject5);
                        callJs(str4, jSONObject5);
                    } catch (JSONException e19) {
                        e19.printStackTrace();
                    }
                } else if ("getCPUCoreNum".equals(str3)) {
                    try {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("count", v());
                        String jSONObject7 = jSONObject6.toString();
                        QLog.i("DeviceApiPlugin", 2, "getCPUCoreNum : " + jSONObject7);
                        callJs(str4, jSONObject7);
                    } catch (JSONException e26) {
                        e26.printStackTrace();
                    }
                } else if ("getConfiguration".equals(str3)) {
                    try {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put(DownloadInfo.spKey_Config, p());
                        String jSONObject9 = jSONObject8.toString();
                        QLog.i("DeviceApiPlugin", 1, "getConfiguration : " + jSONObject9);
                        callJs(str4, jSONObject9);
                    } catch (JSONException e27) {
                        QLog.e("DeviceApiPlugin", 1, "getConfiguration ", e27.toString());
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.w("DeviceApiPlugin", 2, "NOT support method " + str3 + " yet!!");
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (f238867h) {
            w(false, null, false);
        }
        PowerManager.WakeLock wakeLock = f238866f;
        if (wakeLock != null && wakeLock.isHeld()) {
            f238866f.release();
        }
        f238866f = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) customWebView);
            return;
        }
        super.onWebViewCreated(customWebView);
        if (customWebView != null && customWebView.getX5WebViewExtension() != null) {
            this.f238868d = new int[]{0, 3, 0, 0};
            this.f238869e = "QQBrowser";
            return;
        }
        int[] b16 = WebpSoLoader.b();
        this.f238868d = b16;
        if (b16 != null) {
            if (WebpSoLoader.f306528a != null) {
                this.f238869e = "Hook";
            } else {
                this.f238869e = "System";
            }
        }
    }

    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = "";
        try {
            str = BaseApplicationImpl.getApplication().getResources().getConfiguration().toString();
            if (QLog.isColorLevel()) {
                QLog.d("DeviceApiPlugin", 2, "getConfiguration:", str);
            }
        } catch (Throwable th5) {
            QLog.e("DeviceApiPlugin", 1, "getConfiguration ", th5);
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public String q() {
        ?? r26;
        Throwable th5;
        ?? r16;
        BufferedReader bufferedReader;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null) {
            r16 = 11;
            r26 = iPatchRedirector.hasPatch((short) 11);
            if (r26 != 0) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
        }
        try {
            try {
                try {
                    r16 = new FileReader("/proc/cpuinfo");
                } catch (FileNotFoundException e16) {
                    e = e16;
                    r16 = 0;
                    bufferedReader = null;
                } catch (IOException e17) {
                    e = e17;
                    r16 = 0;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    r26 = 0;
                    th5 = th6;
                    r16 = 0;
                }
                try {
                    bufferedReader = new BufferedReader(r16);
                } catch (FileNotFoundException e18) {
                    e = e18;
                    bufferedReader = null;
                } catch (IOException e19) {
                    e = e19;
                    bufferedReader = null;
                } catch (Throwable th7) {
                    r26 = 0;
                    th5 = th7;
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (r26 != 0) {
                        try {
                            r26.close();
                            throw th5;
                        } catch (IOException e27) {
                            e27.printStackTrace();
                            throw th5;
                        }
                    }
                    throw th5;
                }
                try {
                    String[] split = bufferedReader.readLine().split(":\\s+", 2);
                    for (int i3 = 0; i3 < split.length; i3++) {
                    }
                    String str = split[1];
                    try {
                        r16.close();
                    } catch (IOException e28) {
                        e28.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                    return str;
                } catch (FileNotFoundException e36) {
                    e = e36;
                    e.printStackTrace();
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return null;
                } catch (IOException e38) {
                    e = e38;
                    e.printStackTrace();
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e39) {
                            e39.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return null;
                }
            } catch (Throwable th8) {
                th5 = th8;
            }
        } catch (IOException e46) {
            e46.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.FileReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public String r() {
        ?? r26;
        Throwable th5;
        ?? r16;
        BufferedReader bufferedReader;
        IOException e16;
        FileNotFoundException e17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null) {
            r16 = 10;
            r26 = iPatchRedirector.hasPatch((short) 10);
            if (r26 != 0) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }
        try {
            try {
                try {
                    r16 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                } catch (FileNotFoundException e18) {
                    bufferedReader = null;
                    e17 = e18;
                    r16 = 0;
                } catch (IOException e19) {
                    bufferedReader = null;
                    e16 = e19;
                    r16 = 0;
                } catch (Throwable th6) {
                    r26 = 0;
                    th5 = th6;
                    r16 = 0;
                }
                try {
                    bufferedReader = new BufferedReader(r16);
                } catch (FileNotFoundException e26) {
                    bufferedReader = null;
                    e17 = e26;
                } catch (IOException e27) {
                    bufferedReader = null;
                    e16 = e27;
                } catch (Throwable th7) {
                    r26 = 0;
                    th5 = th7;
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (r26 != 0) {
                        try {
                            r26.close();
                            throw th5;
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            throw th5;
                        }
                    }
                    throw th5;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    r16.close();
                    bufferedReader.close();
                    String trim = readLine.trim();
                    try {
                        r16.close();
                    } catch (IOException e36) {
                        e36.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                        return trim;
                    } catch (IOException e37) {
                        e37.printStackTrace();
                        return trim;
                    }
                } catch (FileNotFoundException e38) {
                    e17 = e38;
                    e17.printStackTrace();
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e39) {
                            e39.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return WiFiDash.NOT_AVALIBLE;
                } catch (IOException e46) {
                    e16 = e46;
                    e16.printStackTrace();
                    if (r16 != 0) {
                        try {
                            r16.close();
                        } catch (IOException e47) {
                            e47.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return WiFiDash.NOT_AVALIBLE;
                }
            } catch (Throwable th8) {
                th5 = th8;
            }
        } catch (IOException e48) {
            e48.printStackTrace();
        }
    }

    public long s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        ActivityManager activityManager = (ActivityManager) this.mRuntime.a().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return String.valueOf(com.tencent.mobileqq.utils.ah.m());
    }

    public String u() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
            str = WiFiDash.NOT_AVALIBLE;
        }
        return str.trim();
    }
}
