package com.tencent.mobileqq.popanim.api.impl;

import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.popanim.NTAioPopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.api.INTPopOutAnimConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/popanim/api/impl/NTPopOutAnimConfigImpl;", "Lcom/tencent/mobileqq/popanim/api/INTPopOutAnimConfig;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/popanim/PopOutAnimConfig;", "getNTPopOutAnimConfig", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NTPopOutAnimConfigImpl implements INTPopOutAnimConfig {
    static IPatchRedirector $redirector_;

    public NTPopOutAnimConfigImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.popanim.api.INTPopOutAnimConfig
    @NotNull
    public PopOutAnimConfig getNTPopOutAnimConfig(@NotNull a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PopOutAnimConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        return new NTAioPopOutAnimConfig(aioContext);
    }
}
