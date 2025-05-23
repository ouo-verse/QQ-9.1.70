package com.tencent.mobileqq.login.api.qrlogin.impl;

import com.tencent.mobileqq.login.api.qrlogin.IQrLoginApi;
import com.tencent.mobileqq.loginregister.servlet.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrlogin.e;
import com.tencent.mobileqq.qrlogin.j;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/login/api/qrlogin/impl/QrLoginApiImpl;", "Lcom/tencent/mobileqq/login/api/qrlogin/IQrLoginApi;", "Lcom/tencent/mobileqq/loginregister/servlet/a;", "getQrLoginManager", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QrLoginApiImpl implements IQrLoginApi {
    static IPatchRedirector $redirector_;

    public QrLoginApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.login.api.qrlogin.IQrLoginApi
    @NotNull
    public a getQrLoginManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            return new j();
        }
        return new e();
    }
}
