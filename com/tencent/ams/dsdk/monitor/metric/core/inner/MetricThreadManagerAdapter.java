package com.tencent.ams.dsdk.monitor.metric.core.inner;

import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.monitor.metric.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MetricThreadManagerAdapter implements m {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MetricThreadManagerAdapter";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class SafeRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private final String from;
        private final Runnable runnable;

        /* synthetic */ SafeRunnable(Runnable runnable, String str, AnonymousClass1 anonymousClass1) {
            this(runnable, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, this, runnable, str, anonymousClass1);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Runnable runnable = this.runnable;
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th5) {
                DLog.e(MetricThreadManagerAdapter.TAG, "[SafeRunnable] error happens in " + this.from, th5);
            }
        }

        SafeRunnable(Runnable runnable, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) str);
            } else {
                this.runnable = runnable;
                this.from = str;
            }
        }
    }

    public MetricThreadManagerAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean postDelayed(Runnable runnable, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, runnable, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        AnonymousClass1 anonymousClass1 = null;
        if (i3 != 10) {
            WorkThreadManager.getInstance().scheduleOnSingleThread(new SafeRunnable(runnable, "commonSingleThread", anonymousClass1), j3);
            return true;
        }
        String str = "networkThread";
        if (j3 == 0) {
            WorkThreadManager.getInstance().getBackgroundThreadPool().execute(new SafeRunnable(runnable, str, anonymousClass1));
        } else {
            WorkThreadManager.getInstance().scheduleOnSingleThread(new SafeRunnable(runnable, str, anonymousClass1), j3);
        }
        return true;
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean quitSafely() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
