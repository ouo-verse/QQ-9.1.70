package com.tencent.mobileqq.timiqqid.helper;

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
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f293197c;

    /* renamed from: a, reason: collision with root package name */
    private ValueCallback<Uri> f293198a;

    /* renamed from: b, reason: collision with root package name */
    private ValueCallback<Uri[]> f293199b;

    a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f293197c == null) {
                f293197c = new a();
            }
            aVar = f293197c;
        }
        return aVar;
    }

    private static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return "NETWORK_WIFI";
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (NetworkMonitor.getSubtype(activeNetworkInfo)) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "NETWORK_2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "NETWORK_3G";
                        case 13:
                            return "NETWORK_4G";
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return "NETWORK_3G";
                            }
                            return "NETWORK_MOBILE";
                    }
                }
            }
        }
        return "NETWORK_NONE";
    }

    private void c(Activity activity) {
        try {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("android.intent.extra.videoQuality", 1);
            intent.addFlags(1);
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            activity.startActivityForResult(intent, 17);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void g(ValueCallback<Uri[]> valueCallback) {
        this.f293199b = valueCallback;
    }

    private void h(ValueCallback<Uri> valueCallback) {
        this.f293198a = valueCallback;
    }

    @TargetApi(21)
    public boolean d(WebView webView, ValueCallback<Uri[]> valueCallback, Activity activity, WebChromeClient.FileChooserParams fileChooserParams) {
        Log.d("faceVerify", "accept is " + fileChooserParams.getAcceptTypes()[0] + "---url---" + webView.getUrl());
        if (!webView.getUrl().startsWith("https://miniprogram-kyc.tencentcloudapi.com") && !webView.getUrl().startsWith("https://ida.webank.com")) {
            return false;
        }
        g(valueCallback);
        c(activity);
        return true;
    }

    public boolean e(ValueCallback<Uri> valueCallback, String str, Activity activity) {
        if ("video/webank".equals(str)) {
            h(valueCallback);
            c(activity);
            return true;
        }
        return false;
    }

    public void f(WebView webView, Context context) {
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
            settings.setUserAgentString(userAgentString + ";webank/h5face;webank/1.0;netType:" + b(context) + ";appVersion:" + InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode + ";packageName:" + context.getPackageName());
        } catch (PackageManager.NameNotFoundException e16) {
            settings.setUserAgentString(userAgentString + ";webank/h5face;webank/1.0");
            e16.printStackTrace();
        }
    }
}
