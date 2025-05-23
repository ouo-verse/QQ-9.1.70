package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.chatfactory.publicaccount.PublicAccountAIOFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOExtProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOExtProviderImpl;", "Lcom/tencent/qqnt/aio/api/IAIOExtProvider;", "", "chatType", "Ljava/lang/Class;", "Lcom/tencent/aio/api/factory/g;", "getExtAIOFactoryClz", "getTroopHistoryMsgAIOFactoryClz", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOExtProviderImpl implements IAIOExtProvider {
    static IPatchRedirector $redirector_;

    public AIOExtProviderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOExtProvider
    @Nullable
    public Class<? extends com.tencent.aio.api.factory.g> getExtAIOFactoryClz(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        }
        if (chatType == 103) {
            return PublicAccountAIOFactory.class;
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOExtProvider
    @NotNull
    public Class<? extends com.tencent.aio.api.factory.g> getTroopHistoryMsgAIOFactoryClz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.qqnt.aio.troophistory.a.class;
    }
}
