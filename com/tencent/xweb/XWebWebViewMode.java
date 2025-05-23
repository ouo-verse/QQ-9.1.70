package com.tencent.xweb;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.xweb.XWebSdk;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebWebViewMode {
    public static final String SP_KEY_WEBVIEW_MODE_FOR_MM = "SP_KEY_WEBVIEW_MODE_FOR_MM";
    public static final String TAG = "XWebWebViewMode";

    /* renamed from: a, reason: collision with root package name */
    public static XWebSdk.WebViewModeForMM f385101a;

    public static synchronized void a(String str, int i3) {
        SharedPreferences m3;
        synchronized (XWebWebViewMode.class) {
            if (XWalkEnvironment.getPackageName().equalsIgnoreCase(XWalkEnvironment.getProcessName()) && (m3 = y0.m()) != null) {
                x0.d(TAG, "saveWebViewModeIfNeed, key:" + str + ", value:" + i3);
                m3.edit().putInt(str, i3).apply();
            }
        }
    }

    public static XWebSdk.WebViewModeForMM getWebViewModeCommandForMM() {
        if (f385101a != null) {
            x0.d(TAG, "getWebViewModeCommandForMM, already init mode:" + f385101a);
            return f385101a;
        }
        SharedPreferences m3 = y0.m();
        if (m3 != null && m3.contains(SP_KEY_WEBVIEW_MODE_FOR_MM)) {
            f385101a = XWebSdk.WebViewModeForMM.values()[m3.getInt(SP_KEY_WEBVIEW_MODE_FOR_MM, CommandCfg.getInstance().getMMWebViewDowngradeMode())];
            x0.d(TAG, "getWebViewModeCommandForMM, already checked in mm process:" + f385101a);
            return f385101a;
        }
        int mMWebViewDowngradeMode = CommandCfg.getInstance().getMMWebViewDowngradeMode();
        f385101a = XWebSdk.WebViewModeForMM.values()[mMWebViewDowngradeMode];
        x0.d(TAG, "getWebViewModeCommandForMM, downgrade mode:" + mMWebViewDowngradeMode);
        if (!XWebSdk.supportMultiProcess(XWalkEnvironment.getApplicationContext())) {
            x0.d(TAG, "getWebViewModeCommandForMM, disable for core version is low");
            a(SP_KEY_WEBVIEW_MODE_FOR_MM, f385101a.ordinal());
            return f385101a;
        }
        if (XWebChildProcessMonitor.checkDisableMultiProcess()) {
            x0.d(TAG, "getWebViewModeCommandForMM, disable for child process crash");
            a(SP_KEY_WEBVIEW_MODE_FOR_MM, f385101a.ordinal());
            return f385101a;
        }
        int webViewModeForMM = WebDebugCfg.getInst().getWebViewModeForMM();
        x0.d(TAG, "getWebViewModeCommandForMM, debug mode:" + webViewModeForMM);
        if (webViewModeForMM < 0) {
            webViewModeForMM = CommandCfg.getInstance().getWebViewModeCommandForMM();
        }
        if (webViewModeForMM >= XWebSdk.WebViewModeForMM.NOT_IN_MM.ordinal() && webViewModeForMM < XWebSdk.WebViewModeForMM.values().length) {
            f385101a = XWebSdk.WebViewModeForMM.values()[webViewModeForMM];
        }
        x0.d(TAG, "getWebViewModeCommandForMM, value:" + webViewModeForMM);
        a(SP_KEY_WEBVIEW_MODE_FOR_MM, f385101a.ordinal());
        return f385101a;
    }

    public static synchronized void init() {
        synchronized (XWebWebViewMode.class) {
            SharedPreferences m3 = y0.m();
            if (m3 != null && p0.a()) {
                x0.d(TAG, "init, remove webview mode");
                m3.edit().remove(SP_KEY_WEBVIEW_MODE_FOR_MM).apply();
            }
        }
    }
}
