package com.tencent.mobileqq.uftransfer.task;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class UFTBaseOp {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final AppRuntime f305342a;

    /* renamed from: b, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.task.taskinfo.a f305343b;

    /* renamed from: c, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.api.impl.a f305344c;

    /* renamed from: d, reason: collision with root package name */
    private b f305345d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f305346e;

    /* renamed from: f, reason: collision with root package name */
    protected a f305347f;

    /* renamed from: g, reason: collision with root package name */
    private String f305348g;

    /* renamed from: h, reason: collision with root package name */
    protected long f305349h;

    /* renamed from: i, reason: collision with root package name */
    protected long f305350i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f305352a;

        /* renamed from: b, reason: collision with root package name */
        private String f305353b;

        /* renamed from: c, reason: collision with root package name */
        private String f305354c;

        /* renamed from: d, reason: collision with root package name */
        private long f305355d;

        /* renamed from: e, reason: collision with root package name */
        private long f305356e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f305352a;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f305353b;
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.f305354c;
        }

        public void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.f305352a = i3;
            }
        }

        public void g(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.f305353b = str;
            }
        }

        public void h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.f305354c = str;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void a(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        public abstract void b(a aVar);
    }

    public UFTBaseOp(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar, com.tencent.mobileqq.uftransfer.api.impl.a aVar2, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, aVar2, bVar);
            return;
        }
        this.f305346e = false;
        this.f305349h = 0L;
        this.f305350i = 0L;
        this.f305342a = appRuntime;
        this.f305343b = aVar;
        this.f305344c = aVar2;
        this.f305345d = bVar;
    }

    protected abstract int i();

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f305348g;
    }

    public long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.f305344c.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(long j3, long j16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
        } else if (!this.f305346e && (bVar = this.f305345d) != null) {
            bVar.a(j3, j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            return;
        }
        if (this.f305346e) {
            return;
        }
        this.f305350i = System.currentTimeMillis();
        this.f305348g = aVar.d();
        aVar.f305355d = this.f305349h;
        aVar.f305356e = this.f305350i;
        this.f305347f = aVar;
        if (this.f305345d == null) {
            return;
        }
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(aVar) { // from class: com.tencent.mobileqq.uftransfer.task.UFTBaseOp.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f305351d;

            {
                this.f305351d = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTBaseOp.this, (Object) aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                UFTBaseOp uFTBaseOp = UFTBaseOp.this;
                if (uFTBaseOp.f305346e) {
                    return;
                }
                uFTBaseOp.f305346e = true;
                if (uFTBaseOp.f305345d != null) {
                    UFTBaseOp.this.f305345d.b(this.f305351d);
                }
            }
        });
    }

    public void t(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.f305348g = str;
            v();
        }
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        this.f305349h = System.currentTimeMillis();
        this.f305350i = 0L;
        this.f305346e = false;
        return i();
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f305350i = System.currentTimeMillis();
        this.f305346e = true;
        this.f305345d = null;
    }
}
