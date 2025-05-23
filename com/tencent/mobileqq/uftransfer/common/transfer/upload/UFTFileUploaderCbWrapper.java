package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class UFTFileUploaderCbWrapper implements com.tencent.mobileqq.uftransfer.common.transfer.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected com.tencent.mobileqq.uftransfer.common.transfer.b f305034a;

    /* renamed from: b, reason: collision with root package name */
    protected long f305035b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f305036c;

    public UFTFileUploaderCbWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305035b = 0L;
            this.f305036c = false;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305048d;

                {
                    this.f305048d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTFileUploaderCbWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTFileUploaderCbWrapper.this.u() && (bVar = UFTFileUploaderCbWrapper.this.f305034a) != null) {
                        bVar.d(this.f305048d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public void f(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, obj);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(obj) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Object f305050d;

                {
                    this.f305050d = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTFileUploaderCbWrapper.this, obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTFileUploaderCbWrapper.this.u() && (bVar = UFTFileUploaderCbWrapper.this.f305034a) != null) {
                        bVar.f(this.f305050d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void j(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), obj);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(z16, obj) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f305037d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Object f305038e;

                {
                    this.f305037d = z16;
                    this.f305038e = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTFileUploaderCbWrapper.this, Boolean.valueOf(z16), obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTFileUploaderCbWrapper uFTFileUploaderCbWrapper = UFTFileUploaderCbWrapper.this;
                    if (uFTFileUploaderCbWrapper.f305036c) {
                        return;
                    }
                    uFTFileUploaderCbWrapper.w(true);
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar = UFTFileUploaderCbWrapper.this.f305034a;
                    if (bVar != null) {
                        bVar.j(this.f305037d, this.f305038e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void k(boolean z16, int i3, long j3, String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, obj);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(z16, i3, j3, str, str2, obj) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f305042d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f305043e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f305044f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f305045h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f305046i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ Object f305047m;

                {
                    this.f305042d = z16;
                    this.f305043e = i3;
                    this.f305044f = j3;
                    this.f305045h = str;
                    this.f305046i = str2;
                    this.f305047m = obj;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTFileUploaderCbWrapper.this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str, str2, obj);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f305042d) {
                        UFTFileUploaderCbWrapper uFTFileUploaderCbWrapper = UFTFileUploaderCbWrapper.this;
                        if (uFTFileUploaderCbWrapper.f305036c) {
                            return;
                        } else {
                            uFTFileUploaderCbWrapper.w(true);
                        }
                    } else if (UFTFileUploaderCbWrapper.this.u()) {
                        return;
                    }
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar = UFTFileUploaderCbWrapper.this.f305034a;
                    if (bVar != null) {
                        bVar.k(this.f305042d, this.f305043e, this.f305044f, this.f305045h, this.f305046i, this.f305047m);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void l(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f305049d;

                {
                    this.f305049d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTFileUploaderCbWrapper.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTFileUploaderCbWrapper.this.u() && (bVar = UFTFileUploaderCbWrapper.this.f305034a) != null) {
                        bVar.l(this.f305049d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void m(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j18 = this.f305035b;
        if (j18 == 0 || currentTimeMillis - j18 >= 1000) {
            this.f305035b = currentTimeMillis;
            com.tencent.mobileqq.uftransfer.common.transfer.b bVar = this.f305034a;
            if (bVar != null) {
                bVar.m(j3, j16, j17);
            }
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTFileUploaderCbWrapper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTFileUploaderCbWrapper.this.u() && (bVar = UFTFileUploaderCbWrapper.this.f305034a) != null) {
                        bVar.n();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.common.transfer.b
    public final void s(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), str, str2);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(j3, str, str2) { // from class: com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFileUploaderCbWrapper.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f305039d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f305040e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f305041f;

                {
                    this.f305039d = j3;
                    this.f305040e = str;
                    this.f305041f = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTFileUploaderCbWrapper.this, Long.valueOf(j3), str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.common.transfer.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTFileUploaderCbWrapper.this.u() && (bVar = UFTFileUploaderCbWrapper.this.f305034a) != null) {
                        bVar.s(this.f305039d, this.f305040e, this.f305041f);
                    }
                }
            });
        }
    }

    public abstract boolean u();

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(com.tencent.mobileqq.uftransfer.common.transfer.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.f305034a = bVar;
        }
    }

    public void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f305036c = z16;
        }
    }
}
