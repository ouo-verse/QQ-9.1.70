package com.tencent.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.Xml;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.p;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import uy4.a;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQDeviceInfo {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_LEVEL = 4;
    private static final String KEY_ANDROID_ID = "android_id";
    private static final String KEY_DEVICE_ID_CACHE_PREFIX = "device_id_cache_";
    private static final String KEY_HUAWEI_OAID = "huawei_oaid";
    private static final String KEY_IMEI = "imei";
    public static final String KEY_NO_LOGIN_USER_ID = "key_no_login_user_id";
    public static final int LEVEL_CROSS_APP = 5;
    private static final int LEVEL_INVALID = -1;
    public static final int LEVEL_NEW_INSTALL = 2;
    public static final int LEVEL_OVER_INSTALL = 3;
    public static final int LEVEL_REBOOT = 1;
    public static final int LEVEL_SYSTEM_UPGRADE = 4;
    private static final String SP_AUTHORITY = "authority";
    public static String TAG;
    private static String mAndroidId;
    private static volatile Map<String, Integer> mBusiIdCache;
    private static final Object mCacheOj;
    private static final SparseArray<String> mDeviceIDCache;
    private static String mHuaweiOaid;
    private static String mImei;
    private static boolean mSwitch;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Entity {
        static IPatchRedirector $redirector_;
        public final String androidID;
        public final String imei;
        public final String qimei;

        public Entity(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.imei = str;
            this.qimei = str2;
            this.androidID = str3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36601);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = "QQDeviceInfo";
        mSwitch = false;
        mCacheOj = new Object();
        mDeviceIDCache = new SparseArray<>();
    }

    public QQDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getAndroidID() {
        if (!TextUtils.isEmpty(mAndroidId)) {
            return mAndroidId;
        }
        String iMEIFromSp = getIMEIFromSp("android_id");
        mAndroidId = iMEIFromSp;
        if (TextUtils.isEmpty(iMEIFromSp)) {
            String stringSystem = DeviceInfoMonitor.getStringSystem(BaseApplication.getContext().getContentResolver(), "android_id");
            mAndroidId = stringSystem;
            saveIMEI2Sp("android_id", stringSystem);
        }
        return mAndroidId;
    }

    private static String getDeviceIDCache(int i3) {
        String str;
        SparseArray<String> sparseArray = mDeviceIDCache;
        synchronized (sparseArray) {
            if (sparseArray.indexOfKey(i3) < 0) {
                sparseArray.put(i3, getIMEIFromSp(KEY_DEVICE_ID_CACHE_PREFIX + i3));
            }
            str = sparseArray.get(i3);
        }
        return str;
    }

    public static Entity getDeviceInfo(String str) {
        getLevelByBIdAndVerify(str);
        return new Entity(getIMEI(), getQIMEI(), getAndroidID());
    }

    private static String getHuaweiOaid() {
        String androidID;
        if (!TextUtils.isEmpty(mHuaweiOaid)) {
            androidID = mHuaweiOaid;
        } else {
            androidID = getAndroidID();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getHuaweiOaid, but huawei oaid is null, so use android id instead");
            }
        }
        reportGetHuaweiOaid();
        return androidID;
    }

    public static String getIMEI(String str, int i3) {
        String androidID;
        int levelByBIdAndVerify = getLevelByBIdAndVerify(str);
        if (i3 == -1) {
            i3 = levelByBIdAndVerify;
        }
        String deviceIDCache = getDeviceIDCache(i3);
        if (!TextUtils.isEmpty(deviceIDCache)) {
            return deviceIDCache;
        }
        initIMEI();
        initHuaweiOaid(true);
        if ((Build.VERSION.SDK_INT <= 28 && BaseApplication.getContext().checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) || !TextUtils.isEmpty(mImei)) {
            androidID = getIMEI();
        } else if (i3 >= 5) {
            androidID = getQIMEI();
        } else if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER) && !TextUtils.isEmpty(mHuaweiOaid)) {
            androidID = mHuaweiOaid;
        } else {
            androidID = getAndroidID();
        }
        if (androidID == null) {
            androidID = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getIMEI, level = " + i3 + "; result = " + androidID);
        }
        if (!androidID.equals(deviceIDCache)) {
            saveIMEI2Sp(KEY_DEVICE_ID_CACHE_PREFIX + i3, androidID);
        }
        return androidID;
    }

    private static String getIMEIFromSp(String str) {
        String string = BaseApplication.getContext().getSharedPreferences("authority", 4).getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String getIMSI(String str, int i3) {
        return getIMSI(str);
    }

    private static int getLevelByBIdAndVerify(String str) {
        if (mBusiIdCache == null) {
            synchronized (mCacheOj) {
                if (mBusiIdCache == null) {
                    initBusiIdData();
                }
            }
        }
        if (mBusiIdCache == null) {
            return 4;
        }
        if (!mBusiIdCache.containsKey(str)) {
            if (!mSwitch) {
                return 4;
            }
            throw new IllegalArgumentException("busiId not registed ,please first regist");
        }
        Integer num = mBusiIdCache.get(str);
        if (num == null) {
            return 4;
        }
        return num.intValue();
    }

    public static String getMAC(String str) {
        getLevelByBIdAndVerify(str);
        try {
            return NetworkMonitor.getMacAddress(LocationMonitor.getConnectionInfo((WifiManager) BaseApplication.getContext().getApplicationContext().getSystemService("wifi")));
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 2, " getMacAddr exception = " + e16);
            }
            return "";
        }
    }

    public static String getNoLoginUserId() {
        BaseApplication context = BaseApplication.getContext();
        String str = "";
        String str2 = (String) p.b(context, "0", KEY_NO_LOGIN_USER_ID, "");
        if (TextUtils.isEmpty(str2)) {
            try {
                str = DeviceInfoMonitor.getString(context.getContentResolver(), "android_id");
            } catch (Exception unused) {
            }
            String md5 = MD5.toMD5(str + UUID.randomUUID().toString());
            p.g(context, "0", false, KEY_NO_LOGIN_USER_ID, md5);
            return md5;
        }
        return str2;
    }

    public static String getQIMEI() {
        return com.tencent.mobileqq.statistics.o.b();
    }

    @SuppressLint({"HardwareIds"})
    public static String getSerial(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 26) {
            return DeviceInfoMonitor.getSerialByField();
        }
        if ((i3 <= 28 || com.tencent.common.config.AppSetting.m() <= 28) && activity != null && activity.checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0) {
            try {
                return DeviceInfoMonitor.getSerialByMethod();
            } catch (SecurityException e16) {
                QLog.e(TAG, 2, e16, new Object[0]);
            }
        }
        return "unknown";
    }

    private static void initBusiIdData() {
        int i3;
        HashMap hashMap = new HashMap();
        try {
            InputStream open = BaseApplication.getContext().getResources().getAssets().open("SensiveAuthorityFile.xml");
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(open, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && newPullParser.getName().equalsIgnoreCase("business")) {
                    String attributeValue = newPullParser.getAttributeValue(null, "id");
                    String attributeValue2 = newPullParser.getAttributeValue(null, "level");
                    if (!TextUtils.isEmpty(attributeValue2)) {
                        i3 = stringToInt(attributeValue2, 4);
                    } else {
                        i3 = 4;
                    }
                    hashMap.put(attributeValue, Integer.valueOf(i3));
                    if (QLog.isDevelopLevel()) {
                        QLog.d(TAG, 4, "init sensitive au, busiId = " + attributeValue + "; level = " + i3);
                    }
                }
            }
            open.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (XmlPullParserException e17) {
            e17.printStackTrace();
        }
        mBusiIdCache = hashMap;
    }

    public static void initHuaweiOaid() {
        initHuaweiOaid(false);
    }

    private static void initIMEI() {
        if (!TextUtils.isEmpty(mImei)) {
            return;
        }
        mImei = getIMEIFromSp("imei");
    }

    private static void reportGetHuaweiOaid() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = TAG + "_getHuaweiOaid";
        hashMap.put(KEY_HUAWEI_OAID, mHuaweiOaid);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, 0L, 0L, hashMap, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveIMEI2Sp(String str, String str2) {
        BaseApplication.getContext().getSharedPreferences("authority", 4).edit().putString(str, str2).apply();
    }

    private static int stringToInt(String str, int i3) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return i3;
        }
    }

    public static String getIMSI(String str) {
        getLevelByBIdAndVerify(str);
        try {
            return DeviceInfoMonitor.getSubscriberId((TelephonyManager) BaseApplication.getContext().getSystemService("phone"));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void initHuaweiOaid(boolean z16) {
        if (Build.VERSION.SDK_INT <= 28 || !CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
            return;
        }
        String iMEIFromSp = getIMEIFromSp(KEY_HUAWEI_OAID);
        mHuaweiOaid = iMEIFromSp;
        if (z16 || !TextUtils.isEmpty(iMEIFromSp)) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.util.QQDeviceInfo.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.util.QQDeviceInfo$1$a */
            /* loaded from: classes27.dex */
            class a implements ServiceConnection {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        try {
                            try {
                                QQDeviceInfo.mHuaweiOaid = a.AbstractBinderC11378a.j(iBinder).getOaid();
                                QQDeviceInfo.saveIMEI2Sp(QQDeviceInfo.KEY_HUAWEI_OAID, QQDeviceInfo.mHuaweiOaid);
                                if (QLog.isColorLevel()) {
                                    QLog.d(QQDeviceInfo.TAG, 2, "huawei oaid = " + QQDeviceInfo.mHuaweiOaid);
                                    return;
                                }
                                return;
                            } catch (SecurityException e16) {
                                e16.printStackTrace();
                                QLog.e(QQDeviceInfo.TAG, 2, e16, new Object[0]);
                                return;
                            }
                        } catch (RemoteException e17) {
                            e17.printStackTrace();
                            QLog.e(QQDeviceInfo.TAG, 2, "get huawei oaid throw e", e17);
                            return;
                        }
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                a aVar = new a();
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                BaseApplication.getContext().bindService(intent, aVar, 1);
            }
        });
    }

    public static String getIMEI(String str) {
        return getIMEI(str, -1);
    }

    private static String getIMEI() {
        initIMEI();
        if (!TextUtils.isEmpty(mImei)) {
            return mImei;
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                mImei = com.tencent.mobileqq.statistics.o.c();
            } else {
                mImei = com.tencent.mobileqq.statistics.o.c();
            }
            saveIMEI2Sp("imei", mImei);
        } catch (SecurityException unused) {
            mImei = "";
        } catch (Throwable unused2) {
            mImei = "";
        }
        return mImei;
    }
}
