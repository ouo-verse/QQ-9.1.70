package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.v;
import com.tencent.mobileqq.troop.data.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/data/v;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/j;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class s {
    @NotNull
    public static final j a(@NotNull v vVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        TroopInfo i3 = vVar.i();
        String troopUin = i3.getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        String str = troopUin;
        int i16 = i3.nTroopGrade;
        if (i3.shouldShowTroopLevel() && !i3.isQidianPrivateTroop()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new j(str, i16, z16, i3.wMemberNum, w.a(vVar));
    }
}
