package com.tencent.liteav.base.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Debug;
import android.os.Process;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class LiteavSystemInfo {
    private static final int APP_SYSTEM_METHOD_DEFAULT_GET_INTERVAL_MS = 1000;
    private static final String EXT_KEY_APP_BACKGROUND = "isAppBackground";
    private static final String EXT_KEY_APP_NAME = "appName";
    private static final String EXT_KEY_APP_PACKAGE_NAME = "appPackageName";
    private static final String EXT_KEY_APP_VERSION = "appVersion";
    private static final String EXT_KEY_BUILD_BOARD = "buildBoard";
    private static final String EXT_KEY_BUILD_BRAND = "buildBrand";
    private static final String EXT_KEY_BUILD_HARDWARE = "buildHardware";
    private static final String EXT_KEY_BUILD_MANUFACTURER = "buildManufacturer";
    private static final String EXT_KEY_BUILD_MODEL = "buildModel";
    private static final String EXT_KEY_BUILD_VERSION = "buildVersion";
    private static final String EXT_KEY_BUILD_VERSION_INT = "buildVersionInt";
    private static final int GET_APP_MEMORY_INTERVAL_MS = 15000;
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NETWORK_TYPE_WIRED = 5;
    private static final String TAG = "LiteavBaseSystemInfo";
    private static final com.tencent.liteav.base.util.p<String> sModel = new com.tencent.liteav.base.util.p<>(j.a());
    private static final com.tencent.liteav.base.util.p<String> sBrand = new com.tencent.liteav.base.util.p<>(k.a());
    private static final com.tencent.liteav.base.util.p<String> sManufacturer = new com.tencent.liteav.base.util.p<>(l.a());
    private static final com.tencent.liteav.base.util.p<String> sHardware = new com.tencent.liteav.base.util.p<>(m.a());
    private static final com.tencent.liteav.base.util.p<String> sSystemOSVersion = new com.tencent.liteav.base.util.p<>(n.a());
    private static final com.tencent.liteav.base.util.p<Integer> sSystemOSVersionInt = new com.tencent.liteav.base.util.p<>(o.a());
    private static final com.tencent.liteav.base.util.p<String> sBoard = new com.tencent.liteav.base.util.p<>(p.a());
    private static final com.tencent.liteav.base.util.p<String> sAppPackageName = new com.tencent.liteav.base.util.p<>(d.a());
    private static final com.tencent.liteav.base.util.p<String> sAppName = new com.tencent.liteav.base.util.p<>(e.a());
    private static final com.tencent.liteav.base.util.p<String> sAppVersion = new com.tencent.liteav.base.util.p<>(f.a());
    private static final com.tencent.liteav.base.util.p<String> sUUID = new com.tencent.liteav.base.util.p<>(g.a());
    private static final com.tencent.liteav.base.util.p<String[]> sCpuABIs = new com.tencent.liteav.base.util.p<>(h.a());
    private static AtomicBoolean sIsGettingMemoryUsage = new AtomicBoolean(false);
    private static AtomicInteger sLastMemoryUsage = new AtomicInteger(0);
    private static final com.tencent.liteav.base.b.a sMemoryUsageThrottler = new com.tencent.liteav.base.b.a(15000);
    private static int sLastNetworkType = 0;
    private static final com.tencent.liteav.base.b.a sNetworkTypeThrottler = new com.tencent.liteav.base.b.a(1000);
    private static int sLastGateway = 0;
    private static final com.tencent.liteav.base.b.a sGatewayThrottler = new com.tencent.liteav.base.b.a(1000);
    private static boolean sLastMicPermission = false;
    private static final com.tencent.liteav.base.b.a sMicPermissionThrottler = new com.tencent.liteav.base.b.a(1000);

    public static synchronized int getAppBackgroundState() {
        boolean b16;
        synchronized (LiteavSystemInfo.class) {
            b16 = com.tencent.liteav.base.util.i.a().b();
        }
        if (b16) {
            return 1;
        }
        return 0;
    }

    public static synchronized int getAppMemoryUsage() {
        int i3;
        synchronized (LiteavSystemInfo.class) {
            if (sMemoryUsageThrottler.a()) {
                getAppMemoryUsageFromSystem();
            }
            i3 = sLastMemoryUsage.get();
        }
        return i3;
    }

    private static void getAppMemoryUsageFromSystem() {
        if (sIsGettingMemoryUsage.get()) {
            return;
        }
        sIsGettingMemoryUsage.set(true);
        AsyncTask.execute(c.a());
    }

    public static String getAppName() {
        return sAppName.a();
    }

    public static String getAppPackageName() {
        return sAppPackageName.a();
    }

    public static synchronized int getAppThreadSize() {
        int activeCount;
        synchronized (LiteavSystemInfo.class) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            activeCount = threadGroup.activeCount();
        }
        return activeCount;
    }

    public static String getAppVersion() {
        return sAppVersion.a();
    }

    public static synchronized boolean getAudioRecordPermission() {
        boolean z16;
        synchronized (LiteavSystemInfo.class) {
            if (sMicPermissionThrottler.a()) {
                sLastMicPermission = getAudioRecordPermissionFromSystem();
            }
            z16 = sLastMicPermission;
        }
        return z16;
    }

    private static boolean getAudioRecordPermissionFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || applicationContext.checkPermission(QQPermissionConstants.Permission.RECORD_AUDIO, Process.myPid(), Process.myUid()) != 0) {
            return false;
        }
        return true;
    }

    public static String getBoard() {
        return sBoard.a();
    }

    public static String getBrand() {
        return sBrand.a();
    }

    public static String getDeviceUuid() {
        return sUUID.a();
    }

    public static synchronized int getGateway() {
        int i3;
        synchronized (LiteavSystemInfo.class) {
            if (sGatewayThrottler.a()) {
                sLastGateway = getGatewayFromSystem();
            }
            i3 = sLastGateway;
        }
        return i3;
    }

    private static int getGatewayFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        try {
            return NetworkMonitor.getDhcpInfo((WifiManager) applicationContext.getSystemService("wifi")).gateway;
        } catch (Throwable th5) {
            Log.e(TAG, "getGateway error " + th5.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static String getHardware() {
        return sHardware.a();
    }

    public static String getManufacturer() {
        return sManufacturer.a();
    }

    public static String getModel() {
        return sModel.a();
    }

    public static synchronized int getNetworkType() {
        int i3;
        synchronized (LiteavSystemInfo.class) {
            if (sNetworkTypeThrottler.a()) {
                sLastNetworkType = getNetworkTypeFromSystem();
            }
            i3 = sLastNetworkType;
        }
        return i3;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x004d. Please report as an issue. */
    private static int getNetworkTypeFromSystem() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        TelephonyManager telephonyManager;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        if (NetworkMonitor.getType(networkInfo) == 9) {
            return 5;
        }
        if (NetworkMonitor.getType(networkInfo) == 1) {
            return 1;
        }
        if (NetworkMonitor.getType(networkInfo) != 0) {
            return 0;
        }
        try {
            telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
        } catch (Exception unused2) {
        }
        if (telephonyManager == null) {
            return 0;
        }
        int networkType = NetworkMonitor.getNetworkType(telephonyManager);
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 2;
            default:
                if (getSystemOSVersionInt() < 29 || networkType != 20) {
                    return 2;
                }
                return 6;
        }
    }

    public static synchronized String getProperty(String str) {
        String str2;
        synchronized (LiteavSystemInfo.class) {
            try {
                str2 = System.getProperty(str);
            } catch (Throwable th5) {
                th = th5;
                str2 = null;
            }
            try {
                Log.i(TAG, "Get " + str + " property is " + str2, new Object[0]);
            } catch (Throwable th6) {
                th = th6;
                Log.e(TAG, "Get property failed. ".concat(String.valueOf(th)), new Object[0]);
                return str2;
            }
        }
        return str2;
    }

    public static int[] getScreenSizeInPixels() {
        int[] iArr = {0, 0};
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "Context is null.", new Object[0]);
            return iArr;
        }
        try {
            WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
            if (windowManager == null) {
                Log.e(TAG, "WindowManager is null.", new Object[0]);
                return iArr;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            iArr[1] = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            return iArr;
        } catch (Throwable th5) {
            Log.e(TAG, "Get display from window service failed. ".concat(String.valueOf(th5)), new Object[0]);
            return iArr;
        }
    }

    public static String[] getSupportABIs() {
        return sCpuABIs.a();
    }

    public static String getSystemOSVersion() {
        return sSystemOSVersion.a();
    }

    public static int getSystemOSVersionInt() {
        return sSystemOSVersionInt.a().intValue();
    }

    public static synchronized String getSystemProperty(String str) {
        String str2;
        synchronized (LiteavSystemInfo.class) {
            str2 = null;
            try {
                Object invoke = SystemProperties.class.getMethod("get", String.class).invoke(null, str);
                if (invoke != null) {
                    String str3 = (String) invoke;
                    try {
                        Log.i(TAG, "Get " + str + " property is " + str3, new Object[0]);
                        str2 = str3;
                    } catch (Throwable th5) {
                        th = th5;
                        str2 = str3;
                        Log.e(TAG, "Get system property failed. ".concat(String.valueOf(th)), new Object[0]);
                        return str2;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getAppMemoryUsageFromSystem$9() {
        int i3;
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            i3 = memoryInfo.getTotalPss();
        } catch (Exception e16) {
            Log.e(TAG, "Get App memory usage failed." + e16.getMessage(), new Object[0]);
            i3 = 0;
        }
        sLastMemoryUsage.set(i3 / 1024);
        sIsGettingMemoryUsage.set(false);
    }

    public static synchronized void listenAppBackgroundState() {
        synchronized (LiteavSystemInfo.class) {
            com.tencent.liteav.base.util.i.a().a(i.a());
        }
    }

    private static native void nativeOnAppBackgroundStateChanged(int i3);

    public static void onAppBackgroundStateChanged(boolean z16) {
        nativeOnAppBackgroundStateChanged(z16 ? 1 : 0);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x00a9. Please report as an issue. */
    public static boolean setExtID(String str, String str2) {
        boolean z16;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -1978299099:
                    if (str.equals(EXT_KEY_APP_BACKGROUND)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (str.equals(EXT_KEY_BUILD_VERSION)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -794136500:
                    if (str.equals("appName")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -589756065:
                    if (str.equals(EXT_KEY_BUILD_MANUFACTURER)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case -497349352:
                    if (str.equals(EXT_KEY_BUILD_BOARD)) {
                        c16 = 4;
                        break;
                    }
                    break;
                case -497260103:
                    if (str.equals(EXT_KEY_BUILD_BRAND)) {
                        c16 = 5;
                        break;
                    }
                    break;
                case -487188133:
                    if (str.equals(EXT_KEY_BUILD_MODEL)) {
                        c16 = 6;
                        break;
                    }
                    break;
                case -441921776:
                    if (str.equals("appPackageName")) {
                        c16 = 7;
                        break;
                    }
                    break;
                case -391134602:
                    if (str.equals(EXT_KEY_BUILD_HARDWARE)) {
                        c16 = '\b';
                        break;
                    }
                    break;
                case 725329157:
                    if (str.equals(EXT_KEY_BUILD_VERSION_INT)) {
                        c16 = '\t';
                        break;
                    }
                    break;
                case 1484112759:
                    if (str.equals("appVersion")) {
                        c16 = '\n';
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    try {
                        if (Integer.parseInt(str2) == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        com.tencent.liteav.base.util.i.a(z16);
                        return true;
                    } catch (Exception e16) {
                        Log.e(TAG, "set app background state failed. ".concat(String.valueOf(e16)), new Object[0]);
                        break;
                    }
                case 1:
                    sSystemOSVersion.a(str2);
                    return true;
                case 2:
                    sAppName.a(str2);
                    return true;
                case 3:
                    sManufacturer.a(str2);
                    return true;
                case 4:
                    sBoard.a(str2);
                    return true;
                case 5:
                    sBrand.a(str2);
                    return true;
                case 6:
                    sModel.a(str2);
                    return true;
                case 7:
                    sAppPackageName.a(str2);
                    return true;
                case '\b':
                    sHardware.a(str2);
                    return true;
                case '\t':
                    try {
                        sSystemOSVersionInt.a(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    return true;
                case '\n':
                    sAppVersion.a(str2);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
