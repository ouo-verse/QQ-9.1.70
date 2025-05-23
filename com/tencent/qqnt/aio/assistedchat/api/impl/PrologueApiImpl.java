package com.tencent.qqnt.aio.assistedchat.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.assistedchat.api.IPrologueApi;
import com.tencent.qqnt.aio.assistedchat.progolue.PrologueAIOHelper;
import com.tencent.qqnt.aio.assistedchat.progolue.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/api/impl/PrologueApiImpl;", "Lcom/tencent/qqnt/aio/assistedchat/api/IPrologueApi;", "()V", "getC2CNeedRequestPrologue", "", "peerUin", "", "getPrologueHelper", "Lcom/tencent/qqnt/aio/assistedchat/progolue/PrologueAIOHelper;", "setC2CNeedRequestPrologue", "", "value", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class PrologueApiImpl implements IPrologueApi {
    static IPatchRedirector $redirector_;

    public PrologueApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IPrologueApi
    public boolean getC2CNeedRequestPrologue(@NotNull String peerUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) peerUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        return c.f349416a.a(peerUin);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IPrologueApi
    public void setC2CNeedRequestPrologue(@NotNull String peerUin, boolean value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, peerUin, Boolean.valueOf(value));
        } else {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            c.f349416a.d(peerUin, value);
        }
    }

    @Override // com.tencent.qqnt.aio.assistedchat.api.IPrologueApi
    @NotNull
    public PrologueAIOHelper getPrologueHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new PrologueAIOHelper() : (PrologueAIOHelper) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
