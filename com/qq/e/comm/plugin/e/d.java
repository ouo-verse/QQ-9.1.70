package com.qq.e.comm.plugin.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.bb;
import com.qq.e.comm.plugin.k.j;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.xweb.internal.ConstValue;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f39354a = new d();

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f39357d;

    /* renamed from: b, reason: collision with root package name */
    private final Object f39355b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f39356c = false;

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<Integer, String> f39358e = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (e.a().b() != null && context != null) {
            a aVar = a.f39337a;
            aVar.a(context, true);
            JSONObject b16 = aVar.b();
            if (!y.a(b16)) {
                GDTLogger.d("empty fileCache");
                return;
            }
            ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
            try {
                a(a(b16, "imei"), concurrentHashMap, 101);
                a(a(b16, "imei0"), concurrentHashMap, 102);
                a(a(b16, "imei1"), concurrentHashMap, 103);
                a(b.a(a(b16, "deviceIdOrigin")), concurrentHashMap, 110);
                a(a(b16, "deviceId0"), concurrentHashMap, 111);
                a(a(b16, "deviceId1"), concurrentHashMap, 112);
                a(a(b16, "meid"), concurrentHashMap, 107);
                a(a(b16, "meid0"), concurrentHashMap, 108);
                a(a(b16, "meid1"), concurrentHashMap, 109);
                a(a(b16, "subscriberId"), concurrentHashMap, 104);
                a(b.b(a(b16, "androidIdOrigin")), concurrentHashMap, 115);
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
            e.a().a(concurrentHashMap);
            return;
        }
        GDTLogger.d("Gatherer is not init or context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:10|(1:12)(1:50)|13|(2:14|15)|(11:17|18|(1:20)|21|(1:23)(1:45)|24|25|26|27|2f5|32)|47|18|(0)|21|(0)(0)|24|25|26|27|2f5) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x02ac, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02ad, code lost:
    
        com.qq.e.comm.util.GDTLogger.e("GathererDeviceInfo add appId error NumberFormatException", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x02b4, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x02b5, code lost:
    
        com.qq.e.comm.util.GDTLogger.e("GathererDeviceInfo add appId error JSONException", r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c(int i3, c cVar) throws JSONException {
        int i16;
        String b16;
        Pair<Integer, Integer> c16;
        int intValue;
        int intValue2;
        if (e.a().b() == null || !this.f39356c) {
            a(GDTADManager.getInstance().getAppContext());
        }
        JSONObject jSONObject = new JSONObject();
        GDTADManager gDTADManager = GDTADManager.getInstance();
        if (gDTADManager == null) {
            GDTLogger.e("GathererDeviceInfo gdtAdManager is null");
            return jSONObject;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Context appContext = gDTADManager.getAppContext();
        e.a().d();
        Map<Integer, com.tencent.gathererga.tangram.d> c17 = e.a().c();
        a(ConstValue.INVOKE_RUNTIME_ID_SET_PROXY_OVERRIDE, System.currentTimeMillis() - currentTimeMillis, 0);
        com.qq.e.comm.plugin.e.a.d.a().b();
        com.qq.e.comm.plugin.e.a.d.a().a(c17);
        String b17 = com.qq.e.comm.plugin.e.a.d.a().b(110, true);
        jSONObject.putOpt("m1", b17);
        jSONObject.putOpt("muid", b17);
        this.f39358e.put(110, b17);
        if (!TextUtils.isEmpty(b17)) {
            jSONObject.putOpt("muidtype", 1);
        } else {
            jSONObject.putOpt("muidtype", 0);
        }
        String b18 = com.qq.e.comm.plugin.e.a.d.a().b(115, true);
        jSONObject.putOpt("m3", b18);
        this.f39358e.put(115, b18);
        int a16 = com.qq.e.comm.plugin.e.a.d.a().a(312, false, NetworkType.UNKNOWN.getConnValue());
        jSONObject.putOpt("conn", Integer.valueOf(a16));
        this.f39358e.put(312, String.valueOf(a16));
        String b19 = com.qq.e.comm.plugin.e.a.d.a().b(313, false);
        jSONObject.putOpt("cell_native", b19);
        this.f39358e.put(313, b19);
        String b26 = com.qq.e.comm.plugin.e.a.d.a().b(305, false);
        try {
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        if (!TextUtils.isEmpty(b26)) {
            i16 = Integer.parseInt(b26);
            jSONObject.putOpt("carrier_code", Integer.valueOf(i16));
            this.f39358e.put(305, b26);
            jSONObject.putOpt("c_os", "android");
            String b27 = com.qq.e.comm.plugin.e.a.d.a().b(403, false);
            jSONObject.putOpt("c_osver", b27);
            this.f39358e.put(403, b27);
            b16 = com.qq.e.comm.plugin.e.a.d.a().b(414, false);
            if (!TextUtils.isEmpty(b16)) {
                jSONObject.putOpt("m_os", b16);
                this.f39358e.put(414, b16);
            }
            String b28 = com.qq.e.comm.plugin.e.a.d.a().b(501, false);
            jSONObject.putOpt("c_pkgname", b28);
            this.f39358e.put(501, b28);
            String b29 = com.qq.e.comm.plugin.e.a.d.a().b(117, false);
            jSONObject.putOpt("c_device", b29);
            this.f39358e.put(117, b29);
            jSONObject.putOpt("c_devicetype", Integer.valueOf(ak.a(appContext)));
            String b36 = com.qq.e.comm.plugin.e.a.d.a().b(116, false);
            jSONObject.putOpt("c_mf", b36);
            this.f39358e.put(116, b36);
            c16 = com.qq.e.comm.plugin.e.a.d.a().c(119, false);
            if (((Integer) c16.first).intValue() <= ((Integer) c16.second).intValue()) {
                intValue = ((Integer) c16.second).intValue();
                intValue2 = ((Integer) c16.first).intValue();
            } else {
                intValue = ((Integer) c16.first).intValue();
                intValue2 = ((Integer) c16.second).intValue();
            }
            this.f39358e.put(Integer.valueOf(QzoneCoverConst.MSG_COVER_INVALIDATE), String.valueOf(intValue));
            this.f39358e.put(1191, String.valueOf(intValue2));
            jSONObject.putOpt("c_w", Integer.valueOf(intValue));
            jSONObject.putOpt("c_h", Integer.valueOf(intValue2));
            jSONObject.putOpt("sdkver", SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
            a(jSONObject, appContext);
            String b37 = com.qq.e.comm.plugin.e.a.d.a().b(2, false);
            String b38 = com.qq.e.comm.plugin.e.a.d.a().b(1, false);
            jSONObject.putOpt("m11", b37);
            jSONObject.putOpt("m10", b38);
            this.f39358e.put(2, b37);
            this.f39358e.put(1, b38);
            jSONObject.putOpt("deep_link_version", 1);
            jSONObject.putOpt("source_from", Integer.valueOf(Integer.parseInt(GDTADManager.getInstance().getAppStatus().getAPPID())));
            long currentTimeMillis2 = System.currentTimeMillis();
            jSONObject.put("wx_api_ver", bb.b());
            jSONObject.put("opensdk_ver", bb.d());
            a(ConstValue.INVOKE_RUNTIME_ID_MEMORY_DUMP, System.currentTimeMillis() - currentTimeMillis2, 6000);
            jSONObject.put("device_ext", d(i3, cVar));
            com.qq.e.comm.plugin.base.a.a.a().a(this.f39358e);
            synchronized (this.f39355b) {
                try {
                    this.f39357d = new JSONObject(jSONObject.toString());
                } finally {
                    return jSONObject;
                }
            }
            return jSONObject;
        }
        i16 = 0;
        jSONObject.putOpt("carrier_code", Integer.valueOf(i16));
        this.f39358e.put(305, b26);
        jSONObject.putOpt("c_os", "android");
        String b272 = com.qq.e.comm.plugin.e.a.d.a().b(403, false);
        jSONObject.putOpt("c_osver", b272);
        this.f39358e.put(403, b272);
        b16 = com.qq.e.comm.plugin.e.a.d.a().b(414, false);
        if (!TextUtils.isEmpty(b16)) {
        }
        String b282 = com.qq.e.comm.plugin.e.a.d.a().b(501, false);
        jSONObject.putOpt("c_pkgname", b282);
        this.f39358e.put(501, b282);
        String b292 = com.qq.e.comm.plugin.e.a.d.a().b(117, false);
        jSONObject.putOpt("c_device", b292);
        this.f39358e.put(117, b292);
        jSONObject.putOpt("c_devicetype", Integer.valueOf(ak.a(appContext)));
        String b362 = com.qq.e.comm.plugin.e.a.d.a().b(116, false);
        jSONObject.putOpt("c_mf", b362);
        this.f39358e.put(116, b362);
        c16 = com.qq.e.comm.plugin.e.a.d.a().c(119, false);
        if (((Integer) c16.first).intValue() <= ((Integer) c16.second).intValue()) {
        }
        this.f39358e.put(Integer.valueOf(QzoneCoverConst.MSG_COVER_INVALIDATE), String.valueOf(intValue));
        this.f39358e.put(1191, String.valueOf(intValue2));
        jSONObject.putOpt("c_w", Integer.valueOf(intValue));
        jSONObject.putOpt("c_h", Integer.valueOf(intValue2));
        jSONObject.putOpt("sdkver", SDKStatus.getSDKVersion() + "." + GDTADManager.getInstance().getPM().getPluginVersion());
        a(jSONObject, appContext);
        String b372 = com.qq.e.comm.plugin.e.a.d.a().b(2, false);
        String b382 = com.qq.e.comm.plugin.e.a.d.a().b(1, false);
        jSONObject.putOpt("m11", b372);
        jSONObject.putOpt("m10", b382);
        this.f39358e.put(2, b372);
        this.f39358e.put(1, b382);
        jSONObject.putOpt("deep_link_version", 1);
        jSONObject.putOpt("source_from", Integer.valueOf(Integer.parseInt(GDTADManager.getInstance().getAppStatus().getAPPID())));
        long currentTimeMillis22 = System.currentTimeMillis();
        jSONObject.put("wx_api_ver", bb.b());
        jSONObject.put("opensdk_ver", bb.d());
        a(ConstValue.INVOKE_RUNTIME_ID_MEMORY_DUMP, System.currentTimeMillis() - currentTimeMillis22, 6000);
        jSONObject.put("device_ext", d(i3, cVar));
        com.qq.e.comm.plugin.base.a.a.a().a(this.f39358e);
        synchronized (this.f39355b) {
        }
    }

    private JSONObject d(int i3, c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("attri_info", a(cVar));
        jSONObject.putOpt("sdk_config_ver", Integer.valueOf(com.qq.e.comm.plugin.j.e.a().f()));
        jSONObject.putOpt("harmony_sys_info", c());
        jSONObject.putOpt("pps", Boolean.valueOf(GlobalSetting.isAgreePrivacyStrategy()));
        jSONObject.putOpt("qi36", com.qq.e.comm.plugin.e.a.d.a().b(701, false));
        jSONObject.putOpt("targeting_ability", com.qq.e.comm.plugin.k.b.a());
        jSONObject.putOpt("configure_ability", com.qq.e.comm.plugin.k.b.a(i3));
        jSONObject.putOpt("jump_ability", com.qq.e.comm.plugin.k.b.b());
        jSONObject.putOpt("report_source", "2");
        b.a(jSONObject);
        return jSONObject;
    }

    public void a() {
        this.f39357d = null;
        this.f39358e.clear();
    }

    public void a(final Context context) {
        GDTLogger.i("GathererDeviceInfo init");
        if (this.f39356c) {
            return;
        }
        synchronized (this) {
            if (this.f39356c) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            e.a().a(context);
            a(ConstValue.INVOKE_RUNTIME_ID_FORCE_KILL_GPU_PROCESS, System.currentTimeMillis() - currentTimeMillis, 0);
            this.f39356c = true;
            if (b.c()) {
                a.f39337a.a();
            } else {
                if (b.b()) {
                    GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.e.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.b(context);
                        }
                    });
                }
            }
        }
    }

    private String a(JSONObject jSONObject, String str) {
        if (y.a(jSONObject) && !TextUtils.isEmpty(str)) {
            try {
                return b.e(jSONObject.optString(b.d(str)));
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return null;
    }

    private void a(String str, ConcurrentHashMap<Integer, String> concurrentHashMap, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        concurrentHashMap.put(Integer.valueOf(i3), str);
    }

    private static void a(int i3, long j3, int i16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("cost_time", Long.valueOf(j3));
        if (i16 != Integer.MIN_VALUE) {
            cVar.a("error_code", Integer.valueOf(i16));
        }
        StatTracer.trackEvent(i3, (int) j3, bVar, cVar);
    }

    private void a(JSONObject jSONObject, Context context) throws JSONException {
        double d16;
        double d17;
        double d18 = 0.0d;
        if (TextUtils.isEmpty(com.qq.e.comm.plugin.e.a.d.a().b(309, false)) && TextUtils.isEmpty(com.qq.e.comm.plugin.e.a.d.a().b(310, false))) {
            if (b.a(309, false)) {
                b.a(310, false);
            }
            d17 = 0.0d;
        } else {
            try {
                d16 = Double.parseDouble(com.qq.e.comm.plugin.e.a.d.a().b(309, false));
            } catch (Exception e16) {
                e16.printStackTrace();
                d16 = 0.0d;
            }
            try {
                d18 = Double.parseDouble(com.qq.e.comm.plugin.e.a.d.a().b(310, false));
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            double d19 = d18;
            d18 = d16;
            d17 = d19;
        }
        if (j.a(d18) || j.a(d17)) {
            return;
        }
        jSONObject.putOpt(QCircleSchemeAttr.Polymerize.LAT, Long.valueOf((long) (d18 * 1000000.0d)));
        this.f39358e.put(309, String.valueOf(d18));
        jSONObject.putOpt("lng", Long.valueOf((long) (1000000.0d * d17)));
        this.f39358e.put(310, String.valueOf(d17));
        GDTLogger.d("GathererDeviceInfo [latitude, longitude] = " + d18 + ", " + d17);
    }

    private JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String b16 = com.qq.e.comm.plugin.e.a.d.a().b(408, false);
        if (!QzoneWebMusicJsPlugin.EVENT_UNKOWN.equals(b16)) {
            jSONObject.put("c_i", b16);
            this.f39358e.put(408, b16);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("s_i", jSONObject2);
        String b17 = com.qq.e.comm.plugin.e.a.d.a().b(403, false);
        jSONObject2.put("b_v_r", b17);
        this.f39358e.put(403, b17);
        String b18 = com.qq.e.comm.plugin.e.a.d.a().b(117, false);
        jSONObject2.put("b_m", b18);
        this.f39358e.put(117, b18);
        String b19 = com.qq.e.comm.plugin.e.a.d.a().b(409, false);
        jSONObject2.put("b_v_c", b19);
        this.f39358e.put(409, b19);
        String b26 = com.qq.e.comm.plugin.e.a.d.a().b(410, false);
        jSONObject2.put("b_i", b26);
        this.f39358e.put(410, b26);
        int a16 = com.qq.e.comm.plugin.e.a.d.a().a(128, false, 1);
        jSONObject2.put("sw_s", String.valueOf(a16));
        this.f39358e.put(128, String.valueOf(a16));
        String b27 = com.qq.e.comm.plugin.e.a.d.a().b(116, false);
        jSONObject2.put("b_mf", b27);
        this.f39358e.put(116, b27);
        String b28 = com.qq.e.comm.plugin.e.a.d.a().b(411, false);
        jSONObject2.put("b_r_o_c", b28);
        this.f39358e.put(411, b28);
        String b29 = com.qq.e.comm.plugin.e.a.d.a().b(413, false);
        jSONObject2.put("jvm_v", b29);
        this.f39358e.put(413, b29);
        String b36 = com.qq.e.comm.plugin.e.a.d.a().b(412, false);
        jSONObject2.put("b_v_i", b36);
        this.f39358e.put(412, b36);
        return jSONObject;
    }

    private JSONObject a(c cVar) throws JSONException {
        HashMap hashMap = new HashMap();
        String b16 = com.qq.e.comm.plugin.e.a.d.a().b(101, true);
        hashMap.put(8, b16);
        this.f39358e.put(101, b16);
        String b17 = com.qq.e.comm.plugin.e.a.d.a().b(102, true);
        hashMap.put(16, b17);
        this.f39358e.put(102, b17);
        String b18 = com.qq.e.comm.plugin.e.a.d.a().b(103, true);
        hashMap.put(32, b18);
        this.f39358e.put(103, b18);
        String b19 = com.qq.e.comm.plugin.e.a.d.a().b(110, true);
        hashMap.put(1, b19);
        this.f39358e.put(110, b19);
        String b26 = com.qq.e.comm.plugin.e.a.d.a().b(111, true);
        hashMap.put(2, b26);
        this.f39358e.put(111, b26);
        String b27 = com.qq.e.comm.plugin.e.a.d.a().b(112, true);
        hashMap.put(4, b27);
        this.f39358e.put(112, b27);
        String b28 = com.qq.e.comm.plugin.e.a.d.a().b(107, true);
        hashMap.put(64, b28);
        this.f39358e.put(107, b28);
        String b29 = com.qq.e.comm.plugin.e.a.d.a().b(108, true);
        hashMap.put(128, b29);
        this.f39358e.put(108, b29);
        String b36 = com.qq.e.comm.plugin.e.a.d.a().b(109, true);
        hashMap.put(256, b36);
        this.f39358e.put(109, b36);
        String b37 = com.qq.e.comm.plugin.e.a.d.a().b(104, true);
        hashMap.put(512, b37);
        this.f39358e.put(104, b37);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id_info", b.a(hashMap));
        } catch (Exception e16) {
            GDTLogger.e("GathererDeviceInfo create idInfoJson failed.", e16);
        }
        if (cVar != null && cVar.a()) {
            String b38 = com.qq.e.comm.plugin.e.a.d.a().b(308, false);
            jSONObject.put("ua", b38);
            this.f39358e.put(308, b38);
        }
        String b39 = com.qq.e.comm.plugin.e.a.d.a().b(307, true);
        jSONObject.put("wm_h", b39);
        this.f39358e.put(307, b39);
        String b46 = com.qq.e.comm.plugin.e.a.d.a().b(318, false);
        jSONObject.put("w_u", b46);
        this.f39358e.put(318, b46);
        jSONObject.put("ua_i", b());
        return jSONObject;
    }

    public synchronized JSONObject b(int i3, c cVar) throws JSONException {
        JSONObject a16 = a(i3, cVar);
        long currentTimeMillis = System.currentTimeMillis();
        if (y.a(a16)) {
            a(ConstValue.INVOKE_RUNTIME_ID_CLEAR_PROXY_OVERRIDE, System.currentTimeMillis() - currentTimeMillis, 0);
            return a16;
        }
        JSONObject c16 = c(i3, cVar);
        a(ConstValue.INVOKE_RUNTIME_ID_PROXY_OVERRIDE_REVERSE_BYPASS, System.currentTimeMillis() - currentTimeMillis, 0);
        return c16;
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            String b16 = com.qq.e.comm.plugin.e.a.d.a().b(124, false);
            jSONObject.putOpt("os_version", b16);
            this.f39358e.put(124, b16);
            int a16 = com.qq.e.comm.plugin.e.a.d.a().a(125, false, -1);
            jSONObject.putOpt("harmony_pure_mode", Integer.valueOf(a16));
            this.f39358e.put(125, String.valueOf(a16));
            boolean a17 = com.qq.e.comm.plugin.e.a.d.a().a(126, false, false);
            jSONObject.putOpt("is_harmony_os", Boolean.valueOf(a17));
            this.f39358e.put(126, String.valueOf(a17));
        } catch (Throwable th5) {
            GDTLogger.e("getHarmonyInfo error, " + th5.getMessage());
        }
        return jSONObject;
    }

    public JSONObject a(final int i3, final c cVar) {
        JSONObject jSONObject;
        if (y.a(this.f39357d)) {
            synchronized (this.f39355b) {
                jSONObject = y.a(y.b(this.f39357d));
                b.a(y.g(jSONObject, "device_ext"));
            }
        } else {
            jSONObject = null;
        }
        if (this.f39357d != null) {
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.e.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.c(i3, cVar);
                    } catch (JSONException e16) {
                        GDTLogger.e("GathererDeviceInfo getOnlyCache JSONException.", e16);
                    }
                }
            });
        }
        return jSONObject;
    }
}
