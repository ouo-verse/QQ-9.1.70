package com.tencent.mobileqq.qqmatrix;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes17.dex */
public class ThreadMonitorUpdateImpl implements com.tencent.mobileqq.qqfeatureswitch.c {
    @Override // com.tencent.mobileqq.qqfeatureswitch.c
    public void a() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqmatrix.ThreadMonitorUpdateImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("ThreadMonitorUpdateImpl", 1, "onFeatureUpdate");
                try {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        b.b().n(peekAppRuntime);
                        b.b().j(peekAppRuntime);
                        b.b().l();
                        b.b().m();
                    }
                } catch (Exception e16) {
                    QLog.e("ThreadMonitorUpdateImpl", 1, "[onFeatureUpdate]:" + e16.toString());
                }
            }
        }, 16, null, true);
    }
}
