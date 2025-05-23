package com.tencent.hippy.qq.utils;

import android.os.Build;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class WebSSOUtils {
    public static final String CALLBACK_COLUMN_BUSINESSRET = "businessRet";
    public static final String CALLBACK_COLUMN_DATA = "data";
    public static final String CALLBACK_COLUMN_MSG = "msg";
    public static final String CALLBACK_COLUMN_SSORET = "ssoRet";
    public static final int CODE_SSO_RET_MSF_FAILED = 201;
    public static final int CODE_SSO_RET_MSF_TIMEOUT = 202;
    public static final int CODE_SSO_RET_NO_CONNECTION = 103;
    public static final int CODE_SSO_RET_PKG_SIZE_EXCEED = 101;
    public static final int CODE_SSO_RET_REQUEST_TOO_OFTEN = 102;
    public static final int CODE_SSO_RET_SUCCESS = 0;
    public static final int CODE_SSO_RET_UNKNOWN_ERROR = 255;
    private static final String TAG = "WebSSOUtils";

    public static JSONObject generateAgentCostData(long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            am.f238850h = currentTimeMillis;
            long j16 = currentTimeMillis - am.f238847d;
            long j17 = am.f238848e - am.f238847d;
            long j18 = am.f238849f - am.f238848e;
            long j19 = am.f238850h - am.f238849f;
            jSONObject.put("totalTime", j16);
            jSONObject.put("packTime", j17);
            jSONObject.put("SSONetworkTime", j18);
            jSONObject.put("unpackTime", j19);
            jSONObject.put("serverProcessTime", j3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "generateAgentCostData e:" + th5);
        }
        return jSONObject;
    }

    public static JSONObject generateDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            jSONObject.put("model", DeviceInfoMonitor.getModel());
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("product", Build.PRODUCT);
            jSONObject.put("id", Build.ID);
            jSONObject.put("level", Build.VERSION.SDK_INT);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("cpu_abi2", Build.CPU_ABI2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getRomData e:" + th5);
        }
        return jSONObject;
    }

    public static void removeAgentUnusedData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("callback");
        jSONObject.remove("cmd");
        jSONObject.remove("needCookie");
        jSONObject.remove("timeout");
    }

    public static void reportAgentRequest(AppInterface appInterface, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        boolean z16;
        if (appInterface != null && jSONObject2 != null) {
            try {
                long optLong = jSONObject2.optLong("totalTime");
                long optLong2 = jSONObject2.optLong("packTime");
                long optLong3 = jSONObject2.optLong("SSONetworkTime");
                long optLong4 = jSONObject2.optLong("unpackTime");
                long optLong5 = jSONObject2.optLong("serverProcessTime");
                long optLong6 = jSONObject.optLong(CALLBACK_COLUMN_SSORET, 0L);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", String.valueOf(optLong6));
                hashMap.put("totalTime", optLong + "");
                hashMap.put("packTime", optLong2 + "");
                hashMap.put("SSONetworkTime", optLong3 + "");
                hashMap.put("unpackTime", optLong4 + "");
                hashMap.put("serverProcessTime", optLong5 + "");
                hashMap.put("cmd", str);
                String currentAccountUin = appInterface.getCurrentAccountUin();
                StatisticCollector statisticCollector = StatisticCollector.getInstance(appInterface.getApplicationContext());
                if (0 == optLong6) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                statisticCollector.collectPerformance(currentAccountUin, str2, z16, optLong, 0L, hashMap, "", false);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "report ssoWebView:  " + th5);
                }
            }
        }
    }
}
