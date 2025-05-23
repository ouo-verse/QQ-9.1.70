package com.tencent.beacon.event.open;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.avbiz.Constants;
import com.tencent.beacon.a.a.c;
import com.tencent.beacon.a.b.h;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.c.j;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.beacon.base.util.e;
import com.tencent.beacon.core.info.BeaconPubParams;
import com.tencent.beacon.event.c.d;
import com.tencent.beacon.event.immediate.IBeaconImmediateReport;
import com.tencent.beacon.event.open.EventResult;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.EventModule;
import com.tencent.beacon.module.ModuleName;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.smtt.export.external.TbsCoreSettings;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class BeaconReport {

    /* renamed from: a, reason: collision with root package name */
    private static volatile BeaconReport f78043a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f78044b = "";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f78045c = false;

    /* renamed from: d, reason: collision with root package name */
    private Context f78046d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f78047e;

    /* renamed from: f, reason: collision with root package name */
    private IBeaconImmediateReport f78048f;

    /* renamed from: g, reason: collision with root package name */
    private EventModule f78049g;

    BeaconReport() {
        synchronized (BeaconReport.class) {
            if (!f78045c) {
                f78045c = true;
            } else {
                throw new RuntimeException("\u5355\u4f8b\u6a21\u5f0f\u88ab\u4fb5\u72af\uff01");
            }
        }
    }

    private void b(BeaconConfig beaconConfig) {
        HashMap hashMap = new HashMap();
        hashMap.put("u_c_r_p", Long.valueOf(beaconConfig.getRealtimePollingTime()));
        hashMap.put("u_c_n_p", Long.valueOf(beaconConfig.getNormalPollingTIme()));
        com.tencent.beacon.a.a.b.a().b(new c(11, hashMap));
    }

    private void c(BeaconConfig beaconConfig) {
        if (beaconConfig != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("u_c_a_e", Boolean.valueOf(beaconConfig.isAuditEnable()));
                hashMap.put("u_c_b_e", Boolean.valueOf(beaconConfig.isBidEnable()));
                hashMap.put("u_c_d_s", Integer.valueOf(beaconConfig.getMaxDBCount()));
                hashMap.put("u_c_p_s", Boolean.valueOf(beaconConfig.isPagePathEnable()));
                hashMap.put("u_s_o_h", Boolean.valueOf(beaconConfig.isSocketMode()));
                com.tencent.beacon.a.a.b.a().b(new c(8, hashMap));
            } catch (Throwable th5) {
                i.e().a(ThemeReporter.FROM_NIGHT, "sdk init error! package name: " + com.tencent.beacon.a.c.b.b() + " , msg:" + th5.getMessage(), th5);
                com.tencent.beacon.base.util.c.a(th5);
            }
        }
    }

    private void d(BeaconConfig beaconConfig) {
        f e16 = f.e();
        if (!TextUtils.isEmpty(beaconConfig.getAndroidID())) {
            e16.a(beaconConfig.getAndroidID());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImei())) {
            e16.b(beaconConfig.getImei());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImei2())) {
            e16.c(beaconConfig.getImei2());
        }
        if (!TextUtils.isEmpty(beaconConfig.getImsi())) {
            e16.d(beaconConfig.getImsi());
        }
        if (!TextUtils.isEmpty(beaconConfig.getMeid())) {
            e16.f(beaconConfig.getMeid());
        }
        if (!TextUtils.isEmpty(beaconConfig.getModel())) {
            e16.g(beaconConfig.getModel());
        }
        if (!TextUtils.isEmpty(beaconConfig.getMac())) {
            e16.e(beaconConfig.getMac());
        }
        if (!TextUtils.isEmpty(beaconConfig.getWifiMacAddress())) {
            e16.i(beaconConfig.getWifiMacAddress());
        }
        if (!TextUtils.isEmpty(beaconConfig.getWifiSSID())) {
            e16.j(beaconConfig.getWifiSSID());
        }
        if (!TextUtils.isEmpty(beaconConfig.getOaid())) {
            e16.h(beaconConfig.getOaid());
        }
    }

    public static BeaconReport getInstance() {
        if (f78043a == null) {
            synchronized (BeaconReport.class) {
                if (f78043a == null) {
                    f78043a = new BeaconReport();
                }
            }
        }
        return f78043a;
    }

    public static String getSoPath() {
        return f78044b;
    }

    public static void setSoPath(String str) {
        f78044b = str;
    }

    public void disableReport() {
        com.tencent.beacon.d.b.a().a(false, true);
    }

    public void enableReport() {
        com.tencent.beacon.d.b.a().a(true, true);
    }

    public BeaconPubParams getCommonParams(Context context) {
        if (context == null) {
            return null;
        }
        return BeaconPubParams.getPubParams(context);
    }

    public IBeaconImmediateReport getImmediateReport() {
        return this.f78048f;
    }

    @Deprecated
    public String getOAID() {
        com.tencent.beacon.base.util.c.b("this method do not collect OAID, use method in qmsp instead", new Object[0]);
        return f.e().i();
    }

    @Nullable
    public Qimei getQimei(@NonNull String str) {
        return j.b(str);
    }

    @Nullable
    public Qimei getRtQimei(Context context, @NonNull String str) {
        return j.b(context, str);
    }

    public String getSDKVersion() {
        return "4.2.84.3-qqvideo6";
    }

    public void pauseUpload(boolean z16) {
        EventModule eventModule = this.f78049g;
        if (eventModule != null && eventModule.e()) {
            this.f78049g.b(z16);
        }
    }

    public EventResult report(BeaconEvent beaconEvent) {
        try {
            if (!com.tencent.beacon.d.b.a().g()) {
                com.tencent.beacon.base.util.c.e("BeaconReport not enable report! event: %s", beaconEvent.getCode());
                return EventResult.a.a(102);
            }
            if (TextUtils.isEmpty(beaconEvent.getCode())) {
                return EventResult.a.a(106);
            }
            BeaconEvent build = BeaconEvent.newBuilder(beaconEvent).build();
            EventModule eventModule = this.f78049g;
            if (eventModule != null && eventModule.e()) {
                return this.f78049g.a(build);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("b_e", build);
            com.tencent.beacon.a.a.b.a().a(new c(6, hashMap));
            return new EventResult(0, -1L, "Beacon SDK not init beaconEvent add to cache!");
        } catch (Throwable th5) {
            com.tencent.beacon.base.util.c.a(th5);
            i.e().a("598", "error while report", th5);
            return new EventResult(199, -1L, "REPORT ERROR");
        }
    }

    @Deprecated
    public void resumeReport() {
        resumeUpload();
    }

    public void resumeUpload() {
        EventModule eventModule = this.f78049g;
        if (eventModule != null && eventModule.e()) {
            this.f78049g.f();
        }
    }

    @Deprecated
    public void setAdditionalParams(@NonNull Map<String, String> map) {
        setAdditionalParams(com.tencent.beacon.a.c.c.c().e(), map);
    }

    public void setAndroidID(String str) {
        f.e().a(str);
    }

    public void setAppVersion(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.beacon.a.c.b.f77630a = str;
        }
    }

    @Deprecated
    public boolean setChannelID(String str) {
        return setChannelID(com.tencent.beacon.a.c.c.c().e(), str);
    }

    @Deprecated
    public void setCollectAndroidID(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectAndroidID has been Deprecated", new Object[0]);
    }

    @Deprecated
    public void setCollectImei(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectImei has been Deprecated", new Object[0]);
    }

    @Deprecated
    public void setCollectMac(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectMac has been Deprecated", new Object[0]);
    }

    @Deprecated
    public void setCollectModel(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectModel has been Deprecated", new Object[0]);
    }

    @Deprecated
    public void setCollectOAID(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectOAID has been Deprecated", new Object[0]);
    }

    @Deprecated
    public void setCollectPersonalInfo(boolean z16) {
        com.tencent.beacon.base.util.c.b("setCollectPersonalInfo has been Deprecated", new Object[0]);
    }

    public void setCollectProcessInfo(boolean z16) {
        com.tencent.beacon.d.b.a().c(z16);
    }

    public void setImei(String str) {
        f.e().b(str);
    }

    public void setImei2(String str) {
        f.e().c(str);
    }

    public void setImmediateReport(IBeaconImmediateReport iBeaconImmediateReport) {
        this.f78048f = iBeaconImmediateReport;
    }

    public void setImsi(String str) {
        f.e().d(str);
    }

    public void setLogAble(boolean z16) {
        com.tencent.beacon.base.util.c.a(z16);
    }

    public void setLogger(BeaconLogger beaconLogger) {
        com.tencent.beacon.base.util.c.a(beaconLogger);
    }

    public void setMac(String str) {
        f.e().e(str);
    }

    public void setMeid(String str) {
        f.e().f(str);
    }

    public void setModel(String str) {
        f.e().g(str);
    }

    public void setOAID(String str) {
        f.e().h(str);
    }

    @Deprecated
    public void setOaid(String str) {
        f.e().h(str);
        com.tencent.beacon.base.util.c.b("setOaid has been Deprecated, please use setOAID", new Object[0]);
    }

    public void setOmgID(String str) {
        com.tencent.beacon.a.c.c.c().d(str);
    }

    public void setOpenID(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("i_c_ak", str);
        hashMap.put("i_c_o_i", str2);
        com.tencent.beacon.a.a.b.a().b(new c(5, hashMap));
    }

    public void setQQ(String str) {
        com.tencent.beacon.a.c.b.a(str);
    }

    public void setQimei(String str, String str2) {
        j.a(str, str2);
    }

    public void setQimeiSdkVersion(String str) {
        j.c(str);
    }

    public void setStrictMode(boolean z16) {
        e.f77791a.set(z16);
    }

    @Deprecated
    public void setUserID(String str) {
        setUserID(com.tencent.beacon.a.c.c.c().e(), str);
    }

    public void setUserSampleEvents(String str, Map<String, Integer> map) {
        com.tencent.beacon.d.b.a().a(str, map);
    }

    public void setWifiMacAddress(String str) {
        f.e().i(str);
    }

    public void setWifiSSID(String str) {
        f.e().j(str);
    }

    public synchronized void start(@NonNull Context context, @NonNull String str, @Nullable BeaconConfig beaconConfig) throws BeaconInitException {
        boolean z16;
        String c16 = com.tencent.beacon.a.c.b.c(context);
        String t16 = com.tencent.beacon.a.c.e.l().t();
        String h16 = f.e().h();
        boolean z17 = false;
        Log.d("beacon", String.format("QQ fix, get current processName: %s osVer: %s model: %s;", c16, t16, h16));
        if (c16 != null && t16 != null && h16 != null && c16.equals(Constants.Process.VIDEO_PROCESS) && ((t16.startsWith("Android 6") || t16.startsWith("Android 5")) && (h16.toLowerCase().startsWith("oppo") || h16.toLowerCase().startsWith(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)))) {
            Log.d("beacon", "QQ fix, interrupt start");
            disableReport();
            return;
        }
        if (this.f78047e) {
            a(str, String.format("don't init beacon twice!! 1: %s, 2: %s", com.tencent.beacon.a.c.c.c().e(), str), ThemeReporter.FROM_INIT_THEME);
            return;
        }
        e.a("Context", context);
        if (context == null) {
            com.tencent.beacon.base.util.c.b("fail to start beacon, context is null", new Object[0]);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f78046d = applicationContext;
        e.a("ApplicationContext", applicationContext);
        if (this.f78046d == null) {
            com.tencent.beacon.base.util.c.b("fail to start beacon, application context is null", new Object[0]);
            return;
        }
        com.tencent.beacon.a.c.c.c().a(this.f78046d);
        e.a(TbsCoreSettings.TBS_SETTINGS_APP_KEY, str);
        if (TextUtils.isEmpty(str)) {
            com.tencent.beacon.base.util.c.b("fail to start beacon, appkey is empty", new Object[0]);
            return;
        }
        com.tencent.beacon.a.c.c.c().c(a(context, str));
        Log.i("beacon", "logAble: " + com.tencent.beacon.base.util.c.b() + " , SDKVersion: " + getSDKVersion());
        i e16 = i.e();
        if (beaconConfig != null && beaconConfig.isForceEnableAtta()) {
            z16 = true;
        } else {
            z16 = false;
        }
        e16.a(z16);
        h e17 = h.e();
        if (beaconConfig != null && beaconConfig.isForceEnableAtta()) {
            z17 = true;
        }
        e17.a(z17);
        ((Application) this.f78046d).registerActivityLifecycleCallbacks(new com.tencent.beacon.b.a());
        c(beaconConfig);
        if (beaconConfig != null) {
            d(beaconConfig);
            j.a(beaconConfig.isNeedInitQimei());
            com.tencent.beacon.d.b.a().b(beaconConfig.needReportRqdEvent());
            com.tencent.beacon.d.b.a().a(beaconConfig.needAttaReport());
        }
        com.tencent.beacon.a.b.a.a().a(new b(this, beaconConfig));
        this.f78047e = true;
    }

    @Deprecated
    public void stopReport(boolean z16) {
        pauseUpload(z16);
    }

    public void getQimei(@NonNull String str, @NonNull Context context, IAsyncQimeiListener iAsyncQimeiListener) {
        j.a(str, context, iAsyncQimeiListener);
    }

    public void setAdditionalParams(String str, @NonNull Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("i_c_ad", new HashMap(map));
        hashMap.put("i_c_ak", str);
        com.tencent.beacon.a.a.b.a().b(new c(3, hashMap));
    }

    public boolean setChannelID(@NonNull String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.tencent.beacon.a.c.c.c().a(str, str2);
        return true;
    }

    public void setUserID(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("i_c_ak", str);
        hashMap.put("i_c_u_i", str2);
        com.tencent.beacon.a.a.b.a().b(new c(4, hashMap));
    }

    private String a(Context context, String str) throws BeaconInitException {
        String str2;
        if (!BeaconReport.class.getPackage().getName().startsWith("com.tencent.beacon")) {
            return str;
        }
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BEACON_MAIN_APPKEY");
        } catch (Exception unused) {
            com.tencent.beacon.base.util.c.e("not set MAIN_APPKEY in manifest.xml", new Object[0]);
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!str.equals(str2)) {
            a(str, "appKey in manifest.xml and start-params is conflicted", ThemeReporter.FROM_ENGINE);
        }
        return str2;
    }

    private void a(String str, String str2, String str3) throws BeaconInitException {
        if (!com.tencent.beacon.base.util.c.b()) {
            Log.e("BeaconReport", str2);
            i.e().a(str, str3, str2);
            return;
        }
        throw new BeaconInitException(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BeaconConfig beaconConfig) {
        if (beaconConfig != null) {
            com.tencent.beacon.base.util.c.a("BeaconReport", beaconConfig.toString(), new Object[0]);
            com.tencent.beacon.base.net.b.b.a(beaconConfig.getConfigHost(), beaconConfig.getUploadHost());
            b(beaconConfig);
            com.tencent.beacon.a.c.c.c().a(beaconConfig.isEnableQmsp());
            com.tencent.beacon.d.b.a().b(beaconConfig.getRealtimeUploadNum());
            com.tencent.beacon.d.b.a().a(beaconConfig.getNormalUploadNum());
        }
        com.tencent.beacon.base.net.c.c().a(this.f78046d, beaconConfig == null ? null : beaconConfig.getHttpAdapter());
        com.tencent.beacon.a.d.a.a().a(this.f78046d);
        com.tencent.beacon.a.c.b.f();
        com.tencent.beacon.a.c.e.l().C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ModuleName[] values = ModuleName.values();
        for (ModuleName moduleName : values) {
            try {
                BeaconModule.f78053a.put(moduleName, d.f(moduleName.getClassName()));
            } catch (Exception e16) {
                com.tencent.beacon.base.util.c.b("init Module error: " + e16.getMessage(), new Object[0]);
                com.tencent.beacon.base.util.c.a(e16);
            }
        }
        for (ModuleName moduleName2 : values) {
            BeaconModule beaconModule = BeaconModule.f78053a.get(moduleName2);
            if (beaconModule != null) {
                beaconModule.a(this.f78046d);
            }
        }
        this.f78049g = (EventModule) com.tencent.beacon.a.c.c.c().a(ModuleName.EVENT);
    }
}
