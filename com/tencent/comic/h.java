package com.tencent.comic;

import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {
    private static boolean a(String str) {
        return "detail".equals(str) || "tag".equals(str) || "topic".equals(str);
    }

    public static void b(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str6)) {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC01327(appInterface, new com.tencent.comic.data.e().x(str).w("2").v("200778").u(str2).y(str3).t(str4));
        } else {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(appInterface, str, "2", "210393", str3, str5, str4);
        }
    }

    public static void c(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str6)) {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC01327(appInterface, new com.tencent.comic.data.e().x(str).w("3").v("39816").u(str2).y(str3).t(str4));
        } else {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(appInterface, str, "3", "300393", str3, str5, str4);
        }
    }

    public static void d(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        if (a(str6)) {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC01327(appInterface, new com.tencent.comic.data.e().x(str).w("3").v("39815").u(str2).y(str3).t(str4));
        } else {
            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(appInterface, str, "3", "300392", str3, str5, str4);
        }
    }
}
