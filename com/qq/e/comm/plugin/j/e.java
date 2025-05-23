package com.qq.e.comm.plugin.j;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.plugin.ipc.C2SMethod;
import com.qq.e.comm.plugin.ipc.IPCClass;
import com.qq.e.comm.plugin.ipc.business.BusinessAction;
import com.qq.e.comm.plugin.ipc.business.BusinessModuleName;
import com.qq.e.comm.plugin.ipc.business.BusinessParamsKey;
import com.qq.e.comm.plugin.ipc.business.BusinessResultKey;
import com.qq.e.comm.plugin.k.aj;
import com.qq.e.comm.plugin.k.an;
import com.qq.e.comm.plugin.k.ap;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.plugin.k.r;
import com.qq.e.comm.plugin.k.w;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.f;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.qq.e.comm.util.StringUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@IPCClass
/* loaded from: classes3.dex */
public class e {

    /* renamed from: j, reason: collision with root package name */
    private Pair<Integer, JSONArray> f39600j;

    /* renamed from: c, reason: collision with root package name */
    private static final e f39593c = new e();

    /* renamed from: a, reason: collision with root package name */
    public static String f39591a = "https://test-tangram.e.qq.com/updateSetting";

    /* renamed from: b, reason: collision with root package name */
    public static String f39592b = "https://ttc.gdt.qq.com/autotest/updateSetting";

    /* renamed from: d, reason: collision with root package name */
    private static String f39594d = "https://tangram.e.qq.com/updateSetting";

    /* renamed from: e, reason: collision with root package name */
    private AtomicLong f39595e = new AtomicLong();

    /* renamed from: f, reason: collision with root package name */
    private volatile long f39596f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f39597g = 69;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<ADListener> f39598h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Pair<Integer, JSONArray>> f39599i = new ConcurrentHashMap();

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Pair<Integer, JSONArray>> f39601k = new ConcurrentHashMap();

    /* renamed from: l, reason: collision with root package name */
    private long f39602l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f39603m = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f39604n = true;

    /* renamed from: o, reason: collision with root package name */
    private String f39605o = null;

    private void e(String str, String str2) {
        try {
            if (Md5Util.encode(str + "c5b98ab2e7278e43b2e7243cda83ff09").equals(str2)) {
                GDTADManager.getInstance().getSM().updateSDKCloudSetting(str2, str);
                an.a();
            }
        } catch (Throwable th5) {
            GDTLogger.e("updateSdkConfig error:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String g() {
        JSONObject jSONObject;
        JSONArray f16;
        SM sm5 = GDTADManager.getInstance().getSM();
        if (sm5 == null) {
            return null;
        }
        String string = sm5.getString("ex_exp_info");
        if (!TextUtils.isEmpty(string)) {
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            f16 = y.f(jSONObject, "exp_id");
            if (!w.b(f16)) {
                return null;
            }
            String e17 = w.e(f16);
            try {
                for (String str : this.f39599i.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        e(str);
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e("getExpIdArrayString", th5);
            }
            e(null);
            return e17;
        }
        jSONObject = null;
        f16 = y.f(jSONObject, "exp_id");
        if (!w.b(f16)) {
        }
    }

    private void h() {
        GDTLogger.d("update request time");
        this.f39595e.set(System.currentTimeMillis() / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            GDTLogger.d("Load wuji seq config");
            File dir = GDTADManager.getInstance().getAppContext().getDir(GDTADManager.getInstance().getSM().getSettingDir(), 0);
            if (dir != null && dir.exists()) {
                String readAll = StringUtil.readAll(new File(dir, "gdt_config_wuji.ncfg"));
                if (TextUtils.isEmpty(readAll)) {
                    GDTLogger.d("Empty local seq encrypt config");
                    return;
                }
                GDTLogger.d("read value: " + readAll);
                if (TextUtils.isEmpty(readAll)) {
                    GDTLogger.d("Empty local seq config");
                    return;
                }
                this.f39597g = new JSONObject(readAll).optInt("seq", 69);
                GDTLogger.d("Load wuji_seq: " + this.f39597g);
            }
        } catch (Exception e16) {
            GDTLogger.e("Exception while load seq", e16);
        }
    }

    private void j() {
        b(-2);
    }

    private void k() {
        b(-3);
    }

    private void l() {
        GDTLogger.e("Update success");
        StatTracer.trackEvent(1600102, 0, new com.qq.e.comm.plugin.stat.b());
    }

    private void m() {
        GDTLogger.d("Update done");
        c(1);
        this.f39605o = g();
        StatTracer.trackEvent(1600100, 0, new com.qq.e.comm.plugin.stat.b());
    }

    private int n() {
        int integer = GDTADManager.getInstance().getSM().getInteger("reqInterval", 900);
        if (integer <= 0) {
            return 900;
        }
        return integer;
    }

    private boolean o() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long e16 = e();
        long n3 = n();
        if (currentTimeMillis - e16 > n3) {
            return true;
        }
        GDTLogger.d(String.format("need not update for time, (%s - %s) < %s", Long.valueOf(currentTimeMillis), Long.valueOf(e16), Long.valueOf(n3)));
        return false;
    }

    public void d() {
        String a16 = b.a(GDTADManager.getInstance().getSM(), GDTADManager.getInstance().getPM(), GDTADManager.getInstance().getDeviceStatus(), GDTADManager.getInstance().getAppStatus(), GDTADManager.getInstance().getAppContext(), this.f39604n);
        ap.a().a(b.a());
        c(a16);
    }

    public int f() {
        return this.f39597g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(long j3, int i3) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("cost_time", Long.valueOf(j3));
        if (i3 != Integer.MIN_VALUE) {
            cVar.a("error_code", Integer.valueOf(i3));
        }
        StatTracer.trackEvent(30592, (int) j3, bVar, cVar);
    }

    public void c() {
        if (o()) {
            d();
        }
    }

    private void c(int i3) {
        if (this.f39598h.size() == 0) {
            return;
        }
        Iterator<ADListener> it = this.f39598h.iterator();
        while (it.hasNext()) {
            it.next().onADEvent(new ADEvent(i3));
        }
    }

    public long e() {
        return this.f39595e.get();
    }

    public static e a() {
        return f39593c;
    }

    private void c(String str) {
        String str2;
        GDTLogger.d("Config request: " + str);
        NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.plugin.j.e.3
            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onException(Exception exc) {
                GDTLogger.e("Config request error: ", exc);
            }

            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onResponse(Request request, Response response) {
                long j3 = 0;
                try {
                    if (response.getStatusCode() == 200) {
                        String stringContent = response.getStringContent();
                        GDTLogger.d("Config wuji response:" + stringContent);
                        if (StringUtil.isEmpty(stringContent)) {
                            GDTLogger.report("SDK Server response empty string, maybe zip or tea format error");
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(stringContent);
                        e.this.a(jSONObject);
                        e.this.f39604n = false;
                        DeviceStatus deviceStatus = GDTADManager.getInstance().getDeviceStatus();
                        if (deviceStatus != null && SDKStatus.getSDKVersionCode() >= 290 && jSONObject.has(DeviceStatus.EXPERIMENT_ID)) {
                            deviceStatus.writeExperimentIdSync(jSONObject.optString(DeviceStatus.EXPERIMENT_ID));
                            return;
                        }
                        return;
                    }
                    GDTLogger.e("SDK server response code error while launch or activate, code:" + response.getStatusCode());
                } catch (IOException e16) {
                    if (e.this.f39596f != 0) {
                        j3 = System.currentTimeMillis() - e.this.f39596f;
                    }
                    e.b(j3, -1);
                    GDTLogger.e("Config wuji request error", e16);
                } catch (JSONException e17) {
                    if (e.this.f39596f != 0) {
                        j3 = System.currentTimeMillis() - e.this.f39596f;
                    }
                    e.b(j3, -2);
                    GDTLogger.e("Parse config response exception", e17);
                } catch (Throwable th5) {
                    if (e.this.f39596f != 0) {
                        j3 = System.currentTimeMillis() - e.this.f39596f;
                    }
                    e.b(j3, -3);
                    GDTLogger.e("config Throwable", th5);
                }
            }
        };
        if (SharedPreferencedUtil.getInt("testControlServerOn", 0) == 2) {
            str2 = f39592b;
        } else if (SharedPreferencedUtil.getInt("testControlServerOn", 0) != 1 && !aj.e()) {
            str2 = f39594d;
        } else {
            str2 = f39591a;
        }
        GDTLogger.d("wuji req url : " + str2);
        S2SSRequest s2SSRequest = new S2SSRequest(str2, str.getBytes(Charset.forName("UTF-8")), false);
        s2SSRequest.addHeader(FileUploadBase.CONTENT_TYPE, "application/json");
        this.f39596f = System.currentTimeMillis();
        NetworkClientImpl.getInstance().submit(s2SSRequest, 1, networkCallBack);
    }

    private void e(String str) {
        Pair<Integer, JSONArray> b16;
        HashSet<String> d16 = d(str);
        if (g.a(d16)) {
            GDTLogger.d("WuJiConfigNEED_REPORT_EXP_ID_LIST is null");
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                b16 = r.a(str);
            } else {
                b16 = r.b(null);
            }
            if (b16 == null) {
                return;
            }
            JSONArray a16 = w.a(w.f((JSONArray) b16.second), w.a(), d16);
            if (w.b(a16)) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f39599i.put(str, new Pair<>(b16.first, a16));
            } else {
                this.f39600j = new Pair<>(b16.first, a16);
            }
        } catch (Throwable th5) {
            GDTLogger.e("WuJiConfigcachedExpIdForReport", th5);
        }
    }

    public void b() {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.j.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.i();
                e eVar = e.this;
                eVar.f39605o = eVar.g();
            }
        });
    }

    private static boolean a(Context context, String str) {
        OutputStreamWriter outputStreamWriter = null;
        File dir = context != null ? context.getDir(aj.h(), 0) : null;
        if (dir != null && (dir.exists() || dir.mkdirs())) {
            File file = new File(dir, "gdt_config_wuji.ncfg");
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                    try {
                        outputStreamWriter2.write(str);
                        try {
                            outputStreamWriter2.close();
                            return true;
                        } catch (Exception unused) {
                            return true;
                        }
                    } catch (Exception unused2) {
                        outputStreamWriter = outputStreamWriter2;
                        if (!file.delete()) {
                            GDTLogger.d("Delete seq config failed");
                        }
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception unused5) {
            }
        } else {
            GDTLogger.w("Create config file failed!");
            return false;
        }
    }

    private void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(new JSONObject(str), false, false);
        } catch (JSONException e16) {
            GDTLogger.e("Load config info failed:", e16);
            b(-2);
        }
    }

    private void d(String str, String str2) {
        if (Md5Util.encode(str + "c5b98ab2e7278e43b2e7243cda83ff09").equals(str2)) {
            GDTADManager.getInstance().getSM().updateDEVCloudSetting(str2, str);
        }
    }

    private HashSet<String> d(String str) {
        String b16 = b(str, "needReportExpList");
        if (TextUtils.isEmpty(b16)) {
            GDTLogger.d("WuJiConfigNEED_REPORT_EXP_ID_LIST is null");
            return null;
        }
        try {
            return new HashSet<>(Arrays.asList(b16.split(",")));
        } catch (Throwable unused) {
            GDTLogger.e("getExpIdWhiteList error");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, boolean z16, boolean z17) {
        GDTLogger.d("WuJi doUpdate");
        if (jSONObject == null) {
            j();
        } else {
            int optInt = jSONObject.optInt("ret", -1);
            if (z17) {
                b(this.f39596f != 0 ? System.currentTimeMillis() - this.f39596f : 0L, optInt);
            }
            if (optInt == 1) {
                GDTLogger.i("WuJiConfig no need update");
            } else if (optInt != 0) {
                b(optInt);
            } else {
                int optInt2 = jSONObject.optInt("seq", -1);
                if (optInt2 != -1) {
                    a(optInt2);
                }
                if (!jSONObject.has(PreloadTRTCPlayerParams.KEY_SIG)) {
                    k();
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject(PreloadTRTCPlayerParams.KEY_SIG);
                    if (optJSONObject == null) {
                        k();
                    } else {
                        if (z16) {
                            b(optJSONObject);
                        }
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("setting");
                        if (optJSONObject2 != null) {
                            a(optJSONObject, optJSONObject2);
                        }
                        long optLong = jSONObject.optLong("timestamp");
                        if (optLong > 0) {
                            this.f39602l = optLong;
                            this.f39603m = SystemClock.elapsedRealtime() / 1000;
                        }
                        l();
                    }
                }
            }
        }
        m();
    }

    public void a(int i3, String str, ADListener aDListener) {
        if (i3 != 1) {
            GDTLogger.e("Unsupported config action: " + i3);
            return;
        }
        if (aDListener != null && !this.f39598h.contains(aDListener)) {
            this.f39598h.add(aDListener);
        }
        b(str);
        this.f39605o = g();
    }

    @C2SMethod(action = BusinessAction.ACTION_WUJI_GET_STRING, module = BusinessModuleName.IPC_MODULE_WUJI_CONFIG, params = {BusinessParamsKey.KEY_WUJI_GET_PARAMS_1, BusinessParamsKey.KEY_WUJI_GET_PARAMS_2}, results = {BusinessResultKey.KEY_WUJI_GET_STRING})
    public String c(String str, String str2) {
        Object onlyForPlacement = SDKStatus.getSDKVersionCode() >= 380 ? GDTADManager.getInstance().getSM().getOnlyForPlacement(str, str2) : null;
        if (onlyForPlacement != null) {
            return onlyForPlacement.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        h();
        a(jSONObject, true, true);
        this.f39605o = g();
    }

    private void a(final JSONObject jSONObject, final boolean z16, final boolean z17) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.plugin.j.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.b(jSONObject, z16, z17);
                f.a(true);
            }
        });
    }

    private void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (y.a(jSONObject) && y.a(jSONObject2)) {
            String optString = jSONObject2.optString("app", null);
            String optString2 = jSONObject.optString("app", null);
            if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString2)) {
                GDTLogger.d("update app config");
                d(optString, optString2);
            }
            String optString3 = jSONObject2.optString("sdk", null);
            String optString4 = jSONObject.optString("sdk", null);
            if (StringUtil.isEmpty(optString3) || StringUtil.isEmpty(optString4)) {
                return;
            }
            GDTLogger.d("update sdk config");
            e(optString3, optString4);
        }
    }

    private void b(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            String optString = jSONObject.optString(HttpMsg.FILE_JAR, null);
            String optString2 = jSONObject.optString("url", null);
            if (StringUtil.isEmpty(optString) || StringUtil.isEmpty(optString2)) {
                return;
            }
            GDTLogger.d("update plugin: " + optString2);
        }
    }

    private void b(int i3) {
        GDTLogger.e("Update failed: " + i3);
        c(2);
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", Integer.valueOf(i3));
        StatTracer.trackEvent(1600101, 0, new com.qq.e.comm.plugin.stat.b(), cVar);
    }

    private void a(int i3) {
        int i16 = this.f39597g;
        if (i3 != i16) {
            GDTLogger.d(String.format("Update seq from %d to %d", Integer.valueOf(i16), Integer.valueOf(i3)));
            this.f39597g = i3;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("seq", this.f39597g);
                GDTLogger.d("write value: " + jSONObject.toString());
                a(GDTADManager.getInstance().getAppContext(), jSONObject.toString());
            } catch (Exception e16) {
                GDTLogger.e("Exception while update seq", e16);
            }
        }
    }

    @C2SMethod(action = BusinessAction.ACTION_WUJI_GET_STRING, module = BusinessModuleName.IPC_MODULE_WUJI_CONFIG, params = {BusinessParamsKey.KEY_WUJI_GET_PARAMS_1, BusinessParamsKey.KEY_WUJI_GET_PARAMS_2}, results = {BusinessResultKey.KEY_WUJI_GET_STRING})
    public String b(String str, String str2) {
        Object a16 = a(str, str2);
        if (a16 != null) {
            return a16.toString();
        }
        return null;
    }

    public Object a(String str, String str2) {
        if (SDKStatus.getSDKVersionCode() >= 140) {
            return GDTADManager.getInstance().getSM().get(str, str2);
        }
        return GDTADManager.getInstance().getSM().get(str2);
    }

    public String a(String str, String str2, String str3) {
        String b16 = b(str, str2);
        return b16 != null ? b16.toString() : str3;
    }

    @C2SMethod(action = BusinessAction.ACTION_WUJI_GET_INTEGER, module = BusinessModuleName.IPC_MODULE_WUJI_CONFIG, params = {BusinessParamsKey.KEY_WUJI_GET_PARAMS_1, BusinessParamsKey.KEY_WUJI_GET_PARAMS_2, BusinessParamsKey.KEY_WUJI_GET_PARAMS_3}, results = {BusinessResultKey.KEY_WUJI_GET_INTEGER})
    public int a(String str, String str2, int i3) {
        Object a16 = a(str, str2);
        return a16 instanceof Integer ? ((Integer) a16).intValue() : i3;
    }

    public long a(String str, String str2, long j3) {
        Object a16 = a(str, str2);
        if (a16 instanceof Long) {
            return ((Long) a16).longValue();
        }
        return a16 instanceof Integer ? ((Integer) a16).longValue() : j3;
    }

    public void a(int i3, String[] strArr, String str) {
        if (!g.a(strArr) && !TextUtils.isEmpty(str)) {
            try {
                this.f39601k.put(str, new Pair<>(Integer.valueOf(i3), w.a(strArr, w.a(), d(str))));
                e(str);
                return;
            } catch (Throwable th5) {
                GDTLogger.e("WuJiConfigcacheCustomExpIds", th5);
                return;
            }
        }
        GDTLogger.e("WuJiConfigcacheCustomExpIds params error");
    }

    public Pair<Integer, JSONArray> a(String str) {
        try {
            JSONArray a16 = w.a();
            Pair<Integer, JSONArray> pair = this.f39600j;
            if (pair != null && !w.a((JSONArray) pair.second)) {
                a16 = w.a(a16, (JSONArray) this.f39600j.second);
            }
            int i3 = -1;
            if (!TextUtils.isEmpty(str)) {
                if (this.f39599i.containsKey(str) && this.f39599i.get(str) != null) {
                    a16 = w.a(a16, (JSONArray) this.f39599i.get(str).second);
                    i3 = ((Integer) this.f39599i.get(str).first).intValue();
                }
                if (this.f39601k.containsKey(str) && this.f39601k.get(str) != null) {
                    a16 = w.a(a16, (JSONArray) this.f39601k.get(str).second);
                    i3 = ((Integer) this.f39601k.get(str).first).intValue();
                }
            }
            return new Pair<>(Integer.valueOf(i3), a16);
        } catch (Throwable th5) {
            GDTLogger.e("WuJiConfiggetExpIdByWhiteList", th5);
            return null;
        }
    }
}
