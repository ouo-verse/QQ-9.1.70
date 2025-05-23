package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes26.dex */
public class GlobalUtil {
    public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";
    public static final int DEF_INT = 0;
    public static final String DEF_STRING = "empty";
    protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
    protected static final String TAG = "GlobalUtil";
    protected static final String UN_DEFINED = "NA";
    protected static String mDevicedId = "";
    protected static GlobalUtil mInstance = null;
    protected static int mMemUUID = 0;
    private static String mQImei = "";
    private static String mQadid = "";
    private static long sUin;
    protected Context mContext;
    public static ThreadLocal<SimpleDateFormat> yyyyMMddTimeFormat = new b();
    public static ThreadLocal<SimpleDateFormat> yyyyMMddHHTimeFormat = new c();
    public String mQUA = "";
    private String mMACAdress = null;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.a(GlobalUtil.this.mContext);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b extends ThreadLocal<SimpleDateFormat> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(DateUtil.DATE_FORMAT_8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends ThreadLocal<SimpleDateFormat> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHH");
        }
    }

    protected GlobalUtil() {
        try {
            r.b(TAG, "isMIUI:" + isMIUI());
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<String> String2List(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0011. Please report as an issue. */
    public static int assistantErrorCode2SDKErrorCode(int i3) {
        if (i3 != -1000) {
            if (i3 != -16) {
                if (i3 != -15) {
                    if (i3 != -1) {
                        if (i3 != 0) {
                            switch (i3) {
                                case -28:
                                    return 701;
                                case -27:
                                    return 606;
                                case -26:
                                case -24:
                                    break;
                                case -25:
                                    return 602;
                                case -23:
                                    return 601;
                                case -22:
                                    return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
                                case -21:
                                    return 700;
                                default:
                                    switch (i3) {
                                        case -13:
                                            return 703;
                                        case -12:
                                            return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
                                        case -11:
                                            return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_HOOK;
                                    }
                            }
                        } else {
                            return 0;
                        }
                    } else {
                        return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_REDIRECT_TOO_MANY_TIMES;
                    }
                } else {
                    return 1;
                }
            } else {
                return TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY;
            }
        }
        return 604;
    }

    public static int assistantState2SDKState(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 3;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return 4;
            }
            if (i3 == 6) {
                return 1;
            }
            if (i3 == 9) {
                return 6;
            }
            return 0;
        }
        return 5;
    }

    public static String calcMD5AsString(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.reset();
                messageDigest.update(bytes, 0, bytes.length);
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b16 : digest) {
                    stringBuffer.append(Integer.toHexString(b16 & 255));
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    public static void deleteOldDB(String str) {
        if (getInstance().getContext() != null) {
            File databasePath = getInstance().getContext().getDatabasePath(str);
            if (databasePath.exists()) {
                try {
                    databasePath.delete();
                    r.b(TAG, "deleteDB");
                } catch (Exception unused) {
                    r.b(TAG, "deleteDB failed");
                }
            }
        }
    }

    private String filter(String str) {
        return String.valueOf(o.a(str));
    }

    public static String getAppPackageName(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        return "";
    }

    public static int getAppVersionCode(Context context) {
        if (context != null) {
            try {
                return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static String getCurrentDay() {
        return yyyyMMddTimeFormat.get().format(new Date());
    }

    public static String getDay(long j3) {
        return yyyyMMddTimeFormat.get().format(new Date(j3));
    }

    public static String getDayAndHour(long j3) {
        return yyyyMMddHHTimeFormat.get().format(new Date(j3));
    }

    public static synchronized GlobalUtil getInstance() {
        GlobalUtil globalUtil;
        synchronized (GlobalUtil.class) {
            if (mInstance == null) {
                mInstance = new GlobalUtil();
            }
            globalUtil = mInstance;
        }
        return globalUtil;
    }

    public static int getInt(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private String getMacAddressNew() {
        return null;
    }

    private String getMacAddressOld() {
        return "";
    }

    public static synchronized int getMemUUID() {
        int i3;
        synchronized (GlobalUtil.class) {
            i3 = mMemUUID;
            mMemUUID = i3 + 1;
        }
        return i3;
    }

    public static synchronized String getNetStatus() {
        NetworkInfo networkInfo;
        synchronized (GlobalUtil.class) {
            Context context = getInstance().getContext();
            if (context == null) {
                return "";
            }
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                    return "";
                }
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e16) {
                    r.a(TAG, e16.getMessage());
                    networkInfo = null;
                }
                if (networkInfo == null) {
                    return "";
                }
                if (NetworkMonitor.getType(networkInfo) == 1) {
                    return "wifi";
                }
                String netGetExInfo = NetworkMonitor.netGetExInfo(networkInfo);
                if (netGetExInfo == null) {
                    return "";
                }
                return netGetExInfo.toLowerCase();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static String getString(String str) {
        if (TextUtils.isEmpty(str)) {
            return DEF_STRING;
        }
        return str;
    }

    public static String getSystemVersion() {
        return Build.VERSION.SDK_INT + "";
    }

    public static long getUin() {
        long j3 = sUin;
        if (j3 != 0) {
            return j3;
        }
        try {
            long longValue = Long.valueOf((String) p.a(p.a(p.f("com.tencent.common.app.BaseApplicationImpl").e("sApplication")).a("getRuntime").a()).a("getAccount").a()).longValue();
            sUin = longValue;
            return longValue;
        } catch (Throwable th5) {
            r.a(TAG, th5.getMessage());
            return 0L;
        }
    }

    public static String getUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return "supersdk_nulluser";
        }
        return str;
    }

    public static boolean isDBExist(String str) {
        if (getInstance().getContext() != null && getInstance().getContext().getDatabasePath(str).exists()) {
            return true;
        }
        return false;
    }

    public static boolean isMIUI() {
        try {
            if (!TextUtils.isEmpty(SystemProperties.get("ro.miui.ui.version.name", null))) {
                return true;
            }
            String str = Build.MANUFACTURER;
            if (str == null) {
                return false;
            }
            return replaceBlank(str).toLowerCase().contains("xiaomi");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isNetworkConncted() {
        NetworkInfo networkInfo;
        Context context = getInstance().getContext();
        if (context == null) {
            r.c(TAG, "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            r.a(TAG, e16.getMessage());
            networkInfo = null;
        }
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }

    public static boolean isOppo() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo")) {
                return true;
            }
            String str2 = Build.FINGERPRINT;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.toLowerCase().contains("oppo")) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e16) {
            Log.e("DeviceUtils", e16.getMessage(), e16);
            return false;
        }
    }

    public static boolean isRecommendGame(String str) {
        ArrayList<String> arrayList;
        BoutiqueGameConfig boutiqueGameConfig = (BoutiqueGameConfig) com.tencent.tmdownloader.f.b.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
        if (boutiqueGameConfig != null && (arrayList = boutiqueGameConfig.pkgList) != null && arrayList.size() != 0) {
            r.b("nemo_bgg", "<isRecommendGame> CONFIG_RECOMMEND_GAMES  size = " + boutiqueGameConfig.pkgList.size() + "\ncontent=" + boutiqueGameConfig.pkgList);
            boolean contains = boutiqueGameConfig.pkgList.contains(str);
            r.b("nemo_bgg", "<isRecommendGame> " + str + " is bgg\uff1a" + contains);
            return contains;
        }
        r.a("nemo_bgg", "<isRecommendGame> CONFIG_RECOMMEND_GAMES error, boutiqueGameConfig is null!");
        return false;
    }

    public static boolean isVivo() {
        return replaceBlank((Build.MANUFACTURER + "-" + DeviceInfoMonitor.getModel()).toLowerCase()).contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
    }

    public static String replaceBlank(String str) {
        if (str == null) {
            return "";
        }
        return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
    }

    public static void updateFilePathAuthorized(String str) {
        File file = new File(str);
        String parent = file.getParent();
        String parent2 = new File(parent).getParent();
        String parent3 = new File(parent2).getParent();
        try {
            RuntimeMonitor.exec(Runtime.getRuntime(), "chmod 777 " + file.getAbsolutePath());
            RuntimeMonitor.exec(Runtime.getRuntime(), "chmod 777 " + parent);
            RuntimeMonitor.exec(Runtime.getRuntime(), "chmod 777 " + parent2);
            RuntimeMonitor.exec(Runtime.getRuntime(), "chmod 777" + parent3);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    public boolean canReportValue() {
        if ("wifi".equals(getNetStatus())) {
            return true;
        }
        return false;
    }

    public void destroy() {
        this.mContext = null;
        mInstance = null;
    }

    public String getAndroidIdInPhone() {
        return "";
    }

    public boolean getAutoDeleteSwitch() {
        SharedPreferences sharedPreferences;
        Context context = this.mContext;
        if (context == null || (sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 4)) == null) {
            return false;
        }
        return sharedPreferences.getBoolean("autoDeleteEnabled", false);
    }

    public String getBrand() {
        return filter(Build.BRAND);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getImei() {
        return "";
    }

    public String getImsi() {
        return "";
    }

    public String getMacAddress() {
        return "";
    }

    public String getManufacture() {
        return filter(Build.MANUFACTURER);
    }

    public String getModel() {
        return filter(DeviceInfoMonitor.getModel());
    }

    public String getNetworkOperator() {
        try {
            Context context = this.mContext;
            if (context == null) {
                return "";
            }
            return DeviceInfoMonitor.getNetworkOperator((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e16) {
            r.a(TAG, "getNetworkOperator Exception:", e16);
            return "";
        }
    }

    public int getNetworkType() {
        try {
            Context context = this.mContext;
            if (context == null) {
                return 0;
            }
            return NetworkMonitor.getNetworkType((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception e16) {
            r.a(TAG, "getNetworkType Exception:", e16);
            return 0;
        }
    }

    public String getPhoneGuid() {
        SharedPreferences sharedPreferences;
        Context context = this.mContext;
        if (context == null || (sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 4)) == null) {
            return "";
        }
        return sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }

    public String getProduct() {
        return filter(Build.PRODUCT);
    }

    public int getQQDownloaderAPILevel() {
        Bundle bundle;
        if (this.mContext == null) {
            r.b("SelfUpdateSDK", "context == null");
            return 0;
        }
        r.b("SelfUpdateSDK", "getQQDownloaderAPILevel");
        try {
            ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(SDKConst.SELF_PACKAGENAME, 128);
            r.b("SelfUpdateSDK", "appInfo:" + applicationInfo);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                int i3 = bundle.getInt(SDKConst.SDK_APILEVEL);
                r.b("SelfUpdateSDK", "apiLevel:" + i3);
                return i3;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public int getQQDownloaderConnectLevel() {
        Bundle bundle;
        if (this.mContext == null) {
            r.b("SelfUpdateSDK", "context == null");
            return 0;
        }
        r.b("SelfUpdateSDK", "getQQDownloaderConnectLevel");
        try {
            ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo(SDKConst.SELF_PACKAGENAME, 128);
            r.b("SelfUpdateSDK", "appInfo:" + applicationInfo);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                int i3 = bundle.getInt("com.tencent.android.qqdownloader.sdk.connectlevel");
                r.b("SelfUpdateSDK", "apiLevel:" + i3);
                return i3;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public synchronized int getQQDownloaderVersionCode() {
        Context context = this.mContext;
        if (context == null) {
            return 0;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, SDKConst.SELF_PACKAGENAME, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getQadid() {
        Context context;
        if (TextUtils.isEmpty(mQadid) && (context = this.mContext) != null) {
            mQadid = m.a(context.getApplicationContext());
            r.b(TAG, ">getQadid " + mQadid);
            return mQadid;
        }
        r.b(TAG, ">getQadid " + mQadid);
        return mQadid;
    }

    public String getQimei() {
        if (TextUtils.isEmpty(mQImei) && this.mContext != null) {
            try {
                p.f("com.tencent.beacon.event.UserAction").a("initUserAction", this.mContext.getApplicationContext());
                String str = (String) p.f("com.tencent.beacon.event.UserAction").a("getQIMEI").a();
                String str2 = (String) p.f("com.tencent.beacon.event.UserAction").a("getQimeiNew").a();
                mQImei = str + "-" + str2;
                r.b(TAG, ">getQimei: qimei=" + str + "; qimei36=" + str2 + "; mQImei=" + mQImei);
            } catch (Throwable th5) {
                r.a(TAG, ">getQimei" + th5.getMessage());
            }
            r.b(TAG, ">getQimei" + mQImei);
            return mQImei;
        }
        r.b(TAG, ">getQimei" + mQImei);
        return mQImei;
    }

    public int getScreenHeight() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public int getScreenWidth() {
        Context context = this.mContext;
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return 0;
    }

    public SharedPreferences getSharedPreferences() {
        if (getInstance().getContext() == null) {
            return null;
        }
        return getInstance().getContext().getSharedPreferences(SharedPreferencesName, 4);
    }

    public void saveAutoDeleteSwitch(boolean z16) {
        SharedPreferences sharedPreferences;
        Context context = this.mContext;
        if (context != null && (sharedPreferences = context.getSharedPreferences(SharedPreferencesName, 4)) != null) {
            sharedPreferences.edit().putBoolean("autoDeleteEnabled", z16).commit();
        }
    }

    public void setContext(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        this.mContext = context;
        this.mQUA = new o(context).a();
        e.a().post(new a());
        try {
            com.tencent.hlyyb.common.c.a.r(this.mContext);
        } catch (Throwable unused) {
        }
    }

    public void setPhoneGuid(String str) {
        SharedPreferences sharedPreferences;
        if (this.mContext != null && !TextUtils.isEmpty(str) && (sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 4)) != null) {
            sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
        }
    }

    public int getAppVersionCode() {
        Context context = this.mContext;
        if (context == null) {
            return 0;
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(this.mContext.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void setNetTypeValue(byte b16) {
    }
}
