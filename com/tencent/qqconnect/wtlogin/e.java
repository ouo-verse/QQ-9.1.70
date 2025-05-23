package com.tencent.qqconnect.wtlogin;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ILoginService;
import com.tencent.qqnt.kernel.nativeinterface.ILoginTicketCallback;
import com.tencent.qqnt.kernel.nativeinterface.LoginTicketInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.inject.ILoginMainTicketCallback;
import mqq.inject.ISigInject;
import mqq.inject.LoginTicketResult;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements ISigInject {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f344970a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ILoginTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ILoginMainTicketCallback f344971a;

        a(ILoginMainTicketCallback iLoginMainTicketCallback) {
            this.f344971a = iLoginMainTicketCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) iLoginMainTicketCallback);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.ILoginTicketCallback
        public void onResult(int i3, String str, LoginTicketInfo loginTicketInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, loginTicketInfo);
                return;
            }
            LoginTicketResult loginTicketResult = new LoginTicketResult();
            if (i3 == 0) {
                loginTicketResult.f417209a2 = loginTicketInfo.f359193a2;
                loginTicketResult.f417210d2 = loginTicketInfo.f359194d2;
                loginTicketResult.d2Key = loginTicketInfo.d2Key;
            } else {
                QLog.i("SkeyInjectImpl", 1, "onResult " + i3 + ", errorMsg::" + str);
            }
            this.f344971a.onResult(i3, str, loginTicketResult);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f344970a = new AtomicBoolean(false);
        }
    }

    @Override // mqq.inject.ISigInject
    public boolean banSkeyAccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100672", false);
        QLog.d("SkeyInjectImpl", 1, "banSkeyAccess ban = " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // mqq.inject.ISigInject
    public String getFakeSkey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && str.length() > 5) {
            String sb5 = new StringBuilder(str).replace(0, 5, "MMMMM").toString();
            QLog.d("SkeyInjectImpl", 1, "getFakeSkey fakeSkey = " + sb5);
            return sb5;
        }
        QLog.d("SkeyInjectImpl", 1, "getFakeSkey skey is invalid");
        return null;
    }

    @Override // mqq.inject.ISigInject
    public void getLoginSig(long j3, long j16, ILoginMainTicketCallback iLoginMainTicketCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Long.valueOf(j16), iLoginMainTicketCallback);
        } else {
            QLog.d("SkeyInjectImpl", 1, "getLoginSig");
            ((ILoginService) QRoute.api(ILoginService.class)).getLoginTicketByUin(j3, j16, new a(iLoginMainTicketCallback));
        }
    }
}
