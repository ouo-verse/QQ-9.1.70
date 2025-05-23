package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.TGDeviceInfo;
import com.qq.e.comm.net.ZipCompress;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.pi.CustomLandingPageListener;
import com.qq.e.comm.pi.CustomWXLuggageListener;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.qq.e.comm.pi.ProgressCallBack;
import com.qq.e.comm.pi.SplashCustomSettingListener;
import com.qq.e.comm.pi.TangramAuthorizeListener;
import com.qq.e.comm.pi.WXLuggageListener;
import com.qq.e.comm.pi.WebViewShareListener;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SystemUtil;
import com.qq.e.tg.download.interfaces.APKDownloadListener;
import com.qq.e.tg.splash.SplashDownloadRes;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StubVisitor {

    /* renamed from: a, reason: collision with root package name */
    private static volatile StubVisitor f38089a;

    StubVisitor() {
    }

    private static void a(String str) {
        if (GDTLogger.isEnableConsoleLog()) {
            Log.d("tg_ad_mob", str);
        }
    }

    public static StubVisitor getInstance() {
        if (f38089a == null) {
            synchronized (StubVisitor.class) {
                if (f38089a == null) {
                    f38089a = new StubVisitor();
                }
            }
        }
        return f38089a;
    }

    public String appendPathName(String str) {
        return SystemUtil.buildNewPathByProcessName(str);
    }

    public byte[] compressByGzip(byte[] bArr) {
        return ZipCompress.compressByGzip(bArr);
    }

    public byte[] decompressByGzip(byte[] bArr) {
        return ZipCompress.decompressByGzip(bArr);
    }

    public AppDownloadCallback getAppDownloadCallback() {
        return GlobalSetting.getAppDownloadCallback();
    }

    public TangramAuthorizeListener getAuthorizeListener() {
        return GlobalSetting.getAuthorizeListener();
    }

    public APKDownloadListener getCustomAPKDownloadListener() {
        return GlobalSetting.getCustomAPKDownloadListener();
    }

    public Bundle getCustomBundle() {
        return GlobalSetting.getCustomBundle();
    }

    public String getCustomFileProviderClassName() {
        return GlobalSetting.getCustomFileProviderClassName();
    }

    public CustomWXLuggageListener getCustomWXLuggageListener() {
        return GlobalSetting.getCustomWXLuggageListener();
    }

    public TGDeviceInfo getDeviceInfoFromFlow() {
        return GlobalSetting.getTGDeviceInfo();
    }

    public int getLandingPageShareOptions() {
        return GlobalSetting.getLandingPageShareOptions();
    }

    public WXLuggageListener getWXLuggageListener() {
        return GlobalSetting.getWxLuggageListener();
    }

    public boolean isEnableConsoleLog() {
        return GDTLogger.isEnableConsoleLog();
    }

    public boolean isIsCurrentPageAllowAutoInstall() {
        return GlobalSetting.isIsCurrentPageAllowAutoInstall();
    }

    public boolean isSupportCustomRequestAdData() {
        if (GlobalSetting.getiCustomAdDataGenerator() != null) {
            return true;
        }
        return false;
    }

    public boolean jumpToActivityAndRegisterCallback(Context context, Intent intent) {
        CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
        a("jumpToActivityWithDelayLandingPage, customLandingPageListener = " + customLandingPageListener);
        if (customLandingPageListener != null) {
            boolean jumpToActivityAndRegisterCallback = customLandingPageListener.jumpToActivityAndRegisterCallback(context, intent);
            a("jumpToActivityWithDelayLandingPage, success = " + jumpToActivityAndRegisterCallback);
            return jumpToActivityAndRegisterCallback;
        }
        return false;
    }

    public boolean jumpToCustomLandingPage(CustomLandingPageListener.Params params) {
        CustomLandingPageListener customLandingPageListener = GlobalSetting.getCustomLandingPageListener();
        a("jumpToCustomLandingPage, customLandingPageListener = " + customLandingPageListener);
        if (customLandingPageListener != null) {
            boolean jumpToCustomLandingPage = customLandingPageListener.jumpToCustomLandingPage(params);
            a("jumpToCustomLandingPage, success = " + jumpToCustomLandingPage);
            return jumpToCustomLandingPage;
        }
        return false;
    }

    public boolean loadCustomAdData(String str, Map<String, String> map, ICustomAdDataGenerator.LoadADCallback loadADCallback) {
        if (isSupportCustomRequestAdData()) {
            return GlobalSetting.getiCustomAdDataGenerator().loadAD(str, map, loadADCallback);
        }
        return false;
    }

    public void onDataUsed(Map<Integer, String> map) {
        if (map != null && map.size() != 0 && GlobalSetting.getTangramDataUseNotification() == null) {
            a("dataUseNotification is null");
        }
    }

    public void onWebViewShare(int i3, String str, String str2, String str3, String str4) {
        WebViewShareListener webViewShareListener = GlobalSetting.getWebViewShareListener();
        if (webViewShareListener != null) {
            webViewShareListener.onWebViewShare(i3, str, str2, str3, str4);
        }
    }

    public void preRequestDNS() {
        GDTADManager.getInstance().preRequestDNS();
    }

    public void setIsCurrentPageAllowAutoInstall(boolean z16) {
        GlobalSetting.setIsCurrentPageAllowAutoInstall(z16);
    }

    public boolean setSplashCustomDownloaderListener(List<SplashDownloadRes> list) {
        SplashCustomSettingListener splashCustomSettingListener = GlobalSetting.getSplashCustomSettingListener();
        if (splashCustomSettingListener != null) {
            return splashCustomSettingListener.setCustomDownloaderListener(list);
        }
        return false;
    }

    public void unZipFolder(String str, String str2) throws Exception {
        ZipCompress.unZipFolder(str, str2);
    }

    public void updateVideoLoadingProgress(ProgressCallBack progressCallBack, int i3) {
        if (progressCallBack != null) {
            progressCallBack.updateVideoProgress(i3);
        }
    }
}
