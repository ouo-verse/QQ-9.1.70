package com.tencent.mobileqq.uftransfer.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uftransfer.depend.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTRunnableQueue {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static long f304979e;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Long, IUFTRunnable> f304980a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList<Long> f304981b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<IUFTRunnable> f304982c;

    /* renamed from: d, reason: collision with root package name */
    private final a f304983d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface IUFTRunnable extends Runnable {
        boolean fh(IUFTRunnable iUFTRunnable);

        long getId();

        boolean j9(a aVar);

        void setId(long j3);

        void stop();
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(long j3, boolean z16, int i3, IUFTRunnable iUFTRunnable);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f304979e = 1L;
        }
    }

    public UFTRunnableQueue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f304980a = new HashMap();
        this.f304981b = new LinkedList<>();
        this.f304982c = new LinkedList<>();
        this.f304983d = new a() { // from class: com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTRunnableQueue.this);
                }
            }

            @Override // com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.a
            public void a(long j3, boolean z16, int i3, IUFTRunnable iUFTRunnable) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), iUFTRunnable);
                } else {
                    com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(j3, z16, i3, iUFTRunnable) { // from class: com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ long f304985d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f304986e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f304987f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ IUFTRunnable f304988h;

                        {
                            this.f304985d = j3;
                            this.f304986e = z16;
                            this.f304987f = i3;
                            this.f304988h = iUFTRunnable;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), iUFTRunnable);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                UFTRunnableQueue.this.i(this.f304985d, this.f304986e, this.f304987f, this.f304988h);
                            }
                        }
                    });
                }
            }
        };
    }

    private boolean h(IUFTRunnable iUFTRunnable) {
        if (iUFTRunnable == null) {
            return false;
        }
        Iterator<IUFTRunnable> it = this.f304982c.iterator();
        while (it.hasNext()) {
            if (iUFTRunnable.fh(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f304982c.size() >= f()) {
            return;
        }
        while (this.f304981b.size() > 0) {
            IUFTRunnable remove = this.f304980a.remove(Long.valueOf(this.f304981b.remove(0).longValue()));
            if (remove != null) {
                if (h(remove)) {
                    c.e("[UFTTransfer] UFTRunnableQueue", 1, "[" + remove.getId() + "] has same runnable. add wd task");
                } else {
                    this.f304982c.add(remove);
                    if (!remove.j9(this.f304983d)) {
                        this.f304982c.remove(remove);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(long j3) {
        boolean z16;
        boolean z17;
        Iterator<IUFTRunnable> it = this.f304982c.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                IUFTRunnable next = it.next();
                if (j3 == next.getId()) {
                    next.stop();
                    it.remove();
                    z17 = true;
                    break;
                }
            } else {
                z17 = false;
                break;
            }
        }
        if (!z17) {
            this.f304981b.remove(Long.valueOf(j3));
            if (this.f304980a.remove(Long.valueOf(j3)) != null) {
                z16 = true;
            }
            z17 = z16;
        }
        if (z17) {
            c.c("[UFTTransfer] UFTRunnableQueue", 1, "[" + j3 + "] stop Runnable." + g());
        }
        return z17;
    }

    public long e(IUFTRunnable iUFTRunnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) iUFTRunnable)).longValue();
        }
        long j3 = f304979e;
        long j16 = j3 + 1;
        f304979e = j16;
        if (j3 == 0) {
            f304979e = 1 + j16;
            j3 = j16;
        }
        iUFTRunnable.setId(j3);
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(j3, iUFTRunnable) { // from class: com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f304990d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ IUFTRunnable f304991e;

            {
                this.f304990d = j3;
                this.f304991e = iUFTRunnable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTRunnableQueue.this, Long.valueOf(j3), iUFTRunnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                UFTRunnableQueue.this.f304980a.put(Long.valueOf(this.f304990d), this.f304991e);
                UFTRunnableQueue.this.f304981b.add(Long.valueOf(this.f304990d));
                c.c("[UFTTransfer] UFTRunnableQueue", 1, "[" + this.f304990d + "] add Runnable. " + UFTRunnableQueue.this.g());
                UFTRunnableQueue.this.j();
            }
        });
        return j3;
    }

    protected int f() {
        throw null;
    }

    protected String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return " ws:" + this.f304980a.size() + " qs:" + this.f304981b.size() + " rs:" + this.f304982c.size();
    }

    protected void i(long j3, boolean z16, int i3, IUFTRunnable iUFTRunnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), iUFTRunnable);
            return;
        }
        this.f304982c.remove(iUFTRunnable);
        c.c("[UFTTransfer] UFTRunnableQueue", 1, "[" + j3 + "] on runnable done. " + g());
        j();
    }

    public void k(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(j3) { // from class: com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f304992d;

                {
                    this.f304992d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTRunnableQueue.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        UFTRunnableQueue.this.l(this.f304992d);
                        UFTRunnableQueue.this.j();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }
}
