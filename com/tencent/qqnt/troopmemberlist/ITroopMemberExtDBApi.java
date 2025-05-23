package com.tencent.qqnt.troopmemberlist;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u0005H&J,\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H&J,\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0005H&J,\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u00132\u0006\u0010\n\u001a\u00020\u0005H&J.\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00132\u0006\u0010\n\u001a\u00020\u0005H&J(\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/ITroopMemberExtDBApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "updateCommonFriendCount", "", "troopUin", "", "commonFriendCountMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "from", "updateHwIdentity", "memberUin", "identity", "updateLastMsgUpdateHonorRichTime", "lastMsgUpdateHonorRichTime", "", "updateTroopMemberFlagEx3", "uinToFlagEx3", "", "updateTroopMemberNickIconInfo", "uinToInfoBuffer", "", "updateTroopMemberShowNamePinyin", "troopMemberList", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopMemberExtDBApi extends QRouteApi {
    void updateCommonFriendCount(@Nullable String troopUin, @NotNull HashMap<String, Integer> commonFriendCountMap, @NotNull String from);

    void updateHwIdentity(@Nullable String troopUin, @Nullable String memberUin, int identity, @NotNull String from);

    void updateLastMsgUpdateHonorRichTime(@Nullable String troopUin, @Nullable String memberUin, long lastMsgUpdateHonorRichTime, @NotNull String from);

    void updateTroopMemberFlagEx3(@NotNull String troopUin, @NotNull Map<String, Long> uinToFlagEx3, @NotNull String from);

    void updateTroopMemberNickIconInfo(@NotNull String troopUin, @NotNull Map<String, byte[]> uinToInfoBuffer, @NotNull String from);

    void updateTroopMemberShowNamePinyin(@Nullable String troopUin, @NotNull List<? extends TroopMemberInfo> troopMemberList, @NotNull String from);
}
