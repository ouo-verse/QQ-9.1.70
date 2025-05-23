package com.tencent.mobileqq.qqmatrix;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
class QQThreadMonitorManager$2 implements Runnable {
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.b().h();
            c.a(null);
        } catch (Exception e16) {
            QLog.e("QQThreadMonitorManager", 1, "[executeCheckOnThread]" + e16.toString());
        }
    }
}
