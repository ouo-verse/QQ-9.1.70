package com.qq.e.comm;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.ZipCompress;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.JSONUtilStub;
import com.qq.e.comm.util.SystemUtil;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Random f38090a = new Random(System.currentTimeMillis());

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Integer, String> f38091b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static volatile long f38092c = 0;

    private static int a(Context context) {
        String b16 = b(context);
        if (TextUtils.isEmpty(b16)) {
            return 0;
        }
        if (b16.equals("46000") || b16.equals("46002") || b16.equals("46007") || b16.equals("46020")) {
            return 1;
        }
        if (b16.equals("46001") || b16.equals("46006")) {
            return 2;
        }
        return (b16.equals("46003") || b16.equals("46005")) ? 3 : 0;
    }

    private static String b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? DeviceInfoMonitor.getNetworkOperator(telephonyManager) : "";
        } catch (Exception e16) {
            GDTLogger.w("Get operator failed: ", e16);
            return "";
        }
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bid", 10001015);
            jSONObject.put("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
            jSONObject.put("osType", 2);
            jSONObject.put("stubVersion", SDKStatus.STUB_VERSION);
            jSONObject.put("sdkVersion", GDTADManager.getInstance().getPM().getPluginVersion());
            String str = Build.VERSION.RELEASE;
            jSONObject.put("osVersion", str);
            int a16 = a(GDTADManager.getInstance().getAppContext());
            jSONObject.put("carrierCode", a16);
            jSONObject.put("androidSDK", Build.VERSION.SDK_INT);
            String str2 = Build.BRAND;
            jSONObject.put("androidBrand", str2);
            String str3 = Build.MANUFACTURER;
            jSONObject.put("androidManufacturer", str3);
            String buildModel = GDTADManager.getInstance().getDeviceStatus().getBuildModel();
            jSONObject.put("model", buildModel);
            Map<Integer, String> map = f38091b;
            map.put(403, String.valueOf(str));
            map.put(305, String.valueOf(a16));
            map.put(118, String.valueOf(str2));
            map.put(116, String.valueOf(str3));
            map.put(117, String.valueOf(buildModel));
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            d();
            return null;
        }
    }

    private static void d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bid", 10001015);
            jSONObject.put("osType", 2);
            jSONObject.put("osVersion", "release");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eventId", 1999);
            jSONObject2.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, System.currentTimeMillis());
            jSONObject2.put("androidCurrentProcessName", SystemUtil.getProcessName(GDTADManager.getInstance().getAppContext()));
            jSONObject2.put("errorCode", 1999);
            jSONObject.put("body", b(jSONObject2));
            c(jSONObject.toString(), true);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (GDTADManager.getInstance().getSM() != null) {
                    jSONObject.put("rate", GDTADManager.getInstance().getSM().getInteger("dp3_rate", 100));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.mo162put(jSONObject);
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject c(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bid", 10001015);
            jSONObject.put("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
            jSONObject.put("osType", 2);
            jSONObject.put("stubVersion", SDKStatus.STUB_VERSION);
            if (i3 != Integer.MIN_VALUE) {
                jSONObject.put("sdkVersion", i3);
            }
            String str = Build.VERSION.RELEASE;
            jSONObject.put("osVersion", str);
            int a16 = a(GDTADManager.getInstance().getAppContext());
            jSONObject.put("carrierCode", a16);
            jSONObject.put("androidSDK", Build.VERSION.SDK_INT);
            String str2 = Build.BRAND;
            jSONObject.put("androidBrand", str2);
            String str3 = Build.MANUFACTURER;
            jSONObject.put("androidManufacturer", str3);
            String buildModel = GDTADManager.getInstance().getDeviceStatus().getBuildModel();
            jSONObject.put("model", buildModel);
            Map<Integer, String> map = f38091b;
            map.put(403, String.valueOf(str));
            map.put(305, String.valueOf(a16));
            map.put(118, String.valueOf(str2));
            map.put(116, String.valueOf(str3));
            map.put(117, String.valueOf(buildModel));
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            d();
            return null;
        }
    }

    public static void d(final long j3, final int i3) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.5
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", i3);
                    jSONObject.put("cost_time", j3);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportPreDNSInfo error :", th5);
                }
            }
        });
    }

    public static void a() {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.6
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 5001);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportUnzipFileNameError error :", th5);
                }
            }
        });
    }

    static /* synthetic */ JSONObject b() {
        return c();
    }

    public static void c(final long j3, final int i3) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 2011);
                    jSONObject.put("cost_time", j3);
                    int i16 = i3;
                    if (i16 != Integer.MIN_VALUE) {
                        jSONObject.put("errorCode", i16);
                    }
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportConfigUpdateFailed error :", th5);
                }
            }
        });
    }

    private static boolean d(int i3) {
        return GDTLogger.isEnableConsoleLog() || f38090a.nextDouble() < 1.0d / ((double) i3);
    }

    public static void a(final int i3) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 2009);
                    jSONObject.put("configType", i3);
                    jSONObject.put("androidCurrentProcessName", SystemUtil.getProcessName(GDTADManager.getInstance().getAppContext()));
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportConfigUpdateStart error :", th5);
                }
            }
        });
    }

    public static void a(final int i3, final int i16) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.8
            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 3001);
                    jSONObject.put("netType", i3);
                    jSONObject.put("netType1", i16);
                    if (i3 == i16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    jSONObject.put("errorCode", z16);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportNetworkType error :", th5);
                }
            }
        });
    }

    public static void b(final long j3, final int i3) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 2010);
                    jSONObject.put("cost_time", j3);
                    jSONObject.put("configType", i3);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportConfigUpdateSucc error :", th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("report dp3 result null");
            return;
        }
        try {
            if (!d(GDTADManager.getInstance().getSM() != null ? GDTADManager.getInstance().getSM().getInteger("dp3_rate", 100) : 100) && z16) {
                GDTLogger.e("reportDp3 miss rate");
                return;
            }
            GDTLogger.d("report dp3 :" + str);
            StubVisitor.getInstance().onDataUsed(f38091b);
            NetworkClientImpl.getInstance().submit(new PlainRequest("https://dp3.qq.com/stdlog", 2, str.getBytes("UTF-8")), 3, new NetworkCallBack() { // from class: com.qq.e.comm.a.7
                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onException(Exception exc) {
                    GDTLogger.e("reportDp3 failed" + exc);
                }

                @Override // com.qq.e.comm.net.NetworkCallBack
                public final void onResponse(Request request, Response response) {
                    if (response.getStatusCode() == 200) {
                        GDTLogger.d("reportDp3 success");
                    }
                }
            });
        } catch (UnsupportedEncodingException e16) {
            GDTLogger.e("reportDp3 failed" + e16);
        }
    }

    public static void a(final int i3, final int i16, final long j3, int i17) {
        final int i18 = 2;
        final int i19 = Integer.MIN_VALUE;
        final int i26 = Integer.MIN_VALUE;
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject c16 = a.c(i16);
                    if (!JSONUtilStub.notNull(c16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 1998);
                    jSONObject.put("cost_time", j3);
                    jSONObject.put("step", i3);
                    int i27 = i19;
                    if (i27 != Integer.MIN_VALUE) {
                        jSONObject.put("dexMrResult", i27);
                    }
                    int i28 = i26;
                    if (i28 != Integer.MIN_VALUE) {
                        jSONObject.put("sdexfrom", i28);
                    }
                    jSONObject.put("netType", GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue());
                    jSONObject.put("androidCurrentProcessName", SystemUtil.getProcessName(GDTADManager.getInstance().getAppContext()));
                    jSONObject.put("sdkType", i18);
                    c16.put("body", a.b(jSONObject));
                    a.c(c16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportSDKinitTotalTime error :", th5);
                }
            }
        });
    }

    public static void b(final String str) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.10
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 5002);
                    jSONObject.put("content", str);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportClearSplashCacheDataExecuted error :", th5);
                }
            }
        });
    }

    public static void a(final int i3, final int i16, final String str) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.13
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", i3);
                    jSONObject.put("errorCode", i16);
                    jSONObject.put("msg", str);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), false);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportFlowConfigError error :", th5);
                }
            }
        });
    }

    public static void a(final long j3, final int i3) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.9
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 30592);
                    jSONObject.put("cost_time", j3);
                    int i16 = i3;
                    if (i16 != Integer.MIN_VALUE) {
                        jSONObject.put("errorCode", i16);
                    }
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportWuJiReqFailed error :", th5);
                }
            }
        });
    }

    public static void a(final String str) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.12
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 30593);
                    jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, System.currentTimeMillis());
                    jSONObject.put("netType", GDTADManager.getInstance().getDeviceStatus().getNetworkType().getConnValue());
                    jSONObject.put("content", ZipCompress.compressByGzipAndBase64(str));
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportSetDeviceInfoByFlow error :", th5);
                }
            }
        });
    }

    public static void a(final String str, final boolean z16) {
        GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.comm.a.11
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject b16 = a.b();
                    if (!JSONUtilStub.notNull(b16)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("eventId", 5003);
                    jSONObject.put("posId", str);
                    jSONObject.put("uadContext", z16);
                    b16.put("body", a.b(jSONObject));
                    a.c(b16.toString(), true);
                } catch (Throwable th5) {
                    GDTLogger.e("dp3 reportOldNativeAd error :", th5);
                }
            }
        });
    }
}
