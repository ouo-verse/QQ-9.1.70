package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatsTitleGetter;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsTitleGetterImpl;", "Lcom/tencent/qqnt/chats/api/IChatsTitleGetter;", "()V", "getTroopTitles", "", "troopUin", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ChatsTitleGetterImpl implements IChatsTitleGetter {
    static IPatchRedirector $redirector_;

    public ChatsTitleGetterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsTitleGetter
    @Nullable
    public String getTroopTitles(@NotNull String troopUin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null) {
            String troopDisplayName = troopInfoFromCache.getTroopDisplayName();
            if (troopDisplayName != null && troopDisplayName.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return troopInfoFromCache.getTroopDisplayName();
            }
            return null;
        }
        return null;
    }
}
