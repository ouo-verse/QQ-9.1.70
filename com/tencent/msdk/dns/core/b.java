package com.tencent.msdk.dns.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final RunnableC9214b f336241d;

        /* renamed from: e, reason: collision with root package name */
        private final CountDownLatch f336242e;

        a(RunnableC9214b runnableC9214b, CountDownLatch countDownLatch) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnableC9214b, (Object) countDownLatch);
            } else {
                this.f336241d = runnableC9214b;
                this.f336242e = countDownLatch;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                this.f336241d.run();
            } catch (Exception unused) {
            }
            if (!this.f336241d.f336244e) {
                this.f336242e.countDown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.core.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class RunnableC9214b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final Runnable f336243d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f336244e;

        public RunnableC9214b(Runnable runnable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, runnable, Boolean.valueOf(z16));
            } else {
                this.f336243d = runnable;
                this.f336244e = z16;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f336243d.run();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private List<RunnableC9214b> f336245a;

        /* renamed from: b, reason: collision with root package name */
        private CountDownLatch f336246b;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f336245a = Collections.emptyList();
                this.f336246b = null;
            }
        }

        public c a(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            return b(runnable, false);
        }

        public synchronized c b(Runnable runnable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (c) iPatchRedirector.redirect((short) 3, this, runnable, Boolean.valueOf(z16));
            }
            if (runnable != null) {
                if (Collections.emptyList() == this.f336245a) {
                    this.f336245a = new ArrayList();
                }
                this.f336245a.add(new RunnableC9214b(runnable, z16));
                return this;
            }
            throw new IllegalArgumentException("task".concat(" can not be null"));
        }

        public CountDownLatch c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                CountDownLatch c16 = b.c(this);
                this.f336246b = c16;
                return c16;
            }
            return (CountDownLatch) iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CountDownLatch c(c cVar) {
        CountDownLatch countDownLatch = cVar.f336246b;
        if (countDownLatch == null) {
            Iterator it = cVar.f336245a.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (!((RunnableC9214b) it.next()).f336244e) {
                    i3++;
                }
            }
            countDownLatch = new CountDownLatch(i3);
        }
        Iterator it5 = cVar.f336245a.iterator();
        while (it5.hasNext()) {
            DnsExecutors.f336208c.execute(new a((RunnableC9214b) it5.next(), countDownLatch));
        }
        cVar.f336245a.clear();
        return countDownLatch;
    }
}
