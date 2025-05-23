package com.tencent.xweb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.e0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.yq.l;
import com.tencent.luggage.wxa.yq.m;
import com.tencent.luggage.wxa.yq.q;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdk;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes27.dex */
public class WebDebugCfg {

    /* renamed from: a, reason: collision with root package name */
    public Context f384980a;

    /* renamed from: b, reason: collision with root package name */
    public WebView.WebViewKind f384981b = WebView.WebViewKind.WV_KIND_NONE;

    /* renamed from: c, reason: collision with root package name */
    public boolean f384982c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f384983d = false;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Holder {

        /* renamed from: a, reason: collision with root package name */
        public static final WebDebugCfg f384984a = new WebDebugCfg();
    }

    public static WebDebugCfg getInst() {
        return Holder.f384984a;
    }

    public final void a() {
        l.g().abandonCurrentScheduler();
        m.f().abandonCurrentScheduler();
    }

    public final void b() {
        SharedPreferences.Editor edit = y0.o().edit();
        edit.putLong("nLastFetchConfigTime", 0L);
        edit.commit();
    }

    public void cleanTestSetting() {
        SharedPreferences r16 = y0.r();
        if (r16 != null) {
            r16.edit().clear().commit();
        }
    }

    public boolean getDisableFileReaderCache() {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            return false;
        }
        return r16.getBoolean("fr_disable_cache", false);
    }

    public boolean getDisableFileReaderCrashDetect() {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            return false;
        }
        return r16.getBoolean("fr_disable_crash_detect", false);
    }

    public boolean getDisableFileReaderEncry() {
        SharedPreferences r16 = y0.r();
        if (r16 == null) {
            return true;
        }
        return r16.getBoolean("fr_disable_encry", true);
    }

    public boolean getEnableCheckStorage() {
        return y0.r().getBoolean("bEnableCheckStorage", false);
    }

    public boolean getEnableCheckThread() {
        return y0.r().getBoolean("bEnableCheckThread", false);
    }

    public boolean getEnableDebugPackage() {
        return y0.r().getBoolean("enableDebugPackage", false);
    }

    public boolean getEnableLocalDebug() {
        return y0.r().getBoolean("bEnableLocalDebug", false);
    }

    public boolean getEnableNewDebugPage() {
        return y0.r().getBoolean("enableNewDebugPage", false);
    }

    public boolean getEnableRemoteDebug() {
        return y0.r().getBoolean("bEnableRemoteDebug", false);
    }

    public boolean getEnableShowFps() {
        return y0.r().getBoolean("bShowFps", false);
    }

    public boolean getEnableShowSavePage() {
        return y0.r().getBoolean("bShowSavePage", false);
    }

    public boolean getEnableShowVersion() {
        return y0.r().getBoolean("bShowVersion", false);
    }

    public boolean getEnableTestBaseConfig() {
        return !TextUtils.isEmpty(z0.h());
    }

    public FileReaderHelper.UseOfficeReader getForceUseOfficeReader(String str) {
        try {
            SharedPreferences r16 = y0.r();
            if (r16 == null) {
                return FileReaderHelper.UseOfficeReader.none;
            }
            return CommandCfgPlugin.convertUseOfficeReader(r16.getString("force_use_office_reader_" + str.toLowerCase(), ""));
        } catch (Throwable th5) {
            x0.a("WebDebugCfg", "getForceUseOfficeReader error", th5);
            return FileReaderHelper.UseOfficeReader.none;
        }
    }

    public boolean getIgnoreCrashWatch() {
        return y0.r().getBoolean("bIgnoreCrashWatch", false);
    }

    public boolean getRemoteDebugStarted() {
        return y0.r().getBoolean("bRemoteDebugStarted", false);
    }

    public String getRemoteDebugToken() {
        return y0.r().getString("bRemoteDebugToken", "");
    }

    public WebView.WebViewKind getWebViewKind(String str) {
        if (str != null && !str.isEmpty() && this.f384980a != null) {
            SharedPreferences r16 = y0.r();
            if (r16 == null) {
                return WebView.WebViewKind.WV_KIND_NONE;
            }
            String string = r16.getString("HardCodeWebView" + str, "");
            if (string != null && !string.isEmpty()) {
                x0.d("WebDebugCfg", "has hardcode type:" + string);
            }
            if (string == null || string.isEmpty() || string.equals(WebView.WebViewKind.WV_KIND_NONE.toString())) {
                string = r16.getString("ABTestWebView" + str, "");
                if (string != null && !string.isEmpty()) {
                    x0.d("WebDebugCfg", "has abtest type:" + string);
                }
            }
            if (string != null && !string.isEmpty()) {
                try {
                    this.f384981b = WebView.WebViewKind.valueOf(string);
                } catch (Throwable unused) {
                    this.f384981b = WebView.WebViewKind.WV_KIND_NONE;
                }
            } else {
                this.f384981b = WebView.WebViewKind.WV_KIND_NONE;
            }
            return this.f384981b;
        }
        return WebView.WebViewKind.WV_KIND_NONE;
    }

    public WebView.WebViewKind getWebViewKindTest(String str, boolean z16) {
        String string;
        if (str != null && !str.isEmpty() && this.f384980a != null) {
            SharedPreferences r16 = y0.r();
            if (r16 == null) {
                return WebView.WebViewKind.WV_KIND_NONE;
            }
            if (z16) {
                string = r16.getString("ABTestWebView" + str, "");
            } else {
                string = r16.getString("HardCodeWebView" + str, "");
            }
            if (string != null && !string.isEmpty()) {
                try {
                    this.f384981b = WebView.WebViewKind.valueOf(string);
                } catch (Throwable unused) {
                    this.f384981b = WebView.WebViewKind.WV_KIND_NONE;
                }
            } else {
                this.f384981b = WebView.WebViewKind.WV_KIND_NONE;
            }
            return this.f384981b;
        }
        return WebView.WebViewKind.WV_KIND_NONE;
    }

    public int getWebViewModeForMM() {
        return y0.r().getInt("WebViewModeForMM", -1);
    }

    public boolean isDebugMode() {
        return this.f384982c;
    }

    public boolean isDebugModeReplace() {
        return this.f384983d;
    }

    public synchronized void load(Context context) {
        if (this.f384980a != null) {
            return;
        }
        x0.f("WebDebugCfg", "load start");
        Context convertContextToApplication = XWalkEnvironment.convertContextToApplication(context);
        this.f384980a = convertContextToApplication;
        y0.a(convertContextToApplication);
        x0.f("WebDebugCfg", "load end");
    }

    public void setABTestWebViewKind(String str, WebView.WebViewKind webViewKind) {
        if (this.f384980a != null && str != null && !str.isEmpty()) {
            x0.d("WebDebugCfg", "setABTestWebViewKind, module:" + str + ", kind:" + webViewKind.toString());
            if (webViewKind == WebView.WebViewKind.WV_KIND_NONE) {
                y0.r().edit().remove("ABTestWebView" + str).commit();
                return;
            }
            y0.r().edit().putString("ABTestWebView" + str, webViewKind.toString()).commit();
        }
    }

    public void setDisableFileReaderCache(boolean z16) {
        SharedPreferences.Editor edit;
        int availableVersion;
        SharedPreferences r16 = y0.r();
        if (r16 == null || (edit = r16.edit()) == null) {
            return;
        }
        edit.putBoolean("fr_disable_cache", z16);
        edit.commit();
        if (z16) {
            for (XWalkPlugin xWalkPlugin : XWalkPluginManager.getAllPlugins()) {
                if ((xWalkPlugin instanceof XWalkReaderBasePlugin) && (availableVersion = xWalkPlugin.getAvailableVersion(true)) >= 0) {
                    String privateCacheDir = xWalkPlugin.getPrivateCacheDir(availableVersion);
                    if (!privateCacheDir.isEmpty()) {
                        w.a(privateCacheDir);
                    }
                }
            }
        }
    }

    public void setDisableFileReaderCrashDetect(boolean z16) {
        SharedPreferences.Editor edit;
        SharedPreferences r16 = y0.r();
        if (r16 == null || (edit = r16.edit()) == null) {
            return;
        }
        edit.putBoolean("fr_disable_crash_detect", z16);
        edit.commit();
    }

    public void setDisableFileReaderEncry(boolean z16) {
        SharedPreferences.Editor edit;
        SharedPreferences r16 = y0.r();
        if (r16 == null || (edit = r16.edit()) == null) {
            return;
        }
        edit.putBoolean("fr_disable_encry", z16);
        edit.commit();
    }

    public void setEnableCheckStorage(boolean z16) {
        y0.r().edit().putBoolean("bEnableCheckStorage", z16).commit();
    }

    public void setEnableCheckThread(boolean z16) {
        y0.r().edit().putBoolean("bEnableCheckThread", z16).commit();
    }

    public void setEnableDebugPackage(boolean z16) {
        y0.r().edit().putBoolean("enableDebugPackage", z16).commit();
    }

    public void setEnableLocalDebug(boolean z16) {
        y0.r().edit().putBoolean("bEnableLocalDebug", z16).commit();
    }

    public void setEnableNewDebugPage(boolean z16) {
        y0.r().edit().putBoolean("enableNewDebugPage", z16).commit();
    }

    public void setEnableRemoteDebug(boolean z16) {
        y0.r().edit().putBoolean("bEnableRemoteDebug", z16).commit();
    }

    public void setEnableShowFps(boolean z16) {
        y0.r().edit().putBoolean("bShowFps", z16).commit();
    }

    public void setEnableShowSavePage(boolean z16) {
        y0.r().edit().putBoolean("bShowSavePage", z16).commit();
    }

    public void setEnableShowVersion(boolean z16) {
        y0.r().edit().putBoolean("bShowVersion", z16).commit();
    }

    public void setEnableTestBaseConfig(boolean z16) {
        if (z16) {
            z0.d("https://dldir1v6.qq.com/weixin/android/wxweb/updateConfig_test.xml");
            b();
            a();
        } else {
            z0.d("");
            b();
            a();
        }
    }

    public String setForceUseOfficeReader(String[] strArr, FileReaderHelper.UseOfficeReader useOfficeReader) {
        SharedPreferences r16;
        SharedPreferences.Editor edit;
        if (strArr == null || strArr.length == 0 || (r16 = y0.r()) == null || (edit = r16.edit()) == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : strArr) {
            for (String str2 : FileReaderHelper.OFFICE_READER_FORMATS) {
                if (str2.equalsIgnoreCase(str)) {
                    edit.putString("force_use_office_reader_" + str.toLowerCase(), useOfficeReader.toString());
                    sb5.append(str2);
                    sb5.append(",");
                }
            }
        }
        if (edit.commit()) {
            return sb5.toString();
        }
        return "";
    }

    public void setHardCodeWebViewKind(String str, WebView.WebViewKind webViewKind) {
        if (this.f384980a != null && str != null && !str.isEmpty()) {
            x0.d("WebDebugCfg", "setHardCodeWebViewKind, module:" + str + ", kind:" + webViewKind.toString());
            if (webViewKind == WebView.WebViewKind.WV_KIND_NONE) {
                y0.r().edit().remove("HardCodeWebView" + str).commit();
                return;
            }
            y0.r().edit().putString("HardCodeWebView" + str, webViewKind.toString()).commit();
        }
    }

    public void setIgnoreCrashWatch(boolean z16) {
        y0.r().edit().putBoolean("bIgnoreCrashWatch", z16).commit();
    }

    public void setPinusDebugMode(boolean z16, boolean z17, Context context) {
        if (!z17) {
            if (z16) {
                this.f384982c = true;
                this.f384983d = true;
                return;
            } else {
                this.f384982c = true;
                this.f384983d = false;
                return;
            }
        }
        if (!XWebEmbedSetting.getForbidDownloadCode()) {
            new q().a(context, true);
        }
        e0.b(context);
    }

    public void setRemoteDebugStarted(boolean z16) {
        y0.r().edit().putBoolean("bRemoteDebugStarted", z16).commit();
    }

    public void setRemoteDebugToken(String str) {
        if (str == null) {
            y0.r().edit().remove("bRemoteDebugToken").commit();
        } else {
            y0.r().edit().putString("bRemoteDebugToken", str).commit();
        }
    }

    public void setWebViewModeForMM(int i3) {
        if (i3 >= 0 && i3 < XWebSdk.WebViewModeForMM.values().length) {
            XWebSdk.WebViewModeForMM webViewModeForMM = XWebSdk.WebViewModeForMM.values()[i3];
            x0.f("WebDebugCfg", "setWebViewModeForMM, set mm webview mode:" + webViewModeForMM);
            if (webViewModeForMM != null) {
                y0.r().edit().putInt("WebViewModeForMM", webViewModeForMM.ordinal()).commit();
                return;
            }
            return;
        }
        x0.f("WebDebugCfg", "setWebViewModeForMM, clear mm webview mode");
        y0.r().edit().remove("WebViewModeForMM").commit();
    }
}
