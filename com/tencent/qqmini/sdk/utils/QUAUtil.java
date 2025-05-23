package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.VersionUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.net.URLEncoder;
import kotlin.text.Typography;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class QUAUtil {
    private static final String TAG = "QUAUtil";
    private static volatile String requestUA;
    private static volatile String sSimpleDeviceInfo;
    private static volatile String systemUA;
    private static String[] sLoginTypeList = {"anonymous", "wechat", "qq", "qqwtlogin", "other"};
    private static volatile String mWebViewUA = "";

    public static String getApplicationName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static int getClipboardInterval() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getClipboardInterval();
    }

    public static String getLoginType() {
        return sLoginTypeList[LoginManager.getInstance().getLoginType()];
    }

    public static String getPlatformQUA() {
        String platformQUA = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformQUA();
        if (!TextUtils.isEmpty(platformQUA)) {
            return platformQUA;
        }
        return getQUA();
    }

    public static String getPlatformVersionString() {
        String appVersion = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            return appVersion;
        }
        return "1.83.3";
    }

    public static String getQUA() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("V1_AND_MINISDK_1.83.3_0");
        if (isAbi64()) {
            str = "_ARM64";
        } else {
            str = "_RELEASE_B";
        }
        sb5.append(str);
        return sb5.toString();
    }

    public static String getRequestUA() {
        if (requestUA == null) {
            requestUA = getSystemUA() + " QQ/" + getPlatformVersionString() + " " + getPlatformQUA() + " QQ/MiniApp";
        }
        return requestUA;
    }

    public static String getSimpleDeviceInfo(Context context) {
        if (!TextUtils.isEmpty(sSimpleDeviceInfo)) {
            return sSimpleDeviceInfo;
        }
        if (context == null) {
            return "";
        }
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        sSimpleDeviceInfo = "m=" + DeviceInfoUtil.getPhoneModel() + Typography.amp + "o=" + Build.VERSION.RELEASE + Typography.amp + "a=" + Build.VERSION.SDK_INT + Typography.amp + "p=" + displayMetrics.widthPixels + '*' + displayMetrics.heightPixels + Typography.amp + "f=" + Build.MANUFACTURER + Typography.amp + "mm=" + (DeviceUtil.getSystemTotalMemory() / 1048576) + Typography.amp + "cf=" + DeviceUtil.getCpuFrequency() + Typography.amp + "cc=" + DeviceUtil.getCpuNumber() + Typography.amp + "qqversion=" + miniAppProxy.getAppVersion();
        return sSimpleDeviceInfo;
    }

    public static String getSystemUA() {
        String property;
        if (systemUA != null) {
            return systemUA;
        }
        try {
            if (VersionUtil.isKITKAT()) {
                try {
                    property = WebSettings.getDefaultUserAgent(AppLoaderFactory.g().getContext());
                } catch (Exception unused) {
                    property = System.getProperty("http.agent");
                }
            } else {
                property = System.getProperty("http.agent");
            }
            systemUA = URLEncoder.encode(property, "UTF-8");
        } catch (Throwable unused2) {
            systemUA = "AndroidQQ";
        }
        return systemUA;
    }

    public static String getWebViewUA() {
        if (TextUtils.isEmpty(mWebViewUA)) {
            mWebViewUA = getSystemUA() + " QQ/" + getPlatformVersionString() + " " + getPlatformQUA() + " MiniAppEnable miniProgram miniprogramhtmlwebview";
        }
        QMLog.d(TAG, "getWebViewUA done in " + Thread.currentThread().getName());
        return mWebViewUA;
    }

    public static boolean isAbi64() {
        return Build.CPU_ABI.equals("arm64-v8a");
    }

    public static boolean isAlienApp() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId().startsWith("2");
    }

    public static boolean isDemoApp() {
        return "demo".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }

    public static boolean isMicroApp() {
        return "ma".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }

    public static boolean isQQApp() {
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (!"qq".equals(miniAppProxy.getAppName()) && !"qi".equals(miniAppProxy.getAppName()) && !"ssq".equals(miniAppProxy.getAppName()) && !"tim".equals(miniAppProxy.getAppName())) {
            return false;
        }
        return true;
    }

    public static boolean isQQBrowseApp() {
        return "qb".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }

    public static boolean isQQMainApp() {
        return "qq".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }

    public static boolean isQQSpeedApp() {
        return "ssq".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }

    public static boolean isRdmBuild() {
        return getPlatformQUA().toLowerCase().contains("rdm");
    }

    public static boolean isTimApp() {
        return "tim".equals(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
    }
}
