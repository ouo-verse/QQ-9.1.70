package cooperation.vip.ad;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes28.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static String f391236a = "";

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f391237b = Boolean.FALSE;

    public static void a(String str, int i3, String str2) {
        i(i3, str, 1, str2, "", "", true, 339);
    }

    public static void b(String str, int i3, String str2) {
        i(i3, str, 1, str2, "", "", true, 340);
    }

    public static void c(String str, int i3, int i16, String str2) {
        h(i3, str, i16, str2, "tianshu.31", "");
    }

    public static void d(String str, int i3, String str2) {
        c(str, i3, 1, str2);
    }

    public static void e(String str, int i3) {
        i(i3, str, 1, "", "tianshu.47", "", true, SubAccountBindActivity.ERROR_ACCOUNT_LOCK);
    }

    public static void f(String str, int i3, String str2) {
        i(i3, str, 1, str2, "", "", true, 341);
    }

    public static void g(String str, int i3) {
        i(i3, str, 1, "", "tianshu.47", "", true, 596);
    }

    public static void h(int i3, String str, int i16, String str2, String str3, String str4) {
        i(i3, str, i16, str2, str3, str4, true, 0);
    }

    public static void i(int i3, String str, int i16, String str2, String str3, String str4, boolean z16, int i17) {
        String str5;
        try {
            TianShuReportData tianShuReportData = new TianShuReportData();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime == null) {
                str5 = "";
            } else {
                str5 = runtime.getAccount();
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            tianShuReportData.mTraceId = str5 + "_" + currentTimeMillis;
            tianShuReportData.mActionId = i3;
            tianShuReportData.mActionValue = i16;
            tianShuReportData.mItemId = str;
            tianShuReportData.mOperTime = currentTimeMillis;
            tianShuReportData.mTraceNum = 1;
            tianShuReportData.mAppId = str3;
            tianShuReportData.mPageId = str4;
            tianShuReportData.mModuleId = "";
            tianShuReportData.mTriggerInfo = str2;
            tianShuReportData.mNeedReportCachedUrl = z16;
            tianShuReportData.mAdSpace = i17;
            TianShuManager.getInstance().report(tianShuReportData);
            if (QLog.isDevelopLevel()) {
                QLog.i("TianshuReportUtils", 4, "report appId:" + str3 + " adId:" + str + " actionId:" + i3);
            }
        } catch (Exception e16) {
            QLog.e("TianshuReportUtils", 1, "report exception" + e16.toString());
        }
    }

    public static void j(String str, int i3, String str2) {
        i(i3, str, 1, str2, "tianshu.150", "", false, 510);
    }

    public static void k(String str, int i3) {
        i(i3, str, 1, "", "tianshu.185", "", true, 715);
    }

    public static void l(String str, int i3, int i16, String str2) {
        i(i3, str, i16, str2, "vab_qboss", "", true, 715);
    }

    public static void m(String str, int i3, int i16, String str2, int i17) {
        i(i3, str, i16, str2, "", "", true, i17);
    }

    public static void n(String str, int i3, String str2, int i16) {
        i(i3, str, 1, str2, "", "", true, i16);
    }

    public static void o(String str, int i3, String str2) {
        i(i3, str, 1, str2, "tianshu.32", "", true, 716);
    }

    public static void p(String str, int i3, String str2) {
        i(i3, str, 1, str2, "tianshu.32", "", false, 716);
    }

    public static void q(String str, int i3, String str2) {
        QLog.d("TianshuReportUtils", 1, "adId:" + str + " actionID:" + i3);
        String accountId = RFWApplication.getAccountId();
        if (accountId == null) {
            return;
        }
        if (!accountId.equals(f391236a)) {
            f391236a = accountId;
            f391237b = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tianshu_splash_monitor_sample_report", false));
        }
        if (!f391237b.booleanValue()) {
            return;
        }
        c(str, i3, 1, str2);
    }

    public static void r(String str, int i3, String str2) {
        i(i3, str, 1, str2, "tianshu.150", "", true, 510);
    }
}
