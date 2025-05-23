package com.tencent.mobileqq.ark.secure;

import android.text.TextUtils;
import com.tencent.biz.common.util.k;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, Integer> f199613a = new HashMap<>(8);

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Integer> f199614b = new HashMap<>(8);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f199615c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static String f199616d = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ark.secure.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C7422a {

        /* renamed from: b, reason: collision with root package name */
        public String f199618b;

        /* renamed from: c, reason: collision with root package name */
        public String f199619c;

        /* renamed from: d, reason: collision with root package name */
        public int f199620d;

        /* renamed from: e, reason: collision with root package name */
        public int f199621e;

        /* renamed from: f, reason: collision with root package name */
        public int f199622f;

        /* renamed from: a, reason: collision with root package name */
        public String f199617a = "android";

        /* renamed from: g, reason: collision with root package name */
        public String f199623g = a.a();

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("os", this.f199617a);
                jSONObject.put("app", this.f199618b);
                jSONObject.put("url", this.f199619c);
                jSONObject.put("result", this.f199620d);
                jSONObject.put("scene", this.f199621e);
                jSONObject.put("type", this.f199622f);
                jSONObject.put("ver", this.f199623g);
            } catch (JSONException e16) {
                QLog.e("ArkApp.ArkSecurityReporter", 1, "ArkSafe.report exception=", e16);
            }
            return jSONObject.toString();
        }
    }

    static /* bridge */ /* synthetic */ String a() {
        return b();
    }

    private static String b() {
        if (TextUtils.isEmpty(f199616d)) {
            try {
                String[] split = AppSetting.f99551k.split("\\.");
                if (split != null) {
                    if (split.length >= 3) {
                        f199616d = String.format("%d%02d%02d", Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])), Integer.valueOf(Integer.parseInt(split[2])));
                    } else if (split.length == 2) {
                        f199616d = String.format("%d%02d00", Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
                    }
                }
            } catch (Exception e16) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report get QQVersion=", f199616d);
            }
        }
        return f199616d;
    }

    public static void c(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkSecurityReporter", 2, "handleReportArkOpenUrl ArkSafe.report web url app=", str, " ,sender uin=", str3, " ,r3=3 ,url=", k.f(str2, new String[0]), " ,QQVersion=", b());
        }
        ReportController.r(null, "dc00898", "", str3, "0X8009BD0", "0X8009BD0", 0, 0, b(), "3", str, str2);
    }

    public static void d(String str, String str2, int i3, int i16, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (i16 == 0) {
                synchronized (f199615c) {
                    HashMap<String, Integer> hashMap = f199614b;
                    Integer num = hashMap.get(str);
                    if (num != null) {
                        hashMap.put(str, Integer.valueOf(num.intValue() + 1));
                    } else {
                        hashMap.put(str, 1);
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report invalid navigation url app=", str, ",count=1, result=", Integer.valueOf(i16), ",validType=", Integer.valueOf(i3), ",sender uin=", str3, ",r3=1 ,url=", k.f(str2, new String[0]), " ,QQVersion=", b());
            }
            ReportController.r(null, "dc00898", "", str3, "0X8009BD0", "0X8009BD0", i3, i16, b(), "1", str, str2);
            C7422a c7422a = new C7422a();
            c7422a.f199618b = str;
            c7422a.f199619c = str2;
            c7422a.f199621e = 1;
            c7422a.f199622f = i3;
            c7422a.f199620d = i16;
            h(c7422a);
        }
    }

    public static void e(String str, String str2, int i3, int i16, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (i16 == 0) {
                synchronized (f199615c) {
                    HashMap<String, Integer> hashMap = f199613a;
                    Integer num = hashMap.get(str);
                    if (num != null) {
                        hashMap.put(str, Integer.valueOf(num.intValue() + 1));
                    } else {
                        hashMap.put(str, 1);
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report invalid resource url app=", str, ", count=1, result=", Integer.valueOf(i16), ",validType=", Integer.valueOf(i3), ",sender uin=", str3, " ,url=", k.f(str2, new String[0]), " ,QQVersion=", b());
            }
            ReportController.r(null, "dc00898", "", str3, "0X8009BCF", "0X8009BCF", i3, i16, b(), "0", str, str2);
            C7422a c7422a = new C7422a();
            c7422a.f199618b = str;
            c7422a.f199619c = str2;
            c7422a.f199621e = 0;
            c7422a.f199622f = i3;
            c7422a.f199620d = i16;
            h(c7422a);
        }
    }

    public static void f(String str, String str2, int i3, int i16, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (i16 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report web url app=", str, ", count=1, result=0, r3=2, url=", k.f(str2, new String[0]), ",QQVersion=", b());
                }
                ReportController.r(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, 0, b(), "2", str, "");
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report web url app=", str, ", count=1, result=", Integer.valueOf(i16), ",validType=", Integer.valueOf(i3), " ,sender uin=", str3, " ,r3=2 ,url=", k.f(str2, new String[0]), " ,QQVersion=", b());
            }
            ReportController.r(null, "dc00898", "", str3, "0X8009BD0", "0X8009BD0", i3, i16, b(), "2", str, str2);
            C7422a c7422a = new C7422a();
            c7422a.f199618b = str;
            c7422a.f199619c = str2;
            c7422a.f199621e = 2;
            c7422a.f199622f = i3;
            c7422a.f199620d = i16;
            h(c7422a);
        }
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Object obj = f199615c;
        synchronized (obj) {
            HashMap<String, Integer> hashMap = f199613a;
            Integer num = hashMap.get(str);
            if (num != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report valid resource app=", str, ", count=", num, ", result=0 , QQVersion=", b());
                }
                ReportController.n(null, "dc00898", "", "", "0X8009BCF", "0X8009BCF", 0, num.intValue(), 0, b(), "", str, "");
                hashMap.remove(str);
            }
        }
        synchronized (obj) {
            HashMap<String, Integer> hashMap2 = f199614b;
            Integer num2 = hashMap2.get(str);
            if (num2 != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report valid navigation app=", str, ", count=", num2, ", result=0, r3=1, QQVersion=", b());
                }
                ReportController.n(null, "dc00898", "", "", "0X8009BD0", "0X8009BD0", 0, num2.intValue(), 0, b(), "1", str, "");
                hashMap2.remove(str);
            }
        }
    }

    private static void h(C7422a c7422a) {
        if (c7422a == null) {
            return;
        }
        String c7422a2 = c7422a.toString();
        if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkSecurityReporter", 2, "ArkSafe.report reportRealTime content=", c7422a2);
        }
        if (MobileQQ.sProcessId == 1) {
            ((IArkService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IArkService.class, "")).doURLReport(c7422a2);
        }
    }
}
