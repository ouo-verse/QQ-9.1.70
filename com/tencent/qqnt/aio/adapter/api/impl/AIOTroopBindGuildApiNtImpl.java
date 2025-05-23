package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTroopBindGuildApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTroopBindGuildApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTroopBindGuildApi;", "()V", "isTroopBindGuild", "", "troopUin", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOTroopBindGuildApiNtImpl implements IAIOTroopBindGuildApi {
    static IPatchRedirector $redirector_;

    public AIOTroopBindGuildApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTroopBindGuildApi
    public boolean isTroopBindGuild(@NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        return false;
    }
}
