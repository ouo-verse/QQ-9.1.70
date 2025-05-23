package com.tencent.aio.stranger.api.impl;

import com.tencent.aio.data.AIOContact;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAssistantAdapterApiNtImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAssistantAdapterApi;", "()V", "getMiniCardAppId", "", "isLittleAssistant", "", "contact", "Lcom/tencent/aio/data/AIOContact;", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StrangerAssistantAdapterApiNtImpl implements IStrangerAssistantAdapterApi {
    static IPatchRedirector $redirector_;

    public StrangerAssistantAdapterApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi
    @NotNull
    public String getMiniCardAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi
    public boolean isLittleAssistant(@NotNull AIOContact contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        return false;
    }
}
