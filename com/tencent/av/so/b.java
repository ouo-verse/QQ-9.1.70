package com.tencent.av.so;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f74638a = false;

    public static Map<String, String> a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("application_type", "AQQ");
        hashMap.put("application_version", AppSetting.d());
        hashMap.put("qav_rtc_sdk_version", str);
        hashMap.put("md5", str2);
        hashMap.put("qav_rtc_sdk_downloaded", str3);
        return hashMap;
    }

    public static Map<String, String> b(String str, String str2, String str3, boolean z16, boolean z17, int i3) {
        Object obj;
        HashMap hashMap = new HashMap();
        hashMap.put("application_type", "AQQ");
        hashMap.put("application_version", AppSetting.d());
        hashMap.put(NativeMonitorConfigHelper.SUB_KEY_SYMBOL, str);
        hashMap.put("qav_rtc_sdk_version", str2);
        hashMap.put("md5", str3);
        String str4 = "true";
        if (z16) {
            obj = "true";
        } else {
            obj = "false";
        }
        hashMap.put("is_load_from_local", obj);
        if (!z17) {
            str4 = "false";
        }
        hashMap.put("is_load_success", str4);
        hashMap.put("retry_cnt", "" + i3);
        return hashMap;
    }

    public static boolean c(String str, String str2, String str3, String str4, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("application_type", "AQQ");
        hashMap.put("application_version", AppSetting.d());
        hashMap.put("qav_res_id", str2);
        hashMap.put("qav_res_url", str3);
        hashMap.put("qav_res_md5", str4);
        hashMap.put("qav_res_download_state", String.valueOf(i3));
        d(str, hashMap);
        return true;
    }

    public static boolean d(String str, Map<String, String> map) {
        String str2;
        if (!f74638a) {
            QQBeaconReport.start();
            f74638a = true;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && mobileQQ.peekAppRuntime() != null) {
            str2 = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        } else {
            str2 = "";
        }
        QQBeaconReport.reportWithAppKey("0AND0708YG43EUAN", str2, str, true, map, true);
        return true;
    }
}
