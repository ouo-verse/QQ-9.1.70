package com.tencent.qqnt.troopmemberlist.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberDBExtInfoRepo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J-\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J-\u0010\u000f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J/\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J)\u0010\u0018\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/impl/TroopMemberExtDBApiImpl;", "Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtDBApi;", "()V", "updateCommonFriendCount", "", "troopUin", "", "commonFriendCountMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "from", "updateHwIdentity", "memberUin", "identity", "updateLastMsgUpdateHonorRichTime", "lastMsgUpdateHonorRichTime", "", "updateTroopMemberFlagEx3", "uinToFlagEx3", "", "updateTroopMemberNickIconInfo", "uinToInfoBuffer", "", "updateTroopMemberShowNamePinyin", "troopMemberList", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopMemberExtDBApiImpl implements ITroopMemberExtDBApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopMemberDBExtInfoRepo $$delegate_0;

    public TroopMemberExtDBApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopMemberDBExtInfoRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateCommonFriendCount(@Nullable String troopUin, @NotNull HashMap<String, Integer> commonFriendCountMap, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, commonFriendCountMap, from);
            return;
        }
        Intrinsics.checkNotNullParameter(commonFriendCountMap, "commonFriendCountMap");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateCommonFriendCount(troopUin, commonFriendCountMap, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateHwIdentity(@Nullable String troopUin, @Nullable String memberUin, int identity, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, memberUin, Integer.valueOf(identity), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateHwIdentity(troopUin, memberUin, identity, from);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateLastMsgUpdateHonorRichTime(@Nullable String troopUin, @Nullable String memberUin, long lastMsgUpdateHonorRichTime, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, memberUin, Long.valueOf(lastMsgUpdateHonorRichTime), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateLastMsgUpdateHonorRichTime(troopUin, memberUin, lastMsgUpdateHonorRichTime, from);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberFlagEx3(@NotNull String troopUin, @NotNull Map<String, Long> uinToFlagEx3, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, uinToFlagEx3, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinToFlagEx3, "uinToFlagEx3");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateTroopMemberFlagEx3(troopUin, uinToFlagEx3, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberNickIconInfo(@NotNull String troopUin, @NotNull Map<String, byte[]> uinToInfoBuffer, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, troopUin, uinToInfoBuffer, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uinToInfoBuffer, "uinToInfoBuffer");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateTroopMemberNickIconInfo(troopUin, uinToInfoBuffer, from);
    }

    @Override // com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi
    public void updateTroopMemberShowNamePinyin(@Nullable String troopUin, @NotNull List<? extends TroopMemberInfo> troopMemberList, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, troopMemberList, from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateTroopMemberShowNamePinyin(troopUin, troopMemberList, from);
    }
}
