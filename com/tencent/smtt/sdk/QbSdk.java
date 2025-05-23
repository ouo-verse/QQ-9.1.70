package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.BuildConfig;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IAuthRequestCallback;
import com.tencent.smtt.export.external.interfaces.IPreloadManager;
import com.tencent.smtt.export.external.interfaces.IX5LocationProviderClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsPrivacyAccess;
import com.tencent.smtt.sdk.config.FeatureConfig;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.Timer;
import com.tencent.smtt.utils.exception.BusinessLimitException;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportTaskParam;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.xweb.FileReaderHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes23.dex */
public class QbSdk {
    private static String A = "UNKNOWN";
    private static boolean B = false;
    private static int C = -1;

    @Deprecated
    public static final int CORE_VER_ENABLE_202112 = 45912;
    public static final int CORE_VER_ENABLE_202207 = 46110;
    private static int D = 0;
    private static int E = 170;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    private static String F = null;
    public static final String FILERADER_MENUDATA = "menuData";
    private static String G = null;
    private static String H = "";
    private static boolean I = false;
    private static boolean J = false;
    private static TbsListener K = null;
    public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String KEY_THIRD_PARTY_TURING = "turing";
    private static TbsListener L = null;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    private static boolean M = false;
    private static boolean N = false;
    public static final int QBMODE = 2;
    public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;

    /* renamed from: a, reason: collision with root package name */
    static String f368991a = null;

    /* renamed from: b, reason: collision with root package name */
    static boolean f368992b = false;

    /* renamed from: c, reason: collision with root package name */
    static boolean f368993c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f368994d = true;

    /* renamed from: e, reason: collision with root package name */
    static String f368995e = null;

    /* renamed from: f, reason: collision with root package name */
    static boolean f368996f = false;

    /* renamed from: g, reason: collision with root package name */
    static long f368997g = 0;

    /* renamed from: h, reason: collision with root package name */
    static long f368998h = 0;

    /* renamed from: j, reason: collision with root package name */
    static boolean f369000j = true;

    /* renamed from: k, reason: collision with root package name */
    static boolean f369001k = true;

    /* renamed from: l, reason: collision with root package name */
    static boolean f369002l = false;

    /* renamed from: m, reason: collision with root package name */
    static boolean f369003m = false;
    public static boolean mDisableUseHostBackupCore = false;

    /* renamed from: n, reason: collision with root package name */
    static volatile boolean f369004n = false;

    /* renamed from: o, reason: collision with root package name */
    static boolean f369005o = false;

    /* renamed from: s, reason: collision with root package name */
    private static int f369009s = 0;
    public static boolean sIsVersionPrinted = false;

    /* renamed from: t, reason: collision with root package name */
    private static String f369010t = "";

    /* renamed from: u, reason: collision with root package name */
    private static Class<?> f369011u = null;

    /* renamed from: v, reason: collision with root package name */
    private static Object f369012v = null;

    /* renamed from: w, reason: collision with root package name */
    private static String f369013w = null;

    /* renamed from: x, reason: collision with root package name */
    private static boolean f369014x = false;

    /* renamed from: y, reason: collision with root package name */
    private static String[] f369015y = null;

    /* renamed from: z, reason: collision with root package name */
    private static String f369016z = "NULL";

    /* renamed from: i, reason: collision with root package name */
    static Object f368999i = new Object();

    /* renamed from: p, reason: collision with root package name */
    static TbsListener f369006p = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.6
        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadFinish(int i3) {
            TbsDownloader.f369089a = false;
            if (QbSdk.K != null) {
                QbSdk.K.onDownloadFinish(i3);
            }
            if (QbSdk.L != null) {
                QbSdk.L.onDownloadFinish(i3);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onDownloadProgress(int i3) {
            if (QbSdk.L != null) {
                QbSdk.L.onDownloadProgress(i3);
            }
            if (QbSdk.K != null) {
                QbSdk.K.onDownloadProgress(i3);
            }
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public void onInstallFinish(int i3) {
            boolean z16;
            if (i3 == 243 && QbSdk.L != null) {
                QbSdk.L.onInstallFinish(i3);
                return;
            }
            if (i3 != 200 && i3 != 220) {
                z16 = false;
            } else {
                z16 = true;
            }
            Log.i(TbsLog.X5LOGTAG, "installX5 -> isSuccess:" + z16 + ",code:" + i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInstallFinish errCode is ");
            sb5.append(i3);
            TbsLog.i("QbSdk", sb5.toString(), true);
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.f369089a = false;
            if (QbSdk.K != null) {
                QbSdk.K.onInstallFinish(i3);
            }
            if (QbSdk.L != null) {
                QbSdk.L.onInstallFinish(i3);
            }
        }
    };
    private static boolean O = false;
    private static boolean P = false;

    /* renamed from: q, reason: collision with root package name */
    static Map<String, Object> f369007q = null;

    @Deprecated
    public static final String USER_ID_FROM_APP_IMSI = TbsPrivacyAccess.ConfigurablePrivacy.IMSI.f369155a;

    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_ID = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_ID.f369155a;

    @Deprecated
    public static final String USER_ID_FROM_APP_MAC = TbsPrivacyAccess.ConfigurablePrivacy.MAC.f369155a;

    @Deprecated
    public static final String USER_ID_FROM_APP_ANDROID_VERSION = TbsPrivacyAccess.ConfigurablePrivacy.ANDROID_VERSION.f369155a;

    @Deprecated
    public static final String USER_ID_FROM_APP_DEVICE_MODEL = TbsPrivacyAccess.ConfigurablePrivacy.DEVICE_MODEL.f369155a;
    public static final String USER_ID_FROM_APP_QIMEI36 = TbsPrivacyAccess.ConfigurablePrivacy.QIMEI36.f369155a;
    private static int Q = -1;
    private static Timer R = null;

    /* renamed from: r, reason: collision with root package name */
    static boolean f369008r = true;
    private static PrivateCDNMode S = PrivateCDNMode.NOT_USE;
    private static SystemCoreProtector T = null;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum PrivateCDNMode {
        OFFICIAL_IMPL,
        SELF_IMPL,
        STANDARD_IMPL,
        NOT_USE
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface TbsInstallerCallBack {
        void onCoreRenameFinished(File[] fileArr);
    }

    static boolean a(Context context) {
        try {
            if (f369011u != null) {
                return true;
            }
            File n3 = n.a().n(context);
            if (n3 == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(n3, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
                return false;
            }
            TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
            p.a().b(context);
            com.tencent.smtt.utils.o.a(context);
            f369011u = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, n3.getAbsolutePath(), getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (Throwable th5) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th5));
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean b(Context context, boolean z16) {
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 44357; SDK_VERSION_NAME: 4.4.2");
            sIsVersionPrinted = true;
        }
        if (f368992b && !z16) {
            TbsCoreLoadStat.getInstance().a(context, 414);
            TbsLog.e("QbSdk", "init", "Force WebView Inner, " + A);
            return false;
        }
        if (f368993c) {
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(f369016z));
            TbsLog.e("QbSdk", "init", "QbSdk init mIsSysWebViewForcedByOuter = true, " + f369016z);
            return false;
        }
        if (!AppUtil.isCpuValid()) {
            TbsCoreLoadStat.getInstance().a(context, 326, new Throwable(AppUtil.mCpu));
            TbsLog.i("QbSdk", "init", "cpu is invalid: " + AppUtil.mCpu);
            return false;
        }
        if (TbsPVConfig.getInstance(context).isEnableProtection() && !f369005o) {
            d(context);
        }
        try {
            File n3 = n.a().n(context);
            if (n3 == null) {
                TbsCoreLoadStat.getInstance().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                return false;
            }
            int a16 = n.a().a(true, context);
            int i3 = f369009s;
            if (i3 != 0 && i3 != a16) {
                f369011u = null;
                f369012v = null;
                TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + f369009s + "; tbsCoreInstalledVer: " + a16));
                return false;
            }
            f369009s = a16;
            if (TbsDownloader.a(context, a16)) {
                TbsLog.w("QbSdk", "init", "version " + f369009s + " is in blacklist,can not load! return");
                return false;
            }
            if (b(context, f369009s)) {
                TbsLog.w("QbSdk", "version " + f369009s + " is in below min-version that app set by QbSdk.setCoreMinVersion, reset and not load.");
                return false;
            }
            int i16 = C;
            if (i16 == -1) {
                boolean isTbsCoreDisabledBySwitch = TbsDownloader.isTbsCoreDisabledBySwitch(context.getApplicationContext(), f369009s);
                C = isTbsCoreDisabledBySwitch ? 0 : 1;
                if (isTbsCoreDisabledBySwitch) {
                    TbsLog.w("QbSdk", "init", "version " + f369009s + "is disable by remote switch");
                    TbsCoreLoadStat.getInstance().a(context, 309, new Throwable("version " + f369009s + "is disable by remote switch or preloadX5Protect()"));
                    return false;
                }
            } else if (i16 == 0) {
                TbsLog.w("QbSdk", "init", "version " + f369009s + "is disable by remote switch");
                return false;
            }
            if (f369011u != null && f369012v != null) {
                return true;
            }
            File n16 = n.a().n(context);
            File file = new File(n16, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                try {
                    int g16 = n.a().g(context);
                    if (g16 > 0) {
                        File file2 = new File(file.getParentFile(), "tbs_jars_fusion_dex.jar");
                        TbsCoreLoadStat.getInstance().a(context, 403, new Throwable("[loadMsg] extension is miss, fusion exist is " + file2.exists() + ", core is " + g16 + ", dexPath is " + file.getPath()));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, 404, new Throwable("core path: " + n16));
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                return false;
            }
            String absolutePath = n3.getAbsolutePath();
            TbsLog.i("QbSdk", "init", "optDirExtension #1 is " + absolutePath);
            TbsLog.i("QbSdk", "init", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
            p.a().b(context);
            com.tencent.smtt.utils.o.a(context);
            f369011u = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            loadTBSSDKExtension(context, file.getParent());
            return true;
        } catch (Throwable th6) {
            TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th6));
            TbsCoreLoadStat.getInstance().a(context, 306, th6);
            return false;
        }
    }

    public static boolean canDownloadWithoutWifi() {
        return M;
    }

    @Deprecated
    public static void canGetAndroidId(boolean z16) {
        TbsPrivacyAccess.AndroidId.setEnabled(z16);
    }

    @Deprecated
    public static void canGetDeviceId(boolean z16) {
        TbsPrivacyAccess.DeviceId.setEnabled(z16);
    }

    @Deprecated
    public static void canGetSubscriberId(boolean z16) {
        TbsPrivacyAccess.Imsi.setEnabled(z16);
    }

    public static boolean canLoadVideo(Context context) {
        Object a16 = com.tencent.smtt.utils.k.a(f369012v, "canLoadVideo", (Class<?>[]) new Class[]{Integer.TYPE}, 0);
        if (a16 != null) {
            if (!((Boolean) a16).booleanValue()) {
                TbsCoreLoadStat.getInstance().a(context, 313);
            }
        } else {
            TbsCoreLoadStat.getInstance().a(context, 314);
        }
        if (a16 == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    @Deprecated
    public static boolean canLoadX5(Context context) {
        return a(context, false);
    }

    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        new BaseThread() { // from class: com.tencent.smtt.sdk.QbSdk.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                final boolean z16;
                p a16 = p.a();
                a16.a(context);
                if (a16.b()) {
                    z16 = a16.c().a(context, str);
                } else {
                    z16 = false;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        valueCallback.onReceiveValue(Boolean.valueOf(z16));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        b(context, false);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream, java.io.InputStream] */
    public static boolean canOpenWebPlus(Context context) {
        ?? fileInputStream;
        if (D == 0) {
            D = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + D);
        boolean z16 = false;
        if (D < E || context == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(n.a().n(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(Build.VERSION.SDK);
                if (parseInt3 <= parseInt && parseInt3 >= parseInt2) {
                    int parseInt4 = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        fileInputStream = new FileInputStream(new File(n.o(context), "tbs_extension.conf"));
                    } catch (Throwable unused2) {
                    }
                    try {
                        ?? properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt5 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        int parseInt6 = Integer.parseInt(properties2.getProperty(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                        if (parseInt4 != 88888888 && parseInt5 != 88888888 && parseInt4 <= parseInt5 && parseInt4 == parseInt5 && ((parseInt6 <= 0 || parseInt6 == AppUtil.getAppVersionCode(context)) && Boolean.parseBoolean(properties2.getProperty("x5_disabled")))) {
                            if (!TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false)) {
                                z16 = true;
                            }
                        }
                    } catch (Throwable unused3) {
                        bufferedInputStream = fileInputStream;
                        try {
                            TbsLog.i("QbSdk", "canOpenWebPlus - isX5Disabled Exception");
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            z16 = true;
                            return !z16;
                        } catch (Throwable th5) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception unused5) {
                                }
                            }
                            throw th5;
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused6) {
                        return !z16;
                    }
                }
                TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                try {
                    bufferedInputStream2.close();
                } catch (Exception unused7) {
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream = bufferedInputStream2;
                try {
                    th.printStackTrace();
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused8) {
                        }
                    }
                    return false;
                } catch (Throwable th7) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused9) {
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i3) {
        Object a16 = com.tencent.smtt.utils.k.a(f369012v, "canUseVideoFeatrue", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(i3));
        if (a16 == null || !(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean checkApkExist(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean checkContentProviderPrivilage(Context context) {
        if (context == null || context.getApplicationInfo().targetSdkVersion < 24 || Build.VERSION.SDK_INT < 24 || "com.tencent.mobileqq".equals(context.getApplicationInfo().packageName)) {
            return true;
        }
        try {
            if (!TextUtils.isEmpty(context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), "android.support.v4.content.FileProvider"), 0).authority)) {
                return true;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getApplicationInfo().packageName + ".provider", 128);
        if (resolveContentProvider == null) {
            Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
        if (resolveContentProvider != null) {
            return true;
        }
        return false;
    }

    public static void checkTbsValidity(Context context) {
        if (context != null && !com.tencent.smtt.utils.o.b(context)) {
            TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().a(context, 419);
            forceSysWebView();
        }
    }

    public static void clearAllDefaultBrowser(Context context) {
        context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0).edit().clear().commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void clearAllWebViewCache(Context context, boolean z16) {
        boolean z17;
        Throwable th5;
        TbsLog.i("QbSdk", "clearAllWebViewCache(" + context + ", " + z16 + ")");
        boolean z18 = false;
        try {
            if (new QmX5Webview(context).getWebViewClientExtension() != null) {
                try {
                    p a16 = p.a();
                    if (a16 != null && a16.b()) {
                        a16.c().a(context, z16);
                    }
                    z18 = true;
                } catch (Throwable th6) {
                    th5 = th6;
                    z17 = true;
                    TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th5));
                    z18 = z17;
                    if (!z18) {
                    }
                }
            }
        } catch (Throwable th7) {
            z17 = false;
            th5 = th7;
        }
        if (!z18) {
            TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            return;
        }
        try {
            QmWebview qmWebview = new QmWebview(context);
            qmWebview.removeJavascriptInterface("searchBoxJavaBridge_");
            qmWebview.removeJavascriptInterface("accessibility");
            qmWebview.removeJavascriptInterface("accessibilityTraversal");
            qmWebview.clearCache(true);
            if (z16) {
                android.webkit.CookieSyncManager.createInstance(context);
                android.webkit.CookieManager.getInstance().removeAllCookie();
            }
            android.webkit.WebViewDatabase.getInstance(context).clearUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            android.webkit.WebViewDatabase.getInstance(context).clearFormData();
            android.webkit.WebStorage.getInstance().deleteAllData();
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th8) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th8));
        }
    }

    public static void clearDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String d16 = com.tencent.smtt.sdk.ui.dialog.e.d(str);
        if (TextUtils.isEmpty(d16)) {
            d16 = "*/*";
        }
        sharedPreferences.edit().remove("key_tbs_picked_default_browser_" + d16).commit();
    }

    @Deprecated
    public static void closeFileReader(Context context) {
        p a16 = p.a();
        a16.a(context);
        if (a16.b()) {
            a16.c().p();
        }
    }

    public static String closeNetLogAndSavaToLocal() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                Object invokeStaticMethod = a16.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
                if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                    return (String) invokeStaticMethod;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static void configurePrivacy(Context context, TbsPrivacyAccess.ConfigurablePrivacy configurablePrivacy, String str) {
        TbsPrivacyAccess.configurePrivacy(context, configurablePrivacy, str);
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        p a16;
        Bitmap bitmap;
        if (context != null && !TbsDownloader.getOverSea(context) && !isMiniQBShortCutExist(context, str, str2) && (a16 = p.a()) != null && a16.b()) {
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else {
                bitmap = null;
            }
            DexLoader b16 = a16.c().b();
            TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b16.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
            if (invokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    private static void d(Context context) {
        String e16 = e(context);
        if (J || !Thread.currentThread().getName().equals("tbs_preinit")) {
            return;
        }
        J = true;
        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- process:" + context.getApplicationInfo().processName + "; thread:" + Thread.currentThread().getName());
        int g16 = n.a().g(context);
        if (g16 <= 0) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
            int i3 = sharedPreferences.getInt(e16, 0) + 1;
            if (i3 > 3) {
                TbsCoreLoadStat.getInstance().a(context, 327, new Throwable("key is: " + e16));
                f(context);
                if (!TbsDownloader.isTbsCoreDisabledBySwitch(context, g16)) {
                    TbsDownloader.setTbsCoreDisabledBySwitch(context, g16);
                }
                TbsLog.e("QbSdk", "Too many unfinished preInit for current process, disable X5Core.");
                TbsLogReport tbsLogReport = TbsLogReport.getInstance(context);
                TbsLogReport.TbsLogInfo tbsLogInfo = tbsLogReport.tbsLogInfo();
                tbsLogInfo.setErrorCode(g16);
                tbsLogReport.eventReport(TbsLogReport.EventType.TYPE_CORE_PROTECT_RESET, tbsLogInfo);
                return;
            }
            sharedPreferences.edit().putInt(e16, i3).commit();
        } catch (Throwable th5) {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th5));
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        p a16;
        if (context == null || TbsDownloader.getOverSea(context) || (a16 = p.a()) == null || !a16.b() || a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) == null) {
            return false;
        }
        return true;
    }

    public static void disAllowThirdAppDownload() {
        f368994d = false;
    }

    public static void disableAutoCreateX5Webview() {
        f369001k = false;
    }

    public static void disableCoreLoadProtection(Context context) {
        f369005o = true;
        TbsDownloader.setAppContext(context.getApplicationContext());
        TbsDownloader.a();
    }

    @Deprecated
    public static void disableSensitiveApi() {
        TbsPrivacyAccess.disableSensitiveApi();
    }

    private static String e(Context context) {
        String currentProcessName = getCurrentProcessName(context);
        if (currentProcessName == null || TextUtils.isEmpty(currentProcessName)) {
            return "tbs_preload_x5_recorder";
        }
        String[] split = currentProcessName.split(":");
        if (split.length < 2) {
            return "tbs_preload_x5_recorder";
        }
        return "tbs_preload_x5_recorder" + split[1];
    }

    public static void enableX5WithoutRestart() {
        throw new UnsupportedOperationException("Current TBS SDK doesn't support");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context) {
        if (Thread.currentThread().getName().equals("tbs_preinit")) {
            context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4).edit().putInt(e(context), 0).commit();
        }
    }

    public static void fileInfoDetect(Context context, String str, android.webkit.ValueCallback<String> valueCallback) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, android.webkit.ValueCallback.class}, context, str, valueCallback);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static void forceSysWebView() {
        f368993c = true;
        f369016z = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        if (context == null) {
            return 0L;
        }
        return TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0L);
    }

    public static String getCurrentProcessName(Context context) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i3;
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            bArr = new byte[256];
            i3 = 0;
            while (true) {
                int read = fileInputStream.read();
                if (read <= 0 || i3 >= 256) {
                    break;
                }
                bArr[i3] = (byte) read;
                i3++;
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            } catch (Throwable th7) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                throw th7;
            }
        }
        if (i3 > 0) {
            String str = new String(bArr, 0, i3, "UTF-8");
            if (TextUtils.isEmpty(H)) {
                H = str;
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return str;
            }
            try {
                fileInputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            return str;
        }
        fileInputStream.close();
        return null;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        String[] strArr = f369015y;
        if (strArr instanceof String[]) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            for (int i3 = 0; i3 < length; i3++) {
                strArr2[i3] = str + f369015y[i3];
            }
            return strArr2;
        }
        Object a16 = com.tencent.smtt.utils.k.a(f369012v, "getJarFiles", (Class<?>[]) new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a16 instanceof String[])) {
            a16 = new String[]{""};
        }
        return (String[]) a16;
    }

    @Deprecated
    public static boolean getDownloadWithoutWifi() {
        return M;
    }

    public static boolean getIsInitX5Environment() {
        return f369002l;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return f368993c;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        Object obj = f369012v;
        if (obj == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            return false;
        }
        Bundle bundle = (Bundle) com.tencent.smtt.utils.k.a(obj, "canLoadX5CoreAndNotLoadSo", (Class<?>[]) new Class[]{Integer.TYPE}, 44357);
        if (bundle == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + n.a().a(true, context));
            return false;
        }
        f369015y = bundle.getStringArray("tbs_jarfiles");
        f368995e = bundle.getString("tbs_librarypath");
        return true;
    }

    public static String getMiniQBVersion(Context context) {
        p a16 = p.a();
        a16.a(context);
        if (a16.b()) {
            return a16.c().f();
        }
        return null;
    }

    public static boolean getOnlyDownload() {
        return f369003m;
    }

    public static String getQQBuildNumber() {
        return G;
    }

    public static Map<String, Object> getSettings() {
        return f369007q;
    }

    public static boolean getTBSInstalling() {
        return N;
    }

    public static String getTID() {
        return F;
    }

    public static File getTbsFolderDir(Context context) {
        if (context == null) {
            return null;
        }
        if (AppUtil.is64BitImpl()) {
            return context.getDir("tbs_64", 0);
        }
        return context.getDir("tbs", 0);
    }

    @Deprecated
    public static String getTbsResourcesPath(Context context) {
        return "";
    }

    public static int getTbsSdkVersion() {
        return 44357;
    }

    public static int getTbsVersion(Context context) {
        return n.a().g(context);
    }

    public static int getTbsVersionForCrash(Context context) {
        if (f368992b) {
            return 0;
        }
        int h16 = n.a().h(context);
        if (h16 == 0 && m.a(context).c() == 3) {
            g(context);
        }
        return h16;
    }

    public static int getTmpDirTbsVersion(Context context) {
        if (m.a(context).c() == 2) {
            return n.a().a(context, 0);
        }
        if (m.a(context).b("copy_status") != 1) {
            return 0;
        }
        return n.a().a(context, 1);
    }

    public static String getX5CoreLoadHelp(Context context) {
        String str;
        if (context == null) {
            return "context is null";
        }
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        int g16 = n.a().g(context);
        if (g16 > 0) {
            int loadErrorCode = TbsCoreLoadStat.getLoadErrorCode();
            if (loadErrorCode == -1 && p.a().b()) {
                str = "core load success";
            } else {
                str = "Core Exist version is " + g16 + ", error code: " + loadErrorCode + ", detail: " + TbsCoreLoadStat.getLoadErrorMessage() + ", suggestion: " + com.tencent.smtt.utils.f.a().a(loadErrorCode);
            }
        } else {
            int nextPostInterval = TbsDownloader.getNextPostInterval(context);
            if (TbsDownloader.f369089a) {
                str = "core is downloading, please check TbsListener.onDownloadProgress.";
            } else if (Apn.getApnType(context) != 3 && !canDownloadWithoutWifi()) {
                str = "Mobile Network will not download as default. If you want, you can set QbSdk.setDownloadWithoutWifi(true) in the beginning of your app.";
            } else if (nextPostInterval > 0) {
                str = "Perhaps server is busy, try to restart your app in " + nextPostInterval + "s later or (uninstall + reinstall).";
            } else {
                str = "Core not exist, unknown network problem.";
            }
        }
        return str + "If it doesn't help, contact with x5 with your tbslog.txt, site: x5.tencent.com";
    }

    public static IPreloadManager getX5PreloadManager() {
        throw new BusinessLimitException();
    }

    public static void initBuglyAsync(boolean z16) {
        f369000j = z16;
    }

    @Deprecated
    public static void initForinitAndNotLoadSo(Context context) {
        File n3;
        if (f369011u == null && (n3 = n.a().n(context)) != null && n3.exists()) {
            File file = new File(n3, "tbs_sdk_extension_dex.jar");
            if (!file.exists()) {
                return;
            }
            String absolutePath = n3.getAbsolutePath();
            p.a().b(context);
            com.tencent.smtt.utils.o.a(context);
            f369011u = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, getSettings()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        }
    }

    public static synchronized void initTbsSettings(Map<String, Object> map) {
        synchronized (QbSdk.class) {
            Map<String, Object> map2 = f369007q;
            if (map2 == null) {
                f369007q = map;
            } else {
                try {
                    map2.putAll(map);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        boolean z16;
        com.tencent.smtt.utils.recorder.a.a().a("init_tbs_Start");
        TbsLog.initIfNeed(context);
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            return;
        }
        if (d()) {
            TbsLog.i("QbSdk", "using private CDN mode, preInit directly.");
            preInit(context, preInitCallback);
            return;
        }
        b(context);
        L = new TbsListener() { // from class: com.tencent.smtt.sdk.QbSdk.4
            @Override // com.tencent.smtt.sdk.TbsListener
            public void onInstallFinish(int i3) {
                QbSdk.preInit(context, preInitCallback);
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadFinish(int i3) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public void onDownloadProgress(int i3) {
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            n a16 = n.a();
            if (g.f369355a == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            a16.b(context, z16);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() { // from class: com.tencent.smtt.sdk.QbSdk.5
            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public void onNeedDownloadFinish(boolean z17, int i3) {
                if (TbsShareManager.isThirdPartyApp(context)) {
                    QbSdk.f369006p.onDownloadFinish(TbsDownloadConfig.getInstance(context).getCurrentDownloadInterruptCode());
                    if (QbSdk.f369000j) {
                        TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                    }
                }
                if (QbSdk.c() != null) {
                    TbsDownloader.a(context, new Runnable() { // from class: com.tencent.smtt.sdk.QbSdk.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            QbSdk.preInit(context, preInitCallback);
                        }
                    });
                } else {
                    QbSdk.preInit(context, preInitCallback);
                }
            }
        });
        f369002l = true;
    }

    @Deprecated
    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        g a16 = g.a(true);
        a16.a(context, false, false);
        if (!a16.b()) {
            return false;
        }
        return a16.a().a(context, str, str2, bundle);
    }

    @Deprecated
    public static void installLocalTbsCore(Context context, int i3, String str) {
        if (context != null && context.getPackageName() != null && context.getPackageName().startsWith(BuildConfig.LIBRARY_PACKAGE_NAME)) {
            n.a().a(context, str, i3);
            return;
        }
        throw new IllegalAccessError("QbSdk.installLocalTbsCore is deprecated.");
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        String str3;
        String str4;
        String str5;
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            if (indexOf > 0) {
                str3 = str.substring(indexOf + 4);
            } else {
                str3 = null;
            }
            HashMap hashMap = new HashMap();
            try {
                str4 = context.getApplicationInfo().packageName;
            } catch (Exception e16) {
                e16.printStackTrace();
                str4 = "unknown";
            }
            hashMap.put("ChannelID", str4);
            hashMap.put("PosID", "14004");
            if (QQBrowserActivity.INEWS_HEADLINES_URL.equals(str3)) {
                str5 = "qb://navicard/addCard?cardId=168&cardName=168";
            } else {
                str5 = str3;
            }
            if (MttLoader.loadUrl(context, str5, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                p a16 = p.a();
                if (a16 != null && a16.b() && a16.c().a(context, str3, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(str3);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    @Deprecated
    public static boolean isEnableCanGetSubscriberId() {
        return TbsPrivacyAccess.Imsi.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetAndroidID() {
        return TbsPrivacyAccess.AndroidId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableGetDeviceID() {
        return TbsPrivacyAccess.DeviceId.isEnabled();
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return TbsPrivacyAccess.isEnableSensitiveApi();
    }

    public static boolean isEnableX5WithoutRestart() {
        return I;
    }

    public static boolean isInDefaultBrowser(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARE_PREFERENCES_NAME, 0);
        String d16 = com.tencent.smtt.sdk.ui.dialog.e.d(str);
        if (TextUtils.isEmpty(d16)) {
            d16 = "*/*";
        }
        return sharedPreferences.contains("key_tbs_picked_default_browser_" + d16);
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        p a16;
        Object invokeStaticMethod;
        if (context == null || TbsDownloader.getOverSea(context) || (a16 = p.a()) == null || !a16.b() || (invokeStaticMethod = a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str)) == null) {
            return false;
        }
        Boolean bool = Boolean.FALSE;
        if (invokeStaticMethod instanceof Boolean) {
            bool = (Boolean) invokeStaticMethod;
        }
        return bool.booleanValue();
    }

    public static boolean isNeedInitX5FirstTime() {
        return B;
    }

    public static boolean isStaticNeedDownload() {
        return P;
    }

    public static boolean isSuportOpenFile(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {"rar", "zip", "tar", "bz2", "gz", "7z", FileReaderHelper.DOC_EXT, FileReaderHelper.DOCX_EXT, FileReaderHelper.PPT_EXT, FileReaderHelper.PPTX_EXT, FileReaderHelper.XLS_EXT, FileReaderHelper.XLSX_EXT, FileReaderHelper.TXT_EXT, FileReaderHelper.PDF_EXT, "epub", "chm", TextComponent.SpanType.HTML, "htm", "xml", "mht", "url", "ini", "log", "bat", ResourceAttributes.TelemetrySdkLanguageValues.PHP, EnginePathProvider.ENGINE_JS_DIR, "lrc", "jpg", MimeHelper.IMAGE_SUBTYPE_JPEG, "png", "gif", "bmp", "tiff", "webp", FileReaderHelper.MP3_EXT, FileReaderHelper.M4A_EXT, FileReaderHelper.AAC_EXT, "amr", FileReaderHelper.WAV_EXT, "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", FileUtils.FILE_TYPE_AVI, "3gp", "3gpp", "webm", "ts", "ogv", TPDataTransportTaskParam.TASK_PARAM_SECONDARY_M3U8_CONTENT_KEY_M3U8, "asf", FileUtils.FILE_TYPE_WMV, "rmvb", MsfCmdConfig.CMD_DELETE_FILE, "f4v", VideoTemplateParser.POSTFIX_DAT, FileUtils.FILE_TYPE_MOV, "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx"};
        String[] strArr2 = {FileReaderHelper.DOC_EXT, FileReaderHelper.DOCX_EXT, FileReaderHelper.PPT_EXT, FileReaderHelper.PPTX_EXT, FileReaderHelper.XLS_EXT, FileReaderHelper.XLSX_EXT, FileReaderHelper.TXT_EXT, FileReaderHelper.PDF_EXT, "epub"};
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            return Arrays.asList(strArr).contains(str.toLowerCase());
        }
        return Arrays.asList(strArr2).contains(str.toLowerCase());
    }

    public static boolean isTbsCoreInited() {
        g a16 = g.a(false);
        if (a16 == null || !a16.h()) {
            return false;
        }
        return true;
    }

    public static boolean isX5Core() {
        if (getIsSysWebViewForcedByOuter()) {
            return false;
        }
        return p.a().b();
    }

    public static boolean isX5DisabledSync(Context context) {
        boolean z16;
        if (m.a(context).c() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if (!a(context)) {
            return true;
        }
        int g16 = n.a().g(context);
        Object obj = f369012v;
        Class cls = Integer.TYPE;
        Object a16 = com.tencent.smtt.utils.k.a(obj, "isX5DisabledSync", (Class<?>[]) new Class[]{cls, cls}, Integer.valueOf(g16), 44357);
        if (a16 == null) {
            return true;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Constructor<?> constructor;
        boolean z16;
        String str2;
        if (f369012v != null) {
            return;
        }
        synchronized (QbSdk.class) {
            if (f369012v != null) {
                return;
            }
            if (f369011u == null) {
                TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
            }
            try {
                constructor = f369011u.getConstructor(Context.class, Context.class, String.class, String.class, String.class);
                z16 = true;
            } catch (Throwable unused) {
                constructor = null;
                z16 = false;
            }
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                if (!z16) {
                    f369012v = f369011u.getConstructor(Context.class, Context.class).newInstance(context, context);
                } else {
                    if ("com.tencent.mm".equals(getCurrentProcessName(context)) && !WebView.mWebViewCreated) {
                        str2 = "notLoadSo";
                    } else {
                        str2 = null;
                    }
                    f369012v = constructor.newInstance(context, context, null, str, str2);
                }
            } catch (Throwable th5) {
                TbsCoreLoadStat.getInstance().a(context, 310, th5);
                TbsLog.e("QbSdk", "throwable" + Log.getStackTraceString(th5));
            }
        }
    }

    public static boolean needUpdateLicense(Context context) {
        boolean z16;
        n a16 = n.a();
        if (g.f369355a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        a16.b(context, z16);
        if (!a(context)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("lckey", f368991a);
        bundle.putString("lc", f369013w);
        com.tencent.smtt.utils.k.a(f369012v, "authenticateX5", (Class<?>[]) new Class[]{Bundle.class}, bundle);
        com.tencent.smtt.utils.k.a(f369012v, "canLoadX5Core", (Class<?>[]) new Class[]{Integer.TYPE}, 44357);
        Object a17 = com.tencent.smtt.utils.k.a(f369012v, "isLicenseUpdateNeeded", (Class<?>[]) new Class[0], new Object[0]);
        if (!(a17 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a17).booleanValue();
    }

    public static void openBrowserList(Context context, String str, ValueCallback<String> valueCallback) {
        openBrowserList(context, str, null, valueCallback);
    }

    @Deprecated
    public static int openFileReader(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsLog.i("QbSdk", "Open file reader filepath = " + str);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (!checkContentProviderPrivilage(context)) {
            TbsLog.e("QbSdk", "Got an unexpected result when check content provider privilege above api 24");
            return -5;
        }
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
            String str2 = hashMap.get("fileext");
            String str3 = !TextUtils.isEmpty(str2) ? str2 : lowerCase;
            if (str3 == null) {
                TbsLog.e("QbSdk", "open openFileReader null file type");
            }
            if (RFixConstants.APK_PATH.equalsIgnoreCase(str3)) {
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                Uri a16 = FileProvider.a(context, str);
                if (a16 == null) {
                    valueCallback.onReceiveValue("uri failed");
                    return -6;
                }
                intent.setDataAndType(a16, "application/vnd.android.package-archive");
                context.startActivity(intent);
                TbsLog.e("QbSdk", "open openFileReader ret = 4");
                return 4;
            }
            String packageName = context.getPackageName();
            if (packageName.equals("com.tencent.mm") || packageName.equals("com.tencent.moblieqq") || packageName.equals("com.tencent.wework")) {
                if (MttLoader.isBrowserInstalled(context)) {
                    if (!isSuportOpenFile(str3, 2)) {
                        TbsLog.e("QbSdk", "Open file reader in qq browser, isQBSupport: false  ret = 3");
                        openFileReaderListWithQBDownload(context, str, valueCallback);
                        return 3;
                    }
                    if (startQBForDoc(context, str, 4, 0, str3, a(context, hashMap))) {
                        if (valueCallback != null) {
                            valueCallback.onReceiveValue("open QB");
                        }
                        TbsLog.e("QbSdk", "open openFileReader open QB ret = 1");
                        return 1;
                    }
                    TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
                } else {
                    TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
                }
            }
            hashMap.put("local", "true");
            int startMiniQBToLoadUrl = startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
            if (startMiniQBToLoadUrl != 0) {
                openFileReaderListWithQBDownload(context, str, valueCallback);
                TbsLog.i("QbSdk", "openFileReader open filereader list startMiniQBToLoadUrl ret = " + startMiniQBToLoadUrl);
                return 3;
            }
            TbsLog.i("QbSdk", "openFileReader open in MiniQB");
            return 2;
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue("filepath error");
        }
        TbsLog.e("QbSdk", "open openFileReader filepath error ret -1");
        return -1;
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, ValueCallback<String> valueCallback) {
        openFileReaderListWithQBDownload(context, str, null, valueCallback);
    }

    public static int openFileWithQB(Context context, String str, String str2) {
        TbsLog.i("QbSdk", "open openFileReader startMiniQBToLoadUrl filepath = " + str);
        if (!checkContentProviderPrivilage(context)) {
            return -1;
        }
        if (str != null) {
            String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
            if (MttLoader.isBrowserInstalled(context)) {
                if (!isSuportOpenFile(lowerCase, 2)) {
                    TbsLog.i("QbSdk", "openFileReader open in QB isQBSupport: false");
                    return -2;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("ChannelID", context.getApplicationContext().getApplicationInfo().processName);
                hashMap.put("PosID", Integer.toString(4));
                if (MttLoader.openDocWithQb(context, str, 0, lowerCase, str2, hashMap, null)) {
                    return 0;
                }
                TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
                return -3;
            }
            TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
            return -4;
        }
        TbsLog.i("QbSdk", "open openFileReader filepath error");
        return -5;
    }

    public static void openNetLog(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.smtt.util.X5LogManager", "setLogWrite2FileFlag", new Class[]{String.class}, "sdkNetLog");
            } catch (Exception unused) {
            }
        }
    }

    public static void pauseDownload() {
        TbsDownloader.pauseDownload();
    }

    public static void preInit(Context context) {
        preInit(context, null);
    }

    public static boolean preinstallStaticTbs(Context context) {
        return false;
    }

    public static boolean recordFilePositionEnabled(Context context) {
        return context.getSharedPreferences("file_read_settings", 0).getBoolean("record_file_position", true);
    }

    public static String replaceLibraryName(String str) {
        return "";
    }

    public static void reset(Context context) {
        if (O) {
            TbsLog.w("QbSdk", "[warning] TBS only allow reset 1 times each process.");
        } else {
            O = true;
            g(context);
        }
    }

    public static void resumeDownload() {
        TbsDownloader.resumeDownload();
    }

    public static void setAppList(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        TbsPrivacyAccess.configureAllPrivacy(context, TextUtils.join(",", list));
    }

    public static void setCoreMinVersion(int i3) {
        TbsLog.i("QbSdk", "setCoreMinVersion: " + i3);
        Q = i3;
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            F = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z16) {
        mDisableUseHostBackupCore = z16;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
    }

    public static void setDownloadWithoutWifi(boolean z16) {
        M = z16;
    }

    @Deprecated
    public static void setEnableForThirdParty(Context context, Bundle bundle) {
        com.tencent.smtt.utils.r.a(context, bundle);
    }

    public static void setEnableWebViewInitWaitX5(boolean z16) {
        f369008r = z16;
    }

    public static void setMultiProcessSyncInitTimer(Timer timer) {
        if (R == null) {
            R = timer;
        }
    }

    public static void setNeedInitX5FirstTime(boolean z16) {
        B = z16;
    }

    public static void setNeedStaticWithDownload(boolean z16) {
        throw new IllegalStateException("Current SDK is not support static mode.");
    }

    public static void setNetLogEncryptionKey(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[]{String.class}, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void setNewDnsHostList(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[]{String.class}, str);
            } catch (Exception unused) {
            }
        }
    }

    public static void setOnlyDownload(boolean z16) {
        f369003m = z16;
    }

    public static void setQQBuildNumber(String str) {
        G = str;
    }

    public static void setRecordFilePositionEnabled(Context context, boolean z16) {
        SharedPreferences.Editor edit = context.getSharedPreferences("file_read_settings", 0).edit();
        edit.putBoolean("record_file_position", z16);
        edit.commit();
    }

    public static void setSandboxExternalEnable(boolean z16) {
        FileUtil.a(z16);
    }

    public static void setSystemCoreProtector(SystemCoreProtector systemCoreProtector) {
        throw new BusinessLimitException();
    }

    public static void setTBSInstallingStatus(boolean z16) {
        N = z16;
    }

    public static void setTbsInstallerCallback(TbsInstallerCallBack tbsInstallerCallBack) {
        n.a().a(tbsInstallerCallBack);
    }

    public static void setTbsListener(TbsListener tbsListener) {
        K = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static void setUUID(String str) {
        AppUtil.setSDKUID(str, true);
    }

    public static void setUserID(Context context, Bundle bundle) {
        TbsPrivacyAccess.configureAllPrivacy(context, bundle);
    }

    public static void setX5LocationProviderClient(IX5LocationProviderClient iX5LocationProviderClient) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.smtt.webkit.SmttLocationProviderProxy", "setLocationProviderClient", new Class[]{IX5LocationProviderClient.class}, iX5LocationProviderClient);
            } catch (Exception unused) {
            }
        }
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, android.webkit.ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        p a16 = p.a();
        a16.a(context);
        if (a16.b()) {
            if (context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return -101;
            }
            int a17 = a16.c().a(context, str, hashMap, null, valueCallback);
            TbsLog.i("QbSdk", "startMiniQBToLoadUrl  ret = " + a17);
            return a17;
        }
        TbsCoreLoadStat.getInstance().a(context, 502);
        Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
        return -102;
    }

    public static boolean startQBForDoc(Context context, String str, int i3, int i16, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i3));
        return MttLoader.openDocWithQb(context, str, i16, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i3));
        return MttLoader.openVideoWithQb(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i3, WebView webView) {
        p a16;
        Object invokeStaticMethod;
        HashMap hashMap = new HashMap();
        hashMap.put("ChannelID", context.getApplicationInfo().processName);
        hashMap.put("PosID", Integer.toString(i3));
        if (webView == null) {
            try {
                String str2 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).packageName;
                if ((str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") && (a16 = p.a()) != null && a16.b() && (invokeStaticMethod = a16.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) != null) {
                    webView = (WebView) ((IX5WebViewBase) invokeStaticMethod).getView().getParent();
                }
            } catch (Exception unused) {
            }
        }
        if (MttLoader.loadUrl(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) != 0) {
            return false;
        }
        return true;
    }

    public static boolean startQBWithBrowserlist(Context context, String str, int i3) {
        boolean startQBToLoadurl = startQBToLoadurl(context, str, i3, null);
        if (!startQBToLoadurl) {
            openBrowserList(context, str, null);
        }
        return startQBToLoadurl;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        p a16 = p.a();
        a16.a(context);
        if (hashMap != null && "5".equals(hashMap.get("PosID")) && a16.b()) {
        }
        if (MttLoader.loadUrl(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
            return true;
        }
        if (!a16.b() || ((context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) || a16.c().a(context, str, hashMap, null, valueCallback) != 0)) {
            return false;
        }
        return true;
    }

    public static void unForceSysWebView() {
        f368993c = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static void uploadNetLog(String str) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            try {
                a16.c().b().invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[]{String.class}, str);
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    public static void usePrivateCDN() {
        throw new BusinessLimitException();
    }

    public static boolean useSoftWare() {
        Object obj = f369012v;
        if (obj == null) {
            return false;
        }
        Object a16 = com.tencent.smtt.utils.k.a(obj, "useSoftWare", (Class<?>[]) new Class[0], new Object[0]);
        if (a16 == null) {
            a16 = com.tencent.smtt.utils.k.a(f369012v, "useSoftWare", (Class<?>[]) new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (a16 == null) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Timer c() {
        return R;
    }

    private static void g(Context context) {
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        Log.i("QbSdk", "TBS reset internal...");
        try {
            TbsDownloader.stopDownload();
            TbsDownloader.c(context);
            FileUtil.a(getTbsFolderDir(context), false, true);
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            n.b();
            File file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th5) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th5));
        }
        Log.i("QbSdk", "TBS reset finished");
    }

    public static void openBrowserList(Context context, String str, Bundle bundle, ValueCallback<String> valueCallback) {
        if (context == null) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(str));
        new com.tencent.smtt.sdk.ui.dialog.d(context, "\u9009\u62e9\u5176\u5b83\u5e94\u7528\u6253\u5f00", intent, bundle, valueCallback, com.tencent.smtt.sdk.ui.dialog.e.d(str), string).a();
    }

    public static void openFileReaderListWithQBDownload(Context context, String str, Bundle bundle, ValueCallback<String> valueCallback) {
        if (context == null || context.getApplicationInfo().packageName.equals("com.tencent.qim") || context.getApplicationInfo().packageName.equals(AppConstants.QQMAIL_PACKAGE_NAME)) {
            return;
        }
        String string = bundle != null ? bundle.getString("ChannelId") : "";
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.addCategory("android.intent.category.DEFAULT");
        String d16 = com.tencent.smtt.sdk.ui.dialog.e.d(str);
        if (context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        Uri a16 = FileProvider.a(context, str);
        if (a16 == null) {
            TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,uri failed");
            valueCallback.onReceiveValue("uri failed");
            return;
        }
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,fileUri:" + str + ",mimeType:" + d16);
        intent.setDataAndType(a16, d16);
        new com.tencent.smtt.sdk.ui.dialog.d(context, "\u9009\u62e9\u5176\u5b83\u5e94\u7528\u6253\u5f00", intent, bundle, valueCallback, d16, string).a();
    }

    public static synchronized void preInit(final Context context, boolean z16, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            com.tencent.smtt.utils.recorder.a.a().a("preinit_start");
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit", "processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit", "stack trace: " + Log.getStackTraceString(new Throwable("PreInit Detect:")));
            if (z16 && f369014x && !I) {
                TbsLog.w("QbSdk", "haven't enableX5WithoutRestart");
                return;
            }
            if (z16) {
                f368992b = false;
                f369014x = false;
                TbsLog.w("QbSdk", "is forcePreInit, local web core status has reset");
            }
            if (!f369014x) {
                TbsLog.i("QbSdk", "preInit", "#1# Start new thread to preInit, thread name: tbs_preinit");
                final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.QbSdk.2
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        PreInitCallback preInitCallback2;
                        com.tencent.smtt.utils.recorder.a a16 = com.tencent.smtt.utils.recorder.a.a();
                        int i3 = message.what;
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3 && (preInitCallback2 = preInitCallback) != null) {
                                    preInitCallback2.onCoreInitFinished();
                                    return;
                                }
                                return;
                            }
                            a16.a("preinit_finish");
                            PreInitCallback preInitCallback3 = preInitCallback;
                            if (preInitCallback3 != null) {
                                preInitCallback3.onViewInitFinished(false);
                                a16.a("init_tbs_end");
                            }
                            TbsLog.writeLogToDisk();
                            a16.a(context);
                            return;
                        }
                        a16.a("preinit_finish");
                        if (QbSdk.f369001k) {
                            a16.a("create_webview_start");
                            q c16 = p.a().c();
                            if (c16 != null) {
                                c16.a(context);
                            }
                            a16.a("create_webview_end");
                        }
                        PreInitCallback preInitCallback4 = preInitCallback;
                        if (preInitCallback4 != null) {
                            preInitCallback4.onViewInitFinished(true);
                            a16.a("init_tbs_end");
                        }
                        a16.a(context);
                        TbsLog.writeLogToDisk();
                    }
                };
                BaseThread baseThread = new BaseThread() { // from class: com.tencent.smtt.sdk.QbSdk.3
                    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                    public void run() {
                        boolean z17;
                        int a16 = n.a().a(true, context);
                        TbsDownloader.setAppContext(context);
                        TbsLog.i("QbSdk", "QbSdk preinit ver is " + a16);
                        n a17 = n.a();
                        Context context2 = context;
                        if (g.f369355a == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        a17.b(context2, z17);
                        TbsLog.i("QbSdk", "preInit", "#2-1# prepare initAndLoadSo");
                        p a18 = p.a();
                        a18.a(context);
                        QbSdk.f(context);
                        TbsLog.i("QbSdk", "preInit", "#2-3# X5CoreEngine init finish");
                        boolean b16 = a18.b();
                        handler.sendEmptyMessage(3);
                        if (!b16) {
                            handler.sendEmptyMessage(2);
                        } else {
                            handler.sendEmptyMessage(1);
                        }
                    }
                };
                baseThread.setName("tbs_preinit");
                baseThread.setPriority(10);
                baseThread.start();
                f369014x = true;
            }
        }
    }

    public static void usePrivateCDN(PrivateCDNMode privateCDNMode) {
        throw new BusinessLimitException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SystemCoreProtector f() {
        return T;
    }

    @Deprecated
    public static void reset(Context context, boolean z16) {
        if (O) {
            TbsLog.w("QbSdk", "[warning] TBS only allow reset 1 times each process.");
            return;
        }
        Log.i("QbSdk", "[Warn] TBS reset outside by app call");
        O = true;
        g(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PrivateCDNMode e() {
        throw new BusinessLimitException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(Context context, Bundle bundle) {
        if (!a(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(216, "initForPatch return false!");
            return null;
        }
        Object a16 = com.tencent.smtt.utils.k.a(f369012v, "incrUpdate", (Class<?>[]) new Class[]{Context.class, Bundle.class}, context, bundle);
        if (a16 != null) {
            return (Bundle) a16;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(216, "incrUpdate return null!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return S != PrivateCDNMode.NOT_USE;
    }

    public static void preInit(Context context, PreInitCallback preInitCallback) {
        preInit(context, false, preInitCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, int i3) {
        return a(context, i3, 20000);
    }

    static boolean a(Context context, int i3, int i16) {
        Map<String, Object> map = f369007q;
        if (map != null && map.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && f369007q.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return true;
        }
        n.a().b(context, g.f369355a == 0);
        if (a(context)) {
            return TbsDownloader.isTbsCoreDisabledBySwitch(context.getApplicationContext(), i3);
        }
        return true;
    }

    @Deprecated
    public static void clear(Context context) {
    }

    @Deprecated
    public static void resetDecoupleCore(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, boolean z16) {
        boolean z17;
        Object obj;
        TbsLog.i("QbSdk", "canLoadX5", "#1# installTbsCoreIfNeeded");
        n.a().b(context, g.f369355a == 0);
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        int g16 = n.a().g(context);
        TbsLog.i("QbSdk", "canLoadX5", "#1-1# disabledCoreVersion is " + disabledCoreVersion + " localCoreVersion is " + g16);
        if (disabledCoreVersion != 0 && disabledCoreVersion == g16) {
            TbsLog.e("QbSdk", "canLoadX5", "#2-1# force use sys by remote switch");
            return false;
        }
        if (!b(context, z16)) {
            TbsLog.e("QbSdk", "canLoadX5", "#2-4# QbSdk.init failure!");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("lckey", f368991a);
        bundle.putString("lc", f369013w);
        com.tencent.smtt.utils.k.a(f369012v, "authenticateX5", (Class<?>[]) new Class[]{Bundle.class}, bundle);
        Object obj2 = f369012v;
        Class cls = Integer.TYPE;
        Object a16 = com.tencent.smtt.utils.k.a(obj2, "canLoadX5Core", (Class<?>[]) new Class[]{cls}, 44357);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("#3# invoke sExtensionObj canLoadX5Core and ret is ");
        sb5.append(a16 != null);
        TbsLog.i("QbSdk", "canLoadX5", sb5.toString());
        if (a16 != null) {
            if ((a16 instanceof String) && ((String) a16).equalsIgnoreCase("AuthenticationFail")) {
                TbsLog.e("QbSdk", "canLoadX5", "[LoadError] authenticationFail");
                return false;
            }
            if (!(a16 instanceof Bundle)) {
                TbsCoreLoadStat.getInstance().a(context, 323, new Throwable("" + a16));
                TbsLog.e("QbSdk", "canLoadX5", "[LoadError] ret not instance of bundle, ret:" + a16);
                return false;
            }
            Bundle bundle2 = (Bundle) a16;
            if (bundle2.isEmpty()) {
                TbsCoreLoadStat.getInstance().a(context, 324, new Throwable("" + a16));
                TbsLog.e("QbSdk", "canLoadX5", "[LoadError] empty bundle" + a16);
                return false;
            }
            try {
                int i3 = bundle2.getInt("result_code", -1);
                z17 = i3 == 0;
                if (!z17) {
                    try {
                        obj = com.tencent.smtt.utils.k.a(f369012v, "getErrorCodeForLogReport", (Class<?>[]) new Class[0], new Object[0]);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        obj = null;
                    }
                    if (obj instanceof Integer) {
                        TbsCoreLoadStat.getInstance().a(context, ((Integer) obj).intValue(), new Throwable("detail: " + obj));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, 319, new Throwable("retcode:" + i3 + "; detail: " + obj));
                    }
                    return false;
                }
                try {
                    f369010t = bundle2.getString("tbs_core_version", "0");
                } catch (Exception unused) {
                    f369010t = "0";
                }
                try {
                    f369009s = Integer.parseInt(f369010t);
                } catch (NumberFormatException e17) {
                    e17.printStackTrace();
                    TbsLog.e("QbSdk", "core version string to num error: " + f369010t);
                    f369009s = 0;
                }
                g.a(f369009s);
                if (f369009s == 0) {
                    TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sTbsVersion is 0, string is " + f369010t));
                    TbsLog.e("QbSdk", "canLoadX5", "[LoadError] sTbsVersion is 0, version string is " + f369010t);
                    return false;
                }
                try {
                    String[] stringArray = bundle2.getStringArray("tbs_jarfiles");
                    f369015y = stringArray;
                    if (stringArray == null) {
                        TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + f369015y));
                        TbsLog.e("QbSdk", "canLoadX5", "sJarFiles not instanceof String[]: " + f369015y);
                        return false;
                    }
                    try {
                        f368995e = bundle2.getString("tbs_librarypath");
                        return z17;
                    } catch (Exception e18) {
                        TbsCoreLoadStat.getInstance().a(context, 307, e18);
                        return false;
                    }
                } catch (Throwable th5) {
                    TbsCoreLoadStat.getInstance().a(context, 322, th5);
                    return false;
                }
            } catch (Exception e19) {
                TbsCoreLoadStat.getInstance().a(context, 319, e19);
                return false;
            }
        }
        Object a17 = com.tencent.smtt.utils.k.a(f369012v, "canLoadX5", (Class<?>[]) new Class[]{cls}, Integer.valueOf(a.a()));
        if (a17 != null) {
            if (((a17 instanceof String) && ((String) a17).equalsIgnoreCase("AuthenticationFail")) || !(a17 instanceof Boolean)) {
                return false;
            }
            f369009s = g.d();
            boolean a18 = a(context, g.d());
            z17 = ((Boolean) a17).booleanValue() && !a18;
            if (!z17) {
                TbsCoreLoadStat.getInstance().a(context, 318, new Throwable("isX5Disable:" + a18 + "(Boolean) ret:" + a17));
            }
            return z17;
        }
        TbsCoreLoadStat.getInstance().a(context, 308, new Throwable());
        return false;
    }

    public static int openFileReader(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("local", "true");
        ValueCallback valueCallback = new ValueCallback() { // from class: com.tencent.smtt.sdk.QbSdk.7
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public void onReceiveValue(Object obj) {
            }
        };
        if (FeatureConfig.isOpenFileByQBEnable()) {
            return openFileReader(context, str, hashMap, valueCallback);
        }
        return startMiniQBToLoadUrl(context, str, hashMap, valueCallback);
    }

    @Deprecated
    public static void deleteStableCore(Context context, int i3) {
    }

    @Deprecated
    public static void setUploadCode(Context context, int i3) {
    }

    static boolean b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return false;
        }
        try {
            if (!context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                return true;
            }
            TbsLog.i("QbSdk", "clearPluginConfigFile #1");
            String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            String str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.portfolio", 0).versionName;
            TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
            if (string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null) {
                return true;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
            return true;
        } catch (Throwable th5) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th5.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b() {
        Object invokeStaticMethod;
        p a16 = p.a();
        if (a16 == null || !a16.b() || (invokeStaticMethod = a16.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", DeviceInfoPlugin.API_GET_GUID, new Class[0], new Object[0])) == null || !(invokeStaticMethod instanceof String)) {
            return null;
        }
        return (String) invokeStaticMethod;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Context context, int i3) {
        int i16 = Q;
        if (i3 >= i16 || i3 == 0 || i16 == -1 || !TbsShareManager.isThirdPartyApp(context)) {
            return false;
        }
        g(context);
        TbsCoreLoadStat.getInstance().a(context, 178, new Throwable("QbSdk.setCoreMinVersion: " + Q));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        if (f369013w == null) {
            f369013w = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (f368993c) {
                TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(f369016z));
                return;
            }
            if (f368992b) {
                return;
            }
            f368992b = true;
            A = "forceSysWebViewInner: " + str;
            TbsLog.e("QbSdk", "forceSysWebViewInner", "Reason:" + A);
            TbsLog.e("QbSdk", "forceSysWebViewInner", Log.getStackTraceString(new Throwable("#")));
            TbsCoreLoadStat.getInstance().a(context, 401);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return f369010t;
    }

    private static Bundle a(Context context, Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("style", map.get("style") == null ? "0" : map.get("style"));
            try {
                bundle.putInt("topBarBgColor", Color.parseColor(map.get("topBarBgColor")));
            } catch (Exception unused) {
            }
            if (map.containsKey(FILERADER_MENUDATA)) {
                JSONObject jSONObject = new JSONObject(map.get(FILERADER_MENUDATA));
                JSONArray jSONArray = jSONObject.getJSONArray("menuItems");
                if (jSONArray != null) {
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArray.length() && i3 < 5; i3++) {
                        try {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                            arrayList.add(i3, BitmapFactory.decodeResource(context.getResources(), jSONObject2.getInt("iconResId")));
                            jSONObject2.put("iconResId", i3);
                        } catch (Exception unused2) {
                        }
                    }
                    bundle.putParcelableArrayList("resArray", arrayList);
                }
                bundle.putString(FILERADER_MENUDATA, jSONObject.toString());
            }
            return bundle;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return -99999;
        }
        Object a16 = com.tencent.smtt.utils.k.a(f369012v, "miscCall", (Class<?>[]) new Class[]{String.class, Bundle.class}, str, bundle);
        if (a16 != null) {
            return a16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        if (f368991a == null) {
            f368991a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, boolean z16, IAuthRequestCallback iAuthRequestCallback) {
        n.a().b(context, g.f369355a == 0 || getTbsVersion(context) == 0);
        if (!a(context)) {
            if (iAuthRequestCallback != null) {
                iAuthRequestCallback.onFailed(-1, "x5 is not installed");
            }
        } else {
            if (!(com.tencent.smtt.utils.k.a(f369012v, "queryLicense", (Class<?>[]) new Class[]{String.class, Boolean.TYPE, Object.class}, f368991a, Boolean.valueOf(z16), iAuthRequestCallback) instanceof String) || iAuthRequestCallback == null) {
                return;
            }
            iAuthRequestCallback.onFailed(-2, "current x5 not support outer query");
        }
    }
}
