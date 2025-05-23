package com.tencent.ams.dynamicwidget.report;

import com.tencent.ams.dynamicwidget.c;
import com.tencent.ams.dynamicwidget.utils.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AbsBusinessReporter extends CacheableReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<Long, DefaultReportWorker> f70205d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class DefaultReportWorker implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final List<AbsBusinessReporter> f70206d;
        final /* synthetic */ AbsBusinessReporter this$0;

        protected void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            b bVar = b.f70218a;
            bVar.a("AbsBusinessReporter", "handleReporter");
            if (this.f70206d.isEmpty()) {
                bVar.d("AbsBusinessReporter", "reporters is empty.");
                return;
            }
            for (AbsBusinessReporter absBusinessReporter : this.f70206d) {
                if (absBusinessReporter != null) {
                    b.f70218a.a("AbsBusinessReporter", "doReport: " + absBusinessReporter);
                    try {
                        absBusinessReporter.h();
                    } catch (Throwable th5) {
                        b.f70218a.b("AbsBusinessReporter", "reporter: " + absBusinessReporter + " doReport error.", th5);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            b.f70218a.a("AbsBusinessReporter", "DefaultReportWorker run");
            if (this.this$0.i()) {
                this.this$0.j();
                return;
            }
            try {
                e();
            } catch (Throwable th5) {
                b.f70218a.b("AbsBusinessReporter", "default report worker run error.", th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f70205d = new ConcurrentHashMap<>();
        }
    }

    protected abstract void h();

    protected boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return c.f70185s.m();
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        try {
            ScheduledExecutorService scheduledExecutorService = CacheableReporter.f70207c;
            if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown() && !CacheableReporter.f70207c.isTerminated()) {
                b.f70218a.a("AbsBusinessReporter", "stopScheduledThreadPool");
                CacheableReporter.f70207c.shutdown();
            }
            f70205d.clear();
        } catch (Throwable th5) {
            b.f70218a.b("AbsBusinessReporter", "stop scheduled thread pool error.", th5);
        }
    }
}
