package com.tencent.mobileqq.uftransfer.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.IUFTTransferService;
import com.tencent.mobileqq.uftransfer.api.f;
import com.tencent.mobileqq.uftransfer.api.g;
import com.tencent.mobileqq.uftransfer.api.k;
import com.tencent.mobileqq.uftransfer.api.m;
import com.tencent.mobileqq.uftransfer.guild.e;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTTransferServiceImpl implements IUFTTransferService, INetInfoHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "[UFTTransfer] UFTTransferService";
    private AppRuntime mApp;
    private com.tencent.mobileqq.uftransfer.manager.controller.a mC2CUploadController;
    private com.tencent.mobileqq.uftransfer.manager.controller.a mC2CUploadController4MutilFwd;
    private com.tencent.mobileqq.uftransfer.manager.controller.b mDiscUploadController;
    private com.tencent.mobileqq.uftransfer.manager.controller.b mDiscUploadController4MutilFwd;
    private com.tencent.mobileqq.uftransfer.guild.c mGuildUploadController;
    private com.tencent.mobileqq.uftransfer.manager.controller.c mTroopUploadController;
    private com.tencent.mobileqq.uftransfer.manager.controller.c mTroopUploadController4MutilFwd;

    public UFTTransferServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.c(TAG, 1, "on service create...");
        this.mApp = appRuntime;
        this.mC2CUploadController = new com.tencent.mobileqq.uftransfer.manager.controller.a(appRuntime, 2);
        this.mDiscUploadController = new com.tencent.mobileqq.uftransfer.manager.controller.b(this.mApp, 2);
        this.mTroopUploadController = new com.tencent.mobileqq.uftransfer.manager.controller.c(this.mApp, 8);
        this.mGuildUploadController = new com.tencent.mobileqq.uftransfer.guild.c(this.mApp, 2);
        this.mC2CUploadController4MutilFwd = new com.tencent.mobileqq.uftransfer.manager.controller.a(this.mApp, 100);
        this.mDiscUploadController4MutilFwd = new com.tencent.mobileqq.uftransfer.manager.controller.b(this.mApp, 100);
        this.mTroopUploadController4MutilFwd = new com.tencent.mobileqq.uftransfer.manager.controller.c(this.mApp, 100);
        AppNetConnInfo.registerConnectionChangeReceiver(this.mApp.getApplication(), this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on service destroy...");
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (UFTTransferServiceImpl.this.mC2CUploadController != null) {
                    UFTTransferServiceImpl.this.mC2CUploadController.a();
                }
                if (UFTTransferServiceImpl.this.mDiscUploadController != null) {
                    UFTTransferServiceImpl.this.mDiscUploadController.a();
                }
                if (UFTTransferServiceImpl.this.mTroopUploadController != null) {
                    UFTTransferServiceImpl.this.mTroopUploadController.a();
                }
                if (UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd != null) {
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.a();
                }
                if (UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd != null) {
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.a();
                }
                if (UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd != null) {
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.a();
                }
            }
        });
        this.mApp = null;
        AppNetConnInfo.unregisterNetInfoHandler(this);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: mobile->none");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.11
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetMobile2None();
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetMobile2None();
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetMobile2None();
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetMobile2None();
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetMobile2None();
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetMobile2None();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: mobile->wifi");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f304884d;

                {
                    this.f304884d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetMobile2Wifi(this.f304884d);
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetMobile2Wifi(this.f304884d);
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetMobile2Wifi(this.f304884d);
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetMobile2Wifi(this.f304884d);
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetMobile2Wifi(this.f304884d);
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetMobile2Wifi(this.f304884d);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: none->mobile");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f304903d;

                {
                    this.f304903d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetNone2Mobile(this.f304903d);
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetNone2Mobile(this.f304903d);
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetNone2Mobile(this.f304903d);
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetNone2Mobile(this.f304903d);
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetNone2Mobile(this.f304903d);
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetNone2Mobile(this.f304903d);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: none->wifi");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f304905d;

                {
                    this.f304905d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetNone2Wifi(this.f304905d);
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetNone2Wifi(this.f304905d);
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetNone2Wifi(this.f304905d);
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetNone2Wifi(this.f304905d);
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetNone2Wifi(this.f304905d);
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetNone2Wifi(this.f304905d);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: wifi->mobile");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(str) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f304904d;

                {
                    this.f304904d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetWifi2Mobile(this.f304904d);
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetWifi2Mobile(this.f304904d);
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetWifi2Mobile(this.f304904d);
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetWifi2Mobile(this.f304904d);
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetWifi2Mobile(this.f304904d);
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetWifi2Mobile(this.f304904d);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.e(TAG, 1, "on net work change: wifi->none");
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.12
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTransferServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UFTTransferServiceImpl.this.mC2CUploadController.onNetWifi2None();
                    UFTTransferServiceImpl.this.mDiscUploadController.onNetWifi2None();
                    UFTTransferServiceImpl.this.mTroopUploadController.onNetWifi2None();
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.onNetWifi2None();
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.onNetWifi2None();
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.onNetWifi2None();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTTransferService
    public void stop(com.tencent.mobileqq.uftransfer.api.a aVar, Bundle bundle) {
        a aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) bundle);
            return;
        }
        if (aVar == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b(TAG, 1, "stop fail. trans key is null");
            return;
        }
        if (aVar instanceof a) {
            aVar2 = (a) aVar;
        } else {
            aVar2 = null;
        }
        if (aVar2 == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b(TAG, 1, "stop fail. trans key err");
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(aVar2, bundle) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f304901d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f304902e;

                {
                    this.f304901d = aVar2;
                    this.f304902e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UFTTransferServiceImpl.this, aVar2, bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int c16 = this.f304901d.c();
                    if (c16 != 1) {
                        if (c16 != 2) {
                            if (c16 != 3) {
                                if (c16 == 10) {
                                    UFTTransferServiceImpl.this.mGuildUploadController.a(this.f304901d, this.f304902e);
                                }
                                com.tencent.mobileqq.uftransfer.depend.c.b(UFTTransferServiceImpl.TAG, 1, "stop fail. trans type error:" + this.f304901d.c());
                                return;
                            }
                            if (this.f304901d.d()) {
                                UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.b(this.f304901d, this.f304902e);
                                return;
                            } else {
                                UFTTransferServiceImpl.this.mDiscUploadController.b(this.f304901d, this.f304902e);
                                return;
                            }
                        }
                        if (this.f304901d.d()) {
                            UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.b(this.f304901d, this.f304902e);
                            return;
                        } else {
                            UFTTransferServiceImpl.this.mTroopUploadController.b(this.f304901d, this.f304902e);
                            return;
                        }
                    }
                    if (this.f304901d.d()) {
                        UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.b(this.f304901d, this.f304902e);
                    } else {
                        UFTTransferServiceImpl.this.mC2CUploadController.b(this.f304901d, this.f304902e);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTTransferService
    public com.tencent.mobileqq.uftransfer.api.a uploadC2CFile(f fVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.uftransfer.api.a) iPatchRedirector.redirect((short) 4, this, fVar, kVar, bVar);
        }
        a aVar = new a(1, fVar.e());
        aVar.f(fVar.d());
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(fVar, aVar, kVar, bVar) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ f f304885d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f304886e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ k f304887f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.b f304888h;

            {
                this.f304885d = fVar;
                this.f304886e = aVar;
                this.f304887f = kVar;
                this.f304888h = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTTransferServiceImpl.this, fVar, aVar, kVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (this.f304885d.e()) {
                    UFTTransferServiceImpl.this.mC2CUploadController4MutilFwd.c(this.f304886e, this.f304885d, this.f304887f, this.f304888h);
                } else {
                    UFTTransferServiceImpl.this.mC2CUploadController.c(this.f304886e, this.f304885d, this.f304887f, this.f304888h);
                }
            }
        });
        return aVar;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTTransferService
    public com.tencent.mobileqq.uftransfer.api.a uploadDiscFile(g gVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.uftransfer.api.a) iPatchRedirector.redirect((short) 7, this, gVar, kVar, bVar);
        }
        a aVar = new a(3, gVar.e());
        aVar.f(gVar.d());
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(gVar, aVar, kVar, bVar) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ g f304897d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f304898e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ k f304899f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.b f304900h;

            {
                this.f304897d = gVar;
                this.f304898e = aVar;
                this.f304899f = kVar;
                this.f304900h = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTTransferServiceImpl.this, gVar, aVar, kVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (this.f304897d.e()) {
                    UFTTransferServiceImpl.this.mDiscUploadController4MutilFwd.c(this.f304898e, this.f304897d, this.f304899f, this.f304900h);
                } else {
                    UFTTransferServiceImpl.this.mDiscUploadController.c(this.f304898e, this.f304897d, this.f304899f, this.f304900h);
                }
            }
        });
        return aVar;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTTransferService
    public com.tencent.mobileqq.uftransfer.api.a uploadGuildFile(e eVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.uftransfer.api.a) iPatchRedirector.redirect((short) 5, this, eVar, kVar, bVar);
        }
        a aVar = new a(10, eVar.e());
        aVar.f(eVar.d());
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(aVar, eVar, kVar, bVar) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f304889d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ e f304890e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ k f304891f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.b f304892h;

            {
                this.f304889d = aVar;
                this.f304890e = eVar;
                this.f304891f = kVar;
                this.f304892h = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTTransferServiceImpl.this, aVar, eVar, kVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    UFTTransferServiceImpl.this.mGuildUploadController.b(this.f304889d, this.f304890e, this.f304891f, this.f304892h);
                }
            }
        });
        return aVar;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTTransferService
    public com.tencent.mobileqq.uftransfer.api.a uploadTroopFile(m mVar, k kVar, com.tencent.mobileqq.uftransfer.api.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.uftransfer.api.a) iPatchRedirector.redirect((short) 6, this, mVar, kVar, bVar);
        }
        a aVar = new a(2, mVar.e());
        aVar.f(mVar.d());
        com.tencent.mobileqq.uftransfer.a.a().b(new Runnable(mVar, aVar, kVar, bVar) { // from class: com.tencent.mobileqq.uftransfer.api.impl.UFTTransferServiceImpl.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ m f304893d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f304894e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ k f304895f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.uftransfer.api.b f304896h;

            {
                this.f304893d = mVar;
                this.f304894e = aVar;
                this.f304895f = kVar;
                this.f304896h = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, UFTTransferServiceImpl.this, mVar, aVar, kVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else if (this.f304893d.e()) {
                    UFTTransferServiceImpl.this.mTroopUploadController4MutilFwd.c(this.f304894e, this.f304893d, this.f304895f, this.f304896h);
                } else {
                    UFTTransferServiceImpl.this.mTroopUploadController.c(this.f304894e, this.f304893d, this.f304895f, this.f304896h);
                }
            }
        });
        return aVar;
    }
}
