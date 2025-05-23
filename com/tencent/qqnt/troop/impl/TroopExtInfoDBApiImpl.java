package com.tencent.qqnt.troop.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J\u001b\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0001J#\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J+\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0096\u0001J#\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\u001b\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0001J#\u0010\u0019\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J#\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J\u001b\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u000fH\u0096\u0001J#\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J%\u0010!\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020$H\u0096\u0001J#\u0010%\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J!\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J#\u0010)\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J#\u0010+\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J)\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001J\u001b\u00100\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u00101\u001a\u00020\u000bH\u0096\u0001J\u001b\u00102\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u000204H\u0096\u0001J,\u00105\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00106\u001a\u0004\u0018\u00010$2\b\u00107\u001a\u0004\u0018\u00010$H\u0096\u0001\u00a2\u0006\u0002\u00108J#\u00109\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u000bH\u0096\u0001J!\u0010<\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060>H\u0096\u0001J#\u0010?\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010@\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopExtInfoDBApiImpl;", "Lcom/tencent/qqnt/troop/ITroopExtInfoDBApi;", "()V", "updateAnnouncement", "", "troopUin", "", "announcement", "updateAtOrReplyMeUins", "updateAvatarId", "picId", "", "from", "updateBatchAddFriendData", "lastInsertBAFTipTime", "", "insertBAFTipCount", "lastBAFTipMsgUniSeq", "updateDailyNewMemberUins", "dailyNewMemberUins", "updateGameSwitchStatus", "showGameSwitchStatus", "gameSwitchStatus", "updateGuildSwitchOpen", "guildSwitchOpen", "updateHeaderUinNew", "headerUinNew", "updateHeaderUinOld", "headerUinOld", "updateHonorUpdateTime", "honorUpdateTime", "updateMemberNumClient", "memberNumClient", "updateMyTroopHonor", "honorList", "honorRichFlag", "", "updateNewTroopNameTimeStamp", "newTroopNameTimeStamp", "updateOldMemberNickIconSeq", "oldMemberNickIconSeq", "updatePicListJson", "picListJson", "updateSpecialClass", "specialClass", "updateTroopFileVideo", "fileVideoIsWhite", "fileVideoReqInterval", "updateTroopHonorGrayFlag", "grayFlag", "updateTroopLevelInfo", "groupMemberExtList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "updateTroopLevelSwitch", "rankUserFlag", "newRankUserFlag", "(Ljava/lang/String;Ljava/lang/Byte;Ljava/lang/Byte;)V", "updateTroopNotificationData", "feedsId", "repeatType", "updateTroopSettingMemberList", "memberList", "", "updateTroopType", "type", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class TroopExtInfoDBApiImpl implements ITroopExtInfoDBApi {
    static IPatchRedirector $redirector_;
    private final /* synthetic */ TroopExtDBInfoRepo $$delegate_0;

    public TroopExtInfoDBApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.$$delegate_0 = TroopExtDBInfoRepo.INSTANCE;
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAnnouncement(@Nullable String troopUin, @NotNull String announcement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) announcement);
        } else {
            Intrinsics.checkNotNullParameter(announcement, "announcement");
            this.$$delegate_0.updateAnnouncement(troopUin, announcement);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAtOrReplyMeUins(@Nullable String troopUin, @NotNull String announcement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) announcement);
        } else {
            Intrinsics.checkNotNullParameter(announcement, "announcement");
            this.$$delegate_0.updateAtOrReplyMeUins(troopUin, announcement);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateAvatarId(@Nullable String troopUin, int picId, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, Integer.valueOf(picId), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateAvatarId(troopUin, picId, from);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateBatchAddFriendData(@Nullable String troopUin, long lastInsertBAFTipTime, int insertBAFTipCount, long lastBAFTipMsgUniSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, Long.valueOf(lastInsertBAFTipTime), Integer.valueOf(insertBAFTipCount), Long.valueOf(lastBAFTipMsgUniSeq));
        } else {
            this.$$delegate_0.updateBatchAddFriendData(troopUin, lastInsertBAFTipTime, insertBAFTipCount, lastBAFTipMsgUniSeq);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateDailyNewMemberUins(@Nullable String troopUin, @NotNull String dailyNewMemberUins) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin, (Object) dailyNewMemberUins);
        } else {
            Intrinsics.checkNotNullParameter(dailyNewMemberUins, "dailyNewMemberUins");
            this.$$delegate_0.updateDailyNewMemberUins(troopUin, dailyNewMemberUins);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateGameSwitchStatus(@Nullable String troopUin, int showGameSwitchStatus, int gameSwitchStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, Integer.valueOf(showGameSwitchStatus), Integer.valueOf(gameSwitchStatus));
        } else {
            this.$$delegate_0.updateGameSwitchStatus(troopUin, showGameSwitchStatus, gameSwitchStatus);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateGuildSwitchOpen(@Nullable String troopUin, int guildSwitchOpen) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) troopUin, guildSwitchOpen);
        } else {
            this.$$delegate_0.updateGuildSwitchOpen(troopUin, guildSwitchOpen);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHeaderUinNew(@Nullable String troopUin, @NotNull String headerUinNew, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, troopUin, headerUinNew, from);
            return;
        }
        Intrinsics.checkNotNullParameter(headerUinNew, "headerUinNew");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateHeaderUinNew(troopUin, headerUinNew, from);
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHeaderUinOld(@Nullable String troopUin, @NotNull String headerUinOld, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, headerUinOld, from);
            return;
        }
        Intrinsics.checkNotNullParameter(headerUinOld, "headerUinOld");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateHeaderUinOld(troopUin, headerUinOld, from);
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateHonorUpdateTime(@Nullable String troopUin, long honorUpdateTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, troopUin, Long.valueOf(honorUpdateTime));
        } else {
            this.$$delegate_0.updateHonorUpdateTime(troopUin, honorUpdateTime);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateMemberNumClient(@Nullable String troopUin, int memberNumClient, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, troopUin, Integer.valueOf(memberNumClient), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateMemberNumClient(troopUin, memberNumClient, from);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateMyTroopHonor(@Nullable String troopUin, @Nullable String honorList, byte honorRichFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, troopUin, honorList, Byte.valueOf(honorRichFlag));
        } else {
            this.$$delegate_0.updateMyTroopHonor(troopUin, honorList, honorRichFlag);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateNewTroopNameTimeStamp(@Nullable String troopUin, long newTroopNameTimeStamp, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, troopUin, Long.valueOf(newTroopNameTimeStamp), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateNewTroopNameTimeStamp(troopUin, newTroopNameTimeStamp, from);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateOldMemberNickIconSeq(@NotNull String troopUin, long oldMemberNickIconSeq, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, troopUin, Long.valueOf(oldMemberNickIconSeq), from);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updateOldMemberNickIconSeq(troopUin, oldMemberNickIconSeq, from);
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updatePicListJson(@Nullable String troopUin, @NotNull String picListJson, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, troopUin, picListJson, from);
            return;
        }
        Intrinsics.checkNotNullParameter(picListJson, "picListJson");
        Intrinsics.checkNotNullParameter(from, "from");
        this.$$delegate_0.updatePicListJson(troopUin, picListJson, from);
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateSpecialClass(@Nullable String troopUin, int specialClass, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, troopUin, Integer.valueOf(specialClass), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateSpecialClass(troopUin, specialClass, from);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopFileVideo(long troopUin, int fileVideoIsWhite, long fileVideoReqInterval, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Long.valueOf(troopUin), Integer.valueOf(fileVideoIsWhite), Long.valueOf(fileVideoReqInterval), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateTroopFileVideo(troopUin, fileVideoIsWhite, fileVideoReqInterval, from);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopHonorGrayFlag(@Nullable String troopUin, int grayFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) troopUin, grayFlag);
        } else {
            this.$$delegate_0.updateTroopHonorGrayFlag(troopUin, grayFlag);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopLevelInfo(@Nullable String troopUin, @NotNull GroupMemberExtListResult groupMemberExtList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) troopUin, (Object) groupMemberExtList);
        } else {
            Intrinsics.checkNotNullParameter(groupMemberExtList, "groupMemberExtList");
            this.$$delegate_0.updateTroopLevelInfo(troopUin, groupMemberExtList);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopLevelSwitch(@Nullable String troopUin, @Nullable Byte rankUserFlag, @Nullable Byte newRankUserFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, troopUin, rankUserFlag, newRankUserFlag);
        } else {
            this.$$delegate_0.updateTroopLevelSwitch(troopUin, rankUserFlag, newRankUserFlag);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopNotificationData(@Nullable String troopUin, @NotNull String feedsId, int repeatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, troopUin, feedsId, Integer.valueOf(repeatType));
        } else {
            Intrinsics.checkNotNullParameter(feedsId, "feedsId");
            this.$$delegate_0.updateTroopNotificationData(troopUin, feedsId, repeatType);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopSettingMemberList(@Nullable String troopUin, @NotNull List<String> memberList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) troopUin, (Object) memberList);
        } else {
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            this.$$delegate_0.updateTroopSettingMemberList(troopUin, memberList);
        }
    }

    @Override // com.tencent.qqnt.troop.ITroopExtInfoDBApi
    public void updateTroopType(@Nullable String troopUin, int type, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, troopUin, Integer.valueOf(type), from);
        } else {
            Intrinsics.checkNotNullParameter(from, "from");
            this.$$delegate_0.updateTroopType(troopUin, type, from);
        }
    }
}
