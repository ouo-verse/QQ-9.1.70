package com.tencent.biz.qqcircle.entrance;

import com.tencent.biz.qqcircle.broadcast.QFSGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.proxy.QCircleInvokeModule;
import cooperation.qqcircle.report.outbox.QCircleReportOutboxTaskQueue;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleInvokeInitImpl implements QCircleInvokeModule {
    @Override // cooperation.qqcircle.proxy.QCircleInvokeModule
    public void invoke(int i3, int i16, Object... objArr) {
        if (i16 == 1) {
            QLog.d("QCircleInvokeInitImpl", 1, "init_by_vsnetwork_helper");
            RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.entrance.QCircleInvokeInitImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleReportOutboxTaskQueue.getInstance();
                    QCircleOutboxTaskQueue.k();
                }
            }, 3000L);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.entrance.QCircleInvokeInitImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSGlobalBroadcastHelper.c().d();
                }
            });
        }
    }
}
