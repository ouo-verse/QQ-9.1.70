package com.tencent.mobileqq.uftransfer.manager.controller;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.g;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.task.upload.UFTDiscUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.ac;
import com.tencent.mobileqq.uftransfer.task.upload.s;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AppRuntime f305241d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.taskqueue.a f305242e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.manager.controller.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8871b implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        C8871b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper.a
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public b(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, i3);
        } else {
            this.f305241d = appRuntime;
            this.f305242e = new com.tencent.mobileqq.uftransfer.taskqueue.a(i3);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 3);
        this.f305242e.p(bundle);
    }

    public void b(com.tencent.mobileqq.uftransfer.api.impl.a aVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) bundle);
        } else {
            this.f305242e.q(aVar.b(), bundle);
        }
    }

    public void c(com.tencent.mobileqq.uftransfer.api.impl.a aVar, g gVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, gVar, kVar, bVar);
            return;
        }
        if (gVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload disc file, upload info is null");
            new UFTUploadCbWrapper(new a(), bVar).f(aVar, 9005, new ac());
            return;
        }
        if (kVar == null) {
            kVar = new k(true);
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload disc file, uploadinfo:" + gVar.toString() + " config:" + kVar.toString());
        AppRuntime appRuntime = this.f305241d;
        s sVar = new s(appRuntime, appRuntime.getCurrentUin());
        sVar.f305614m = "";
        sVar.f305615n = gVar.c();
        sVar.f305616o = 3000;
        sVar.f305617p = "";
        sVar.f305620s = com.tencent.mobileqq.uftransfer.utility.a.b(gVar.a());
        sVar.f305621t = 0;
        sVar.f305608g = aVar.b();
        sVar.f305610i = 0L;
        sVar.f305611j = 0L;
        sVar.f305612k = 0L;
        sVar.f305618q = 0L;
        sVar.f305622u = "";
        com.tencent.mobileqq.uftransfer.task.taskinfo.c n3 = com.tencent.mobileqq.uftransfer.task.taskinfo.c.n(aVar.b(), aVar.c(), gVar, kVar);
        if (n3 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload disc file, create task info fail");
            sVar.f305606e = 9005L;
            sVar.f305607f = "create task info fail";
            sVar.b();
            new UFTUploadCbWrapper(new C8871b(), bVar).f(aVar, 9005, new ac());
            return;
        }
        UFTDiscUploadTask Q = UFTDiscUploadTask.Q(this.f305241d, aVar, n3, this.f305242e, bVar);
        if (Q == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload disc file, create task fail");
            sVar.f305606e = 9005L;
            sVar.f305607f = "create upload task fail";
            sVar.b();
            new UFTUploadCbWrapper(new c(), bVar).f(aVar, 9005, new ac());
            return;
        }
        this.f305242e.b(Q);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305242e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305242e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305242e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305242e.p(bundle);
    }
}
