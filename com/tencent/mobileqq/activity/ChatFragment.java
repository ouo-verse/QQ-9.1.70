package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ChatFragment extends BaseFragment implements com.tencent.mobileqq.pad.g {
    static IPatchRedirector $redirector_;
    public static volatile boolean F;
    private static boolean G;
    public a61.c C;
    public BaseActivity D;
    protected boolean E;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {
        static IPatchRedirector $redirector_;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66745);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            F = false;
            G = false;
        }
    }

    public ChatFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.E = false;
            com.tencent.mobileqq.activity.aio.w.a("ChatFragment.onCreate");
        }
    }

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    public QQAppInterface ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.D.app;
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public a61.c qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a61.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.C;
    }
}
