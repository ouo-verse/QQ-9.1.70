package com.tencent.ark;

import android.text.TextUtils;
import com.tencent.ark.ark;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ArkAppPreloader {
    public static final int PRELOAD_DESTROY_RELOAD = 2;
    public static final int PRELOAD_START_UP = 1;
    private static final String TAG = "ArkApp.ArkAppPreloader";
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static HashMap<String, PreloadAppInfo> sPreLoadApplications = new HashMap<>(8);
    private static boolean sArkCommonInit = false;

    /* loaded from: classes3.dex */
    public interface PreloadAppCallback {
        void beginAppload(String str, int i3);

        void onAppLoaded(boolean z16, String str, int i3);

        void onReleaseAndReload(String str, String str2, int i3);
    }

    /* loaded from: classes3.dex */
    public static class PreloadAppInfo {
        public String appName;
        public String appPath;
        public ark.Application application;
        public String bizSrc;
        public String cachePath;
        public WeakReference<PreloadAppCallback> callbackRef;
        public String resPath;
        public String storagePath;
    }

    public static boolean isAppPreloaded(String str) {
        boolean containsKey;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (sPreLoadApplications) {
            containsKey = sPreLoadApplications.containsKey(str);
        }
        return containsKey;
    }

    public static void preloadApp(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, PreloadAppCallback preloadAppCallback, final int i3) {
        if (str == null) {
            Logger.logE(TAG, "profiling.preloadApp failed for appname is null");
            return;
        }
        final WeakReference weakReference = new WeakReference(preloadAppCallback);
        try {
            ArkDispatchQueue.asyncRun(str, new Runnable() { // from class: com.tencent.ark.ArkAppPreloader.1
                @Override // java.lang.Runnable
                public void run() {
                    PreloadAppCallback preloadAppCallback2;
                    boolean containsKey;
                    WeakReference weakReference2 = weakReference;
                    if (weakReference2 != null) {
                        preloadAppCallback2 = (PreloadAppCallback) weakReference2.get();
                    } else {
                        preloadAppCallback2 = null;
                    }
                    if (preloadAppCallback2 != null) {
                        preloadAppCallback2.beginAppload(str, i3);
                    }
                    synchronized (ArkAppPreloader.sPreLoadApplications) {
                        containsKey = ArkAppPreloader.sPreLoadApplications.containsKey(str);
                    }
                    if (containsKey) {
                        Logger.logE(ArkAppPreloader.TAG, String.format("profiling.preloadApp allready preload appName=%s", str));
                        if (preloadAppCallback2 != null) {
                            preloadAppCallback2.onAppLoaded(true, str, i3);
                            return;
                        }
                        return;
                    }
                    String str7 = str;
                    String str8 = str2;
                    if (str8 == null) {
                        str8 = "";
                    }
                    ark.Application Create = ark.Application.Create(str7, str8, str3);
                    if (Create == null) {
                        if (preloadAppCallback2 != null) {
                            preloadAppCallback2.onAppLoaded(false, str, i3);
                        }
                        Logger.logE(ArkAppPreloader.TAG, String.format("profiling.preloadApp failed!appName=%s,path=%s", str, str3));
                        return;
                    }
                    PreloadAppInfo preloadAppInfo = new PreloadAppInfo();
                    preloadAppInfo.application = Create;
                    preloadAppInfo.appName = str;
                    preloadAppInfo.bizSrc = str2;
                    preloadAppInfo.appPath = str3;
                    preloadAppInfo.storagePath = str4;
                    preloadAppInfo.cachePath = str6;
                    preloadAppInfo.resPath = str5;
                    preloadAppInfo.callbackRef = new WeakReference<>(preloadAppCallback2);
                    synchronized (ArkAppPreloader.sPreLoadApplications) {
                        if (!ArkAppPreloader.sPreLoadApplications.containsKey(str)) {
                            ArkAppPreloader.sPreLoadApplications.put(str, preloadAppInfo);
                        }
                    }
                    Logger.logI(ArkAppPreloader.TAG, String.format("profiling.preloadApp load application, appName=%s,path=%s,application=%h", str, str3, Create));
                    if (!Create.Load(str4, str5, str6)) {
                        Logger.logE(ArkAppPreloader.TAG, String.format("profiling.preloadApp load application failed!appName=%s,path=%s,application=%h", str, str3, Create));
                        Create.Release();
                        if (preloadAppCallback2 != null) {
                            preloadAppCallback2.onAppLoaded(false, str, i3);
                        }
                        synchronized (ArkAppPreloader.sPreLoadApplications) {
                            ArkAppPreloader.sPreLoadApplications.remove(str);
                        }
                        return;
                    }
                    if (preloadAppCallback2 != null) {
                        preloadAppCallback2.onAppLoaded(true, str, i3);
                    }
                    Logger.logI(ArkAppPreloader.TAG, String.format("profiling.preloadApp load application success! appName=%s,path=%s,application=%h", str, str3, Create));
                }
            });
        } catch (UnsatisfiedLinkError e16) {
            Logger.logE(TAG, String.format("profiling.preloadApp, exception=%s", e16.getMessage()));
        }
    }

    public static void preloadCommon(float f16, String str, String str2) {
        try {
            if (!sArkCommonInit) {
                ark.arkHTTPStartup();
                ark.arkSetPixelScale(f16);
                ark.arkSetStoragePath(str, str2);
                ark.arkHTTPSetDownloadDirectory(str2);
                ArkViewModelBase.setArkHttpProxy();
                Logger.logI(TAG, String.format("profiling.preloadCommon storagePath=%s.cachePath=%s", str, str2));
                sArkCommonInit = true;
            }
        } catch (UnsatisfiedLinkError e16) {
            Logger.logE(TAG, String.format("profiling.preloadCommon, exception=%s", e16.getMessage()));
        }
    }

    public static void releasePreloadApplicationAndReload(String str) {
        PreloadAppCallback preloadAppCallback;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (sPreLoadApplications) {
            PreloadAppInfo preloadAppInfo = sPreLoadApplications.get(str);
            Logger.logI(TAG, String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing preloadApp:%s", str));
            ark.Application application = null;
            PreloadAppCallback preloadAppCallback2 = null;
            if (preloadAppInfo != null) {
                str2 = preloadAppInfo.appName;
                str3 = preloadAppInfo.bizSrc;
                str4 = preloadAppInfo.appPath;
                str5 = preloadAppInfo.storagePath;
                str6 = preloadAppInfo.resPath;
                str7 = preloadAppInfo.cachePath;
                WeakReference<PreloadAppCallback> weakReference = preloadAppInfo.callbackRef;
                if (weakReference != null) {
                    preloadAppCallback2 = weakReference.get();
                }
                PreloadAppCallback preloadAppCallback3 = preloadAppCallback2;
                application = preloadAppInfo.application;
                preloadAppCallback = preloadAppCallback3;
            } else {
                preloadAppCallback = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            if (application != null) {
                Logger.logD(TAG, String.format("profiling.releasePreloadApplicationAndReload.delay 5s releasing.preloadApp.application=%h", application));
                application.Release();
                sPreLoadApplications.remove(str);
            }
        }
        Logger.logD(TAG, String.format("profiling.releasePreloadApplicationAndReload.delay 5s preloadApp.appName=%s,bizSrc=%s,path=%s,storagePath=%s,resPath=%s,cachePath=%s,cb=%h", str2, str3, str4, str5, str6, str7, preloadAppCallback));
        if (!TextUtils.isEmpty(str2) && preloadAppCallback != null) {
            Logger.logD(TAG, String.format("profiling.releasePreloadApplicationAndReload.delay 5s.begin.preload.App=%s", str2));
            preloadAppCallback.onReleaseAndReload(str2, str3, 2);
        }
    }

    public static void setEmojiFontBasePath(String str) {
        ark.SetEmojiBasePath(str);
    }
}
