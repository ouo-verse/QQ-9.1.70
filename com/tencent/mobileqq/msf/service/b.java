package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.wtlogin.MsfWtloginPrivacyListenerImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qmethod.pandoraex.api.r;
import com.tencent.qmethod.pandoraex.core.s;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f250798a = "AppCloneHandler";

    /* renamed from: b, reason: collision with root package name */
    private static final String f250799b = "appCloneSp";

    /* renamed from: c, reason: collision with root package name */
    private static final String f250800c = "firstInstallTime";

    /* renamed from: d, reason: collision with root package name */
    private static final String f250801d = "lastGetAndroidIdTime";

    /* renamed from: e, reason: collision with root package name */
    private static final String f250802e = "isReportSameAndroidId";

    /* renamed from: f, reason: collision with root package name */
    private static final String f250803f = "isReportSame";

    /* renamed from: g, reason: collision with root package name */
    private static final String f250804g = "model";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250805h = "qimei";

    /* renamed from: i, reason: collision with root package name */
    private static final long f250806i = 3600;

    /* renamed from: j, reason: collision with root package name */
    public static final String f250807j = "appCloneCheck";

    /* renamed from: k, reason: collision with root package name */
    public static final String f250808k = "appCloneExtra";

    /* renamed from: l, reason: collision with root package name */
    public static final String f250809l = "oldAndroidId";

    /* renamed from: m, reason: collision with root package name */
    public static final String f250810m = "newAndroidID";

    /* renamed from: n, reason: collision with root package name */
    public static final String f250811n = "oldFirstInstallTime";

    /* renamed from: o, reason: collision with root package name */
    public static final String f250812o = "newFirstInstallTime";

    /* renamed from: p, reason: collision with root package name */
    public static final String f250813p = "oldModel";

    /* renamed from: q, reason: collision with root package name */
    public static final String f250814q = "newModel";

    /* renamed from: r, reason: collision with root package name */
    public static final String f250815r = "oldQimei";

    /* renamed from: s, reason: collision with root package name */
    public static final String f250816s = "newQimei";

    /* renamed from: t, reason: collision with root package name */
    public static final String f250817t = "user_id";

    /* renamed from: u, reason: collision with root package name */
    private static final String f250818u = "102264";

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long e16 = e();
        QLog.d(f250798a, 1, "currentTime = " + currentTimeMillis + " lastGetAndroidIdTime = " + e16);
        if (e16 != 0 && Math.abs(currentTimeMillis - e16) <= 3600) {
            return false;
        }
        b(currentTimeMillis);
        return true;
    }

    public static String b(Context context) {
        try {
            return DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Throwable th5) {
            QLog.e(f250798a, 1, th5, new Object[0]);
            return null;
        }
    }

    private static long c(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e16) {
            QLog.e(f250798a, 1, e16, new Object[0]);
            return 0L;
        }
    }

    public static void d(Context context) {
        try {
            QLog.d(f250798a, 1, "AppClone: checkCloneBehavior");
            if (e(context)) {
                a(context);
                h();
            }
        } catch (Exception e16) {
            QLog.e(f250798a, 1, e16, new Object[0]);
        }
    }

    private static boolean e(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        long c16 = c(context);
        long b16 = b();
        QLog.d(f250798a, 1, "newFirstInstallTime:" + c16 + " ,oldFirstInstallTime:" + b16);
        String f16 = f();
        String g16 = g();
        String beaconAppKey = BaseApplication.getContext().getMSFInterfaceAdapter().getBeaconAppKey();
        if (TextUtils.isEmpty(f16) && TextUtils.isEmpty(g16)) {
            a(DeviceInfoMonitor.getModel());
            b(QimeiSDK.getInstance(beaconAppKey).getQimei().getQimei36());
        }
        if (c16 <= 0 || c16 == b16) {
            return false;
        }
        if (b16 <= 0) {
            a(c16);
            return false;
        }
        if (!a()) {
            return false;
        }
        String b17 = b(context);
        String identification = RealIdentificationInfoUtil.getIdentification(context);
        QLog.d(f250798a, 1, "oldAndroidID:" + b17 + " ,newAndroidID:" + identification);
        boolean z16 = TextUtils.isEmpty(b17) || TextUtils.isEmpty(identification) || b17.equals(identification);
        String model = RealIdentificationInfoUtil.getModel();
        boolean z17 = TextUtils.isEmpty(f16) || TextUtils.isEmpty(model) || f16.equals(model);
        QLog.d(f250798a, 1, "oldModel:" + f16 + " ,newModel:" + model);
        String qimei36 = QimeiSDK.getInstance(beaconAppKey).getQimei().getQimei36();
        boolean z18 = TextUtils.isEmpty(qimei36) || TextUtils.isEmpty(g16) || qimei36.equals(g16);
        QLog.d(f250798a, 1, "oldQimei:" + g16 + " ,newQimei:" + qimei36);
        if ((z16 || z17 || z18) && !c()) {
            str = qimei36;
            str2 = model;
            str3 = identification;
            str4 = b17;
            if (a(b16, c16, b17, identification, f16, str2, g16, str)) {
                a(true);
            }
        } else {
            str = qimei36;
            str2 = model;
            str3 = identification;
            str4 = b17;
        }
        if (z16) {
            if (!d() && a(b16, c16, str4, str3)) {
                b(true);
            }
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isSwitchOn(f250818u, false) || z17) {
                return false;
            }
        }
        a(c16);
        b(str);
        a(str2);
        a(b16, c16, str4, str3);
        return true;
    }

    private static String f() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getString("model", "");
    }

    private static String g() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getString("qimei", "");
    }

    private static void h() {
        com.tencent.mobileqq.msf.core.o.u();
        MsfWtloginPrivacyListenerImpl.getSingleton().resetDeviceModelCache();
        QLog.d(f250798a, 1, "AppClone: old guid =" + util.buf_to_string(NetConnInfoCenter.GUID));
        com.tencent.mobileqq.msf.core.auth.i.f247480n.clearAllSigAndUpdateGuid();
        NetConnInfoCenter.GUID = com.tencent.mobileqq.msf.core.auth.i.f247480n.GetGuid();
        QLog.d(f250798a, 1, "AppClone: new guid =" + util.buf_to_string(NetConnInfoCenter.GUID));
        FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), MsfService.getCore().getNextSeq(), "0", BaseConstants.CMD_APP_CLONE);
        fromServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
        fromServiceMsg.setBusinessFail(3003);
        MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
        MsfService.getCore().addRespToQuque(null, fromServiceMsg);
    }

    private static long b() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getLong(f250800c, 0L);
    }

    private static boolean c() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getBoolean(f250803f, false);
    }

    private static void b(String str) {
        QLog.d(f250798a, 1, "updateQimeiToSp qimei = " + str);
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putString("qimei", str).apply();
    }

    private static boolean a(long j3, long j16, String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(f250809l, str);
            hashMap.put(f250810m, str2);
            hashMap.put(f250811n, String.valueOf(j3));
            hashMap.put(f250812o, String.valueOf(j16));
            hashMap.put(f250813p, str3);
            hashMap.put(f250814q, str4);
            hashMap.put(f250815r, str5);
            hashMap.put(f250816s, str6);
            hashMap.put("user_id", MsfService.getCore().getAccountCenter().e());
            MsfService.getCore().statReporter.a(f250808k, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            return true;
        } catch (Exception e16) {
            QLog.e(f250798a, 1, e16, new Object[0]);
            return false;
        }
    }

    private static boolean d() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getBoolean(f250802e, false);
    }

    private static void b(long j3) {
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putLong(f250801d, j3).apply();
    }

    private static void b(boolean z16) {
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putBoolean(f250802e, z16).apply();
    }

    private static boolean a(long j3, long j16, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(f250809l, str);
            hashMap.put(f250810m, str2);
            hashMap.put(f250811n, String.valueOf(j3));
            hashMap.put(f250812o, String.valueOf(j16));
            hashMap.put("user_id", MsfService.getCore().getAccountCenter().e());
            MsfService.getCore().statReporter.a(f250807j, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            return true;
        } catch (Exception e16) {
            QLog.e(f250798a, 1, e16, new Object[0]);
            return false;
        }
    }

    private static void a(long j3) {
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putLong(f250800c, j3).apply();
    }

    private static void a(String str) {
        QLog.d(f250798a, 1, "updateModelToSp model = " + str);
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putString("model", str).apply();
    }

    private static void a(boolean z16) {
        BaseApplication.getContext().getSharedPreferences(f250799b, 0).edit().putBoolean(f250803f, z16).apply();
    }

    private static void a(Context context) {
        r.a(context);
        r.b();
        s.c(true);
        r.p(context, "version", "1");
    }

    private static long e() {
        return BaseApplication.getContext().getSharedPreferences(f250799b, 0).getLong(f250801d, 0L);
    }
}
