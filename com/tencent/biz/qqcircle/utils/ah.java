package com.tencent.biz.qqcircle.utils;

import com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QFSTianShuConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ah {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str, int i3, String str2) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        long currentAccountLong = WinkCommonUtil.getCurrentAccountLong();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        tianShuReportData.mToUid = currentAccountLong + "";
        tianShuReportData.mTraceId = currentAccountLong + "_" + currentTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mItemId = str;
        tianShuReportData.mOperTime = currentTimeMillis;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = str2;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public static void c(QFSPersonalInfo qFSPersonalInfo, int i3) {
        if (qFSPersonalInfo != null && qFSPersonalInfo.E > 0) {
            d(qFSPersonalInfo.E + "", i3, qFSPersonalInfo.F);
        }
    }

    public static void d(final String str, final int i3, final String str2) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.utils.ag
            @Override // java.lang.Runnable
            public final void run() {
                ah.b(str, i3, str2);
            }
        });
    }
}
