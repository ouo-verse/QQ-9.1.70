package com.tencent.mobileqq.qqlive.runtime;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.Constants;
import mqq.app.IToolProcEventListener;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveQzoneAppInterface extends BaseToolAppInterface implements IToolProcEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private MobileQQServiceBase f272154d;

    private void release() {
        MobileQQServiceBase mobileQQServiceBase = this.f272154d;
        if (mobileQQServiceBase != null) {
            mobileQQServiceBase.destroy();
        }
    }

    @Override // mqq.app.AppRuntime
    public void exit(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            release();
            super.exit(z16);
        }
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MobileQQServiceBase) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f272154d;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "qq_live_qzone";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void logout(Constants.LogoutReason logoutReason, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, logoutReason, Boolean.valueOf(z16));
        } else {
            release();
            super.logout(logoutReason, z16);
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            this.f272154d = new c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            release();
            super.onDestroy();
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) intent)).booleanValue();
        }
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent)).booleanValue();
        }
        return false;
    }
}
