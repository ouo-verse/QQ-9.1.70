package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.data.troop.TroopInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/r;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class k {
    @NotNull
    public static final r a(@NotNull TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(troopInfo, "<this>");
        boolean z16 = !troopInfo.isQidianPrivateTroop();
        String troopUin = troopInfo.getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        return new r(z16, troopUin, troopInfo.isNewTroop, troopInfo.isOwnerOrAdmin(), troopInfo.isMember());
    }
}
