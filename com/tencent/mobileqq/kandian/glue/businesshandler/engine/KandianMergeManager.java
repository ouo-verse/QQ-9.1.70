package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class KandianMergeManager implements Manager {
    public KandianMergeManager(QQAppInterface qQAppInterface) {
        QLog.i("KandianMergeManager", 1, "[KandianMergeManager] constructed.");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.1
            @Override // java.lang.Runnable
            public void run() {
                KandianMergeManager.this.b();
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.2
            @Override // java.lang.Runnable
            public void run() {
                ReadInJoyMMapKvStorage.resetRootPath();
            }
        });
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        ReadInJoyHelper.g();
    }
}
