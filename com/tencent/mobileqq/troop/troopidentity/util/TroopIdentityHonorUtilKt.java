package com.tencent.mobileqq.troop.troopidentity.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u0000*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u001a\f\u0010\u0007\u001a\u00020\u0003*\u0004\u0018\u00010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "", "newRankId", "", "newRankTitle", "a", "", "b", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityHonorUtilKt {
    @NotNull
    public static final com.tencent.mobileqq.troop.troopmemberlevel.a a(@Nullable com.tencent.mobileqq.troop.troopmemberlevel.a aVar, int i3, @Nullable String str) {
        com.tencent.mobileqq.troop.troopmemberlevel.a aVar2 = new com.tencent.mobileqq.troop.troopmemberlevel.a();
        aVar2.f300590a = i3;
        aVar2.f300592c = str;
        int[] rankGradientColorByRankId = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(i3);
        int rankTextColor = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(i3);
        if (rankGradientColorByRankId == null) {
            rankGradientColorByRankId = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(315);
            rankTextColor = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(315);
        }
        aVar2.f300593d = rankGradientColorByRankId;
        aVar2.f300597h = rankTextColor;
        if (aVar == null) {
            aVar2.f300596g = true;
            return aVar2;
        }
        aVar2.f300591b = aVar.f300591b;
        aVar2.f300594e = aVar.f300594e;
        aVar2.f300595f = aVar.f300595f;
        aVar2.f300596g = aVar.f300596g;
        aVar2.f300598i = aVar.f300598i;
        aVar2.f300599j = aVar.f300599j;
        return aVar2;
    }

    @NotNull
    public static final String b(@Nullable Object obj) {
        if (obj == null) {
            return "null";
        }
        return TroopIdentityHonorUtil.f300410a.b().replace(obj.toString(), TroopIdentityHonorUtilKt$fuzzyLog$1.INSTANCE);
    }
}
