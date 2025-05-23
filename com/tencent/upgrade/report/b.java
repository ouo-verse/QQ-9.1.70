package com.tencent.upgrade.report;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.util.HttpUtil;
import com.tencent.upgrade.util.d;
import cooperation.qzone.report.QZonePushReporter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class a implements HttpUtil.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onFail(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            d.c("ReportHelper", "report errorCode = " + i3 + " errorMsg = " + str);
        }

        @Override // com.tencent.upgrade.util.HttpUtil.b
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            d.a("ReportHelper", "report success  = " + str);
        }
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "01300060238");
        hashMap.put("token", "6574741836");
        hashMap.put(ReportDataBuilder.KEY_HARDWARE_OS, "android");
        hashMap.put("sdk_version", "2.1.3-RC02");
        hashMap.put("app_version", com.tencent.upgrade.util.a.f());
        hashMap.put("app_bundle_id", com.tencent.upgrade.util.a.g());
        return hashMap;
    }

    private static boolean b(int i3) {
        if (i3 <= 0 || new Random().nextInt(i3) != 0) {
            return false;
        }
        return true;
    }

    private static void c(Map<String, String> map, int i3) {
        if (!b(i3)) {
            d.a("ReportHelper", "report return for not hit sampling");
            return;
        }
        try {
            map.put("sampling_count", String.valueOf(i3));
            HttpUtil.h(HttpUtil.e("https://h.trace.qq.com/kv", map), 5000, null, new a());
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
    }

    public static void d(long j3, int i3) {
        e(j3);
        f(i3);
    }

    public static void e(long j3) {
        Map<String, String> a16 = a();
        a16.put("event_name", "launch_elapsed_time");
        a16.put(QZonePushReporter.EVENT_VALUE, String.valueOf(j3));
        c(a16, 1000);
    }

    public static void f(int i3) {
        Map<String, String> a16 = a();
        a16.put("event_name", "launch_state");
        a16.put(QZonePushReporter.EVENT_VALUE, String.valueOf(i3));
        c(a16, 1000);
    }
}
