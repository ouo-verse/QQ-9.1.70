package com.tencent.mobileqq.qqgamepub.manager;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes16.dex */
public class PageVisitTimeReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f264602a;

    public PageVisitTimeReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264602a = 0L;
        }
    }

    private void a(long j3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("PageVisitTimeReporter", 2, "[report], totalTime:" + j3);
        }
        ThreadManagerV2.excute(new Runnable(j3) { // from class: com.tencent.mobileqq.qqgamepub.manager.PageVisitTimeReporter.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f264603d;

            {
                this.f264603d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PageVisitTimeReporter.this, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ext4", "8");
                hashMap.put("ext46", String.valueOf(this.f264603d));
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "765", "76502", "912717", "", hashMap);
            }
        }, 128, null, false);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("PageVisitTimeReporter", 2, "[startVisit]");
        }
        this.f264602a = System.currentTimeMillis();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f264602a;
        if (QLog.isDevelopLevel()) {
            QLog.i("PageVisitTimeReporter", 2, "[stopVisit], totalVisitTime:" + currentTimeMillis);
        }
        a(currentTimeMillis);
    }
}
