package com.tencent.mobileqq.hermes.impl;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.hermes.ISuperQQTaskApi;
import com.tencent.mobileqq.hermes.part.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/hermes/impl/SuperQQTaskApiImpl;", "Lcom/tencent/mobileqq/hermes/ISuperQQTaskApi;", "()V", "getEasterEggPart", "Lcom/tencent/biz/richframework/part/Part;", "hermes-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class SuperQQTaskApiImpl implements ISuperQQTaskApi {
    static IPatchRedirector $redirector_;

    public SuperQQTaskApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.hermes.ISuperQQTaskApi
    @NotNull
    public Part getEasterEggPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Part) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new d();
    }
}
