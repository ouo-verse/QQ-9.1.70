package com.tencent.mobileqq.troop.troopownertask.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopownertask.api.ITroopOwnerTaskApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/troopownertask/api/impl/TroopOwnerTaskApiImpl;", "Lcom/tencent/mobileqq/troop/troopownertask/api/ITroopOwnerTaskApi;", "Lcom/tencent/aio/main/businesshelper/h;", "createHelper", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopOwnerTaskApiImpl implements ITroopOwnerTaskApi {
    static IPatchRedirector $redirector_;

    public TroopOwnerTaskApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopownertask.api.ITroopOwnerTaskApi
    @NotNull
    public h createHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new TroopOwnerTaskHelper();
    }
}
