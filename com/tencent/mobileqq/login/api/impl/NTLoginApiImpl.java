package com.tencent.mobileqq.login.api.impl;

import com.tencent.mobileqq.login.api.INTLoginApi;
import com.tencent.mobileqq.login.ntlogin.ag;
import com.tencent.mobileqq.login.ntlogin.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016JR\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t28\u0010\n\u001a4\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\tH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/NTLoginApiImpl;", "Lcom/tencent/mobileqq/login/api/INTLoginApi;", "()V", "checkPasswordStatus", "", "refreshAccountTicket", "account", "", "isHost", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "errMsg", "refreshCurrentAccountTicket", "forceRefresh", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NTLoginApiImpl implements INTLoginApi {
    static IPatchRedirector $redirector_;

    public NTLoginApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.api.INTLoginApi
    public void checkPasswordStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ag.f242225a.r();
        }
    }

    @Override // com.tencent.mobileqq.login.api.INTLoginApi
    public void refreshAccountTicket(long account, boolean isHost, @Nullable Function2<? super Boolean, ? super String, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(account), Boolean.valueOf(isHost), callback);
        } else {
            y.f242393a.i(account, isHost, false, callback);
        }
    }

    @Override // com.tencent.mobileqq.login.api.INTLoginApi
    public void refreshCurrentAccountTicket(boolean forceRefresh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, forceRefresh);
        } else {
            y.f242393a.h(forceRefresh);
        }
    }
}
