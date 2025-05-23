package com.qzone.util;

import TianShuJce.AdItem;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ak {
    public static TianShuReportData a(int i3, long j3, String str) {
        return b(i3, String.valueOf(j3), str);
    }

    public static TianShuReportData b(int i3, String str, String str2) {
        return c(i3, str, str2, "tianshu.247", "tianshu.247");
    }

    public static TianShuReportData c(int i3, String str, String str2, String str3, String str4) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(LoginData.getInstance().getUin());
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = str3;
        tianShuReportData.mPageId = str4;
        tianShuReportData.mItemId = String.valueOf(str);
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = str2;
        return tianShuReportData;
    }

    public static void d(long j3, String str) {
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(a(102, j3, str));
    }

    public static void e(long j3, String str) {
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(a(101, j3, str));
    }

    public static void f(AdItem adItem, int i3) {
        if (adItem == null) {
            QLog.w("QzoneTianshuReportUtil", 1, "tianShuReportBanner , adItem is null");
        } else {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(a(i3, adItem.iAdId, adItem.traceinfo));
        }
    }

    public static void g(TianShuAccess.AdItem adItem, int i3) {
        if (adItem == null) {
            QLog.w("QzoneTianshuReportUtil", 1, "tianShuReportBanner , adItem is null");
        } else {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(a(i3, adItem.iAdId.get(), adItem.traceinfo.get()));
        }
    }
}
