package com.tencent.ams.adcore.mma.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceInfoUtil {
    static IPatchRedirector $redirector_;
    private static String appname;
    private static HashMap<String, String> deviceUniqueData;
    private static String packageName;
    private static String resolution;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55807);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            deviceUniqueData = new HashMap<>();
        }
    }

    public DeviceInfoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String encryp(int i3, String str, String str2) {
        if (i3 == 1) {
            return CommonUtil.md5(str + str2);
        }
        if (i3 == 2) {
            return CommonUtil.md5(CommonUtil.md5(str) + str2);
        }
        return CommonUtil.md5(str);
    }

    public static Map<String, String> fulfillTrackingInfo(Context context) {
        String str;
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        hashMap.put(Global.TRACKING_OS_VERION, getOSVersion());
        hashMap.put(Global.TRACKING_TERM, getDevice());
        if (!isWifi(context)) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put(Global.TRACKING_WIFI, str);
        hashMap.put(Global.TRACKING_NAME, getAppName(context));
        hashMap.put(Global.TRACKING_KEY, getPackageName(context));
        hashMap.put(Global.TRACKING_OS_VERION, getOSVersion());
        hashMap.put(Global.TRACKING_OS, "0");
        hashMap.put(Global.TRACKING_SCWH, getResolution(context));
        hashMap.put(Global.TRACKING_SDKVS, Global.TRACKING_SDKVS_VALUE);
        return hashMap;
    }

    private static String getAndroidId(Context context, String str, int i3) {
        String str2;
        String str3 = str + i3 + "androidId";
        String str4 = deviceUniqueData.get(str3);
        if (str4 != null) {
            return str4;
        }
        try {
            String androidId = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getAndroidId();
            if (!TextUtils.isEmpty(androidId) && !"9774d56d682e549c".equals(androidId) && androidId.length() >= 15) {
                str2 = encryp(i3, androidId, str);
            } else {
                str2 = "";
            }
            str4 = str2;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        deviceUniqueData.put(str3, str4);
        return str4;
    }

    public static String getAppName(Context context) {
        String str = appname;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.loadLabel(packageManager) != null) {
                appname = applicationInfo.loadLabel(packageManager).toString();
            }
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        return appname;
    }

    public static String getDevice() {
        return ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel();
    }

    private static String getImei(Context context, String str, int i3) {
        String str2 = "";
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String str3 = str + i3 + "imei";
        String str4 = deviceUniqueData.get(str3);
        if (str4 != null) {
            return str4;
        }
        try {
            str4 = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getDeviceId();
            if (!TextUtils.isEmpty(str4)) {
                str4 = encryp(i3, str4, str);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (str4 != null) {
            str2 = str4;
        }
        deviceUniqueData.put(str3, str2);
        return str2;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPackageName(Context context) {
        if (packageName == null && context != null) {
            packageName = context.getPackageName();
        }
        return packageName;
    }

    public static String getResolution(Context context) {
        String str = resolution;
        if (str != null) {
            return str;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            resolution = "";
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                resolution = displayMetrics.widthPixels + HippyTKDListViewAdapter.X + displayMetrics.heightPixels;
            }
        }
        return resolution;
    }

    public static HashMap<String, String> getUniqueData(Context context, String str, int i3) {
        HashMap<String, String> hashMap = new HashMap<>(3);
        hashMap.put(Global.TRACKING_IMEI, getImei(context, str, i3));
        hashMap.put(Global.TRACKING_ANDROIDID, getAndroidId(context, str, i3));
        return hashMap;
    }

    public static boolean isWifi(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return false;
        }
        return true;
    }
}
