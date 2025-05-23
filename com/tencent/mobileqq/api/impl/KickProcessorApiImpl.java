package com.tencent.mobileqq.api.impl;

import com.tencent.mobileqq.api.IKickProcessorApi;
import com.tencent.mobileqq.kick.NTKickProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.api.IKickApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/api/impl/KickProcessorApiImpl;", "Lcom/tencent/mobileqq/api/IKickProcessorApi;", "Lcom/tencent/qqnt/kernel/api/IKickApi$b;", "getNTKickProcessor", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class KickProcessorApiImpl implements IKickProcessorApi {
    static IPatchRedirector $redirector_;

    public KickProcessorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.api.IKickProcessorApi
    @NotNull
    public IKickApi.b getNTKickProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IKickApi.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new NTKickProcessor();
    }
}
