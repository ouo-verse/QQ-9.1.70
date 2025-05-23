package com.tencent.xweb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.r0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.luggage.wxa.yq.i;
import com.tencent.luggage.wxa.yq.k;
import com.tencent.luggage.wxa.yq.m;
import com.tencent.luggage.wxa.yq.u;
import com.tencent.xweb.LibraryLoader;
import com.tencent.xweb.WebView;
import com.tencent.xweb.debug.XWebDebugActivity;
import com.tencent.xweb.downloader.IFileDownloaderProxy;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.location.XWebLocationProxy;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import com.tencent.xweb.updater.IXWebUpdateListener;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.WebViewExtensionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebSdk extends XWebSdkInternal {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum WebViewModeForMM {
        NOT_IN_MM,
        DISABLE_MULTI_PROCESS,
        RENDER_SANDBOX,
        RENDER_UNSANDBOX,
        GPU_RENDER_SANDBOX,
        GPU_RENDER_UNSANDBOX
    }

    public static void appendAppInfo(String str) {
        XWalkEnvironment.appendAppInfo(str);
    }

    public static void bindNativeTrans(long j3) {
        XWebSdkInternal.a(j3);
    }

    public static void checkConfigUpdate(Context context) {
        u.a(context);
    }

    public static void checkNeedDownload() {
        u.a();
    }

    public static void clearAllWebViewCache(boolean z16) {
        XWebSdkInternal.a(z16);
    }

    public static void enableAutoCheckUpdate(boolean z16) {
        i.a(z16);
    }

    public static void forceKillChildProcess() {
        if (g.a(ConstValue.INVOKE_RUNTIME_ID_FORCE_KILL_CHILD_PROCESS, (Object[]) null) == null) {
            forceKillRenderProcess();
            forceKillGpuProcess();
        }
    }

    public static void forceKillGpuProcess() {
        g.a(ConstValue.INVOKE_RUNTIME_ID_FORCE_KILL_GPU_PROCESS, (Object[]) null);
    }

    public static void forceKillRenderProcess() {
        g.a(ConstValue.INVOKE_RUNTIME_ID_FORCE_KILL_RENDER_PROCESS, (Object[]) null);
    }

    public static long getApplicationStartTime() {
        return XWebSdkInternal.getApplicationStartTime();
    }

    public static int getAvailableVersion() {
        return XWalkEnvironment.getAvailableVersion();
    }

    public static boolean getBuildConfigNeedTurnOffDynamicCode() {
        return XWalkEnvironment.getBuildConfigNeedTurnOffDynamicCode();
    }

    public static boolean getBuildConfigShouldEmbedXWebCore() {
        return XWalkEnvironment.getBuildConfigShouldEmbedXWebCore();
    }

    public static String getConfigValue(String str) {
        return CommandCfg.getInstance().getCmd(str);
    }

    public static boolean getConfigValueAsBoolean(String str, String str2, boolean z16) {
        return CommandCfg.getInstance().getCmdAsBoolean(str, str2, z16);
    }

    public static int getConfigValueAsInt(String str, String str2, int i3) {
        return CommandCfg.getInstance().getCmdAsInt(str, str2, i3);
    }

    public static String getCurrentVersionDir(Context context) {
        return u0.a(context);
    }

    public static boolean getDowngradeToSys() {
        return XWebChildProcessMonitor.getShouldSwitchToSys();
    }

    public static boolean getEnableRemoteDebug() {
        return XWebSdkInternal.getEnableRemoteDebugInternal();
    }

    public static boolean getEnableSandbox() {
        return XWalkEnvironment.getEnableSandbox();
    }

    public static Bundle getExtendConfigBundle() {
        return XWalkEnvironment.getExtendConfigBundle();
    }

    public static Bundle getInitConfigBundle() {
        return XWalkEnvironment.getInitConfigBundle();
    }

    public static int getInstalledNewstVersion(Context context) {
        return XWalkEnvironment.getInstalledNewstVersion(context);
    }

    public static int getMultiProcessType() {
        return XWalkEnvironment.getMultiProcessType();
    }

    public static String getNewestVersionDir(Context context) {
        return u0.b(context);
    }

    public static String getPluginConfigValue(String str) {
        return CommandCfgPlugin.getInstance().getCmd(str);
    }

    public static String getPredownloadVersionDir(Context context) {
        return u0.c(context);
    }

    public static int getRenderSandboxProcessMemory() {
        return XWebSdkInternal.a();
    }

    public static boolean getUsingCustomContext() {
        return XWalkEnvironment.getUsingCustomContext();
    }

    public static boolean getV8LiteMode() {
        return XWalkEnvironment.getV8LiteMode();
    }

    public static int getWebViewCount() {
        return WebViewCounter.getCount();
    }

    public static WebViewModeForMM getWebViewModeCommandForMM() {
        return XWebWebViewMode.getWebViewModeCommandForMM();
    }

    public static String getXWebConfigVersion() {
        return CommandCfg.getInstance().getConfigVersion();
    }

    public static int getXWebSdkVersion() {
        return XWalkEnvironment.SDK_VERSION;
    }

    public static boolean hasWebViewCoreInited() {
        return WebView.hasInited();
    }

    public static boolean hasXWebFeature(int i3) {
        return XWebSdkInternal.a(i3);
    }

    public static void initWebviewCore(Context context, WebView.WebViewKind webViewKind, String str, WebView.PreInitCallback preInitCallback) {
        WebView.initWebviewCore(context, webViewKind, str, preInitCallback);
    }

    public static void initWorkManager(Context context) {
        i.a(context);
    }

    public static synchronized void initXWebEnvironment(Context context, XWebEnvironmentConfig xWebEnvironmentConfig) {
        synchronized (XWebSdk.class) {
            XWebSdkInternal.a(context, xWebEnvironmentConfig);
        }
    }

    public static boolean isBusyUpdate() {
        return u.d();
    }

    public static boolean isCurrentSupportCustomContext() {
        return XWalkEnvironment.isCurrentSupportCustomContext();
    }

    public static boolean isCurrentVersionSupportAudioMuted() {
        return XWalkEnvironment.isCurrentVersionSupportAudioMuted();
    }

    public static boolean isCurrentVersionSupportCustomContext() {
        return XWalkEnvironment.isCurrentVersionSupportCustomContext();
    }

    public static boolean isCurrentVersionSupportCustomInputForAppbrand() {
        return XWalkEnvironment.isCurrentVersionSupportCustomInputForAppbrand();
    }

    public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand() {
        return XWalkEnvironment.isCurrentVersionSupportCustomTextAreaForAppbrand();
    }

    public static boolean isCurrentVersionSupportExtendPluginForAppbrand() {
        return XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand();
    }

    public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand() {
        return XWalkEnvironment.isCurrentVersionSupportMapExtendPluginForAppbrand();
    }

    public static boolean isCurrentVersionSupportNativeView() {
        return XWalkEnvironment.isCurrentVersionSupportNativeView();
    }

    public static boolean isCurrentVersionSupportProxyOverrideReverseBypass() {
        return XWalkEnvironment.isCurrentVersionSupportProxyOverrideReverseBypass();
    }

    public static boolean isCurrentVersionSupportSetProxyOverride() {
        return XWalkEnvironment.isCurrentVersionSupportSetProxyOverride();
    }

    public static boolean isSysWebView() {
        return WebView.isSys();
    }

    public static boolean isXWebApplicationContextReady() {
        if (XWalkEnvironment.getApplicationContext() != null) {
            return true;
        }
        return false;
    }

    public static boolean isXWebChildProcessCrashDumpFiles(File file) {
        return XWebCrashMonitor.isXWebChildProcessCrashDumpFiles(file);
    }

    public static boolean isXWebCoreInited() {
        return WebView.isXWebCoreInited();
    }

    public static boolean isXWebView() {
        return WebView.isXWeb();
    }

    public static boolean loadPackageFromFile(Context context, String str) {
        return XWebSdkInternal.a(context, str);
    }

    public static boolean needCheckUpdate(boolean z16) {
        return u.a(z16);
    }

    public static boolean needRebootProcess() {
        return WebView.needRebootProcess();
    }

    public static boolean needSwitchToTools(String str) {
        return UrlDispatcher.needSwitchToTools(str);
    }

    public static boolean needUseXWeb(String str) {
        return UrlDispatcher.needUseXWeb(str);
    }

    public static void onReportXWebCrash(File file) {
        XWebCrashMonitor.onReportXWebCrash(file);
    }

    public static void openDebugActivity(Context context) {
        Intent intent = new Intent(context, (Class<?>) XWebDebugActivity.class);
        b.a(context, intent);
        context.startActivity(intent);
    }

    public static void preInitGpuProcess() {
        g.a(ConstValue.INVOKE_RUNTIME_ID_PRE_INIT_GPU_PROCESS, (Object[]) null);
    }

    public static void preInitRenderProcess() {
        g.a(ConstValue.INVOKE_RUNTIME_ID_PRE_INIT_RENDER_PROCESS, (Object[]) null);
    }

    public static void registerBroadcastListener(Context context, IXWebBroadcastListener iXWebBroadcastListener) {
        k.a(context, iXWebBroadcastListener);
    }

    public static void runCommand(Bundle bundle) {
        bundle.putInt("source", com.tencent.luggage.wxa.qq.b.SDK_INTERFACE.ordinal());
        r0.a(bundle, null);
    }

    public static int safeGetChromiumVersion() {
        return com.tencent.luggage.wxa.ar.g.g();
    }

    public static void setAppBrandId(String str) {
        g.a(90001, new Object[]{str});
    }

    public static void setApplicationStartTime(long j3) {
        XWebSdkInternal.setApplicationStartTime(j3);
    }

    public static void setBaseConfigUpdatePeriod(long j3) {
        z0.a(j3);
    }

    public static void setCustomDensity(float f16) {
        XWalkEnvironment.setCustomDensity(f16);
    }

    @Deprecated
    public static synchronized void setEmbedInstallLibDir(String str) {
        synchronized (XWebSdk.class) {
            XWebEmbedSetting.setEmbedInstallLibDir(str);
        }
    }

    public static void setEnableCheckCertificate(boolean z16) {
        XWalkEnvironment.setEnableCheckCertificate(z16);
    }

    public static boolean setEnableRemoteDebug(boolean z16) {
        return XWebSdkInternal.setEnableRemoteDebugInternal(z16);
    }

    public static void setEnableSandbox(boolean z16) {
        XWalkEnvironment.setEnableSandbox(z16);
    }

    public static void setFileDownloaderProxy(IFileDownloaderProxy iFileDownloaderProxy) {
        com.tencent.luggage.wxa.rq.a.a(iFileDownloaderProxy);
    }

    public static synchronized void setForbidDownloadCode(boolean z16) {
        synchronized (XWebSdk.class) {
            XWebEmbedSetting.setForbidDownloadCode(z16);
        }
    }

    public static void setForceCheckUpdate() {
        i0.setForceCheckUpdate(true);
        m.f().resetLastFetchConfigTime();
    }

    public static void setForceDarkBehavior(XWalkEnvironment.ForceDarkBehavior forceDarkBehavior) {
        XWalkEnvironment.setForceDarkBehavior(forceDarkBehavior);
    }

    public static void setForceDarkMode(boolean z16) {
        XWalkEnvironment.setForceDarkMode(z16);
    }

    public static boolean setGrayValueByUserId(int i3) {
        return v0.a(i3);
    }

    public static boolean setIpType(int i3) {
        return XWebSdkInternal.setIpTypeInternal(i3);
    }

    public static synchronized void setIsEmbedDirReady(boolean z16) {
        synchronized (XWebSdk.class) {
            XWebEmbedSetting.setIsEmbedDirReady(z16);
        }
    }

    public static void setLibraryLoader(LibraryLoader.ILibraryLoader iLibraryLoader) {
        LibraryLoader.setLibraryLoader(iLibraryLoader);
    }

    public static void setLocale(@Nullable Locale locale) {
        XWalkEnvironment.setLocale(locale);
    }

    public static void setLocationProxy(XWebLocationProxy xWebLocationProxy) {
        com.tencent.luggage.wxa.uq.a.a().a(xWebLocationProxy);
    }

    public static void setLogInterface(IXWebLogClient iXWebLogClient) {
        x0.a(iXWebLogClient);
    }

    public static void setMultiProcessType(int i3) {
        XWalkEnvironment.setMultiProcessType(i3);
    }

    public static void setPluginConfigUpdatePeriod(int i3) {
        z0.a(i3);
    }

    public static void setReportInterface(WebViewReporterInterface webViewReporterInterface) {
        n0.a(webViewReporterInterface);
    }

    public static void setSharedPreferenceProvider(ISharedPreferenceProvider iSharedPreferenceProvider) {
        y0.a(iSharedPreferenceProvider);
    }

    public static synchronized void setSoLibDirs(List<File> list) {
        synchronized (XWebSdk.class) {
            XWebEmbedSetting.setSoLibDirs(list);
        }
    }

    public static void setTempBaseConfigUrl(String str) {
        z0.b(str);
    }

    public static void setTempPluginConfigUrl(String str) {
        z0.c(str);
    }

    public static void setUsingCustomContext(boolean z16) {
        XWalkEnvironment.setUsingCustomContext(z16);
    }

    public static void setV8LiteMode(boolean z16) {
        XWalkEnvironment.setV8LiteMode(z16);
    }

    public static void setWaitForXWeb(boolean z16) {
        XWebSdkInternal.b(z16);
    }

    public static void setWebViewExtensionListener(WebViewExtensionListener webViewExtensionListener) {
        XWalkEnvironment.setWebViewExtensionListener(webViewExtensionListener);
    }

    public static void setXWebReportRequestIpInterface(XWebReportRequestIpInterface xWebReportRequestIpInterface) {
        XWebRuntimeToSdkHelper.a(xWebReportRequestIpInterface);
    }

    public static void setXWebUpdateListener(IXWebUpdateListener iXWebUpdateListener) {
        XWebSdkInternal.a(iXWebUpdateListener);
    }

    public static void startCheck(Context context, HashMap<String, String> hashMap) {
        u.b(context, hashMap);
    }

    public static void startMemoryDump(XWebMemoryDumpInterface xWebMemoryDumpInterface) {
        XWebRuntimeToSdkHelper.a(xWebMemoryDumpInterface);
        g.a(ConstValue.INVOKE_RUNTIME_ID_ASYC_MEMORY_DUMP, new Object[]{""});
    }

    public static boolean supportMultiProcess(Context context) {
        if (!XWalkEnvironment.isPinusWebViewCoreFromInstalledNewstVersion(context)) {
            x0.f("XWebSdk", "supportMultiProcess, not pinus core");
            return false;
        }
        int installedNewstVersion = getInstalledNewstVersion(context);
        int supportMultiProcessMinApkVersion = CommandCfg.getInstance().getSupportMultiProcessMinApkVersion();
        if (supportMultiProcessMinApkVersion <= 0) {
            x0.f("XWebSdk", "supportMultiProcess, no min apk version");
            return false;
        }
        x0.d("XWebSdk", "supportMultiProcess, installedNewstVersion:" + installedNewstVersion + ", multiProcessMinApkVersion:" + supportMultiProcessMinApkVersion);
        if (installedNewstVersion < supportMultiProcessMinApkVersion) {
            return false;
        }
        return true;
    }

    public static void tryStartDownload() {
        u.g();
    }

    public static void unregisterBroadcastListener(IXWebBroadcastListener iXWebBroadcastListener) {
        k.a(iXWebBroadcastListener);
    }

    public static boolean updateHttpDnsHostList(ConstValue.UpdateHttpDns updateHttpDns, ArrayList<String> arrayList) {
        if (isXWebCoreInited()) {
            try {
                return XWebSdkInternal.updateHttpDnsHostListInternal(updateHttpDns, arrayList);
            } catch (Throwable th5) {
                x0.c("XWebSdk", "updateHttpDnsHostList, unsupported xweb core! " + th5.getMessage());
                return false;
            }
        }
        x0.d("XWebSdk", "updateHttpDnsHostList, xweb core is not initialized!");
        return false;
    }

    public static void updateResourceLocale(Locale locale) {
        XWebSdkInternal.a(locale);
    }

    public static String getConfigValue(String str, String str2) {
        return CommandCfg.getInstance().getCmd(str, str2);
    }

    public static String getPluginConfigValue(String str, String str2) {
        return CommandCfgPlugin.getInstance().getCmd(str, str2);
    }

    public static void setTempBaseConfigUrl(String str, String str2) {
        z0.a(str, str2);
    }

    public static void setTempPluginConfigUrl(String str, String str2) {
        z0.b(str, str2);
    }
}
