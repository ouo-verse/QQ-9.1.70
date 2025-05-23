package com.tencent.mobileqq.search.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f283717a = "b";

    /* renamed from: b, reason: collision with root package name */
    public static String f283718b = "";

    public static String a(int i3) {
        if (i3 == 1) {
            return "message";
        }
        if (i3 == 2) {
            return "contact";
        }
        if (i3 != 21 && i3 != 3) {
            return "unknown";
        }
        return "dongtai";
    }

    public static String b() {
        int i3;
        if (QQTheme.isNowSimpleUI()) {
            i3 = R.string.f201154u2;
        } else if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            i3 = R.string.f201164u3;
        } else {
            i3 = R.string.f201144u1;
        }
        return BaseApplication.getContext().getString(i3);
    }

    public static String c() {
        return "old_search";
    }

    public static boolean d() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100818", false);
        QLog.d("searchReportClick898", 1, "searchReportClick898 isSwitchOn" + isSwitchOn);
        return isSwitchOn;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x002d, code lost:
    
        if (r19 != 21) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(AppInterface appInterface, int i3, int i16, String str, int i17, int i18, String str2, String str3) {
        int i19;
        String str4;
        String str5;
        if (d()) {
            return;
        }
        int i26 = 3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i26 = 0;
                    }
                } else {
                    i26 = 2;
                }
            } else {
                i26 = 1;
            }
        } else {
            if (i16 != 0) {
                if (i16 != 1) {
                    if (i16 == 2) {
                        i19 = 2;
                    }
                } else {
                    i19 = 1;
                }
                if (str2 == null) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if (TextUtils.isEmpty(str3)) {
                    str5 = b();
                } else {
                    str5 = str3;
                }
                String str6 = str5;
                String str7 = str4;
                ReportController.o(appInterface, "dc00898", "", "", "qqsearch", str, i19, 0, i17 + "", i18 + "", str7, str6);
                if (QLog.isColorLevel()) {
                    QLog.d("searchReportClick898", 2, " source: " + i3 + " from: " + i16 + "  sopName: " + str + " r1: " + i17 + " r2: " + i18 + " r3: " + str7 + " r4: " + str6);
                    return;
                }
                return;
            }
            i19 = 0;
            if (str2 == null) {
            }
            if (TextUtils.isEmpty(str3)) {
            }
            String str62 = str5;
            String str72 = str4;
            ReportController.o(appInterface, "dc00898", "", "", "qqsearch", str, i19, 0, i17 + "", i18 + "", str72, str62);
            if (QLog.isColorLevel()) {
            }
        }
        i19 = i26;
        if (str2 == null) {
        }
        if (TextUtils.isEmpty(str3)) {
        }
        String str622 = str5;
        String str722 = str4;
        ReportController.o(appInterface, "dc00898", "", "", "qqsearch", str, i19, 0, i17 + "", i18 + "", str722, str622);
        if (QLog.isColorLevel()) {
        }
    }

    protected static void f(String str, AppInterface appInterface, ReportModel reportModel) {
        if (reportModel != null && appInterface != null) {
            reportModel.uin = appInterface.getCurrentAccountUin();
            reportModel.version = AppSetting.f99551k;
            NewIntent newIntent = new NewIntent(appInterface.getApplication(), q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", str);
            newIntent.putExtra("content", reportModel.toReportString());
            newIntent.setWithouLogin(true);
            appInterface.startServlet(newIntent);
            if (QLog.isColorLevel()) {
                QLog.d(f283717a, 2, "reportEventRuntime, tag = " + str + ", model = " + reportModel);
                return;
            }
            return;
        }
        QLog.isColorLevel();
    }

    public static void g(String str, AppInterface appInterface, ReportModel reportModel) {
        AppRuntime peekAppRuntime;
        if (TextUtils.isEmpty(str)) {
            QLog.isColorLevel();
            return;
        }
        if (reportModel == null) {
            QLog.isColorLevel();
            return;
        }
        if (appInterface == null && MobileQQ.sProcessId == 1 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (peekAppRuntime instanceof AppInterface)) {
            appInterface = (AppInterface) peekAppRuntime;
        }
        if (appInterface == null) {
            Intent intent = new Intent();
            intent.setClassName(MobileQQ.sMobileQQ, "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", str);
            intent.putExtra("reporting_detail", reportModel);
            intent.putExtra("reporting_count", reportModel.report_count);
            intent.putExtra("is_runtime", 1);
            MobileQQ.sMobileQQ.sendBroadcast(intent);
            return;
        }
        f(str, appInterface, reportModel);
    }

    public static void h(AppInterface appInterface, ReportModelDC02528 reportModelDC02528) {
        g("dc02528", appInterface, reportModelDC02528);
        QLog.isColorLevel();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r18 != 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0034, code lost:
    
        if (r19 != 21) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(AppInterface appInterface, int i3, int i16, String str, int i17, int i18, String str2) {
        AppInterface appInterface2;
        String str3;
        int i19 = 1;
        if (appInterface == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof AppInterface)) {
                QLog.e(f283717a, 1, "app is null");
                return;
            }
            appInterface2 = (AppInterface) peekAppRuntime;
        } else {
            appInterface2 = appInterface;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                }
                i19 = 2;
            }
            String str4 = "" + i17;
            str3 = "" + i18;
            try {
                Integer.valueOf(str4);
                ReportController.o(appInterface2, "dc00898", "", "", "qqsearch", str, i19, 0, str4, str3, str2, b());
            } catch (Exception unused) {
                ReportController.o(appInterface2, "dc00898", "", "", "qqsearch", str, i19, 0, "0", str3, str2, b());
                return;
            }
        }
        if (i16 != 1) {
            if (i16 != 2) {
            }
            i19 = 2;
        }
        String str42 = "" + i17;
        str3 = "" + i18;
        Integer.valueOf(str42);
        ReportController.o(appInterface2, "dc00898", "", "", "qqsearch", str, i19, 0, str42, str3, str2, b());
    }
}
