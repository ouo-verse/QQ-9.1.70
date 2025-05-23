package com.tencent.mobileqq.guild.channel.create.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo;
import com.tencent.mobileqq.qqguildsdk.data.d;
import com.tencent.mobileqq.qqguildsdk.data.df;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010W\u001a\u00020\u0002\u00a2\u0006\u0004\bY\u0010ZJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060(H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J \u00101\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010.j\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u0001`0H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u000207H\u0016J \u0010:\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u00010.j\f\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u0001`0H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010>\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010.j\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u0001`0H\u0016J\b\u0010?\u001a\u00020\u0006H\u0016J\b\u0010@\u001a\u000207H\u0016J\n\u0010B\u001a\u0004\u0018\u00010AH\u0016J\n\u0010D\u001a\u0004\u0018\u00010CH\u0016J\n\u0010F\u001a\u0004\u0018\u00010EH\u0016J\b\u0010G\u001a\u00020\u0006H\u0016J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\n\u0010J\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010K\u001a\u00020\u0006H\u0016J\n\u0010M\u001a\u0004\u0018\u00010LH\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010P\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010Q\u001a\u000207H\u0016J\b\u0010R\u001a\u00020\u0002H\u0016J\b\u0010S\u001a\u00020\u0006H\u0016R\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010W\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/channel/create/data/IGProChannelInfoForApplicationChannelLink;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "", "getChannelUin", "getChannelName", "getGuildId", "", "getType", "", "getApplicationId", "getAppChannelJumpType", "getAppChannelJumpUrl", "getTalkPermission", "getMsgNotify", "getFinalMsgNotify", "notifyType", "", "setFinalMsgNotify", "getCreateTime", "getCreatorId", "getLastMsgTime", "getLastCntMsgTime", "getReadMsgTime", "getReadCntMsgTime", "getLastMsgSeq", "getLastCntMsgSeq", "getReadMsgSeq", "getReadCntMsgSeq", "", "getMsgMeta", "getReadMsgMeta", "getChannelMemberMax", "getCategoryName", "getCategoryId", "getCategoryType", "getBannedSpeak", "getLiveRoomId", "getLiveAnchorTinyId", "getLiveRoomName", "getVisibleType", "", "getSpecialType", "getTopMsgSeq", "getTopMsgTime", "getTopMsgOperatorTinyId", "getSlowModeKey", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/ISlowModeInfo;", "Lkotlin/collections/ArrayList;", "getGProSlowModeInfoList", "getTextChannelSubtypeId", "getForumSortMode", "getMyTalkPermissionType", "getIsChannelAdmin", "getIsCategoryAdmin", "", "isChannelOrCategoryAdmin", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "getTopMsgList", "getChannelLiveableType", "getAppChannelIconUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/df;", "getAuthControlStatusList", "getAllowOtherRaiseHand", "isAllowOtherRaiseHand", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceSpeakModeCfg;", "getVoiceSpeakModeCfg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceQueueCfg;", "getVoiceQueueCfg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProInviteSpeakCfg;", "getInviteSpeakCfg", "getNoMemberMaxLimited", "getGotoChannelId", "getJumpSwitch", "getHotIcon", "getHotIndex", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "getMedalInfo", "getOperationType", "getIconUrl", "getOperationTitle", "isHiddenPostChannel", "getContentUrl", "getContentUrlType", "Lcom/tencent/mobileqq/qqguildsdk/data/d;", "info", "Lcom/tencent/mobileqq/qqguildsdk/data/d;", "guildId", "Ljava/lang/String;", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/d;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class IGProChannelInfoForApplicationChannelLink implements IGProChannelInfo {

    @NotNull
    private final String guildId;

    @NotNull
    private final d info;

    public IGProChannelInfoForApplicationChannelLink(@NotNull d info, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.info = info;
        this.guildId = guildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getAllowOtherRaiseHand() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getAppChannelIconUrl() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getAppChannelJumpType() {
        return 2;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getAppChannelJumpUrl() {
        return this.info.t();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getApplicationId() {
        return this.info.a();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public ArrayList<df> getAuthControlStatusList() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getBannedSpeak() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCategoryId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getCategoryName() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getCategoryType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelLiveableType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getChannelMemberMax() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getChannelName() {
        return this.info.m();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getChannelUin() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @NotNull
    public String getContentUrl() {
        return "";
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getContentUrlType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getCreateTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getCreatorId() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getFinalMsgNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getForumSortMode() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public ArrayList<ISlowModeInfo> getGProSlowModeInfoList() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getGotoChannelId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getHotIcon() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getHotIndex() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getIconUrl() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public IGProInviteSpeakCfg getInviteSpeakCfg() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsCategoryAdmin() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getIsChannelAdmin() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getJumpSwitch() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastCntMsgTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLastMsgTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveAnchorTinyId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getLiveRoomId() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getLiveRoomName() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public IGProMedalInfo getMedalInfo() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public byte[] getMsgMeta() {
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMsgNotify() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getMyTalkPermissionType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getNoMemberMaxLimited() {
        return 1;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getOperationTitle() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getOperationType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadCntMsgTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public byte[] getReadMsgMeta() {
        return new byte[0];
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getReadMsgTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getSlowModeKey() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @NotNull
    public List<Integer> getSpecialType() {
        List<Integer> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTalkPermission() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getTextChannelSubtypeId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public ArrayList<IGProTopMsg> getTopMsgList() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public String getTopMsgOperatorTinyId() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgSeq() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public long getTopMsgTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getType() {
        return this.info.p();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public int getVisibleType() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public IGProVoiceQueueCfg getVoiceQueueCfg() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    @Nullable
    public IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg() {
        return null;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isAllowOtherRaiseHand() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isChannelOrCategoryAdmin() {
        if (getIsChannelAdmin() == 1 || getIsCategoryAdmin() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public boolean isHiddenPostChannel() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo
    public void setFinalMsgNotify(int notifyType) {
    }
}
