package com.tencent.mobileqq.app.guardcallback;

import android.text.TextUtils;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d implements IGuardInterface {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        String str = MobileQQ.PACKAGE_NAME + ":MSF";
        if (guardManager.mFgProcess == null) {
            String c16 = com.tencent.mobileqq.rfix.a.c();
            if (!TextUtils.isEmpty(c16) && !c16.equals(com.tencent.mobileqq.rfix.a.d(str))) {
                QLog.d("PatchLogTag", 1, "GuardManager exit MSF Process to install patch, target patchVersion=" + c16);
                MsfServiceSdk.get().onKillProcess();
            }
        }
    }

    private void b() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        String c16 = com.tencent.mobileqq.rfix.a.c();
        if (!com.tencent.mobileqq.rfix.a.h() && !TextUtils.isEmpty(c16) && !c16.equals(com.tencent.mobileqq.rfix.a.d(MobileQQ.PACKAGE_NAME)) && guardManager.mFgProcess == null) {
            QLog.d("PatchLogTag", 1, "GuardManager exit Main Process to install patch, target patchVersion=" + c16);
            System.exit(-1);
        }
    }

    private void c() {
        a();
        b();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else if (j3 == 50 || j3 == 51) {
            c();
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
