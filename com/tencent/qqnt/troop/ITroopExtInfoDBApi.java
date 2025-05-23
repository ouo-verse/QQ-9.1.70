package com.tencent.qqnt.troop;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000eH&J\u001a\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H&J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH&J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\nH&J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\"\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001a\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u000eH&J\"\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J$\u0010 \u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020#H&J\"\u0010$\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H&J \u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H&J\"\u0010(\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J\"\u0010*\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&J(\u0010,\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0005H&J\u001a\u0010/\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00100\u001a\u00020\nH&J\u001a\u00101\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H&J+\u00104\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u00010#2\b\u00106\u001a\u0004\u0018\u00010#H&\u00a2\u0006\u0002\u00107J\"\u00108\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\nH&J \u0010;\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050=H&J\"\u0010>\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010?\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006@"}, d2 = {"Lcom/tencent/qqnt/troop/ITroopExtInfoDBApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "updateAnnouncement", "", "troopUin", "", "announcement", "updateAtOrReplyMeUins", "updateAvatarId", "picId", "", "from", "updateBatchAddFriendData", "lastInsertBAFTipTime", "", "insertBAFTipCount", "lastBAFTipMsgUniSeq", "updateDailyNewMemberUins", "dailyNewMemberUins", "updateGameSwitchStatus", "showGameSwitchStatus", "gameSwitchStatus", "updateGuildSwitchOpen", "guildSwitchOpen", "updateHeaderUinNew", "headerUinNew", "updateHeaderUinOld", "headerUinOld", "updateHonorUpdateTime", "honorUpdateTime", "updateMemberNumClient", "memberNumClient", "updateMyTroopHonor", "honorList", "honorRichFlag", "", "updateNewTroopNameTimeStamp", "newTroopNameTimeStamp", "updateOldMemberNickIconSeq", "oldMemberNickIconSeq", "updatePicListJson", "picListJson", "updateSpecialClass", "specialClass", "updateTroopFileVideo", "fileVideoIsWhite", "fileVideoReqInterval", "updateTroopHonorGrayFlag", "grayFlag", "updateTroopLevelInfo", "groupMemberExtList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "updateTroopLevelSwitch", "rankUserFlag", "newRankUserFlag", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;)V", "updateTroopNotificationData", "feedsId", "repeatType", "updateTroopSettingMemberList", "memberList", "", "updateTroopType", "type", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopExtInfoDBApi extends QRouteApi {
    void updateAnnouncement(@Nullable String troopUin, @NotNull String announcement);

    void updateAtOrReplyMeUins(@Nullable String troopUin, @NotNull String announcement);

    void updateAvatarId(@Nullable String troopUin, int picId, @NotNull String from);

    void updateBatchAddFriendData(@Nullable String troopUin, long lastInsertBAFTipTime, int insertBAFTipCount, long lastBAFTipMsgUniSeq);

    void updateDailyNewMemberUins(@Nullable String troopUin, @NotNull String dailyNewMemberUins);

    void updateGameSwitchStatus(@Nullable String troopUin, int showGameSwitchStatus, int gameSwitchStatus);

    void updateGuildSwitchOpen(@Nullable String troopUin, int guildSwitchOpen);

    void updateHeaderUinNew(@Nullable String troopUin, @NotNull String headerUinNew, @NotNull String from);

    void updateHeaderUinOld(@Nullable String troopUin, @NotNull String headerUinOld, @NotNull String from);

    void updateHonorUpdateTime(@Nullable String troopUin, long honorUpdateTime);

    void updateMemberNumClient(@Nullable String troopUin, int memberNumClient, @NotNull String from);

    void updateMyTroopHonor(@Nullable String troopUin, @Nullable String honorList, byte honorRichFlag);

    void updateNewTroopNameTimeStamp(@Nullable String troopUin, long newTroopNameTimeStamp, @NotNull String from);

    void updateOldMemberNickIconSeq(@NotNull String troopUin, long oldMemberNickIconSeq, @NotNull String from);

    void updatePicListJson(@Nullable String troopUin, @NotNull String picListJson, @NotNull String from);

    void updateSpecialClass(@Nullable String troopUin, int specialClass, @NotNull String from);

    void updateTroopFileVideo(long troopUin, int fileVideoIsWhite, long fileVideoReqInterval, @NotNull String from);

    void updateTroopHonorGrayFlag(@Nullable String troopUin, int grayFlag);

    void updateTroopLevelInfo(@Nullable String troopUin, @NotNull GroupMemberExtListResult groupMemberExtList);

    void updateTroopLevelSwitch(@Nullable String troopUin, @Nullable Byte rankUserFlag, @Nullable Byte newRankUserFlag);

    void updateTroopNotificationData(@Nullable String troopUin, @NotNull String feedsId, int repeatType);

    void updateTroopSettingMemberList(@Nullable String troopUin, @NotNull List<String> memberList);

    void updateTroopType(@Nullable String troopUin, int type, @NotNull String from);
}
