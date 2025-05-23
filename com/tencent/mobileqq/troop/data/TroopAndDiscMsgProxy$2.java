package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
class TroopAndDiscMsgProxy$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f294786d;
    final /* synthetic */ j this$0;

    @Override // java.lang.Runnable
    public void run() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        appRuntime = ((BaseProxy) this.this$0).app;
        statisticCollector.collectPerformance(((QQAppInterface) appRuntime).getCurrentAccountUin(), "aio_break_point", !this.f294786d, 0L, 0L, new HashMap<>(), "");
    }
}
