package com.tencent.could.huiyansdk.utils;

import com.tencent.could.huiyansdk.api.HuiYanOperationConfigCallBack;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class j implements com.tencent.could.huiyansdk.callback.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HuiYanOperationConfigCallBack f100306a;

    public j(HuiYanOperationConfigCallBack huiYanOperationConfigCallBack) {
        this.f100306a = huiYanOperationConfigCallBack;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) huiYanOperationConfigCallBack);
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error: " + str);
        CommonUtils.sendErrorAndExitAuth(286, str);
        this.f100306a.onFail(str);
    }
}
