package com.qzone.homepage.diy.util;

import android.text.TextUtils;
import com.qzone.util.ar;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f47548a = ar.e(75.0f);

    private static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.charAt(0) == '#') {
            return str.length() == 7 || str.length() == 9;
        }
        return false;
    }

    public static String c(String str, String str2) {
        if (a(str)) {
            return str;
        }
        QZLog.e("QzoneDIYHelper", 1, "getColorValue error = " + str);
        return str2;
    }

    public static void d(int i3) {
        QZLog.i("QzoneDIYHelper", 1, "report reserve = " + i3);
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(LpReportInfoConfig.ACTION_TYPE_DIY, 30, i3), false, false);
    }

    public static int b() {
        return ar.e(164.0f);
    }
}
