package com.tencent.mobileqq.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class as {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Integer> f306597a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f306598b = new ConcurrentHashMap<>();

    private static boolean a(String str) {
        boolean z16;
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f306598b;
        Boolean bool = concurrentHashMap.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (as.class) {
            Boolean bool2 = concurrentHashMap.get(str);
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            int c16 = c(str);
            if (c16 <= 1) {
                return true;
            }
            if (new Random().nextInt(c16) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            concurrentHashMap.put(str, valueOf);
            QLog.i("LoginReportUtil", 1, "combineEvent:" + str + ", sampleRate:" + c16 + ", hit:" + valueOf);
            return valueOf.booleanValue();
        }
    }

    public static void b(String str, String str2, String str3, int i3, int i16, boolean z16, String str4, String str5, String str6, String str7) {
        String str8;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.r(peekAppRuntime, "dc00898", "", e(str3), str2, str2, i3, i16, str4, str5, str6, str7);
        if (!a(str)) {
            return;
        }
        if (peekAppRuntime != null) {
            str8 = peekAppRuntime.getCurrentAccountUin();
        } else {
            str8 = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("tvalue", e(str2));
        hashMap.put("dwfuin", e(str3));
        hashMap.put("dwop_via", String.valueOf(i3));
        hashMap.put("dwop_result", String.valueOf(i16));
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("dwflag2", String.valueOf(NumberUtil.stringToInt(str4, 0)));
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("dwflag3", String.valueOf(NumberUtil.stringToInt(str5, 0)));
        }
        if (z16) {
            hashMap.put("is_nt_login", "1");
        } else {
            hashMap.put("is_nt_login", "0");
        }
        hashMap.put("swflag4", e(str6));
        hashMap.put("swflag5", e(str7));
        QQBeaconReport.report(str8, str, hashMap);
    }

    private static int c(String str) {
        d();
        Integer num = f306597a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private static void d() {
        if (f306597a != null) {
            return;
        }
        f306597a = new HashMap<>();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("login_beacon_report_sample_rate", "");
        QLog.i("LoginReportUtil", 1, "sample rate config: " + loadAsString);
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                JSONObject jSONObject = new JSONObject(loadAsString);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    int i3 = jSONObject.getInt(str);
                    if (!TextUtils.isEmpty(str)) {
                        f306597a.put(str, Integer.valueOf(i3));
                    }
                }
                return;
            } catch (Exception e16) {
                QLog.e("LoginReportUtil", 1, "parse config json error:", e16);
            }
        }
        f306597a.put("account_login_mainline", 30);
        f306597a.put("phone_sms_login_mainline", 10);
        f306597a.put("phone_quick_login_mainline", 10);
        f306597a.put("phone_pwd_login_mainline", 10);
        f306597a.put("puzzle_verify_component", 30);
        f306597a.put("devlock_verify_component", 10);
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void f(AppRuntime appRuntime, String str, String str2, int i3, int i16, String str3) {
        ReportController.o(appRuntime, "dc00898", "", str2, str, str, i3, 0, String.valueOf(i16), "0", str3, "");
    }

    public static void g(AppRuntime appRuntime, String str, String str2, int i3, String str3) {
        ReportController.o(appRuntime, "dc00898", "", str2, str, str, i3, 0, "0", "0", str3, "");
    }
}
