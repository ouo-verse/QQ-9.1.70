package com.tencent.mobileqq.gateway.localphone.ecdh.api.impl;

import com.tencent.mobileqq.gateway.localphone.ecdh.a;
import com.tencent.mobileqq.gateway.localphone.ecdh.api.IECDHServiceApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/gateway/localphone/ecdh/api/impl/ECDHServiceApiImpl;", "Lcom/tencent/mobileqq/gateway/localphone/ecdh/api/IECDHServiceApi;", "()V", "getECDHService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelECDHService;", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class ECDHServiceApiImpl implements IECDHServiceApi {
    static IPatchRedirector $redirector_;

    public ECDHServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.gateway.localphone.ecdh.api.IECDHServiceApi
    @Nullable
    public IKernelECDHService getECDHService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IKernelECDHService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.f213611a.a();
    }
}
