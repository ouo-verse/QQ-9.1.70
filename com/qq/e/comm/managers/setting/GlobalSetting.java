package com.qq.e.comm.managers.setting;

import android.os.Bundle;
import com.qq.e.comm.managers.status.DeviceInfoSetting;
import com.qq.e.comm.managers.status.TGDeviceInfo;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.pi.CustomWXLuggageListener;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.ILandingPageReportListener;
import com.qq.e.comm.pi.ITGChangeBackgroundStatusManager;
import com.qq.e.comm.pi.ITangramApkInstaller;
import com.qq.e.comm.pi.SplashCustomSettingListener;
import com.qq.e.comm.pi.TGTQUICADLoader;
import com.qq.e.comm.pi.TangramAdLogger;
import com.qq.e.comm.pi.TangramAuthorizeListener;
import com.qq.e.comm.pi.TangramDataUseNotification;
import com.qq.e.comm.pi.WXLuggageListener;
import com.qq.e.comm.pi.WebViewShareListener;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SystemUtil;
import com.qq.e.tg.download.interfaces.APKDownloadListener;
import dalvik.system.BaseDexClassLoader;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class GlobalSetting {
    private static volatile APKDownloadListener A = null;
    private static volatile ITangramApkInstaller B = null;
    private static volatile ILandingPageReportListener C = null;
    private static volatile Bundle D = null;

    /* renamed from: a, reason: collision with root package name */
    private static volatile WeakReference<CustomLandingPageListener> f38184a = null;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Integer f38185b = null;

    /* renamed from: c, reason: collision with root package name */
    private static volatile TGDeviceInfo f38186c = null;

    /* renamed from: d, reason: collision with root package name */
    private static volatile DeviceInfoSetting f38187d = null;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f38188e = true;

    /* renamed from: f, reason: collision with root package name */
    private static volatile AppDownloadCallback f38189f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile BaseDexClassLoader f38190g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f38191h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile WeakReference<ITGChangeBackgroundStatusManager> f38192i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile SplashCustomSettingListener f38193j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile ICustomAdDataGenerator f38194k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile WeakReference<TGTQUICADLoader> f38195l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile String f38196m;

    /* renamed from: n, reason: collision with root package name */
    private static volatile String f38197n;

    /* renamed from: o, reason: collision with root package name */
    private static volatile TangramAdLogger f38198o;

    /* renamed from: p, reason: collision with root package name */
    private static volatile String f38199p;

    /* renamed from: q, reason: collision with root package name */
    private static volatile String f38200q;

    /* renamed from: r, reason: collision with root package name */
    private static volatile String f38201r;

    /* renamed from: s, reason: collision with root package name */
    private static volatile String f38202s;

    /* renamed from: t, reason: collision with root package name */
    private static String f38203t;

    /* renamed from: u, reason: collision with root package name */
    private static volatile int f38204u;

    /* renamed from: v, reason: collision with root package name */
    private static volatile WebViewShareListener f38205v;

    /* renamed from: w, reason: collision with root package name */
    private static volatile WXLuggageListener f38206w;

    /* renamed from: x, reason: collision with root package name */
    private static volatile CustomWXLuggageListener f38207x;

    /* renamed from: y, reason: collision with root package name */
    private static volatile TangramDataUseNotification f38208y;

    /* renamed from: z, reason: collision with root package name */
    private static volatile TangramAuthorizeListener f38209z;

    public static AppDownloadCallback getAppDownloadCallback() {
        return f38189f;
    }

    public static TangramAuthorizeListener getAuthorizeListener() {
        return f38209z;
    }

    public static Integer getChannel() {
        return f38185b;
    }

    public static String getCustomADActivityClassName() {
        return f38196m;
    }

    public static APKDownloadListener getCustomAPKDownloadListener() {
        return A;
    }

    public static Bundle getCustomBundle() {
        return D;
    }

    public static String getCustomFileProviderClassName() {
        return f38203t;
    }

    public static CustomLandingPageListener getCustomLandingPageListener() {
        WeakReference<CustomLandingPageListener> weakReference = f38184a;
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        return null;
    }

    public static String getCustomLandscapeActivityClassName() {
        return f38200q;
    }

    public static String getCustomPortraitActivityClassName() {
        return f38197n;
    }

    public static String getCustomRewardvideoLandscapeActivityClassName() {
        return f38202s;
    }

    public static String getCustomRewardvideoPortraitActivityClassName() {
        return f38199p;
    }

    public static String getCustomTransPortraitActivityClassName() {
        return f38201r;
    }

    public static CustomWXLuggageListener getCustomWXLuggageListener() {
        return f38207x;
    }

    public static DeviceInfoSetting getDeviceInfoSetting() {
        return f38187d;
    }

    public static ILandingPageReportListener getLandingPageReportListener() {
        return C;
    }

    public static int getLandingPageShareOptions() {
        return f38204u;
    }

    public static BaseDexClassLoader getOutDexClassLoader() {
        return f38190g;
    }

    public static SplashCustomSettingListener getSplashCustomSettingListener() {
        return f38193j;
    }

    public static WeakReference<ITGChangeBackgroundStatusManager> getTGChangeBackgroundStatusListener() {
        return f38192i;
    }

    public static TGDeviceInfo getTGDeviceInfo() {
        return f38186c;
    }

    public static WeakReference<TGTQUICADLoader> getTQUICLoader() {
        return f38195l;
    }

    public static TangramAdLogger getTangramAdLogger() {
        return f38198o;
    }

    public static ITangramApkInstaller getTangramApkInstaller() {
        return B;
    }

    public static TangramDataUseNotification getTangramDataUseNotification() {
        return f38208y;
    }

    public static WebViewShareListener getWebViewShareListener() {
        return f38205v;
    }

    public static WXLuggageListener getWxLuggageListener() {
        return f38206w;
    }

    public static ICustomAdDataGenerator getiCustomAdDataGenerator() {
        return f38194k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return f38188e;
    }

    public static boolean isIsCurrentPageAllowAutoInstall() {
        return f38191h;
    }

    public static void registerTangramAPKDownloadListener(APKDownloadListener aPKDownloadListener) {
        A = aPKDownloadListener;
    }

    public static void releaseCustomAdDataGenerator() {
        f38194k = null;
    }

    public static void setAgreePrivacyStrategy(boolean z16) {
        f38188e = z16;
    }

    public static void setAppDownloadCallback(AppDownloadCallback appDownloadCallback) {
        f38189f = appDownloadCallback;
    }

    public static void setAuthorizeListener(TangramAuthorizeListener tangramAuthorizeListener) {
        f38209z = tangramAuthorizeListener;
    }

    public static void setChannel(int i3) {
        if (f38185b == null) {
            f38185b = Integer.valueOf(i3);
        }
    }

    public static void setCustomADActivityClassName(String str) {
        f38196m = str;
    }

    public static void setCustomBundle(Bundle bundle) {
        D = bundle;
    }

    public static void setCustomFileProviderClassName(String str) {
        f38203t = str;
    }

    public static void setCustomLandingPageListener(WeakReference<CustomLandingPageListener> weakReference) {
        f38184a = weakReference;
    }

    public static void setCustomLandscapeActivityClassName(String str) {
        f38200q = str;
    }

    public static void setCustomPortraitActivityClassName(String str) {
        f38197n = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(String str) {
        f38202s = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(String str) {
        f38199p = str;
    }

    public static void setCustomTransPortraitActivityClassName(String str) {
        f38201r = str;
    }

    public static void setCustomWXLuggageListener(CustomWXLuggageListener customWXLuggageListener) {
        f38207x = customWXLuggageListener;
    }

    public static void setDeviceInfoSetting(DeviceInfoSetting deviceInfoSetting) {
        f38187d = deviceInfoSetting;
    }

    public static void setIsCurrentPageAllowAutoInstall(boolean z16) {
        f38191h = z16;
    }

    public static void setLandingPageReportListener(ILandingPageReportListener iLandingPageReportListener) {
        C = iLandingPageReportListener;
    }

    public static void setOutDexClassLoader(BaseDexClassLoader baseDexClassLoader) {
        f38190g = baseDexClassLoader;
    }

    public static void setProcessName(String str) {
        SystemUtil.setProcessName(str);
    }

    public static void setSplashCustomSettingListener(SplashCustomSettingListener splashCustomSettingListener) {
        f38193j = splashCustomSettingListener;
    }

    public static void setTGChangeBackgroundStatusListener(WeakReference<ITGChangeBackgroundStatusManager> weakReference) {
        GDTLogger.d("GlobalSetting setTGChangeBackgroundStatusListener, listener = " + weakReference);
        f38192i = weakReference;
    }

    @Deprecated
    public static void setTGDeviceInfo(TGDeviceInfo tGDeviceInfo) {
        f38186c = tGDeviceInfo;
        if (tGDeviceInfo != null) {
            com.qq.e.comm.a.a(tGDeviceInfo.toString());
        }
    }

    public static void setTQUICLoader(WeakReference<TGTQUICADLoader> weakReference) {
        f38195l = weakReference;
    }

    public static void setTangramAdLogger(TangramAdLogger tangramAdLogger) {
        f38198o = tangramAdLogger;
    }

    public static void setTangramApkInstaller(ITangramApkInstaller iTangramApkInstaller) {
        B = iTangramApkInstaller;
    }

    public static void setTangramDataUseNotification(TangramDataUseNotification tangramDataUseNotification) {
        f38208y = tangramDataUseNotification;
    }

    public static void setWebViewShareListener(int i3, WebViewShareListener webViewShareListener) {
        f38205v = webViewShareListener;
        f38204u = i3;
    }

    public static void setWxLuggageListener(WXLuggageListener wXLuggageListener) {
        f38206w = wXLuggageListener;
    }

    public static void setiCustomAdDataGenerator(ICustomAdDataGenerator iCustomAdDataGenerator) {
        f38194k = iCustomAdDataGenerator;
    }

    public static void unregisterTangramAPKDownloadListener() {
        A = null;
    }
}
