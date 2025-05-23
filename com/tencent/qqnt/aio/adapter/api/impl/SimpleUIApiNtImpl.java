package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.ISimpleUIApi;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/SimpleUIApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ISimpleUIApi;", "()V", "shouldHideShortcutBar", "", "chatType", "", "shouldSwitchInputBar", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class SimpleUIApiNtImpl implements ISimpleUIApi {
    static IPatchRedirector $redirector_;

    public SimpleUIApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ISimpleUIApi
    public boolean shouldHideShortcutBar(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, chatType)).booleanValue();
        }
        if (chatType == 2 || chatType == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ISimpleUIApi
    public boolean shouldSwitchInputBar(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, chatType)).booleanValue();
        }
        if (chatType == 2 || chatType == 1) {
            return true;
        }
        return false;
    }
}
