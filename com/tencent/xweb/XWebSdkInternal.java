package com.tencent.xweb;

import android.content.Context;
import com.tencent.luggage.wxa.ar.a1;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.w0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.tq.c;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.updater.IXWebUpdateListener;
import java.util.ArrayList;
import java.util.Locale;
import org.xwalk.core.XWalkEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebSdkInternal {
    public static final String SP_KEY_IP_TYPE = "IP_TYPE";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f385089a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f385090b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static IXWebUpdateListener f385091c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f385092d = false;

    /* compiled from: P */
    /* renamed from: com.tencent.xweb.XWebSdkInternal$1, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f385093a;

        static {
            int[] iArr = new int[ConstValue.UpdateHttpDns.values().length];
            f385093a = iArr;
            try {
                iArr[ConstValue.UpdateHttpDns.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f385093a[ConstValue.UpdateHttpDns.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f385093a[ConstValue.UpdateHttpDns.DELETE_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static synchronized void a(Context context, XWebEnvironmentConfig xWebEnvironmentConfig) {
        synchronized (XWebSdkInternal.class) {
            x0.d("XWebSdkInternal", String.format("initXWebEnvironment, logInterface:%s, reportInterface:%s, spProvider:%s, libraryLoader:%s, webViewExtensionListener:%s", xWebEnvironmentConfig.getLogInterface(), xWebEnvironmentConfig.getReporterInterface(), xWebEnvironmentConfig.getSharedPreferenceProvider(), xWebEnvironmentConfig.getLibraryLoader(), xWebEnvironmentConfig.getWebViewExtensionListener()));
            if (xWebEnvironmentConfig.getLogInterface() != null) {
                x0.a(xWebEnvironmentConfig.getLogInterface());
            }
            if (xWebEnvironmentConfig.getReporterInterface() != null) {
                n0.a(xWebEnvironmentConfig.getReporterInterface());
            }
            if (xWebEnvironmentConfig.getSharedPreferenceProvider() != null) {
                y0.a(xWebEnvironmentConfig.getSharedPreferenceProvider());
            }
            if (xWebEnvironmentConfig.getLibraryLoader() != null) {
                LibraryLoader.setLibraryLoader(xWebEnvironmentConfig.getLibraryLoader());
            }
            if (xWebEnvironmentConfig.getWebViewExtensionListener() != null) {
                XWalkEnvironment.setWebViewExtensionListener(xWebEnvironmentConfig.getWebViewExtensionListener());
            }
            XWalkEnvironment.init(context);
            XWalkEnvironment.tryLoadLocalAssetRuntime(context);
        }
    }

    public static void b(boolean z16) {
        x0.d("XWebSdkInternal", "setWaitForXWeb:" + z16);
        f385092d = z16;
    }

    public static long getApplicationStartTime() {
        return f385090b;
    }

    public static boolean getEnableRemoteDebugInternal() {
        if (WebView.isXWeb()) {
            try {
                f385089a = XWebPreferences.getBooleanValue(IXWebPreferences.REMOTE_DEBUGGING);
            } catch (Exception e16) {
                x0.a("XWebSdkInternal", "getEnableRemoteDebug, xweb error:", e16);
            }
        }
        return f385089a;
    }

    public static int getIpType() {
        return y0.s().getInt(SP_KEY_IP_TYPE, -2);
    }

    public static IXWebUpdateListener getXWebUpdateListener() {
        return f385091c;
    }

    public static boolean isWaitForXWeb() {
        return f385092d;
    }

    public static void setABTestWebViewKindInternal(Context context, String str, WebView.WebViewKind webViewKind) {
        try {
            a(context).setABTestWebViewKind(str, webViewKind);
        } catch (Exception e16) {
            x0.a("XWebSdkInternal", "setABTestWebViewKind failed, error", e16);
        }
    }

    public static void setApplicationStartTime(long j3) {
        f385090b = j3;
    }

    public static void setEnableCheckStorageInternal(Context context, boolean z16) {
        try {
            a(context).setEnableCheckStorage(z16);
        } catch (Exception e16) {
            x0.a("XWebSdkInternal", "setEnableCheckStorage failed, error", e16);
        }
    }

    public static void setEnableLocalDebugInternal(Context context, boolean z16) {
        try {
            a(context).setEnableLocalDebug(z16);
        } catch (Exception e16) {
            x0.a("XWebSdkInternal", "setEnableLocalDebug failed, error", e16);
        }
    }

    public static boolean setEnableRemoteDebugInternal(boolean z16) {
        f385089a = z16;
        x0.d("XWebSdkInternal", "setEnableRemoteDebug, enable:" + z16);
        if (WebView.isXWeb()) {
            try {
                XWebPreferences.setValue(IXWebPreferences.REMOTE_DEBUGGING, z16);
                return true;
            } catch (Exception e16) {
                x0.a("XWebSdkInternal", "setEnableRemoteDebug, xweb error:", e16);
                return false;
            }
        }
        if (WebView.isSys()) {
            try {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z16);
                return true;
            } catch (Exception e17) {
                x0.a("XWebSdkInternal", "setEnableRemoteDebug, sys error:", e17);
                return false;
            }
        }
        x0.c("XWebSdkInternal", "setEnableRemoteDebug, webview core not init yet");
        return false;
    }

    public static boolean setIpTypeInternal(int i3) {
        if (CommandCfg.getInstance().getCmdAsBoolean("disable_ip_type_change", "tools", false)) {
            x0.d("XWebSdkInternal", "setIpType, ip type change disabled");
            return false;
        }
        int ipType = getIpType();
        if (i3 != ipType) {
            y0.s().edit().putInt(SP_KEY_IP_TYPE, i3).commit();
            x0.d("XWebSdkInternal", "setIpType, ip type changed from " + ipType + " to " + i3);
            if (ipType == 0 && i3 == 1) {
                n0.a(197L, 1);
            } else if (ipType == 1 && i3 == 0) {
                n0.a(198L, 1);
            }
            if (ipType > 0 || i3 > 0) {
                n0.a(1749L, 28L, 1L);
                return true;
            }
        }
        return false;
    }

    public static boolean updateHttpDnsHostListInternal(ConstValue.UpdateHttpDns updateHttpDns, ArrayList<String> arrayList) throws RuntimeException {
        int i3 = AnonymousClass1.f385093a[updateHttpDns.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    x0.d("XWebSdkInternal", "updateHttpDnsHostListInternal fail, unsupported UpdateHttpDns type");
                    return false;
                }
                return a1.b(arrayList);
            }
            return a1.c(arrayList);
        }
        return a1.a(arrayList);
    }

    public static WebDebugCfg a(Context context) {
        WebDebugCfg.getInst().load(context);
        return WebDebugCfg.getInst();
    }

    public static boolean a(int i3) {
        Object a16 = g.a(80003, new Object[]{Integer.valueOf(i3)});
        if (a16 instanceof Boolean) {
            return ((Boolean) a16).booleanValue();
        }
        return false;
    }

    public static void a(boolean z16) {
        try {
            Context applicationContext = XWalkEnvironment.getApplicationContext();
            if (applicationContext == null) {
                x0.f("XWebSdkInternal", "clearAllWebViewCache, invalid context");
                return;
            }
            f b16 = g.b(WebView.getCurrentModuleWebCoreType());
            if (b16 != null) {
                b16.clearAllWebViewCache(applicationContext, z16);
            }
        } catch (Throwable th5) {
            x0.a("XWebSdkInternal", "clearAllWebViewCache, error", th5);
        }
    }

    public static void a(long j3) {
        g.b(30003, new String[]{String.valueOf(j3)});
    }

    public static void a(Locale locale) {
        c webViewContextWrapper;
        try {
            XWalkEnvironment.setLocale(locale);
            XWebPreferences.setValue("lang", locale.toLanguageTag());
            f b16 = g.b(WebView.getCurrentModuleWebCoreType());
            if (b16 == null || (webViewContextWrapper = b16.getWebViewContextWrapper()) == null) {
                return;
            }
            webViewContextWrapper.updateResourceLocale(locale);
        } catch (Throwable th5) {
            x0.a("XWebSdkInternal", "updateResourceLocale, error", th5);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return w0.a(context, str, XWalkEnvironment.LOCAL_TEST_ZIP_NAME, false);
        } catch (Throwable th5) {
            x0.a("XWebSdkInternal", "loadPackageFromCacheDir, error", th5);
            return false;
        }
    }

    public static int a() {
        if (!WebView.isPinus()) {
            x0.f("XWebSdkInternal", "getRenderSandboxProcessMemory, not pinus now");
            return 0;
        }
        Object a16 = g.a(ConstValue.INVOKE_RUNTIME_ID_GET_RENDER_SANDBOX_PROCESS_MEMORY, (Object[]) null);
        if (a16 instanceof Integer) {
            return ((Integer) a16).intValue();
        }
        return 0;
    }

    public static void a(IXWebUpdateListener iXWebUpdateListener) {
        f385091c = iXWebUpdateListener;
    }
}
