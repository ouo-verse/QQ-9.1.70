package com.tencent.open.business.base;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.WindowManager;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.open.base.f;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.QQDeviceInfo;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MobileInfoUtil {
    public static final int APP_VERSION = 1;
    private static final String BUSINESS_ID_IMEI = "52b7f2";
    private static final String BUSINESS_ID_IMSI = "ea6862";
    private static final String BUSINESS_ID_MAC_ADDRESS = "7ef1aa";
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    protected static final String MOBILE_INFO = "appcenter_mobileinfo";
    public static final String WIFI_MAC_ADDRESS = "wifi_mac_address";
    protected static String imei;
    protected static String imsi;
    protected static String localMacAddress;
    protected static String location;
    protected static String resolution;

    public static String getCity() {
        return "";
    }

    public static String getDeviceinfoForCgiReport(boolean z16) {
        String imei2;
        int i3;
        try {
            BaseApplication context = BaseApplication.getContext();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("imei=");
            String str = "";
            if (z16) {
                imei2 = "";
            } else {
                imei2 = getImei();
            }
            sb5.append(imei2);
            sb5.append(Typography.amp);
            sb5.append("model=");
            sb5.append(DeviceInfoMonitor.getModel());
            sb5.append(Typography.amp);
            sb5.append("os=");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append(Typography.amp);
            sb5.append("apilevel=");
            sb5.append(Build.VERSION.SDK_INT);
            sb5.append(Typography.amp);
            String b16 = com.tencent.open.base.a.b(context);
            if (b16 != null) {
                str = b16;
            }
            sb5.append("network=");
            sb5.append(str);
            sb5.append(Typography.amp);
            sb5.append("sdcard=");
            if (Environment.getExternalStorageState().equals("mounted")) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append(Typography.amp);
            sb5.append("display=");
            sb5.append(getResolution());
            sb5.append(Typography.amp);
            sb5.append("manu=");
            sb5.append(Build.MANUFACTURER);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("wifi=");
            sb5.append(com.tencent.open.base.a.h(context));
            return sb5.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getImei() {
        if (TextUtils.isEmpty(imei)) {
            imei = "";
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
                String decodeString = from.decodeString("imei", "");
                imei = decodeString;
                if (TextUtils.isEmpty(decodeString)) {
                    try {
                        imei = QQDeviceInfo.getIMEI(BUSINESS_ID_IMEI);
                    } catch (Exception unused) {
                    }
                    String str = imei;
                    if (str != null) {
                        from.encodeString("imei", str).commitAsync();
                    }
                }
            }
        }
        return imei;
    }

    public static String getImsi() {
        if (TextUtils.isEmpty(imsi)) {
            imsi = "";
            BaseApplication context = BaseApplication.getContext();
            if (context != null) {
                MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
                String decodeString = from.decodeString(IMSI, "");
                imsi = decodeString;
                if (TextUtils.isEmpty(decodeString)) {
                    try {
                        imsi = QQDeviceInfo.getIMSI(BUSINESS_ID_IMSI);
                    } catch (Exception unused) {
                    }
                    String str = imsi;
                    if (str != null) {
                        from.encodeString(IMSI, str).commitAsync();
                    }
                }
            }
        }
        return imsi;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocalMacAddress() {
        if (TextUtils.isEmpty(localMacAddress)) {
            localMacAddress = "";
            try {
                BaseApplication context = BaseApplication.getContext();
                if (context != null) {
                    MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
                    String decodeString = from.decodeString(WIFI_MAC_ADDRESS, "");
                    localMacAddress = decodeString;
                    if (TextUtils.isEmpty(decodeString)) {
                        String mac = QQDeviceInfo.getMAC(BUSINESS_ID_MAC_ADDRESS);
                        localMacAddress = mac;
                        if (mac != null) {
                            from.encodeString(WIFI_MAC_ADDRESS, mac).commitAsync();
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return localMacAddress;
    }

    public static String getLocation() {
        return "";
    }

    public static String getMobileInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qua", com.tencent.open.adapter.a.f().i());
            jSONObject.put("longitude", getLocation());
            jSONObject.put("platform", com.tencent.open.adapter.a.f().h());
            jSONObject.put("uin", com.tencent.open.adapter.a.f().l());
            jSONObject.put("imei", getImei());
            jSONObject.put("imei", getImei());
            jSONObject.put("resolution", getResolution());
            jSONObject.put("network", com.tencent.open.base.a.c(com.tencent.open.adapter.a.f().e()));
            jSONObject.put("wifimac", getLocalMacAddress());
            jSONObject.put("mobile_pf", "1");
            jSONObject.put("os_ver", Build.VERSION.RELEASE);
            jSONObject.put("lang", getLanguage());
            jSONObject.put("device", Build.DEVICE);
            jSONObject.put("model_name", DeviceInfoMonitor.getModel());
            jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, "1.5");
            jSONObject.put("timezone", TimeZone.getDefault().getID());
            jSONObject.put("city", getCity());
            jSONObject.put("longitude", getLocation());
            jSONObject.put("ret_code", "0");
            jSONObject.put("qua", com.tencent.open.adapter.a.f().i());
            jSONObject.put("qz_ver", com.tencent.open.adapter.a.f().d());
            jSONObject.put(IMSI, getImsi());
            jSONObject.put("androidID", "");
            jSONObject.put("os_api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdkVersionCode", 1);
            jSONObject.put("QVersionCode", com.tencent.open.adapter.a.f().c());
            jSONObject.put("brand", GlobalUtil.getInstance().getBrand());
            jSONObject.put("manufacture", GlobalUtil.getInstance().getManufacture());
            jSONObject.put("product", GlobalUtil.getInstance().getProduct());
        } catch (Exception unused) {
            f.c("getMobileInfo", "gather mobile info exception.");
        }
        return jSONObject.toString();
    }

    public static String getResolution() {
        try {
            if (!TextUtils.isEmpty(resolution)) {
                return resolution;
            }
            WindowManager windowManager = (WindowManager) BaseApplication.getContext().getSystemService("window");
            return windowManager.getDefaultDisplay().getWidth() + HippyTKDListViewAdapter.X + windowManager.getDefaultDisplay().getHeight();
        } catch (Exception unused) {
            f.c("getResolution", "gather width height exception.");
            return "0x0";
        }
    }
}
