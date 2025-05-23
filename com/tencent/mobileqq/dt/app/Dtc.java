package com.tencent.mobileqq.dt.app;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.channel.ChannelReport;
import com.tencent.mobileqq.dt.app.utils.d;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.fe.f;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qimei.sdk.IQimeiSDK;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qmsp.oaid2.IVendorCallback;
import com.tencent.qmsp.oaid2.VendorManager;
import cooperation.qzone.util.WiFiDash;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Dtc {
    static IPatchRedirector $redirector_ = null;
    public static final String DEVELOP_APP_KEY = "0S200H74R907V3HE";
    private static final String EMPTY = "-1";
    private static final String MMKV_ASSIST_LIST_KEY = "ASSIST-LIST-20231221";
    private static final String MMKV_ASSIST_LIST_KEY_NEW = "ASSIST-LIST-20241209";
    private static final String MMKV_ASSIST_OPENED_KEY = "ASSIST-OPENED-20231221";
    private static final String MMKV_ASSIST_OPENED_KEY_NEW = "ASSIST-OPENED-20241209";
    private static final String MMKV_ASSIST_STATUS_KEY = "ASSIST-ST-20231221";
    private static final String MMKV_FONT_LIST_KEY = "FONT-LIST-20231221";
    private static final String MMKV_LOCKGUARD_INFO_KEY = "LOCKGUARD-INFO-20231221";
    private static final String MMKV_NATIVE_FIRST = "O3FE-NATIVE_FIRST";
    private static final String MMKV_SDCARD_INFO_KEY = "SDCRAD-INFO-20231221";
    private static final String MMKV_SENSORLIST_KEY = "SensorList-20231221";
    private static final String MMKV_SIM_STATUS_KEY = "SIM-ST-20231221";
    private static final String MMKV_SYSTEM_START_TIME = "SYSTEM_STARTTIME-20240104";
    private static final String MMKV_TRUING_CACHEID = "DeviceToken-TuringCache-V001";
    private static final String MMKV_TRUING_RISKCACHEID = "TuringRiskID-TuringCache-20230511";
    private static final String MMKV_USB_STATUS_KEY = "USB-ST-20231221";
    private static final String MODULE_ALL = "1";
    private static final String MODULE_SSID = "3";
    public static final String PUBLIC_MAIN_APP_KEY = "0S200MNJT807V3GE";
    public static final String SP_NAME = "MQQ_SP_DEVICETOKEN_";
    private static final String SP_OAID_TEMP_KEY = "O3FE-OAID-20220825";
    public static String TAG;
    public static boolean mHasDoNative;
    private static boolean mHasInitDebugFlag;
    private static boolean mIsDebugVersion;
    public static String mOaid;
    private static String mQ36;
    private static int systemGetSafeTimes;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class a implements IVendorCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qmsp.oaid2.IVendorCallback
        public void onResult(boolean z16, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            com.tencent.mobileqq.fe.c.c(Dtc.TAG, 1, "oaid:" + str2);
            if (!TextUtils.isEmpty(str2)) {
                Dtc.mOaid = str2;
                try {
                    f.a().f(Dtc.SP_OAID_TEMP_KEY, str2);
                } catch (Throwable th5) {
                    com.tencent.mobileqq.fe.c.a(Dtc.TAG, 1, "mmKVSaveValue:" + th5);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12894);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = "FEKit_dtc";
        mHasDoNative = false;
        systemGetSafeTimes = 0;
        mHasInitDebugFlag = false;
        mIsDebugVersion = false;
    }

    public Dtc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void cacheDI() {
        String str;
        try {
            Context context = getContext();
            if (com.tencent.mobileqq.fe.a.INSTANCE.b()) {
                f.a().c(MMKV_SENSORLIST_KEY, formatEmpty(getSensorList(context)));
            }
            f.a().c(MMKV_USB_STATUS_KEY, getMtpMode());
            f.a().c(MMKV_SIM_STATUS_KEY, String.valueOf(hasSimCard(context)));
            f.a().c(MMKV_SDCARD_INFO_KEY, getSdcardInfo());
            f.a().c(MMKV_FONT_LIST_KEY, getSystemFont());
            f a16 = f.a();
            if (getScreenPasswordStatus(context)) {
                str = "1";
            } else {
                str = "0";
            }
            a16.c(MMKV_LOCKGUARD_INFO_KEY, str);
            f.a().c(MMKV_ASSIST_LIST_KEY, formatEmpty(getAccessibilityServiceList(context, false)));
            f.a().c(MMKV_ASSIST_OPENED_KEY, formatEmpty(getAccessibilityEnabledServiceList(context, false)));
            f.a().c(MMKV_ASSIST_STATUS_KEY, String.valueOf(getAccessibilityEnabledStatus(context)));
            f.a().c(MMKV_ASSIST_LIST_KEY_NEW, formatEmpty(getAccessibilityServiceList(context, true)));
            f.a().c(MMKV_ASSIST_OPENED_KEY_NEW, formatEmpty(getAccessibilityEnabledServiceList(context, true)));
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "exception: " + th5);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:759)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:838)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:711)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean checkAppInstalled(java.lang.String r2) {
        /*
            android.content.Context r0 = getContext()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r2 == 0) goto L15
            if (r0 != 0) goto L11
            goto L15
        L11:
            com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor.getPackageInfo(r0, r2, r1)     // Catch: java.lang.Throwable -> L15
            r1 = 1
        L15:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.dt.app.Dtc.checkAppInstalled(java.lang.String):boolean");
    }

    private static int checkRiskPermission(Context context, String str) {
        try {
            String join = TextUtils.join(",", InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 4096).requestedPermissions);
            if (!join.contains("SYSTEM_ALERT_WINDOW")) {
                if (!join.contains("SYSTEM_OVERLAY_WINDOW")) {
                    return 0;
                }
            }
            return 1;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return 0;
        }
    }

    private static String curAppKey() {
        boolean z16;
        try {
            String str = AppSetting.f99541a;
            z16 = AppSetting.class.getField("isPublicVersion").getBoolean(null);
        } catch (Throwable th5) {
            Log.e(TAG, "get AppSetting exception:" + th5);
            z16 = false;
        }
        if (z16) {
            return "0S200MNJT807V3GE";
        }
        return "0S200H74R907V3HE";
    }

    private static String formatEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            return "-1";
        }
        return str;
    }

    private static String getAccessibilityEnabledServiceList(Context context, boolean z16) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        if (context == null) {
            return "-1";
        }
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                Iterator<AccessibilityServiceInfo> it = enabledAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().getResolveInfo().serviceInfo;
                    if (z16) {
                        arrayList.add(d.b(serviceInfo.packageName) + ":" + d.b(serviceInfo.loadLabel(context.getPackageManager()).toString()) + ":" + checkRiskPermission(context, serviceInfo.packageName));
                    } else {
                        arrayList.add(d.a(serviceInfo.packageName) + ":" + d.a(serviceInfo.loadLabel(context.getPackageManager()).toString()));
                    }
                }
            }
            return arrayList.toString();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return arrayList.toString();
        }
    }

    private static int getAccessibilityEnabledStatus(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null) {
                return accessibilityManager.isEnabled() ? 1 : 0;
            }
            return -1;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return -1;
        }
    }

    private static String getAccessibilityServiceList(Context context, boolean z16) {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        if (context == null) {
            return "-1";
        }
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && (installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList()) != null) {
                Iterator<AccessibilityServiceInfo> it = installedAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().getResolveInfo().serviceInfo;
                    if (z16) {
                        arrayList.add(d.b(serviceInfo.packageName) + ":" + d.b(serviceInfo.loadLabel(context.getPackageManager()).toString()) + ":" + checkRiskPermission(context, serviceInfo.packageName));
                    } else {
                        arrayList.add(d.a(serviceInfo.packageName) + ":" + d.a(serviceInfo.loadLabel(context.getPackageManager()).toString()));
                    }
                }
            }
            return arrayList.toString();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return arrayList.toString();
        }
    }

    public static String getAndroidID() {
        try {
            String string = DeviceInfoMonitor.getString(getContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            if (TextUtils.isEmpty(string)) {
                return "-1";
            }
            return string;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "aid:" + th5);
            return "-1";
        }
    }

    public static String getApkPath(String str) {
        try {
            return getContext().getApplicationContext().getPackageResourcePath();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "oaid:" + th5);
            return "-1";
        }
    }

    public static String getAppInstallTime(String str) {
        try {
            Context context = getContext();
            return String.valueOf(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime);
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getAppInstallTime:" + th5);
            return "-1";
        }
    }

    public static String getAppVersionCode(String str) {
        try {
            Context context = getContext();
            return String.valueOf(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode);
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getAppVersionCode:" + th5);
            return "-1";
        }
    }

    public static String getAppVersionName(String str) {
        try {
            Context context = getContext();
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getAppVersionName:" + th5);
            return "-1";
        }
    }

    public static String getBSSID(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo wifiInfo = null;
            if (wifiManager == null) {
                return null;
            }
            try {
                wifiInfo = LocationMonitor.getConnectionInfo(wifiManager);
            } catch (Exception unused) {
            }
            if (wifiInfo == null) {
                return "-1";
            }
            String bssid = NetworkMonitor.getBSSID(wifiInfo);
            if (!WiFiDash.NOT_AVALIBLE.equals(bssid) && !"00:00:00:00:00:00".equals(bssid)) {
                if (!"FF:FF:FF:FF:FF:FF".equalsIgnoreCase(bssid)) {
                    return bssid;
                }
            }
            return "-1";
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "bssid:" + th5);
            return "-1";
        }
    }

    public static String getBatteryCap(String str) {
        try {
            return Double.toString(((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(getContext()), new Object[0])).doubleValue());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getBatteryCapacity:" + th5);
            return "-1";
        }
    }

    public static String getCMC(String str) {
        try {
            return String.valueOf(Camera.getNumberOfCameras());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getCMC:" + th5);
            return "-1";
        }
    }

    public static Context getContext() {
        return FEKit.getInstance().getContext();
    }

    public static String getDensity(String str) {
        try {
            return String.valueOf(getContext().getResources().getDisplayMetrics().density);
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getDensity:" + th5);
            return "-1";
        }
    }

    public static String getFontDpi(String str) {
        try {
            return String.valueOf(getContext().getResources().getDisplayMetrics().scaledDensity);
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getFontDpi:" + th5);
            return "-1";
        }
    }

    public static String getIME(String str) {
        try {
            return DeviceInfoMonitor.getString(getContext().getContentResolver(), "default_input_method");
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getIME:" + th5);
            return "-1";
        }
    }

    public static String getLibraryList(String str) {
        String str2;
        try {
            String[] systemSharedLibraryNames = getContext().getPackageManager().getSystemSharedLibraryNames();
            if (systemSharedLibraryNames == null || systemSharedLibraryNames.length <= 0) {
                str2 = "-1";
            } else {
                str2 = "-1";
                for (String str3 : systemSharedLibraryNames) {
                    str2 = (str2 + "|") + str3;
                }
            }
            Log.d("FEKit_", "value:" + str);
            return String.valueOf(str2.hashCode());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getLibraryList:" + th5);
            return "-1";
        }
    }

    private static String getMQOaid() {
        try {
            String decodeString = QMMKV.from(FEKit.getInstance().getContext(), "common_mmkv_configurations").decodeString("key_beacon_privacy_info_oaid", "");
            mOaid = decodeString;
            return decodeString;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "oaid:" + th5);
            return "-1";
        }
    }

    @SuppressLint({"PrivateApi"})
    private static String getMtpMode() {
        try {
            return (String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "sys.usb.config");
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return "-1";
        }
    }

    public static String getNetWorkInfo(String str) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return "-1";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "-2";
            }
            if (!activeNetworkInfo.isAvailable()) {
                return "-3";
            }
            if (!activeNetworkInfo.isConnected()) {
                return "-4";
            }
            if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                return "1";
            }
            return "2";
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "params:" + str + ",get networkinfo:" + th5);
            return "0";
        }
    }

    public static String getOaid() {
        try {
            if (TextUtils.isEmpty(mOaid)) {
                String g16 = f.a().g(SP_OAID_TEMP_KEY);
                mOaid = g16;
                if (TextUtils.isEmpty(g16) || "-1".equals(mOaid)) {
                    mOaid = getMQOaid();
                }
            }
            return mOaid;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "oaid:" + th5);
            return "-1";
        }
    }

    private static String getPluginBssid(Context context) {
        try {
            return getBSSID(context);
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return "-1";
        }
    }

    public static String getPluginInfo(String str) {
        String str2 = "";
        try {
            Context context = getContext();
            str2 = (((getMtpMode() + "|" + hasSimCard(context)) + "|" + formatEmpty(getAccessibilityServiceList(context, true))) + "|" + formatEmpty(getAccessibilityEnabledServiceList(context, true))) + "|" + getAccessibilityEnabledStatus(context);
            String str3 = "-1";
            if (str.contains("3") || str.contains("1")) {
                str3 = getPluginBssid(context);
            }
            return str2 + "|" + str3;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "exception: " + th5 + ",params:" + str);
            return str2;
        }
    }

    public static String getPropSafe(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, "-1");
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getPropSafe:" + th5);
            return "-1";
        }
    }

    public static String getQimei36() {
        try {
            if (!TextUtils.isEmpty(mQ36)) {
                return mQ36;
            }
            IQimeiSDK qimeiSDK = QimeiSDK.getInstance(curAppKey());
            qimeiSDK.init(getContext());
            Qimei qimei = qimeiSDK.getQimei();
            if (qimei == null) {
                return "-1";
            }
            return qimei.getQimei36();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "q36:" + th5);
            return "-1";
        }
    }

    private static boolean getScreenPasswordStatus(Context context) {
        if (context != null) {
            try {
                return ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure();
            } catch (Throwable th5) {
                com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
                return false;
            }
        }
        return false;
    }

    public static String getScreenSize(String str) {
        try {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            return "[" + displayMetrics.widthPixels + "," + displayMetrics.heightPixels + "]";
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getScreenSize:" + th5);
            return "-1";
        }
    }

    private static String getSdcardInfo() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("available", Long.valueOf(statFs.getAvailableBytes()));
            arrayMap.put("free", Long.valueOf(statFs.getFreeBytes()));
            arrayMap.put("total", Long.valueOf(statFs.getTotalBytes()));
            return arrayMap.toString();
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return "";
        }
    }

    private static String getSensorList(Context context) {
        if (context == null) {
            return "";
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            if (sensorManager == null) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            ArrayMap arrayMap = new ArrayMap();
            List<Sensor> sensorList = SensorMonitor.getSensorList(sensorManager, -1);
            if (sensorList == null) {
                return "";
            }
            for (Sensor sensor : sensorList) {
                arrayMap.put("Sensor Type", String.valueOf(sensor.getType()));
                arrayMap.put("Sensor Name", sensor.getName());
                arrayMap.put("Sensor Version", String.valueOf(sensor.getVersion()));
                arrayMap.put("Sensor Vendor", String.valueOf(sensor.getVendor()));
                arrayMap.put("Maximum Range", String.valueOf(sensor.getMaximumRange()));
                arrayMap.put("Minimum Delay", String.valueOf(sensor.getMinDelay()));
                arrayMap.put("Power", String.valueOf(sensor.getPower()));
                arrayMap.put("Resolution", String.valueOf(sensor.getResolution()));
                arrayList.add(arrayMap.toString());
                arrayMap.clear();
            }
            return com.tencent.mobileqq.qsec.qsecest.c.a(arrayList.toString());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
            return "";
        }
    }

    public static String getStorage(String str) {
        try {
            return String.valueOf(Environment.getDataDirectory().getTotalSpace());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "getStorage:" + th5);
            return "-1";
        }
    }

    public static String getSystemFont() {
        try {
            List<String> systemFontList = getSystemFontList();
            if (systemFontList != null && systemFontList.size() > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Iterator<String> it = systemFontList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                if (!TextUtils.isEmpty(stringBuffer)) {
                    return com.tencent.mobileqq.qsec.qsecest.c.a(stringBuffer.toString());
                }
            }
            return "CK_N";
        } catch (Throwable unused) {
            return "CK_PE";
        }
    }

    private static List<String> getSystemFontList() {
        return null;
    }

    public static String getSystemStartTime() {
        return String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
    }

    public static String getUUID(String str) {
        try {
            Context context = getContext();
            String g16 = f.a().g(str);
            if ((TextUtils.isEmpty(g16) || "-1".equals(g16)) && context != null) {
                g16 = context.getSharedPreferences(SP_NAME, 4).getString(str, "");
                if (!TextUtils.isEmpty(g16)) {
                    f.a().f(str, g16);
                }
            }
            if (TextUtils.isEmpty(g16) || "-1".equals(g16)) {
                String str2 = UUID.randomUUID().toString() + "|" + getAppVersionName("app_version_name");
                f.a().f(str, str2);
                return str2;
            }
            return g16;
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "uuid:" + th5);
            return "-1";
        }
    }

    public static String getUid(String str) {
        try {
            return String.valueOf(Process.myUid());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "get uid:" + th5 + ",params:" + str);
            return "-1";
        }
    }

    private static String getWvID() {
        return "-1";
    }

    public static boolean hasDoItOnceDaily(String str) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return true;
            }
            String format = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
            String str2 = str + "|check";
            if (TextUtils.equals(f.a().h(str2), format)) {
                return true;
            }
            f.a().c(str2, format);
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public static int hasSimCard(Context context) {
        int i3 = -1;
        if (context == null) {
            return -1;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            try {
                int simState = telephonyManager.getSimState();
                if (simState != 0 && simState != 1) {
                    return 1;
                }
                return 0;
            } catch (Throwable th5) {
                th = th5;
                i3 = 1;
                com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th);
                return i3;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void initOAIDAsync(Context context) {
        String oaid = getOaid();
        if (!TextUtils.isEmpty(oaid) && !"-1".equals(oaid)) {
            return;
        }
        try {
            new VendorManager().getVendorInfo(context, new a());
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "oaid:" + th5);
        }
    }

    public static boolean isDebugVersion() {
        if (!mHasInitDebugFlag) {
            try {
                String str = AppSetting.f99541a;
                mIsDebugVersion = AppSetting.class.getField("isDebugVersion").getBoolean(null);
                mHasInitDebugFlag = true;
            } catch (Throwable th5) {
                mHasInitDebugFlag = true;
                Log.e(TAG, "get AppSetting exception:" + th5);
            }
        }
        return mIsDebugVersion;
    }

    public static boolean isMsfConnected() {
        try {
            return MsfService.getCore().isConnected();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void mmKVQsecSaveValue(String str, String str2) {
        f.a().c(str, str2);
    }

    public static void mmKVSaveValue(String str, String str2) {
        f.a().f(str, str2);
    }

    public static String mmKVValue(String str) {
        return f.a().g(str);
    }

    public static String mmQsecKVValue(String str) {
        return f.a().h(str);
    }

    public static byte[] mmQsecKVValueBytes(String str) {
        return f.a().i(str);
    }

    public static String mmkvQsecAllKeys(String str) {
        return f.a().j();
    }

    public static String mmkvQsecDeleteKeys(String str) {
        f.a().k(str);
        return "";
    }

    public static void retportAccessibilityServiceList(Context context) {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList;
        if (!ChannelReport.isReportOnceOfDay("reportAccessbility0805") || context == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && (installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList()) != null) {
                Iterator<AccessibilityServiceInfo> it = installedAccessibilityServiceList.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().getResolveInfo().serviceInfo;
                    arrayList.add(d.a(serviceInfo.packageName) + ":" + d.a(serviceInfo.loadLabel(context.getPackageManager()).toString()) + ":" + com.tencent.mobileqq.dt.app.utils.a.a(serviceInfo.applicationInfo.loadIcon(context.getPackageManager())) + ":" + com.tencent.mobileqq.dt.app.utils.c.a(serviceInfo.applicationInfo.sourceDir) + ":" + com.tencent.mobileqq.dt.app.utils.c.e(serviceInfo.applicationInfo.sourceDir));
                }
            }
            ChannelReport.getInstance().commonReport("02f00075617", "assist_list", new String[]{arrayList.toString()});
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "error! " + th5);
        }
    }

    public static void saveList(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        try {
            if (!mHasDoNative) {
                mHasDoNative = true;
                getContext();
                if (!TextUtils.isEmpty(str)) {
                    f.a().f(str, DeviceInfoMonitor.getModel());
                }
                if (!TextUtils.isEmpty(str2)) {
                    f.a().f(str2, getAndroidID());
                }
                if (!TextUtils.isEmpty(str3)) {
                    f.a().f(str3, getQimei36());
                }
                if (!TextUtils.isEmpty(str4)) {
                    f.a().f(str4, getOaid());
                }
                if (!TextUtils.isEmpty(str5)) {
                    f.a().f(str5, getWvID());
                }
                if (!TextUtils.isEmpty(str7)) {
                    getUUID(str7);
                }
                cacheDI();
                f.a().c(MMKV_SYSTEM_START_TIME, getSystemStartTime());
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "saveList:" + th5);
        }
    }

    public static void setQ36(String str) {
        mQ36 = str;
    }

    public static String systemGetSafe(String str) {
        try {
            return System.getProperty(str, "-1");
        } catch (Throwable th5) {
            com.tencent.mobileqq.fe.c.a(TAG, 1, "systemGetSafe:" + th5);
            return "-1";
        }
    }

    public static void mmKVQsecSaveValue(String str, byte[] bArr) {
        f.a().d(str, bArr);
    }

    public static void init(Context context, String str) {
    }
}
