package com.tencent.mobileqq.troop.troopfullmember.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopfullmember.api.ITroopFullMemberChangeApi;
import com.tencent.mobileqq.troop.troopfullmember.schema.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/api/impl/TroopFullMemberChangeApiImpl;", "Lcom/tencent/mobileqq/troop/troopfullmember/api/ITroopFullMemberChangeApi;", "()V", "getParserClass", "Ljava/lang/Class;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopFullMemberChangeApiImpl implements ITroopFullMemberChangeApi {
    static IPatchRedirector $redirector_;

    public TroopFullMemberChangeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopfullmember.api.ITroopFullMemberChangeApi
    @NotNull
    public Class<?> getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
    }
}
