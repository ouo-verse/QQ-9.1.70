package com.tencent.mobileqq.data.dt;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class QQDtSamplingToggleUpdateImpl implements com.tencent.mobileqq.qqfeatureswitch.c {
    @Override // com.tencent.mobileqq.qqfeatureswitch.c
    public void a() {
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.data.dt.QQDtSamplingToggleUpdateImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("QQDtSamplingToggleUpdateImpl", 1, "onFeatureUpdate");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    g.c().g(peekAppRuntime);
                    g.c().m();
                    g.c().o();
                }
            }
        }, 16, null, true);
    }
}
