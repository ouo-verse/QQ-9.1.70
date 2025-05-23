package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOPttApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOPttApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOPttApi;", "()V", "stopAll", "", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOPttApiImpl implements IAIOPttApi {
    static IPatchRedirector $redirector_;

    public AIOPttApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOPttApi
    public void stopAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            AIOPttAudioPlayerManager.f191706d.D();
        }
    }
}
