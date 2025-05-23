package com.tencent.could.huiyansdk.utils;

import com.google.gson.Gson;
import com.tencent.could.component.common.ai.net.IJsonDataListener;
import com.tencent.could.huiyansdk.api.HuiYanAuthImp;
import com.tencent.could.huiyansdk.entity.CustomerConfig;
import com.tencent.could.huiyansdk.entity.HPCCompareResult;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class h implements IJsonDataListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomerConfig f100304a;

    public h(CustomerConfig customerConfig) {
        this.f100304a = customerConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) customerConfig);
        }
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onFailed(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        k.a.f100197a.a(2, "HuiYanSenderHelper", "get config error for network error: " + str);
        this.f100304a.setAuthTips("");
        this.f100304a.setAuthTipsTextColor(-1);
        HuiYanAuthImp.getInstance().doNoticeCustomConfigSuccess(this.f100304a);
        HuiYanAuthImp.getInstance().setShouldShowCustomerTxt(false);
    }

    @Override // com.tencent.could.component.common.ai.net.IJsonDataListener
    public void onSuccess(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (!e.a((HPCCompareResult) new Gson().fromJson(str, HPCCompareResult.class))) {
            this.f100304a.setAuthTips("");
            this.f100304a.setAuthTipsTextColor(-1);
        }
        HuiYanAuthImp.getInstance().doNoticeCustomConfigSuccess(this.f100304a);
        HuiYanAuthImp.getInstance().setShouldShowCustomerTxt(true);
    }
}
