package com.tencent.mobileqq.msf.sdk;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250604a = "MSF.C.NetworkType5GWrapper";

    /* renamed from: b, reason: collision with root package name */
    public static final int f250605b = 29;

    /* renamed from: c, reason: collision with root package name */
    private static final String f250606c = "evt_five_g_network_type";

    /* renamed from: d, reason: collision with root package name */
    private static final String f250607d = "evt_read_phone_state_per";

    /* renamed from: e, reason: collision with root package name */
    private static final String f250608e = "user_uin";

    /* renamed from: f, reason: collision with root package name */
    private static final String f250609f = "has_read_phone_per";

    /* renamed from: g, reason: collision with root package name */
    private static final String f250610g = "is_five_g";

    /* renamed from: h, reason: collision with root package name */
    private static final long f250611h = 86400000;

    /* renamed from: i, reason: collision with root package name */
    private static final String f250612i = "sp_network";

    /* renamed from: j, reason: collision with root package name */
    private static final String f250613j = "last_report_5g_network_type";

    /* renamed from: k, reason: collision with root package name */
    private static final String f250614k = "last_report_read_phone_state_per_time";

    /* renamed from: l, reason: collision with root package name */
    private static long f250615l;

    /* renamed from: m, reason: collision with root package name */
    private static long f250616m;

    /* renamed from: n, reason: collision with root package name */
    private static ServiceState f250617n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24454);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250615l = a(f250613j);
            f250616m = a(f250614k);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int a(int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (i3 == 20) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250604a, 2, "network type is correct, val = " + i3);
                }
            } else if (i3 != 13) {
                if (QLog.isColorLevel()) {
                    QLog.d(f250604a, 2, "networkType != LTE");
                }
            } else if (Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
                i3 = b(i3);
                if (QLog.isColorLevel()) {
                    QLog.d(f250604a, 2, "getHwNetworkType = " + i3);
                }
            } else {
                ServiceState a16 = a();
                if (a16 != null && b(a16.toString())) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f250604a, 2, "getNetworkTypeWhenSDKVerAboveQ, res is nr last");
                    }
                    i3 = 20;
                } else {
                    if ((!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() || BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) && QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("ss = ");
                        sb5.append(a16 == null ? "null" : a16.toString());
                        QLog.d(f250604a, 2, sb5.toString());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(f250604a, 2, "go end");
                    }
                }
            }
        }
        try {
            d(i3);
        } catch (Throwable th5) {
            QLog.e(f250604a, 1, "reportIfNeed throw t, per = " + b(), th5);
        }
        return i3;
    }

    private static int b(int i3) {
        ServiceState a16 = a();
        int i16 = Build.VERSION.SDK_INT;
        if (i16 >= 26 && a16 != null && b()) {
            try {
                Method method = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
                method.setAccessible(true);
                Integer num = (Integer) method.invoke(a16, new Object[0]);
                if (num == null) {
                    return i3;
                }
                if (num.intValue() == 20) {
                    return 20;
                }
                return i3;
            } catch (Exception e16) {
                QLog.e(f250604a, 1, "getHwNetworkType throw ex", e16);
                return i3;
            }
        }
        if (!QLog.isColorLevel()) {
            return i3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sdkVersion = ");
        sb5.append(i16);
        sb5.append(", ss != null = ");
        sb5.append(a16 != null);
        sb5.append(", per = ");
        sb5.append(b());
        QLog.d(f250604a, 2, sb5.toString());
        return i3;
    }

    public static int c(int i3) {
        try {
            return a(i3);
        } catch (Throwable th5) {
            QLog.e(f250604a, 1, "getNetworkTypeWhenSDKVerAboveQ throw e", th5);
            return i3;
        }
    }

    private static void d(int i3) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        MsfCore msfCore = MsfCore.sCore;
        if (msfCore != null && msfCore.statReporter != null && msfCore.getAccountCenter() != null) {
            MsfCore msfCore2 = MsfCore.sCore;
            com.tencent.mobileqq.msf.core.c0.j jVar = msfCore2.statReporter;
            String e16 = msfCore2.getAccountCenter().e();
            b(jVar, i3, e16);
            a(jVar, i3, e16);
            return;
        }
        QLog.d(f250604a, 1, "some param are still null, per = " + b());
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    @RequiresApi(api = 23)
    private static void b(com.tencent.mobileqq.msf.core.c0.j jVar, int i3, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f250616m <= 86400000) {
            return;
        }
        f250616m = currentTimeMillis;
        a(f250614k, currentTimeMillis);
        boolean b16 = b();
        HashMap hashMap = new HashMap();
        hashMap.put("user_uin", str);
        hashMap.put(f250609f, String.valueOf(b16));
        hashMap.put(f250610g, String.valueOf(i3 == 20));
        jVar.a(f250607d, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    @SuppressLint({"MissingPermission"})
    @Nullable
    private static ServiceState a() {
        TelephonyManager createForSubscriptionId;
        if (com.tencent.mobileqq.msf.core.y.a.h().i()) {
            QLog.e(f250604a, 1, "[getServiceState] background access service state. ", new Throwable("BackgroundAccessServiceState"));
            return f250617n;
        }
        ServiceState serviceState = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && serviceState != 0 && b()) {
            try {
                int a16 = c.a(c.a(serviceState));
                if (a16 >= 0) {
                    createForSubscriptionId = serviceState.createForSubscriptionId(a16);
                    serviceState = LocationMonitor.getServiceState(createForSubscriptionId);
                } else {
                    serviceState = LocationMonitor.getServiceState(serviceState);
                }
            } catch (Exception e16) {
                QLog.e(f250604a, 1, "getServiceState throw e", e16);
                serviceState = LocationMonitor.getServiceState(serviceState);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(f250604a, 2, "sdkVersion = " + i3 + ", per = " + b());
            }
            serviceState = 0;
        }
        f250617n = serviceState;
        return serviceState;
    }

    private static boolean b() {
        return BaseApplication.getContext().checkSelfPermission(DeviceInfoUtil.PERMISSION_READ_PHONE) == 0;
    }

    private static void a(com.tencent.mobileqq.msf.core.c0.j jVar, int i3, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 20 || currentTimeMillis - f250615l <= 86400000) {
            return;
        }
        f250615l = currentTimeMillis;
        a(f250613j, currentTimeMillis);
        HashMap hashMap = new HashMap();
        hashMap.put("user_uin", str);
        jVar.a(f250606c, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
    }

    private static long a(String str) {
        return BaseApplication.getContext().getSharedPreferences(f250612i, 0).getLong(str, 0L);
    }

    private static void a(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences(f250612i, 0).edit().putLong(str, j3).apply();
    }
}
