package com.tencent.mobileqq.perf.thread.block;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.ThreadLooperPrinter2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
class c implements Printer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f258109a;

    /* renamed from: b, reason: collision with root package name */
    private long f258110b;

    /* renamed from: c, reason: collision with root package name */
    private long f258111c;

    /* renamed from: d, reason: collision with root package name */
    private String f258112d;

    /* renamed from: e, reason: collision with root package name */
    ThreadWatcher f258113e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ThreadWatcher threadWatcher) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) threadWatcher);
        } else {
            this.f258113e = threadWatcher;
        }
    }

    @Override // android.util.Printer
    public void println(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (str.startsWith(ThreadLooperPrinter2.START_PREFIX)) {
            this.f258111c = SystemClock.uptimeMillis();
            this.f258112d = str;
            ThreadWatcher threadWatcher = this.f258113e;
            if (threadWatcher != null) {
                threadWatcher.e();
                return;
            }
            return;
        }
        if (this.f258111c != 0 && str.startsWith(ThreadLooperPrinter2.STOP_PREFIX)) {
            this.f258109a++;
            long uptimeMillis = SystemClock.uptimeMillis() - this.f258111c;
            this.f258111c = 0L;
            this.f258110b += uptimeMillis;
            ThreadWatcher threadWatcher2 = this.f258113e;
            if (threadWatcher2 != null) {
                threadWatcher2.d(this.f258112d, uptimeMillis);
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return super.toString() + "(msgCount = " + this.f258109a + ", totalCost = " + this.f258110b + ")";
    }
}
