package com.tencent.mobileqq.troop.memberlevel.api;

import android.content.Context;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopMemberLevelUtilsApi extends QRouteApi {
    int convertOldLevelToNewLevel(int i3);

    String getNewGroupMemberLevelJumpUrl();

    JSONObject getRankBgColorConfigJson(int i3);

    int[] getRankGradientColorByRankId(int i3);

    int getRankTextColor(int i3);

    int getRankTextColorByRankId(int i3);

    com.tencent.mobileqq.troop.troopmemberlevel.a getTroopMemberRankItem(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo);

    com.tencent.mobileqq.troop.troopmemberlevel.a getTroopMemberRankItem(TroopInfo troopInfo, String str, int i3, int i16, String str2, byte b16);

    com.tencent.mobileqq.troop.troopmemberlevel.a getTroopMemberRankItem_Unique(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo);

    boolean hasNewGroupMemberLevelJumpUrl();

    boolean isNewRealLevelGrayTroop(String str);

    void jumpToVasTroopHonorUrl(Context context, String str);
}
