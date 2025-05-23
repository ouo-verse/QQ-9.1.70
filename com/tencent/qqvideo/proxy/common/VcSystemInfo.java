package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;

/* compiled from: P */
/* loaded from: classes34.dex */
public class VcSystemInfo {
    public static final int CHIP_ARM_LATER = 50;
    public static final int CHIP_ARM_V5 = 3;
    public static final int CHIP_ARM_V6 = 4;
    public static final int CHIP_ARM_V7_NENO = 6;
    public static final int CHIP_ARM_V7_NO_NENO = 5;
    public static final int CHIP_MIPS = 2;
    public static final int CHIP_UNKNOW = 0;
    public static final int CHIP_X86 = 1;
    public static final int NETWORK_AP_3G = 2;
    public static final int NETWORK_AP_GPRS = 3;
    public static final int NETWORK_AP_LINE = 4;
    public static final int NETWORK_AP_WIFI = 1;
    public static final int NETWORK_CLASS_2_G = 2;
    public static final int NETWORK_CLASS_3_G = 3;
    public static final int NETWORK_CLASS_4_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_NONE = 0;
    private static final int NETWORK_TYPE_1xRTT = 7;
    private static final int NETWORK_TYPE_CDMA = 4;
    private static final int NETWORK_TYPE_EDGE = 2;
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_0 = 5;
    private static final int NETWORK_TYPE_EVDO_A = 6;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_GPRS = 1;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final int NETWORK_TYPE_UMTS = 3;
    public static final int PLAYER_LEVEL_1 = 1;
    public static final int PLAYER_LEVEL_11 = 11;
    public static final int PLAYER_LEVEL_16 = 16;
    public static final int PLAYER_LEVEL_21 = 21;
    public static final int PLAYER_LEVEL_26 = 26;
    public static final int PLAYER_LEVEL_6 = 6;
    private static final String TAG = "VcSystemInfo";
    public static final int TYPE_CMNET = 2;
    public static final int TYPE_CMWAP = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_OTHER = 4;
    public static final int TYPE_WIFI = 1;
    private static int appVersionCode = 0;
    private static String appVersionName = null;
    private static String deviceID = "";
    private static String deviceIMSI = null;
    private static String deviceMacAddr = null;
    public static int mCpuArchitecture = 0;
    public static String mCpuHardware = "";
    private static int mDeviceLevel = 0;
    public static String mFeature = "";
    private static int mMCC = 0;
    private static int mMNC = 0;
    public static String mProcessorName = "N/A";
    public static int mScreenHeight;
    public static int mScreenWidth;
    private long mLastCpu;
    private long mLastIdle;
    public int mdispHeight;
    public int mdispWidth;
    public long mMaxCpuFreq = 0;
    public int mCoreNumber = 1;
    public long mCurrCpuFreq = 0;

    public VcSystemInfo() {
        mScreenWidth = 320;
        mScreenHeight = 480;
        this.mdispWidth = 320;
        this.mdispHeight = 240;
        this.mLastCpu = 0L;
        this.mLastIdle = 0L;
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getAppVersionCode(Context context, String str) {
        int i3 = appVersionCode;
        if (i3 != 0) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        try {
            int i16 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0).versionCode;
            appVersionCode = i16;
            return i16;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getAppVersionName(Context context) {
        if (!TextUtils.isEmpty(appVersionName)) {
            return appVersionName;
        }
        if (context == null) {
            return "";
        }
        try {
            String str = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            appVersionName = str;
            return str == null ? "" : str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceID(Context context) {
        if (!TextUtils.isEmpty(deviceID)) {
            return deviceID;
        }
        if (context == null) {
            return "";
        }
        try {
            String stringSystem = DeviceInfoMonitor.getStringSystem(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            deviceID = stringSystem;
            if (stringSystem == null) {
                deviceID = "";
            }
        } catch (Throwable unused) {
            deviceID = "";
        }
        return deviceID;
    }

    public static String getDeviceIMSI(Context context) {
        if (!TextUtils.isEmpty(deviceIMSI)) {
            return deviceIMSI;
        }
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String subscriberId = DeviceInfoMonitor.getSubscriberId(telephonyManager);
                deviceIMSI = subscriberId;
                if (subscriberId == null) {
                    deviceIMSI = "";
                }
                return deviceIMSI;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getDeviceMacAddr(Context context) {
        WifiInfo connectionInfo;
        if (!TextUtils.isEmpty(deviceMacAddr)) {
            return deviceMacAddr;
        }
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = LocationMonitor.getConnectionInfo(wifiManager)) != null) {
                String macAddress = NetworkMonitor.getMacAddress(connectionInfo);
                deviceMacAddr = macAddress;
                if (macAddress == null) {
                    deviceMacAddr = "";
                }
                return deviceMacAddr;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int getMCC(Context context) {
        int i3 = mMCC;
        if (i3 != 0) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                mMCC = configuration.mcc;
            }
            return mMCC;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int getMNC(Context context) {
        int i3 = mMNC;
        if (i3 != 0) {
            return i3;
        }
        if (context == null) {
            return 0;
        }
        try {
            Configuration configuration = context.getResources().getConfiguration();
            if (configuration != null) {
                mMNC = configuration.mnc;
            }
            return mMNC;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int getNetworkClass(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
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
                return 4;
            default:
                return 0;
        }
    }

    public static int getOsVerInt() {
        return 0;
    }

    public static int getOsVerIntFromVerStr() {
        String osVersion = getOsVersion();
        int osVerInt = getOsVerInt();
        if (osVersion.length() < 3) {
            return osVerInt;
        }
        try {
            int parseInt = Integer.parseInt(osVersion.substring(0, 1));
            int parseInt2 = Integer.parseInt(osVersion.substring(2, 3));
            if (parseInt == 2) {
                if (parseInt2 == 3) {
                    return 9;
                }
                return osVerInt;
            }
            if (parseInt != 4) {
                return osVerInt;
            }
            if (parseInt2 == 0) {
                return 14;
            }
            if (parseInt2 == 1) {
                return 16;
            }
            if (parseInt2 == 2) {
                return 17;
            }
            if (parseInt2 == 3) {
                return 18;
            }
            if (parseInt2 != 4) {
                return osVerInt;
            }
            return 19;
        } catch (Exception unused) {
            return osVerInt;
        }
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getRomInfo() {
        return Build.VERSION.INCREMENTAL;
    }

    public static int getSystemCpuUsage(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        float f16 = -1.0f;
        try {
            String[] split = str.trim().split("\\s+");
            long systemIdleTime = getSystemIdleTime(split);
            long systemUptime = getSystemUptime(split);
            String[] split2 = str2.trim().split("\\s+");
            long systemIdleTime2 = getSystemIdleTime(split2);
            long systemUptime2 = getSystemUptime(split2);
            if (systemIdleTime >= 0 && systemUptime >= 0 && systemIdleTime2 >= 0 && systemUptime2 >= 0) {
                long j3 = systemIdleTime2 + systemUptime2;
                long j16 = systemIdleTime + systemUptime;
                if (j3 > j16 && systemUptime2 >= systemUptime) {
                    f16 = (((float) (systemUptime2 - systemUptime)) / ((float) (j3 - j16))) * 100.0f;
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return (int) f16;
    }

    public static String getWiFiMacAddress(Context context) {
        try {
            return NetworkMonitor.getMacAddress(LocationMonitor.getConnectionInfo((WifiManager) context.getSystemService("wifi")));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getNetworkClass(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || NetworkMonitor.getType(activeNetworkInfo) != 0) {
            return 0;
        }
        return getNetworkClass(NetworkMonitor.getSubtype(activeNetworkInfo));
    }

    public static long getSystemIdleTime(String[] strArr) {
        try {
            return Long.parseLong(strArr[4]);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String readSystemStat() {
        RandomAccessFile randomAccessFile;
        String str = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
                try {
                    str = randomAccessFile.readLine();
                    randomAccessFile.close();
                } catch (Throwable unused) {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                }
            } catch (Throwable unused2) {
                randomAccessFile = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return str;
    }

    public static long getSystemUptime(String[] strArr) {
        long j3 = 0;
        for (int i3 = 1; i3 < strArr.length; i3++) {
            if (4 != i3) {
                try {
                    j3 += Long.parseLong(strArr[i3]);
                } catch (Throwable unused) {
                    return -1L;
                }
            }
        }
        return j3;
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) ? false : true;
    }

    public static int GetNetAP(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 0;
        }
        return "wifi".equalsIgnoreCase(NetworkMonitor.getTypeName(activeNetworkInfo)) ? 1 : 2;
    }

    public static String PrintStack(Throwable th5) {
        if (th5 == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                th5.printStackTrace();
                th5.printStackTrace(new PrintStream(byteArrayOutputStream));
                byteArrayOutputStream.close();
            } catch (Throwable th6) {
                byteArrayOutputStream.close();
                throw th6;
            }
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toString();
    }

    public static int getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo;
        int i3 = 0;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                return type != 1 ? 4 : 1;
            }
            i3 = 2;
            if (NetworkMonitor.netGetExInfo(activeNetworkInfo) != null) {
                return !"cmnet".equalsIgnoreCase(NetworkMonitor.netGetExInfo(activeNetworkInfo)) ? 3 : 2;
            }
            return 2;
        } catch (Exception unused) {
            return i3;
        }
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int i3 = mScreenHeight;
        if (i3 != 0) {
            return i3;
        }
        try {
            mScreenHeight = context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable unused) {
        }
        return mScreenHeight;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        int i3 = mScreenWidth;
        if (i3 != 0) {
            return i3;
        }
        try {
            mScreenWidth = context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return mScreenWidth;
    }

    public static int getWifiNetStrength(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) context.getSystemService("wifi"));
            if (connectionInfo == null) {
                return 0;
            }
            connectionInfo.getRssi();
            return WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 101);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean isNetworkTypeMobile(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        int type;
        return context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (type = NetworkMonitor.getType(activeNetworkInfo)) == 0 || type == 2 || type == 3 || type == 4 || type == 5;
    }

    public static long getAppInstallTime(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r2 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getMarketId(Context context) {
        BufferedReader bufferedReader;
        int i3 = -1;
        if (context == null) {
            return -1;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream open = context.getApplicationContext().getAssets().open("channel.ini");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(open));
                    try {
                        String readLine = bufferedReader.readLine();
                        if (!TextUtils.isEmpty(readLine) && readLine.contains("CHANNEL=")) {
                            String substring = readLine.substring(readLine.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                            if (!TextUtils.isEmpty(substring)) {
                                i3 = Integer.parseInt(substring.trim());
                            }
                        }
                        if (open != null) {
                            open.close();
                        }
                    } catch (Throwable unused) {
                        inputStream = open;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                } catch (Throwable unused2) {
                    bufferedReader = null;
                }
            } catch (Throwable unused3) {
                bufferedReader = null;
            }
            bufferedReader.close();
        } catch (Throwable unused4) {
        }
        return i3;
    }

    public static long getRxBytesFromNetwork(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            context.getClassLoader().loadClass("android.net.TrafficStats");
            return TrafficStats.getTotalRxBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
