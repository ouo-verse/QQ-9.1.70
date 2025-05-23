package com.tencent.mobileqq.vashealth;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.ads.data.AdParam;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.hippy.HealthModule;
import com.tencent.mobileqq.vashealth.huaweistep.HuaweiStepHelper;
import com.tencent.mobileqq.vashealth.huaweistep.HuaweiStepManager;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReq;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SSOHttpUtils {

    /* renamed from: a, reason: collision with root package name */
    public static float f312183a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public static String f312184b = "";

    /* renamed from: c, reason: collision with root package name */
    public static volatile long f312185c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static String[] f312186d = null;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f312187e = null;

    /* renamed from: f, reason: collision with root package name */
    static String f312188f = null;

    /* renamed from: g, reason: collision with root package name */
    public static volatile int f312189g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static volatile int f312190h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static volatile int f312191i = 0;

    /* renamed from: j, reason: collision with root package name */
    static boolean f312192j = false;

    /* renamed from: k, reason: collision with root package name */
    static String f312193k;

    /* renamed from: l, reason: collision with root package name */
    static String f312194l;

    private static void a(AppRuntime appRuntime, JSONArray jSONArray, boolean z16, int i3, long j3) {
        if (!TextUtils.isEmpty(appRuntime.getAccount()) && jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AdParam.CONSUMERID, 1002);
                jSONObject.put("data", jSONArray);
                jSONObject.put("version", AppSetting.f99551k);
                jSONObject.put("lastRecordTime", j3 / 1000);
                String h16 = h();
                f312188f = h16;
                jSONObject.put("model", h16);
                String j16 = j();
                f312193k = j16;
                jSONObject.put("zone", String.valueOf(j16));
                if (TextUtils.isEmpty(f312194l)) {
                    f312194l = QQDeviceInfo.getQIMEI();
                }
                jSONObject.put("imei", String.valueOf(f312194l));
                int i16 = 1;
                if (i3 == 0 && z16) {
                    QLog.i("SSOHttpUtils", 1, "report with exception_0");
                    jSONObject.put("exception_0", 1);
                }
                jSONObject.put("mode", 1);
                jSONObject.put("stepSource", i3);
                if (!QBaseActivity.mAppForground) {
                    i16 = 0;
                }
                jSONObject.put(com.tencent.mobileqq.msf.core.net.r.a.f248963o, i16);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SSOHttpUtils", 2, "Exception:" + e16.toString());
                }
            }
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.i("SSOHttpUtils", 2, "parameter:" + jSONObject.toString());
            }
            NewIntent newIntent = new NewIntent(appRuntime.getApplication().getApplicationContext(), com.tencent.mobileqq.vashealth.websso.a.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, HealthModule.REPORT_STEP_CMD);
            newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.setObserver(b(appRuntime));
            appRuntime.startServlet(newIntent);
        }
    }

    @NotNull
    private static BusinessObserver b(final AppRuntime appRuntime) {
        return new BusinessObserver() { // from class: com.tencent.mobileqq.vashealth.SSOHttpUtils.1
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                final String str;
                byte[] byteArray;
                if (z16) {
                    try {
                        byteArray = bundle.getByteArray("extra_data");
                    } catch (Exception e16) {
                        QLog.e("SSOHttpUtils", 1, "Parse response exception:" + e16.getMessage());
                    }
                    if (byteArray == null) {
                        QLog.e("SSOHttpUtils", 1, "report failed response data is null");
                        return;
                    }
                    WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                    webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                    QLog.i("SSOHttpUtils", 1, "report result:" + webSSOAgent$UniSsoServerRsp.rspdata.get() + ",ret:" + webSSOAgent$UniSsoServerRsp.ret.get());
                    if (0 == webSSOAgent$UniSsoServerRsp.ret.get()) {
                        NewIntent newIntent = new NewIntent(AppRuntime.this.getApplication(), u.class);
                        newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_UPDATE_LAST_REPORT_TIME);
                        newIntent.putExtra("last_report_time", Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
                        newIntent.putExtra("has_report_yes", Boolean.valueOf(SSOHttpUtils.f312192j));
                        AppRuntime.this.startServlet(newIntent);
                        SSOHttpUtils.f312183a = (SSOHttpUtils.f312189g - SSOHttpUtils.f312190h) + SSOHttpUtils.f312191i;
                        String account = AppRuntime.this.getAccount();
                        if (!TextUtils.isEmpty(account)) {
                            SSOHttpUtils.f312184b = account;
                        }
                        SSOHttpUtils.f312185c = NetConnInfoCenter.getServerTimeMillis();
                        QLog.i("SSOHttpUtils", 1, "SSOHttpUtils do report success steps:" + SSOHttpUtils.f312183a);
                    }
                    com.tencent.mobileqq.vashealth.step.k kVar = com.tencent.mobileqq.vashealth.step.k.f312340a;
                    kVar.r(SSOHttpUtils.f312185c);
                    JSONObject jSONObject = new JSONObject(webSSOAgent$UniSsoServerRsp.rspdata.get());
                    if (jSONObject.has("svr_steps")) {
                        int i16 = jSONObject.getInt("svr_steps");
                        QLog.e("SSOHttpUtils", 1, "step reset from server:" + i16);
                        if (kVar.j()) {
                            com.tencent.mobileqq.vashealth.step.e.f312337a.d(NetConnInfoCenter.getServerTimeMillis(), i16);
                        } else {
                            NewIntent newIntent2 = new NewIntent(AppRuntime.this.getApplication(), u.class);
                            newIntent2.putExtra("msf_cmd_type", StepCounterConstants.CMD_RESET_STEP);
                            newIntent2.putExtra("server_step", i16);
                            AppRuntime.this.startServlet(newIntent2);
                        }
                    }
                    str = "";
                } else {
                    QLog.i("SSOHttpUtils", 1, "SSO sent Failed!!" + bundle.toString());
                    str = bundle.toString();
                }
                final int i17 = -1;
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.SSOHttpUtils.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SSOHttpUtils.v(i17, str);
                    }
                }, 5, null, true);
            }
        };
    }

    public static long c() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTimeInMillis();
    }

    public static long d() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0079, code lost:
    
        if (m(r2) != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0082, code lost:
    
        if (r2.getLong(2) >= r12) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0084, code lost:
    
        r1[0] = r1[0] + r2.getInt(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009b, code lost:
    
        if (r2.moveToNext() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a0, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
    
        r1[1] = r1[1] + r2.getInt(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0115, code lost:
    
        if (r2 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0134, code lost:
    
        return new int[]{-1, -1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012a, code lost:
    
        if (0 != 0) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] e() {
        ContentResolver contentResolver;
        int[] iArr = {0, 0};
        Cursor cursor = null;
        try {
            try {
                if (cu.g()) {
                    Class<?> cls = Class.forName("miui.util.FeatureParser");
                    Object newInstance = cls.newInstance();
                    Method declaredMethod = cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
                    declaredMethod.setAccessible(true);
                    if (r(declaredMethod.invoke(newInstance, "support_steps_provider", Boolean.FALSE)) && (contentResolver = MobileQQ.getMobileQQ().getContentResolver()) != null) {
                        String[] strArr = {String.valueOf(i()), String.valueOf(c())};
                        long d16 = d();
                        cursor = ContactsMonitor.query(contentResolver, k.f312315a, k.f312316b, "_begin_time >= ? AND _end_time <= ? AND (_mode = 2 OR _mode = 3)", strArr, "_id asc");
                    }
                }
                if (StepCounterPermissionUtils.l()) {
                    if (!StepCounterPermissionUtils.h()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return iArr;
                    }
                    Context context = QBaseActivity.sTopActivity;
                    if (context == null) {
                        context = Foreground.getTopActivity();
                    }
                    iArr[1] = new com.vivo.datashare.sport.query.c(context).a();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return iArr;
                }
                if (HuaweiStepHelper.isInHuaWeiSystemWhiteList()) {
                    iArr[1] = HuaweiStepManager.getInstance().queryHuaWeiSdkTodaySteps(iArr[1], false);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return iArr;
                }
                if (com.tencent.mobileqq.vashealth.honorstep.g.f312292a.n()) {
                    iArr[1] = com.tencent.mobileqq.vashealth.honorstep.h.f312298a.a(iArr[1], false);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return iArr;
                }
                if (m43.c.f416147a.c()) {
                    iArr[1] = m43.d.f416148a.a(iArr[1], false);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return iArr;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SSOHttpUtils", 2, "getDeviceSteps error:", e16);
                }
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                cursor.close();
            }
            throw th5;
        }
    }

    private static boolean f(Bundle bundle) {
        if (bundle.containsKey(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG)) {
            return bundle.getBoolean(StepCounterConstants.ATTR_HAS_SHUTDOWN_FLAG);
        }
        return false;
    }

    private static long g(Bundle bundle) {
        if (bundle.containsKey(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME)) {
            return bundle.getLong(StepCounterConstants.ATTR_LAST_SENSOR_EVENT_TIME);
        }
        return 0L;
    }

    private static String h() {
        try {
            if (TextUtils.isEmpty(f312188f)) {
                f312188f = URLEncoder.encode(DeviceInfoMonitor.getModel(), "utf-8");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SSOHttpUtils", 2, "Exception:" + e16.toString());
            }
        }
        return f312188f;
    }

    public static long i() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        calendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        calendar.set(5, calendar.get(5) - 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static String j() {
        try {
            if (TextUtils.isEmpty(f312193k)) {
                TimeZone timeZone = TimeZone.getDefault();
                f312193k = timeZone.getDisplayName(false, 0) + " " + timeZone.getID();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SSOHttpUtils", 2, "Exception:" + e16.toString());
            }
        }
        return f312193k;
    }

    private static void k() {
        if (f312186d == null) {
            f312186d = new String[0];
        }
    }

    private static void l() {
        if (f312187e == null) {
            f312187e = new String[0];
        }
    }

    private static boolean m(Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

    public static boolean n(int i3) {
        if (i3 > 0) {
            return true;
        }
        return false;
    }

    private static boolean o(File file) {
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    public static boolean p(int i3, String str) {
        if (q()) {
            File file = new File(MobileQQ.getMobileQQ().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
            if (o(file)) {
                w(FileUtils.readFileContent(file));
            }
            k();
            l();
        }
        if (i3 == 1) {
            if (x(str, f312186d)) {
                if (QLog.isColorLevel()) {
                    QLog.i("SSOHttpUtils", 2, "login report found current uin banned!");
                }
                return false;
            }
        } else if (i3 == 2 && x(str, f312187e)) {
            if (QLog.isColorLevel()) {
                QLog.i("SSOHttpUtils", 2, "timmer report found current uin banned!");
            }
            return false;
        }
        return true;
    }

    private static boolean q() {
        if (f312186d != null && f312187e != null) {
            return false;
        }
        return true;
    }

    private static boolean r(Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            return true;
        }
        return false;
    }

    private static boolean s(Map<Long, Integer> map) {
        if (map != null && !map.isEmpty()) {
            return false;
        }
        return true;
    }

    private static JSONObject t(int i3, long j3, int i16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i3);
            jSONObject.put("time", j3);
            jSONObject.put("steps", i16);
            return jSONObject;
        } catch (JSONException e16) {
            QLog.e("SSOHttpUtils", 1, "error read step count from step history", e16);
            return null;
        }
    }

    public static void u(AppRuntime appRuntime, Bundle bundle) {
        Map map;
        int i3;
        if (bundle != null && appRuntime != null) {
            g43.b bVar = (g43.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("106050");
            if (bVar != null && bVar.getFellowStepReport() && !((IQQHealthApi) QRoute.api(IQQHealthApi.class)).isSubscribedHealthPA()) {
                QLog.w("SSOHttpUtils", 1, "no fellow to report");
                return;
            }
            if (bundle.containsKey(StepCounterConstants.ATTR_STEP_COUNT_HISTORY)) {
                map = (Map) bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
            } else {
                map = null;
            }
            int i16 = e()[1];
            if (s(map) && i16 <= 0) {
                QLog.w("SSOHttpUtils", 1, "step count history is null or empty, no data to report");
                return;
            }
            if (map == null) {
                map = new HashMap();
            }
            long d16 = d() / 1000;
            if (map.containsKey(Long.valueOf(d16)) && map.get(Long.valueOf(d16)) != null) {
                f312189g = ((Integer) map.get(Long.valueOf(d16))).intValue();
            }
            JSONArray jSONArray = new JSONArray();
            if (map.get(Long.valueOf(d16)) != null && !n(i16)) {
                i3 = 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SSOHttpUtils", 2, "get step from manufacturer: " + i16 + " , sensor value:" + map.get(Long.valueOf(d16)));
                }
                map.remove(Long.valueOf(d16));
                f312189g = i16;
                JSONObject t16 = t(1, NetConnInfoCenter.getServerTime(), i16);
                if (t16 != null) {
                    jSONArray.mo162put(t16);
                }
                i3 = 1;
            }
            boolean f16 = f(bundle);
            long g16 = g(bundle);
            for (Map.Entry entry : map.entrySet()) {
                JSONObject t17 = t(1, ((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                if (t17 != null) {
                    jSONArray.mo162put(t17);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SSOHttpUtils", 2, "ready for new step counter report, data:" + jSONArray.toString() + ", hasShutdown:" + f16 + " , stepSource:" + i3 + " , lastRecordTime:" + g16);
            }
            a(appRuntime, jSONArray, f16, i3, g16);
            return;
        }
        QLog.w("SSOHttpUtils", 1, "report params is null");
    }

    public static void v(int i3, String str) {
        String str2;
        String str3 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        int networkType = NetworkUtil.getNetworkType(BaseApplication.context);
        if (networkType != -1) {
            if (networkType != 0) {
                if (networkType != 1) {
                    if (networkType != 2) {
                        if (networkType != 3) {
                            if (networkType == 4) {
                                str3 = QADNetStatus.G_4;
                            }
                        } else {
                            str3 = QADNetStatus.G_3;
                        }
                    } else {
                        str3 = QADNetStatus.G_2;
                    }
                } else {
                    str3 = "wifi";
                }
            } else {
                str3 = "no_network";
            }
        } else {
            str3 = "unknown";
        }
        ReportController.n(null, "P_CliOper", "HealthStepReport", "", "ReportResult", str3, i3, 1, f312191i, String.valueOf(f312190h), String.valueOf(f312189g), str2, DeviceInfoMonitor.getModel());
    }

    private static void w(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("login_report");
                if (!TextUtils.isEmpty(optString)) {
                    f312186d = optString.split(",");
                }
                String optString2 = jSONObject.optString("timmer_report");
                if (!TextUtils.isEmpty(optString2)) {
                    f312187e = optString2.split(",");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SSOHttpUtils", 2, "parse json failed:" + e16.toString());
                }
            }
        }
    }

    private static boolean x(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.endsWith(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
