package com.tencent.mobileqq.perf.startup;

import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.AppSetting;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f258033a;

    /* renamed from: b, reason: collision with root package name */
    private static long f258034b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258033a = "";
            f258034b = 0L;
        }
    }

    public static void a(long j3, String str) {
        if (j3 > 0 && str != null) {
            com.tencent.mobileqq.perf.log.a.c("AS", "AddFrame_" + str.substring(str.lastIndexOf(46)) + ", cost=" + (System.currentTimeMillis() - j3));
        }
    }

    public static void b(String str) {
        if (AppSetting.isPublicVersion()) {
            return;
        }
        if ("Begin".equals(str)) {
            f258034b = System.currentTimeMillis();
        } else {
            if (f258033a.equals("End")) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "QQFrame_" + str;
            com.tencent.mobileqq.perf.log.a.c("AS", str2 + ", cost=" + (currentTimeMillis - f258034b) + ", lastState:" + f258033a);
            PerfReportUtil.b(str2, currentTimeMillis - f258034b);
            if (!"End".equals(str)) {
                f258034b = currentTimeMillis;
            }
        }
        f258033a = str;
    }
}
