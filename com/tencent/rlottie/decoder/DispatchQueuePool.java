package com.tencent.rlottie.decoder;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes25.dex */
public class DispatchQueuePool {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static SecureRandom f365210j;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<DispatchQueue> f365211a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<DispatchQueue, Integer> f365212b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<DispatchQueue> f365213c;

    /* renamed from: d, reason: collision with root package name */
    private final int f365214d;

    /* renamed from: e, reason: collision with root package name */
    private final int f365215e;

    /* renamed from: f, reason: collision with root package name */
    private int f365216f;

    /* renamed from: g, reason: collision with root package name */
    private int f365217g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f365218h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f365219i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f365210j = new SecureRandom();
        }
    }

    public DispatchQueuePool(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f365211a = new LinkedList<>();
        this.f365212b = new HashMap<>();
        this.f365213c = new LinkedList<>();
        this.f365219i = new Runnable() { // from class: com.tencent.rlottie.decoder.DispatchQueuePool.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DispatchQueuePool.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    DispatchQueuePool.this.e();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.f365214d = i3;
        this.f365215e = f365210j.nextInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(DispatchQueue dispatchQueue) {
        this.f365217g--;
        int intValue = this.f365212b.get(dispatchQueue).intValue() - 1;
        if (intValue == 0) {
            this.f365212b.remove(dispatchQueue);
            this.f365213c.remove(dispatchQueue);
            this.f365211a.add(dispatchQueue);
        } else {
            this.f365212b.put(dispatchQueue, Integer.valueOf(intValue));
        }
    }

    private void d(DispatchQueue dispatchQueue) {
        if (!this.f365218h) {
            DispatchQueue.t(this.f365219i, 30000L);
            this.f365218h = true;
        }
        this.f365217g++;
        this.f365213c.add(dispatchQueue);
        Integer num = this.f365212b.get(dispatchQueue);
        if (num == null) {
            num = 0;
        }
        this.f365212b.put(dispatchQueue, Integer.valueOf(num.intValue() + 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        h();
        i();
    }

    private DispatchQueue g() {
        if (!this.f365213c.isEmpty() && (this.f365217g / 2 <= this.f365213c.size() || (this.f365211a.isEmpty() && this.f365216f >= this.f365214d))) {
            return this.f365213c.remove(0);
        }
        if (this.f365211a.isEmpty()) {
            DispatchQueue dispatchQueue = new DispatchQueue("DispatchQueuePool" + this.f365215e + "_" + f365210j.nextInt());
            dispatchQueue.setPriority(10);
            this.f365216f = this.f365216f + 1;
            return dispatchQueue;
        }
        return this.f365211a.remove(0);
    }

    private void h() {
        if (this.f365211a.isEmpty()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int size = this.f365211a.size();
        int i3 = 0;
        while (i3 < size) {
            DispatchQueue dispatchQueue = this.f365211a.get(i3);
            if (dispatchQueue.o() < elapsedRealtime - 30000) {
                dispatchQueue.r();
                this.f365211a.remove(i3);
                this.f365216f--;
                i3--;
                size--;
            }
            i3++;
        }
    }

    private void i() {
        if (this.f365211a.isEmpty() && this.f365213c.isEmpty()) {
            this.f365218h = false;
        } else {
            DispatchQueue.t(this.f365219i, 30000L);
            this.f365218h = true;
        }
    }

    public synchronized void f(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            return;
        }
        DispatchQueue g16 = g();
        d(g16);
        g16.p(new Runnable(runnable, g16) { // from class: com.tencent.rlottie.decoder.DispatchQueuePool.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Runnable f365220d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ DispatchQueue f365221e;

            {
                this.f365220d = runnable;
                this.f365221e = g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DispatchQueuePool.this, runnable, g16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.f365220d.run();
                    DispatchQueue.s(new Runnable() { // from class: com.tencent.rlottie.decoder.DispatchQueuePool.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                DispatchQueuePool.this.c(anonymousClass2.f365221e);
                            }
                        }
                    });
                }
            }
        });
    }
}
