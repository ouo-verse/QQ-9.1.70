package com.tencent.mobileqq.uftransfer.task.upload;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTUploadCbWrapper implements com.tencent.mobileqq.uftransfer.api.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final com.tencent.mobileqq.uftransfer.api.b f305453a;

    /* renamed from: b, reason: collision with root package name */
    final a f305454b;

    /* renamed from: c, reason: collision with root package name */
    final Handler f305455c;

    /* renamed from: d, reason: collision with root package name */
    long f305456d;

    /* renamed from: e, reason: collision with root package name */
    boolean f305457e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        boolean a();
    }

    public UFTUploadCbWrapper(a aVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) bVar);
            return;
        }
        this.f305456d = 0L;
        this.f305457e = false;
        this.f305454b = aVar;
        this.f305453a = bVar;
        this.f305455c = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        a aVar = this.f305454b;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public int a(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle, com.tencent.mobileqq.uftransfer.api.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, this, aVar, bundle, dVar)).intValue();
        }
        this.f305455c.post(new Runnable(aVar, bundle, dVar) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305473d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f305474e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.d f305475f;

            {
                this.f305473d = aVar;
                this.f305474e = bundle;
                this.f305475f = dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, bundle, dVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                com.tencent.mobileqq.uftransfer.api.d dVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.mobileqq.uftransfer.api.b bVar = UFTUploadCbWrapper.this.f305453a;
                if (bVar != null) {
                    i3 = bVar.a(this.f305473d, this.f305474e, this.f305475f);
                } else {
                    i3 = -1;
                }
                if (i3 != 0 && (dVar2 = this.f305475f) != null) {
                    dVar2.a(false, i3, new Bundle());
                }
            }
        });
        return 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void b(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) hVar);
        } else {
            if (j()) {
                return;
            }
            this.f305455c.post(new Runnable(aVar, hVar) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305469d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.h f305470e;

                {
                    this.f305469d = aVar;
                    this.f305470e = hVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, hVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.api.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTUploadCbWrapper.this.j() && (bVar = UFTUploadCbWrapper.this.f305453a) != null) {
                        bVar.b(this.f305469d, this.f305470e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void c(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, aVar, Integer.valueOf(i3), bundle);
        } else {
            if (j()) {
                return;
            }
            this.f305455c.post(new Runnable(aVar, i3, bundle) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305466d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f305467e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Bundle f305468f;

                {
                    this.f305466d = aVar;
                    this.f305467e = i3;
                    this.f305468f = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, Integer.valueOf(i3), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.api.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTUploadCbWrapper.this.j() && (bVar = UFTUploadCbWrapper.this.f305453a) != null) {
                        bVar.c(this.f305466d, this.f305467e, this.f305468f);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void d(com.tencent.mobileqq.uftransfer.api.a aVar, com.tencent.mobileqq.uftransfer.api.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar, (Object) iVar);
        } else {
            if (j()) {
                return;
            }
            this.f305455c.post(new Runnable(aVar, iVar) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305471d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.i f305472e;

                {
                    this.f305471d = aVar;
                    this.f305472e = iVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, iVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.api.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTUploadCbWrapper.this.j() && (bVar = UFTUploadCbWrapper.this.f305453a) != null) {
                        bVar.d(this.f305471d, this.f305472e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void e(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16) {
        com.tencent.mobileqq.uftransfer.api.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, aVar, Long.valueOf(j3), Long.valueOf(j16));
        } else if (!j() && (bVar = this.f305453a) != null) {
            bVar.e(aVar, j3, j16);
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void f(com.tencent.mobileqq.uftransfer.api.a aVar, int i3, com.tencent.mobileqq.uftransfer.api.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, aVar, Integer.valueOf(i3), cVar);
        } else {
            this.f305455c.post(new Runnable(aVar, i3, cVar) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305463d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f305464e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.c f305465f;

                {
                    this.f305463d = aVar;
                    this.f305464e = i3;
                    this.f305465f = cVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, Integer.valueOf(i3), cVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTUploadCbWrapper uFTUploadCbWrapper = UFTUploadCbWrapper.this;
                    if (uFTUploadCbWrapper.f305457e) {
                        return;
                    }
                    uFTUploadCbWrapper.k(true);
                    com.tencent.mobileqq.uftransfer.api.b bVar = UFTUploadCbWrapper.this.f305453a;
                    if (bVar != null) {
                        bVar.f(this.f305463d, this.f305464e, this.f305465f);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void g(com.tencent.mobileqq.uftransfer.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            if (j()) {
                return;
            }
            this.f305455c.post(new Runnable(aVar) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305458d;

                {
                    this.f305458d = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTUploadCbWrapper.this, (Object) aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.api.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTUploadCbWrapper.this.j() && (bVar = UFTUploadCbWrapper.this.f305453a) != null) {
                        bVar.g(this.f305458d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.b
    public void h(com.tencent.mobileqq.uftransfer.api.a aVar, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, aVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (j()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j18 = this.f305456d;
        if (j18 == 0 || currentTimeMillis - j18 >= 1000) {
            this.f305456d = currentTimeMillis;
            this.f305455c.post(new Runnable(aVar, j3, j16, j17) { // from class: com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.uftransfer.api.a f305459d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f305460e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ long f305461f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ long f305462h;

                {
                    this.f305459d = aVar;
                    this.f305460e = j3;
                    this.f305461f = j16;
                    this.f305462h = j17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTUploadCbWrapper.this, aVar, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.mobileqq.uftransfer.api.b bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (!UFTUploadCbWrapper.this.j() && (bVar = UFTUploadCbWrapper.this.f305453a) != null) {
                        bVar.h(this.f305459d, this.f305460e, this.f305461f, this.f305462h);
                    }
                }
            });
        }
    }

    public void k(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f305457e = z16;
        }
    }
}
