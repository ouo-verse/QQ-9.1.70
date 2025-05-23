package com.tencent.mobileqq.vastrash.uec;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes20.dex */
class UECPageStayReportManager$1 implements Runnable {
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b.d(null) > 0) {
                LockMethodProxy.sleep(b.d(null));
            }
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (b.b(null)) {
            arrayList.addAll(b.b(null));
            b.b(null).clear();
            b.a(null).set(false);
        }
        b.c(null, arrayList);
        if (QLog.isDevelopLevel()) {
            QLog.d("UECPageStayReportManager", 4, "report finish!!!");
        }
    }
}
