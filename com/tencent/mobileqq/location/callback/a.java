package com.tencent.mobileqq.location.callback;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements e {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d() {
        ChatFragment chatFragment;
        a61.c qh5;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((baseActivity instanceof BaseActivity) && (chatFragment = baseActivity.getChatFragment()) != null && (qh5 = chatFragment.qh()) != null && qh5.j() >= 2) {
            try {
                qh5.t(131072);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void a(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (i3 == 0) {
            com.tencent.mobileqq.location.a.c(appInterface, String.valueOf(j3));
        } else if (i3 == 1) {
            com.tencent.mobileqq.location.a.d(appInterface, String.valueOf(j3));
        }
        d();
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void b(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        } else {
            com.tencent.mobileqq.location.a.g((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null), i3, str, z16);
            d();
        }
    }

    @Override // com.tencent.mobileqq.location.callback.e
    public void c(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (i3 == 0) {
            com.tencent.mobileqq.location.a.c(appInterface, String.valueOf(j3));
        } else if (i3 == 1) {
            com.tencent.mobileqq.location.a.d(appInterface, String.valueOf(j3));
        }
    }
}
