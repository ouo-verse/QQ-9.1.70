package com.tenpay.sdk.net;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ErrorCode;
import com.tenpay.api.QFuncApi;
import com.tenpay.util.MD5;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetUtil {
    private static final String TAG = "NetUtil";

    public static List<JSONObject> findAllCanUseAutoPay(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("spfa_info");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optJSONObject(i3));
            }
        }
        return arrayList;
    }

    public static List<JSONObject> findBindedBanks(JSONObject jSONObject, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optJSONObject(i3));
            }
        }
        return arrayList;
    }

    public static String getDeviceInfo(Context context, String str) {
        StringBuilder sb5 = new StringBuilder(256);
        boolean z16 = true;
        for (Map.Entry<String, String> entry : getDeviceInfoMap(context, str).entrySet()) {
            if (!z16) {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
            z16 = false;
        }
        return sb5.toString();
    }

    public static HashMap<String, String> getDeviceInfoMap(Context context, String str) {
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("h_model", "android_mqq");
        hashMap.put("h_edition", "126");
        StringBuilder sb5 = new StringBuilder(160);
        String deviceId = QFuncApi.getDeviceId(context);
        if (deviceId != null && deviceId.length() > 0) {
            sb5.append(MD5.hexdigest(deviceId));
        }
        sb5.append("||");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("|");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append(",sdk");
        sb5.append(Build.VERSION.SDK_INT);
        sb5.append("|");
        boolean isPhoneRooted = isPhoneRooted(context);
        INewQWalletApi iNewQWalletApi = (INewQWalletApi) QRoute.api(INewQWalletApi.class);
        if (isPhoneRooted) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        sb5.append(str2);
        sb5.append("|");
        hashMap.put("h_location", Uri.encode(sb5.toString()));
        hashMap.put("h_qq_guid", str);
        hashMap.put("h_qq_appid", iNewQWalletApi.appIdStr());
        hashMap.put("h_exten", "");
        hashMap.put("h_pkg_name", MobileQQ.sMobileQQ.getPackageName());
        return hashMap;
    }

    public static String getDeviceName(Context context) {
        return DeviceInfoMonitor.getModel();
    }

    public static String getDeviceType(Context context) {
        return "android_mqq";
    }

    public static JSONObject getReturnData(int i3, String str) {
        if ((str.length() == 20 || str.length() == 10) && str.indexOf("{") < 0) {
            str = "{tm:\"" + str + "\",retcode:\"0\"}";
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getReturnData: ", th5);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retcode", ErrorCode.ERR_RET_DATA);
                jSONObject.put("retmsg", "\u6570\u636e\u683c\u5f0f\u5f02\u5e38:1000" + i3);
            } catch (Throwable unused) {
                QLog.e(TAG, 1, "getReturnData: ", th5);
            }
            return jSONObject;
        }
    }

    public static boolean isPhoneRooted(Context context) {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                if (new File(strArr[i3] + "su").exists()) {
                    return true;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "isPhoneRooted: ", e16);
            }
        }
        return false;
    }

    public static void setTransferCallBackData(JSONObject jSONObject, Bundle bundle) {
        bundle.putString("retdata", jSONObject.toString());
    }

    public static void preConnect(Context context, String str) {
    }
}
