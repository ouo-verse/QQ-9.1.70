package com.tencent.hippy.qq.utils;

import android.content.Context;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DeviceInfoUtils {
    private static final String EMPTY_JSON = "{}";
    private static final String TAG = "DeviceInfoUtils";

    private static String getApkVersionName(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e16) {
            QLog.e("DeviceInfoUtils", 1, "getApkVersionName error:", e16);
            return "";
        }
    }

    public static String getClientInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("qqVersion", getApkVersionName(BaseApplication.getContext()));
            jSONObject.put("qqBuild", AppSetting.f99542b);
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("DeviceInfoUtils", 1, "getClientInfo error:", e16);
            return "{}";
        }
    }

    public static String getDeviceInfo() {
        String str;
        String str2;
        String model = DeviceInfoMonitor.getModel();
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.FINGERPRINT;
        String str5 = Build.VERSION.INCREMENTAL;
        try {
            str = o.b();
        } catch (Exception unused) {
            str = "";
        }
        try {
            try {
                str2 = o.c();
            } catch (Exception unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e("DeviceInfoUtils", 2, "get QIMEI fail");
                }
                str2 = "";
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", model);
                jSONObject.put("systemName", "android");
                jSONObject.put("systemVersion", str3);
                jSONObject.put("isMobileQQ", true);
                jSONObject.put(IECDtReport.ACTION_IDENTIFIER, "");
                jSONObject.put("fingerprint", str4);
                jSONObject.put("incremental", str5);
                jSONObject.put("macAddress", MobileInfoUtil.getLocalMacAddress());
                jSONObject.put("androidID", "");
                jSONObject.put(MobileInfoUtil.IMSI, "");
                jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str);
                jSONObject.put("qimei36", str2);
                jSONObject.put("totalMemory", String.valueOf(m.c()));
                jSONObject.put("availableMemory", String.valueOf(ah.X()));
                jSONObject.put("cpuType", ah.o());
                jSONObject.put("cpuNum", ah.n());
                jSONObject.put("cpuFreq", ah.l());
                jSONObject.put("msfImei", MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS));
                return jSONObject.toString();
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("model", model);
            jSONObject2.put("systemName", "android");
            jSONObject2.put("systemVersion", str3);
            jSONObject2.put("isMobileQQ", true);
            jSONObject2.put(IECDtReport.ACTION_IDENTIFIER, "");
            jSONObject2.put("fingerprint", str4);
            jSONObject2.put("incremental", str5);
            jSONObject2.put("macAddress", MobileInfoUtil.getLocalMacAddress());
            jSONObject2.put("androidID", "");
            jSONObject2.put(MobileInfoUtil.IMSI, "");
            jSONObject2.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str);
            jSONObject2.put("qimei36", str2);
            jSONObject2.put("totalMemory", String.valueOf(m.c()));
            jSONObject2.put("availableMemory", String.valueOf(ah.X()));
            jSONObject2.put("cpuType", ah.o());
            jSONObject2.put("cpuNum", ah.n());
            jSONObject2.put("cpuFreq", ah.l());
            jSONObject2.put("msfImei", MsfSdkUtils.getIMEIForMain(MsfSdkUtils.BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS));
            return jSONObject2.toString();
        } catch (JSONException e16) {
            QLog.e("DeviceInfoUtils", 1, "getDeviceInfo error:" + e16);
            return "{}";
        }
    }

    public static String getGdtDeviceInfo(HippyMap hippyMap) {
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(BaseApplication.getContext(), new GdtDeviceInfoHelper.Params());
            if (create != null) {
                deviceInfo = create.deviceInfo;
            } else {
                deviceInfo = null;
            }
            Object pbToJson = GdtJsonPbUtil.pbToJson(deviceInfo);
            if (pbToJson instanceof JSONObject) {
                return ((JSONObject) pbToJson).toString();
            }
            return "";
        } catch (Throwable th5) {
            QLog.e("DeviceInfoUtils", 1, "getGdtDeviceInfo error:" + th5);
            return "";
        }
    }
}
