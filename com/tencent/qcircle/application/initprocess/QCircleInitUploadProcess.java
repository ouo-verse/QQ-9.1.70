package com.tencent.qcircle.application.initprocess;

import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;

/* loaded from: classes22.dex */
public class QCircleInitUploadProcess extends b {
    private void b() {
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qcircle.application.initprocess.QCircleInitUploadProcess.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QCircleOutboxTaskQueue", 1, "initOutbox...");
                QCircleOutboxTaskQueue.k();
            }
        }, 30000L);
    }

    @Override // com.tencent.qcircle.application.initprocess.b, com.tencent.qcircle.application.initprocess.a
    public void process() {
        super.process();
        QLog.d("QCircleInitUploadProcess", 2, "process begin");
        b();
        QLog.d("QCircleInitUploadProcess", 2, "process end");
    }
}
