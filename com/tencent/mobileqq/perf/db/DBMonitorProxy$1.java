package com.tencent.mobileqq.perf.db;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes16.dex */
class DBMonitorProxy$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ HashMap f257644d;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "main_db_close_monitor", true, 0L, 0L, this.f257644d, "");
        } catch (NoClassDefFoundError e16) {
            QLog.e("DBMonitorProxy", 1, e16, new Object[0]);
        }
    }
}
