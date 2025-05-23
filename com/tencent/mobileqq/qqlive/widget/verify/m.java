package com.tencent.mobileqq.qqlive.widget.verify;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.webkit.ValueCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;

/* compiled from: P */
/* loaded from: classes17.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static m f274088c;

    /* renamed from: a, reason: collision with root package name */
    private ValueCallback<Uri> f274089a;

    /* renamed from: b, reason: collision with root package name */
    private ValueCallback<Uri[]> f274090b;

    m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean a(NetworkInfo.State state) {
        if (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING) {
            return false;
        }
        return true;
    }

    private static String b(NetworkInfo networkInfo, NetworkInfo.State state, String str) {
        if (state == null || !a(state)) {
            return "NETWORK_NONE";
        }
        if (e(networkInfo)) {
            return "NETWORK_2G";
        }
        if (f(networkInfo)) {
            return "NETWORK_3G";
        }
        if (g(networkInfo)) {
            return "NETWORK_4G";
        }
        if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) {
            return "NETWORK_3G";
        }
        return "NETWORK_MOBILE";
    }

    public static synchronized m c() {
        m mVar;
        synchronized (m.class) {
            if (f274088c == null) {
                f274088c = new m();
            }
            mVar = f274088c;
        }
        return mVar;
    }

    private static String d(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return "NETWORK_NONE";
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "NETWORK_WIFI";
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 == null) {
            return "NETWORK_NONE";
        }
        return b(activeNetworkInfo, networkInfo2.getState(), networkInfo2.getSubtypeName());
    }

    private static boolean e(NetworkInfo networkInfo) {
        if (NetworkMonitor.getSubtype(networkInfo) == 1 || NetworkMonitor.getSubtype(networkInfo) == 4 || NetworkMonitor.getSubtype(networkInfo) == 2 || NetworkMonitor.getSubtype(networkInfo) == 7 || NetworkMonitor.getSubtype(networkInfo) == 11) {
            return true;
        }
        return false;
    }

    private static boolean f(NetworkInfo networkInfo) {
        if (NetworkMonitor.getSubtype(networkInfo) != 6 && NetworkMonitor.getSubtype(networkInfo) != 3 && NetworkMonitor.getSubtype(networkInfo) != 5 && NetworkMonitor.getSubtype(networkInfo) != 8 && NetworkMonitor.getSubtype(networkInfo) != 9 && NetworkMonitor.getSubtype(networkInfo) != 10 && NetworkMonitor.getSubtype(networkInfo) != 12 && NetworkMonitor.getSubtype(networkInfo) != 14 && NetworkMonitor.getSubtype(networkInfo) != 15) {
            return false;
        }
        return true;
    }

    private static boolean g(NetworkInfo networkInfo) {
        if (NetworkMonitor.getSubtype(networkInfo) == 13) {
            return true;
        }
        return false;
    }

    private void i(Activity activity) {
        try {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 1);
            intent.addFlags(1);
            intent.putExtra("big_brother_source_key", "biz_src_jc_qqlive");
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            activity.startActivityForResult(intent, 17);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void m(ValueCallback<Uri[]> valueCallback) {
        this.f274090b = valueCallback;
    }

    private void n(ValueCallback<Uri> valueCallback) {
        this.f274089a = valueCallback;
    }

    public boolean h(int i3, int i16, Intent intent) {
        Uri uri;
        Uri[] uriArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent)).booleanValue();
        }
        if (i3 != 17) {
            return false;
        }
        if (this.f274089a == null && this.f274090b == null) {
            return true;
        }
        if (intent != null && i16 == -1) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        if (uri == null) {
            uriArr = null;
        } else {
            uriArr = new Uri[]{uri};
        }
        ValueCallback<Uri[]> valueCallback = this.f274090b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(uriArr);
            m(null);
        } else {
            this.f274089a.onReceiveValue(uri);
            n(null);
        }
        return true;
    }

    @TargetApi(21)
    public boolean j(WebView webView, ValueCallback<Uri[]> valueCallback, Activity activity, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, webView, valueCallback, activity, fileChooserParams)).booleanValue();
        }
        Log.d("faceVerify", "accept is " + fileChooserParams.getAcceptTypes()[0] + "---url---" + webView.getUrl());
        if (!"video/webank".equals(fileChooserParams.getAcceptTypes()[0]) && !webView.getUrl().startsWith("https://ida.webank.com/")) {
            return false;
        }
        m(valueCallback);
        i(activity);
        return true;
    }

    public boolean k(ValueCallback<Uri> valueCallback, String str, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, valueCallback, str, activity)).booleanValue();
        }
        if ("video/webank".equals(str)) {
            n(valueCallback);
            i(activity);
            return true;
        }
        return false;
    }

    public void l(WebView webView, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) context);
            return;
        }
        if (webView == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(false);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setAppCacheMaxSize(Long.MAX_VALUE);
        settings.setAppCachePath(context.getDir("appcache", 0).getPath());
        settings.setDatabasePath(context.getDir(QZoneAppCtrlUploadFileLogic.DATABASE_PATH, 0).getPath());
        settings.setGeolocationDatabasePath(context.getDir("geolocation", 0).getPath());
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        String userAgentString = settings.getUserAgentString();
        try {
            settings.setUserAgentString(userAgentString + ";webank/h5face;webank/1.0;netType:" + d(context) + ";appVersion:" + InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode + ";packageName:" + context.getPackageName());
        } catch (PackageManager.NameNotFoundException e16) {
            settings.setUserAgentString(userAgentString + ";webank/h5face;webank/1.0");
            e16.printStackTrace();
        }
    }
}
