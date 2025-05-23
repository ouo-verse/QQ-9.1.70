package com.tencent.qcircle.application.initprocess;

import android.app.ActivityManager;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.helpers.QFSBarrageHelper;
import com.tencent.biz.qqcircle.manager.QCircleAvatarDecorateManager;
import com.tencent.biz.qqcircle.manager.diffres.QCircleChangeResEngine;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;
import cooperation.qzone.util.QZLog;
import java.util.List;

/* loaded from: classes22.dex */
public class QCircleLazyLoadProcess extends b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public class a implements IQQFrontBackListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
        public void onQQEnterBackground() {
            if (!QCircleLazyLoadProcess.e()) {
                UploadServiceBuilder.getInstance().setBackgroundMode(true);
            }
            WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
            if (qfsService == null) {
                QLog.w("QCircleLazyLoadProcess", 1, "[onQQEnterBackground] invalid service");
            } else if (qfsService.hasRunningTask()) {
                WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_BACKGROUND).ext1("true").getReportData(), 1);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
        public void onQQEnterForeground() {
            WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
            if (qfsService == null) {
                QLog.w("QCircleLazyLoadProcess", 1, "[onQQEnterForeground] invalid service");
            } else if (qfsService.hasRunningTask()) {
                WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_PUBLISH_BACKGROUND).ext1("false").getReportData(), 1);
            }
        }
    }

    private void b() {
        QCircleListenerProxyManager.getInstance().addQQFrontBackListener(new a());
    }

    private void c() {
        QCircleAvatarDecorateManager.INSTANCE.init();
        QCircleChangeResEngine.INSTANCE.init();
    }

    private void d() {
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qcircle.application.initprocess.QCircleLazyLoadProcess.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QCircleOutboxTaskQueue", 1, "initOutbox...");
                QCircleReportOutboxTaskQueue.getInstance();
                QCircleOutboxTaskQueue.k();
            }
        }, 10000L);
    }

    public static boolean e() {
        ActivityManager activityManager = (ActivityManager) RFWApplication.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return false;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName.endsWith(":peak") && runningAppProcessInfo.importance == 100) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("QCircleLazyLoadProcess", 2, "isQQCircleExtraProcessForground >> " + runningAppProcessInfo.processName + "[ " + runningAppProcessInfo.importance + " ]");
                        }
                        return true;
                    }
                }
            } else {
                QZLog.i("QCircleLazyLoadProcess", 1, "isQQCircleExtraProcessForground: RunningAppProcess null");
            }
        } catch (Exception e16) {
            QZLog.e("QCircleLazyLoadProcess", 1, "isQQCircleExtraProcessForground: exception:", e16);
        }
        return false;
    }

    @Override // com.tencent.qcircle.application.initprocess.b, com.tencent.qcircle.application.initprocess.a
    public void process() {
        QLog.d("QCircleLazyLoadProcess", 1, "process begin");
        b();
        c();
        d();
        QFSBarrageHelper.c().d();
        QCircleRelationGroupManager.instance().loadRelationGroup();
        QLog.d("QCircleLazyLoadProcess", 1, "process end");
    }
}
