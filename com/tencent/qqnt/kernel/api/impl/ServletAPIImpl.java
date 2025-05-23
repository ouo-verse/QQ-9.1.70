package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.IServletAPI;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import mqq.app.MSFServlet;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/ServletAPIImpl;", "Lcom/tencent/qqnt/kernel/api/IServletAPI;", "()V", "getNTCmd", "", "", "getPushMsgServlet", "Ljava/lang/Class;", "Lmqq/app/MSFServlet;", "setServletKernelInit", "", "kernel_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ServletAPIImpl implements IServletAPI {
    static IPatchRedirector $redirector_;

    public ServletAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IServletAPI
    @NotNull
    public Set<String> getNTCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new HashSet(com.tencent.qqnt.kernel.msf.b.INSTANCE.b());
    }

    @Override // com.tencent.qqnt.kernel.api.IServletAPI
    @NotNull
    public Class<? extends MSFServlet> getPushMsgServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.qqnt.kernel.msf.b.class;
    }

    @Override // com.tencent.qqnt.kernel.api.IServletAPI
    public void setServletKernelInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.qqnt.kernel.msf.b.INSTANCE.c();
        }
    }
}
