package com.tencent.could.huiyansdk.fragments;

import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.permission.c;
import com.tencent.could.huiyansdk.utils.CommonUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements com.tencent.could.huiyansdk.permission.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100070a;

    public a(AuthingFragment authingFragment) {
        this.f100070a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "OpenCheckPageError", "");
        k.a.f100197a.a(2, "AuthingFragment", "permission forbid!");
        c.a.f100268a.b();
        CommonUtils.sendErrorAndExitAuth(224, this.f100070a.c().getString(R.string.txy_permission_loss_check_error));
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        HuiYanSdkImp.getInstance().sendBuriedPointInfo("AuthCheckStage", "EnterAuthCheckPage", "");
        c.a.f100268a.b();
        this.f100070a.p();
    }
}
