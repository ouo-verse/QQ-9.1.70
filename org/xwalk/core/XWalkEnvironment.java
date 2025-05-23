package org.xwalk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.ar.e0;
import com.tencent.luggage.wxa.ar.p0;
import com.tencent.luggage.wxa.ar.s0;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.ar.z0;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.luggage.wxa.vq.b;
import com.tencent.luggage.wxa.vq.c;
import com.tencent.luggage.wxa.yq.j;
import com.tencent.luggage.wxa.yq.k;
import com.tencent.luggage.wxa.yq.q;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.xweb.CalledByRuntime;
import com.tencent.xweb.DeprecatedOutsideXWebSdk;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebChildProcessMonitor;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.XWebEmbedSetting;
import com.tencent.xweb.XWebWebViewMode;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.util.WebViewExtensionListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
@SuppressLint({"ApplySharedPref"})
/* loaded from: classes29.dex */
public class XWalkEnvironment {
    public static final String CRASH_DUMP_FILE_SUFFIX = "xweb_sandbox_crash";
    public static final String CRASH_DUMP_FILE_SUFFIX_FOR_GPU = "xweb_gpu_crash";
    public static final String CRASH_DUMP_FILE_SUFFIX_FOR_RENDER_UNSANDBOX = "xweb_render_crash";
    public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
    public static final int MULTI_PROCESS_TYPE_DISABLE = 0;
    public static final int MULTI_PROCESS_TYPE_RENDERER = 1;
    public static final int MULTI_PROCESS_TYPE_RENDERER_AND_GPU = 2;
    public static final String PINUS_SO_NAME = "libxwebcore.so";
    public static final String RUNTIME_ABI_ARM32_STR = "armeabi-v7a";
    public static final String RUNTIME_ABI_ARM64_STR = "arm64-v8a";
    public static final int SDK_SUPPORT_MIN_APKVERSION = 2000;
    public static final int SDK_VERSION = 20240404;
    public static final int TEST_APK_START_VERSION = 100000000;
    public static final String XWALK_SO_NAME = "libxwalkcore.so";

    /* renamed from: c, reason: collision with root package name */
    public static Context f423915c;

    /* renamed from: d, reason: collision with root package name */
    public static s0 f423916d;

    /* renamed from: e, reason: collision with root package name */
    public static String f423917e;

    /* renamed from: f, reason: collision with root package name */
    public static String f423918f;

    /* renamed from: g, reason: collision with root package name */
    public static String f423919g;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f423923k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f423924l;

    /* renamed from: p, reason: collision with root package name */
    public static WebViewExtensionListener f423928p;

    /* renamed from: q, reason: collision with root package name */
    public static String f423929q;

    /* renamed from: a, reason: collision with root package name */
    public static final j f423913a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final b f423914b = new b();

    /* renamed from: h, reason: collision with root package name */
    public static boolean f423920h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f423921i = false;

    /* renamed from: j, reason: collision with root package name */
    public static int f423922j = 2;

    /* renamed from: m, reason: collision with root package name */
    public static final Bundle f423925m = new Bundle();

    @CalledByRuntime
    public static boolean isTurnOnKVLog = false;

    /* renamed from: n, reason: collision with root package name */
    public static final Set f423926n = new HashSet();

    /* renamed from: o, reason: collision with root package name */
    public static final Bundle f423927o = new Bundle();

    /* renamed from: r, reason: collision with root package name */
    public static int f423930r = 0;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f423931s = false;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ForceDarkBehavior {
        FORCE_DARK_ONLY,
        MEDIA_QUERY_ONLY,
        PREFER_MEDIA_QUERY_OVER_FORCE_DARK
    }

    public static boolean a(int i3) {
        d webViewCoreWrapper;
        f b16 = b();
        if (b16 == null || (webViewCoreWrapper = b16.getWebViewCoreWrapper()) == null) {
            return false;
        }
        return webViewCoreWrapper.hasFeature(i3);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void appendAppInfo(String str) {
        x0.d("XWalkEnvironment", "appendAppInfo:" + str);
        f423926n.add(str);
    }

    public static f b() {
        return g.b(getWebViewKindFromAvailableVersion());
    }

    public static void c() {
        if (getBuildConfigShouldEmbedXWebCore()) {
            appendAppInfo(ConstValue.APP_INFO_EMBED_XWEB);
        }
    }

    @CalledByRuntime
    public static boolean containsAppInfo(String str) {
        x0.d("XWalkEnvironment", "containsAppInfo, strInfos:" + str);
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split != null && split.length != 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && !f423926n.contains(str2.trim())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Context convertContextToApplication(@NonNull Context context) {
        if (context instanceof Application) {
            return context;
        }
        return context.getApplicationContext();
    }

    public static s0 d() {
        s0.a();
        String b16 = com.tencent.luggage.wxa.ar.b.b();
        s0 a16 = s0.a(b16);
        int i3 = a16.f121780a;
        if (i3 > 0 && !u0.u(i3)) {
            x0.d("XWalkEnvironment", "initCoreVersionInfo, no apk in version(" + a16.f121780a + ") dir");
            a16 = new s0(-1, null, b16);
            s0.a(a16);
        }
        int i16 = a16.f121780a;
        if (i16 > 0 && u0.c(i16, XWALK_SO_NAME)) {
            x0.d("XWalkEnvironment", "initCoreVersionInfo, xwalk core version(" + a16.f121780a + ") no longer support");
            a16 = new s0(-1, null, b16);
            s0.a(a16);
        }
        int i17 = a16.f121780a;
        if (i17 > 0) {
            s0.b(i17);
        }
        return a16;
    }

    @CalledByRuntime
    public static String dumpAppInfo() {
        String join = TextUtils.join(";", f423926n);
        x0.d("XWalkEnvironment", "dumpAppInfo:" + join);
        return join;
    }

    public static void e() {
        x0.d("XWalkEnvironment", "showBuildConfigs, SHOULD_EMBED_XWEB_CORE:" + getBuildConfigShouldEmbedXWebCore() + ", XWEB_TEST_MODE:" + getBuildConfigXWebTestMode() + ", FORCE_XWEB_CORE:" + getBuildConfigForceXWebCore() + ", NEED_TURN_OFF_DYNAMIC_CODE:" + getBuildConfigNeedTurnOffDynamicCode() + ", THIRD_PARD_RELEASE:" + getBuildConfigThirdPartyRelease());
    }

    public static void ensureInitEnvironment(Context context) {
        if (!hasInited()) {
            init(context);
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static Context getApplicationContext() {
        return f423915c;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static int getAvailableVersion() {
        s0 s0Var = f423916d;
        if (s0Var == null) {
            return -1;
        }
        return s0Var.f121780a;
    }

    public static String getAvailableVersionDetail() {
        s0 s0Var = f423916d;
        if (s0Var != null) {
            return s0Var.f121781b;
        }
        return "";
    }

    public static boolean getBuildConfigForceXWebCore() {
        return true;
    }

    public static boolean getBuildConfigNeedTurnOffDynamicCode() {
        return false;
    }

    public static boolean getBuildConfigShouldEmbedXWebCore() {
        return false;
    }

    public static boolean getBuildConfigThirdPartyRelease() {
        return true;
    }

    public static boolean getBuildConfigXWebTestMode() {
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static ContentResolver getContentResolver() {
        Context context = f423915c;
        if (context == null) {
            x0.c("XWalkEnvironment", "getContentResolver, sApplicationContext is null");
            return null;
        }
        return context.getContentResolver();
    }

    public static float getCustomDensity() {
        float f16;
        Bundle bundle = f423925m;
        synchronized (bundle) {
            f16 = bundle.getFloat(ConstValue.EXTEND_CONFIG_CUSTOM_DENSITY, 0.0f);
        }
        return f16;
    }

    public static boolean getEnableCheckCertificate() {
        return f423924l;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized boolean getEnableSandbox() {
        boolean z16;
        synchronized (XWalkEnvironment.class) {
            if (Build.VERSION.SDK_INT < 26) {
                x0.d("XWalkEnvironment", "getEnableSandbox, disable sandbox because android version below O");
                f423931s = false;
            }
            x0.d("XWalkEnvironment", "getEnableSandbox:" + f423931s);
            z16 = f423931s;
        }
        return z16;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static Bundle getExtendConfigBundle() {
        return f423925m;
    }

    public static int getForceDarkBehavior() {
        return f423922j;
    }

    public static boolean getForceDarkMode() {
        return f423921i;
    }

    public static Object getInitConfig(String str) {
        Object obj;
        Bundle bundle = f423927o;
        synchronized (bundle) {
            obj = bundle.get(str);
        }
        return obj;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static Bundle getInitConfigBundle() {
        return f423927o;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static int getInstalledNewstVersion(Context context) {
        return s0.a(context);
    }

    public static int getInstalledNewstVersionForCurAbi() {
        return getInstalledNewstVersion(com.tencent.luggage.wxa.ar.b.b());
    }

    public static int getInstalledNewstVersionForPredownAbi() {
        String str = "armeabi-v7a";
        if ("armeabi-v7a".equalsIgnoreCase(com.tencent.luggage.wxa.ar.b.b())) {
            str = "arm64-v8a";
        }
        return getInstalledNewstVersion(str);
    }

    public static int getInstalledPluginVersion(Context context, String str) {
        if (context == null) {
            x0.c("XWalkEnvironment", "getInstalledPluginVersion, context is null");
            return -2;
        }
        SharedPreferences e16 = y0.e(str);
        if (e16 == null) {
            x0.c("XWalkEnvironment", "getInstalledPluginVersion, sp is null");
            return -3;
        }
        return e16.getInt("availableVersion", -1);
    }

    @Nullable
    public static Locale getLocale() {
        String str = f423919g;
        if (str != null && !str.isEmpty()) {
            return Locale.forLanguageTag(f423919g);
        }
        return null;
    }

    @Nullable
    public static String getLocaleString() {
        return f423919g;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized int getMultiProcessType() {
        synchronized (XWalkEnvironment.class) {
            int i3 = f423930r;
            if (i3 >= 0 && i3 <= 2) {
                x0.d("XWalkEnvironment", "getMultiProcessType, multiProcessType:" + f423930r);
                return f423930r;
            }
            x0.f("XWalkEnvironment", "getMultiProcessType, MULTI_PROCESS_TYPE_DISABLE");
            return 0;
        }
    }

    public static String getPackageName() {
        Context context = f423915c;
        if (context == null) {
            x0.c("XWalkEnvironment", "getPackageName, sApplicationContext is null");
            return "";
        }
        return context.getPackageName();
    }

    public static String getPrivilegedServicesName() {
        return f423917e;
    }

    public static String getProcessName() {
        if (!TextUtils.isEmpty(f423929q)) {
            return f423929q;
        }
        Object initConfig = getInitConfig("processName");
        if (initConfig != null) {
            String obj = initConfig.toString();
            f423929q = obj;
            return obj;
        }
        String f16 = e0.f(getApplicationContext());
        f423929q = f16;
        return f16;
    }

    public static String getSafeModuleName(String str) {
        try {
            String a16 = a();
            if (!"tools".equalsIgnoreCase(a16) && !"mm".equalsIgnoreCase(a16) && !TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT.equalsIgnoreCase(a16)) {
                if (a16.startsWith("appbrand")) {
                    x0.d("XWalkEnvironment", "getSafeModuleName, module = appbrand");
                    return "appbrand";
                }
                x0.d("XWalkEnvironment", "getSafeModuleName, unknown:" + a16 + ", use defaultVal:" + str);
                return str;
            }
            x0.d("XWalkEnvironment", "getSafeModuleName, module = " + a16);
            return a16;
        } catch (Throwable th5) {
            x0.a("XWalkEnvironment", "getSafeModuleName, use defaultVal:" + str + ", error", th5);
            return str;
        }
    }

    public static String getSandboxedServicesName() {
        return f423918f;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean getUsingCustomContext() {
        if (isCurrentSupportCustomContext()) {
            return getUsingCustomContextInternal();
        }
        return false;
    }

    public static boolean getUsingCustomContextInternal() {
        return f423920h;
    }

    public static boolean getV8LiteMode() {
        return f423923k;
    }

    public static WebViewExtensionListener getWebViewExtensionListener() {
        return f423928p;
    }

    public static WebView.WebViewKind getWebViewKindFromAvailableVersion() {
        return getWebViewKindFromVersion(getAvailableVersion());
    }

    public static WebView.WebViewKind getWebViewKindFromInstalledNewstVersion(Context context) {
        return getWebViewKindFromVersion(getInstalledNewstVersion(context));
    }

    public static WebView.WebViewKind getWebViewKindFromVersion(int i3) {
        if (!hasInited()) {
            x0.f("XWalkEnvironment", "getWebViewKindFromVersion, not init yet, version:" + i3);
            return WebView.WebViewKind.WV_KIND_NONE;
        }
        if (i3 <= 0) {
            x0.f("XWalkEnvironment", "getWebViewKindFromVersion, invalid version:" + i3);
            return WebView.WebViewKind.WV_KIND_NONE;
        }
        if (u0.c(i3, PINUS_SO_NAME)) {
            return WebView.WebViewKind.WV_KIND_PINUS;
        }
        x0.f("XWalkEnvironment", "getWebViewKindFromVersion, version:" + i3 + ", no pinus so file exist");
        return WebView.WebViewKind.WV_KIND_NONE;
    }

    public static boolean hasAvailableVersion() {
        if (2000 <= getAvailableVersion()) {
            return true;
        }
        return false;
    }

    public static boolean hasInited() {
        if (f423915c != null) {
            return true;
        }
        return false;
    }

    public static boolean hasInstalledAvailableVersion() {
        if (2000 <= getInstalledNewstVersionForCurAbi()) {
            return true;
        }
        return false;
    }

    public static synchronized void init(Context context) {
        synchronized (XWalkEnvironment.class) {
            if (context == null) {
                x0.f("XWalkEnvironment", "init, invalid context");
                return;
            }
            if (hasInited()) {
                x0.f("XWalkEnvironment", "init, already init");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            x0.f("XWalkEnvironment", "init start, sdkVersion:20240404, processName:" + getProcessName() + ", stack:" + Log.getStackTraceString(new Exception("please ignore this exception")));
            f423915c = convertContextToApplication(context);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("init, application context:");
            sb5.append(f423915c);
            x0.d("XWalkEnvironment", sb5.toString());
            y0.a(f423915c);
            long currentTimeMillis2 = System.currentTimeMillis();
            f423916d = d();
            x0.d("XWalkEnvironment", "init, initCoreInfo costTime:" + (System.currentTimeMillis() - currentTimeMillis2) + ", coreInfo:" + f423916d);
            e();
            p0.c();
            long currentTimeMillis3 = System.currentTimeMillis();
            XWalkPluginManager.initPlugins();
            x0.d("XWalkEnvironment", "init, initPlugins costTime:" + (System.currentTimeMillis() - currentTimeMillis3));
            WebDebugCfg.getInst().load(context);
            c();
            initProcessServices();
            XWebChildProcessMonitor.init();
            XWebWebViewMode.init();
            com.tencent.luggage.wxa.vq.d.a();
            k.a(f423915c, f423913a);
            c.a(f423915c, f423914b);
            XWebCoreContentProvider.onXWebInitFinished();
            x0.f("XWalkEnvironment", "init end, processName:" + getProcessName() + ", costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static void initInChildProcess(Context context, boolean z16) {
        if (context == null) {
            x0.f("XWalkEnvironment", "initInChildProcess, invalid context");
            return;
        }
        if (hasInited()) {
            x0.f("XWalkEnvironment", "initInChildProcess, already init");
            return;
        }
        x0.f("XWalkEnvironment", "initInChildProcess start, sdkVersion:20240404, isIsolated:" + z16 + " stack:" + Log.getStackTraceString(new Exception("please ignore this exception")));
        f423915c = convertContextToApplication(context);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initInChildProcess, application context:");
        sb5.append(f423915c);
        x0.f("XWalkEnvironment", sb5.toString());
        if (!z16) {
            y0.a(f423915c);
            f423916d = d();
            x0.d("XWalkEnvironment", "initInChildProcess, coreInfo:" + f423916d);
        }
        x0.f("XWalkEnvironment", "initInChildProcess end, processName:" + getProcessName());
    }

    public static void initProcessServices() {
        a("com.tencent.xweb.pinus.sdk.process.PrivilegedProcessService", "com.tencent.xweb.pinus.sdk.process.SandboxedProcessService");
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentSupportCustomContext() {
        if (WebView.getCurrentModuleWebCoreType() == WebView.WebViewKind.WV_KIND_PINUS) {
            return isCurrentVersionSupportCustomContext();
        }
        return false;
    }

    public static boolean isCurrentVersionSupportAudioMuted() {
        if (hasAvailableVersion() && a(2018)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportConfigureV8Lite() {
        if (hasAvailableVersion() && a(1043)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportContentHeightChange() {
        if (hasAvailableVersion() && a(2014)) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentVersionSupportCustomContext() {
        if (hasAvailableVersion() && a(1020)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportCustomInputForAppbrand() {
        if (hasAvailableVersion() && a(1041)) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand() {
        if (hasAvailableVersion() && a(1012)) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentVersionSupportExtendPluginForAppbrand() {
        if (hasAvailableVersion() && getAvailableVersion() >= 300) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportForceDarkMode() {
        if (hasAvailableVersion() && a(1021)) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand() {
        if (hasAvailableVersion() && a(1011)) {
            return true;
        }
        return false;
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static boolean isCurrentVersionSupportNativeView() {
        if (hasAvailableVersion() && a(1013)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportProxyOverrideReverseBypass() {
        if (hasAvailableVersion() && a(2016)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportScreenshotForSameLayer() {
        if (hasAvailableVersion() && a(2010)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportSetProxyOverride() {
        if (hasAvailableVersion() && a(2015)) {
            return true;
        }
        return false;
    }

    public static boolean isCurrentVersionSupportSetWebContentsSize() {
        if (hasAvailableVersion() && a(1042)) {
            return true;
        }
        return false;
    }

    public static boolean isInTestMode() {
        return !TextUtils.isEmpty(z0.h());
    }

    public static boolean isPinusWebViewCoreFromAvailableVersion() {
        if (getWebViewKindFromAvailableVersion() == WebView.WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    public static boolean isPinusWebViewCoreFromInstalledNewstVersion(Context context) {
        if (getWebViewKindFromInstalledNewstVersion(context) == WebView.WebViewKind.WV_KIND_PINUS) {
            return true;
        }
        return false;
    }

    public static boolean isTestVersion(int i3) {
        if (i3 >= 100000000) {
            return true;
        }
        return false;
    }

    public static void refreshVersionInfo() {
        f423916d = s0.a(com.tencent.luggage.wxa.ar.b.b());
    }

    public static void reset() {
        x0.d("XWalkEnvironment", "reset");
        f423915c = null;
        f423916d = null;
    }

    public static boolean setCoreVersionInfo(int i3, String str, String str2) {
        return s0.a(i3, str, str2);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setCustomDensity(float f16) {
        x0.d("XWalkEnvironment", "setCustomDensity:" + f16);
        Bundle bundle = f423925m;
        synchronized (bundle) {
            bundle.putFloat(ConstValue.EXTEND_CONFIG_CUSTOM_DENSITY, f16);
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setEnableCheckCertificate(boolean z16) {
        f423924l = z16;
        g.a(ConstValue.INVOKE_RUNTIME_ID_ENABLE_CHECK_CERTIFICATE, new Object[]{Boolean.valueOf(z16)});
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setEnableSandbox(boolean z16) {
        synchronized (XWalkEnvironment.class) {
            if (Build.VERSION.SDK_INT < 26) {
                x0.d("XWalkEnvironment", "setEnableSandbox, disable sandbox because android version below O");
                f423931s = false;
            } else {
                x0.d("XWalkEnvironment", "setEnableSandbox:" + z16);
                f423931s = z16;
            }
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setForceDarkBehavior(ForceDarkBehavior forceDarkBehavior) {
        if (forceDarkBehavior == ForceDarkBehavior.FORCE_DARK_ONLY) {
            f423922j = 0;
        } else if (forceDarkBehavior == ForceDarkBehavior.MEDIA_QUERY_ONLY) {
            f423922j = 1;
        } else if (forceDarkBehavior == ForceDarkBehavior.PREFER_MEDIA_QUERY_OVER_FORCE_DARK) {
            f423922j = 2;
        }
        x0.d("XWalkEnvironment", "setForceDarkBehavior, forceDarkBehavior:" + forceDarkBehavior);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setForceDarkMode(boolean z16) {
        f423921i = z16;
        x0.d("XWalkEnvironment", "setForceDarkMode, forceDarkMode:" + z16);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setLocale(@Nullable Locale locale) {
        if (locale != null) {
            x0.d("XWalkEnvironment", "setLocale, customize locale:" + locale.toLanguageTag());
            a(locale.toLanguageTag());
            return;
        }
        x0.f("XWalkEnvironment", "setLocale, customize locale not set");
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static synchronized void setMultiProcessType(int i3) {
        synchronized (XWalkEnvironment.class) {
            x0.f("XWalkEnvironment", "setMultiProcessType, multiProcessType:" + i3);
            f423930r = i3;
        }
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setUsingCustomContext(boolean z16) {
        f423920h = z16;
        x0.d("XWalkEnvironment", "setUsingCustomContext, usingCustomContext:" + z16);
    }

    @DeprecatedOutsideXWebSdk
    @Deprecated
    public static void setV8LiteMode(boolean z16) {
        f423923k = z16;
        x0.d("XWalkEnvironment", "setV8LiteMode " + z16);
    }

    public static void setWebViewExtensionListener(WebViewExtensionListener webViewExtensionListener) {
        f423928p = webViewExtensionListener;
    }

    public static void tryLoadLocalAssetRuntime(Context context) {
        if (!WebDebugCfg.getInst().isDebugMode() || context == null) {
            return;
        }
        if (XWebEmbedSetting.getForbidDownloadCode()) {
            x0.d("XWalkEnvironment", "tryLoadLocalAssetRuntime, turn off dynamic code");
        } else {
            new q().a(context, WebDebugCfg.getInst().isDebugModeReplace());
        }
    }

    public static int getInstalledNewstVersion(String str) {
        return s0.a(str).f121780a;
    }

    public static void a(String str) {
        f423919g = str;
    }

    public static int getInitConfig(String str, int i3) {
        int i16;
        Bundle bundle = f423927o;
        synchronized (bundle) {
            i16 = bundle.getInt(str, i3);
        }
        return i16;
    }

    public static String a() {
        String processName = getProcessName();
        if (processName == null) {
            return "";
        }
        if (processName.contains(":")) {
            return processName.substring(processName.lastIndexOf(":") + 1).toLowerCase();
        }
        return processName.contains(".") ? processName.substring(processName.lastIndexOf(".") + 1).toLowerCase() : processName;
    }

    public static String getInitConfig(String str, String str2) {
        String string;
        Bundle bundle = f423927o;
        synchronized (bundle) {
            string = bundle.getString(str, str2);
        }
        return string;
    }

    public static void a(String str, String str2) {
        f423917e = str;
        f423918f = str2;
    }

    public static boolean getInitConfig(String str, boolean z16) {
        boolean z17;
        Bundle bundle = f423927o;
        synchronized (bundle) {
            z17 = bundle.getBoolean(str, z16);
        }
        return z17;
    }
}
