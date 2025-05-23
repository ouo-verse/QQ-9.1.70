package com.tencent.mobileqq.perf.thread.block;

import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.perf.thread.config.b f258106a;

    /* renamed from: b, reason: collision with root package name */
    private ThreadWatcher f258107b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f258108c;

    public b(com.tencent.mobileqq.perf.thread.config.b bVar, ThreadWatcher threadWatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) threadWatcher);
            return;
        }
        this.f258108c = false;
        this.f258106a = bVar;
        this.f258107b = threadWatcher;
    }

    private boolean a(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (this.f258108c) {
            return true;
        }
        if (aVar != null && aVar.f258121f) {
            return true;
        }
        return false;
    }

    private com.tencent.mobileqq.perf.thread.config.a b(int i3, com.tencent.mobileqq.perf.thread.config.b bVar) {
        if (bVar == null) {
            return null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return null;
                        }
                        return bVar.f258133l;
                    }
                    return bVar.f258132k;
                }
                return bVar.f258131j;
            }
            return bVar.f258129h;
        }
        return bVar.f258128g;
    }

    private void d(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        Thread fileThread = ThreadManagerV2.getFileThread();
        if (fileThread instanceof HandlerThread) {
            this.f258107b.a(new a((HandlerThread) fileThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorFileThread");
        }
    }

    private void e(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        HandlerThread mSFCommonPriorityThread = ThreadManagerV2.getMSFCommonPriorityThread();
        if (mSFCommonPriorityThread instanceof HandlerThread) {
            this.f258107b.a(new a(mSFCommonPriorityThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorMSFCommonThread");
        }
    }

    private void f(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        HandlerThread mSFHighPriorityThread = ThreadManagerV2.getMSFHighPriorityThread();
        if (mSFHighPriorityThread instanceof HandlerThread) {
            this.f258107b.a(new a(mSFHighPriorityThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorMSFHighThread");
        }
    }

    private void g(int i3, com.tencent.mobileqq.perf.thread.config.a aVar, HandlerThread handlerThread) {
        if (!a(aVar)) {
            return;
        }
        this.f258107b.a(new a(handlerThread, aVar));
        com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMSFThread type:" + i3);
    }

    private void h(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        Thread qQCommonThread = ThreadManagerV2.getQQCommonThread();
        if (qQCommonThread instanceof HandlerThread) {
            this.f258107b.a(new a((HandlerThread) qQCommonThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorQQCommonThread");
        }
    }

    private void i(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        Thread recentThread = ThreadManagerV2.getRecentThread();
        if (recentThread instanceof HandlerThread) {
            this.f258107b.a(new a((HandlerThread) recentThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorRecentThread");
        }
    }

    private void j(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        Thread serviceContentThread = ThreadManagerV2.getServiceContentThread();
        if (serviceContentThread instanceof HandlerThread) {
            this.f258107b.a(new a((HandlerThread) serviceContentThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorServiceContentThread");
        }
    }

    private void k(com.tencent.mobileqq.perf.thread.config.a aVar) {
        if (!a(aVar)) {
            return;
        }
        Thread subThread = ThreadManagerV2.getSubThread();
        if (subThread instanceof HandlerThread) {
            this.f258107b.a(new a((HandlerThread) subThread, aVar));
            com.tencent.mobileqq.perf.log.a.a("TB", "[TM]ThreadBlockMonitor.startMonitorSubThread");
        }
    }

    public void c(int i3, HandlerThread handlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) handlerThread);
            return;
        }
        if (4 != MobileQQ.sProcessId) {
            QLog.d("[TM]ThreadBlockMonitor", 1, "not in msf process. start failed");
            return;
        }
        com.tencent.mobileqq.perf.thread.config.a b16 = b(i3, this.f258106a);
        if (b16 == null) {
            QLog.d("[TM]ThreadBlockMonitor", 1, "configItem is null. start failed");
        } else {
            g(i3, b16, handlerThread);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (4 != MobileQQ.sProcessId) {
            k(this.f258106a.f258122a);
            h(this.f258106a.f258123b);
            i(this.f258106a.f258125d);
            d(this.f258106a.f258124c);
            f(this.f258106a.f258126e);
            e(this.f258106a.f258127f);
            j(this.f258106a.f258134m);
        }
    }
}
