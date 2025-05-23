package com.tencent.mobileqq.dt.app;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.fe.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GuardManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IGuardInterface f203703a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuardManager.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                f.a().f("AppStatus_Value_Key_20241025", "0");
                GuardManager.this.b(false);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                f.a().f("AppStatus_Value_Key_20241025", "1");
                GuardManager.this.b(true);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    public GuardManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f203703a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z16) {
        ThreadManagerV2.excute(new Runnable(z16) { // from class: com.tencent.mobileqq.dt.app.GuardManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f203704d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.dt.app.GuardManager$2$a */
            /* loaded from: classes5.dex */
            class a extends com.tencent.mobileqq.dt.web.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // com.tencent.mobileqq.dt.web.a
                public void b(int i3, byte[] bArr) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
                    }
                }
            }

            {
                this.f203704d = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, GuardManager.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (this.f203704d) {
                    f.a().f("AppStatus_Value_Key_20241025", "1");
                } else {
                    f.a().f("AppStatus_Value_Key_20241025", "0");
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    O3BusinessHandler o3BusinessHandler = (O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName());
                    QLog.i("Fekit_GuardManager", 1, "fekit notify foreground:" + this.f203704d);
                    if (this.f203704d) {
                        str = "onAppForeground";
                    } else {
                        str = "onAppBackground";
                    }
                    o3BusinessHandler.D2(str, "", new a());
                    return;
                }
                QLog.e("Fekit_GuardManager", 1, "fekit notify foreground but runtime is null");
            }
        }, 128, null, true);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f203703a == null) {
            QLog.i("Fekit_GuardManager", 1, "registerGuardInterface");
            a aVar = new a();
            this.f203703a = aVar;
            com.tencent.mobileqq.app.guard.GuardManager guardManager = com.tencent.mobileqq.app.guard.GuardManager.sInstance;
            if (guardManager == null) {
                QLog.i("Fekit_GuardManager", 1, "GuardManager is null");
            } else {
                guardManager.registerCallBack(aVar);
                b(true);
            }
        }
    }
}
