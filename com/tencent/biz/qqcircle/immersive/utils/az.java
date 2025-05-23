package com.tencent.biz.qqcircle.immersive.utils;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QFSTianShuConstant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tianshu.QQCircleTianShu$AdItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class az {
    public static void a(List<QQCircleTianShu$AdItem> list, int i3) {
        if (list != null && list.size() > 0) {
            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = list.get(0);
            TianShuReportData tianShuReportData = new TianShuReportData();
            tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin());
            tianShuReportData.mItemId = String.valueOf(qQCircleTianShu$AdItem.iAdId.get());
            tianShuReportData.mTraceNum = 1;
            tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
            tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
            tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            tianShuReportData.mActionId = i3;
            tianShuReportData.mActionValue = 1;
            tianShuReportData.mTriggerInfo = qQCircleTianShu$AdItem.traceinfo.get();
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
            return;
        }
        QLog.w("QFSTianShuReportUtils", 1, "tianShuReportBanner , adItems.size() <= 0");
    }

    public static void b(QQCircleTianShu$AdItem qQCircleTianShu$AdItem, int i3) {
        if (qQCircleTianShu$AdItem == null) {
            QLog.w("QFSTianShuReportUtils", 1, "[tianShuReportBanner] adItem == null");
            return;
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = String.valueOf(QCirclePluginUtil.getCurrentAccountLongUin());
        tianShuReportData.mItemId = String.valueOf(qQCircleTianShu$AdItem.iAdId.get());
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mPageId = QFSTianShuConstant.QCIRCLE_APP_ID;
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = qQCircleTianShu$AdItem.traceinfo.get();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }
}
