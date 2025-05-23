package com.tencent.qqnt.troop.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.troop.ITroopArkApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopArkApiImpl;", "Lcom/tencent/qqnt/troop/ITroopArkApi;", "()V", "openTroopManageForScheme", "", "params", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopArkApiImpl implements ITroopArkApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopArkUtil $$delegate_0;

    public TroopArkApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopArkUtil.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopArkApi
    public void openTroopManageForScheme(@NotNull String params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(params, "params");
            this.$$delegate_0.openTroopManageForScheme(params);
        }
    }
}
