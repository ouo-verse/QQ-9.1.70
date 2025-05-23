package com.tencent.mobileqq.uftransfer.manager.controller;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.f;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTC2CUploadTask;
import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;
import com.tencent.mobileqq.uftransfer.task.upload.ac;
import com.tencent.mobileqq.uftransfer.task.upload.e;
import com.tencent.mobileqq.uftransfer.task.upload.g;
import com.tencent.mobileqq.uftransfer.task.upload.j;
import com.tencent.mobileqq.uftransfer.task.upload.o;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements INetInfoHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AppRuntime f305235d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.taskqueue.a f305236e;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.manager.controller.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8870a implements UFTUploadCbWrapper.a {
        static IPatchRedirector $redirector_;

        C8870a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
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

    public a(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, i3);
        } else {
            this.f305235d = appRuntime;
            this.f305236e = new com.tencent.mobileqq.uftransfer.taskqueue.a(i3);
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
        this.f305236e.p(bundle);
    }

    public void b(com.tencent.mobileqq.uftransfer.api.impl.a aVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) bundle);
        } else {
            this.f305236e.q(aVar.b(), bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(com.tencent.mobileqq.uftransfer.api.impl.a aVar, f fVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        k kVar2;
        long j3;
        UFTBaseTask U;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aVar, fVar, kVar, bVar);
            return;
        }
        if (fVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadController", 1, "[" + aVar.b() + "] upload c2c file, upload info is null");
            new UFTUploadCbWrapper(new C8870a(), bVar).f(aVar, 9005, new ac());
            return;
        }
        if (kVar == null) {
            kVar2 = new k(true);
        } else {
            kVar2 = kVar;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTC2CUploadController", 1, "[" + aVar.b() + "] uploadC2CFile, uploadinfo:" + fVar.toString() + " config:" + kVar2.toString());
        String i3 = com.tencent.mobileqq.uftransfer.depend.a.i(fVar.a());
        if (!TextUtils.isEmpty(fVar.a())) {
            File file = new File(fVar.a());
            if (file.exists()) {
                j3 = file.length();
                long j16 = j3;
                o oVar = new o(this.f305235d, aVar.b(), fVar.c(), j16, kVar2.a().d() ? 1 : 0);
                oVar.f305583i = 1L;
                g gVar = new g(this.f305235d);
                gVar.i(aVar.b());
                gVar.k(Long.valueOf(fVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j16);
                if (!TextUtils.isEmpty(fVar.a())) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadController", 1, "[" + aVar.b() + "] upload c2c file, file path is null");
                    oVar.f305593s = 9042L;
                    oVar.f305594t = "upload file but filepath = null";
                    oVar.f305595u = "upload file but filepath = null";
                    oVar.a();
                    oVar.c();
                    if (kVar2.a().d()) {
                        gVar.h(9042);
                        gVar.b(false);
                    }
                    new UFTUploadCbWrapper(new b(), bVar).f(aVar, 9042, new ac());
                    return;
                }
                com.tencent.mobileqq.uftransfer.task.taskinfo.b n3 = com.tencent.mobileqq.uftransfer.task.taskinfo.b.n(aVar.b(), aVar.c(), fVar, kVar2);
                if (n3 == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadController", 1, "[" + aVar.b() + "] upload c2c file, create task info fail");
                    oVar.f305593s = 9005L;
                    oVar.f305594t = "create task info fail";
                    oVar.f305595u = "create task info fail";
                    oVar.a();
                    oVar.c();
                    if (kVar2.a().d()) {
                        gVar.h(17);
                        gVar.b(false);
                    }
                    new UFTUploadCbWrapper(new c(), bVar).f(aVar, 9005, new ac());
                    return;
                }
                if (n3.b().a().d()) {
                    if (j16 >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                        U = com.tencent.mobileqq.uftransfer.task.upload.f.C0(this.f305235d, aVar, n3, this.f305236e, bVar);
                    } else {
                        U = j.s0(this.f305235d, aVar, n3, this.f305236e, bVar);
                    }
                } else if (j16 >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    U = e.U(this.f305235d, aVar, n3, this.f305236e, bVar);
                } else {
                    U = UFTC2CUploadTask.U(this.f305235d, aVar, n3, this.f305236e, bVar);
                }
                if (U == null) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTC2CUploadController", 1, "[" + aVar.b() + "] upload c2c file, create task fail");
                    oVar.f305593s = 9005L;
                    oVar.f305594t = "create task fail";
                    oVar.f305595u = "create task fail";
                    oVar.a();
                    oVar.c();
                    if (kVar2.a().d()) {
                        gVar.h(17);
                        gVar.b(false);
                    }
                    new UFTUploadCbWrapper(new d(), bVar).f(aVar, 9005, new ac());
                    return;
                }
                this.f305236e.b(U);
                return;
            }
        }
        j3 = 0;
        long j162 = j3;
        o oVar2 = new o(this.f305235d, aVar.b(), fVar.c(), j162, kVar2.a().d() ? 1 : 0);
        oVar2.f305583i = 1L;
        g gVar2 = new g(this.f305235d);
        gVar2.i(aVar.b());
        gVar2.k(Long.valueOf(fVar.c()).longValue(), 0L, i3, com.tencent.mobileqq.uftransfer.depend.a.l(i3), j162);
        if (!TextUtils.isEmpty(fVar.a())) {
        }
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
        this.f305236e.p(bundle);
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
        this.f305236e.p(bundle);
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
        this.f305236e.p(bundle);
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
        this.f305236e.p(bundle);
    }
}
