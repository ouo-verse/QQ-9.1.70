package com.tencent.qqperf.tools;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor;
import com.tencent.util.AppSetting;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class DeviceInfoUtils {
    private static final int LEVEL_HIGH = 1;
    private static final int LEVEL_LOW = 3;
    private static final int LEVEL_MEDIUM = 2;
    private static final int LEVEL_UNKNOWN = 0;
    private static final long REQUEST_INTERVAL = -1702967296;
    public static final String TAG = "DeviceInfoUtils";
    private static int sPerfLevelLocal;
    private static int sPerfLevelRemote;
    private static AtomicBoolean sRequestPost = new AtomicBoolean(false);
    private static long sLastRequestTime = 0;

    public static int getPerfLevel() {
        if (sPerfLevelLocal == 0) {
            sPerfLevelLocal = getPerfLevelLocal();
        }
        return sPerfLevelLocal;
    }

    private static int getPerfLevelLocal() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt("localLevel", 0);
        if (decodeInt == 0) {
            int n3 = ah.n();
            long m3 = ah.m();
            long c16 = m.c();
            if (n3 >= 8 && m3 >= 2000000 && c16 >= 5368709120L) {
                decodeInt = 1;
            } else if (n3 > 6 && c16 > 3221225472L) {
                decodeInt = 2;
            } else {
                decodeInt = 3;
            }
            QLog.d(TAG, 1, "Record local level:" + decodeInt);
            from.encodeInt("localLevel", decodeInt);
        }
        return decodeInt;
    }

    private static int getPerfLevelRemote() {
        int i3 = sPerfLevelRemote;
        if (i3 != 0) {
            return i3;
        }
        if (LowEndPerfProcessor.a().a()) {
            if (sPerfLevelRemote != 0) {
                sPerfLevelRemote = 0;
                vy3.a.a().edit().putInt("device_perf_level", 0).apply();
            }
            return 0;
        }
        final SharedPreferences a16 = vy3.a.a();
        int i16 = a16.getInt("device_perf_level", 0);
        sPerfLevelRemote = i16;
        if (i16 != 0) {
            return i16;
        }
        if (sLastRequestTime == 0) {
            sLastRequestTime = a16.getLong("device_perf_level_timestamps", 0L);
        }
        if (!AppSetting.isDebugVersion() && Math.abs(sLastRequestTime - System.currentTimeMillis()) < -1702967296) {
            return sPerfLevelRemote;
        }
        if (!sRequestPost.compareAndSet(false, true)) {
            return sPerfLevelRemote;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.tools.DeviceInfoUtils.1
            @Override // java.lang.Runnable
            public void run() {
                DeviceInfoUtils.sLastRequestTime = System.currentTimeMillis();
                a16.edit().putLong("device_perf_level_timestamps", DeviceInfoUtils.sLastRequestTime).apply();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pid", "1");
                    jSONObject.put("device", URLEncoder.encode(DeviceInfoMonitor.getModel(), "UTF-8"));
                    jSONObject.put("version", "1.0.0");
                    jSONObject.put("userSwitch", "0");
                    jSONObject.put("lastSwitch", "0");
                    if (QLog.isColorLevel()) {
                        QLog.e(DeviceInfoUtils.TAG, 1, "perf level sendRequest");
                        QLog.e(DeviceInfoUtils.TAG, 1, jSONObject.toString());
                    }
                    Request.Builder url = new Request.Builder().url("https://ten.sngapm.qq.com/appconfig/v4/config/14199/");
                    String jSONObject2 = jSONObject.toString();
                    Response response = null;
                    Request build = url.post(RequestBody.create((MediaType) null, jSONObject2)).build();
                    OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    try {
                        response = newBuilder.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build().newCall(build).execute();
                        if (response.code() == 200) {
                            JSONObject jSONObject3 = new JSONObject(response.body().string());
                            if (QLog.isColorLevel()) {
                                QLog.e(DeviceInfoUtils.TAG, 1, jSONObject3.toString());
                            }
                            int i17 = jSONObject3.getInt("deviceLevel");
                            if (i17 != 0) {
                                a16.edit().putInt("device_perf_level", i17).apply();
                                DeviceInfoUtils.sPerfLevelRemote = i17;
                            }
                        }
                        response.close();
                    } catch (Throwable th5) {
                        if (response != null) {
                            response.close();
                        }
                        throw th5;
                    }
                } catch (Throwable th6) {
                    if (QLog.isColorLevel()) {
                        QLog.e(DeviceInfoUtils.TAG, 2, th6.toString());
                    }
                }
                DeviceInfoUtils.sRequestPost.set(false);
            }
        }, 128, null, true);
        return sPerfLevelRemote;
    }

    public static boolean isHighPerfDevice() {
        if (getPerfLevel() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isLowPerfDevice() {
        if (getPerfLevel() == 3) {
            return true;
        }
        return false;
    }
}
