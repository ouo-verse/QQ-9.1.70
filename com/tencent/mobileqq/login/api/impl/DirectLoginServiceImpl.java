package com.tencent.mobileqq.login.api.impl;

import com.tencent.mobileqq.login.api.IDirectLoginService;
import com.tencent.mobileqq.login.u;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/login/api/impl/DirectLoginServiceImpl;", "Lcom/tencent/mobileqq/login/api/IDirectLoginService;", "", "uin", "", "canDirectLogin", "", "loginEntrance", "isNestedLogin", "Le72/a;", "callback", "", "directLogin", "switchAccount", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class DirectLoginServiceImpl implements IDirectLoginService {
    static IPatchRedirector $redirector_;

    public DirectLoginServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.api.IDirectLoginService
    public boolean canDirectLogin(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin)).booleanValue();
        }
        return u.o(uin);
    }

    @Override // com.tencent.mobileqq.login.api.IDirectLoginService
    public void directLogin(@Nullable String uin, int loginEntrance, boolean isNestedLogin, @Nullable e72.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uin, Integer.valueOf(loginEntrance), Boolean.valueOf(isNestedLogin), callback);
        } else {
            u.p(uin, loginEntrance, isNestedLogin, callback);
        }
    }

    @Override // com.tencent.mobileqq.login.api.IDirectLoginService
    public void switchAccount(@Nullable String uin, @Nullable e72.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin, (Object) callback);
        } else {
            u.J(uin, callback);
        }
    }
}
