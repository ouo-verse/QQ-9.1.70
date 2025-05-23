package com.tencent.mobileqq.uftransfer.manager.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.api.m;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTTroopUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.aa;
import com.tencent.mobileqq.uftransfer.task.upload.ac;
import com.tencent.mobileqq.uftransfer.task.upload.v;
import com.tencent.mobileqq.uftransfer.task.upload.y;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AppRuntime f305246d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.taskqueue.a f305247e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
    class b implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
    /* renamed from: com.tencent.mobileqq.uftransfer.manager.controller.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8872c implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        C8872c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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
    class d implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
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

    public c(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, i3);
        } else {
            this.f305246d = appRuntime;
            this.f305247e = new com.tencent.mobileqq.uftransfer.taskqueue.a(i3);
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
        this.f305247e.p(bundle);
    }

    public void b(com.tencent.mobileqq.uftransfer.api.impl.a aVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) bundle);
        } else {
            this.f305247e.q(aVar.b(), bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(com.tencent.mobileqq.uftransfer.api.impl.a aVar, m mVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        k kVar2;
        long j3;
        UFTBaseTask U;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, mVar, kVar, bVar);
            return;
        }
        if (mVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload troop file, upload info is null");
            new UFTUploadCbWrapper(new a(), bVar).f(aVar, 1, new ac());
            return;
        }
        if (kVar == null) {
            kVar2 = new k(true);
        } else {
            kVar2 = kVar;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload troop file, upload info:" + mVar.toString() + " config:" + kVar2.toString());
        String i3 = com.tencent.mobileqq.uftransfer.depend.a.i(mVar.a());
        if (!TextUtils.isEmpty(mVar.a())) {
            File file = new File(mVar.a());
            if (file.exists()) {
                j3 = file.length();
                long j16 = j3;
                AppRuntime appRuntime = this.f305246d;
                aa aaVar = new aa(appRuntime, appRuntime.getCurrentAccountUin(), mVar.c());
                aaVar.A = i3;
                aaVar.B = j16;
                aaVar.D = mVar.o();
                aaVar.C = mVar.m();
                aaVar.f305690t = kVar2.a().d() ? 1 : 0;
                v vVar = new v(this.f305246d);
                vVar.e(aVar.b());
                vVar.f(Long.valueOf(mVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j16);
                if (!TextUtils.isEmpty(mVar.a())) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload troop file, file path = null");
                    aaVar.f305681k = 10;
                    aaVar.f305682l = 1001;
                    aaVar.c();
                    aaVar.e();
                    if (kVar2.a().d()) {
                        vVar.d(7);
                        vVar.c(false);
                    }
                    new UFTUploadCbWrapper(new b(), bVar).f(aVar, 201, new ac());
                    return;
                }
                com.tencent.mobileqq.uftransfer.task.taskinfo.d n3 = com.tencent.mobileqq.uftransfer.task.taskinfo.d.n(aVar.b(), aVar.c(), mVar, kVar2);
                if (n3 == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload troop file, create task info fail");
                    aaVar.f305681k = 9;
                    aaVar.f305682l = 905;
                    aaVar.c();
                    aaVar.e();
                    if (kVar2.a().d()) {
                        vVar.d(17);
                        vVar.c(false);
                    }
                    new UFTUploadCbWrapper(new C8872c(), bVar).f(aVar, 1, new ac());
                    return;
                }
                if (n3.b().a().d()) {
                    U = y.q0(this.f305246d, aVar, n3, this.f305247e, bVar);
                } else {
                    U = UFTTroopUploadTask.U(this.f305246d, aVar, n3, this.f305247e, bVar);
                }
                if (U == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTDiscUploadController", 1, "[" + aVar.b() + "] upload troop file, create task fail");
                    aaVar.f305681k = 9;
                    aaVar.f305682l = 904;
                    aaVar.c();
                    aaVar.e();
                    if (kVar2.a().d()) {
                        vVar.d(17);
                        vVar.c(false);
                    }
                    new UFTUploadCbWrapper(new d(), bVar).f(aVar, 9005, new ac());
                    return;
                }
                this.f305247e.b(U);
                return;
            }
        }
        j3 = 0;
        long j162 = j3;
        AppRuntime appRuntime2 = this.f305246d;
        aa aaVar2 = new aa(appRuntime2, appRuntime2.getCurrentAccountUin(), mVar.c());
        aaVar2.A = i3;
        aaVar2.B = j162;
        aaVar2.D = mVar.o();
        aaVar2.C = mVar.m();
        aaVar2.f305690t = kVar2.a().d() ? 1 : 0;
        v vVar2 = new v(this.f305246d);
        vVar2.e(aVar.b());
        vVar2.f(Long.valueOf(mVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j162);
        if (!TextUtils.isEmpty(mVar.a())) {
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305247e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305247e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 1);
        this.f305247e.p(bundle);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("REASON", 2);
        this.f305247e.p(bundle);
    }
}
