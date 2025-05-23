package com.tencent.qmethod.pandoraex.monitor;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.hardware.Sensor;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.UiccCardInfo;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DeviceInfoMonitor {
    public static final String TAG = "DeviceInfoMonitor";
    private static volatile String lastDeviceId = "";
    private static volatile Map<Integer, String> lastDeviceIds = new ConcurrentHashMap();
    private static volatile String lastImei = "";
    private static volatile Map<Integer, String> lastImeis = new ConcurrentHashMap();
    private static volatile String lastMeid = "";
    private static volatile Map<Integer, String> lastMeids = new ConcurrentHashMap();
    private static volatile String lastImsi = "";
    private static volatile String lastAndroidId = "";
    private static volatile String lastLineNumber = "";
    private static volatile String lastSimOperator = "";
    private static volatile String lastSimSerialNumber = "";
    private static volatile String lastSerial = "";
    private static volatile String lastModel = "";
    private static volatile List<UiccCardInfo> lastUiccCardInfos = new ArrayList();
    private static volatile Sensor lastSensor = null;
    private static final Object lockDeviceId = new Object();
    private static final Object lockDeviceIds = new Object();
    private static final Object lockImei = new Object();
    private static final Object lockImeis = new Object();
    private static final Object lockMeid = new Object();
    private static final Object lockMeids = new Object();
    private static final Object lockImsi = new Object();
    private static final Object lockAndroidId = new Object();
    private static final Object lockSerial = new Object();
    private static final Object lockModel = new Object();
    private static final Object lockUiccCardInfos = new Object();

    private static void attainAndSavaAndroidId(ContentResolver contentResolver, String str) {
        try {
            lastAndroidId = Settings.Secure.getString(contentResolver, str);
            com.tencent.qmethod.pandoraex.core.o.c(TAG, "SE#G_AID is Really Call System API");
            com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "SE#G_AID", lastAndroidId);
        } catch (Exception e16) {
            com.tencent.qmethod.pandoraex.core.o.d(TAG, "getString android_id exception is ", e16);
        }
    }

    public static void clearDeviceInfoMemoryCache() {
        lastDeviceId = "";
        lastDeviceIds.clear();
        lastImei = "";
        lastImeis.clear();
        lastMeid = "";
        lastMeids.clear();
        lastImsi = "";
        lastAndroidId = "";
        lastLineNumber = "";
        lastSimOperator = "";
        lastSimSerialNumber = "";
        lastSerial = "";
        lastModel = "";
        lastSensor = null;
        synchronized (lockUiccCardInfos) {
            lastUiccCardInfos = new ArrayList();
        }
    }

    public static List<SubscriptionInfo> getAccessibleSubscriptionInfoList(final SubscriptionManager subscriptionManager) throws Throwable {
        return (List) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<List<SubscriptionInfo>>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.4
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 22)
            @SuppressLint({"MissingPermission", "NewApi"})
            public List<SubscriptionInfo> call() {
                List<SubscriptionInfo> accessibleSubscriptionInfoList;
                accessibleSubscriptionInfoList = subscriptionManager.getAccessibleSubscriptionInfoList();
                return accessibleSubscriptionInfoList;
            }
        }).f("device").c("SUBM#G_ACCESS_SUB_L").e();
    }

    public static SubscriptionInfo getActiveSubscriptionInfo(final SubscriptionManager subscriptionManager, final int i3) throws Throwable {
        return (SubscriptionInfo) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<SubscriptionInfo>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 22)
            @SuppressLint({"MissingPermission"})
            public SubscriptionInfo call() {
                return subscriptionManager.getActiveSubscriptionInfo(i3);
            }
        }).f("device").c("SUBM#G_ATIVE_SUB#I").e();
    }

    public static SubscriptionInfo getActiveSubscriptionInfoForSimSlotIndex(final SubscriptionManager subscriptionManager, final int i3) throws Throwable {
        return (SubscriptionInfo) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<SubscriptionInfo>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 22)
            @SuppressLint({"MissingPermission"})
            public SubscriptionInfo call() {
                return subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i3);
            }
        }).f("device").c("SUBM#G_ATIVE_SUB_FSSI#I").e();
    }

    public static List<SubscriptionInfo> getActiveSubscriptionInfoList(final SubscriptionManager subscriptionManager) throws Throwable {
        return (List) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<List<SubscriptionInfo>>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.3
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 22)
            @SuppressLint({"MissingPermission"})
            public List<SubscriptionInfo> call() {
                return subscriptionManager.getActiveSubscriptionInfoList();
            }
        }).f("device").c("SM#G_ACTIVE_SUB_L").e();
    }

    public static List<SubscriptionInfo> getCompleteActiveSubscriptionInfoList(final SubscriptionManager subscriptionManager) throws Throwable {
        return (List) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<List<SubscriptionInfo>>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.2
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 30)
            @SuppressLint({"MissingPermission"})
            public List<SubscriptionInfo> call() {
                List<SubscriptionInfo> completeActiveSubscriptionInfoList;
                completeActiveSubscriptionInfoList = subscriptionManager.getCompleteActiveSubscriptionInfoList();
                return completeActiveSubscriptionInfoList;
            }
        }).f("device").c("SUBM#G_COMP_ACTIVE_SUB_L").e();
    }

    @SuppressLint({"MissingPermission"})
    public static String getDeviceId(TelephonyManager telephonyManager) {
        synchronized (lockDeviceId) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_DID", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    lastDeviceId = telephonyManager.getDeviceId();
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_DID is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_DID", lastDeviceId);
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getDeviceId exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_DID", strategyAndReport.f343902c);
                return lastDeviceId;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastDeviceId)) {
                    lastDeviceId = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_DID");
                    return lastDeviceId;
                }
                return lastDeviceId;
            }
            if (com.tencent.qmethod.pandoraex.api.e.e() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.e();
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getImei(TelephonyManager telephonyManager) {
        String imei;
        synchronized (lockImei) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_IM", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    imei = telephonyManager.getImei();
                    lastImei = imei;
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_IM is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_IM", lastImei);
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getImei exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_IM", strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("TM#G_IM", lastImei);
                return lastImei;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastImei)) {
                    lastImei = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_IM");
                    return lastImei;
                }
                return lastImei;
            }
            if (com.tencent.qmethod.pandoraex.api.e.g() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.g();
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getLine1Number(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_LI_NUM", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            try {
                lastLineNumber = telephonyManager.getLine1Number();
                com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_LI_NUM is Really Call System API");
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_LI_NUM", lastLineNumber);
            } catch (Exception e16) {
                com.tencent.qmethod.pandoraex.core.o.d(TAG, "getLine1Number index exception is ", e16);
            }
            com.tencent.qmethod.pandoraex.core.e.d("TM#G_LI_NUM", strategyAndReport.f343902c);
            return lastLineNumber;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastLineNumber)) {
                lastLineNumber = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_LI_NUM");
                return lastLineNumber;
            }
            return lastLineNumber;
        }
        if (com.tencent.qmethod.pandoraex.api.e.i() != null) {
            return com.tencent.qmethod.pandoraex.api.e.i();
        }
        return "";
    }

    public static long getLong(ContentResolver contentResolver, String str) throws Settings.SettingNotFoundException {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            try {
                return Long.parseLong(getString(contentResolver, str));
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return Settings.Secure.getLong(contentResolver, str);
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getMeid(TelephonyManager telephonyManager) {
        String meid;
        synchronized (lockMeid) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_MID", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    meid = telephonyManager.getMeid();
                    lastMeid = meid;
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_MID is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_MID", lastMeid);
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getMeid exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_MID", strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("TM#G_MID", lastMeid);
                return lastMeid;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastMeid)) {
                    lastMeid = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_MID");
                    return lastMeid;
                }
                return lastMeid;
            }
            if (com.tencent.qmethod.pandoraex.api.e.l() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.l();
        }
    }

    public static String getModel() {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "BU#MODEL", null, null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            synchronized (lockModel) {
                if (com.tencent.qmethod.pandoraex.core.x.y(strategyAndReport) || com.tencent.qmethod.pandoraex.core.x.O("BU#MODEL", strategyAndReport.f343902c, null)) {
                    try {
                        lastModel = Build.MODEL;
                        com.tencent.qmethod.pandoraex.core.o.c(TAG, "BU#MODEL is Really Call System API");
                        com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "BU#MODEL", lastModel);
                    } catch (Exception e16) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "getModel exception is ", e16);
                    }
                    com.tencent.qmethod.pandoraex.core.e.d("BU#MODEL", strategyAndReport.f343902c);
                }
            }
            return lastModel;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastModel)) {
                lastModel = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "BU#MODEL");
                return lastModel;
            }
            return lastModel;
        }
        return "";
    }

    public static String getNetworkOperator(final TelephonyManager telephonyManager) throws Throwable {
        String str;
        if (com.tencent.qmethod.pandoraex.api.e.b() != null) {
            str = com.tencent.qmethod.pandoraex.api.e.b();
        } else {
            str = "";
        }
        return (String) a.C11438a.p(new com.tencent.qmethod.pandoraex.core.k<String>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.1
            @Override // com.tencent.qmethod.pandoraex.core.k
            public String call() {
                return telephonyManager.getNetworkOperator();
            }
        }).f("device").c("TM#G_NWK_OP").j(str).e();
    }

    public static List<SubscriptionInfo> getOpportunisticSubscriptions(final SubscriptionManager subscriptionManager) throws Throwable {
        return (List) a.C11438a.n(new com.tencent.qmethod.pandoraex.core.k<List<SubscriptionInfo>>() { // from class: com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor.5
            @Override // com.tencent.qmethod.pandoraex.core.k
            @RequiresApi(api = 22)
            @SuppressLint({"MissingPermission", "NewApi"})
            public List<SubscriptionInfo> call() {
                List<SubscriptionInfo> opportunisticSubscriptions;
                opportunisticSubscriptions = subscriptionManager.getOpportunisticSubscriptions();
                return opportunisticSubscriptions;
            }
        }).f("device").c("SUBM#G_OPP_SUBS").e();
    }

    public static String getSerialByField() {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "BU#SER", null, null);
        if (Build.VERSION.SDK_INT >= 26) {
            return "unknown";
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            synchronized (lockSerial) {
                if (com.tencent.qmethod.pandoraex.core.x.y(strategyAndReport) || com.tencent.qmethod.pandoraex.core.x.O("BU#SER", strategyAndReport.f343902c, null)) {
                    try {
                        lastSerial = Build.SERIAL;
                        com.tencent.qmethod.pandoraex.core.o.c(TAG, "BU#SERByField is Really Call System API");
                        com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "BU#SER", lastSerial);
                    } catch (Exception e16) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "getSerial exception is ", e16);
                    }
                    com.tencent.qmethod.pandoraex.core.e.d("BU#SER", strategyAndReport.f343902c);
                }
            }
            return lastSerial;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastSerial)) {
                lastSerial = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "BU#SER");
                return lastSerial;
            }
            return lastSerial;
        }
        return "unknown";
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getSerialByMethod() {
        String serial;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "BU#SER", null, null);
        if (Build.VERSION.SDK_INT > 28) {
            return "unknown";
        }
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            synchronized (lockSerial) {
                if (com.tencent.qmethod.pandoraex.core.x.y(strategyAndReport) || com.tencent.qmethod.pandoraex.core.x.O("BU#SER", strategyAndReport.f343902c, null)) {
                    try {
                        serial = Build.getSerial();
                        lastSerial = serial;
                        com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "BU#SER", lastSerial);
                        com.tencent.qmethod.pandoraex.core.o.c(TAG, "BU#SERByMethod is Really Call System API");
                    } catch (Exception e16) {
                        com.tencent.qmethod.pandoraex.core.o.d(TAG, "getSerial exception is ", e16);
                    }
                    com.tencent.qmethod.pandoraex.core.e.d("BU#SER", strategyAndReport.f343902c);
                }
            }
            return lastSerial;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastSerial)) {
                lastSerial = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "BU#SER");
                return lastSerial;
            }
            return lastSerial;
        }
        return "unknown";
    }

    public static String getSimOperator(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_SIM_OP", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            try {
                lastSimOperator = telephonyManager.getSimOperator();
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SIM_OP", lastSimOperator);
            } catch (Exception e16) {
                com.tencent.qmethod.pandoraex.core.o.d(TAG, "getSimOperator exception is ", e16);
            }
            com.tencent.qmethod.pandoraex.core.e.d("TM#G_SIM_OP", strategyAndReport.f343902c);
            return lastSimOperator;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastImsi)) {
                lastSimOperator = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SIM_OP");
                return lastSimOperator;
            }
            return lastSimOperator;
        }
        if (com.tencent.qmethod.pandoraex.api.e.m() != null) {
            return com.tencent.qmethod.pandoraex.api.e.m();
        }
        return "";
    }

    @SuppressLint({"MissingPermission"})
    public static String getSimSerialNumber(TelephonyManager telephonyManager) {
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_SIM_SE_NUM", new a.C11438a().b("ban").b("cache_only").b("memory").b(QQPermissionConstants.Permission.STORAGE_GROUP).d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            try {
                lastSimSerialNumber = telephonyManager.getSimSerialNumber();
                com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_SIM_SE_NUM is Really Call System API");
                com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SIM_SE_NUM", lastSimSerialNumber);
            } catch (Exception e16) {
                com.tencent.qmethod.pandoraex.core.o.d(TAG, "getSimSerialNumber index exception is ", e16);
            }
            com.tencent.qmethod.pandoraex.core.e.d("TM#G_SIM_SE_NUM", strategyAndReport.f343902c);
            return lastSimSerialNumber;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastLineNumber)) {
                lastSimSerialNumber = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SIM_SE_NUM");
                return lastSimSerialNumber;
            }
            return lastSimSerialNumber;
        }
        if (com.tencent.qmethod.pandoraex.api.e.n() != null) {
            return com.tencent.qmethod.pandoraex.api.e.n();
        }
        return "";
    }

    public static String getString(ContentResolver contentResolver, String str) {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            synchronized (lockAndroidId) {
                com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "SE#G_AID", null, null);
                if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                    attainAndSavaAndroidId(contentResolver, str);
                    com.tencent.qmethod.pandoraex.core.e.d("SE#G_AID", strategyAndReport.f343902c);
                    MonitorReporter.handleEventReport("SE#G_AID", lastAndroidId);
                    return lastAndroidId;
                }
                if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                    if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastAndroidId)) {
                        lastAndroidId = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "SE#G_AID");
                        return lastAndroidId;
                    }
                    return lastAndroidId;
                }
                if (com.tencent.qmethod.pandoraex.api.e.c() != null) {
                    return com.tencent.qmethod.pandoraex.api.e.c();
                }
                return "";
            }
        }
        return Settings.Secure.getString(contentResolver, str);
    }

    public static String getStringForMiPush(ContentResolver contentResolver, String str) {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            synchronized (lockAndroidId) {
                if (com.tencent.qmethod.pandoraex.core.x.u()) {
                    if (!TextUtils.isEmpty(lastAndroidId)) {
                        return lastAndroidId;
                    }
                    lastAndroidId = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "SE#G_AID");
                    if (!TextUtils.isEmpty(lastAndroidId)) {
                        return lastAndroidId;
                    }
                    attainAndSavaAndroidId(contentResolver, str);
                    return lastAndroidId;
                }
                if (com.tencent.qmethod.pandoraex.api.e.c() != null) {
                    return com.tencent.qmethod.pandoraex.api.e.c();
                }
                return "";
            }
        }
        return Settings.Secure.getString(contentResolver, str);
    }

    public static String getStringForMiPushSystem(ContentResolver contentResolver, String str) {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            return getStringForMiPush(contentResolver, str);
        }
        return Settings.System.getString(contentResolver, str);
    }

    public static String getStringSystem(ContentResolver contentResolver, String str) {
        if (SharedPreferencedUtil.SP_KEY_ANDROID_ID.equals(str)) {
            return getString(contentResolver, str);
        }
        return Settings.System.getString(contentResolver, str);
    }

    @SuppressLint({"MissingPermission"})
    public static String getSubscriberId(TelephonyManager telephonyManager) {
        synchronized (lockImsi) {
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_SID", null, null);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    lastImsi = telephonyManager.getSubscriberId();
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SID", lastImsi);
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_SID is Really Call System API");
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getImsi exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_SID", strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("TM#G_SID", lastImsi);
                return lastImsi;
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastImsi)) {
                    lastImsi = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_SID");
                    return lastImsi;
                }
                return lastImsi;
            }
            if (com.tencent.qmethod.pandoraex.api.e.h() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.h();
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static List<UiccCardInfo> getUiccCardsInfo(TelephonyManager telephonyManager) {
        List<UiccCardInfo> list;
        List<UiccCardInfo> uiccCardsInfo;
        com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_UICC_INFO", new a.C11438a().b("ban").b("cache_only").b("memory").d(), null);
        if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
            uiccCardsInfo = telephonyManager.getUiccCardsInfo();
            lastUiccCardInfos = uiccCardsInfo;
            return lastUiccCardInfos;
        }
        if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
            synchronized (lockUiccCardInfos) {
                list = lastUiccCardInfos;
            }
            return list;
        }
        return new ArrayList();
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getDeviceId(TelephonyManager telephonyManager, int i3) {
        synchronized (lockDeviceIds) {
            HashMap hashMap = new HashMap();
            hashMap.put("index", String.valueOf(i3));
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_DID#I", null, hashMap);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    lastDeviceIds.put(Integer.valueOf(i3), telephonyManager.getDeviceId(i3));
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_DID#I" + i3 + " is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_DID#I" + i3, lastDeviceIds.get(Integer.valueOf(i3)));
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getDeviceId index exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_DID#I" + i3, strategyAndReport.f343902c);
                return lastDeviceIds.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastDeviceIds.get(Integer.valueOf(i3)))) {
                    lastDeviceIds.put(Integer.valueOf(i3), com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_DID#I" + i3));
                    return lastDeviceIds.get(Integer.valueOf(i3));
                }
                return lastDeviceIds.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.api.e.e() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.e();
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getImei(TelephonyManager telephonyManager, int i3) {
        String imei;
        synchronized (lockImeis) {
            HashMap hashMap = new HashMap();
            hashMap.put("index", String.valueOf(i3));
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_IM#I", null, hashMap);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    Map<Integer, String> map = lastImeis;
                    Integer valueOf = Integer.valueOf(i3);
                    imei = telephonyManager.getImei(i3);
                    map.put(valueOf, imei);
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_IM#I" + i3 + " is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_IM#I" + i3, lastImeis.get(Integer.valueOf(i3)));
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getImei index exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_IM#I" + i3, strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("TM#G_IM#I", lastImeis.get(Integer.valueOf(i3)));
                return lastImeis.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastImeis.get(Integer.valueOf(i3)))) {
                    lastImeis.put(Integer.valueOf(i3), com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_IM#I" + i3));
                    return lastImeis.get(Integer.valueOf(i3));
                }
                return lastImeis.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.api.e.g() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.g();
        }
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static String getMeid(TelephonyManager telephonyManager, int i3) {
        String meid;
        synchronized (lockMeids) {
            HashMap hashMap = new HashMap();
            hashMap.put("index", String.valueOf(i3));
            com.tencent.qmethod.pandoraex.api.d strategyAndReport = MonitorReporter.getStrategyAndReport("device", "TM#G_MID#I", null, hashMap);
            if (com.tencent.qmethod.pandoraex.core.x.C(strategyAndReport)) {
                try {
                    Map<Integer, String> map = lastMeids;
                    Integer valueOf = Integer.valueOf(i3);
                    meid = telephonyManager.getMeid(i3);
                    map.put(valueOf, meid);
                    com.tencent.qmethod.pandoraex.core.o.c(TAG, "TM#G_MID#I" + i3 + " is Really Call System API");
                    com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_MID#I" + i3, lastMeids.get(Integer.valueOf(i3)));
                } catch (Exception e16) {
                    com.tencent.qmethod.pandoraex.core.o.d(TAG, "getMeid index exception is ", e16);
                }
                com.tencent.qmethod.pandoraex.core.e.d("TM#G_MID#I" + i3, strategyAndReport.f343902c);
                MonitorReporter.handleEventReport("TM#G_MID#I", lastMeids.get(Integer.valueOf(i3)));
                return lastMeids.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.core.x.A(strategyAndReport)) {
                if (!"memory".equals(strategyAndReport.f343900a) && TextUtils.isEmpty(lastMeids.get(Integer.valueOf(i3)))) {
                    lastMeids.put(Integer.valueOf(i3), com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), "TM#G_MID#I" + i3));
                    return lastMeids.get(Integer.valueOf(i3));
                }
                return lastMeids.get(Integer.valueOf(i3));
            }
            if (com.tencent.qmethod.pandoraex.api.e.l() == null) {
                return "";
            }
            return com.tencent.qmethod.pandoraex.api.e.l();
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getSubscriberId(TelephonyManager telephonyManager, int i3) {
        return getSubscriberId(telephonyManager);
    }
}
